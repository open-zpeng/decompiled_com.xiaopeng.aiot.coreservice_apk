package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
/* compiled from: ImageViewCompat.java */
/* renamed from: cb  reason: default package */
/* loaded from: classes.dex */
public class cb {
    public static ColorStateList a(ImageView view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getImageTintList();
        }
        if (view instanceof kb) {
            return ((kb) view).getSupportImageTintList();
        }
        return null;
    }

    public static void c(ImageView view, ColorStateList tintList) {
        Drawable imageViewDrawable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            view.setImageTintList(tintList);
            if (i == 21 && (imageViewDrawable = view.getDrawable()) != null && view.getImageTintList() != null) {
                if (imageViewDrawable.isStateful()) {
                    imageViewDrawable.setState(view.getDrawableState());
                }
                view.setImageDrawable(imageViewDrawable);
            }
        } else if (view instanceof kb) {
            ((kb) view).setSupportImageTintList(tintList);
        }
    }

    public static PorterDuff.Mode b(ImageView view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getImageTintMode();
        }
        if (view instanceof kb) {
            return ((kb) view).getSupportImageTintMode();
        }
        return null;
    }

    public static void d(ImageView view, PorterDuff.Mode mode) {
        Drawable imageViewDrawable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            view.setImageTintMode(mode);
            if (i == 21 && (imageViewDrawable = view.getDrawable()) != null && view.getImageTintList() != null) {
                if (imageViewDrawable.isStateful()) {
                    imageViewDrawable.setState(view.getDrawableState());
                }
                view.setImageDrawable(imageViewDrawable);
            }
        } else if (view instanceof kb) {
            ((kb) view).setSupportImageTintMode(mode);
        }
    }
}
