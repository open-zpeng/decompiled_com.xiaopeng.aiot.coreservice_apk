package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: DrawableCompat.java */
/* renamed from: i8  reason: default package */
/* loaded from: classes.dex */
public final class i8 {
    public static Method a;
    public static boolean b;
    public static Method c;
    public static boolean d;

    @Deprecated
    public static void h(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void i(Drawable drawable, boolean mirrored) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(mirrored);
        }
    }

    public static boolean g(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    public static void j(Drawable drawable, float x, float y) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(x, y);
        }
    }

    public static void k(Drawable drawable, int left, int top, int right, int bottom) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(left, top, right, bottom);
        }
    }

    public static void m(Drawable drawable, int tint) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(tint);
        } else if (drawable instanceof j8) {
            ((j8) drawable).setTint(tint);
        }
    }

    public static void n(Drawable drawable, ColorStateList tint) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(tint);
        } else if (drawable instanceof j8) {
            ((j8) drawable).setTintList(tint);
        }
    }

    public static void o(Drawable drawable, PorterDuff.Mode tintMode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(tintMode);
        } else if (drawable instanceof j8) {
            ((j8) drawable).setTintMode(tintMode);
        }
    }

    public static int c(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean b(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public static ColorFilter d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    public static void f(Drawable drawable, Resources res, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(res, parser, attrs, theme);
        } else {
            drawable.inflate(res, parser, attrs);
        }
    }

    public static Drawable q(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return drawable;
        }
        if (i >= 21) {
            if (!(drawable instanceof j8)) {
                return new m8(drawable);
            }
            return drawable;
        } else if (!(drawable instanceof j8)) {
            return new l8(drawable);
        } else {
            return drawable;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T p(Drawable drawable) {
        if (drawable instanceof k8) {
            return (T) ((k8) drawable).b();
        }
        return drawable;
    }

    public static boolean l(Drawable drawable, int layoutDirection) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return drawable.setLayoutDirection(layoutDirection);
        }
        if (i >= 17) {
            if (!b) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    a = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e);
                }
                b = true;
            }
            Method method = a;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(layoutDirection));
                    return true;
                } catch (Exception e2) {
                    Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    a = null;
                }
            }
            return false;
        }
        return false;
    }

    public static int e(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return drawable.getLayoutDirection();
        }
        if (i >= 17) {
            if (!d) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    c = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e);
                }
                d = true;
            }
            Method method = c;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e2) {
                    Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e2);
                    c = null;
                }
            }
            return 0;
        }
        return 0;
    }
}
