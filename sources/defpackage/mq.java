package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.view.Window;
/* compiled from: XThemeManager.java */
/* renamed from: mq  reason: default package */
/* loaded from: classes.dex */
public class mq {
    public static void e(Configuration newConfig, Window window, int resId) {
        eo.e(newConfig, window, resId);
    }

    public static boolean d(Configuration newConfig) {
        return eo.c(newConfig);
    }

    public static boolean a(Context context) {
        return c(context);
    }

    public static boolean b(Configuration config) {
        return config != null && (config.uiMode & 48) == 32;
    }

    public static boolean c(Context context) {
        return eo.b(context);
    }
}
