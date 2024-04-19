package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import defpackage.sc;
import defpackage.t8;
import defpackage.wb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: DefaultSpecialEffectsController.java */
/* renamed from: vb  reason: default package */
/* loaded from: classes.dex */
public class vb extends sc {
    public vb(ViewGroup container) {
        super(container);
    }

    @Override // defpackage.sc
    public void f(List<sc.e> list, boolean isPop) {
        sc.e firstOut = null;
        sc.e lastIn = null;
        for (sc.e operation : list) {
            sc.e.c currentState = sc.e.c.c(operation.f().K);
            switch (a.a[operation.e().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    if (currentState == sc.e.c.VISIBLE && firstOut == null) {
                        firstOut = operation;
                        break;
                    }
                    break;
                case 4:
                    if (currentState != sc.e.c.VISIBLE) {
                        lastIn = operation;
                        break;
                    } else {
                        break;
                    }
            }
        }
        List<DefaultSpecialEffectsController.AnimationInfo> animations = new ArrayList<>();
        List<DefaultSpecialEffectsController.TransitionInfo> transitions = new ArrayList<>();
        List<SpecialEffectsController.Operation> awaitingContainerChanges = new ArrayList<>(list);
        Iterator<sc.e> it = list.iterator();
        while (true) {
            boolean z = true;
            if (it.hasNext()) {
                sc.e operation2 = it.next();
                t8 animCancellationSignal = new t8();
                operation2.j(animCancellationSignal);
                animations.add(new k(operation2, animCancellationSignal, isPop));
                t8 transitionCancellationSignal = new t8();
                operation2.j(transitionCancellationSignal);
                if (isPop) {
                    if (operation2 == firstOut) {
                        transitions.add(new m(operation2, transitionCancellationSignal, isPop, z));
                        operation2.a(new b(awaitingContainerChanges, operation2));
                    }
                    z = false;
                    transitions.add(new m(operation2, transitionCancellationSignal, isPop, z));
                    operation2.a(new b(awaitingContainerChanges, operation2));
                } else {
                    if (operation2 == lastIn) {
                        transitions.add(new m(operation2, transitionCancellationSignal, isPop, z));
                        operation2.a(new b(awaitingContainerChanges, operation2));
                    }
                    z = false;
                    transitions.add(new m(operation2, transitionCancellationSignal, isPop, z));
                    operation2.a(new b(awaitingContainerChanges, operation2));
                }
            } else {
                Map<sc.e, Boolean> x = x(transitions, awaitingContainerChanges, isPop, firstOut, lastIn);
                boolean startedAnyTransition = x.containsValue(true);
                w(animations, awaitingContainerChanges, startedAnyTransition, x);
                Iterator<sc.e> it2 = awaitingContainerChanges.iterator();
                while (it2.hasNext()) {
                    s(it2.next());
                }
                awaitingContainerChanges.clear();
                return;
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[sc.e.c.values().length];
            a = iArr;
            try {
                iArr[sc.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[sc.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[sc.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[sc.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ sc.e b;

        public b(List list, sc.e eVar) {
            this.a = list;
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.contains(this.b)) {
                this.a.remove(this.b);
                vb.this.s(this.b);
            }
        }
    }

    public final void w(List<k> list, List<sc.e> list2, boolean startedAnyTransition, Map<sc.e, Boolean> map) {
        ViewGroup container = m();
        Context context = container.getContext();
        ArrayList<DefaultSpecialEffectsController.AnimationInfo> animationsToRun = new ArrayList<>();
        View viewToAnimate = null;
        Iterator<k> it = list.iterator();
        while (it.hasNext()) {
            k animationInfo = it.next();
            if (animationInfo.d()) {
                animationInfo.a();
            } else {
                wb.d anim = animationInfo.e(context);
                if (anim == null) {
                    animationInfo.a();
                } else {
                    Animator animator = anim.b;
                    if (animator == null) {
                        animationsToRun.add(animationInfo);
                    } else {
                        sc.e operation = animationInfo.b();
                        Fragment fragment = operation.f();
                        boolean startedTransition = Boolean.TRUE.equals(map.get(operation));
                        if (startedTransition) {
                            if (dc.F0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            animationInfo.a();
                        } else {
                            boolean isHideOperation = operation.e() == sc.e.c.GONE;
                            if (isHideOperation) {
                                list2.remove(operation);
                            }
                            View viewToAnimate2 = fragment.K;
                            container.startViewTransition(viewToAnimate2);
                            animator.addListener(new c(container, viewToAnimate2, isHideOperation, operation, animationInfo));
                            animator.setTarget(viewToAnimate2);
                            animator.start();
                            t8 signal = animationInfo.c();
                            signal.c(new d(animator));
                            viewToAnimate = 1;
                            it = it;
                        }
                    }
                }
            }
        }
        Iterator<DefaultSpecialEffectsController.AnimationInfo> it2 = animationsToRun.iterator();
        while (it2.hasNext()) {
            k animationInfo2 = (k) it2.next();
            sc.e operation2 = animationInfo2.b();
            Fragment fragment2 = operation2.f();
            if (startedAnyTransition) {
                if (dc.F0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.a();
            } else if (viewToAnimate != null) {
                if (dc.F0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.a();
            } else {
                View viewToAnimate3 = fragment2.K;
                Animation anim2 = (Animation) k9.d(((wb.d) k9.d(animationInfo2.e(context))).a);
                sc.e.c finalState = operation2.e();
                if (finalState != sc.e.c.REMOVED) {
                    viewToAnimate3.startAnimation(anim2);
                    animationInfo2.a();
                } else {
                    container.startViewTransition(viewToAnimate3);
                    Animation animation = new wb.e(anim2, container, viewToAnimate3);
                    animation.setAnimationListener(new e(container, viewToAnimate3, animationInfo2));
                    viewToAnimate3.startAnimation(animation);
                }
                t8 signal2 = animationInfo2.c();
                signal2.c(new f(viewToAnimate3, container, animationInfo2));
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$c */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ sc.e f;
        public final /* synthetic */ k g;

        public c(ViewGroup viewGroup, View view, boolean z, sc.e eVar, k kVar) {
            this.a = viewGroup;
            this.b = view;
            this.d = z;
            this.f = eVar;
            this.g = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator anim) {
            this.a.endViewTransition(this.b);
            if (this.d) {
                this.f.e().a(this.b);
            }
            this.g.a();
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$d */
    /* loaded from: classes.dex */
    public class d implements t8.a {
        public final /* synthetic */ Animator a;

        public d(Animator animator) {
            this.a = animator;
        }

        @Override // defpackage.t8.a
        public void a() {
            this.a.end();
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$e */
    /* loaded from: classes.dex */
    public class e implements Animation.AnimationListener {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ k c;

        public e(ViewGroup viewGroup, View view, k kVar) {
            this.a = viewGroup;
            this.b = view;
            this.c = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        /* compiled from: DefaultSpecialEffectsController.java */
        /* renamed from: vb$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.a.endViewTransition(eVar.b);
                e.this.c.a();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$f */
    /* loaded from: classes.dex */
    public class f implements t8.a {
        public final /* synthetic */ View a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ k c;

        public f(View view, ViewGroup viewGroup, k kVar) {
            this.a = view;
            this.b = viewGroup;
            this.c = kVar;
        }

        @Override // defpackage.t8.a
        public void a() {
            this.a.clearAnimation();
            this.b.endViewTransition(this.a);
            this.c.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x050f, code lost:
        if (r11 == r43) goto L196;
     */
    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.String> */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0564  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<defpackage.sc.e, java.lang.Boolean> x(java.util.List<defpackage.vb.m> r39, java.util.List<defpackage.sc.e> r40, boolean r41, defpackage.sc.e r42, defpackage.sc.e r43) {
        /*
            Method dump skipped, instructions count: 1467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vb.x(java.util.List, java.util.List, boolean, sc$e, sc$e):java.util.Map");
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$g */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        public final /* synthetic */ sc.e a;
        public final /* synthetic */ sc.e b;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ t3 f;

        public g(sc.e eVar, sc.e eVar2, boolean z, t3 t3Var) {
            this.a = eVar;
            this.b = eVar2;
            this.d = z;
            this.f = t3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            nc.f(this.a.f(), this.b.f(), this.d, this.f, false);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$h */
    /* loaded from: classes.dex */
    public class h implements Runnable {
        public final /* synthetic */ pc a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Rect d;

        public h(pc pcVar, View view, Rect rect) {
            this.a = pcVar;
            this.b = view;
            this.d = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.k(this.b, this.d);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$i */
    /* loaded from: classes.dex */
    public class i implements Runnable {
        public final /* synthetic */ ArrayList a;

        public i(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            nc.B(this.a, 4);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$j */
    /* loaded from: classes.dex */
    public class j implements Runnable {
        public final /* synthetic */ m a;

        public j(m mVar) {
            this.a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, android.view.View> */
    public void v(t3<String, View> t3Var, Collection<String> transitionNames) {
        Iterator<Map.Entry<String, View>> iterator = t3Var.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, View> entry = iterator.next();
            if (!transitionNames.contains(ga.C(entry.getValue()))) {
                iterator.remove();
            }
        }
    }

    public void t(ArrayList<View> transitioningViews, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (ia.a(viewGroup)) {
                if (!transitioningViews.contains(view)) {
                    transitioningViews.add(viewGroup);
                    return;
                }
                return;
            }
            int count = viewGroup.getChildCount();
            for (int i2 = 0; i2 < count; i2++) {
                View child = viewGroup.getChildAt(i2);
                if (child.getVisibility() == 0) {
                    t(transitioningViews, child);
                }
            }
        } else if (!transitioningViews.contains(view)) {
            transitioningViews.add(view);
        }
    }

    public void u(Map<String, View> namedViews, View view) {
        String transitionName = ga.C(view);
        if (transitionName != null) {
            namedViews.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int count = viewGroup.getChildCount();
            for (int i2 = 0; i2 < count; i2++) {
                View child = viewGroup.getChildAt(i2);
                if (child.getVisibility() == 0) {
                    u(namedViews, child);
                }
            }
        }
    }

    public void s(sc.e operation) {
        View view = operation.f().K;
        operation.e().a(view);
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$l */
    /* loaded from: classes.dex */
    public static class l {
        public final sc.e a;
        public final t8 b;

        public l(sc.e operation, t8 signal) {
            this.a = operation;
            this.b = signal;
        }

        public sc.e b() {
            return this.a;
        }

        public t8 c() {
            return this.b;
        }

        public boolean d() {
            sc.e.c cVar;
            sc.e.c currentState = sc.e.c.c(this.a.f().K);
            sc.e.c finalState = this.a.e();
            return currentState == finalState || !(currentState == (cVar = sc.e.c.VISIBLE) || finalState == cVar);
        }

        public void a() {
            this.a.d(this.b);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$k */
    /* loaded from: classes.dex */
    public static class k extends l {
        public boolean c;
        public boolean d;
        public wb.d e;

        public k(sc.e operation, t8 signal, boolean isPop) {
            super(operation, signal);
            this.d = false;
            this.c = isPop;
        }

        public wb.d e(Context context) {
            if (this.d) {
                return this.e;
            }
            wb.d c = wb.c(context, b().f(), b().e() == sc.e.c.VISIBLE, this.c);
            this.e = c;
            this.d = true;
            return c;
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: vb$m */
    /* loaded from: classes.dex */
    public static class m extends l {
        public final Object c;
        public final boolean d;
        public final Object e;

        public m(sc.e operation, t8 signal, boolean isPop, boolean providesSharedElementTransition) {
            super(operation, signal);
            Object u;
            Object r;
            boolean k;
            if (operation.e() == sc.e.c.VISIBLE) {
                if (isPop) {
                    r = operation.f().H();
                } else {
                    r = operation.f().r();
                }
                this.c = r;
                if (isPop) {
                    k = operation.f().l();
                } else {
                    k = operation.f().k();
                }
                this.d = k;
            } else {
                if (isPop) {
                    u = operation.f().J();
                } else {
                    u = operation.f().u();
                }
                this.c = u;
                this.d = true;
            }
            if (providesSharedElementTransition) {
                if (isPop) {
                    this.e = operation.f().L();
                    return;
                } else {
                    this.e = operation.f().K();
                    return;
                }
            }
            this.e = null;
        }

        public Object h() {
            return this.c;
        }

        public boolean j() {
            return this.d;
        }

        public boolean i() {
            return this.e != null;
        }

        public Object g() {
            return this.e;
        }

        public pc e() {
            pc transitionImpl = f(this.c);
            pc sharedElementTransitionImpl = f(this.e);
            if (transitionImpl == null || sharedElementTransitionImpl == null || transitionImpl == sharedElementTransitionImpl) {
                return transitionImpl != null ? transitionImpl : sharedElementTransitionImpl;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.c + " which uses a different Transition  type than its shared element transition " + this.e);
        }

        public final pc f(Object transition) {
            if (transition == null) {
                return null;
            }
            pc pcVar = nc.b;
            if (pcVar != null && pcVar.e(transition)) {
                return pcVar;
            }
            pc pcVar2 = nc.c;
            if (pcVar2 != null && pcVar2.e(transition)) {
                return pcVar2;
            }
            throw new IllegalArgumentException("Transition " + transition + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
