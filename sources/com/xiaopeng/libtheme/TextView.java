package com.xiaopeng.libtheme;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class TextView extends android.widget.TextView {
    public fo a;

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.a.j(this, newConfig);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a.i(this);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.k(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
    }

    @Override // android.view.View
    public void setBackgroundResource(int resid) {
        super.setBackgroundResource(resid);
        this.a.l(resid);
    }

    @Override // android.widget.TextView
    public void setTextColor(int color) {
        super.setTextColor(color);
    }
}
