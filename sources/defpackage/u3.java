package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* compiled from: ArraySet.java */
/* renamed from: u3  reason: default package */
/* loaded from: classes.dex */
public final class u3<E> implements Collection<E>, Set<E> {
    public static final int[] a = new int[0];
    public static final Object[] b = new Object[0];
    public static Object[] d;
    public static int f;
    public static Object[] g;
    public static int h;
    public int[] i;
    public Object[] j;
    public int k;
    public y3<E, E> l;

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    public final int e(Object key, int hash) {
        int N = this.k;
        if (N == 0) {
            return -1;
        }
        int index = v3.a(this.i, N, hash);
        if (index < 0) {
            return index;
        }
        if (key.equals(this.j[index])) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.i[end] == hash) {
            if (key.equals(this.j[end])) {
                return end;
            }
            end++;
        }
        for (int i = index - 1; i >= 0 && this.i[i] == hash; i--) {
            if (key.equals(this.j[i])) {
                return i;
            }
        }
        int i2 = ~end;
        return i2;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    public final int f() {
        int N = this.k;
        if (N == 0) {
            return -1;
        }
        int index = v3.a(this.i, N, 0);
        if (index < 0) {
            return index;
        }
        if (this.j[index] == null) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.i[end] == 0) {
            if (this.j[end] == null) {
                return end;
            }
            end++;
        }
        for (int i = index - 1; i >= 0 && this.i[i] == 0; i--) {
            if (this.j[i] == null) {
                return i;
            }
        }
        int i2 = ~end;
        return i2;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    public final void a(int size) {
        if (size == 8) {
            synchronized (u3.class) {
                Object[] array = g;
                if (array != null) {
                    this.j = array;
                    g = (Object[]) array[0];
                    this.i = (int[]) array[1];
                    array[1] = null;
                    array[0] = null;
                    h--;
                    return;
                }
            }
        } else if (size == 4) {
            synchronized (u3.class) {
                Object[] array2 = d;
                if (array2 != null) {
                    this.j = array2;
                    d = (Object[]) array2[0];
                    this.i = (int[]) array2[1];
                    array2[1] = null;
                    array2[0] = null;
                    f--;
                    return;
                }
            }
        }
        this.i = new int[size];
        this.j = new Object[size];
    }

    public static void c(int[] hashes, Object[] array, int size) {
        if (hashes.length == 8) {
            synchronized (u3.class) {
                if (h < 10) {
                    array[0] = g;
                    array[1] = hashes;
                    for (int i = size - 1; i >= 2; i--) {
                        array[i] = null;
                    }
                    g = array;
                    h++;
                }
            }
        } else if (hashes.length == 4) {
            synchronized (u3.class) {
                if (f < 10) {
                    array[0] = d;
                    array[1] = hashes;
                    for (int i2 = size - 1; i2 >= 2; i2--) {
                        array[i2] = null;
                    }
                    d = array;
                    f++;
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    public u3() {
        this(0);
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    public u3(int capacity) {
        if (capacity == 0) {
            this.i = a;
            this.j = b;
        } else {
            a(capacity);
        }
        this.k = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.k;
        if (i != 0) {
            c(this.i, this.j, i);
            this.i = a;
            this.j = b;
            this.k = 0;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    public void b(int minimumCapacity) {
        if (this.i.length < minimumCapacity) {
            int[] ohashes = this.i;
            Object[] oarray = this.j;
            a(minimumCapacity);
            int i = this.k;
            if (i > 0) {
                System.arraycopy(ohashes, 0, this.i, 0, i);
                System.arraycopy(oarray, 0, this.j, 0, this.k);
            }
            c(ohashes, oarray, this.k);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object key) {
        return indexOf(key) >= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    public int indexOf(Object key) {
        return key == null ? f() : e(key, key.hashCode());
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    public E h(int index) {
        return (E) this.j[index];
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.k <= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean add(E value) {
        int hash;
        int index;
        if (value == null) {
            hash = 0;
            index = f();
        } else {
            hash = value.hashCode();
            index = e(value, hash);
        }
        if (index >= 0) {
            return false;
        }
        int index2 = ~index;
        int i = this.k;
        if (i >= this.i.length) {
            int i2 = 4;
            if (i >= 8) {
                i2 = (i >> 1) + i;
            } else if (i >= 4) {
                i2 = 8;
            }
            int n = i2;
            int[] ohashes = this.i;
            Object[] oarray = this.j;
            a(n);
            int[] iArr = this.i;
            if (iArr.length > 0) {
                System.arraycopy(ohashes, 0, iArr, 0, ohashes.length);
                System.arraycopy(oarray, 0, this.j, 0, oarray.length);
            }
            c(ohashes, oarray, this.k);
        }
        int i3 = this.k;
        if (index2 < i3) {
            int[] iArr2 = this.i;
            System.arraycopy(iArr2, index2, iArr2, index2 + 1, i3 - index2);
            Object[] objArr = this.j;
            System.arraycopy(objArr, index2, objArr, index2 + 1, this.k - index2);
        }
        this.i[index2] = hash;
        this.j[index2] = value;
        this.k++;
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object object) {
        int index = indexOf(object);
        if (index >= 0) {
            g(index);
            return true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    public E g(int index) {
        Object[] objArr = this.j;
        E e = (E) objArr[index];
        int i = this.k;
        if (i <= 1) {
            c(this.i, objArr, i);
            this.i = a;
            this.j = b;
            this.k = 0;
        } else {
            int[] iArr = this.i;
            if (iArr.length > 8 && i < iArr.length / 3) {
                int n = i > 8 ? i + (i >> 1) : 8;
                int[] ohashes = this.i;
                Object[] oarray = this.j;
                a(n);
                this.k--;
                if (index > 0) {
                    System.arraycopy(ohashes, 0, this.i, 0, index);
                    System.arraycopy(oarray, 0, this.j, 0, index);
                }
                int i2 = this.k;
                if (index < i2) {
                    System.arraycopy(ohashes, index + 1, this.i, index, i2 - index);
                    System.arraycopy(oarray, index + 1, this.j, index, this.k - index);
                }
            } else {
                int i3 = i - 1;
                this.k = i3;
                if (index < i3) {
                    System.arraycopy(iArr, index + 1, iArr, index, i3 - index);
                    Object[] objArr2 = this.j;
                    System.arraycopy(objArr2, index + 1, objArr2, index, this.k - index);
                }
                this.j[this.k] = null;
            }
        }
        return e;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.k;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.k;
        Object[] result = new Object[i];
        System.arraycopy(this.j, 0, result, 0, i);
        return result;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object[]] */
    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] array) {
        if (array.length < this.k) {
            array = (Object[]) Array.newInstance(array.getClass().getComponentType(), this.k);
        }
        System.arraycopy(this.j, 0, array, 0, this.k);
        int length = array.length;
        int i = this.k;
        if (length > i) {
            array[i] = null;
        }
        return array;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Set) {
            Set<?> set = (Set) object;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.k; i++) {
                try {
                    E mine = h(i);
                    if (!set.contains(mine)) {
                        return false;
                    }
                } catch (ClassCastException e) {
                    return false;
                } catch (NullPointerException e2) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] hashes = this.i;
        int result = 0;
        int s = this.k;
        for (int i = 0; i < s; i++) {
            result += hashes[i];
        }
        return result;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.k * 14);
        buffer.append('{');
        for (int i = 0; i < this.k; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            Object value = h(i);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Set)");
            }
        }
        buffer.append('}');
        return buffer.toString();
    }

    /* compiled from: ArraySet.java */
    /* renamed from: u3$a */
    /* loaded from: classes.dex */
    public class a extends y3<E, E> {
        public a() {
        }

        @Override // defpackage.y3
        public int d() {
            return u3.this.k;
        }

        @Override // defpackage.y3
        public Object b(int index, int offset) {
            return u3.this.j[index];
        }

        @Override // defpackage.y3
        public int e(Object key) {
            return u3.this.indexOf(key);
        }

        @Override // defpackage.y3
        public int f(Object value) {
            return u3.this.indexOf(value);
        }

        @Override // defpackage.y3
        public Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // defpackage.y3
        public void g(E key, E value) {
            u3.this.add(key);
        }

        @Override // defpackage.y3
        public E i(int index, E value) {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // defpackage.y3
        public void h(int index) {
            u3.this.g(index);
        }

        @Override // defpackage.y3
        public void a() {
            u3.this.clear();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    public final y3<E, E> d() {
        if (this.l == null) {
            this.l = new a();
        }
        return this.l;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        for (Object item : collection) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.k + collection.size());
        boolean added = false;
        for (E value : collection) {
            added |= add(value);
        }
        return added;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean removed = false;
        for (Object value : collection) {
            removed |= remove(value);
        }
        return removed;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<E> */
    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean removed = false;
        for (int i = this.k - 1; i >= 0; i--) {
            if (!collection.contains(this.j[i])) {
                g(i);
                removed = true;
            }
        }
        return removed;
    }
}
