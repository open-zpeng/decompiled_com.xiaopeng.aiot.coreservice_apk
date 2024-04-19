package defpackage;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: AlarmSampling.java */
/* renamed from: qi  reason: default package */
/* loaded from: classes.dex */
public class qi extends ri {
    public String e;
    public int f;
    public int g;

    @Override // defpackage.ri
    public /* bridge */ /* synthetic */ boolean c(int i, String str, String str2, Map map) {
        return super.c(i, str, str2, map);
    }

    public qi(zh zhVar, int i) {
        super(zhVar, i);
        this.e = "AlarmSampling";
        this.f = 0;
        this.g = 0;
        this.f = i;
        this.g = i;
    }

    public boolean g(int i, String str, String str2, Boolean bool, Map<String, String> map) {
        si siVar;
        String str3 = this.e;
        vj.c(str3, "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.f), "failSampling:" + this.g);
        Map<String, si> map2 = this.c;
        if (map2 == null || (siVar = map2.get(str)) == null || !(siVar instanceof oi)) {
            return bool.booleanValue() ? i < this.f : i < this.g;
        }
        return ((oi) siVar).e(i, str2, bool, map);
    }

    @Override // defpackage.ri
    public void d(JSONObject jSONObject) {
        a(jSONObject);
        e(jSONObject);
        this.c.clear();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("metrics");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("module");
                    if (xi.a(string)) {
                        si siVar = this.c.get(string);
                        if (siVar == null) {
                            siVar = new oi(string, this.f, this.g);
                            this.c.put(string, siVar);
                        }
                        siVar.d(jSONObject2);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // defpackage.li
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        int i = this.a;
        this.f = i;
        this.g = i;
        try {
            Integer valueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (valueOf != null) {
                this.f = valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt("failSampling"));
            if (valueOf2 != null) {
                this.g = valueOf2.intValue();
            }
        } catch (Exception e) {
        }
    }

    @Override // defpackage.ri
    public void f(int sampling) {
        super.f(sampling);
        this.f = sampling;
        this.g = sampling;
    }
}
