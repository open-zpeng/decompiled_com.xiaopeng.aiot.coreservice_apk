package defpackage;

import defpackage.gs;
import java.util.concurrent.ThreadFactory;
/* compiled from: NewThreadScheduler.java */
/* renamed from: ru  reason: default package */
/* loaded from: classes.dex */
public final class ru extends gs {
    public static final tu b;
    public final ThreadFactory c;

    static {
        int priority = Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue()));
        b = new tu("RxNewThreadScheduler", priority);
    }

    public ru() {
        this(b);
    }

    public ru(ThreadFactory threadFactory) {
        this.c = threadFactory;
    }

    @Override // defpackage.gs
    public gs.b a() {
        return new su(this.c);
    }
}
