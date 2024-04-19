package defpackage;
/* compiled from: SerializedObserver.java */
/* renamed from: hv  reason: default package */
/* loaded from: classes.dex */
public final class hv<T> implements fs<T>, ls {
    public final fs<? super T> a;
    public final boolean b;
    public ls d;
    public boolean f;
    public zu<Object> g;
    public volatile boolean h;

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: hv != io.reactivex.observers.SerializedObserver<T> */
    public hv(fs<? super T> fsVar) {
        this(fsVar, false);
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: hv != io.reactivex.observers.SerializedObserver<T> */
    public hv(fs<? super T> fsVar, boolean delayError) {
        this.a = fsVar;
        this.b = delayError;
    }

    /* JADX WARN: Generic types in debug info not equals: hv != io.reactivex.observers.SerializedObserver<T> */
    @Override // defpackage.fs
    public void onSubscribe(ls d) {
        if (et.h(this.d, d)) {
            this.d = d;
            this.a.onSubscribe(this);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: hv != io.reactivex.observers.SerializedObserver<T> */
    @Override // defpackage.ls
    public void a() {
        this.d.a();
    }

    /* JADX WARN: Generic types in debug info not equals: hv != io.reactivex.observers.SerializedObserver<T> */
    /* JADX WARN: Generic types in debug info not equals: zu != io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> */
    @Override // defpackage.fs
    public void onNext(T t) {
        if (this.h) {
            return;
        }
        if (t == null) {
            this.d.a();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.h) {
                return;
            }
            if (this.f) {
                zu<Object> zuVar = this.g;
                if (zuVar == null) {
                    zuVar = new zu<>(4);
                    this.g = zuVar;
                }
                zuVar.b(dv.d(t));
                return;
            }
            this.f = true;
            this.a.onNext(t);
            b();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: hv != io.reactivex.observers.SerializedObserver<T> */
    /* JADX WARN: Generic types in debug info not equals: zu != io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> */
    @Override // defpackage.fs
    public void onError(Throwable t) {
        boolean reportError;
        if (this.h) {
            iv.m(t);
            return;
        }
        synchronized (this) {
            if (this.h) {
                reportError = true;
            } else {
                boolean reportError2 = this.f;
                if (reportError2) {
                    this.h = true;
                    zu<Object> zuVar = this.g;
                    if (zuVar == null) {
                        zuVar = new zu<>(4);
                        this.g = zuVar;
                    }
                    Object err = dv.c(t);
                    if (this.b) {
                        zuVar.b(err);
                    } else {
                        zuVar.c(err);
                    }
                    return;
                }
                this.h = true;
                this.f = true;
                reportError = false;
            }
            if (reportError) {
                iv.m(t);
            } else {
                this.a.onError(t);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: hv != io.reactivex.observers.SerializedObserver<T> */
    /* JADX WARN: Generic types in debug info not equals: zu != io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> */
    @Override // defpackage.fs
    public void onComplete() {
        if (this.h) {
            return;
        }
        synchronized (this) {
            if (this.h) {
                return;
            }
            if (this.f) {
                zu<Object> zuVar = this.g;
                if (zuVar == null) {
                    zuVar = new zu<>(4);
                    this.g = zuVar;
                }
                zuVar.b(dv.b());
                return;
            }
            this.h = true;
            this.f = true;
            this.a.onComplete();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: hv != io.reactivex.observers.SerializedObserver<T> */
    /* JADX WARN: Generic types in debug info not equals: zu != io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> */
    public void b() {
        zu<Object> zuVar;
        do {
            synchronized (this) {
                zuVar = this.g;
                if (zuVar == null) {
                    this.f = false;
                    return;
                }
                this.g = null;
            }
        } while (!zuVar.a((fs<? super T>) this.a));
    }
}
