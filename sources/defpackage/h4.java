package defpackage;
/* compiled from: Pools.java */
/* renamed from: h4  reason: default package */
/* loaded from: classes.dex */
public class h4<T> implements g4<T> {
    public final Object[] a;
    public int b;

    /* JADX WARN: Generic types in debug info not equals: h4 != androidx.constraintlayout.core.Pools$SimplePool<T> */
    public h4(int maxPoolSize) {
        if (maxPoolSize <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[maxPoolSize];
    }

    /* JADX WARN: Generic types in debug info not equals: h4 != androidx.constraintlayout.core.Pools$SimplePool<T> */
    @Override // defpackage.g4
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

    /* JADX WARN: Generic types in debug info not equals: h4 != androidx.constraintlayout.core.Pools$SimplePool<T> */
    @Override // defpackage.g4
    public boolean a(T instance) {
        int i = this.b;
        Object[] objArr = this.a;
        if (i < objArr.length) {
            objArr[i] = instance;
            this.b = i + 1;
            return true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: h4 != androidx.constraintlayout.core.Pools$SimplePool<T> */
    @Override // defpackage.g4
    public void c(T[] variables, int count) {
        if (count > variables.length) {
            count = variables.length;
        }
        for (int i = 0; i < count; i++) {
            T instance = variables[i];
            int i2 = this.b;
            Object[] objArr = this.a;
            if (i2 < objArr.length) {
                objArr[i2] = instance;
                this.b = i2 + 1;
            }
        }
    }
}
