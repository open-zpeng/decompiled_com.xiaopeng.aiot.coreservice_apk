package defpackage;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import defpackage.f1;
import defpackage.r0;
import java.lang.ref.WeakReference;
/* compiled from: StandaloneActionMode.java */
/* renamed from: u0  reason: default package */
/* loaded from: classes.dex */
public class u0 extends r0 implements f1.a {
    public Context d;
    public ActionBarContextView f;
    public r0.a g;
    public WeakReference<View> h;
    public boolean i;
    public boolean j;
    public f1 k;

    public u0(Context context, ActionBarContextView view, r0.a callback, boolean isFocusable) {
        this.d = context;
        this.f = view;
        this.g = callback;
        f1 S = new f1(view.getContext()).S(1);
        this.k = S;
        S.R(this);
        this.j = isFocusable;
    }

    @Override // defpackage.r0
    public void r(CharSequence title) {
        this.f.setTitle(title);
    }

    @Override // defpackage.r0
    public void o(CharSequence subtitle) {
        this.f.setSubtitle(subtitle);
    }

    @Override // defpackage.r0
    public void q(int resId) {
        r(this.d.getString(resId));
    }

    @Override // defpackage.r0
    public void n(int resId) {
        o(this.d.getString(resId));
    }

    @Override // defpackage.r0
    public void s(boolean titleOptional) {
        super.s(titleOptional);
        this.f.setTitleOptional(titleOptional);
    }

    @Override // defpackage.r0
    public boolean l() {
        return this.f.j();
    }

    @Override // defpackage.r0
    public void m(View view) {
        this.f.setCustomView(view);
        this.h = view != null ? new WeakReference<>(view) : null;
    }

    @Override // defpackage.r0
    public void k() {
        this.g.a(this, this.k);
    }

    @Override // defpackage.r0
    public void c() {
        if (this.i) {
            return;
        }
        this.i = true;
        this.f.sendAccessibilityEvent(32);
        this.g.b(this);
    }

    @Override // defpackage.r0
    public Menu e() {
        return this.k;
    }

    @Override // defpackage.r0
    public CharSequence i() {
        return this.f.getTitle();
    }

    @Override // defpackage.r0
    public CharSequence g() {
        return this.f.getSubtitle();
    }

    @Override // defpackage.r0
    public View d() {
        WeakReference<View> weakReference = this.h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // defpackage.r0
    public MenuInflater f() {
        return new w0(this.f.getContext());
    }

    @Override // defpackage.f1.a
    public boolean a(f1 menu, MenuItem item) {
        return this.g.c(this, item);
    }

    @Override // defpackage.f1.a
    public void b(f1 menu) {
        k();
        this.f.l();
    }
}
