package defpackage;
/* compiled from: EmptyDisposable.java */
/* renamed from: ft  reason: default package */
/* loaded from: classes.dex */
public enum ft implements lt<Object> {
    INSTANCE,
    NEVER;

    @Override // defpackage.ls
    public void a() {
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<?> */
    public static void c(fs<?> fsVar) {
        fsVar.onSubscribe(INSTANCE);
        fsVar.onComplete();
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<?> */
    public static void d(Throwable e, fs<?> fsVar) {
        fsVar.onSubscribe(INSTANCE);
        fsVar.onError(e);
    }

    @Override // defpackage.nt
    public boolean offer(Object value) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // defpackage.nt
    public Object poll() throws Exception {
        return null;
    }

    @Override // defpackage.nt
    public boolean isEmpty() {
        return true;
    }

    @Override // defpackage.nt
    public void clear() {
    }

    @Override // defpackage.mt
    public int b(int mode) {
        return mode & 2;
    }
}
