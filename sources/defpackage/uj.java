package defpackage;

import android.text.TextUtils;
import com.alibaba.mtl.log.model.LogField;
import com.xiaopeng.base.log.LogUtils;
import java.util.HashMap;
import java.util.Map;
/* compiled from: LogAssemble.java */
/* renamed from: uj  reason: default package */
/* loaded from: classes.dex */
public class uj {
    public static String b(Map<String, String> map) {
        boolean z;
        LogField logField;
        StringBuilder sb = new StringBuilder();
        LogField[] values = LogField.values();
        int length = values.length;
        int i = 0;
        while (true) {
            String str = null;
            if (i >= length || (logField = values[i]) == LogField.ARGS) {
                break;
            }
            if (map.containsKey(logField.toString())) {
                str = map.get(logField.toString()) + "";
                map.remove(logField.toString());
            }
            sb.append(f(str));
            sb.append("||");
            i++;
        }
        LogField logField2 = LogField.ARGS;
        if (!map.containsKey(logField2.toString())) {
            z = true;
        } else {
            sb.append(f(map.get(logField2.toString()) + ""));
            map.remove(logField2.toString());
            z = false;
        }
        for (String str2 : map.keySet()) {
            String str3 = !map.containsKey(str2) ? null : map.get(str2) + "";
            if (z) {
                if ("StackTrace".equals(str2)) {
                    sb.append("StackTrace=====>");
                    sb.append(str3);
                } else {
                    sb.append(f(str2));
                    sb.append("=");
                    sb.append(str3);
                }
                z = false;
            } else if ("StackTrace".equals(str2)) {
                sb.append(LogUtils.SEPARATOR);
                sb.append("StackTrace=====>");
                sb.append(str3);
            } else {
                sb.append(LogUtils.SEPARATOR);
                sb.append(f(str2));
                sb.append("=");
                sb.append(str3);
            }
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2) && sb2.endsWith("||")) {
            return sb2 + "-";
        }
        return sb2;
    }

    public static String d(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            c(map);
            return b(map);
        }
        return null;
    }

    public static Map<String, String> c(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        try {
            String i = oj.i();
            if (!TextUtils.isEmpty(i)) {
                LogField logField = LogField.USERNICK;
                if (!map.containsKey(logField.toString())) {
                    map.put(logField.toString(), i);
                }
            }
            String d = oj.d();
            if (!TextUtils.isEmpty(d)) {
                LogField logField2 = LogField.LL_USERNICK;
                if (!map.containsKey(logField2.toString())) {
                    map.put(logField2.toString(), d);
                }
            }
            String j = oj.j();
            if (!TextUtils.isEmpty(j)) {
                LogField logField3 = LogField.USERID;
                if (!map.containsKey(logField3.toString())) {
                    map.put(logField3.toString(), j);
                }
            }
            String e = oj.e();
            if (!TextUtils.isEmpty(e)) {
                LogField logField4 = LogField.LL_USERID;
                if (!map.containsKey(logField4.toString())) {
                    map.put(logField4.toString(), e);
                }
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            LogField logField5 = LogField.RECORD_TIMESTAMP;
            if (!map.containsKey(logField5.toString())) {
                map.put(logField5.toString(), valueOf);
            }
            LogField logField6 = LogField.START_SESSION_TIMESTAMP;
            if (!map.containsKey(logField6.toString())) {
                map.put(logField6.toString(), String.valueOf(ej.i));
            }
            Map<String, String> a = qj.a(ej.i());
            if (a != null) {
                for (String str : a.keySet()) {
                    String str2 = a.get(str);
                    if (!TextUtils.isEmpty(str2) && !map.containsKey(str) && !map.containsKey(str)) {
                        map.put(str, str2);
                    }
                }
            }
            String e2 = e(map);
            if (!TextUtils.isEmpty(e2)) {
                LogField logField7 = LogField.RESERVES;
                if (!map.containsKey(logField7.toString())) {
                    map.put(logField7.toString(), e2);
                }
            }
        } catch (Throwable th) {
        }
        return map;
    }

    public static String e(Map<String, String> map) {
        String g;
        String str = "_ap=1";
        if (yj.g(ej.i()) != null) {
            str = "_ap=1" + String.format("%s=%s", ",_mac", g);
        }
        if ("y".equalsIgnoreCase(map.get(LogField.OS.toString()))) {
            String k = qj.k();
            if (!TextUtils.isEmpty(k)) {
                str = str + ",_did=" + k;
            }
        }
        String str2 = map.get(LogField.APPKEY.toString());
        if (!TextUtils.isEmpty(oj.c()) && !TextUtils.isEmpty(str2) && !oj.c().equalsIgnoreCase(str2)) {
            return str + ",_mak=" + oj.c();
        }
        return str;
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "-";
        }
        return str;
    }

    public static String a(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6, String str7) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(LogField.PAGE.toString(), str);
        }
        hashMap.put(LogField.EVENTID.toString(), str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(LogField.ARG1.toString(), str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(LogField.ARG2.toString(), str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put(LogField.ARG3.toString(), str5);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put(LogField.RECORD_TIMESTAMP.toString(), str7);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put(LogField.RESERVE3.toString(), str6);
        }
        return d(hashMap);
    }
}
