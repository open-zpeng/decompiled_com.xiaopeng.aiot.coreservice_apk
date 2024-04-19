package defpackage;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.lzy.okgo.model.Priority;
import java.lang.reflect.Method;
import java.util.List;
/* compiled from: AndroidUtils.java */
/* renamed from: zm  reason: default package */
/* loaded from: classes.dex */
public class zm {
    public static String a;

    public static boolean h(Context context, Class serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService("activity");
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Priority.UI_TOP)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(Context context) {
        String curProcess = b(context);
        return TextUtils.equals(context.getPackageName(), curProcess);
    }

    public static boolean a(Context context, String packageName) {
        if (packageName == null || "".equals(packageName)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(packageName, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String e = e();
        a = e;
        if (!TextUtils.isEmpty(e)) {
            return a;
        }
        String d = d();
        a = d;
        if (!TextUtils.isEmpty(d)) {
            return a;
        }
        String c = c(context);
        a = c;
        return c;
    }

    public static String e() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    public static String d() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (!(invoke instanceof String)) {
                return null;
            }
            String processName = (String) invoke;
            return processName;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppList;
        if (context == null) {
            return null;
        }
        int pid = Process.myPid();
        ActivityManager am = (ActivityManager) context.getSystemService("activity");
        if (am != null && (runningAppList = am.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo processInfo : runningAppList) {
                if (processInfo.pid == pid) {
                    return processInfo.processName;
                }
            }
        }
        return null;
    }

    public static boolean g(Context context, String processName) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(processName)) {
                return true;
            }
        }
        return false;
    }
}
