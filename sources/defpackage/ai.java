package defpackage;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: StatEvent.java */
/* renamed from: ai  reason: default package */
/* loaded from: classes.dex */
public class ai extends xh {
    public Metric g;
    public Map<DimensionValueSet, a> h;

    public synchronized void c(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        a aVar;
        boolean z;
        if (dimensionValueSet == null) {
            DimensionValueSet dimensionValueSet2 = (DimensionValueSet) fi.a().b(DimensionValueSet.class, new Object[0]);
            dimensionValueSet2.addValues(dimensionValueSet);
            dimensionValueSet = dimensionValueSet2;
        }
        if (!this.h.containsKey(dimensionValueSet)) {
            DimensionValueSet dimensionValueSet3 = (DimensionValueSet) fi.a().b(DimensionValueSet.class, new Object[0]);
            dimensionValueSet3.addValues(dimensionValueSet);
            a aVar2 = new a();
            this.h.put(dimensionValueSet3, aVar2);
            aVar = aVar2;
        } else {
            aVar = this.h.get(dimensionValueSet);
        }
        Metric metric = this.g;
        if (metric == null) {
            z = false;
        } else {
            z = metric.valid(dimensionValueSet, measureValueSet);
        }
        if (z) {
            aVar.f();
            aVar.d(measureValueSet);
        } else {
            aVar.g();
            if (this.g.isCommitDetail()) {
                aVar.d(measureValueSet);
            }
        }
        vj.c("StatEvent", "entity  count:", Integer.valueOf(aVar.a), " noise:", Integer.valueOf(aVar.b));
    }

    @Override // defpackage.xh
    public synchronized JSONObject a() {
        JSONObject a2;
        Set<String> keySet;
        a2 = super.a();
        try {
            Metric metric = this.g;
            if (metric != null) {
                a2.put("isCommitDetail", String.valueOf(metric.isCommitDetail()));
            }
            JSONArray jSONArray = (JSONArray) fi.a().b(ii.class, new Object[0]);
            Map<DimensionValueSet, a> map = this.h;
            if (map != null) {
                for (Map.Entry<DimensionValueSet, a> entry : map.entrySet()) {
                    JSONObject jSONObject = (JSONObject) fi.a().b(ji.class, new Object[0]);
                    DimensionValueSet key = entry.getKey();
                    a value = entry.getValue();
                    Object valueOf = Integer.valueOf(value.a);
                    Object valueOf2 = Integer.valueOf(value.b);
                    jSONObject.put("count", valueOf);
                    jSONObject.put("noise", valueOf2);
                    jSONObject.put("dimensions", key != null ? new JSONObject(key.getMap()) : "");
                    List<Map<String, Map<String, Double>>> c = value.c();
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < c.size(); i++) {
                        JSONObject jSONObject2 = new JSONObject();
                        Map<String, Map<String, Double>> map2 = c.get(i);
                        if (map2 != null && (keySet = map2.keySet()) != null) {
                            for (String str : keySet) {
                                if (map2.get(str) != null) {
                                    jSONObject2.put(str, new JSONObject(map2.get(str)));
                                } else {
                                    jSONObject2.put(str, "");
                                }
                            }
                        }
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("measures", jSONArray2);
                    jSONArray.put(jSONObject);
                }
            }
            a2.put("values", jSONArray);
        } catch (Exception e) {
        }
        return a2;
    }

    @Override // defpackage.xh, defpackage.gi
    public synchronized void clean() {
        super.clean();
        this.g = null;
        for (DimensionValueSet dimensionValueSet : this.h.keySet()) {
            fi.a().d(dimensionValueSet);
        }
        this.h.clear();
    }

    @Override // defpackage.xh, defpackage.gi
    public void fill(Object... params) {
        super.fill(params);
        if (this.h == null) {
            this.h = new HashMap();
        }
        this.g = MetricRepo.getRepo().getMetric(this.a, this.b);
    }

    /* compiled from: StatEvent.java */
    /* renamed from: ai$a */
    /* loaded from: classes.dex */
    public class a {
        public int a = 0;
        public int b = 0;
        public List<MeasureValueSet> c = new ArrayList();

        public a() {
        }

        public void d(MeasureValueSet measureValueSet) {
            if (measureValueSet != null) {
                if (ai.this.g != null && ai.this.g.isCommitDetail()) {
                    this.c.add(b(measureValueSet));
                } else if (this.c.isEmpty()) {
                    this.c.add(b(measureValueSet));
                } else {
                    this.c.get(0).merge(measureValueSet);
                }
            }
        }

        public final MeasureValueSet b(MeasureValueSet measureValueSet) {
            List<Measure> measures;
            MeasureValueSet measureValueSet2 = (MeasureValueSet) fi.a().b(MeasureValueSet.class, new Object[0]);
            if (ai.this.g != null && ai.this.g.getMeasureSet() != null && (measures = ai.this.g.getMeasureSet().getMeasures()) != null) {
                int size = measures.size();
                for (int i = 0; i < size; i++) {
                    Measure measure = measures.get(i);
                    if (measure != null) {
                        MeasureValue measureValue = (MeasureValue) fi.a().b(MeasureValue.class, new Object[0]);
                        MeasureValue value = measureValueSet.getValue(measure.getName());
                        if (value.getOffset() != null) {
                            measureValue.setOffset(value.getOffset().doubleValue());
                        }
                        measureValue.setValue(value.getValue());
                        measureValueSet2.setValue(measure.getName(), measureValue);
                    }
                }
            }
            return measureValueSet2;
        }

        public List<Map<String, Map<String, Double>>> c() {
            Map<String, MeasureValue> map;
            List<MeasureValueSet> list = this.c;
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                MeasureValueSet measureValueSet = this.c.get(i);
                if (measureValueSet != null && (map = measureValueSet.getMap()) != null && !map.isEmpty()) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, MeasureValue> entry : map.entrySet()) {
                        HashMap hashMap2 = new HashMap();
                        String key = entry.getKey();
                        MeasureValue value = entry.getValue();
                        hashMap2.put("value", Double.valueOf(value.getValue()));
                        if (value.getOffset() != null) {
                            hashMap2.put("offset", value.getOffset());
                        }
                        hashMap.put(key, hashMap2);
                    }
                    arrayList.add(hashMap);
                }
            }
            return arrayList;
        }

        public void f() {
            this.a++;
        }

        public void g() {
            this.b++;
        }
    }
}
