package defpackage;
/* compiled from: ParseUtils.java */
/* renamed from: wi  reason: default package */
/* loaded from: classes.dex */
public class wi {
    public static int a(String str) {
        if (xi.a(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return 0;
    }
}
