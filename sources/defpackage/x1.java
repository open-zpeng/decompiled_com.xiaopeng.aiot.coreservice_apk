package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
/* compiled from: AppCompatCompoundButtonHelper.java */
/* renamed from: x1  reason: default package */
/* loaded from: classes.dex */
public class x1 {
    public final CompoundButton a;
    public ColorStateList b = null;
    public PorterDuff.Mode c = null;
    public boolean d = false;
    public boolean e = false;
    public boolean f;

    public x1(CompoundButton view) {
        this.a = view;
    }

    public void e(AttributeSet attrs, int defStyleAttr) {
        int resourceId;
        int resourceId2;
        Context context = this.a.getContext();
        int[] iArr = w.R0;
        z2 a = z2.u(context, attrs, iArr, defStyleAttr, 0);
        CompoundButton compoundButton = this.a;
        ga.X(compoundButton, compoundButton.getContext(), iArr, attrs, a.q(), defStyleAttr, 0);
        boolean buttonDrawableLoaded = false;
        try {
            int i = w.T0;
            if (a.r(i) && (resourceId2 = a.m(i, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.a;
                    compoundButton2.setButtonDrawable(j0.d(compoundButton2.getContext(), resourceId2));
                    buttonDrawableLoaded = true;
                } catch (Resources.NotFoundException e) {
                }
            }
            if (!buttonDrawableLoaded) {
                int i2 = w.S0;
                if (a.r(i2) && (resourceId = a.m(i2, 0)) != 0) {
                    CompoundButton compoundButton3 = this.a;
                    compoundButton3.setButtonDrawable(j0.d(compoundButton3.getContext(), resourceId));
                }
            }
            int resourceId3 = w.U0;
            if (a.r(resourceId3)) {
                ab.b(this.a, a.c(resourceId3));
            }
            int i3 = w.V0;
            if (a.r(i3)) {
                ab.c(this.a, k2.e(a.j(i3, -1), null));
            }
        } finally {
            a.v();
        }
    }

    public void g(ColorStateList tint) {
        this.b = tint;
        this.d = true;
        a();
    }

    public ColorStateList c() {
        return this.b;
    }

    public void h(PorterDuff.Mode tintMode) {
        this.c = tintMode;
        this.e = true;
        a();
    }

    public PorterDuff.Mode d() {
        return this.c;
    }

    public void f() {
        if (this.f) {
            this.f = false;
            return;
        }
        this.f = true;
        a();
    }

    public void a() {
        Drawable buttonDrawable = ab.a(this.a);
        if (buttonDrawable != null) {
            if (this.d || this.e) {
                Drawable buttonDrawable2 = i8.q(buttonDrawable).mutate();
                if (this.d) {
                    i8.n(buttonDrawable2, this.b);
                }
                if (this.e) {
                    i8.o(buttonDrawable2, this.c);
                }
                if (buttonDrawable2.isStateful()) {
                    buttonDrawable2.setState(this.a.getDrawableState());
                }
                this.a.setButtonDrawable(buttonDrawable2);
            }
        }
    }

    public int b(int superValue) {
        Drawable buttonDrawable;
        if (Build.VERSION.SDK_INT < 17 && (buttonDrawable = ab.a(this.a)) != null) {
            return superValue + buttonDrawable.getIntrinsicWidth();
        }
        return superValue;
    }
}
