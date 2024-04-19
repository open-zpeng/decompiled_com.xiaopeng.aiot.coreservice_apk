package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import defpackage.a9;
import defpackage.s7;
import defpackage.v7;
/* compiled from: TypefaceCompat.java */
@SuppressLint({"NewApi"})
/* renamed from: a8  reason: default package */
/* loaded from: classes.dex */
public class a8 {
    public static final g8 a;
    public static final x3<String, Typeface> b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            a = new f8();
        } else if (i >= 28) {
            a = new e8();
        } else if (i >= 26) {
            a = new d8();
        } else if (i >= 24 && c8.m()) {
            a = new c8();
        } else if (i >= 21) {
            a = new b8();
        } else {
            a = new g8();
        }
        b = new x3<>(16);
    }

    public static Typeface f(Resources resources, int id, int style) {
        return b.c(e(resources, id, style));
    }

    public static String e(Resources resources, int id, int style) {
        return resources.getResourcePackageName(id) + "-" + id + "-" + style;
    }

    public static Typeface h(String familyName) {
        if (familyName == null || familyName.isEmpty()) {
            return null;
        }
        Typeface typeface = Typeface.create(familyName, 0);
        Typeface defaultTypeface = Typeface.create(Typeface.DEFAULT, 0);
        if (typeface == null || typeface.equals(defaultTypeface)) {
            return null;
        }
        return typeface;
    }

    public static Typeface c(Context context, s7.a entry, Resources resources, int id, int style, v7.a fontCallback, Handler handler, boolean isRequestFromLayoutInflator) {
        Typeface typeface;
        boolean isBlocking;
        if (!(entry instanceof s7.d)) {
            typeface = a.b(context, (s7.b) entry, resources, style);
            if (fontCallback != null) {
                if (typeface != null) {
                    fontCallback.b(typeface, handler);
                } else {
                    fontCallback.a(-3, handler);
                }
            }
        } else {
            s7.d providerEntry = (s7.d) entry;
            Typeface fontFamilyTypeface = h(providerEntry.c());
            if (fontFamilyTypeface != null) {
                if (fontCallback != null) {
                    fontCallback.b(fontFamilyTypeface, handler);
                }
                return fontFamilyTypeface;
            }
            if (isRequestFromLayoutInflator) {
                isBlocking = providerEntry.a() == 0;
            } else {
                isBlocking = fontCallback == null;
            }
            int timeout = isRequestFromLayoutInflator ? providerEntry.d() : -1;
            Handler newHandler = v7.a.c(handler);
            a newCallback = new a(fontCallback);
            typeface = a9.a(context, providerEntry.b(), style, isBlocking, timeout, newHandler, newCallback);
        }
        if (typeface != null) {
            b.d(e(resources, id, style), typeface);
        }
        return typeface;
    }

    public static Typeface d(Context context, Resources resources, int id, String path, int style) {
        Typeface typeface = a.e(context, resources, id, path, style);
        if (typeface != null) {
            String resourceUid = e(resources, id, style);
            b.d(resourceUid, typeface);
        }
        return typeface;
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, a9.b[] fonts, int style) {
        return a.c(context, cancellationSignal, fonts, style);
    }

    public static Typeface g(Context context, Typeface typeface, int style) {
        g8 g8Var = a;
        s7.b families = g8Var.i(typeface);
        if (families == null) {
            return null;
        }
        return g8Var.b(context, families, context.getResources(), style);
    }

    public static Typeface a(Context context, Typeface family, int style) {
        Typeface typefaceFromFamily;
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        }
        if (Build.VERSION.SDK_INT < 21 && (typefaceFromFamily = g(context, family, style)) != null) {
            return typefaceFromFamily;
        }
        return Typeface.create(family, style);
    }

    /* compiled from: TypefaceCompat.java */
    /* renamed from: a8$a */
    /* loaded from: classes.dex */
    public static class a extends a9.c {
        public v7.a a;

        public a(v7.a fontCallback) {
            this.a = fontCallback;
        }

        @Override // defpackage.a9.c
        public void b(Typeface typeface) {
            v7.a aVar = this.a;
            if (aVar != null) {
                aVar.e(typeface);
            }
        }

        @Override // defpackage.a9.c
        public void a(int reason) {
            v7.a aVar = this.a;
            if (aVar != null) {
                aVar.d(reason);
            }
        }
    }
}
