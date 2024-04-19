package defpackage;
/* compiled from: PendingPostQueue.java */
/* renamed from: iz  reason: default package */
/* loaded from: classes.dex */
public final class iz {
    public hz a;
    public hz b;

    public synchronized void a(hz pendingPost) {
        try {
            if (pendingPost == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            hz hzVar = this.b;
            if (hzVar != null) {
                hzVar.d = pendingPost;
                this.b = pendingPost;
            } else if (this.a == null) {
                this.b = pendingPost;
                this.a = pendingPost;
            } else {
                throw new IllegalStateException("Head present, but no tail");
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized hz b() {
        hz pendingPost;
        pendingPost = this.a;
        if (pendingPost != null) {
            hz hzVar = pendingPost.d;
            this.a = hzVar;
            if (hzVar == null) {
                this.b = null;
            }
        }
        return pendingPost;
    }

    public synchronized hz c(int maxMillisToWait) throws InterruptedException {
        if (this.a == null) {
            wait(maxMillisToWait);
        }
        return b();
    }
}
