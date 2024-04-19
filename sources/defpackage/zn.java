package defpackage;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
/* compiled from: EnvConfig.java */
/* renamed from: zn  reason: default package */
/* loaded from: classes.dex */
public final class zn {
    public static Properties a = new Properties();

    static {
        f();
    }

    public static boolean d(String key) {
        return a.containsKey(key);
    }

    public static boolean e() {
        return a.size() > 0 && d("main_host");
    }

    public static String b(String defLanVerValue, String defUserVerVal) {
        return c("main_host", defLanVerValue, defUserVerVal);
    }

    public static String c(String key, String defLanVerValue, String defUserVerVal) {
        if (co.f()) {
            String result = a.getProperty(key);
            if (!TextUtils.isEmpty(result)) {
                return result;
            }
        }
        if (co.h()) {
            return defLanVerValue;
        }
        return defUserVerVal;
    }

    public static long a(String dateStr) {
        try {
            String pattern = "yyyyMMdd HH:mm:ss";
            int pos = dateStr.indexOf(":");
            if (pos < 0) {
                int pos2 = dateStr.indexOf(" ");
                if (pos2 < 0) {
                    if (dateStr.length() <= 8) {
                        pattern = "yyyyMMdd";
                    } else {
                        pattern = "yyyyMMddHHmmss";
                    }
                } else {
                    pattern = "yyyyMMdd HHmmss";
                }
            }
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            Date date = formatter.parse(dateStr);
            long expiredTime = date.getTime();
            return expiredTime;
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static void f() {
        File file;
        if (co.f()) {
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                try {
                    file = new File("/sdcard/pre_env.ini");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (file.exists()) {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    a.load(bis);
                    Log.w("EnvConfig", "<<<< warning, load file: pre_env.ini !!!");
                    String expired = a.getProperty("expired_time", null);
                    if (!TextUtils.isEmpty(expired)) {
                        long expiredTime = a(expired);
                        if (expiredTime > 0 && System.currentTimeMillis() >= expiredTime) {
                            Log.w("EnvConfig", "<<<< file pre_env.ini is expired!");
                            a.clear();
                        }
                    }
                }
            } finally {
                on.a(bis);
                on.a(fis);
            }
        }
    }
}
