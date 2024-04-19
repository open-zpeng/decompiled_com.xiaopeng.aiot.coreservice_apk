package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ResourceManagerInternal.java */
/* renamed from: q2  reason: default package */
/* loaded from: classes.dex */
public final class q2 {
    public static q2 b;
    public WeakHashMap<Context, a4<ColorStateList>> d;
    public z3<String, e> e;
    public a4<String> f;
    public final WeakHashMap<Context, w3<WeakReference<Drawable.ConstantState>>> g = new WeakHashMap<>(0);
    public TypedValue h;
    public boolean i;
    public f j;
    public static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    public static final c c = new c(6);

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: q2$e */
    /* loaded from: classes.dex */
    public interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: q2$f */
    /* loaded from: classes.dex */
    public interface f {
        boolean a(Context context, int i, Drawable drawable);

        PorterDuff.Mode b(int i);

        Drawable c(q2 q2Var, Context context, int i);

        ColorStateList d(Context context, int i);

        boolean e(Context context, int i, Drawable drawable);
    }

    public static synchronized q2 h() {
        q2 q2Var;
        synchronized (q2.class) {
            if (b == null) {
                q2 q2Var2 = new q2();
                b = q2Var2;
                p(q2Var2);
            }
            q2Var = b;
        }
        return q2Var;
    }

    public static void p(q2 manager) {
        if (Build.VERSION.SDK_INT < 24) {
            manager.a("vector", new g());
            manager.a("animated-vector", new b());
            manager.a("animated-selector", new a());
            manager.a("drawable", new d());
        }
    }

    public synchronized void u(f hooks) {
        this.j = hooks;
    }

    public synchronized Drawable j(Context context, int resId) {
        return k(context, resId, false);
    }

    public synchronized Drawable k(Context context, int resId, boolean failIfNotKnown) {
        Drawable drawable;
        d(context);
        drawable = r(context, resId);
        if (drawable == null) {
            drawable = f(context, resId);
        }
        if (drawable == null) {
            drawable = m7.d(context, resId);
        }
        if (drawable != null) {
            drawable = v(context, resId, failIfNotKnown, drawable);
        }
        if (drawable != null) {
            k2.b(drawable);
        }
        return drawable;
    }

    /* JADX WARN: Generic types in debug info not equals: w3 != androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>> */
    public synchronized void s(Context context) {
        w3<WeakReference<Drawable.ConstantState>> w3Var = this.g.get(context);
        if (w3Var != null) {
            w3Var.b();
        }
    }

    public static long e(TypedValue tv) {
        return (tv.assetCookie << 32) | tv.data;
    }

    public final Drawable f(Context context, int resId) {
        if (this.h == null) {
            this.h = new TypedValue();
        }
        TypedValue tv = this.h;
        context.getResources().getValue(resId, tv, true);
        long key = e(tv);
        Drawable dr = i(context, key);
        if (dr != null) {
            return dr;
        }
        f fVar = this.j;
        Drawable dr2 = fVar == null ? null : fVar.c(this, context, resId);
        if (dr2 != null) {
            dr2.setChangingConfigurations(tv.changingConfigurations);
            b(context, key, dr2);
        }
        return dr2;
    }

    public final Drawable v(Context context, int resId, boolean failIfNotKnown, Drawable drawable) {
        ColorStateList tintList = m(context, resId);
        if (tintList != null) {
            if (k2.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawable2 = i8.q(drawable);
            i8.n(drawable2, tintList);
            PorterDuff.Mode tintMode = o(resId);
            if (tintMode != null) {
                i8.o(drawable2, tintMode);
                return drawable2;
            }
            return drawable2;
        }
        f fVar = this.j;
        if (fVar == null || !fVar.e(context, resId, drawable)) {
            boolean tinted = x(context, resId, drawable);
            if (!tinted && failIfNotKnown) {
                return null;
            }
            return drawable;
        }
        return drawable;
    }

    public final Drawable r(Context context, int resId) {
        int type;
        z3<String, e> z3Var = this.e;
        if (z3Var == null || z3Var.isEmpty()) {
            return null;
        }
        a4<String> a4Var = this.f;
        if (a4Var != null) {
            String cachedTagName = a4Var.e(resId);
            if ("appcompat_skip_skip".equals(cachedTagName) || (cachedTagName != null && this.e.get(cachedTagName) == null)) {
                return null;
            }
        } else {
            this.f = new a4<>();
        }
        if (this.h == null) {
            this.h = new TypedValue();
        }
        TypedValue tv = this.h;
        Resources res = context.getResources();
        res.getValue(resId, tv, true);
        long key = e(tv);
        Drawable dr = i(context, key);
        if (dr != null) {
            return dr;
        }
        CharSequence charSequence = tv.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlPullParser parser = res.getXml(resId);
                AttributeSet attrs = Xml.asAttributeSet(parser);
                while (true) {
                    type = parser.next();
                    if (type == 2 || type == 1) {
                        break;
                    }
                }
                if (type != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String tagName = parser.getName();
                this.f.a(resId, tagName);
                e delegate = this.e.get(tagName);
                if (delegate != null) {
                    dr = delegate.a(context, parser, attrs, context.getTheme());
                }
                if (dr != null) {
                    dr.setChangingConfigurations(tv.changingConfigurations);
                    b(context, key, dr);
                }
            } catch (Exception e2) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
        }
        if (dr == null) {
            this.f.a(resId, "appcompat_skip_skip");
        }
        return dr;
    }

    /* JADX WARN: Generic types in debug info not equals: w3 != androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>> */
    public final synchronized Drawable i(Context context, long key) {
        w3<WeakReference<Drawable.ConstantState>> w3Var = this.g.get(context);
        if (w3Var == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> wr = w3Var.e(key);
        if (wr != null) {
            Drawable.ConstantState entry = wr.get();
            if (entry != null) {
                return entry.newDrawable(context.getResources());
            }
            w3Var.i(key);
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: w3 != androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>> */
    public final synchronized boolean b(Context context, long key, Drawable drawable) {
        Drawable.ConstantState cs = drawable.getConstantState();
        if (cs != null) {
            w3<WeakReference<Drawable.ConstantState>> w3Var = this.g.get(context);
            if (w3Var == null) {
                w3Var = new w3<>();
                this.g.put(context, w3Var);
            }
            w3Var.h(key, new WeakReference<>(cs));
            return true;
        }
        return false;
    }

    public synchronized Drawable t(Context context, e3 resources, int resId) {
        Drawable drawable = r(context, resId);
        if (drawable == null) {
            drawable = resources.c(resId);
        }
        if (drawable != null) {
            return v(context, resId, false, drawable);
        }
        return null;
    }

    public boolean x(Context context, int resId, Drawable drawable) {
        f fVar = this.j;
        return fVar != null && fVar.a(context, resId, drawable);
    }

    public final void a(String tagName, e delegate) {
        if (this.e == null) {
            this.e = new z3<>();
        }
        this.e.put(tagName, delegate);
    }

    public PorterDuff.Mode o(int resId) {
        f fVar = this.j;
        if (fVar == null) {
            return null;
        }
        return fVar.b(resId);
    }

    public synchronized ColorStateList m(Context context, int resId) {
        ColorStateList tint;
        tint = n(context, resId);
        if (tint == null) {
            f fVar = this.j;
            tint = fVar == null ? null : fVar.d(context, resId);
            if (tint != null) {
                c(context, resId, tint);
            }
        }
        return tint;
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<android.content.res.ColorStateList> */
    public final ColorStateList n(Context context, int resId) {
        a4<ColorStateList> a4Var;
        WeakHashMap<Context, a4<ColorStateList>> weakHashMap = this.d;
        if (weakHashMap == null || (a4Var = weakHashMap.get(context)) == null) {
            return null;
        }
        return a4Var.e(resId);
    }

    /* JADX WARN: Generic types in debug info not equals: a4 != androidx.collection.SparseArrayCompat<android.content.res.ColorStateList> */
    public final void c(Context context, int resId, ColorStateList tintList) {
        if (this.d == null) {
            this.d = new WeakHashMap<>();
        }
        a4<ColorStateList> a4Var = this.d.get(context);
        if (a4Var == null) {
            a4Var = new a4<>();
            this.d.put(context, a4Var);
        }
        a4Var.a(resId, tintList);
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: q2$c */
    /* loaded from: classes.dex */
    public static class c extends x3<Integer, PorterDuffColorFilter> {
        public c(int maxSize) {
            super(maxSize);
        }

        public PorterDuffColorFilter i(int color, PorterDuff.Mode mode) {
            return c(Integer.valueOf(h(color, mode)));
        }

        public PorterDuffColorFilter j(int color, PorterDuff.Mode mode, PorterDuffColorFilter filter) {
            return d(Integer.valueOf(h(color, mode)), filter);
        }

        public static int h(int color, PorterDuff.Mode mode) {
            int hashCode = (1 * 31) + color;
            return (hashCode * 31) + mode.hashCode();
        }
    }

    public static void w(Drawable drawable, x2 tint, int[] state) {
        if (k2.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z = tint.d;
        if (z || tint.c) {
            drawable.setColorFilter(g(z ? tint.a : null, tint.c ? tint.b : a, state));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public static PorterDuffColorFilter g(ColorStateList tint, PorterDuff.Mode tintMode, int[] state) {
        if (tint == null || tintMode == null) {
            return null;
        }
        int color = tint.getColorForState(state, 0);
        return l(color, tintMode);
    }

    public static synchronized PorterDuffColorFilter l(int color, PorterDuff.Mode mode) {
        PorterDuffColorFilter filter;
        synchronized (q2.class) {
            c cVar = c;
            filter = cVar.i(color, mode);
            if (filter == null) {
                filter = new PorterDuffColorFilter(color, mode);
                cVar.j(color, mode, filter);
            }
        }
        return filter;
    }

    public final void d(Context context) {
        if (this.i) {
            return;
        }
        this.i = true;
        Drawable d2 = j(context, o0.abc_vector_test);
        if (d2 == null || !q(d2)) {
            this.i = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public static boolean q(Drawable d2) {
        return (d2 instanceof Cif) || "android.graphics.drawable.VectorDrawable".equals(d2.getClass().getName());
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: q2$g */
    /* loaded from: classes.dex */
    public static class g implements e {
        @Override // defpackage.q2.e
        public Drawable a(Context context, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
            try {
                return Cif.c(context.getResources(), parser, attrs, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: q2$b */
    /* loaded from: classes.dex */
    public static class b implements e {
        @Override // defpackage.q2.e
        public Drawable a(Context context, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
            try {
                return cf.a(context, context.getResources(), parser, attrs, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: q2$a */
    /* loaded from: classes.dex */
    public static class a implements e {
        @Override // defpackage.q2.e
        public Drawable a(Context context, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
            try {
                return k0.l(context, context.getResources(), parser, attrs, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: q2$d */
    /* loaded from: classes.dex */
    public static class d implements e {
        @Override // defpackage.q2.e
        public Drawable a(Context context, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) {
            String className = attrs.getClassAttribute();
            if (className == null) {
                return null;
            }
            try {
                Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(className).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable.inflate(context.getResources(), parser, attrs, theme);
                } else {
                    drawable.inflate(context.getResources(), parser, attrs);
                }
                return drawable;
            } catch (Exception e) {
                Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
                return null;
            }
        }
    }
}
