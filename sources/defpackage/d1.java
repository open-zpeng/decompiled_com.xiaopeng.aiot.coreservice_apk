package defpackage;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ExpandedMenuView;
import defpackage.l1;
import defpackage.m1;
import java.util.ArrayList;
/* compiled from: ListMenuPresenter.java */
/* renamed from: d1  reason: default package */
/* loaded from: classes.dex */
public class d1 implements l1, AdapterView.OnItemClickListener {
    public Context a;
    public LayoutInflater b;
    public f1 d;
    public ExpandedMenuView f;
    public int g;
    public int h;
    public int i;
    public l1.a j;
    public a k;

    public d1(Context context, int itemLayoutRes) {
        this(itemLayoutRes, 0);
        this.a = context;
        this.b = LayoutInflater.from(context);
    }

    public d1(int itemLayoutRes, int themeRes) {
        this.i = itemLayoutRes;
        this.h = themeRes;
    }

    @Override // defpackage.l1
    public void c(Context context, f1 menu) {
        int i = this.h;
        if (i != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            this.a = contextThemeWrapper;
            this.b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.a != null) {
            this.a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from(context);
            }
        }
        this.d = menu;
        a aVar = this.k;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public m1 d(ViewGroup root) {
        if (this.f == null) {
            this.f = (ExpandedMenuView) this.b.inflate(t.g, root, false);
            if (this.k == null) {
                this.k = new a();
            }
            this.f.setAdapter((ListAdapter) this.k);
            this.f.setOnItemClickListener(this);
        }
        return this.f;
    }

    public ListAdapter b() {
        if (this.k == null) {
            this.k = new a();
        }
        return this.k;
    }

    @Override // defpackage.l1
    public void f(boolean cleared) {
        a aVar = this.k;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // defpackage.l1
    public void k(l1.a cb) {
        this.j = cb;
    }

    @Override // defpackage.l1
    public boolean e(q1 subMenu) {
        if (subMenu.hasVisibleItems()) {
            new g1(subMenu).d(null);
            l1.a aVar = this.j;
            if (aVar != null) {
                aVar.b(subMenu);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.l1
    public void a(f1 menu, boolean allMenusAreClosing) {
        l1.a aVar = this.j;
        if (aVar != null) {
            aVar.a(menu, allMenusAreClosing);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.d.M(this.k.getItem(position), this, 0);
    }

    @Override // defpackage.l1
    public boolean h() {
        return false;
    }

    @Override // defpackage.l1
    public boolean j(f1 menu, h1 item) {
        return false;
    }

    @Override // defpackage.l1
    public boolean i(f1 menu, h1 item) {
        return false;
    }

    /* compiled from: ListMenuPresenter.java */
    /* renamed from: d1$a */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        public int a = -1;

        public a() {
            a();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int count = d1.this.d.z().size() - d1.this.g;
            if (this.a < 0) {
                return count;
            }
            return count - 1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b */
        public h1 getItem(int position) {
            ArrayList<h1> z = d1.this.d.z();
            int position2 = position + d1.this.g;
            int i = this.a;
            if (i >= 0 && position2 >= i) {
                position2++;
            }
            return z.get(position2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                d1 d1Var = d1.this;
                convertView = d1Var.b.inflate(d1Var.i, parent, false);
            }
            m1.a itemView = (m1.a) convertView;
            itemView.i(getItem(position), 0);
            return convertView;
        }

        public void a() {
            h1 expandedItem = d1.this.d.v();
            if (expandedItem != null) {
                ArrayList<h1> z = d1.this.d.z();
                int count = z.size();
                for (int i = 0; i < count; i++) {
                    h1 item = z.get(i);
                    if (item == expandedItem) {
                        this.a = i;
                        return;
                    }
                }
            }
            this.a = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }
}
