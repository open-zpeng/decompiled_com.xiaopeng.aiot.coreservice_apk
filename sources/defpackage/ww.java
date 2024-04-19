package defpackage;
/* compiled from: ConnectActionListener.java */
/* renamed from: ww  reason: default package */
/* loaded from: classes.dex */
public class ww implements xv {
    public fw a;
    public cw b;
    public qw c;
    public gw d;
    public ow e;
    public Object f;
    public xv g;
    public int h;
    public ew i;
    public boolean j;

    public ww(cw client, fw persistence, qw comms, gw options, ow userToken, Object userContext, xv userCallback, boolean reconnect) {
        this.a = persistence;
        this.b = client;
        this.c = comms;
        this.d = options;
        this.e = userToken;
        this.f = userContext;
        this.g = userCallback;
        this.h = options.e();
        this.j = reconnect;
    }

    @Override // defpackage.xv
    public void onSuccess(bw token) {
        if (this.h == 0) {
            this.d.t(0);
        }
        this.e.a.o(token.d(), null);
        this.e.a.p();
        this.e.a.s(this.b);
        this.c.F();
        if (this.g != null) {
            this.e.j(this.f);
            this.g.onSuccess(this.e);
        }
        if (this.i != null) {
            String serverURI = this.c.w()[this.c.v()].a();
            this.i.connectComplete(this.j, serverURI);
        }
    }

    @Override // defpackage.xv
    public void onFailure(bw token, Throwable exception) {
        iw ex;
        int numberOfURIs = this.c.w().length;
        int index = this.c.v();
        if (index + 1 < numberOfURIs || (this.h == 0 && this.d.e() == 4)) {
            if (this.h == 0) {
                if (this.d.e() == 4) {
                    this.d.t(3);
                } else {
                    this.d.t(4);
                    this.c.K(index + 1);
                }
            } else {
                this.c.K(index + 1);
            }
            try {
                a();
                return;
            } catch (lw e) {
                onFailure(token, e);
                return;
            }
        }
        if (this.h == 0) {
            this.d.t(0);
        }
        if (exception instanceof iw) {
            ex = (iw) exception;
        } else {
            ex = new iw(exception);
        }
        this.e.a.o(null, ex);
        this.e.a.p();
        this.e.a.s(this.b);
        if (this.g != null) {
            this.e.j(this.f);
            this.g.onFailure(this.e, exception);
        }
    }

    public void a() throws lw {
        ow token = new ow(this.b.b());
        token.i(this);
        token.j(this);
        this.a.open(this.b.b(), this.b.a());
        if (this.d.o()) {
            this.a.clear();
        }
        if (this.d.e() == 0) {
            this.d.t(4);
        }
        try {
            this.c.o(this.d, token);
        } catch (iw e) {
            onFailure(token, e);
        }
    }

    public void b(ew mqttCallbackExtended) {
        this.i = mqttCallbackExtended;
    }
}
