package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* renamed from: x0  reason: default package */
/* loaded from: classes.dex */
public class x0 {
    public Interpolator c;
    public la d;
    public boolean e;
    public long b = -1;
    public final ma f = new a();
    public final ArrayList<ka> a = new ArrayList<>();

    public x0 c(ka animator) {
        if (!this.e) {
            this.a.add(animator);
        }
        return this;
    }

    public x0 d(ka anim1, ka anim2) {
        this.a.add(anim1);
        anim2.h(anim1.c());
        this.a.add(anim2);
        return this;
    }

    public void h() {
        if (this.e) {
            return;
        }
        Iterator<ka> it = this.a.iterator();
        while (it.hasNext()) {
            ka animator = it.next();
            long j = this.b;
            if (j >= 0) {
                animator.d(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                animator.e(interpolator);
            }
            if (this.d != null) {
                animator.f(this.f);
            }
            animator.j();
        }
        this.e = true;
    }

    public void b() {
        this.e = false;
    }

    public void a() {
        if (!this.e) {
            return;
        }
        Iterator<ka> it = this.a.iterator();
        while (it.hasNext()) {
            ka animator = it.next();
            animator.b();
        }
        this.e = false;
    }

    public x0 e(long duration) {
        if (!this.e) {
            this.b = duration;
        }
        return this;
    }

    public x0 f(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public x0 g(la listener) {
        if (!this.e) {
            this.d = listener;
        }
        return this;
    }

    /* compiled from: ViewPropertyAnimatorCompatSet.java */
    /* renamed from: x0$a */
    /* loaded from: classes.dex */
    public class a extends ma {
        public boolean a = false;
        public int b = 0;

        public a() {
        }

        @Override // defpackage.ma, defpackage.la
        public void c(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            la laVar = x0.this.d;
            if (laVar != null) {
                laVar.c(null);
            }
        }

        public void d() {
            this.b = 0;
            this.a = false;
            x0.this.b();
        }

        @Override // defpackage.la
        public void b(View view) {
            int i = this.b + 1;
            this.b = i;
            if (i == x0.this.a.size()) {
                la laVar = x0.this.d;
                if (laVar != null) {
                    laVar.b(null);
                }
                d();
            }
        }
    }
}
