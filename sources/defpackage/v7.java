package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: ResourcesCompat.java */
/* renamed from: v7  reason: default package */
/* loaded from: classes.dex */
public final class v7 {
    public static Drawable a(Resources res, int id, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return res.getDrawable(id, theme);
        }
        return res.getDrawable(id);
    }

    /* compiled from: ResourcesCompat.java */
    /* renamed from: v7$a */
    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract void d(int i);

        public abstract void e(Typeface typeface);

        /* compiled from: ResourcesCompat.java */
        /* renamed from: v7$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0023a implements Runnable {
            public final /* synthetic */ Typeface a;

            public RunnableC0023a(Typeface typeface) {
                this.a = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.e(this.a);
            }
        }

        public final void b(Typeface typeface, Handler handler) {
            c(handler).post(new RunnableC0023a(typeface));
        }

        /* compiled from: ResourcesCompat.java */
        /* renamed from: v7$a$b */
        /* loaded from: classes.dex */
        public class b implements Runnable {
            public final /* synthetic */ int a;

            public b(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.d(this.a);
            }
        }

        public final void a(int reason, Handler handler) {
            c(handler).post(new b(reason));
        }

        public static Handler c(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }
    }

    public static Typeface b(Context context, int id, TypedValue value, int style, a fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return c(context, id, value, style, fontCallback, null, true, false);
    }

    public static Typeface c(Context context, int id, TypedValue value, int style, a fontCallback, Handler handler, boolean isRequestFromLayoutInflator, boolean isCachedOnly) {
        Resources resources = context.getResources();
        resources.getValue(id, value, true);
        Typeface typeface = d(context, resources, value, id, style, fontCallback, handler, isRequestFromLayoutInflator, isCachedOnly);
        if (typeface == null && fontCallback == null && !isCachedOnly) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(id) + " could not be retrieved.");
        }
        return typeface;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface d(android.content.Context r19, android.content.res.Resources r20, android.util.TypedValue r21, int r22, int r23, defpackage.v7.a r24, android.os.Handler r25, boolean r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v7.d(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, v7$a, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    /* compiled from: ResourcesCompat.java */
    /* renamed from: v7$b */
    /* loaded from: classes.dex */
    public static final class b {
        public static void a(Resources.Theme theme) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                C0024b.a(theme);
            } else if (i >= 23) {
                a.a(theme);
            }
        }

        /* compiled from: ResourcesCompat.java */
        /* renamed from: v7$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0024b {
            public static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        /* compiled from: ResourcesCompat.java */
        /* renamed from: v7$b$a */
        /* loaded from: classes.dex */
        public static class a {
            public static final Object a = new Object();
            public static Method b;
            public static boolean c;

            public static void a(Resources.Theme theme) {
                synchronized (a) {
                    if (!c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                        }
                        c = true;
                    }
                    Method method = b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e2) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                            b = null;
                        }
                    }
                }
            }
        }
    }
}
