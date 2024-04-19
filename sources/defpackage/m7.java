package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;
/* compiled from: ContextCompat.java */
/* renamed from: m7  reason: default package */
/* loaded from: classes.dex */
public class m7 {
    public static final Object a = new Object();
    public static TypedValue b;

    public static boolean g(Context context, Intent[] intents, Bundle options) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intents, options);
            return true;
        }
        context.startActivities(intents);
        return true;
    }

    public static File[] f(Context context, String type) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs(type) : new File[]{context.getExternalFilesDir(type)};
    }

    public static File[] e(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()};
    }

    public static Drawable d(Context context, int id) {
        int resolvedId;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            return context.getDrawable(id);
        }
        if (i >= 16) {
            return context.getResources().getDrawable(id);
        }
        synchronized (a) {
            if (b == null) {
                b = new TypedValue();
            }
            context.getResources().getValue(id, b, true);
            resolvedId = b.resourceId;
        }
        return context.getResources().getDrawable(resolvedId);
    }

    public static ColorStateList c(Context context, int id) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(id);
        }
        return context.getResources().getColorStateList(id);
    }

    public static int b(Context context, int id) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(id);
        }
        return context.getResources().getColor(id);
    }

    public static int a(Context context, String permission) {
        if (permission == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(permission, Process.myPid(), Process.myUid());
    }
}
