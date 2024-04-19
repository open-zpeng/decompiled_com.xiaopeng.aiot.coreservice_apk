package defpackage;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
/* compiled from: ForwardingListener.java */
/* renamed from: n2  reason: default package */
/* loaded from: classes.dex */
public abstract class n2 implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public final float a;
    public final int b;
    public final int d;
    public final View f;
    public Runnable g;
    public Runnable h;
    public boolean i;
    public int j;
    public final int[] k = new int[2];

    public abstract o1 b();

    public abstract boolean c();

    public n2(View src) {
        this.f = src;
        src.setLongClickable(true);
        src.addOnAttachStateChangeListener(this);
        this.a = ViewConfiguration.get(src.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.b = tapTimeout;
        this.d = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        boolean forwarding;
        boolean wasForwarding = this.i;
        if (!wasForwarding) {
            forwarding = g(event) && c();
            if (forwarding) {
                long now = SystemClock.uptimeMillis();
                MotionEvent e = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
                this.f.onTouchEvent(e);
                e.recycle();
            }
        } else {
            forwarding = f(event) || !d();
        }
        this.i = forwarding;
        return forwarding || wasForwarding;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        this.i = false;
        this.j = -1;
        Runnable runnable = this.g;
        if (runnable != null) {
            this.f.removeCallbacks(runnable);
        }
    }

    public boolean d() {
        o1 popup = b();
        if (popup != null && popup.b()) {
            popup.dismiss();
            return true;
        }
        return true;
    }

    public final boolean g(MotionEvent srcEvent) {
        View src = this.f;
        if (src.isEnabled()) {
            int actionMasked = srcEvent.getActionMasked();
            switch (actionMasked) {
                case 0:
                    this.j = srcEvent.getPointerId(0);
                    if (this.g == null) {
                        this.g = new a();
                    }
                    src.postDelayed(this.g, this.b);
                    if (this.h == null) {
                        this.h = new b();
                    }
                    src.postDelayed(this.h, this.d);
                    break;
                case 1:
                case 3:
                    a();
                    break;
                case 2:
                    int activePointerIndex = srcEvent.findPointerIndex(this.j);
                    if (activePointerIndex >= 0) {
                        float x = srcEvent.getX(activePointerIndex);
                        float y = srcEvent.getY(activePointerIndex);
                        if (!h(src, x, y, this.a)) {
                            a();
                            src.getParent().requestDisallowInterceptTouchEvent(true);
                            return true;
                        }
                    }
                    break;
            }
            return false;
        }
        return false;
    }

    public final void a() {
        Runnable runnable = this.h;
        if (runnable != null) {
            this.f.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.g;
        if (runnable2 != null) {
            this.f.removeCallbacks(runnable2);
        }
    }

    public void e() {
        a();
        View src = this.f;
        if (!src.isEnabled() || src.isLongClickable() || !c()) {
            return;
        }
        src.getParent().requestDisallowInterceptTouchEvent(true);
        long now = SystemClock.uptimeMillis();
        MotionEvent e = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
        src.onTouchEvent(e);
        e.recycle();
        this.i = true;
    }

    public final boolean f(MotionEvent srcEvent) {
        l2 dst;
        boolean keepForwarding;
        View src = this.f;
        o1 popup = b();
        if (popup == null || !popup.b() || (dst = (l2) popup.g()) == null || !dst.isShown()) {
            return false;
        }
        MotionEvent dstEvent = MotionEvent.obtainNoHistory(srcEvent);
        i(src, dstEvent);
        j(dst, dstEvent);
        boolean handled = dst.e(dstEvent, this.j);
        dstEvent.recycle();
        int action = srcEvent.getActionMasked();
        if (action == 1 || action == 3) {
            keepForwarding = false;
        } else {
            keepForwarding = true;
        }
        if (!handled || !keepForwarding) {
            return false;
        }
        return true;
    }

    public static boolean h(View view, float localX, float localY, float slop) {
        return localX >= (-slop) && localY >= (-slop) && localX < ((float) (view.getRight() - view.getLeft())) + slop && localY < ((float) (view.getBottom() - view.getTop())) + slop;
    }

    public final boolean j(View view, MotionEvent event) {
        int[] loc = this.k;
        view.getLocationOnScreen(loc);
        event.offsetLocation(-loc[0], -loc[1]);
        return true;
    }

    public final boolean i(View view, MotionEvent event) {
        int[] loc = this.k;
        view.getLocationOnScreen(loc);
        event.offsetLocation(loc[0], loc[1]);
        return true;
    }

    /* compiled from: ForwardingListener.java */
    /* renamed from: n2$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = n2.this.f.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener.java */
    /* renamed from: n2$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n2.this.e();
        }
    }
}
