package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.MenuPopupWindow;
import defpackage.l1;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CascadingMenuPopup.java */
/* renamed from: c1  reason: default package */
/* loaded from: classes.dex */
public final class c1 extends j1 implements l1, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int b = t.abc_cascading_menu_item_layout;
    public l1.a A;
    public ViewTreeObserver B;
    public PopupWindow.OnDismissListener C;
    public boolean D;
    public final Context d;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;
    public final Handler j;
    public View r;
    public View s;
    public boolean u;
    public boolean v;
    public int w;
    public int x;
    public boolean z;
    public final List<f1> k = new ArrayList();
    public final List<d> l = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener m = new a();
    public final View.OnAttachStateChangeListener n = new b();
    public final p2 o = new c();
    public int p = 0;
    public int q = 0;
    public boolean y = false;
    public int t = D();

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: c1$a */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (c1.this.b() && c1.this.l.size() > 0 && !c1.this.l.get(0).a.x()) {
                View anchor = c1.this.s;
                if (anchor == null || !anchor.isShown()) {
                    c1.this.dismiss();
                    return;
                }
                for (d info : c1.this.l) {
                    info.a.d();
                }
            }
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: c1$b */
    /* loaded from: classes.dex */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            ViewTreeObserver viewTreeObserver = c1.this.B;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    c1.this.B = v.getViewTreeObserver();
                }
                c1 c1Var = c1.this;
                c1Var.B.removeGlobalOnLayoutListener(c1Var.m);
            }
            v.removeOnAttachStateChangeListener(this);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: c1$c */
    /* loaded from: classes.dex */
    public class c implements p2 {
        public c() {
        }

        @Override // defpackage.p2
        public void e(f1 menu, MenuItem item) {
            c1.this.j.removeCallbacksAndMessages(menu);
        }

        @Override // defpackage.p2
        public void c(f1 menu, MenuItem item) {
            d nextInfo;
            c1.this.j.removeCallbacksAndMessages(null);
            int menuIndex = -1;
            int i = 0;
            int count = c1.this.l.size();
            while (true) {
                if (i >= count) {
                    break;
                } else if (menu != c1.this.l.get(i).b) {
                    i++;
                } else {
                    menuIndex = i;
                    break;
                }
            }
            if (menuIndex == -1) {
                return;
            }
            int nextIndex = menuIndex + 1;
            if (nextIndex < c1.this.l.size()) {
                nextInfo = c1.this.l.get(nextIndex);
            } else {
                nextInfo = null;
            }
            Runnable runnable = new a(nextInfo, item, menu);
            long uptimeMillis = SystemClock.uptimeMillis() + 200;
            c1.this.j.postAtTime(runnable, menu, uptimeMillis);
        }

        /* compiled from: CascadingMenuPopup.java */
        /* renamed from: c1$c$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public final /* synthetic */ d a;
            public final /* synthetic */ MenuItem b;
            public final /* synthetic */ f1 d;

            public a(d dVar, MenuItem menuItem, f1 f1Var) {
                this.a = dVar;
                this.b = menuItem;
                this.d = f1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.a;
                if (dVar != null) {
                    c1.this.D = true;
                    dVar.b.e(false);
                    c1.this.D = false;
                }
                if (this.b.isEnabled() && this.b.hasSubMenu()) {
                    this.d.L(this.b, 4);
                }
            }
        }
    }

    public c1(Context context, View anchor, int popupStyleAttr, int popupStyleRes, boolean overflowOnly) {
        this.d = context;
        this.r = anchor;
        this.g = popupStyleAttr;
        this.h = popupStyleRes;
        this.i = overflowOnly;
        Resources res = context.getResources();
        this.f = Math.max(res.getDisplayMetrics().widthPixels / 2, res.getDimensionPixelSize(q.d));
        this.j = new Handler();
    }

    @Override // defpackage.j1
    public void r(boolean forceShow) {
        this.y = forceShow;
    }

    public final MenuPopupWindow z() {
        MenuPopupWindow popupWindow = new MenuPopupWindow(this.d, null, this.g, this.h);
        popupWindow.P(this.o);
        popupWindow.H(this);
        popupWindow.G(this);
        popupWindow.z(this.r);
        popupWindow.C(this.q);
        popupWindow.F(true);
        popupWindow.E(2);
        return popupWindow;
    }

    @Override // defpackage.o1
    public void d() {
        if (b()) {
            return;
        }
        for (f1 menu : this.k) {
            F(menu);
        }
        this.k.clear();
        View view = this.r;
        this.s = view;
        if (view != null) {
            boolean addGlobalListener = this.B == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.B = viewTreeObserver;
            if (addGlobalListener) {
                viewTreeObserver.addOnGlobalLayoutListener(this.m);
            }
            this.s.addOnAttachStateChangeListener(this.n);
        }
    }

    @Override // defpackage.o1
    public void dismiss() {
        int length = this.l.size();
        if (length > 0) {
            d[] addedMenus = (d[]) this.l.toArray(new d[length]);
            for (int i = length - 1; i >= 0; i--) {
                d info = addedMenus[i];
                if (info.a.b()) {
                    info.a.dismiss();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == 1 && keyCode == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    public final int D() {
        int layoutDirection = ga.v(this.r);
        return layoutDirection == 1 ? 0 : 1;
    }

    public final int E(int nextMenuWidth) {
        List<d> list = this.l;
        ListView lastListView = list.get(list.size() - 1).a();
        int[] screenLocation = new int[2];
        lastListView.getLocationOnScreen(screenLocation);
        Rect displayFrame = new Rect();
        this.s.getWindowVisibleDisplayFrame(displayFrame);
        if (this.t == 1) {
            int right = screenLocation[0] + lastListView.getWidth() + nextMenuWidth;
            return right > displayFrame.right ? 0 : 1;
        }
        int right2 = screenLocation[0];
        int left = right2 - nextMenuWidth;
        return left < 0 ? 1 : 0;
    }

    @Override // defpackage.j1
    public void l(f1 menu) {
        menu.c(this, this.d);
        if (b()) {
            F(menu);
        } else {
            this.k.add(menu);
        }
    }

    public final void F(f1 menu) {
        d parentInfo;
        View parentView;
        int parentOffsetX;
        int parentOffsetY;
        int x;
        LayoutInflater inflater = LayoutInflater.from(this.d);
        e1 adapter = new e1(menu, inflater, this.i, b);
        if (!b() && this.y) {
            adapter.d(true);
        } else if (b()) {
            adapter.d(j1.x(menu));
        }
        int menuWidth = j1.o(adapter, null, this.d, this.f);
        MenuPopupWindow popupWindow = z();
        popupWindow.p(adapter);
        popupWindow.B(menuWidth);
        popupWindow.C(this.q);
        if (this.l.size() > 0) {
            List<d> list = this.l;
            parentInfo = list.get(list.size() - 1);
            parentView = C(parentInfo, menu);
        } else {
            parentInfo = null;
            parentView = null;
        }
        if (parentView != null) {
            popupWindow.Q(false);
            popupWindow.N(null);
            int nextMenuPosition = E(menuWidth);
            boolean showOnRight = nextMenuPosition == 1;
            this.t = nextMenuPosition;
            if (Build.VERSION.SDK_INT >= 26) {
                popupWindow.z(parentView);
                parentOffsetX = 0;
                parentOffsetY = 0;
            } else {
                int[] anchorScreenLocation = new int[2];
                this.r.getLocationOnScreen(anchorScreenLocation);
                int[] parentViewScreenLocation = new int[2];
                parentView.getLocationOnScreen(parentViewScreenLocation);
                if ((this.q & 7) == 5) {
                    anchorScreenLocation[0] = anchorScreenLocation[0] + this.r.getWidth();
                    parentViewScreenLocation[0] = parentViewScreenLocation[0] + parentView.getWidth();
                }
                parentOffsetX = parentViewScreenLocation[0] - anchorScreenLocation[0];
                parentOffsetY = parentViewScreenLocation[1] - anchorScreenLocation[1];
            }
            if ((this.q & 5) == 5) {
                if (showOnRight) {
                    x = parentOffsetX + menuWidth;
                } else {
                    int x2 = parentView.getWidth();
                    x = parentOffsetX - x2;
                }
            } else if (showOnRight) {
                x = parentView.getWidth() + parentOffsetX;
            } else {
                x = parentOffsetX - menuWidth;
            }
            popupWindow.l(x);
            popupWindow.I(true);
            popupWindow.j(parentOffsetY);
        } else {
            if (this.u) {
                popupWindow.l(this.w);
            }
            if (this.v) {
                popupWindow.j(this.x);
            }
            Rect epicenterBounds = n();
            popupWindow.D(epicenterBounds);
        }
        d menuInfo = new d(popupWindow, menu, this.t);
        this.l.add(menuInfo);
        popupWindow.d();
        ListView listView = popupWindow.g();
        listView.setOnKeyListener(this);
        if (parentInfo == null && this.z && menu.x() != null) {
            FrameLayout titleItemView = (FrameLayout) inflater.inflate(t.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView titleView = (TextView) titleItemView.findViewById(16908310);
            titleItemView.setEnabled(false);
            titleView.setText(menu.x());
            listView.addHeaderView(titleItemView, null, false);
            popupWindow.d();
        }
    }

    public final MenuItem B(f1 parent, f1 submenu) {
        int count = parent.size();
        for (int i = 0; i < count; i++) {
            MenuItem item = parent.getItem(i);
            if (item.hasSubMenu() && submenu == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public final View C(d parentInfo, f1 submenu) {
        int headersCount;
        e1 menuAdapter;
        int ownerViewPosition;
        MenuItem owner = B(parentInfo.b, submenu);
        if (owner == null) {
            return null;
        }
        ListView listView = parentInfo.a();
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerAdapter = (HeaderViewListAdapter) listAdapter;
            headersCount = headerAdapter.getHeadersCount();
            menuAdapter = (e1) headerAdapter.getWrappedAdapter();
        } else {
            headersCount = 0;
            menuAdapter = (e1) listAdapter;
        }
        int ownerPosition = -1;
        int i = 0;
        int count = menuAdapter.getCount();
        while (true) {
            if (i >= count) {
                break;
            } else if (owner != menuAdapter.getItem(i)) {
                i++;
            } else {
                ownerPosition = i;
                break;
            }
        }
        if (ownerPosition == -1 || (ownerViewPosition = (ownerPosition + headersCount) - listView.getFirstVisiblePosition()) < 0 || ownerViewPosition >= listView.getChildCount()) {
            return null;
        }
        return listView.getChildAt(ownerViewPosition);
    }

    @Override // defpackage.o1
    public boolean b() {
        return this.l.size() > 0 && this.l.get(0).a.b();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dismissedInfo = null;
        int i = 0;
        int count = this.l.size();
        while (true) {
            if (i >= count) {
                break;
            }
            d info = this.l.get(i);
            if (info.a.b()) {
                i++;
            } else {
                dismissedInfo = info;
                break;
            }
        }
        if (dismissedInfo != null) {
            dismissedInfo.b.e(false);
        }
    }

    @Override // defpackage.l1
    public void f(boolean cleared) {
        for (d info : this.l) {
            j1.y(info.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // defpackage.l1
    public void k(l1.a cb) {
        this.A = cb;
    }

    @Override // defpackage.l1
    public boolean e(q1 subMenu) {
        for (d info : this.l) {
            if (subMenu == info.b) {
                info.a().requestFocus();
                return true;
            }
        }
        if (subMenu.hasVisibleItems()) {
            l(subMenu);
            l1.a aVar = this.A;
            if (aVar != null) {
                aVar.b(subMenu);
            }
            return true;
        }
        return false;
    }

    public final int A(f1 menu) {
        int count = this.l.size();
        for (int i = 0; i < count; i++) {
            d info = this.l.get(i);
            if (menu == info.b) {
                return i;
            }
        }
        return -1;
    }

    @Override // defpackage.l1
    public void a(f1 menu, boolean allMenusAreClosing) {
        int menuIndex = A(menu);
        if (menuIndex < 0) {
            return;
        }
        int nextMenuIndex = menuIndex + 1;
        if (nextMenuIndex < this.l.size()) {
            d childInfo = this.l.get(nextMenuIndex);
            childInfo.b.e(false);
        }
        d info = this.l.remove(menuIndex);
        info.b.O(this);
        if (this.D) {
            info.a.O(null);
            info.a.A(0);
        }
        info.a.dismiss();
        int count = this.l.size();
        if (count > 0) {
            this.t = this.l.get(count - 1).c;
        } else {
            this.t = D();
        }
        if (count == 0) {
            dismiss();
            l1.a aVar = this.A;
            if (aVar != null) {
                aVar.a(menu, true);
            }
            ViewTreeObserver viewTreeObserver = this.B;
            if (viewTreeObserver != null) {
                if (viewTreeObserver.isAlive()) {
                    this.B.removeGlobalOnLayoutListener(this.m);
                }
                this.B = null;
            }
            this.s.removeOnAttachStateChangeListener(this.n);
            this.C.onDismiss();
        } else if (allMenusAreClosing) {
            d rootInfo = this.l.get(0);
            rootInfo.b.e(false);
        }
    }

    @Override // defpackage.l1
    public boolean h() {
        return false;
    }

    @Override // defpackage.j1
    public void s(int dropDownGravity) {
        if (this.p != dropDownGravity) {
            this.p = dropDownGravity;
            this.q = p9.b(dropDownGravity, ga.v(this.r));
        }
    }

    @Override // defpackage.j1
    public void p(View anchor) {
        if (this.r != anchor) {
            this.r = anchor;
            this.q = p9.b(this.p, ga.v(anchor));
        }
    }

    @Override // defpackage.j1
    public void u(PopupWindow.OnDismissListener listener) {
        this.C = listener;
    }

    @Override // defpackage.o1
    public ListView g() {
        if (this.l.isEmpty()) {
            return null;
        }
        List<d> list = this.l;
        return list.get(list.size() - 1).a();
    }

    @Override // defpackage.j1
    public void t(int x) {
        this.u = true;
        this.w = x;
    }

    @Override // defpackage.j1
    public void w(int y) {
        this.v = true;
        this.x = y;
    }

    @Override // defpackage.j1
    public void v(boolean showTitle) {
        this.z = showTitle;
    }

    @Override // defpackage.j1
    public boolean m() {
        return false;
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: c1$d */
    /* loaded from: classes.dex */
    public static class d {
        public final MenuPopupWindow a;
        public final f1 b;
        public final int c;

        public d(MenuPopupWindow window, f1 menu, int position) {
            this.a = window;
            this.b = menu;
            this.c = position;
        }

        public ListView a() {
            return this.a.g();
        }
    }
}
