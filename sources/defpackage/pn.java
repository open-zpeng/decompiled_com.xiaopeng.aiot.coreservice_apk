package defpackage;

import android.app.ActivityThread;
import android.text.TextUtils;
import android.util.Log;
/* compiled from: LogUtils.java */
/* renamed from: pn  reason: default package */
/* loaded from: classes.dex */
public class pn {
    public static int a = 2;
    public static String b = k();
    public static b c = new a();
    public static boolean d = true;
    public static boolean e = false;

    /* compiled from: LogUtils.java */
    /* renamed from: pn$b */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, String str2, String str3);
    }

    public static boolean m() {
        return d;
    }

    public static boolean n(int logLevel) {
        return a <= logLevel && m();
    }

    public static void r(Object tag, String format) {
        if (n(2)) {
            e(2, tag, format, null, e);
        }
    }

    public static void d(String msg) {
        if (n(3)) {
            e(3, null, msg, null, e);
        }
    }

    public static void a(Object tag, String message) {
        if (n(3)) {
            e(3, tag, message, null, e);
        }
    }

    public static void b(Object tag, String message, Throwable t) {
        if (n(3)) {
            e(3, tag, message, t, e);
        }
    }

    public static void c(Object tag, Throwable t) {
        if (n(3)) {
            e(3, tag, "Exception occurs at", t, e);
        }
    }

    public static void l(Object tag, String format) {
        if (n(4)) {
            e(4, tag, format, null, e);
        }
    }

    public static void u(String msg) {
        if (n(5)) {
            e(5, null, msg, null, e);
        }
    }

    public static void s(Object tag, String message) {
        if (n(5)) {
            e(5, tag, message, null, e);
        }
    }

    public static void t(Object tag, String message, Throwable t) {
        if (n(5)) {
            e(5, tag, message, t, e);
        }
    }

    public static void j(String msg) {
        if (n(6)) {
            e(6, null, msg, null, e);
        }
    }

    public static void f(Object tag, String message) {
        if (n(6)) {
            e(6, tag, message, null, e);
        }
    }

    public static void h(Object tag, String format, Object... args) {
        if (n(6)) {
            e(6, tag, String.format(format, args), null, e);
        }
    }

    public static void g(Object tag, String message, Throwable t) {
        if (n(6)) {
            e(6, tag, message, t, e);
        }
    }

    public static void i(Object tag, Throwable t) {
        if (n(6)) {
            e(6, tag, "Exception occurs at", t, e);
        }
    }

    public static void e(int logLevel, Object tag, String message, Throwable t, boolean needStackTrace) {
        String fileName = null;
        int lineNumber = 0;
        if (needStackTrace) {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement element = null;
            if (stackTraceElements != null && stackTraceElements.length > 4) {
                element = stackTraceElements[4];
            }
            if (element != null) {
                fileName = element.getFileName();
                lineNumber = element.getLineNumber();
            }
        }
        String msg = message;
        if (needStackTrace || t != null) {
            msg = p(fileName, lineNumber, message, t, needStackTrace);
        }
        String tagName = q(tag);
        if (tagName == null) {
            if (TextUtils.isEmpty(fileName)) {
                tagName = b;
            } else {
                tagName = fileName;
            }
        }
        o(logLevel, tagName, msg);
    }

    public static void o(int logLevel, String tag, String msg) {
        c.a(logLevel, msg, tag, null);
    }

    public static String p(String filename, int line, String msg, Throwable t, boolean needStackTrace) {
        StringBuilder sb = new StringBuilder();
        sb.append(msg);
        if (needStackTrace) {
            sb.append(" (T:");
            sb.append(Thread.currentThread().getId());
            sb.append(")");
            if (b != null) {
                sb.append("(C:");
                sb.append(b);
                sb.append(")");
            }
            sb.append("at (");
            sb.append(filename == null ? "" : filename);
            sb.append(":");
            sb.append(line);
            sb.append(")");
        }
        if (t != null) {
            sb.append('\n');
            sb.append(Log.getStackTraceString(t));
        }
        return sb.toString();
    }

    public static String q(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Class) {
            return ((Class) obj).getSimpleName();
        }
        return obj.getClass().getSimpleName();
    }

    /* compiled from: LogUtils.java */
    /* renamed from: pn$a */
    /* loaded from: classes.dex */
    public static class a implements b {
        @Override // defpackage.pn.b
        public void a(int type, String msg, String TAG, String fileName) {
            switch (type) {
                case 2:
                    Log.v(TAG, msg);
                    return;
                case 3:
                    Log.d(TAG, msg);
                    String str = "DEBUG: " + msg;
                    return;
                case 4:
                    Log.i(TAG, msg);
                    String str2 = "INFO: " + msg;
                    return;
                case 5:
                    Log.w(TAG, msg);
                    String str3 = "WARN: " + msg;
                    return;
                case 6:
                    Log.e(TAG, msg);
                    String str4 = "ERROR: " + msg;
                    return;
                default:
                    return;
            }
        }
    }

    public static String k() {
        String packageName = ActivityThread.currentApplication().getPackageName();
        String[] strings = packageName.split("\\.");
        return strings[strings.length - 1];
    }
}
