package defpackage;
/* compiled from: ExceptionHelper.java */
/* renamed from: yw  reason: default package */
/* loaded from: classes.dex */
public class yw {
    public static iw a(int reasonCode) {
        if (reasonCode == 4 || reasonCode == 5) {
            return new nw(reasonCode);
        }
        return new iw(reasonCode);
    }

    public static iw b(Throwable cause) {
        if (cause.getClass().getName().equals("java.security.GeneralSecurityException")) {
            return new nw(cause);
        }
        return new iw(cause);
    }

    public static boolean c(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
