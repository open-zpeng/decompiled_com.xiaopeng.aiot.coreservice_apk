package defpackage;
/* compiled from: Pools.java */
/* renamed from: i9  reason: default package */
/* loaded from: classes.dex */
public class i9<T> implements h9<T> {
    public final Object[] a;
    public int b;

    /* JADX WARN: Generic types in debug info not equals: i9 != androidx.core.util.Pools$SimplePool<T> */
    public i9(int maxPoolSize) {
        if (maxPoolSize <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[maxPoolSize];
    }

    /* JADX WARN: Generic types in debug info not equals: i9 != androidx.core.util.Pools$SimplePool<T> */
    @Override // defpackage.h9
    public T b() {
        int i = this.b;
        if (i > 0) {
            int lastPooledIndex = i - 1;
            Object[] objArr = this.a;
            T instance = (T) objArr[lastPooledIndex];
            objArr[lastPooledIndex] = null;
            this.b = i - 1;
            return instance;
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: i9 != androidx.core.util.Pools$SimplePool<T> */
    @Override // defpackage.h9
    public boolean a(T instance) {
        if (c(instance)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i = this.b;
        Object[] objArr = this.a;
        if (i < objArr.length) {
            objArr[i] = instance;
            this.b = i + 1;
            return true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: i9 != androidx.core.util.Pools$SimplePool<T> */
    public final boolean c(T instance) {
        for (int i = 0; i < this.b; i++) {
            if (this.a[i] == instance) {
                return true;
            }
        }
        return false;
    }
}
