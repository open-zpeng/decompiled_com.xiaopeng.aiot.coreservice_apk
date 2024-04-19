package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: BundleCompat.java */
/* renamed from: c7  reason: default package */
/* loaded from: classes.dex */
public final class c7 {

    /* compiled from: BundleCompat.java */
    /* renamed from: c7$a */
    /* loaded from: classes.dex */
    public static class a {
        public static Method a;
        public static boolean b;
        public static Method c;
        public static boolean d;

        public static IBinder a(Bundle bundle, String key) {
            if (!b) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", String.class);
                    a = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
                }
                b = true;
            }
            Method method2 = a;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, key);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                    a = null;
                }
            }
            return null;
        }

        public static void b(Bundle bundle, String key, IBinder binder) {
            if (!d) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    c = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e);
                }
                d = true;
            }
            Method method2 = c;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, key, binder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e2);
                    c = null;
                }
            }
        }
    }

    public static IBinder a(Bundle bundle, String key) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(key);
        }
        return a.a(bundle, key);
    }

    public static void b(Bundle bundle, String key, IBinder binder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(key, binder);
        } else {
            a.b(bundle, key, binder);
        }
    }
}
