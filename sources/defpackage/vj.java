package defpackage;

import android.os.Process;
import android.util.Log;
import com.xiaopeng.base.log.LogUtils;
/* compiled from: Logger.java */
/* renamed from: vj  reason: default package */
/* loaded from: classes.dex */
public class vj {
    public static String a = "UTAnalytics:";
    public static boolean b = false;
    public static boolean c = false;

    public static boolean f() {
        return b;
    }

    public static boolean g() {
        return c;
    }

    public static void e(boolean z) {
        c = z;
    }

    public static void c(String str, Object... objArr) {
        if (c) {
            String str2 = a + str;
            StringBuilder sb = new StringBuilder();
            sb.append("pid:");
            sb.append(Process.myPid());
            sb.append(" ");
            if (objArr != null) {
                for (int i = 0; i < objArr.length; i++) {
                    if (objArr[i] != null) {
                        String obj = objArr[i].toString();
                        if (obj.endsWith(":") || obj.endsWith(": ")) {
                            sb.append(obj);
                        } else {
                            sb.append(obj);
                            sb.append(LogUtils.SEPARATOR);
                        }
                    }
                }
            }
            Log.d(str2, sb.toString());
        }
    }

    public static void b(String str, Object obj, Throwable th) {
        if (g() || f()) {
            Log.w(str + a, obj + "", th);
        }
    }

    public static void a(String str, Object obj) {
        if (g() || f()) {
            Log.w(str + a, obj + "");
        }
    }

    public static void d(String str, String... strArr) {
        if (c) {
            String str2 = a + str;
            StringBuilder sb = new StringBuilder();
            sb.append("pid:");
            sb.append(Process.myPid());
            sb.append(" ");
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i++) {
                    if (strArr[i] != null) {
                        String str3 = strArr[i];
                        if (str3.endsWith(":") || str3.endsWith(": ")) {
                            sb.append(str3);
                        } else {
                            sb.append(str3);
                            sb.append(LogUtils.SEPARATOR);
                        }
                    }
                }
            }
            Log.i(str2, sb.toString());
        }
    }
}
