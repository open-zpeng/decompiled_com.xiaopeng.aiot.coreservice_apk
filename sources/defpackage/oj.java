package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
/* compiled from: AppInfoUtil.java */
/* renamed from: oj  reason: default package */
/* loaded from: classes.dex */
public class oj {
    public static String a = "";
    public static String b;

    public static String d() {
        if (ej.i() == null) {
            return "";
        }
        try {
            String string = ej.i().getSharedPreferences("UTCommon", 0).getString("_lun", "");
            return !TextUtils.isEmpty(string) ? new String(pj.a(string.getBytes(), 2), XmartV1Constants.UTF8_ENCODING) : "";
        } catch (Exception e) {
            return "";
        }
    }

    public static String e() {
        if (ej.i() == null) {
            return "";
        }
        try {
            String string = ej.i().getSharedPreferences("UTCommon", 0).getString("_luid", "");
            return !TextUtils.isEmpty(string) ? new String(pj.a(string.getBytes(), 2), XmartV1Constants.UTF8_ENCODING) : "";
        } catch (Exception e) {
            return "";
        }
    }

    public static String g() {
        return a;
    }

    public static void f(String str) {
        vj.c("AppInfoUtil", "[setChannle]", str);
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("@");
            if (indexOf == -1) {
                a = str;
            } else {
                a = str.substring(0, indexOf);
            }
        }
    }

    public static String i() {
        return "";
    }

    public static String j() {
        return "";
    }

    public static String c() {
        return b;
    }

    public static void h(String str) {
        vj.c("AppInfoUtil", "set Appkey:", str);
        b = str;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(packageName)) {
                    if (runningAppProcessInfo.importance == 400) {
                        return false;
                    }
                    if (powerManager.isScreenOn()) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }
}
