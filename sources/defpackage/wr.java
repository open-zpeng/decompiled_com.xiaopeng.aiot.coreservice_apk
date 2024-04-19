package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
/* compiled from: IndicatorDrawable.java */
/* renamed from: wr  reason: default package */
/* loaded from: classes.dex */
public class wr extends Drawable implements Drawable.Callback {
    public final Paint a;
    public int b;
    public Drawable d;
    public float f;
    public int g;
    public float h;
    public String i;
    public boolean j;
    public int k;
    public int l;
    public final Rect m;

    public wr() {
        Paint paint = new Paint(1);
        this.a = paint;
        this.f = 24.0f;
        this.g = 50;
        this.i = "";
        this.j = true;
        float f = this.h;
        this.m = new Rect((int) (f - 28.0f), 10, (int) (f + 28.0f), 60);
        paint.setTextSize(24.0f);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(this.j ? -1 : 1560281087);
    }

    public void a(Resources resources, Resources.Theme theme, AttributeSet attrs, int defStyleRes) {
        TypedArray ta;
        Rect rect;
        if (attrs != null) {
            ta = theme.obtainStyledAttributes(attrs, bp.B2, 0, defStyleRes);
        } else {
            ta = theme.obtainStyledAttributes(defStyleRes, bp.B2);
        }
        int i = bp.O2;
        if (ta.hasValueOrEmpty(i)) {
            this.b = ta.getResourceId(i, 0);
        }
        int paddingTop = 10;
        int i2 = bp.Q2;
        if (ta.hasValueOrEmpty(i2)) {
            paddingTop = ta.getDimensionPixelSize(i2, 10);
        }
        this.m.top = paddingTop;
        int i3 = bp.P2;
        if (ta.hasValueOrEmpty(i3)) {
            float tagHeight = ta.getDimensionPixelSize(i3, 40);
            this.m.bottom = (int) (rect.top + tagHeight);
        }
        float baselineOffset = this.m.height() / 4.0f;
        int i4 = bp.R2;
        if (ta.hasValueOrEmpty(i4)) {
            baselineOffset = ta.getDimension(i4, baselineOffset);
        }
        Rect rect2 = this.m;
        this.f = rect2.top + (rect2.height() / 2.0f) + baselineOffset;
        int i5 = bp.S2;
        if (ta.hasValueOrEmpty(i5)) {
            this.g = ta.getDimensionPixelSize(i5, 50);
        }
        b(resources, theme);
        setBounds(this.m);
        ta.recycle();
    }

    public void b(Resources resources, Resources.Theme theme) {
        Drawable tagBg = v7.a(resources, this.b, theme);
        rq.a("IndicatorDrawable", "refreshUI, newBg:" + tagBg + ", oldBg:" + this.d);
        d(tagBg);
    }

    public void d(Drawable drawable) {
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
        }
        this.d = drawable;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        String str = this.i;
        Rect rect = this.m;
        canvas.drawText(str, (rect.left + rect.right) / 2.0f, this.f, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.d;
        return drawable != null && drawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] state) {
        boolean changed = false;
        boolean isEnabled = false;
        int length = state.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int s = state[i];
            if (s != 16842910) {
                i++;
            } else {
                isEnabled = true;
                break;
            }
        }
        if (this.j != isEnabled) {
            this.j = isEnabled;
            this.a.setColor(isEnabled ? -1 : 1560281087);
            rq.a("IndicatorDrawable", "onStateChange, isEnabled:" + isEnabled);
            changed = true;
        }
        Drawable drawable = this.d;
        if (drawable != null && drawable.isStateful()) {
            return changed | this.d.setState(state);
        }
        return changed;
    }

    public void e(float center, String text, int slideWidth) {
        this.i = text;
        this.h = center;
        this.k = (int) this.a.measureText(text);
        this.l = slideWidth;
        c();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public final void c() {
        int specifyWidth = Math.max(this.k + this.g, 56);
        float f = this.h;
        float offsetStart = f - (specifyWidth / 2.0f);
        int i = this.l;
        float offsetEnd = (i - f) - (specifyWidth / 2.0f);
        if (offsetStart < 0.0f) {
            Rect rect = this.m;
            rect.left = 0;
            rect.right = specifyWidth;
        } else if (offsetEnd < 0.0f) {
            Rect rect2 = this.m;
            rect2.left = i - specifyWidth;
            rect2.right = i;
        } else {
            Rect rect3 = this.m;
            rect3.left = (int) (f - (specifyWidth / 2));
            rect3.right = (int) (f + (specifyWidth / 2));
        }
        setBounds(this.m);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable who, Runnable what) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }
}
