package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* compiled from: RoundRectDrawable.java */
/* renamed from: r3  reason: default package */
/* loaded from: classes.dex */
public class r3 extends Drawable {
    public float a;
    public final Paint b;
    public final RectF c;
    public final Rect d;
    public float e;
    public boolean f;
    public boolean g;
    public ColorStateList h;
    public PorterDuffColorFilter i;
    public ColorStateList j;
    public PorterDuff.Mode k;

    public final void e(ColorStateList color) {
        ColorStateList valueOf = color == null ? ColorStateList.valueOf(0) : color;
        this.h = valueOf;
        this.b.setColor(valueOf.getColorForState(getState(), this.h.getDefaultColor()));
    }

    public void g(float padding, boolean insetForPadding, boolean insetForRadius) {
        if (padding == this.e && this.f == insetForPadding && this.g == insetForRadius) {
            return;
        }
        this.e = padding;
        this.f = insetForPadding;
        this.g = insetForRadius;
        i(null);
        invalidateSelf();
    }

    public float c() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean clearColorFilter;
        Paint paint = this.b;
        if (this.i != null && paint.getColorFilter() == null) {
            paint.setColorFilter(this.i);
            clearColorFilter = true;
        } else {
            clearColorFilter = false;
        }
        RectF rectF = this.c;
        float f = this.a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (clearColorFilter) {
            paint.setColorFilter(null);
        }
    }

    public final void i(Rect bounds) {
        if (bounds == null) {
            bounds = getBounds();
        }
        this.c.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        this.d.set(bounds);
        if (this.f) {
            float vInset = s3.d(this.e, this.a, this.g);
            float hInset = s3.c(this.e, this.a, this.g);
            this.d.inset((int) Math.ceil(hInset), (int) Math.ceil(vInset));
            this.c.set(this.d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        i(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.d, this.a);
    }

    public void h(float radius) {
        if (radius == this.a) {
            return;
        }
        this.a = radius;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.b.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        this.b.setColorFilter(cf);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float d() {
        return this.a;
    }

    public void f(ColorStateList color) {
        e(color);
        invalidateSelf();
    }

    public ColorStateList b() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList tint) {
        this.j = tint;
        this.i = a(tint, this.k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode tintMode) {
        this.k = tintMode;
        this.i = a(this.j, tintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] stateSet) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.h;
        int newColor = colorStateList.getColorForState(stateSet, colorStateList.getDefaultColor());
        boolean colorChanged = newColor != this.b.getColor();
        if (colorChanged) {
            this.b.setColor(newColor);
        }
        ColorStateList colorStateList2 = this.j;
        if (colorStateList2 != null && (mode = this.k) != null) {
            this.i = a(colorStateList2, mode);
            return true;
        }
        return colorChanged;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    public final PorterDuffColorFilter a(ColorStateList tint, PorterDuff.Mode tintMode) {
        if (tint == null || tintMode == null) {
            return null;
        }
        int color = tint.getColorForState(getState(), 0);
        return new PorterDuffColorFilter(color, tintMode);
    }
}
