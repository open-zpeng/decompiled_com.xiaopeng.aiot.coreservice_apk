package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
/* compiled from: MenuPopup.java */
/* renamed from: j1  reason: default package */
/* loaded from: classes.dex */
public abstract class j1 implements o1, l1, AdapterView.OnItemClickListener {
    public Rect a;

    public abstract void l(f1 f1Var);

    public abstract void p(View view);

    public abstract void r(boolean z);

    public abstract void s(int i);

    public abstract void t(int i);

    public abstract void u(PopupWindow.OnDismissListener onDismissListener);

    public abstract void v(boolean z);

    public abstract void w(int i);

    public void q(Rect bounds) {
        this.a = bounds;
    }

    public Rect n() {
        return this.a;
    }

    @Override // defpackage.l1
    public void c(Context context, f1 menu) {
    }

    @Override // defpackage.l1
    public boolean j(f1 menu, h1 item) {
        return false;
    }

    @Override // defpackage.l1
    public boolean i(f1 menu, h1 item) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListAdapter outerAdapter = (ListAdapter) parent.getAdapter();
        e1 wrappedAdapter = y(outerAdapter);
        wrappedAdapter.a.M((MenuItem) outerAdapter.getItem(position), this, m() ? 0 : 4);
    }

    public static int o(ListAdapter adapter, ViewGroup parent, Context context, int maxAllowedWidth) {
        int maxWidth = 0;
        View itemView = null;
        int itemType = 0;
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            if (parent == null) {
                parent = new FrameLayout(context);
            }
            itemView = adapter.getView(i, itemView, parent);
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            int itemWidth = itemView.getMeasuredWidth();
            if (itemWidth >= maxAllowedWidth) {
                return maxAllowedWidth;
            }
            if (itemWidth > maxWidth) {
                maxWidth = itemWidth;
            }
        }
        return maxWidth;
    }

    public static e1 y(ListAdapter adapter) {
        if (adapter instanceof HeaderViewListAdapter) {
            return (e1) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
        }
        return (e1) adapter;
    }

    public static boolean x(f1 menu) {
        int count = menu.size();
        for (int i = 0; i < count; i++) {
            MenuItem childItem = menu.getItem(i);
            if (childItem.isVisible() && childItem.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        return true;
    }
}
