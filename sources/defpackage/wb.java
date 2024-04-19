package defpackage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.fragment.app.Fragment;
import defpackage.nc;
import defpackage.t8;
/* compiled from: FragmentAnim.java */
/* renamed from: wb  reason: default package */
/* loaded from: classes.dex */
public class wb {
    public static d c(Context context, Fragment fragment, boolean enter, boolean isPop) {
        int transit = fragment.A();
        int nextAnim = b(fragment, enter, isPop);
        fragment.o1(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.J;
        if (viewGroup != null) {
            int i = rb.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i) != null) {
                fragment.J.setTag(i, null);
            }
        }
        ViewGroup viewGroup2 = fragment.J;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation animation = fragment.j0(transit, enter, nextAnim);
            if (animation != null) {
                return new d(animation);
            }
            Animator animator = fragment.k0(transit, enter, nextAnim);
            if (animator != null) {
                return new d(animator);
            }
            if (nextAnim == 0 && transit != 0) {
                nextAnim = d(transit, enter);
            }
            if (nextAnim != 0) {
                String dir = context.getResources().getResourceTypeName(nextAnim);
                boolean isAnim = "anim".equals(dir);
                boolean successfulLoad = false;
                if (isAnim) {
                    try {
                        Animation animation2 = AnimationUtils.loadAnimation(context, nextAnim);
                        if (animation2 != null) {
                            return new d(animation2);
                        }
                        successfulLoad = true;
                    } catch (Resources.NotFoundException e2) {
                        throw e2;
                    } catch (RuntimeException e3) {
                    }
                }
                if (!successfulLoad) {
                    try {
                        Animator animator2 = AnimatorInflater.loadAnimator(context, nextAnim);
                        if (animator2 != null) {
                            return new d(animator2);
                        }
                    } catch (RuntimeException e4) {
                        if (isAnim) {
                            throw e4;
                        }
                        Animation animation3 = AnimationUtils.loadAnimation(context, nextAnim);
                        if (animation3 != null) {
                            return new d(animation3);
                        }
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static int b(Fragment fragment, boolean enter, boolean isPop) {
        if (isPop) {
            if (enter) {
                return fragment.E();
            }
            return fragment.F();
        } else if (enter) {
            return fragment.q();
        } else {
            return fragment.t();
        }
    }

    public static void a(Fragment fragment, d anim, nc.g callback) {
        View viewToAnimate = fragment.K;
        ViewGroup container = fragment.J;
        container.startViewTransition(viewToAnimate);
        t8 signal = new t8();
        signal.c(new a(fragment));
        callback.b(fragment, signal);
        Animation animation = anim.a;
        if (animation != null) {
            Animation animation2 = new e(animation, container, viewToAnimate);
            fragment.n1(fragment.K);
            animation2.setAnimationListener(new b(container, fragment, callback, signal));
            fragment.K.startAnimation(animation2);
            return;
        }
        Animator animator = anim.b;
        fragment.p1(anim.b);
        animator.addListener(new c(container, viewToAnimate, fragment, callback, signal));
        animator.setTarget(fragment.K);
        animator.start();
    }

    /* compiled from: FragmentAnim.java */
    /* renamed from: wb$a */
    /* loaded from: classes.dex */
    public class a implements t8.a {
        public final /* synthetic */ Fragment a;

        public a(Fragment fragment) {
            this.a = fragment;
        }

        @Override // defpackage.t8.a
        public void a() {
            if (this.a.m() != null) {
                View v = this.a.m();
                this.a.n1(null);
                v.clearAnimation();
            }
            this.a.p1(null);
        }
    }

    /* compiled from: FragmentAnim.java */
    /* renamed from: wb$b */
    /* loaded from: classes.dex */
    public class b implements Animation.AnimationListener {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ Fragment b;
        public final /* synthetic */ nc.g c;
        public final /* synthetic */ t8 d;

        public b(ViewGroup viewGroup, Fragment fragment, nc.g gVar, t8 t8Var) {
            this.a = viewGroup;
            this.b = fragment;
            this.c = gVar;
            this.d = t8Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        /* compiled from: FragmentAnim.java */
        /* renamed from: wb$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.b.m() != null) {
                    b.this.b.n1(null);
                    b bVar = b.this;
                    bVar.c.a(bVar.b, bVar.d);
                }
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

    /* compiled from: FragmentAnim.java */
    /* renamed from: wb$c */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Fragment d;
        public final /* synthetic */ nc.g f;
        public final /* synthetic */ t8 g;

        public c(ViewGroup viewGroup, View view, Fragment fragment, nc.g gVar, t8 t8Var) {
            this.a = viewGroup;
            this.b = view;
            this.d = fragment;
            this.f = gVar;
            this.g = t8Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator anim) {
            this.a.endViewTransition(this.b);
            Animator animator = this.d.n();
            this.d.p1(null);
            if (animator != null && this.a.indexOfChild(this.b) < 0) {
                this.f.a(this.d, this.g);
            }
        }
    }

    public static int d(int transit, boolean enter) {
        switch (transit) {
            case 4097:
                int animAttr = enter ? qb.fragment_open_enter : qb.fragment_open_exit;
                return animAttr;
            case 4099:
                int animAttr2 = enter ? qb.fragment_fade_enter : qb.fragment_fade_exit;
                return animAttr2;
            case 8194:
                int animAttr3 = enter ? qb.fragment_close_enter : qb.fragment_close_exit;
                return animAttr3;
            default:
                return -1;
        }
    }

    /* compiled from: FragmentAnim.java */
    /* renamed from: wb$d */
    /* loaded from: classes.dex */
    public static class d {
        public final Animation a;
        public final Animator b;

        public d(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public d(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: FragmentAnim.java */
    /* renamed from: wb$e */
    /* loaded from: classes.dex */
    public static class e extends AnimationSet implements Runnable {
        public final ViewGroup a;
        public final View b;
        public boolean d;
        public boolean f;
        public boolean g;

        public e(Animation animation, ViewGroup parent, View child) {
            super(false);
            this.g = true;
            this.a = parent;
            this.b = child;
            addAnimation(animation);
            parent.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long currentTime, Transformation t) {
            this.g = true;
            if (this.d) {
                return true ^ this.f;
            }
            boolean more = super.getTransformation(currentTime, t);
            if (!more) {
                this.d = true;
                ea.a(this.a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long currentTime, Transformation outTransformation, float scale) {
            this.g = true;
            if (this.d) {
                return true ^ this.f;
            }
            boolean more = super.getTransformation(currentTime, outTransformation, scale);
            if (!more) {
                this.d = true;
                ea.a(this.a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.d && this.g) {
                this.g = false;
                this.a.post(this);
                return;
            }
            this.a.endViewTransition(this.b);
            this.f = true;
        }
    }
}
