package defpackage;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
/* compiled from: CommsCallback.java */
/* renamed from: sw  reason: default package */
/* loaded from: classes.dex */
public class sw implements Runnable {
    public static final String a;
    public static final qy b;
    public dw d;
    public ew f;
    public qw h;
    public Thread n;
    public rw q;
    public String s;
    public Future u;
    public boolean k = false;
    public boolean l = false;
    public Object m = new Object();
    public Object o = new Object();
    public Object p = new Object();
    public boolean r = false;
    public final Semaphore t = new Semaphore(1);
    public Vector i = new Vector(10);
    public Vector j = new Vector(10);
    public Hashtable g = new Hashtable();

    static {
        String name = sw.class.getName();
        a = name;
        b = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public sw(qw clientComms) {
        this.h = clientComms;
        b.setResourceName(clientComms.t().b());
    }

    public void n(rw clientState) {
        this.q = clientState;
    }

    public void p(String threadName, ExecutorService executorService) {
        this.s = threadName;
        synchronized (this.m) {
            if (!this.k) {
                this.i.clear();
                this.j.clear();
                this.k = true;
                this.l = false;
                this.u = executorService.submit(this);
            }
        }
    }

    public void q() {
        Semaphore semaphore;
        synchronized (this.m) {
            Future future = this.u;
            if (future != null) {
                future.cancel(true);
            }
            if (this.k) {
                qy qyVar = b;
                String str = a;
                qyVar.fine(str, "stop", "700");
                this.k = false;
                if (!Thread.currentThread().equals(this.n)) {
                    try {
                        synchronized (this.o) {
                            qyVar.fine(str, "stop", "701");
                            this.o.notifyAll();
                        }
                        this.t.acquire();
                        semaphore = this.t;
                    } catch (InterruptedException e) {
                        semaphore = this.t;
                    }
                    semaphore.release();
                }
            }
            this.n = null;
            b.fine(a, "stop", "703");
        }
    }

    public void m(dw mqttCallback) {
        this.d = mqttCallback;
    }

    public void o(ew callback) {
        this.f = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        this.n = currentThread;
        currentThread.setName(this.s);
        try {
            this.t.acquire();
            while (this.k) {
                try {
                    try {
                        synchronized (this.o) {
                            if (this.k && this.i.isEmpty() && this.j.isEmpty()) {
                                b.fine(a, "run", "704");
                                this.o.wait();
                            }
                        }
                    } catch (InterruptedException e) {
                    }
                    if (this.k) {
                        ow token = null;
                        synchronized (this.j) {
                            if (!this.j.isEmpty()) {
                                token = (ow) this.j.elementAt(0);
                                this.j.removeElementAt(0);
                            }
                        }
                        if (token != null) {
                            f(token);
                        }
                        gy message = null;
                        synchronized (this.i) {
                            if (!this.i.isEmpty()) {
                                message = (gy) this.i.elementAt(0);
                                this.i.removeElementAt(0);
                            }
                        }
                        if (message != null) {
                            g(message);
                        }
                    }
                    if (this.l) {
                        this.q.b();
                    }
                    this.t.release();
                    synchronized (this.p) {
                        b.fine(a, "run", "706");
                        this.p.notifyAll();
                    }
                } catch (Throwable ex) {
                    try {
                        qy qyVar = b;
                        String str = a;
                        qyVar.fine(str, "run", "714", null, ex);
                        this.k = false;
                        this.h.O(null, new iw(ex));
                        this.t.release();
                        synchronized (this.p) {
                            qyVar.fine(str, "run", "706");
                            this.p.notifyAll();
                        }
                    } catch (Throwable th) {
                        this.t.release();
                        synchronized (this.p) {
                            b.fine(a, "run", "706");
                            this.p.notifyAll();
                            throw th;
                        }
                    }
                }
            }
        } catch (InterruptedException e2) {
            this.k = false;
        }
    }

    public final void f(ow token) throws iw {
        synchronized (token) {
            b.fine(a, "handleActionComplete", "705", new Object[]{token.a.e()});
            if (token.h()) {
                this.q.t(token);
            }
            token.a.p();
            if (!token.a.n()) {
                if (this.d != null && (token instanceof hw) && token.h()) {
                    this.d.deliveryComplete((hw) token);
                }
                d(token);
            }
            if (token.h() && ((token instanceof hw) || (token.e() instanceof xv))) {
                token.a.x(true);
            }
        }
    }

    public void b(iw cause) {
        try {
            if (this.d != null && cause != null) {
                b.fine(a, "connectionLost", "708", new Object[]{cause});
                this.d.connectionLost(cause);
            }
            ew ewVar = this.f;
            if (ewVar != null && cause != null) {
                ewVar.connectionLost(cause);
            }
        } catch (Throwable t) {
            b.fine(a, "connectionLost", "720", new Object[]{t});
        }
    }

    public void d(ow token) {
        xv asyncCB;
        if (token != null && (asyncCB = token.e()) != null) {
            if (token.g() == null) {
                b.fine(a, "fireActionEvent", "716", new Object[]{token.a.e()});
                asyncCB.onSuccess(token);
                return;
            }
            b.fine(a, "fireActionEvent", "716", new Object[]{token.a.e()});
            asyncCB.onFailure(token, token.g());
        }
    }

    public void i(gy sendMessage) {
        if (this.d != null || this.g.size() > 0) {
            synchronized (this.p) {
                while (this.k && !this.l && this.i.size() >= 10) {
                    try {
                        b.fine(a, "messageArrived", "709");
                        this.p.wait(200L);
                    } catch (InterruptedException e) {
                    }
                }
            }
            if (!this.l) {
                this.i.addElement(sendMessage);
                synchronized (this.o) {
                    b.fine(a, "messageArrived", "710");
                    this.o.notifyAll();
                }
            }
        }
    }

    public void j() {
        this.l = true;
        synchronized (this.p) {
            b.fine(a, "quiesce", "711");
            this.p.notifyAll();
        }
    }

    public boolean h() {
        if (this.l && this.j.size() == 0 && this.i.size() == 0) {
            return true;
        }
        return false;
    }

    public final void g(gy publishMessage) throws iw, Exception {
        String destName = publishMessage.A();
        b.fine(a, "handleMessage", "713", new Object[]{new Integer(publishMessage.p()), destName});
        c(destName, publishMessage.p(), publishMessage.z());
        if (!this.r) {
            if (publishMessage.z().c() == 1) {
                this.h.z(new cy(publishMessage), new ow(this.h.t().b()));
            } else if (publishMessage.z().c() == 2) {
                this.h.q(publishMessage);
                dy pubComp = new dy(publishMessage);
                qw qwVar = this.h;
                qwVar.z(pubComp, new ow(qwVar.t().b()));
            }
        }
    }

    public void a(ow token) {
        if (this.k) {
            this.j.addElement(token);
            synchronized (this.o) {
                b.fine(a, "asyncOperationComplete", "715", new Object[]{token.a.e()});
                this.o.notifyAll();
            }
            return;
        }
        try {
            f(token);
        } catch (Throwable ex) {
            b.fine(a, "asyncOperationComplete", "719", null, ex);
            this.h.O(null, new iw(ex));
        }
    }

    public Thread e() {
        return this.n;
    }

    public void k(String topicFilter) {
        this.g.remove(topicFilter);
    }

    public void l() {
        this.g.clear();
    }

    public boolean c(String topicName, int messageId, jw aMessage) throws Exception {
        boolean delivered = false;
        Enumeration keys = this.g.keys();
        while (keys.hasMoreElements()) {
            String topicFilter = (String) keys.nextElement();
            if (pw.a(topicFilter, topicName)) {
                aMessage.g(messageId);
                ((aw) this.g.get(topicFilter)).messageArrived(topicName, aMessage);
                delivered = true;
            }
        }
        if (this.d != null && !delivered) {
            aMessage.g(messageId);
            this.d.messageArrived(topicName, aMessage);
            return true;
        }
        return delivered;
    }
}
