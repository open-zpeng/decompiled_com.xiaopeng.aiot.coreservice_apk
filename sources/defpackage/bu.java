package defpackage;
/* compiled from: ObservableFromArray.java */
/* renamed from: bu  reason: default package */
/* loaded from: classes.dex */
public final class bu<T> extends bs<T> {
    public final T[] a;

    /* JADX WARN: Generic types in debug info not equals: bu != io.reactivex.internal.operators.observable.ObservableFromArray<T> */
    public bu(T[] array) {
        this.a = array;
    }

    /* JADX WARN: Generic types in debug info not equals: bu != io.reactivex.internal.operators.observable.ObservableFromArray<T> */
    /* JADX WARN: Generic types in debug info not equals: bu$a != io.reactivex.internal.operators.observable.ObservableFromArray$FromArrayDisposable<T> */
    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        a aVar = new a(fsVar, this.a);
        fsVar.onSubscribe(aVar);
        if (aVar.f) {
            return;
        }
        aVar.d();
    }

    /* compiled from: ObservableFromArray.java */
    /* renamed from: bu$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends qt<T> {
        public final fs<? super T> a;
        public final T[] b;
        public int d;
        public boolean f;
        public volatile boolean g;

        /* JADX WARN: Generic types in debug info not equals: bu$a != io.reactivex.internal.operators.observable.ObservableFromArray$FromArrayDisposable<T> */
        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        public a(fs<? super T> fsVar, T[] array) {
            this.a = fsVar;
            this.b = array;
        }

        /* JADX WARN: Generic types in debug info not equals: bu$a != io.reactivex.internal.operators.observable.ObservableFromArray$FromArrayDisposable<T> */
        @Override // defpackage.mt
        public int b(int mode) {
            if ((mode & 1) != 0) {
                this.f = true;
                return 1;
            }
            return 0;
        }

        /* JADX WARN: Generic types in debug info not equals: bu$a != io.reactivex.internal.operators.observable.ObservableFromArray$FromArrayDisposable<T> */
        @Override // defpackage.nt
        public T poll() {
            int i = this.d;
            T[] a = this.b;
            if (i != a.length) {
                this.d = i + 1;
                return (T) kt.d(a[i], "The array element is null");
            }
            return null;
        }

        /* JADX WARN: Generic types in debug info not equals: bu$a != io.reactivex.internal.operators.observable.ObservableFromArray$FromArrayDisposable<T> */
        @Override // defpackage.nt
        public boolean isEmpty() {
            return this.d == this.b.length;
        }

        /* JADX WARN: Generic types in debug info not equals: bu$a != io.reactivex.internal.operators.observable.ObservableFromArray$FromArrayDisposable<T> */
        @Override // defpackage.nt
        public void clear() {
            this.d = this.b.length;
        }

        /* JADX WARN: Generic types in debug info not equals: bu$a != io.reactivex.internal.operators.observable.ObservableFromArray$FromArrayDisposable<T> */
        @Override // defpackage.ls
        public void a() {
            this.g = true;
        }

        /* JADX WARN: Generic types in debug info not equals: bu$a != io.reactivex.internal.operators.observable.ObservableFromArray$FromArrayDisposable<T> */
        public boolean c() {
            return this.g;
        }

        /* JADX WARN: Generic types in debug info not equals: bu$a != io.reactivex.internal.operators.observable.ObservableFromArray$FromArrayDisposable<T> */
        public void d() {
            T[] a = this.b;
            int n = a.length;
            for (int i = 0; i < n && !c(); i++) {
                T value = a[i];
                if (value == null) {
                    fs<? super T> fsVar = this.a;
                    fsVar.onError(new NullPointerException("The " + i + "th element is null"));
                    return;
                }
                this.a.onNext(value);
            }
            if (!c()) {
                this.a.onComplete();
            }
        }
    }
}
