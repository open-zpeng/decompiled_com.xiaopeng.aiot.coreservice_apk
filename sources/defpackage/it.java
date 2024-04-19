package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SequentialDisposable.java */
/* renamed from: it  reason: default package */
/* loaded from: classes.dex */
public final class it extends AtomicReference<ls> implements ls {
    public boolean c(ls next) {
        return et.d(this, next);
    }

    @Override // defpackage.ls
    public void a() {
        et.b(this);
    }

    public boolean b() {
        return et.c(get());
    }
}
