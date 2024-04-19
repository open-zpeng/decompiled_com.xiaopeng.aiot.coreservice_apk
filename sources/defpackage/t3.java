package defpackage;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: ArrayMap.java */
/* renamed from: t3  reason: default package */
/* loaded from: classes.dex */
public class t3<K, V> extends z3<K, V> implements Map<K, V> {
    public y3<K, V> j;

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<K, V> */
    public t3() {
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<K, V> */
    public t3(int capacity) {
        super(capacity);
    }

    /* compiled from: ArrayMap.java */
    /* renamed from: t3$a */
    /* loaded from: classes.dex */
    public class a extends y3<K, V> {
        public a() {
        }

        @Override // defpackage.y3
        public int d() {
            return t3.this.i;
        }

        @Override // defpackage.y3
        public Object b(int index, int offset) {
            return t3.this.h[(index << 1) + offset];
        }

        @Override // defpackage.y3
        public int e(Object key) {
            return t3.this.f(key);
        }

        @Override // defpackage.y3
        public int f(Object value) {
            return t3.this.h(value);
        }

        @Override // defpackage.y3
        public Map<K, V> c() {
            return t3.this;
        }

        @Override // defpackage.y3
        public void g(K key, V value) {
            t3.this.put(key, value);
        }

        @Override // defpackage.y3
        public V i(int index, V value) {
            return t3.this.k(index, value);
        }

        @Override // defpackage.y3
        public void h(int index) {
            t3.this.j(index);
        }

        @Override // defpackage.y3
        public void a() {
            t3.this.clear();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<K, V> */
    public final y3<K, V> m() {
        if (this.j == null) {
            this.j = new a();
        }
        return this.j;
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<K, V> */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.i + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<K, V> */
    public boolean n(Collection<?> collection) {
        return y3.p(this, collection);
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<K, V> */
    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m().l();
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<K, V> */
    @Override // java.util.Map
    public Set<K> keySet() {
        return m().m();
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<K, V> */
    @Override // java.util.Map
    public Collection<V> values() {
        return m().n();
    }
}
