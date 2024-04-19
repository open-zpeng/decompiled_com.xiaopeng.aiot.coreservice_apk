package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
/* compiled from: ViewConfigurationCompat.java */
/* renamed from: ha  reason: default package */
/* loaded from: classes.dex */
public final class ha {
    public static Method a;

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception e) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    public static int a(ViewConfiguration config) {
        if (Build.VERSION.SDK_INT >= 28) {
            return config.getScaledHoverSlop();
        }
        return config.getScaledTouchSlop() / 2;
    }

    public static boolean b(ViewConfiguration config, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return config.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
        Resources res = context.getResources();
        int platformResId = res.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        return platformResId != 0 && res.getBoolean(platformResId);
    }
}
