package defpackage;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: XTouchTargetUtils.java */
/* renamed from: cr  reason: default package */
/* loaded from: classes.dex */
public class cr {
    public static final Rect a = new Rect();

    public static void b(View view, ViewGroup parent) {
        if (view == null || parent == null) {
            return;
        }
        view.post(new a(view, parent));
    }

    /* compiled from: XTouchTargetUtils.java */
    /* renamed from: cr$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ ViewGroup b;

        public a(View view, ViewGroup viewGroup) {
            this.a = view;
            this.b = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isAttachedToWindow()) {
                cr.d(" as not isAttachedToWindow " + hashCode());
            } else if (this.b.getWidth() == 0 || this.b.getHeight() == 0) {
                cr.d(" as width or height == 0 " + hashCode());
                b layoutAttachStateChangeListener = new b(this.b);
                this.a.addOnLayoutChangeListener(layoutAttachStateChangeListener);
                this.a.addOnAttachStateChangeListener(layoutAttachStateChangeListener);
            } else {
                Rect rect = new Rect(0, 0, this.b.getWidth(), this.b.getHeight());
                ar touchDelegate = new ar(rect, this.a);
                br touchDelegateGroup = cr.c(this.b);
                touchDelegateGroup.a(touchDelegate);
                this.b.setTouchDelegate(touchDelegateGroup);
                this.a.addOnAttachStateChangeListener(new c(touchDelegate, touchDelegateGroup));
            }
        }
    }

    /* compiled from: XTouchTargetUtils.java */
    /* renamed from: cr$b */
    /* loaded from: classes.dex */
    public static class b implements View.OnLayoutChangeListener, View.OnAttachStateChangeListener {
        public static int a;
        public ViewGroup b;

        public b(ViewGroup ancestor) {
            this.b = ancestor;
            a++;
        }

        public void finalize() throws Throwable {
            super.finalize();
            int i = a - 1;
            a = i;
            if (i == 0) {
                rq.a("xpui-touch", " LayoutAttachStateChangeListener2  finalize " + a);
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            if (v.getWidth() > 0 && v.getHeight() > 0) {
                cr.b(v, this.b);
                this.b = null;
                v.removeOnLayoutChangeListener(this);
                v.removeOnAttachStateChangeListener(this);
                cr.d(" LayoutAttachStateChangeListener2  onLayoutChange ");
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            v.removeOnLayoutChangeListener(this);
            v.removeOnAttachStateChangeListener(this);
            cr.d(" LayoutAttachStateChangeListener2  onViewDetachedFromWindow ");
        }
    }

    /* compiled from: XTouchTargetUtils.java */
    /* renamed from: cr$c */
    /* loaded from: classes.dex */
    public static class c implements View.OnAttachStateChangeListener {
        public static int a;
        public ar b;
        public br d;

        public c(ar touchDelegate, br touchDelegateGroup) {
            this.b = touchDelegate;
            this.d = touchDelegateGroup;
            a++;
        }

        public void finalize() throws Throwable {
            super.finalize();
            int i = a - 1;
            a = i;
            if (i == 0) {
                rq.a("xpui-touch", " MyStateChangeListener finalize " + a);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            v.removeOnAttachStateChangeListener(this);
            this.d.b(this.b);
            cr.d("  MyStateChangeListener onViewDetachedFromWindow " + v.hashCode());
            this.d = null;
            this.b = null;
        }
    }

    public static br c(View ancestor) {
        TouchDelegate existingTouchDelegate = ancestor.getTouchDelegate();
        if (existingTouchDelegate != null) {
            if (existingTouchDelegate instanceof br) {
                return (br) existingTouchDelegate;
            }
            br touchDelegateGroup = new br(ancestor);
            if (existingTouchDelegate instanceof ar) {
                touchDelegateGroup.a((ar) existingTouchDelegate);
                return touchDelegateGroup;
            }
            return touchDelegateGroup;
        }
        return new br(ancestor);
    }

    public static void d(String msg) {
    }
}
