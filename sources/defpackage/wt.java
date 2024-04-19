package defpackage;

import java.util.concurrent.Callable;
/* compiled from: ObservableDefer.java */
/* renamed from: wt  reason: default package */
/* loaded from: classes.dex */
public final class wt<T> extends bs<T> {
    public final Callable<? extends es<? extends T>> a;

    /* JADX WARN: Generic types in debug info not equals: wt != io.reactivex.internal.operators.observable.ObservableDefer<T> */
    public wt(Callable<? extends es<? extends T>> callable) {
        this.a = callable;
    }

    /* JADX WARN: Generic types in debug info not equals: es != io.reactivex.ObservableSource<? extends T> */
    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: wt != io.reactivex.internal.operators.observable.ObservableDefer<T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        try {
            ((es) kt.d(this.a.call(), "null ObservableSource supplied")).a(fsVar);
        } catch (Throwable t) {
            qs.b(t);
            ft.d(t, fsVar);
        }
    }
}
