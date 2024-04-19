package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: AppCompatResources.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: j0  reason: default package */
/* loaded from: classes.dex */
public final class j0 {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    public static final WeakHashMap<Context, SparseArray<a>> b = new WeakHashMap<>(0);
    public static final Object c = new Object();

    public static ColorStateList c(Context context, int resId) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(resId);
        }
        ColorStateList csl = b(context, resId);
        if (csl != null) {
            return csl;
        }
        ColorStateList csl2 = f(context, resId);
        if (csl2 != null) {
            a(context, resId, csl2);
            return csl2;
        }
        return m7.c(context, resId);
    }

    public static Drawable d(Context context, int resId) {
        return q2.h().j(context, resId);
    }

    public static ColorStateList f(Context context, int resId) {
        if (g(context, resId)) {
            return null;
        }
        Resources r = context.getResources();
        XmlPullParser xml = r.getXml(resId);
        try {
            return q7.a(r, xml, context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    public static ColorStateList b(Context context, int resId) {
        a entry;
        synchronized (c) {
            SparseArray<a> sparseArray = b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (entry = sparseArray.get(resId)) != null) {
                if (entry.b.equals(context.getResources().getConfiguration())) {
                    return entry.a;
                }
                sparseArray.remove(resId);
            }
            return null;
        }
    }

    public static void a(Context context, int resId, ColorStateList value) {
        synchronized (c) {
            WeakHashMap<Context, SparseArray<a>> weakHashMap = b;
            SparseArray<a> sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(resId, new a(value, context.getResources().getConfiguration()));
        }
    }

    public static boolean g(Context context, int resId) {
        Resources r = context.getResources();
        TypedValue value = e();
        r.getValue(resId, value, true);
        int i = value.type;
        return i >= 28 && i <= 31;
    }

    public static TypedValue e() {
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue tv = threadLocal.get();
        if (tv == null) {
            TypedValue tv2 = new TypedValue();
            threadLocal.set(tv2);
            return tv2;
        }
        return tv;
    }

    /* compiled from: AppCompatResources.java */
    /* renamed from: j0$a */
    /* loaded from: classes.dex */
    public static class a {
        public final ColorStateList a;
        public final Configuration b;

        public a(ColorStateList value, Configuration configuration) {
            this.a = value;
            this.b = configuration;
        }
    }
}
