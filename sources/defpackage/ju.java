package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableScalarXMap.java */
/* renamed from: ju  reason: default package */
/* loaded from: classes.dex */
public final class ju {
    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<? extends R> */
    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<T> */
    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super R> */
    /* JADX WARN: Generic types in debug info not equals: ju$a != io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable<R> */
    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> */
    public static <T, R> boolean a(es<T> esVar, fs<? super R> fsVar, zs<? super T, ? extends es<? extends R>> zsVar) {
        if (esVar instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) esVar).call();
                if (obj == 0) {
                    ft.c(fsVar);
                    return true;
                }
                try {
                    es esVar2 = (es) kt.d(zsVar.apply(obj), "The mapper returned a null ObservableSource");
                    if (esVar2 instanceof Callable) {
                        try {
                            Object call = ((Callable) esVar2).call();
                            if (call == null) {
                                ft.c(fsVar);
                                return true;
                            }
                            a aVar = new a(fsVar, call);
                            fsVar.onSubscribe(aVar);
                            aVar.run();
                        } catch (Throwable ex) {
                            qs.b(ex);
                            ft.d(ex, fsVar);
                            return true;
                        }
                    } else {
                        esVar2.a(fsVar);
                    }
                    return true;
                } catch (Throwable ex2) {
                    qs.b(ex2);
                    ft.d(ex2, fsVar);
                    return true;
                }
            } catch (Throwable ex3) {
                qs.b(ex3);
                ft.d(ex3, fsVar);
                return true;
            }
        }
        return false;
    }

    /* compiled from: ObservableScalarXMap.java */
    /* renamed from: ju$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements lt<T>, Runnable {
        public final fs<? super T> a;
        public final T b;

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: ju$a != io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable<T> */
        public a(fs<? super T> fsVar, T value) {
            this.a = fsVar;
            this.b = value;
        }

        /* JADX WARN: Generic types in debug info not equals: ju$a != io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable<T> */
        @Override // defpackage.nt
        public boolean offer(T value) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        /* JADX WARN: Generic types in debug info not equals: ju$a != io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable<T> */
        @Override // defpackage.nt
        public T poll() throws Exception {
            if (get() == 1) {
                lazySet(3);
                return this.b;
            }
            return null;
        }

        /* JADX WARN: Generic types in debug info not equals: ju$a != io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable<T> */
        @Override // defpackage.nt
        public boolean isEmpty() {
            return get() != 1;
        }

        /* JADX WARN: Generic types in debug info not equals: ju$a != io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable<T> */
        @Override // defpackage.nt
        public void clear() {
            lazySet(3);
        }

        /* JADX WARN: Generic types in debug info not equals: ju$a != io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable<T> */
        @Override // defpackage.ls
        public void a() {
            set(3);
        }

        /* JADX WARN: Generic types in debug info not equals: ju$a != io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable<T> */
        @Override // defpackage.mt
        public int b(int mode) {
            if ((mode & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        /* JADX WARN: Generic types in debug info not equals: ju$a != io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable<T> */
        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.a.onNext((T) this.b);
                if (get() == 2) {
                    lazySet(3);
                    this.a.onComplete();
                }
            }
        }
    }
}
