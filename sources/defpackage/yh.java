package defpackage;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.appmonitor.model.MetricValueSet;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.log.model.LogField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: EventRepo.java */
/* renamed from: yh  reason: default package */
/* loaded from: classes.dex */
public class yh {
    public static yh a;
    public AtomicInteger d = new AtomicInteger(0);
    public AtomicInteger e = new AtomicInteger(0);
    public AtomicInteger f = new AtomicInteger(0);
    public Map<UTDimensionValueSet, MetricValueSet> c = new ConcurrentHashMap();
    public Map<String, wh> b = new ConcurrentHashMap();

    public static synchronized yh b() {
        yh yhVar;
        synchronized (yh.class) {
            if (a == null) {
                a = new yh();
            }
            yhVar = a;
        }
        return yhVar;
    }

    public final UTDimensionValueSet c(int i, Map<String, String> map) {
        UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) fi.a().b(UTDimensionValueSet.class, new Object[0]);
        if (map != null) {
            uTDimensionValueSet.setMap(map);
        }
        uTDimensionValueSet.setValue(LogField.ACCESS.toString(), ej.e());
        uTDimensionValueSet.setValue(LogField.ACCESS_SUBTYPE.toString(), ej.f());
        uTDimensionValueSet.setValue(LogField.USERID.toString(), ej.g());
        uTDimensionValueSet.setValue(LogField.USERNICK.toString(), ej.h());
        uTDimensionValueSet.setValue(LogField.EVENTID.toString(), String.valueOf(i));
        return uTDimensionValueSet;
    }

    public void j(int i, String str, String str2, String str3, Map<String, String> map) {
        UTDimensionValueSet c = c(i, map);
        ((uh) a(c, str, str2, str3, uh.class)).c();
        if (zi.h()) {
            uh uhVar = (uh) fi.a().b(uh.class, Integer.valueOf(i), str, str2, str3);
            uhVar.c();
            yi.b(c, uhVar);
        }
        k(zh.b(i), this.d);
    }

    public void i(int i, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        UTDimensionValueSet c = c(i, map);
        uh uhVar = (uh) a(c, str, str2, str3, uh.class);
        uhVar.d();
        uhVar.b(str4, str5);
        if (zi.h()) {
            uh uhVar2 = (uh) fi.a().b(uh.class, Integer.valueOf(i), str, str2, str3);
            uhVar2.d();
            uhVar2.b(str4, str5);
            yi.b(c, uhVar2);
        }
        k(zh.b(i), this.d);
    }

    public void h(int i, String str, String str2, String str3, double d, Map<String, String> map) {
        UTDimensionValueSet c = c(i, map);
        ((vh) a(c, str, str2, str3, vh.class)).b(d);
        if (zi.h()) {
            vh vhVar = (vh) fi.a().b(vh.class, Integer.valueOf(i), str, str2, str3);
            vhVar.b(d);
            yi.b(c, vhVar);
        }
        k(zh.b(i), this.e);
    }

    public void g(int i, String str, String str2, MeasureValueSet measureValueSet, DimensionValueSet dimensionValueSet, Map<String, String> map) {
        Metric metric = MetricRepo.getRepo().getMetric(str, str2);
        if (metric != null) {
            if (metric.getDimensionSet() != null) {
                metric.getDimensionSet().setConstantValue(dimensionValueSet);
            }
            if (metric.getMeasureSet() != null) {
                metric.getMeasureSet().setConstantValue(measureValueSet);
            }
            UTDimensionValueSet c = c(i, map);
            ((ai) a(c, str, str2, null, ai.class)).c(dimensionValueSet, measureValueSet);
            if (zi.h()) {
                ai aiVar = (ai) fi.a().b(ai.class, Integer.valueOf(i), str, str2);
                aiVar.c(dimensionValueSet, measureValueSet);
                yi.b(c, aiVar);
            }
            k(zh.b(i), this.f);
            return;
        }
        vj.a("EventRepo", "metric is null");
    }

    public void l(Integer num, String str, String str2, String str3) {
        String d = d(str, str2);
        if (d != null) {
            n(d, num, str, str2, str3);
        }
    }

    public void n(String str, Integer num, String str2, String str3, String str4) {
        wh whVar;
        Metric metric = MetricRepo.getRepo().getMetric(str2, str3);
        if (metric != null && metric.getMeasureSet() != null && metric.getMeasureSet().getMeasure(str4) != null) {
            synchronized (wh.class) {
                whVar = this.b.get(str);
                if (whVar == null) {
                    whVar = (wh) fi.a().b(wh.class, num, str2, str3);
                    this.b.put(str, whVar);
                }
            }
            whVar.e(str4);
        }
    }

    public void o(String str, String str2, String str3) {
        String d = d(str, str2);
        if (d != null) {
            p(d, str3, true, null);
        }
    }

    public void p(String str, String str2, boolean z, Map<String, String> map) {
        wh whVar = this.b.get(str);
        if (whVar != null && whVar.f(str2)) {
            this.b.remove(str);
            if (z) {
                q(whVar.a, whVar.b);
            }
            g(whVar.f, whVar.a, whVar.b, whVar.c(), whVar.b(), map);
            fi.a().d(whVar);
        }
    }

    public void m(String str, Integer num, String str2, String str3, DimensionValueSet dimensionValueSet) {
        wh whVar;
        synchronized (wh.class) {
            whVar = this.b.get(str);
            if (whVar == null) {
                whVar = (wh) fi.a().b(wh.class, num, str2, str3);
                this.b.put(str, whVar);
            }
        }
        whVar.d(dimensionValueSet);
    }

    public final String d(String str, String str2) {
        Metric metric = MetricRepo.getRepo().getMetric(str, str2);
        if (metric != null) {
            return metric.getTransactionId();
        }
        return null;
    }

    public final void q(String str, String str2) {
        Metric metric = MetricRepo.getRepo().getMetric(str, str2);
        if (metric != null) {
            metric.resetTransactionId();
        }
    }

    public final xh a(UTDimensionValueSet uTDimensionValueSet, String str, String str2, String str3, Class<? extends xh> cls) {
        Integer eventId;
        MetricValueSet metricValueSet;
        if (xi.a(str) && xi.a(str2) && (eventId = uTDimensionValueSet.getEventId()) != null) {
            synchronized (this.c) {
                metricValueSet = this.c.get(uTDimensionValueSet);
                if (metricValueSet == null) {
                    metricValueSet = (MetricValueSet) fi.a().b(MetricValueSet.class, new Object[0]);
                    this.c.put(uTDimensionValueSet, metricValueSet);
                }
            }
            return metricValueSet.getEvent(eventId, str, str2, str3, cls);
        }
        return null;
    }

    public final void k(zh zhVar, AtomicInteger atomicInteger) {
        int incrementAndGet = atomicInteger.incrementAndGet();
        vj.d("EventRepo", zhVar.toString(), " EVENT size:", String.valueOf(incrementAndGet));
        if (incrementAndGet >= zhVar.d()) {
            vj.c("EventRepo", zhVar.toString(), " event size exceed trigger count.");
            atomicInteger.set(0);
            f(zhVar.a());
        }
    }

    public Map<UTDimensionValueSet, List<xh>> e(int i) {
        HashMap hashMap = new HashMap();
        synchronized (this.c) {
            ArrayList arrayList = new ArrayList(this.c.keySet());
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) arrayList.get(i2);
                if (uTDimensionValueSet != null && uTDimensionValueSet.getEventId().intValue() == i) {
                    hashMap.put(uTDimensionValueSet, this.c.get(uTDimensionValueSet).getEvents());
                    this.c.remove(uTDimensionValueSet);
                }
            }
        }
        return hashMap;
    }

    public void r() {
        ArrayList arrayList = new ArrayList(this.b.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            wh whVar = this.b.get(str);
            if (whVar != null && whVar.g()) {
                this.b.remove(str);
            }
        }
    }

    /* compiled from: EventRepo.java */
    /* renamed from: yh$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Map a;

        public a(Map map) {
            this.a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            yi.d(this.a);
        }
    }

    public void f(int i) {
        ek.a().g(new a(e(i)));
    }
}
