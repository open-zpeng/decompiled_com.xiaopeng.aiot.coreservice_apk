package defpackage;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import defpackage.l9;
import defpackage.oa;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ViewCompat.java */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* renamed from: ga  reason: default package */
/* loaded from: classes.dex */
public class ga {
    public static Field b;
    public static boolean c;
    public static Field d;
    public static boolean e;
    public static WeakHashMap<View, String> f;
    public static Field h;
    public static ThreadLocal<Rect> j;
    public static final AtomicInteger a = new AtomicInteger(1);
    public static WeakHashMap<View, ka> g = null;
    public static boolean i = false;
    public static final int[] k = {x6.accessibility_custom_action_0, x6.accessibility_custom_action_1, x6.accessibility_custom_action_2, x6.accessibility_custom_action_3, x6.accessibility_custom_action_4, x6.accessibility_custom_action_5, x6.accessibility_custom_action_6, x6.accessibility_custom_action_7, x6.accessibility_custom_action_8, x6.accessibility_custom_action_9, x6.accessibility_custom_action_10, x6.accessibility_custom_action_11, x6.accessibility_custom_action_12, x6.accessibility_custom_action_13, x6.accessibility_custom_action_14, x6.accessibility_custom_action_15, x6.accessibility_custom_action_16, x6.accessibility_custom_action_17, x6.accessibility_custom_action_18, x6.accessibility_custom_action_19, x6.accessibility_custom_action_20, x6.accessibility_custom_action_21, x6.accessibility_custom_action_22, x6.accessibility_custom_action_23, x6.accessibility_custom_action_24, x6.accessibility_custom_action_25, x6.accessibility_custom_action_26, x6.accessibility_custom_action_27, x6.accessibility_custom_action_28, x6.accessibility_custom_action_29, x6.accessibility_custom_action_30, x6.accessibility_custom_action_31};
    public static final da l = new a();
    public static f m = new f();

    /* compiled from: ViewCompat.java */
    /* renamed from: ga$k */
    /* loaded from: classes.dex */
    public interface k {
        boolean a(View view, KeyEvent keyEvent);
    }

    public static Rect r() {
        if (j == null) {
            j = new ThreadLocal<>();
        }
        Rect rect = j.get();
        if (rect == null) {
            rect = new Rect();
            j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void X(View view, @SuppressLint({"ContextFirst"}) Context context, int[] styleable, AttributeSet attrs, TypedArray t, int defStyleAttr, int defStyleRes) {
        if (Build.VERSION.SDK_INT >= 29) {
            j.a(view, context, styleable, attrs, t, defStyleAttr, defStyleRes);
        }
    }

    public static void Z(View v, l9 delegate) {
        if (delegate == null && (j(v) instanceof l9.a)) {
            delegate = new l9();
        }
        v.setAccessibilityDelegate(delegate == null ? null : delegate.d());
    }

    public static l9 i(View view) {
        View.AccessibilityDelegate delegate = j(view);
        if (delegate == null) {
            return null;
        }
        if (delegate instanceof l9.a) {
            return ((l9.a) delegate).a;
        }
        return new l9(delegate);
    }

    public static l9 z(View v) {
        l9 delegateCompat = i(v);
        if (delegateCompat == null) {
            delegateCompat = new l9();
        }
        Z(v, delegateCompat);
        return delegateCompat;
    }

    public static View.AccessibilityDelegate j(View v) {
        if (Build.VERSION.SDK_INT >= 29) {
            return v.getAccessibilityDelegate();
        }
        return k(v);
    }

    public static View.AccessibilityDelegate k(View v) {
        if (i) {
            return null;
        }
        if (h == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable th) {
                i = true;
                return null;
            }
        }
        try {
            Object o = h.get(v);
            if (o instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) o;
            }
            return null;
        } catch (Throwable th2) {
            i = true;
            return null;
        }
    }

    public static boolean G(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void S(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void T(View view, int left, int top, int right, int bottom) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(left, top, right, bottom);
        } else {
            view.postInvalidate(left, top, right, bottom);
        }
    }

    public static void U(View view, Runnable action) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(action);
        } else {
            view.postDelayed(action, ValueAnimator.getFrameDelay());
        }
    }

    public static void V(View view, Runnable action, long delayMillis) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(action, delayMillis);
        } else {
            view.postDelayed(action, ValueAnimator.getFrameDelay() + delayMillis);
        }
    }

    public static int u(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void e0(View view, int mode) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            view.setImportantForAccessibility(mode);
        } else if (i2 >= 16) {
            if (mode == 4) {
                mode = 2;
            }
            view.setImportantForAccessibility(mode);
        }
    }

    public static void i0(View view, CharSequence stateDescription) {
        if (Build.VERSION.SDK_INT >= 19) {
            l0().g(view, stateDescription);
        }
    }

    public static final CharSequence B(View view) {
        return l0().f(view);
    }

    public static void f0(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
            return;
        }
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    public static int v(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int l(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static int x(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            c = true;
        }
        Field field = b;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception e3) {
                return 0;
            }
        }
        return 0;
    }

    public static int w(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            e = true;
        }
        Field field = d;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception e3) {
                return 0;
            }
        }
        return 0;
    }

    public static ka b(View view) {
        if (g == null) {
            g = new WeakHashMap<>();
        }
        ka vpa = g.get(view);
        if (vpa == null) {
            ka vpa2 = new ka(view);
            g.put(view, vpa2);
            return vpa2;
        }
        return vpa;
    }

    public static void d0(View view, float elevation) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(elevation);
        }
    }

    public static float q(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void j0(View view, String transitionName) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(transitionName);
            return;
        }
        if (f == null) {
            f = new WeakHashMap<>();
        }
        f.put(view, transitionName);
    }

    public static String C(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int D(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void W(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            view.requestApplyInsets();
        } else if (i2 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static boolean t(View v) {
        if (Build.VERSION.SDK_INT >= 16) {
            return v.getFitsSystemWindows();
        }
        return false;
    }

    public static void g0(View v, ba listener) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.d(v, listener);
        }
    }

    public static oa P(View view, oa insets) {
        WindowInsets unwrapped;
        if (Build.VERSION.SDK_INT >= 21 && (unwrapped = insets.q()) != null) {
            WindowInsets result = view.onApplyWindowInsets(unwrapped);
            if (!result.equals(unwrapped)) {
                return oa.s(result, view);
            }
        }
        return insets;
    }

    public static oa f(View view, oa insets) {
        WindowInsets unwrapped;
        if (Build.VERSION.SDK_INT >= 21 && (unwrapped = insets.q()) != null) {
            WindowInsets result = view.dispatchApplyWindowInsets(unwrapped);
            if (!result.equals(unwrapped)) {
                return oa.s(result, view);
            }
        }
        return insets;
    }

    public static oa A(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return i.a(view);
        }
        if (i2 >= 21) {
            return h.c(view);
        }
        return null;
    }

    public static oa e(View view, oa insets, Rect outLocalInsets) {
        if (Build.VERSION.SDK_INT >= 21) {
            return h.b(view, insets, outLocalInsets);
        }
        return insets;
    }

    public static String[] y(View view) {
        return (String[]) view.getTag(x6.tag_on_receive_content_mime_types);
    }

    public static n9 R(View view, n9 payload) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + payload + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        ca listener = (ca) view.getTag(x6.tag_on_receive_content_listener);
        if (listener != null) {
            n9 remaining = listener.a(view, payload);
            if (remaining == null) {
                return null;
            }
            return s(view).d(remaining);
        }
        return s(view).d(payload);
    }

    public static da s(View view) {
        if (view instanceof da) {
            return (da) view;
        }
        return l;
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: ga$a */
    /* loaded from: classes.dex */
    public class a implements da {
        @Override // defpackage.da
        public n9 d(n9 payload) {
            return payload;
        }
    }

    public static void a0(View view, Drawable background) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(background);
        } else {
            view.setBackgroundDrawable(background);
        }
    }

    public static ColorStateList n(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof fa) {
            return ((fa) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void b0(View view, ColorStateList tintList) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            view.setBackgroundTintList(tintList);
            if (i2 == 21) {
                Drawable background = view.getBackground();
                boolean hasTint = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && hasTint) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof fa) {
            ((fa) view).setSupportBackgroundTintList(tintList);
        }
    }

    public static PorterDuff.Mode o(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof fa) {
            return ((fa) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void c0(View view, PorterDuff.Mode mode) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            view.setBackgroundTintMode(mode);
            if (i2 == 21) {
                Drawable background = view.getBackground();
                boolean hasTint = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && hasTint) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof fa) {
            ((fa) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static boolean K(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof v9) {
            return ((v9) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static void m0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof v9) {
            ((v9) view).stopNestedScroll();
        }
    }

    public static boolean J(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float E(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static void O(View view, int offset) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetTopAndBottom(offset);
        } else if (i2 >= 21) {
            Rect parentRect = r();
            boolean needInvalidateWorkaround = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View p = (View) parent;
                parentRect.set(p.getLeft(), p.getTop(), p.getRight(), p.getBottom());
                needInvalidateWorkaround = !parentRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            d(view, offset);
            if (needInvalidateWorkaround && parentRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(parentRect);
            }
        } else {
            d(view, offset);
        }
    }

    public static void d(View view, int offset) {
        view.offsetTopAndBottom(offset);
        if (view.getVisibility() == 0) {
            n0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                n0((View) parent);
            }
        }
    }

    public static void N(View view, int offset) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetLeftAndRight(offset);
        } else if (i2 >= 21) {
            Rect parentRect = r();
            boolean needInvalidateWorkaround = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View p = (View) parent;
                parentRect.set(p.getLeft(), p.getTop(), p.getRight(), p.getBottom());
                needInvalidateWorkaround = !parentRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            c(view, offset);
            if (needInvalidateWorkaround && parentRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(parentRect);
            }
        } else {
            c(view, offset);
        }
    }

    public static void c(View view, int offset) {
        view.offsetLeftAndRight(offset);
        if (view.getVisibility() == 0) {
            n0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                n0((View) parent);
            }
        }
    }

    public static void n0(View view) {
        float y = view.getTranslationY();
        view.setTranslationY(1.0f + y);
        view.setTranslationY(y);
    }

    public static boolean I(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean F(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static void h0(View view, int indicators, int mask) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(indicators, mask);
        }
    }

    public static Display p(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (I(view)) {
            WindowManager wm = (WindowManager) view.getContext().getSystemService("window");
            return wm.getDefaultDisplay();
        }
        return null;
    }

    public static boolean h(View root, KeyEvent evt) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(root).f(evt);
    }

    public static boolean g(View root, KeyEvent evt) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return l.a(root).b(root, evt);
    }

    public static boolean L(View view) {
        Boolean result = Y().f(view);
        if (result == null) {
            return false;
        }
        return result.booleanValue();
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: ga$b */
    /* loaded from: classes.dex */
    public class b extends g<Boolean> {
        public b(int tagKey, Class cls, int frameworkMinimumSdk) {
            super(tagKey, cls, frameworkMinimumSdk);
        }

        @Override // defpackage.ga.g
        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }

        @Override // defpackage.ga.g
        /* renamed from: j */
        public void e(View view, Boolean value) {
            view.setScreenReaderFocusable(value.booleanValue());
        }

        @Override // defpackage.ga.g
        /* renamed from: k */
        public boolean h(Boolean oldValue, Boolean newValue) {
            return !a(oldValue, newValue);
        }
    }

    public static g<Boolean> Y() {
        return new b(x6.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static CharSequence m(View view) {
        return Q().f(view);
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: ga$c */
    /* loaded from: classes.dex */
    public class c extends g<CharSequence> {
        public c(int tagKey, Class cls, int contentChangeType, int frameworkMinimumSdk) {
            super(tagKey, cls, contentChangeType, frameworkMinimumSdk);
        }

        @Override // defpackage.ga.g
        /* renamed from: i */
        public CharSequence d(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @Override // defpackage.ga.g
        /* renamed from: j */
        public void e(View view, CharSequence value) {
            view.setAccessibilityPaneTitle(value);
        }

        @Override // defpackage.ga.g
        /* renamed from: k */
        public boolean h(CharSequence oldValue, CharSequence newValue) {
            return !TextUtils.equals(oldValue, newValue);
        }
    }

    public static g<CharSequence> Q() {
        return new c(x6.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: ga$d */
    /* loaded from: classes.dex */
    public class d extends g<CharSequence> {
        public d(int tagKey, Class cls, int contentChangeType, int frameworkMinimumSdk) {
            super(tagKey, cls, contentChangeType, frameworkMinimumSdk);
        }

        @Override // defpackage.ga.g
        /* renamed from: i */
        public CharSequence d(View view) {
            return view.getStateDescription();
        }

        @Override // defpackage.ga.g
        /* renamed from: j */
        public void e(View view, CharSequence value) {
            view.setStateDescription(value);
        }

        @Override // defpackage.ga.g
        /* renamed from: k */
        public boolean h(CharSequence oldValue, CharSequence newValue) {
            return !TextUtils.equals(oldValue, newValue);
        }
    }

    public static g<CharSequence> l0() {
        return new d(x6.tag_state_description, CharSequence.class, 64, 30);
    }

    public static boolean H(View view) {
        Boolean result = a().f(view);
        if (result == null) {
            return false;
        }
        return result.booleanValue();
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: ga$e */
    /* loaded from: classes.dex */
    public class e extends g<Boolean> {
        public e(int tagKey, Class cls, int frameworkMinimumSdk) {
            super(tagKey, cls, frameworkMinimumSdk);
        }

        @Override // defpackage.ga.g
        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }

        @Override // defpackage.ga.g
        /* renamed from: j */
        public void e(View view, Boolean value) {
            view.setAccessibilityHeading(value.booleanValue());
        }

        @Override // defpackage.ga.g
        /* renamed from: k */
        public boolean h(Boolean oldValue, Boolean newValue) {
            return !a(oldValue, newValue);
        }
    }

    public static g<Boolean> a() {
        return new e(x6.tag_accessibility_heading, Boolean.class, 28);
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: ga$g */
    /* loaded from: classes.dex */
    public static abstract class g<T> {
        public final int a;
        public final Class<T> b;
        public final int c;
        public final int d;

        public abstract T d(View view);

        public abstract void e(View view, T t);

        public abstract boolean h(T t, T t2);

        /* JADX WARN: Generic types in debug info not equals: ga$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public g(int tagKey, Class<T> type, int frameworkMinimumSdk) {
            this(tagKey, type, 0, frameworkMinimumSdk);
        }

        /* JADX WARN: Generic types in debug info not equals: ga$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public g(int tagKey, Class<T> type, int contentChangeType, int frameworkMinimumSdk) {
            this.a = tagKey;
            this.b = type;
            this.d = contentChangeType;
            this.c = frameworkMinimumSdk;
        }

        /* JADX WARN: Generic types in debug info not equals: ga$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public void g(View view, T value) {
            if (c()) {
                e(view, value);
            } else if (b() && h(f(view), value)) {
                ga.z(view);
                view.setTag(this.a, value);
                ga.M(view, this.d);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: ga$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public T f(View view) {
            if (c()) {
                return d(view);
            }
            if (b()) {
                T t = (T) view.getTag(this.a);
                if (this.b.isInstance(t)) {
                    return t;
                }
                return null;
            }
            return null;
        }

        /* JADX WARN: Generic types in debug info not equals: ga$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public final boolean c() {
            return Build.VERSION.SDK_INT >= this.c;
        }

        /* JADX WARN: Generic types in debug info not equals: ga$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public final boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        /* JADX WARN: Generic types in debug info not equals: ga$g != androidx.core.view.ViewCompat$AccessibilityViewProperty<T> */
        public boolean a(Boolean a, Boolean b) {
            boolean aBool = a == null ? false : a.booleanValue();
            boolean bBool = b == null ? false : b.booleanValue();
            return aBool == bBool;
        }
    }

    public static void M(View view, int changeType) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        boolean isVisibleAccessibilityPane = m(view) != null && view.getVisibility() == 0;
        if (l(view) != 0 || isVisibleAccessibilityPane) {
            AccessibilityEvent event = AccessibilityEvent.obtain();
            event.setEventType(isVisibleAccessibilityPane ? 32 : 2048);
            event.setContentChangeTypes(changeType);
            if (isVisibleAccessibilityPane) {
                event.getText().add(m(view));
                k0(view);
            }
            view.sendAccessibilityEventUnchecked(event);
        } else if (changeType == 32) {
            AccessibilityEvent event2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(event2);
            event2.setEventType(32);
            event2.setContentChangeTypes(changeType);
            event2.setSource(view);
            view.onPopulateAccessibilityEvent(event2);
            event2.getText().add(m(view));
            accessibilityManager.sendAccessibilityEvent(event2);
        } else if (view.getParent() != null) {
            try {
                view.getParent().notifySubtreeAccessibilityStateChanged(view, view, changeType);
            } catch (AbstractMethodError e2) {
                Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
            }
        }
    }

    public static void k0(View view) {
        if (u(view) == 0) {
            e0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (u((View) parent) == 4) {
                e0(view, 2);
                return;
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: ga$f */
    /* loaded from: classes.dex */
    public static class f implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        public WeakHashMap<View, Boolean> a = new WeakHashMap<>();

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.a.entrySet()) {
                    a(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        public final void a(View pane, boolean oldVisibility) {
            int contentChangeType;
            boolean newVisibility = pane.getVisibility() == 0;
            if (oldVisibility != newVisibility) {
                if (newVisibility) {
                    contentChangeType = 16;
                } else {
                    contentChangeType = 32;
                }
                ga.M(pane, contentChangeType);
                this.a.put(pane, Boolean.valueOf(newVisibility));
            }
        }

        public final void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: ga$l */
    /* loaded from: classes.dex */
    public static class l {
        public static final ArrayList<WeakReference<View>> a = new ArrayList<>();
        public WeakHashMap<View, Boolean> b = null;
        public SparseArray<WeakReference<View>> c = null;
        public WeakReference<KeyEvent> d = null;

        public final SparseArray<WeakReference<View>> d() {
            if (this.c == null) {
                this.c = new SparseArray<>();
            }
            return this.c;
        }

        public static l a(View root) {
            int i = x6.R;
            l manager = (l) root.getTag(i);
            if (manager == null) {
                l manager2 = new l();
                root.setTag(i, manager2);
                return manager2;
            }
            return manager;
        }

        public boolean b(View root, KeyEvent event) {
            if (event.getAction() == 0) {
                g();
            }
            View consumer = c(root, event);
            if (event.getAction() == 0) {
                int keycode = event.getKeyCode();
                if (consumer != null && !KeyEvent.isModifierKey(keycode)) {
                    d().put(keycode, new WeakReference<>(consumer));
                }
            }
            return consumer != null;
        }

        public final View c(View view, KeyEvent event) {
            WeakHashMap<View, Boolean> weakHashMap = this.b;
            if (weakHashMap == null || !weakHashMap.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) view;
                for (int i = vg.getChildCount() - 1; i >= 0; i--) {
                    View v = vg.getChildAt(i);
                    View consumer = c(v, event);
                    if (consumer != null) {
                        return consumer;
                    }
                }
            }
            if (e(view, event)) {
                return view;
            }
            return null;
        }

        public boolean f(KeyEvent event) {
            int idx;
            WeakReference<KeyEvent> weakReference = this.d;
            if (weakReference == null || weakReference.get() != event) {
                this.d = new WeakReference<>(event);
                WeakReference<View> currentReceiver = null;
                SparseArray<WeakReference<View>> capturedKeys = d();
                if (event.getAction() == 1 && (idx = capturedKeys.indexOfKey(event.getKeyCode())) >= 0) {
                    currentReceiver = capturedKeys.valueAt(idx);
                    capturedKeys.removeAt(idx);
                }
                if (currentReceiver == null) {
                    currentReceiver = capturedKeys.get(event.getKeyCode());
                }
                if (currentReceiver != null) {
                    View target = currentReceiver.get();
                    if (target != null && ga.I(target)) {
                        e(target, event);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        public final boolean e(View v, KeyEvent event) {
            ArrayList<ViewCompat.OnUnhandledKeyEventListenerCompat> viewListeners = (ArrayList) v.getTag(x6.S);
            if (viewListeners != null) {
                for (int i = viewListeners.size() - 1; i >= 0; i--) {
                    if (((k) viewListeners.get(i)).a(v, event)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        public final void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = a;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.b == null) {
                    this.b = new WeakHashMap<>();
                }
                for (int i = arrayList.size() - 1; i >= 0; i--) {
                    ArrayList<WeakReference<View>> arrayList2 = a;
                    WeakReference<View> vw = arrayList2.get(i);
                    View v = vw.get();
                    if (v == null) {
                        arrayList2.remove(i);
                    } else {
                        this.b.put(v, Boolean.TRUE);
                        for (ViewParent nxt = v.getParent(); nxt instanceof View; nxt = nxt.getParent()) {
                            this.b.put((View) nxt, Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: ga$h */
    /* loaded from: classes.dex */
    public static class h {
        public static oa c(View v) {
            return oa.a.a(v);
        }

        public static oa b(View v, oa insets, Rect outLocalInsets) {
            WindowInsets platformInsets = insets.q();
            if (platformInsets != null) {
                return oa.s(v.computeSystemWindowInsets(platformInsets, outLocalInsets), v);
            }
            outLocalInsets.setEmpty();
            return insets;
        }

        public static void d(View v, ba listener) {
            if (Build.VERSION.SDK_INT < 30) {
                v.setTag(x6.tag_on_apply_window_listener, listener);
            }
            if (listener == null) {
                View.OnApplyWindowInsetsListener compatInsetsAnimationCallback = (View.OnApplyWindowInsetsListener) v.getTag(x6.tag_window_insets_animation_callback);
                v.setOnApplyWindowInsetsListener(compatInsetsAnimationCallback);
                return;
            }
            v.setOnApplyWindowInsetsListener(new a(v, listener));
        }

        /* compiled from: ViewCompat.java */
        /* renamed from: ga$h$a */
        /* loaded from: classes.dex */
        public class a implements View.OnApplyWindowInsetsListener {
            public oa a = null;
            public final /* synthetic */ View b;
            public final /* synthetic */ ba c;

            public a(View view, ba baVar) {
                this.b = view;
                this.c = baVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
                oa compatInsets = oa.s(insets, view);
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    h.a(insets, this.b);
                    if (compatInsets.equals(this.a)) {
                        return this.c.a(view, compatInsets).q();
                    }
                }
                this.a = compatInsets;
                oa compatInsets2 = this.c.a(view, compatInsets);
                if (i >= 30) {
                    return compatInsets2.q();
                }
                ga.W(view);
                return compatInsets2.q();
            }
        }

        public static void a(WindowInsets insets, View v) {
            View.OnApplyWindowInsetsListener insetsAnimationCallback = (View.OnApplyWindowInsetsListener) v.getTag(x6.tag_window_insets_animation_callback);
            if (insetsAnimationCallback != null) {
                insetsAnimationCallback.onApplyWindowInsets(v, insets);
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: ga$i */
    /* loaded from: classes.dex */
    public static class i {
        public static oa a(View v) {
            WindowInsets wi = v.getRootWindowInsets();
            if (wi == null) {
                return null;
            }
            oa insets = oa.r(wi);
            insets.o(insets);
            insets.d(v.getRootView());
            return insets;
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: ga$j */
    /* loaded from: classes.dex */
    public static class j {
        public static void a(View view, Context context, int[] styleable, AttributeSet attrs, TypedArray t, int defStyleAttr, int defStyleRes) {
            view.saveAttributeDataForStyleable(context, styleable, attrs, t, defStyleAttr, defStyleRes);
        }
    }
}
