package com.xiaopeng.xui.widget;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XSegmented extends XLinearLayout implements View.OnClickListener {
    public static final String b = XSegmented.class.getSimpleName();
    public float d;
    public int f;
    public int[] g;
    public int h;
    public final vp i;
    public boolean j;
    public a k;
    public b l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(XSegmented xSegmented, int i, boolean z);

        boolean b(XSegmented xSegmented, int i);
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

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        if (this.m) {
            int width = this.n * count;
            if (count >= 5) {
                width = this.o * count;
            }
            if (View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                return;
            } else {
                int len = Math.min(width, this.q);
                widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(len, 1073741824);
            }
        } else if (View.MeasureSpec.getMode(heightMeasureSpec) == 1073741824) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        } else {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.p * count, 1073741824);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setTitleTextSize(float size) {
        this.d = size;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view instanceof TextView) {
                ((TextView) view).setTextSize(size);
            }
        }
    }

    public void setTitleTextColor(int colorRes) {
        this.f = colorRes;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(getContext().getColorStateList(colorRes));
            }
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void h(int res, CharSequence vuiLabel, int index) {
        if (getChildCount() > index) {
            View view = getChildAt(index);
            if (view instanceof XImageView) {
                XImageView xImageView = (XImageView) view;
                xImageView.setImageDrawable(getContext().getDrawable(res));
                if (vuiLabel != null) {
                    xImageView.setVuiLabel(vuiLabel.toString());
                }
                int[] iArr = this.g;
                if (iArr != null && iArr.length > index) {
                    iArr[index] = res;
                    return;
                }
                return;
            }
            rq.k(b, "setSegmentIcon failed, view is not XImageView");
            return;
        }
        rq.k(b, "setSegmentIcon failed, index > child count");
    }

    public void setSelection(int index) {
        i(index, true, false, false);
    }

    public final void i(int index, boolean playAnimation, boolean fromUser, boolean isEdt) {
        int i;
        int current = this.h;
        this.h = index;
        if (index < 0 || index >= getChildCount()) {
            this.h = -1;
        }
        int i2 = 0;
        while (i2 < getChildCount()) {
            getChildAt(i2).setSelected(this.h == i2);
            i2++;
        }
        vp vpVar = this.i;
        if (vpVar != null) {
            vpVar.c(getChildCount(), this.h, playAnimation);
            throw null;
        }
        d();
        b bVar = this.l;
        if (bVar != null && current != (i = this.h)) {
            bVar.a(this, i, fromUser);
        }
        if (current != this.h || isEdt) {
            m(this);
        }
    }

    public int getSelection() {
        return this.h;
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        for (int i = 0; i < getChildCount(); i++) {
            f(enabled, i);
        }
    }

    public void f(boolean enabled, int index) {
        if (index >= 0 && index < getChildCount()) {
            getChildAt(index).setEnabled(enabled);
            d();
        }
    }

    public final void d() {
        int i;
        if (this.i != null && (i = this.h) >= 0 && i < getChildCount()) {
            this.i.b(getChildAt(this.h).isEnabled());
            throw null;
        }
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.View
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mq.d(newConfig)) {
            setTitleTextColor(this.f);
            int[] iArr = this.g;
            if (iArr != null && iArr.length == getChildCount()) {
                int i = 0;
                while (true) {
                    int[] iArr2 = this.g;
                    if (i >= iArr2.length) {
                        break;
                    }
                    h(iArr2[i], null, i);
                    i++;
                }
            }
            vp vpVar = this.i;
            if (vpVar != null) {
                vpVar.a(getResources(), getContext().getTheme());
                throw null;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        vp vpVar = this.i;
        if (vpVar != null) {
            vpVar.setBounds(new Rect(l, t, r, b2));
            throw null;
        } else {
            this.r = getChildCount();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        vp vpVar = this.i;
        if (vpVar != null) {
            vpVar.setState(getDrawableState());
            throw null;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        vp vpVar = this.i;
        if (vpVar != null) {
            vpVar.draw(canvas);
            throw null;
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (this.j) {
            return;
        }
        int index = indexOfChild(v);
        b bVar = this.l;
        if (bVar == null || !bVar.b(this, index)) {
            i(indexOfChild(v), true, true, false);
        }
    }

    public void setSegmentListener(b segmentListener) {
        this.l = segmentListener;
    }

    public void setSegmentAnimatorListener(a segmentAnimatorListener) {
        this.k = segmentAnimatorListener;
    }
}
