package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import defpackage.l1;
import defpackage.m1;
import java.util.ArrayList;
/* compiled from: BaseMenuPresenter.java */
/* renamed from: a1  reason: default package */
/* loaded from: classes.dex */
public abstract class a1 implements l1 {
    public Context a;
    public Context b;
    public f1 d;
    public LayoutInflater f;
    public LayoutInflater g;
    public l1.a h;
    public int i;
    public int j;
    public m1 k;
    public int l;

    public abstract void d(h1 h1Var, m1.a aVar);

    public abstract boolean q(int i, h1 h1Var);

    public a1(Context context, int menuLayoutRes, int itemLayoutRes) {
        this.a = context;
        this.f = LayoutInflater.from(context);
        this.i = menuLayoutRes;
        this.j = itemLayoutRes;
    }

    @Override // defpackage.l1
    public void c(Context context, f1 menu) {
        this.b = context;
        this.g = LayoutInflater.from(context);
        this.d = menu;
    }

    public m1 o(ViewGroup root) {
        if (this.k == null) {
            m1 m1Var = (m1) this.f.inflate(this.i, root, false);
            this.k = m1Var;
            m1Var.b(this.d);
            f(true);
        }
        return this.k;
    }

    @Override // defpackage.l1
    public void f(boolean cleared) {
        ViewGroup parent = (ViewGroup) this.k;
        if (parent == null) {
            return;
        }
        int childIndex = 0;
        f1 f1Var = this.d;
        if (f1Var != null) {
            f1Var.r();
            ArrayList<h1> E = this.d.E();
            int itemCount = E.size();
            for (int i = 0; i < itemCount; i++) {
                h1 item = E.get(i);
                if (q(childIndex, item)) {
                    View convertView = parent.getChildAt(childIndex);
                    h1 oldItem = convertView instanceof m1.a ? ((m1.a) convertView).getItemData() : null;
                    View itemView = n(item, convertView, parent);
                    if (item != oldItem) {
                        itemView.setPressed(false);
                        itemView.jumpDrawablesToCurrentState();
                    }
                    if (itemView != convertView) {
                        b(itemView, childIndex);
                    }
                    childIndex++;
                }
            }
        }
        while (childIndex < parent.getChildCount()) {
            if (!l(parent, childIndex)) {
                childIndex++;
            }
        }
    }

    public void b(View itemView, int childIndex) {
        ViewGroup currentParent = (ViewGroup) itemView.getParent();
        if (currentParent != null) {
            currentParent.removeView(itemView);
        }
        ((ViewGroup) this.k).addView(itemView, childIndex);
    }

    public boolean l(ViewGroup parent, int childIndex) {
        parent.removeViewAt(childIndex);
        return true;
    }

    @Override // defpackage.l1
    public void k(l1.a cb) {
        this.h = cb;
    }

    public l1.a m() {
        return this.h;
    }

    public m1.a g(ViewGroup parent) {
        return (m1.a) this.f.inflate(this.j, parent, false);
    }

    public View n(h1 item, View convertView, ViewGroup parent) {
        m1.a itemView;
        if (convertView instanceof m1.a) {
            itemView = (m1.a) convertView;
        } else {
            itemView = g(parent);
        }
        d(item, itemView);
        return (View) itemView;
    }

    @Override // defpackage.l1
    public void a(f1 menu, boolean allMenusAreClosing) {
        l1.a aVar = this.h;
        if (aVar != null) {
            aVar.a(menu, allMenusAreClosing);
        }
    }

    @Override // defpackage.l1
    public boolean e(q1 menu) {
        l1.a aVar = this.h;
        if (aVar != null) {
            return aVar.b(menu != null ? menu : this.d);
        }
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

    public void p(int id) {
        this.l = id;
    }
}
