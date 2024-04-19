package defpackage;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
/* compiled from: SystemPropertyUtil.java */
/* renamed from: un  reason: default package */
/* loaded from: classes.dex */
public class un {
    public static final String a = "persist.sys.mqtt.comm_url" + co.a();
    public static final String b = "persist.sys.mqtt.url" + co.a();
    public static final String c = "persist.sys.mqtt.user" + co.a();
    public static final String d = "persist.sys.mqtt.pass" + co.a();
    public static final String e = "persist.sys.mqtt.id" + co.a();

    public static long a() {
        return SystemProperties.getLong("persist.sys.account_uid", -1L);
    }

    public static int g() {
        return SystemProperties.getInt("persist.sys.vehicle_id", -1);
    }

    public static String d() {
        if (Build.VERSION.SDK_INT >= 26) {
            return SystemProperties.get("sys.xiaopeng.iccid", "");
        }
        return SystemProperties.get("ril.audio.iccid", "");
    }

    public static String f() {
        String result = SystemProperties.get("persist.sys.xiaopeng.vin", "");
        if (TextUtils.isEmpty(result)) {
            return SystemProperties.get("sys.xiaopeng.vin", "");
        }
        return result;
    }

    public static String c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return SystemProperties.get("persist.sys.mcu.hardwareId");
        }
        return SystemProperties.get("persist.sys.hardware_id");
    }

    public static String e() {
        return SystemProperties.get("ro.xiaopeng.software");
    }

    public static String b() {
        return SystemProperties.get("sys.xiaopeng.dbc_ver", "");
    }
}
