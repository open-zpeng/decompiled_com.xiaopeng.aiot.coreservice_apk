package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Map;
/* compiled from: SimpleArrayMap.java */
/* renamed from: z3  reason: default package */
/* loaded from: classes.dex */
public class z3<K, V> {
    public static Object[] a;
    public static int b;
    public static Object[] d;
    public static int f;
    public int[] g;
    public Object[] h;
    public int i;

    public static int b(int[] hashes, int N, int hash) {
        try {
            return v3.a(hashes, N, hash);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public int e(Object key, int hash) {
        int N = this.i;
        if (N == 0) {
            return -1;
        }
        int index = b(this.g, N, hash);
        if (index < 0) {
            return index;
        }
        if (key.equals(this.h[index << 1])) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.g[end] == hash) {
            if (key.equals(this.h[end << 1])) {
                return end;
            }
            end++;
        }
        for (int i = index - 1; i >= 0 && this.g[i] == hash; i--) {
            if (key.equals(this.h[i << 1])) {
                return i;
            }
        }
        int i2 = ~end;
        return i2;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public int g() {
        int N = this.i;
        if (N == 0) {
            return -1;
        }
        int index = b(this.g, N, 0);
        if (index < 0) {
            return index;
        }
        if (this.h[index << 1] == null) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.g[end] == 0) {
            if (this.h[end << 1] == null) {
                return end;
            }
            end++;
        }
        for (int i = index - 1; i >= 0 && this.g[i] == 0; i--) {
            if (this.h[i << 1] == null) {
                return i;
            }
        }
        int i2 = ~end;
        return i2;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public final void a(int size) {
        if (size == 8) {
            synchronized (z3.class) {
                Object[] array = d;
                if (array != null) {
                    this.h = array;
                    d = (Object[]) array[0];
                    this.g = (int[]) array[1];
                    array[1] = null;
                    array[0] = null;
                    f--;
                    return;
                }
            }
        } else if (size == 4) {
            synchronized (z3.class) {
                Object[] array2 = a;
                if (array2 != null) {
                    this.h = array2;
                    a = (Object[]) array2[0];
                    this.g = (int[]) array2[1];
                    array2[1] = null;
                    array2[0] = null;
                    b--;
                    return;
                }
            }
        }
        this.g = new int[size];
        this.h = new Object[size << 1];
    }

    public static void d(int[] hashes, Object[] array, int size) {
        if (hashes.length == 8) {
            synchronized (z3.class) {
                if (f < 10) {
                    array[0] = d;
                    array[1] = hashes;
                    for (int i = (size << 1) - 1; i >= 2; i--) {
                        array[i] = null;
                    }
                    d = array;
                    f++;
                }
            }
        } else if (hashes.length == 4) {
            synchronized (z3.class) {
                if (b < 10) {
                    array[0] = a;
                    array[1] = hashes;
                    for (int i2 = (size << 1) - 1; i2 >= 2; i2--) {
                        array[i2] = null;
                    }
                    a = array;
                    b++;
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public z3() {
        this.g = v3.a;
        this.h = v3.c;
        this.i = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public z3(int capacity) {
        if (capacity == 0) {
            this.g = v3.a;
            this.h = v3.c;
        } else {
            a(capacity);
        }
        this.i = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public void clear() {
        if (this.i > 0) {
            int[] ohashes = this.g;
            Object[] oarray = this.h;
            int osize = this.i;
            this.g = v3.a;
            this.h = v3.c;
            this.i = 0;
            d(ohashes, oarray, osize);
        }
        if (this.i > 0) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public void c(int minimumCapacity) {
        int osize = this.i;
        if (this.g.length < minimumCapacity) {
            int[] ohashes = this.g;
            Object[] oarray = this.h;
            a(minimumCapacity);
            if (this.i > 0) {
                System.arraycopy(ohashes, 0, this.g, 0, osize);
                System.arraycopy(oarray, 0, this.h, 0, osize << 1);
            }
            d(ohashes, oarray, osize);
        }
        if (this.i != osize) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public boolean containsKey(Object key) {
        return f(key) >= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public int f(Object key) {
        return key == null ? g() : e(key, key.hashCode());
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public int h(Object value) {
        int N = this.i * 2;
        Object[] array = this.h;
        if (value == null) {
            for (int i = 1; i < N; i += 2) {
                if (array[i] == null) {
                    return i >> 1;
                }
            }
            return -1;
        }
        for (int i2 = 1; i2 < N; i2 += 2) {
            if (value.equals(array[i2])) {
                return i2 >> 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public boolean containsValue(Object value) {
        return h(value) >= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public V get(Object key) {
        return getOrDefault(key, null);
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public V getOrDefault(Object key, V defaultValue) {
        int index = f(key);
        return index >= 0 ? (V) this.h[(index << 1) + 1] : defaultValue;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public K i(int index) {
        return (K) this.h[index << 1];
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public V l(int index) {
        return (V) this.h[(index << 1) + 1];
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public V k(int index, V value) {
        int index2 = (index << 1) + 1;
        Object[] objArr = this.h;
        V old = (V) objArr[index2];
        objArr[index2] = value;
        return old;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public boolean isEmpty() {
        return this.i <= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public V put(K key, V value) {
        int hash;
        int index;
        int osize = this.i;
        if (key == null) {
            hash = 0;
            index = g();
        } else {
            hash = key.hashCode();
            index = e(key, hash);
        }
        if (index >= 0) {
            int index2 = (index << 1) + 1;
            Object[] objArr = this.h;
            V old = (V) objArr[index2];
            objArr[index2] = value;
            return old;
        }
        int index3 = ~index;
        if (osize >= this.g.length) {
            int n = 4;
            if (osize >= 8) {
                n = (osize >> 1) + osize;
            } else if (osize >= 4) {
                n = 8;
            }
            int[] ohashes = this.g;
            Object[] oarray = this.h;
            a(n);
            if (osize != this.i) {
                throw new ConcurrentModificationException();
            }
            int[] iArr = this.g;
            if (iArr.length > 0) {
                System.arraycopy(ohashes, 0, iArr, 0, ohashes.length);
                System.arraycopy(oarray, 0, this.h, 0, oarray.length);
            }
            d(ohashes, oarray, osize);
        }
        if (index3 < osize) {
            int[] iArr2 = this.g;
            System.arraycopy(iArr2, index3, iArr2, index3 + 1, osize - index3);
            Object[] objArr2 = this.h;
            System.arraycopy(objArr2, index3 << 1, objArr2, (index3 + 1) << 1, (this.i - index3) << 1);
        }
        int i = this.i;
        if (osize == i) {
            int[] iArr3 = this.g;
            if (index3 < iArr3.length) {
                iArr3[index3] = hash;
                Object[] objArr3 = this.h;
                objArr3[index3 << 1] = key;
                objArr3[(index3 << 1) + 1] = value;
                this.i = i + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public V putIfAbsent(K key, V value) {
        V mapValue = get(key);
        if (mapValue == null) {
            return put(key, value);
        }
        return mapValue;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public V remove(Object key) {
        int index = f(key);
        if (index >= 0) {
            return j(index);
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public boolean remove(Object key, Object value) {
        int index = f(key);
        if (index >= 0) {
            V mapValue = l(index);
            if (value == mapValue || (value != null && value.equals(mapValue))) {
                j(index);
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public V j(int index) {
        int nsize;
        Object[] objArr = this.h;
        V v = (V) objArr[(index << 1) + 1];
        int osize = this.i;
        if (osize <= 1) {
            d(this.g, objArr, osize);
            this.g = v3.a;
            this.h = v3.c;
            nsize = 0;
        } else {
            nsize = osize - 1;
            int[] iArr = this.g;
            if (iArr.length > 8 && this.i < iArr.length / 3) {
                int n = osize > 8 ? osize + (osize >> 1) : 8;
                int[] ohashes = this.g;
                Object[] oarray = this.h;
                a(n);
                if (osize != this.i) {
                    throw new ConcurrentModificationException();
                }
                if (index > 0) {
                    System.arraycopy(ohashes, 0, this.g, 0, index);
                    System.arraycopy(oarray, 0, this.h, 0, index << 1);
                }
                if (index < nsize) {
                    System.arraycopy(ohashes, index + 1, this.g, index, nsize - index);
                    System.arraycopy(oarray, (index + 1) << 1, this.h, index << 1, (nsize - index) << 1);
                }
            } else {
                if (index < nsize) {
                    System.arraycopy(iArr, index + 1, iArr, index, nsize - index);
                    Object[] objArr2 = this.h;
                    System.arraycopy(objArr2, (index + 1) << 1, objArr2, index << 1, (nsize - index) << 1);
                }
                Object[] objArr3 = this.h;
                objArr3[nsize << 1] = null;
                objArr3[(nsize << 1) + 1] = null;
            }
        }
        if (osize != this.i) {
            throw new ConcurrentModificationException();
        }
        this.i = nsize;
        return v;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public V replace(K key, V value) {
        int index = f(key);
        if (index >= 0) {
            return k(index, value);
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public boolean replace(K key, V oldValue, V newValue) {
        int index = f(key);
        if (index >= 0) {
            V mapValue = l(index);
            if (mapValue == oldValue || (oldValue != null && oldValue.equals(mapValue))) {
                k(index, newValue);
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public int size() {
        return this.i;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<?, ?> */
    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof z3) {
            z3 z3Var = (z3) object;
            if (size() != z3Var.size()) {
                return false;
            }
            for (int i = 0; i < this.i; i++) {
                try {
                    K key = i(i);
                    V mine = l(i);
                    Object theirs = z3Var.get(key);
                    if (mine == null) {
                        if (theirs != null || !z3Var.containsKey(key)) {
                            return false;
                        }
                    } else if (!mine.equals(theirs)) {
                        return false;
                    }
                } catch (ClassCastException e) {
                    return false;
                } catch (NullPointerException e2) {
                    return false;
                }
            }
            return true;
        } else if (object instanceof Map) {
            Map<?, ?> map = (Map) object;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.i; i2++) {
                try {
                    K key2 = i(i2);
                    V mine2 = l(i2);
                    Object theirs2 = map.get(key2);
                    if (mine2 == null) {
                        if (theirs2 != null || !map.containsKey(key2)) {
                            return false;
                        }
                    } else if (!mine2.equals(theirs2)) {
                        return false;
                    }
                } catch (ClassCastException e3) {
                    return false;
                } catch (NullPointerException e4) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public int hashCode() {
        int[] hashes = this.g;
        Object[] array = this.h;
        int result = 0;
        int i = 0;
        int v = 1;
        int s = this.i;
        while (i < s) {
            Object value = array[v];
            result += hashes[i] ^ (value == null ? 0 : value.hashCode());
            i++;
            v += 2;
        }
        return result;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<K, V> */
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.i * 28);
        buffer.append('{');
        for (int i = 0; i < this.i; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            Object key = i(i);
            if (key != this) {
                buffer.append(key);
            } else {
                buffer.append("(this Map)");
            }
            buffer.append('=');
            Object value = l(i);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Map)");
            }
        }
        buffer.append('}');
        return buffer.toString();
    }
}
