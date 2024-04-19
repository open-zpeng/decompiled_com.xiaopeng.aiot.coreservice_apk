package defpackage;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: AlarmMonitorPointSampling.java */
/* renamed from: pi  reason: default package */
/* loaded from: classes.dex */
public class pi extends ti {
    public int d;
    public int e;

    @Override // defpackage.ti
    public /* bridge */ /* synthetic */ boolean c(int i, Map map) {
        return super.c(i, map);
    }

    public pi(String str, int i, int i2) {
        super(str, 0);
        this.d = i;
        this.e = i2;
    }

    public boolean e(int i, Boolean bool, Map<String, String> map) {
        vj.c("AlarmMonitorPointSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.d), "failSampling:", Integer.valueOf(this.e));
        List<ni> list = this.c;
        if (list != null && map != null) {
            for (ni niVar : list) {
                Boolean c = niVar.c(i, map);
                if (c != null) {
                    return c.booleanValue();
                }
            }
        }
        return f(i, bool.booleanValue());
    }

    public boolean f(int i, boolean z) {
        return z ? i < this.d : i < this.e;
    }

    @Override // defpackage.ti
    public void d(JSONObject jSONObject) {
        super.d(jSONObject);
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
            vj.c("AlarmMonitorPointSampling", "[updateSelfSampling]", jSONObject, "successSampling:", valueOf, "failSampling", valueOf2);
        } catch (Exception e) {
        }
    }
}
