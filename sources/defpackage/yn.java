package defpackage;
/* compiled from: CommonConfig.java */
/* renamed from: yn  reason: default package */
/* loaded from: classes.dex */
public class yn {
    public static final String a = "car.xmart.com/" + co.e();
    public static String b = zn.b("https://10.0.13.28:8553", "https://xmart.xiaopeng.com");
    public static String c = zn.b("https://10.0.13.28:8556", "https://xmart-eu.xiaopeng.com");
    public static final String d;

    static {
        if (Cdo.c()) {
            d = c + "/biz";
            return;
        }
        d = b + "/biz";
    }
}
