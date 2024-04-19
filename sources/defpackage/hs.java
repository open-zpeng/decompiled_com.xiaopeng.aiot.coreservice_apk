package defpackage;

import java.util.concurrent.Callable;
/* compiled from: RxAndroidPlugins.java */
/* renamed from: hs  reason: default package */
/* loaded from: classes.dex */
public final class hs {
    public static volatile zs<Callable<gs>, gs> a;
    public static volatile zs<gs, gs> b;

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler> */
    public static gs d(Callable<gs> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        zs<Callable<gs>, gs> zsVar = a;
        if (zsVar == null) {
            return c(callable);
        }
        return b(zsVar, callable);
    }

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<io.reactivex.Scheduler, io.reactivex.Scheduler> */
    public static gs e(gs scheduler) {
        if (scheduler == null) {
            throw new NullPointerException("scheduler == null");
        }
        zs<gs, gs> zsVar = b;
        if (zsVar == null) {
            return scheduler;
        }
        return (gs) a(zsVar, scheduler);
    }

    public static gs c(Callable<gs> callable) {
        try {
            gs scheduler = callable.call();
            if (scheduler == null) {
                throw new NullPointerException("Scheduler Callable returned null");
            }
            return scheduler;
        } catch (Throwable ex) {
            throw qs.a(ex);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler> */
    public static gs b(zs<Callable<gs>, gs> zsVar, Callable<gs> callable) {
        gs scheduler = (gs) a(zsVar, callable);
        if (scheduler == null) {
            throw new NullPointerException("Scheduler Callable returned null");
        }
        return scheduler;
    }

    /* JADX WARN: Generic types in debug info not equals: zs != io.reactivex.functions.Function<T, R> */
    public static <T, R> R a(zs<T, R> zsVar, T t) {
        try {
            return zsVar.apply(t);
        } catch (Throwable ex) {
            throw qs.a(ex);
        }
    }
}
