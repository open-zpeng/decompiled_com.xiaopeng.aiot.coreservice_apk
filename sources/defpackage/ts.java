package defpackage;
/* compiled from: UndeliverableException.java */
/* renamed from: ts  reason: default package */
/* loaded from: classes.dex */
public final class ts extends IllegalStateException {
    public ts(Throwable cause) {
        super("The exception could not be delivered to the consumer because it has already canceled/disposed the flow or the exception has nowhere to go to begin with. Further reading: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling | " + cause, cause);
    }
}
