package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
/* compiled from: ThemeUtils.java */
/* renamed from: u2  reason: default package */
/* loaded from: classes.dex */
public class u2 {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    public static final int[] b = {-16842910};
    public static final int[] c = {16842908};
    public static final int[] d = {16843518};
    public static final int[] e = {16842919};
    public static final int[] f = {16842912};
    public static final int[] g = {16842913};
    public static final int[] h = {-16842919, -16842908};
    public static final int[] i = new int[0];
    public static final int[] j = new int[1];

    public static int c(Context context, int attr) {
        int[] iArr = j;
        iArr[0] = attr;
        z2 a2 = z2.t(context, null, iArr);
        try {
            return a2.b(0, 0);
        } finally {
            a2.v();
        }
    }

    public static ColorStateList e(Context context, int attr) {
        int[] iArr = j;
        iArr[0] = attr;
        z2 a2 = z2.t(context, null, iArr);
        try {
            return a2.c(0);
        } finally {
            a2.v();
        }
    }

    public static int b(Context context, int attr) {
        ColorStateList csl = e(context, attr);
        if (csl != null && csl.isStateful()) {
            return csl.getColorForState(b, csl.getDefaultColor());
        }
        TypedValue tv = f();
        context.getTheme().resolveAttribute(16842803, tv, true);
        float disabledAlpha = tv.getFloat();
        return d(context, attr, disabledAlpha);
    }

    public static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    public static int d(Context context, int attr, float alpha) {
        int color = c(context, attr);
        int originalAlpha = Color.alpha(color);
        return x7.d(color, Math.round(originalAlpha * alpha));
    }

    public static void a(View view, Context context) {
        TypedArray a2 = context.obtainStyledAttributes(w.z0);
        try {
            if (!a2.hasValue(w.E0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            a2.recycle();
        }
    }
}
