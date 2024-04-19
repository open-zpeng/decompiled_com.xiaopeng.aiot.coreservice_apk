package com.xiaopeng.xui.widget.slider;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.lzy.okgo.model.Priority;
import com.xiaopeng.xui.widget.XViewGroup;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class AbsSlider extends XViewGroup {
    public int A;
    public boolean B;
    public float C;
    public float D;
    public boolean E;
    public float F;
    public wr G;
    public float H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public Drawable N;
    public int O;
    public Drawable P;
    public final int b;
    public final float d;
    public int f;
    public String g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public float m;
    public float n;
    public float o;
    public DecimalFormat p;
    public float q;
    public float r;
    public float s;
    public String t;
    public boolean u;
    public int v;
    public float w;
    public boolean x;
    public int y;
    public Drawable z;

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiAction() {
        return super.getVuiAction();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiBizId() {
        return super.getVuiBizId();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
        return super.getVuiDisableHitEffect();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
        return super.getVuiElementChangedListener();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiElementId() {
        return super.getVuiElementId();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ oo getVuiElementType() {
        return super.getVuiElementType();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
        return super.getVuiFatherElementId();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
        return super.getVuiFatherLabel();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
        return super.getVuiFeedbackType();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiLabel() {
        return super.getVuiLabel();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ qo getVuiMode() {
        return super.getVuiMode();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ int getVuiPosition() {
        return super.getVuiPosition();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ ro getVuiPriority() {
        return super.getVuiPriority();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
        return super.getVuiProps();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ Object getVuiValue() {
        return super.getVuiValue();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
        super.setPerformVuiAction(z);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiAction(String str) {
        super.setVuiAction(str);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
        super.setVuiBizId(str);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
        super.setVuiDisableHitEffect(z);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
        super.setVuiElementChangedListener(koVar);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
        super.setVuiElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
        super.setVuiElementType(ooVar);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
        super.setVuiFatherElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
        super.setVuiFatherLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
        super.setVuiFeedbackType(poVar);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
        super.setVuiLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
        super.setVuiLayoutLoadable(z);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
        super.setVuiMode(qoVar);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
        super.setVuiPosition(i);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
        super.setVuiPriority(roVar);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
        super.setVuiProps(jSONObject);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
        super.setVuiValue(obj);
    }

    public AbsSlider(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AbsSlider(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public AbsSlider(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.b = 92;
        this.d = 644.0f;
        this.f = 40;
        this.i = -1;
        this.l = Priority.BG_LOW;
        this.m = 32.0f;
        this.n = 32.0f / 2.0f;
        this.s = 1.0f;
        this.x = false;
        this.A = 1;
        this.B = false;
        this.H = 100.0f;
        this.I = 30;
        this.K = 0;
        this.L = ap.XSliderLine;
        setWillNotDraw(false);
        h(context, attrs, defStyleAttr, defStyleRes);
        if (!isInEditMode()) {
            this.u = mq.a(getContext());
        }
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (!isInEditMode()) {
            this.u = mq.a(getContext());
            if (mq.d(newConfig)) {
                wr wrVar = this.G;
                if (wrVar != null) {
                    wrVar.b(getResources(), getContext().getTheme());
                }
                Drawable thumb = null;
                if (this.y != 0) {
                    thumb = m7.d(getContext(), this.y);
                }
                setThumb(thumb);
                if (this.M != 0) {
                    Drawable bg = m7.d(getContext(), this.M);
                    setSliderBackground(bg);
                }
                Drawable pg = null;
                if (this.O != 0) {
                    pg = m7.d(getContext(), this.O);
                }
                setSliderProgress(pg);
            }
        }
        invalidate();
    }

    public final void h(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.F = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, bp.B2, defStyleAttr, defStyleRes);
        this.g = attributes.getString(bp.V2);
        this.h = attributes.getInteger(bp.M2, 0);
        this.A = attributes.getInteger(bp.N2, 1);
        this.i = attributes.getInteger(bp.I2, -1);
        this.j = attributes.getInteger(bp.F2, 100);
        this.l = attributes.getInteger(bp.X2, Priority.BG_LOW);
        this.k = attributes.getInteger(bp.H2, 0);
        this.t = attributes.getString(bp.W2);
        this.s = attributes.getFloat(bp.C2, 0.0f);
        attributes.recycle();
        if (this.i == -1) {
            this.i = Math.min(this.h, this.j);
        }
        int i = this.i;
        int i2 = this.h;
        this.q = i - i2;
        if (this.j == i2) {
            throw new RuntimeException("startIndex = endIndex!!! please check the xml");
        }
        int i3 = this.k;
        DecimalFormat decimalFormat = i3 == 0 ? null : i3 == 1 ? new DecimalFormat("0.0") : new DecimalFormat("0.00");
        this.p = decimalFormat;
        if (decimalFormat != null) {
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
        }
        if (this.s == 0.0f) {
            int i4 = this.k;
            this.s = i4 == 0 ? 1.0f : i4 == 1 ? 0.1f : 0.01f;
        }
        o(attrs, defStyleRes);
    }

    public void setStyle(int styleRes) {
        o(null, styleRes);
    }

    public final void o(AttributeSet attrs, int styleRes) {
        n(attrs, styleRes);
        d();
        if (!this.B) {
            wr wrVar = new wr();
            this.G = wrVar;
            wrVar.a(getResources(), getContext().getTheme(), attrs, styleRes);
            this.G.setState(getDrawableState());
            this.G.setCallback(this);
            this.G.e(f(), getPopString(), getSliderLength());
        }
    }

    public final void n(AttributeSet attrs, int styleRes) {
        TypedArray attributes;
        Drawable bg;
        if (attrs != null) {
            attributes = getContext().obtainStyledAttributes(attrs, bp.B2, 0, styleRes);
        } else {
            attributes = getContext().obtainStyledAttributes(styleRes, bp.B2);
        }
        int i = bp.D2;
        if (attributes.hasValueOrEmpty(i)) {
            this.M = attributes.getResourceId(i, 0);
        }
        if (this.M != 0) {
            bg = m7.d(getContext(), this.M);
        } else {
            int color = attributes.getColor(i, -30720);
            Drawable bg2 = new ColorDrawable(color);
            bg = bg2;
        }
        setSliderBackground(bg);
        int i2 = bp.L2;
        if (attributes.hasValueOrEmpty(i2)) {
            this.O = attributes.getResourceId(i2, 0);
        }
        Drawable pg = null;
        if (this.O != 0) {
            pg = m7.d(getContext(), this.O);
        }
        setSliderProgress(pg);
        int i3 = bp.G2;
        if (attributes.hasValueOrEmpty(i3)) {
            this.B = attributes.getBoolean(i3, false);
        }
        int i4 = bp.E2;
        if (attributes.hasValueOrEmpty(i4)) {
            this.x = attributes.getBoolean(i4, false);
        }
        int i5 = bp.J2;
        if (attributes.hasValueOrEmpty(i5)) {
            this.I = attributes.getInteger(i5, 30);
        }
        int i6 = bp.K2;
        if (attributes.hasValueOrEmpty(i6)) {
            this.K = attributes.getInt(i6, 0);
        }
        int i7 = bp.T2;
        if (attributes.hasValueOrEmpty(i7)) {
            this.y = attributes.getResourceId(i7, 0);
        }
        Drawable thumb = null;
        if (this.y != 0) {
            thumb = m7.d(getContext(), this.y);
        }
        setThumb(thumb);
        int i8 = bp.U2;
        if (attributes.hasValueOrEmpty(i8)) {
            this.L = attributes.getResourceId(i8, ap.XSliderLine);
        }
        attributes.recycle();
    }

    public final void d() {
        if (this.I < 3) {
            this.I = 3;
        }
        if (this.x) {
            this.B = true;
            this.H = 32.0f;
        }
        if (!this.B) {
            this.J = 40;
        } else {
            this.J = 0;
        }
        if (this.K == 1) {
            setMinimumWidth(0);
            setMinimumHeight(80);
        } else {
            setMinimumWidth(80);
            setMinimumHeight(0);
        }
        super.setBackground(null);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child instanceof xr) {
                xr slideLineView = (xr) child;
                slideLineView.v(this.L);
            }
        }
        invalidate();
    }

    public void setSliderBackground(Drawable background) {
        Drawable drawable = this.N;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        if (background != null) {
            background.setCallback(this);
            background.setState(getDrawableState());
        }
        this.N = background;
        setBackgroundBounds();
        Drawable drawable2 = this.N;
        if (drawable2 != null) {
            invalidateDrawable(drawable2);
        }
    }

    public void setSliderProgress(Drawable drawable) {
        Drawable drawable2 = this.P;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
        }
        this.P = drawable;
        if (drawable != null) {
            invalidateDrawable(drawable);
        }
    }

    public void setThumb(Drawable drawable) {
        Drawable drawable2 = this.z;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
        }
        this.z = drawable;
        if (drawable != null) {
            invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width;
        int height;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.K == 1) {
            width = (int) this.H;
            if (View.MeasureSpec.getMode(heightMeasureSpec) != 1073741824) {
                height = 644;
            } else {
                height = getMeasuredHeight();
            }
        } else {
            int width2 = View.MeasureSpec.getMode(widthMeasureSpec);
            if (width2 == Integer.MIN_VALUE) {
                width = 644;
            } else {
                width = getMeasuredWidth();
            }
            height = (int) this.H;
        }
        setMeasuredDimension(width, height);
    }

    private void setBackgroundBounds() {
        int top = (int) ((getHeightExIndicator() / 2.0f) - this.n);
        int right = (int) getWidthExIndicator();
        int bottom = (int) ((getHeightExIndicator() / 2.0f) + this.n);
        Drawable drawable = this.N;
        if (drawable != null) {
            drawable.setBounds(0, top, right, bottom);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int count = canvas.save();
        if (this.K == 1) {
            canvas.translate(0.0f, getHeight());
            canvas.rotate(270.0f);
        }
        Drawable drawable = this.N;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        if (this.P != null) {
            int top = (int) ((getHeightExIndicator() / 2.0f) - this.n);
            int offset = 0;
            Drawable drawable2 = this.z;
            if (drawable2 != null) {
                offset = drawable2.getIntrinsicWidth() / 2;
            }
            int right = (int) (f() + offset + 7.0f);
            int bottom = (int) ((getHeightExIndicator() / 2.0f) + this.n);
            this.P.setBounds(0, top, right, bottom);
            this.P.draw(canvas);
        }
        canvas.restoreToCount(count);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        setPadding(0, 0, 0, 0);
        int i = (this.K == 0 ? w : h) - 32;
        this.v = i;
        this.w = i / (this.I - 1);
        int i2 = this.i;
        int i3 = this.h;
        this.o = (Math.abs((i2 - i3) / (this.j - i3)) * this.v) + 16.0f;
        for (int i4 = 0; i4 < this.I; i4++) {
            xr slideLineView = new xr(getContext(), this.o > (this.w * ((float) i4)) + 16.0f, this.L);
            addView(slideLineView);
        }
        wr wrVar = this.G;
        if (wrVar != null) {
            wrVar.e(f(), getPopString(), getSliderLength());
        }
        setBackgroundBounds();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        float itemGap = (getSliderLength() - 36) / (childCount - 1);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            int left = (int) (((i * itemGap) + 18.0f) - 10.0f);
            int top = (((int) getHeightExIndicator()) / 2) - 20;
            int right = (int) ((i * itemGap) + 18.0f + 10.0f);
            int bottom = (((int) getHeightExIndicator()) / 2) + 20;
            childAt.layout(left, top, right, bottom);
        }
    }

    public void i() {
        invalidate();
        wr wrVar = this.G;
        if (wrVar != null) {
            wrVar.e(f(), getPopString(), getSliderLength());
        }
    }

    public ViewGroup j() {
        for (ViewParent p = getParent(); p instanceof ViewGroup; p = p.getParent()) {
            ViewGroup viewGroup = (ViewGroup) p;
            if (viewGroup.shouldDelayChildPressedState()) {
                return viewGroup;
            }
        }
        return null;
    }

    public void p() {
        if (this.A == 1) {
            return;
        }
        int natureGap = this.v / (this.j - this.h);
        int number = (int) (((this.o - 16.0f) / natureGap) + 0.5d);
        this.o = (number * natureGap) + 16;
    }

    public float getIndicatorValue() {
        return (this.q + this.h) * this.A;
    }

    public void setAccuracy(float accuracy) {
        this.s = accuracy;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        wr wrVar;
        Drawable drawable = this.z;
        return (drawable != null && who == drawable) || ((wrVar = this.G) != null && who == wrVar) || super.verifyDrawable(who);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] states = getDrawableState();
        Drawable drawable = this.G;
        if (drawable != null && drawable.isStateful() && drawable.setState(states)) {
            invalidateDrawable(drawable);
        }
        Drawable drawable2 = this.z;
        if (drawable2 != null && drawable2.isStateful() && this.z.setState(states)) {
            invalidateDrawable(this.z);
        }
        Drawable drawable3 = this.N;
        if (drawable3 != null && drawable3.isStateful() && this.N.setState(states)) {
            invalidateDrawable(this.N);
        }
        Drawable drawable4 = this.P;
        if (drawable4 != null && drawable4.isStateful() && this.P.setState(states)) {
            invalidateDrawable(this.P);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int count = canvas.save();
        if (this.K == 1) {
            canvas.translate(0.0f, getHeight());
            canvas.rotate(270.0f);
        }
        super.dispatchDraw(canvas);
        float currentLocation = f();
        if (currentLocation == 0.0f) {
            return;
        }
        float barCenterY = getHeightExIndicator() / 2.0f;
        wr wrVar = this.G;
        if (wrVar != null) {
            wrVar.draw(canvas);
        }
        if (!isEnabled()) {
            return;
        }
        Drawable drawable = this.z;
        if (drawable != null) {
            float halfThumbHeight = drawable.getIntrinsicHeight() / 2.0f;
            float halfThumbWidth = this.z.getIntrinsicWidth() / 2.0f;
            float left = currentLocation - halfThumbWidth;
            float top = barCenterY - halfThumbHeight;
            Drawable drawable2 = this.z;
            drawable2.setBounds((int) left, (int) top, (int) (drawable2.getIntrinsicWidth() + left), (int) (this.z.getIntrinsicHeight() + top));
            this.z.draw(canvas);
        }
        canvas.restoreToCount(count);
    }

    public int getOrientation() {
        return this.K;
    }

    public float getHeightExIndicator() {
        return getSliderThickness() + this.J;
    }

    public float getWidthExIndicator() {
        return getSliderLength();
    }

    public int getSliderLength() {
        return this.K == 1 ? getHeight() : getWidth();
    }

    public int getSliderThickness() {
        return this.K == 1 ? getWidth() : getHeight();
    }

    public float getProgressViewLength() {
        return this.o;
    }

    public float f() {
        if (this.o < 16.0f) {
            return 16.0f;
        }
        float maxValue = (getSliderLength() - 16) - r();
        float f = this.o;
        if (f > maxValue) {
            return maxValue;
        }
        return f;
    }

    public final int r() {
        int i;
        int i2;
        int i3 = this.l;
        if (i3 != Integer.MIN_VALUE && (i = this.h) < (i2 = this.j) && i <= i3 && i3 <= i2) {
            return ((i2 - i3) * this.v) / (i2 - i);
        }
        return 0;
    }

    public String getPopString() {
        if (this.g == null) {
            this.g = "";
        }
        if (this.t == null) {
            this.t = "";
        }
        if (this.p == null) {
            if (this.A == 1) {
                return this.t + (this.h + ((int) this.q)) + this.g;
            }
            return this.t + ((this.h + ((int) (this.q + 0.5d))) * this.A) + this.g;
        }
        return this.t + this.p.format((this.h + this.q) * this.A) + this.g;
    }

    public void setAlphaByEnable(boolean enable) {
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.u = mq.a(getContext());
        }
    }
}
