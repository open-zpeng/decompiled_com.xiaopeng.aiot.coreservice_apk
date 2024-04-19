package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.mtl.log.model.LogField;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import okhttp3.internal.cache.DiskLruCache;
/* compiled from: UrlWrapper.java */
/* renamed from: gk  reason: default package */
/* loaded from: classes.dex */
public class gk {
    public static final String a = gk.class.getSimpleName();

    public static String b(String str, Map<String, Object> map, Map<String, Object> map2) throws Exception {
        String a2;
        String str2;
        String str3 = "";
        if (map2 != null && map2.size() > 0) {
            Set<String> keySet = map2.keySet();
            String[] strArr = new String[keySet.size()];
            keySet.toArray(strArr);
            for (String str4 : tj.a().b(strArr, true)) {
                str3 = str3 + str4 + wj.c((byte[]) map2.get(str4));
            }
        }
        try {
            a2 = a(str, null, null, str3);
        } catch (Throwable th) {
            a2 = a(zi.k(), null, null, str3);
        }
        if (!TextUtils.isEmpty(zi.f)) {
            return a2 + "&dk=" + URLEncoder.encode(str2, XmartV1Constants.UTF8_ENCODING);
        }
        return a2;
    }

    public static String c(String str, Map<String, Object> map, Map<String, Object> map2) throws Exception {
        String str2;
        if (map == null) {
            new HashMap();
        }
        Context i = ej.i();
        String c = oj.c();
        String g = oj.g();
        if (g == null) {
            g = "";
        }
        String str3 = qj.a(i).get(LogField.APPVERSION.toString());
        String str4 = qj.a(i).get(LogField.OS.toString());
        String str5 = qj.a(i).get(LogField.UTDID.toString());
        String valueOf = String.valueOf(System.currentTimeMillis());
        jk a2 = ej.a();
        if (!(a2 instanceof kk)) {
            str2 = "0";
        } else {
            str2 = DiskLruCache.VERSION_1;
        }
        String sign = a2.getSign(wj.c((c + str3 + g + str4 + str5 + "2.6.4.4_for_bc" + valueOf + str2 + map.get("_b01n15") + map.get("_b01na")).getBytes()));
        return str + "?ak=" + c + "&av=" + str3 + "&c=" + URLEncoder.encode(g) + "&d=" + str5 + "&sv=2.6.4.4_for_bc&t=" + valueOf + "&is=" + str2 + "&_b01n15=" + map.get("_b01n15") + "&_b01na=" + map.get("_b01na") + "&s=" + sign;
    }

    public static String a(String str, String str2, String str3, String str4) throws Exception {
        String str5;
        Context i = ej.i();
        String c = oj.c();
        String g = oj.g();
        if (g == null) {
            g = "";
        }
        String str6 = qj.a(i).get(LogField.APPVERSION.toString());
        String str7 = qj.a(i).get(LogField.OS.toString());
        String str8 = qj.a(i).get(LogField.UTDID.toString());
        String valueOf = String.valueOf(System.currentTimeMillis());
        jk a2 = ej.a();
        boolean z = a2 instanceof kk;
        String str9 = DiskLruCache.VERSION_1;
        String str10 = "0";
        if (!z) {
            if (!(a2 instanceof ik)) {
                str9 = "0";
            } else {
                if (!((ik) a2).a()) {
                    str9 = "0";
                }
                str10 = str9;
                str9 = "0";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append(g);
        sb.append(str6);
        sb.append(str7);
        sb.append("2.6.4.4_for_bc");
        sb.append(str8);
        sb.append(valueOf);
        sb.append("3.0");
        sb.append(str9);
        sb.append(str3 == null ? "" : str3);
        sb.append(str4 == null ? "" : str4);
        String sign = a2.getSign(wj.c(sb.toString().getBytes()));
        if (TextUtils.isEmpty(str2)) {
            str5 = "";
        } else {
            str5 = str2 + "&";
        }
        return String.format("%s?%sak=%s&av=%s&c=%s&v=%s&s=%s&d=%s&sv=%s&p=%s&t=%s&u=%s&is=%s&k=%s", str, str5, d(c), d(str6), d(g), d("3.0"), d(sign), d(str8), "2.6.4.4_for_bc", str7, valueOf, "", str9, str10);
    }

    public static String d(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, XmartV1Constants.UTF8_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
