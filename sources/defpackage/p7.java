package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
/* compiled from: ThemeContextCompat.java */
/* renamed from: p7  reason: default package */
/* loaded from: classes.dex */
public class p7 {
    public static final Object a = new Object();
    public static TypedValue b;

    public static Drawable b(Context context, int id) {
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

    public static ColorStateList a(Context context, int id) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(id);
        }
        return context.getResources().getColorStateList(id);
    }
}
