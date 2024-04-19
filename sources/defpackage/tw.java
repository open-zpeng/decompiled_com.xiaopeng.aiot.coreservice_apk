package defpackage;

import com.xiaopeng.libconfig.ipc.AccountConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
/* compiled from: CommsReceiver.java */
/* renamed from: tw  reason: default package */
/* loaded from: classes.dex */
public class tw implements Runnable {
    public static final String a;
    public static final qy b;
    public rw g;
    public qw h;
    public xx i;
    public vw j;
    public volatile boolean l;
    public String n;
    public Future o;
    public boolean d = false;
    public Object f = new Object();
    public Thread k = null;
    public final Semaphore m = new Semaphore(1);

    static {
        String name = tw.class.getName();
        a = name;
        b = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public tw(qw clientComms, rw clientState, vw tokenStore, InputStream in) {
        this.g = null;
        this.h = null;
        this.j = null;
        this.i = new xx(clientState, in);
        this.h = clientComms;
        this.g = clientState;
        this.j = tokenStore;
        b.setResourceName(clientComms.t().b());
    }

    public void a(String threadName, ExecutorService executorService) {
        this.n = threadName;
        b.fine(a, AccountConfig.FaceIDRegisterAction.STATUS_START, "855");
        synchronized (this.f) {
            if (!this.d) {
                this.d = true;
                this.o = executorService.submit(this);
            }
        }
    }

    public void b() {
        Semaphore semaphore;
        synchronized (this.f) {
            Future future = this.o;
            if (future != null) {
                future.cancel(true);
            }
            b.fine(a, "stop", "850");
            if (this.d) {
                this.d = false;
                this.l = false;
                if (!Thread.currentThread().equals(this.k)) {
                    try {
                        this.m.acquire();
                        semaphore = this.m;
                    } catch (InterruptedException e) {
                        semaphore = this.m;
                    }
                    semaphore.release();
                }
            }
        }
        this.k = null;
        b.fine(a, "stop", "851");
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        this.k = currentThread;
        currentThread.setName(this.n);
        ow token = null;
        try {
            this.m.acquire();
            while (this.d && this.i != null) {
                try {
                    try {
                        qy qyVar = b;
                        String str = a;
                        qyVar.fine(str, "run", "852");
                        this.l = this.i.available() > 0;
                        my message = this.i.b();
                        this.l = false;
                        if (message instanceof tx) {
                            token = this.j.f(message);
                            if (token != null) {
                                synchronized (token) {
                                    this.g.v((tx) message);
                                }
                            } else {
                                if (!(message instanceof ey) && !(message instanceof dy) && !(message instanceof cy)) {
                                    throw new iw(6);
                                }
                                qyVar.fine(str, "run", "857");
                            }
                        } else if (message != null) {
                            this.g.x(message);
                        }
                    } catch (iw ex) {
                        b.fine(a, "run", "856", null, ex);
                        this.d = false;
                        this.h.O(token, ex);
                    } catch (IOException ioe) {
                        b.fine(a, "run", "853");
                        this.d = false;
                        if (!this.h.E()) {
                            this.h.O(token, new iw(32109, ioe));
                        }
                    }
                } finally {
                    this.l = false;
                    this.m.release();
                }
            }
            b.fine(a, "run", "854");
        } catch (InterruptedException e) {
            this.d = false;
        }
    }
}
