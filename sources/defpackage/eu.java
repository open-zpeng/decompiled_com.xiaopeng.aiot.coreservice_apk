package defpackage;
/* compiled from: ObservableMap.java */
/* renamed from: eu  reason: default package */
/* loaded from: classes.dex */
public final class eu<T, U> extends tt<T, U> {
    public final zs<? super T, ? extends U> b;

    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<T> */
    /* JADX WARN: Generic types in debug info not equals: eu != io.reactivex.internal.operators.observable.ObservableMap<T, U> */
    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super T, ? extends U> */
    public eu(es<T> esVar, zs<? super T, ? extends U> zsVar) {
        super(esVar);
        this.b = zsVar;
    }

    /* JADX WARN: Generic types in debug info not equals: eu != io.reactivex.internal.operators.observable.ObservableMap<T, U> */
    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super U> */
    @Override // defpackage.bs
    public void z(fs<? super U> fsVar) {
        this.a.a(new a(fsVar, this.b));
    }

    /* compiled from: ObservableMap.java */
    /* renamed from: eu$a */
    /* loaded from: classes.dex */
    public static final class a<T, U> extends ot<T, U> {
        public final zs<? super T, ? extends U> h;

        /* JADX WARN: Generic types in debug info not equals: eu$a != io.reactivex.internal.operators.observable.ObservableMap$MapObserver<T, U> */
        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super U> */
        /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super T, ? extends U> */
        public a(fs<? super U> fsVar, zs<? super T, ? extends U> zsVar) {
            super(fsVar);
            this.h = zsVar;
        }

        /* JADX WARN: Generic types in debug info not equals: eu$a != io.reactivex.internal.operators.observable.ObservableMap$MapObserver<T, U> */
        @Override // defpackage.fs
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            if (this.g != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                this.a.onNext(kt.d(this.h.apply(t), "The mapper function returned a null value."));
            } catch (Throwable ex) {
                e(ex);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: eu$a != io.reactivex.internal.operators.observable.ObservableMap$MapObserver<T, U> */
        @Override // defpackage.mt
        public int b(int mode) {
            return f(mode);
        }

        /* JADX WARN: Generic types in debug info not equals: eu$a != io.reactivex.internal.operators.observable.ObservableMap$MapObserver<T, U> */
        @Override // defpackage.nt
        public U poll() throws Exception {
            T t = this.d.poll();
            if (t != null) {
                return (U) kt.d(this.h.apply(t), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
