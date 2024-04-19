package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
/* compiled from: ViewPropertyAnimatorCompat.java */
/* renamed from: ka  reason: default package */
/* loaded from: classes.dex */
public final class ka {
    public WeakReference<View> a;
    public Runnable b = null;
    public Runnable c = null;
    public int d = -1;

    public ka(View view) {
        this.a = new WeakReference<>(view);
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: ka$c */
    /* loaded from: classes.dex */
    public static class c implements la {
        public ka a;
        public boolean b;

        public c(ka vpa) {
            this.a = vpa;
        }

        @Override // defpackage.la
        public void c(View view) {
            this.b = false;
            if (this.a.d > -1) {
                view.setLayerType(2, null);
            }
            ka kaVar = this.a;
            if (kaVar.b != null) {
                Runnable startAction = kaVar.b;
                kaVar.b = null;
                startAction.run();
            }
            Object listenerTag = view.getTag(2113929216);
            la listener = null;
            if (listenerTag instanceof la) {
                listener = (la) listenerTag;
            }
            if (listener != null) {
                listener.c(view);
            }
        }

        @Override // defpackage.la
        @SuppressLint({"WrongConstant"})
        public void b(View view) {
            int i = this.a.d;
            if (i > -1) {
                view.setLayerType(i, null);
                this.a.d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.b) {
                ka kaVar = this.a;
                if (kaVar.c != null) {
                    Runnable endAction = kaVar.c;
                    kaVar.c = null;
                    endAction.run();
                }
                Object listenerTag = view.getTag(2113929216);
                la listener = null;
                if (listenerTag instanceof la) {
                    listener = (la) listenerTag;
                }
                if (listener != null) {
                    listener.b(view);
                }
                this.b = true;
            }
        }

        @Override // defpackage.la
        public void a(View view) {
            Object listenerTag = view.getTag(2113929216);
            la listener = null;
            if (listenerTag instanceof la) {
                listener = (la) listenerTag;
            }
            if (listener != null) {
                listener.a(view);
            }
        }
    }

    public ka d(long value) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(value);
        }
        return this;
    }

    public ka a(float value) {
        View view = this.a.get();
        if (view != null) {
            view.animate().alpha(value);
        }
        return this;
    }

    public ka k(float value) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(value);
        }
        return this;
    }

    public long c() {
        View view = this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public ka e(Interpolator value) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setInterpolator(value);
        }
        return this;
    }

    public ka h(long value) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setStartDelay(value);
        }
        return this;
    }

    public void b() {
        View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void j() {
        View view = this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public ka f(la listener) {
        View view = this.a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                g(view, listener);
            } else {
                view.setTag(2113929216, listener);
                g(view, new c(this));
            }
        }
        return this;
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: ka$a */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ la a;
        public final /* synthetic */ View b;

        public a(la laVar, View view) {
            this.a = laVar;
            this.b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.a.a(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.a.b(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            this.a.c(this.b);
        }
    }

    public final void g(View view, la listener) {
        if (listener != null) {
            view.animate().setListener(new a(listener, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public ka i(na listener) {
        View view = this.a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            ValueAnimator.AnimatorUpdateListener wrapped = null;
            if (listener != null) {
                wrapped = new b(listener, view);
            }
            view.animate().setUpdateListener(wrapped);
        }
        return this;
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: ka$b */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ na a;
        public final /* synthetic */ View b;

        public b(na naVar, View view) {
            this.a = naVar;
            this.b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(this.b);
        }
    }
}
