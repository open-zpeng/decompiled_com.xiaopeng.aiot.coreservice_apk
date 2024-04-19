package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: SafeIterableMap.java */
/* renamed from: l3  reason: default package */
/* loaded from: classes.dex */
public class l3<K, V> implements Iterable<Map.Entry<K, V>> {
    public c<K, V> a;
    public c<K, V> b;
    public WeakHashMap<f<K, V>, Boolean> d = new WeakHashMap<>();
    public int f = 0;

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l3$f */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
    public c<K, V> b(K k) {
        c<K, V> cVar = this.a;
        while (cVar != null && !cVar.a.equals(k)) {
            cVar = cVar.d;
        }
        return cVar;
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
    public V f(K key, V v) {
        c<K, V> b2 = b(key);
        if (b2 != null) {
            return b2.b;
        }
        e(key, v);
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
    public c<K, V> e(K key, V v) {
        c<K, V> cVar = new c<>(key, v);
        this.f++;
        c<K, V> cVar2 = this.b;
        if (cVar2 == null) {
            this.a = cVar;
            this.b = cVar;
            return cVar;
        }
        cVar2.d = cVar;
        cVar.f = cVar2;
        this.b = cVar;
        return cVar;
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
    /* JADX WARN: Generic types in debug info not equals: l3$f != androidx.arch.core.internal.SafeIterableMap$SupportRemove<K, V> */
    public V g(K key) {
        c<K, V> b2 = b(key);
        if (b2 == null) {
            return null;
        }
        this.f--;
        if (!this.d.isEmpty()) {
            for (f<K, V> fVar : this.d.keySet()) {
                fVar.a(b2);
            }
        }
        c<K, V> cVar = b2.f;
        if (cVar != null) {
            cVar.d = b2.d;
        } else {
            this.a = b2.d;
        }
        c<K, V> cVar2 = b2.d;
        if (cVar2 != null) {
            cVar2.f = cVar;
        } else {
            this.b = cVar;
        }
        b2.d = null;
        b2.f = null;
        return b2.b;
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    public int size() {
        return this.f;
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: l3$e != androidx.arch.core.internal.SafeIterableMap$ListIterator<K, V> */
    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.a, this.b);
        this.d.put(aVar, false);
        return aVar;
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: l3$b != androidx.arch.core.internal.SafeIterableMap$DescendingIterator<K, V> */
    public Iterator<Map.Entry<K, V>> descendingIterator() {
        b bVar = new b(this.b, this.a);
        this.d.put(bVar, false);
        return bVar;
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: l3$d != androidx.arch.core.internal.SafeIterableMap<K, V>$IteratorWithAdditions */
    public l3<K, V>.d c() {
        l3<K, V>.d dVar = new d();
        this.d.put(dVar, false);
        return dVar;
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    public Map.Entry<K, V> a() {
        return this.a;
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    public Map.Entry<K, V> d() {
        return this.b;
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l3) {
            l3 map = (l3) obj;
            if (size() != map.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> iterator1 = iterator();
            Iterator iterator2 = map.iterator();
            while (iterator1.hasNext() && iterator2.hasNext()) {
                Map.Entry<K, V> next1 = iterator1.next();
                Object next2 = iterator2.next();
                if ((next1 == null && next2 != null) || (next1 != null && !next1.equals(next2))) {
                    return false;
                }
            }
            return (iterator1.hasNext() || iterator2.hasNext()) ? false : true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    public int hashCode() {
        int h = 0;
        Iterator<Map.Entry<K, V>> i = iterator();
        while (i.hasNext()) {
            h += i.next().hashCode();
        }
        return h;
    }

    /* JADX WARN: Generic types in debug info not equals: l3 != androidx.arch.core.internal.SafeIterableMap<K, V> */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Iterator<Map.Entry<K, V>> iterator = iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next().toString());
            if (iterator.hasNext()) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l3$e */
    /* loaded from: classes.dex */
    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {
        public c<K, V> a;
        public c<K, V> b;

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        /* JADX WARN: Generic types in debug info not equals: l3$e != androidx.arch.core.internal.SafeIterableMap$ListIterator<K, V> */
        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.a = cVar2;
            this.b = cVar;
        }

        /* JADX WARN: Generic types in debug info not equals: l3$e != androidx.arch.core.internal.SafeIterableMap$ListIterator<K, V> */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b != null;
        }

        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        /* JADX WARN: Generic types in debug info not equals: l3$e != androidx.arch.core.internal.SafeIterableMap$ListIterator<K, V> */
        @Override // defpackage.l3.f
        public void a(c<K, V> cVar) {
            if (this.a == cVar && cVar == this.b) {
                this.b = null;
                this.a = null;
            }
            c<K, V> cVar2 = this.a;
            if (cVar2 == cVar) {
                this.a = b(cVar2);
            }
            if (this.b == cVar) {
                this.b = e();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: l3$e != androidx.arch.core.internal.SafeIterableMap$ListIterator<K, V> */
        public final c<K, V> e() {
            c<K, V> cVar = this.b;
            c<K, V> cVar2 = this.a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        /* JADX WARN: Generic types in debug info not equals: l3$e != androidx.arch.core.internal.SafeIterableMap$ListIterator<K, V> */
        @Override // java.util.Iterator
        /* renamed from: d */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> result = this.b;
            this.b = e();
            return result;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l3$a */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        /* JADX WARN: Generic types in debug info not equals: l3$a != androidx.arch.core.internal.SafeIterableMap$AscendingIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* JADX WARN: Generic types in debug info not equals: l3$a != androidx.arch.core.internal.SafeIterableMap$AscendingIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // defpackage.l3.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.d;
        }

        /* JADX WARN: Generic types in debug info not equals: l3$a != androidx.arch.core.internal.SafeIterableMap$AscendingIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // defpackage.l3.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l3$b */
    /* loaded from: classes.dex */
    public static class b<K, V> extends e<K, V> {
        /* JADX WARN: Generic types in debug info not equals: l3$b != androidx.arch.core.internal.SafeIterableMap$DescendingIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        public b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* JADX WARN: Generic types in debug info not equals: l3$b != androidx.arch.core.internal.SafeIterableMap$DescendingIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // defpackage.l3.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f;
        }

        /* JADX WARN: Generic types in debug info not equals: l3$b != androidx.arch.core.internal.SafeIterableMap$DescendingIterator<K, V> */
        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // defpackage.l3.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l3$d */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {
        public c<K, V> a;
        public boolean b = true;

        /* JADX WARN: Generic types in debug info not equals: l3$d != androidx.arch.core.internal.SafeIterableMap<K, V>$IteratorWithAdditions */
        public d() {
        }

        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        /* JADX WARN: Generic types in debug info not equals: l3$d != androidx.arch.core.internal.SafeIterableMap<K, V>$IteratorWithAdditions */
        @Override // defpackage.l3.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f;
                this.a = cVar3;
                this.b = cVar3 == null;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: l3$d != androidx.arch.core.internal.SafeIterableMap<K, V>$IteratorWithAdditions */
        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b) {
                return l3.this.a != null;
            }
            c<K, V> cVar = this.a;
            return (cVar == null || cVar.d == null) ? false : true;
        }

        /* JADX WARN: Generic types in debug info not equals: l3$d != androidx.arch.core.internal.SafeIterableMap<K, V>$IteratorWithAdditions */
        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            if (this.b) {
                this.b = false;
                this.a = l3.this.a;
            } else {
                c<K, V> cVar = this.a;
                this.a = cVar != null ? cVar.d : null;
            }
            return this.a;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l3$c */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        public final K a;
        public final V b;
        public c<K, V> d;
        public c<K, V> f;

        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        public c(K key, V value) {
            this.a = key;
            this.b = value;
        }

        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // java.util.Map.Entry
        public V setValue(V value) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        public String toString() {
            return this.a + "=" + this.b;
        }

        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c entry = (c) obj;
                return this.a.equals(entry.a) && this.b.equals(entry.b);
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: l3$c != androidx.arch.core.internal.SafeIterableMap$Entry<K, V> */
        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }
    }
}
