package defpackage;
/* compiled from: Disposables.java */
/* renamed from: ms  reason: default package */
/* loaded from: classes.dex */
public final class ms {
    public static ls b(Runnable run) {
        kt.d(run, "run is null");
        return new os(run);
    }

    public static ls a() {
        return ft.INSTANCE;
    }
}
