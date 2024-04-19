package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
/* compiled from: NetworkUtil.java */
/* renamed from: yj  reason: default package */
/* loaded from: classes.dex */
public class yj {
    public static String[] a = {"Unknown", "Unknown"};
    public static c b = new c();
    public static b c = new b();

    public static String i() {
        NetworkInfo activeNetworkInfo;
        Context i = ej.i();
        if (i == null) {
            return "Unknown";
        }
        try {
            if (i.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", i.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) i.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return "wifi";
                }
                if (activeNetworkInfo.getType() == 0) {
                    return b(activeNetworkInfo.getSubtype());
                }
            }
        } catch (Throwable th) {
        }
        return "Unknown";
    }

    public static boolean h() {
        Context i = ej.i();
        if (i != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) i.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                    return false;
                }
                return true;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    public static String b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "Unknown";
        }
    }

    public static String[] f(Context paramContext) {
        return a;
    }

    public static String g(Context context) {
        WifiInfo connectionInfo;
        if (context == null || (connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) == null) {
            return "00:00:00:00:00:00";
        }
        String macAddress = connectionInfo.getMacAddress();
        if (TextUtils.isEmpty(macAddress)) {
            return "00:00:00:00:00:00";
        }
        return macAddress;
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        context.registerReceiver(b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static void e(Context context) {
        c cVar;
        if (context == null || (cVar = b) == null) {
            return;
        }
        context.unregisterReceiver(cVar);
    }

    /* compiled from: NetworkUtil.java */
    /* renamed from: yj$c */
    /* loaded from: classes.dex */
    public static class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ek.a().g(yj.c.a(context));
        }
    }

    /* compiled from: NetworkUtil.java */
    /* renamed from: yj$b */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public Context a;

        public b() {
        }

        public b a(Context context) {
            this.a = context;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.a;
            if (context == null) {
                return;
            }
            try {
                if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.a.getPackageName()) != 0) {
                    yj.a[0] = "Unknown";
                    return;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
                if (connectivityManager == null) {
                    yj.a[0] = "Unknown";
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (1 == activeNetworkInfo.getType()) {
                        yj.a[0] = "Wi-Fi";
                    } else if (activeNetworkInfo.getType() == 0) {
                        yj.a[0] = "2G/3G";
                        yj.a[1] = activeNetworkInfo.getSubtypeName();
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
