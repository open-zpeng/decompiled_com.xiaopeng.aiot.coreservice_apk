package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/* compiled from: CommsSender.java */
/* renamed from: uw  reason: default package */
/* loaded from: classes.dex */
public class uw implements Runnable {
    public static final String a;
    public static final qy b;
    public rw g;
    public yx h;
    public qw i;
    public vw j;
    public String l;
    public Future n;
    public boolean d = false;
    public Object f = new Object();
    public Thread k = null;
    public final Semaphore m = new Semaphore(1);

    static {
        String name = uw.class.getName();
        a = name;
        b = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public uw(qw clientComms, rw clientState, vw tokenStore, OutputStream out) {
        this.g = null;
        this.i = null;
        this.j = null;
        this.h = new yx(clientState, out);
        this.i = clientComms;
        this.g = clientState;
        this.j = tokenStore;
        b.setResourceName(clientComms.t().b());
    }

    public void b(String threadName, ExecutorService executorService) {
        this.l = threadName;
        synchronized (this.f) {
            if (!this.d) {
                this.d = true;
                this.n = executorService.submit(this);
            }
        }
    }

    public void c() {
        Semaphore semaphore;
        synchronized (this.f) {
            Future future = this.n;
            if (future != null) {
                future.cancel(true);
            }
            b.fine(a, "stop", "800");
            if (this.d) {
                this.d = false;
                if (!Thread.currentThread().equals(this.k)) {
                    while (this.d) {
                        try {
                            this.g.u();
                            this.m.tryAcquire(100L, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException e) {
                            semaphore = this.m;
                        } catch (Throwable th) {
                            this.m.release();
                            throw th;
                        }
                    }
                    semaphore = this.m;
                    semaphore.release();
                }
            }
            this.k = null;
            b.fine(a, "stop", "801");
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        this.k = currentThread;
        currentThread.setName(this.l);
        my message = null;
        try {
            this.m.acquire();
            while (this.d && this.h != null) {
                try {
                    try {
                        message = this.g.i();
                        if (message != null) {
                            b.fine(a, "run", "802", new Object[]{message.o(), message});
                            if (message instanceof tx) {
                                this.h.a(message);
                                this.h.flush();
                            } else {
                                ow token = this.j.f(message);
                                if (token != null) {
                                    synchronized (token) {
                                        this.h.a(message);
                                        try {
                                            this.h.flush();
                                        } catch (IOException ex) {
                                            if (!(message instanceof wx)) {
                                                throw ex;
                                                break;
                                            }
                                        }
                                        this.g.z(message);
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            b.fine(a, "run", "803");
                            this.d = false;
                        }
                    } catch (iw me) {
                        a(message, me);
                    } catch (Exception ex2) {
                        a(message, ex2);
                    }
                } catch (Throwable th) {
                    this.d = false;
                    this.m.release();
                    throw th;
                }
            }
            this.d = false;
            this.m.release();
            b.fine(a, "run", "805");
        } catch (InterruptedException e) {
            this.d = false;
        }
    }

    public final void a(my message, Exception ex) {
        iw mex;
        b.fine(a, "handleRunException", "804", null, ex);
        if (!(ex instanceof iw)) {
            mex = new iw(32109, ex);
        } else {
            mex = (iw) ex;
        }
        this.d = false;
        this.i.O(null, mex);
    }
}
