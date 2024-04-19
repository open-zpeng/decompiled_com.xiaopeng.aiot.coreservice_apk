package defpackage;

import android.text.TextUtils;
import android.util.Log;
/* compiled from: XLogUtils.java */
/* renamed from: rq  reason: default package */
/* loaded from: classes.dex */
public class rq {
    public static String a = "xpui";
    public static b b = new a();
    public static boolean c = true;
    public static boolean d = false;
    public static int e = 4;

    /* compiled from: XLogUtils.java */
    /* renamed from: rq$b */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, String str2, String str3);
    }

    public static boolean f() {
        return c;
    }

    public static boolean g(int logLevel) {
        return e <= logLevel && f();
    }

    public static void a(Object tag, String message) {
        if (g(3)) {
            c(3, tag, message, null, d);
        }
    }

    public static void b(Object tag, String format, Object... args) {
        if (g(3)) {
            c(3, tag, String.format(format, args), null, d);
        }
    }

    public static void e(Object tag, String message) {
        if (g(4)) {
            c(4, tag, message, null, d);
        }
    }

    public static void k(Object tag, String message) {
        if (g(5)) {
            c(5, tag, message, null, d);
        }
    }

    public static void d(Object tag, String message) {
        if (g(6)) {
            c(6, tag, message, null, d);
        }
    }

    public static void c(int logLevel, Object tag, String message, Throwable t, boolean needStackTrace) {
        String fileName = null;
        int lineNumber = 0;
        if (needStackTrace) {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement element = null;
            if (stackTraceElements.length > 4) {
                element = stackTraceElements[4];
            }
            if (element != null) {
                fileName = element.getFileName();
                lineNumber = element.getLineNumber();
            }
        }
        String msg = message;
        if (needStackTrace || t != null) {
            msg = i(fileName, lineNumber, message, t, needStackTrace);
        }
        String tagName = j(tag);
        if (tagName == null) {
            if (TextUtils.isEmpty(fileName)) {
                tagName = a;
            } else {
                tagName = fileName;
            }
        }
        h(logLevel, tagName, msg);
    }

    public static void h(int logLevel, String tag, String msg) {
        b.a(logLevel, msg, tag, null);
    }

    public static String i(String filename, int line, String msg, Throwable t, boolean needStackTrace) {
        StringBuilder sb = new StringBuilder();
        sb.append(msg);
        if (needStackTrace) {
            sb.append(" (T:");
            sb.append(Thread.currentThread().getId());
            sb.append(")");
            if (a != null) {
                sb.append("(C:");
                sb.append(a);
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

    public static String j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return (obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName();
    }

    /* compiled from: XLogUtils.java */
    /* renamed from: rq$a */
    /* loaded from: classes.dex */
    public static class a implements b {
        @Override // defpackage.rq.b
        public void a(int type, String msg, String TAG, String fileName) {
            switch (type) {
                case 2:
                    Log.v(TAG, msg);
                    return;
                case 3:
                    Log.d(TAG, msg);
                    return;
                case 4:
                    Log.i(TAG, msg);
                    return;
                case 5:
                    Log.w(TAG, msg);
                    return;
                case 6:
                    Log.e(TAG, msg);
                    return;
                default:
                    return;
            }
        }
    }
}
