package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;
/* compiled from: AppCompatDelegate.java */
/* renamed from: a0  reason: default package */
/* loaded from: classes.dex */
public abstract class a0 {
    public static int a = -100;
    public static final u3<WeakReference<a0>> b = new u3<>();
    public static final Object d = new Object();

    public abstract boolean A(int i);

    public abstract void B(int i);

    public abstract void C(View view);

    public abstract void D(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void F(CharSequence charSequence);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    public abstract View i(View view, String str, Context context, AttributeSet attributeSet);

    public abstract <T extends View> T j(int i);

    public abstract MenuInflater m();

    public abstract x n();

    public abstract void o();

    public abstract void p();

    public abstract void q(Configuration configuration);

    public abstract void r(Bundle bundle);

    public abstract void s();

    public abstract void t(Bundle bundle);

    public abstract void u();

    public abstract void v(Bundle bundle);

    public abstract void w();

    public abstract void x();

    public static a0 g(Activity activity, z callback) {
        return new b0(activity, callback);
    }

    public static a0 h(Dialog dialog, z callback) {
        return new b0(dialog, callback);
    }

    public void E(int themeResId) {
    }

    @Deprecated
    public void e(Context context) {
    }

    public Context f(Context context) {
        e(context);
        return context;
    }

    public int l() {
        return -100;
    }

    public static int k() {
        return a;
    }

    public static void c(a0 delegate) {
        synchronized (d) {
            z(delegate);
            b.add(new WeakReference<>(delegate));
        }
    }

    public static void y(a0 delegate) {
        synchronized (d) {
            z(delegate);
        }
    }

    public static void z(a0 toRemove) {
        synchronized (d) {
            Iterator<WeakReference<a0>> it = b.iterator();
            while (it.hasNext()) {
                a0 delegate = it.next().get();
                if (delegate == toRemove || delegate == null) {
                    it.remove();
                }
            }
        }
    }
}
