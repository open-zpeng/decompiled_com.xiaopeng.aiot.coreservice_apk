package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: LambdaObserver.java */
/* renamed from: st  reason: default package */
/* loaded from: classes.dex */
public final class st<T> extends AtomicReference<ls> implements fs<T>, ls {
    public final ys<? super T> a;
    public final ys<? super Throwable> b;
    public final us d;
    public final ys<? super ls> f;

    /* JADX WARN: Generic types in debug info not equals: st != io.reactivex.internal.observers.LambdaObserver<T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super java.lang.Throwable> */
    public st(ys<? super T> ysVar, ys<? super Throwable> ysVar2, us onComplete, ys<? super ls> ysVar3) {
        this.a = ysVar;
        this.b = ysVar2;
        this.d = onComplete;
        this.f = ysVar3;
    }

    /* JADX WARN: Generic types in debug info not equals: st != io.reactivex.internal.observers.LambdaObserver<T> */
    @Override // defpackage.fs
    public void onSubscribe(ls d) {
        if (et.g(this, d)) {
            try {
                this.f.accept(this);
            } catch (Throwable ex) {
                qs.b(ex);
                d.a();
                onError(ex);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: st != io.reactivex.internal.observers.LambdaObserver<T> */
    @Override // defpackage.fs
    public void onNext(T t) {
        if (!b()) {
            try {
                this.a.accept(t);
            } catch (Throwable e) {
                qs.b(e);
                get().a();
                onError(e);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: st != io.reactivex.internal.observers.LambdaObserver<T> */
    @Override // defpackage.fs
    public void onError(Throwable t) {
        if (!b()) {
            lazySet(et.DISPOSED);
            try {
                this.b.accept(t);
                return;
            } catch (Throwable e) {
                qs.b(e);
                iv.m(new ps(t, e));
                return;
            }
        }
        iv.m(t);
    }

    /* JADX WARN: Generic types in debug info not equals: st != io.reactivex.internal.observers.LambdaObserver<T> */
    @Override // defpackage.fs
    public void onComplete() {
        if (!b()) {
            lazySet(et.DISPOSED);
            try {
                this.d.run();
            } catch (Throwable e) {
                qs.b(e);
                iv.m(e);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: st != io.reactivex.internal.observers.LambdaObserver<T> */
    @Override // defpackage.ls
    public void a() {
        et.b(this);
    }

    /* JADX WARN: Generic types in debug info not equals: st != io.reactivex.internal.observers.LambdaObserver<T> */
    public boolean b() {
        return get() == et.DISPOSED;
    }
}
