package defpackage;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: AccurateSampling.java */
/* renamed from: ni  reason: default package */
/* loaded from: classes.dex */
public class ni extends li<JSONObject> {
    public Map<String, mi> b;

    public ni(int i) {
        super(i);
        this.b = new HashMap();
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
    }

    public Boolean c(int i, Map<String, String> map) {
        Map<String, mi> map2;
        if (map == null || (map2 = this.b) == null) {
            return null;
        }
        for (String str : map2.keySet()) {
            if (!this.b.get(str).a(map.get(str))) {
                return null;
            }
        }
        return Boolean.valueOf(b(i));
    }
}
