package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;
import defpackage.mc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* compiled from: FragmentTransition.java */
/* renamed from: nc  reason: default package */
/* loaded from: classes.dex */
public class nc {
    public static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    public static final pc b;
    public static final pc c;

    /* compiled from: FragmentTransition.java */
    /* renamed from: nc$g */
    /* loaded from: classes.dex */
    public interface g {
        void a(Fragment fragment, t8 t8Var);

        void b(Fragment fragment, t8 t8Var);
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: nc$h */
    /* loaded from: classes.dex */
    public static class h {
        public Fragment a;
        public boolean b;
        public tb c;
        public Fragment d;
        public boolean e;
        public tb f;
    }

    static {
        oc ocVar;
        if (Build.VERSION.SDK_INT >= 21) {
            ocVar = new oc();
        } else {
            ocVar = null;
        }
        b = ocVar;
        c = x();
    }

    public static pc x() {
        try {
            return (pc) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static void C(Context context, xb fragmentContainer, ArrayList<tb> arrayList, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex, boolean isReordered, g callback) {
        ViewGroup container;
        SparseArray<FragmentTransition.FragmentContainerTransition> transitioningFragments = new SparseArray<>();
        for (int i = startIndex; i < endIndex; i++) {
            tb record = arrayList.get(i);
            boolean isPop = isRecordPop.get(i).booleanValue();
            if (isPop) {
                e(record, transitioningFragments, isReordered);
            } else {
                c(record, transitioningFragments, isReordered);
            }
        }
        int i2 = transitioningFragments.size();
        if (i2 != 0) {
            View nonExistentView = new View(context);
            int numContainers = transitioningFragments.size();
            for (int i3 = 0; i3 < numContainers; i3++) {
                int containerId = transitioningFragments.keyAt(i3);
                t3<String, String> d2 = d(containerId, arrayList, isRecordPop, startIndex, endIndex);
                h containerTransition = (h) transitioningFragments.valueAt(i3);
                if (fragmentContainer.h() && (container = (ViewGroup) fragmentContainer.f(containerId)) != null) {
                    if (isReordered) {
                        o(container, containerTransition, nonExistentView, d2, callback);
                    } else {
                        n(container, containerTransition, nonExistentView, d2, callback);
                    }
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static t3<String, String> d(int containerId, ArrayList<tb> arrayList, ArrayList<Boolean> isRecordPop, int startIndex, int endIndex) {
        ArrayList<String> sources;
        ArrayList<String> targets;
        t3<String, String> t3Var = new t3<>();
        for (int recordNum = endIndex - 1; recordNum >= startIndex; recordNum--) {
            tb record = arrayList.get(recordNum);
            if (record.t(containerId)) {
                boolean isPop = isRecordPop.get(recordNum).booleanValue();
                ArrayList<String> arrayList2 = record.p;
                if (arrayList2 != null) {
                    int numSharedElements = arrayList2.size();
                    if (isPop) {
                        targets = record.p;
                        sources = record.q;
                    } else {
                        sources = record.p;
                        targets = record.q;
                    }
                    for (int i = 0; i < numSharedElements; i++) {
                        String sourceName = sources.get(i);
                        String targetName = targets.get(i);
                        String previousTarget = t3Var.remove(targetName);
                        if (previousTarget != null) {
                            t3Var.put(sourceName, previousTarget);
                        } else {
                            t3Var.put(sourceName, targetName);
                        }
                    }
                }
            }
        }
        return t3Var;
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static void o(ViewGroup container, h fragments, View nonExistentView, t3<String, String> t3Var, g callback) {
        Object exitTransition;
        ArrayList<View> sharedElementsIn;
        Fragment inFragment = fragments.a;
        Fragment outFragment = fragments.d;
        pc impl = j(outFragment, inFragment);
        if (impl == null) {
            return;
        }
        boolean inIsPop = fragments.b;
        boolean outIsPop = fragments.e;
        ArrayList<View> sharedElementsIn2 = new ArrayList<>();
        ArrayList<View> sharedElementsOut = new ArrayList<>();
        Object enterTransition = r(impl, inFragment, inIsPop);
        Object exitTransition2 = s(impl, outFragment, outIsPop);
        Object sharedElementTransition = m(impl, container, nonExistentView, t3Var, fragments, sharedElementsOut, sharedElementsIn2, enterTransition, exitTransition2);
        if (enterTransition == null && sharedElementTransition == null) {
            exitTransition = exitTransition2;
            if (exitTransition == null) {
                return;
            }
        } else {
            exitTransition = exitTransition2;
        }
        ArrayList<View> exitingViews = k(impl, exitTransition, outFragment, sharedElementsOut, nonExistentView);
        ArrayList<View> enteringViews = k(impl, enterTransition, inFragment, sharedElementsIn2, nonExistentView);
        B(enteringViews, 4);
        Object transition = v(impl, enterTransition, exitTransition, sharedElementTransition, inFragment, inIsPop);
        if (outFragment == null || exitingViews == null) {
            sharedElementsIn = sharedElementsIn2;
        } else if (exitingViews.size() > 0 || sharedElementsOut.size() > 0) {
            t8 signal = new t8();
            sharedElementsIn = sharedElementsIn2;
            callback.b(outFragment, signal);
            impl.w(outFragment, transition, signal, new a(callback, outFragment, signal));
        } else {
            sharedElementsIn = sharedElementsIn2;
        }
        if (transition != null) {
            w(impl, exitTransition, outFragment, exitingViews);
            ArrayList<String> inNames = impl.o(sharedElementsIn);
            ArrayList<View> sharedElementsIn3 = sharedElementsIn;
            impl.t(transition, enterTransition, enteringViews, exitTransition, exitingViews, sharedElementTransition, sharedElementsIn3);
            impl.c(container, transition);
            impl.y(container, sharedElementsOut, sharedElementsIn3, inNames, t3Var);
            B(enteringViews, 0);
            impl.A(sharedElementTransition, sharedElementsOut, sharedElementsIn3);
        }
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: nc$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ g a;
        public final /* synthetic */ Fragment b;
        public final /* synthetic */ t8 d;

        public a(g gVar, Fragment fragment, t8 t8Var) {
            this.a = gVar;
            this.b = fragment;
            this.d = t8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.d);
        }
    }

    public static void w(pc impl, Object exitTransition, Fragment exitingFragment, ArrayList<View> exitingViews) {
        if (exitingFragment != null && exitTransition != null && exitingFragment.o && exitingFragment.C && exitingFragment.Q) {
            exitingFragment.s1(true);
            impl.r(exitTransition, exitingFragment.P(), exitingViews);
            ViewGroup container = exitingFragment.J;
            ea.a(container, new b(exitingViews));
        }
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: nc$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ ArrayList a;

        public b(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            nc.B(this.a, 4);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static void n(ViewGroup container, h fragments, View nonExistentView, t3<String, String> t3Var, g callback) {
        Object exitTransition;
        Fragment inFragment = fragments.a;
        Fragment outFragment = fragments.d;
        pc impl = j(outFragment, inFragment);
        if (impl == null) {
            return;
        }
        boolean inIsPop = fragments.b;
        boolean outIsPop = fragments.e;
        Object enterTransition = r(impl, inFragment, inIsPop);
        Object exitTransition2 = s(impl, outFragment, outIsPop);
        ArrayList<View> sharedElementsOut = new ArrayList<>();
        ArrayList<View> sharedElementsIn = new ArrayList<>();
        Object sharedElementTransition = l(impl, container, nonExistentView, t3Var, fragments, sharedElementsOut, sharedElementsIn, enterTransition, exitTransition2);
        if (enterTransition == null && sharedElementTransition == null) {
            exitTransition = exitTransition2;
            if (exitTransition == null) {
                return;
            }
        } else {
            exitTransition = exitTransition2;
        }
        ArrayList<View> exitingViews = k(impl, exitTransition, outFragment, sharedElementsOut, nonExistentView);
        Object exitTransition3 = (exitingViews == null || exitingViews.isEmpty()) ? null : exitTransition;
        impl.a(enterTransition, nonExistentView);
        Object transition = v(impl, enterTransition, exitTransition3, sharedElementTransition, inFragment, fragments.b);
        if (outFragment != null && exitingViews != null && (exitingViews.size() > 0 || sharedElementsOut.size() > 0)) {
            t8 signal = new t8();
            callback.b(outFragment, signal);
            impl.w(outFragment, transition, signal, new c(callback, outFragment, signal));
        }
        if (transition != null) {
            ArrayList<View> enteringViews = new ArrayList<>();
            impl.t(transition, enterTransition, enteringViews, exitTransition3, exitingViews, sharedElementTransition, sharedElementsIn);
            z(impl, container, inFragment, nonExistentView, sharedElementsIn, enterTransition, enteringViews, exitTransition3, exitingViews);
            impl.x(container, sharedElementsIn, t3Var);
            impl.c(container, transition);
            impl.s(container, sharedElementsIn, t3Var);
        }
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: nc$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ g a;
        public final /* synthetic */ Fragment b;
        public final /* synthetic */ t8 d;

        public c(g gVar, Fragment fragment, t8 t8Var) {
            this.a = gVar;
            this.b = fragment;
            this.d = t8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.d);
        }
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: nc$d */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ pc b;
        public final /* synthetic */ View d;
        public final /* synthetic */ Fragment f;
        public final /* synthetic */ ArrayList g;
        public final /* synthetic */ ArrayList h;
        public final /* synthetic */ ArrayList i;
        public final /* synthetic */ Object j;

        public d(Object obj, pc pcVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.a = obj;
            this.b = pcVar;
            this.d = view;
            this.f = fragment;
            this.g = arrayList;
            this.h = arrayList2;
            this.i = arrayList3;
            this.j = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.a;
            if (obj != null) {
                this.b.p(obj, this.d);
                ArrayList<View> views = nc.k(this.b, this.a, this.f, this.g, this.d);
                this.h.addAll(views);
            }
            ArrayList<View> views2 = this.i;
            if (views2 != null) {
                if (this.j != null) {
                    ArrayList<View> tempExiting = new ArrayList<>();
                    tempExiting.add(this.d);
                    this.b.q(this.j, this.i, tempExiting);
                }
                this.i.clear();
                this.i.add(this.d);
            }
        }
    }

    public static void z(pc impl, ViewGroup sceneRoot, Fragment inFragment, View nonExistentView, ArrayList<View> sharedElementsIn, Object enterTransition, ArrayList<View> enteringViews, Object exitTransition, ArrayList<View> exitingViews) {
        ea.a(sceneRoot, new d(enterTransition, impl, nonExistentView, inFragment, sharedElementsIn, enteringViews, exitingViews, exitTransition));
    }

    public static pc j(Fragment outFragment, Fragment inFragment) {
        ArrayList<Object> transitions = new ArrayList<>();
        if (outFragment != null) {
            Object exitTransition = outFragment.u();
            if (exitTransition != null) {
                transitions.add(exitTransition);
            }
            Object returnTransition = outFragment.J();
            if (returnTransition != null) {
                transitions.add(returnTransition);
            }
            Object sharedReturnTransition = outFragment.L();
            if (sharedReturnTransition != null) {
                transitions.add(sharedReturnTransition);
            }
        }
        if (inFragment != null) {
            Object enterTransition = inFragment.r();
            if (enterTransition != null) {
                transitions.add(enterTransition);
            }
            Object reenterTransition = inFragment.H();
            if (reenterTransition != null) {
                transitions.add(reenterTransition);
            }
            Object sharedEnterTransition = inFragment.K();
            if (sharedEnterTransition != null) {
                transitions.add(sharedEnterTransition);
            }
        }
        if (transitions.isEmpty()) {
            return null;
        }
        pc pcVar = b;
        if (pcVar != null && g(pcVar, transitions)) {
            return pcVar;
        }
        pc pcVar2 = c;
        if (pcVar2 != null && g(pcVar2, transitions)) {
            return pcVar2;
        }
        if (pcVar == null && pcVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static boolean g(pc impl, List<Object> transitions) {
        int size = transitions.size();
        for (int i = 0; i < size; i++) {
            if (!impl.e(transitions.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static Object u(pc impl, Fragment inFragment, Fragment outFragment, boolean isPop) {
        Object K;
        if (inFragment == null || outFragment == null) {
            return null;
        }
        if (isPop) {
            K = outFragment.L();
        } else {
            K = inFragment.K();
        }
        Object transition = impl.g(K);
        return impl.B(transition);
    }

    public static Object r(pc impl, Fragment inFragment, boolean isPop) {
        Object r;
        if (inFragment == null) {
            return null;
        }
        if (isPop) {
            r = inFragment.H();
        } else {
            r = inFragment.r();
        }
        return impl.g(r);
    }

    public static Object s(pc impl, Fragment outFragment, boolean isPop) {
        Object u;
        if (outFragment == null) {
            return null;
        }
        if (isPop) {
            u = outFragment.J();
        } else {
            u = outFragment.u();
        }
        return impl.g(u);
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static Object m(pc impl, ViewGroup sceneRoot, View nonExistentView, t3<String, String> t3Var, h fragments, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn, Object enterTransition, Object exitTransition) {
        Object sharedElementTransition;
        Object sharedElementTransition2;
        Object sharedElementTransition3;
        t3<String, View> t3Var2;
        Rect epicenter;
        View epicenterView;
        Fragment inFragment = fragments.a;
        Fragment outFragment = fragments.d;
        if (inFragment != null) {
            inFragment.j1().setVisibility(0);
        }
        if (inFragment != null && outFragment != null) {
            boolean inIsPop = fragments.b;
            if (t3Var.isEmpty()) {
                sharedElementTransition = null;
            } else {
                sharedElementTransition = u(impl, inFragment, outFragment, inIsPop);
            }
            t3<String, View> i = i(impl, t3Var, sharedElementTransition, fragments);
            t3<String, View> h2 = h(impl, t3Var, sharedElementTransition, fragments);
            if (t3Var.isEmpty()) {
                if (i != null) {
                    i.clear();
                }
                if (h2 != null) {
                    h2.clear();
                }
                sharedElementTransition2 = null;
            } else {
                a(sharedElementsOut, i, t3Var.keySet());
                a(sharedElementsIn, h2, t3Var.values());
                sharedElementTransition2 = sharedElementTransition;
            }
            if (enterTransition == null && exitTransition == null && sharedElementTransition2 == null) {
                return null;
            }
            f(inFragment, outFragment, inIsPop, i, true);
            if (sharedElementTransition2 != null) {
                sharedElementsIn.add(nonExistentView);
                impl.z(sharedElementTransition2, nonExistentView, sharedElementsOut);
                boolean outIsPop = fragments.e;
                tb outTransaction = fragments.f;
                sharedElementTransition3 = sharedElementTransition2;
                t3Var2 = h2;
                A(impl, sharedElementTransition2, exitTransition, i, outIsPop, outTransaction);
                Rect epicenter2 = new Rect();
                View epicenterView2 = t(t3Var2, fragments, enterTransition, inIsPop);
                if (epicenterView2 != null) {
                    impl.u(enterTransition, epicenter2);
                }
                epicenter = epicenter2;
                epicenterView = epicenterView2;
            } else {
                sharedElementTransition3 = sharedElementTransition2;
                t3Var2 = h2;
                epicenter = null;
                epicenterView = null;
            }
            ea.a(sceneRoot, new e(inFragment, outFragment, inIsPop, t3Var2, epicenterView, impl, epicenter));
            return sharedElementTransition3;
        }
        return null;
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: nc$e */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        public final /* synthetic */ Fragment a;
        public final /* synthetic */ Fragment b;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ t3 f;
        public final /* synthetic */ View g;
        public final /* synthetic */ pc h;
        public final /* synthetic */ Rect i;

        public e(Fragment fragment, Fragment fragment2, boolean z, t3 t3Var, View view, pc pcVar, Rect rect) {
            this.a = fragment;
            this.b = fragment2;
            this.d = z;
            this.f = t3Var;
            this.g = view;
            this.h = pcVar;
            this.i = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            nc.f(this.a, this.b, this.d, this.f, false);
            View view = this.g;
            if (view != null) {
                this.h.k(view, this.i);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    public static void a(ArrayList<View> views, t3<String, View> t3Var, Collection<String> nameOverridesSet) {
        for (int i = t3Var.size() - 1; i >= 0; i--) {
            View view = t3Var.l(i);
            if (nameOverridesSet.contains(ga.C(view))) {
                views.add(view);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static Object l(pc impl, ViewGroup sceneRoot, View nonExistentView, t3<String, String> t3Var, h fragments, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn, Object enterTransition, Object exitTransition) {
        Object sharedElementTransition;
        Object sharedElementTransition2;
        Rect inEpicenter;
        Fragment inFragment = fragments.a;
        Fragment outFragment = fragments.d;
        if (inFragment != null && outFragment != null) {
            boolean inIsPop = fragments.b;
            if (t3Var.isEmpty()) {
                sharedElementTransition = null;
            } else {
                sharedElementTransition = u(impl, inFragment, outFragment, inIsPop);
            }
            t3<String, View> i = i(impl, t3Var, sharedElementTransition, fragments);
            if (t3Var.isEmpty()) {
                sharedElementTransition2 = null;
            } else {
                sharedElementsOut.addAll(i.values());
                sharedElementTransition2 = sharedElementTransition;
            }
            if (enterTransition == null && exitTransition == null && sharedElementTransition2 == null) {
                return null;
            }
            f(inFragment, outFragment, inIsPop, i, true);
            if (sharedElementTransition2 != null) {
                Rect inEpicenter2 = new Rect();
                impl.z(sharedElementTransition2, nonExistentView, sharedElementsOut);
                boolean outIsPop = fragments.e;
                tb outTransaction = fragments.f;
                A(impl, sharedElementTransition2, exitTransition, i, outIsPop, outTransaction);
                if (enterTransition != null) {
                    impl.u(enterTransition, inEpicenter2);
                }
                inEpicenter = inEpicenter2;
            } else {
                inEpicenter = null;
            }
            Object finalSharedElementTransition = sharedElementTransition2;
            Object sharedElementTransition3 = sharedElementTransition2;
            ea.a(sceneRoot, new f(impl, t3Var, finalSharedElementTransition, fragments, sharedElementsIn, nonExistentView, inFragment, outFragment, inIsPop, sharedElementsOut, enterTransition, inEpicenter));
            return sharedElementTransition3;
        }
        return null;
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: nc$f */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        public final /* synthetic */ pc a;
        public final /* synthetic */ t3 b;
        public final /* synthetic */ Object d;
        public final /* synthetic */ h f;
        public final /* synthetic */ ArrayList g;
        public final /* synthetic */ View h;
        public final /* synthetic */ Fragment i;
        public final /* synthetic */ Fragment j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ ArrayList l;
        public final /* synthetic */ Object m;
        public final /* synthetic */ Rect n;

        public f(pc pcVar, t3 t3Var, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.a = pcVar;
            this.b = t3Var;
            this.d = obj;
            this.f = hVar;
            this.g = arrayList;
            this.h = view;
            this.i = fragment;
            this.j = fragment2;
            this.k = z;
            this.l = arrayList2;
            this.m = obj2;
            this.n = rect;
        }

        /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
        @Override // java.lang.Runnable
        public void run() {
            t3<String, View> h = nc.h(this.a, this.b, this.d, this.f);
            if (h != null) {
                this.g.addAll(h.values());
                this.g.add(this.h);
            }
            nc.f(this.i, this.j, this.k, h, false);
            Object obj = this.d;
            if (obj != null) {
                this.a.A(obj, this.l, this.g);
                View inEpicenterView = nc.t(h, this.f, this.m, this.k);
                if (inEpicenterView != null) {
                    this.a.k(inEpicenterView, this.n);
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static t3<String, View> i(pc impl, t3<String, String> t3Var, Object sharedElementTransition, h fragments) {
        k7 sharedElementCallback;
        ArrayList<String> names;
        if (t3Var.isEmpty() || sharedElementTransition == null) {
            t3Var.clear();
            return null;
        }
        Fragment outFragment = fragments.d;
        t3<String, View> t3Var2 = new t3<>();
        impl.j(t3Var2, outFragment.j1());
        tb outTransaction = fragments.f;
        if (fragments.e) {
            sharedElementCallback = outFragment.s();
            names = outTransaction.q;
        } else {
            sharedElementCallback = outFragment.v();
            names = outTransaction.p;
        }
        if (names != null) {
            t3Var2.n(names);
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.a(names, t3Var2);
            for (int i = names.size() - 1; i >= 0; i--) {
                String name = names.get(i);
                View view = t3Var2.get(name);
                if (view == null) {
                    t3Var.remove(name);
                } else if (!name.equals(ga.C(view))) {
                    String targetValue = t3Var.remove(name);
                    t3Var.put(ga.C(view), targetValue);
                }
            }
        } else {
            t3Var.n(t3Var2.keySet());
        }
        return t3Var2;
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static t3<String, View> h(pc impl, t3<String, String> t3Var, Object sharedElementTransition, h fragments) {
        k7 sharedElementCallback;
        ArrayList<String> names;
        String key;
        Fragment inFragment = fragments.a;
        View fragmentView = inFragment.P();
        if (t3Var.isEmpty() || sharedElementTransition == null || fragmentView == null) {
            t3Var.clear();
            return null;
        }
        t3<String, View> t3Var2 = new t3<>();
        impl.j(t3Var2, fragmentView);
        tb inTransaction = fragments.c;
        if (fragments.b) {
            sharedElementCallback = inFragment.v();
            names = inTransaction.p;
        } else {
            sharedElementCallback = inFragment.s();
            names = inTransaction.q;
        }
        if (names != null) {
            t3Var2.n(names);
            t3Var2.n(t3Var.values());
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.a(names, t3Var2);
            for (int i = names.size() - 1; i >= 0; i--) {
                String name = names.get(i);
                View view = t3Var2.get(name);
                if (view == null) {
                    String key2 = q(t3Var, name);
                    if (key2 != null) {
                        t3Var.remove(key2);
                    }
                } else if (!name.equals(ga.C(view)) && (key = q(t3Var, name)) != null) {
                    t3Var.put(key, ga.C(view));
                }
            }
        } else {
            y(t3Var, t3Var2);
        }
        return t3Var2;
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static String q(t3<String, String> t3Var, String value) {
        int numElements = t3Var.size();
        for (int i = 0; i < numElements; i++) {
            if (value.equals(t3Var.l(i))) {
                return t3Var.i(i);
            }
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    public static View t(t3<String, View> t3Var, h fragments, Object enterTransition, boolean inIsPop) {
        ArrayList<String> arrayList;
        tb inTransaction = fragments.c;
        if (enterTransition != null && t3Var != null && (arrayList = inTransaction.p) != null && !arrayList.isEmpty()) {
            String targetName = inIsPop ? inTransaction.p.get(0) : inTransaction.q.get(0);
            return t3Var.get(targetName);
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    public static void A(pc impl, Object sharedElementTransition, Object exitTransition, t3<String, View> t3Var, boolean outIsPop, tb outTransaction) {
        ArrayList<String> arrayList = outTransaction.p;
        if (arrayList != null && !arrayList.isEmpty()) {
            String sourceName = outIsPop ? outTransaction.q.get(0) : outTransaction.p.get(0);
            View outEpicenterView = t3Var.get(sourceName);
            impl.v(sharedElementTransition, outEpicenterView);
            if (exitTransition != null) {
                impl.v(exitTransition, outEpicenterView);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    public static void y(t3<String, String> t3Var, t3<String, View> t3Var2) {
        for (int i = t3Var.size() - 1; i >= 0; i--) {
            String targetName = t3Var.l(i);
            if (!t3Var2.containsKey(targetName)) {
                t3Var.j(i);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    public static void f(Fragment inFragment, Fragment outFragment, boolean isPop, t3<String, View> t3Var, boolean isStart) {
        k7 sharedElementCallback;
        if (isPop) {
            sharedElementCallback = outFragment.s();
        } else {
            sharedElementCallback = inFragment.s();
        }
        if (sharedElementCallback != null) {
            ArrayList<View> views = new ArrayList<>();
            ArrayList<String> names = new ArrayList<>();
            int count = t3Var == null ? 0 : t3Var.size();
            for (int i = 0; i < count; i++) {
                names.add(t3Var.i(i));
                views.add(t3Var.l(i));
            }
            if (isStart) {
                sharedElementCallback.c(names, views, null);
            } else {
                sharedElementCallback.b(names, views, null);
            }
        }
    }

    public static ArrayList<View> k(pc impl, Object transition, Fragment fragment, ArrayList<View> sharedElements, View nonExistentView) {
        ArrayList<View> viewList = null;
        if (transition != null) {
            viewList = new ArrayList<>();
            View root = fragment.P();
            if (root != null) {
                impl.f(viewList, root);
            }
            if (sharedElements != null) {
                viewList.removeAll(sharedElements);
            }
            if (!viewList.isEmpty()) {
                viewList.add(nonExistentView);
                impl.b(transition, viewList);
            }
        }
        return viewList;
    }

    public static void B(ArrayList<View> views, int visibility) {
        if (views == null) {
            return;
        }
        for (int i = views.size() - 1; i >= 0; i--) {
            View view = views.get(i);
            view.setVisibility(visibility);
        }
    }

    public static Object v(pc impl, Object enterTransition, Object exitTransition, Object sharedElementTransition, Fragment inFragment, boolean isPop) {
        boolean overlap = true;
        if (enterTransition != null && exitTransition != null && inFragment != null) {
            overlap = isPop ? inFragment.l() : inFragment.k();
        }
        if (overlap) {
            Object transition = impl.n(exitTransition, enterTransition, sharedElementTransition);
            return transition;
        }
        Object transition2 = impl.m(exitTransition, enterTransition, sharedElementTransition);
        return transition2;
    }

    public static void c(tb transaction, SparseArray<h> sparseArray, boolean isReordered) {
        int numOps = transaction.c.size();
        for (int opNum = 0; opNum < numOps; opNum++) {
            mc.a op = transaction.c.get(opNum);
            b(transaction, op, sparseArray, false, isReordered);
        }
    }

    public static void e(tb transaction, SparseArray<h> sparseArray, boolean isReordered) {
        if (!transaction.t.o0().h()) {
            return;
        }
        int numOps = transaction.c.size();
        for (int opNum = numOps - 1; opNum >= 0; opNum--) {
            mc.a op = transaction.c.get(opNum);
            b(transaction, op, sparseArray, true, isReordered);
        }
    }

    public static void b(tb transaction, mc.a op, SparseArray<h> sparseArray, boolean isPop, boolean isReorderedTransaction) {
        int containerId;
        View view;
        Fragment fragment = op.b;
        if (fragment == null || (containerId = fragment.A) == 0) {
            return;
        }
        int command = isPop ? a[op.a] : op.a;
        boolean setLastIn = false;
        boolean wasRemoved = false;
        boolean setFirstOut = false;
        boolean wasAdded = false;
        boolean z = true;
        switch (command) {
            case 1:
            case 7:
                if (isReorderedTransaction) {
                    setLastIn = fragment.P;
                } else {
                    if (fragment.o || fragment.C) {
                        z = false;
                    }
                    setLastIn = z;
                }
                wasAdded = true;
                break;
            case 3:
            case 6:
                if (isReorderedTransaction) {
                    if (fragment.o || (view = fragment.K) == null || view.getVisibility() != 0 || fragment.R < 0.0f) {
                        z = false;
                    }
                    setFirstOut = z;
                } else {
                    if (!fragment.o || fragment.C) {
                        z = false;
                    }
                    setFirstOut = z;
                }
                wasRemoved = true;
                break;
            case 4:
                if (isReorderedTransaction) {
                    if (!fragment.Q || !fragment.o || !fragment.C) {
                        z = false;
                    }
                    setFirstOut = z;
                } else {
                    if (!fragment.o || fragment.C) {
                        z = false;
                    }
                    setFirstOut = z;
                }
                wasRemoved = true;
                break;
            case 5:
                if (isReorderedTransaction) {
                    if (!fragment.Q || fragment.C || !fragment.o) {
                        z = false;
                    }
                    setLastIn = z;
                } else {
                    setLastIn = fragment.C;
                }
                wasAdded = true;
                break;
        }
        h containerTransition = sparseArray.get(containerId);
        if (setLastIn) {
            containerTransition = p(containerTransition, sparseArray, containerId);
            containerTransition.a = fragment;
            containerTransition.b = isPop;
            containerTransition.c = transaction;
        }
        if (!isReorderedTransaction && wasAdded) {
            if (containerTransition != null && containerTransition.d == fragment) {
                containerTransition.d = null;
            }
            if (!transaction.r) {
                dc manager = transaction.t;
                kc fragmentStateManager = manager.v(fragment);
                manager.r0().p(fragmentStateManager);
                manager.O0(fragment);
            }
        }
        if (setFirstOut && (containerTransition == null || containerTransition.d == null)) {
            containerTransition = p(containerTransition, sparseArray, containerId);
            containerTransition.d = fragment;
            containerTransition.e = isPop;
            containerTransition.f = transaction;
        }
        if (!isReorderedTransaction && wasRemoved && containerTransition != null && containerTransition.a == fragment) {
            containerTransition.a = null;
        }
    }

    public static h p(h containerTransition, SparseArray<h> sparseArray, int containerId) {
        if (containerTransition == null) {
            h containerTransition2 = new h();
            sparseArray.put(containerId, containerTransition2);
            return containerTransition2;
        }
        return containerTransition;
    }
}
