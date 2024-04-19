package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import defpackage.f1;
/* compiled from: SubMenuBuilder.java */
/* renamed from: q1  reason: default package */
/* loaded from: classes.dex */
public class q1 extends f1 implements SubMenu {
    public f1 B;
    public h1 C;

    public q1(Context context, f1 parentMenu, h1 item) {
        super(context);
        this.B = parentMenu;
        this.C = item;
    }

    @Override // defpackage.f1, android.view.Menu
    public void setQwertyMode(boolean isQwerty) {
        this.B.setQwertyMode(isQwerty);
    }

    @Override // defpackage.f1
    public boolean G() {
        return this.B.G();
    }

    @Override // defpackage.f1
    public boolean H() {
        return this.B.H();
    }

    public Menu e0() {
        return this.B;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.C;
    }

    @Override // defpackage.f1
    public void R(f1.a callback) {
        this.B.R(callback);
    }

    @Override // defpackage.f1
    public f1 D() {
        return this.B.D();
    }

    @Override // defpackage.f1
    public boolean h(f1 menu, MenuItem item) {
        return super.h(menu, item) || this.B.h(menu, item);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable icon) {
        this.C.setIcon(icon);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int iconRes) {
        this.C.setIcon(iconRes);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable icon) {
        return (SubMenu) super.V(icon);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int iconRes) {
        return (SubMenu) super.U(iconRes);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence title) {
        return (SubMenu) super.Y(title);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int titleRes) {
        return (SubMenu) super.X(titleRes);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.Z(view);
    }

    @Override // defpackage.f1
    public boolean k(h1 item) {
        return this.B.k(item);
    }

    @Override // defpackage.f1
    public boolean f(h1 item) {
        return this.B.f(item);
    }

    @Override // defpackage.f1
    public String t() {
        h1 h1Var = this.C;
        int itemId = h1Var != null ? h1Var.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.t() + ":" + itemId;
    }

    @Override // defpackage.f1, android.view.Menu
    public void setGroupDividerEnabled(boolean groupDividerEnabled) {
        this.B.setGroupDividerEnabled(groupDividerEnabled);
    }

    @Override // defpackage.f1
    public boolean F() {
        return this.B.F();
    }
}
