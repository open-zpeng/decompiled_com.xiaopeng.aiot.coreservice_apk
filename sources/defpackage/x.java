package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import defpackage.r0;
/* compiled from: ActionBar.java */
/* renamed from: x  reason: default package */
/* loaded from: classes.dex */
public abstract class x {

    /* compiled from: ActionBar.java */
    /* renamed from: x$b */
    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    /* compiled from: ActionBar.java */
    @Deprecated
    /* renamed from: x$c */
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public abstract boolean h();

    public abstract void i(boolean z);

    public abstract int j();

    public abstract Context k();

    public abstract void m(Configuration configuration);

    public abstract boolean o(int i, KeyEvent keyEvent);

    public abstract void r(boolean z);

    public abstract void s(boolean z);

    public abstract void t(CharSequence charSequence);

    public abstract r0 u(r0.a aVar);

    public boolean q() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public boolean l() {
        return false;
    }

    public boolean p(KeyEvent event) {
        return false;
    }

    public void n() {
    }

    /* compiled from: ActionBar.java */
    /* renamed from: x$a */
    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public int a;

        public a(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.a = 0;
            TypedArray a = c.obtainStyledAttributes(attrs, w.t);
            this.a = a.getInt(w.u, 0);
            a.recycle();
        }

        public a(int width, int height) {
            super(width, height);
            this.a = 0;
            this.a = 8388627;
        }

        public a(a source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.a = 0;
            this.a = source.a;
        }

        public a(ViewGroup.LayoutParams source) {
            super(source);
            this.a = 0;
        }
    }
}
