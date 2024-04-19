package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
/* compiled from: RoundRectDrawableWithShadow.java */
/* renamed from: s3  reason: default package */
/* loaded from: classes.dex */
public class s3 extends Drawable {
    public static final double a = Math.cos(Math.toRadians(45.0d));
    public static a b;
    public final int c;
    public Paint d;
    public Paint e;
    public Paint f;
    public final RectF g;
    public float h;
    public Path i;
    public float j;
    public float k;
    public float l;
    public ColorStateList m;
    public boolean n;
    public final int o;
    public final int p;
    public boolean q;
    public boolean r;

    /* compiled from: RoundRectDrawableWithShadow.java */
    /* renamed from: s3$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public final void n(ColorStateList color) {
        ColorStateList valueOf = color == null ? ColorStateList.valueOf(0) : color;
        this.m = valueOf;
        this.d.setColor(valueOf.getColorForState(getState(), this.m.getDefaultColor()));
    }

    public final int t(float value) {
        int i = (int) (0.5f + value);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    public void m(boolean addPaddingForCorners) {
        this.q = addPaddingForCorners;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.d.setAlpha(alpha);
        this.e.setAlpha(alpha);
        this.f.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.n = true;
    }

    public final void s(float shadowSize, float maxShadowSize) {
        if (shadowSize < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + shadowSize + ". Must be >= 0");
        } else if (maxShadowSize < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + maxShadowSize + ". Must be >= 0");
        } else {
            float shadowSize2 = t(shadowSize);
            float maxShadowSize2 = t(maxShadowSize);
            if (shadowSize2 > maxShadowSize2) {
                shadowSize2 = maxShadowSize2;
                if (!this.r) {
                    this.r = true;
                }
            }
            if (this.l == shadowSize2 && this.j == maxShadowSize2) {
                return;
            }
            this.l = shadowSize2;
            this.j = maxShadowSize2;
            this.k = (int) ((1.5f * shadowSize2) + this.c + 0.5f);
            this.n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        int vOffset = (int) Math.ceil(d(this.j, this.h, this.q));
        int hOffset = (int) Math.ceil(c(this.j, this.h, this.q));
        padding.set(hOffset, vOffset, hOffset, vOffset);
        return true;
    }

    public static float d(float maxShadowSize, float cornerRadius, boolean addPaddingForCorners) {
        if (addPaddingForCorners) {
            return (float) ((1.5f * maxShadowSize) + ((1.0d - a) * cornerRadius));
        }
        return 1.5f * maxShadowSize;
    }

    public static float c(float maxShadowSize, float cornerRadius, boolean addPaddingForCorners) {
        if (addPaddingForCorners) {
            return (float) (maxShadowSize + ((1.0d - a) * cornerRadius));
        }
        return maxShadowSize;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] stateSet) {
        ColorStateList colorStateList = this.m;
        int newColor = colorStateList.getColorForState(stateSet, colorStateList.getDefaultColor());
        if (this.d.getColor() == newColor) {
            return false;
        }
        this.d.setColor(newColor);
        this.n = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.m;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        this.d.setColorFilter(cf);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void p(float radius) {
        if (radius < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + radius + ". Must be >= 0");
        }
        float radius2 = (int) (0.5f + radius);
        if (this.h == radius2) {
            return;
        }
        this.h = radius2;
        this.n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            a(getBounds());
            this.n = false;
        }
        canvas.translate(0.0f, this.l / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.l) / 2.0f);
        b.a(canvas, this.g, this.h, this.d);
    }

    public final void e(Canvas canvas) {
        float f = this.h;
        float edgeShadowTop = (-f) - this.k;
        float inset = f + this.c + (this.l / 2.0f);
        boolean drawHorizontalEdges = this.g.width() - (inset * 2.0f) > 0.0f;
        boolean drawVerticalEdges = this.g.height() - (inset * 2.0f) > 0.0f;
        int saved = canvas.save();
        RectF rectF = this.g;
        canvas.translate(rectF.left + inset, rectF.top + inset);
        canvas.drawPath(this.i, this.e);
        if (drawHorizontalEdges) {
            canvas.drawRect(0.0f, edgeShadowTop, this.g.width() - (inset * 2.0f), -this.h, this.f);
        }
        canvas.restoreToCount(saved);
        int saved2 = canvas.save();
        RectF rectF2 = this.g;
        canvas.translate(rectF2.right - inset, rectF2.bottom - inset);
        canvas.rotate(180.0f);
        canvas.drawPath(this.i, this.e);
        if (drawHorizontalEdges) {
            canvas.drawRect(0.0f, edgeShadowTop, this.g.width() - (inset * 2.0f), (-this.h) + this.k, this.f);
        }
        canvas.restoreToCount(saved2);
        int saved3 = canvas.save();
        RectF rectF3 = this.g;
        canvas.translate(rectF3.left + inset, rectF3.bottom - inset);
        canvas.rotate(270.0f);
        canvas.drawPath(this.i, this.e);
        if (drawVerticalEdges) {
            canvas.drawRect(0.0f, edgeShadowTop, this.g.height() - (inset * 2.0f), -this.h, this.f);
        }
        canvas.restoreToCount(saved3);
        int saved4 = canvas.save();
        RectF rectF4 = this.g;
        canvas.translate(rectF4.right - inset, rectF4.top + inset);
        canvas.rotate(90.0f);
        canvas.drawPath(this.i, this.e);
        if (drawVerticalEdges) {
            canvas.drawRect(0.0f, edgeShadowTop, this.g.height() - (2.0f * inset), -this.h, this.f);
        }
        canvas.restoreToCount(saved4);
    }

    public final void b() {
        float f = this.h;
        RectF innerBounds = new RectF(-f, -f, f, f);
        RectF outerBounds = new RectF(innerBounds);
        float f2 = this.k;
        outerBounds.inset(-f2, -f2);
        Path path = this.i;
        if (path == null) {
            this.i = new Path();
        } else {
            path.reset();
        }
        this.i.setFillType(Path.FillType.EVEN_ODD);
        this.i.moveTo(-this.h, 0.0f);
        this.i.rLineTo(-this.k, 0.0f);
        this.i.arcTo(outerBounds, 180.0f, 90.0f, false);
        this.i.arcTo(innerBounds, 270.0f, -90.0f, false);
        this.i.close();
        float f3 = this.h;
        float f4 = this.k;
        float startRatio = f3 / (f3 + f4);
        Paint paint = this.e;
        float f5 = f3 + f4;
        int i = this.o;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.p}, new float[]{0.0f, startRatio, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f;
        float f6 = this.h;
        float f7 = this.k;
        float f8 = (-f6) - f7;
        int i2 = this.o;
        paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, f8, new int[]{i2, i2, this.p}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f.setAntiAlias(false);
    }

    public final void a(Rect bounds) {
        float f = this.j;
        float verticalOffset = 1.5f * f;
        this.g.set(bounds.left + f, bounds.top + verticalOffset, bounds.right - f, bounds.bottom - verticalOffset);
        b();
    }

    public float g() {
        return this.h;
    }

    public void h(Rect into) {
        getPadding(into);
    }

    public void r(float size) {
        s(size, this.j);
    }

    public void q(float size) {
        s(this.l, size);
    }

    public float l() {
        return this.l;
    }

    public float i() {
        return this.j;
    }

    public float k() {
        float f = this.j;
        float content = Math.max(f, this.h + this.c + (f / 2.0f)) * 2.0f;
        return ((this.j + this.c) * 2.0f) + content;
    }

    public float j() {
        float f = this.j;
        float content = Math.max(f, this.h + this.c + ((f * 1.5f) / 2.0f)) * 2.0f;
        return (((this.j * 1.5f) + this.c) * 2.0f) + content;
    }

    public void o(ColorStateList color) {
        n(color);
        invalidateSelf();
    }

    public ColorStateList f() {
        return this.m;
    }
}
