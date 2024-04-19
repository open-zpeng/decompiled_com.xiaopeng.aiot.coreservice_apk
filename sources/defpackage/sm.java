package defpackage;
/* compiled from: BizConstants.java */
/* renamed from: sm  reason: default package */
/* loaded from: classes.dex */
public interface sm {
    public static final String a = yn.b;
    public static final int b = a();

    static int a() {
        if (co.f()) {
            String str = a;
            if (str.equals("https://xmart.deploy-test.xiaopeng.com")) {
                return 2;
            }
            if (str.equals("https://10.0.13.28:8553")) {
                return 1;
            }
            return 0;
        }
        return co.h() ? 1 : 0;
    }
}
