package defpackage;

import android.app.Activity;
import android.view.WindowManager;
/* compiled from: XActivityWindowAttributes.java */
/* renamed from: rp  reason: default package */
/* loaded from: classes.dex */
public class rp {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public final Activity h;

    public rp(Activity activity) {
        this.h = activity;
        b();
    }

    public final void b() {
        WindowManager.LayoutParams lp;
        Activity activity = this.h;
        if (activity != null && activity.getWindow() != null && (lp = this.h.getWindow().getAttributes()) != null) {
            this.a = lp.x;
            this.b = lp.y;
            this.e = lp.flags;
            this.c = lp.width;
            this.d = lp.height;
            this.f = lp.gravity;
            this.g = lp.systemUiVisibility;
        }
    }

    public void a() {
        WindowManager.LayoutParams lp;
        Activity activity = this.h;
        if (activity != null && activity.getWindow() != null && (lp = this.h.getWindow().getAttributes()) != null) {
            lp.x = this.a;
            lp.y = this.b;
            lp.flags |= this.e;
            lp.width = this.c;
            lp.height = this.d;
            lp.gravity = this.f;
            lp.systemUiVisibility |= this.g;
            this.h.getWindow().setAttributes(lp);
        }
    }

    public rp f(int x) {
        this.a = x;
        return this;
    }

    public rp g(int y) {
        this.b = y;
        return this;
    }

    public rp e(int width) {
        this.c = width;
        return this;
    }

    public rp d(int height) {
        this.d = height;
        return this;
    }

    public rp c(int gravity) {
        this.f = gravity;
        return this;
    }

    public String toString() {
        return "{x=" + this.a + ", y=" + this.b + ", width=" + this.c + ", height=" + this.d + ", flags=" + this.e + ", gravity=" + this.f + ", systemUiVisibility=" + this.g + ", mActivity=" + this.h + '}';
    }
}
