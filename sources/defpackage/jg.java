package defpackage;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* compiled from: LinkedTreeMap.java */
/* renamed from: jg  reason: default package */
/* loaded from: classes.dex */
public final class jg<K, V> extends AbstractMap<K, V> implements Serializable {
    public Comparator<? super K> d;
    public e<K, V> f;
    public int g;
    public int h;
    public final e<K, V> i;
    public jg<K, V>.b j;
    public jg<K, V>.c k;
    public static final /* synthetic */ boolean b = true;
    public static final Comparator<Comparable> a = new a();

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: jg$a */
    /* loaded from: classes.dex */
    public static class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: jg$b */
    /* loaded from: classes.dex */
    public class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap.java */
        /* renamed from: jg$b$a */
        /* loaded from: classes.dex */
        public class a extends jg<K, V>.d<Map.Entry<K, V>> {
            public a() {
                super(jg.this, null);
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            jg.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && jg.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> c;
            if ((obj instanceof Map.Entry) && (c = jg.this.c((Map.Entry) obj)) != null) {
                jg.this.f(c, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return jg.this.g;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: jg$c */
    /* loaded from: classes.dex */
    public class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap.java */
        /* renamed from: jg$c$a */
        /* loaded from: classes.dex */
        public class a extends jg<K, V>.d<K> {
            public a() {
                super(jg.this, null);
            }

            @Override // java.util.Iterator
            public K next() {
                return a().h;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            jg.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return jg.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return jg.this.h(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return jg.this.g;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: jg$d */
    /* loaded from: classes.dex */
    public abstract class d<T> implements Iterator<T> {
        public e<K, V> a;
        public e<K, V> b;
        public int d;

        public d() {
            this.a = jg.this.i.f;
            this.b = null;
            this.d = jg.this.h;
        }

        public /* synthetic */ d(jg jgVar, a aVar) {
            this();
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.a;
            jg jgVar = jg.this;
            if (eVar != jgVar.i) {
                if (jgVar.h == this.d) {
                    this.a = eVar.f;
                    this.b = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != jg.this.i;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            jg.this.f(eVar, true);
            this.b = null;
            this.d = jg.this.h;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: jg$e */
    /* loaded from: classes.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {
        public e<K, V> a;
        public e<K, V> b;
        public e<K, V> d;
        public e<K, V> f;
        public e<K, V> g;
        public final K h;
        public V i;
        public int j;

        public e() {
            this.h = null;
            this.g = this;
            this.f = this;
        }

        public e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.a = eVar;
            this.h = k;
            this.j = 1;
            this.f = eVar2;
            this.g = eVar3;
            eVar3.f = this;
            eVar2.g = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.b; eVar2 != null; eVar2 = eVar2.b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.d; eVar2 != null; eVar2 = eVar2.d) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.h;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.i;
                Object value = entry.getValue();
                if (v == null) {
                    if (value != null) {
                        return false;
                    }
                } else if (!v.equals(value)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.i;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.h;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.i;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.i;
            this.i = v;
            return v2;
        }

        public String toString() {
            return this.h + "=" + this.i;
        }
    }

    public jg() {
        this(a);
    }

    public jg(Comparator<? super K> comparator) {
        this.g = 0;
        this.h = 0;
        this.i = new e<>();
        this.d = comparator == null ? a : comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<K, V> a(Object obj) {
        if (obj != 0) {
            try {
                return b(obj, false);
            } catch (ClassCastException e2) {
                return null;
            }
        }
        return null;
    }

    public e<K, V> b(K k, boolean z) {
        int i;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.d;
        e<K, V> eVar2 = this.f;
        if (eVar2 != null) {
            Comparable comparable = comparator == a ? (Comparable) k : null;
            while (true) {
                Object obj = (K) eVar2.h;
                i = comparable != null ? comparable.compareTo(obj) : comparator.compare(k, obj);
                if (i == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i < 0 ? eVar2.b : eVar2.d;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            e<K, V> eVar4 = this.i;
            if (eVar2 != null) {
                eVar = new e<>(eVar2, k, eVar4, eVar4.g);
                if (i < 0) {
                    eVar2.b = eVar;
                } else {
                    eVar2.d = eVar;
                }
                j(eVar2, true);
            } else if (comparator == a && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            } else {
                eVar = new e<>(eVar2, k, eVar4, eVar4.g);
                this.f = eVar;
            }
            this.g++;
            this.h++;
            return eVar;
        }
        return null;
    }

    public e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> a2 = a(entry.getKey());
        if (a2 != null && g(a2.i, entry.getValue())) {
            return a2;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f = null;
        this.g = 0;
        this.h++;
        e<K, V> eVar = this.i;
        eVar.g = eVar;
        eVar.f = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    public final void d(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.b;
        e<K, V> eVar3 = eVar.d;
        e<K, V> eVar4 = eVar3.b;
        e<K, V> eVar5 = eVar3.d;
        eVar.d = eVar4;
        if (eVar4 != null) {
            eVar4.a = eVar;
        }
        e(eVar, eVar3);
        eVar3.b = eVar;
        eVar.a = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.j : 0, eVar4 != null ? eVar4.j : 0) + 1;
        eVar.j = max;
        eVar3.j = Math.max(max, eVar5 != null ? eVar5.j : 0) + 1;
    }

    public final void e(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.a;
        eVar.a = null;
        if (eVar2 != null) {
            eVar2.a = eVar3;
        }
        if (eVar3 == null) {
            this.f = eVar2;
        } else if (eVar3.b == eVar) {
            eVar3.b = eVar2;
        } else if (!b && eVar3.d != eVar) {
            throw new AssertionError();
        } else {
            eVar3.d = eVar2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        jg<K, V>.b bVar = this.j;
        if (bVar != null) {
            return bVar;
        }
        jg<K, V>.b bVar2 = new b();
        this.j = bVar2;
        return bVar2;
    }

    public void f(e<K, V> eVar, boolean z) {
        int i;
        if (z) {
            e<K, V> eVar2 = eVar.g;
            eVar2.f = eVar.f;
            eVar.f.g = eVar2;
        }
        e<K, V> eVar3 = eVar.b;
        e<K, V> eVar4 = eVar.d;
        e<K, V> eVar5 = eVar.a;
        int i2 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                e(eVar, eVar3);
                eVar.b = null;
            } else if (eVar4 != null) {
                e(eVar, eVar4);
                eVar.d = null;
            } else {
                e(eVar, null);
            }
            j(eVar5, false);
            this.g--;
            this.h++;
            return;
        }
        e<K, V> b2 = eVar3.j > eVar4.j ? eVar3.b() : eVar4.a();
        f(b2, false);
        e<K, V> eVar6 = eVar.b;
        if (eVar6 != null) {
            i = eVar6.j;
            b2.b = eVar6;
            eVar6.a = b2;
            eVar.b = null;
        } else {
            i = 0;
        }
        e<K, V> eVar7 = eVar.d;
        if (eVar7 != null) {
            i2 = eVar7.j;
            b2.d = eVar7;
            eVar7.a = b2;
            eVar.d = null;
        }
        b2.j = Math.max(i, i2) + 1;
        e(eVar, b2);
    }

    public final boolean g(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.i;
        }
        return null;
    }

    public e<K, V> h(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            f(a2, true);
        }
        return a2;
    }

    public final void i(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.b;
        e<K, V> eVar3 = eVar.d;
        e<K, V> eVar4 = eVar2.b;
        e<K, V> eVar5 = eVar2.d;
        eVar.b = eVar5;
        if (eVar5 != null) {
            eVar5.a = eVar;
        }
        e(eVar, eVar2);
        eVar2.d = eVar;
        eVar.a = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.j : 0, eVar5 != null ? eVar5.j : 0) + 1;
        eVar.j = max;
        eVar2.j = Math.max(max, eVar4 != null ? eVar4.j : 0) + 1;
    }

    public final void j(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.b;
            e<K, V> eVar3 = eVar.d;
            int i = eVar2 != null ? eVar2.j : 0;
            int i2 = eVar3 != null ? eVar3.j : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                e<K, V> eVar4 = eVar3.b;
                e<K, V> eVar5 = eVar3.d;
                int i4 = (eVar4 != null ? eVar4.j : 0) - (eVar5 != null ? eVar5.j : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    if (!b && i4 != 1) {
                        throw new AssertionError();
                    }
                    i(eVar3);
                }
                d(eVar);
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                e<K, V> eVar6 = eVar2.b;
                e<K, V> eVar7 = eVar2.d;
                int i5 = (eVar6 != null ? eVar6.j : 0) - (eVar7 != null ? eVar7.j : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    if (!b && i5 != -1) {
                        throw new AssertionError();
                    }
                    d(eVar2);
                }
                i(eVar);
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                eVar.j = i + 1;
                if (z) {
                    return;
                }
            } else if (!b && i3 != -1 && i3 != 1) {
                throw new AssertionError();
            } else {
                eVar.j = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        jg<K, V>.c cVar = this.k;
        if (cVar != null) {
            return cVar;
        }
        jg<K, V>.c cVar2 = new c();
        this.k = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            e<K, V> b2 = b(k, true);
            V v2 = b2.i;
            b2.i = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> h = h(obj);
        if (h != null) {
            return h.i;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.g;
    }
}
