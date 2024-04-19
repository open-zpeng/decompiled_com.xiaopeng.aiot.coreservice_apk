package defpackage;
/* compiled from: $Gson$Preconditions.java */
/* renamed from: dg  reason: default package */
/* loaded from: classes.dex */
public final class dg {
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
