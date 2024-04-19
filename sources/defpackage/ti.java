package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: MonitorPointSampling.java */
/* renamed from: ti  reason: default package */
/* loaded from: classes.dex */
public class ti extends li<JSONObject> {
    public String b;
    public List<ni> c;

    public ti(String str, int i) {
        super(i);
        this.b = str;
    }

    public boolean c(int i, Map<String, String> map) {
        List<ni> list = this.c;
        if (list != null && map != null) {
            for (ni niVar : list) {
                Boolean c = niVar.c(i, map);
                if (c != null) {
                    return c.booleanValue();
                }
            }
        }
        return b(i);
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("extra");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    ni niVar = new ni(this.a);
                    if (this.c == null) {
                        this.c = new ArrayList();
                    }
                    this.c.add(niVar);
                    niVar.d(jSONObject2);
                }
            }
        } catch (Exception e) {
        }
    }
}
