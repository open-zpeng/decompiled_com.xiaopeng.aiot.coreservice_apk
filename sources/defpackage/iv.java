package defpackage;

import java.lang.Thread;
import java.util.concurrent.Callable;
/* compiled from: RxJavaPlugins.java */
/* renamed from: iv  reason: default package */
/* loaded from: classes.dex */
public final class iv {
    public static volatile ys<? super Throwable> a;
    public static volatile zs<? super Runnable, ? extends Runnable> b;
    public static volatile zs<? super Callable<gs>, ? extends gs> c;
    public static volatile zs<? super Callable<gs>, ? extends gs> d;
    public static volatile zs<? super Callable<gs>, ? extends gs> e;
    public static volatile zs<? super Callable<gs>, ? extends gs> f;
    public static volatile zs<? super gs, ? extends gs> g;
    public static volatile zs<? super gs, ? extends gs> h;
    public static volatile zs<? super bs, ? extends bs> i;
    public static volatile zs<? super gv, ? extends gv> j;
    public static volatile vs<? super bs, ? super fs, ? extends fs> k;
    public static volatile boolean l;

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> */
    public static gs e(Callable<gs> callable) {
        kt.d(callable, "Scheduler Callable can't be null");
        zs<? super Callable<gs>, ? extends gs> zsVar = c;
        if (zsVar == null) {
            return d(callable);
        }
        return c(zsVar, callable);
    }

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> */
    public static gs f(Callable<gs> callable) {
        kt.d(callable, "Scheduler Callable can't be null");
        zs<? super Callable<gs>, ? extends gs> zsVar = e;
        if (zsVar == null) {
            return d(callable);
        }
        return c(zsVar, callable);
    }

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> */
    public static gs g(Callable<gs> callable) {
        kt.d(callable, "Scheduler Callable can't be null");
        zs<? super Callable<gs>, ? extends gs> zsVar = f;
        if (zsVar == null) {
            return d(callable);
        }
        return c(zsVar, callable);
    }

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> */
    public static gs h(Callable<gs> callable) {
        kt.d(callable, "Scheduler Callable can't be null");
        zs<? super Callable<gs>, ? extends gs> zsVar = d;
        if (zsVar == null) {
            return d(callable);
        }
        return c(zsVar, callable);
    }

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> */
    public static gs l(gs defaultScheduler) {
        zs<? super gs, ? extends gs> zsVar = g;
        if (zsVar == null) {
            return defaultScheduler;
        }
        return (gs) b(zsVar, defaultScheduler);
    }

    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super java.lang.Throwable> */
    public static void m(Throwable error) {
        ys<? super Throwable> ysVar = a;
        if (error == null) {
            error = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(error)) {
            error = new ts(error);
        }
        if (ysVar != null) {
            try {
                ysVar.accept(error);
                return;
            } catch (Throwable e2) {
                e2.printStackTrace();
                r(e2);
            }
        }
        error.printStackTrace();
        r(error);
    }

    public static boolean i(Throwable error) {
        return (error instanceof rs) || (error instanceof IllegalStateException) || (error instanceof NullPointerException) || (error instanceof IllegalArgumentException) || (error instanceof ps);
    }

    public static void r(Throwable error) {
        Thread currentThread = Thread.currentThread();
        Thread.UncaughtExceptionHandler handler = currentThread.getUncaughtExceptionHandler();
        handler.uncaughtException(currentThread, error);
    }

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super io.reactivex.Scheduler, ? extends io.reactivex.Scheduler> */
    public static gs n(gs defaultScheduler) {
        zs<? super gs, ? extends gs> zsVar = h;
        if (zsVar == null) {
            return defaultScheduler;
        }
        return (gs) b(zsVar, defaultScheduler);
    }

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super java.lang.Runnable, ? extends java.lang.Runnable> */
    public static Runnable o(Runnable run) {
        kt.d(run, "run is null");
        zs<? super Runnable, ? extends Runnable> zsVar = b;
        if (zsVar == null) {
            return run;
        }
        return (Runnable) b(zsVar, run);
    }

    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super java.lang.Throwable> */
    public static void q(ys<? super Throwable> ysVar) {
        if (l) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        a = ysVar;
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: vs != io.reactivex.functions.BiFunction<? super io.reactivex.Observable, ? super io.reactivex.Observer, ? extends io.reactivex.Observer> */
    public static <T> fs<? super T> p(bs<T> bsVar, fs<? super T> fsVar) {
        vs<? super bs, ? super fs, ? extends fs> vsVar = k;
        if (vsVar != null) {
            return (fs) a(vsVar, bsVar, fsVar);
        }
        return fsVar;
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super io.reactivex.Observable, ? extends io.reactivex.Observable> */
    public static <T> bs<T> j(bs<T> bsVar) {
        zs<? super bs, ? extends bs> zsVar = i;
        if (zsVar != null) {
            return (bs) b(zsVar, bsVar);
        }
        return bsVar;
    }

    /* JADX WARN: Generic types in debug info not equals: gv != io.reactivex.observables.ConnectableObservable<T> */
    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super io.reactivex.observables.ConnectableObservable, ? extends io.reactivex.observables.ConnectableObservable> */
    public static <T> gv<T> k(gv<T> gvVar) {
        zs<? super gv, ? extends gv> zsVar = j;
        if (zsVar != null) {
            return (gv) b(zsVar, gvVar);
        }
        return gvVar;
    }

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<T, R> */
    public static <T, R> R b(zs<T, R> zsVar, T t) {
        try {
            return zsVar.apply(t);
        } catch (Throwable ex) {
            throw cv.d(ex);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: vs != io.reactivex.functions.BiFunction<T, U, R> */
    public static <T, U, R> R a(vs<T, U, R> vsVar, T t, U u) {
        try {
            return vsVar.a(t, u);
        } catch (Throwable ex) {
            throw cv.d(ex);
        }
    }

    public static gs d(Callable<gs> callable) {
        try {
            return (gs) kt.d(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable ex) {
            throw cv.d(ex);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<? super java.util.concurrent.Callable<io.reactivex.Scheduler>, ? extends io.reactivex.Scheduler> */
    public static gs c(zs<? super Callable<gs>, ? extends gs> zsVar, Callable<gs> callable) {
        return (gs) kt.d(b(zsVar, callable), "Scheduler Callable result can't be null");
    }
}
