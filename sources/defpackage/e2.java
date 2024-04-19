package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
/* compiled from: AppCompatSeekBarHelper.java */
/* renamed from: e2  reason: default package */
/* loaded from: classes.dex */
public class e2 extends c2 {
    public final SeekBar d;
    public Drawable e;
    public ColorStateList f;
    public PorterDuff.Mode g;
    public boolean h;
    public boolean i;

    public e2(SeekBar view) {
        super(view);
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = false;
        this.d = view;
    }

    @Override // defpackage.c2
    public void c(AttributeSet attrs, int defStyleAttr) {
        super.c(attrs, defStyleAttr);
        Context context = this.d.getContext();
        int[] iArr = w.V;
        z2 a = z2.u(context, attrs, iArr, defStyleAttr, 0);
        SeekBar seekBar = this.d;
        ga.X(seekBar, seekBar.getContext(), iArr, attrs, a.q(), defStyleAttr, 0);
        Drawable drawable = a.g(w.W);
        if (drawable != null) {
            this.d.setThumb(drawable);
        }
        Drawable tickMark = a.f(w.X);
        j(tickMark);
        int i = w.Z;
        if (a.r(i)) {
            this.g = k2.e(a.j(i, -1), this.g);
            this.i = true;
        }
        int i2 = w.Y;
        if (a.r(i2)) {
            this.f = a.c(i2);
            this.h = true;
        }
        a.v();
        f();
    }

    public void j(Drawable tickMark) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.e = tickMark;
        if (tickMark != null) {
            tickMark.setCallback(this.d);
            i8.l(tickMark, ga.v(this.d));
            if (tickMark.isStateful()) {
                tickMark.setState(this.d.getDrawableState());
            }
            f();
        }
        this.d.invalidate();
    }

    public final void f() {
        Drawable drawable = this.e;
        if (drawable != null) {
            if (this.h || this.i) {
                Drawable q = i8.q(drawable.mutate());
                this.e = q;
                if (this.h) {
                    i8.n(q, this.f);
                }
                if (this.i) {
                    i8.o(this.e, this.g);
                }
                if (this.e.isStateful()) {
                    this.e.setState(this.d.getDrawableState());
                }
            }
        }
    }

    public void i() {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void h() {
        Drawable tickMark = this.e;
        if (tickMark != null && tickMark.isStateful() && tickMark.setState(this.d.getDrawableState())) {
            this.d.invalidateDrawable(tickMark);
        }
    }

    public void g(Canvas canvas) {
        if (this.e != null) {
            int count = this.d.getMax();
            if (count > 1) {
                int w = this.e.getIntrinsicWidth();
                int h = this.e.getIntrinsicHeight();
                int halfW = w >= 0 ? w / 2 : 1;
                int halfH = h >= 0 ? h / 2 : 1;
                this.e.setBounds(-halfW, -halfH, halfW, halfH);
                float spacing = ((this.d.getWidth() - this.d.getPaddingLeft()) - this.d.getPaddingRight()) / count;
                int saveCount = canvas.save();
                canvas.translate(this.d.getPaddingLeft(), this.d.getHeight() / 2);
                for (int i = 0; i <= count; i++) {
                    this.e.draw(canvas);
                    canvas.translate(spacing, 0.0f);
                }
                canvas.restoreToCount(saveCount);
            }
        }
    }
}
