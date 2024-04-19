package defpackage;
/* compiled from: MqttToken.java */
/* renamed from: ow  reason: default package */
/* loaded from: classes.dex */
public class ow implements bw {
    public hx a;

    public ow() {
        this.a = null;
    }

    public ow(String logContext) {
        this.a = null;
        this.a = new hx(logContext);
    }

    public iw g() {
        return this.a.d();
    }

    public boolean h() {
        return this.a.l();
    }

    public void i(xv listener) {
        this.a.r(listener);
    }

    @Override // defpackage.bw
    public xv e() {
        return this.a.b();
    }

    @Override // defpackage.bw
    public void c(long timeout) throws iw {
        this.a.A(timeout);
    }

    @Override // defpackage.bw
    public yv f() {
        return this.a.c();
    }

    @Override // defpackage.bw
    public String[] b() {
        return this.a.i();
    }

    public void j(Object userContext) {
        this.a.z(userContext);
    }

    @Override // defpackage.bw
    public int a() {
        return this.a.g();
    }

    @Override // defpackage.bw
    public my d() {
        return this.a.h();
    }
}
