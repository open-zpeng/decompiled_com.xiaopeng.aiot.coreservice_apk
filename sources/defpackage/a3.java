package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import defpackage.l1;
/* compiled from: ToolbarWidgetWrapper.java */
/* renamed from: a3  reason: default package */
/* loaded from: classes.dex */
public class a3 implements j2 {
    public Toolbar a;
    public int b;
    public View c;
    public View d;
    public Drawable e;
    public Drawable f;
    public Drawable g;
    public boolean h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;
    public Window.Callback l;
    public boolean m;
    public u1 n;
    public int o;
    public int p;
    public Drawable q;

    public a3(Toolbar toolbar, boolean style) {
        this(toolbar, style, u.a, r.abc_ic_ab_back_material);
    }

    public a3(Toolbar toolbar, boolean style, int defaultNavigationContentDescription, int defaultNavigationIcon) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        z2 a2 = z2.u(toolbar.getContext(), null, w.a, n.c, 0);
        this.q = a2.f(w.l);
        if (!style) {
            this.b = v();
        } else {
            CharSequence title = a2.o(w.r);
            if (!TextUtils.isEmpty(title)) {
                D(title);
            }
            CharSequence subtitle = a2.o(w.p);
            if (!TextUtils.isEmpty(subtitle)) {
                C(subtitle);
            }
            Drawable logo = a2.f(w.n);
            if (logo != null) {
                y(logo);
            }
            Drawable icon = a2.f(w.m);
            if (icon != null) {
                setIcon(icon);
            }
            if (this.g == null && (drawable = this.q) != null) {
                B(drawable);
            }
            n(a2.j(w.h, 0));
            int customNavId = a2.m(w.g, 0);
            if (customNavId != 0) {
                w(LayoutInflater.from(this.a.getContext()).inflate(customNavId, (ViewGroup) this.a, false));
                n(this.b | 16);
            }
            int height = a2.l(w.j, 0);
            if (height > 0) {
                ViewGroup.LayoutParams lp = this.a.getLayoutParams();
                lp.height = height;
                this.a.setLayoutParams(lp);
            }
            int contentInsetStart = a2.d(w.f, -1);
            int contentInsetEnd = a2.d(w.e, -1);
            if (contentInsetStart >= 0 || contentInsetEnd >= 0) {
                this.a.H(Math.max(contentInsetStart, 0), Math.max(contentInsetEnd, 0));
            }
            int titleTextStyle = a2.m(w.s, 0);
            if (titleTextStyle != 0) {
                Toolbar toolbar2 = this.a;
                toolbar2.K(toolbar2.getContext(), titleTextStyle);
            }
            int subtitleTextStyle = a2.m(w.q, 0);
            if (subtitleTextStyle != 0) {
                Toolbar toolbar3 = this.a;
                toolbar3.J(toolbar3.getContext(), subtitleTextStyle);
            }
            int popupTheme = a2.m(w.o, 0);
            if (popupTheme != 0) {
                this.a.setPopupTheme(popupTheme);
            }
        }
        a2.v();
        x(defaultNavigationContentDescription);
        this.k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new a());
    }

    /* compiled from: ToolbarWidgetWrapper.java */
    /* renamed from: a3$a */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public final z0 a;

        public a() {
            this.a = new z0(a3.this.a.getContext(), 0, 16908332, 0, 0, a3.this.i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            a3 a3Var = a3.this;
            Window.Callback callback = a3Var.l;
            if (callback != null && a3Var.m) {
                callback.onMenuItemSelected(0, this.a);
            }
        }
    }

    public void x(int defaultNavigationContentDescription) {
        if (defaultNavigationContentDescription == this.p) {
            return;
        }
        this.p = defaultNavigationContentDescription;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            z(this.p);
        }
    }

    public final int v() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        int opts = 11 | 4;
        this.q = this.a.getNavigationIcon();
        return opts;
    }

    @Override // defpackage.j2
    public ViewGroup k() {
        return this.a;
    }

    @Override // defpackage.j2
    public Context getContext() {
        return this.a.getContext();
    }

    @Override // defpackage.j2
    public boolean m() {
        return this.a.v();
    }

    @Override // defpackage.j2
    public void collapseActionView() {
        this.a.e();
    }

    @Override // defpackage.j2
    public void setWindowCallback(Window.Callback cb) {
        this.l = cb;
    }

    @Override // defpackage.j2
    public void setWindowTitle(CharSequence title) {
        if (!this.h) {
            E(title);
        }
    }

    @Override // defpackage.j2
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    public void D(CharSequence title) {
        this.h = true;
        E(title);
    }

    public final void E(CharSequence title) {
        this.i = title;
        if ((this.b & 8) != 0) {
            this.a.setTitle(title);
        }
    }

    public void C(CharSequence subtitle) {
        this.j = subtitle;
        if ((this.b & 8) != 0) {
            this.a.setSubtitle(subtitle);
        }
    }

    @Override // defpackage.j2
    public void s() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // defpackage.j2
    public void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // defpackage.j2
    public void setIcon(int resId) {
        setIcon(resId != 0 ? j0.d(getContext(), resId) : null);
    }

    @Override // defpackage.j2
    public void setIcon(Drawable d) {
        this.e = d;
        H();
    }

    @Override // defpackage.j2
    public void p(int resId) {
        y(resId != 0 ? j0.d(getContext(), resId) : null);
    }

    public void y(Drawable d) {
        this.f = d;
        H();
    }

    public final void H() {
        Drawable logo = null;
        int i = this.b;
        if ((i & 2) != 0) {
            if ((i & 1) != 0) {
                Drawable drawable = this.f;
                if (drawable == null) {
                    drawable = this.e;
                }
                logo = drawable;
            } else {
                logo = this.e;
            }
        }
        this.a.setLogo(logo);
    }

    @Override // defpackage.j2
    public boolean g() {
        return this.a.d();
    }

    @Override // defpackage.j2
    public boolean b() {
        return this.a.A();
    }

    @Override // defpackage.j2
    public boolean d() {
        return this.a.z();
    }

    @Override // defpackage.j2
    public boolean f() {
        return this.a.N();
    }

    @Override // defpackage.j2
    public boolean e() {
        return this.a.w();
    }

    @Override // defpackage.j2
    public void c() {
        this.m = true;
    }

    @Override // defpackage.j2
    public void a(Menu menu, l1.a cb) {
        if (this.n == null) {
            u1 u1Var = new u1(this.a.getContext());
            this.n = u1Var;
            u1Var.p(s.g);
        }
        this.n.k(cb);
        this.a.I((f1) menu, this.n);
    }

    @Override // defpackage.j2
    public void h() {
        this.a.f();
    }

    @Override // defpackage.j2
    public int o() {
        return this.b;
    }

    @Override // defpackage.j2
    public void n(int newOpts) {
        View view;
        int oldOpts = this.b;
        int changed = oldOpts ^ newOpts;
        this.b = newOpts;
        if (changed != 0) {
            if ((changed & 4) != 0) {
                if ((newOpts & 4) != 0) {
                    F();
                }
                G();
            }
            if ((changed & 3) != 0) {
                H();
            }
            if ((changed & 8) != 0) {
                if ((newOpts & 8) != 0) {
                    this.a.setTitle(this.i);
                    this.a.setSubtitle(this.j);
                } else {
                    this.a.setTitle((CharSequence) null);
                    this.a.setSubtitle((CharSequence) null);
                }
            }
            if ((changed & 16) != 0 && (view = this.d) != null) {
                if ((newOpts & 16) != 0) {
                    this.a.addView(view);
                } else {
                    this.a.removeView(view);
                }
            }
        }
    }

    @Override // defpackage.j2
    public void j(ScrollingTabContainerView tabView) {
        View view = this.c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.a;
            if (parent == toolbar) {
                toolbar.removeView(this.c);
            }
        }
        this.c = tabView;
        if (tabView != null && this.o == 2) {
            this.a.addView(tabView, 0);
            Toolbar.e lp = (Toolbar.e) this.c.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) lp).width = -2;
            ((ViewGroup.MarginLayoutParams) lp).height = -2;
            lp.a = 8388691;
            tabView.setAllowCollapse(true);
        }
    }

    @Override // defpackage.j2
    public void u(boolean collapsible) {
        this.a.setCollapsible(collapsible);
    }

    @Override // defpackage.j2
    public void l(boolean enable) {
    }

    @Override // defpackage.j2
    public int q() {
        return this.o;
    }

    public void w(View view) {
        View view2 = this.d;
        if (view2 != null && (this.b & 16) != 0) {
            this.a.removeView(view2);
        }
        this.d = view;
        if (view != null && (this.b & 16) != 0) {
            this.a.addView(view);
        }
    }

    @Override // defpackage.j2
    public ka r(int visibility, long duration) {
        return ga.b(this.a).a(visibility == 0 ? 1.0f : 0.0f).d(duration).f(new b(visibility));
    }

    /* compiled from: ToolbarWidgetWrapper.java */
    /* renamed from: a3$b */
    /* loaded from: classes.dex */
    public class b extends ma {
        public boolean a = false;
        public final /* synthetic */ int b;

        public b(int i) {
            this.b = i;
        }

        @Override // defpackage.ma, defpackage.la
        public void c(View view) {
            a3.this.a.setVisibility(0);
        }

        @Override // defpackage.la
        public void b(View view) {
            if (!this.a) {
                a3.this.a.setVisibility(this.b);
            }
        }

        @Override // defpackage.ma, defpackage.la
        public void a(View view) {
            this.a = true;
        }
    }

    public void B(Drawable icon) {
        this.g = icon;
        G();
    }

    public final void G() {
        if ((this.b & 4) != 0) {
            Toolbar toolbar = this.a;
            Drawable drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.a.setNavigationIcon((Drawable) null);
    }

    public void A(CharSequence description) {
        this.k = description;
        F();
    }

    public void z(int resId) {
        A(resId == 0 ? null : getContext().getString(resId));
    }

    public final void F() {
        if ((this.b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.k);
            }
        }
    }

    @Override // defpackage.j2
    public void i(int visible) {
        this.a.setVisibility(visible);
    }
}
