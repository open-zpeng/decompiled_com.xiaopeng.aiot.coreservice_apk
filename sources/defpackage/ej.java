package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.log.model.a;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: UTDC.java */
/* renamed from: ej  reason: default package */
/* loaded from: classes.dex */
public class ej {
    public static Context a;
    public static boolean b = false;
    public static boolean c = false;
    public static int d = 10000;
    public static int e = 0;
    public static long f = -1;
    public static boolean g = false;
    public static boolean h = true;
    public static String i = String.valueOf(System.currentTimeMillis());
    public static final AtomicInteger j = new AtomicInteger(0);
    public static boolean k = true;
    public static jk l = null;

    public static synchronized void b(Context context) {
        synchronized (ej.class) {
            if (context == null) {
                vj.a("UTDC", "UTDC init failed ,context:" + context);
                return;
            }
            if (!b) {
                b = true;
                a = context.getApplicationContext();
                lj.c().f();
            }
        }
    }

    public static void c(jk jkVar) {
        l = jkVar;
        if (jkVar != null) {
            oj.h(jkVar.getAppkey());
        }
    }

    public static void m(String channel) {
        oj.f(channel);
    }

    public static void j() {
        vj.c("UTDC", "[onBackground]");
        c = true;
        fj.d();
    }

    public static void k() {
        vj.c("UTDC", "[onForeground]");
        c = false;
        lj.c().f();
    }

    public static void d(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (a == null) {
            vj.a("UTDC", "please call UTDC.init(context) before commit log,and this log will be discarded");
        } else if (l == null) {
            vj.a("UTDC", "please call UTDC.setRequestAuthentication(auth) before commit log,and this log will be discarded");
        } else {
            vj.c("UTDC", "[commit] page:", str, "eventId:", str2, "arg1:", str3, "arg2:", str4, "arg3:", str5, "args:", map);
            fj.i(str2);
            jj.f().i(new a(str, str2, str3, str4, str5, map));
        }
    }

    public static Context i() {
        return a;
    }

    public static jk a() {
        jk jkVar = l;
        if (jkVar == null || TextUtils.isEmpty(jkVar.getAppkey())) {
            if (vj.g()) {
                throw new RuntimeException("please Set <meta-data android:value=\"YOU KEY\" android:name=\"com.alibaba.apmplus.app_key\"></meta-data> in app AndroidManifest.xml ");
            }
            Log.w("UTDC", "please Set <meta-data android:value=\"YOU KEY\" android:name=\"com.alibaba.apmplus.app_key\"></meta-data> in app AndroidManifest.xml ");
        }
        return l;
    }

    public static String e() {
        try {
            return yj.f(i())[0];
        } catch (Exception e2) {
            return "Unknown";
        }
    }

    public static String f() {
        try {
            String[] f2 = yj.f(i());
            if (!f2[0].equals("2G/3G")) {
                return "Unknown";
            }
            return f2[1];
        } catch (Exception e2) {
            return "Unknown";
        }
    }

    public static String g() {
        return "";
    }

    public static String h() {
        return "";
    }

    public static void l() {
        lj.c().f();
    }
}
