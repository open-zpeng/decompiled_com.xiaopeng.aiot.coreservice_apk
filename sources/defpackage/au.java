package defpackage;
/* compiled from: ObservableFilter.java */
/* renamed from: au  reason: default package */
/* loaded from: classes.dex */
public final class au<T> extends tt<T, T> {
    public final bt<? super T> b;

    /* JADX WARN: Generic types in debug info not equals: au != io.reactivex.internal.operators.observable.ObservableFilter<T> */
    /* JADX WARN: Generic types in debug info not equals: bt != io.reactivex.functions.Predicate<? super T> */
    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<T> */
    public au(es<T> esVar, bt<? super T> btVar) {
        super(esVar);
        this.b = btVar;
    }

    /* JADX WARN: Generic types in debug info not equals: au != io.reactivex.internal.operators.observable.ObservableFilter<T> */
    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        this.a.a(new a(fsVar, this.b));
    }

    /* compiled from: ObservableFilter.java */
    /* renamed from: au$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends ot<T, T> {
        public final bt<? super T> h;

        /* JADX WARN: Generic types in debug info not equals: au$a != io.reactivex.internal.operators.observable.ObservableFilter$FilterObserver<T> */
        /* JADX WARN: Generic types in debug info not equals: bt != io.reactivex.functions.Predicate<? super T> */
        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        public a(fs<? super T> fsVar, bt<? super T> btVar) {
            super(fsVar);
            this.h = btVar;
        }

        /* JADX WARN: Generic types in debug info not equals: au$a != io.reactivex.internal.operators.observable.ObservableFilter$FilterObserver<T> */
        @Override // defpackage.fs
        public void onNext(T t) {
            if (this.g == 0) {
                try {
                    boolean b = this.h.test(t);
                    if (b) {
                        this.a.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    e(e);
                    return;
                }
            }
            this.a.onNext(null);
        }

        /* JADX WARN: Generic types in debug info not equals: au$a != io.reactivex.internal.operators.observable.ObservableFilter$FilterObserver<T> */
        @Override // defpackage.mt
        public int b(int mode) {
            return f(mode);
        }

        /* JADX WARN: Generic types in debug info not equals: au$a != io.reactivex.internal.operators.observable.ObservableFilter$FilterObserver<T> */
        @Override // defpackage.nt
        public T poll() throws Exception {
            T v;
            do {
                v = this.d.poll();
                if (v == null) {
                    break;
                }
            } while (!this.h.test(v));
            return v;
        }
    }
}
