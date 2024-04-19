package defpackage;

import defpackage.gs;
/* compiled from: ObservableObserveOn.java */
/* renamed from: fu  reason: default package */
/* loaded from: classes.dex */
public final class fu<T> extends tt<T, T> {
    public final gs b;
    public final boolean d;
    public final int f;

    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<T> */
    /* JADX WARN: Generic types in debug info not equals: fu != io.reactivex.internal.operators.observable.ObservableObserveOn<T> */
    public fu(es<T> esVar, gs scheduler, boolean delayError, int bufferSize) {
        super(esVar);
        this.b = scheduler;
        this.d = delayError;
        this.f = bufferSize;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: fu != io.reactivex.internal.operators.observable.ObservableObserveOn<T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        gs gsVar = this.b;
        if (gsVar instanceof yu) {
            this.a.a(fsVar);
            return;
        }
        gs.b w = gsVar.a();
        this.a.a(new a(fsVar, w, this.d, this.f));
    }

    /* compiled from: ObservableObserveOn.java */
    /* renamed from: fu$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends pt<T> implements fs<T>, Runnable {
        public final fs<? super T> a;
        public final gs.b b;
        public final boolean d;
        public final int f;
        public nt<T> g;
        public ls h;
        public Throwable i;
        public volatile boolean j;
        public volatile boolean k;
        public int l;
        public boolean m;

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        public a(fs<? super T> fsVar, gs.b worker, boolean delayError, int bufferSize) {
            this.a = fsVar;
            this.b = worker;
            this.d = delayError;
            this.f = bufferSize;
        }

        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        /* JADX WARN: Generic types in debug info not equals: lt != io.reactivex.internal.fuseable.QueueDisposable<T> */
        @Override // defpackage.fs
        public void onSubscribe(ls d) {
            if (et.h(this.h, d)) {
                this.h = d;
                if (d instanceof lt) {
                    lt ltVar = (lt) d;
                    int m = ltVar.b(7);
                    if (m == 1) {
                        this.l = m;
                        this.g = ltVar;
                        this.j = true;
                        this.a.onSubscribe(this);
                        f();
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

        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        @Override // defpackage.fs
        public void onNext(T t) {
            if (this.j) {
                return;
            }
            if (this.l != 2) {
                this.g.offer(t);
            }
            f();
        }

        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        @Override // defpackage.fs
        public void onError(Throwable t) {
            if (this.j) {
                iv.m(t);
                return;
            }
            this.i = t;
            this.j = true;
            f();
        }

        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        @Override // defpackage.fs
        public void onComplete() {
            if (this.j) {
                return;
            }
            this.j = true;
            f();
        }

        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        @Override // defpackage.ls
        public void a() {
            if (!this.k) {
                this.k = true;
                this.h.a();
                this.b.a();
                if (getAndIncrement() == 0) {
                    this.g.clear();
                }
            }
        }

        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        public void f() {
            if (getAndIncrement() == 0) {
                this.b.c(this);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        /* JADX WARN: Generic types in debug info not equals: nt != io.reactivex.internal.fuseable.SimpleQueue<T> */
        public void e() {
            int missed = 1;
            nt<T> ntVar = this.g;
            fs<? super T> fsVar = this.a;
            while (!c(this.j, ntVar.isEmpty(), fsVar)) {
                while (true) {
                    boolean d = this.j;
                    try {
                        Object obj = (T) ntVar.poll();
                        boolean empty = obj == null;
                        if (c(d, empty, fsVar)) {
                            return;
                        }
                        if (!empty) {
                            fsVar.onNext(obj);
                        } else {
                            missed = addAndGet(-missed);
                            if (missed == 0) {
                                return;
                            }
                        }
                    } catch (Throwable ex) {
                        qs.b(ex);
                        this.k = true;
                        this.h.a();
                        ntVar.clear();
                        fsVar.onError(ex);
                        this.b.a();
                        return;
                    }
                }
            }
        }

        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        public void d() {
            int missed = 1;
            while (!this.k) {
                boolean d = this.j;
                Throwable ex = this.i;
                if (!this.d && d && ex != null) {
                    this.k = true;
                    this.a.onError(this.i);
                    this.b.a();
                    return;
                }
                this.a.onNext(null);
                if (d) {
                    this.k = true;
                    Throwable ex2 = this.i;
                    if (ex2 != null) {
                        this.a.onError(ex2);
                    } else {
                        this.a.onComplete();
                    }
                    this.b.a();
                    return;
                }
                missed = addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            }
        }

        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        @Override // java.lang.Runnable
        public void run() {
            if (this.m) {
                d();
            } else {
                e();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        public boolean c(boolean d, boolean empty, fs<? super T> fsVar) {
            if (this.k) {
                this.g.clear();
                return true;
            } else if (d) {
                Throwable e = this.i;
                if (this.d) {
                    if (empty) {
                        this.k = true;
                        if (e != null) {
                            fsVar.onError(e);
                        } else {
                            fsVar.onComplete();
                        }
                        this.b.a();
                        return true;
                    }
                    return false;
                } else if (e != null) {
                    this.k = true;
                    this.g.clear();
                    fsVar.onError(e);
                    this.b.a();
                    return true;
                } else if (empty) {
                    this.k = true;
                    fsVar.onComplete();
                    this.b.a();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        @Override // defpackage.mt
        public int b(int mode) {
            if ((mode & 2) != 0) {
                this.m = true;
                return 2;
            }
            return 0;
        }

        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        @Override // defpackage.nt
        public T poll() throws Exception {
            return this.g.poll();
        }

        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        @Override // defpackage.nt
        public void clear() {
            this.g.clear();
        }

        /* JADX WARN: Generic types in debug info not equals: fu$a != io.reactivex.internal.operators.observable.ObservableObserveOn$ObserveOnObserver<T> */
        @Override // defpackage.nt
        public boolean isEmpty() {
            return this.g.isEmpty();
        }
    }
}
