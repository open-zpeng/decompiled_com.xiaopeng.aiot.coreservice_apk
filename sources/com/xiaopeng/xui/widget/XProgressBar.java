package com.xiaopeng.xui.widget;

import android.content.res.Configuration;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
public class XProgressBar extends ProgressBar {
    public uq a;

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        uq uqVar = this.a;
        if (uqVar != null) {
            uqVar.g(newConfig);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uq uqVar = this.a;
        if (uqVar != null) {
            uqVar.f();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uq uqVar = this.a;
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
