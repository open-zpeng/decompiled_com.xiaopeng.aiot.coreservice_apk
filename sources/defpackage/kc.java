package defpackage;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import defpackage.cd;
import defpackage.sc;
/* compiled from: FragmentStateManager.java */
/* renamed from: kc  reason: default package */
/* loaded from: classes.dex */
public class kc {
    public final cc a;
    public final lc b;
    public final Fragment c;
    public boolean d = false;
    public int e = -1;

    public kc(cc dispatcher, lc fragmentStore, Fragment fragment) {
        this.a = dispatcher;
        this.b = fragmentStore;
        this.c = fragment;
    }

    public kc(cc dispatcher, lc fragmentStore, ClassLoader classLoader, zb fragmentFactory, jc fs) {
        this.a = dispatcher;
        this.b = fragmentStore;
        Fragment a2 = fragmentFactory.a(classLoader, fs.a);
        this.c = a2;
        Bundle bundle = fs.l;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.q1(fs.l);
        a2.i = fs.b;
        a2.q = fs.d;
        a2.s = true;
        a2.z = fs.f;
        a2.A = fs.g;
        a2.B = fs.h;
        a2.E = fs.i;
        a2.p = fs.j;
        a2.D = fs.k;
        a2.C = fs.m;
        a2.U = cd.c.values()[fs.n];
        Bundle bundle2 = fs.o;
        if (bundle2 != null) {
            a2.d = bundle2;
        } else {
            a2.d = new Bundle();
        }
        if (dc.F0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a2);
        }
    }

    public kc(cc dispatcher, lc fragmentStore, Fragment retainedFragment, jc fs) {
        this.a = dispatcher;
        this.b = fragmentStore;
        this.c = retainedFragment;
        retainedFragment.f = null;
        retainedFragment.g = null;
        retainedFragment.u = 0;
        retainedFragment.r = false;
        retainedFragment.o = false;
        Fragment fragment = retainedFragment.k;
        retainedFragment.l = fragment != null ? fragment.i : null;
        retainedFragment.k = null;
        Bundle bundle = fs.o;
        if (bundle != null) {
            retainedFragment.d = bundle;
        } else {
            retainedFragment.d = new Bundle();
        }
    }

    public Fragment k() {
        return this.c;
    }

    public void t(int state) {
        this.e = state;
    }

    public int d() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.c;
        if (fragment2.v == null) {
            return fragment2.b;
        }
        int maxState = this.e;
        switch (b.a[fragment2.U.ordinal()]) {
            case 1:
                break;
            case 2:
                maxState = Math.min(maxState, 5);
                break;
            case 3:
                maxState = Math.min(maxState, 1);
                break;
            case 4:
                maxState = Math.min(maxState, 0);
                break;
            default:
                maxState = Math.min(maxState, -1);
                break;
        }
        Fragment fragment3 = this.c;
        if (fragment3.q) {
            if (fragment3.r) {
                maxState = Math.max(this.e, 2);
                View view = this.c.K;
                if (view != null && view.getParent() == null) {
                    maxState = Math.min(maxState, 2);
                }
            } else {
                maxState = this.e < 4 ? Math.min(maxState, fragment3.b) : Math.min(maxState, 1);
            }
        }
        if (!this.c.o) {
            maxState = Math.min(maxState, 1);
        }
        sc.e.b awaitingEffect = null;
        if (dc.b && (viewGroup = (fragment = this.c).J) != null) {
            sc controller = sc.n(viewGroup, fragment.C());
            awaitingEffect = controller.l(this);
        }
        if (awaitingEffect == sc.e.b.ADDING) {
            maxState = Math.min(maxState, 6);
        } else if (awaitingEffect == sc.e.b.REMOVING) {
            maxState = Math.max(maxState, 3);
        } else {
            Fragment fragment4 = this.c;
            if (fragment4.p) {
                if (fragment4.V()) {
                    maxState = Math.min(maxState, 1);
                } else {
                    maxState = Math.min(maxState, -1);
                }
            }
        }
        Fragment fragment5 = this.c;
        if (fragment5.L && fragment5.b < 5) {
            maxState = Math.min(maxState, 4);
        }
        if (dc.F0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + maxState + " for " + this.c);
        }
        return maxState;
    }

    /* compiled from: FragmentStateManager.java */
    /* renamed from: kc$b */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[cd.c.values().length];
            a = iArr;
            try {
                iArr[cd.c.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[cd.c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[cd.c.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[cd.c.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.d) {
            if (dc.F0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.d = true;
            while (true) {
                int newState = d();
                Fragment fragment = this.c;
                int i = fragment.b;
                if (newState != i) {
                    if (newState > i) {
                        int nextStep = i + 1;
                        switch (nextStep) {
                            case 0:
                                c();
                                break;
                            case 1:
                                e();
                                break;
                            case 2:
                                j();
                                f();
                                break;
                            case 3:
                                a();
                                break;
                            case 4:
                                if (fragment.K != null && (viewGroup2 = fragment.J) != null) {
                                    sc controller = sc.n(viewGroup2, fragment.C());
                                    int visibility = this.c.K.getVisibility();
                                    sc.e.c finalState = sc.e.c.b(visibility);
                                    controller.b(finalState, this);
                                }
                                this.c.b = 4;
                                break;
                            case 5:
                                u();
                                break;
                            case 6:
                                fragment.b = 6;
                                break;
                            case 7:
                                p();
                                break;
                        }
                    } else {
                        int nextStep2 = i - 1;
                        switch (nextStep2) {
                            case -1:
                                i();
                                break;
                            case 0:
                                g();
                                break;
                            case 1:
                                h();
                                this.c.b = 1;
                                break;
                            case 2:
                                fragment.r = false;
                                fragment.b = 2;
                                break;
                            case 3:
                                if (dc.F0(3)) {
                                    Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.c);
                                }
                                Fragment fragment2 = this.c;
                                if (fragment2.K != null && fragment2.f == null) {
                                    s();
                                }
                                Fragment fragment3 = this.c;
                                if (fragment3.K != null && (viewGroup3 = fragment3.J) != null) {
                                    sc.n(viewGroup3, fragment3.C()).d(this);
                                }
                                this.c.b = 3;
                                break;
                            case 4:
                                v();
                                break;
                            case 5:
                                fragment.b = 5;
                                break;
                            case 6:
                                n();
                                break;
                        }
                    }
                } else {
                    if (dc.b && fragment.Q) {
                        if (fragment.K != null && (viewGroup = fragment.J) != null) {
                            sc controller2 = sc.n(viewGroup, fragment.C());
                            if (this.c.C) {
                                controller2.c(this);
                            } else {
                                controller2.e(this);
                            }
                        }
                        Fragment fragment4 = this.c;
                        dc dcVar = fragment4.v;
                        if (dcVar != null) {
                            dcVar.D0(fragment4);
                        }
                        Fragment fragment5 = this.c;
                        fragment5.Q = false;
                        fragment5.s0(fragment5.C);
                    }
                    return;
                }
            }
        } finally {
            this.d = false;
        }
    }

    public void j() {
        Fragment fragment = this.c;
        if (fragment.q && fragment.r && !fragment.t) {
            if (dc.F0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
            }
            Fragment fragment2 = this.c;
            fragment2.P0(fragment2.T0(fragment2.d), null, this.c.d);
            View view = this.c.K;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.c;
                fragment3.K.setTag(rb.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.c;
                if (fragment4.C) {
                    fragment4.K.setVisibility(8);
                }
                this.c.g1();
                cc ccVar = this.a;
                Fragment fragment5 = this.c;
                ccVar.m(fragment5, fragment5.K, fragment5.d, false);
                this.c.b = 2;
            }
        }
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.c.d;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.c;
        fragment.f = fragment.d.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.c;
        fragment2.g = fragment2.d.getBundle("android:view_registry_state");
        Fragment fragment3 = this.c;
        fragment3.l = fragment3.d.getString("android:target_state");
        Fragment fragment4 = this.c;
        if (fragment4.l != null) {
            fragment4.m = fragment4.d.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.c;
        Boolean bool = fragment5.h;
        if (bool != null) {
            fragment5.M = bool.booleanValue();
            this.c.h = null;
        } else {
            fragment5.M = fragment5.d.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.c;
        if (!fragment6.M) {
            fragment6.L = true;
        }
    }

    public void c() {
        kc targetFragmentStateManager;
        if (dc.F0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.c);
        }
        Fragment fragment = this.c;
        Fragment fragment2 = fragment.k;
        if (fragment2 != null) {
            targetFragmentStateManager = this.b.m(fragment2.i);
            if (targetFragmentStateManager == null) {
                throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.k + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.c;
            fragment3.l = fragment3.k.i;
            fragment3.k = null;
        } else {
            String str = fragment.l;
            if (str != null) {
                targetFragmentStateManager = this.b.m(str);
                if (targetFragmentStateManager == null) {
                    throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.l + " that does not belong to this FragmentManager!");
                }
            } else {
                targetFragmentStateManager = null;
            }
        }
        if (targetFragmentStateManager != null && (dc.b || targetFragmentStateManager.k().b < 1)) {
            targetFragmentStateManager.m();
        }
        Fragment fragment4 = this.c;
        fragment4.w = fragment4.v.t0();
        Fragment fragment5 = this.c;
        fragment5.y = fragment5.v.w0();
        this.a.g(this.c, false);
        this.c.K0();
        this.a.b(this.c, false);
    }

    public void e() {
        if (dc.F0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        if (!fragment.T) {
            this.a.h(fragment, fragment.d, false);
            Fragment fragment2 = this.c;
            fragment2.N0(fragment2.d);
            cc ccVar = this.a;
            Fragment fragment3 = this.c;
            ccVar.c(fragment3, fragment3.d, false);
            return;
        }
        fragment.k1(fragment.d);
        this.c.b = 1;
    }

    public void f() {
        String resName;
        if (this.c.q) {
            return;
        }
        if (dc.F0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
        }
        Fragment fragment = this.c;
        LayoutInflater layoutInflater = fragment.T0(fragment.d);
        ViewGroup container = null;
        Fragment fragment2 = this.c;
        if (fragment2.J != null) {
            container = fragment2.J;
        } else {
            int i = fragment2.A;
            if (i != 0) {
                if (i == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.c + " for a container view with no id");
                }
                xb fragmentContainer = fragment2.v.o0();
                container = (ViewGroup) fragmentContainer.f(this.c.A);
                if (container == null) {
                    Fragment fragment3 = this.c;
                    if (!fragment3.s) {
                        try {
                            resName = fragment3.I().getResourceName(this.c.A);
                        } catch (Resources.NotFoundException e) {
                            resName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.c.A) + " (" + resName + ") for fragment " + this.c);
                    }
                }
            }
        }
        Fragment fragment4 = this.c;
        fragment4.J = container;
        fragment4.P0(layoutInflater, container, fragment4.d);
        View view = this.c.K;
        if (view != null) {
            boolean z = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.c;
            fragment5.K.setTag(rb.fragment_container_view_tag, fragment5);
            if (container != null) {
                b();
            }
            Fragment fragment6 = this.c;
            if (fragment6.C) {
                fragment6.K.setVisibility(8);
            }
            if (ga.I(this.c.K)) {
                ga.W(this.c.K);
            } else {
                View fragmentView = this.c.K;
                fragmentView.addOnAttachStateChangeListener(new a(fragmentView));
            }
            this.c.g1();
            cc ccVar = this.a;
            Fragment fragment7 = this.c;
            ccVar.m(fragment7, fragment7.K, fragment7.d, false);
            int postOnViewCreatedVisibility = this.c.K.getVisibility();
            float postOnViewCreatedAlpha = this.c.K.getAlpha();
            if (dc.b) {
                this.c.w1(postOnViewCreatedAlpha);
                Fragment fragment8 = this.c;
                if (fragment8.J != null && postOnViewCreatedVisibility == 0) {
                    View focusedView = fragment8.K.findFocus();
                    if (focusedView != null) {
                        this.c.r1(focusedView);
                        if (dc.F0(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + focusedView + " for Fragment " + this.c);
                        }
                    }
                    this.c.K.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.c;
                if (postOnViewCreatedVisibility == 0 && fragment9.J != null) {
                    z = true;
                }
                fragment9.P = z;
            }
        }
        this.c.b = 2;
    }

    /* compiled from: FragmentStateManager.java */
    /* renamed from: kc$a */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            this.a.removeOnAttachStateChangeListener(this);
            ga.W(this.a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
        }
    }

    public void a() {
        if (dc.F0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        fragment.J0(fragment.d);
        cc ccVar = this.a;
        Fragment fragment2 = this.c;
        ccVar.a(fragment2, fragment2.d, false);
    }

    public void u() {
        if (dc.F0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.c);
        }
        this.c.e1();
        this.a.k(this.c, false);
    }

    public void p() {
        if (dc.F0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.c);
        }
        View focusedView = this.c.w();
        if (focusedView != null && l(focusedView)) {
            boolean success = focusedView.requestFocus();
            if (dc.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(success ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.c);
                sb.append(" resulting in focused view ");
                sb.append(this.c.K.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.c.r1(null);
        this.c.c1();
        this.a.i(this.c, false);
        Fragment fragment = this.c;
        fragment.d = null;
        fragment.f = null;
        fragment.g = null;
    }

    public final boolean l(View view) {
        if (view == this.c.K) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.c.K) {
                return true;
            }
        }
        return false;
    }

    public void n() {
        if (dc.F0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.c);
        }
        this.c.Y0();
        this.a.f(this.c, false);
    }

    public void v() {
        if (dc.F0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.c);
        }
        this.c.f1();
        this.a.l(this.c, false);
    }

    public jc r() {
        jc fs = new jc(this.c);
        Fragment fragment = this.c;
        if (fragment.b > -1 && fs.o == null) {
            Bundle q = q();
            fs.o = q;
            if (this.c.l != null) {
                if (q == null) {
                    fs.o = new Bundle();
                }
                fs.o.putString("android:target_state", this.c.l);
                int i = this.c.m;
                if (i != 0) {
                    fs.o.putInt("android:target_req_state", i);
                }
            }
        } else {
            fs.o = fragment.d;
        }
        return fs;
    }

    public final Bundle q() {
        Bundle result = new Bundle();
        this.c.d1(result);
        this.a.j(this.c, result, false);
        if (result.isEmpty()) {
            result = null;
        }
        if (this.c.K != null) {
            s();
        }
        if (this.c.f != null) {
            if (result == null) {
                result = new Bundle();
            }
            result.putSparseParcelableArray("android:view_state", this.c.f);
        }
        if (this.c.g != null) {
            if (result == null) {
                result = new Bundle();
            }
            result.putBundle("android:view_registry_state", this.c.g);
        }
        if (!this.c.M) {
            if (result == null) {
                result = new Bundle();
            }
            result.putBoolean("android:user_visible_hint", this.c.M);
        }
        return result;
    }

    public void s() {
        if (this.c.K == null) {
            return;
        }
        SparseArray<Parcelable> mStateArray = new SparseArray<>();
        this.c.K.saveHierarchyState(mStateArray);
        if (mStateArray.size() > 0) {
            this.c.f = mStateArray;
        }
        Bundle outBundle = new Bundle();
        this.c.W.h(outBundle);
        if (!outBundle.isEmpty()) {
            this.c.g = outBundle;
        }
    }

    public void h() {
        View view;
        if (dc.F0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.c);
        }
        Fragment fragment = this.c;
        ViewGroup viewGroup = fragment.J;
        if (viewGroup != null && (view = fragment.K) != null) {
            viewGroup.removeView(view);
        }
        this.c.R0();
        this.a.n(this.c, false);
        Fragment fragment2 = this.c;
        fragment2.J = null;
        fragment2.K = null;
        fragment2.W = null;
        fragment2.X.i(null);
        this.c.r = false;
    }

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<?> */
    public void g() {
        Fragment target;
        boolean shouldClear;
        if (dc.F0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        boolean beingRemoved = fragment.p && !fragment.V();
        boolean shouldDestroy = beingRemoved || this.b.o().o(this.c);
        if (shouldDestroy) {
            ac<?> acVar = this.c.w;
            if (acVar instanceof sd) {
                shouldClear = this.b.o().l();
            } else if (acVar.k() instanceof Activity) {
                Activity activity = (Activity) acVar.k();
                shouldClear = true ^ activity.isChangingConfigurations();
            } else {
                shouldClear = true;
            }
            if (beingRemoved || shouldClear) {
                this.b.o().f(this.c);
            }
            this.c.Q0();
            this.a.d(this.c, false);
            for (kc fragmentStateManager : this.b.k()) {
                if (fragmentStateManager != null) {
                    Fragment fragment2 = fragmentStateManager.k();
                    if (this.c.i.equals(fragment2.l)) {
                        fragment2.k = this.c;
                        fragment2.l = null;
                    }
                }
            }
            Fragment fragment3 = this.c;
            String str = fragment3.l;
            if (str != null) {
                fragment3.k = this.b.f(str);
            }
            this.b.q(this);
            return;
        }
        String str2 = this.c.l;
        if (str2 != null && (target = this.b.f(str2)) != null && target.E) {
            this.c.k = target;
        }
        this.c.b = 0;
    }

    public void i() {
        if (dc.F0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.c);
        }
        this.c.S0();
        boolean z = false;
        this.a.e(this.c, false);
        Fragment fragment = this.c;
        fragment.b = -1;
        fragment.w = null;
        fragment.y = null;
        fragment.v = null;
        if (fragment.p && !fragment.V()) {
            z = true;
        }
        boolean beingRemoved = z;
        if (beingRemoved || this.b.o().o(this.c)) {
            if (dc.F0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.c);
            }
            this.c.R();
        }
    }

    public void b() {
        int index = this.b.j(this.c);
        Fragment fragment = this.c;
        fragment.J.addView(fragment.K, index);
    }
}
