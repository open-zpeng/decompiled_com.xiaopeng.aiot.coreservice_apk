package defpackage;
/* compiled from: SparseArrayCompat.java */
/* renamed from: a4  reason: default package */
/* loaded from: classes.dex */
public class a4<E> implements Cloneable {
    public static final Object a = new Object();
    public boolean b;
    public int[] d;
    public Object[] f;
    public int g;

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    public a4() {
        this(10);
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    public a4(int initialCapacity) {
        this.b = false;
        if (initialCapacity == 0) {
            this.d = v3.a;
            this.f = v3.c;
            return;
        }
        int initialCapacity2 = v3.e(initialCapacity);
        this.d = new int[initialCapacity2];
        this.f = new Object[initialCapacity2];
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    /* renamed from: c */
    public a4<E> clone() {
        try {
            a4<E> a4Var = (a4) super.clone();
            a4Var.d = (int[]) this.d.clone();
            a4Var.f = (Object[]) this.f.clone();
            return a4Var;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    public E e(int key) {
        return f(key, null);
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    public E f(int key, E valueIfKeyNotFound) {
        int i = v3.a(this.d, this.g, key);
        if (i >= 0) {
            Object[] objArr = this.f;
            if (objArr[i] != a) {
                return (E) objArr[i];
            }
        }
        return valueIfKeyNotFound;
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    public final void d() {
        int n = this.g;
        int o = 0;
        int[] keys = this.d;
        Object[] values = this.f;
        for (int i = 0; i < n; i++) {
            Object val = values[i];
            if (val != a) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
                    values[i] = null;
                }
                o++;
            }
        }
        this.b = false;
        this.g = o;
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    public void h(int key, E value) {
        int i = v3.a(this.d, this.g, key);
        if (i >= 0) {
            this.f[i] = value;
            return;
        }
        int i2 = ~i;
        int i3 = this.g;
        if (i2 < i3) {
            Object[] objArr = this.f;
            if (objArr[i2] == a) {
                this.d[i2] = key;
                objArr[i2] = value;
                return;
            }
        }
        if (this.b && i3 >= this.d.length) {
            d();
            i2 = ~v3.a(this.d, this.g, key);
        }
        int i4 = this.g;
        if (i4 >= this.d.length) {
            int n = v3.e(i4 + 1);
            int[] nkeys = new int[n];
            Object[] nvalues = new Object[n];
            int[] iArr = this.d;
            System.arraycopy(iArr, 0, nkeys, 0, iArr.length);
            Object[] objArr2 = this.f;
            System.arraycopy(objArr2, 0, nvalues, 0, objArr2.length);
            this.d = nkeys;
            this.f = nvalues;
        }
        int n2 = this.g;
        if (n2 - i2 != 0) {
            int[] iArr2 = this.d;
            System.arraycopy(iArr2, i2, iArr2, i2 + 1, n2 - i2);
            Object[] objArr3 = this.f;
            System.arraycopy(objArr3, i2, objArr3, i2 + 1, this.g - i2);
        }
        this.d[i2] = key;
        this.f[i2] = value;
        this.g++;
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    public int i() {
        if (this.b) {
            d();
        }
        return this.g;
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    public int g(int index) {
        if (this.b) {
            d();
        }
        return this.d[index];
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    public E j(int index) {
        if (this.b) {
            d();
        }
        return (E) this.f[index];
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    public void b() {
        int n = this.g;
        Object[] values = this.f;
        for (int i = 0; i < n; i++) {
            values[i] = null;
        }
        this.g = 0;
        this.b = false;
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    public void a(int key, E value) {
        int i = this.g;
        if (i != 0 && key <= this.d[i - 1]) {
            h(key, value);
            return;
        }
        if (this.b && i >= this.d.length) {
            d();
        }
        int pos = this.g;
        if (pos >= this.d.length) {
            int n = v3.e(pos + 1);
            int[] nkeys = new int[n];
            Object[] nvalues = new Object[n];
            int[] iArr = this.d;
            System.arraycopy(iArr, 0, nkeys, 0, iArr.length);
            Object[] objArr = this.f;
            System.arraycopy(objArr, 0, nvalues, 0, objArr.length);
            this.d = nkeys;
            this.f = nvalues;
        }
        this.d[pos] = key;
        this.f[pos] = value;
        this.g = pos + 1;
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<E> */
    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.g * 28);
        buffer.append('{');
        for (int i = 0; i < this.g; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            int key = g(i);
            buffer.append(key);
            buffer.append('=');
            Object value = j(i);
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
