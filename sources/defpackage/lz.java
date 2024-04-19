package defpackage;
/* compiled from: SubscriberExceptionEvent.java */
/* renamed from: lz  reason: default package */
/* loaded from: classes.dex */
public final class lz {
    public final az a;
    public final Throwable b;
    public final Object c;
    public final Object d;

    public lz(az eventBus, Throwable throwable, Object causingEvent, Object causingSubscriber) {
        this.a = eventBus;
        this.b = throwable;
        this.c = causingEvent;
        this.d = causingSubscriber;
    }
}
