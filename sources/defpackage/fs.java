package defpackage;
/* compiled from: Observer.java */
/* renamed from: fs  reason: default package */
/* loaded from: classes.dex */
public interface fs<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(ls lsVar);
}
