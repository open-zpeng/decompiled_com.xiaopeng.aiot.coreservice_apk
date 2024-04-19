package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
/* compiled from: NetWorkUtil.java */
/* renamed from: bn  reason: default package */
/* loaded from: classes.dex */
public class bn {
    @SuppressLint({"MissingPermission"})
    public static cn a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo mobileNetInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo wifiNetInfo = connectivityManager.getNetworkInfo(1);
            if (mobileNetInfo != null && mobileNetInfo.isAvailable()) {
                return cn.MOBILE;
            }
            if (wifiNetInfo != null && wifiNetInfo.isAvailable()) {
                return cn.WIFI;
            }
            return cn.NONE;
        } else if (b(context)) {
            return cn.MOBILE;
        } else {
            if (d(context)) {
                return cn.WIFI;
            }
            return cn.NONE;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean c(Context context) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isAvailable();
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(16);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean d(Context context) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        } else {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                return networkCapabilities.hasTransport(1);
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean b(Context context) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        } else {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                return networkCapabilities.hasTransport(0);
            }
        }
        return false;
    }
}
