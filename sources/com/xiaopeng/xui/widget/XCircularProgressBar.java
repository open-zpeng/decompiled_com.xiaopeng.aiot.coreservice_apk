package com.xiaopeng.xui.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
public class XCircularProgressBar extends ProgressBar {
    public static final int[] a = {to.progress_state_playing_stop};
    public static final int[] b = {to.progress_state_playing_pause};
    public static final int[] d = {to.progress_state_paused};
    public static final int[] f = {to.progress_state_start_download};
    public boolean g;
    public int h;
    public float i;
    public float j;
    public float k;
    public Drawable l;
    public Drawable m;
    public Drawable n;
    public Drawable o;
    public zp p;
    public xp q;
    public yp r;
    public uq s;

    public void setIndicatorType(int indicatorType) {
        if (this.h == 3) {
            super.setProgress(getMin());
        }
        if (indicatorType == 3) {
            super.setProgress(getMax());
        }
        this.h = indicatorType;
        refreshDrawableState();
    }

    public int getIndicatorType() {
        return this.h;
    }

    public void setEnableIndicator(boolean enableIndicator) {
        this.g = enableIndicator;
        refreshDrawableState();
    }

    public final void b(Drawable progressDrawable) {
        if (progressDrawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) progressDrawable;
            Drawable pgDrawable = layerDrawable.findDrawableByLayerId(16908301);
            if (pgDrawable instanceof zp) {
                this.p = (zp) pgDrawable;
            }
            Drawable background = layerDrawable.findDrawableByLayerId(16908288);
            if (background instanceof xp) {
                this.q = (xp) background;
            }
        }
    }

    public final void a(Drawable indeterminateDrawable) {
        if (indeterminateDrawable instanceof RotateDrawable) {
            Drawable indeterminate = ((RotateDrawable) indeterminateDrawable).getDrawable();
            if (indeterminate instanceof yp) {
                this.r = (yp) indeterminate;
            }
        }
    }

    public final void d() {
        zp zpVar = this.p;
        if (zpVar != null) {
            zpVar.a(this.i);
            this.p.c(this.j);
            this.p.b(this.k);
        }
        xp xpVar = this.q;
        if (xpVar != null) {
            xpVar.f(this.i);
            this.q.g(this.j);
            this.q.c(this.l);
            this.q.b(this.n);
            this.q.e(this.m);
            this.q.d(this.o);
        }
    }

    public final void c() {
        yp ypVar = this.r;
        if (ypVar != null) {
            ypVar.a(this.i);
            this.r.c(this.j);
            this.r.b(this.k);
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int progress) {
        if (this.h == 3) {
            progress = getMax();
        }
        super.setProgress(progress);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable d2) {
        b(d2);
        d();
        super.setProgressDrawable(d2);
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable d2) {
        a(d2);
        c();
        super.setIndeterminateDrawable(d2);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.s.g(newConfig);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s.f();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s.h();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean indeterminate) {
        super.setIndeterminate(indeterminate);
        if (!indeterminate) {
            refreshDrawableState();
        }
    }

    @Override // android.view.View
    public int[] onCreateDrawableState(int extraSpace) {
        if (isIndeterminate() || !this.g) {
            return super.onCreateDrawableState(extraSpace);
        }
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        int i = this.h;
        if (i == 0) {
            ProgressBar.mergeDrawableStates(drawableState, d);
        } else if (i == 1) {
            ProgressBar.mergeDrawableStates(drawableState, a);
        } else if (i == 2) {
            ProgressBar.mergeDrawableStates(drawableState, b);
        } else if (i == 3) {
            ProgressBar.mergeDrawableStates(drawableState, f);
        }
        return drawableState;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (isEnabled()) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.16f);
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
