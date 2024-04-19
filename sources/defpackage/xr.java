package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import com.xiaopeng.xui.view.XView;
import defpackage.fo;
/* compiled from: SlideLineView.java */
/* renamed from: xr  reason: default package */
/* loaded from: classes.dex */
public class xr extends XView {
    public final int b;
    public final int d;
    public boolean f;
    public ValueAnimator g;
    public float h;
    public int i;
    public Drawable j;
    public int k;
    public ColorStateList l;
    public uq m;

    public xr(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.b = 22;
        this.d = 40;
        this.h = 1.0f;
        this.m = uq.c(this, attrs, defStyleAttr, defStyleRes);
        n(attrs, defStyleRes);
        this.m.e().m(new fo.a() { // from class: sr
            @Override // defpackage.fo.a
            public final void a() {
                xr.this.s();
            }
        });
    }

    public xr(Context context, boolean isSelect, int defStyle) {
        this(context, null, 0, defStyle);
        u(isSelect, false);
    }

    public void x(Drawable drawable) {
        Drawable drawable2 = this.j;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setBounds(0, 0, getWidth(), getHeight());
            if (drawable instanceof aq) {
                aq dr = (aq) drawable;
                dr.a(this.l);
            }
            drawable.setState(getDrawableState());
        }
        this.j = drawable;
        if (drawable != null) {
            invalidateDrawable(drawable);
        }
    }

    public final void r(Context context, AttributeSet attrs, int defaultStyle) {
        TypedArray a2;
        if (attrs != null) {
            a2 = context.obtainStyledAttributes(attrs, bp.q0, 0, defaultStyle);
        } else {
            a2 = context.obtainStyledAttributes(defaultStyle, bp.q0);
        }
        int i = bp.r0;
        if (a2.hasValueOrEmpty(i)) {
            this.i = a2.getResourceId(i, 0);
        }
        int resourceId = a2.getResourceId(bp.s0, 0);
        this.k = resourceId;
        if (resourceId != 0) {
            this.l = m7.c(context, resourceId);
        }
        a2.recycle();
    }

    public final void j() {
        s();
        if (this.g == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 2.0f, 1.0f);
            this.g = ofFloat;
            ofFloat.setDuration(800L);
            this.g.addUpdateListener(new a());
            this.g.setInterpolator(new DecelerateInterpolator());
            this.g.addListener(new b());
        }
        setEnabled(true);
        invalidate();
    }

    /* compiled from: SlideLineView.java */
    /* renamed from: xr$a */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            xr.this.h = ((Float) animation.getAnimatedValue()).floatValue();
            xr.this.j.setLevel((int) (xr.this.h * 100.0f));
            xr.this.invalidate();
        }
    }

    /* compiled from: SlideLineView.java */
    /* renamed from: xr$b */
    /* loaded from: classes.dex */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            xr.this.setActivated(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }
    }

    public void v(int defaultStyle) {
        w(null, defaultStyle);
    }

    public final void w(AttributeSet attrs, int defaultStyle) {
        r(getContext(), attrs, defaultStyle);
        j();
    }

    public final void n(AttributeSet attrs, int defaultStyle) {
        setLayerType(1, null);
        w(attrs, defaultStyle);
    }

    public final void s() {
        Drawable tickMark = null;
        if (this.i != 0) {
            tickMark = m7.d(getContext(), this.i);
        }
        if (this.k != 0) {
            this.l = m7.c(getContext(), this.k);
        }
        x(tickMark);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] state = getDrawableState();
        boolean changed = false;
        Drawable drawable = this.j;
        if (drawable != null && drawable.isStateful()) {
            changed = false | this.j.setState(state);
        }
        if (changed) {
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        Drawable drawable = this.j;
        return (drawable != null && who == drawable) || super.verifyDrawable(who);
    }

    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        uq uqVar = this.m;
        if (uqVar != null) {
            uqVar.g(newConfig);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(22, 40);
    }

    public void t(boolean isSelect) {
        u(isSelect, true);
    }

    public void u(boolean isSelect, boolean animate) {
        setSelected(isSelect);
        this.f = isSelect;
        if (!isSelect) {
            setActivated(false);
            this.g.cancel();
        } else if (animate) {
            this.g.start();
            setActivated(true);
        } else {
            setActivated(false);
        }
        invalidate();
    }

    public boolean o() {
        return this.f;
    }

    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uq uqVar = this.m;
        if (uqVar != null) {
            uqVar.f();
        }
    }

    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uq uqVar = this.m;
        if (uqVar != null) {
            uqVar.h();
        }
    }
}
