package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: RxThreadFactory.java */
/* renamed from: tu  reason: default package */
/* loaded from: classes.dex */
public final class tu extends AtomicLong implements ThreadFactory {
    public final String a;
    public final int b;
    public final boolean d;

    public tu(String prefix) {
        this(prefix, 5, false);
    }

    public tu(String prefix, int priority) {
        this(prefix, priority, false);
    }

    public tu(String prefix, int priority, boolean nonBlocking) {
        this.a = prefix;
        this.b = priority;
        this.d = nonBlocking;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r) {
        StringBuilder sb = new StringBuilder(this.a);
        sb.append('-');
        StringBuilder nameBuilder = sb.append(incrementAndGet());
        String name = nameBuilder.toString();
        Thread t = this.d ? new a(r, name) : new Thread(r, name);
        t.setPriority(this.b);
        t.setDaemon(true);
        return t;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.a + "]";
    }

    /* compiled from: RxThreadFactory.java */
    /* renamed from: tu$a */
    /* loaded from: classes.dex */
    public static final class a extends Thread {
        public a(Runnable run, String name) {
            super(run, name);
        }
    }
}
