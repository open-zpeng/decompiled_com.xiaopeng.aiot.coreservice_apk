package defpackage;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;
/* compiled from: ResourcesFlusher.java */
/* renamed from: f0  reason: default package */
/* loaded from: classes.dex */
public class f0 {
    public static Field a;
    public static boolean b;
    public static Class<?> c;
    public static boolean d;
    public static Field e;
    public static boolean f;
    public static Field g;
    public static boolean h;

    public static void a(Resources resources) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return;
        }
        if (i >= 24) {
            d(resources);
        } else if (i >= 23) {
            c(resources);
        } else if (i >= 21) {
            b(resources);
        }
    }

    public static void b(Resources resources) {
        if (!b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            b = true;
        }
        Field field = a;
        if (field != null) {
            Map drawableCache = null;
            try {
                drawableCache = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
            if (drawableCache != null) {
                drawableCache.clear();
            }
        }
    }

    public static void c(Resources resources) {
        if (!b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            b = true;
        }
        Object drawableCache = null;
        Field field = a;
        if (field != null) {
            try {
                drawableCache = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        if (drawableCache == null) {
            return;
        }
        e(drawableCache);
    }

    public static void d(Resources resources) {
        if (!h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            h = true;
        }
        Field field = g;
        if (field == null) {
            return;
        }
        Object resourcesImpl = null;
        try {
            resourcesImpl = field.get(resources);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
        }
        if (resourcesImpl == null) {
            return;
        }
        if (!b) {
            try {
                Field declaredField2 = resourcesImpl.getClass().getDeclaredField("mDrawableCache");
                a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
            }
            b = true;
        }
        Object drawableCache = null;
        Field field2 = a;
        if (field2 != null) {
            try {
                drawableCache = field2.get(resourcesImpl);
            } catch (IllegalAccessException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
            }
        }
        if (drawableCache != null) {
            e(drawableCache);
        }
    }

    public static void e(Object cache) {
        if (!d) {
            try {
                c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            d = true;
        }
        Class<?> cls = c;
        if (cls == null) {
            return;
        }
        if (!f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException ee) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", ee);
            }
            f = true;
        }
        Field field = e;
        if (field == null) {
            return;
        }
        LongSparseArray unthemedEntries = null;
        try {
            unthemedEntries = (LongSparseArray) field.get(cache);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
        }
        if (unthemedEntries != null) {
            unthemedEntries.clear();
        }
    }
}
