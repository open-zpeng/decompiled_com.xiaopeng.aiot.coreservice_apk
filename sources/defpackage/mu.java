package defpackage;

import defpackage.gs;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableTimeoutTimed.java */
/* renamed from: mu  reason: default package */
/* loaded from: classes.dex */
public final class mu<T> extends tt<T, T> {
    public final long b;
    public final TimeUnit d;
    public final gs f;
    public final es<? extends T> g;

    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: mu$d */
    /* loaded from: classes.dex */
    public interface d {
        void b(long j);
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<? extends T> */
    /* JADX WARN: Generic types in debug info not equals: mu != io.reactivex.internal.operators.observable.ObservableTimeoutTimed<T> */
    public mu(bs<T> bsVar, long timeout, TimeUnit unit, gs scheduler, es<? extends T> esVar) {
        super(bsVar);
        this.b = timeout;
        this.d = unit;
        this.f = scheduler;
        this.g = esVar;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: mu != io.reactivex.internal.operators.observable.ObservableTimeoutTimed<T> */
    /* JADX WARN: Generic types in debug info not equals: mu$b != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver<T> */
    /* JADX WARN: Generic types in debug info not equals: mu$c != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver<T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        if (this.g == null) {
            c cVar = new c(fsVar, this.b, this.d, this.f.a());
            fsVar.onSubscribe(cVar);
            cVar.c(0L);
            this.a.a(cVar);
            return;
        }
        b bVar = new b(fsVar, this.b, this.d, this.f.a(), this.g);
        fsVar.onSubscribe(bVar);
        bVar.c(0L);
        this.a.a(bVar);
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: mu$c */
    /* loaded from: classes.dex */
    public static final class c<T> extends AtomicLong implements fs<T>, ls, d {
        public final fs<? super T> a;
        public final long b;
        public final TimeUnit d;
        public final gs.b f;
        public final it g = new it();
        public final AtomicReference<ls> h = new AtomicReference<>();

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: mu$c != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver<T> */
        public c(fs<? super T> fsVar, long timeout, TimeUnit unit, gs.b worker) {
            this.a = fsVar;
            this.b = timeout;
            this.d = unit;
            this.f = worker;
        }

        /* JADX WARN: Generic types in debug info not equals: mu$c != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver<T> */
        @Override // defpackage.fs
        public void onSubscribe(ls d) {
            et.g(this.h, d);
        }

        /* JADX WARN: Generic types in debug info not equals: mu$c != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver<T> */
        @Override // defpackage.fs
        public void onNext(T t) {
            long idx = get();
            if (idx == Long.MAX_VALUE || !compareAndSet(idx, idx + 1)) {
                return;
            }
            this.g.get().a();
            this.a.onNext(t);
            c(1 + idx);
        }

        /* JADX WARN: Generic types in debug info not equals: mu$c != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver<T> */
        public void c(long nextIndex) {
            this.g.c(this.f.d(new e(nextIndex, this), this.b, this.d));
        }

        /* JADX WARN: Generic types in debug info not equals: mu$c != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver<T> */
        @Override // defpackage.fs
        public void onError(Throwable t) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.g.a();
                this.a.onError(t);
                this.f.a();
                return;
            }
            iv.m(t);
        }

        /* JADX WARN: Generic types in debug info not equals: mu$c != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver<T> */
        @Override // defpackage.fs
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.g.a();
                this.a.onComplete();
                this.f.a();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: mu$c != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver<T> */
        @Override // defpackage.mu.d
        public void b(long idx) {
            if (compareAndSet(idx, Long.MAX_VALUE)) {
                et.b(this.h);
                this.a.onError(new TimeoutException(cv.c(this.b, this.d)));
                this.f.a();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: mu$c != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver<T> */
        @Override // defpackage.ls
        public void a() {
            et.b(this.h);
            this.f.a();
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: mu$e */
    /* loaded from: classes.dex */
    public static final class e implements Runnable {
        public final d a;
        public final long b;

        public e(long idx, d parent) {
            this.b = idx;
            this.a = parent;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: mu$b */
    /* loaded from: classes.dex */
    public static final class b<T> extends AtomicReference<ls> implements fs<T>, ls, d {
        public final fs<? super T> a;
        public final long b;
        public final TimeUnit d;
        public final gs.b f;
        public final it g = new it();
        public final AtomicLong h = new AtomicLong();
        public final AtomicReference<ls> i = new AtomicReference<>();
        public es<? extends T> j;

        /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<? extends T> */
        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: mu$b != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver<T> */
        public b(fs<? super T> fsVar, long timeout, TimeUnit unit, gs.b worker, es<? extends T> esVar) {
            this.a = fsVar;
            this.b = timeout;
            this.d = unit;
            this.f = worker;
            this.j = esVar;
        }

        /* JADX WARN: Generic types in debug info not equals: mu$b != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver<T> */
        @Override // defpackage.fs
        public void onSubscribe(ls d) {
            et.g(this.i, d);
        }

        /* JADX WARN: Generic types in debug info not equals: mu$b != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver<T> */
        @Override // defpackage.fs
        public void onNext(T t) {
            long idx = this.h.get();
            if (idx == Long.MAX_VALUE || !this.h.compareAndSet(idx, idx + 1)) {
                return;
            }
            this.g.get().a();
            this.a.onNext(t);
            c(1 + idx);
        }

        /* JADX WARN: Generic types in debug info not equals: mu$b != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver<T> */
        public void c(long nextIndex) {
            this.g.c(this.f.d(new e(nextIndex, this), this.b, this.d));
        }

        /* JADX WARN: Generic types in debug info not equals: mu$b != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver<T> */
        @Override // defpackage.fs
        public void onError(Throwable t) {
            if (this.h.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.g.a();
                this.a.onError(t);
                this.f.a();
                return;
            }
            iv.m(t);
        }

        /* JADX WARN: Generic types in debug info not equals: mu$b != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver<T> */
        @Override // defpackage.fs
        public void onComplete() {
            if (this.h.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.g.a();
                this.a.onComplete();
                this.f.a();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<? extends T> */
        /* JADX WARN: Generic types in debug info not equals: mu$b != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver<T> */
        @Override // defpackage.mu.d
        public void b(long idx) {
            if (this.h.compareAndSet(idx, Long.MAX_VALUE)) {
                et.b(this.i);
                es<? extends T> esVar = this.j;
                this.j = null;
                esVar.a(new a(this.a, this));
                this.f.a();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: mu$b != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver<T> */
        @Override // defpackage.ls
        public void a() {
            et.b(this.i);
            et.b(this);
            this.f.a();
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: mu$a */
    /* loaded from: classes.dex */
    public static final class a<T> implements fs<T> {
        public final fs<? super T> a;
        public final AtomicReference<ls> b;

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: mu$a != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$FallbackObserver<T> */
        public a(fs<? super T> fsVar, AtomicReference<ls> atomicReference) {
            this.a = fsVar;
            this.b = atomicReference;
        }

        /* JADX WARN: Generic types in debug info not equals: mu$a != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$FallbackObserver<T> */
        @Override // defpackage.fs
        public void onSubscribe(ls d) {
            et.d(this.b, d);
        }

        /* JADX WARN: Generic types in debug info not equals: mu$a != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$FallbackObserver<T> */
        @Override // defpackage.fs
        public void onNext(T t) {
            this.a.onNext(t);
        }

        /* JADX WARN: Generic types in debug info not equals: mu$a != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$FallbackObserver<T> */
        @Override // defpackage.fs
        public void onError(Throwable t) {
            this.a.onError(t);
        }

        /* JADX WARN: Generic types in debug info not equals: mu$a != io.reactivex.internal.operators.observable.ObservableTimeoutTimed$FallbackObserver<T> */
        @Override // defpackage.fs
        public void onComplete() {
            this.a.onComplete();
        }
    }
}
