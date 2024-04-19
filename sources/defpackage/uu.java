package defpackage;

import java.util.concurrent.Callable;
/* compiled from: ScheduledDirectTask.java */
/* renamed from: uu  reason: default package */
/* loaded from: classes.dex */
public final class uu extends ou implements Callable<Void> {
    public uu(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: c */
    public Void call() throws Exception {
        this.f = Thread.currentThread();
        try {
            this.d.run();
            return null;
        } finally {
            lazySet(ou.a);
            this.f = null;
        }
    }
}
