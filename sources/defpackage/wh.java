package defpackage;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: DurationEvent.java */
/* renamed from: wh  reason: default package */
/* loaded from: classes.dex */
public class wh extends xh {
    public static final Long g = 300000L;
    public Metric h;
    public MeasureValueSet i;
    public DimensionValueSet j;
    public Map<String, MeasureValue> k;
    public Long l;

    public boolean g() {
        long currentTimeMillis = System.currentTimeMillis();
        List<Measure> measures = this.h.getMeasureSet().getMeasures();
        if (measures != null) {
            int size = measures.size();
            for (int i = 0; i < size; i++) {
                Measure measure = measures.get(i);
                if (measure != null) {
                    double doubleValue = measure.getMax() != null ? measure.getMax().doubleValue() : g.longValue();
                    MeasureValue measureValue = this.k.get(measure.getName());
                    if (measureValue != null && !measureValue.isFinish() && currentTimeMillis - measureValue.getValue() > doubleValue) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void e(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.k.isEmpty()) {
            this.l = Long.valueOf(currentTimeMillis);
        }
        this.k.put(str, (MeasureValue) fi.a().b(MeasureValue.class, Double.valueOf(currentTimeMillis), Double.valueOf(currentTimeMillis - this.l.longValue())));
    }

    public boolean f(String str) {
        MeasureValue measureValue = this.k.get(str);
        if (measureValue != null) {
            double currentTimeMillis = System.currentTimeMillis();
            vj.c("DurationEvent", "statEvent consumeTime. module:", this.a, " monitorPoint:", this.b, " measureName:", str, " time:", Double.valueOf(currentTimeMillis - measureValue.getValue()));
            measureValue.setValue(currentTimeMillis - measureValue.getValue());
            measureValue.setFinish(true);
            this.i.setValue(str, measureValue);
            if (this.h.getMeasureSet().valid(this.i)) {
                return true;
            }
        }
        return false;
    }

    public void d(DimensionValueSet dimensionValueSet) {
        DimensionValueSet dimensionValueSet2 = this.j;
        if (dimensionValueSet2 == null) {
            this.j = dimensionValueSet;
        } else {
            dimensionValueSet2.addValues(dimensionValueSet);
        }
    }

    public MeasureValueSet c() {
        return this.i;
    }

    public DimensionValueSet b() {
        return this.j;
    }

    @Override // defpackage.xh, defpackage.gi
    public void clean() {
        super.clean();
        this.h = null;
        this.l = null;
        for (MeasureValue measureValue : this.k.values()) {
            fi.a().d(measureValue);
        }
        this.k.clear();
        if (this.i != null) {
            fi.a().d(this.i);
            this.i = null;
        }
        if (this.j != null) {
            fi.a().d(this.j);
            this.j = null;
        }
    }

    @Override // defpackage.xh, defpackage.gi
    public void fill(Object... params) {
        super.fill(params);
        if (this.k == null) {
            this.k = new HashMap();
        }
        Metric metric = MetricRepo.getRepo().getMetric(this.a, this.b);
        this.h = metric;
        if (metric.getDimensionSet() != null) {
            this.j = (DimensionValueSet) fi.a().b(DimensionValueSet.class, new Object[0]);
            this.h.getDimensionSet().setConstantValue(this.j);
        }
        this.i = (MeasureValueSet) fi.a().b(MeasureValueSet.class, new Object[0]);
    }
}
