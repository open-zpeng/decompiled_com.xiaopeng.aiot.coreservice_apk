package defpackage;

import defpackage.l3;
import java.util.HashMap;
import java.util.Map;
/* compiled from: FastSafeIterableMap.java */
/* renamed from: k3  reason: default package */
/* loaded from: classes.dex */
public class k3<K, V> extends l3<K, V> {
    public HashMap<K, l3.c<K, V>> g = new HashMap<>();

    /* JADX WARN: Generic types in debug info not equals: k3 != androidx.arch.core.internal.FastSafeIterableMap<K, V> */
    @Override // defpackage.l3
    public l3.c<K, V> b(K k) {
        return this.g.get(k);
    }

    /* JADX WARN: Generic types in debug info not equals: k3 != androidx.arch.core.internal.FastSafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
    @Override // defpackage.l3
    public V f(K key, V v) {
        l3.c<K, V> b = b(key);
        if (b != null) {
            return b.b;
        }
        this.g.put(key, e(key, v));
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: k3 != androidx.arch.core.internal.FastSafeIterableMap<K, V> */
    @Override // defpackage.l3
    public V g(K key) {
        V removed = (V) super.g(key);
        this.g.remove(key);
        return removed;
    }

    /* JADX WARN: Generic types in debug info not equals: k3 != androidx.arch.core.internal.FastSafeIterableMap<K, V> */
    public boolean contains(K key) {
        return this.g.containsKey(key);
    }

    /* JADX WARN: Generic types in debug info not equals: k3 != androidx.arch.core.internal.FastSafeIterableMap<K, V> */
    public Map.Entry<K, V> h(K k) {
        if (contains(k)) {
            return this.g.get(k).f;
        }
        return null;
    }
}
