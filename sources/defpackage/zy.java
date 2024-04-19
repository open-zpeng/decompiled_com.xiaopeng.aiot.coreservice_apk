package defpackage;

import java.util.logging.Level;
/* compiled from: BackgroundPoster.java */
/* renamed from: zy  reason: default package */
/* loaded from: classes.dex */
public final class zy implements Runnable, jz {
    public final iz a = new iz();
    public final az b;
    public volatile boolean d;

    public zy(az eventBus) {
        this.b = eventBus;
    }

    @Override // defpackage.jz
    public void a(oz subscription, Object event) {
        hz pendingPost = hz.a(subscription, event);
        synchronized (this) {
            this.a.a(pendingPost);
            if (!this.d) {
                this.d = true;
                this.b.e().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                hz pendingPost = this.a.c(1000);
                if (pendingPost == null) {
                    synchronized (this) {
                        pendingPost = this.a.b();
                        if (pendingPost == null) {
                            return;
                        }
                    }
                }
                this.b.i(pendingPost);
            } catch (InterruptedException e) {
                ez f = this.b.f();
                Level level = Level.WARNING;
                f.b(level, Thread.currentThread().getName() + " was interruppted", e);
                return;
            } finally {
                this.d = false;
            }
        }
    }
}
