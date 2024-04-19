package defpackage;

import defpackage.gi;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: ReuseItemPool.java */
/* renamed from: hi  reason: default package */
/* loaded from: classes.dex */
public class hi<T extends gi> {
    public static AtomicLong a = new AtomicLong(0);
    public static AtomicLong b = new AtomicLong(0);
    public final int f = 20;
    public Integer e = null;
    public AtomicLong c = new AtomicLong(0);
    public AtomicLong d = new AtomicLong(0);
    public ConcurrentLinkedQueue<T> g = new ConcurrentLinkedQueue<>();
    public Set<Integer> h = new HashSet();

    public T a() {
        a.getAndIncrement();
        this.c.getAndIncrement();
        T poll = this.g.poll();
        if (poll != null) {
            this.h.remove(Integer.valueOf(System.identityHashCode(poll)));
            this.d.getAndIncrement();
            b.getAndIncrement();
        }
        return poll;
    }

    public void b(T t) {
        t.clean();
        if (this.g.size() < 20) {
            synchronized (this.h) {
                int identityHashCode = System.identityHashCode(t);
                if (!this.h.contains(Integer.valueOf(identityHashCode))) {
                    this.h.add(Integer.valueOf(identityHashCode));
                    this.g.offer(t);
                }
            }
        }
    }
}
