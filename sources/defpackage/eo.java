package defpackage;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.Window;
import java.util.HashMap;
import java.util.List;
/* compiled from: ThemeManager.java */
/* renamed from: eo  reason: default package */
/* loaded from: classes.dex */
public class eo {
    public static final boolean a;
    public static final boolean b;
    public static final long c;
    public static final long d;

    static {
        boolean z = SystemProperties.getInt("persist.sys.theme.logger", 0) == 1;
        a = z;
        b = z;
        c = UiModeManager.THEME_ANIMATION_INTERVAL;
        d = UiModeManager.THEME_TIMEOUT_DELAY;
    }

    public static boolean c(Configuration newConfig) {
        return (newConfig == null || (newConfig.uiMode & 192) == 0) ? false : true;
    }

    public static int a(Context context) {
        Context ctx = context != null ? context.getApplicationContext() : null;
        Configuration configuration = ctx != null ? ctx.getResources().getConfiguration() : null;
        if (configuration != null) {
            return configuration.uiMode;
        }
        return 0;
    }

    public static boolean b(Context context) {
        Context ctx = context != null ? context.getApplicationContext() : null;
        Configuration configuration = ctx != null ? ctx.getResources().getConfiguration() : null;
        return configuration != null && (configuration.uiMode & 48) == 32;
    }

    public static void e(Configuration newConfig, Window window, int resId) {
        if (c(newConfig) && window != null) {
            try {
                window.setBackgroundDrawableResource(resId);
            } catch (Exception e) {
            }
        }
    }

    public static HashMap<String, Integer> d(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, HashMap<String, List<String>> extras) {
        return go.e(context, attrs, defStyleAttr, defStyleRes, extras);
    }

    public static void f(View view, HashMap<String, Integer> map) {
        go.i(view, map);
    }

    /* compiled from: ThemeManager.java */
    /* renamed from: eo$b */
    /* loaded from: classes.dex */
    public static class b {
        public static void a(String msg) {
            if (eo.b) {
                Log.i("ThemeManager", msg);
            }
        }

        public static void b(String tag, String msg) {
            Log.i(tag, msg);
        }
    }

    /* compiled from: ThemeManager.java */
    /* renamed from: eo$a */
    /* loaded from: classes.dex */
    public static class a {
        public static final HashMap<String, Integer> a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>();
            a = hashMap;
            hashMap.clear();
            hashMap.put("style", 0);
            hashMap.put("theme", 16842752);
            hashMap.put("alpha", 16843551);
            hashMap.put("foreground", 16843017);
            hashMap.put("background", 16842964);
            hashMap.put("scrollbarThumbVertical", 16842853);
            hashMap.put("src", 16843033);
            hashMap.put("textColor", 16842904);
            hashMap.put("textColorHint", 16842906);
            hashMap.put("drawableLeft", 16843119);
            hashMap.put("drawableTop", 16843117);
            hashMap.put("drawableRight", 16843120);
            hashMap.put("drawableBottom", 16843118);
            hashMap.put("drawableStart", 16843666);
            hashMap.put("drawableEnd", 16843667);
            hashMap.put("progressDrawable", 16843068);
            hashMap.put("thumb", 16843074);
            hashMap.put("button", 16843015);
            hashMap.put("divider", 16843049);
        }

        public static boolean a(String attr) {
            if (!TextUtils.isEmpty(attr)) {
                return a.containsKey(attr);
            }
            return false;
        }

        public static boolean c(String attr) {
            if (!TextUtils.isEmpty(attr)) {
                return "theme".equals(attr);
            }
            return false;
        }

        public static boolean b(String attr) {
            if (!TextUtils.isEmpty(attr)) {
                return "style".equals(attr);
            }
            return false;
        }
    }
}
