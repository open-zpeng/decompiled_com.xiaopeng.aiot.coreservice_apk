package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import defpackage.m1;
import defpackage.m9;
/* compiled from: MenuItemImpl.java */
/* renamed from: h1  reason: default package */
/* loaded from: classes.dex */
public final class h1 implements p8 {
    public View A;
    public m9 B;
    public MenuItem.OnActionExpandListener C;
    public ContextMenu.ContextMenuInfo E;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public CharSequence e;
    public CharSequence f;
    public Intent g;
    public char h;
    public char j;
    public Drawable l;
    public f1 n;
    public q1 o;
    public Runnable p;
    public MenuItem.OnMenuItemClickListener q;
    public CharSequence r;
    public CharSequence s;
    public int z;
    public int i = 4096;
    public int k = 4096;
    public int m = 0;
    public ColorStateList t = null;
    public PorterDuff.Mode u = null;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public int y = 16;
    public boolean D = false;

    public h1(f1 menu, int group, int id, int categoryOrder, int ordering, CharSequence title, int showAsAction) {
        this.z = 0;
        this.n = menu;
        this.a = id;
        this.b = group;
        this.c = categoryOrder;
        this.d = ordering;
        this.e = title;
        this.z = showAsAction;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(this)) {
            f1 f1Var = this.n;
            if (f1Var.h(f1Var, this)) {
                return true;
            }
            Runnable runnable = this.p;
            if (runnable != null) {
                runnable.run();
                return true;
            }
            if (this.g != null) {
                try {
                    this.n.u().startActivity(this.g);
                    return true;
                } catch (ActivityNotFoundException e) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
                }
            }
            m9 m9Var = this.B;
            return m9Var != null && m9Var.e();
        }
        return true;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean enabled) {
        if (enabled) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    public int f() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        if (this.j == alphaChar) {
            return this;
        }
        this.j = Character.toLowerCase(alphaChar);
        this.n.K(false);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar, int alphaModifiers) {
        if (this.j == alphaChar && this.k == alphaModifiers) {
            return this;
        }
        this.j = Character.toLowerCase(alphaChar);
        this.k = KeyEvent.normalizeMetaState(alphaModifiers);
        this.n.K(false);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.h;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar) {
        if (this.h == numericChar) {
            return this;
        }
        this.h = numericChar;
        this.n.K(false);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar, int numericModifiers) {
        if (this.h == numericChar && this.i == numericModifiers) {
            return this;
        }
        this.h = numericChar;
        this.i = KeyEvent.normalizeMetaState(numericModifiers);
        this.n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        this.h = numericChar;
        this.j = Character.toLowerCase(alphaChar);
        this.n.K(false);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) {
        this.h = numericChar;
        this.i = KeyEvent.normalizeMetaState(numericModifiers);
        this.j = Character.toLowerCase(alphaChar);
        this.k = KeyEvent.normalizeMetaState(alphaModifiers);
        this.n.K(false);
        return this;
    }

    public char g() {
        return this.n.G() ? this.j : this.h;
    }

    public String h() {
        char shortcut = g();
        if (shortcut == 0) {
            return "";
        }
        Resources res = this.n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.n.u()).hasPermanentMenuKey()) {
            sb.append(res.getString(u.abc_prepend_shortcut_label));
        }
        int modifiers = this.n.G() ? this.k : this.i;
        d(sb, modifiers, 65536, res.getString(u.abc_menu_meta_shortcut_label));
        d(sb, modifiers, 4096, res.getString(u.abc_menu_ctrl_shortcut_label));
        d(sb, modifiers, 2, res.getString(u.abc_menu_alt_shortcut_label));
        d(sb, modifiers, 1, res.getString(u.abc_menu_shift_shortcut_label));
        d(sb, modifiers, 4, res.getString(u.abc_menu_sym_shortcut_label));
        d(sb, modifiers, 8, res.getString(u.abc_menu_function_shortcut_label));
        switch (shortcut) {
            case '\b':
                sb.append(res.getString(u.abc_menu_delete_shortcut_label));
                break;
            case '\n':
                sb.append(res.getString(u.abc_menu_enter_shortcut_label));
                break;
            case ' ':
                sb.append(res.getString(u.abc_menu_space_shortcut_label));
                break;
            default:
                sb.append(shortcut);
                break;
        }
        return sb.toString();
    }

    public static void d(StringBuilder sb, int modifiers, int flag, String label) {
        if ((modifiers & flag) == flag) {
            sb.append(label);
        }
    }

    public boolean z() {
        return this.n.H() && g() != 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    public void w(q1 subMenu) {
        this.o = subMenu;
        subMenu.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence i(m1.a itemView) {
        if (itemView != null && itemView.d()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence title) {
        this.e = title;
        this.n.K(false);
        q1 q1Var = this.o;
        if (q1Var != null) {
            q1Var.setHeaderTitle(title);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int title) {
        return setTitle(this.n.u().getString(title));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence ctitle = this.f;
        if (ctitle == null) {
            ctitle = this.e;
        }
        if (Build.VERSION.SDK_INT < 18 && ctitle != null && !(ctitle instanceof String)) {
            return ctitle.toString();
        }
        return ctitle;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence title) {
        this.f = title;
        if (title == null) {
            CharSequence title2 = this.e;
        }
        this.n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.m != 0) {
            Drawable icon = j0.d(this.n.u(), this.m);
            this.m = 0;
            this.l = icon;
            return e(icon);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable icon) {
        this.m = 0;
        this.l = icon;
        this.x = true;
        this.n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int iconResId) {
        this.l = null;
        this.m = iconResId;
        this.x = true;
        this.n.K(false);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList iconTintList) {
        this.t = iconTintList;
        this.v = true;
        this.x = true;
        this.n.K(false);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode iconTintMode) {
        this.u = iconTintMode;
        this.w = true;
        this.x = true;
        this.n.K(false);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    public final Drawable e(Drawable icon) {
        if (icon != null && this.x && (this.v || this.w)) {
            icon = i8.q(icon).mutate();
            if (this.v) {
                i8.n(icon, this.t);
            }
            if (this.w) {
                i8.o(icon, this.u);
            }
            this.x = false;
        }
        return icon;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean checkable) {
        int oldFlags = this.y;
        int i = (this.y & (-2)) | (checkable ? 1 : 0);
        this.y = i;
        if (oldFlags != i) {
            this.n.K(false);
        }
        return this;
    }

    public void s(boolean exclusive) {
        this.y = (this.y & (-5)) | (exclusive ? 4 : 0);
    }

    public boolean m() {
        return (this.y & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean checked) {
        if ((this.y & 4) != 0) {
            this.n.T(this);
        } else {
            r(checked);
        }
        return this;
    }

    public void r(boolean checked) {
        int oldFlags = this.y;
        int i = (this.y & (-3)) | (checked ? 2 : 0);
        this.y = i;
        if (oldFlags != i) {
            this.n.K(false);
        }
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        m9 m9Var = this.B;
        return (m9Var == null || !m9Var.g()) ? (this.y & 8) == 0 : (this.y & 8) == 0 && this.B.b();
    }

    public boolean x(boolean shown) {
        int oldFlags = this.y;
        int i = (this.y & (-9)) | (shown ? 0 : 8);
        this.y = i;
        return oldFlags != i;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean shown) {
        if (x(shown)) {
            this.n.J(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener clickListener) {
        this.q = clickListener;
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(ContextMenu.ContextMenuInfo menuInfo) {
        this.E = menuInfo;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public void c() {
        this.n.I(this);
    }

    public boolean y() {
        return this.n.A();
    }

    public boolean l() {
        return (this.y & 32) == 32;
    }

    public boolean n() {
        return (this.z & 1) == 1;
    }

    public boolean requiresActionButton() {
        return (this.z & 2) == 2;
    }

    public boolean requiresOverflow() {
        return (requiresActionButton() || n()) ? false : true;
    }

    public void t(boolean isActionButton) {
        if (isActionButton) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    public boolean A() {
        return (this.z & 4) == 4;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public void setShowAsAction(int actionEnum) {
        switch (actionEnum & 3) {
            case 0:
            case 1:
            case 2:
                this.z = actionEnum;
                this.n.I(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    @Override // defpackage.p8, android.view.MenuItem
    /* renamed from: p */
    public p8 setActionView(View view) {
        int i;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i = this.a) > 0) {
            view.setId(i);
        }
        this.n.I(this);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    /* renamed from: o */
    public p8 setActionView(int resId) {
        Context context = this.n.u();
        LayoutInflater inflater = LayoutInflater.from(context);
        setActionView(inflater.inflate(resId, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        m9 m9Var = this.B;
        if (m9Var != null) {
            View d = m9Var.d(this);
            this.A = d;
            return d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // defpackage.p8
    public m9 b() {
        return this.B;
    }

    @Override // defpackage.p8
    public p8 a(m9 actionProvider) {
        m9 m9Var = this.B;
        if (m9Var != null) {
            m9Var.h();
        }
        this.A = null;
        this.B = actionProvider;
        this.n.K(true);
        m9 m9Var2 = this.B;
        if (m9Var2 != null) {
            m9Var2.j(new a());
        }
        return this;
    }

    /* compiled from: MenuItemImpl.java */
    /* renamed from: h1$a */
    /* loaded from: classes.dex */
    public class a implements m9.b {
        public a() {
        }

        @Override // defpackage.m9.b
        public void onActionProviderVisibilityChanged(boolean isVisible) {
            h1 h1Var = h1.this;
            h1Var.n.J(h1Var);
        }
    }

    @Override // defpackage.p8, android.view.MenuItem
    /* renamed from: v */
    public p8 setShowAsActionFlags(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public boolean expandActionView() {
        if (j()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.C;
            if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
                return this.n.k(this);
            }
            return false;
        }
        return false;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.f(this);
        }
        return false;
    }

    public boolean j() {
        m9 m9Var;
        if ((this.z & 8) != 0) {
            if (this.A == null && (m9Var = this.B) != null) {
                this.A = m9Var.d(this);
            }
            return this.A != null;
        }
        return false;
    }

    public void q(boolean isExpanded) {
        this.D = isExpanded;
        this.n.K(false);
    }

    @Override // defpackage.p8, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        this.C = listener;
        return this;
    }

    @Override // android.view.MenuItem
    public p8 setContentDescription(CharSequence contentDescription) {
        this.r = contentDescription;
        this.n.K(false);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public p8 setTooltipText(CharSequence tooltipText) {
        this.s = tooltipText;
        this.n.K(false);
        return this;
    }

    @Override // defpackage.p8, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.s;
    }
}
