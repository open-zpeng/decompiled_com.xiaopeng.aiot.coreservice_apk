package defpackage;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
/* compiled from: BuildInfoUtils.java */
/* renamed from: co  reason: default package */
/* loaded from: classes.dex */
public class co {
    public static String a = null;

    public static String e() {
        String version;
        int index;
        int end;
        String result = d("ro.product.firmware");
        if ("unknown".equals(result) && (index = (version = b()).indexOf("_")) > 1 && (end = version.indexOf("_", index + 1)) > index) {
            return version.substring(index + 1, end);
        }
        return result;
    }

    public static String b() {
        String str = a;
        if (str != null) {
            return str;
        }
        String d = d("ro.xiaopeng.software");
        a = d;
        if ("unknown".equals(d)) {
            a = d("ro.build.display.id");
        }
        return a;
    }

    public static String c() {
        return d("persist.sys.mcu.hardwareId");
    }

    public static String a() {
        int index;
        String version = b();
        return (!TextUtils.isEmpty(version) && (index = version.indexOf("_")) > 1) ? version.substring(index - 1, index) : "4";
    }

    public static boolean h() {
        return "4".equals(a());
    }

    public static boolean g() {
        return "eng".equals(Build.TYPE);
    }

    public static boolean i() {
        return "userdebug".equals(Build.TYPE);
    }

    public static boolean f() {
        return g() || i();
    }

    public static boolean j() {
        return "user".equals(Build.TYPE);
    }

    public static String d(String property) {
        return SystemProperties.get(property, "unknown");
    }
}
