package defpackage;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableRetryPredicate.java */
/* renamed from: iu  reason: default package */
/* loaded from: classes.dex */
public final class iu<T> extends tt<T, T> {
    public final bt<? super Throwable> b;
    public final long d;

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: bt != io.reactivex.functions.Predicate<? super java.lang.Throwable> */
    /* JADX WARN: Generic types in debug info not equals: iu != io.reactivex.internal.operators.observable.ObservableRetryPredicate<T> */
    public iu(bs<T> bsVar, long count, bt<? super Throwable> btVar) {
        super(bsVar);
        this.b = btVar;
        this.d = count;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: iu != io.reactivex.internal.operators.observable.ObservableRetryPredicate<T> */
    /* JADX WARN: Generic types in debug info not equals: iu$a != io.reactivex.internal.operators.observable.ObservableRetryPredicate$RepeatObserver<T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        it sa = new it();
        fsVar.onSubscribe(sa);
        new a(fsVar, this.d, this.b, sa, this.a).a();
    }

    /* compiled from: ObservableRetryPredicate.java */
    /* renamed from: iu$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements fs<T> {
        public final fs<? super T> a;
        public final it b;
        public final es<? extends T> d;
        public final bt<? super Throwable> f;
        public long g;

        /* JADX WARN: Generic types in debug info not equals: bt != io.reactivex.functions.Predicate<? super java.lang.Throwable> */
        /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<? extends T> */
        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: iu$a != io.reactivex.internal.operators.observable.ObservableRetryPredicate$RepeatObserver<T> */
        public a(fs<? super T> fsVar, long count, bt<? super Throwable> btVar, it sa, es<? extends T> esVar) {
            this.a = fsVar;
            this.b = sa;
            this.d = esVar;
            this.f = btVar;
            this.g = count;
        }

        /* JADX WARN: Generic types in debug info not equals: iu$a != io.reactivex.internal.operators.observable.ObservableRetryPredicate$RepeatObserver<T> */
        @Override // defpackage.fs
        public void onSubscribe(ls d) {
            this.b.c(d);
        }

        /* JADX WARN: Generic types in debug info not equals: iu$a != io.reactivex.internal.operators.observable.ObservableRetryPredicate$RepeatObserver<T> */
        @Override // defpackage.fs
        public void onNext(T t) {
            this.a.onNext(t);
        }

        /* JADX WARN: Generic types in debug info not equals: iu$a != io.reactivex.internal.operators.observable.ObservableRetryPredicate$RepeatObserver<T> */
        @Override // defpackage.fs
        public void onError(Throwable t) {
            long r = this.g;
            if (r != Long.MAX_VALUE) {
                this.g = r - 1;
            }
            if (r == 0) {
                this.a.onError(t);
                return;
            }
            try {
                boolean b = this.f.test(t);
                if (!b) {
                    this.a.onError(t);
                } else {
                    a();
                }
            } catch (Throwable e) {
                qs.b(e);
                this.a.onError(new ps(t, e));
            }
        }

        /* JADX WARN: Generic types in debug info not equals: iu$a != io.reactivex.internal.operators.observable.ObservableRetryPredicate$RepeatObserver<T> */
        @Override // defpackage.fs
        public void onComplete() {
            this.a.onComplete();
        }

        /* JADX WARN: Generic types in debug info not equals: iu$a != io.reactivex.internal.operators.observable.ObservableRetryPredicate$RepeatObserver<T> */
        public void a() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                while (!this.b.b()) {
                    this.d.a(this);
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
        }
    }
}
