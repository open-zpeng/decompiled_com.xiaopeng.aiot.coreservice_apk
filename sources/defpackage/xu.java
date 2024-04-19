package defpackage;

import defpackage.gs;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleScheduler.java */
/* renamed from: xu  reason: default package */
/* loaded from: classes.dex */
public final class xu extends gs {
    public static final tu b;
    public static final ScheduledExecutorService c;
    public final ThreadFactory d;
    public final AtomicReference<ScheduledExecutorService> e;

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        c = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        int priority = Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue()));
        b = new tu("RxSingleScheduler", priority, true);
    }

    public xu() {
        this(b);
    }

    public xu(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.e = atomicReference;
        this.d = threadFactory;
        atomicReference.lazySet(d(threadFactory));
    }

    public static ScheduledExecutorService d(ThreadFactory threadFactory) {
        return wu.a(threadFactory);
    }

    @Override // defpackage.gs
    public gs.b a() {
        return new a(this.e.get());
    }

    @Override // defpackage.gs
    public ls c(Runnable run, long delay, TimeUnit unit) {
        Future<?> f;
        uu task = new uu(iv.o(run));
        try {
            if (delay <= 0) {
                f = this.e.get().submit(task);
            } else {
                f = this.e.get().schedule(task, delay, unit);
            }
            task.b(f);
            return task;
        } catch (RejectedExecutionException ex) {
            iv.m(ex);
            return ft.INSTANCE;
        }
    }

    /* compiled from: SingleScheduler.java */
    /* renamed from: xu$a */
    /* loaded from: classes.dex */
    public static final class a extends gs.b {
        public final ScheduledExecutorService a;
        public final ks b = new ks();
        public volatile boolean d;

        public a(ScheduledExecutorService executor) {
            this.a = executor;
        }

        @Override // defpackage.gs.b
        public ls d(Runnable run, long delay, TimeUnit unit) {
            Future<?> f;
            if (this.d) {
                return ft.INSTANCE;
            }
            Runnable decoratedRun = iv.o(run);
            vu sr = new vu(decoratedRun, this.b);
            this.b.d(sr);
            try {
                if (delay <= 0) {
                    f = this.a.submit((Callable) sr);
                } else {
                    f = this.a.schedule((Callable) sr, delay, unit);
                }
                sr.b(f);
                return sr;
            } catch (RejectedExecutionException ex) {
                a();
                iv.m(ex);
                return ft.INSTANCE;
            }
        }

        @Override // defpackage.ls
        public void a() {
            if (!this.d) {
                this.d = true;
                this.b.a();
            }
        }
    }
}
