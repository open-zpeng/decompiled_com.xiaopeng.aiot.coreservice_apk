package defpackage;
/* compiled from: InitEventHolder.java */
/* renamed from: ln  reason: default package */
/* loaded from: classes.dex */
public class ln implements kn {
    public static volatile ln a = new ln();
    public kn b;

    @Override // defpackage.kn
    public void a(int code, String msg) {
        kn knVar = this.b;
        if (knVar != null) {
            knVar.a(code, msg);
        }
    }

    public static kn b() {
        return a;
    }

    public static void c(kn listener) {
        a.b = listener;
    }
}
