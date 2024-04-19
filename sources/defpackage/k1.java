package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import defpackage.l1;
/* compiled from: MenuPopupHelper.java */
/* renamed from: k1  reason: default package */
/* loaded from: classes.dex */
public class k1 {
    public final Context a;
    public final f1 b;
    public final boolean c;
    public final int d;
    public final int e;
    public View f;
    public int g;
    public boolean h;
    public l1.a i;
    public j1 j;
    public PopupWindow.OnDismissListener k;
    public final PopupWindow.OnDismissListener l;

    public k1(Context context, f1 menu, View anchorView, boolean overflowOnly, int popupStyleAttr) {
        this(context, menu, anchorView, overflowOnly, popupStyleAttr, 0);
    }

    public k1(Context context, f1 menu, View anchorView, boolean overflowOnly, int popupStyleAttr, int popupStyleRes) {
        this.g = 8388611;
        this.l = new a();
        this.a = context;
        this.b = menu;
        this.f = anchorView;
        this.c = overflowOnly;
        this.d = popupStyleAttr;
        this.e = popupStyleRes;
    }

    public void i(PopupWindow.OnDismissListener listener) {
        this.k = listener;
    }

    public void f(View anchor) {
        this.f = anchor;
    }

    public void g(boolean forceShowIcon) {
        this.h = forceShowIcon;
        j1 j1Var = this.j;
        if (j1Var != null) {
            j1Var.r(forceShowIcon);
        }
    }

    public void h(int gravity) {
        this.g = gravity;
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public j1 c() {
        if (this.j == null) {
            this.j = a();
        }
        return this.j;
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int x, int y) {
        if (d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        l(x, y, true, true);
        return true;
    }

    public final j1 a() {
        j1 popup;
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        Display display = windowManager.getDefaultDisplay();
        Point displaySize = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealSize(displaySize);
        } else {
            display.getSize(displaySize);
        }
        int smallestWidth = Math.min(displaySize.x, displaySize.y);
        int minSmallestWidthCascading = this.a.getResources().getDimensionPixelSize(q.abc_cascading_menus_min_smallest_width);
        boolean enableCascadingSubmenus = smallestWidth >= minSmallestWidthCascading;
        if (enableCascadingSubmenus) {
            popup = new c1(this.a, this.f, this.d, this.e, this.c);
        } else {
            popup = new p1(this.a, this.b, this.f, this.d, this.e, this.c);
        }
        popup.l(this.b);
        popup.u(this.l);
        popup.p(this.f);
        popup.k(this.i);
        popup.r(this.h);
        popup.s(this.g);
        return popup;
    }

    public final void l(int xOffset, int yOffset, boolean useOffsets, boolean showTitle) {
        j1 popup = c();
        popup.v(showTitle);
        if (useOffsets) {
            int hgrav = p9.b(this.g, ga.v(this.f)) & 7;
            if (hgrav == 5) {
                xOffset -= this.f.getWidth();
            }
            popup.t(xOffset);
            popup.w(yOffset);
            float density = this.a.getResources().getDisplayMetrics().density;
            int halfSize = (int) ((48.0f * density) / 2.0f);
            Rect epicenter = new Rect(xOffset - halfSize, yOffset - halfSize, xOffset + halfSize, yOffset + halfSize);
            popup.q(epicenter);
        }
        popup.d();
    }

    public void b() {
        if (d()) {
            this.j.dismiss();
        }
    }

    public void e() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean d() {
        j1 j1Var = this.j;
        return j1Var != null && j1Var.b();
    }

    public void j(l1.a cb) {
        this.i = cb;
        j1 j1Var = this.j;
        if (j1Var != null) {
            j1Var.k(cb);
        }
    }

    /* compiled from: MenuPopupHelper.java */
    /* renamed from: k1$a */
    /* loaded from: classes.dex */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            k1.this.e();
        }
    }
}
