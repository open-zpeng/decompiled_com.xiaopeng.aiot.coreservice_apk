package defpackage;
/* compiled from: Subscription.java */
/* renamed from: oz  reason: default package */
/* loaded from: classes.dex */
public final class oz {
    public final Object a;
    public final mz b;
    public volatile boolean c = true;

    public oz(Object subscriber, mz subscriberMethod) {
        this.a = subscriber;
        this.b = subscriberMethod;
    }

    public boolean equals(Object other) {
        if (other instanceof oz) {
            oz otherSubscription = (oz) other;
            return this.a == otherSubscription.a && this.b.equals(otherSubscription.b);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.f.hashCode();
    }
}
