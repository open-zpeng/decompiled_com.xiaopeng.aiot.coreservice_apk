package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* compiled from: AppCompatImageHelper.java */
/* renamed from: a2  reason: default package */
/* loaded from: classes.dex */
public class a2 {
    public final ImageView a;
    public x2 b;
    public x2 c;
    public x2 d;

    public a2(ImageView view) {
        this.a = view;
    }

    public void f(AttributeSet attrs, int defStyleAttr) {
        int id;
        Context context = this.a.getContext();
        int[] iArr = w.R;
        z2 a = z2.u(context, attrs, iArr, defStyleAttr, 0);
        ImageView imageView = this.a;
        ga.X(imageView, imageView.getContext(), iArr, attrs, a.q(), defStyleAttr, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (id = a.m(w.S, -1)) != -1 && (drawable = j0.d(this.a.getContext(), id)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                k2.b(drawable);
            }
            int i = w.T;
            if (a.r(i)) {
                cb.c(this.a, a.c(i));
            }
            int i2 = w.U;
            if (a.r(i2)) {
                cb.d(this.a, k2.e(a.j(i2, -1), null));
            }
        } finally {
            a.v();
        }
    }

    public void g(int resId) {
        if (resId != 0) {
            Drawable d = j0.d(this.a.getContext(), resId);
            if (d != null) {
                k2.b(d);
            }
            this.a.setImageDrawable(d);
        } else {
            this.a.setImageDrawable(null);
        }
        b();
    }

    public boolean e() {
        Drawable background = this.a.getBackground();
        if (Build.VERSION.SDK_INT >= 21 && (background instanceof RippleDrawable)) {
            return false;
        }
        return true;
    }

    public void h(ColorStateList tint) {
        if (this.c == null) {
            this.c = new x2();
        }
        x2 x2Var = this.c;
        x2Var.a = tint;
        x2Var.d = true;
        b();
    }

    public ColorStateList c() {
        x2 x2Var = this.c;
        if (x2Var != null) {
            return x2Var.a;
        }
        return null;
    }

    public void i(PorterDuff.Mode tintMode) {
        if (this.c == null) {
            this.c = new x2();
        }
        x2 x2Var = this.c;
        x2Var.b = tintMode;
        x2Var.c = true;
        b();
    }

    public PorterDuff.Mode d() {
        x2 x2Var = this.c;
        if (x2Var != null) {
            return x2Var.b;
        }
        return null;
    }

    public void b() {
        Drawable imageViewDrawable = this.a.getDrawable();
        if (imageViewDrawable != null) {
            k2.b(imageViewDrawable);
        }
        if (imageViewDrawable != null) {
            if (j() && a(imageViewDrawable)) {
                return;
            }
            x2 x2Var = this.c;
            if (x2Var != null) {
                y1.i(imageViewDrawable, x2Var, this.a.getDrawableState());
                return;
            }
            x2 x2Var2 = this.b;
            if (x2Var2 != null) {
                y1.i(imageViewDrawable, x2Var2, this.a.getDrawableState());
            }
        }
    }

    public final boolean j() {
        int sdk = Build.VERSION.SDK_INT;
        return sdk > 21 ? this.b != null : sdk == 21;
    }

    public final boolean a(Drawable imageSource) {
        if (this.d == null) {
            this.d = new x2();
        }
        x2 info = this.d;
        info.a();
        ColorStateList tintList = cb.a(this.a);
        if (tintList != null) {
            info.d = true;
            info.a = tintList;
        }
        PorterDuff.Mode mode = cb.b(this.a);
        if (mode != null) {
            info.c = true;
            info.b = mode;
        }
        if (info.d || info.c) {
            y1.i(imageSource, info, this.a.getDrawableState());
            return true;
        }
        return false;
    }
}
