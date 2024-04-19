package defpackage;
/* compiled from: AsyncPoster.java */
/* renamed from: yy  reason: default package */
/* loaded from: classes.dex */
public class yy implements Runnable, jz {
    public final iz a = new iz();
    public final az b;

    public yy(az eventBus) {
        this.b = eventBus;
    }

    @Override // defpackage.jz
    public void a(oz subscription, Object event) {
        hz pendingPost = hz.a(subscription, event);
        this.a.a(pendingPost);
        this.b.e().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        hz pendingPost = this.a.b();
        if (pendingPost == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.b.i(pendingPost);
    }
}
