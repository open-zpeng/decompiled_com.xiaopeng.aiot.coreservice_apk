package defpackage;
/* compiled from: ObservableFromUnsafeSource.java */
/* renamed from: cu  reason: default package */
/* loaded from: classes.dex */
public final class cu<T> extends bs<T> {
    public final es<T> a;

    /* JADX WARN: Generic types in debug info not equals: cu != io.reactivex.internal.operators.observable.ObservableFromUnsafeSource<T> */
    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<T> */
    public cu(es<T> esVar) {
        this.a = esVar;
    }

    /* JADX WARN: Generic types in debug info not equals: cu != io.reactivex.internal.operators.observable.ObservableFromUnsafeSource<T> */
    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        this.a.a(fsVar);
    }
}
