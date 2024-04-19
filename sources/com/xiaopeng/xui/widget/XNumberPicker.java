package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatEditText;
import com.lzy.okgo.model.Priority;
import java.util.Formatter;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XNumberPicker extends XLinearLayout {
    public static final g b = new g();
    public static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785, 2406, 2407, 2408, 2409, 2410, 2411, 2412, 2413, 2414, 2415, 2534, 2535, 2536, 2537, 2538, 2539, 2540, 2541, 2542, 2543, 3302, 3303, 3304, 3305, 3306, 3307, 3308, 3309, 3310, 3311};
    public final SparseArray<String> A;
    public final int[] B;
    public final Paint C;
    public int D;
    public int E;
    public int F;
    public int G;
    public final Scroller H;
    public final Scroller I;
    public int J;
    public b K;
    public a L;
    public float M;
    public long N;
    public float O;
    public VelocityTracker P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public boolean U;
    public final int V;
    public final Drawable W;
    public final Drawable X;
    public final int Y;
    public int Z;
    public boolean a0;
    public boolean b0;
    public int c0;
    public int d0;
    public final f e0;
    public boolean f;
    public int f0;
    public int g;
    public boolean g0;
    public int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public int m;
    public final boolean n;
    public final int o;
    public final int p;
    public ColorStateList q;
    public int r;
    public String[] s;
    public int t;
    public int u;
    public int v;
    public e w;
    public d x;
    public c y;
    public long z;

    /* loaded from: classes.dex */
    public interface c {
        String a(int i);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(XNumberPicker xNumberPicker, int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(XNumberPicker xNumberPicker, int i, int i2);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiAction() {
        return super.getVuiAction();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiBizId() {
        return super.getVuiBizId();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
        return super.getVuiDisableHitEffect();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
        return super.getVuiElementChangedListener();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiElementId() {
        return super.getVuiElementId();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ oo getVuiElementType() {
        return super.getVuiElementType();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
        return super.getVuiFatherElementId();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
        return super.getVuiFatherLabel();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
        return super.getVuiFeedbackType();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiLabel() {
        return super.getVuiLabel();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ qo getVuiMode() {
        return super.getVuiMode();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ int getVuiPosition() {
        return super.getVuiPosition();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ ro getVuiPriority() {
        return super.getVuiPriority();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
        return super.getVuiProps();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ Object getVuiValue() {
        return super.getVuiValue();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
        super.setPerformVuiAction(z);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiAction(String str) {
        super.setVuiAction(str);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
        super.setVuiBizId(str);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
        super.setVuiDisableHitEffect(z);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
        super.setVuiElementChangedListener(koVar);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
        super.setVuiElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
        super.setVuiElementType(ooVar);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
        super.setVuiFatherElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
        super.setVuiFatherLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
        super.setVuiFeedbackType(poVar);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
        super.setVuiLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
        super.setVuiLayoutLoadable(z);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
        super.setVuiMode(qoVar);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
        super.setVuiPosition(i);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
        super.setVuiPriority(roVar);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
        super.setVuiProps(jSONObject);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
        super.setVuiValue(obj);
    }

    /* loaded from: classes.dex */
    public static class g implements c {
        public char b;
        public Formatter c;
        public final StringBuilder a = new StringBuilder();
        public final Object[] d = new Object[1];

        public g() {
            Locale locale = Locale.getDefault();
            d(locale);
        }

        public final void d(Locale locale) {
            this.c = b(locale);
            this.b = c(locale);
        }

        @Override // com.xiaopeng.xui.widget.XNumberPicker.c
        public String a(int value) {
            Locale currentLocale = Locale.getDefault();
            if (this.b != c(currentLocale)) {
                d(currentLocale);
            }
            this.d[0] = Integer.valueOf(value);
            StringBuilder sb = this.a;
            sb.delete(0, sb.length());
            this.c.format("%02d", this.d);
            return this.c.toString();
        }

        public static char c(Locale locale) {
            return '0';
        }

        public final Formatter b(Locale locale) {
            return new Formatter(this.a, locale);
        }
    }

    public static c getTwoDigitFormatter() {
        return b;
    }

    public XNumberPicker(Context context, AttributeSet attrs) {
        this(context, attrs, ap.XNumberPicker);
    }

    public XNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, ap.XNumberPicker);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public XNumberPicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        boolean z;
        int dimensionPixelSize;
        int dimensionPixelSize2;
        ?? r2;
        this.f = true;
        this.z = 300L;
        this.A = new SparseArray<>();
        this.B = new int[5];
        this.F = Priority.BG_LOW;
        this.Z = 0;
        this.f0 = -1;
        TypedArray attributesArray = context.obtainStyledAttributes(attrs, bp.Z1, defStyleAttr, defStyleRes);
        this.g0 = attributesArray.getBoolean(bp.c2, false);
        this.T = attributesArray.getInt(bp.n2, 1);
        this.V = attributesArray.getColor(bp.l2, 0);
        Drawable selectionDivider = attributesArray.getDrawable(bp.i2);
        if (selectionDivider != null) {
            selectionDivider.setCallback(this);
            selectionDivider.setLayoutDirection(getLayoutDirection());
            if (selectionDivider.isStateful()) {
                selectionDivider.setState(getDrawableState());
            }
        }
        this.W = selectionDivider;
        this.X = attributesArray.getDrawable(bp.m2);
        int defSelectionDividerHeight = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.Y = attributesArray.getDimensionPixelSize(bp.j2, defSelectionDividerHeight);
        int defSelectionDividerDistance = (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics());
        this.i = attributesArray.getDimensionPixelSize(bp.k2, defSelectionDividerDistance);
        this.g = attributesArray.getDimensionPixelSize(bp.o2, 0);
        int dimensionPixelSize3 = attributesArray.getDimensionPixelSize(bp.f2, -1);
        this.j = dimensionPixelSize3;
        int dimensionPixelSize4 = attributesArray.getDimensionPixelSize(bp.d2, -1);
        this.k = dimensionPixelSize4;
        if (dimensionPixelSize3 == -1 || dimensionPixelSize4 == -1 || dimensionPixelSize3 <= dimensionPixelSize4) {
            int dimensionPixelSize5 = attributesArray.getDimensionPixelSize(bp.g2, -1);
            this.l = dimensionPixelSize5;
            int dimensionPixelSize6 = attributesArray.getDimensionPixelSize(bp.e2, -1);
            this.m = dimensionPixelSize6;
            if (dimensionPixelSize5 != -1 && dimensionPixelSize6 != -1 && dimensionPixelSize5 > dimensionPixelSize6) {
                throw new IllegalArgumentException("minWidth > maxWidth");
            }
            if (dimensionPixelSize6 == -1) {
                z = true;
            } else {
                z = false;
            }
            this.n = z;
            this.o = attributesArray.getDimensionPixelSize(bp.a2, 20);
            this.p = attributesArray.getDimensionPixelSize(bp.h2, 20);
            ColorStateList colorStateList = attributesArray.getColorStateList(bp.b2);
            this.q = colorStateList;
            if (colorStateList == null) {
                this.q = ColorStateList.valueOf(context.getColor(17170444));
            }
            attributesArray.recycle();
            this.e0 = new f();
            setWillNotDraw(false);
            ViewConfiguration configuration = ViewConfiguration.get(context);
            this.Q = configuration.getScaledTouchSlop();
            this.R = configuration.getScaledMinimumFlingVelocity();
            this.S = configuration.getScaledMaximumFlingVelocity() / 8;
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            switch (this.T) {
                case 0:
                    paint.setTextAlign(Paint.Align.LEFT);
                    break;
                case 1:
                    paint.setTextAlign(Paint.Align.CENTER);
                    break;
                case 2:
                    paint.setTextAlign(Paint.Align.RIGHT);
                    break;
            }
            paint.setTextSize(Math.max(dimensionPixelSize, dimensionPixelSize2));
            int color = this.q.getDefaultColor();
            paint.setColor(color);
            paint.setTypeface(Typeface.create(getResources().getString(zo.x_font_typeface_medium), 0));
            this.C = paint;
            this.H = new Scroller(getContext(), null, true);
            this.I = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
            if (getImportantForAccessibility() != 0) {
                r2 = 1;
            } else {
                r2 = 1;
                setImportantForAccessibility(1);
            }
            if (getFocusable() == 16) {
                setFocusable((int) r2);
                setFocusableInTouchMode(r2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("minHeight > maxHeight");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            x();
            w();
            int height = getHeight();
            int i = this.i;
            int i2 = this.Y;
            int i3 = (((height - i) / 2) - i2) + 5;
            this.c0 = i3;
            this.d0 = i3 + (i2 * 2) + i;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int newWidthMeasureSpec = z(widthMeasureSpec, this.m);
        int newHeightMeasureSpec = z(heightMeasureSpec, this.k);
        super.onMeasure(newWidthMeasureSpec, newHeightMeasureSpec);
        int widthSize = J(this.l, getMeasuredWidth(), widthMeasureSpec);
        this.h = widthSize;
        int heightSize = J(this.j, getMeasuredHeight(), heightMeasureSpec);
        setMeasuredDimension(widthSize, heightSize);
    }

    public final boolean A(Scroller scroller) {
        scroller.forceFinished(true);
        int amountToScroll = scroller.getFinalY() - scroller.getCurrY();
        int futureScrollOffset = (this.G + amountToScroll) % this.D;
        int overshootAdjustment = this.F - futureScrollOffset;
        if (overshootAdjustment == 0) {
            return false;
        }
        int abs = Math.abs(overshootAdjustment);
        int i = this.D;
        if (abs > i / 2) {
            if (overshootAdjustment > 0) {
                overshootAdjustment -= i;
            } else {
                overshootAdjustment += i;
            }
        }
        scrollBy(0, amountToScroll + overshootAdjustment);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (isEnabled()) {
            int action = event.getActionMasked();
            if (action == 0) {
                G();
                float y = event.getY();
                this.M = y;
                this.O = y;
                this.N = event.getEventTime();
                this.a0 = false;
                this.b0 = false;
                float f2 = this.M;
                if (f2 < this.c0) {
                    if (this.Z == 0) {
                        this.e0.a(2);
                    }
                } else if (f2 > this.d0 && this.Z == 0) {
                    this.e0.a(1);
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                if (!this.H.isFinished()) {
                    this.H.forceFinished(true);
                    this.I.forceFinished(true);
                    C(0);
                } else if (!this.I.isFinished()) {
                    this.H.forceFinished(true);
                    this.I.forceFinished(true);
                } else {
                    float f3 = this.M;
                    if (f3 < this.c0) {
                        F(false, ViewConfiguration.getLongPressTimeout());
                    } else if (f3 > this.d0) {
                        F(true, ViewConfiguration.getLongPressTimeout());
                    } else {
                        this.b0 = true;
                        E();
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (isEnabled()) {
            if (this.P == null) {
                this.P = VelocityTracker.obtain();
            }
            this.P.addMovement(event);
            int action = event.getActionMasked();
            switch (action) {
                case 1:
                    H();
                    I();
                    this.e0.c();
                    VelocityTracker velocityTracker = this.P;
                    velocityTracker.computeCurrentVelocity(1000, this.S);
                    int initialVelocity = (int) velocityTracker.getYVelocity();
                    if (Math.abs(initialVelocity) > this.R) {
                        r(initialVelocity);
                        C(2);
                    } else {
                        int eventY = (int) event.getY();
                        int deltaMoveY = (int) Math.abs(eventY - this.M);
                        long deltaTime = event.getEventTime() - this.N;
                        if (deltaMoveY <= this.Q && deltaTime < ViewConfiguration.getTapTimeout()) {
                            if (this.b0) {
                                this.b0 = false;
                                performClick();
                            } else {
                                int selectorIndexOffset = (eventY / this.D) - 2;
                                if (selectorIndexOffset > 0) {
                                    j(true);
                                    this.e0.b(1);
                                } else if (selectorIndexOffset < 0) {
                                    j(false);
                                    this.e0.b(2);
                                }
                            }
                        } else {
                            p();
                        }
                        C(0);
                    }
                    this.P.recycle();
                    this.P = null;
                    break;
                case 2:
                    if (!this.a0) {
                        float currentMoveY = event.getY();
                        if (this.Z != 1) {
                            int deltaDownY = (int) Math.abs(currentMoveY - this.M);
                            if (deltaDownY > this.Q) {
                                G();
                                C(1);
                            }
                        } else {
                            int deltaMoveY2 = (int) (currentMoveY - this.O);
                            scrollBy(0, deltaMoveY2);
                            invalidate();
                        }
                        this.O = currentMoveY;
                        break;
                    }
                    break;
            }
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        switch (action) {
            case 1:
            case 3:
                G();
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (eo.c(newConfig)) {
            this.q = getContext().getResources().getColorStateList(uo.x_number_picker_text_color, null);
            postInvalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case 19:
            case 20:
                switch (event.getAction()) {
                    case 0:
                        if (this.U || (keyCode != 20 ? getValue() > getMinValue() : getValue() < getMaxValue())) {
                            requestFocus();
                            this.f0 = keyCode;
                            G();
                            if (this.H.isFinished()) {
                                j(keyCode == 20);
                            }
                            return true;
                        }
                    case 1:
                        if (this.f0 == keyCode) {
                            this.f0 = -1;
                            return true;
                        }
                        break;
                }
                break;
            case 23:
            case 66:
                G();
                break;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent event) {
        int action = event.getActionMasked();
        switch (action) {
            case 1:
            case 3:
                G();
                break;
        }
        return super.dispatchTrackballEvent(event);
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller scroller = this.H;
        if (scroller.isFinished()) {
            scroller = this.I;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        int currentScrollerY = scroller.getCurrY();
        if (this.J == 0) {
            this.J = scroller.getStartY();
        }
        scrollBy(0, currentScrollerY - this.J);
        this.J = currentScrollerY;
        if (scroller.isFinished()) {
            D(scroller);
        } else {
            invalidate();
        }
    }

    @Override // android.view.View
    public void scrollBy(int x, int y) {
        int i;
        int[] selectorIndices = this.B;
        int startScrollOffset = this.G;
        boolean z = this.U;
        if (!z && y > 0 && selectorIndices[2] <= this.t) {
            this.G = this.F;
        } else if (!z && y < 0 && selectorIndices[2] >= this.u) {
            this.G = this.F;
        } else {
            this.G += y;
            while (true) {
                int i2 = this.G;
                int i3 = i2 - this.F;
                int i4 = this.r;
                if (i3 <= i4) {
                    break;
                }
                int decrement = (i4 * 2) + 1;
                this.G = i2 - decrement;
                n(selectorIndices);
                K(selectorIndices[2], true);
                if (!this.U && selectorIndices[2] <= this.t) {
                    this.G = this.F;
                }
            }
            while (true) {
                i = this.G;
                int i5 = i - this.F;
                int i6 = this.r;
                if (i5 >= (-i6)) {
                    break;
                }
                int increment = (i6 * 2) + 1;
                this.G = i + increment;
                v(selectorIndices);
                K(selectorIndices[2], true);
                if (!this.U && selectorIndices[2] >= this.u) {
                    this.G = this.F;
                }
            }
            if (startScrollOffset != i) {
                onScrollChanged(0, i, 0, startScrollOffset);
            }
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return this.G;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        return ((this.u - this.t) + 1) * this.D;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return getHeight();
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.V;
    }

    public void setOnValueChangedListener(e onValueChangedListener) {
        this.w = onValueChangedListener;
    }

    public void setOnScrollListener(d onScrollListener) {
        this.x = onScrollListener;
    }

    public void setFormatter(c formatter) {
        if (formatter == this.y) {
            return;
        }
        this.y = formatter;
        y();
    }

    public void setValue(int value) {
        K(value, false);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // android.view.View
    public boolean performLongClick() {
        return super.performLongClick();
    }

    public final void L() {
        if (!this.n) {
            return;
        }
        int maxTextWidth = 0;
        String[] strArr = this.s;
        if (strArr == null) {
            float maxDigitWidth = 0.0f;
            for (int i = 0; i <= 9; i++) {
                float digitWidth = this.C.measureText(t(i));
                if (digitWidth > maxDigitWidth) {
                    maxDigitWidth = digitWidth;
                }
            }
            int numberOfDigits = 0;
            for (int current = this.u; current > 0; current /= 10) {
                numberOfDigits++;
            }
            maxTextWidth = (int) (numberOfDigits * maxDigitWidth);
        } else {
            int length = strArr.length;
            for (String mDisplayedValue : strArr) {
                float textWidth = this.C.measureText(mDisplayedValue);
                if (textWidth > maxTextWidth) {
                    maxTextWidth = (int) textWidth;
                }
            }
        }
        if (this.m != maxTextWidth) {
            int i2 = this.l;
            if (maxTextWidth > i2) {
                this.m = maxTextWidth;
            } else {
                this.m = i2;
            }
            invalidate();
        }
    }

    public boolean getWrapSelectorWheel() {
        return this.U;
    }

    public void setWrapSelectorWheel(boolean wrapSelectorWheel) {
        this.f = wrapSelectorWheel;
        M();
    }

    public final void M() {
        boolean z = true;
        boolean wrappingAllowed = (this.u - this.t) + 1 >= this.B.length;
        if (!wrappingAllowed || !this.f) {
            z = false;
        }
        this.U = z;
    }

    public void setOnLongPressUpdateInterval(long intervalMillis) {
        this.z = intervalMillis;
    }

    public int getValue() {
        return this.v;
    }

    public int getMinValue() {
        return this.t;
    }

    public void setMinValue(int minValue) {
        if (this.t == minValue) {
            return;
        }
        if (minValue < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        this.t = minValue;
        if (minValue > this.v) {
            this.v = minValue;
        }
        M();
        invalidate();
    }

    public int getMaxValue() {
        return this.u;
    }

    public void setMaxValue(int maxValue) {
        if (this.u == maxValue) {
            return;
        }
        if (maxValue < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.u = maxValue;
        if (maxValue < this.v) {
            this.v = maxValue;
        }
        M();
        invalidate();
    }

    public String[] getDisplayedValues() {
        return this.s;
    }

    public void setDisplayedValues(String[] displayedValues) {
        if (this.s == displayedValues) {
            return;
        }
        this.s = displayedValues;
        y();
        L();
    }

    public CharSequence getDisplayedValueForCurrentSelection() {
        return this.A.get(getValue());
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        G();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable selectionDivider = this.W;
        if (selectionDivider != null && selectionDivider.isStateful() && selectionDivider.setState(getDrawableState())) {
            invalidateDrawable(selectionDivider);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.W;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        int i;
        float x;
        float x2;
        boolean showSelectorWheel = !this.g0 || hasFocus();
        float y = this.G;
        int[] selectorIndices = this.B;
        for (int i2 = 0; i2 < selectorIndices.length; i2++) {
            int selectorIndex = selectorIndices[i2];
            String scrollSelectorValue = this.A.get(selectorIndex);
            if (showSelectorWheel) {
                if (i2 == 2) {
                    int color = this.q.getColorForState(LinearLayout.SELECTED_STATE_SET, -16777216);
                    this.C.setColor(color);
                    this.C.setTextSize(this.p);
                    switch (this.T) {
                        case 0:
                            x2 = this.g;
                            break;
                        case 1:
                        default:
                            x2 = (getRight() - getLeft()) / 2.0f;
                            break;
                        case 2:
                            x2 = (getRight() - getLeft()) - this.g;
                            break;
                    }
                    canvas.drawText(scrollSelectorValue, x2, y, this.C);
                } else {
                    int color2 = this.q.getDefaultColor();
                    this.C.setColor(color2);
                    this.C.setTextSize(this.o);
                    switch (this.T) {
                        case 0:
                            x = this.g;
                            break;
                        case 1:
                        default:
                            x = (getRight() - getLeft()) / 2.0f;
                            break;
                        case 2:
                            x = (getRight() - getLeft()) - this.g;
                            break;
                    }
                    canvas.drawText(scrollSelectorValue, x, y, this.C);
                }
            }
            if (i2 == 1) {
                i = this.E;
            } else {
                i = this.D;
            }
            y += i;
        }
        if (showSelectorWheel && (drawable = this.W) != null) {
            int topOfTopDivider = this.c0;
            int bottomOfTopDivider = this.Y + topOfTopDivider;
            drawable.setBounds(0, topOfTopDivider, this.h, bottomOfTopDivider);
            this.W.draw(canvas);
            int bottomOfBottomDivider = this.d0;
            int topOfBottomDivider = bottomOfBottomDivider - this.Y;
            this.W.setBounds(0, topOfBottomDivider, this.h, bottomOfBottomDivider);
            this.W.draw(canvas);
            Drawable drawable2 = this.X;
            if (drawable2 != null) {
                int topOfTopSymbol = ((bottomOfTopDivider * 2) + topOfBottomDivider) / 3;
                int bottomOfBottomSymbol = ((topOfBottomDivider * 2) + bottomOfTopDivider) / 3;
                switch (this.T) {
                    case 0:
                        int i3 = this.h;
                        drawable2.setBounds(i3 - 6, topOfTopSymbol, i3, topOfTopSymbol + 6);
                        this.X.draw(canvas);
                        Drawable drawable3 = this.X;
                        int i4 = this.h;
                        drawable3.setBounds(i4 - 6, bottomOfBottomSymbol - 6, i4, bottomOfBottomSymbol);
                        this.X.draw(canvas);
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        drawable2.setBounds(35, topOfTopSymbol, 41, topOfTopSymbol + 6);
                        this.X.draw(canvas);
                        this.X.setBounds(35, bottomOfBottomSymbol - 6, 41, bottomOfBottomSymbol);
                        this.X.draw(canvas);
                        return;
                }
            }
        }
    }

    public final int z(int measureSpec, int maxSize) {
        if (maxSize == -1) {
            return measureSpec;
        }
        int size = View.MeasureSpec.getSize(measureSpec);
        int mode = View.MeasureSpec.getMode(measureSpec);
        switch (mode) {
            case Priority.BG_LOW /* -2147483648 */:
                return View.MeasureSpec.makeMeasureSpec(Math.min(size, maxSize), 1073741824);
            case 0:
                return View.MeasureSpec.makeMeasureSpec(maxSize, 1073741824);
            case 1073741824:
                return measureSpec;
            default:
                throw new IllegalArgumentException("Unknown measure mode: " + mode);
        }
    }

    public final int J(int minSize, int measuredSize, int measureSpec) {
        if (minSize != -1) {
            int desiredWidth = Math.max(minSize, measuredSize);
            return LinearLayout.resolveSizeAndState(desiredWidth, measureSpec, 0);
        }
        return measuredSize;
    }

    public final void y() {
        this.A.clear();
        int[] selectorIndices = this.B;
        int current = getValue();
        for (int i = 0; i < this.B.length; i++) {
            int selectorIndex = (i - 2) + current;
            if (this.U) {
                selectorIndex = u(selectorIndex);
            }
            selectorIndices[i] = selectorIndex;
            o(selectorIndices[i]);
        }
    }

    public final void K(int current, boolean notifyChange) {
        int current2;
        if (this.v == current) {
            return;
        }
        if (this.U) {
            current2 = u(current);
        } else {
            current2 = Math.min(Math.max(current, this.t), this.u);
        }
        int previous = this.v;
        this.v = current2;
        if (notifyChange) {
            lq.a().g(2);
            B(previous, current2);
        }
        y();
        invalidate();
    }

    public final void j(boolean increment) {
        if (!A(this.H)) {
            A(this.I);
        }
        this.J = 0;
        if (increment) {
            this.H.startScroll(0, 0, 0, -this.D, 300);
        } else {
            this.H.startScroll(0, 0, 0, this.D, 300);
        }
        invalidate();
    }

    public final void x() {
        y();
        int[] selectorIndices = this.B;
        int totalTextHeight = ((selectorIndices.length - 1) * this.o) + this.p;
        float totalTextGapHeight = (getBottom() - getTop()) - totalTextHeight;
        int textGapCount = selectorIndices.length;
        int i = (int) ((totalTextGapHeight / textGapCount) + 0.5f);
        this.r = i;
        int i2 = this.o;
        this.D = i2 + i;
        this.E = this.p + i;
        int i3 = i + (i2 / 2);
        this.F = i3;
        this.G = i3;
    }

    public final void w() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.o) / 2);
    }

    public final void D(Scroller scroller) {
        if (scroller == this.H) {
            p();
            C(0);
        }
    }

    public final void C(int scrollState) {
        if (this.Z == scrollState) {
            return;
        }
        this.Z = scrollState;
        d dVar = this.x;
        if (dVar != null) {
            dVar.a(this, scrollState);
        }
    }

    public final void r(int velocityY) {
        this.J = 0;
        if (velocityY > 0) {
            this.H.fling(0, 0, 0, velocityY, 0, 0, 0, Priority.UI_TOP);
        } else {
            this.H.fling(0, Priority.UI_TOP, 0, velocityY, 0, 0, 0, Priority.UI_TOP);
        }
        invalidate();
    }

    public final int u(int selectorIndex) {
        int i = this.u;
        if (selectorIndex > i) {
            int i2 = this.t;
            return (i2 + ((selectorIndex - i) % (i - i2))) - 1;
        }
        int i3 = this.t;
        if (selectorIndex < i3) {
            return (i - ((i3 - selectorIndex) % (i - i3))) + 1;
        }
        return selectorIndex;
    }

    public final void v(int[] selectorIndices) {
        if (selectorIndices.length - 1 >= 0) {
            System.arraycopy(selectorIndices, 1, selectorIndices, 0, selectorIndices.length - 1);
        }
        int nextScrollSelectorIndex = selectorIndices[selectorIndices.length - 2] + 1;
        if (this.U && nextScrollSelectorIndex > this.u) {
            nextScrollSelectorIndex = this.t;
        }
        selectorIndices[selectorIndices.length - 1] = nextScrollSelectorIndex;
        o(nextScrollSelectorIndex);
    }

    public final void n(int[] selectorIndices) {
        if (selectorIndices.length - 1 >= 0) {
            System.arraycopy(selectorIndices, 0, selectorIndices, 1, selectorIndices.length - 1);
        }
        int nextScrollSelectorIndex = selectorIndices[1] - 1;
        if (this.U && nextScrollSelectorIndex < this.t) {
            nextScrollSelectorIndex = this.u;
        }
        selectorIndices[0] = nextScrollSelectorIndex;
        o(nextScrollSelectorIndex);
    }

    public final void o(int selectorIndex) {
        String scrollSelectorValue;
        SparseArray<String> cache = this.A;
        String scrollSelectorValue2 = cache.get(selectorIndex);
        if (scrollSelectorValue2 != null) {
            return;
        }
        int i = this.t;
        if (selectorIndex < i || selectorIndex > this.u) {
            scrollSelectorValue = "";
        } else {
            String[] strArr = this.s;
            if (strArr != null) {
                int displayedValueIndex = selectorIndex - i;
                scrollSelectorValue = strArr[displayedValueIndex];
            } else {
                scrollSelectorValue = s(selectorIndex);
            }
        }
        cache.put(selectorIndex, scrollSelectorValue);
    }

    public final String s(int value) {
        c cVar = this.y;
        return cVar != null ? cVar.a(value) : t(value);
    }

    public final void B(int previous, int current) {
        e eVar = this.w;
        if (eVar != null) {
            eVar.a(this, previous, this.v);
        }
    }

    public final void F(boolean increment, long delayMillis) {
        b bVar = this.K;
        if (bVar == null) {
            this.K = new b();
        } else {
            removeCallbacks(bVar);
        }
        this.K.b(increment);
        postDelayed(this.K, delayMillis);
    }

    public final void I() {
        b bVar = this.K;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
    }

    public final void E() {
        a aVar = this.L;
        if (aVar == null) {
            this.L = new a();
        } else {
            removeCallbacks(aVar);
        }
        postDelayed(this.L, ViewConfiguration.getLongPressTimeout());
    }

    public final void H() {
        a aVar = this.L;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
    }

    public final void G() {
        b bVar = this.K;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
        a aVar = this.L;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
        this.e0.c();
    }

    public final boolean p() {
        int deltaY = this.F - this.G;
        if (deltaY == 0) {
            return false;
        }
        this.J = 0;
        int abs = Math.abs(deltaY);
        int i = this.D;
        if (abs > i / 2) {
            if (deltaY > 0) {
                i = -i;
            }
            deltaY += i;
        }
        this.I.startScroll(0, 0, 0, deltaY, 800);
        invalidate();
        return true;
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public final int a = 1;
        public final int b = 2;
        public int d;
        public int f;

        public f() {
        }

        public void c() {
            this.f = 0;
            this.d = 0;
            XNumberPicker.this.removeCallbacks(this);
        }

        public void a(int button) {
            c();
            this.f = 1;
            this.d = button;
            XNumberPicker.this.postDelayed(this, ViewConfiguration.getTapTimeout());
        }

        public void b(int button) {
            c();
            this.f = 2;
            this.d = button;
            XNumberPicker.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.f) {
                case 1:
                    switch (this.d) {
                        case 1:
                            XNumberPicker xNumberPicker = XNumberPicker.this;
                            xNumberPicker.invalidate(0, xNumberPicker.d0, XNumberPicker.this.getRight(), XNumberPicker.this.getBottom());
                            return;
                        case 2:
                            XNumberPicker xNumberPicker2 = XNumberPicker.this;
                            xNumberPicker2.invalidate(0, 0, xNumberPicker2.getRight(), XNumberPicker.this.c0);
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public boolean a;

        public b() {
        }

        public final void b(boolean increment) {
            this.a = increment;
        }

        @Override // java.lang.Runnable
        public void run() {
            XNumberPicker.this.j(this.a);
            XNumberPicker xNumberPicker = XNumberPicker.this;
            xNumberPicker.postDelayed(this, xNumberPicker.z);
        }
    }

    /* loaded from: classes.dex */
    public static class CustomEditText extends AppCompatEditText {
        @Override // android.widget.TextView
        public void onEditorAction(int actionCode) {
            super.onEditorAction(actionCode);
            if (actionCode == 6) {
                clearFocus();
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            XNumberPicker.this.performLongClick();
        }
    }

    public static String t(int value) {
        return String.format(Locale.getDefault(), "%d", Integer.valueOf(value));
    }
}
