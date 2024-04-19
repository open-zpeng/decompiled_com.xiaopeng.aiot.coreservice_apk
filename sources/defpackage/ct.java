package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CancellableDisposable.java */
/* renamed from: ct  reason: default package */
/* loaded from: classes.dex */
public final class ct extends AtomicReference<xs> implements ls {
    public ct(xs cancellable) {
        super(cancellable);
    }

    @Override // defpackage.ls
    public void a() {
        xs c;
        if (get() != null && (c = getAndSet(null)) != null) {
            try {
                c.cancel();
            } catch (Exception ex) {
                qs.b(ex);
                iv.m(ex);
            }
        }
    }
}
