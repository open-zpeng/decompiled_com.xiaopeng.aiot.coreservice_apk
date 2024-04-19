package xiaopeng.widget;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
/* loaded from: classes.dex */
public class SimpleSlider extends View {
    public int a;
    public int b;
    public int d;
    public boolean f;
    public boolean g;
    public float h;
    public Drawable i;
    public Drawable j;
    public boolean k;
    public float l;
    public boolean m;
    public int n;
    public b o;
    public a p;
    public float q;
    public boolean r;

    /* loaded from: classes.dex */
    public interface a {
        void a(SimpleSlider simpleSlider, int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(SimpleSlider simpleSlider, MotionEvent motionEvent);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setEnabled(this.r);
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float x, float y) {
        super.drawableHotspotChanged(x, y);
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.setHotspot(x, y);
        }
    }

    public int getScaledTouchSlop() {
        return this.n;
    }

    public void setTouchEventHandler(b touchEventHandler) {
        this.o = touchEventHandler;
    }

    public int getMin() {
        return this.b;
    }

    public void setMin(int minProgress) {
        boolean z = this.f;
        if (z && minProgress > this.d) {
            minProgress = this.d;
        }
        this.g = true;
        if (z && minProgress != this.b) {
            this.b = minProgress;
            postInvalidate();
            if (this.a < minProgress) {
                this.a = minProgress;
            }
            setProgress(this.a);
            return;
        }
        this.b = minProgress;
    }

    public int getMax() {
        return this.d;
    }

    public void setMax(int maxProgress) {
        boolean z = this.g;
        if (z && maxProgress < this.b) {
            maxProgress = this.b;
        }
        this.f = true;
        if (z && maxProgress != this.d) {
            this.d = maxProgress;
            postInvalidate();
            if (this.a > maxProgress) {
                this.a = maxProgress;
            }
            setProgress(this.a);
            return;
        }
        this.d = maxProgress;
    }

    public int getRange() {
        return this.d - this.b;
    }

    public int getProgress() {
        return this.a;
    }

    public void setOnSlideChangeListener(a onSlideChangeListener) {
        this.p = onSlideChangeListener;
    }

    public void setProgress(int progress) {
        c(progress, false);
    }

    public final void c(int progress, boolean fromUser) {
        int progress2 = b(progress);
        this.a = progress2;
        int i = this.d;
        int i2 = this.b;
        int range = i - i2;
        float scale = range > 0 ? (progress2 - i2) / range : 0.0f;
        setVisualProgress(scale);
        a aVar = this.p;
        if (aVar != null) {
            aVar.a(this, progress2, fromUser);
        }
    }

    public float getSlideScale() {
        return this.h;
    }

    public void setSlideScale(float slideScale) {
        this.h = slideScale;
    }

    public void setProgressDrawable(Drawable d) {
        Drawable drawable = this.i;
        if (drawable != d) {
            if (drawable != null) {
                drawable.setCallback(null);
                unscheduleDrawable(this.i);
            }
            this.i = d;
            if (d != null) {
                d.setCallback(this);
                d.setLayoutDirection(getLayoutDirection());
                if (d.isStateful()) {
                    d.setState(getDrawableState());
                }
                d(getWidth(), getHeight());
                e();
            }
        }
    }

    public void setTickMark(Drawable tickMark) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.j = tickMark;
        if (tickMark != null) {
            tickMark.setCallback(this);
            tickMark.setLayoutDirection(getLayoutDirection());
            if (tickMark.isStateful()) {
                tickMark.setState(getDrawableState());
            }
        }
        invalidate();
    }

    public Drawable getTickMark() {
        return this.j;
    }

    public final void d(int w, int h) {
        int w2 = w - (getPaddingRight() + getPaddingLeft());
        int h2 = h - (getPaddingTop() + getPaddingBottom());
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.setBounds(0, 0, w2, h2);
        }
    }

    public final void e() {
        int[] state = getDrawableState();
        boolean changed = false;
        Drawable sliderDrawable = this.i;
        if (sliderDrawable != null && sliderDrawable.isStateful()) {
            changed = sliderDrawable.setState(state);
        }
        if (changed) {
            invalidate();
        }
    }

    public void setVisualProgress(float progress) {
        Drawable d = this.i;
        if ((d instanceof LayerDrawable) && (d = ((LayerDrawable) d).findDrawableByLayerId(16908301)) == null) {
            d = this.i;
        }
        if (d != null) {
            int level = (int) (10000.0f * progress);
            d.setLevel(level);
            return;
        }
        invalidate();
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.setAlpha(isEnabled() ? 255 : (int) (this.q * 255.0f));
        }
        Drawable drawable2 = this.j;
        if (drawable2 != null) {
            drawable2.setAlpha(isEnabled() ? 255 : (int) (this.q * 255.0f));
        }
        super.drawableStateChanged();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        return who == this.i || super.verifyDrawable(who);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (isEnabled()) {
            int action = ev.getActionMasked();
            switch (action) {
                case 0:
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    setPressed(false);
                    break;
            }
            return super.dispatchTouchEvent(ev);
        }
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        b bVar = this.o;
        if (bVar != null) {
            return bVar.a(this, event);
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        d(w, h);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        a(canvas);
    }

    public void a(Canvas canvas) {
        int count;
        boolean z;
        Drawable tickMark = getTickMark();
        if (tickMark != null && (count = getMax() - getMin()) > 1) {
            int w = tickMark.getIntrinsicWidth();
            int h = tickMark.getIntrinsicHeight();
            int halfW = w >= 0 ? w / 2 : 1;
            int halfH = h >= 0 ? h / 2 : 1;
            tickMark.setBounds(-halfW, -halfH, halfW, halfH);
            float spacing = (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.l * 2.0f)) / count;
            int saveCount = canvas.save();
            canvas.translate(getPaddingLeft(), getHeight() >> 1);
            canvas.translate(this.l + spacing, 0.0f);
            for (int i = 1; i < count && (this.k || ((!(z = this.m) || i <= this.a) && (z || i < this.a))); i++) {
                tickMark.draw(canvas);
                canvas.translate(spacing, 0.0f);
            }
            canvas.restoreToCount(saveCount);
        }
    }

    public final int b(int progress) {
        int min = this.b;
        int max = this.d;
        return Math.min(max, Math.max(progress, min));
    }

    public boolean isInScrollingContainer() {
        for (ViewParent p = getParent(); p != null && (p instanceof ViewGroup); p = p.getParent()) {
            if (((ViewGroup) p).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }
}
