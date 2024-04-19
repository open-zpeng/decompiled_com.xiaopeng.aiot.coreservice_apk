package defpackage;
/* compiled from: ObservableDoOnEach.java */
/* renamed from: xt  reason: default package */
/* loaded from: classes.dex */
public final class xt<T> extends tt<T, T> {
    public final ys<? super T> b;
    public final ys<? super Throwable> d;
    public final us f;
    public final us g;

    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<T> */
    /* JADX WARN: Generic types in debug info not equals: xt != io.reactivex.internal.operators.observable.ObservableDoOnEach<T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super java.lang.Throwable> */
    public xt(es<T> esVar, ys<? super T> ysVar, ys<? super Throwable> ysVar2, us onComplete, us onAfterTerminate) {
        super(esVar);
        this.b = ysVar;
        this.d = ysVar2;
        this.f = onComplete;
        this.g = onAfterTerminate;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: xt != io.reactivex.internal.operators.observable.ObservableDoOnEach<T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        this.a.a(new a(fsVar, this.b, this.d, this.f, this.g));
    }

    /* compiled from: ObservableDoOnEach.java */
    /* renamed from: xt$a */
    /* loaded from: classes.dex */
    public static final class a<T> implements fs<T>, ls {
        public final fs<? super T> a;
        public final ys<? super T> b;
        public final ys<? super Throwable> d;
        public final us f;
        public final us g;
        public ls h;
        public boolean i;

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: xt$a != io.reactivex.internal.operators.observable.ObservableDoOnEach$DoOnEachObserver<T> */
        /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super java.lang.Throwable> */
        public a(fs<? super T> fsVar, ys<? super T> ysVar, ys<? super Throwable> ysVar2, us onComplete, us onAfterTerminate) {
            this.a = fsVar;
            this.b = ysVar;
            this.d = ysVar2;
            this.f = onComplete;
            this.g = onAfterTerminate;
        }

        /* JADX WARN: Generic types in debug info not equals: xt$a != io.reactivex.internal.operators.observable.ObservableDoOnEach$DoOnEachObserver<T> */
        @Override // defpackage.fs
        public void onSubscribe(ls d) {
            if (et.h(this.h, d)) {
                this.h = d;
                this.a.onSubscribe(this);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: xt$a != io.reactivex.internal.operators.observable.ObservableDoOnEach$DoOnEachObserver<T> */
        @Override // defpackage.ls
        public void a() {
            this.h.a();
        }

        /* JADX WARN: Generic types in debug info not equals: xt$a != io.reactivex.internal.operators.observable.ObservableDoOnEach$DoOnEachObserver<T> */
        @Override // defpackage.fs
        public void onNext(T t) {
            if (this.i) {
                return;
            }
            try {
                this.b.accept(t);
                this.a.onNext(t);
            } catch (Throwable e) {
                qs.b(e);
                this.h.a();
                onError(e);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: xt$a != io.reactivex.internal.operators.observable.ObservableDoOnEach$DoOnEachObserver<T> */
        @Override // defpackage.fs
        public void onError(Throwable t) {
            if (this.i) {
                iv.m(t);
                return;
            }
            this.i = true;
            try {
                this.d.accept(t);
            } catch (Throwable e) {
                qs.b(e);
                t = new ps(t, e);
            }
            this.a.onError(t);
            try {
                this.g.run();
            } catch (Throwable e2) {
                qs.b(e2);
                iv.m(e2);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: xt$a != io.reactivex.internal.operators.observable.ObservableDoOnEach$DoOnEachObserver<T> */
        @Override // defpackage.fs
        public void onComplete() {
            if (this.i) {
                return;
            }
            try {
                this.f.run();
                this.i = true;
                this.a.onComplete();
                try {
                    this.g.run();
                } catch (Throwable e) {
                    qs.b(e);
                    iv.m(e);
                }
            } catch (Throwable e2) {
                qs.b(e2);
                onError(e2);
            }
        }
    }
}
