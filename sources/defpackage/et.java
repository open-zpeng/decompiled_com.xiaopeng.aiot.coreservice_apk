package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: DisposableHelper.java */
/* renamed from: et  reason: default package */
/* loaded from: classes.dex */
public enum et implements ls {
    DISPOSED;

    public static boolean c(ls d) {
        return d == DISPOSED;
    }

    public static boolean f(AtomicReference<ls> atomicReference, ls d) {
        ls current;
        do {
            current = atomicReference.get();
            if (current == DISPOSED) {
                if (d != null) {
                    d.a();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(current, d));
        if (current != null) {
            current.a();
            return true;
        }
        return true;
    }

    public static boolean g(AtomicReference<ls> atomicReference, ls d) {
        kt.d(d, "d is null");
        if (!atomicReference.compareAndSet(null, d)) {
            d.a();
            if (atomicReference.get() != DISPOSED) {
                e();
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean d(AtomicReference<ls> atomicReference, ls d) {
        ls current;
        do {
            current = atomicReference.get();
            if (current == DISPOSED) {
                if (d != null) {
                    d.a();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(current, d));
        return true;
    }

    public static boolean b(AtomicReference<ls> atomicReference) {
        ls current = atomicReference.get();
        ls d = DISPOSED;
        if (current != d) {
            ls current2 = atomicReference.getAndSet(d);
            ls current3 = current2;
            if (current3 != d) {
                if (current3 != null) {
                    current3.a();
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean h(ls current, ls next) {
        if (next == null) {
            iv.m(new NullPointerException("next is null"));
            return false;
        } else if (current != null) {
            next.a();
            e();
            return false;
        } else {
            return true;
        }
    }

    public static void e() {
        iv.m(new ss("Disposable already set!"));
    }

    @Override // defpackage.ls
    public void a() {
    }
}
