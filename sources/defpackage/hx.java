package defpackage;
/* compiled from: Token.java */
/* renamed from: hx  reason: default package */
/* loaded from: classes.dex */
public class hx {
    public static final String a;
    public static final qy b;
    public String l;
    public volatile boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public Object f = new Object();
    public Object g = new Object();
    public jw h = null;
    public my i = null;
    public iw j = null;
    public String[] k = null;
    public yv m = null;
    public xv n = null;
    public Object o = null;
    public int p = 0;
    public boolean q = false;

    static {
        String name = hx.class.getName();
        a = name;
        b = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public hx(String logContext) {
        b.setResourceName(logContext);
    }

    public int g() {
        return this.p;
    }

    public void w(int messageID) {
        this.p = messageID;
    }

    public boolean a() throws iw {
        if (d() != null) {
            throw d();
        }
        return true;
    }

    public iw d() {
        return this.j;
    }

    public boolean l() {
        return this.c;
    }

    public boolean m() {
        return this.d;
    }

    public void r(xv listener) {
        this.n = listener;
    }

    public xv b() {
        return this.n;
    }

    public void A(long timeout) throws iw {
        qy qyVar = b;
        String str = a;
        qyVar.fine(str, "waitForCompletion", "407", new Object[]{e(), new Long(timeout), this});
        my resp = B(timeout);
        if (resp == null && !this.c) {
            qyVar.fine(str, "waitForCompletion", "406", new Object[]{e(), this});
            iw iwVar = new iw(32000);
            this.j = iwVar;
            throw iwVar;
        }
        a();
    }

    public my B(long timeout) throws iw {
        synchronized (this.f) {
            qy qyVar = b;
            String str = a;
            Object[] objArr = new Object[7];
            objArr[0] = e();
            objArr[1] = new Long(timeout);
            objArr[2] = new Boolean(this.e);
            objArr[3] = new Boolean(this.c);
            iw iwVar = this.j;
            objArr[4] = iwVar == null ? "false" : "true";
            objArr[5] = this.i;
            objArr[6] = this;
            qyVar.fine(str, "waitForResponse", "400", objArr, iwVar);
            while (!this.c) {
                if (this.j == null) {
                    try {
                        b.fine(a, "waitForResponse", "408", new Object[]{e(), new Long(timeout)});
                        if (timeout <= 0) {
                            this.f.wait();
                        } else {
                            this.f.wait(timeout);
                        }
                    } catch (InterruptedException e) {
                        this.j = new iw(e);
                    }
                }
                if (!this.c) {
                    iw iwVar2 = this.j;
                    if (iwVar2 != null) {
                        b.fine(a, "waitForResponse", "401", null, iwVar2);
                        throw this.j;
                    } else if (timeout > 0) {
                        break;
                    }
                }
            }
        }
        b.fine(a, "waitForResponse", "402", new Object[]{e(), this.i});
        return this.i;
    }

    public void o(my msg, iw ex) {
        b.fine(a, "markComplete", "404", new Object[]{e(), msg, ex});
        synchronized (this.f) {
            if (msg instanceof tx) {
                this.h = null;
            }
            this.d = true;
            this.i = msg;
            this.j = ex;
        }
    }

    public void p() {
        b.fine(a, "notifyComplete", "404", new Object[]{e(), this.i, this.j});
        synchronized (this.f) {
            if (this.j == null && this.d) {
                this.c = true;
                this.d = false;
            } else {
                this.d = false;
            }
            this.f.notifyAll();
        }
        synchronized (this.g) {
            this.e = true;
            this.g.notifyAll();
        }
    }

    public void C() throws iw {
        boolean z;
        synchronized (this.g) {
            synchronized (this.f) {
                iw iwVar = this.j;
                if (iwVar != null) {
                    throw iwVar;
                }
            }
            while (true) {
                z = this.e;
                if (z) {
                    break;
                }
                try {
                    b.fine(a, "waitUntilSent", "409", new Object[]{e()});
                    this.g.wait();
                } catch (InterruptedException e) {
                }
            }
            if (!z) {
                iw iwVar2 = this.j;
                if (iwVar2 == null) {
                    throw yw.a(6);
                }
                throw iwVar2;
            }
        }
    }

    public void q() {
        b.fine(a, "notifySent", "403", new Object[]{e()});
        synchronized (this.f) {
            this.i = null;
            this.c = false;
        }
        synchronized (this.g) {
            this.e = true;
            this.g.notifyAll();
        }
    }

    public yv c() {
        return this.m;
    }

    public void s(yv client) {
        this.m = client;
    }

    public jw f() {
        return this.h;
    }

    public my k() {
        return this.i;
    }

    public void v(jw msg) {
        this.h = msg;
    }

    public String[] i() {
        return this.k;
    }

    public void y(String[] topics) {
        this.k = topics;
    }

    public Object j() {
        return this.o;
    }

    public void z(Object userContext) {
        this.o = userContext;
    }

    public void u(String key) {
        this.l = key;
    }

    public String e() {
        return this.l;
    }

    public void t(iw exception) {
        synchronized (this.f) {
            this.j = exception;
        }
    }

    public boolean n() {
        return this.q;
    }

    public void x(boolean notified) {
        this.q = notified;
    }

    public String toString() {
        StringBuffer tok = new StringBuffer();
        tok.append("key=");
        tok.append(e());
        tok.append(" ,topics=");
        if (i() != null) {
            for (int i = 0; i < i().length; i++) {
                tok.append(i()[i]);
                tok.append(", ");
            }
        }
        tok.append(" ,usercontext=");
        tok.append(j());
        tok.append(" ,isComplete=");
        tok.append(l());
        tok.append(" ,isNotified=");
        tok.append(n());
        tok.append(" ,exception=");
        tok.append(d());
        tok.append(" ,actioncallback=");
        tok.append(b());
        return tok.toString();
    }

    public my h() {
        return this.i;
    }
}
