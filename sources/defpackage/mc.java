package defpackage;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import defpackage.cd;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* compiled from: FragmentTransaction.java */
/* renamed from: mc  reason: default package */
/* loaded from: classes.dex */
public abstract class mc {
    public final zb a;
    public final ClassLoader b;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public String k;
    public int l;
    public CharSequence m;
    public int n;
    public CharSequence o;
    public ArrayList<String> p;
    public ArrayList<String> q;
    public ArrayList<Runnable> s;
    public ArrayList<a> c = new ArrayList<>();
    public boolean j = true;
    public boolean r = false;

    public abstract int f();

    public abstract void g();

    /* compiled from: FragmentTransaction.java */
    /* renamed from: mc$a */
    /* loaded from: classes.dex */
    public static final class a {
        public int a;
        public Fragment b;
        public int c;
        public int d;
        public int e;
        public int f;
        public cd.c g;
        public cd.c h;

        public a() {
        }

        public a(int cmd, Fragment fragment) {
            this.a = cmd;
            this.b = fragment;
            cd.c cVar = cd.c.RESUMED;
            this.g = cVar;
            this.h = cVar;
        }
    }

    public mc(zb fragmentFactory, ClassLoader classLoader) {
        this.a = fragmentFactory;
        this.b = classLoader;
    }

    public void d(a op) {
        this.c.add(op);
        op.c = this.d;
        op.d = this.e;
        op.e = this.f;
        op.f = this.g;
    }

    public mc b(int containerViewId, Fragment fragment, String tag) {
        j(containerViewId, fragment, tag, 1);
        return this;
    }

    public mc c(ViewGroup container, Fragment fragment, String tag) {
        fragment.J = container;
        return b(container.getId(), fragment, tag);
    }

    public void j(int containerViewId, Fragment fragment, String tag, int opcmd) {
        Class<?> fragmentClass = fragment.getClass();
        int modifiers = fragmentClass.getModifiers();
        if (fragmentClass.isAnonymousClass() || !Modifier.isPublic(modifiers) || (fragmentClass.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + fragmentClass.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (tag != null) {
            String str = fragment.B;
            if (str != null && !tag.equals(str)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.B + " now " + tag);
            }
            fragment.B = tag;
        }
        if (containerViewId != 0) {
            if (containerViewId == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + tag + " to container view with no id");
            }
            int i = fragment.z;
            if (i != 0 && i != containerViewId) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.z + " now " + containerViewId);
            }
            fragment.z = containerViewId;
            fragment.A = containerViewId;
        }
        d(new a(opcmd, fragment));
    }

    public mc h(Fragment fragment) {
        d(new a(6, fragment));
        return this;
    }

    public mc e(Fragment fragment) {
        d(new a(7, fragment));
        return this;
    }

    public mc i() {
        if (this.i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.j = false;
        return this;
    }

    public mc k(boolean reorderingAllowed) {
        this.r = reorderingAllowed;
        return this;
    }
}
