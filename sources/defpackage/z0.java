package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* compiled from: ActionMenuItem.java */
/* renamed from: z0  reason: default package */
/* loaded from: classes.dex */
public class z0 implements p8 {
    public final int a;
    public final int b;
    public final int c;
    public CharSequence d;
    public CharSequence e;
    public Intent f;
    public char g;
    public char i;
    public Drawable k;
    public Context l;
    public MenuItem.OnMenuItemClickListener m;
    public CharSequence n;
    public CharSequence o;
    public int h = 4096;
    public int j = 4096;
    public ColorStateList p = null;
    public PorterDuff.Mode q = null;
    public boolean r = false;
    public boolean s = false;
    public int t = 16;

    public z0(Context context, int group, int id, int categoryOrder, int ordering, CharSequence title) {
        this.l = context;
        this.a = id;
        this.b = group;
        this.c = ordering;
        this.d = title;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.i;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.g;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public int getNumericModifiers() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.e;
        return charSequence != null ? charSequence : this.d;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        this.i = Character.toLowerCase(alphaChar);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar, int alphaModifiers) {
        this.i = Character.toLowerCase(alphaChar);
        this.j = KeyEvent.normalizeMetaState(alphaModifiers);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean checkable) {
        this.t = (this.t & (-2)) | (checkable ? 1 : 0);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean checked) {
        this.t = (this.t & (-3)) | (checked ? 2 : 0);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean enabled) {
        this.t = (this.t & (-17)) | (enabled ? 16 : 0);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable icon) {
        this.k = icon;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int iconRes) {
        this.k = m7.d(this.l, iconRes);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar) {
        this.g = numericChar;
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar, int numericModifiers) {
        this.g = numericChar;
        this.h = KeyEvent.normalizeMetaState(numericModifiers);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItemClickListener) {
        this.m = menuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        this.g = numericChar;
        this.i = Character.toLowerCase(alphaChar);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) {
        this.g = numericChar;
        this.h = KeyEvent.normalizeMetaState(numericModifiers);
        this.i = Character.toLowerCase(alphaChar);
        this.j = KeyEvent.normalizeMetaState(alphaModifiers);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence title) {
        this.d = title;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int title) {
        this.d = this.l.getResources().getString(title);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence title) {
        this.e = title;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean visible) {
        this.t = (this.t & 8) | (visible ? 0 : 8);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public void setShowAsAction(int show) {
    }

    public boolean requiresActionButton() {
        return true;
    }

    public boolean requiresOverflow() {
        return false;
    }

    @Override // defpackage.p8, android.view.MenuItem
    /* renamed from: e */
    public p8 setActionView(View actionView) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.p8, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.p8, android.view.MenuItem
    /* renamed from: d */
    public p8 setActionView(int resId) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.p8
    public m9 b() {
        return null;
    }

    @Override // defpackage.p8
    public p8 a(m9 actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.p8, android.view.MenuItem
    /* renamed from: f */
    public p8 setShowAsActionFlags(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public p8 setContentDescription(CharSequence contentDescription) {
        this.n = contentDescription;
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.n;
    }

    @Override // android.view.MenuItem
    public p8 setTooltipText(CharSequence tooltipText) {
        this.o = tooltipText;
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.o;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList iconTintList) {
        this.p = iconTintList;
        this.r = true;
        c();
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.p;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode iconTintMode) {
        this.q = iconTintMode;
        this.s = true;
        c();
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.q;
    }

    public final void c() {
        Drawable drawable = this.k;
        if (drawable != null) {
            if (this.r || this.s) {
                Drawable q = i8.q(drawable);
                this.k = q;
                Drawable mutate = q.mutate();
                this.k = mutate;
                if (this.r) {
                    i8.n(mutate, this.p);
                }
                if (this.s) {
                    i8.o(this.k, this.q);
                }
            }
        }
    }
}
