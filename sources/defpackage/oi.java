package defpackage;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: AlarmModuleSampling.java */
/* renamed from: oi  reason: default package */
/* loaded from: classes.dex */
public class oi extends si {
    public int d;
    public int e;

    @Override // defpackage.si
    public /* bridge */ /* synthetic */ boolean c(int i, String str, Map map) {
        return super.c(i, str, map);
    }

    public oi(String str, int i, int i2) {
        super(str, 0);
        int i3 = this.a;
        this.d = i3;
        this.e = i3;
    }

    public boolean e(int i, String str, Boolean bool, Map<String, String> map) {
        ti tiVar;
        vj.c("AlarmModuleSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.d), "failSampling:", Integer.valueOf(this.e));
        Map<String, ti> map2 = this.c;
        if (map2 != null && (tiVar = map2.get(str)) != null && (tiVar instanceof pi)) {
            return ((pi) tiVar).e(i, bool, map);
        }
        return f(i, bool.booleanValue());
    }

    @Override // defpackage.si
    public void d(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("monitorPoints");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("monitorPoint");
                    if (xi.a(string)) {
                        ti tiVar = this.c.get(string);
                        if (tiVar == null) {
                            tiVar = new pi(string, this.d, this.e);
                            this.c.put(string, tiVar);
                        }
                        tiVar.d(jSONObject2);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public boolean f(int i, boolean z) {
        return z ? i < this.d : i < this.e;
    }

    @Override // defpackage.li
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        int i = this.a;
        this.d = i;
        this.e = i;
        try {
            Integer valueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (valueOf != null) {
                this.d = valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt("failSampling"));
            if (valueOf2 != null) {
                this.e = valueOf2.intValue();
            }
            vj.c("AlarmModuleSampling", "[updateSelfSampling]", jSONObject, "successSampling:", valueOf, "failSampling");
        } catch (Exception e) {
        }
    }
}
