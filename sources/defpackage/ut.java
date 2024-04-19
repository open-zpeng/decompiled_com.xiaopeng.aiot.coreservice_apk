package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableConcatMap.java */
/* renamed from: ut  reason: default package */
/* loaded from: classes.dex */
public final class ut<T, U> extends tt<T, U> {
    public final zs<? super T, ? extends es<? extends U>> b;
    public final int d;
    public final bv f;

    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<T> */
    /* JADX WARN: Generic types in debug info not equals: ut != io.reactivex.internal.operators.observable.ObservableConcatMap<T, U> */
    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> */
    public ut(es<T> esVar, zs<? super T, ? extends es<? extends U>> zsVar, int bufferSize, bv delayErrors) {
        super(esVar);
        this.b = zsVar;
        this.f = delayErrors;
        this.d = Math.max(8, bufferSize);
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super U> */
    /* JADX WARN: Generic types in debug info not equals: hv != io.reactivex.observers.SerializedObserver<U> */
    /* JADX WARN: Generic types in debug info not equals: ut != io.reactivex.internal.operators.observable.ObservableConcatMap<T, U> */
    @Override // defpackage.bs
    public void z(fs<? super U> fsVar) {
        if (ju.a(this.a, fsVar, this.b)) {
            return;
        }
        if (this.f == bv.IMMEDIATE) {
            this.a.a(new b(new hv(fsVar), this.b, this.d));
        } else {
            this.a.a(new a(fsVar, this.b, this.d, this.f == bv.END));
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: ut$b */
    /* loaded from: classes.dex */
    public static final class b<T, U> extends AtomicInteger implements fs<T>, ls {
        public final fs<? super U> a;
        public final zs<? super T, ? extends es<? extends U>> b;
        public final a<U> d;
        public final int f;
        public nt<T> g;
        public ls h;
        public volatile boolean i;
        public volatile boolean j;
        public volatile boolean k;
        public int l;

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super U> */
        /* JADX WARN: Generic types in debug info not equals: ut$b != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver<T, U> */
        /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends U>> */
        public b(fs<? super U> fsVar, zs<? super T, ? extends es<? extends U>> zsVar, int bufferSize) {
            this.a = fsVar;
            this.b = zsVar;
            this.f = bufferSize;
            this.d = new a<>(fsVar, this);
        }

        /* JADX WARN: Generic types in debug info not equals: lt != io.reactivex.internal.fuseable.QueueDisposable<T> */
        /* JADX WARN: Generic types in debug info not equals: ut$b != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver<T, U> */
        @Override // defpackage.fs
        public void onSubscribe(ls d) {
            if (et.h(this.h, d)) {
                this.h = d;
                if (d instanceof lt) {
                    lt ltVar = (lt) d;
                    int m = ltVar.b(3);
                    if (m == 1) {
                        this.l = m;
                        this.g = ltVar;
                        this.k = true;
                        this.a.onSubscribe(this);
                        b();
                        return;
                    } else if (m == 2) {
                        this.l = m;
                        this.g = ltVar;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.g = new nu(this.f);
                this.a.onSubscribe(this);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: ut$b != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver<T, U> */
        @Override // defpackage.fs
        public void onNext(T t) {
            if (this.k) {
                return;
            }
            if (this.l == 0) {
                this.g.offer(t);
            }
            b();
        }

        /* JADX WARN: Generic types in debug info not equals: ut$b != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver<T, U> */
        @Override // defpackage.fs
        public void onError(Throwable t) {
            if (this.k) {
                iv.m(t);
                return;
            }
            this.k = true;
            a();
            this.a.onError(t);
        }

        /* JADX WARN: Generic types in debug info not equals: ut$b != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver<T, U> */
        @Override // defpackage.fs
        public void onComplete() {
            if (this.k) {
                return;
            }
            this.k = true;
            b();
        }

        /* JADX WARN: Generic types in debug info not equals: ut$b != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver<T, U> */
        public void c() {
            this.i = false;
            b();
        }

        /* JADX WARN: Generic types in debug info not equals: ut$b != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver<T, U> */
        @Override // defpackage.ls
        public void a() {
            this.j = true;
            this.d.a();
            this.h.a();
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<? extends U> */
        /* JADX WARN: Generic types in debug info not equals: ut$b != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver<T, U> */
        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.j) {
                if (!this.i) {
                    boolean d = this.k;
                    try {
                        T t = this.g.poll();
                        boolean empty = t == null;
                        if (d && empty) {
                            this.j = true;
                            this.a.onComplete();
                            return;
                        } else if (!empty) {
                            try {
                                es esVar = (es) kt.d(this.b.apply(t), "The mapper returned a null ObservableSource");
                                this.i = true;
                                esVar.a(this.d);
                            } catch (Throwable ex) {
                                qs.b(ex);
                                a();
                                this.g.clear();
                                this.a.onError(ex);
                                return;
                            }
                        }
                    } catch (Throwable ex2) {
                        qs.b(ex2);
                        a();
                        this.g.clear();
                        this.a.onError(ex2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.g.clear();
        }

        /* compiled from: ObservableConcatMap.java */
        /* renamed from: ut$b$a */
        /* loaded from: classes.dex */
        public static final class a<U> extends AtomicReference<ls> implements fs<U> {
            public final fs<? super U> a;
            public final b<?, ?> b;

            /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super U> */
            /* JADX WARN: Generic types in debug info not equals: ut$b != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver<?, ?> */
            /* JADX WARN: Generic types in debug info not equals: ut$b$a != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver$InnerObserver<U> */
            public a(fs<? super U> fsVar, b<?, ?> bVar) {
                this.a = fsVar;
                this.b = bVar;
            }

            /* JADX WARN: Generic types in debug info not equals: ut$b$a != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver$InnerObserver<U> */
            @Override // defpackage.fs
            public void onSubscribe(ls d) {
                et.d(this, d);
            }

            /* JADX WARN: Generic types in debug info not equals: ut$b$a != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver$InnerObserver<U> */
            @Override // defpackage.fs
            public void onNext(U t) {
                this.a.onNext(t);
            }

            /* JADX WARN: Generic types in debug info not equals: ut$b$a != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver$InnerObserver<U> */
            @Override // defpackage.fs
            public void onError(Throwable t) {
                this.b.a();
                this.a.onError(t);
            }

            /* JADX WARN: Generic types in debug info not equals: ut$b$a != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver$InnerObserver<U> */
            @Override // defpackage.fs
            public void onComplete() {
                this.b.c();
            }

            /* JADX WARN: Generic types in debug info not equals: ut$b$a != io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver$InnerObserver<U> */
            public void a() {
                et.b(this);
            }
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: ut$a */
    /* loaded from: classes.dex */
    public static final class a<T, R> extends AtomicInteger implements fs<T>, ls {
        public final fs<? super R> a;
        public final zs<? super T, ? extends es<? extends R>> b;
        public final int d;
        public final av f = new av();
        public final C0022a<R> g;
        public final boolean h;
        public nt<T> i;
        public ls j;
        public volatile boolean k;
        public volatile boolean l;
        public volatile boolean m;
        public int n;

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super R> */
        /* JADX WARN: Generic types in debug info not equals: ut$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver<T, R> */
        /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<? extends R>> */
        public a(fs<? super R> fsVar, zs<? super T, ? extends es<? extends R>> zsVar, int bufferSize, boolean tillTheEnd) {
            this.a = fsVar;
            this.b = zsVar;
            this.d = bufferSize;
            this.h = tillTheEnd;
            this.g = new C0022a<>(fsVar, this);
        }

        /* JADX WARN: Generic types in debug info not equals: lt != io.reactivex.internal.fuseable.QueueDisposable<T> */
        /* JADX WARN: Generic types in debug info not equals: ut$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver<T, R> */
        @Override // defpackage.fs
        public void onSubscribe(ls d) {
            if (et.h(this.j, d)) {
                this.j = d;
                if (d instanceof lt) {
                    lt ltVar = (lt) d;
                    int m = ltVar.b(3);
                    if (m == 1) {
                        this.n = m;
                        this.i = ltVar;
                        this.l = true;
                        this.a.onSubscribe(this);
                        b();
                        return;
                    } else if (m == 2) {
                        this.n = m;
                        this.i = ltVar;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.i = new nu(this.d);
                this.a.onSubscribe(this);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: ut$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver<T, R> */
        @Override // defpackage.fs
        public void onNext(T value) {
            if (this.n == 0) {
                this.i.offer(value);
            }
            b();
        }

        /* JADX WARN: Generic types in debug info not equals: ut$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver<T, R> */
        @Override // defpackage.fs
        public void onError(Throwable e) {
            if (this.f.a(e)) {
                this.l = true;
                b();
                return;
            }
            iv.m(e);
        }

        /* JADX WARN: Generic types in debug info not equals: ut$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver<T, R> */
        @Override // defpackage.fs
        public void onComplete() {
            this.l = true;
            b();
        }

        /* JADX WARN: Generic types in debug info not equals: ut$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver<T, R> */
        @Override // defpackage.ls
        public void a() {
            this.m = true;
            this.j.a();
            this.g.a();
        }

        /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<? extends R> */
        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super R> */
        /* JADX WARN: Generic types in debug info not equals: nt != io.reactivex.internal.fuseable.SimpleQueue<T> */
        /* JADX WARN: Generic types in debug info not equals: ut$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver<T, R> */
        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            fs<? super R> fsVar = this.a;
            nt<T> ntVar = this.i;
            av error = this.f;
            while (true) {
                if (!this.k) {
                    if (this.m) {
                        ntVar.clear();
                        return;
                    } else if (!this.h && error.get() != null) {
                        ntVar.clear();
                        this.m = true;
                        fsVar.onError(error.b());
                        return;
                    } else {
                        boolean d = this.l;
                        try {
                            T v = ntVar.poll();
                            boolean empty = v == null;
                            if (d && empty) {
                                this.m = true;
                                Throwable ex = error.b();
                                if (ex != null) {
                                    fsVar.onError(ex);
                                    return;
                                } else {
                                    fsVar.onComplete();
                                    return;
                                }
                            } else if (!empty) {
                                try {
                                    es esVar = (es) kt.d(this.b.apply(v), "The mapper returned a null ObservableSource");
                                    if (esVar instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) esVar).call();
                                            if (obj != 0 && !this.m) {
                                                fsVar.onNext(obj);
                                            }
                                        } catch (Throwable ex2) {
                                            qs.b(ex2);
                                            error.a(ex2);
                                        }
                                    } else {
                                        this.k = true;
                                        esVar.a(this.g);
                                    }
                                } catch (Throwable ex3) {
                                    qs.b(ex3);
                                    this.m = true;
                                    this.j.a();
                                    ntVar.clear();
                                    error.a(ex3);
                                    fsVar.onError(error.b());
                                    return;
                                }
                            }
                        } catch (Throwable ex4) {
                            qs.b(ex4);
                            this.m = true;
                            this.j.a();
                            error.a(ex4);
                            fsVar.onError(error.b());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        /* compiled from: ObservableConcatMap.java */
        /* renamed from: ut$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0022a<R> extends AtomicReference<ls> implements fs<R> {
            public final fs<? super R> a;
            public final a<?, R> b;

            /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super R> */
            /* JADX WARN: Generic types in debug info not equals: ut$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> */
            /* JADX WARN: Generic types in debug info not equals: ut$a$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver<R> */
            public C0022a(fs<? super R> fsVar, a<?, R> aVar) {
                this.a = fsVar;
                this.b = aVar;
            }

            /* JADX WARN: Generic types in debug info not equals: ut$a$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver<R> */
            @Override // defpackage.fs
            public void onSubscribe(ls d) {
                et.d(this, d);
            }

            /* JADX WARN: Generic types in debug info not equals: ut$a$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver<R> */
            @Override // defpackage.fs
            public void onNext(R value) {
                this.a.onNext(value);
            }

            /* JADX WARN: Generic types in debug info not equals: ut$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> */
            /* JADX WARN: Generic types in debug info not equals: ut$a$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver<R> */
            @Override // defpackage.fs
            public void onError(Throwable e) {
                a<?, R> aVar = this.b;
                if (aVar.f.a(e)) {
                    if (!aVar.h) {
                        aVar.j.a();
                    }
                    aVar.k = false;
                    aVar.b();
                    return;
                }
                iv.m(e);
            }

            /* JADX WARN: Generic types in debug info not equals: ut$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> */
            /* JADX WARN: Generic types in debug info not equals: ut$a$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver<R> */
            @Override // defpackage.fs
            public void onComplete() {
                a<?, R> aVar = this.b;
                aVar.k = false;
                aVar.b();
            }

            /* JADX WARN: Generic types in debug info not equals: ut$a$a != io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver<R> */
            public void a() {
                et.b(this);
            }
        }
    }
}
