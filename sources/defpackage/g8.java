package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import com.lzy.okgo.model.Priority;
import defpackage.a9;
import defpackage.s7;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: TypefaceCompatBaseImpl.java */
/* renamed from: g8  reason: default package */
/* loaded from: classes.dex */
public class g8 {
    @SuppressLint({"BanConcurrentHashMap"})
    public ConcurrentHashMap<Long, s7.b> a = new ConcurrentHashMap<>();

    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: g8$c */
    /* loaded from: classes.dex */
    public interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    /* JADX WARN: Generic types in debug info not equals: g8$c != androidx.core.graphics.TypefaceCompatBaseImpl$StyleExtractor<T> */
    public static <T> T g(T[] fonts, int style, c<T> cVar) {
        int targetWeight = (style & 1) == 0 ? 400 : 700;
        boolean isTargetItalic = (style & 2) != 0;
        T best = null;
        int bestScore = Priority.UI_TOP;
        for (T font : fonts) {
            int score = (Math.abs(cVar.a(font) - targetWeight) * 2) + (cVar.b(font) == isTargetItalic ? 0 : 1);
            if (best == null || bestScore > score) {
                best = font;
                bestScore = score;
            }
        }
        return best;
    }

    public static long j(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field field = Typeface.class.getDeclaredField("native_instance");
            field.setAccessible(true);
            Number num = (Number) field.get(typeface);
            return num.longValue();
        } catch (IllegalAccessException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0L;
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: g8$a */
    /* loaded from: classes.dex */
    public class a implements c<a9.b> {
        public a() {
        }

        @Override // defpackage.g8.c
        /* renamed from: c */
        public int a(a9.b info) {
            return info.e();
        }

        @Override // defpackage.g8.c
        /* renamed from: d */
        public boolean b(a9.b info) {
            return info.f();
        }
    }

    public a9.b h(a9.b[] fonts, int style) {
        return (a9.b) g(fonts, style, new a());
    }

    public Typeface d(Context context, InputStream is) {
        File tmpFile = h8.e(context);
        if (tmpFile == null) {
            return null;
        }
        try {
            if (h8.d(tmpFile, is)) {
                return Typeface.createFromFile(tmpFile.getPath());
            }
            return null;
        } catch (RuntimeException e) {
            return null;
        } finally {
            tmpFile.delete();
        }
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, a9.b[] fonts, int style) {
        if (fonts.length < 1) {
            return null;
        }
        a9.b font = h(fonts, style);
        InputStream is = null;
        try {
            is = context.getContentResolver().openInputStream(font.d());
            return d(context, is);
        } catch (IOException e) {
            return null;
        } finally {
            h8.a(is);
        }
    }

    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: g8$b */
    /* loaded from: classes.dex */
    public class b implements c<s7.c> {
        public b() {
        }

        @Override // defpackage.g8.c
        /* renamed from: c */
        public int a(s7.c entry) {
            return entry.e();
        }

        @Override // defpackage.g8.c
        /* renamed from: d */
        public boolean b(s7.c entry) {
            return entry.f();
        }
    }

    public final s7.c f(s7.b entry, int style) {
        return (s7.c) g(entry.a(), style, new b());
    }

    public Typeface b(Context context, s7.b entry, Resources resources, int style) {
        s7.c best = f(entry, style);
        if (best == null) {
            return null;
        }
        Typeface typeface = a8.d(context, resources, best.b(), best.a(), style);
        a(typeface, entry);
        return typeface;
    }

    public Typeface e(Context context, Resources resources, int id, String path, int style) {
        File tmpFile = h8.e(context);
        if (tmpFile == null) {
            return null;
        }
        try {
            if (h8.c(tmpFile, resources, id)) {
                return Typeface.createFromFile(tmpFile.getPath());
            }
            return null;
        } catch (RuntimeException e) {
            return null;
        } finally {
            tmpFile.delete();
        }
    }

    public s7.b i(Typeface typeface) {
        long key = j(typeface);
        if (key == 0) {
            return null;
        }
        return this.a.get(Long.valueOf(key));
    }

    public final void a(Typeface typeface, s7.b entry) {
        long key = j(typeface);
        if (key != 0) {
            this.a.put(Long.valueOf(key), entry);
        }
    }
}
