package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
/* compiled from: MenuItemCompat.java */
/* renamed from: t9  reason: default package */
/* loaded from: classes.dex */
public final class t9 {
    public static MenuItem a(MenuItem item, m9 provider) {
        if (item instanceof p8) {
            return ((p8) item).a(provider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return item;
    }

    public static void c(MenuItem item, CharSequence contentDescription) {
        if (item instanceof p8) {
            ((p8) item).setContentDescription(contentDescription);
        } else if (Build.VERSION.SDK_INT >= 26) {
            item.setContentDescription(contentDescription);
        }
    }

    public static void g(MenuItem item, CharSequence tooltipText) {
        if (item instanceof p8) {
            ((p8) item).setTooltipText(tooltipText);
        } else if (Build.VERSION.SDK_INT >= 26) {
            item.setTooltipText(tooltipText);
        }
    }

    public static void f(MenuItem item, char numericChar, int numericModifiers) {
        if (item instanceof p8) {
            ((p8) item).setNumericShortcut(numericChar, numericModifiers);
        } else if (Build.VERSION.SDK_INT >= 26) {
            item.setNumericShortcut(numericChar, numericModifiers);
        }
    }

    public static void b(MenuItem item, char alphaChar, int alphaModifiers) {
        if (item instanceof p8) {
            ((p8) item).setAlphabeticShortcut(alphaChar, alphaModifiers);
        } else if (Build.VERSION.SDK_INT >= 26) {
            item.setAlphabeticShortcut(alphaChar, alphaModifiers);
        }
    }

    public static void d(MenuItem item, ColorStateList tint) {
        if (item instanceof p8) {
            ((p8) item).setIconTintList(tint);
        } else if (Build.VERSION.SDK_INT >= 26) {
            item.setIconTintList(tint);
        }
    }

    public static void e(MenuItem item, PorterDuff.Mode tintMode) {
        if (item instanceof p8) {
            ((p8) item).setIconTintMode(tintMode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            item.setIconTintMode(tintMode);
        }
    }
}
