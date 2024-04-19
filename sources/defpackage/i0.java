package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import defpackage.f1;
import defpackage.r0;
import defpackage.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* compiled from: WindowDecorActionBar.java */
/* renamed from: i0  reason: default package */
/* loaded from: classes.dex */
public class i0 extends x implements ActionBarOverlayLayout.d {
    public static final Interpolator a = new AccelerateInterpolator();
    public static final Interpolator b = new DecelerateInterpolator();
    public x0 A;
    public boolean B;
    public boolean C;
    public Context c;
    public Context d;
    public Activity e;
    public ActionBarOverlayLayout f;
    public ActionBarContainer g;
    public j2 h;
    public ActionBarContextView i;
    public View j;
    public ScrollingTabContainerView k;
    public boolean n;
    public d o;
    public r0 p;
    public r0.a q;
    public boolean r;
    public boolean t;
    public boolean w;
    public boolean x;
    public boolean y;
    public ArrayList<?> l = new ArrayList<>();
    public int m = -1;
    public ArrayList<x.b> s = new ArrayList<>();
    public int u = 0;
    public boolean v = true;
    public boolean z = true;
    public final la D = new a();
    public final la E = new b();
    public final na F = new c();

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: i0$a */
    /* loaded from: classes.dex */
    public class a extends ma {
        public a() {
        }

        @Override // defpackage.la
        public void b(View view) {
            View view2;
            i0 i0Var = i0.this;
            if (i0Var.v && (view2 = i0Var.j) != null) {
                view2.setTranslationY(0.0f);
                i0.this.g.setTranslationY(0.0f);
            }
            i0.this.g.setVisibility(8);
            i0.this.g.setTransitioning(false);
            i0 i0Var2 = i0.this;
            i0Var2.A = null;
            i0Var2.x();
            ActionBarOverlayLayout actionBarOverlayLayout = i0.this.f;
            if (actionBarOverlayLayout != null) {
                ga.W(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: i0$b */
    /* loaded from: classes.dex */
    public class b extends ma {
        public b() {
        }

        @Override // defpackage.la
        public void b(View view) {
            i0 i0Var = i0.this;
            i0Var.A = null;
            i0Var.g.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: i0$c */
    /* loaded from: classes.dex */
    public class c implements na {
        public c() {
        }

        @Override // defpackage.na
        public void a(View view) {
            ViewParent parent = i0.this.g.getParent();
            ((View) parent).invalidate();
        }
    }

    public i0(Activity activity, boolean overlayMode) {
        this.e = activity;
        Window window = activity.getWindow();
        View decor = window.getDecorView();
        D(decor);
        if (!overlayMode) {
            this.j = decor.findViewById(16908290);
        }
    }

    public i0(Dialog dialog) {
        D(dialog.getWindow().getDecorView());
    }

    public final void D(View decor) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) decor.findViewById(s.p);
        this.f = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.h = A(decor.findViewById(s.a));
        this.i = (ActionBarContextView) decor.findViewById(s.f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) decor.findViewById(s.c);
        this.g = actionBarContainer;
        j2 j2Var = this.h;
        if (j2Var == null || this.i == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.c = j2Var.getContext();
        int current = this.h.o();
        boolean homeAsUp = (current & 4) != 0;
        if (homeAsUp) {
            this.n = true;
        }
        q0 abp = q0.b(this.c);
        J(abp.a() || homeAsUp);
        H(abp.g());
        TypedArray a2 = this.c.obtainStyledAttributes(null, w.a, n.c, 0);
        if (a2.getBoolean(w.k, false)) {
            I(true);
        }
        int elevation = a2.getDimensionPixelSize(w.i, 0);
        if (elevation != 0) {
            G(elevation);
        }
        a2.recycle();
    }

    public final j2 A(View view) {
        if (view instanceof j2) {
            return (j2) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    public void G(float elevation) {
        ga.d0(this.g, elevation);
    }

    @Override // defpackage.x
    public void m(Configuration newConfig) {
        H(q0.b(this.c).g());
    }

    public final void H(boolean hasEmbeddedTabs) {
        this.t = hasEmbeddedTabs;
        if (!hasEmbeddedTabs) {
            this.h.j(null);
            this.g.setTabContainer(this.k);
        } else {
            this.g.setTabContainer(null);
            this.h.j(this.k);
        }
        boolean z = true;
        boolean isInTabMode = B() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.k;
        if (scrollingTabContainerView != null) {
            if (isInTabMode) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f;
                if (actionBarOverlayLayout != null) {
                    ga.W(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.h.u(!this.t && isInTabMode);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f;
        if (this.t || !isInTabMode) {
            z = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z);
    }

    public void x() {
        r0.a aVar = this.q;
        if (aVar != null) {
            aVar.b(this.p);
            this.p = null;
            this.q = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(int visibility) {
        this.u = visibility;
    }

    @Override // defpackage.x
    public void s(boolean enabled) {
        x0 x0Var;
        this.B = enabled;
        if (!enabled && (x0Var = this.A) != null) {
            x0Var.a();
        }
    }

    @Override // defpackage.x
    public void i(boolean isVisible) {
        if (isVisible == this.r) {
            return;
        }
        this.r = isVisible;
        int count = this.s.size();
        for (int i = 0; i < count; i++) {
            this.s.get(i).a(isVisible);
        }
    }

    public void E(boolean showHomeAsUp) {
        F(showHomeAsUp ? 4 : 0, 4);
    }

    public void J(boolean enable) {
        this.h.l(enable);
    }

    @Override // defpackage.x
    public void t(CharSequence title) {
        this.h.setWindowTitle(title);
    }

    public void F(int options, int mask) {
        int current = this.h.o();
        if ((mask & 4) != 0) {
            this.n = true;
        }
        this.h.n((options & mask) | ((~mask) & current));
    }

    public int B() {
        return this.h.q();
    }

    @Override // defpackage.x
    public int j() {
        return this.h.o();
    }

    @Override // defpackage.x
    public r0 u(r0.a callback) {
        d dVar = this.o;
        if (dVar != null) {
            dVar.c();
        }
        this.f.setHideOnContentScrollEnabled(false);
        this.i.k();
        d mode = new d(this.i.getContext(), callback);
        if (mode.t()) {
            this.o = mode;
            mode.k();
            this.i.h(mode);
            v(true);
            this.i.sendAccessibilityEvent(32);
            return mode;
        }
        return null;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e(boolean enabled) {
        this.v = enabled;
    }

    public final void L() {
        if (!this.y) {
            this.y = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            M(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.x) {
            this.x = false;
            M(true);
        }
    }

    public final void C() {
        if (this.y) {
            this.y = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
        if (!this.x) {
            this.x = true;
            M(true);
        }
    }

    public void I(boolean hideOnContentScroll) {
        if (hideOnContentScroll && !this.f.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.C = hideOnContentScroll;
        this.f.setHideOnContentScrollEnabled(hideOnContentScroll);
    }

    public static boolean w(boolean hiddenByApp, boolean hiddenBySystem, boolean showingForMode) {
        if (showingForMode) {
            return true;
        }
        if (!hiddenByApp && !hiddenBySystem) {
            return true;
        }
        return false;
    }

    public final void M(boolean fromSystem) {
        boolean shown = w(this.w, this.x, this.y);
        if (shown) {
            if (!this.z) {
                this.z = true;
                z(fromSystem);
            }
        } else if (this.z) {
            this.z = false;
            y(fromSystem);
        }
    }

    public void z(boolean fromSystem) {
        View view;
        View view2;
        x0 x0Var = this.A;
        if (x0Var != null) {
            x0Var.a();
        }
        this.g.setVisibility(0);
        if (this.u == 0 && (this.B || fromSystem)) {
            this.g.setTranslationY(0.0f);
            float startingY = -this.g.getHeight();
            if (fromSystem) {
                int[] topLeft = {0, 0};
                this.g.getLocationInWindow(topLeft);
                startingY -= topLeft[1];
            }
            this.g.setTranslationY(startingY);
            x0 anim = new x0();
            ka a2 = ga.b(this.g).k(0.0f);
            a2.i(this.F);
            anim.c(a2);
            if (this.v && (view2 = this.j) != null) {
                view2.setTranslationY(startingY);
                anim.c(ga.b(this.j).k(0.0f));
            }
            anim.f(b);
            anim.e(250L);
            anim.g(this.E);
            this.A = anim;
            anim.h();
        } else {
            this.g.setAlpha(1.0f);
            this.g.setTranslationY(0.0f);
            if (this.v && (view = this.j) != null) {
                view.setTranslationY(0.0f);
            }
            this.E.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f;
        if (actionBarOverlayLayout != null) {
            ga.W(actionBarOverlayLayout);
        }
    }

    public void y(boolean fromSystem) {
        View view;
        x0 x0Var = this.A;
        if (x0Var != null) {
            x0Var.a();
        }
        if (this.u == 0 && (this.B || fromSystem)) {
            this.g.setAlpha(1.0f);
            this.g.setTransitioning(true);
            x0 anim = new x0();
            float endingY = -this.g.getHeight();
            if (fromSystem) {
                int[] topLeft = {0, 0};
                this.g.getLocationInWindow(topLeft);
                endingY -= topLeft[1];
            }
            ka a2 = ga.b(this.g).k(endingY);
            a2.i(this.F);
            anim.c(a2);
            if (this.v && (view = this.j) != null) {
                anim.c(ga.b(view).k(endingY));
            }
            anim.f(a);
            anim.e(250L);
            anim.g(this.D);
            this.A = anim;
            anim.h();
            return;
        }
        this.D.b(null);
    }

    public void v(boolean toActionMode) {
        ka fadeIn;
        ka fadeOut;
        if (toActionMode) {
            L();
        } else {
            C();
        }
        if (K()) {
            if (toActionMode) {
                fadeOut = this.h.r(4, 100L);
                fadeIn = this.i.f(0, 200L);
            } else {
                fadeIn = this.h.r(0, 200L);
                fadeOut = this.i.f(8, 100L);
            }
            x0 set = new x0();
            set.d(fadeOut, fadeIn);
            set.h();
        } else if (toActionMode) {
            this.h.i(4);
            this.i.setVisibility(0);
        } else {
            this.h.i(0);
            this.i.setVisibility(8);
        }
    }

    public final boolean K() {
        return ga.J(this.g);
    }

    @Override // defpackage.x
    public Context k() {
        if (this.d == null) {
            TypedValue outValue = new TypedValue();
            Resources.Theme currentTheme = this.c.getTheme();
            currentTheme.resolveAttribute(n.g, outValue, true);
            int targetThemeRes = outValue.resourceId;
            if (targetThemeRes != 0) {
                this.d = new ContextThemeWrapper(this.c, targetThemeRes);
            } else {
                this.d = this.c;
            }
        }
        return this.d;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        x0 x0Var = this.A;
        if (x0Var != null) {
            x0Var.a();
            this.A = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
    }

    @Override // defpackage.x
    public boolean h() {
        j2 j2Var = this.h;
        if (j2Var != null && j2Var.m()) {
            this.h.collapseActionView();
            return true;
        }
        return false;
    }

    /* compiled from: WindowDecorActionBar.java */
    /* renamed from: i0$d */
    /* loaded from: classes.dex */
    public class d extends r0 implements f1.a {
        public final Context d;
        public final f1 f;
        public r0.a g;
        public WeakReference<View> h;

        public d(Context context, r0.a callback) {
            this.d = context;
            this.g = callback;
            f1 S = new f1(context).S(1);
            this.f = S;
            S.R(this);
        }

        @Override // defpackage.r0
        public MenuInflater f() {
            return new w0(this.d);
        }

        @Override // defpackage.r0
        public Menu e() {
            return this.f;
        }

        @Override // defpackage.r0
        public void c() {
            i0 i0Var = i0.this;
            if (i0Var.o != this) {
                return;
            }
            if (!i0.w(i0Var.w, i0Var.x, false)) {
                i0 i0Var2 = i0.this;
                i0Var2.p = this;
                i0Var2.q = this.g;
            } else {
                this.g.b(this);
            }
            this.g = null;
            i0.this.v(false);
            i0.this.i.g();
            i0.this.h.k().sendAccessibilityEvent(32);
            i0 i0Var3 = i0.this;
            i0Var3.f.setHideOnContentScrollEnabled(i0Var3.C);
            i0.this.o = null;
        }

        @Override // defpackage.r0
        public void k() {
            if (i0.this.o != this) {
                return;
            }
            this.f.d0();
            try {
                this.g.a(this, this.f);
            } finally {
                this.f.c0();
            }
        }

        public boolean t() {
            this.f.d0();
            try {
                return this.g.d(this, this.f);
            } finally {
                this.f.c0();
            }
        }

        @Override // defpackage.r0
        public void m(View view) {
            i0.this.i.setCustomView(view);
            this.h = new WeakReference<>(view);
        }

        @Override // defpackage.r0
        public void o(CharSequence subtitle) {
            i0.this.i.setSubtitle(subtitle);
        }

        @Override // defpackage.r0
        public void r(CharSequence title) {
            i0.this.i.setTitle(title);
        }

        @Override // defpackage.r0
        public void q(int resId) {
            r(i0.this.c.getResources().getString(resId));
        }

        @Override // defpackage.r0
        public void n(int resId) {
            o(i0.this.c.getResources().getString(resId));
        }

        @Override // defpackage.r0
        public CharSequence i() {
            return i0.this.i.getTitle();
        }

        @Override // defpackage.r0
        public CharSequence g() {
            return i0.this.i.getSubtitle();
        }

        @Override // defpackage.r0
        public void s(boolean titleOptional) {
            super.s(titleOptional);
            i0.this.i.setTitleOptional(titleOptional);
        }

        @Override // defpackage.r0
        public boolean l() {
            return i0.this.i.j();
        }

        @Override // defpackage.r0
        public View d() {
            WeakReference<View> weakReference = this.h;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // defpackage.f1.a
        public boolean a(f1 menu, MenuItem item) {
            r0.a aVar = this.g;
            if (aVar != null) {
                return aVar.c(this, item);
            }
            return false;
        }

        @Override // defpackage.f1.a
        public void b(f1 menu) {
            if (this.g == null) {
                return;
            }
            k();
            i0.this.i.l();
        }
    }

    @Override // defpackage.x
    public void r(boolean enable) {
        if (!this.n) {
            E(enable);
        }
    }

    @Override // defpackage.x
    public boolean o(int keyCode, KeyEvent event) {
        Menu menu;
        d dVar = this.o;
        if (dVar == null || (menu = dVar.e()) == null) {
            return false;
        }
        KeyCharacterMap kmap = KeyCharacterMap.load(event != null ? event.getDeviceId() : -1);
        menu.setQwertyMode(kmap.getKeyboardType() != 1);
        return menu.performShortcut(keyCode, event, 0);
    }
}
