package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* compiled from: Observable.java */
/* renamed from: bs  reason: default package */
/* loaded from: classes.dex */
public abstract class bs<T> implements es<T> {
    public abstract void z(fs<? super T> fsVar);

    public static int b() {
        return as.a();
    }

    /* JADX WARN: Generic types in debug info not equals: es[] != io.reactivex.ObservableSource<? extends T>[] */
    public static <T> bs<T> c(es<? extends T>... esVarArr) {
        if (esVarArr.length == 0) {
            return j();
        }
        if (esVarArr.length == 1) {
            return E(esVarArr[0]);
        }
        return iv.j(new ut(l(esVarArr), jt.c(), b(), bv.BOUNDARY));
    }

    /* JADX WARN: Generic types in debug info not equals: ds != io.reactivex.ObservableOnSubscribe<T> */
    public static <T> bs<T> d(ds<T> dsVar) {
        kt.d(dsVar, "source is null");
        return iv.j(new vt(dsVar));
    }

    public static <T> bs<T> e(Callable<? extends es<? extends T>> callable) {
        kt.d(callable, "supplier is null");
        return iv.j(new wt(callable));
    }

    public static <T> bs<T> j() {
        return iv.j(zt.a);
    }

    public static <T> bs<T> l(T... items) {
        kt.d(items, "items is null");
        if (items.length == 0) {
            return j();
        }
        if (items.length == 1) {
            return m(items[0]);
        }
        return iv.j(new bu(items));
    }

    public static <T> bs<T> m(T item) {
        kt.d(item, "The item is null");
        return iv.j(new du(item));
    }

    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<T> */
    public static <T> bs<T> E(es<T> esVar) {
        kt.d(esVar, "source is null");
        if (esVar instanceof bs) {
            return iv.j((bs) esVar);
        }
        return iv.j(new cu(esVar));
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    public final bs<T> f(us onDispose) {
        return h(jt.b(), onDispose);
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super java.lang.Throwable> */
    public final bs<T> g(ys<? super T> ysVar, ys<? super Throwable> ysVar2, us onComplete, us onAfterTerminate) {
        kt.d(ysVar, "onNext is null");
        kt.d(ysVar2, "onError is null");
        kt.d(onComplete, "onComplete is null");
        kt.d(onAfterTerminate, "onAfterTerminate is null");
        return iv.j(new xt(this, ysVar, ysVar2, onComplete, onAfterTerminate));
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> */
    public final bs<T> h(ys<? super ls> ysVar, us onDispose) {
        kt.d(ysVar, "onSubscribe is null");
        kt.d(onDispose, "onDispose is null");
        return iv.j(new yt(this, ysVar, onDispose));
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super T> */
    public final bs<T> i(ys<? super T> ysVar) {
        ys<? super Throwable> b = jt.b();
        us usVar = jt.c;
        return g(ysVar, b, usVar, usVar);
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: bt != io.reactivex.functions.Predicate<? super T> */
    public final bs<T> k(bt<? super T> btVar) {
        kt.d(btVar, "predicate is null");
        return iv.j(new au(this, btVar));
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super T, ? extends R> */
    public final <R> bs<R> n(zs<? super T, ? extends R> zsVar) {
        kt.d(zsVar, "mapper is null");
        return iv.j(new eu(this, zsVar));
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    public final bs<T> o(gs scheduler) {
        return p(scheduler, false, b());
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    public final bs<T> p(gs scheduler, boolean delayError, int bufferSize) {
        kt.d(scheduler, "scheduler is null");
        kt.e(bufferSize, "bufferSize");
        return iv.j(new fu(this, scheduler, delayError, bufferSize));
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    public final gv<T> q() {
        return gu.H(this);
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    public final bs<T> r(long times) {
        return s(times, jt.a());
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: bt != io.reactivex.functions.Predicate<? super java.lang.Throwable> */
    public final bs<T> s(long times, bt<? super Throwable> btVar) {
        if (times < 0) {
            throw new IllegalArgumentException("times >= 0 required but it was " + times);
        }
        kt.d(btVar, "predicate is null");
        return iv.j(new iu(this, times, btVar));
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: bt != io.reactivex.functions.Predicate<? super java.lang.Throwable> */
    public final bs<T> t(bt<? super Throwable> btVar) {
        return s(Long.MAX_VALUE, btVar);
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    public final bs<T> u() {
        return q().G();
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    public final bs<T> v(T item) {
        kt.d(item, "item is null");
        return c(m(item), this);
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super T> */
    public final ls w(ys<? super T> ysVar) {
        return y(ysVar, jt.f, jt.c, jt.b());
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super java.lang.Throwable> */
    public final ls x(ys<? super T> ysVar, ys<? super Throwable> ysVar2) {
        return y(ysVar, ysVar2, jt.c, jt.b());
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: st != io.reactivex.internal.observers.LambdaObserver<T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super java.lang.Throwable> */
    public final ls y(ys<? super T> ysVar, ys<? super Throwable> ysVar2, us onComplete, ys<? super ls> ysVar3) {
        kt.d(ysVar, "onNext is null");
        kt.d(ysVar2, "onError is null");
        kt.d(onComplete, "onComplete is null");
        kt.d(ysVar3, "onSubscribe is null");
        st stVar = new st(ysVar, ysVar2, onComplete, ysVar3);
        a(stVar);
        return stVar;
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    @Override // defpackage.es
    public final void a(fs<? super T> fsVar) {
        kt.d(fsVar, "observer is null");
        try {
            fs<? super T> p = iv.p(this, fsVar);
            kt.d(p, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            z(p);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable e2) {
            qs.b(e2);
            iv.m(e2);
            NullPointerException npe = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            npe.initCause(e2);
            throw npe;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    public final bs<T> A(gs scheduler) {
        kt.d(scheduler, "scheduler is null");
        return iv.j(new ku(this, scheduler));
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    public final bs<T> B(long count) {
        if (count < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + count);
        }
        return iv.j(new lu(this, count));
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    public final bs<T> C(long timeout, TimeUnit timeUnit) {
        return D(timeout, timeUnit, null, jv.a());
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<? extends T> */
    public final bs<T> D(long timeout, TimeUnit timeUnit, es<? extends T> esVar, gs scheduler) {
        kt.d(timeUnit, "timeUnit is null");
        kt.d(scheduler, "scheduler is null");
        return iv.j(new mu(this, timeout, timeUnit, scheduler, esVar));
    }
}
