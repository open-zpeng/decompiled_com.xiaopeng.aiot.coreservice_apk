package com.xiaopeng.xui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes.dex */
public class XTabLayout extends XLinearLayout {
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public float N;
    public int O;
    public int P;
    public ValueAnimator Q;
    public boolean R;
    public int S;
    public boolean T;
    public CharSequence[] U;
    public int[] V;
    public CharSequence[] W;
    public i X;
    public View.OnClickListener Y;
    public boolean Z;
    public boolean a0;
    public final int b;
    public int d;
    public boolean f;
    public float g;
    public ColorStateList h;
    public float i;
    public float j;
    public float k;
    public int l;
    public int m;
    public int n;
    public int o;
    public float p;
    public int q;
    public int r;
    public float s;
    public boolean t;
    public Paint u;
    public Paint v;
    public Paint w;
    public Paint x;
    public float y;
    public float z;

    /* loaded from: classes.dex */
    public interface h {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(XTabLayout xTabLayout, int i, boolean z, boolean z2);

        boolean b(XTabLayout xTabLayout, int i, boolean z, boolean z2);

        void c(XTabLayout xTabLayout, int i, boolean z, boolean z2);
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
    public /* bridge */ /* synthetic */ void setVuiPosition(int i2) {
        super.setVuiPosition(i2);
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
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (XTabLayout.this.Q != null && XTabLayout.this.Q.isRunning()) {
                return;
            }
            XTabLayout xTabLayout = XTabLayout.this;
            xTabLayout.Y(xTabLayout.indexOfChild(v), true, true);
        }
    }

    public XTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public XTabLayout(android.content.Context r17, android.util.AttributeSet r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.xui.widget.XTabLayout.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public /* synthetic */ void W(zq xFontScaleHelper) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View v = getChildAt(i2);
            if (v instanceof TextView) {
                TextView textView = (TextView) v;
                xFontScaleHelper.g(textView);
            }
        }
    }

    private View getSelectView() {
        return getChildAt(this.O);
    }

    public void setStyle(int style) {
        int[] iArr;
        this.a0 = U();
        if (!this.t) {
            style = 1;
        }
        this.P = style;
        if (this.R) {
            this.P = 2;
        }
        if (this.P == 2) {
            int i2 = this.d;
            setPadding(i2, 0, i2, 0);
        } else {
            setPadding(0, 0, 0, 0);
        }
        if (this.S > 0) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View view = getChildAt(i3);
                if (view instanceof TextView) {
                    ColorStateList textColor = getResources().getColorStateList(this.S, getContext().getTheme());
                    ((TextView) view).setTextColor(textColor);
                } else if ((view instanceof ImageView) && (iArr = this.V) != null && iArr.length > i3) {
                    ((ImageView) view).setImageResource(iArr[i3]);
                }
            }
        }
        this.u.setColor(getContext().getColor(this.l));
        this.w.setColor(getContext().getColor(this.q));
        X(false, null);
    }

    public final void S() {
        this.u.setStrokeWidth(0.0f);
        this.u.setColor(getContext().getColor(this.l));
        this.v.setStrokeWidth(0.0f);
        this.v.setColor(this.o);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 26) {
            setLayerType(1, this.v);
        }
        this.w.setStrokeWidth(0.0f);
        this.w.setColor(getContext().getColor(this.q));
        this.x.setStrokeWidth(0.0f);
        this.x.setColor(this.r);
        if (i2 <= 26) {
            setLayerType(1, this.x);
        }
        CharSequence[] charSequenceArr = this.U;
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            for (CharSequence title : charSequenceArr) {
                J(title);
            }
        } else {
            int[] iArr = this.V;
            if (iArr != null && iArr.length > 0) {
                for (int i3 = 0; i3 < this.V.length; i3++) {
                    String vuiLabel = "";
                    CharSequence[] charSequenceArr2 = this.W;
                    if (charSequenceArr2 != null && charSequenceArr2.length > i3) {
                        vuiLabel = charSequenceArr2[i3].toString();
                    }
                    I(this.V[i3], vuiLabel);
                }
            }
        }
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            getChildAt(i4).setOnClickListener(this.Y);
        }
        setOnHierarchyChangeListener(new b());
    }

    /* loaded from: classes.dex */
    public class b implements ViewGroup.OnHierarchyChangeListener {
        public b() {
        }

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public final /* synthetic */ boolean a;

            public a(boolean z) {
                this.a = z;
            }

            /* renamed from: com.xiaopeng.xui.widget.XTabLayout$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0014a implements h {
                public C0014a() {
                }

                @Override // com.xiaopeng.xui.widget.XTabLayout.h
                public void a() {
                    if (XTabLayout.this.X != null) {
                        i iVar = XTabLayout.this.X;
                        XTabLayout xTabLayout = XTabLayout.this;
                        iVar.c(xTabLayout, xTabLayout.O, a.this.a, false);
                    }
                }

                @Override // com.xiaopeng.xui.widget.XTabLayout.h
                public void b() {
                    if (XTabLayout.this.X != null) {
                        i iVar = XTabLayout.this.X;
                        XTabLayout xTabLayout = XTabLayout.this;
                        iVar.a(xTabLayout, xTabLayout.O, a.this.a, false);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                XTabLayout.this.X(true, new C0014a());
            }
        }

        public final void a(boolean change) {
            XTabLayout.this.post(new a(change));
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View parent, View child) {
            child.setOnClickListener(XTabLayout.this.Y);
            if (XTabLayout.this.O < 0) {
                XTabLayout xTabLayout = XTabLayout.this;
                xTabLayout.O = xTabLayout.indexOfChild(child);
                child.setSelected(true);
            }
            Object tag = child.getTag();
            a(tag == null ? false : ((Boolean) tag).booleanValue());
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View parent, View child) {
            child.setOnClickListener(null);
            Object tag = child.getTag();
            a(tag == null ? false : ((Boolean) tag).booleanValue());
        }
    }

    public void setIndicatorAnimatorEnable(boolean indicatorAnimatorEnable) {
        this.f = indicatorAnimatorEnable;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        switch (this.P) {
            case 1:
                N(canvas);
                break;
            case 2:
                O(canvas);
                break;
        }
        super.dispatchDraw(canvas);
    }

    public int K(CharSequence title, int index) {
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(yo.x_tab_layout_title_view, (ViewGroup) this, false);
        textView.setText(title);
        textView.setTextColor(this.h);
        textView.setTextSize(0, this.g);
        textView.setTag(Boolean.valueOf(index == this.O));
        int i2 = this.O;
        if (index <= i2) {
            this.O = i2 + 1;
        }
        textView.setSoundEffectsEnabled(isSoundEffectsEnabled());
        addView(textView, index);
        return index;
    }

    public int H(int iconId, int index, String vuiLabel) {
        XImageView imageView = new XImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(iconId);
        imageView.setVuiElementType(oo.TEXTVIEW);
        imageView.setVuiLabel(vuiLabel);
        imageView.setTag(Boolean.valueOf(index == this.O));
        int i2 = this.O;
        if (index <= i2) {
            this.O = i2 + 1;
        }
        imageView.setSoundEffectsEnabled(isSoundEffectsEnabled());
        addView(imageView, index);
        return index;
    }

    public void setAllTabClickable(boolean clickable) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View view = getChildAt(i2);
            view.setClickable(clickable);
        }
    }

    public int J(CharSequence title) {
        int index = getChildCount();
        return K(title, index);
    }

    public int I(int iconId, String vuiLabel) {
        int index = getChildCount();
        return H(iconId, index, vuiLabel);
    }

    public final void Y(int index, boolean animator, boolean fromUser) {
        boolean shouldNotifyTabChange;
        if (index >= getTabCount() || index < 0 || index == this.O) {
            return;
        }
        i iVar = this.X;
        if (iVar != null && iVar.b(this, index, true, fromUser)) {
            return;
        }
        View targetView = getChildAt(index);
        View currentView = getSelectView();
        if (targetView != currentView) {
            if (targetView != null) {
                targetView.setSelected(true);
            }
            if (currentView != null) {
                currentView.setSelected(false);
            }
            this.O = index;
            shouldNotifyTabChange = true;
        } else {
            shouldNotifyTabChange = false;
        }
        X(animator, new c(shouldNotifyTabChange, targetView, fromUser, index));
    }

    /* loaded from: classes.dex */
    public class c implements h {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ View b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;

        public c(boolean z, View view, boolean z2, int i) {
            this.a = z;
            this.b = view;
            this.c = z2;
            this.d = i;
        }

        @Override // com.xiaopeng.xui.widget.XTabLayout.h
        public void a() {
            if (this.a && XTabLayout.this.X != null) {
                if (this.b == null) {
                    XTabLayout.this.X.c(XTabLayout.this, -1, true, this.c);
                } else {
                    XTabLayout.this.X.c(XTabLayout.this, this.d, true, this.c);
                }
            }
        }

        @Override // com.xiaopeng.xui.widget.XTabLayout.h
        public void b() {
            if (this.a && XTabLayout.this.X != null) {
                if (this.b == null) {
                    XTabLayout.this.X.a(XTabLayout.this, -1, true, this.c);
                } else {
                    XTabLayout.this.X.a(XTabLayout.this, this.d, true, this.c);
                }
            }
            XTabLayout xTabLayout = XTabLayout.this;
            xTabLayout.m(xTabLayout);
        }
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mq.d(newConfig)) {
            setStyle(U() ? 2 : 1);
        }
    }

    public final int R(int selectedTabIndex) {
        if (selectedTabIndex < 0 || getWidth() <= 0) {
            return 0;
        }
        if (this.P == 2) {
            int tabWidth = (getWidth() - (this.d * 2)) / getTabCount();
            int start = (selectedTabIndex * tabWidth) + P(tabWidth) + this.d;
            return start;
        }
        int start2 = (selectedTabIndex * (getWidth() / getTabCount())) + 0;
        return start2;
    }

    public final int Q(int selectedTabIndex) {
        if (selectedTabIndex < 0 || getWidth() <= 0) {
            return 0;
        }
        if (this.P == 2) {
            int tabWidth = (getWidth() - (this.d * 2)) / getTabCount();
            int end = (((selectedTabIndex + 1) * tabWidth) - P(tabWidth)) + this.d;
            return end;
        }
        int tabWidth2 = getWidth();
        int end2 = ((selectedTabIndex + 1) * (tabWidth2 / getTabCount())) + 0;
        return end2;
    }

    public final int P(int tabWidth) {
        float offset;
        float f2 = this.i;
        if (f2 != 0.0f) {
            offset = (tabWidth - f2) / 2.0f;
        } else {
            float f3 = (1.0f - this.j) / 2.0f;
            offset = tabWidth * f3;
        }
        return (int) offset;
    }

    private void getIndicatorPosition() {
        int selectedTabIndex = getSelectedTabIndex();
        if (selectedTabIndex < 0) {
            this.F = 0;
            this.H = 0;
            this.G = 0;
            this.I = 0;
            return;
        }
        this.F = R(selectedTabIndex);
        int Q = Q(selectedTabIndex);
        this.H = Q;
        this.G = this.F;
        this.I = Q;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    public final void X(boolean animator, h listener) {
        if (getTabCount() <= 0) {
            return;
        }
        boolean animator2 = animator && this.f;
        getIndicatorPosition();
        if (animator2) {
            if (this.Q == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.Q = ofFloat;
                ofFloat.setDuration(300L);
                this.Q.addUpdateListener(new d());
                this.Q.addListener(new e());
                this.Q.setInterpolator(new AccelerateDecelerateInterpolator());
            }
            this.Q.addListener(new f(listener));
            this.Q.start();
            return;
        }
        L();
        if (listener != null) {
            listener.a();
            listener.b();
        }
        invalidate();
    }

    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            float value = ((Float) animation.getAnimatedValue()).floatValue();
            float p = Math.min(value, XTabLayout.this.N) / XTabLayout.this.N;
            if (value < XTabLayout.this.N) {
                XTabLayout xTabLayout = XTabLayout.this;
                xTabLayout.A = (int) (xTabLayout.y - ((value / XTabLayout.this.N) * (XTabLayout.this.y - XTabLayout.this.z)));
            } else {
                XTabLayout xTabLayout2 = XTabLayout.this;
                xTabLayout2.A = (int) (xTabLayout2.y + ((((value - XTabLayout.this.N) / (1.0f - XTabLayout.this.N)) - 1.0f) * (XTabLayout.this.y - XTabLayout.this.z)));
            }
            if (XTabLayout.this.F > XTabLayout.this.B) {
                XTabLayout xTabLayout3 = XTabLayout.this;
                xTabLayout3.J = (int) (xTabLayout3.B + (Math.pow(value, 1.048d) * (XTabLayout.this.F - XTabLayout.this.B)));
                XTabLayout xTabLayout4 = XTabLayout.this;
                xTabLayout4.L = (int) (xTabLayout4.C + ((XTabLayout.this.H - XTabLayout.this.C) * p));
            } else {
                XTabLayout xTabLayout5 = XTabLayout.this;
                xTabLayout5.J = (int) (xTabLayout5.B + ((XTabLayout.this.F - XTabLayout.this.B) * p));
                XTabLayout xTabLayout6 = XTabLayout.this;
                xTabLayout6.L = (int) (xTabLayout6.C + (Math.pow(value, 1.048d) * (XTabLayout.this.H - XTabLayout.this.C)));
            }
            if (XTabLayout.this.G > XTabLayout.this.D) {
                XTabLayout xTabLayout7 = XTabLayout.this;
                xTabLayout7.K = (int) (xTabLayout7.D + (Math.pow(value, 4.648d) * (XTabLayout.this.G - XTabLayout.this.D)));
                XTabLayout xTabLayout8 = XTabLayout.this;
                xTabLayout8.M = (int) (xTabLayout8.E + ((XTabLayout.this.I - XTabLayout.this.E) * p));
            } else {
                XTabLayout xTabLayout9 = XTabLayout.this;
                xTabLayout9.K = (int) (xTabLayout9.D + ((XTabLayout.this.G - XTabLayout.this.D) * p));
                XTabLayout xTabLayout10 = XTabLayout.this;
                xTabLayout10.M = (int) (xTabLayout10.E + (Math.pow(value, 4.648d) * (XTabLayout.this.I - XTabLayout.this.E)));
            }
            XTabLayout.this.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            super.onAnimationStart(animation);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            XTabLayout.this.L();
            XTabLayout.this.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {
        public final /* synthetic */ h a;

        public f(h hVar) {
            this.a = hVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            super.onAnimationStart(animation);
            h hVar = this.a;
            if (hVar != null) {
                hVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            XTabLayout.this.Q.removeListener(this);
            h hVar = this.a;
            if (hVar != null) {
                hVar.b();
            }
        }
    }

    public final void L() {
        int i2 = this.F;
        this.B = i2;
        int i3 = this.H;
        this.C = i3;
        this.D = this.G;
        int i4 = this.I;
        this.E = i4;
        this.J = i2;
        this.L = i3;
        this.K = i2;
        this.M = i4;
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setEnabled(enabled);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 > 26) {
            int alpha = enabled ? 255 : 92;
            this.u.setAlpha(alpha);
            this.v.setAlpha(alpha);
            this.w.setAlpha(alpha);
            this.x.setAlpha(alpha);
            invalidate();
        }
    }

    public boolean T(int position) {
        int childCount = getChildCount();
        View view = getChildAt(position);
        if (position < childCount && view != null) {
            return view.isEnabled();
        }
        return false;
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            XTabLayout.this.X(false, null);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        post(new g());
    }

    public int getSelectedTabIndex() {
        return this.O;
    }

    public int getTabCount() {
        return getChildCount();
    }

    public final void N(Canvas canvas) {
        if (!U()) {
            this.u.setMaskFilter(null);
        }
        this.u.setAlpha(T(this.O) ? 255 : 92);
        float indicatorHeight = getHeight() * 1.0f;
        float r = indicatorHeight / 2.0f;
        float top = getHeight() >> 1;
        int i2 = this.J;
        int i3 = this.L;
        if (i2 < i3) {
            float diff = indicatorHeight / 2.0f;
            canvas.drawRoundRect(i2, top - diff, i3, top + diff, r, r, this.u);
            return;
        }
        float diff2 = indicatorHeight / 2.0f;
        canvas.drawRoundRect(i3, top - diff2, i2, top + diff2, r, r, this.u);
    }

    public final void O(Canvas canvas) {
        if (U()) {
            this.u.setMaskFilter(new BlurMaskFilter(this.p, BlurMaskFilter.Blur.SOLID));
            this.w.setMaskFilter(new BlurMaskFilter(this.s, BlurMaskFilter.Blur.SOLID));
        } else {
            this.u.setMaskFilter(null);
            this.w.setMaskFilter(null);
        }
        this.u.setAlpha(T(this.O) ? 255 : 92);
        this.w.setAlpha(T(this.O) ? 255 : 92);
        float r = this.A / 2.0f;
        float bottom = getHeight() - this.k;
        if (this.K < this.M) {
            float diff = Math.max(this.A, 1.0f);
            canvas.drawRoundRect(this.K, bottom - diff, this.M, bottom, r, r, this.w);
            return;
        }
        float diff2 = Math.max(this.A, 1.0f);
        canvas.drawRoundRect(this.M, bottom - diff2, this.K, bottom, r, r, this.w);
    }

    public int M(int dp) {
        return (int) TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    public void setOnTabChangeListener(i onTabChangeListener) {
        this.X = onTabChangeListener;
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Z && this.a0 != U()) {
            this.Z = false;
            setStyle(U() ? 2 : 1);
        }
    }

    public final boolean U() {
        if (isInEditMode()) {
            return false;
        }
        return mq.a(getContext());
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Z = true;
        this.a0 = U();
    }

    @Override // android.view.View
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        super.setSoundEffectsEnabled(soundEffectsEnabled);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View view = getChildAt(i2);
            if (view != null) {
                view.setSoundEffectsEnabled(soundEffectsEnabled);
            }
        }
    }
}
