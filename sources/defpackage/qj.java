package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.alibaba.mtl.log.model.LogField;
import com.ut.device.UTDevice;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* compiled from: DeviceUtil.java */
/* renamed from: qj  reason: default package */
/* loaded from: classes.dex */
public class qj {
    public static Map<String, String> a = null;

    public static synchronized Map<String, String> a(Context context) {
        synchronized (qj.class) {
            Map<String, String> map = a;
            if (map != null) {
                map.put(LogField.CHANNEL.toString(), oj.g());
                a.put(LogField.APPKEY.toString(), oj.c());
                String a2 = zj.a(context);
                String b = zj.b(context);
                if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(b)) {
                    a2 = "";
                    b = "";
                }
                a.put(LogField.IMEI.toString(), a2);
                a.put(LogField.IMSI.toString(), b);
                b(a, context);
                return a;
            }
            HashMap hashMap = new HashMap();
            a = hashMap;
            if (context == null) {
                return null;
            }
            if (hashMap != null) {
                try {
                    String a3 = zj.a(context);
                    String b2 = zj.b(context);
                    if (TextUtils.isEmpty(a3) || TextUtils.isEmpty(b2)) {
                        a3 = "";
                        b2 = "";
                    }
                    a.put(LogField.IMEI.toString(), a3);
                    a.put(LogField.IMSI.toString(), b2);
                    a.put(LogField.BRAND.toString(), Build.BRAND);
                    a.put(LogField.DEVICE_MODEL.toString(), Build.MODEL);
                    a.put(LogField.RESOLUTION.toString(), d(context));
                    a.put(LogField.CHANNEL.toString(), oj.g());
                    a.put(LogField.APPKEY.toString(), oj.c());
                    a.put(LogField.APPVERSION.toString(), f(context));
                    a.put(LogField.LANGUAGE.toString(), c(context));
                    a.put(LogField.OS.toString(), j());
                    a.put(LogField.OSVERSION.toString(), i());
                    a.put(LogField.SDKVERSION.toString(), "2.6.4.4_for_bc");
                    a.put(LogField.SDKTYPE.toString(), "mini");
                    try {
                        a.put(LogField.UTDID.toString(), UTDevice.getUtdid(context));
                    } catch (Throwable th) {
                        Log.e("DeviceUtil", "utdid4all jar doesn't exist, please copy the libs folder.");
                        th.printStackTrace();
                    }
                    b(a, context);
                } catch (Exception e) {
                    return null;
                }
            }
            return a;
        }
    }

    public static String i() {
        String str = Build.VERSION.RELEASE;
        if (g()) {
            String property = System.getProperty("ro.yunos.version");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            str = m();
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return str;
    }

    public static String j() {
        if (g() && !h()) {
            return "y";
        }
        return "a";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.telephony.TelephonyManager] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0034 -> B:23:0x0046). Please submit an issue!!! */
    public static void b(Map<String, String> map, Context context) {
        Context context2;
        String str = "Unknown";
        try {
            String[] f = yj.f(context);
            map.put(LogField.ACCESS.toString(), f[0]);
            if (!f[0].equals("2G/3G")) {
                map.put(LogField.ACCESS_SUBTYPE.toString(), "Unknown");
                context2 = context;
            } else {
                map.put(LogField.ACCESS_SUBTYPE.toString(), f[1]);
                context2 = context;
            }
        } catch (Exception e) {
            map.put(LogField.ACCESS.toString(), "Unknown");
            map.put(LogField.ACCESS_SUBTYPE.toString(), "Unknown");
            context2 = context;
        }
        try {
            context = (TelephonyManager) context2.getSystemService("phone");
            String str2 = "";
            if (context != 0 && context.getSimState() == 5) {
                str2 = context.getNetworkOperatorName();
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            map.put(LogField.CARRIER.toString(), str);
        } catch (Exception e2) {
        }
    }

    public static String c(Context context) {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Throwable th) {
            return "Unknown";
        }
    }

    public static String d(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i > i2) {
                int i3 = i ^ i2;
                i2 ^= i3;
                i = i3 ^ i2;
            }
            return i2 + "*" + i;
        } catch (Exception e) {
            return "Unknown";
        }
    }

    public static String f(Context context) {
        String e = gj.b().e();
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return "Unknown";
            }
            a.put(LogField.APPVERSION.toString(), packageInfo.versionName);
            return packageInfo.versionName;
        } catch (Throwable th) {
            return "Unknown";
        }
    }

    public static boolean g() {
        try {
            if ((System.getProperty("java.vm.name") == null || !System.getProperty("java.vm.name").toLowerCase().contains("lemur")) && System.getProperty("ro.yunos.version") == null && TextUtils.isEmpty(dk.a("ro.yunos.build.version"))) {
                return h();
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean h() {
        if (!TextUtils.isEmpty(e("ro.yunos.product.chip")) || !TextUtils.isEmpty(e("ro.yunos.hardware"))) {
            return true;
        }
        return false;
    }

    public static String e(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls.newInstance(), str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String k() {
        String b = dk.b("ro.aliyun.clouduuid", "false");
        if ("false".equals(b)) {
            b = dk.b("ro.sys.aliyun.clouduuid", "false");
        }
        if (TextUtils.isEmpty(b)) {
            return l();
        }
        return b;
    }

    public static String l() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    public static String m() {
        try {
            Field declaredField = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return (String) declaredField.get(new String());
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
