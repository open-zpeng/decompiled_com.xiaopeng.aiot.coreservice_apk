package defpackage;

import defpackage.gs;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TrampolineScheduler.java */
/* renamed from: yu  reason: default package */
/* loaded from: classes.dex */
public final class yu extends gs {
    public static final yu b = new yu();

    public static yu d() {
        return b;
    }

    @Override // defpackage.gs
    public gs.b a() {
        return new c();
    }

    @Override // defpackage.gs
    public ls b(Runnable run) {
        iv.o(run).run();
        return ft.INSTANCE;
    }

    @Override // defpackage.gs
    public ls c(Runnable run, long delay, TimeUnit unit) {
        try {
            unit.sleep(delay);
            iv.o(run).run();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            iv.m(ex);
        }
        return ft.INSTANCE;
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: yu$c */
    /* loaded from: classes.dex */
    public static final class c extends gs.b implements ls {
        public final PriorityBlockingQueue<b> a = new PriorityBlockingQueue<>();
        public final AtomicInteger b = new AtomicInteger();
        public final AtomicInteger d = new AtomicInteger();
        public volatile boolean f;

        @Override // defpackage.gs.b
        public ls c(Runnable action) {
            return e(action, b(TimeUnit.MILLISECONDS));
        }

        @Override // defpackage.gs.b
        public ls d(Runnable action, long delayTime, TimeUnit unit) {
            long execTime = b(TimeUnit.MILLISECONDS) + unit.toMillis(delayTime);
            return e(new a(action, this, execTime), execTime);
        }

        public ls e(Runnable action, long execTime) {
            if (this.f) {
                return ft.INSTANCE;
            }
            b timedRunnable = new b(action, Long.valueOf(execTime), this.d.incrementAndGet());
            this.a.add(timedRunnable);
            if (this.b.getAndIncrement() == 0) {
                int missed = 1;
                while (!this.f) {
                    b polled = this.a.poll();
                    if (polled != null) {
                        if (!polled.f) {
                            polled.a.run();
                        }
                    } else {
                        missed = this.b.addAndGet(-missed);
                        if (missed == 0) {
                            return ft.INSTANCE;
                        }
                    }
                }
                this.a.clear();
                return ft.INSTANCE;
            }
            return ms.b(new a(timedRunnable));
        }

        @Override // defpackage.ls
        public void a() {
            this.f = true;
        }

        /* compiled from: TrampolineScheduler.java */
        /* renamed from: yu$c$a */
        /* loaded from: classes.dex */
        public final class a implements Runnable {
            public final b a;

            public a(b timedRunnable) {
                this.a = timedRunnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.f = true;
                c.this.a.remove(this.a);
            }
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: yu$b */
    /* loaded from: classes.dex */
    public static final class b implements Comparable<b> {
        public final Runnable a;
        public final long b;
        public final int d;
        public volatile boolean f;

        public b(Runnable run, Long execTime, int count) {
            this.a = run;
            this.b = execTime.longValue();
            this.d = count;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b that) {
            int result = kt.b(this.b, that.b);
            if (result == 0) {
                return kt.a(this.d, that.d);
            }
            return result;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: yu$a */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        public final Runnable a;
        public final c b;
        public final long d;

        public a(Runnable run, c worker, long execTime) {
            this.a = run;
            this.b = worker;
            this.d = execTime;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.b.f) {
                long t = this.b.b(TimeUnit.MILLISECONDS);
                long j = this.d;
                if (j > t) {
                    long delay = j - t;
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        iv.m(e);
                        return;
                    }
                }
                if (!this.b.f) {
                    this.a.run();
                }
            }
        }
    }
}
