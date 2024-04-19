package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableRefCount.java */
/* renamed from: hu  reason: default package */
/* loaded from: classes.dex */
public final class hu<T> extends bs<T> {
    public final gv<T> a;
    public final int b;
    public final long d;
    public final TimeUnit f;
    public final gs g;
    public a h;

    /* JADX WARN: Generic types in debug info not equals: gv != io.reactivex.observables.ConnectableObservable<T> */
    /* JADX WARN: Generic types in debug info not equals: hu != io.reactivex.internal.operators.observable.ObservableRefCount<T> */
    public hu(gv<T> gvVar) {
        this(gvVar, 1, 0L, TimeUnit.NANOSECONDS, jv.c());
    }

    /* JADX WARN: Generic types in debug info not equals: gv != io.reactivex.observables.ConnectableObservable<T> */
    /* JADX WARN: Generic types in debug info not equals: hu != io.reactivex.internal.operators.observable.ObservableRefCount<T> */
    public hu(gv<T> gvVar, int n, long timeout, TimeUnit unit, gs scheduler) {
        this.a = gvVar;
        this.b = n;
        this.d = timeout;
        this.f = unit;
        this.g = scheduler;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: hu != io.reactivex.internal.operators.observable.ObservableRefCount<T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        a conn;
        ls lsVar;
        boolean connect = false;
        synchronized (this) {
            conn = this.h;
            if (conn == null) {
                conn = new a(this);
                this.h = conn;
            }
            long c = conn.d;
            if (c == 0 && (lsVar = conn.b) != null) {
                lsVar.a();
            }
            conn.d = c + 1;
            if (!conn.f && 1 + c == this.b) {
                connect = true;
                conn.f = true;
            }
        }
        this.a.a(new b(fsVar, this, conn));
        if (connect) {
            this.a.F(conn);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: hu != io.reactivex.internal.operators.observable.ObservableRefCount<T> */
    public void F(a rc) {
        synchronized (this) {
            a aVar = this.h;
            if (aVar != null && aVar == rc) {
                long c = rc.d - 1;
                rc.d = c;
                if (c == 0 && rc.f) {
                    if (this.d == 0) {
                        H(rc);
                        return;
                    }
                    it sd = new it();
                    rc.b = sd;
                    sd.c(this.g.c(rc, this.d, this.f));
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: hu != io.reactivex.internal.operators.observable.ObservableRefCount<T> */
    public void G(a rc) {
        synchronized (this) {
            a aVar = this.h;
            if (aVar != null && aVar == rc) {
                this.h = null;
                ls lsVar = rc.b;
                if (lsVar != null) {
                    lsVar.a();
                }
            }
            long j = rc.d - 1;
            rc.d = j;
            if (j == 0) {
                gv<T> gvVar = this.a;
                if (gvVar instanceof ls) {
                    ((ls) gvVar).a();
                } else if (gvVar instanceof ht) {
                    ((ht) gvVar).a(rc.get());
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: hu != io.reactivex.internal.operators.observable.ObservableRefCount<T> */
    public void H(a rc) {
        synchronized (this) {
            if (rc.d == 0 && rc == this.h) {
                this.h = null;
                ls connectionObject = rc.get();
                et.b(rc);
                gv<T> gvVar = this.a;
                if (gvVar instanceof ls) {
                    ((ls) gvVar).a();
                } else if (gvVar instanceof ht) {
                    if (connectionObject == null) {
                        rc.g = true;
                    } else {
                        ((ht) gvVar).a(connectionObject);
                    }
                }
            }
        }
    }

    /* compiled from: ObservableRefCount.java */
    /* renamed from: hu$a */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<ls> implements Runnable, ys<ls> {
        public final hu<?> a;
        public ls b;
        public long d;
        public boolean f;
        public boolean g;

        /* JADX WARN: Generic types in debug info not equals: hu != io.reactivex.internal.operators.observable.ObservableRefCount<?> */
        public a(hu<?> huVar) {
            this.a = huVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.H(this);
        }

        @Override // defpackage.ys
        /* renamed from: a */
        public void accept(ls t) throws Exception {
            et.d(this, t);
            synchronized (this.a) {
                if (this.g) {
                    ((ht) this.a.a).a(t);
                }
            }
        }
    }

    /* compiled from: ObservableRefCount.java */
    /* renamed from: hu$b */
    /* loaded from: classes.dex */
    public static final class b<T> extends AtomicBoolean implements fs<T>, ls {
        public final fs<? super T> a;
        public final hu<T> b;
        public final a d;
        public ls f;

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: hu != io.reactivex.internal.operators.observable.ObservableRefCount<T> */
        /* JADX WARN: Generic types in debug info not equals: hu$b != io.reactivex.internal.operators.observable.ObservableRefCount$RefCountObserver<T> */
        public b(fs<? super T> fsVar, hu<T> huVar, a connection) {
            this.a = fsVar;
            this.b = huVar;
            this.d = connection;
        }

        /* JADX WARN: Generic types in debug info not equals: hu$b != io.reactivex.internal.operators.observable.ObservableRefCount$RefCountObserver<T> */
        @Override // defpackage.fs
        public void onNext(T t) {
            this.a.onNext(t);
        }

        /* JADX WARN: Generic types in debug info not equals: hu$b != io.reactivex.internal.operators.observable.ObservableRefCount$RefCountObserver<T> */
        @Override // defpackage.fs
        public void onError(Throwable t) {
            if (compareAndSet(false, true)) {
                this.b.G(this.d);
                this.a.onError(t);
                return;
            }
            iv.m(t);
        }

        /* JADX WARN: Generic types in debug info not equals: hu$b != io.reactivex.internal.operators.observable.ObservableRefCount$RefCountObserver<T> */
        @Override // defpackage.fs
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.b.G(this.d);
                this.a.onComplete();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: hu$b != io.reactivex.internal.operators.observable.ObservableRefCount$RefCountObserver<T> */
        @Override // defpackage.ls
        public void a() {
            this.f.a();
            if (compareAndSet(false, true)) {
                this.b.F(this.d);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: hu$b != io.reactivex.internal.operators.observable.ObservableRefCount$RefCountObserver<T> */
        @Override // defpackage.fs
        public void onSubscribe(ls d) {
            if (et.h(this.f, d)) {
                this.f = d;
                this.a.onSubscribe(this);
            }
        }
    }
}
