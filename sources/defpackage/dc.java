package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.SpecialEffectsController;
import defpackage.cd;
import defpackage.mc;
import defpackage.nc;
import defpackage.wb;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: FragmentManager.java */
/* renamed from: dc  reason: default package */
/* loaded from: classes.dex */
public abstract class dc {
    public static boolean a = false;
    public static boolean b = true;
    public defpackage.h<Intent> B;
    public defpackage.h<?> C;
    public defpackage.h<String[]> D;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public ArrayList<tb> K;
    public ArrayList<Boolean> L;
    public ArrayList<Fragment> M;
    public ArrayList<p> N;
    public gc O;
    public boolean d;
    public ArrayList<tb> f;
    public ArrayList<Fragment> g;
    public OnBackPressedDispatcher i;
    public ArrayList<n> n;
    public ac<?> t;
    public xb u;
    public Fragment v;
    public Fragment w;
    public final ArrayList<o> c = new ArrayList<>();
    public final lc e = new lc();
    public final bc h = new bc(this);
    public final defpackage.b j = new c(false);
    public final AtomicInteger k = new AtomicInteger();
    public final Map<String, Bundle> l = Collections.synchronizedMap(new HashMap());
    public final Map<String, ?> m = Collections.synchronizedMap(new HashMap());
    public Map<Fragment, HashSet<t8>> o = Collections.synchronizedMap(new HashMap());
    public final nc.g p = new d();
    public final cc q = new cc(this);
    public final CopyOnWriteArrayList<hc> r = new CopyOnWriteArrayList<>();
    public int s = -1;
    public zb x = null;
    public zb y = new e();
    public tc z = null;
    public tc A = new f();
    public ArrayDeque<m> E = new ArrayDeque<>();
    public Runnable P = new g();

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$l */
    /* loaded from: classes.dex */
    public static abstract class l {
        @Deprecated
        public abstract void a(dc dcVar, Fragment fragment, Bundle bundle);

        public abstract void b(dc dcVar, Fragment fragment, Context context);

        public abstract void c(dc dcVar, Fragment fragment, Bundle bundle);

        public abstract void d(dc dcVar, Fragment fragment);

        public abstract void e(dc dcVar, Fragment fragment);

        public abstract void f(dc dcVar, Fragment fragment);

        public abstract void g(dc dcVar, Fragment fragment, Context context);

        public abstract void h(dc dcVar, Fragment fragment, Bundle bundle);

        public abstract void i(dc dcVar, Fragment fragment);

        public abstract void j(dc dcVar, Fragment fragment, Bundle bundle);

        public abstract void k(dc dcVar, Fragment fragment);

        public abstract void l(dc dcVar, Fragment fragment);

        public abstract void m(dc dcVar, Fragment fragment, View view, Bundle bundle);

        public abstract void n(dc dcVar, Fragment fragment);
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$n */
    /* loaded from: classes.dex */
    public interface n {
        void a();
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$o */
    /* loaded from: classes.dex */
    public interface o {
        boolean a(ArrayList<tb> arrayList, ArrayList<Boolean> arrayList2);
    }

    public static boolean F0(int level) {
        return a || Log.isLoggable("FragmentManager", level);
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$c */
    /* loaded from: classes.dex */
    public class c extends defpackage.b {
        public c(boolean arg0) {
            super(arg0);
        }

        @Override // defpackage.b
        public void b() {
            dc.this.B0();
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$d */
    /* loaded from: classes.dex */
    public class d implements nc.g {
        public d() {
        }

        @Override // defpackage.nc.g
        public void b(Fragment fragment, t8 signal) {
            dc.this.f(fragment, signal);
        }

        @Override // defpackage.nc.g
        public void a(Fragment f, t8 signal) {
            if (!signal.b()) {
                dc.this.X0(f, signal);
            }
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$e */
    /* loaded from: classes.dex */
    public class e extends zb {
        public e() {
        }

        @Override // defpackage.zb
        public Fragment a(ClassLoader classLoader, String className) {
            return dc.this.t0().e(dc.this.t0().k(), className, null);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$f */
    /* loaded from: classes.dex */
    public class f implements tc {
        public f() {
        }

        @Override // defpackage.tc
        public sc a(ViewGroup container) {
            return new vb(container);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$g */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            dc.this.a0(true);
        }
    }

    public mc l() {
        return new tb(this);
    }

    public boolean e0() {
        boolean updates = a0(true);
        k0();
        return updates;
    }

    public final void l1() {
        synchronized (this.c) {
            boolean z = true;
            if (!this.c.isEmpty()) {
                this.j.f(true);
            } else {
                this.j.f((m0() <= 0 || !I0(this.v)) ? false : false);
            }
        }
    }

    public boolean I0(Fragment parent) {
        if (parent == null) {
            return true;
        }
        dc parentFragmentManager = parent.v;
        Fragment primaryNavigationFragment = parentFragmentManager.x0();
        return parent.equals(primaryNavigationFragment) && I0(parentFragmentManager.v);
    }

    public boolean H0(Fragment parent) {
        if (parent == null) {
            return true;
        }
        return parent.W();
    }

    public void B0() {
        a0(true);
        if (this.j.c()) {
            T0();
        } else {
            this.i.c();
        }
    }

    public boolean T0() {
        return U0(null, -1, 0);
    }

    public final boolean U0(String name, int id, int flags) {
        a0(false);
        Z(true);
        Fragment fragment = this.w;
        if (fragment != null && id < 0 && name == null) {
            dc childManager = fragment.o();
            if (childManager.T0()) {
                return true;
            }
        }
        boolean executePop = V0(this.K, this.L, name, id, flags);
        if (executePop) {
            this.d = true;
            try {
                Z0(this.K, this.L);
            } finally {
                p();
            }
        }
        l1();
        V();
        this.e.b();
        return executePop;
    }

    public int m0() {
        ArrayList<tb> arrayList = this.f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void f(Fragment f2, t8 signal) {
        if (this.o.get(f2) == null) {
            this.o.put(f2, new HashSet<>());
        }
        this.o.get(f2).add(signal);
    }

    public void X0(Fragment f2, t8 signal) {
        HashSet<t8> hashSet = this.o.get(f2);
        if (hashSet != null && hashSet.remove(signal) && hashSet.isEmpty()) {
            this.o.remove(f2);
            if (f2.b < 5) {
                w(f2);
                O0(f2);
            }
        }
    }

    public final void q(String requestKey) {
        this.l.remove(requestKey);
    }

    public static Fragment z0(View view) {
        Object tag = view.getTag(rb.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public void R0(FragmentContainerView container) {
        View view;
        for (kc fragmentStateManager : this.e.k()) {
            Fragment fragment = fragmentStateManager.k();
            if (fragment.A == container.getId() && (view = fragment.K) != null && view.getParent() == null) {
                fragment.J = container;
                fragmentStateManager.b();
            }
        }
    }

    public List<Fragment> s0() {
        return this.e.n();
    }

    public rd A0(Fragment f2) {
        return this.O.k(f2);
    }

    public final gc n0(Fragment f2) {
        return this.O.h(f2);
    }

    public boolean E0() {
        return this.I;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.v;
        if (fragment != null) {
            Class<?> cls = fragment.getClass();
            sb.append(cls.getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.v)));
            sb.append("}");
        } else {
            ac<?> acVar = this.t;
            if (acVar != null) {
                Class<?> cls2 = acVar.getClass();
                sb.append(cls2.getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.t)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public void W(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        int count;
        int count2;
        String innerPrefix = prefix + "    ";
        this.e.e(prefix, fd, writer, args);
        ArrayList<Fragment> arrayList = this.g;
        if (arrayList != null && (count2 = arrayList.size()) > 0) {
            writer.print(prefix);
            writer.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < count2; i2++) {
                Fragment f2 = this.g.get(i2);
                writer.print(prefix);
                writer.print("  #");
                writer.print(i2);
                writer.print(": ");
                writer.println(f2.toString());
            }
        }
        ArrayList<tb> arrayList2 = this.f;
        if (arrayList2 != null && (count = arrayList2.size()) > 0) {
            writer.print(prefix);
            writer.println("Back Stack:");
            for (int i3 = 0; i3 < count; i3++) {
                tb bs = this.f.get(i3);
                writer.print(prefix);
                writer.print("  #");
                writer.print(i3);
                writer.print(": ");
                writer.println(bs.toString());
                bs.n(innerPrefix, writer);
            }
        }
        writer.print(prefix);
        writer.println("Back Stack Index: " + this.k.get());
        synchronized (this.c) {
            int count3 = this.c.size();
            if (count3 > 0) {
                writer.print(prefix);
                writer.println("Pending Actions:");
                for (int i4 = 0; i4 < count3; i4++) {
                    o r = this.c.get(i4);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i4);
                    writer.print(": ");
                    writer.println(r);
                }
            }
        }
        writer.print(prefix);
        writer.println("FragmentManager misc state:");
        writer.print(prefix);
        writer.print("  mHost=");
        writer.println(this.t);
        writer.print(prefix);
        writer.print("  mContainer=");
        writer.println(this.u);
        if (this.v != null) {
            writer.print(prefix);
            writer.print("  mParent=");
            writer.println(this.v);
        }
        writer.print(prefix);
        writer.print("  mCurState=");
        writer.print(this.s);
        writer.print(" mStateSaved=");
        writer.print(this.G);
        writer.print(" mStopped=");
        writer.print(this.H);
        writer.print(" mDestroyed=");
        writer.println(this.I);
        if (this.F) {
            writer.print(prefix);
            writer.print("  mNeedMenuInvalidate=");
            writer.println(this.F);
        }
    }

    public void S0(kc fragmentStateManager) {
        Fragment f2 = fragmentStateManager.k();
        if (f2.L) {
            if (this.d) {
                this.J = true;
                return;
            }
            f2.L = false;
            if (b) {
                fragmentStateManager.m();
            } else {
                O0(f2);
            }
        }
    }

    public boolean J0(int state) {
        return this.s >= state;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void P0(androidx.fragment.app.Fragment r11, int r12) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dc.P0(androidx.fragment.app.Fragment, int):void");
    }

    public final void m(Fragment f2) {
        HashSet<t8> hashSet = this.o.get(f2);
        if (hashSet != null) {
            Iterator<t8> it = hashSet.iterator();
            while (it.hasNext()) {
                t8 signal = it.next();
                signal.a();
            }
            hashSet.clear();
            w(f2);
            this.o.remove(f2);
        }
    }

    public void f1(Fragment f2, boolean isPop) {
        ViewGroup container = p0(f2);
        if (container != null && (container instanceof FragmentContainerView)) {
            ((FragmentContainerView) container).setDrawDisappearingViewsLast(!isPop);
        }
    }

    public final void w(Fragment fragment) {
        fragment.R0();
        this.q.n(fragment, false);
        fragment.J = null;
        fragment.K = null;
        fragment.W = null;
        fragment.X.i(null);
        fragment.r = false;
    }

    public void O0(Fragment f2) {
        P0(f2, this.s);
    }

    public final void u(Fragment fragment) {
        int visibility;
        Animator animator;
        if (fragment.K != null) {
            wb.d anim = wb.c(this.t.k(), fragment, !fragment.C, fragment.D());
            if (anim != null && (animator = anim.b) != null) {
                animator.setTarget(fragment.K);
                if (fragment.C) {
                    if (fragment.U()) {
                        fragment.s1(false);
                    } else {
                        ViewGroup container = fragment.J;
                        View animatingView = fragment.K;
                        container.startViewTransition(animatingView);
                        anim.b.addListener(new h(container, animatingView, fragment));
                    }
                } else {
                    fragment.K.setVisibility(0);
                }
                anim.b.start();
            } else {
                if (anim != null) {
                    fragment.K.startAnimation(anim.a);
                    anim.a.start();
                }
                if (fragment.C && !fragment.U()) {
                    visibility = 8;
                } else {
                    visibility = 0;
                }
                fragment.K.setVisibility(visibility);
                if (fragment.U()) {
                    fragment.s1(false);
                }
            }
        }
        D0(fragment);
        fragment.Q = false;
        fragment.s0(fragment.C);
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$h */
    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Fragment d;

        public h(ViewGroup viewGroup, View view, Fragment fragment) {
            this.a = viewGroup;
            this.b = view;
            this.d = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.a.endViewTransition(this.b);
            animation.removeListener(this);
            Fragment fragment = this.d;
            View view = fragment.K;
            if (view != null && fragment.C) {
                view.setVisibility(8);
            }
        }
    }

    public void M0(Fragment f2) {
        if (!this.e.c(f2.i)) {
            if (F0(3)) {
                Log.d("FragmentManager", "Ignoring moving " + f2 + " to state " + this.s + "since it is not added to " + this);
                return;
            }
            return;
        }
        O0(f2);
        View view = f2.K;
        if (view != null && f2.P && f2.J != null) {
            float f3 = f2.R;
            if (f3 > 0.0f) {
                view.setAlpha(f3);
            }
            f2.R = 0.0f;
            f2.P = false;
            wb.d anim = wb.c(this.t.k(), f2, true, f2.D());
            if (anim != null) {
                Animation animation = anim.a;
                if (animation != null) {
                    f2.K.startAnimation(animation);
                } else {
                    anim.b.setTarget(f2.K);
                    anim.b.start();
                }
            }
        }
        if (f2.Q) {
            u(f2);
        }
    }

    public void N0(int newState, boolean always) {
        ac<?> acVar;
        if (this.t == null && newState != -1) {
            throw new IllegalStateException("No activity");
        }
        if (!always && newState == this.s) {
            return;
        }
        this.s = newState;
        if (b) {
            this.e.r();
        } else {
            for (Fragment f2 : this.e.n()) {
                M0(f2);
            }
            for (kc fragmentStateManager : this.e.k()) {
                Fragment f3 = fragmentStateManager.k();
                if (!f3.P) {
                    M0(f3);
                }
                boolean beingRemoved = f3.p && !f3.V();
                if (beingRemoved) {
                    this.e.q(fragmentStateManager);
                }
            }
        }
        k1();
        if (this.F && (acVar = this.t) != null && this.s == 7) {
            acVar.p();
            this.F = false;
        }
    }

    public final void k1() {
        for (kc fragmentStateManager : this.e.k()) {
            S0(fragmentStateManager);
        }
    }

    public kc v(Fragment f2) {
        kc existing = this.e.m(f2.i);
        if (existing != null) {
            return existing;
        }
        kc fragmentStateManager = new kc(this.q, this.e, f2);
        fragmentStateManager.o(this.t.k().getClassLoader());
        fragmentStateManager.t(this.s);
        return fragmentStateManager;
    }

    public kc g(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        kc fragmentStateManager = v(fragment);
        fragment.v = this;
        this.e.p(fragmentStateManager);
        if (!fragment.D) {
            this.e.a(fragment);
            fragment.p = false;
            if (fragment.K == null) {
                fragment.Q = false;
            }
            if (G0(fragment)) {
                this.F = true;
            }
        }
        return fragmentStateManager;
    }

    public void Y0(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.u);
        }
        boolean inactive = !fragment.V();
        if (!fragment.D || inactive) {
            this.e.s(fragment);
            if (G0(fragment)) {
                this.F = true;
            }
            fragment.p = true;
            i1(fragment);
        }
    }

    public void C0(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.C) {
            fragment.C = true;
            fragment.Q = true ^ fragment.Q;
            i1(fragment);
        }
    }

    public void j1(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.C) {
            fragment.C = false;
            fragment.Q = !fragment.Q;
        }
    }

    public void x(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.D) {
            fragment.D = true;
            if (fragment.o) {
                if (F0(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.e.s(fragment);
                if (G0(fragment)) {
                    this.F = true;
                }
                i1(fragment);
            }
        }
    }

    public void k(Fragment fragment) {
        if (F0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.D) {
            fragment.D = false;
            if (!fragment.o) {
                this.e.a(fragment);
                if (F0(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (G0(fragment)) {
                    this.F = true;
                }
            }
        }
    }

    public Fragment h0(int id) {
        return this.e.g(id);
    }

    public Fragment i0(String tag) {
        return this.e.h(tag);
    }

    public Fragment j0(String who) {
        return this.e.i(who);
    }

    public Fragment g0(String who) {
        return this.e.f(who);
    }

    public final void o() {
        if (K0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public boolean K0() {
        return this.G || this.H;
    }

    public void Y(o action, boolean allowStateLoss) {
        if (!allowStateLoss) {
            if (this.t == null) {
                if (this.I) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            o();
        }
        synchronized (this.c) {
            if (this.t == null) {
                if (!allowStateLoss) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
                return;
            }
            this.c.add(action);
            e1();
        }
    }

    public void e1() {
        synchronized (this.c) {
            ArrayList<p> arrayList = this.N;
            boolean postponeReady = (arrayList == null || arrayList.isEmpty()) ? false : true;
            boolean pendingReady = this.c.size() == 1;
            if (postponeReady || pendingReady) {
                this.t.l().removeCallbacks(this.P);
                this.t.l().post(this.P);
                l1();
            }
        }
    }

    public int i() {
        return this.k.getAndIncrement();
    }

    public final void Z(boolean allowStateLoss) {
        if (this.d) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.t == null) {
            if (this.I) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.t.l().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!allowStateLoss) {
                o();
            }
            if (this.K == null) {
                this.K = new ArrayList<>();
                this.L = new ArrayList<>();
            }
            this.d = true;
            try {
                f0(null, null);
            } finally {
                this.d = false;
            }
        }
    }

    public void b0(o action, boolean allowStateLoss) {
        if (allowStateLoss && (this.t == null || this.I)) {
            return;
        }
        Z(allowStateLoss);
        if (action.a(this.K, this.L)) {
            this.d = true;
            try {
                Z0(this.K, this.L);
            } finally {
                p();
            }
        }
        l1();
        V();
        this.e.b();
    }

    public final void p() {
        this.d = false;
        this.L.clear();
        this.K.clear();
    }

    public boolean a0(boolean allowStateLoss) {
        Z(allowStateLoss);
        boolean didSomething = false;
        while (l0(this.K, this.L)) {
            this.d = true;
            try {
                Z0(this.K, this.L);
                p();
                didSomething = true;
            } catch (Throwable th) {
                p();
                throw th;
            }
        }
        l1();
        V();
        this.e.b();
        return didSomething;
    }

    public final void f0(ArrayList<tb> arrayList, ArrayList<Boolean> isRecordPop) {
        int index;
        int index2;
        ArrayList<p> arrayList2 = this.N;
        int numPostponed = arrayList2 == null ? 0 : arrayList2.size();
        int i2 = 0;
        while (i2 < numPostponed) {
            p listener = this.N.get(i2);
            if (arrayList != null && !listener.a && (index2 = arrayList.indexOf(listener.b)) != -1 && isRecordPop != null && isRecordPop.get(index2).booleanValue()) {
                this.N.remove(i2);
                i2--;
                numPostponed--;
                listener.c();
            } else if (listener.e() || (arrayList != null && listener.b.u(arrayList, 0, arrayList.size()))) {
                this.N.remove(i2);
                i2--;
                numPostponed--;
                if (arrayList != null && !listener.a && (index = arrayList.indexOf(listener.b)) != -1 && isRecordPop != null && isRecordPop.get(index).booleanValue()) {
                    listener.c();
                } else {
                    listener.d();
                }
            }
            i2++;
        }
    }

    public final void Z0(ArrayList<tb> arrayList, ArrayList<Boolean> isRecordPop) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != isRecordPop.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        f0(arrayList, isRecordPop);
        int numRecords = arrayList.size();
        int startIndex = 0;
        int recordNum = 0;
        while (recordNum < numRecords) {
            boolean canReorder = arrayList.get(recordNum).r;
            if (!canReorder) {
                if (startIndex != recordNum) {
                    d0(arrayList, isRecordPop, startIndex, recordNum);
                }
                int reorderingEnd = recordNum + 1;
                if (isRecordPop.get(recordNum).booleanValue()) {
                    while (reorderingEnd < numRecords && isRecordPop.get(reorderingEnd).booleanValue() && !arrayList.get(reorderingEnd).r) {
                        reorderingEnd++;
                    }
                }
                d0(arrayList, isRecordPop, recordNum, reorderingEnd);
                startIndex = reorderingEnd;
                recordNum = reorderingEnd - 1;
            }
            recordNum++;
        }
        if (startIndex != numRecords) {
            d0(arrayList, isRecordPop, startIndex, numRecords);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<androidx.fragment.app.Fragment> */
    public final void d0(ArrayList<tb> arrayList, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex) {
        int i2;
        boolean allowReordering;
        int i3;
        int i4;
        ArrayList<Boolean> arrayList2;
        int postponeIndex;
        ArrayList<Boolean> arrayList3;
        int i5;
        boolean z;
        boolean allowReordering2 = arrayList.get(startIndex).r;
        ArrayList<Fragment> arrayList4 = this.M;
        if (arrayList4 == null) {
            this.M = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.M.addAll(this.e.n());
        Fragment oldPrimaryNav = x0();
        int recordNum = startIndex;
        boolean addToBackStack = false;
        while (true) {
            boolean addToBackStack2 = true;
            if (recordNum >= endIndex) {
                break;
            }
            tb record = arrayList.get(recordNum);
            if (!isRecordPop.get(recordNum).booleanValue()) {
                oldPrimaryNav = record.r(this.M, oldPrimaryNav);
            } else {
                oldPrimaryNav = record.z(this.M, oldPrimaryNav);
            }
            if (!addToBackStack && !record.i) {
                addToBackStack2 = false;
            }
            addToBackStack = addToBackStack2;
            recordNum++;
        }
        this.M.clear();
        if (!allowReordering2 && this.s >= 1) {
            if (!b) {
                nc.C(this.t.k(), this.u, arrayList, isRecordPop, startIndex, endIndex, false, this.p);
            } else {
                for (int index = startIndex; index < endIndex; index++) {
                    Iterator<mc.a> it = arrayList.get(index).c.iterator();
                    while (it.hasNext()) {
                        mc.a op = it.next();
                        Fragment fragment = op.b;
                        if (fragment != null && fragment.v != null) {
                            kc fragmentStateManager = v(fragment);
                            this.e.p(fragmentStateManager);
                        }
                    }
                }
            }
        }
        c0(arrayList, isRecordPop, startIndex, endIndex);
        if (b) {
            boolean isPop = isRecordPop.get(endIndex - 1).booleanValue();
            for (int index2 = startIndex; index2 < endIndex; index2++) {
                tb record2 = arrayList.get(index2);
                if (isPop) {
                    for (int opIndex = record2.c.size() - 1; opIndex >= 0; opIndex--) {
                        mc.a op2 = record2.c.get(opIndex);
                        Fragment fragment2 = op2.b;
                        if (fragment2 != null) {
                            kc fragmentStateManager2 = v(fragment2);
                            fragmentStateManager2.m();
                        }
                    }
                } else {
                    Iterator<mc.a> it2 = record2.c.iterator();
                    while (it2.hasNext()) {
                        mc.a op3 = it2.next();
                        Fragment fragment3 = op3.b;
                        if (fragment3 != null) {
                            kc fragmentStateManager3 = v(fragment3);
                            fragmentStateManager3.m();
                        }
                    }
                }
            }
            int index3 = this.s;
            N0(index3, true);
            for (sc controller : s(arrayList, startIndex, endIndex)) {
                controller.r(isPop);
                controller.p();
                controller.g();
            }
            i5 = endIndex;
            arrayList3 = isRecordPop;
        } else {
            if (!allowReordering2) {
                i2 = 1;
                allowReordering = allowReordering2;
                i3 = endIndex;
                i4 = startIndex;
                arrayList2 = isRecordPop;
                postponeIndex = endIndex;
            } else {
                u3<Fragment> u3Var = new u3<>();
                d(u3Var);
                i2 = 1;
                allowReordering = allowReordering2;
                i3 = endIndex;
                i4 = startIndex;
                arrayList2 = isRecordPop;
                int postponeIndex2 = W0(arrayList, isRecordPop, startIndex, endIndex, u3Var);
                L0(u3Var);
                postponeIndex = postponeIndex2;
            }
            if (postponeIndex == i4 || !allowReordering) {
                arrayList3 = arrayList2;
                i5 = i3;
            } else {
                if (this.s >= i2) {
                    arrayList3 = arrayList2;
                    i5 = i3;
                    z = i2;
                    nc.C(this.t.k(), this.u, arrayList, isRecordPop, startIndex, postponeIndex, true, this.p);
                } else {
                    arrayList3 = arrayList2;
                    i5 = i3;
                    z = i2;
                }
                N0(this.s, z);
            }
        }
        for (int recordNum2 = startIndex; recordNum2 < i5; recordNum2++) {
            tb record3 = arrayList.get(recordNum2);
            if (arrayList3.get(recordNum2).booleanValue() && record3.v >= 0) {
                record3.v = -1;
            }
            record3.x();
        }
        if (addToBackStack) {
            a1();
        }
    }

    public final Set<sc> s(ArrayList<tb> arrayList, int startIndex, int endIndex) {
        ViewGroup container;
        Set<SpecialEffectsController> controllers = new HashSet<>();
        for (int index = startIndex; index < endIndex; index++) {
            tb record = arrayList.get(index);
            Iterator<mc.a> it = record.c.iterator();
            while (it.hasNext()) {
                mc.a op = it.next();
                Fragment fragment = op.b;
                if (fragment != null && (container = fragment.J) != null) {
                    controllers.add(sc.n(container, this));
                }
            }
        }
        return controllers;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<androidx.fragment.app.Fragment> */
    public final void L0(u3<Fragment> u3Var) {
        int numAdded = u3Var.size();
        for (int i2 = 0; i2 < numAdded; i2++) {
            Fragment fragment = u3Var.h(i2);
            if (!fragment.o) {
                View view = fragment.j1();
                fragment.R = view.getAlpha();
                view.setAlpha(0.0f);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<androidx.fragment.app.Fragment> */
    public final int W0(ArrayList<tb> arrayList, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex, u3<Fragment> u3Var) {
        int postponeIndex = endIndex;
        for (int i2 = endIndex - 1; i2 >= startIndex; i2--) {
            tb record = arrayList.get(i2);
            boolean isPop = isRecordPop.get(i2).booleanValue();
            boolean isPostponed = record.w() && !record.u(arrayList, i2 + 1, endIndex);
            if (isPostponed) {
                if (this.N == null) {
                    this.N = new ArrayList<>();
                }
                p listener = new p(record, isPop);
                this.N.add(listener);
                record.y(listener);
                if (isPop) {
                    record.p();
                } else {
                    record.q(false);
                }
                postponeIndex--;
                if (i2 != postponeIndex) {
                    arrayList.remove(i2);
                    arrayList.add(postponeIndex, record);
                }
                d(u3Var);
            }
        }
        return postponeIndex;
    }

    public void t(tb record, boolean isPop, boolean runTransitions, boolean moveToState) {
        if (isPop) {
            record.q(moveToState);
        } else {
            record.p();
        }
        ArrayList<BackStackRecord> records = new ArrayList<>(1);
        ArrayList<Boolean> isRecordPop = new ArrayList<>(1);
        records.add(record);
        isRecordPop.add(Boolean.valueOf(isPop));
        if (runTransitions && this.s >= 1) {
            nc.C(this.t.k(), this.u, records, isRecordPop, 0, 1, true, this.p);
        }
        if (moveToState) {
            N0(this.s, true);
        }
        for (Fragment fragment : this.e.l()) {
            if (fragment != null && fragment.K != null && fragment.P && record.t(fragment.A)) {
                float f2 = fragment.R;
                if (f2 > 0.0f) {
                    fragment.K.setAlpha(f2);
                }
                if (moveToState) {
                    fragment.R = 0.0f;
                } else {
                    fragment.R = -1.0f;
                    fragment.P = false;
                }
            }
        }
    }

    public static void c0(ArrayList<tb> arrayList, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex) {
        int i2 = startIndex;
        while (i2 < endIndex) {
            tb record = arrayList.get(i2);
            boolean isPop = isRecordPop.get(i2).booleanValue();
            if (isPop) {
                record.l(-1);
                boolean moveToState = i2 == endIndex + (-1);
                record.q(moveToState);
            } else {
                record.l(1);
                record.p();
            }
            i2++;
        }
    }

    public final void i1(Fragment f2) {
        ViewGroup container = p0(f2);
        if (container != null && f2.q() + f2.t() + f2.E() + f2.F() > 0) {
            int i2 = rb.visible_removing_fragment_view_tag;
            if (container.getTag(i2) == null) {
                container.setTag(i2, f2);
            }
            ((Fragment) container.getTag(i2)).v1(f2.D());
        }
    }

    public final ViewGroup p0(Fragment f2) {
        ViewGroup viewGroup = f2.J;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (f2.A > 0 && this.u.h()) {
            View view = this.u.f(f2.A);
            if (view instanceof ViewGroup) {
                return (ViewGroup) view;
            }
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<androidx.fragment.app.Fragment> */
    public final void d(u3<Fragment> u3Var) {
        int i2 = this.s;
        if (i2 < 1) {
            return;
        }
        int state = Math.min(i2, 5);
        for (Fragment fragment : this.e.n()) {
            if (fragment.b < state) {
                P0(fragment, state);
                if (fragment.K != null && !fragment.C && fragment.P) {
                    u3Var.add(fragment);
                }
            }
        }
    }

    public final void k0() {
        if (b) {
            for (sc controller : r()) {
                controller.k();
            }
        } else if (this.N != null) {
            while (!this.N.isEmpty()) {
                this.N.remove(0).d();
            }
        }
    }

    public final void X() {
        if (b) {
            for (sc controller : r()) {
                controller.j();
            }
        } else if (!this.o.isEmpty()) {
            for (Fragment fragment : this.o.keySet()) {
                m(fragment);
                O0(fragment);
            }
        }
    }

    public final Set<sc> r() {
        Set<SpecialEffectsController> controllers = new HashSet<>();
        for (kc fragmentStateManager : this.e.k()) {
            ViewGroup container = fragmentStateManager.k().J;
            if (container != null) {
                controllers.add(sc.o(container, y0()));
            }
        }
        return controllers;
    }

    public final boolean l0(ArrayList<tb> arrayList, ArrayList<Boolean> isPop) {
        boolean didSomething = false;
        synchronized (this.c) {
            if (this.c.isEmpty()) {
                return false;
            }
            int numActions = this.c.size();
            for (int i2 = 0; i2 < numActions; i2++) {
                didSomething |= this.c.get(i2).a(arrayList, isPop);
            }
            this.c.clear();
            this.t.l().removeCallbacks(this.P);
            return didSomething;
        }
    }

    public final void V() {
        if (this.J) {
            this.J = false;
            k1();
        }
    }

    public final void a1() {
        if (this.n != null) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                this.n.get(i2).a();
            }
        }
    }

    public void e(tb state) {
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.add(state);
    }

    public boolean V0(ArrayList<tb> arrayList, ArrayList<Boolean> isRecordPop, String name, int id, int flags) {
        ArrayList<tb> arrayList2 = this.f;
        if (arrayList2 == null) {
            return false;
        }
        if (name == null && id < 0 && (flags & 1) == 0) {
            int last = arrayList2.size() - 1;
            if (last < 0) {
                return false;
            }
            arrayList.add(this.f.remove(last));
            isRecordPop.add(true);
        } else {
            int index = -1;
            if (name != null || id >= 0) {
                index = arrayList2.size() - 1;
                while (index >= 0) {
                    tb bss = this.f.get(index);
                    if ((name != null && name.equals(bss.s())) || (id >= 0 && id == bss.v)) {
                        break;
                    }
                    index--;
                }
                if (index < 0) {
                    return false;
                }
                if ((flags & 1) != 0) {
                    index--;
                    while (index >= 0) {
                        tb bss2 = this.f.get(index);
                        if ((name == null || !name.equals(bss2.s())) && (id < 0 || id != bss2.v)) {
                            break;
                        }
                        index--;
                    }
                }
            }
            if (index == this.f.size() - 1) {
                return false;
            }
            for (int i2 = this.f.size() - 1; i2 > index; i2--) {
                arrayList.add(this.f.remove(i2));
                isRecordPop.add(true);
            }
        }
        return true;
    }

    public Parcelable d1() {
        int size;
        k0();
        X();
        a0(true);
        this.G = true;
        this.O.n(true);
        ArrayList<jc> v = this.e.v();
        if (v.isEmpty()) {
            if (F0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
                return null;
            }
            return null;
        }
        ArrayList<String> added = this.e.w();
        ub[] backStack = null;
        ArrayList<tb> arrayList = this.f;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStack = new ub[size];
            for (int i2 = 0; i2 < size; i2++) {
                backStack[i2] = new ub(this.f.get(i2));
                if (F0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f.get(i2));
                }
            }
        }
        fc fms = new fc();
        fms.a = v;
        fms.b = added;
        fms.d = backStack;
        fms.f = this.k.get();
        Fragment fragment = this.w;
        if (fragment != null) {
            fms.g = fragment.i;
        }
        fms.h.addAll(this.l.keySet());
        fms.i.addAll(this.l.values());
        fms.j = new ArrayList<>(this.E);
        return fms;
    }

    public void b1(Parcelable state) {
        kc fragmentStateManager;
        if (state == null) {
            return;
        }
        fc fms = (fc) state;
        if (fms.a == null) {
            return;
        }
        this.e.t();
        Iterator<jc> it = fms.a.iterator();
        while (it.hasNext()) {
            jc fs = it.next();
            if (fs != null) {
                Fragment retainedFragment = this.O.g(fs.b);
                if (retainedFragment != null) {
                    if (F0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + retainedFragment);
                    }
                    fragmentStateManager = new kc(this.q, this.e, retainedFragment, fs);
                } else {
                    fragmentStateManager = new kc(this.q, this.e, this.t.k().getClassLoader(), q0(), fs);
                }
                Fragment f2 = fragmentStateManager.k();
                f2.v = this;
                if (F0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + f2.i + "): " + f2);
                }
                fragmentStateManager.o(this.t.k().getClassLoader());
                this.e.p(fragmentStateManager);
                fragmentStateManager.t(this.s);
            }
        }
        for (Fragment f3 : this.O.j()) {
            if (!this.e.c(f3.i)) {
                if (F0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + f3 + " that was not found in the set of active Fragments " + fms.a);
                }
                this.O.m(f3);
                f3.v = this;
                kc fragmentStateManager2 = new kc(this.q, this.e, f3);
                fragmentStateManager2.t(1);
                fragmentStateManager2.m();
                f3.p = true;
                fragmentStateManager2.m();
            }
        }
        this.e.u(fms.b);
        if (fms.d != null) {
            this.f = new ArrayList<>(fms.d.length);
            int i2 = 0;
            while (true) {
                ub[] ubVarArr = fms.d;
                if (i2 >= ubVarArr.length) {
                    break;
                }
                tb bse = ubVarArr[i2].a(this);
                if (F0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + bse.v + "): " + bse);
                    rc logw = new rc("FragmentManager");
                    PrintWriter pw = new PrintWriter(logw);
                    bse.o("  ", pw, false);
                    pw.close();
                }
                this.f.add(bse);
                i2++;
            }
        } else {
            this.f = null;
        }
        this.k.set(fms.f);
        String str = fms.g;
        if (str != null) {
            Fragment g0 = g0(str);
            this.w = g0;
            L(g0);
        }
        ArrayList<String> savedResultKeys = fms.h;
        if (savedResultKeys != null) {
            for (int i3 = 0; i3 < savedResultKeys.size(); i3++) {
                Bundle savedResult = fms.i.get(i3);
                savedResult.setClassLoader(this.t.k().getClassLoader());
                this.l.put(savedResultKeys.get(i3), savedResult);
            }
        }
        this.E = new ArrayDeque<>(fms.j);
    }

    public ac<?> t0() {
        return this.t;
    }

    public Fragment w0() {
        return this.v;
    }

    public xb o0() {
        return this.u;
    }

    public lc r0() {
        return this.e;
    }

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<?> */
    @SuppressLint({"SyntheticAccessor"})
    public void j(ac<?> acVar, xb container, Fragment parent) {
        String parentId;
        if (this.t != null) {
            throw new IllegalStateException("Already attached");
        }
        this.t = acVar;
        this.u = container;
        this.v = parent;
        if (parent != null) {
            h(new i(parent));
        } else if (acVar instanceof hc) {
            h((hc) acVar);
        }
        if (this.v != null) {
            l1();
        }
        if (acVar instanceof defpackage.c) {
            defpackage.c dispatcherOwner = (defpackage.c) acVar;
            OnBackPressedDispatcher b2 = dispatcherOwner.b();
            this.i = b2;
            fd owner = parent != null ? parent : dispatcherOwner;
            b2.a(owner, this.j);
        }
        if (parent != null) {
            this.O = parent.v.n0(parent);
        } else if (acVar instanceof sd) {
            rd viewModelStore = ((sd) acVar).i();
            this.O = gc.i(viewModelStore);
        } else {
            this.O = new gc(false);
        }
        this.O.n(K0());
        this.e.x(this.O);
        ac<?> acVar2 = this.t;
        if (acVar2 instanceof defpackage.j) {
            defpackage.i registry = ((defpackage.j) acVar2).g();
            if (parent != null) {
                parentId = parent.i + ":";
            } else {
                parentId = "";
            }
            String keyPrefix = "FragmentManager:" + parentId;
            this.B = registry.g(keyPrefix + "StartActivityForResult", new defpackage.m(), new j());
            this.C = registry.g(keyPrefix + "StartIntentSenderForResult", new k(), new a());
            this.D = registry.g(keyPrefix + "RequestPermissions", new defpackage.l(), new b());
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$i */
    /* loaded from: classes.dex */
    public class i implements hc {
        public final /* synthetic */ Fragment a;

        public i(Fragment fragment) {
            this.a = fragment;
        }

        @Override // defpackage.hc
        public void d(dc fragmentManager, Fragment fragment) {
            this.a.g0(fragment);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$j */
    /* loaded from: classes.dex */
    public class j implements defpackage.g<defpackage.f> {
        public j() {
        }

        @Override // defpackage.g
        /* renamed from: b */
        public void a(defpackage.f result) {
            m requestInfo = dc.this.E.pollFirst();
            if (requestInfo == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String fragmentWho = requestInfo.a;
            int requestCode = requestInfo.b;
            Fragment fragment = dc.this.e.i(fragmentWho);
            if (fragment == null) {
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + fragmentWho);
                return;
            }
            fragment.d0(requestCode, result.b(), result.a());
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$a */
    /* loaded from: classes.dex */
    public class a implements defpackage.g<defpackage.f> {
        public a() {
        }

        @Override // defpackage.g
        /* renamed from: b */
        public void a(defpackage.f result) {
            m requestInfo = dc.this.E.pollFirst();
            if (requestInfo == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String fragmentWho = requestInfo.a;
            int requestCode = requestInfo.b;
            Fragment fragment = dc.this.e.i(fragmentWho);
            if (fragment == null) {
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + fragmentWho);
                return;
            }
            fragment.d0(requestCode, result.b(), result.a());
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$b */
    /* loaded from: classes.dex */
    public class b implements defpackage.g<Map<String, Boolean>> {
        public b() {
        }

        @Override // defpackage.g
        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: b */
        public void a(Map<String, Boolean> result) {
            int i;
            String[] permissions = (String[]) result.keySet().toArray(new String[0]);
            ArrayList<Boolean> resultValues = new ArrayList<>(result.values());
            int[] grantResults = new int[resultValues.size()];
            for (int i2 = 0; i2 < resultValues.size(); i2++) {
                if (resultValues.get(i2).booleanValue()) {
                    i = 0;
                } else {
                    i = -1;
                }
                grantResults[i2] = i;
            }
            m requestInfo = dc.this.E.pollFirst();
            if (requestInfo == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String fragmentWho = requestInfo.a;
            int requestCode = requestInfo.b;
            Fragment fragment = dc.this.e.i(fragmentWho);
            if (fragment == null) {
                Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + fragmentWho);
                return;
            }
            fragment.C0(requestCode, permissions, grantResults);
        }
    }

    public void Q0() {
        if (this.t == null) {
            return;
        }
        this.G = false;
        this.H = false;
        this.O.n(false);
        for (Fragment fragment : this.e.n()) {
            if (fragment != null) {
                fragment.b0();
            }
        }
    }

    public void z() {
        this.G = false;
        this.H = false;
        this.O.n(false);
        S(0);
    }

    public void C() {
        this.G = false;
        this.H = false;
        this.O.n(false);
        S(1);
    }

    public void U() {
        S(2);
    }

    public void y() {
        this.G = false;
        this.H = false;
        this.O.n(false);
        S(4);
    }

    public void R() {
        this.G = false;
        this.H = false;
        this.O.n(false);
        S(5);
    }

    public void Q() {
        this.G = false;
        this.H = false;
        this.O.n(false);
        S(7);
    }

    public void M() {
        S(5);
    }

    public void T() {
        this.H = true;
        this.O.n(true);
        S(4);
    }

    public void F() {
        S(1);
    }

    public void E() {
        this.I = true;
        a0(true);
        X();
        S(-1);
        this.t = null;
        this.u = null;
        this.v = null;
        if (this.i != null) {
            this.j.d();
            this.i = null;
        }
        defpackage.h<Intent> hVar = this.B;
        if (hVar != null) {
            hVar.a();
            this.C.a();
            this.D.a();
        }
    }

    public final void S(int nextState) {
        try {
            this.d = true;
            this.e.d(nextState);
            N0(nextState, false);
            if (b) {
                for (sc controller : r()) {
                    controller.j();
                }
            }
            this.d = false;
            a0(true);
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }

    public void H(boolean isInMultiWindowMode) {
        for (Fragment f2 : this.e.n()) {
            if (f2 != null) {
                f2.V0(isInMultiWindowMode);
            }
        }
    }

    public void N(boolean isInPictureInPictureMode) {
        for (Fragment f2 : this.e.n()) {
            if (f2 != null) {
                f2.Z0(isInPictureInPictureMode);
            }
        }
    }

    public void A(Configuration newConfig) {
        for (Fragment f2 : this.e.n()) {
            if (f2 != null) {
                f2.L0(newConfig);
            }
        }
    }

    public void G() {
        for (Fragment f2 : this.e.n()) {
            if (f2 != null) {
                f2.U0();
            }
        }
    }

    public boolean D(Menu menu, MenuInflater inflater) {
        if (this.s < 1) {
            return false;
        }
        boolean show = false;
        ArrayList<Fragment> newMenus = null;
        for (Fragment f2 : this.e.n()) {
            if (f2 != null && H0(f2) && f2.O0(menu, inflater)) {
                show = true;
                if (newMenus == null) {
                    newMenus = new ArrayList<>();
                }
                newMenus.add(f2);
            }
        }
        if (this.g != null) {
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                Fragment f3 = this.g.get(i2);
                if (newMenus == null || !newMenus.contains(f3)) {
                    f3.o0();
                }
            }
        }
        this.g = newMenus;
        return show;
    }

    public boolean O(Menu menu) {
        if (this.s < 1) {
            return false;
        }
        boolean show = false;
        for (Fragment f2 : this.e.n()) {
            if (f2 != null && H0(f2) && f2.a1(menu)) {
                show = true;
            }
        }
        return show;
    }

    public boolean J(MenuItem item) {
        if (this.s < 1) {
            return false;
        }
        for (Fragment f2 : this.e.n()) {
            if (f2 != null && f2.W0(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean B(MenuItem item) {
        if (this.s < 1) {
            return false;
        }
        for (Fragment f2 : this.e.n()) {
            if (f2 != null && f2.M0(item)) {
                return true;
            }
        }
        return false;
    }

    public void K(Menu menu) {
        if (this.s < 1) {
            return;
        }
        for (Fragment f2 : this.e.n()) {
            if (f2 != null) {
                f2.X0(menu);
            }
        }
    }

    public void h1(Fragment f2) {
        if (f2 != null && (!f2.equals(g0(f2.i)) || (f2.w != null && f2.v != this))) {
            throw new IllegalArgumentException("Fragment " + f2 + " is not an active fragment of FragmentManager " + this);
        }
        Fragment previousPrimaryNav = this.w;
        this.w = f2;
        L(previousPrimaryNav);
        L(this.w);
    }

    public final void L(Fragment f2) {
        if (f2 != null && f2.equals(g0(f2.i))) {
            f2.b1();
        }
    }

    public void P() {
        l1();
        L(this.w);
    }

    public Fragment x0() {
        return this.w;
    }

    public void g1(Fragment f2, cd.c state) {
        if (!f2.equals(g0(f2.i)) || (f2.w != null && f2.v != this)) {
            throw new IllegalArgumentException("Fragment " + f2 + " is not an active fragment of FragmentManager " + this);
        }
        f2.U = state;
    }

    public zb q0() {
        zb zbVar = this.x;
        if (zbVar != null) {
            return zbVar;
        }
        Fragment fragment = this.v;
        if (fragment != null) {
            return fragment.v.q0();
        }
        return this.y;
    }

    public tc y0() {
        tc tcVar = this.z;
        if (tcVar != null) {
            return tcVar;
        }
        Fragment fragment = this.v;
        if (fragment != null) {
            return fragment.v.y0();
        }
        return this.A;
    }

    public cc v0() {
        return this.q;
    }

    public void h(hc listener) {
        this.r.add(listener);
    }

    public void I(Fragment fragment) {
        Iterator<hc> it = this.r.iterator();
        while (it.hasNext()) {
            hc listener = it.next();
            listener.d(this, fragment);
        }
    }

    public boolean n() {
        boolean hasMenu = false;
        for (Fragment fragment : this.e.l()) {
            if (fragment != null) {
                hasMenu = G0(fragment);
                continue;
            }
            if (hasMenu) {
                return true;
            }
        }
        return false;
    }

    public final boolean G0(Fragment f2) {
        return (f2.G && f2.H) || f2.x.n();
    }

    public void D0(Fragment f2) {
        if (f2.o && G0(f2)) {
            this.F = true;
        }
    }

    public static int c1(int transit) {
        switch (transit) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public LayoutInflater.Factory2 u0() {
        return this.h;
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$p */
    /* loaded from: classes.dex */
    public static class p implements Fragment.h {
        public final boolean a;
        public final tb b;
        public int c;

        public p(tb record, boolean isBack) {
            this.a = isBack;
            this.b = record;
        }

        @Override // androidx.fragment.app.Fragment.h
        public void a() {
            int i = this.c - 1;
            this.c = i;
            if (i != 0) {
                return;
            }
            this.b.t.e1();
        }

        @Override // androidx.fragment.app.Fragment.h
        public void b() {
            this.c++;
        }

        public boolean e() {
            return this.c == 0;
        }

        public void d() {
            boolean canceled = this.c > 0;
            dc manager = this.b.t;
            for (Fragment fragment : manager.s0()) {
                fragment.u1(null);
                if (canceled && fragment.X()) {
                    fragment.y1();
                }
            }
            tb tbVar = this.b;
            tbVar.t.t(tbVar, this.a, canceled ? false : true, true);
        }

        public void c() {
            tb tbVar = this.b;
            tbVar.t.t(tbVar, this.a, false, false);
        }
    }

    /* compiled from: FragmentManager.java */
    @SuppressLint({"BanParcelableUsage"})
    /* renamed from: dc$m */
    /* loaded from: classes.dex */
    public static class m implements Parcelable {
        public static final Parcelable.Creator<m> CREATOR = new a();
        public String a;
        public int b;

        public m(Parcel in) {
            this.a = in.readString();
            this.b = in.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.a);
            dest.writeInt(this.b);
        }

        /* compiled from: FragmentManager.java */
        /* renamed from: dc$m$a */
        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<m> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public m createFromParcel(Parcel in) {
                return new m(in);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public m[] newArray(int size) {
                return new m[size];
            }
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: dc$k */
    /* loaded from: classes.dex */
    public static class k extends defpackage.k<?, defpackage.f> {
        @Override // defpackage.k
        /* renamed from: b */
        public defpackage.f a(int resultCode, Intent intent) {
            return new defpackage.f(resultCode, intent);
        }
    }
}
