package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ViewStubCompat;
import com.lzy.okgo.model.Priority;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import defpackage.cd;
import defpackage.f1;
import defpackage.l1;
import defpackage.m2;
import defpackage.q9;
import defpackage.r0;
import defpackage.v0;
import defpackage.v7;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: AppCompatDelegateImpl.java */
/* renamed from: b0  reason: default package */
/* loaded from: classes.dex */
public class b0 extends a0 implements f1.a, LayoutInflater.Factory2 {
    public static final z3<String, Integer> f = new z3<>();
    public static final boolean g;
    public static final int[] h;
    public static final boolean i;
    public static final boolean j;
    public static boolean k;
    public ka A;
    public boolean B;
    public boolean C;
    public ViewGroup D;
    public TextView E;
    public View F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public t[] O;
    public t P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public p Z;
    public p a0;
    public boolean b0;
    public int c0;
    public final Runnable d0;
    public boolean e0;
    public Rect f0;
    public Rect g0;
    public d0 h0;
    public e0 i0;
    public final Object l;
    public final Context m;
    public Window n;
    public n o;
    public final z p;
    public x q;
    public MenuInflater r;
    public CharSequence s;
    public i2 t;
    public h u;
    public u v;
    public r0 w;
    public ActionBarContextView x;
    public PopupWindow y;
    public Runnable z;

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = i2 < 21;
        g = z;
        h = new int[]{16842836};
        i = !"robolectric".equals(Build.FINGERPRINT);
        j = i2 >= 17;
        if (z && !k) {
            Thread.UncaughtExceptionHandler defHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new a(defHandler));
            k = true;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$a */
    /* loaded from: classes.dex */
    public class a implements Thread.UncaughtExceptionHandler {
        public final /* synthetic */ Thread.UncaughtExceptionHandler a;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.a = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable throwable) {
            if (a(throwable)) {
                Throwable wrapped = new Resources.NotFoundException(throwable.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                wrapped.initCause(throwable.getCause());
                wrapped.setStackTrace(throwable.getStackTrace());
                this.a.uncaughtException(thread, wrapped);
                return;
            }
            this.a.uncaughtException(thread, throwable);
        }

        public final boolean a(Throwable throwable) {
            String message;
            if (!(throwable instanceof Resources.NotFoundException) || (message = throwable.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0 b0Var = b0.this;
            if ((b0Var.c0 & 1) != 0) {
                b0Var.U(0);
            }
            b0 b0Var2 = b0.this;
            if ((b0Var2.c0 & 4096) != 0) {
                b0Var2.U(108);
            }
            b0 b0Var3 = b0.this;
            b0Var3.b0 = false;
            b0Var3.c0 = 0;
        }
    }

    public b0(Activity activity, z callback) {
        this(activity, null, callback, activity);
    }

    public b0(Dialog dialog, z callback) {
        this(dialog.getContext(), dialog.getWindow(), callback, dialog);
    }

    public b0(Context context, Window window, z callback, Object host) {
        z3<String, Integer> z3Var;
        Integer value;
        AppCompatActivity activity;
        this.A = null;
        this.B = true;
        this.V = -100;
        this.d0 = new b();
        this.m = context;
        this.p = callback;
        this.l = host;
        if (this.V == -100 && (host instanceof Dialog) && (activity = I0()) != null) {
            this.V = activity.B().l();
        }
        if (this.V == -100 && (value = (z3Var = f).get(host.getClass().getName())) != null) {
            this.V = value.intValue();
            z3Var.remove(host.getClass().getName());
        }
        if (window != null) {
            J(window);
        }
        y1.h();
    }

    @Override // defpackage.a0
    public Context f(Context baseContext) {
        boolean needsThemeRebase = true;
        this.R = true;
        int modeToApply = n0(baseContext, K());
        if (j && (baseContext instanceof ContextThemeWrapper)) {
            Configuration config = Q(baseContext, modeToApply, null);
            try {
                r.a((ContextThemeWrapper) baseContext, config);
                return baseContext;
            } catch (IllegalStateException e2) {
            }
        }
        if (baseContext instanceof t0) {
            Configuration config2 = Q(baseContext, modeToApply, null);
            try {
                ((t0) baseContext).a(config2);
                return baseContext;
            } catch (IllegalStateException e3) {
            }
        }
        if (!i) {
            return super.f(baseContext);
        }
        Configuration configOverlay = null;
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration overrideConfig = new Configuration();
            overrideConfig.uiMode = -1;
            overrideConfig.fontScale = 0.0f;
            Configuration referenceConfig = j.a(baseContext, overrideConfig).getResources().getConfiguration();
            Configuration baseConfig = baseContext.getResources().getConfiguration();
            referenceConfig.uiMode = baseConfig.uiMode;
            if (!referenceConfig.equals(baseConfig)) {
                configOverlay = Z(referenceConfig, baseConfig);
            }
        }
        Configuration config3 = Q(baseContext, modeToApply, configOverlay);
        t0 wrappedContext = new t0(baseContext, v.Theme_AppCompat_Empty);
        wrappedContext.a(config3);
        try {
            if (baseContext.getTheme() == null) {
                needsThemeRebase = false;
            }
        } catch (NullPointerException e4) {
            needsThemeRebase = false;
        }
        if (needsThemeRebase) {
            v7.b.a(wrappedContext.getTheme());
        }
        return super.f(wrappedContext);
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$r */
    /* loaded from: classes.dex */
    public static class r {
        public static void a(ContextThemeWrapper context, Configuration overrideConfiguration) {
            context.applyOverrideConfiguration(overrideConfiguration);
        }
    }

    @Override // defpackage.a0
    public void r(Bundle savedInstanceState) {
        this.R = true;
        H(false);
        X();
        Object obj = this.l;
        if (obj instanceof Activity) {
            String parentActivityName = null;
            try {
                parentActivityName = d7.c((Activity) obj);
            } catch (IllegalArgumentException e2) {
            }
            if (parentActivityName != null) {
                x ab = y0();
                if (ab == null) {
                    this.e0 = true;
                } else {
                    ab.r(true);
                }
            }
            a0.c(this);
        }
        this.S = true;
    }

    @Override // defpackage.a0
    public void t(Bundle savedInstanceState) {
        W();
    }

    @Override // defpackage.a0
    public x n() {
        g0();
        return this.q;
    }

    public final x y0() {
        return this.q;
    }

    public final Window.Callback f0() {
        return this.n.getCallback();
    }

    public final void g0() {
        W();
        if (!this.I || this.q != null) {
            return;
        }
        Object obj = this.l;
        if (obj instanceof Activity) {
            this.q = new i0((Activity) this.l, this.J);
        } else if (obj instanceof Dialog) {
            this.q = new i0((Dialog) this.l);
        }
        x xVar = this.q;
        if (xVar != null) {
            xVar.r(this.e0);
        }
    }

    public final Context a0() {
        Context context = null;
        x ab = n();
        if (ab != null) {
            context = ab.k();
        }
        if (context == null) {
            Context context2 = this.m;
            return context2;
        }
        return context;
    }

    @Override // defpackage.a0
    public MenuInflater m() {
        if (this.r == null) {
            g0();
            x xVar = this.q;
            this.r = new w0(xVar != null ? xVar.k() : this.m);
        }
        return this.r;
    }

    @Override // defpackage.a0
    public <T extends View> T j(int id) {
        W();
        return (T) this.n.findViewById(id);
    }

    @Override // defpackage.a0
    public void q(Configuration newConfig) {
        x ab;
        if (this.I && this.C && (ab = n()) != null) {
            ab.m(newConfig);
        }
        y1.b().g(this.m);
        H(false);
    }

    @Override // defpackage.a0
    public void w() {
        this.T = true;
        G();
    }

    @Override // defpackage.a0
    public void x() {
        this.T = false;
        x ab = n();
        if (ab != null) {
            ab.s(false);
        }
    }

    @Override // defpackage.a0
    public void u() {
        x ab = n();
        if (ab != null) {
            ab.s(true);
        }
    }

    @Override // defpackage.a0
    public void C(View v) {
        W();
        ViewGroup contentParent = (ViewGroup) this.D.findViewById(16908290);
        contentParent.removeAllViews();
        contentParent.addView(v);
        this.o.a().onContentChanged();
    }

    @Override // defpackage.a0
    public void B(int resId) {
        W();
        ViewGroup contentParent = (ViewGroup) this.D.findViewById(16908290);
        contentParent.removeAllViews();
        LayoutInflater.from(this.m).inflate(resId, contentParent);
        this.o.a().onContentChanged();
    }

    @Override // defpackage.a0
    public void D(View v, ViewGroup.LayoutParams lp) {
        W();
        ViewGroup contentParent = (ViewGroup) this.D.findViewById(16908290);
        contentParent.removeAllViews();
        contentParent.addView(v, lp);
        this.o.a().onContentChanged();
    }

    @Override // defpackage.a0
    public void d(View v, ViewGroup.LayoutParams lp) {
        W();
        ViewGroup contentParent = (ViewGroup) this.D.findViewById(16908290);
        contentParent.addView(v, lp);
        this.o.a().onContentChanged();
    }

    @Override // defpackage.a0
    public void v(Bundle outState) {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    @Override // defpackage.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.l
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            defpackage.a0.y(r3)
        L9:
            boolean r0 = r3.b0
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.n
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.d0
            r0.removeCallbacks(r1)
        L18:
            r0 = 0
            r3.T = r0
            r0 = 1
            r3.U = r0
            int r0 = r3.V
            r1 = -100
            if (r0 == r1) goto L48
            java.lang.Object r0 = r3.l
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L48
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L48
            z3<java.lang.String, java.lang.Integer> r0 = defpackage.b0.f
            java.lang.Object r1 = r3.l
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.V
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L57
        L48:
            z3<java.lang.String, java.lang.Integer> r0 = defpackage.b0.f
            java.lang.Object r1 = r3.l
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L57:
            x r0 = r3.q
            if (r0 == 0) goto L5e
            r0.n()
        L5e:
            r3.N()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b0.s():void");
    }

    public final void N() {
        p pVar = this.Z;
        if (pVar != null) {
            pVar.a();
        }
        p pVar2 = this.a0;
        if (pVar2 != null) {
            pVar2.a();
        }
    }

    @Override // defpackage.a0
    public void E(int themeResId) {
        this.W = themeResId;
    }

    public final void X() {
        if (this.n == null) {
            Object obj = this.l;
            if (obj instanceof Activity) {
                J(((Activity) obj).getWindow());
            }
        }
        if (this.n == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final void J(Window window) {
        if (this.n != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof n) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        n nVar = new n(callback);
        this.o = nVar;
        window.setCallback(nVar);
        z2 a2 = z2.t(this.m, null, h);
        Drawable winBg = a2.g(0);
        if (winBg != null) {
            window.setBackgroundDrawable(winBg);
        }
        a2.v();
        this.n = window;
    }

    public final void W() {
        if (!this.C) {
            this.D = R();
            CharSequence title = e0();
            if (!TextUtils.isEmpty(title)) {
                i2 i2Var = this.t;
                if (i2Var != null) {
                    i2Var.setWindowTitle(title);
                } else if (y0() != null) {
                    y0().t(title);
                } else {
                    TextView textView = this.E;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
            I();
            w0(this.D);
            this.C = true;
            t st = d0(0, false);
            if (this.U) {
                return;
            }
            if (st == null || st.j == null) {
                k0(108);
            }
        }
    }

    public final ViewGroup R() {
        Context themedContext;
        TypedArray a2 = this.m.obtainStyledAttributes(w.z0);
        int i2 = w.E0;
        if (!a2.hasValue(i2)) {
            a2.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (a2.getBoolean(w.N0, false)) {
            A(1);
        } else if (a2.getBoolean(i2, false)) {
            A(108);
        }
        if (a2.getBoolean(w.F0, false)) {
            A(r6.g3);
        }
        if (a2.getBoolean(w.G0, false)) {
            A(10);
        }
        this.L = a2.getBoolean(w.A0, false);
        a2.recycle();
        X();
        this.n.getDecorView();
        LayoutInflater inflater = LayoutInflater.from(this.m);
        ViewGroup subDecor = null;
        if (!this.M) {
            if (this.L) {
                subDecor = (ViewGroup) inflater.inflate(defpackage.t.f, (ViewGroup) null);
                this.J = false;
                this.I = false;
            } else if (this.I) {
                TypedValue outValue = new TypedValue();
                this.m.getTheme().resolveAttribute(defpackage.n.f, outValue, true);
                int i3 = outValue.resourceId;
                if (i3 != 0) {
                    themedContext = new t0(this.m, i3);
                } else {
                    themedContext = this.m;
                }
                subDecor = (ViewGroup) LayoutInflater.from(themedContext).inflate(defpackage.t.p, (ViewGroup) null);
                i2 i2Var = (i2) subDecor.findViewById(defpackage.s.p);
                this.t = i2Var;
                i2Var.setWindowCallback(f0());
                if (this.J) {
                    this.t.k(r6.g3);
                }
                if (this.G) {
                    this.t.k(2);
                }
                if (this.H) {
                    this.t.k(5);
                }
            }
        } else {
            subDecor = this.K ? (ViewGroup) inflater.inflate(defpackage.t.o, (ViewGroup) null) : (ViewGroup) inflater.inflate(defpackage.t.n, (ViewGroup) null);
        }
        if (subDecor == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.I + ", windowActionBarOverlay: " + this.J + ", android:windowIsFloating: " + this.L + ", windowActionModeOverlay: " + this.K + ", windowNoTitle: " + this.M + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            ga.g0(subDecor, new c());
        } else if (subDecor instanceof m2) {
            ((m2) subDecor).setOnFitSystemWindowsListener(new d());
        }
        if (this.t == null) {
            this.E = (TextView) subDecor.findViewById(defpackage.s.M);
        }
        f3.c(subDecor);
        ContentFrameLayout contentView = (ContentFrameLayout) subDecor.findViewById(defpackage.s.b);
        ViewGroup windowContentView = (ViewGroup) this.n.findViewById(16908290);
        if (windowContentView != null) {
            while (windowContentView.getChildCount() > 0) {
                View child = windowContentView.getChildAt(0);
                windowContentView.removeViewAt(0);
                contentView.addView(child);
            }
            windowContentView.setId(-1);
            contentView.setId(16908290);
            if (windowContentView instanceof FrameLayout) {
                ((FrameLayout) windowContentView).setForeground(null);
            }
        }
        this.n.setContentView(subDecor);
        contentView.setAttachListener(new e());
        return subDecor;
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$c */
    /* loaded from: classes.dex */
    public class c implements ba {
        public c() {
        }

        @Override // defpackage.ba
        public oa a(View v, oa insets) {
            int top = insets.h();
            int newTop = b0.this.L0(insets, null);
            if (top != newTop) {
                insets = insets.l(insets.f(), newTop, insets.g(), insets.e());
            }
            return ga.P(v, insets);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$d */
    /* loaded from: classes.dex */
    public class d implements m2.a {
        public d() {
        }

        @Override // defpackage.m2.a
        public void a(Rect insets) {
            insets.top = b0.this.L0(null, insets);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$e */
    /* loaded from: classes.dex */
    public class e implements ContentFrameLayout.a {
        public e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            b0.this.S();
        }
    }

    public void w0(ViewGroup subDecor) {
    }

    public final void I() {
        ContentFrameLayout cfl = (ContentFrameLayout) this.D.findViewById(16908290);
        View windowDecor = this.n.getDecorView();
        cfl.b(windowDecor.getPaddingLeft(), windowDecor.getPaddingTop(), windowDecor.getPaddingRight(), windowDecor.getPaddingBottom());
        TypedArray a2 = this.m.obtainStyledAttributes(w.z0);
        a2.getValue(w.L0, cfl.getMinWidthMajor());
        a2.getValue(w.M0, cfl.getMinWidthMinor());
        int i2 = w.J0;
        if (a2.hasValue(i2)) {
            a2.getValue(i2, cfl.getFixedWidthMajor());
        }
        int i3 = w.K0;
        if (a2.hasValue(i3)) {
            a2.getValue(i3, cfl.getFixedWidthMinor());
        }
        int i4 = w.H0;
        if (a2.hasValue(i4)) {
            a2.getValue(i4, cfl.getFixedHeightMajor());
        }
        int i5 = w.I0;
        if (a2.hasValue(i5)) {
            a2.getValue(i5, cfl.getFixedHeightMinor());
        }
        a2.recycle();
        cfl.requestLayout();
    }

    @Override // defpackage.a0
    public boolean A(int featureId) {
        int featureId2 = C0(featureId);
        if (this.M && featureId2 == 108) {
            return false;
        }
        if (this.I && featureId2 == 1) {
            this.I = false;
        }
        switch (featureId2) {
            case 1:
                H0();
                this.M = true;
                return true;
            case 2:
                H0();
                this.G = true;
                return true;
            case 5:
                H0();
                this.H = true;
                return true;
            case 10:
                H0();
                this.K = true;
                return true;
            case 108:
                H0();
                this.I = true;
                return true;
            case r6.g3 /* 109 */:
                H0();
                this.J = true;
                return true;
            default:
                return this.n.requestFeature(featureId2);
        }
    }

    @Override // defpackage.a0
    public final void F(CharSequence title) {
        this.s = title;
        i2 i2Var = this.t;
        if (i2Var != null) {
            i2Var.setWindowTitle(title);
        } else if (y0() != null) {
            y0().t(title);
        } else {
            TextView textView = this.E;
            if (textView != null) {
                textView.setText(title);
            }
        }
    }

    public final CharSequence e0() {
        Object obj = this.l;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.s;
    }

    public void v0(int featureId) {
        if (featureId == 108) {
            x ab = n();
            if (ab != null) {
                ab.i(false);
            }
        } else if (featureId == 0) {
            t st = d0(featureId, true);
            if (st.o) {
                P(st, false);
            }
        }
    }

    public void u0(int featureId) {
        x ab;
        if (featureId == 108 && (ab = n()) != null) {
            ab.i(true);
        }
    }

    @Override // defpackage.f1.a
    public boolean a(f1 menu, MenuItem item) {
        t panel;
        Window.Callback cb = f0();
        if (cb != null && !this.U && (panel = Y(menu.D())) != null) {
            return cb.onMenuItemSelected(panel.a, item);
        }
        return false;
    }

    @Override // defpackage.f1.a
    public void b(f1 menu) {
        B0(true);
    }

    public r0 F0(r0.a callback) {
        z zVar;
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        r0 r0Var = this.w;
        if (r0Var != null) {
            r0Var.c();
        }
        r0.a wrappedCallback = new i(callback);
        x ab = n();
        if (ab != null) {
            r0 u2 = ab.u(wrappedCallback);
            this.w = u2;
            if (u2 != null && (zVar = this.p) != null) {
                zVar.e(u2);
            }
        }
        if (this.w == null) {
            this.w = G0(wrappedCallback);
        }
        return this.w;
    }

    @Override // defpackage.a0
    public void p() {
        x ab = n();
        if (ab == null || !ab.l()) {
            k0(0);
        }
    }

    public r0 G0(r0.a callback) {
        Context actionBarContext;
        z zVar;
        V();
        r0 r0Var = this.w;
        if (r0Var != null) {
            r0Var.c();
        }
        if (!(callback instanceof i)) {
            callback = new i(callback);
        }
        r0 mode = null;
        z zVar2 = this.p;
        if (zVar2 != null && !this.U) {
            try {
                mode = zVar2.j(callback);
            } catch (AbstractMethodError e2) {
            }
        }
        if (mode != null) {
            this.w = mode;
        } else {
            if (this.x == null) {
                if (this.L) {
                    TypedValue outValue = new TypedValue();
                    Resources.Theme baseTheme = this.m.getTheme();
                    baseTheme.resolveAttribute(defpackage.n.f, outValue, true);
                    if (outValue.resourceId != 0) {
                        Resources.Theme actionBarTheme = this.m.getResources().newTheme();
                        actionBarTheme.setTo(baseTheme);
                        actionBarTheme.applyStyle(outValue.resourceId, true);
                        actionBarContext = new t0(this.m, 0);
                        actionBarContext.getTheme().setTo(actionBarTheme);
                    } else {
                        actionBarContext = this.m;
                    }
                    this.x = new ActionBarContextView(actionBarContext);
                    PopupWindow popupWindow = new PopupWindow(actionBarContext, (AttributeSet) null, defpackage.n.i);
                    this.y = popupWindow;
                    fb.b(popupWindow, 2);
                    this.y.setContentView(this.x);
                    this.y.setWidth(-1);
                    actionBarContext.getTheme().resolveAttribute(defpackage.n.b, outValue, true);
                    int height = TypedValue.complexToDimensionPixelSize(outValue.data, actionBarContext.getResources().getDisplayMetrics());
                    this.x.setContentHeight(height);
                    this.y.setHeight(-2);
                    this.z = new f();
                } else {
                    ViewStubCompat stub = (ViewStubCompat) this.D.findViewById(defpackage.s.h);
                    if (stub != null) {
                        stub.setLayoutInflater(LayoutInflater.from(a0()));
                        this.x = (ActionBarContextView) stub.a();
                    }
                }
            }
            if (this.x != null) {
                V();
                this.x.k();
                r0 mode2 = new u0(this.x.getContext(), this.x, callback, this.y == null);
                if (callback.d(mode2, mode2.e())) {
                    mode2.k();
                    this.x.h(mode2);
                    this.w = mode2;
                    if (D0()) {
                        this.x.setAlpha(0.0f);
                        ka a2 = ga.b(this.x).a(1.0f);
                        this.A = a2;
                        a2.f(new g());
                    } else {
                        this.x.setAlpha(1.0f);
                        this.x.setVisibility(0);
                        this.x.sendAccessibilityEvent(32);
                        if (this.x.getParent() instanceof View) {
                            ga.W((View) this.x.getParent());
                        }
                    }
                    if (this.y != null) {
                        this.n.getDecorView().post(this.z);
                    }
                } else {
                    this.w = null;
                }
            }
        }
        r0 r0Var2 = this.w;
        if (r0Var2 != null && (zVar = this.p) != null) {
            zVar.e(r0Var2);
        }
        return this.w;
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$f */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0 b0Var = b0.this;
            b0Var.y.showAtLocation(b0Var.x, 55, 0, 0);
            b0.this.V();
            if (b0.this.D0()) {
                b0.this.x.setAlpha(0.0f);
                b0 b0Var2 = b0.this;
                b0Var2.A = ga.b(b0Var2.x).a(1.0f);
                b0.this.A.f(new a());
                return;
            }
            b0.this.x.setAlpha(1.0f);
            b0.this.x.setVisibility(0);
        }

        /* compiled from: AppCompatDelegateImpl.java */
        /* renamed from: b0$f$a */
        /* loaded from: classes.dex */
        public class a extends ma {
            public a() {
            }

            @Override // defpackage.ma, defpackage.la
            public void c(View view) {
                b0.this.x.setVisibility(0);
            }

            @Override // defpackage.la
            public void b(View view) {
                b0.this.x.setAlpha(1.0f);
                b0.this.A.f(null);
                b0.this.A = null;
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$g */
    /* loaded from: classes.dex */
    public class g extends ma {
        public g() {
        }

        @Override // defpackage.ma, defpackage.la
        public void c(View view) {
            b0.this.x.setVisibility(0);
            b0.this.x.sendAccessibilityEvent(32);
            if (b0.this.x.getParent() instanceof View) {
                ga.W((View) b0.this.x.getParent());
            }
        }

        @Override // defpackage.la
        public void b(View view) {
            b0.this.x.setAlpha(1.0f);
            b0.this.A.f(null);
            b0.this.A = null;
        }
    }

    public final boolean D0() {
        ViewGroup viewGroup;
        return this.C && (viewGroup = this.D) != null && ga.J(viewGroup);
    }

    public boolean m0() {
        return this.B;
    }

    public void V() {
        ka kaVar = this.A;
        if (kaVar != null) {
            kaVar.b();
        }
    }

    public boolean o0() {
        r0 r0Var = this.w;
        if (r0Var != null) {
            r0Var.c();
            return true;
        }
        x ab = n();
        return ab != null && ab.h();
    }

    public boolean r0(int keyCode, KeyEvent ev) {
        x ab = n();
        if (ab != null && ab.o(keyCode, ev)) {
            return true;
        }
        t tVar = this.P;
        if (tVar != null) {
            boolean handled = z0(tVar, ev.getKeyCode(), ev, 1);
            if (handled) {
                t tVar2 = this.P;
                if (tVar2 != null) {
                    tVar2.n = true;
                }
                return true;
            }
        }
        if (this.P == null) {
            t st = d0(0, true);
            A0(st, ev);
            boolean handled2 = z0(st, ev.getKeyCode(), ev, 1);
            st.m = false;
            if (handled2) {
                return true;
            }
        }
        return false;
    }

    public boolean T(KeyEvent event) {
        View root;
        Object obj = this.l;
        if (((obj instanceof q9.a) || (obj instanceof c0)) && (root = this.n.getDecorView()) != null && q9.d(root, event)) {
            return true;
        }
        if (event.getKeyCode() == 82 && this.o.a().dispatchKeyEvent(event)) {
            return true;
        }
        int keyCode = event.getKeyCode();
        int action = event.getAction();
        boolean isDown = action == 0;
        return isDown ? p0(keyCode, event) : s0(keyCode, event);
    }

    public boolean s0(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 82:
                t0(0, event);
                return true;
            case 4:
                boolean wasLongPressBackDown = this.Q;
                this.Q = false;
                t st = d0(0, false);
                if (st != null && st.o) {
                    if (!wasLongPressBackDown) {
                        P(st, true);
                    }
                    return true;
                } else if (o0()) {
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean p0(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 82:
                q0(0, event);
                return true;
            case 4:
                this.Q = (event.getFlags() & 128) != 0;
                break;
        }
        return false;
    }

    @Override // defpackage.a0
    public View i(View parent, String name, Context context, AttributeSet attrs) {
        boolean z = false;
        if (this.h0 == null) {
            TypedArray a2 = this.m.obtainStyledAttributes(w.z0);
            String viewInflaterClassName = a2.getString(w.D0);
            if (viewInflaterClassName == null) {
                this.h0 = new d0();
            } else {
                try {
                    Class<?> viewInflaterClass = Class.forName(viewInflaterClassName);
                    this.h0 = (d0) viewInflaterClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable t2) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + viewInflaterClassName + ". Falling back to default.", t2);
                    this.h0 = new d0();
                }
            }
        }
        boolean inheritContext = false;
        boolean z2 = g;
        if (z2) {
            if (this.i0 == null) {
                this.i0 = new e0();
            }
            if (this.i0.a(attrs)) {
                inheritContext = true;
            } else {
                if (attrs instanceof XmlPullParser) {
                    if (((XmlPullParser) attrs).getDepth() > 1) {
                        z = true;
                    }
                } else {
                    z = E0((ViewParent) parent);
                }
                inheritContext = z;
            }
        }
        return this.h0.q(parent, name, context, attrs, inheritContext, z2, true, e3.b());
    }

    public final boolean E0(ViewParent parent) {
        if (parent == null) {
            return false;
        }
        View windowDecor = this.n.getDecorView();
        while (parent != null) {
            if (parent == windowDecor || !(parent instanceof View) || ga.I((View) parent)) {
                return false;
            }
            parent = parent.getParent();
        }
        return true;
    }

    @Override // defpackage.a0
    public void o() {
        LayoutInflater layoutInflater = LayoutInflater.from(this.m);
        if (layoutInflater.getFactory() == null) {
            r9.b(layoutInflater, this);
        } else if (!(layoutInflater.getFactory2() instanceof b0)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return i(parent, name, context, attrs);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return onCreateView(null, name, context, attrs);
    }

    public final AppCompatActivity I0() {
        for (Context context = this.m; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
        }
        return null;
    }

    public final void x0(t st, KeyEvent event) {
        ViewGroup.LayoutParams lp;
        if (st.o || this.U) {
            return;
        }
        if (st.a == 0) {
            Configuration config = this.m.getResources().getConfiguration();
            boolean isXLarge = (config.screenLayout & 15) == 4;
            if (isXLarge) {
                return;
            }
        }
        Window.Callback cb = f0();
        if (cb != null && !cb.onMenuOpened(st.a, st.j)) {
            P(st, true);
            return;
        }
        WindowManager wm = (WindowManager) this.m.getSystemService("window");
        if (wm == null || !A0(st, event)) {
            return;
        }
        int width = -2;
        ViewGroup viewGroup = st.g;
        if (viewGroup == null || st.q) {
            if (viewGroup == null) {
                if (!i0(st) || st.g == null) {
                    return;
                }
            } else if (st.q && viewGroup.getChildCount() > 0) {
                st.g.removeAllViews();
            }
            if (!h0(st) || !st.b()) {
                st.q = true;
                return;
            }
            ViewGroup.LayoutParams lp2 = st.h.getLayoutParams();
            if (lp2 == null) {
                lp2 = new ViewGroup.LayoutParams(-2, -2);
            }
            int backgroundResId = st.b;
            st.g.setBackgroundResource(backgroundResId);
            ViewParent shownPanelParent = st.h.getParent();
            if (shownPanelParent instanceof ViewGroup) {
                ((ViewGroup) shownPanelParent).removeView(st.h);
            }
            st.g.addView(st.h, lp2);
            if (!st.h.hasFocus()) {
                st.h.requestFocus();
            }
        } else {
            View view = st.i;
            if (view != null && (lp = view.getLayoutParams()) != null && lp.width == -1) {
                width = -1;
            }
        }
        st.n = false;
        WindowManager.LayoutParams lp3 = new WindowManager.LayoutParams(width, -2, st.d, st.e, 1002, 8519680, -3);
        lp3.gravity = st.c;
        lp3.windowAnimations = st.f;
        wm.addView(st.g, lp3);
        st.o = true;
    }

    public final boolean i0(t st) {
        st.d(a0());
        st.g = new s(st.l);
        st.c = 81;
        return true;
    }

    public final void B0(boolean toggleMenuMode) {
        i2 i2Var = this.t;
        if (i2Var != null && i2Var.g() && (!ViewConfiguration.get(this.m).hasPermanentMenuKey() || this.t.d())) {
            Window.Callback cb = f0();
            if (!this.t.b() || !toggleMenuMode) {
                if (cb != null && !this.U) {
                    if (this.b0 && (this.c0 & 1) != 0) {
                        this.n.getDecorView().removeCallbacks(this.d0);
                        this.d0.run();
                    }
                    t st = d0(0, true);
                    f1 f1Var = st.j;
                    if (f1Var != null && !st.r && cb.onPreparePanel(0, st.i, f1Var)) {
                        cb.onMenuOpened(108, st.j);
                        this.t.f();
                        return;
                    }
                    return;
                }
                return;
            }
            this.t.e();
            if (!this.U) {
                cb.onPanelClosed(108, d0(0, true).j);
                return;
            }
            return;
        }
        t st2 = d0(0, true);
        st2.q = true;
        P(st2, false);
        x0(st2, null);
    }

    public final boolean j0(t st) {
        Context context = this.m;
        int i2 = st.a;
        if ((i2 == 0 || i2 == 108) && this.t != null) {
            TypedValue outValue = new TypedValue();
            Resources.Theme baseTheme = context.getTheme();
            baseTheme.resolveAttribute(defpackage.n.f, outValue, true);
            Resources.Theme widgetTheme = null;
            if (outValue.resourceId != 0) {
                widgetTheme = context.getResources().newTheme();
                widgetTheme.setTo(baseTheme);
                widgetTheme.applyStyle(outValue.resourceId, true);
                widgetTheme.resolveAttribute(defpackage.n.g, outValue, true);
            } else {
                baseTheme.resolveAttribute(defpackage.n.g, outValue, true);
            }
            if (outValue.resourceId != 0) {
                if (widgetTheme == null) {
                    widgetTheme = context.getResources().newTheme();
                    widgetTheme.setTo(baseTheme);
                }
                widgetTheme.applyStyle(outValue.resourceId, true);
            }
            if (widgetTheme != null) {
                context = new t0(context, 0);
                context.getTheme().setTo(widgetTheme);
            }
        }
        f1 menu = new f1(context);
        menu.R(this);
        st.c(menu);
        return true;
    }

    public final boolean h0(t st) {
        View view = st.i;
        if (view != null) {
            st.h = view;
            return true;
        } else if (st.j == null) {
            return false;
        } else {
            if (this.v == null) {
                this.v = new u();
            }
            m1 menuView = st.a(this.v);
            View view2 = (View) menuView;
            st.h = view2;
            return view2 != null;
        }
    }

    public final boolean A0(t st, KeyEvent event) {
        i2 i2Var;
        i2 i2Var2;
        i2 i2Var3;
        if (this.U) {
            return false;
        }
        if (st.m) {
            return true;
        }
        t tVar = this.P;
        if (tVar != null && tVar != st) {
            P(tVar, false);
        }
        Window.Callback cb = f0();
        if (cb != null) {
            st.i = cb.onCreatePanelView(st.a);
        }
        int i2 = st.a;
        boolean isActionBarMenu = i2 == 0 || i2 == 108;
        if (isActionBarMenu && (i2Var3 = this.t) != null) {
            i2Var3.c();
        }
        if (st.i == null) {
            if (isActionBarMenu) {
                y0();
            }
            f1 f1Var = st.j;
            if (f1Var == null || st.r) {
                if (f1Var == null && (!j0(st) || st.j == null)) {
                    return false;
                }
                if (isActionBarMenu && this.t != null) {
                    if (this.u == null) {
                        this.u = new h();
                    }
                    this.t.a(st.j, this.u);
                }
                st.j.d0();
                if (!cb.onCreatePanelMenu(st.a, st.j)) {
                    st.c(null);
                    if (isActionBarMenu && (i2Var = this.t) != null) {
                        i2Var.a(null, this.u);
                    }
                    return false;
                }
                st.r = false;
            }
            st.j.d0();
            Bundle bundle = st.s;
            if (bundle != null) {
                st.j.P(bundle);
                st.s = null;
            }
            if (!cb.onPreparePanel(0, st.i, st.j)) {
                if (isActionBarMenu && (i2Var2 = this.t) != null) {
                    i2Var2.a(null, this.u);
                }
                st.j.c0();
                return false;
            }
            KeyCharacterMap kmap = KeyCharacterMap.load(event != null ? event.getDeviceId() : -1);
            boolean z = kmap.getKeyboardType() != 1;
            st.p = z;
            st.j.setQwertyMode(z);
            st.j.c0();
        }
        st.m = true;
        st.n = false;
        this.P = st;
        return true;
    }

    public void M(f1 menu) {
        if (this.N) {
            return;
        }
        this.N = true;
        this.t.l();
        Window.Callback cb = f0();
        if (cb != null && !this.U) {
            cb.onPanelClosed(108, menu);
        }
        this.N = false;
    }

    public void O(int featureId) {
        P(d0(featureId, true), true);
    }

    public void P(t st, boolean doCallback) {
        ViewGroup viewGroup;
        i2 i2Var;
        if (doCallback && st.a == 0 && (i2Var = this.t) != null && i2Var.b()) {
            M(st.j);
            return;
        }
        WindowManager wm = (WindowManager) this.m.getSystemService("window");
        if (wm != null && st.o && (viewGroup = st.g) != null) {
            wm.removeView(viewGroup);
            if (doCallback) {
                L(st.a, st, null);
            }
        }
        st.m = false;
        st.n = false;
        st.o = false;
        st.h = null;
        st.q = true;
        if (this.P == st) {
            this.P = null;
        }
    }

    public final boolean q0(int featureId, KeyEvent event) {
        if (event.getRepeatCount() == 0) {
            t st = d0(featureId, true);
            if (!st.o) {
                return A0(st, event);
            }
            return false;
        }
        return false;
    }

    public final boolean t0(int featureId, KeyEvent event) {
        i2 i2Var;
        if (this.w != null) {
            return false;
        }
        boolean handled = false;
        t st = d0(featureId, true);
        if (featureId == 0 && (i2Var = this.t) != null && i2Var.g() && !ViewConfiguration.get(this.m).hasPermanentMenuKey()) {
            if (!this.t.b()) {
                if (!this.U && A0(st, event)) {
                    handled = this.t.f();
                }
            } else {
                handled = this.t.e();
            }
        } else if (st.o || st.n) {
            handled = st.o;
            P(st, true);
        } else if (st.m) {
            boolean show = true;
            if (st.r) {
                st.m = false;
                show = A0(st, event);
            }
            if (show) {
                x0(st, event);
                handled = true;
            }
        }
        if (handled) {
            AudioManager audioManager = (AudioManager) this.m.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return handled;
    }

    public void L(int featureId, t panel, Menu menu) {
        if (menu == null) {
            if (panel == null && featureId >= 0) {
                t[] tVarArr = this.O;
                if (featureId < tVarArr.length) {
                    panel = tVarArr[featureId];
                }
            }
            if (panel != null) {
                menu = panel.j;
            }
        }
        if ((panel == null || panel.o) && !this.U) {
            this.o.a().onPanelClosed(featureId, menu);
        }
    }

    public t Y(Menu menu) {
        t[] panels = this.O;
        int N = panels != null ? panels.length : 0;
        for (int i2 = 0; i2 < N; i2++) {
            t panel = panels[i2];
            if (panel != null && panel.j == menu) {
                return panel;
            }
        }
        return null;
    }

    public t d0(int featureId, boolean required) {
        t[] tVarArr = this.O;
        t[] ar = tVarArr;
        if (tVarArr == null || ar.length <= featureId) {
            t[] nar = new t[featureId + 1];
            if (ar != null) {
                System.arraycopy(ar, 0, nar, 0, ar.length);
            }
            ar = nar;
            this.O = nar;
        }
        t st = ar[featureId];
        if (st == null) {
            t st2 = new t(featureId);
            ar[featureId] = st2;
            return st2;
        }
        return st;
    }

    public final boolean z0(t st, int keyCode, KeyEvent event, int flags) {
        f1 f1Var;
        if (event.isSystem()) {
            return false;
        }
        boolean handled = false;
        if ((st.m || A0(st, event)) && (f1Var = st.j) != null) {
            handled = f1Var.performShortcut(keyCode, event, flags);
        }
        if (handled && (flags & 1) == 0 && this.t == null) {
            P(st, true);
        }
        return handled;
    }

    public final void k0(int featureId) {
        this.c0 |= 1 << featureId;
        if (!this.b0) {
            ga.U(this.n.getDecorView(), this.d0);
            this.b0 = true;
        }
    }

    public void U(int featureId) {
        t st;
        t st2 = d0(featureId, true);
        if (st2.j != null) {
            Bundle savedActionViewStates = new Bundle();
            st2.j.Q(savedActionViewStates);
            if (savedActionViewStates.size() > 0) {
                st2.s = savedActionViewStates;
            }
            st2.j.d0();
            st2.j.clear();
        }
        st2.r = true;
        st2.q = true;
        if ((featureId == 108 || featureId == 0) && this.t != null && (st = d0(0, false)) != null) {
            st.m = false;
            A0(st, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int L0(defpackage.oa r18, android.graphics.Rect r19) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b0.L0(oa, android.graphics.Rect):int");
    }

    public final void M0(View v) {
        int b2;
        boolean lightStatusBar = (ga.D(v) & 8192) != 0;
        if (lightStatusBar) {
            b2 = m7.b(this.m, defpackage.p.abc_decor_view_status_guard_light);
        } else {
            b2 = m7.b(this.m, defpackage.p.abc_decor_view_status_guard);
        }
        v.setBackgroundColor(b2);
    }

    public final void H0() {
        if (this.C) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final int C0(int featureId) {
        if (featureId == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (featureId == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return r6.g3;
        } else {
            return featureId;
        }
    }

    public void S() {
        f1 f1Var;
        i2 i2Var = this.t;
        if (i2Var != null) {
            i2Var.l();
        }
        if (this.y != null) {
            this.n.getDecorView().removeCallbacks(this.z);
            if (this.y.isShowing()) {
                try {
                    this.y.dismiss();
                } catch (IllegalArgumentException e2) {
                }
            }
            this.y = null;
        }
        V();
        t st = d0(0, false);
        if (st != null && (f1Var = st.j) != null) {
            f1Var.close();
        }
    }

    public boolean G() {
        return H(true);
    }

    public final boolean H(boolean allowRecreation) {
        if (this.U) {
            return false;
        }
        int nightMode = K();
        int modeToApply = n0(this.m, nightMode);
        boolean applied = J0(modeToApply, allowRecreation);
        if (nightMode == 0) {
            c0(this.m).e();
        } else {
            p pVar = this.Z;
            if (pVar != null) {
                pVar.a();
            }
        }
        if (nightMode == 3) {
            b0(this.m).e();
        } else {
            p pVar2 = this.a0;
            if (pVar2 != null) {
                pVar2.a();
            }
        }
        return applied;
    }

    @Override // defpackage.a0
    public int l() {
        return this.V;
    }

    public int n0(Context context, int mode) {
        switch (mode) {
            case Priority.BG_TOP /* -100 */:
                return -1;
            case -1:
            case 1:
            case 2:
                return mode;
            case 0:
                if (Build.VERSION.SDK_INT >= 23) {
                    UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
                    if (uiModeManager.getNightMode() == 0) {
                        return -1;
                    }
                }
                return c0(context).c();
            case 3:
                return b0(context).c();
            default:
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
        }
    }

    public final int K() {
        int i2 = this.V;
        return i2 != -100 ? i2 : a0.k();
    }

    public final Configuration Q(Context context, int mode, Configuration configOverlay) {
        int newNightMode;
        switch (mode) {
            case 1:
                newNightMode = 16;
                break;
            case 2:
                newNightMode = 32;
                break;
            default:
                Configuration appConfig = context.getApplicationContext().getResources().getConfiguration();
                newNightMode = appConfig.uiMode & 48;
                break;
        }
        Configuration overrideConf = new Configuration();
        overrideConf.fontScale = 0.0f;
        if (configOverlay != null) {
            overrideConf.setTo(configOverlay);
        }
        overrideConf.uiMode = (overrideConf.uiMode & (-49)) | newNightMode;
        return overrideConf;
    }

    public final boolean J0(int mode, boolean allowRecreation) {
        boolean handled = false;
        Configuration overrideConfig = Q(this.m, mode, null);
        boolean activityHandlingUiMode = l0();
        int currentNightMode = this.m.getResources().getConfiguration().uiMode & 48;
        int newNightMode = overrideConfig.uiMode & 48;
        if (currentNightMode != newNightMode && allowRecreation && !activityHandlingUiMode && this.R && (i || this.S)) {
            Object obj = this.l;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                z6.i((Activity) this.l);
                handled = true;
            }
        }
        if (!handled && currentNightMode != newNightMode) {
            K0(newNightMode, activityHandlingUiMode, null);
            handled = true;
        }
        if (handled) {
            Object obj2 = this.l;
            if (obj2 instanceof AppCompatActivity) {
                ((AppCompatActivity) obj2).F(mode);
            }
        }
        return handled;
    }

    public final void K0(int uiModeNightModeValue, boolean callOnConfigChange, Configuration configOverlay) {
        Resources res = this.m.getResources();
        Configuration conf = new Configuration(res.getConfiguration());
        if (configOverlay != null) {
            conf.updateFrom(configOverlay);
        }
        conf.uiMode = (res.getConfiguration().uiMode & (-49)) | uiModeNightModeValue;
        res.updateConfiguration(conf, null);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            f0.a(res);
        }
        int i3 = this.W;
        if (i3 != 0) {
            this.m.setTheme(i3);
            if (i2 >= 23) {
                this.m.getTheme().applyStyle(this.W, true);
            }
        }
        if (callOnConfigChange) {
            Object obj = this.l;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof fd) {
                    cd lifecycle = ((fd) activity).a();
                    if (lifecycle.b().a(cd.c.STARTED)) {
                        activity.onConfigurationChanged(conf);
                    }
                } else if (this.T) {
                    activity.onConfigurationChanged(conf);
                }
            }
        }
    }

    public final p c0(Context context) {
        if (this.Z == null) {
            this.Z = new q(h0.a(context));
        }
        return this.Z;
    }

    public final p b0(Context context) {
        if (this.a0 == null) {
            this.a0 = new o(context);
        }
        return this.a0;
    }

    public final boolean l0() {
        if (!this.Y && (this.l instanceof Activity)) {
            PackageManager pm = this.m.getPackageManager();
            if (pm == null) {
                return false;
            }
            int flags = 0;
            try {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 29) {
                    flags = 269221888;
                } else if (i2 >= 24) {
                    flags = 786432;
                }
                ActivityInfo info = pm.getActivityInfo(new ComponentName(this.m, this.l.getClass()), flags);
                this.X = (info == null || (info.configChanges & IInputController.KEYCODE_BACK_BUTTON) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.X = false;
            }
        }
        this.Y = true;
        return this.X;
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$i */
    /* loaded from: classes.dex */
    public class i implements r0.a {
        public r0.a a;

        public i(r0.a wrapped) {
            this.a = wrapped;
        }

        @Override // defpackage.r0.a
        public boolean d(r0 mode, Menu menu) {
            return this.a.d(mode, menu);
        }

        @Override // defpackage.r0.a
        public boolean a(r0 mode, Menu menu) {
            ga.W(b0.this.D);
            return this.a.a(mode, menu);
        }

        @Override // defpackage.r0.a
        public boolean c(r0 mode, MenuItem item) {
            return this.a.c(mode, item);
        }

        @Override // defpackage.r0.a
        public void b(r0 mode) {
            this.a.b(mode);
            b0 b0Var = b0.this;
            if (b0Var.y != null) {
                b0Var.n.getDecorView().removeCallbacks(b0.this.z);
            }
            b0 b0Var2 = b0.this;
            if (b0Var2.x != null) {
                b0Var2.V();
                b0 b0Var3 = b0.this;
                b0Var3.A = ga.b(b0Var3.x).a(0.0f);
                b0.this.A.f(new a());
            }
            b0 b0Var4 = b0.this;
            z zVar = b0Var4.p;
            if (zVar != null) {
                zVar.f(b0Var4.w);
            }
            b0 b0Var5 = b0.this;
            b0Var5.w = null;
            ga.W(b0Var5.D);
        }

        /* compiled from: AppCompatDelegateImpl.java */
        /* renamed from: b0$i$a */
        /* loaded from: classes.dex */
        public class a extends ma {
            public a() {
            }

            @Override // defpackage.la
            public void b(View view) {
                b0.this.x.setVisibility(8);
                b0 b0Var = b0.this;
                PopupWindow popupWindow = b0Var.y;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (b0Var.x.getParent() instanceof View) {
                    ga.W((View) b0.this.x.getParent());
                }
                b0.this.x.k();
                b0.this.A.f(null);
                b0 b0Var2 = b0.this;
                b0Var2.A = null;
                ga.W(b0Var2.D);
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$u */
    /* loaded from: classes.dex */
    public final class u implements l1.a {
        public u() {
        }

        @Override // defpackage.l1.a
        public void a(f1 menu, boolean allMenusAreClosing) {
            Menu parentMenu = menu.D();
            boolean isSubMenu = parentMenu != menu;
            t panel = b0.this.Y(isSubMenu ? parentMenu : menu);
            if (panel != null) {
                if (isSubMenu) {
                    b0.this.L(panel.a, panel, parentMenu);
                    b0.this.P(panel, true);
                    return;
                }
                b0.this.P(panel, allMenusAreClosing);
            }
        }

        @Override // defpackage.l1.a
        public boolean b(f1 subMenu) {
            Window.Callback cb;
            if (subMenu == subMenu.D()) {
                b0 b0Var = b0.this;
                if (b0Var.I && (cb = b0Var.f0()) != null && !b0.this.U) {
                    cb.onMenuOpened(108, subMenu);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$h */
    /* loaded from: classes.dex */
    public final class h implements l1.a {
        public h() {
        }

        @Override // defpackage.l1.a
        public boolean b(f1 subMenu) {
            Window.Callback cb = b0.this.f0();
            if (cb != null) {
                cb.onMenuOpened(108, subMenu);
                return true;
            }
            return true;
        }

        @Override // defpackage.l1.a
        public void a(f1 menu, boolean allMenusAreClosing) {
            b0.this.M(menu);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$t */
    /* loaded from: classes.dex */
    public static final class t {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public ViewGroup g;
        public View h;
        public View i;
        public f1 j;
        public d1 k;
        public Context l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public boolean q = false;
        public boolean r;
        public Bundle s;

        public t(int featureId) {
            this.a = featureId;
        }

        public boolean b() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.b().getCount() > 0;
        }

        public void d(Context context) {
            TypedValue outValue = new TypedValue();
            Resources.Theme widgetTheme = context.getResources().newTheme();
            widgetTheme.setTo(context.getTheme());
            widgetTheme.resolveAttribute(defpackage.n.a, outValue, true);
            int i = outValue.resourceId;
            if (i != 0) {
                widgetTheme.applyStyle(i, true);
            }
            widgetTheme.resolveAttribute(defpackage.n.E, outValue, true);
            int i2 = outValue.resourceId;
            if (i2 != 0) {
                widgetTheme.applyStyle(i2, true);
            } else {
                widgetTheme.applyStyle(v.b, true);
            }
            Context context2 = new t0(context, 0);
            context2.getTheme().setTo(widgetTheme);
            this.l = context2;
            TypedArray a = context2.obtainStyledAttributes(w.z0);
            this.b = a.getResourceId(w.C0, 0);
            this.f = a.getResourceId(w.B0, 0);
            a.recycle();
        }

        public void c(f1 menu) {
            d1 d1Var;
            f1 f1Var = this.j;
            if (menu == f1Var) {
                return;
            }
            if (f1Var != null) {
                f1Var.O(this.k);
            }
            this.j = menu;
            if (menu == null || (d1Var = this.k) == null) {
                return;
            }
            menu.b(d1Var);
        }

        public m1 a(l1.a cb) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                d1 d1Var = new d1(this.l, defpackage.t.j);
                this.k = d1Var;
                d1Var.k(cb);
                this.j.b(this.k);
            }
            m1 result = this.k.d(this.g);
            return result;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$s */
    /* loaded from: classes.dex */
    public class s extends ContentFrameLayout {
        public s(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent event) {
            return b0.this.T(event) || super.dispatchKeyEvent(event);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent event) {
            int action = event.getAction();
            if (action == 0) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                if (c(x, y)) {
                    b0.this.O(0);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(event);
        }

        @Override // android.view.View
        public void setBackgroundResource(int resid) {
            setBackgroundDrawable(j0.d(getContext(), resid));
        }

        public final boolean c(int x, int y) {
            return x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$n */
    /* loaded from: classes.dex */
    public class n extends y0 {
        public n(Window.Callback callback) {
            super(callback);
        }

        @Override // defpackage.y0, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent event) {
            return b0.this.T(event) || super.dispatchKeyEvent(event);
        }

        @Override // defpackage.y0, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent event) {
            return super.dispatchKeyShortcutEvent(event) || b0.this.r0(event.getKeyCode(), event);
        }

        @Override // defpackage.y0, android.view.Window.Callback
        public boolean onCreatePanelMenu(int featureId, Menu menu) {
            if (featureId == 0 && !(menu instanceof f1)) {
                return false;
            }
            return super.onCreatePanelMenu(featureId, menu);
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // defpackage.y0, android.view.Window.Callback
        public boolean onPreparePanel(int featureId, View view, Menu menu) {
            f1 mb = menu instanceof f1 ? (f1) menu : null;
            if (featureId == 0 && mb == null) {
                return false;
            }
            if (mb != null) {
                mb.a0(true);
            }
            boolean handled = super.onPreparePanel(featureId, view, menu);
            if (mb != null) {
                mb.a0(false);
            }
            return handled;
        }

        @Override // defpackage.y0, android.view.Window.Callback
        public boolean onMenuOpened(int featureId, Menu menu) {
            super.onMenuOpened(featureId, menu);
            b0.this.u0(featureId);
            return true;
        }

        @Override // defpackage.y0, android.view.Window.Callback
        public void onPanelClosed(int featureId, Menu menu) {
            super.onPanelClosed(featureId, menu);
            b0.this.v0(featureId);
        }

        @Override // defpackage.y0, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (b0.this.m0()) {
                return b(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        public final ActionMode b(ActionMode.Callback callback) {
            v0.a callbackWrapper = new v0.a(b0.this.m, callback);
            r0 supportActionMode = b0.this.F0(callbackWrapper);
            if (supportActionMode != null) {
                return callbackWrapper.e(supportActionMode);
            }
            return null;
        }

        @Override // defpackage.y0, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
            if (b0.this.m0()) {
                switch (type) {
                    case 0:
                        return b(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, type);
        }

        @Override // defpackage.y0, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
            f1 f1Var;
            t panel = b0.this.d0(0, true);
            if (panel != null && (f1Var = panel.j) != null) {
                super.onProvideKeyboardShortcuts(data, f1Var, deviceId);
            } else {
                super.onProvideKeyboardShortcuts(data, menu, deviceId);
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$p */
    /* loaded from: classes.dex */
    public abstract class p {
        public BroadcastReceiver a;

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public p() {
        }

        public void e() {
            a();
            IntentFilter filter = b();
            if (filter == null || filter.countActions() == 0) {
                return;
            }
            if (this.a == null) {
                this.a = new a();
            }
            b0.this.m.registerReceiver(this.a, filter);
        }

        /* compiled from: AppCompatDelegateImpl.java */
        /* renamed from: b0$p$a */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                p.this.d();
            }
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    b0.this.m.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException e) {
                }
                this.a = null;
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$q */
    /* loaded from: classes.dex */
    public class q extends p {
        public final h0 c;

        public q(h0 twilightManager) {
            super();
            this.c = twilightManager;
        }

        @Override // defpackage.b0.p
        public int c() {
            return this.c.d() ? 2 : 1;
        }

        @Override // defpackage.b0.p
        public void d() {
            b0.this.G();
        }

        @Override // defpackage.b0.p
        public IntentFilter b() {
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.TIME_SET");
            filter.addAction("android.intent.action.TIMEZONE_CHANGED");
            filter.addAction("android.intent.action.TIME_TICK");
            return filter;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$o */
    /* loaded from: classes.dex */
    public class o extends p {
        public final PowerManager c;

        public o(Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // defpackage.b0.p
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !k.a(this.c)) ? 1 : 2;
        }

        @Override // defpackage.b0.p
        public void d() {
            b0.this.G();
        }

        @Override // defpackage.b0.p
        public IntentFilter b() {
            if (Build.VERSION.SDK_INT >= 21) {
                IntentFilter filter = new IntentFilter();
                filter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return filter;
            }
            return null;
        }
    }

    public static Configuration Z(Configuration base, Configuration change) {
        Configuration delta = new Configuration();
        delta.fontScale = 0.0f;
        if (change == null || base.diff(change) == 0) {
            return delta;
        }
        float f2 = base.fontScale;
        float f3 = change.fontScale;
        if (f2 != f3) {
            delta.fontScale = f3;
        }
        int i2 = base.mcc;
        int i3 = change.mcc;
        if (i2 != i3) {
            delta.mcc = i3;
        }
        int i4 = base.mnc;
        int i5 = change.mnc;
        if (i4 != i5) {
            delta.mnc = i5;
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 24) {
            l.a(base, change, delta);
        } else if (!f9.a(base.locale, change.locale)) {
            delta.locale = change.locale;
        }
        int i7 = base.touchscreen;
        int i8 = change.touchscreen;
        if (i7 != i8) {
            delta.touchscreen = i8;
        }
        int i9 = base.keyboard;
        int i10 = change.keyboard;
        if (i9 != i10) {
            delta.keyboard = i10;
        }
        int i11 = base.keyboardHidden;
        int i12 = change.keyboardHidden;
        if (i11 != i12) {
            delta.keyboardHidden = i12;
        }
        int i13 = base.navigation;
        int i14 = change.navigation;
        if (i13 != i14) {
            delta.navigation = i14;
        }
        int i15 = base.navigationHidden;
        int i16 = change.navigationHidden;
        if (i15 != i16) {
            delta.navigationHidden = i16;
        }
        int i17 = base.orientation;
        int i18 = change.orientation;
        if (i17 != i18) {
            delta.orientation = i18;
        }
        int i19 = base.screenLayout & 15;
        int i20 = change.screenLayout;
        if (i19 != (i20 & 15)) {
            delta.screenLayout |= i20 & 15;
        }
        int i21 = base.screenLayout & 192;
        int i22 = change.screenLayout;
        if (i21 != (i22 & 192)) {
            delta.screenLayout |= i22 & 192;
        }
        int i23 = base.screenLayout & 48;
        int i24 = change.screenLayout;
        if (i23 != (i24 & 48)) {
            delta.screenLayout |= i24 & 48;
        }
        int i25 = base.screenLayout & 768;
        int i26 = change.screenLayout;
        if (i25 != (i26 & 768)) {
            delta.screenLayout |= i26 & 768;
        }
        if (i6 >= 26) {
            m.a(base, change, delta);
        }
        int i27 = base.uiMode & 15;
        int i28 = change.uiMode;
        if (i27 != (i28 & 15)) {
            delta.uiMode |= i28 & 15;
        }
        int i29 = base.uiMode & 48;
        int i30 = change.uiMode;
        if (i29 != (i30 & 48)) {
            delta.uiMode |= i30 & 48;
        }
        int i31 = base.screenWidthDp;
        int i32 = change.screenWidthDp;
        if (i31 != i32) {
            delta.screenWidthDp = i32;
        }
        int i33 = base.screenHeightDp;
        int i34 = change.screenHeightDp;
        if (i33 != i34) {
            delta.screenHeightDp = i34;
        }
        int i35 = base.smallestScreenWidthDp;
        int i36 = change.smallestScreenWidthDp;
        if (i35 != i36) {
            delta.smallestScreenWidthDp = i36;
        }
        if (i6 >= 17) {
            j.b(base, change, delta);
        }
        return delta;
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$j */
    /* loaded from: classes.dex */
    public static class j {
        public static void b(Configuration base, Configuration change, Configuration delta) {
            int i = base.densityDpi;
            int i2 = change.densityDpi;
            if (i != i2) {
                delta.densityDpi = i2;
            }
        }

        public static Context a(Context context, Configuration overrideConfiguration) {
            return context.createConfigurationContext(overrideConfiguration);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$k */
    /* loaded from: classes.dex */
    public static class k {
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$l */
    /* loaded from: classes.dex */
    public static class l {
        public static void a(Configuration base, Configuration change, Configuration delta) {
            LocaleList baseLocales = base.getLocales();
            LocaleList changeLocales = change.getLocales();
            if (!baseLocales.equals(changeLocales)) {
                delta.setLocales(changeLocales);
                delta.locale = change.locale;
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: b0$m */
    /* loaded from: classes.dex */
    public static class m {
        public static void a(Configuration base, Configuration change, Configuration delta) {
            int i = base.colorMode & 3;
            int i2 = change.colorMode;
            if (i != (i2 & 3)) {
                delta.colorMode |= i2 & 3;
            }
            int i3 = base.colorMode & 12;
            int i4 = change.colorMode;
            if (i3 != (i4 & 12)) {
                delta.colorMode |= i4 & 12;
            }
        }
    }
}
