package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ReferenceDisposable.java */
/* renamed from: ns  reason: default package */
/* loaded from: classes.dex */
public abstract class ns<T> extends AtomicReference<T> implements ls {
    public abstract void c(T t);

    /* JADX WARN: Generic types in debug info not equals: ns != io.reactivex.disposables.ReferenceDisposable<T> */
    public ns(T value) {
        super(kt.d(value, "value is null"));
    }

    /* JADX WARN: Generic types in debug info not equals: ns != io.reactivex.disposables.ReferenceDisposable<T> */
    @Override // defpackage.ls
    public final void a() {
        T value;
        if (get() != null && (value = getAndSet(null)) != null) {
            c(value);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: ns != io.reactivex.disposables.ReferenceDisposable<T> */
    public final boolean b() {
        return get() == null;
    }
}
