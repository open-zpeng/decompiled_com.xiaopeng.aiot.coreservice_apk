package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import defpackage.a9;
import defpackage.s7;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
/* compiled from: TypefaceCompatApi26Impl.java */
/* renamed from: d8  reason: default package */
/* loaded from: classes.dex */
public class d8 extends b8 {
    public final Class<?> g;
    public final Constructor<?> h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;
    public final Method m;

    public d8() {
        Class<?> fontFamily;
        Constructor<?> fontFamilyCtor;
        Method addFontFromAssetManager;
        Method addFontFromAssetManager2;
        Method addFontFromBuffer;
        Method freeze;
        Method abortCreation;
        try {
            fontFamily = y();
            fontFamilyCtor = z(fontFamily);
            addFontFromAssetManager = v(fontFamily);
            addFontFromAssetManager2 = w(fontFamily);
            addFontFromBuffer = A(fontFamily);
            freeze = u(fontFamily);
            abortCreation = x(fontFamily);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            fontFamily = null;
            fontFamilyCtor = null;
            addFontFromAssetManager = null;
            addFontFromAssetManager2 = null;
            addFontFromBuffer = null;
            freeze = null;
            abortCreation = null;
        }
        this.g = fontFamily;
        this.h = fontFamilyCtor;
        this.i = addFontFromAssetManager;
        this.j = addFontFromAssetManager2;
        this.k = addFontFromBuffer;
        this.l = freeze;
        this.m = abortCreation;
    }

    public final boolean t() {
        if (this.i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }

    private Object o() {
        try {
            return this.h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            return null;
        }
    }

    public final boolean q(Context context, Object family, String fileName, int ttcIndex, int weight, int style, FontVariationAxis[] axes) {
        try {
            return ((Boolean) this.i.invoke(family, context.getAssets(), fileName, 0, false, Integer.valueOf(ttcIndex), Integer.valueOf(weight), Integer.valueOf(style), axes)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }

    public final boolean r(Object family, ByteBuffer buffer, int ttcIndex, int weight, int style) {
        try {
            return ((Boolean) this.j.invoke(family, buffer, Integer.valueOf(ttcIndex), null, Integer.valueOf(weight), Integer.valueOf(style))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }

    public Typeface l(Object family) {
        try {
            Object familyArray = Array.newInstance(this.g, 1);
            Array.set(familyArray, 0, family);
            return (Typeface) this.m.invoke(null, familyArray, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    public final boolean s(Object family) {
        try {
            return ((Boolean) this.k.invoke(family, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }

    public final void p(Object family) {
        try {
            this.l.invoke(family, new Object[0]);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
    }

    @Override // defpackage.b8, defpackage.g8
    public Typeface b(Context context, s7.b entry, Resources resources, int style) {
        s7.c[] a;
        if (!t()) {
            return super.b(context, entry, resources, style);
        }
        Object fontFamily = o();
        if (fontFamily == null) {
            return null;
        }
        for (s7.c fontFile : entry.a()) {
            if (!q(context, fontFamily, fontFile.a(), fontFile.c(), fontFile.e(), fontFile.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFile.d()))) {
                p(fontFamily);
                return null;
            }
        }
        if (!s(fontFamily)) {
            return null;
        }
        return l(fontFamily);
    }

    @Override // defpackage.b8, defpackage.g8
    public Typeface c(Context context, CancellationSignal cancellationSignal, a9.b[] fonts, int style) {
        Typeface typeface;
        int i;
        if (fonts.length < 1) {
            return null;
        }
        if (!t()) {
            a9.b bestFont = h(fonts, style);
            ContentResolver resolver = context.getContentResolver();
            try {
                ParcelFileDescriptor pfd = resolver.openFileDescriptor(bestFont.d(), "r", cancellationSignal);
                if (pfd != null) {
                    Typeface build = new Typeface.Builder(pfd.getFileDescriptor()).setWeight(bestFont.e()).setItalic(bestFont.f()).build();
                    pfd.close();
                    return build;
                }
                if (pfd != null) {
                    pfd.close();
                }
                return null;
            } catch (IOException e) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> uriBuffer = h8.h(context, fonts, cancellationSignal);
        Object fontFamily = o();
        if (fontFamily == null) {
            return null;
        }
        int length = fonts.length;
        boolean atLeastOneFont = false;
        int i2 = 0;
        while (i2 < length) {
            a9.b font = fonts[i2];
            ByteBuffer fontBuffer = uriBuffer.get(font.d());
            if (fontBuffer == null) {
                i = i2;
            } else {
                i = i2;
                boolean success = r(fontFamily, fontBuffer, font.c(), font.e(), font.f() ? 1 : 0);
                if (!success) {
                    p(fontFamily);
                    return null;
                }
                atLeastOneFont = true;
            }
            i2 = i + 1;
            atLeastOneFont = atLeastOneFont;
        }
        if (!atLeastOneFont) {
            p(fontFamily);
            return null;
        } else if (s(fontFamily) && (typeface = l(fontFamily)) != null) {
            return Typeface.create(typeface, style);
        } else {
            return null;
        }
    }

    @Override // defpackage.g8
    public Typeface e(Context context, Resources resources, int id, String path, int style) {
        if (!t()) {
            return super.e(context, resources, id, path, style);
        }
        Object fontFamily = o();
        if (fontFamily == null) {
            return null;
        }
        if (!q(context, fontFamily, path, 0, -1, -1, null)) {
            p(fontFamily);
            return null;
        } else if (!s(fontFamily)) {
            return null;
        } else {
            return l(fontFamily);
        }
    }

    public Class<?> y() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor<?> z(Class<?> fontFamily) throws NoSuchMethodException {
        return fontFamily.getConstructor(new Class[0]);
    }

    public Method v(Class<?> fontFamily) throws NoSuchMethodException {
        Class<?> cls = Integer.TYPE;
        return fontFamily.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls, Boolean.TYPE, cls, cls, cls, FontVariationAxis[].class);
    }

    public Method w(Class<?> fontFamily) throws NoSuchMethodException {
        Class<?> cls = Integer.TYPE;
        return fontFamily.getMethod("addFontFromBuffer", ByteBuffer.class, cls, FontVariationAxis[].class, cls, cls);
    }

    public Method A(Class<?> fontFamily) throws NoSuchMethodException {
        return fontFamily.getMethod("freeze", new Class[0]);
    }

    public Method u(Class<?> fontFamily) throws NoSuchMethodException {
        return fontFamily.getMethod("abortCreation", new Class[0]);
    }

    public Method x(Class<?> fontFamily) throws NoSuchMethodException {
        Object familyArray = Array.newInstance(fontFamily, 1);
        Class cls = Integer.TYPE;
        Method m = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", familyArray.getClass(), cls, cls);
        m.setAccessible(true);
        return m;
    }
}
