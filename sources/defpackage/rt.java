package defpackage;
/* compiled from: DisposableLambdaObserver.java */
/* renamed from: rt  reason: default package */
/* loaded from: classes.dex */
public final class rt<T> implements fs<T>, ls {
    public final fs<? super T> a;
    public final ys<? super ls> b;
    public final us d;
    public ls f;

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: rt != io.reactivex.internal.observers.DisposableLambdaObserver<T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> */
    public rt(fs<? super T> fsVar, ys<? super ls> ysVar, us onDispose) {
        this.a = fsVar;
        this.b = ysVar;
        this.d = onDispose;
    }

    /* JADX WARN: Generic types in debug info not equals: rt != io.reactivex.internal.observers.DisposableLambdaObserver<T> */
    @Override // defpackage.fs
    public void onSubscribe(ls d) {
        try {
            this.b.accept(d);
            if (et.h(this.f, d)) {
                this.f = d;
                this.a.onSubscribe(this);
            }
        } catch (Throwable e) {
            qs.b(e);
            d.a();
            this.f = et.DISPOSED;
            ft.d(e, this.a);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: rt != io.reactivex.internal.observers.DisposableLambdaObserver<T> */
    @Override // defpackage.fs
    public void onNext(T t) {
        this.a.onNext(t);
    }

    /* JADX WARN: Generic types in debug info not equals: rt != io.reactivex.internal.observers.DisposableLambdaObserver<T> */
    @Override // defpackage.fs
    public void onError(Throwable t) {
        ls lsVar = this.f;
        et etVar = et.DISPOSED;
        if (lsVar != etVar) {
            this.f = etVar;
            this.a.onError(t);
            return;
        }
        iv.m(t);
    }

    /* JADX WARN: Generic types in debug info not equals: rt != io.reactivex.internal.observers.DisposableLambdaObserver<T> */
    @Override // defpackage.fs
    public void onComplete() {
        ls lsVar = this.f;
        et etVar = et.DISPOSED;
        if (lsVar != etVar) {
            this.f = etVar;
            this.a.onComplete();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: rt != io.reactivex.internal.observers.DisposableLambdaObserver<T> */
    @Override // defpackage.ls
    public void a() {
        ls d = this.f;
        et etVar = et.DISPOSED;
        if (d != etVar) {
            this.f = etVar;
            try {
                this.d.run();
            } catch (Throwable e) {
                qs.b(e);
                iv.m(e);
            }
            d.a();
        }
    }
}
