package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: MenuBuilder.java */
/* renamed from: f1  reason: default package */
/* loaded from: classes.dex */
public class f1 implements o8 {
    public static final int[] a = {1, 4, 5, 3, 2, 0};
    public boolean A;
    public final Context b;
    public final Resources c;
    public boolean d;
    public boolean e;
    public a f;
    public ContextMenu.ContextMenuInfo n;
    public CharSequence o;
    public Drawable p;
    public View q;
    public h1 y;
    public int m = 0;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public ArrayList<h1> w = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<l1>> x = new CopyOnWriteArrayList<>();
    public boolean z = false;
    public ArrayList<h1> g = new ArrayList<>();
    public ArrayList<h1> h = new ArrayList<>();
    public boolean i = true;
    public ArrayList<h1> j = new ArrayList<>();
    public ArrayList<h1> k = new ArrayList<>();
    public boolean l = true;

    /* compiled from: MenuBuilder.java */
    /* renamed from: f1$a */
    /* loaded from: classes.dex */
    public interface a {
        boolean a(f1 f1Var, MenuItem menuItem);

        void b(f1 f1Var);
    }

    /* compiled from: MenuBuilder.java */
    /* renamed from: f1$b */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(h1 h1Var);
    }

    public f1(Context context) {
        this.b = context;
        this.c = context.getResources();
        b0(true);
    }

    public f1 S(int defaultShowAsAction) {
        this.m = defaultShowAsAction;
        return this;
    }

    public void b(l1 presenter) {
        c(presenter, this.b);
    }

    public void c(l1 presenter, Context menuContext) {
        this.x.add(new WeakReference<>(presenter));
        presenter.c(menuContext, this);
        this.l = true;
    }

    public void O(l1 presenter) {
        Iterator<WeakReference<l1>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<l1> next = it.next();
            l1 item = next.get();
            if (item == null || item == presenter) {
                this.x.remove(next);
            }
        }
    }

    public final void i(boolean cleared) {
        if (this.x.isEmpty()) {
            return;
        }
        d0();
        Iterator<WeakReference<l1>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<l1> next = it.next();
            l1 presenter = next.get();
            if (presenter == null) {
                this.x.remove(next);
            } else {
                presenter.f(cleared);
            }
        }
        c0();
    }

    public final boolean j(q1 subMenu, l1 preferredPresenter) {
        if (this.x.isEmpty()) {
            return false;
        }
        boolean result = false;
        if (preferredPresenter != null) {
            result = preferredPresenter.e(subMenu);
        }
        Iterator<WeakReference<l1>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<l1> next = it.next();
            l1 presenter = next.get();
            if (presenter == null) {
                this.x.remove(next);
            } else if (!result) {
                result = presenter.e(subMenu);
            }
        }
        return result;
    }

    public void Q(Bundle outStates) {
        SparseArray<Parcelable> viewStates = null;
        int itemCount = size();
        for (int i = 0; i < itemCount; i++) {
            MenuItem item = getItem(i);
            View v = item.getActionView();
            if (v != null && v.getId() != -1) {
                if (viewStates == null) {
                    viewStates = new SparseArray<>();
                }
                v.saveHierarchyState(viewStates);
                if (item.isActionViewExpanded()) {
                    outStates.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                q1 subMenu = (q1) item.getSubMenu();
                subMenu.Q(outStates);
            }
        }
        if (viewStates != null) {
            outStates.putSparseParcelableArray(t(), viewStates);
        }
    }

    public void P(Bundle states) {
        MenuItem itemToExpand;
        if (states == null) {
            return;
        }
        SparseArray<Parcelable> viewStates = states.getSparseParcelableArray(t());
        int itemCount = size();
        for (int i = 0; i < itemCount; i++) {
            MenuItem item = getItem(i);
            View v = item.getActionView();
            if (v != null && v.getId() != -1) {
                v.restoreHierarchyState(viewStates);
            }
            if (item.hasSubMenu()) {
                q1 subMenu = (q1) item.getSubMenu();
                subMenu.P(states);
            }
        }
        int expandedId = states.getInt("android:menu:expandedactionview");
        if (expandedId > 0 && (itemToExpand = findItem(expandedId)) != null) {
            itemToExpand.expandActionView();
        }
    }

    public String t() {
        return "android:menu:actionviewstates";
    }

    public void R(a cb) {
        this.f = cb;
    }

    public MenuItem a(int group, int id, int categoryOrder, CharSequence title) {
        int ordering = B(categoryOrder);
        h1 item = g(group, id, categoryOrder, ordering, title, this.m);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.n;
        if (contextMenuInfo != null) {
            item.u(contextMenuInfo);
        }
        ArrayList<h1> arrayList = this.g;
        arrayList.add(n(arrayList, ordering), item);
        K(true);
        return item;
    }

    public final h1 g(int group, int id, int categoryOrder, int ordering, CharSequence title, int defaultShowAsAction) {
        return new h1(this, group, id, categoryOrder, ordering, title, defaultShowAsAction);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence title) {
        return a(0, 0, 0, title);
    }

    @Override // android.view.Menu
    public MenuItem add(int titleRes) {
        return a(0, 0, 0, this.c.getString(titleRes));
    }

    @Override // android.view.Menu
    public MenuItem add(int group, int id, int categoryOrder, CharSequence title) {
        return a(group, id, categoryOrder, title);
    }

    @Override // android.view.Menu
    public MenuItem add(int group, int id, int categoryOrder, int title) {
        return a(group, id, categoryOrder, this.c.getString(title));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence title) {
        return addSubMenu(0, 0, 0, title);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int titleRes) {
        return addSubMenu(0, 0, 0, this.c.getString(titleRes));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        h1 item = (h1) a(group, id, categoryOrder, title);
        q1 subMenu = new q1(this.b, this, item);
        item.w(subMenu);
        return subMenu;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int group, int id, int categoryOrder, int title) {
        return addSubMenu(group, id, categoryOrder, this.c.getString(title));
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean enabled) {
        this.z = enabled;
    }

    public boolean F() {
        return this.z;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int group, int id, int categoryOrder, ComponentName caller, Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        int i;
        PackageManager pm = this.b.getPackageManager();
        List<ResolveInfo> lri = pm.queryIntentActivityOptions(caller, specifics, intent, 0);
        int N = lri != null ? lri.size() : 0;
        if ((flags & 1) == 0) {
            removeGroup(group);
        }
        for (int i2 = 0; i2 < N; i2++) {
            ResolveInfo ri = lri.get(i2);
            int i3 = ri.specificIndex;
            Intent rintent = new Intent(i3 < 0 ? intent : specifics[i3]);
            ActivityInfo activityInfo = ri.activityInfo;
            rintent.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem item = add(group, id, categoryOrder, ri.loadLabel(pm)).setIcon(ri.loadIcon(pm)).setIntent(rintent);
            if (outSpecificItems != null && (i = ri.specificIndex) >= 0) {
                outSpecificItems[i] = item;
            }
        }
        return N;
    }

    @Override // android.view.Menu
    public void removeItem(int id) {
        N(o(id), true);
    }

    @Override // android.view.Menu
    public void removeGroup(int group) {
        int i = l(group);
        if (i >= 0) {
            int maxRemovable = this.g.size() - i;
            int numRemoved = 0;
            while (true) {
                int numRemoved2 = numRemoved + 1;
                if (numRemoved >= maxRemovable || this.g.get(i).getGroupId() != group) {
                    break;
                }
                N(i, false);
                numRemoved = numRemoved2;
            }
            K(true);
        }
    }

    public final void N(int index, boolean updateChildrenOnMenuViews) {
        if (index < 0 || index >= this.g.size()) {
            return;
        }
        this.g.remove(index);
        if (updateChildrenOnMenuViews) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        h1 h1Var = this.y;
        if (h1Var != null) {
            f(h1Var);
        }
        this.g.clear();
        K(true);
    }

    public void T(MenuItem item) {
        int group = item.getGroupId();
        int N = this.g.size();
        d0();
        for (int i = 0; i < N; i++) {
            h1 curItem = this.g.get(i);
            if (curItem.getGroupId() == group && curItem.m() && curItem.isCheckable()) {
                curItem.r(curItem == item);
            }
        }
        c0();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        int N = this.g.size();
        for (int i = 0; i < N; i++) {
            h1 item = this.g.get(i);
            if (item.getGroupId() == group) {
                item.s(exclusive);
                item.setCheckable(checkable);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int group, boolean visible) {
        int N = this.g.size();
        boolean changedAtLeastOneItem = false;
        for (int i = 0; i < N; i++) {
            h1 item = this.g.get(i);
            if (item.getGroupId() == group && item.x(visible)) {
                changedAtLeastOneItem = true;
            }
        }
        if (changedAtLeastOneItem) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int group, boolean enabled) {
        int N = this.g.size();
        for (int i = 0; i < N; i++) {
            h1 item = this.g.get(i);
            if (item.getGroupId() == group) {
                item.setEnabled(enabled);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.A) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            h1 item = this.g.get(i);
            if (item.isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int id) {
        MenuItem possibleItem;
        int size = size();
        for (int i = 0; i < size; i++) {
            h1 item = this.g.get(i);
            if (item.getItemId() == id) {
                return item;
            }
            if (item.hasSubMenu() && (possibleItem = item.getSubMenu().findItem(id)) != null) {
                return possibleItem;
            }
        }
        return null;
    }

    public int o(int id) {
        int size = size();
        for (int i = 0; i < size; i++) {
            h1 item = this.g.get(i);
            if (item.getItemId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int l(int group) {
        return m(group, 0);
    }

    public int m(int group, int start) {
        int size = size();
        if (start < 0) {
            start = 0;
        }
        for (int i = start; i < size; i++) {
            h1 item = this.g.get(i);
            if (item.getGroupId() == group) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public int size() {
        return this.g.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int index) {
        return this.g.get(index);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return p(keyCode, event) != null;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean isQwerty) {
        this.d = isQwerty;
        K(false);
    }

    public static int B(int categoryOrder) {
        int index = ((-65536) & categoryOrder) >> 16;
        if (index >= 0) {
            int[] iArr = a;
            if (index < iArr.length) {
                return (iArr[index] << 16) | (65535 & categoryOrder);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public boolean G() {
        return this.d;
    }

    public final void b0(boolean shortcutsVisible) {
        boolean z = true;
        this.e = (shortcutsVisible && this.c.getConfiguration().keyboard != 1 && ha.b(ViewConfiguration.get(this.b), this.b)) ? false : false;
    }

    public boolean H() {
        return this.e;
    }

    public Resources C() {
        return this.c;
    }

    public Context u() {
        return this.b;
    }

    public boolean h(f1 menu, MenuItem item) {
        a aVar = this.f;
        return aVar != null && aVar.a(menu, item);
    }

    public void d() {
        a aVar = this.f;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public static int n(ArrayList<h1> arrayList, int ordering) {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            h1 item = arrayList.get(i);
            if (item.f() <= ordering) {
                return i + 1;
            }
        }
        return 0;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        h1 item = p(keyCode, event);
        boolean handled = false;
        if (item != null) {
            handled = L(item, flags);
        }
        if ((flags & 2) != 0) {
            e(true);
        }
        return handled;
    }

    public void q(List<h1> list, int keyCode, KeyEvent event) {
        boolean qwerty = G();
        int modifierState = event.getModifiers();
        KeyCharacterMap.KeyData possibleChars = new KeyCharacterMap.KeyData();
        boolean isKeyCodeMapped = event.getKeyData(possibleChars);
        if (!isKeyCodeMapped && keyCode != 67) {
            return;
        }
        int N = this.g.size();
        for (int i = 0; i < N; i++) {
            h1 item = this.g.get(i);
            if (item.hasSubMenu()) {
                ((f1) item.getSubMenu()).q(list, keyCode, event);
            }
            char shortcutChar = qwerty ? item.getAlphabeticShortcut() : item.getNumericShortcut();
            int shortcutModifiers = qwerty ? item.getAlphabeticModifiers() : item.getNumericModifiers();
            boolean isModifiersExactMatch = (modifierState & 69647) == (69647 & shortcutModifiers);
            if (isModifiersExactMatch && shortcutChar != 0) {
                char[] cArr = possibleChars.meta;
                if (shortcutChar != cArr[0] && shortcutChar != cArr[2]) {
                    if (qwerty && shortcutChar == '\b') {
                        if (keyCode != 67) {
                        }
                    }
                }
                if (item.isEnabled()) {
                    list.add(item);
                }
            }
        }
    }

    public h1 p(int keyCode, KeyEvent event) {
        ArrayList<h1> arrayList = this.w;
        arrayList.clear();
        q(arrayList, keyCode, event);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = event.getMetaState();
        KeyCharacterMap.KeyData possibleChars = new KeyCharacterMap.KeyData();
        event.getKeyData(possibleChars);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean qwerty = G();
        for (int i = 0; i < size; i++) {
            h1 item = arrayList.get(i);
            char shortcutChar = qwerty ? item.getAlphabeticShortcut() : item.getNumericShortcut();
            char[] cArr = possibleChars.meta;
            if ((shortcutChar == cArr[0] && (metaState & 2) == 0) || ((shortcutChar == cArr[2] && (metaState & 2) != 0) || (qwerty && shortcutChar == '\b' && keyCode == 67))) {
                return item;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int id, int flags) {
        return L(findItem(id), flags);
    }

    public boolean L(MenuItem item, int flags) {
        return M(item, null, flags);
    }

    public boolean M(MenuItem item, l1 preferredPresenter, int flags) {
        boolean providerHasSubMenu;
        h1 itemImpl = (h1) item;
        if (itemImpl == null || !itemImpl.isEnabled()) {
            return false;
        }
        boolean invoked = itemImpl.k();
        m9 provider = itemImpl.b();
        if (provider == null || !provider.a()) {
            providerHasSubMenu = false;
        } else {
            providerHasSubMenu = true;
        }
        if (itemImpl.j()) {
            invoked |= itemImpl.expandActionView();
            if (invoked) {
                e(true);
            }
        } else if (itemImpl.hasSubMenu() || providerHasSubMenu) {
            if ((flags & 4) == 0) {
                e(false);
            }
            if (!itemImpl.hasSubMenu()) {
                itemImpl.w(new q1(u(), this, itemImpl));
            }
            q1 subMenu = (q1) itemImpl.getSubMenu();
            if (providerHasSubMenu) {
                provider.f(subMenu);
            }
            invoked |= j(subMenu, preferredPresenter);
            if (!invoked) {
                e(true);
            }
        } else if ((flags & 1) == 0) {
            e(true);
        }
        return invoked;
    }

    public final void e(boolean closeAllMenus) {
        if (this.v) {
            return;
        }
        this.v = true;
        Iterator<WeakReference<l1>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<l1> next = it.next();
            l1 presenter = next.get();
            if (presenter == null) {
                this.x.remove(next);
            } else {
                presenter.a(this, closeAllMenus);
            }
        }
        this.v = false;
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void K(boolean structureChanged) {
        if (!this.r) {
            if (structureChanged) {
                this.i = true;
                this.l = true;
            }
            i(structureChanged);
            return;
        }
        this.s = true;
        if (structureChanged) {
            this.t = true;
        }
    }

    public void d0() {
        if (!this.r) {
            this.r = true;
            this.s = false;
            this.t = false;
        }
    }

    public void c0() {
        this.r = false;
        if (this.s) {
            this.s = false;
            K(this.t);
        }
    }

    public void J(h1 item) {
        this.i = true;
        K(true);
    }

    public void I(h1 item) {
        this.l = true;
        K(true);
    }

    public ArrayList<h1> E() {
        if (this.i) {
            this.h.clear();
            int itemsSize = this.g.size();
            for (int i = 0; i < itemsSize; i++) {
                h1 item = this.g.get(i);
                if (item.isVisible()) {
                    this.h.add(item);
                }
            }
            this.i = false;
            this.l = true;
            return this.h;
        }
        return this.h;
    }

    public void r() {
        ArrayList<h1> E = E();
        if (!this.l) {
            return;
        }
        boolean flagged = false;
        Iterator<WeakReference<l1>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<l1> next = it.next();
            l1 presenter = next.get();
            if (presenter == null) {
                this.x.remove(next);
            } else {
                flagged |= presenter.h();
            }
        }
        if (flagged) {
            this.j.clear();
            this.k.clear();
            int itemsSize = E.size();
            for (int i = 0; i < itemsSize; i++) {
                h1 item = E.get(i);
                if (item.l()) {
                    this.j.add(item);
                } else {
                    this.k.add(item);
                }
            }
        } else {
            this.j.clear();
            this.k.clear();
            this.k.addAll(E());
        }
        this.l = false;
    }

    public ArrayList<h1> s() {
        r();
        return this.j;
    }

    public ArrayList<h1> z() {
        r();
        return this.k;
    }

    public void clearHeader() {
        this.p = null;
        this.o = null;
        this.q = null;
        K(false);
    }

    public final void W(int titleRes, CharSequence title, int iconRes, Drawable icon, View view) {
        Resources r = C();
        if (view != null) {
            this.q = view;
            this.o = null;
            this.p = null;
        } else {
            if (titleRes > 0) {
                this.o = r.getText(titleRes);
            } else if (title != null) {
                this.o = title;
            }
            if (iconRes > 0) {
                this.p = m7.d(u(), iconRes);
            } else if (icon != null) {
                this.p = icon;
            }
            this.q = null;
        }
        K(false);
    }

    public f1 Y(CharSequence title) {
        W(0, title, 0, null, null);
        return this;
    }

    public f1 X(int titleRes) {
        W(titleRes, null, 0, null, null);
        return this;
    }

    public f1 V(Drawable icon) {
        W(0, null, 0, icon, null);
        return this;
    }

    public f1 U(int iconRes) {
        W(0, null, iconRes, null, null);
        return this;
    }

    public f1 Z(View view) {
        W(0, null, 0, null, view);
        return this;
    }

    public CharSequence x() {
        return this.o;
    }

    public Drawable w() {
        return this.p;
    }

    public View y() {
        return this.q;
    }

    public f1 D() {
        return this;
    }

    public boolean A() {
        return this.u;
    }

    public boolean k(h1 item) {
        if (this.x.isEmpty()) {
            return false;
        }
        boolean expanded = false;
        d0();
        Iterator<WeakReference<l1>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<l1> next = it.next();
            l1 presenter = next.get();
            if (presenter == null) {
                this.x.remove(next);
            } else {
                boolean j = presenter.j(this, item);
                expanded = j;
                if (j) {
                    break;
                }
            }
        }
        c0();
        if (expanded) {
            this.y = item;
        }
        return expanded;
    }

    public boolean f(h1 item) {
        if (this.x.isEmpty() || this.y != item) {
            return false;
        }
        boolean collapsed = false;
        d0();
        Iterator<WeakReference<l1>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference<l1> next = it.next();
            l1 presenter = next.get();
            if (presenter == null) {
                this.x.remove(next);
            } else {
                boolean i = presenter.i(this, item);
                collapsed = i;
                if (i) {
                    break;
                }
            }
        }
        c0();
        if (collapsed) {
            this.y = null;
        }
        return collapsed;
    }

    public h1 v() {
        return this.y;
    }

    public void a0(boolean override) {
        this.A = override;
    }
}
