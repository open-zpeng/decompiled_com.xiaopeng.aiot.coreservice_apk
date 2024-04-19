package defpackage;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
/* compiled from: ActionMode.java */
/* renamed from: r0  reason: default package */
/* loaded from: classes.dex */
public abstract class r0 {
    public Object a;
    public boolean b;

    /* compiled from: ActionMode.java */
    /* renamed from: r0$a */
    /* loaded from: classes.dex */
    public interface a {
        boolean a(r0 r0Var, Menu menu);

        void b(r0 r0Var);

        boolean c(r0 r0Var, MenuItem menuItem);

        boolean d(r0 r0Var, Menu menu);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public abstract CharSequence i();

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i);

    public abstract void o(CharSequence charSequence);

    public abstract void q(int i);

    public abstract void r(CharSequence charSequence);

    public void p(Object tag) {
        this.a = tag;
    }

    public Object h() {
        return this.a;
    }

    public void s(boolean titleOptional) {
        this.b = titleOptional;
    }

    public boolean j() {
        return this.b;
    }
}
