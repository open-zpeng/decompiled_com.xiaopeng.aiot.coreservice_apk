package defpackage;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* compiled from: TraceCompat.java */
@Deprecated
/* renamed from: u8  reason: default package */
/* loaded from: classes.dex */
public final class u8 {
    public static long a;
    public static Method b;
    public static Method c;
    public static Method d;
    public static Method e;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18 && i < 29) {
            try {
                Field traceTagAppField = Trace.class.getField("TRACE_TAG_APP");
                a = traceTagAppField.getLong(null);
                Class cls = Long.TYPE;
                b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e2) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e2);
            }
        }
    }

    public static void a(String sectionName) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(sectionName);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
