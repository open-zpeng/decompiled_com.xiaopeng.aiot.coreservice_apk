package defpackage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStateManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* compiled from: FragmentStore.java */
/* renamed from: lc  reason: default package */
/* loaded from: classes.dex */
public class lc {
    public final ArrayList<Fragment> a = new ArrayList<>();
    public final HashMap<String, kc> b = new HashMap<>();
    public gc c;

    public void x(gc nonConfig) {
        this.c = nonConfig;
    }

    public gc o() {
        return this.c;
    }

    public void t() {
        this.b.clear();
    }

    public void u(List<String> added) {
        this.a.clear();
        if (added != null) {
            for (String who : added) {
                Fragment f = f(who);
                if (f == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + who + ")");
                }
                if (dc.F0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + who + "): " + f);
                }
                a(f);
            }
        }
    }

    public void p(kc newlyActive) {
        Fragment f = newlyActive.k();
        if (c(f.i)) {
            return;
        }
        this.b.put(f.i, newlyActive);
        if (f.F) {
            if (f.E) {
                this.c.e(f);
            } else {
                this.c.m(f);
            }
            f.F = false;
        }
        if (dc.F0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + f);
        }
    }

    public void a(Fragment fragment) {
        if (this.a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.a) {
            this.a.add(fragment);
        }
        fragment.o = true;
    }

    public void d(int state) {
        for (kc fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                fragmentStateManager.t(state);
            }
        }
    }

    public void r() {
        Iterator<Fragment> it = this.a.iterator();
        while (it.hasNext()) {
            kc fragmentStateManager = this.b.get(it.next().i);
            if (fragmentStateManager != null) {
                fragmentStateManager.m();
            }
        }
        for (kc fragmentStateManager2 : this.b.values()) {
            if (fragmentStateManager2 != null) {
                fragmentStateManager2.m();
                Fragment f = fragmentStateManager2.k();
                boolean beingRemoved = f.p && !f.V();
                if (beingRemoved) {
                    q(fragmentStateManager2);
                }
            }
        }
    }

    public void s(Fragment fragment) {
        synchronized (this.a) {
            this.a.remove(fragment);
        }
        fragment.o = false;
    }

    public void q(kc newlyInactive) {
        Fragment f = newlyInactive.k();
        if (f.E) {
            this.c.m(f);
        }
        kc removedStateManager = this.b.put(f.i, null);
        if (removedStateManager != null && dc.F0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + f);
        }
    }

    public void b() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    public ArrayList<jc> v() {
        ArrayList<jc> arrayList = new ArrayList<>(this.b.size());
        for (kc fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                Fragment f = fragmentStateManager.k();
                jc fs = fragmentStateManager.r();
                arrayList.add(fs);
                if (dc.F0(2)) {
                    Log.v("FragmentManager", "Saved state of " + f + ": " + fs.o);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> w() {
        synchronized (this.a) {
            if (this.a.isEmpty()) {
                return null;
            }
            ArrayList<String> added = new ArrayList<>(this.a.size());
            Iterator<Fragment> it = this.a.iterator();
            while (it.hasNext()) {
                Fragment f = it.next();
                added.add(f.i);
                if (dc.F0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + f.i + "): " + f);
                }
            }
            return added;
        }
    }

    public List<kc> k() {
        ArrayList<FragmentStateManager> activeFragmentStateManagers = new ArrayList<>();
        for (kc fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                activeFragmentStateManagers.add(fragmentStateManager);
            }
        }
        return activeFragmentStateManagers;
    }

    public List<Fragment> n() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public List<Fragment> l() {
        ArrayList<Fragment> activeFragments = new ArrayList<>();
        for (kc fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                activeFragments.add(fragmentStateManager.k());
            } else {
                activeFragments.add(null);
            }
        }
        return activeFragments;
    }

    public Fragment g(int id) {
        for (int i = this.a.size() - 1; i >= 0; i--) {
            Fragment f = this.a.get(i);
            if (f != null && f.z == id) {
                return f;
            }
        }
        for (kc fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                Fragment f2 = fragmentStateManager.k();
                if (f2.z == id) {
                    return f2;
                }
            }
        }
        return null;
    }

    public Fragment h(String tag) {
        if (tag != null) {
            for (int i = this.a.size() - 1; i >= 0; i--) {
                Fragment f = this.a.get(i);
                if (f != null && tag.equals(f.B)) {
                    return f;
                }
            }
        }
        if (tag != null) {
            for (kc fragmentStateManager : this.b.values()) {
                if (fragmentStateManager != null) {
                    Fragment f2 = fragmentStateManager.k();
                    if (tag.equals(f2.B)) {
                        return f2;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public boolean c(String who) {
        return this.b.get(who) != null;
    }

    public kc m(String who) {
        return this.b.get(who);
    }

    public Fragment i(String who) {
        Fragment f;
        for (kc fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null && (f = fragmentStateManager.k().h(who)) != null) {
                return f;
            }
        }
        return null;
    }

    public Fragment f(String who) {
        kc fragmentStateManager = this.b.get(who);
        if (fragmentStateManager != null) {
            return fragmentStateManager.k();
        }
        return null;
    }

    public int j(Fragment f) {
        View view;
        View view2;
        ViewGroup container = f.J;
        if (container == null) {
            return -1;
        }
        int fragmentIndex = this.a.indexOf(f);
        for (int i = fragmentIndex - 1; i >= 0; i--) {
            Fragment underFragment = this.a.get(i);
            if (underFragment.J == container && (view2 = underFragment.K) != null) {
                int underIndex = container.indexOfChild(view2);
                return underIndex + 1;
            }
        }
        for (int i2 = fragmentIndex + 1; i2 < this.a.size(); i2++) {
            Fragment overFragment = this.a.get(i2);
            if (overFragment.J == container && (view = overFragment.K) != null) {
                return container.indexOfChild(view);
            }
        }
        return -1;
    }

    public void e(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        String innerPrefix = prefix + "    ";
        if (!this.b.isEmpty()) {
            writer.print(prefix);
            writer.println("Active Fragments:");
            for (kc fragmentStateManager : this.b.values()) {
                writer.print(prefix);
                if (fragmentStateManager != null) {
                    Fragment f = fragmentStateManager.k();
                    writer.println(f);
                    f.f(innerPrefix, fd, writer, args);
                } else {
                    writer.println("null");
                }
            }
        }
        int count = this.a.size();
        if (count > 0) {
            writer.print(prefix);
            writer.println("Added Fragments:");
            for (int i = 0; i < count; i++) {
                writer.print(prefix);
                writer.print("  #");
                writer.print(i);
                writer.print(": ");
                writer.println(this.a.get(i).toString());
            }
        }
    }
}
