package com.xiaopeng.xui.widget;

import android.content.res.Configuration;
import android.widget.ToggleButton;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XToggleButton extends ToggleButton implements dr {
    public uq a;

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiAction() {
        return super.getVuiAction();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiBizId() {
        return super.getVuiBizId();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
        return super.getVuiDisableHitEffect();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
        return super.getVuiElementChangedListener();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiElementId() {
        return super.getVuiElementId();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ oo getVuiElementType() {
        return super.getVuiElementType();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
        return super.getVuiFatherElementId();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
        return super.getVuiFatherLabel();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
        return super.getVuiFeedbackType();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiLabel() {
        return super.getVuiLabel();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ qo getVuiMode() {
        return super.getVuiMode();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ int getVuiPosition() {
        return super.getVuiPosition();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ ro getVuiPriority() {
        return super.getVuiPriority();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
        return super.getVuiProps();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ Object getVuiValue() {
        return super.getVuiValue();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
        super.setPerformVuiAction(z);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiAction(String str) {
        super.setVuiAction(str);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
        super.setVuiBizId(str);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
        super.setVuiDisableHitEffect(z);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
        super.setVuiElementChangedListener(koVar);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
        super.setVuiElementId(str);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
        super.setVuiElementType(ooVar);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
        super.setVuiFatherElementId(str);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
        super.setVuiFatherLabel(str);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
        super.setVuiFeedbackType(poVar);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
        super.setVuiLabel(str);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
        super.setVuiLayoutLoadable(z);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
        super.setVuiMode(qoVar);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
        super.setVuiPosition(i);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
        super.setVuiPriority(roVar);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
        super.setVuiProps(jSONObject);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
        super.setVuiValue(obj);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        uq uqVar = this.a;
        if (uqVar != null) {
            uqVar.g(newConfig);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uq uqVar = this.a;
        if (uqVar != null) {
            uqVar.f();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uq uqVar = this.a;
        if (uqVar != null) {
            uqVar.h();
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        b(this, visibility);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        l(this, selected);
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean checked) {
        boolean isChecked = isChecked();
        super.setChecked(checked);
        if (isChecked != checked) {
            m(this);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        k();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (nq.a()) {
            if (enabled) {
                setAlpha(1.0f);
            } else {
                setAlpha(0.4f);
            }
        }
    }
}
