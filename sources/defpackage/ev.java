package defpackage;
/* compiled from: OpenHashSet.java */
/* renamed from: ev  reason: default package */
/* loaded from: classes.dex */
public final class ev<T> {
    public final float a;
    public int b;
    public int c;
    public int d;
    public T[] e;

    /* JADX WARN: Generic types in debug info not equals: ev != io.reactivex.internal.util.OpenHashSet<T> */
    public ev() {
        this(16, 0.75f);
    }

    /* JADX WARN: Generic types in debug info not equals: ev != io.reactivex.internal.util.OpenHashSet<T> */
    public ev(int capacity, float loadFactor) {
        this.a = loadFactor;
        int c = fv.a(capacity);
        this.b = c - 1;
        this.d = (int) (c * loadFactor);
        this.e = (T[]) new Object[c];
    }

    /* JADX WARN: Generic types in debug info not equals: ev != io.reactivex.internal.util.OpenHashSet<T> */
    public boolean a(T value) {
        T curr;
        T[] a = this.e;
        int m = this.b;
        int pos = c(value.hashCode()) & m;
        T curr2 = a[pos];
        if (curr2 != null) {
            if (curr2.equals(value)) {
                return false;
            }
            do {
                pos = (pos + 1) & m;
                curr = a[pos];
                if (curr == null) {
                }
            } while (!curr.equals(value));
            return false;
        }
        a[pos] = value;
        int i = this.c + 1;
        this.c = i;
        if (i >= this.d) {
            d();
        }
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: ev != io.reactivex.internal.util.OpenHashSet<T> */
    public boolean e(T value) {
        T curr;
        T[] a = this.e;
        int m = this.b;
        int pos = c(value.hashCode()) & m;
        T curr2 = a[pos];
        if (curr2 == null) {
            return false;
        }
        if (curr2.equals(value)) {
            return f(pos, a, m);
        }
        do {
            pos = (pos + 1) & m;
            curr = a[pos];
            if (curr == null) {
                return false;
            }
        } while (!curr.equals(value));
        return f(pos, a, m);
    }

    /* JADX WARN: Generic types in debug info not equals: ev != io.reactivex.internal.util.OpenHashSet<T> */
    public boolean f(int pos, T[] a, int m) {
        T curr;
        this.c--;
        while (true) {
            int last = pos;
            pos = (pos + 1) & m;
            while (true) {
                curr = a[pos];
                if (curr == null) {
                    a[last] = null;
                    return true;
                }
                int slot = c(curr.hashCode()) & m;
                if (last > pos) {
                    if (last >= slot && slot > pos) {
                        break;
                    }
                    pos = (pos + 1) & m;
                } else if (last < slot && slot <= pos) {
                    pos = (pos + 1) & m;
                }
            }
            a[last] = curr;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: ev != io.reactivex.internal.util.OpenHashSet<T> */
    public void d() {
        T[] a = this.e;
        int i = a.length;
        int newCap = i << 1;
        int m = newCap - 1;
        T[] b = (T[]) new Object[newCap];
        int pos = this.c;
        while (true) {
            int j = pos - 1;
            if (pos != 0) {
                do {
                    i--;
                } while (a[i] == null);
                int pos2 = c(a[i].hashCode()) & m;
                if (b[pos2] != null) {
                    do {
                        pos2 = (pos2 + 1) & m;
                    } while (b[pos2] != null);
                }
                b[pos2] = a[i];
                pos = j;
            } else {
                this.b = m;
                this.d = (int) (newCap * this.a);
                this.e = b;
                return;
            }
        }
    }

    public static int c(int x) {
        int h = (-1640531527) * x;
        return (h >>> 16) ^ h;
    }

    /* JADX WARN: Generic types in debug info not equals: ev != io.reactivex.internal.util.OpenHashSet<T> */
    public Object[] b() {
        return this.e;
    }
}
