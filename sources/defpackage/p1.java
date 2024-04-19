package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.MenuPopupWindow;
import defpackage.l1;
/* compiled from: StandardMenuPopup.java */
/* renamed from: p1  reason: default package */
/* loaded from: classes.dex */
public final class p1 extends j1 implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, l1, View.OnKeyListener {
    public static final int b = t.m;
    public final Context d;
    public final f1 f;
    public final e1 g;
    public final boolean h;
    public final int i;
    public final int j;
    public final int k;
    public final MenuPopupWindow l;
    public PopupWindow.OnDismissListener o;
    public View p;
    public View q;
    public l1.a r;
    public ViewTreeObserver s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean x;
    public final ViewTreeObserver.OnGlobalLayoutListener m = new a();
    public final View.OnAttachStateChangeListener n = new b();
    public int w = 0;

    /* compiled from: StandardMenuPopup.java */
    /* renamed from: p1$a */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (p1.this.b() && !p1.this.l.x()) {
                View anchor = p1.this.q;
                if (anchor == null || !anchor.isShown()) {
                    p1.this.dismiss();
                } else {
                    p1.this.l.d();
                }
            }
        }
    }

    /* compiled from: StandardMenuPopup.java */
    /* renamed from: p1$b */
    /* loaded from: classes.dex */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            ViewTreeObserver viewTreeObserver = p1.this.s;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    p1.this.s = v.getViewTreeObserver();
                }
                p1 p1Var = p1.this;
                p1Var.s.removeGlobalOnLayoutListener(p1Var.m);
            }
            v.removeOnAttachStateChangeListener(this);
        }
    }

    public p1(Context context, f1 menu, View anchorView, int popupStyleAttr, int popupStyleRes, boolean overflowOnly) {
        this.d = context;
        this.f = menu;
        this.h = overflowOnly;
        LayoutInflater inflater = LayoutInflater.from(context);
        this.g = new e1(menu, inflater, overflowOnly, b);
        this.j = popupStyleAttr;
        this.k = popupStyleRes;
        Resources res = context.getResources();
        this.i = Math.max(res.getDisplayMetrics().widthPixels / 2, res.getDimensionPixelSize(q.d));
        this.p = anchorView;
        this.l = new MenuPopupWindow(context, null, popupStyleAttr, popupStyleRes);
        menu.c(this, context);
    }

    @Override // defpackage.j1
    public void r(boolean forceShow) {
        this.g.d(forceShow);
    }

    @Override // defpackage.j1
    public void s(int gravity) {
        this.w = gravity;
    }

    public final boolean z() {
        View view;
        if (b()) {
            return true;
        }
        if (this.t || (view = this.p) == null) {
            return false;
        }
        this.q = view;
        this.l.G(this);
        this.l.H(this);
        this.l.F(true);
        View anchor = this.q;
        boolean addGlobalListener = this.s == null;
        ViewTreeObserver viewTreeObserver = anchor.getViewTreeObserver();
        this.s = viewTreeObserver;
        if (addGlobalListener) {
            viewTreeObserver.addOnGlobalLayoutListener(this.m);
        }
        anchor.addOnAttachStateChangeListener(this.n);
        this.l.z(anchor);
        this.l.C(this.w);
        if (!this.u) {
            this.v = j1.o(this.g, null, this.d, this.i);
            this.u = true;
        }
        this.l.B(this.v);
        this.l.E(2);
        this.l.D(n());
        this.l.d();
        ListView listView = this.l.g();
        listView.setOnKeyListener(this);
        if (this.x && this.f.x() != null) {
            FrameLayout titleItemView = (FrameLayout) LayoutInflater.from(this.d).inflate(t.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView titleView = (TextView) titleItemView.findViewById(16908310);
            if (titleView != null) {
                titleView.setText(this.f.x());
            }
            titleItemView.setEnabled(false);
            listView.addHeaderView(titleItemView, null, false);
        }
        this.l.p(this.g);
        this.l.d();
        return true;
    }

    @Override // defpackage.o1
    public void d() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // defpackage.o1
    public void dismiss() {
        if (b()) {
            this.l.dismiss();
        }
    }

    @Override // defpackage.j1
    public void l(f1 menu) {
    }

    @Override // defpackage.o1
    public boolean b() {
        return !this.t && this.l.b();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.t = true;
        this.f.close();
        ViewTreeObserver viewTreeObserver = this.s;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.s = this.q.getViewTreeObserver();
            }
            this.s.removeGlobalOnLayoutListener(this.m);
            this.s = null;
        }
        this.q.removeOnAttachStateChangeListener(this.n);
        PopupWindow.OnDismissListener onDismissListener = this.o;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // defpackage.l1
    public void f(boolean cleared) {
        this.u = false;
        e1 e1Var = this.g;
        if (e1Var != null) {
            e1Var.notifyDataSetChanged();
        }
    }

    @Override // defpackage.l1
    public void k(l1.a cb) {
        this.r = cb;
    }

    @Override // defpackage.l1
    public boolean e(q1 subMenu) {
        if (subMenu.hasVisibleItems()) {
            k1 subPopup = new k1(this.d, subMenu, this.q, this.h, this.j, this.k);
            subPopup.j(this.r);
            subPopup.g(j1.x(subMenu));
            subPopup.i(this.o);
            this.o = null;
            this.f.e(false);
            int horizontalOffset = this.l.a();
            int verticalOffset = this.l.n();
            int hgrav = Gravity.getAbsoluteGravity(this.w, ga.v(this.p)) & 7;
            if (hgrav == 5) {
                horizontalOffset += this.p.getWidth();
            }
            if (subPopup.n(horizontalOffset, verticalOffset)) {
                l1.a aVar = this.r;
                if (aVar != null) {
                    aVar.b(subMenu);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.l1
    public void a(f1 menu, boolean allMenusAreClosing) {
        if (menu != this.f) {
            return;
        }
        dismiss();
        l1.a aVar = this.r;
        if (aVar != null) {
            aVar.a(menu, allMenusAreClosing);
        }
    }

    @Override // defpackage.l1
    public boolean h() {
        return false;
    }

    @Override // defpackage.j1
    public void p(View anchor) {
        this.p = anchor;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == 1 && keyCode == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // defpackage.j1
    public void u(PopupWindow.OnDismissListener listener) {
        this.o = listener;
    }

    @Override // defpackage.o1
    public ListView g() {
        return this.l.g();
    }

    @Override // defpackage.j1
    public void t(int x) {
        this.l.l(x);
    }

    @Override // defpackage.j1
    public void w(int y) {
        this.l.j(y);
    }

    @Override // defpackage.j1
    public void v(boolean showTitle) {
        this.x = showTitle;
    }
}
