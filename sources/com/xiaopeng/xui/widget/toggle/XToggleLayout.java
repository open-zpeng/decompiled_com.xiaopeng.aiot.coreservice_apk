package com.xiaopeng.xui.widget.toggle;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import com.xiaopeng.xui.widget.XRelativeLayout;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XToggleLayout extends XRelativeLayout implements Checkable {
    public static final int[] b = {16842912};
    public boolean d;
    public boolean f;
    public boolean g;
    public wp h;
    public boolean i;
    public a j;
    public boolean k;
    public float l;
    public Drawable m;

    /* loaded from: classes.dex */
    public interface a {
        void a(XToggleLayout xToggleLayout, boolean z);

        boolean b(XToggleLayout xToggleLayout);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiAction() {
        return super.getVuiAction();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiBizId() {
        return super.getVuiBizId();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
        return super.getVuiDisableHitEffect();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
        return super.getVuiElementChangedListener();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiElementId() {
        return super.getVuiElementId();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ oo getVuiElementType() {
        return super.getVuiElementType();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
        return super.getVuiFatherElementId();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
        return super.getVuiFatherLabel();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
        return super.getVuiFeedbackType();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiLabel() {
        return super.getVuiLabel();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ qo getVuiMode() {
        return super.getVuiMode();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ int getVuiPosition() {
        return super.getVuiPosition();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ ro getVuiPriority() {
        return super.getVuiPriority();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
        return super.getVuiProps();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ Object getVuiValue() {
        return super.getVuiValue();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
        super.setPerformVuiAction(z);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiAction(String str) {
        super.setVuiAction(str);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
        super.setVuiBizId(str);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
        super.setVuiDisableHitEffect(z);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
        super.setVuiElementChangedListener(koVar);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
        super.setVuiElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
        super.setVuiElementType(ooVar);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
        super.setVuiFatherElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
        super.setVuiFatherLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
        super.setVuiFeedbackType(poVar);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
        super.setVuiLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
        super.setVuiLayoutLoadable(z);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
        super.setVuiMode(qoVar);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
        super.setVuiPosition(i);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
        super.setVuiPriority(roVar);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
        super.setVuiProps(jSONObject);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
        super.setVuiValue(obj);
    }

    public void setLoading(boolean loading) {
        if (this.g != loading) {
            this.g = loading;
            if (loading) {
                setEnabled(false);
                if (this.h == null) {
                    wp wpVar = new wp();
                    this.h = wpVar;
                    wpVar.g(getContext(), null);
                    this.h.setCallback(this);
                    this.h.k(1);
                    int width = getMeasuredWidth();
                    int height = getMeasuredHeight();
                    if (width != 0 && height != 0) {
                        this.h.setBounds(0, 0, width, height);
                    }
                }
                invalidate();
                return;
            }
            wp wpVar2 = this.h;
            if (wpVar2 != null) {
                wpVar2.a();
            }
            setEnabled(true);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        wp wpVar = this.h;
        if (wpVar != null) {
            wpVar.setBounds(0, 0, w, h);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        i(getBackground());
        h();
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        super.setBackground(background);
        i(background);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setAlpha(isEnabled() ? 255 : (int) (this.l * 255.0f));
        }
    }

    public final void h() {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child instanceof Checkable) {
                Checkable checkable = (Checkable) child;
                checkable.setChecked(this.i);
                child.setEnabled(this.k);
            }
        }
    }

    public final void d() {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child instanceof Checkable) {
                Checkable checkable = (Checkable) child;
                checkable.setChecked(this.i);
            }
        }
    }

    public final void f() {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child instanceof Checkable) {
                child.setEnabled(this.k);
            }
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        return who == this.h || super.verifyDrawable(who);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.g) {
            wp wpVar = this.h;
            if (wpVar != null) {
                wpVar.draw(canvas);
                return;
            }
            return;
        }
        super.dispatchDraw(canvas);
    }

    public void setOnCheckedChangeListener(a listener) {
        this.j = listener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            RelativeLayout.mergeDrawableStates(drawableState, b);
        }
        return drawableState;
    }

    public final void i(Drawable backgroundDrawable) {
        if (backgroundDrawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) backgroundDrawable;
            this.m = layerDrawable.findDrawableByLayerId(16908311);
            return;
        }
        this.m = null;
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (this.k != enabled) {
            this.k = enabled;
            f();
        }
    }

    public void setChecked(boolean checked) {
        if (this.f) {
            throw new IllegalStateException("Cannot change check state in onInterceptClickCheck");
        }
        if (this.i != checked) {
            this.i = checked;
            d();
            refreshDrawableState();
            if (this.d) {
                return;
            }
            this.d = true;
            a aVar = this.j;
            if (aVar != null) {
                aVar.a(this, this.i);
            }
            this.d = false;
            m(this);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean intercept = false;
        this.f = true;
        a aVar = this.j;
        if (aVar != null) {
            intercept = aVar.b(this);
        }
        this.f = false;
        if (!intercept) {
            toggle();
        }
        boolean handled = super.performClick();
        if (!handled) {
            playSoundEffect(0);
        }
        return handled;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.i;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.i);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        wp wpVar = this.h;
        if (wpVar != null) {
            wpVar.g(getContext(), newConfig);
        }
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        wp wpVar = this.h;
        if (wpVar != null) {
            wpVar.g(getContext(), getResources().getConfiguration());
            this.h.a();
            invalidate();
        }
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        wp wpVar = this.h;
        if (wpVar != null) {
            wpVar.a();
        }
    }
}
