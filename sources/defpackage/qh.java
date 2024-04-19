package defpackage;

import java.util.HashMap;
import java.util.Map;
/* compiled from: SdkMeta.java */
/* renamed from: qh  reason: default package */
/* loaded from: classes.dex */
public class qh {
    public static final Map<String, String> a;

    public static Map<String, String> a() {
        ej.i();
        Map<String, String> map = a;
        if (!map.containsKey("sdk-version")) {
            map.put("sdk-version", "2.6.4.4_for_bc");
        }
        return map;
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("sdk-version", "2.6.4.4_for_bc");
    }
}
