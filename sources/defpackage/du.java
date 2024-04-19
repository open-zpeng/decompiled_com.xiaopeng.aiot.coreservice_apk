package defpackage;

import defpackage.ju;
import java.util.concurrent.Callable;
/* compiled from: ObservableJust.java */
/* renamed from: du  reason: default package */
/* loaded from: classes.dex */
public final class du<T> extends bs<T> implements Callable {
    public final T a;

    /* JADX WARN: Generic types in debug info not equals: du != io.reactivex.internal.operators.observable.ObservableJust<T> */
    public du(T value) {
        this.a = value;
    }

    /* JADX WARN: Generic types in debug info not equals: du != io.reactivex.internal.operators.observable.ObservableJust<T> */
    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: ju$a != io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable<T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        ju.a aVar = new ju.a(fsVar, this.a);
        fsVar.onSubscribe(aVar);
        aVar.run();
    }

    /* JADX WARN: Generic types in debug info not equals: du != io.reactivex.internal.operators.observable.ObservableJust<T> */
    @Override // java.util.concurrent.Callable
    public T call() {
        return this.a;
    }
}
