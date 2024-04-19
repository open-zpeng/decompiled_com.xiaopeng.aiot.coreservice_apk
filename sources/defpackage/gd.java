package defpackage;

import android.annotation.SuppressLint;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleRegistry;
import defpackage.cd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* compiled from: LifecycleRegistry.java */
/* renamed from: gd  reason: default package */
/* loaded from: classes.dex */
public class gd extends cd {
    public k3<ed, a> b;
    public cd.c c;
    public final WeakReference<fd> d;
    public int e;
    public boolean f;
    public boolean g;
    public ArrayList<cd.c> h;
    public final boolean i;

    public gd(fd provider) {
        this(provider, true);
    }

    public gd(fd provider, boolean enforceMainThread) {
        this.b = new k3<>();
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = new ArrayList<>();
        this.d = new WeakReference<>(provider);
        this.c = cd.c.INITIALIZED;
        this.i = enforceMainThread;
    }

    @Deprecated
    public void j(cd.c state) {
        f("markState");
        o(state);
    }

    public void o(cd.c state) {
        f("setCurrentState");
        l(state);
    }

    public void h(cd.b event) {
        f("handleLifecycleEvent");
        l(event.b());
    }

    public final void l(cd.c next) {
        if (this.c == next) {
            return;
        }
        this.c = next;
        if (this.f || this.e != 0) {
            this.g = true;
            return;
        }
        this.f = true;
        p();
        this.f = false;
    }

    public final boolean i() {
        if (this.b.size() == 0) {
            return true;
        }
        cd.c eldestObserverState = this.b.a().getValue().a;
        cd.c newestObserverState = this.b.d().getValue().a;
        return eldestObserverState == newestObserverState && this.c == newestObserverState;
    }

    public final cd.c e(ed observer) {
        Map.Entry<ed, a> h = this.b.h(observer);
        cd.c parentState = null;
        cd.c siblingState = h != null ? h.getValue().a : null;
        if (!this.h.isEmpty()) {
            ArrayList<cd.c> arrayList = this.h;
            parentState = arrayList.get(arrayList.size() - 1);
        }
        return k(k(this.c, siblingState), parentState);
    }

    @Override // defpackage.cd
    public void a(ed observer) {
        fd lifecycleOwner;
        f("addObserver");
        cd.c cVar = this.c;
        cd.c cVar2 = cd.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = cd.c.INITIALIZED;
        }
        cd.c initialState = cVar2;
        a statefulObserver = new a(observer, initialState);
        a previous = this.b.f(observer, statefulObserver);
        if (previous != null || (lifecycleOwner = this.d.get()) == null) {
            return;
        }
        boolean isReentrance = this.e != 0 || this.f;
        cd.c targetState = e(observer);
        this.e++;
        while (statefulObserver.a.compareTo(targetState) < 0 && this.b.contains(observer)) {
            n(statefulObserver.a);
            cd.b event = cd.b.c(statefulObserver.a);
            if (event == null) {
                throw new IllegalStateException("no event up from " + statefulObserver.a);
            }
            statefulObserver.a(lifecycleOwner, event);
            m();
            targetState = e(observer);
        }
        if (!isReentrance) {
            p();
        }
        this.e--;
    }

    public final void m() {
        ArrayList<cd.c> arrayList = this.h;
        arrayList.remove(arrayList.size() - 1);
    }

    public final void n(cd.c state) {
        this.h.add(state);
    }

    @Override // defpackage.cd
    public void c(ed observer) {
        f("removeObserver");
        this.b.g(observer);
    }

    @Override // defpackage.cd
    public cd.c b() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(fd lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, LifecycleRegistry.ObserverWithState>> ascendingIterator = this.b.c();
        while (ascendingIterator.hasNext() && !this.g) {
            Map.Entry<LifecycleObserver, LifecycleRegistry.ObserverWithState> entry = ascendingIterator.next();
            a observer = (a) entry.getValue();
            while (observer.a.compareTo(this.c) < 0 && !this.g && this.b.contains(entry.getKey())) {
                n(observer.a);
                cd.b event = cd.b.c(observer.a);
                if (event == null) {
                    throw new IllegalStateException("no event up from " + observer.a);
                }
                observer.a(lifecycleOwner, event);
                m();
            }
        }
    }

    public final void d(fd lifecycleOwner) {
        Iterator<Map.Entry<ed, a>> descendingIterator = this.b.descendingIterator();
        while (descendingIterator.hasNext() && !this.g) {
            Map.Entry<ed, a> next = descendingIterator.next();
            a observer = next.getValue();
            while (observer.a.compareTo(this.c) > 0 && !this.g && this.b.contains(next.getKey())) {
                cd.b event = cd.b.a(observer.a);
                if (event == null) {
                    throw new IllegalStateException("no event down from " + observer.a);
                }
                n(event.b());
                observer.a(lifecycleOwner, event);
                m();
            }
        }
    }

    public final void p() {
        fd lifecycleOwner = this.d.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!i()) {
            this.g = false;
            if (this.c.compareTo(this.b.a().getValue().a) < 0) {
                d(lifecycleOwner);
            }
            Map.Entry<ed, a> d = this.b.d();
            if (!this.g && d != null && this.c.compareTo(d.getValue().a) > 0) {
                g(lifecycleOwner);
            }
        }
        this.g = false;
    }

    @SuppressLint({"RestrictedApi"})
    public final void f(String methodName) {
        if (this.i && !h3.d().b()) {
            throw new IllegalStateException("Method " + methodName + " must be called on the main thread");
        }
    }

    public static cd.c k(cd.c state1, cd.c state2) {
        return (state2 == null || state2.compareTo(state1) >= 0) ? state1 : state2;
    }

    /* compiled from: LifecycleRegistry.java */
    /* renamed from: gd$a */
    /* loaded from: classes.dex */
    public static class a {
        public cd.c a;
        public dd b;

        public a(ed observer, cd.c initialState) {
            this.b = id.f(observer);
            this.a = initialState;
        }

        public void a(fd owner, cd.b event) {
            cd.c newState = event.b();
            this.a = gd.k(this.a, newState);
            this.b.d(owner, event);
            this.a = newState;
        }
    }
}
