package com.xiaopeng.xui.vui.floatinglayer;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.widget.FrameLayout;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class VuiFloatingView extends FrameLayout {
    public Drawable a;
    public AnimatedImageDrawable b;
    public int d;
    public a f;
    public boolean g;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);
    }

    public void a() {
        this.g = true;
    }

    public void setOnTouchListener(a onTouchListener) {
        this.f = onTouchListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        a aVar;
        if ((event.getAction() == 0 || event.getAction() == 4) && (aVar = this.f) != null) {
            aVar.a(this.d);
            if (this.b != null) {
                a();
                return true;
            }
            return true;
        }
        return true;
    }

    public int getVisibleHeight() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return 0;
    }

    public int getVisibleWidth() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        rq.e("VuiFloatingView", "onAttachedToWindow type : " + this.d);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rq.a("VuiFloatingView", "onDetachedFromWindow type : " + this.d);
    }
}
