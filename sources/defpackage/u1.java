package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.l1;
import defpackage.m1;
import defpackage.m9;
import java.util.ArrayList;
/* compiled from: ActionMenuPresenter.java */
/* renamed from: u1  reason: default package */
/* loaded from: classes.dex */
public class u1 extends a1 implements m9.a {
    public e A;
    public a B;
    public c C;
    public b D;
    public final f E;
    public int F;
    public d m;
    public Drawable n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;
    public final SparseBooleanArray z;

    public u1(Context context) {
        super(context, t.c, t.b);
        this.z = new SparseBooleanArray();
        this.E = new f();
    }

    @Override // defpackage.a1, defpackage.l1
    public void c(Context context, f1 menu) {
        super.c(context, menu);
        Resources res = context.getResources();
        q0 abp = q0.b(context);
        if (!this.q) {
            this.p = abp.h();
        }
        if (!this.w) {
            this.r = abp.c();
        }
        if (!this.u) {
            this.t = abp.d();
        }
        int width = this.r;
        if (this.p) {
            if (this.m == null) {
                d dVar = new d(this.a);
                this.m = dVar;
                if (this.o) {
                    dVar.setImageDrawable(this.n);
                    this.n = null;
                    this.o = false;
                }
                int spec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.m.measure(spec, spec);
            }
            width -= this.m.getMeasuredWidth();
        } else {
            this.m = null;
        }
        this.s = width;
        this.y = (int) (res.getDisplayMetrics().density * 56.0f);
    }

    public void F(Configuration newConfig) {
        if (!this.u) {
            this.t = q0.b(this.b).d();
        }
        f1 f1Var = this.d;
        if (f1Var != null) {
            f1Var.K(true);
        }
    }

    public void J(boolean reserveOverflow) {
        this.p = reserveOverflow;
        this.q = true;
    }

    public void G(boolean isExclusive) {
        this.x = isExclusive;
    }

    public void I(Drawable icon) {
        d dVar = this.m;
        if (dVar != null) {
            dVar.setImageDrawable(icon);
            return;
        }
        this.o = true;
        this.n = icon;
    }

    public Drawable A() {
        d dVar = this.m;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.o) {
            return this.n;
        }
        return null;
    }

    @Override // defpackage.a1
    public m1 o(ViewGroup root) {
        m1 oldMenuView = this.k;
        m1 result = super.o(root);
        if (oldMenuView != result) {
            ((ActionMenuView) result).setPresenter(this);
        }
        return result;
    }

    @Override // defpackage.a1
    public View n(h1 item, View convertView, ViewGroup parent) {
        View actionView = item.getActionView();
        if (actionView == null || item.j()) {
            actionView = super.n(item, convertView, parent);
        }
        actionView.setVisibility(item.isActionViewExpanded() ? 8 : 0);
        ActionMenuView menuParent = (ActionMenuView) parent;
        ViewGroup.LayoutParams lp = actionView.getLayoutParams();
        if (!menuParent.checkLayoutParams(lp)) {
            actionView.setLayoutParams(menuParent.m(lp));
        }
        return actionView;
    }

    @Override // defpackage.a1
    public void d(h1 item, m1.a itemView) {
        itemView.i(item, 0);
        ActionMenuView menuView = (ActionMenuView) this.k;
        ActionMenuItemView actionItemView = (ActionMenuItemView) itemView;
        actionItemView.setItemInvoker(menuView);
        if (this.D == null) {
            this.D = new b();
        }
        actionItemView.setPopupCallback(this.D);
    }

    @Override // defpackage.a1
    public boolean q(int childIndex, h1 item) {
        return item.l();
    }

    @Override // defpackage.a1, defpackage.l1
    public void f(boolean cleared) {
        super.f(cleared);
        ((View) this.k).requestLayout();
        f1 f1Var = this.d;
        if (f1Var != null) {
            ArrayList<h1> s = f1Var.s();
            int count = s.size();
            for (int i = 0; i < count; i++) {
                m9 provider = s.get(i).b();
                if (provider != null) {
                    provider.i(this);
                }
            }
        }
        f1 f1Var2 = this.d;
        ArrayList<h1> z = f1Var2 != null ? f1Var2.z() : null;
        boolean hasOverflow = false;
        if (this.p && z != null) {
            int count2 = z.size();
            if (count2 == 1) {
                hasOverflow = !z.get(0).isActionViewExpanded();
            } else {
                hasOverflow = count2 > 0;
            }
        }
        if (hasOverflow) {
            if (this.m == null) {
                this.m = new d(this.a);
            }
            ViewGroup parent = (ViewGroup) this.m.getParent();
            if (parent != this.k) {
                if (parent != null) {
                    parent.removeView(this.m);
                }
                ActionMenuView menuView = (ActionMenuView) this.k;
                menuView.addView(this.m, menuView.D());
            }
        } else {
            d dVar = this.m;
            if (dVar != null) {
                ViewParent parent2 = dVar.getParent();
                m1 m1Var = this.k;
                if (parent2 == m1Var) {
                    ((ViewGroup) m1Var).removeView(this.m);
                }
            }
        }
        ((ActionMenuView) this.k).setOverflowReserved(this.p);
    }

    @Override // defpackage.a1
    public boolean l(ViewGroup parent, int childIndex) {
        if (parent.getChildAt(childIndex) == this.m) {
            return false;
        }
        return super.l(parent, childIndex);
    }

    @Override // defpackage.a1, defpackage.l1
    public boolean e(q1 subMenu) {
        if (subMenu.hasVisibleItems()) {
            q1 topSubMenu = subMenu;
            while (topSubMenu.e0() != this.d) {
                topSubMenu = (q1) topSubMenu.e0();
            }
            View anchor = z(topSubMenu.getItem());
            if (anchor == null) {
                return false;
            }
            this.F = subMenu.getItem().getItemId();
            boolean preserveIconSpacing = false;
            int count = subMenu.size();
            int i = 0;
            while (true) {
                if (i >= count) {
                    break;
                }
                MenuItem childItem = subMenu.getItem(i);
                if (!childItem.isVisible() || childItem.getIcon() == null) {
                    i++;
                } else {
                    preserveIconSpacing = true;
                    break;
                }
            }
            a aVar = new a(this.b, subMenu, anchor);
            this.B = aVar;
            aVar.g(preserveIconSpacing);
            this.B.k();
            super.e(subMenu);
            return true;
        }
        return false;
    }

    public final View z(MenuItem item) {
        ViewGroup parent = (ViewGroup) this.k;
        if (parent == null) {
            return null;
        }
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = parent.getChildAt(i);
            if ((child instanceof m1.a) && ((m1.a) child).getItemData() == item) {
                return child;
            }
        }
        return null;
    }

    public boolean K() {
        f1 f1Var;
        if (this.p && !E() && (f1Var = this.d) != null && this.k != null && this.C == null && !f1Var.z().isEmpty()) {
            e popup = new e(this.b, this.d, this.m, true);
            c cVar = new c(popup);
            this.C = cVar;
            ((View) this.k).post(cVar);
            return true;
        }
        return false;
    }

    public boolean B() {
        m1 m1Var;
        c cVar = this.C;
        if (cVar != null && (m1Var = this.k) != null) {
            ((View) m1Var).removeCallbacks(cVar);
            this.C = null;
            return true;
        }
        k1 popup = this.A;
        if (popup != null) {
            popup.b();
            return true;
        }
        return false;
    }

    public boolean y() {
        boolean result = B();
        return result | C();
    }

    public boolean C() {
        a aVar = this.B;
        if (aVar != null) {
            aVar.b();
            return true;
        }
        return false;
    }

    public boolean E() {
        e eVar = this.A;
        return eVar != null && eVar.d();
    }

    public boolean D() {
        return this.C != null || E();
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x0162  */
    @Override // defpackage.l1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean h() {
        /*
            Method dump skipped, instructions count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u1.h():boolean");
    }

    @Override // defpackage.a1, defpackage.l1
    public void a(f1 menu, boolean allMenusAreClosing) {
        y();
        super.a(menu, allMenusAreClosing);
    }

    public void H(ActionMenuView menuView) {
        this.k = menuView;
        menuView.b(this.d);
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: u1$d */
    /* loaded from: classes.dex */
    public class d extends AppCompatImageView implements ActionMenuView.a {
        public d(Context context) {
            super(context, null, n.k);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            b3.a(this, getContentDescription());
            setOnTouchListener(new a(this, u1.this));
        }

        /* compiled from: ActionMenuPresenter.java */
        /* renamed from: u1$d$a */
        /* loaded from: classes.dex */
        public class a extends n2 {
            public final /* synthetic */ u1 l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(View src, u1 u1Var) {
                super(src);
                this.l = u1Var;
            }

            @Override // defpackage.n2
            public o1 b() {
                e eVar = u1.this.A;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // defpackage.n2
            public boolean c() {
                u1.this.K();
                return true;
            }

            @Override // defpackage.n2
            public boolean d() {
                u1 u1Var = u1.this;
                if (u1Var.C != null) {
                    return false;
                }
                u1Var.B();
                return true;
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            u1.this.K();
            return true;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean h() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean f() {
            return false;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int l, int t, int r, int b) {
            boolean changed = super.setFrame(l, t, r, b);
            Drawable d = getDrawable();
            Drawable bg = getBackground();
            if (d != null && bg != null) {
                int width = getWidth();
                int height = getHeight();
                int halfEdge = Math.max(width, height) / 2;
                int offsetX = getPaddingLeft() - getPaddingRight();
                int offsetY = getPaddingTop() - getPaddingBottom();
                int centerX = (width + offsetX) / 2;
                int centerY = (height + offsetY) / 2;
                i8.k(bg, centerX - halfEdge, centerY - halfEdge, centerX + halfEdge, centerY + halfEdge);
            }
            return changed;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: u1$e */
    /* loaded from: classes.dex */
    public class e extends k1 {
        public e(Context context, f1 menu, View anchorView, boolean overflowOnly) {
            super(context, menu, anchorView, overflowOnly, n.l);
            h(8388613);
            j(u1.this.E);
        }

        @Override // defpackage.k1
        public void e() {
            if (u1.this.d != null) {
                u1.this.d.close();
            }
            u1.this.A = null;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: u1$a */
    /* loaded from: classes.dex */
    public class a extends k1 {
        public a(Context context, q1 subMenu, View anchorView) {
            super(context, subMenu, anchorView, false, n.l);
            h1 item = (h1) subMenu.getItem();
            if (!item.l()) {
                View view = u1.this.m;
                f(view == null ? (View) u1.this.k : view);
            }
            j(u1.this.E);
        }

        @Override // defpackage.k1
        public void e() {
            u1 u1Var = u1.this;
            u1Var.B = null;
            u1Var.F = 0;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: u1$f */
    /* loaded from: classes.dex */
    public class f implements l1.a {
        public f() {
        }

        @Override // defpackage.l1.a
        public boolean b(f1 subMenu) {
            if (subMenu == u1.this.d) {
                return false;
            }
            u1.this.F = ((q1) subMenu).getItem().getItemId();
            l1.a cb = u1.this.m();
            if (cb != null) {
                return cb.b(subMenu);
            }
            return false;
        }

        @Override // defpackage.l1.a
        public void a(f1 menu, boolean allMenusAreClosing) {
            if (menu instanceof q1) {
                menu.D().e(false);
            }
            l1.a cb = u1.this.m();
            if (cb != null) {
                cb.a(menu, allMenusAreClosing);
            }
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: u1$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public e a;

        public c(e popup) {
            this.a = popup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u1.this.d != null) {
                u1.this.d.d();
            }
            View menuView = (View) u1.this.k;
            if (menuView != null && menuView.getWindowToken() != null && this.a.m()) {
                u1.this.A = this.a;
            }
            u1.this.C = null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: u1$b */
    /* loaded from: classes.dex */
    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public o1 a() {
            a aVar = u1.this.B;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }
}
