package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
/* compiled from: AppCompatBackgroundHelper.java */
/* renamed from: w1  reason: default package */
/* loaded from: classes.dex */
public class w1 {
    public final View a;
    public x2 d;
    public x2 e;
    public x2 f;
    public int c = -1;
    public final y1 b = y1.b();

    public w1(View view) {
        this.a = view;
    }

    public void e(AttributeSet attrs, int defStyleAttr) {
        Context context = this.a.getContext();
        int[] iArr = w.D3;
        z2 a = z2.u(context, attrs, iArr, defStyleAttr, 0);
        View view = this.a;
        ga.X(view, view.getContext(), iArr, attrs, a.q(), defStyleAttr, 0);
        try {
            int i = w.E3;
            if (a.r(i)) {
                this.c = a.m(i, -1);
                ColorStateList tint = this.b.f(this.a.getContext(), this.c);
                if (tint != null) {
                    h(tint);
                }
            }
            int i2 = w.F3;
            if (a.r(i2)) {
                ga.b0(this.a, a.c(i2));
            }
            int i3 = w.G3;
            if (a.r(i3)) {
                ga.c0(this.a, k2.e(a.j(i3, -1), null));
            }
        } finally {
            a.v();
        }
    }

    public void g(int resId) {
        ColorStateList colorStateList;
        this.c = resId;
        y1 y1Var = this.b;
        if (y1Var != null) {
            colorStateList = y1Var.f(this.a.getContext(), resId);
        } else {
            colorStateList = null;
        }
        h(colorStateList);
        b();
    }

    public void f(Drawable background) {
        this.c = -1;
        h(null);
        b();
    }

    public void i(ColorStateList tint) {
        if (this.e == null) {
            this.e = new x2();
        }
        x2 x2Var = this.e;
        x2Var.a = tint;
        x2Var.d = true;
        b();
    }

    public ColorStateList c() {
        x2 x2Var = this.e;
        if (x2Var != null) {
            return x2Var.a;
        }
        return null;
    }

    public void j(PorterDuff.Mode tintMode) {
        if (this.e == null) {
            this.e = new x2();
        }
        x2 x2Var = this.e;
        x2Var.b = tintMode;
        x2Var.c = true;
        b();
    }

    public PorterDuff.Mode d() {
        x2 x2Var = this.e;
        if (x2Var != null) {
            return x2Var.b;
        }
        return null;
    }

    public void b() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            x2 x2Var = this.e;
            if (x2Var != null) {
                y1.i(background, x2Var, this.a.getDrawableState());
                return;
            }
            x2 x2Var2 = this.d;
            if (x2Var2 != null) {
                y1.i(background, x2Var2, this.a.getDrawableState());
            }
        }
    }

    public void h(ColorStateList tint) {
        if (tint != null) {
            if (this.d == null) {
                this.d = new x2();
            }
            x2 x2Var = this.d;
            x2Var.a = tint;
            x2Var.d = true;
        } else {
            this.d = null;
        }
        b();
    }

    public final boolean k() {
        int sdk = Build.VERSION.SDK_INT;
        return sdk > 21 ? this.d != null : sdk == 21;
    }

    public final boolean a(Drawable background) {
        if (this.f == null) {
            this.f = new x2();
        }
        x2 info = this.f;
        info.a();
        ColorStateList tintList = ga.n(this.a);
        if (tintList != null) {
            info.d = true;
            info.a = tintList;
        }
        PorterDuff.Mode mode = ga.o(this.a);
        if (mode != null) {
            info.c = true;
            info.b = mode;
        }
        if (info.d || info.c) {
            y1.i(background, info, this.a.getDrawableState());
            return true;
        }
        return false;
    }
}
