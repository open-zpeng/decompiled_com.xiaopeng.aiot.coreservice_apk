package defpackage;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import defpackage.r0;
import java.util.ArrayList;
/* compiled from: SupportActionModeWrapper.java */
/* renamed from: v0  reason: default package */
/* loaded from: classes.dex */
public class v0 extends ActionMode {
    public final Context a;
    public final r0 b;

    public v0(Context context, r0 supportActionMode) {
        this.a = context;
        this.b = supportActionMode;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.b.h();
    }

    @Override // android.view.ActionMode
    public void setTag(Object tag) {
        this.b.p(tag);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence title) {
        this.b.r(title);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence subtitle) {
        this.b.o(subtitle);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.b.k();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.b.c();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new n1(this.a, (o8) this.b.e());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.b.i();
    }

    @Override // android.view.ActionMode
    public void setTitle(int resId) {
        this.b.q(resId);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.b.g();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int resId) {
        this.b.n(resId);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.b.d();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.b.m(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.b.f();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.b.j();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean titleOptional) {
        this.b.s(titleOptional);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.b.l();
    }

    /* compiled from: SupportActionModeWrapper.java */
    /* renamed from: v0$a */
    /* loaded from: classes.dex */
    public static class a implements r0.a {
        public final ActionMode.Callback a;
        public final Context b;
        public final ArrayList<v0> c = new ArrayList<>();
        public final z3<Menu, Menu> d = new z3<>();

        public a(Context context, ActionMode.Callback supportCallback) {
            this.b = context;
            this.a = supportCallback;
        }

        @Override // defpackage.r0.a
        public boolean d(r0 mode, Menu menu) {
            return this.a.onCreateActionMode(e(mode), f(menu));
        }

        @Override // defpackage.r0.a
        public boolean a(r0 mode, Menu menu) {
            return this.a.onPrepareActionMode(e(mode), f(menu));
        }

        @Override // defpackage.r0.a
        public boolean c(r0 mode, MenuItem item) {
            return this.a.onActionItemClicked(e(mode), new i1(this.b, (p8) item));
        }

        @Override // defpackage.r0.a
        public void b(r0 mode) {
            this.a.onDestroyActionMode(e(mode));
        }

        public final Menu f(Menu menu) {
            Menu wrapper = this.d.get(menu);
            if (wrapper == null) {
                Menu wrapper2 = new n1(this.b, (o8) menu);
                this.d.put(menu, wrapper2);
                return wrapper2;
            }
            return wrapper;
        }

        public ActionMode e(r0 mode) {
            int count = this.c.size();
            for (int i = 0; i < count; i++) {
                v0 wrapper = this.c.get(i);
                if (wrapper != null && wrapper.b == mode) {
                    return wrapper;
                }
            }
            v0 wrapper2 = new v0(this.b, mode);
            this.c.add(wrapper2);
            return wrapper2;
        }
    }
}
