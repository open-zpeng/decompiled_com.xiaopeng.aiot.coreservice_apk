package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* compiled from: MapCollections.java */
/* renamed from: y3  reason: default package */
/* loaded from: classes.dex */
public abstract class y3<K, V> {
    public y3<K, V>.b a;
    public y3<K, V>.c b;
    public y3<K, V>.e c;

    public abstract void a();

    public abstract Object b(int i, int i2);

    public abstract Map<K, V> c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(K k, V v);

    public abstract void h(int i);

    public abstract V i(int i, V v);

    /* compiled from: MapCollections.java */
    /* renamed from: y3$a */
    /* loaded from: classes.dex */
    public final class a<T> implements Iterator<T> {
        public final int a;
        public int b;
        public int d;
        public boolean f = false;

        /* JADX WARN: Generic types in debug info not equals: y3$a != androidx.collection.MapCollections<K, V>$ArrayIterator<T> */
        public a(int offset) {
            this.a = offset;
            this.b = y3.this.d();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$a != androidx.collection.MapCollections<K, V>$ArrayIterator<T> */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d < this.b;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$a != androidx.collection.MapCollections<K, V>$ArrayIterator<T> */
        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) y3.this.b(this.d, this.a);
            this.d++;
            this.f = true;
            return t;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$a != androidx.collection.MapCollections<K, V>$ArrayIterator<T> */
        @Override // java.util.Iterator
        public void remove() {
            if (!this.f) {
                throw new IllegalStateException();
            }
            int i = this.d - 1;
            this.d = i;
            this.b--;
            this.f = false;
            y3.this.h(i);
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: y3$d */
    /* loaded from: classes.dex */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        public int a;
        public boolean d = false;
        public int b = -1;

        /* JADX WARN: Generic types in debug info not equals: y3$d != androidx.collection.MapCollections<K, V>$MapIterator */
        public d() {
            this.a = y3.this.d() - 1;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.b++;
            this.d = true;
            return this;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Iterator
        public void remove() {
            if (!this.d) {
                throw new IllegalStateException();
            }
            y3.this.h(this.b);
            this.b--;
            this.a--;
            this.d = false;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Map.Entry
        public K getKey() {
            if (!this.d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K) y3.this.b(this.b, 0);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Map.Entry
        public V getValue() {
            if (!this.d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) y3.this.b(this.b, 1);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Map.Entry
        public V setValue(V object) {
            if (!this.d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) y3.this.i(this.b, object);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Map.Entry
        public boolean equals(Object o) {
            if (!this.d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry) o;
                return v3.c(e.getKey(), y3.this.b(this.b, 0)) && v3.c(e.getValue(), y3.this.b(this.b, 1));
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$d != androidx.collection.MapCollections<K, V>$MapIterator */
        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object key = y3.this.b(this.b, 0);
            Object value = y3.this.b(this.b, 1);
            return (value != null ? value.hashCode() : 0) ^ (key == null ? 0 : key.hashCode());
        }

        /* JADX WARN: Generic types in debug info not equals: y3$d != androidx.collection.MapCollections<K, V>$MapIterator */
        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: y3$b */
    /* loaded from: classes.dex */
    public final class b implements Set<Map.Entry<K, V>> {
        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        public b() {
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        /* renamed from: a */
        public boolean add(Map.Entry<K, V> object) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int oldSize = y3.this.d();
            for (Map.Entry<K, V> entry : collection) {
                y3.this.g(entry.getKey(), entry.getValue());
            }
            return oldSize != y3.this.d();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public void clear() {
            y3.this.a();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object o) {
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry) o;
                int index = y3.this.e(e.getKey());
                if (index < 0) {
                    return false;
                }
                Object foundVal = y3.this.b(index, 1);
                return v3.c(foundVal, e.getValue());
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return y3.this.d() == 0;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public int size() {
            return y3.this.d();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] array) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object object) {
            return y3.k(this, object);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$b != androidx.collection.MapCollections<K, V>$EntrySet */
        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int result = 0;
            for (int i = y3.this.d() - 1; i >= 0; i--) {
                int i2 = 0;
                Object key = y3.this.b(i, 0);
                Object value = y3.this.b(i, 1);
                int hashCode = key == null ? 0 : key.hashCode();
                if (value != null) {
                    i2 = value.hashCode();
                }
                result += i2 ^ hashCode;
            }
            return result;
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: y3$c */
    /* loaded from: classes.dex */
    public final class c implements Set<K> {
        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        public c() {
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean add(K object) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public void clear() {
            y3.this.a();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object object) {
            return y3.this.e(object) >= 0;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return y3.j(y3.this.c(), collection);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return y3.this.d() == 0;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object object) {
            int index = y3.this.e(object);
            if (index >= 0) {
                y3.this.h(index);
                return true;
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return y3.o(y3.this.c(), collection);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return y3.p(y3.this.c(), collection);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public int size() {
            return y3.this.d();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return y3.this.q(0);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] array) {
            return (T[]) y3.this.r(array, 0);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object object) {
            return y3.k(this, object);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$c != androidx.collection.MapCollections<K, V>$KeySet */
        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int result = 0;
            for (int i = y3.this.d() - 1; i >= 0; i--) {
                int i2 = 0;
                Object obj = y3.this.b(i, 0);
                if (obj != null) {
                    i2 = obj.hashCode();
                }
                result += i2;
            }
            return result;
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: y3$e */
    /* loaded from: classes.dex */
    public final class e implements Collection<V> {
        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        public e() {
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean add(V object) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public void clear() {
            y3.this.a();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean contains(Object object) {
            return y3.this.f(object) >= 0;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean isEmpty() {
            return y3.this.d() == 0;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean remove(Object object) {
            int index = y3.this.f(object);
            if (index >= 0) {
                y3.this.h(index);
                return true;
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int N = y3.this.d();
            boolean changed = false;
            int i = 0;
            while (i < N) {
                Object cur = y3.this.b(i, 1);
                if (collection.contains(cur)) {
                    y3.this.h(i);
                    i--;
                    N--;
                    changed = true;
                }
                i++;
            }
            return changed;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int N = y3.this.d();
            boolean changed = false;
            int i = 0;
            while (i < N) {
                Object cur = y3.this.b(i, 1);
                if (!collection.contains(cur)) {
                    y3.this.h(i);
                    i--;
                    N--;
                    changed = true;
                }
                i++;
            }
            return changed;
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public int size() {
            return y3.this.d();
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public Object[] toArray() {
            return y3.this.q(1);
        }

        /* JADX WARN: Generic types in debug info not equals: y3$e != androidx.collection.MapCollections<K, V>$ValuesCollection */
        @Override // java.util.Collection
        public <T> T[] toArray(T[] array) {
            return (T[]) y3.this.r(array, 1);
        }
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int oldSize = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return oldSize != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int oldSize = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return oldSize != map.size();
    }

    /* JADX WARN: Generic types in debug info not equals: y3 != androidx.collection.MapCollections<K, V> */
    public Object[] q(int offset) {
        int N = d();
        Object[] result = new Object[N];
        for (int i = 0; i < N; i++) {
            result[i] = b(i, offset);
        }
        return result;
    }

    /* JADX WARN: Generic types in debug info not equals: y3 != androidx.collection.MapCollections<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v6 */
    public <T> T[] r(T[] array, int offset) {
        int N = d();
        if (array.length < N) {
            array = (Object[]) Array.newInstance(array.getClass().getComponentType(), N);
        }
        for (int i = 0; i < N; i++) {
            array[i] = b(i, offset);
        }
        int i2 = array.length;
        if (i2 > N) {
            array[N] = null;
        }
        return array;
    }

    public static <T> boolean k(Set<T> set, Object object) {
        if (set == object) {
            return true;
        }
        if (object instanceof Set) {
            Set<?> s = (Set) object;
            try {
                if (set.size() == s.size()) {
                    if (set.containsAll(s)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException e2) {
                return false;
            } catch (NullPointerException e3) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: y3 != androidx.collection.MapCollections<K, V> */
    public Set<Map.Entry<K, V>> l() {
        if (this.a == null) {
            this.a = new b();
        }
        return this.a;
    }

    /* JADX WARN: Generic types in debug info not equals: y3 != androidx.collection.MapCollections<K, V> */
    public Set<K> m() {
        if (this.b == null) {
            this.b = new c();
        }
        return this.b;
    }

    /* JADX WARN: Generic types in debug info not equals: y3 != androidx.collection.MapCollections<K, V> */
    public Collection<V> n() {
        if (this.c == null) {
            this.c = new e();
        }
        return this.c;
    }
}
