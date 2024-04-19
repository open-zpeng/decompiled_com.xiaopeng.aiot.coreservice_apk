package defpackage;

import com.alibaba.mtl.appmonitor.model.ConfigMetric;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.xiaopeng.lib.apirouter.ClientConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: ModuleSampling.java */
/* renamed from: si  reason: default package */
/* loaded from: classes.dex */
public class si extends li<JSONObject> {
    public String b;
    public Map<String, ti> c;

    public si(String str, int i) {
        super(i);
        this.b = str;
        this.c = new HashMap();
    }

    public boolean c(int i, String str, Map<String, String> map) {
        ti tiVar;
        Map<String, ti> map2 = this.c;
        if (map2 != null && (tiVar = map2.get(str)) != null) {
            return tiVar.c(i, map);
        }
        return b(i);
    }

    public void d(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("monitorPoints");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("monitorPoint");
                    String optString2 = jSONObject2.optString("metric_comment_detail");
                    if (xi.a(optString)) {
                        ti tiVar = this.c.get(optString);
                        if (tiVar == null) {
                            tiVar = new ti(optString, this.a);
                            this.c.put(optString, tiVar);
                        }
                        tiVar.d(jSONObject2);
                        Metric metric = MetricRepo.getRepo().getMetric(this.b, optString);
                        if (metric != null) {
                            metric.setCommitDetailFromConfig(optString2);
                        }
                        Object opt = jSONObject2.opt("measures");
                        if (opt instanceof JSONArray) {
                            JSONArray jSONArray = (JSONArray) opt;
                            MeasureSet create = MeasureSet.create();
                            int length = jSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                                if (jSONObject3 != null) {
                                    String optString3 = jSONObject3.optString(ClientConstants.ALIAS.P_NAME);
                                    Double valueOf = Double.valueOf(jSONObject3.optDouble("min"));
                                    Double valueOf2 = Double.valueOf(jSONObject3.optDouble("max"));
                                    if (optString3 != null && valueOf != null && valueOf2 != null) {
                                        create.addMeasure(new Measure(optString3, Double.valueOf(0.0d), valueOf, valueOf2));
                                    }
                                }
                            }
                            Metric metric2 = MetricRepo.getRepo().getMetric("config_prefix" + this.b, "config_prefix" + optString);
                            if (metric2 != null) {
                                MetricRepo.getRepo().remove(metric2);
                            }
                            MetricRepo.getRepo().add(new ConfigMetric("config_prefix" + this.b, "config_prefix" + optString, create));
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
