package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: EventTypeSampling.java */
/* renamed from: ri  reason: default package */
/* loaded from: classes.dex */
public class ri extends li<JSONObject> {
    public zh b;
    public Map<String, si> c;
    public int d;

    public ri(zh zhVar, int i) {
        super(i);
        this.d = -1;
        this.b = zhVar;
        this.c = Collections.synchronizedMap(new HashMap());
    }

    public boolean c(int i, String str, String str2, Map<String, String> map) {
        si siVar;
        Map<String, si> map2 = this.c;
        if (map2 != null && (siVar = map2.get(str)) != null) {
            return siVar.c(i, str2, map);
        }
        if (i < this.a) {
            return true;
        }
        return false;
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
        e(jSONObject);
        this.c.clear();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("metrics");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("module");
                    if (xi.a(optString)) {
                        si siVar = this.c.get(optString);
                        if (siVar == null) {
                            siVar = new si(optString, this.a);
                            this.c.put(optString, siVar);
                        }
                        siVar.d(jSONObject2);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public void e(JSONObject jSONObject) {
        zh zhVar;
        vj.c("EventTypeSampling", "[updateEventTypeTriggerCount]", this, jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("cacheCount");
            if (optInt > 0 && (zhVar = this.b) != null) {
                zhVar.e(optInt);
            }
        } catch (Throwable th) {
            vj.b("EventTypeSampling", "updateTriggerCount", th);
        }
    }

    public void f(int sampling) {
        this.a = sampling;
    }
}
