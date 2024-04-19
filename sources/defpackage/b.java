package defpackage;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: OnBackPressedCallback.java */
/* renamed from: b  reason: default package */
/* loaded from: classes.dex */
public abstract class b {
    public boolean a;
    public CopyOnWriteArrayList<a> b = new CopyOnWriteArrayList<>();

    public abstract void b();

    public b(boolean enabled) {
        this.a = enabled;
    }

    public final void f(boolean enabled) {
        this.a = enabled;
    }

    public final boolean c() {
        return this.a;
    }

    public final void d() {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            a cancellable = it.next();
            cancellable.cancel();
        }
    }

    public void a(a cancellable) {
        this.b.add(cancellable);
    }

    public void e(a cancellable) {
        this.b.remove(cancellable);
    }
}
