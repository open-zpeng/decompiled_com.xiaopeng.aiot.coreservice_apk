package defpackage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: Trace.java */
/* renamed from: ze  reason: default package */
/* loaded from: classes.dex */
public final class ze {
    public static long a;
    public static Method b;

    @SuppressLint({"NewApi"})
    public static boolean d() {
        try {
            if (b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError e) {
        } catch (NoSuchMethodError e2) {
        }
        return e();
    }

    public static void a(String label) {
        if (Build.VERSION.SDK_INT >= 18) {
            af.a(label);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            af.b();
        }
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (b == null) {
                    Field traceTagAppField = Trace.class.getField("TRACE_TAG_APP");
                    a = traceTagAppField.getLong(null);
                    b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) b.invoke(null, Long.valueOf(a))).booleanValue();
            } catch (Exception exception) {
                c("isTagEnabled", exception);
            }
        }
        return false;
    }

    public static void c(String methodName, Exception exception) {
        if (exception instanceof InvocationTargetException) {
            Throwable cause = exception.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + methodName + " via reflection", exception);
    }
}
