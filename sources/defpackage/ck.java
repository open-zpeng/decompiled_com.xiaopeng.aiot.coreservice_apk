package defpackage;

import android.text.TextUtils;
import com.xiaopeng.base.log.LogUtils;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* compiled from: StringUtils.java */
/* renamed from: ck  reason: default package */
/* loaded from: classes.dex */
public class ck {
    public static String b(Object o) {
        if (o == null) {
            return "";
        }
        if (o instanceof String) {
            return ((String) o).toString();
        }
        if (o instanceof Integer) {
            return "" + ((Integer) o).intValue();
        } else if (o instanceof Long) {
            return "" + ((Long) o).longValue();
        } else if (o instanceof Double) {
            return "" + ((Double) o).doubleValue();
        } else if (o instanceof Float) {
            return "" + ((Float) o).floatValue();
        } else if (o instanceof Short) {
            return "" + ((int) ((Short) o).shortValue());
        } else if (o instanceof Byte) {
            return "" + ((int) ((Byte) o).byteValue());
        } else if (o instanceof Boolean) {
            return ((Boolean) o).toString();
        } else {
            if (o instanceof Character) {
                return ((Character) o).toString();
            }
            return o.toString();
        }
    }

    public static Map<String, String> a(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            for (String str : map.keySet()) {
                if (str instanceof String) {
                    String str2 = map.get(str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        try {
                            hashMap.put(URLEncoder.encode(str, XmartV1Constants.UTF8_ENCODING), URLEncoder.encode(str2, XmartV1Constants.UTF8_ENCODING));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return hashMap;
        }
        return map;
    }

    public static String c(Map<String, String> map) {
        if (map != null) {
            boolean z = true;
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : map.keySet()) {
                String b = b(map.get(str));
                String b2 = b(str);
                if (b != null && b2 != null) {
                    if (z) {
                        stringBuffer.append(b2 + "=" + b);
                        z = false;
                    } else {
                        stringBuffer.append(LogUtils.SEPARATOR);
                        stringBuffer.append(b2 + "=" + b);
                    }
                }
            }
            return stringBuffer.toString();
        }
        return null;
    }
}
