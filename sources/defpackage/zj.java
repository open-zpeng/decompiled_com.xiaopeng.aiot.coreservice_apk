package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.util.Random;
/* compiled from: PhoneInfoUtils.java */
/* renamed from: zj  reason: default package */
/* loaded from: classes.dex */
public class zj {
    public static final Random a = new Random();

    public static final String c() {
        Random random = a;
        int nextInt = random.nextInt();
        int nextInt2 = random.nextInt();
        byte[] a2 = sj.a((int) (System.currentTimeMillis() / 1000));
        byte[] a3 = sj.a((int) System.nanoTime());
        byte[] a4 = sj.a(nextInt);
        byte[] a5 = sj.a(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(a2, 0, bArr, 0, 4);
        System.arraycopy(a3, 0, bArr, 4, 4);
        System.arraycopy(a4, 0, bArr, 8, 4);
        System.arraycopy(a5, 0, bArr, 12, 4);
        return pj.e(bArr, 2);
    }

    public static String a(Context context) {
        String str = null;
        if (context != null) {
            try {
                String string = context.getSharedPreferences("UTCommon", 0).getString("_ie", "");
                if (!TextUtils.isEmpty(string)) {
                    String str2 = new String(pj.a(string.getBytes(), 2), XmartV1Constants.UTF8_ENCODING);
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                }
            } catch (Exception e) {
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Exception e2) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = c();
        }
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_ie", new String(pj.c(str.getBytes(XmartV1Constants.UTF8_ENCODING), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
        }
        return str;
    }

    public static String b(Context context) {
        String str = null;
        if (context != null) {
            try {
                String string = context.getSharedPreferences("UTCommon", 0).getString("_is", "");
                if (!TextUtils.isEmpty(string)) {
                    String str2 = new String(pj.a(string.getBytes(), 2), XmartV1Constants.UTF8_ENCODING);
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                }
            } catch (Exception e) {
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getSubscriberId();
                }
            } catch (Exception e2) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = c();
        }
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_is", new String(pj.c(str.getBytes(XmartV1Constants.UTF8_ENCODING), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
        }
        return str;
    }
}
