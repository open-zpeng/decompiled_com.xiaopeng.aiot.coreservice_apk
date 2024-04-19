package defpackage;

import defpackage.gs;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* compiled from: NewThreadWorker.java */
/* renamed from: su  reason: default package */
/* loaded from: classes.dex */
public class su extends gs.b implements ls {
    public final ScheduledExecutorService a;
    public volatile boolean b;

    public su(ThreadFactory threadFactory) {
        this.a = wu.a(threadFactory);
    }

    @Override // defpackage.gs.b
    public ls c(Runnable run) {
        return d(run, 0L, null);
    }

    @Override // defpackage.gs.b
    public ls d(Runnable action, long delayTime, TimeUnit unit) {
        if (this.b) {
            return ft.INSTANCE;
        }
        return e(action, delayTime, unit, null);
    }

    public ls f(Runnable run, long delayTime, TimeUnit unit) {
        Future<?> f;
        uu task = new uu(iv.o(run));
        try {
            if (delayTime <= 0) {
                f = this.a.submit(task);
            } else {
                f = this.a.schedule(task, delayTime, unit);
            }
            task.b(f);
            return task;
        } catch (RejectedExecutionException ex) {
            iv.m(ex);
            return ft.INSTANCE;
        }
    }

    public vu e(Runnable run, long delayTime, TimeUnit unit, dt parent) {
        Future<?> f;
        Runnable decoratedRun = iv.o(run);
        vu sr = new vu(decoratedRun, parent);
        if (parent != null && !parent.d(sr)) {
            return sr;
        }
        try {
            if (delayTime <= 0) {
                f = this.a.submit((Callable) sr);
            } else {
                f = this.a.schedule((Callable) sr, delayTime, unit);
            }
            sr.b(f);
        } catch (RejectedExecutionException ex) {
            if (parent != null) {
                parent.c(sr);
            }
            iv.m(ex);
        }
        return sr;
    }

    @Override // defpackage.ls
    public void a() {
        if (!this.b) {
            this.b = true;
            this.a.shutdownNow();
        }
    }

    public void g() {
        if (!this.b) {
            this.b = true;
            this.a.shutdown();
        }
    }
}
