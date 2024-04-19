package defpackage;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: AbstractDirectTask.java */
/* renamed from: ou  reason: default package */
/* loaded from: classes.dex */
public abstract class ou extends AtomicReference<Future<?>> implements ls {
    public static final FutureTask<Void> a;
    public static final FutureTask<Void> b;
    public final Runnable d;
    public Thread f;

    static {
        Runnable runnable = jt.b;
        a = new FutureTask<>(runnable, null);
        b = new FutureTask<>(runnable, null);
    }

    public ou(Runnable runnable) {
        this.d = runnable;
    }

    @Override // defpackage.ls
    public final void a() {
        FutureTask<Void> futureTask;
        Future<?> f = get();
        if (f != a && f != (futureTask = b) && compareAndSet(f, futureTask) && f != null) {
            f.cancel(this.f != Thread.currentThread());
        }
    }

    public final void b(Future<?> future) {
        Future<?> f;
        do {
            f = get();
            if (f != a) {
                if (f == b) {
                    future.cancel(this.f != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(f, future));
    }
}
