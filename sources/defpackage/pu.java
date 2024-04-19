package defpackage;

import defpackage.gs;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ComputationScheduler.java */
/* renamed from: pu  reason: default package */
/* loaded from: classes.dex */
public final class pu extends gs {
    public static final b b;
    public static final tu c;
    public static final int d = d(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    public static final c e;
    public final ThreadFactory f;
    public final AtomicReference<b> g;

    static {
        c cVar = new c(new tu("RxComputationShutdown"));
        e = cVar;
        cVar.a();
        int priority = Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue()));
        tu tuVar = new tu("RxComputationThreadPool", priority, true);
        c = tuVar;
        b bVar = new b(0, tuVar);
        b = bVar;
        bVar.b();
    }

    public static int d(int cpuCount, int paramThreads) {
        return (paramThreads <= 0 || paramThreads > cpuCount) ? cpuCount : paramThreads;
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: pu$b */
    /* loaded from: classes.dex */
    public static final class b {
        public final int a;
        public final c[] b;
        public long c;

        public b(int maxThreads, ThreadFactory threadFactory) {
            this.a = maxThreads;
            this.b = new c[maxThreads];
            for (int i = 0; i < maxThreads; i++) {
                this.b[i] = new c(threadFactory);
            }
        }

        public c a() {
            int c = this.a;
            if (c == 0) {
                return pu.e;
            }
            c[] cVarArr = this.b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % c)];
        }

        public void b() {
            c[] cVarArr;
            for (c w : this.b) {
                w.a();
            }
        }
    }

    public pu() {
        this(c);
    }

    public pu(ThreadFactory threadFactory) {
        this.f = threadFactory;
        this.g = new AtomicReference<>(b);
        e();
    }

    @Override // defpackage.gs
    public gs.b a() {
        return new a(this.g.get().a());
    }

    @Override // defpackage.gs
    public ls c(Runnable run, long delay, TimeUnit unit) {
        c w = this.g.get().a();
        return w.f(run, delay, unit);
    }

    public void e() {
        b update = new b(d, this.f);
        if (!this.g.compareAndSet(b, update)) {
            update.b();
        }
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: pu$a */
    /* loaded from: classes.dex */
    public static final class a extends gs.b {
        public final gt a;
        public final ks b;
        public final gt d;
        public final c f;
        public volatile boolean g;

        public a(c poolWorker) {
            this.f = poolWorker;
            gt gtVar = new gt();
            this.a = gtVar;
            ks ksVar = new ks();
            this.b = ksVar;
            gt gtVar2 = new gt();
            this.d = gtVar2;
            gtVar2.d(gtVar);
            gtVar2.d(ksVar);
        }

        @Override // defpackage.ls
        public void a() {
            if (!this.g) {
                this.g = true;
                this.d.a();
            }
        }

        @Override // defpackage.gs.b
        public ls c(Runnable action) {
            if (this.g) {
                return ft.INSTANCE;
            }
            return this.f.e(action, 0L, TimeUnit.MILLISECONDS, this.a);
        }

        @Override // defpackage.gs.b
        public ls d(Runnable action, long delayTime, TimeUnit unit) {
            if (this.g) {
                return ft.INSTANCE;
            }
            return this.f.e(action, delayTime, unit, this.b);
        }
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: pu$c */
    /* loaded from: classes.dex */
    public static final class c extends su {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
