package defpackage;

import com.lzy.okgo.model.HttpHeaders;
import java.util.Enumeration;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
/* compiled from: ClientComms.java */
/* renamed from: qw  reason: default package */
/* loaded from: classes.dex */
public class qw {
    public static String a = "${project.version}";
    public static String b = "L${build.level}";
    public static final String c;
    public static final qy d;
    public yv e;
    public int f;
    public dx[] g;
    public tw h;
    public uw i;
    public sw j;
    public rw k;
    public gw l;
    public fw m;
    public mw n;
    public vw o;
    public byte q;
    public xw u;
    public ExecutorService v;
    public boolean p = false;
    public Object r = new Object();
    public boolean s = false;
    public boolean t = false;

    static {
        String name = qw.class.getName();
        c = name;
        d = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public qw(yv client, fw persistence, mw pingSender, ExecutorService executorService) throws iw {
        this.q = (byte) 3;
        this.q = (byte) 3;
        this.e = client;
        this.m = persistence;
        this.n = pingSender;
        pingSender.b(this);
        this.v = executorService;
        this.o = new vw(t().b());
        this.j = new sw(this);
        rw rwVar = new rw(persistence, this.o, this.j, this, pingSender);
        this.k = rwVar;
        this.j.n(rwVar);
        d.setResourceName(t().b());
    }

    public final void P() {
        this.v.shutdown();
        try {
            ExecutorService executorService = this.v;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!executorService.awaitTermination(1L, timeUnit)) {
                this.v.shutdownNow();
                if (!this.v.awaitTermination(1L, timeUnit)) {
                    d.fine(c, "shutdownExecutorService", "executorService did not terminate");
                }
            }
        } catch (InterruptedException e) {
            this.v.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public void z(my message, ow token) throws iw {
        qy qyVar = d;
        String str = c;
        qyVar.fine(str, "internalSend", "200", new Object[]{message.o(), message, token});
        if (token.f() == null) {
            token.a.s(t());
            try {
                this.k.J(message, token);
                return;
            } catch (iw e) {
                if (message instanceof gy) {
                    this.k.O((gy) message);
                }
                throw e;
            }
        }
        qyVar.fine(str, "internalSend", "213", new Object[]{message.o(), message, token});
        throw new iw(32201);
    }

    public void H(my message, ow token) throws iw {
        if (B() || ((!B() && (message instanceof vx)) || (E() && (message instanceof wx)))) {
            xw xwVar = this.u;
            if (xwVar != null && xwVar.c() != 0) {
                d.fine(c, "sendNoWait", "507", new Object[]{message.o()});
                if (this.u.d()) {
                    this.k.B(message);
                }
                this.u.e(message, token);
                return;
            }
            z(message, token);
        } else if (this.u != null) {
            d.fine(c, "sendNoWait", "508", new Object[]{message.o()});
            if (this.u.d()) {
                this.k.B(message);
            }
            this.u.e(message, token);
        } else {
            d.fine(c, "sendNoWait", "208");
            throw yw.a(32104);
        }
    }

    public void n(boolean force) throws iw {
        synchronized (this.r) {
            if (!A()) {
                if (!D() || force) {
                    d.fine(c, HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "224");
                    if (C()) {
                        throw new iw(32110);
                    }
                    if (B()) {
                        throw yw.a(32100);
                    }
                    if (E()) {
                        this.s = true;
                        return;
                    }
                }
                this.q = (byte) 4;
                P();
                this.k.d();
                this.k = null;
                this.j = null;
                this.m = null;
                this.i = null;
                this.n = null;
                this.h = null;
                this.g = null;
                this.l = null;
                this.o = null;
            }
        }
    }

    public void o(gw options, ow token) throws iw {
        synchronized (this.r) {
            try {
                try {
                    if (D() && !this.s) {
                        d.fine(c, "connect", "214");
                        this.q = (byte) 1;
                        this.l = options;
                        vx connect = new vx(this.e.b(), this.l.e(), this.l.o(), this.l.c(), this.l.k(), this.l.f(), this.l.m(), this.l.l());
                        this.k.L(this.l.c());
                        this.k.K(this.l.o());
                        this.k.M(this.l.d());
                        this.o.g();
                        a conbg = new a(this, token, connect, this.v);
                        conbg.a();
                        return;
                    }
                    d.fine(c, "connect", "207", new Object[]{new Byte(this.q)});
                    if (A() || this.s) {
                        throw new iw(32111);
                    }
                    if (C()) {
                        throw new iw(32110);
                    }
                    if (E()) {
                        throw new iw(32102);
                    }
                    throw yw.a(32100);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public void p(ux cack, iw mex) throws iw {
        int rc = cack.y();
        synchronized (this.r) {
            if (rc == 0) {
                d.fine(c, "connectComplete", "215");
                this.q = (byte) 0;
                return;
            }
            d.fine(c, "connectComplete", "204", new Object[]{new Integer(rc)});
            throw mex;
        }
    }

    public void O(ow token, iw reason) {
        sw swVar;
        fw fwVar;
        dx networkModule;
        synchronized (this.r) {
            if (!this.p && !this.s && !A()) {
                this.p = true;
                d.fine(c, "shutdownConnection", "216");
                boolean wasConnected = B() || E();
                this.q = (byte) 2;
                if (token != null && !token.h()) {
                    token.a.t(reason);
                }
                sw swVar2 = this.j;
                if (swVar2 != null) {
                    swVar2.q();
                }
                tw twVar = this.h;
                if (twVar != null) {
                    twVar.b();
                }
                try {
                    dx[] dxVarArr = this.g;
                    if (dxVarArr != null && (networkModule = dxVarArr[this.f]) != null) {
                        networkModule.stop();
                    }
                } catch (Exception e) {
                }
                this.o.h(new iw(32102));
                ow endToken = x(token, reason);
                try {
                    this.k.h(reason);
                    if (this.k.k()) {
                        this.j.l();
                    }
                } catch (Exception e2) {
                }
                uw uwVar = this.i;
                if (uwVar != null) {
                    uwVar.c();
                }
                mw mwVar = this.n;
                if (mwVar != null) {
                    mwVar.stop();
                }
                try {
                    if (this.u == null && (fwVar = this.m) != null) {
                        fwVar.close();
                    }
                } catch (Exception e3) {
                }
                synchronized (this.r) {
                    d.fine(c, "shutdownConnection", "217");
                    this.q = (byte) 3;
                    this.p = false;
                }
                boolean z = endToken != null;
                sw swVar3 = this.j;
                if (z & (swVar3 != null)) {
                    swVar3.a(endToken);
                }
                if (wasConnected && (swVar = this.j) != null) {
                    swVar.b(reason);
                }
                synchronized (this.r) {
                    if (this.s) {
                        try {
                            n(true);
                        } catch (Exception e4) {
                        }
                    }
                }
            }
        }
    }

    public final ow x(ow token, iw reason) {
        d.fine(c, "handleOldTokens", "222");
        ow tokToNotifyLater = null;
        if (token != null) {
            try {
                if (this.o.e(token.a.e()) == null) {
                    this.o.l(token, token.a.e());
                }
            } catch (Exception e) {
            }
        }
        Vector toksToNot = this.k.F(reason);
        Enumeration toksToNotE = toksToNot.elements();
        while (toksToNotE.hasMoreElements()) {
            ow tok = (ow) toksToNotE.nextElement();
            if (!tok.a.e().equals("Disc") && !tok.a.e().equals("Con")) {
                this.j.a(tok);
            }
            tokToNotifyLater = tok;
        }
        return tokToNotifyLater;
    }

    public void r(wx disconnect, long quiesceTimeout, ow token) throws iw {
        synchronized (this.r) {
            if (A()) {
                d.fine(c, "disconnect", "223");
                throw yw.a(32111);
            } else if (D()) {
                d.fine(c, "disconnect", "211");
                throw yw.a(32101);
            } else if (E()) {
                d.fine(c, "disconnect", "219");
                throw yw.a(32102);
            } else if (Thread.currentThread() == this.j.e()) {
                d.fine(c, "disconnect", "210");
                throw yw.a(32107);
            } else {
                d.fine(c, "disconnect", "218");
                this.q = (byte) 2;
                b discbg = new b(disconnect, quiesceTimeout, token, this.v);
                discbg.a();
            }
        }
    }

    public void s(long quiesceTimeout, long disconnectTimeout, boolean sendDisconnectPacket) throws iw {
        rw rwVar = this.k;
        if (rwVar != null) {
            rwVar.C(quiesceTimeout);
        }
        ow token = new ow(this.e.b());
        if (sendDisconnectPacket) {
            try {
                z(new wx(), token);
                token.c(disconnectTimeout);
            } catch (Exception e) {
            } catch (Throwable th) {
                token.a.o(null, null);
                O(token, null);
                throw th;
            }
        }
        token.a.o(null, null);
        O(token, null);
    }

    public boolean B() {
        boolean z;
        synchronized (this.r) {
            z = this.q == 0;
        }
        return z;
    }

    public boolean C() {
        boolean z;
        synchronized (this.r) {
            z = true;
            if (this.q != 1) {
                z = false;
            }
        }
        return z;
    }

    public boolean D() {
        boolean z;
        synchronized (this.r) {
            z = this.q == 3;
        }
        return z;
    }

    public boolean E() {
        boolean z;
        synchronized (this.r) {
            z = this.q == 2;
        }
        return z;
    }

    public boolean A() {
        boolean z;
        synchronized (this.r) {
            z = this.q == 4;
        }
        return z;
    }

    public void I(dw mqttCallback) {
        this.j.m(mqttCallback);
    }

    public void M(ew callback) {
        this.j.o(callback);
    }

    public void G(String topicFilter) {
        this.j.k(topicFilter);
    }

    public void K(int index) {
        this.f = index;
    }

    public int v() {
        return this.f;
    }

    public dx[] w() {
        return this.g;
    }

    public void L(dx[] networkModules) {
        this.g = networkModules;
    }

    public void q(gy msg) throws lw {
        this.k.g(msg);
    }

    public yv t() {
        return this.e;
    }

    public long u() {
        return this.k.l();
    }

    /* compiled from: ClientComms.java */
    /* renamed from: qw$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public qw a;
        public ow b;
        public vx d;
        public String f;

        public a(qw cc, ow cToken, vx cPacket, ExecutorService executorService) {
            this.a = null;
            this.a = cc;
            this.b = cToken;
            this.d = cPacket;
            this.f = "MQTT Con: " + qw.this.t().b();
        }

        public void a() {
            qw.this.v.execute(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName(this.f);
            iw mqttEx = null;
            qw.d.fine(qw.c, "connectBG:run", "220");
            try {
                hw[] toks = qw.this.o.c();
                for (hw hwVar : toks) {
                    hwVar.a.t(null);
                }
                qw.this.o.m(this.b, this.d);
                dx networkModule = qw.this.g[qw.this.f];
                networkModule.start();
                qw.this.h = new tw(this.a, qw.this.k, qw.this.o, networkModule.c());
                qw.this.h.a("MQTT Rec: " + qw.this.t().b(), qw.this.v);
                qw.this.i = new uw(this.a, qw.this.k, qw.this.o, networkModule.b());
                qw.this.i.b("MQTT Snd: " + qw.this.t().b(), qw.this.v);
                qw.this.j.p("MQTT Call: " + qw.this.t().b(), qw.this.v);
                qw.this.z(this.d, this.b);
            } catch (iw ex) {
                qw.d.fine(qw.c, "connectBG:run", "212", null, ex);
                mqttEx = ex;
            } catch (Exception ex2) {
                qw.d.fine(qw.c, "connectBG:run", "209", null, ex2);
                mqttEx = yw.b(ex2);
            }
            if (mqttEx != null) {
                qw.this.O(this.b, mqttEx);
            }
        }
    }

    /* compiled from: ClientComms.java */
    /* renamed from: qw$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public wx a;
        public long b;
        public ow d;
        public String f;

        public b(wx disconnect, long quiesceTimeout, ow token, ExecutorService executorService) {
            this.a = disconnect;
            this.b = quiesceTimeout;
            this.d = token;
        }

        public void a() {
            this.f = "MQTT Disc: " + qw.this.t().b();
            qw.this.v.execute(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName(this.f);
            qw.d.fine(qw.c, "disconnectBG:run", "221");
            qw.this.k.C(this.b);
            try {
                qw.this.z(this.a, this.d);
                this.d.a.C();
            } catch (iw e) {
            } catch (Throwable th) {
                this.d.a.o(null, null);
                qw.this.O(this.d, null);
                throw th;
            }
            this.d.a.o(null, null);
            qw.this.O(this.d, null);
        }
    }

    public ow m(xv pingCallback) {
        try {
            ow token = this.k.a(pingCallback);
            return token;
        } catch (iw e) {
            y(e);
            return null;
        } catch (Exception e2) {
            y(e2);
            return null;
        }
    }

    public final void y(Exception ex) {
        iw mex;
        d.fine(c, "handleRunException", "804", null, ex);
        if (!(ex instanceof iw)) {
            mex = new iw(32109, ex);
        } else {
            mex = (iw) ex;
        }
        O(null, mex);
    }

    public void N(boolean resting) {
        this.t = resting;
    }

    public void J(xw disconnectedMessageBuffer) {
        this.u = disconnectedMessageBuffer;
    }

    public void F() {
        if (this.u != null) {
            d.fine(c, "notifyConnect", "509");
            this.u.f(new c("notifyConnect"));
            this.v.execute(this.u);
        }
    }

    /* compiled from: ClientComms.java */
    /* renamed from: qw$c */
    /* loaded from: classes.dex */
    public class c implements ax {
        public final String a;

        public c(String methodName) {
            this.a = methodName;
        }

        @Override // defpackage.ax
        public void a(vv bufferedMessage) throws iw {
            if (!qw.this.B()) {
                qw.d.fine(qw.c, this.a, "208");
                throw yw.a(32104);
            }
            while (qw.this.k.j() >= qw.this.k.m() - 1) {
                Thread.yield();
            }
            qw.d.fine(qw.c, this.a, "510", new Object[]{bufferedMessage.a().o()});
            qw.this.z(bufferedMessage.a(), bufferedMessage.b());
            qw.this.k.N(bufferedMessage.a());
        }
    }
}
