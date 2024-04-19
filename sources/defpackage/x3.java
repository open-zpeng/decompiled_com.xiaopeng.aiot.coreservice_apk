package defpackage;

import java.util.LinkedHashMap;
import java.util.Locale;
/* compiled from: LruCache.java */
/* renamed from: x3  reason: default package */
/* loaded from: classes.dex */
public class x3<K, V> {
    public final LinkedHashMap<K, V> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    /* JADX WARN: Generic types in debug info not equals: x3 != androidx.collection.LruCache<K, V> */
    public x3(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = maxSize;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX WARN: Generic types in debug info not equals: x3 != androidx.collection.LruCache<K, V> */
    public final V c(K key) {
        V mapValue;
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V mapValue2 = this.a.get(key);
            if (mapValue2 != null) {
                this.g++;
                return mapValue2;
            }
            this.h++;
            V createdValue = a(key);
            if (createdValue == null) {
                return null;
            }
            synchronized (this) {
                this.e++;
                mapValue = this.a.put(key, createdValue);
                if (mapValue != null) {
                    this.a.put(key, mapValue);
                } else {
                    this.b += e(key, createdValue);
                }
            }
            if (mapValue != null) {
                b(false, key, createdValue, mapValue);
                return mapValue;
            }
            g(this.c);
            return createdValue;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: x3 != androidx.collection.LruCache<K, V> */
    public final V d(K key, V value) {
        V previous;
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.d++;
            this.b += e(key, value);
            previous = this.a.put(key, value);
            if (previous != null) {
                this.b -= e(key, previous);
            }
        }
        if (previous != null) {
            b(false, key, previous, value);
        }
        g(this.c);
        return previous;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* JADX WARN: Generic types in debug info not equals: x3 != androidx.collection.LruCache<K, V> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(int r6) {
        /*
            r5 = this;
        L0:
            monitor-enter(r5)
            int r0 = r5.b     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, V> r0 = r5.a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r5.b     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r5.b     // Catch: java.lang.Throwable -> L71
            if (r0 <= r6) goto L50
            java.util.LinkedHashMap<K, V> r0 = r5.a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r5.a     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r2 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<K, V> r3 = r5.a     // Catch: java.lang.Throwable -> L71
            r3.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r3 = r5.b     // Catch: java.lang.Throwable -> L71
            int r4 = r5.e(r1, r2)     // Catch: java.lang.Throwable -> L71
            int r3 = r3 - r4
            r5.b = r3     // Catch: java.lang.Throwable -> L71
            int r3 = r5.f     // Catch: java.lang.Throwable -> L71
            r4 = 1
            int r3 = r3 + r4
            r5.f = r3     // Catch: java.lang.Throwable -> L71
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L71
            r0 = 0
            r5.b(r4, r1, r2, r0)
            goto L0
        L50:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r1.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r2 = r5.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L71
            r1.append(r2)     // Catch: java.lang.Throwable -> L71
            java.lang.String r2 = ".sizeOf() is reporting inconsistent results!"
            r1.append(r2)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L71
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L71
            throw r0     // Catch: java.lang.Throwable -> L71
        L71:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L71
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x3.g(int):void");
    }

    /* JADX WARN: Generic types in debug info not equals: x3 != androidx.collection.LruCache<K, V> */
    public void b(boolean evicted, K key, V oldValue, V newValue) {
    }

    /* JADX WARN: Generic types in debug info not equals: x3 != androidx.collection.LruCache<K, V> */
    public V a(K key) {
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: x3 != androidx.collection.LruCache<K, V> */
    public final int e(K key, V value) {
        int result = f(key, value);
        if (result < 0) {
            throw new IllegalStateException("Negative size: " + key + "=" + value);
        }
        return result;
    }

    /* JADX WARN: Generic types in debug info not equals: x3 != androidx.collection.LruCache<K, V> */
    public int f(K key, V value) {
        return 1;
    }

    /* JADX WARN: Generic types in debug info not equals: x3 != androidx.collection.LruCache<K, V> */
    public final synchronized String toString() {
        int hitPercent;
        int i = this.g;
        int accesses = this.h + i;
        hitPercent = accesses != 0 ? (i * 100) / accesses : 0;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(hitPercent));
    }
}
