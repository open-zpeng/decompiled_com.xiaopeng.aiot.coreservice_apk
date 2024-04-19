package defpackage;
/* compiled from: RunnableDisposable.java */
/* renamed from: os  reason: default package */
/* loaded from: classes.dex */
public final class os extends ns<Runnable> {
    public os(Runnable value) {
        super(value);
    }

    @Override // defpackage.ns
    /* renamed from: d */
    public void c(Runnable value) {
        value.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + b() + ", " + get() + ")";
    }
}
