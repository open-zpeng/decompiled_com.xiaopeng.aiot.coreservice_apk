package defpackage;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: SpscLinkedArrayQueue.java */
/* renamed from: nu  reason: default package */
/* loaded from: classes.dex */
public final class nu<T> implements nt {
    public static final int a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object b = new Object();
    public int f;
    public long g;
    public final int h;
    public AtomicReferenceArray<Object> i;
    public final int j;
    public AtomicReferenceArray<Object> k;
    public final AtomicLong d = new AtomicLong();
    public final AtomicLong l = new AtomicLong();

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public nu(int bufferSize) {
        int p2capacity = fv.a(Math.max(8, bufferSize));
        int mask = p2capacity - 1;
        AtomicReferenceArray<Object> buffer = new AtomicReferenceArray<>(p2capacity + 1);
        this.i = buffer;
        this.h = mask;
        a(p2capacity);
        this.k = buffer;
        this.j = mask;
        this.g = mask - 1;
        p(0L);
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    @Override // defpackage.nt
    public boolean offer(T e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> buffer = this.i;
        long index = f();
        int mask = this.h;
        int offset = d(index, mask);
        if (index < this.g) {
            return q(buffer, e, index, offset);
        }
        int lookAheadStep = this.f;
        int lookAheadElementOffset = d(lookAheadStep + index, mask);
        if (h(buffer, lookAheadElementOffset) == null) {
            this.g = (lookAheadStep + index) - 1;
            return q(buffer, e, index, offset);
        } else if (h(buffer, d(1 + index, mask)) == null) {
            return q(buffer, e, index, offset);
        } else {
            l(buffer, index, offset, e, mask);
            return true;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public final boolean q(AtomicReferenceArray<Object> buffer, T e, long index, int offset) {
        n(buffer, offset, e);
        p(1 + index);
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public final void l(AtomicReferenceArray<Object> oldBuffer, long currIndex, int offset, T e, long mask) {
        int capacity = oldBuffer.length();
        AtomicReferenceArray<Object> newBuffer = new AtomicReferenceArray<>(capacity);
        this.i = newBuffer;
        this.g = (currIndex + mask) - 1;
        n(newBuffer, offset, e);
        o(oldBuffer, newBuffer);
        n(oldBuffer, offset, b);
        p(1 + currIndex);
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public final void o(AtomicReferenceArray<Object> curr, AtomicReferenceArray<Object> next) {
        n(curr, c(curr.length() - 1), next);
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public final AtomicReferenceArray<Object> i(AtomicReferenceArray<Object> curr, int nextIndex) {
        int nextOffset = c(nextIndex);
        AtomicReferenceArray<Object> nextBuffer = (AtomicReferenceArray) h(curr, nextOffset);
        n(curr, nextOffset, null);
        return nextBuffer;
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    @Override // defpackage.nt
    public T poll() {
        AtomicReferenceArray<Object> buffer = this.k;
        long index = e();
        int mask = this.j;
        int offset = d(index, mask);
        T t = (T) h(buffer, offset);
        boolean isNextBuffer = t == b;
        if (t != null && !isNextBuffer) {
            n(buffer, offset, null);
            m(1 + index);
            return t;
        } else if (!isNextBuffer) {
            return null;
        } else {
            return k(i(buffer, mask + 1), index, mask);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public final T k(AtomicReferenceArray<Object> nextBuffer, long index, int mask) {
        this.k = nextBuffer;
        int offsetInNew = d(index, mask);
        T n = (T) h(nextBuffer, offsetInNew);
        if (n != null) {
            n(nextBuffer, offsetInNew, null);
            m(1 + index);
        }
        return n;
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    @Override // defpackage.nt
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    @Override // defpackage.nt
    public boolean isEmpty() {
        return j() == g();
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public final void a(int capacity) {
        this.f = Math.min(capacity / 4, a);
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public final long j() {
        return this.d.get();
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public final long g() {
        return this.l.get();
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public final long f() {
        return this.d.get();
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public final long e() {
        return this.l.get();
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public final void p(long v) {
        this.d.lazySet(v);
    }

    /* JADX WARN: Generic types in debug info not equals: nu != io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
    public final void m(long v) {
        this.l.lazySet(v);
    }

    public static int d(long index, int mask) {
        return c(((int) index) & mask);
    }

    public static int c(int index) {
        return index;
    }

    public static void n(AtomicReferenceArray<Object> buffer, int offset, Object e) {
        buffer.lazySet(offset, e);
    }

    public static <E> Object h(AtomicReferenceArray<Object> buffer, int offset) {
        return buffer.get(offset);
    }
}
