package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: AtomicThrowable.java */
/* renamed from: av  reason: default package */
/* loaded from: classes.dex */
public final class av extends AtomicReference<Throwable> {
    public boolean a(Throwable t) {
        return cv.a(this, t);
    }

    public Throwable b() {
        return cv.b(this);
    }
}
