package defpackage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import defpackage.t8;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* compiled from: SpecialEffectsController.java */
/* renamed from: sc  reason: default package */
/* loaded from: classes.dex */
public abstract class sc {
    public final ViewGroup a;
    public final ArrayList<e> b = new ArrayList<>();
    public final ArrayList<e> c = new ArrayList<>();
    public boolean d = false;
    public boolean e = false;

    public abstract void f(List<e> list, boolean z);

    public static sc n(ViewGroup container, dc fragmentManager) {
        tc factory = fragmentManager.y0();
        return o(container, factory);
    }

    public static sc o(ViewGroup container, tc factory) {
        int i = rb.special_effects_controller_view_tag;
        Object controller = container.getTag(i);
        if (controller instanceof sc) {
            return (sc) controller;
        }
        sc newController = factory.a(container);
        container.setTag(i, newController);
        return newController;
    }

    public sc(ViewGroup container) {
        this.a = container;
    }

    public ViewGroup m() {
        return this.a;
    }

    public e.b l(kc fragmentStateManager) {
        e.b lifecycleImpact = null;
        e pendingOperation = h(fragmentStateManager.k());
        if (pendingOperation != null) {
            lifecycleImpact = pendingOperation.g();
        }
        e runningOperation = i(fragmentStateManager.k());
        if (runningOperation != null && (lifecycleImpact == null || lifecycleImpact == e.b.NONE)) {
            return runningOperation.g();
        }
        return lifecycleImpact;
    }

    public final e h(Fragment fragment) {
        Iterator<e> it = this.b.iterator();
        while (it.hasNext()) {
            e operation = it.next();
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    public final e i(Fragment fragment) {
        Iterator<e> it = this.c.iterator();
        while (it.hasNext()) {
            e operation = it.next();
            if (operation.f().equals(fragment) && !operation.h()) {
                return operation;
            }
        }
        return null;
    }

    public void b(e.c finalState, kc fragmentStateManager) {
        if (dc.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        a(finalState, e.b.ADDING, fragmentStateManager);
    }

    public void e(kc fragmentStateManager) {
        if (dc.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.k());
        }
        a(e.c.VISIBLE, e.b.NONE, fragmentStateManager);
    }

    public void c(kc fragmentStateManager) {
        if (dc.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        a(e.c.GONE, e.b.NONE, fragmentStateManager);
    }

    public void d(kc fragmentStateManager) {
        if (dc.F0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, fragmentStateManager);
    }

    public final void a(e.c finalState, e.b lifecycleImpact, kc fragmentStateManager) {
        synchronized (this.b) {
            t8 signal = new t8();
            e existingOperation = h(fragmentStateManager.k());
            if (existingOperation != null) {
                existingOperation.k(finalState, lifecycleImpact);
                return;
            }
            d operation = new d(finalState, lifecycleImpact, fragmentStateManager, signal);
            this.b.add(operation);
            operation.a(new a(operation));
            operation.a(new b(operation));
        }
    }

    /* compiled from: SpecialEffectsController.java */
    /* renamed from: sc$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sc.this.b.contains(this.a)) {
                this.a.e().a(this.a.f().K);
            }
        }
    }

    /* compiled from: SpecialEffectsController.java */
    /* renamed from: sc$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ d a;

        public b(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sc.this.b.remove(this.a);
            sc.this.c.remove(this.a);
        }
    }

    public void r(boolean isPop) {
        this.d = isPop;
    }

    public void p() {
        synchronized (this.b) {
            q();
            this.e = false;
            int index = this.b.size() - 1;
            while (true) {
                if (index < 0) {
                    break;
                }
                e operation = this.b.get(index);
                e.c currentState = e.c.c(operation.f().K);
                e.c e2 = operation.e();
                e.c cVar = e.c.VISIBLE;
                if (e2 != cVar || currentState == cVar) {
                    index--;
                } else {
                    Fragment fragment = operation.f();
                    this.e = fragment.X();
                    break;
                }
            }
        }
    }

    public void k() {
        if (this.e) {
            this.e = false;
            g();
        }
    }

    public void g() {
        if (this.e) {
            return;
        }
        if (!ga.I(this.a)) {
            j();
            this.d = false;
            return;
        }
        synchronized (this.b) {
            if (!this.b.isEmpty()) {
                ArrayList<SpecialEffectsController.Operation> currentlyRunningOperations = new ArrayList<>(this.c);
                this.c.clear();
                Iterator<SpecialEffectsController.Operation> it = currentlyRunningOperations.iterator();
                while (it.hasNext()) {
                    e operation = (e) it.next();
                    if (dc.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                    }
                    operation.b();
                    if (!operation.i()) {
                        this.c.add(operation);
                    }
                }
                q();
                ArrayList<SpecialEffectsController.Operation> newPendingOperations = new ArrayList<>(this.b);
                this.b.clear();
                this.c.addAll(newPendingOperations);
                Iterator<SpecialEffectsController.Operation> it2 = newPendingOperations.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).l();
                }
                f(newPendingOperations, this.d);
                this.d = false;
            }
        }
    }

    public void j() {
        String str;
        String str2;
        boolean attachedToWindow = ga.I(this.a);
        synchronized (this.b) {
            q();
            Iterator<e> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            ArrayList<SpecialEffectsController.Operation> runningOperations = new ArrayList<>(this.c);
            Iterator<SpecialEffectsController.Operation> it2 = runningOperations.iterator();
            while (it2.hasNext()) {
                e operation = (e) it2.next();
                if (dc.F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (attachedToWindow) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(operation);
                    Log.v("FragmentManager", sb.toString());
                }
                operation.b();
            }
            ArrayList<SpecialEffectsController.Operation> pendingOperations = new ArrayList<>(this.b);
            Iterator<SpecialEffectsController.Operation> it3 = pendingOperations.iterator();
            while (it3.hasNext()) {
                e operation2 = (e) it3.next();
                if (dc.F0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (attachedToWindow) {
                        str = "";
                    } else {
                        str = "Container " + this.a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(operation2);
                    Log.v("FragmentManager", sb2.toString());
                }
                operation2.b();
            }
        }
    }

    public final void q() {
        Iterator<e> it = this.b.iterator();
        while (it.hasNext()) {
            e operation = it.next();
            if (operation.g() == e.b.ADDING) {
                Fragment fragment = operation.f();
                View view = fragment.j1();
                e.c finalState = e.c.b(view.getVisibility());
                operation.k(finalState, e.b.NONE);
            }
        }
    }

    /* compiled from: SpecialEffectsController.java */
    /* renamed from: sc$e */
    /* loaded from: classes.dex */
    public static class e {
        public c a;
        public b b;
        public final Fragment c;
        public final List<Runnable> d = new ArrayList();
        public final HashSet<t8> e = new HashSet<>();
        public boolean f = false;
        public boolean g = false;

        /* compiled from: SpecialEffectsController.java */
        /* renamed from: sc$e$b */
        /* loaded from: classes.dex */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        /* compiled from: SpecialEffectsController.java */
        /* renamed from: sc$e$c */
        /* loaded from: classes.dex */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static c c(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return b(view.getVisibility());
            }

            public static c b(int visibility) {
                switch (visibility) {
                    case 0:
                        return VISIBLE;
                    case 4:
                        return INVISIBLE;
                    case 8:
                        return GONE;
                    default:
                        throw new IllegalArgumentException("Unknown visibility " + visibility);
                }
            }

            public void a(View view) {
                switch (c.a[ordinal()]) {
                    case 1:
                        ViewGroup parent = (ViewGroup) view.getParent();
                        if (parent != null) {
                            if (dc.F0(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + parent);
                            }
                            parent.removeView(view);
                            return;
                        }
                        return;
                    case 2:
                        if (dc.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                        }
                        view.setVisibility(0);
                        return;
                    case 3:
                        if (dc.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                        }
                        view.setVisibility(8);
                        return;
                    case 4:
                        if (dc.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                        }
                        view.setVisibility(4);
                        return;
                    default:
                        return;
                }
            }
        }

        public e(c finalState, b lifecycleImpact, Fragment fragment, t8 cancellationSignal) {
            this.a = finalState;
            this.b = lifecycleImpact;
            this.c = fragment;
            cancellationSignal.c(new a());
        }

        /* compiled from: SpecialEffectsController.java */
        /* renamed from: sc$e$a */
        /* loaded from: classes.dex */
        public class a implements t8.a {
            public a() {
            }

            @Override // defpackage.t8.a
            public void a() {
                e.this.b();
            }
        }

        public c e() {
            return this.a;
        }

        public b g() {
            return this.b;
        }

        public final Fragment f() {
            return this.c;
        }

        public final boolean h() {
            return this.f;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.a + "} {mLifecycleImpact = " + this.b + "} {mFragment = " + this.c + "}";
        }

        public final void b() {
            if (h()) {
                return;
            }
            this.f = true;
            if (this.e.isEmpty()) {
                c();
                return;
            }
            ArrayList<CancellationSignal> signals = new ArrayList<>(this.e);
            Iterator<CancellationSignal> it = signals.iterator();
            while (it.hasNext()) {
                t8 signal = (t8) it.next();
                signal.a();
            }
        }

        public final void k(c finalState, b lifecycleImpact) {
            switch (c.b[lifecycleImpact.ordinal()]) {
                case 1:
                    if (this.a == c.REMOVED) {
                        if (dc.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.b + " to ADDING.");
                        }
                        this.a = c.VISIBLE;
                        this.b = b.ADDING;
                        return;
                    }
                    return;
                case 2:
                    if (dc.F0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> REMOVED. mLifecycleImpact  = " + this.b + " to REMOVING.");
                    }
                    this.a = c.REMOVED;
                    this.b = b.REMOVING;
                    return;
                case 3:
                    if (this.a != c.REMOVED) {
                        if (dc.F0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> " + finalState + ". ");
                        }
                        this.a = finalState;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final void a(Runnable listener) {
            this.d.add(listener);
        }

        public void l() {
        }

        public final void j(t8 signal) {
            l();
            this.e.add(signal);
        }

        public final void d(t8 signal) {
            if (this.e.remove(signal) && this.e.isEmpty()) {
                c();
            }
        }

        public final boolean i() {
            return this.g;
        }

        public void c() {
            if (this.g) {
                return;
            }
            if (dc.F0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            for (Runnable listener : this.d) {
                listener.run();
            }
        }
    }

    /* compiled from: SpecialEffectsController.java */
    /* renamed from: sc$c */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[e.b.values().length];
            b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* compiled from: SpecialEffectsController.java */
    /* renamed from: sc$d */
    /* loaded from: classes.dex */
    public static class d extends e {
        public final kc h;

        public d(e.c finalState, e.b lifecycleImpact, kc fragmentStateManager, t8 cancellationSignal) {
            super(finalState, lifecycleImpact, fragmentStateManager.k(), cancellationSignal);
            this.h = fragmentStateManager;
        }

        @Override // defpackage.sc.e
        public void l() {
            if (g() == e.b.ADDING) {
                Fragment fragment = this.h.k();
                View focusedView = fragment.K.findFocus();
                if (focusedView != null) {
                    fragment.r1(focusedView);
                    if (dc.F0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + focusedView + " for Fragment " + fragment);
                    }
                }
                View view = f().j1();
                if (view.getParent() == null) {
                    this.h.b();
                    view.setAlpha(0.0f);
                }
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    view.setVisibility(4);
                }
                view.setAlpha(fragment.G());
            }
        }

        @Override // defpackage.sc.e
        public void c() {
            super.c();
            this.h.m();
        }
    }
}
