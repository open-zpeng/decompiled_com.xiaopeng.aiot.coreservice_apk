package defpackage;

import android.os.SystemProperties;
import android.util.Log;
/* compiled from: DeviceInfoUtils.java */
/* renamed from: do  reason: invalid class name and default package */
/* loaded from: classes.dex */
public class Cdo {
    public static String a() {
        return SystemProperties.get("ro.product.model", "");
    }

    public static boolean c() {
        boolean internation = true;
        try {
            internation = !b().contains("ZH");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Log.i("netChannel", "isInternationVersion :\t" + internation);
        return internation;
    }

    public static String b() {
        String versionFinger = SystemProperties.get("ro.xiaopeng.software", "");
        if (!"".equals(versionFinger) && versionFinger != null) {
            String countryCode = versionFinger.substring(7, 9);
            return countryCode;
        }
        return versionFinger;
    }
}
