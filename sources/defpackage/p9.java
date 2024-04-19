package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;
/* compiled from: GravityCompat.java */
/* renamed from: p9  reason: default package */
/* loaded from: classes.dex */
public final class p9 {
    public static void a(int gravity, int w, int h, Rect container, Rect outRect, int layoutDirection) {
        if (Build.VERSION.SDK_INT >= 17) {
            Gravity.apply(gravity, w, h, container, outRect, layoutDirection);
        } else {
            Gravity.apply(gravity, w, h, container, outRect);
        }
    }

    public static int b(int gravity, int layoutDirection) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Gravity.getAbsoluteGravity(gravity, layoutDirection);
        }
        return (-8388609) & gravity;
    }
}
