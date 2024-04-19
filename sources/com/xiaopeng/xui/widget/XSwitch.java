package com.xiaopeng.xui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XSwitch extends XCompoundButton implements ValueAnimator.AnimatorUpdateListener {
    public static final String d = XSwitch.class.getSimpleName();
    public float A;
    public Shader A0;
    public float B;
    public int B0;
    public float C;
    public int C0;
    public float D;
    public int D0;
    public float E;
    public int E0;
    public final float F;
    public Shader F0;
    public float G;
    public int G0;
    public float H;
    public int H0;
    public float I;
    public int I0;
    public final float J;
    public int J0;
    public final float K;
    public int K0;
    public final float L;
    public int L0;
    public final float M;
    public int M0;
    public int N;
    public float N0;
    public int O;
    public float O0;
    public int P;
    public float P0;
    public int Q;
    public float Q0;
    public int R;
    public float R0;
    public int S;
    public int S0;
    public int T;
    public ValueAnimator T0;
    public int U;
    public int U0;
    public int V;
    public b V0;
    public int W;
    public boolean W0;
    public int X;
    public ArgbEvaluator X0;
    public int Y;
    public boolean Y0;
    public int Z;
    public boolean Z0;
    public int a0;
    public float a1;
    public int b0;
    public int c0;
    public Shader d0;
    public int e0;
    public Paint f;
    public int f0;
    public Paint g;
    public int g0;
    public float h;
    public int h0;
    public BlurMaskFilter i;
    public int i0;
    public Xfermode j;
    public int j0;
    public float k;
    public int k0;
    public final float l;
    public int l0;
    public final float m;
    public int m0;
    public float n;
    public int n0;
    public float o;
    public int o0;
    public float p;
    public int p0;
    public final float q;
    public Shader q0;
    public float r;
    public final float r0;
    public float s;
    public final float s0;
    public final float t;
    public float t0;
    public float u;
    public float u0;
    public float v;
    public float v0;
    public float w;
    public float w0;
    public float x;
    public int x0;
    public float y;
    public float y0;
    public final float z;
    public float z0;

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiAction() {
        return super.getVuiAction();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiBizId() {
        return super.getVuiBizId();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
        return super.getVuiDisableHitEffect();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
        return super.getVuiElementChangedListener();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiElementId() {
        return super.getVuiElementId();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ oo getVuiElementType() {
        return super.getVuiElementType();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
        return super.getVuiFatherElementId();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
        return super.getVuiFatherLabel();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
        return super.getVuiFeedbackType();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiLabel() {
        return super.getVuiLabel();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ qo getVuiMode() {
        return super.getVuiMode();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ int getVuiPosition() {
        return super.getVuiPosition();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ ro getVuiPriority() {
        return super.getVuiPriority();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
        return super.getVuiProps();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ Object getVuiValue() {
        return super.getVuiValue();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
        super.setPerformVuiAction(z);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiAction(String str) {
        super.setVuiAction(str);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
        super.setVuiBizId(str);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
        super.setVuiDisableHitEffect(z);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
        super.setVuiElementChangedListener(koVar);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
        super.setVuiElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
        super.setVuiElementType(ooVar);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
        super.setVuiFatherElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
        super.setVuiFatherLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
        super.setVuiFeedbackType(poVar);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
        super.setVuiLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
        super.setVuiLayoutLoadable(z);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
        super.setVuiMode(qoVar);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
        super.setVuiPosition(i);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
        super.setVuiPriority(roVar);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
        super.setVuiProps(jSONObject);
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
        super.setVuiValue(obj);
    }

    public XSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        float s = s(2);
        this.l = s;
        float s2 = s(6);
        this.m = s2;
        this.n = getResources().getDimension(vo.x_switch_padding_top);
        this.o = getResources().getDimension(vo.x_switch_padding_start);
        this.p = this.n + s(50);
        this.q = s(25);
        this.r = this.o + s(90);
        this.s = this.n + s;
        float s3 = s(21);
        this.t = s3;
        this.u = this.s + s;
        float s4 = this.o + s(4);
        this.v = s4;
        float f = this.u + (s3 * 2.0f);
        this.w = f;
        this.x = f + s;
        this.y = s4 + (s3 * 2.0f);
        float s5 = s(19);
        this.z = s5;
        float f2 = this.v + s;
        this.A = f2;
        float f3 = this.u + s;
        this.B = f3;
        this.C = f3 + (s5 * 2.0f);
        this.D = f2 + (s5 * 2.0f);
        float f4 = this.p;
        float f5 = this.n;
        this.E = ((f4 - f5) / 2.0f) + f5;
        this.F = s(40);
        float s6 = this.A + s(10);
        this.G = s6;
        this.H = s6 + s(46);
        this.I = this.B + s(8);
        this.J = s(18);
        this.K = s(6);
        this.L = s(22);
        this.M = s(3);
        this.r0 = s(5);
        this.s0 = s2;
        this.W0 = true;
        this.Y0 = true;
        o();
    }

    public final void o() {
        setClickable(true);
        Paint paint = new Paint(1);
        this.f = paint;
        paint.setStrokeWidth(s(4));
        this.g = new Paint(1);
        this.j = new PorterDuffXfermode(PorterDuff.Mode.ADD);
        this.i = new BlurMaskFilter(s(8), BlurMaskFilter.Blur.NORMAL);
        setButtonDrawable(wo.x_switch_drawable);
        setBackgroundColor(j(17170445));
        setGravity(16);
        p();
        setSoundEffectsEnabled(false);
        this.X0 = new ArgbEvaluator();
    }

    public final boolean r() {
        if (!isInEditMode()) {
            return mq.a(getContext());
        }
        return true;
    }

    public final void p() {
        this.Z0 = r();
        this.N = j(uo.x_switch_bg_off_enable_normal_start_color);
        this.O = j(uo.x_switch_bg_off_enable_normal_end_color);
        this.P = j(uo.x_switch_bg_off_enable_pressed_start_color);
        this.Q = j(uo.x_switch_bg_off_enable_pressed_end_color);
        this.R = j(uo.x_switch_bg_on_enable_normal_start_color);
        this.S = j(uo.x_switch_bg_on_enable_normal_end_color);
        this.T = j(uo.x_switch_bg_on_enable_pressed_start_color);
        this.U = j(uo.x_switch_bg_on_enable_pressed_end_color);
        this.V = j(uo.x_switch_bg_off_disable_start_color);
        this.W = j(uo.x_switch_bg_off_disable_end_color);
        this.X = j(uo.x_switch_bg_on_disable_start_color);
        this.Y = j(uo.x_switch_bg_on_disable_end_color);
        this.e0 = j(uo.x_switch_circle_out_off_enable_start_color);
        this.f0 = j(uo.x_switch_circle_out_off_enable_end_color);
        this.g0 = j(uo.x_switch_circle_out_on_enable_start_color);
        this.h0 = j(uo.x_switch_circle_out_on_enable_end_color);
        this.i0 = j(uo.x_switch_circle_out_off_disable_start_color);
        this.j0 = j(uo.x_switch_circle_out_off_disable_end_color);
        this.k0 = j(uo.x_switch_circle_out_on_disable_start_color);
        this.l0 = j(uo.x_switch_circle_out_on_disable_end_color);
        this.x0 = j(uo.x_switch_circle_out_shadow_color);
        this.B0 = j(uo.x_switch_circle_inner_enable_start_color);
        this.C0 = j(uo.x_switch_circle_inner_enable_end_color);
        this.D0 = j(uo.x_switch_circle_inner_disable_start_color);
        this.E0 = j(uo.x_switch_circle_inner_disable_end_color);
        this.G0 = j(uo.x_switch_vertical_off_enable_color);
        this.H0 = j(uo.x_switch_vertical_on_enable_color);
        this.I0 = j(uo.x_switch_vertical_off_disable_color);
        this.J0 = j(uo.x_switch_vertical_on_disable_color);
        i();
    }

    public final void i() {
        int mCircleInnerColorStart;
        int mCircleInnerColorEnd;
        if (isEnabled()) {
            if (isPressed()) {
                this.b0 = this.T;
                this.c0 = this.U;
                this.Z = this.P;
                this.a0 = this.Q;
            } else {
                this.b0 = this.R;
                this.c0 = this.S;
                this.Z = this.N;
                this.a0 = this.O;
            }
            this.m0 = this.e0;
            this.n0 = this.f0;
            this.o0 = this.g0;
            this.p0 = this.h0;
            this.h = 1.0f;
            mCircleInnerColorStart = this.B0;
            mCircleInnerColorEnd = this.C0;
            this.K0 = this.G0;
            this.L0 = this.H0;
        } else {
            int mCircleInnerColorStart2 = this.X;
            this.b0 = mCircleInnerColorStart2;
            this.c0 = this.Y;
            this.Z = this.V;
            this.a0 = this.W;
            this.m0 = this.i0;
            this.n0 = this.j0;
            this.o0 = this.k0;
            this.p0 = this.l0;
            this.h = 0.36f;
            mCircleInnerColorStart = this.D0;
            mCircleInnerColorEnd = this.E0;
            this.K0 = this.I0;
            this.L0 = this.J0;
        }
        this.F0 = new LinearGradient(0.0f, this.B, 0.0f, this.C, mCircleInnerColorStart, mCircleInnerColorEnd, Shader.TileMode.CLAMP);
        if (r()) {
            this.t0 = 0.0f;
            this.u0 = 0.0f;
            this.v0 = this.s0;
            this.w0 = 0.0f;
            this.N0 = this.m;
        } else {
            float f = this.r0;
            this.t0 = f;
            this.u0 = f;
            this.v0 = f;
            this.w0 = f;
            this.N0 = 0.0f;
        }
        D();
    }

    public final void D() {
        w();
        z();
        y();
        C();
        invalidate();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mq.d(newConfig)) {
            p();
        }
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Y0 && this.Z0 != r()) {
            this.Y0 = false;
            p();
        }
        t();
        i();
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.T0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.Y0 = true;
        this.Z0 = r();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        v();
        t();
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        i();
    }

    public void setCheckSoundEnable(boolean enable) {
        this.W0 = enable;
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean checked) {
        b bVar = this.V0;
        if (bVar != null && bVar.b(this, checked)) {
            return;
        }
        boolean currentChecked = isChecked();
        if (currentChecked != checked && isPressed() && this.W0) {
            lq.a().g(checked ? 3 : 4);
        }
        super.setChecked(checked);
        if (!isAttachedToWindow() || getWidth() == 0) {
            t();
            i();
        } else if (currentChecked != checked) {
            v();
            if (checked) {
                u(700);
            } else {
                u(0);
            }
        }
    }

    public final void t() {
        if (isChecked()) {
            this.U0 = 700;
        } else {
            this.U0 = 0;
        }
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        i();
    }

    public final void u(int dstValue) {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.U0, dstValue);
        this.T0 = ofInt;
        ofInt.setDuration(Math.abs(dstValue - this.U0));
        this.T0.addUpdateListener(this);
        this.T0.addListener(new a());
        this.T0.start();
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            super.onAnimationCancel(animation);
            XSwitch.this.T0.removeAllUpdateListeners();
            XSwitch.this.T0.removeAllListeners();
            XSwitch.this.T0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            XSwitch.this.T0.removeAllUpdateListeners();
            XSwitch.this.T0.removeAllListeners();
            XSwitch.this.T0 = null;
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        int intValue = ((Integer) animation.getAnimatedValue()).intValue();
        this.U0 = intValue;
        this.a1 = (intValue - 200) / 300.0f;
        D();
    }

    public final void v() {
        ValueAnimator valueAnimator = this.T0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.T0.cancel();
        }
    }

    public final void w() {
        int i = this.U0;
        if (i <= 200) {
            x(this.Z, this.a0);
        } else if (i <= 500) {
            int bgColorStart = n(this.Z, this.b0, this.a1);
            int bgColorEnd = n(this.a0, this.c0, this.a1);
            x(bgColorStart, bgColorEnd);
        } else {
            x(this.b0, this.c0);
        }
    }

    public final void x(int colorStart, int colorEnd) {
        this.d0 = new LinearGradient(0.0f, this.n, 0.0f, this.p, colorStart, colorEnd, Shader.TileMode.CLAMP);
    }

    public final void z() {
        int i = this.U0;
        if (i <= 200) {
            B(this.m0, this.n0);
            this.y0 = this.t0;
            this.z0 = this.u0;
            float alphaPercent = (this.h * this.U0) / 200.0f;
            A(h(alphaPercent, this.m0), h(alphaPercent, this.n0));
        } else if (i <= 500) {
            int circleOutColorStart = n(this.m0, this.o0, this.a1);
            int circleOutColorEnd = n(this.n0, this.p0, this.a1);
            B(circleOutColorStart, circleOutColorEnd);
            float f = this.v0 - this.t0;
            float f2 = this.a1;
            this.y0 = f * f2;
            this.z0 = (this.w0 - this.u0) * f2;
            A(h(this.h, circleOutColorStart), h(this.h, circleOutColorEnd));
        } else {
            B(this.o0, this.p0);
            this.y0 = this.v0;
            this.z0 = this.w0;
            float f3 = this.h;
            float alphaPercent2 = f3 - ((((this.U0 - 300) - 200) * f3) / 200.0f);
            A(h(alphaPercent2, this.o0), h(alphaPercent2, this.p0));
        }
    }

    public final void B(int colorStart, int colorEnd) {
        this.q0 = new LinearGradient(0.0f, this.s, 0.0f, this.x, colorStart, colorEnd, Shader.TileMode.CLAMP);
    }

    public final void A(int colorStart, int colorEnd) {
        this.A0 = new LinearGradient(0.0f, this.s, 0.0f, this.x, colorStart, colorEnd, Shader.TileMode.CLAMP);
    }

    public final void y() {
        int i = this.U0;
        if (i <= 200) {
            this.k = 0.0f;
        } else if (i <= 500) {
            this.k = this.F * this.a1;
        } else {
            this.k = this.F;
        }
    }

    public final void C() {
        int i = this.U0;
        if (i <= 200) {
            int i2 = this.K0;
            this.M0 = i2;
            this.O0 = this.G;
            this.Q0 = this.E;
            this.P0 = this.J;
            this.R0 = 0.0f;
            float alphaPercent = (this.h * i) / 200.0f;
            this.S0 = h(alphaPercent, i2);
        } else if (i <= 500) {
            int n = n(this.K0, this.L0, this.a1);
            this.M0 = n;
            float animationValue = (this.U0 - 200) - 120;
            float percent = animationValue / 180.0f;
            if (percent >= 0.0f) {
                float f = this.G;
                this.O0 = f + ((this.H - f) * percent);
                float f2 = this.E;
                this.Q0 = f2 - ((f2 - this.I) * percent);
                float f3 = this.J;
                this.P0 = f3 - ((f3 - this.K) * percent);
                this.R0 = this.L * percent;
            }
            this.S0 = h(this.h, n);
        } else {
            int i3 = this.L0;
            this.M0 = i3;
            this.O0 = this.H;
            this.Q0 = this.I;
            this.P0 = this.K;
            this.R0 = this.L;
            float f4 = this.h;
            float alphaPercent2 = f4 - ((((i - 300) - 200) * f4) / 200.0f);
            this.S0 = h(alphaPercent2, i3);
        }
    }

    public final int j(int resourceId) {
        return getResources().getColor(resourceId, getContext().getTheme());
    }

    public final int h(float percent, int color) {
        int alpha = (int) (255.0f * percent);
        return Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
    }

    public final int n(int colorS, int colorT, float percent) {
        return ((Integer) this.X0.evaluate(percent, Integer.valueOf(colorS), Integer.valueOf(colorT))).intValue();
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        float height = (((getHeight() - getPaddingTop()) - s(50)) / 2.0f) + getPaddingTop();
        this.n = height;
        float s = height + s(50);
        this.p = s;
        float f = this.n;
        float f2 = this.l;
        float f3 = f + f2;
        this.s = f3;
        float f4 = f3 + f2;
        this.u = f4;
        float f5 = (this.t * 2.0f) + f4;
        this.w = f5;
        this.x = f5 + f2;
        float f6 = f4 + f2;
        this.B = f6;
        this.C = (this.z * 2.0f) + f6;
        this.E = ((s - f) / 2.0f) + f;
        this.I = f6 + s(8);
        float paddingLeft = getPaddingLeft() + s(7);
        this.o = paddingLeft;
        this.r = paddingLeft + s(90);
        float s2 = this.o + s(4);
        this.v = s2;
        this.y = (this.t * 2.0f) + s2;
        float f7 = s2 + this.l;
        this.A = f7;
        this.D = (this.z * 2.0f) + f7;
        float s3 = f7 + s(10);
        this.G = s3;
        this.H = s3 + s(46);
        i();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getVisibility() == 8) {
            return;
        }
        this.f.setStyle(Paint.Style.FILL);
        this.f.setShader(this.d0);
        float f = this.o;
        float f2 = this.n;
        float f3 = this.r;
        float f4 = this.p;
        float f5 = this.q;
        canvas.drawRoundRect(f, f2, f3, f4, f5, f5, this.f);
        int count = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.f);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setShader(this.q0);
        float f6 = this.y0;
        if (f6 > 0.0f) {
            this.f.setShadowLayer(f6, 0.0f, this.z0, this.x0);
        }
        float f7 = this.v;
        float f8 = this.k;
        float f9 = this.w;
        float f10 = this.t;
        canvas.drawRoundRect(f7 + f8, this.u, this.y + f8, f9, f10, f10, this.f);
        this.f.clearShadowLayer();
        this.f.setXfermode(this.j);
        this.f.setMaskFilter(this.i);
        this.f.setShader(this.A0);
        float f11 = this.v;
        float f12 = this.k;
        float f13 = this.w;
        float f14 = this.t;
        canvas.drawRoundRect(f11 + f12, this.u, this.y + f12, f13, f14, f14, this.f);
        canvas.restoreToCount(count);
        this.f.setMaskFilter(null);
        this.f.setXfermode(null);
        this.f.clearShadowLayer();
        this.f.setStyle(Paint.Style.FILL);
        this.f.setShader(this.F0);
        float f15 = this.A;
        float f16 = this.k;
        float f17 = this.C;
        float f18 = this.z;
        canvas.drawRoundRect(f15 + f16, this.B, this.D + f16, f17, f18, f18, this.f);
        this.g.setColor(this.M0);
        float f19 = this.N0;
        if (f19 > 0.0f) {
            this.g.setShadowLayer(f19, 0.0f, 0.0f, this.M0);
        }
        int count2 = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.f);
        float f20 = this.O0;
        float f21 = this.Q0;
        float f22 = this.M;
        canvas.drawRoundRect(f20, f21, f20 + this.P0, f21 + this.R0, f22, f22, this.g);
        this.g.clearShadowLayer();
        if (isEnabled()) {
            this.g.setColor(this.S0);
            this.g.setXfermode(this.j);
            this.g.setMaskFilter(this.i);
            float f23 = this.O0;
            float f24 = this.Q0;
            float f25 = this.M;
            canvas.drawRoundRect(f23, f24, f23 + this.P0, f24 + this.R0, f25, f25, this.g);
        }
        canvas.restoreToCount(count2);
        this.g.setMaskFilter(null);
        this.g.setXfermode(null);
    }

    public final float s(int dp) {
        return TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    @Override // com.xiaopeng.xui.widget.XCompoundButton, android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        b bVar = this.V0;
        if (bVar != null && bVar.a(this)) {
            return false;
        }
        return super.performClick();
    }

    public void setOnInterceptListener(b listener) {
        this.V0 = listener;
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean b(View view, boolean z);

        default boolean a(View v) {
            return false;
        }
    }
}
