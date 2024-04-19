package defpackage;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* compiled from: GapWorker.java */
/* renamed from: me  reason: default package */
/* loaded from: classes.dex */
public final class me implements Runnable {
    public static final ThreadLocal<me> a = new ThreadLocal<>();
    public static Comparator<c> b = new a();
    public long f;
    public long g;
    public ArrayList<RecyclerView> d = new ArrayList<>();
    public ArrayList<c> h = new ArrayList<>();

    /* compiled from: GapWorker.java */
    @SuppressLint({"VisibleForTests"})
    /* renamed from: me$b */
    /* loaded from: classes.dex */
    public static class b {
        public int a;
        public int b;
        public int[] c;
        public int d;

        public void a(RecyclerView recyclerView, boolean z) {
            throw null;
        }

        public void b(int i, int i2) {
            throw null;
        }
    }

    /* compiled from: GapWorker.java */
    /* renamed from: me$c */
    /* loaded from: classes.dex */
    public static class c {
        public boolean a;
        public int b;
        public int c;
        public RecyclerView d;
        public int e;

        public void a() {
            this.a = false;
            this.b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.d.add(recyclerView);
    }

    public void f(RecyclerView recyclerView, int prefetchDx, int prefetchDy) {
        if (recyclerView.isAttachedToWindow() && this.f == 0) {
            this.f = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.m0.b(prefetchDx, prefetchDy);
        throw null;
    }

    /* compiled from: GapWorker.java */
    /* renamed from: me$a */
    /* loaded from: classes.dex */
    public class a implements Comparator<c> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c lhs, c rhs) {
            RecyclerView recyclerView = lhs.d;
            if ((recyclerView == null) != (rhs.d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = lhs.a;
            if (z != rhs.a) {
                return z ? -1 : 1;
            }
            int deltaViewVelocity = rhs.b - lhs.b;
            if (deltaViewVelocity != 0) {
                return deltaViewVelocity;
            }
            int deltaDistanceToItem = lhs.c - rhs.c;
            if (deltaDistanceToItem != 0) {
                return deltaDistanceToItem;
            }
            return 0;
        }
    }

    public final void b() {
        c task;
        int viewCount = this.d.size();
        for (int i = 0; i < viewCount; i++) {
            RecyclerView view = this.d.get(i);
            if (view.getWindowVisibility() == 0) {
                view.m0.a(view, false);
                throw null;
            }
        }
        this.h.ensureCapacity(0);
        int totalTaskIndex = 0;
        for (int i2 = 0; i2 < viewCount; i2++) {
            RecyclerView view2 = this.d.get(i2);
            if (view2.getWindowVisibility() == 0) {
                b prefetchRegistry = view2.m0;
                int viewVelocity = Math.abs(prefetchRegistry.a) + Math.abs(prefetchRegistry.b);
                for (int j = 0; j < prefetchRegistry.d * 2; j += 2) {
                    if (totalTaskIndex >= this.h.size()) {
                        task = new c();
                        this.h.add(task);
                    } else {
                        task = this.h.get(totalTaskIndex);
                    }
                    int[] iArr = prefetchRegistry.c;
                    int distanceToItem = iArr[j + 1];
                    task.a = distanceToItem <= viewVelocity;
                    task.b = viewVelocity;
                    task.c = distanceToItem;
                    task.d = view2;
                    task.e = iArr[j];
                    totalTaskIndex++;
                }
            }
        }
        Collections.sort(this.h, b);
    }

    public static boolean e(RecyclerView view, int position) {
        view.p.c();
        throw null;
    }

    public final RecyclerView.w i(RecyclerView view, int position, long deadlineNs) {
        if (e(view, position)) {
            return null;
        }
        RecyclerView.o recycler = view.m;
        try {
            view.T();
            RecyclerView.w holder = recycler.n(position, false, deadlineNs);
            if (holder != null) {
                if (holder.d() && !holder.e()) {
                    recycler.j(holder.b);
                } else {
                    recycler.a(holder, false);
                }
            }
            return holder;
        } finally {
            view.V(false);
        }
    }

    public final void h(RecyclerView innerView, long deadlineNs) {
        if (innerView == null) {
            return;
        }
        if (innerView.M) {
            innerView.p.c();
            throw null;
        }
        b innerPrefetchRegistry = innerView.m0;
        innerPrefetchRegistry.a(innerView, true);
        if (innerPrefetchRegistry.d != 0) {
            try {
                u8.a("RV Nested Prefetch");
                innerView.n0.e(innerView.v);
                throw null;
            } catch (Throwable th) {
                u8.b();
                throw th;
            }
        }
    }

    public final void c(c task, long deadlineNs) {
        long taskDeadlineNs = task.a ? Long.MAX_VALUE : deadlineNs;
        RecyclerView.w holder = i(task.d, task.e, taskDeadlineNs);
        if (holder != null && holder.c != null && holder.d() && !holder.e()) {
            h(holder.c.get(), deadlineNs);
        }
    }

    public final void d(long deadlineNs) {
        for (int i = 0; i < this.h.size(); i++) {
            c task = this.h.get(i);
            if (task.d != null) {
                c(task, deadlineNs);
                task.a();
            } else {
                return;
            }
        }
    }

    public void g(long deadlineNs) {
        b();
        d(deadlineNs);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            u8.a("RV Prefetch");
            if (this.d.isEmpty()) {
                return;
            }
            int size = this.d.size();
            long latestFrameVsyncMs = 0;
            for (int i = 0; i < size; i++) {
                RecyclerView view = this.d.get(i);
                if (view.getWindowVisibility() == 0) {
                    latestFrameVsyncMs = Math.max(view.getDrawingTime(), latestFrameVsyncMs);
                }
            }
            int i2 = (latestFrameVsyncMs > 0L ? 1 : (latestFrameVsyncMs == 0L ? 0 : -1));
            if (i2 == 0) {
                return;
            }
            long nextFrameNs = TimeUnit.MILLISECONDS.toNanos(latestFrameVsyncMs) + this.g;
            g(nextFrameNs);
        } finally {
            this.f = 0L;
            u8.b();
        }
    }
}
