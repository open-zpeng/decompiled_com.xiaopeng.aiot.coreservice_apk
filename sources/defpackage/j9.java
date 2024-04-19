package defpackage;
/* compiled from: Pools.java */
/* renamed from: j9  reason: default package */
/* loaded from: classes.dex */
public class j9<T> extends i9<T> {
    public final Object c;

    /* JADX WARN: Generic types in debug info not equals: j9 != androidx.core.util.Pools$SynchronizedPool<T> */
    public j9(int maxPoolSize) {
        super(maxPoolSize);
        this.c = new Object();
    }

    /* JADX WARN: Generic types in debug info not equals: j9 != androidx.core.util.Pools$SynchronizedPool<T> */
    @Override // defpackage.i9, defpackage.h9
    public T b() {
        T t;
        synchronized (this.c) {
            t = (T) super.b();
        }
        return t;
    }

    /* JADX WARN: Generic types in debug info not equals: j9 != androidx.core.util.Pools$SynchronizedPool<T> */
    @Override // defpackage.i9, defpackage.h9
    public boolean a(T element) {
        boolean a;
        synchronized (this.c) {
            a = super.a(element);
        }
        return a;
    }
}
