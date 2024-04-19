package defpackage;
/* compiled from: BasicFuseableObserver.java */
/* renamed from: ot  reason: default package */
/* loaded from: classes.dex */
public abstract class ot<T, R> implements fs<T>, lt<R> {
    public final fs<? super R> a;
    public ls b;
    public lt<T> d;
    public boolean f;
    public int g;

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super R> */
    /* JADX WARN: Generic types in debug info not equals: ot != io.reactivex.internal.observers.BasicFuseableObserver<T, R> */
    public ot(fs<? super R> fsVar) {
        this.a = fsVar;
    }

    /* JADX WARN: Generic types in debug info not equals: ot != io.reactivex.internal.observers.BasicFuseableObserver<T, R> */
    @Override // defpackage.fs
    public final void onSubscribe(ls d) {
        if (et.h(this.b, d)) {
            this.b = d;
            if (d instanceof lt) {
                this.d = (lt) d;
            }
            if (d()) {
                this.a.onSubscribe(this);
                c();
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: ot != io.reactivex.internal.observers.BasicFuseableObserver<T, R> */
    public boolean d() {
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: ot != io.reactivex.internal.observers.BasicFuseableObserver<T, R> */
    public void c() {
    }

    /* JADX WARN: Generic types in debug info not equals: ot != io.reactivex.internal.observers.BasicFuseableObserver<T, R> */
    @Override // defpackage.fs
    public void onError(Throwable t) {
        if (this.f) {
            iv.m(t);
            return;
        }
        this.f = true;
        this.a.onError(t);
    }

    /* JADX WARN: Generic types in debug info not equals: ot != io.reactivex.internal.observers.BasicFuseableObserver<T, R> */
    public final void e(Throwable t) {
        qs.b(t);
        this.b.a();
        onError(t);
    }

    /* JADX WARN: Generic types in debug info not equals: ot != io.reactivex.internal.observers.BasicFuseableObserver<T, R> */
    @Override // defpackage.fs
    public void onComplete() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.a.onComplete();
    }

    /* JADX WARN: Generic types in debug info not equals: lt != io.reactivex.internal.fuseable.QueueDisposable<T> */
    /* JADX WARN: Generic types in debug info not equals: ot != io.reactivex.internal.observers.BasicFuseableObserver<T, R> */
    public final int f(int mode) {
        lt<T> ltVar = this.d;
        if (ltVar != null && (mode & 4) == 0) {
            int m = ltVar.b(mode);
            if (m != 0) {
                this.g = m;
            }
            return m;
        }
        return 0;
    }

    /* JADX WARN: Generic types in debug info not equals: ot != io.reactivex.internal.observers.BasicFuseableObserver<T, R> */
    @Override // defpackage.ls
    public void a() {
        this.b.a();
    }

    /* JADX WARN: Generic types in debug info not equals: ot != io.reactivex.internal.observers.BasicFuseableObserver<T, R> */
    @Override // defpackage.nt
    public boolean isEmpty() {
        return this.d.isEmpty();
    }

    /* JADX WARN: Generic types in debug info not equals: ot != io.reactivex.internal.observers.BasicFuseableObserver<T, R> */
    @Override // defpackage.nt
    public void clear() {
        this.d.clear();
    }

    /* JADX WARN: Generic types in debug info not equals: ot != io.reactivex.internal.observers.BasicFuseableObserver<T, R> */
    @Override // defpackage.nt
    public final boolean offer(R e) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
