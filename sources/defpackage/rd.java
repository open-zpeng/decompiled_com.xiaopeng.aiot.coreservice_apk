package defpackage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* compiled from: ViewModelStore.java */
/* renamed from: rd  reason: default package */
/* loaded from: classes.dex */
public class rd {
    public final HashMap<String, pd> a = new HashMap<>();

    public final void d(String key, pd viewModel) {
        pd oldViewModel = this.a.put(key, viewModel);
        if (oldViewModel != null) {
            oldViewModel.d();
        }
    }

    public final pd b(String key) {
        return this.a.get(key);
    }

    public Set<String> c() {
        return new HashSet(this.a.keySet());
    }

    public final void a() {
        for (pd vm : this.a.values()) {
            vm.a();
        }
        this.a.clear();
    }
}
