package defpackage;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import com.lzy.okgo.model.Priority;
/* compiled from: TooltipCompatHandler.java */
/* renamed from: c3  reason: default package */
/* loaded from: classes.dex */
public class c3 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static c3 a;
    public static c3 b;
    public final View d;
    public final CharSequence f;
    public final int g;
    public final Runnable h = new a();
    public final Runnable i = new b();
    public int j;
    public int k;
    public d3 l;
    public boolean m;

    /* compiled from: TooltipCompatHandler.java */
    /* renamed from: c3$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c3.this.g(false);
        }
    }

    /* compiled from: TooltipCompatHandler.java */
    /* renamed from: c3$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c3.this.c();
        }
    }

    public static void f(View view, CharSequence tooltipText) {
        c3 c3Var = a;
        if (c3Var != null && c3Var.d == view) {
            e(null);
        }
        if (TextUtils.isEmpty(tooltipText)) {
            c3 c3Var2 = b;
            if (c3Var2 != null && c3Var2.d == view) {
                c3Var2.c();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new c3(view, tooltipText);
    }

    public c3(View anchor, CharSequence tooltipText) {
        this.d = anchor;
        this.f = tooltipText;
        this.g = ha.a(ViewConfiguration.get(anchor.getContext()));
        b();
        anchor.setOnLongClickListener(this);
        anchor.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        this.j = v.getWidth() / 2;
        this.k = v.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View v, MotionEvent event) {
        if (this.l == null || !this.m) {
            AccessibilityManager manager = (AccessibilityManager) this.d.getContext().getSystemService("accessibility");
            if (manager.isEnabled() && manager.isTouchExplorationEnabled()) {
                return false;
            }
            switch (event.getAction()) {
                case 7:
                    if (this.d.isEnabled() && this.l == null && h(event)) {
                        e(this);
                        break;
                    }
                    break;
                case 10:
                    b();
                    c();
                    break;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        c();
    }

    public void g(boolean fromTouch) {
        long timeout;
        if (!ga.I(this.d)) {
            return;
        }
        e(null);
        c3 c3Var = b;
        if (c3Var != null) {
            c3Var.c();
        }
        b = this;
        this.m = fromTouch;
        d3 d3Var = new d3(this.d.getContext());
        this.l = d3Var;
        d3Var.e(this.d, this.j, this.k, this.m, this.f);
        this.d.addOnAttachStateChangeListener(this);
        if (this.m) {
            timeout = 2500;
        } else if ((ga.D(this.d) & 1) == 1) {
            timeout = 3000 - ViewConfiguration.getLongPressTimeout();
        } else {
            timeout = 15000 - ViewConfiguration.getLongPressTimeout();
        }
        this.d.removeCallbacks(this.i);
        this.d.postDelayed(this.i, timeout);
    }

    public void c() {
        if (b == this) {
            b = null;
            d3 d3Var = this.l;
            if (d3Var != null) {
                d3Var.c();
                this.l = null;
                b();
                this.d.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (a == this) {
            e(null);
        }
        this.d.removeCallbacks(this.i);
    }

    public static void e(c3 handler) {
        c3 c3Var = a;
        if (c3Var != null) {
            c3Var.a();
        }
        a = handler;
        if (handler != null) {
            handler.d();
        }
    }

    public final void d() {
        this.d.postDelayed(this.h, ViewConfiguration.getLongPressTimeout());
    }

    public final void a() {
        this.d.removeCallbacks(this.h);
    }

    public final boolean h(MotionEvent event) {
        int newAnchorX = (int) event.getX();
        int newAnchorY = (int) event.getY();
        if (Math.abs(newAnchorX - this.j) <= this.g && Math.abs(newAnchorY - this.k) <= this.g) {
            return false;
        }
        this.j = newAnchorX;
        this.k = newAnchorY;
        return true;
    }

    public final void b() {
        this.j = Priority.UI_TOP;
        this.k = Priority.UI_TOP;
    }
}
