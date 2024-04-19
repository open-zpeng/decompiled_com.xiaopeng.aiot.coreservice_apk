package defpackage;

import defpackage.gs;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: IoScheduler.java */
/* renamed from: qu  reason: default package */
/* loaded from: classes.dex */
public final class qu extends gs {
    public static final tu b;
    public static final tu c;
    public static final c f;
    public static final a g;
    public final ThreadFactory h;
    public final AtomicReference<a> i;
    public static final TimeUnit e = TimeUnit.SECONDS;
    public static final long d = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    static {
        c cVar = new c(new tu("RxCachedThreadSchedulerShutdown"));
        f = cVar;
        cVar.a();
        int priority = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        tu tuVar = new tu("RxCachedThreadScheduler", priority);
        b = tuVar;
        c = new tu("RxCachedWorkerPoolEvictor", priority);
        a aVar = new a(0L, null, tuVar);
        g = aVar;
        aVar.e();
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: qu$a */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        public final long a;
        public final ConcurrentLinkedQueue<c> b;
        public final ks d;
        public final ScheduledExecutorService f;
        public final Future<?> g;
        public final ThreadFactory h;

        public a(long keepAliveTime, TimeUnit unit, ThreadFactory threadFactory) {
            long nanos = unit != null ? unit.toNanos(keepAliveTime) : 0L;
            this.a = nanos;
            this.b = new ConcurrentLinkedQueue<>();
            this.d = new ks();
            this.h = threadFactory;
            ScheduledExecutorService evictor = null;
            Future<?> task = null;
            if (unit != null) {
                evictor = Executors.newScheduledThreadPool(1, qu.c);
                task = evictor.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            }
            this.f = evictor;
            this.g = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        public c b() {
            if (this.d.f()) {
                return qu.f;
            }
            while (!this.b.isEmpty()) {
                c threadWorker = this.b.poll();
                if (threadWorker != null) {
                    return threadWorker;
                }
            }
            c w = new c(this.h);
            this.d.d(w);
            return w;
        }

        public void d(c threadWorker) {
            threadWorker.i(c() + this.a);
            this.b.offer(threadWorker);
        }

        public void a() {
            if (!this.b.isEmpty()) {
                long currentTimestamp = c();
                Iterator<c> it = this.b.iterator();
                while (it.hasNext()) {
                    c threadWorker = it.next();
                    if (threadWorker.h() <= currentTimestamp) {
                        if (this.b.remove(threadWorker)) {
                            this.d.c(threadWorker);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public long c() {
            return System.nanoTime();
        }

        public void e() {
            this.d.a();
            Future<?> future = this.g;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public qu() {
        this(b);
    }

    public qu(ThreadFactory threadFactory) {
        this.h = threadFactory;
        this.i = new AtomicReference<>(g);
        d();
    }

    public void d() {
        a update = new a(d, e, this.h);
        if (!this.i.compareAndSet(g, update)) {
            update.e();
        }
    }

    @Override // defpackage.gs
    public gs.b a() {
        return new b(this.i.get());
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: qu$b */
    /* loaded from: classes.dex */
    public static final class b extends gs.b {
        public final a b;
        public final c d;
        public final AtomicBoolean f = new AtomicBoolean();
        public final ks a = new ks();

        public b(a pool) {
            this.b = pool;
            this.d = pool.b();
        }

        @Override // defpackage.ls
        public void a() {
            if (this.f.compareAndSet(false, true)) {
                this.a.a();
                this.b.d(this.d);
            }
        }

        @Override // defpackage.gs.b
        public ls d(Runnable action, long delayTime, TimeUnit unit) {
            if (this.a.f()) {
                return ft.INSTANCE;
            }
            return this.d.e(action, delayTime, unit, this.a);
        }
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: qu$c */
    /* loaded from: classes.dex */
    public static final class c extends su {
        public long d;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.d = 0L;
        }

        public long h() {
            return this.d;
        }

        public void i(long expirationTime) {
            this.d = expirationTime;
        }
    }
}
