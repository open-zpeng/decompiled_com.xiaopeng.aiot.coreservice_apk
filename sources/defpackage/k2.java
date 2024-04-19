package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import com.xiaopeng.libconfig.ipc.AccountConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* compiled from: DrawableUtils.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: k2  reason: default package */
/* loaded from: classes.dex */
public class k2 {
    public static final int[] a = {16842912};
    public static final int[] b = new int[0];
    public static final Rect c = new Rect();
    public static Class<?> d;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                d = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Rect d(Drawable drawable) {
        Field[] fields;
        if (Build.VERSION.SDK_INT >= 29) {
            Insets insets = drawable.getOpticalInsets();
            Rect result = new Rect();
            result.left = insets.left;
            result.right = insets.right;
            result.top = insets.top;
            result.bottom = insets.bottom;
            return result;
        }
        if (d != null) {
            try {
                Drawable drawable2 = i8.p(drawable);
                Method getOpticalInsetsMethod = drawable2.getClass().getMethod("getOpticalInsets", new Class[0]);
                Object insets2 = getOpticalInsetsMethod.invoke(drawable2, new Object[0]);
                if (insets2 != null) {
                    Rect result2 = new Rect();
                    for (Field field : d.getFields()) {
                        String name = field.getName();
                        char c2 = 65535;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals(AccountConfig.FaceIDRegisterAction.ORIENTATION_LEFT)) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals(AccountConfig.FaceIDRegisterAction.ORIENTATION_RIGHT)) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                result2.left = field.getInt(insets2);
                                break;
                            case 1:
                                result2.top = field.getInt(insets2);
                                break;
                            case 2:
                                result2.right = field.getInt(insets2);
                                break;
                            case 3:
                                result2.bottom = field.getInt(insets2);
                                break;
                        }
                    }
                    return result2;
                }
            } catch (Exception e) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return c;
    }

    public static void b(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            c(drawable);
        }
    }

    public static boolean a(Drawable drawable) {
        Drawable[] children;
        int i = Build.VERSION.SDK_INT;
        if (i >= 15 || !(drawable instanceof InsetDrawable)) {
            if (i >= 15 || !(drawable instanceof GradientDrawable)) {
                if (i >= 17 || !(drawable instanceof LayerDrawable)) {
                    if (!(drawable instanceof DrawableContainer)) {
                        if (drawable instanceof k8) {
                            return a(((k8) drawable).b());
                        }
                        if (drawable instanceof m0) {
                            return a(((m0) drawable).a());
                        }
                        if (drawable instanceof ScaleDrawable) {
                            return a(((ScaleDrawable) drawable).getDrawable());
                        }
                        return true;
                    }
                    Drawable.ConstantState state = drawable.getConstantState();
                    if (state instanceof DrawableContainer.DrawableContainerState) {
                        DrawableContainer.DrawableContainerState containerState = (DrawableContainer.DrawableContainerState) state;
                        for (Drawable child : containerState.getChildren()) {
                            if (!a(child)) {
                                return false;
                            }
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static void c(Drawable drawable) {
        int[] originalState = drawable.getState();
        if (originalState == null || originalState.length == 0) {
            drawable.setState(a);
        } else {
            drawable.setState(b);
        }
        drawable.setState(originalState);
    }

    public static PorterDuff.Mode e(int value, PorterDuff.Mode defaultMode) {
        switch (value) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return defaultMode;
        }
    }
}
