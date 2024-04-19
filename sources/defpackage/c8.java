package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import defpackage.a9;
import defpackage.s7;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
/* compiled from: TypefaceCompatApi24Impl.java */
/* renamed from: c8  reason: default package */
/* loaded from: classes.dex */
public class c8 extends g8 {
    public static final Class<?> b;
    public static final Constructor<?> c;
    public static final Method d;
    public static final Method e;

    static {
        Constructor<?> fontFamilyCtor;
        Method addFontMethod;
        Class<?> fontFamilyClass;
        Method createFromFamiliesWithDefaultMethod;
        try {
            fontFamilyClass = Class.forName("android.graphics.FontFamily");
            fontFamilyCtor = fontFamilyClass.getConstructor(new Class[0]);
            Class<?> cls = Integer.TYPE;
            addFontMethod = fontFamilyClass.getMethod("addFontWeightStyle", ByteBuffer.class, cls, List.class, cls, Boolean.TYPE);
            Object familyArray = Array.newInstance(fontFamilyClass, 1);
            createFromFamiliesWithDefaultMethod = Typeface.class.getMethod("createFromFamiliesWithDefault", familyArray.getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            fontFamilyCtor = null;
            addFontMethod = null;
            fontFamilyClass = null;
            createFromFamiliesWithDefaultMethod = null;
        }
        c = fontFamilyCtor;
        b = fontFamilyClass;
        d = addFontMethod;
        e = createFromFamiliesWithDefaultMethod;
    }

    public static boolean m() {
        Method method = d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    public static Object n() {
        try {
            return c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            return null;
        }
    }

    public static boolean k(Object family, ByteBuffer buffer, int ttcIndex, int weight, boolean style) {
        try {
            Boolean result = (Boolean) d.invoke(family, buffer, Integer.valueOf(ttcIndex), null, Integer.valueOf(weight), Boolean.valueOf(style));
            return result.booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            return false;
        }
    }

    public static Typeface l(Object family) {
        try {
            Object familyArray = Array.newInstance(b, 1);
            Array.set(familyArray, 0, family);
            return (Typeface) e.invoke(null, familyArray);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            return null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<android.net.Uri, java.nio.ByteBuffer> */
    @Override // defpackage.g8
    public Typeface c(Context context, CancellationSignal cancellationSignal, a9.b[] fonts, int style) {
        Object family = n();
        if (family == null) {
            return null;
        }
        z3 z3Var = new z3();
        for (a9.b font : fonts) {
            Uri uri = font.d();
            ByteBuffer buffer = (ByteBuffer) z3Var.get(uri);
            if (buffer == null) {
                buffer = h8.f(context, cancellationSignal, uri);
                z3Var.put(uri, buffer);
            }
            if (buffer == null || !k(family, buffer, font.c(), font.e(), font.f())) {
                return null;
            }
        }
        Typeface typeface = l(family);
        if (typeface == null) {
            return null;
        }
        return Typeface.create(typeface, style);
    }

    @Override // defpackage.g8
    public Typeface b(Context context, s7.b entry, Resources resources, int style) {
        s7.c[] a;
        Object family = n();
        if (family == null) {
            return null;
        }
        for (s7.c e2 : entry.a()) {
            ByteBuffer buffer = h8.b(context, resources, e2.b());
            if (buffer == null || !k(family, buffer, e2.c(), e2.e(), e2.f())) {
                return null;
            }
        }
        return l(family);
    }
}
