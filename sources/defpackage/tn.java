package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
/* compiled from: SharedPreferencesUtils.java */
/* renamed from: tn  reason: default package */
/* loaded from: classes.dex */
public class tn {
    public static volatile tn a = null;
    public static int b = 0;
    public SharedPreferences c;
    public SharedPreferences.Editor d;

    public tn(Context context, String spName, int mode) {
        spName = TextUtils.isEmpty(spName) ? context.getPackageName() : spName;
        spName = TextUtils.isEmpty(spName) ? "shared_pref" : spName;
        Log.v("SharedPreferencesUtils", "spName=" + spName);
        SharedPreferences sharedPreferences = context.getSharedPreferences(spName, 0);
        this.c = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.d = edit;
        edit.apply();
    }

    public static void e(Context context) {
        f(context, null);
    }

    public static void f(Context context, String spName) {
        if (a == null) {
            synchronized (tn.class) {
                if (a == null) {
                    a = new tn(context.getApplicationContext(), spName, 0);
                    b++;
                }
            }
        }
    }

    public static tn b(Context context) {
        e(context);
        return a;
    }

    public void h(String key, String value) {
        this.d.putString(key, value).commit();
    }

    public String c(String key) {
        return d(key, null);
    }

    public String d(String key, String defaultValue) {
        return this.c.getString(key, defaultValue);
    }

    public void g(String key, float value) {
        this.d.putFloat(key, value).commit();
    }

    public float a(String key, float defaultValue) {
        return this.c.getFloat(key, defaultValue);
    }
}
