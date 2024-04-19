package defpackage;

import android.util.Log;
/* compiled from: OkLogger.java */
/* renamed from: wl  reason: default package */
/* loaded from: classes.dex */
public class wl {
    public static boolean a = true;
    public static String b = "OkGo";

    public static void b(String tag, String msg) {
        if (a) {
            Log.v(tag, msg);
        }
    }

    public static void a(Throwable t) {
        if (!a || t == null) {
            return;
        }
        t.printStackTrace();
    }
}
