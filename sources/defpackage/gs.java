package defpackage;

import java.util.concurrent.TimeUnit;
/* compiled from: Scheduler.java */
/* renamed from: gs  reason: default package */
/* loaded from: classes.dex */
public abstract class gs {
    public static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract b a();

    public ls b(Runnable run) {
        return c(run, 0L, TimeUnit.NANOSECONDS);
    }

    public ls c(Runnable run, long delay, TimeUnit unit) {
        b w = a();
        Runnable decoratedRun = iv.o(run);
        a task = new a(decoratedRun, w);
        w.d(task, delay, unit);
        return task;
    }

    /* compiled from: Scheduler.java */
    /* renamed from: gs$b */
    /* loaded from: classes.dex */
    public static abstract class b implements ls {
        public abstract ls d(Runnable runnable, long j, TimeUnit timeUnit);

        public ls c(Runnable run) {
            return d(run, 0L, TimeUnit.NANOSECONDS);
        }

        public long b(TimeUnit unit) {
            return unit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    /* compiled from: Scheduler.java */
    /* renamed from: gs$a */
    /* loaded from: classes.dex */
    public static final class a implements ls, Runnable {
        public final Runnable a;
        public final b b;
        public Thread d;

        public a(Runnable decoratedRun, b w) {
            this.a = decoratedRun;
            this.b = w;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.d = Thread.currentThread();
            try {
                this.a.run();
            } finally {
                a();
                this.d = null;
            }
        }

        @Override // defpackage.ls
        public void a() {
            if (this.d == Thread.currentThread()) {
                b bVar = this.b;
                if (bVar instanceof su) {
                    ((su) bVar).g();
                    return;
                }
            }
            this.b.a();
        }
    }
}
