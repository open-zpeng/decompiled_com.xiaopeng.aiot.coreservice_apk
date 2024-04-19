package defpackage;
/* compiled from: ObservableDoOnLifecycle.java */
/* renamed from: yt  reason: default package */
/* loaded from: classes.dex */
public final class yt<T> extends tt<T, T> {
    public final ys<? super ls> b;
    public final us d;

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<T> */
    /* JADX WARN: Generic types in debug info not equals: ys != io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> */
    /* JADX WARN: Generic types in debug info not equals: yt != io.reactivex.internal.operators.observable.ObservableDoOnLifecycle<T> */
    public yt(bs<T> bsVar, ys<? super ls> ysVar, us onDispose) {
        super(bsVar);
        this.b = ysVar;
        this.d = onDispose;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: yt != io.reactivex.internal.operators.observable.ObservableDoOnLifecycle<T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        this.a.a(new rt(fsVar, this.b, this.d));
    }
}
