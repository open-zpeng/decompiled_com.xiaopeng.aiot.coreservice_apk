package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.util.ArraySet;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import defpackage.mp;
import defpackage.op;
import java.util.Iterator;
/* compiled from: XActivityDelegateImpl.java */
/* renamed from: kp  reason: default package */
/* loaded from: classes.dex */
public class kp extends jp implements mp.d, op.a {
    public AppCompatActivity a;
    public int b;
    public rp c;
    public sp d;
    public qp e;
    public op f;
    public np g;
    public ArraySet<pp> h = new ArraySet<>();
    public Handler i = new Handler();

    public kp(AppCompatActivity activity) {
        this.a = activity;
        u();
    }

    public final void u() {
        tp timeLogs = tp.a();
        timeLogs.d("XActivityDelegate-init");
        int templateType = s(this.a.getClass());
        timeLogs.c("analysisAnnotation " + templateType);
        this.c = new rp(this.a);
        timeLogs.c("attributes");
        this.d = new sp(this.a);
        timeLogs.c("visible");
        this.g = np.f(this.a, this);
        timeLogs.c("cause");
        op k = op.k(this.a);
        this.f = k;
        k.l(this);
        timeLogs.c("dismiss");
        this.e = qp.f(this.a, templateType);
        timeLogs.c("template");
        this.e.k(this.f);
        this.e.l(this.g);
        this.e.m(this.c);
        this.e.n(this.d);
        timeLogs.c("template-init");
        this.h.add(this.d);
        this.h.add(this.f);
        this.h.add(this.e);
        this.h.add(this.g);
        timeLogs.b();
    }

    public final int s(Class<?> c) {
        ip annotation;
        if (c.isAnnotationPresent(ip.class) && (annotation = (ip) c.getAnnotation(ip.class)) != null) {
            return annotation.value();
        }
        Class<?> superClass = c.getSuperclass();
        if (superClass != null && !superClass.getName().equals(AppCompatActivity.class.getName())) {
            return s(superClass);
        }
        return 0;
    }

    @Override // defpackage.jp
    public void l(Bundle var1) {
        this.c.a();
        TypedArray array = this.a.getTheme().obtainStyledAttributes(new int[]{16842836});
        this.b = array.getResourceId(0, 0);
        array.recycle();
        this.i.post(new Runnable() { // from class: fp
            @Override // java.lang.Runnable
            public final void run() {
                kp.this.w();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w() {
        rq.a("XActivityDelegate", "activityTemplate: " + this.e.toString());
        rq.a("XActivityDelegate", "dismiss: " + this.f.toString());
        rq.a("XActivityDelegate", "windowVisible: " + this.d.toString());
        rq.a("XActivityDelegate", "dismissCause: " + this.g.toString());
    }

    @Override // defpackage.jp
    public void i(Bundle var1) {
        Iterator<pp> it = this.h.iterator();
        while (it.hasNext()) {
            pp lifecycle = it.next();
            lifecycle.j(var1);
        }
    }

    @Override // defpackage.jp
    public void p() {
        Iterator<pp> it = this.h.iterator();
        while (it.hasNext()) {
            pp lifecycle = it.next();
            lifecycle.a();
        }
    }

    @Override // defpackage.jp
    public void n() {
        Iterator<pp> it = this.h.iterator();
        while (it.hasNext()) {
            pp lifecycle = it.next();
            lifecycle.c();
        }
    }

    @Override // defpackage.jp
    public void m() {
        Iterator<pp> it = this.h.iterator();
        while (it.hasNext()) {
            pp lifecycle = it.next();
            lifecycle.d();
        }
    }

    @Override // defpackage.jp
    public void k() {
        Iterator<pp> it = this.h.iterator();
        while (it.hasNext()) {
            pp lifecycle = it.next();
            lifecycle.onPause();
        }
    }

    @Override // defpackage.jp
    public void q() {
        Iterator<pp> it = this.h.iterator();
        while (it.hasNext()) {
            pp lifecycle = it.next();
            lifecycle.onStop();
        }
    }

    @Override // defpackage.jp
    public void j() {
        Iterator<pp> it = this.h.iterator();
        while (it.hasNext()) {
            pp lifecycle = it.next();
            lifecycle.i();
        }
    }

    @Override // defpackage.jp
    public void h(Configuration var1) {
        if (this.b > 0) {
            mq.e(var1, this.a.getWindow(), this.b);
        }
    }

    /* compiled from: XActivityDelegateImpl.java */
    /* renamed from: kp$a */
    /* loaded from: classes.dex */
    public class a implements LayoutInflater.Factory2 {
        public a() {
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            return kp.this.t(parent, name, context, attrs);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            return onCreateView(null, name, context, attrs);
        }
    }

    @Override // defpackage.jp
    public void f() {
        this.a.getLayoutInflater().setFactory2(new a());
    }

    public View t(View parent, String name, Context context, AttributeSet attrs) {
        return this.a.B().i(parent, name, context, attrs);
    }

    @Override // defpackage.jp
    public void o(Bundle outState) {
    }

    @Override // defpackage.jp
    public boolean r(MotionEvent event) {
        if (this.g.e(event)) {
            return true;
        }
        return false;
    }

    @Override // defpackage.jp
    public boolean e(MotionEvent ev) {
        this.g.b();
        return false;
    }

    @Override // defpackage.jp
    public void g() {
        this.g.h();
    }

    @Override // defpackage.mp.d
    public void b(int cause) {
        this.f.f(cause);
    }

    @Override // defpackage.op.a
    public void c(int cause) {
        this.d.f(false);
        if (cause != 2 && this.g.o() != null) {
            this.g.o().g();
        }
    }

    @Override // defpackage.op.a
    public void a(int cause) {
    }
}
