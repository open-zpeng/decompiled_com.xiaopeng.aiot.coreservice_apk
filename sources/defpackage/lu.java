package defpackage;
/* compiled from: ObservableTake.java */
/* renamed from: lu  reason: default package */
/* loaded from: classes.dex */
public final class lu<T> extends tt<T, T> {
    public final long b;

    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<T> */
    /* JADX WARN: Generic types in debug info not equals: lu != io.reactivex.internal.operators.observable.ObservableTake<T> */
    public lu(es<T> esVar, long limit) {
        super(esVar);
        this.b = limit;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: lu != io.reactivex.internal.operators.observable.ObservableTake<T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        this.a.a(new a(fsVar, this.b));
    }

    /* compiled from: ObservableTake.java */
    /* renamed from: lu$a */
    /* loaded from: classes.dex */
    public static final class a<T> implements fs<T>, ls {
        public final fs<? super T> a;
        public boolean b;
        public ls d;
        public long f;

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: lu$a != io.reactivex.internal.operators.observable.ObservableTake$TakeObserver<T> */
        public a(fs<? super T> fsVar, long limit) {
            this.a = fsVar;
            this.f = limit;
        }

        /* JADX WARN: Generic types in debug info not equals: lu$a != io.reactivex.internal.operators.observable.ObservableTake$TakeObserver<T> */
        @Override // defpackage.fs
        public void onSubscribe(ls d) {
            if (et.h(this.d, d)) {
                this.d = d;
                if (this.f == 0) {
                    this.b = true;
                    d.a();
                    ft.c(this.a);
                    return;
                }
                this.a.onSubscribe(this);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: lu$a != io.reactivex.internal.operators.observable.ObservableTake$TakeObserver<T> */
        @Override // defpackage.fs
        public void onNext(T t) {
            if (this.b) {
                return;
            }
            long j = this.f;
            long j2 = j - 1;
            this.f = j2;
            if (j > 0) {
                boolean stop = j2 == 0;
                this.a.onNext(t);
                if (stop) {
                    onComplete();
                }
            }
        }

        /* JADX WARN: Generic types in debug info not equals: lu$a != io.reactivex.internal.operators.observable.ObservableTake$TakeObserver<T> */
        @Override // defpackage.fs
        public void onError(Throwable t) {
            if (this.b) {
                iv.m(t);
                return;
            }
            this.b = true;
            this.d.a();
            this.a.onError(t);
        }

        /* JADX WARN: Generic types in debug info not equals: lu$a != io.reactivex.internal.operators.observable.ObservableTake$TakeObserver<T> */
        @Override // defpackage.fs
        public void onComplete() {
            if (!this.b) {
                this.b = true;
                this.d.a();
                this.a.onComplete();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: lu$a != io.reactivex.internal.operators.observable.ObservableTake$TakeObserver<T> */
        @Override // defpackage.ls
        public void a() {
            this.d.a();
        }
    }
}
