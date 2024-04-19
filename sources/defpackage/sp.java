package defpackage;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
/* compiled from: XActivityWindowVisible.java */
/* renamed from: sp  reason: default package */
/* loaded from: classes.dex */
public class sp implements pp {
    public Activity a;
    public float b;
    public boolean c;

    public sp(Activity mActivity) {
        this.a = mActivity;
    }

    public void k(boolean enable) {
        if (enable != this.c) {
            rq.e("XActivityWindowVisible", "setAutoVisibleEnableOnPause: " + enable);
        }
        this.c = enable;
    }

    public void f(boolean visible) {
        if (this.c) {
            rq.e("XActivityWindowVisible", "changeWindowVisible: " + visible);
            Window window = this.a.getWindow();
            if (window != null) {
                WindowManager.LayoutParams lp = window.getAttributes();
                if (lp != null) {
                    lp.alpha = visible ? 1.0f : 0.0f;
                    lp.dimAmount = visible ? this.b : 0.0f;
                }
                window.setAttributes(lp);
            }
        }
    }

    @Override // defpackage.pp
    public void j(Bundle savedInstanceState) {
        TypedArray array = this.a.getTheme().obtainStyledAttributes(new int[]{16842802});
        this.b = array.getFloat(0, 1.0f);
        array.recycle();
    }

    @Override // defpackage.pp
    public void c() {
        f(true);
    }

    @Override // defpackage.pp
    public void onPause() {
        f(false);
    }

    public String toString() {
        return "{mDimAlpha=" + this.b + ", mAutoVisibility=" + this.c + ", mActivity=" + this.a + '}';
    }
}
