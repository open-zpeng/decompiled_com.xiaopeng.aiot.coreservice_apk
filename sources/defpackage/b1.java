package defpackage;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
/* compiled from: BaseMenuWrapper.java */
/* renamed from: b1  reason: default package */
/* loaded from: classes.dex */
public abstract class b1 {
    public final Context a;
    public z3<p8, MenuItem> b;
    public z3<q8, SubMenu> c;

    public b1(Context context) {
        this.a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (menuItem instanceof p8) {
            p8 supportMenuItem = (p8) menuItem;
            if (this.b == null) {
                this.b = new z3<>();
            }
            MenuItem wrappedItem = this.b.get(menuItem);
            if (wrappedItem == null) {
                MenuItem wrappedItem2 = new i1(this.a, supportMenuItem);
                this.b.put(supportMenuItem, wrappedItem2);
                return wrappedItem2;
            }
            return wrappedItem;
        }
        return menuItem;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (subMenu instanceof q8) {
            q8 supportSubMenu = (q8) subMenu;
            if (this.c == null) {
                this.c = new z3<>();
            }
            SubMenu wrappedMenu = this.c.get(supportSubMenu);
            if (wrappedMenu == null) {
                SubMenu wrappedMenu2 = new r1(this.a, supportSubMenu);
                this.c.put(supportSubMenu, wrappedMenu2);
                return wrappedMenu2;
            }
            return wrappedMenu;
        }
        return subMenu;
    }

    public final void e() {
        z3<p8, MenuItem> z3Var = this.b;
        if (z3Var != null) {
            z3Var.clear();
        }
        z3<q8, SubMenu> z3Var2 = this.c;
        if (z3Var2 != null) {
            z3Var2.clear();
        }
    }

    public final void f(int groupId) {
        if (this.b == null) {
            return;
        }
        int i = 0;
        while (i < this.b.size()) {
            if (this.b.i(i).getGroupId() == groupId) {
                this.b.j(i);
                i--;
            }
            i++;
        }
    }

    public final void g(int id) {
        if (this.b == null) {
            return;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (this.b.i(i).getItemId() == id) {
                this.b.j(i);
                return;
            }
        }
    }
}
