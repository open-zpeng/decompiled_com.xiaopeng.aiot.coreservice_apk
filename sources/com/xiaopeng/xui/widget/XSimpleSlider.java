package com.xiaopeng.xui.widget;

import android.content.res.Configuration;
import xiaopeng.widget.SimpleSlider;
/* loaded from: classes.dex */
public class XSimpleSlider extends SimpleSlider {
    public uq s;

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        uq uqVar = this.s;
        if (uqVar != null) {
            uqVar.g(newConfig);
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uq uqVar = this.s;
        if (uqVar != null) {
            uqVar.f();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uq uqVar = this.s;
        if (uqVar != null) {
            uqVar.h();
        }
    }

    @Override // android.view.View
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
