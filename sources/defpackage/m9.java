package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* compiled from: ActionProvider.java */
/* renamed from: m9  reason: default package */
/* loaded from: classes.dex */
public abstract class m9 {
    public final Context a;
    public a b;
    public b c;

    /* compiled from: ActionProvider.java */
    /* renamed from: m9$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: m9$b */
    /* loaded from: classes.dex */
    public interface b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public abstract View c();

    public m9(Context context) {
        this.a = context;
    }

    public View d(MenuItem forItem) {
        return c();
    }

    public boolean g() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public boolean e() {
        return false;
    }

    public boolean a() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public void i(a listener) {
        this.b = listener;
    }

    public void j(b listener) {
        if (this.c != null && listener != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = listener;
    }

    public void h() {
        this.c = null;
        this.b = null;
    }
}
