package defpackage;
/* compiled from: OnErrorNotImplementedException.java */
/* renamed from: rs  reason: default package */
/* loaded from: classes.dex */
public final class rs extends RuntimeException {
    public rs(String message, Throwable e) {
        super(message, e != null ? e : new NullPointerException());
    }

    public rs(Throwable e) {
        this("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + e, e);
    }
}
