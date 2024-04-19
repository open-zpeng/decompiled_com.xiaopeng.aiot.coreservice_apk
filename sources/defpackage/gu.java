package defpackage;

import io.reactivex.internal.operators.observable.ObservablePublish;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservablePublish.java */
/* renamed from: gu  reason: default package */
/* loaded from: classes.dex */
public final class gu<T> extends gv<T> {
    public final es<T> a;
    public final AtomicReference<b<T>> b;
    public final es<T> d;

    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<T> */
    public static <T> gv<T> H(es<T> esVar) {
        AtomicReference<ObservablePublish.PublishObserver<T>> curr = new AtomicReference<>();
        return iv.k(new gu(new c(curr), esVar, curr));
    }

    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<T> */
    /* JADX WARN: Generic types in debug info not equals: gu != io.reactivex.internal.operators.observable.ObservablePublish<T> */
    public gu(es<T> esVar, es<T> esVar2, AtomicReference<b<T>> atomicReference) {
        this.d = esVar;
        this.a = esVar2;
        this.b = atomicReference;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: gu != io.reactivex.internal.operators.observable.ObservablePublish<T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        this.d.a(fsVar);
    }

    /* JADX WARN: Generic types in debug info not equals: gu != io.reactivex.internal.operators.observable.ObservablePublish<T> */
    /* JADX WARN: Generic types in debug info not equals: gu$b != io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> */
    @Override // defpackage.gv
    public void F(ys<? super ls> ysVar) {
        b<T> bVar;
        while (true) {
            bVar = this.b.get();
            if (bVar != null && !bVar.c()) {
                break;
            }
            b<T> bVar2 = new b<>(this.b);
            if (this.b.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = true;
        if (bVar.g.get() || !bVar.g.compareAndSet(false, true)) {
            z = false;
        }
        boolean doConnect = z;
        try {
            ysVar.accept(bVar);
            if (doConnect) {
                this.a.a(bVar);
            }
        } catch (Throwable ex) {
            qs.b(ex);
            throw cv.d(ex);
        }
    }

    /* compiled from: ObservablePublish.java */
    /* renamed from: gu$b */
    /* loaded from: classes.dex */
    public static final class b<T> implements fs<T>, ls {
        public static final a[] a = new a[0];
        public static final a[] b = new a[0];
        public final AtomicReference<b<T>> d;
        public final AtomicReference<ls> h = new AtomicReference<>();
        public final AtomicReference<a<T>[]> f = new AtomicReference<>(a);
        public final AtomicBoolean g = new AtomicBoolean();

        /* JADX WARN: Generic types in debug info not equals: gu$b != io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T> */
        public b(AtomicReference<b<T>> atomicReference) {
            this.d = atomicReference;
        }

        /* JADX WARN: Generic types in debug info not equals: gu$b != io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T> */
        @Override // defpackage.ls
        public void a() {
            AtomicReference<a<T>[]> atomicReference = this.f;
            a[] aVarArr = b;
            a[] ps = atomicReference.getAndSet(aVarArr);
            if (ps != aVarArr) {
                this.d.compareAndSet(this, null);
                et.b(this.h);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: gu$b != io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T> */
        public boolean c() {
            return this.f.get() == b;
        }

        /* JADX WARN: Generic types in debug info not equals: gu$b != io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T> */
        @Override // defpackage.fs
        public void onSubscribe(ls d) {
            et.g(this.h, d);
        }

        /* JADX WARN: Generic types in debug info not equals: gu$a != io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T> */
        /* JADX WARN: Generic types in debug info not equals: gu$b != io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T> */
        @Override // defpackage.fs
        public void onNext(T t) {
            for (a<T> aVar : this.f.get()) {
                aVar.a.onNext(t);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: gu$a != io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T> */
        /* JADX WARN: Generic types in debug info not equals: gu$a[] != io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T>[] */
        /* JADX WARN: Generic types in debug info not equals: gu$b != io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T> */
        @Override // defpackage.fs
        public void onError(Throwable e) {
            this.d.compareAndSet(this, null);
            a<T>[] andSet = this.f.getAndSet(b);
            if (andSet.length != 0) {
                for (a<T> aVar : andSet) {
                    aVar.a.onError(e);
                }
                return;
            }
            iv.m(e);
        }

        /* JADX WARN: Generic types in debug info not equals: gu$a != io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T> */
        /* JADX WARN: Generic types in debug info not equals: gu$b != io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T> */
        @Override // defpackage.fs
        public void onComplete() {
            this.d.compareAndSet(this, null);
            for (a<T> aVar : this.f.getAndSet(b)) {
                aVar.a.onComplete();
            }
        }

        /* JADX WARN: Generic types in debug info not equals: gu$a != io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T> */
        /* JADX WARN: Generic types in debug info not equals: gu$a[] != io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T>[] */
        /* JADX WARN: Generic types in debug info not equals: gu$b != io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T> */
        public boolean b(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f.get();
                if (aVarArr == b) {
                    return false;
                }
                int len = aVarArr.length;
                aVarArr2 = new a[len + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, len);
                aVarArr2[len] = aVar;
            } while (!this.f.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        /* JADX WARN: Generic types in debug info not equals: gu$a != io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T> */
        /* JADX WARN: Generic types in debug info not equals: gu$a[] != io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T>[] */
        /* JADX WARN: Generic types in debug info not equals: gu$b != io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public void d(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.f.get();
                int len = aVarArr.length;
                if (len == 0) {
                    return;
                }
                int j = -1;
                int i = 0;
                while (true) {
                    if (i >= len) {
                        break;
                    } else if (!aVarArr[i].equals(aVar)) {
                        i++;
                    } else {
                        j = i;
                        break;
                    }
                }
                if (j < 0) {
                    return;
                }
                if (len == 1) {
                    aVarArr2 = a;
                } else {
                    a[] aVarArr3 = new a[len - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, j);
                    System.arraycopy(aVarArr, j + 1, aVarArr3, j, (len - j) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.f.compareAndSet(aVarArr, aVarArr2));
        }
    }

    /* compiled from: ObservablePublish.java */
    /* renamed from: gu$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<Object> implements ls {
        public final fs<? super T> a;

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: gu$a != io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T> */
        public a(fs<? super T> fsVar) {
            this.a = fsVar;
        }

        /* JADX WARN: Generic types in debug info not equals: gu$a != io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T> */
        @Override // defpackage.ls
        public void a() {
            Object o = getAndSet(this);
            if (o != null && o != this) {
                ((b) o).d(this);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: gu$a != io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T> */
        /* JADX WARN: Generic types in debug info not equals: gu$b != io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T> */
        public void b(b<T> bVar) {
            if (!compareAndSet(null, bVar)) {
                bVar.d(this);
            }
        }
    }

    /* compiled from: ObservablePublish.java */
    /* renamed from: gu$c */
    /* loaded from: classes.dex */
    public static final class c<T> implements es<T> {
        public final AtomicReference<b<T>> a;

        /* JADX WARN: Generic types in debug info not equals: gu$c != io.reactivex.internal.operators.observable.ObservablePublish$PublishSource<T> */
        public c(AtomicReference<b<T>> atomicReference) {
            this.a = atomicReference;
        }

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: gu$a != io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T> */
        /* JADX WARN: Generic types in debug info not equals: gu$b != io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver<T> */
        /* JADX WARN: Generic types in debug info not equals: gu$c != io.reactivex.internal.operators.observable.ObservablePublish$PublishSource<T> */
        @Override // defpackage.es
        public void a(fs<? super T> fsVar) {
            a aVar = new a(fsVar);
            fsVar.onSubscribe(aVar);
            while (true) {
                b<T> bVar = this.a.get();
                if (bVar == null || bVar.c()) {
                    b<T> bVar2 = new b<>(this.a);
                    if (this.a.compareAndSet(bVar, bVar2)) {
                        bVar = bVar2;
                    } else {
                        continue;
                    }
                }
                if (bVar.b(aVar)) {
                    aVar.b(bVar);
                    return;
                }
            }
        }
    }
}
