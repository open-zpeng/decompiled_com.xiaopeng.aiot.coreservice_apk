package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemProperties;
/* compiled from: NetUtils.java */
/* renamed from: rn  reason: default package */
/* loaded from: classes.dex */
public class rn {
    public static boolean c(Context context) {
        ConnectivityManager connectMgr = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo info = connectMgr.getActiveNetworkInfo();
        if (info != null && info.getType() == 0) {
            return true;
        }
        return false;
    }

    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        ConnectivityManager connectMgr = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo info = connectMgr.getActiveNetworkInfo();
        if (info != null) {
            if (info.getType() == 0) {
                switch (info.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 2;
                    case 13:
                        return 3;
                }
            } else if (info.getType() == 1) {
                return 10;
            }
        }
        return 0;
    }

    public static boolean d(Context context) {
        NetworkInfo info;
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivity != null && (info = connectivity.getActiveNetworkInfo()) != null && info.isAvailable() && info.isConnected()) {
            return true;
        }
        return false;
    }

    public static int b() {
        return SystemProperties.getInt("persist.sys.xp.4g.st", 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        if ("unknown".equals(r3) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean e() {
        /*
            r0 = 1
            java.lang.String r1 = "persist.sys.ril.gobinet"
            java.lang.String r1 = android.os.SystemProperties.get(r1)
            java.lang.String r2 = "on"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L10
            return r0
        L10:
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "/sys/class/net/xpusb0/operstate"
            r1.<init>(r2)
            boolean r2 = r1.exists()
            if (r2 != 0) goto L1e
            return r0
        L1e:
            r0 = 0
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            r2 = r3
            java.lang.String r3 = r2.readLine()     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            java.lang.String r4 = "up"
            boolean r4 = r4.equals(r3)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            if (r4 != 0) goto L3f
            java.lang.String r4 = "unknown"
            boolean r4 = r4.equals(r3)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L43
            if (r4 == 0) goto L47
        L3f:
            r0 = 1
            goto L47
        L41:
            r3 = move-exception
            goto L4c
        L43:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L41
        L47:
            defpackage.on.a(r2)
            return r0
        L4c:
            defpackage.on.a(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rn.e():boolean");
    }
}
