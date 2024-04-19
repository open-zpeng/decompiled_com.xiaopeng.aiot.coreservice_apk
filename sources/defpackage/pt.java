package defpackage;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: BasicIntQueueDisposable.java */
/* renamed from: pt  reason: default package */
/* loaded from: classes.dex */
public abstract class pt<T> extends AtomicInteger implements lt<T> {
    /* JADX WARN: Generic types in debug info not equals: pt != io.reactivex.internal.observers.BasicIntQueueDisposable<T> */
    @Override // defpackage.nt
    public final boolean offer(T e) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
