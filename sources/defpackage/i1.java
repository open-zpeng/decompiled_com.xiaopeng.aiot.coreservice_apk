package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import defpackage.m9;
import java.lang.reflect.Method;
/* compiled from: MenuItemWrapperICS.java */
/* renamed from: i1  reason: default package */
/* loaded from: classes.dex */
public class i1 extends b1 implements MenuItem {
    public final p8 d;
    public Method e;

    public i1(Context context, p8 object) {
        super(context);
        if (object == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.d = object;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.d.getItemId();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.d.getGroupId();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.d.getOrder();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence title) {
        this.d.setTitle(title);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int title) {
        this.d.setTitle(title);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.d.getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence title) {
        this.d.setTitleCondensed(title);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable icon) {
        this.d.setIcon(icon);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int iconRes) {
        this.d.setIcon(iconRes);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.d.getIcon();
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.d.getIntent();
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        this.d.setShortcut(numericChar, alphaChar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) {
        this.d.setShortcut(numericChar, alphaChar, numericModifiers, alphaModifiers);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar) {
        this.d.setNumericShortcut(numericChar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char numericChar, int numericModifiers) {
        this.d.setNumericShortcut(numericChar, numericModifiers);
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        this.d.setAlphabeticShortcut(alphaChar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char alphaChar, int alphaModifiers) {
        this.d.setAlphabeticShortcut(alphaChar, alphaModifiers);
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean checkable) {
        this.d.setCheckable(checkable);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.d.isCheckable();
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean checked) {
        this.d.setChecked(checked);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.d.isChecked();
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean visible) {
        return this.d.setVisible(visible);
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean enabled) {
        this.d.setEnabled(enabled);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItemClickListener) {
        this.d.setOnMenuItemClickListener(menuItemClickListener != null ? new e(menuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int actionEnum) {
        this.d.setShowAsAction(actionEnum);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int actionEnum) {
        this.d.setShowAsActionFlags(actionEnum);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int resId) {
        this.d.setActionView(resId);
        View actionView = this.d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.d.setActionView(new c(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.d.getActionView();
        if (actionView instanceof c) {
            return ((c) actionView).a();
        }
        return actionView;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider provider) {
        a actionProviderWrapper;
        if (Build.VERSION.SDK_INT >= 16) {
            actionProviderWrapper = new b(this.a, provider);
        } else {
            actionProviderWrapper = new a(this.a, provider);
        }
        this.d.a(provider != null ? actionProviderWrapper : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        m9 provider = this.d.b();
        if (provider instanceof a) {
            return ((a) provider).d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.d.expandActionView();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        this.d.setOnActionExpandListener(listener != null ? new d(listener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence contentDescription) {
        this.d.setContentDescription(contentDescription);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence tooltipText) {
        this.d.setTooltipText(tooltipText);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.d.getTooltipText();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList tint) {
        this.d.setIconTintList(tint);
        return this;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode tintMode) {
        this.d.setIconTintMode(tintMode);
        return this;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.d.getIconTintMode();
    }

    public void h(boolean checkable) {
        try {
            if (this.e == null) {
                this.e = this.d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.e.invoke(this.d, Boolean.valueOf(checkable));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: i1$e */
    /* loaded from: classes.dex */
    public class e implements MenuItem.OnMenuItemClickListener {
        public final MenuItem.OnMenuItemClickListener a;

        public e(MenuItem.OnMenuItemClickListener object) {
            this.a = object;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem item) {
            return this.a.onMenuItemClick(i1.this.c(item));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: i1$d */
    /* loaded from: classes.dex */
    public class d implements MenuItem.OnActionExpandListener {
        public final MenuItem.OnActionExpandListener a;

        public d(MenuItem.OnActionExpandListener object) {
            this.a = object;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem item) {
            return this.a.onMenuItemActionExpand(i1.this.c(item));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem item) {
            return this.a.onMenuItemActionCollapse(i1.this.c(item));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: i1$a */
    /* loaded from: classes.dex */
    public class a extends m9 {
        public final ActionProvider d;

        public a(Context context, ActionProvider inner) {
            super(context);
            this.d = inner;
        }

        @Override // defpackage.m9
        public View c() {
            return this.d.onCreateActionView();
        }

        @Override // defpackage.m9
        public boolean e() {
            return this.d.onPerformDefaultAction();
        }

        @Override // defpackage.m9
        public boolean a() {
            return this.d.hasSubMenu();
        }

        @Override // defpackage.m9
        public void f(SubMenu subMenu) {
            this.d.onPrepareSubMenu(i1.this.d(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: i1$b */
    /* loaded from: classes.dex */
    public class b extends a implements ActionProvider.VisibilityListener {
        public m9.b f;

        public b(Context context, ActionProvider inner) {
            super(context, inner);
        }

        @Override // defpackage.m9
        public View d(MenuItem forItem) {
            return this.d.onCreateActionView(forItem);
        }

        @Override // defpackage.m9
        public boolean g() {
            return this.d.overridesItemVisibility();
        }

        @Override // defpackage.m9
        public boolean b() {
            return this.d.isVisible();
        }

        @Override // defpackage.m9
        public void j(m9.b listener) {
            this.f = listener;
            this.d.setVisibilityListener(listener != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean isVisible) {
            m9.b bVar = this.f;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(isVisible);
            }
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: i1$c */
    /* loaded from: classes.dex */
    public static class c extends FrameLayout implements s0 {
        public final CollapsibleActionView a;

        public c(View actionView) {
            super(actionView.getContext());
            this.a = (CollapsibleActionView) actionView;
            addView(actionView);
        }

        @Override // defpackage.s0
        public void c() {
            this.a.onActionViewExpanded();
        }

        @Override // defpackage.s0
        public void d() {
            this.a.onActionViewCollapsed();
        }

        public View a() {
            return (View) this.a;
        }
    }
}
