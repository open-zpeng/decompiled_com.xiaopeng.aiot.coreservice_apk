package defpackage;

import android.util.Log;
import androidx.fragment.app.Fragment;
import defpackage.qd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* compiled from: FragmentManagerViewModel.java */
/* renamed from: gc  reason: default package */
/* loaded from: classes.dex */
public final class gc extends pd {
    public static final qd.a c = new a();
    public final boolean g;
    public final HashMap<String, Fragment> d = new HashMap<>();
    public final HashMap<String, gc> e = new HashMap<>();
    public final HashMap<String, rd> f = new HashMap<>();
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;

    /* compiled from: FragmentManagerViewModel.java */
    /* renamed from: gc$a */
    /* loaded from: classes.dex */
    public class a implements qd.a {
        @Override // defpackage.qd.a
        public <T extends pd> T a(Class<T> modelClass) {
            gc viewModel = new gc(true);
            return viewModel;
        }
    }

    public static gc i(rd viewModelStore) {
        qd viewModelProvider = new qd(viewModelStore, c);
        return (gc) viewModelProvider.a(gc.class);
    }

    public gc(boolean stateAutomaticallySaved) {
        this.g = stateAutomaticallySaved;
    }

    public void n(boolean isStateSaved) {
        this.j = isStateSaved;
    }

    @Override // defpackage.pd
    public void d() {
        if (dc.F0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.h = true;
    }

    public boolean l() {
        return this.h;
    }

    public void e(Fragment fragment) {
        if (this.j) {
            if (dc.F0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.d.containsKey(fragment.i)) {
        } else {
            this.d.put(fragment.i, fragment);
            if (dc.F0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public Fragment g(String who) {
        return this.d.get(who);
    }

    public Collection<Fragment> j() {
        return new ArrayList(this.d.values());
    }

    public boolean o(Fragment fragment) {
        if (this.d.containsKey(fragment.i)) {
            if (this.g) {
                return this.h;
            }
            return !this.i;
        }
        return true;
    }

    public void m(Fragment fragment) {
        if (this.j) {
            if (dc.F0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        boolean removed = this.d.remove(fragment.i) != null;
        if (removed && dc.F0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public gc h(Fragment f) {
        gc childNonConfig = this.e.get(f.i);
        if (childNonConfig == null) {
            gc childNonConfig2 = new gc(this.g);
            this.e.put(f.i, childNonConfig2);
            return childNonConfig2;
        }
        return childNonConfig;
    }

    public rd k(Fragment f) {
        rd viewModelStore = this.f.get(f.i);
        if (viewModelStore == null) {
            rd viewModelStore2 = new rd();
            this.f.put(f.i, viewModelStore2);
            return viewModelStore2;
        }
        return viewModelStore;
    }

    public void f(Fragment f) {
        if (dc.F0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + f);
        }
        gc childNonConfig = this.e.get(f.i);
        if (childNonConfig != null) {
            childNonConfig.d();
            this.e.remove(f.i);
        }
        rd viewModelStore = this.f.get(f.i);
        if (viewModelStore != null) {
            viewModelStore.a();
            this.f.remove(f.i);
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        gc that = (gc) o;
        if (this.d.equals(that.d) && this.e.equals(that.e) && this.f.equals(that.f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = this.d.hashCode();
        return (((result * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> fragmentIterator = this.d.values().iterator();
        while (fragmentIterator.hasNext()) {
            sb.append(fragmentIterator.next());
            if (fragmentIterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> childNonConfigIterator = this.e.keySet().iterator();
        while (childNonConfigIterator.hasNext()) {
            sb.append(childNonConfigIterator.next());
            if (childNonConfigIterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> viewModelStoreIterator = this.f.keySet().iterator();
        while (viewModelStoreIterator.hasNext()) {
            sb.append(viewModelStoreIterator.next());
            if (viewModelStoreIterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
