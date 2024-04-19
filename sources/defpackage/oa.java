package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
/* compiled from: WindowInsetsCompat.java */
/* renamed from: oa  reason: default package */
/* loaded from: classes.dex */
public class oa {
    public static final oa a;
    public final l b;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            a = k.r;
        } else {
            a = l.a;
        }
    }

    public oa(WindowInsets insets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.b = new k(this, insets);
        } else if (i2 >= 29) {
            this.b = new j(this, insets);
        } else if (i2 >= 28) {
            this.b = new i(this, insets);
        } else if (i2 >= 21) {
            this.b = new h(this, insets);
        } else if (i2 >= 20) {
            this.b = new g(this, insets);
        } else {
            this.b = new l(this);
        }
    }

    public oa(oa src) {
        if (src != null) {
            l srcImpl = src.b;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && (srcImpl instanceof k)) {
                this.b = new k(this, (k) srcImpl);
            } else if (i2 >= 29 && (srcImpl instanceof j)) {
                this.b = new j(this, (j) srcImpl);
            } else if (i2 >= 28 && (srcImpl instanceof i)) {
                this.b = new i(this, (i) srcImpl);
            } else if (i2 >= 21 && (srcImpl instanceof h)) {
                this.b = new h(this, (h) srcImpl);
            } else if (i2 >= 20 && (srcImpl instanceof g)) {
                this.b = new g(this, (g) srcImpl);
            } else {
                this.b = new l(this);
            }
            srcImpl.e(this);
            return;
        }
        this.b = new l(this);
    }

    public static oa r(WindowInsets insets) {
        return s(insets, null);
    }

    public static oa s(WindowInsets insets, View view) {
        oa wic = new oa((WindowInsets) k9.d(insets));
        if (view != null && view.isAttachedToWindow()) {
            wic.o(ga.A(view));
            wic.d(view.getRootView());
        }
        return wic;
    }

    @Deprecated
    public int f() {
        return this.b.h().b;
    }

    @Deprecated
    public int h() {
        return this.b.h().c;
    }

    @Deprecated
    public int g() {
        return this.b.h().d;
    }

    @Deprecated
    public int e() {
        return this.b.h().e;
    }

    public boolean k() {
        return this.b.j();
    }

    @Deprecated
    public oa c() {
        return this.b.c();
    }

    @Deprecated
    public oa l(int left, int top, int right, int bottom) {
        return new b(this).c(y7.b(left, top, right, bottom)).a();
    }

    @Deprecated
    public oa b() {
        return this.b.b();
    }

    @Deprecated
    public oa a() {
        return this.b.a();
    }

    public oa i(int left, int top, int right, int bottom) {
        return this.b.i(left, top, right, bottom);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof oa)) {
            return false;
        }
        oa other = (oa) o;
        return f9.a(this.b, other.b);
    }

    public int hashCode() {
        l lVar = this.b;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public WindowInsets q() {
        l lVar = this.b;
        if (lVar instanceof g) {
            return ((g) lVar).i;
        }
        return null;
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$l */
    /* loaded from: classes.dex */
    public static class l {
        public static final oa a = new b().a().a().b().c();
        public final oa b;

        public l(oa host) {
            this.b = host;
        }

        public boolean k() {
            return false;
        }

        public boolean j() {
            return false;
        }

        public oa c() {
            return this.b;
        }

        public oa b() {
            return this.b;
        }

        public o9 f() {
            return null;
        }

        public oa a() {
            return this.b;
        }

        public y7 h() {
            return y7.a;
        }

        public y7 g() {
            return y7.a;
        }

        public oa i(int left, int top, int right, int bottom) {
            return a;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof l) {
                l impl = (l) o;
                return k() == impl.k() && j() == impl.j() && f9.a(h(), impl.h()) && f9.a(g(), impl.g()) && f9.a(f(), impl.f());
            }
            return false;
        }

        public int hashCode() {
            return f9.b(Boolean.valueOf(k()), Boolean.valueOf(j()), h(), g(), f());
        }

        public void n(oa rootWindowInsets) {
        }

        public void m(y7 visibleInsets) {
        }

        public void d(View rootView) {
        }

        public void e(oa other) {
        }

        public void l(y7[] insetsTypeMask) {
        }

        public void o(y7 stableInsets) {
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$g */
    /* loaded from: classes.dex */
    public static class g extends l {
        public static boolean c = false;
        public static Method d;
        public static Class<?> e;
        public static Class<?> f;
        public static Field g;
        public static Field h;
        public final WindowInsets i;
        public y7[] j;
        public y7 k;
        public oa l;
        public y7 m;

        public g(oa host, WindowInsets insets) {
            super(host);
            this.k = null;
            this.i = insets;
        }

        public g(oa host, g other) {
            this(host, new WindowInsets(other.i));
        }

        @Override // defpackage.oa.l
        public boolean k() {
            return this.i.isRound();
        }

        @Override // defpackage.oa.l
        public final y7 h() {
            if (this.k == null) {
                this.k = y7.b(this.i.getSystemWindowInsetLeft(), this.i.getSystemWindowInsetTop(), this.i.getSystemWindowInsetRight(), this.i.getSystemWindowInsetBottom());
            }
            return this.k;
        }

        @Override // defpackage.oa.l
        public oa i(int left, int top, int right, int bottom) {
            b b = new b(oa.r(this.i));
            b.c(oa.j(h(), left, top, right, bottom));
            b.b(oa.j(g(), left, top, right, bottom));
            return b.a();
        }

        @Override // defpackage.oa.l
        public void e(oa other) {
            other.o(this.l);
            other.n(this.m);
        }

        @Override // defpackage.oa.l
        public void n(oa rootWindowInsets) {
            this.l = rootWindowInsets;
        }

        @Override // defpackage.oa.l
        public void m(y7 visibleInsets) {
            this.m = visibleInsets;
        }

        @Override // defpackage.oa.l
        public void d(View rootView) {
            y7 visibleInsets = p(rootView);
            if (visibleInsets == null) {
                visibleInsets = y7.a;
            }
            m(visibleInsets);
        }

        public final y7 p(View rootView) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!c) {
                q();
            }
            Method method = d;
            if (method == null || f == null || g == null) {
                return null;
            }
            try {
                Object viewRootImpl = method.invoke(rootView, new Object[0]);
                if (viewRootImpl == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Object mAttachInfo = h.get(viewRootImpl);
                Rect visibleRect = (Rect) g.get(mAttachInfo);
                if (visibleRect != null) {
                    return y7.c(visibleRect);
                }
                return null;
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                return null;
            }
        }

        @Override // defpackage.oa.l
        public void l(y7[] insetsTypeMask) {
            this.j = insetsTypeMask;
        }

        @SuppressLint({"PrivateApi"})
        public static void q() {
            try {
                d = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                e = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f = cls;
                g = cls.getDeclaredField("mVisibleInsets");
                h = e.getDeclaredField("mAttachInfo");
                g.setAccessible(true);
                h.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            c = true;
        }

        @Override // defpackage.oa.l
        public boolean equals(Object o) {
            if (super.equals(o)) {
                g impl20 = (g) o;
                return Objects.equals(this.m, impl20.m);
            }
            return false;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$h */
    /* loaded from: classes.dex */
    public static class h extends g {
        public y7 n;

        public h(oa host, WindowInsets insets) {
            super(host, insets);
            this.n = null;
        }

        public h(oa host, h other) {
            super(host, other);
            this.n = null;
            this.n = other.n;
        }

        @Override // defpackage.oa.l
        public boolean j() {
            return this.i.isConsumed();
        }

        @Override // defpackage.oa.l
        public oa b() {
            return oa.r(this.i.consumeStableInsets());
        }

        @Override // defpackage.oa.l
        public oa c() {
            return oa.r(this.i.consumeSystemWindowInsets());
        }

        @Override // defpackage.oa.l
        public final y7 g() {
            if (this.n == null) {
                this.n = y7.b(this.i.getStableInsetLeft(), this.i.getStableInsetTop(), this.i.getStableInsetRight(), this.i.getStableInsetBottom());
            }
            return this.n;
        }

        @Override // defpackage.oa.l
        public void o(y7 stableInsets) {
            this.n = stableInsets;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$i */
    /* loaded from: classes.dex */
    public static class i extends h {
        public i(oa host, WindowInsets insets) {
            super(host, insets);
        }

        public i(oa host, i other) {
            super(host, other);
        }

        @Override // defpackage.oa.l
        public o9 f() {
            return o9.a(this.i.getDisplayCutout());
        }

        @Override // defpackage.oa.l
        public oa a() {
            return oa.r(this.i.consumeDisplayCutout());
        }

        @Override // defpackage.oa.g, defpackage.oa.l
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof i) {
                i otherImpl28 = (i) o;
                return Objects.equals(this.i, otherImpl28.i) && Objects.equals(this.m, otherImpl28.m);
            }
            return false;
        }

        @Override // defpackage.oa.l
        public int hashCode() {
            return this.i.hashCode();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$j */
    /* loaded from: classes.dex */
    public static class j extends i {
        public y7 o;
        public y7 p;
        public y7 q;

        public j(oa host, WindowInsets insets) {
            super(host, insets);
            this.o = null;
            this.p = null;
            this.q = null;
        }

        public j(oa host, j other) {
            super(host, other);
            this.o = null;
            this.p = null;
            this.q = null;
        }

        @Override // defpackage.oa.g, defpackage.oa.l
        public oa i(int left, int top, int right, int bottom) {
            return oa.r(this.i.inset(left, top, right, bottom));
        }

        @Override // defpackage.oa.h, defpackage.oa.l
        public void o(y7 stableInsets) {
        }
    }

    public static y7 j(y7 insets, int left, int top, int right, int bottom) {
        int newLeft = Math.max(0, insets.b - left);
        int newTop = Math.max(0, insets.c - top);
        int newRight = Math.max(0, insets.d - right);
        int newBottom = Math.max(0, insets.e - bottom);
        if (newLeft == left && newTop == top && newRight == right && newBottom == bottom) {
            return insets;
        }
        return y7.b(newLeft, newTop, newRight, newBottom);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$k */
    /* loaded from: classes.dex */
    public static class k extends j {
        public static final oa r = oa.r(WindowInsets.CONSUMED);

        public k(oa host, WindowInsets insets) {
            super(host, insets);
        }

        public k(oa host, k other) {
            super(host, other);
        }

        @Override // defpackage.oa.g, defpackage.oa.l
        public final void d(View rootView) {
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$b */
    /* loaded from: classes.dex */
    public static final class b {
        public final f a;

        public b() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.a = new e();
            } else if (i >= 29) {
                this.a = new d();
            } else if (i >= 20) {
                this.a = new c();
            } else {
                this.a = new f();
            }
        }

        public b(oa insets) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.a = new e(insets);
            } else if (i >= 29) {
                this.a = new d(insets);
            } else if (i >= 20) {
                this.a = new c(insets);
            } else {
                this.a = new f(insets);
            }
        }

        @Deprecated
        public b c(y7 insets) {
            this.a.f(insets);
            return this;
        }

        @Deprecated
        public b b(y7 insets) {
            this.a.d(insets);
            return this;
        }

        public oa a() {
            return this.a.b();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$f */
    /* loaded from: classes.dex */
    public static class f {
        public final oa a;
        public y7[] b;

        public f() {
            this(new oa((oa) null));
        }

        public f(oa insets) {
            this.a = insets;
        }

        public void f(y7 insets) {
        }

        public void e(y7 insets) {
        }

        public void c(y7 insets) {
        }

        public void g(y7 insets) {
        }

        public void d(y7 insets) {
        }

        public final void a() {
            y7[] y7VarArr = this.b;
            if (y7VarArr != null) {
                y7 statusBars = y7VarArr[m.a(1)];
                y7 navigationBars = this.b[m.a(2)];
                if (statusBars != null && navigationBars != null) {
                    f(y7.a(statusBars, navigationBars));
                } else if (statusBars != null) {
                    f(statusBars);
                } else if (navigationBars != null) {
                    f(navigationBars);
                }
                y7 i = this.b[m.a(16)];
                if (i != null) {
                    e(i);
                }
                y7 i2 = this.b[m.a(32)];
                if (i2 != null) {
                    c(i2);
                }
                y7 i3 = this.b[m.a(64)];
                if (i3 != null) {
                    g(i3);
                }
            }
        }

        public oa b() {
            a();
            return this.a;
        }
    }

    public void m(y7[] insetsTypeMask) {
        this.b.l(insetsTypeMask);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$c */
    /* loaded from: classes.dex */
    public static class c extends f {
        public static Field c;
        public static Constructor<WindowInsets> e;
        public WindowInsets g;
        public y7 h;
        public static boolean d = false;
        public static boolean f = false;

        public c() {
            this.g = h();
        }

        public c(oa insets) {
            this.g = insets.q();
        }

        @Override // defpackage.oa.f
        public void f(y7 insets) {
            WindowInsets windowInsets = this.g;
            if (windowInsets != null) {
                this.g = windowInsets.replaceSystemWindowInsets(insets.b, insets.c, insets.d, insets.e);
            }
        }

        @Override // defpackage.oa.f
        public void d(y7 insets) {
            this.h = insets;
        }

        @Override // defpackage.oa.f
        public oa b() {
            a();
            oa windowInsetsCompat = oa.r(this.g);
            windowInsetsCompat.m(this.b);
            windowInsetsCompat.p(this.h);
            return windowInsetsCompat;
        }

        public static WindowInsets h() {
            if (!d) {
                try {
                    c = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                d = true;
            }
            Field field = c;
            if (field != null) {
                try {
                    WindowInsets consumed = (WindowInsets) field.get(null);
                    if (consumed != null) {
                        return new WindowInsets(consumed);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f) {
                try {
                    e = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f = true;
            }
            Constructor<WindowInsets> constructor = e;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }
    }

    public void p(y7 stableInsets) {
        this.b.o(stableInsets);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$d */
    /* loaded from: classes.dex */
    public static class d extends f {
        public final WindowInsets.Builder c;

        public d() {
            this.c = new WindowInsets.Builder();
        }

        public d(oa insets) {
            WindowInsets.Builder builder;
            WindowInsets platInsets = insets.q();
            if (platInsets != null) {
                builder = new WindowInsets.Builder(platInsets);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.c = builder;
        }

        @Override // defpackage.oa.f
        public void f(y7 insets) {
            this.c.setSystemWindowInsets(insets.d());
        }

        @Override // defpackage.oa.f
        public void e(y7 insets) {
            this.c.setSystemGestureInsets(insets.d());
        }

        @Override // defpackage.oa.f
        public void c(y7 insets) {
            this.c.setMandatorySystemGestureInsets(insets.d());
        }

        @Override // defpackage.oa.f
        public void g(y7 insets) {
            this.c.setTappableElementInsets(insets.d());
        }

        @Override // defpackage.oa.f
        public void d(y7 insets) {
            this.c.setStableInsets(insets.d());
        }

        @Override // defpackage.oa.f
        public oa b() {
            a();
            oa windowInsetsCompat = oa.r(this.c.build());
            windowInsetsCompat.m(this.b);
            return windowInsetsCompat;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$e */
    /* loaded from: classes.dex */
    public static class e extends d {
        public e() {
        }

        public e(oa insets) {
            super(insets);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$m */
    /* loaded from: classes.dex */
    public static final class m {
        public static int a(int type) {
            switch (type) {
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 4:
                    return 2;
                case 8:
                    return 3;
                case 16:
                    return 4;
                case 32:
                    return 5;
                case 64:
                    return 6;
                case 128:
                    return 7;
                case IRadioController.TEF663x_PCHANNEL /* 256 */:
                    return 8;
                default:
                    throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + type);
            }
        }
    }

    public void o(oa rootWindowInsets) {
        this.b.n(rootWindowInsets);
    }

    public void n(y7 visibleInsets) {
        this.b.m(visibleInsets);
    }

    public void d(View rootView) {
        this.b.d(rootView);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: oa$a */
    /* loaded from: classes.dex */
    public static class a {
        public static Field a;
        public static Field b;
        public static Field c;
        public static boolean d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                a = declaredField;
                declaredField.setAccessible(true);
                Class<?> sAttachInfoClass = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = sAttachInfoClass.getDeclaredField("mStableInsets");
                b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = sAttachInfoClass.getDeclaredField("mContentInsets");
                c = declaredField3;
                declaredField3.setAccessible(true);
                d = true;
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        public static oa a(View v) {
            if (d && v.isAttachedToWindow()) {
                View rootView = v.getRootView();
                try {
                    Object attachInfo = a.get(rootView);
                    if (attachInfo != null) {
                        Rect stableInsets = (Rect) b.get(attachInfo);
                        Rect visibleInsets = (Rect) c.get(attachInfo);
                        if (stableInsets != null && visibleInsets != null) {
                            oa insets = new b().b(y7.c(stableInsets)).c(y7.c(visibleInsets)).a();
                            insets.o(insets);
                            insets.d(v.getRootView());
                            return insets;
                        }
                    }
                } catch (IllegalAccessException e) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                }
                return null;
            }
            return null;
        }
    }
}
