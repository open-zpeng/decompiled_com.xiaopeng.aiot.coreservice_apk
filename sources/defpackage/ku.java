package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableSubscribeOn.java */
/* renamed from: ku  reason: default package */
/* loaded from: classes.dex */
public final class ku<T> extends tt<T, T> {
    public final gs b;

    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<T> */
    /* JADX WARN: Generic types in debug info not equals: ku != io.reactivex.internal.operators.observable.ObservableSubscribeOn<T> */
    public ku(es<T> esVar, gs scheduler) {
        super(esVar);
        this.b = scheduler;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: ku != io.reactivex.internal.operators.observable.ObservableSubscribeOn<T> */
    /* JADX WARN: Generic types in debug info not equals: ku$a != io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver<T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        a aVar = new a(fsVar);
        fsVar.onSubscribe(aVar);
        aVar.b(this.b.b(new b(aVar)));
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* renamed from: ku$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<ls> implements fs<T>, ls {
        public final fs<? super T> a;
        public final AtomicReference<ls> b = new AtomicReference<>();

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: ku$a != io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver<T> */
        public a(fs<? super T> fsVar) {
            this.a = fsVar;
        }

        /* JADX WARN: Generic types in debug info not equals: ku$a != io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver<T> */
        @Override // defpackage.fs
        public void onSubscribe(ls d) {
            et.g(this.b, d);
        }

        /* JADX WARN: Generic types in debug info not equals: ku$a != io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver<T> */
        @Override // defpackage.fs
        public void onNext(T t) {
            this.a.onNext(t);
        }

        /* JADX WARN: Generic types in debug info not equals: ku$a != io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver<T> */
        @Override // defpackage.fs
        public void onError(Throwable t) {
            this.a.onError(t);
        }

        /* JADX WARN: Generic types in debug info not equals: ku$a != io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver<T> */
        @Override // defpackage.fs
        public void onComplete() {
            this.a.onComplete();
        }

        /* JADX WARN: Generic types in debug info not equals: ku$a != io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver<T> */
        @Override // defpackage.ls
        public void a() {
            et.b(this.b);
            et.b(this);
        }

        /* JADX WARN: Generic types in debug info not equals: ku$a != io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver<T> */
        public void b(ls d) {
            et.g(this, d);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* renamed from: ku$b */
    /* loaded from: classes.dex */
    public final class b implements Runnable {
        public final a<T> a;

        /* JADX WARN: Generic types in debug info not equals: ku$a != io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver<T> */
        /* JADX WARN: Generic types in debug info not equals: ku$b != io.reactivex.internal.operators.observable.ObservableSubscribeOn<T>$SubscribeTask */
        public b(a<T> aVar) {
            this.a = aVar;
        }

        /* JADX WARN: Generic types in debug info not equals: ku$b != io.reactivex.internal.operators.observable.ObservableSubscribeOn<T>$SubscribeTask */
        @Override // java.lang.Runnable
        public void run() {
            ku.this.a.a(this.a);
        }
    }
}
