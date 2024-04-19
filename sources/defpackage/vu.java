package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: ScheduledRunnable.java */
/* renamed from: vu  reason: default package */
/* loaded from: classes.dex */
public final class vu extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, ls {
    public static final Object a = new Object();
    public static final Object b = new Object();
    public static final Object d = new Object();
    public static final Object f = new Object();
    public final Runnable g;

    public vu(Runnable actual, dt parent) {
        super(3);
        this.g = actual;
        lazySet(0, parent);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object o;
        Object obj;
        Object obj2;
        boolean compareAndSet;
        Object o2;
        Object o3;
        lazySet(2, Thread.currentThread());
        try {
            this.g.run();
        } finally {
            try {
                lazySet(2, null);
                o2 = get(0);
                if (o2 != a) {
                    ((dt) o2).b(this);
                }
                do {
                    o3 = get(1);
                    if (o3 != b) {
                        return;
                    }
                    return;
                } while (!compareAndSet(1, o3, f));
            } catch (Throwable th) {
                do {
                    if (o == obj) {
                        break;
                    } else if (o == obj2) {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        lazySet(2, null);
        o2 = get(0);
        if (o2 != a && compareAndSet(0, o2, f) && o2 != null) {
            ((dt) o2).b(this);
        }
        do {
            o3 = get(1);
            if (o3 != b || o3 == d) {
                return;
            }
        } while (!compareAndSet(1, o3, f));
    }

    public void b(Future<?> f2) {
        Object o;
        do {
            o = get(1);
            if (o == f) {
                return;
            }
            if (o == b) {
                f2.cancel(false);
                return;
            } else if (o == d) {
                f2.cancel(true);
                return;
            }
        } while (!compareAndSet(1, o, f2));
    }

    @Override // defpackage.ls
    public void a() {
        Object o;
        Object obj;
        Object obj2;
        Object obj3;
        while (true) {
            Object o2 = get(1);
            if (o2 == f || o2 == (obj2 = b) || o2 == (obj3 = d)) {
                break;
            }
            boolean async = get(2) != Thread.currentThread();
            if (async) {
                obj2 = obj3;
            }
            if (compareAndSet(1, o2, obj2)) {
                if (o2 != null) {
                    ((Future) o2).cancel(async);
                }
            }
        }
        do {
            o = get(0);
            if (o == f || o == (obj = a) || o == null) {
                return;
            }
        } while (!compareAndSet(0, o, obj));
        ((dt) o).b(this);
    }
}
