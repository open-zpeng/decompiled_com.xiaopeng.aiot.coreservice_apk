package defpackage;

import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
/* compiled from: XViewDelegate.java */
/* renamed from: uq  reason: default package */
/* loaded from: classes.dex */
public abstract class uq {

    /* compiled from: XViewDelegate.java */
    /* renamed from: uq$a */
    /* loaded from: classes.dex */
    public interface a {
        void d();
    }

    public abstract fo e();

    public abstract void f();

    public abstract void g(Configuration configuration);

    public abstract void h();

    public abstract void i(a aVar);

    public static uq a(View view, AttributeSet attrs) {
        return c(view, attrs, 0, 0);
    }

    public static uq b(View view, AttributeSet attrs, int defStyleAttr) {
        return c(view, attrs, defStyleAttr, 0);
    }

    public static uq c(View view, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        return new vq(view, attrs, defStyleAttr, defStyleRes, null);
    }

    public static uq d(View view, AttributeSet attrs, int defStyleAttr, int defStyleRes, Object extras) {
        return new vq(view, attrs, defStyleAttr, defStyleRes, extras);
    }
}
