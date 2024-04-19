package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;
/* compiled from: CompoundButtonCompat.java */
/* renamed from: ab  reason: default package */
/* loaded from: classes.dex */
public final class ab {
    public static Field a;
    public static boolean b;

    public static void b(CompoundButton button, ColorStateList tint) {
        if (Build.VERSION.SDK_INT >= 21) {
            button.setButtonTintList(tint);
        } else if (button instanceof ib) {
            ((ib) button).setSupportButtonTintList(tint);
        }
    }

    public static void c(CompoundButton button, PorterDuff.Mode tintMode) {
        if (Build.VERSION.SDK_INT >= 21) {
            button.setButtonTintMode(tintMode);
        } else if (button instanceof ib) {
            ((ib) button).setSupportButtonTintMode(tintMode);
        }
    }

    public static Drawable a(CompoundButton button) {
        if (Build.VERSION.SDK_INT >= 23) {
            return button.getButtonDrawable();
        }
        if (!b) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            b = true;
        }
        Field field = a;
        if (field != null) {
            try {
                return (Drawable) field.get(button);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                a = null;
            }
        }
        return null;
    }
}
