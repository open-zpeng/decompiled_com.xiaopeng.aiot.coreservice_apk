package defpackage;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.cache.DiskLruCache;
/* compiled from: AppMonitorDelegate.java */
/* renamed from: nh  reason: default package */
/* loaded from: classes.dex */
public final class nh {
    public static Application b;
    public static boolean a = false;
    public static volatile boolean c = false;

    public static synchronized void c(Application application) {
        synchronized (nh.class) {
            vj.c("AppMonitorDelegate", "start init");
            if (!c) {
                b = application;
                ej.b(application.getApplicationContext());
                ei.b();
                ki.e();
                th.b(application);
                yj.d(application.getApplicationContext());
                c = true;
            }
        }
    }

    public static synchronized void a() {
        synchronized (nh.class) {
            try {
                vj.c("AppMonitorDelegate", "start destory");
                if (c) {
                    ki.c();
                    ki.d();
                    ei.a();
                    Application application = b;
                    if (application != null) {
                        yj.e(application.getApplicationContext());
                    }
                    c = false;
                }
            } finally {
            }
        }
    }

    public static synchronized void m() {
        synchronized (nh.class) {
            try {
                vj.c("AppMonitorDelegate", "triggerUpload");
                if (c && zi.j()) {
                    ki.c();
                }
            } finally {
            }
        }
    }

    public static void k(int statisticsInterval) {
        zh[] values;
        for (zh zhVar : zh.values()) {
            zhVar.l(statisticsInterval);
            l(zhVar, statisticsInterval);
        }
    }

    public static void j(int sampling) {
        zh[] values;
        vj.c("AppMonitorDelegate", "[setSampling]");
        for (zh zhVar : zh.values()) {
            zhVar.h(sampling);
            ui.a().c(zhVar, sampling);
        }
    }

    public static void b(boolean open) {
        vj.c("AppMonitorDelegate", "[enableLog]");
        vj.e(open);
    }

    public static void d(String module, String monitorPoint, MeasureSet measures) {
        e(module, monitorPoint, measures, null);
    }

    public static void g(String module, String monitorPoint, MeasureSet measures, boolean isCommitDetail) {
        f(module, monitorPoint, measures, null, isCommitDetail);
    }

    public static void e(String module, String monitorPoint, MeasureSet measures, DimensionSet dimensions) {
        f(module, monitorPoint, measures, dimensions, false);
    }

    public static void f(String module, String monitorPoint, MeasureSet measures, DimensionSet dimensions, boolean isCommitDetail) {
        try {
            if (c) {
                if (!xi.b(module) && !xi.b(monitorPoint)) {
                    MetricRepo.getRepo().add(new Metric(module, monitorPoint, measures, dimensions, isCommitDetail));
                    return;
                }
                vj.c("AppMonitorDelegate", "register stat event. module: ", module, " monitorPoint: ", monitorPoint);
                if (a) {
                    throw new ci("register error. module and monitorPoint can't be null");
                }
            }
        } catch (Throwable th) {
            di.d(th);
        }
    }

    /* compiled from: AppMonitorDelegate.java */
    /* renamed from: nh$a */
    /* loaded from: classes.dex */
    public static class a {
        public static void g(int statisticsInterval) {
            zh zhVar = zh.ALARM;
            zhVar.l(statisticsInterval);
            nh.l(zhVar, statisticsInterval);
        }

        public static void f(int sampling) {
            ui.a().c(zh.ALARM, sampling);
        }

        @Deprecated
        public static boolean a(String module, String monitorPoint) {
            return ui.d(zh.ALARM, module, monitorPoint);
        }

        public static void e(String module, String monitorPoint, Map<String, String> exta) {
            d(module, monitorPoint, null, exta);
        }

        public static void d(String module, String monitorPoint, String arg, Map<String, String> exta) {
            try {
                if (!TextUtils.isEmpty(module) && !TextUtils.isEmpty(monitorPoint)) {
                    fj.a();
                    if (nh.c && zi.j()) {
                        zh zhVar = zh.ALARM;
                        if (zhVar.k() && (nh.a || ui.f(module, monitorPoint, true, null))) {
                            vj.c("AppMonitorDelegate", "commitSuccess module:", module, " monitorPoint:", monitorPoint);
                            fj.b();
                            yh.b().j(zhVar.a(), module, monitorPoint, arg, exta);
                            return;
                        }
                    }
                    vj.a("log discard !", "");
                    return;
                }
                vj.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                di.d(th);
            }
        }

        public static void c(String module, String monitorPoint, String errorCode, String errorMsg, Map<String, String> exta) {
            b(module, monitorPoint, null, errorCode, errorMsg, exta);
        }

        public static void b(String module, String monitorPoint, String arg, String errorCode, String errorMsg, Map<String, String> exta) {
            try {
                if (!TextUtils.isEmpty(module) && !TextUtils.isEmpty(monitorPoint)) {
                    fj.a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("_status", "0");
                    if (nh.c && zi.j()) {
                        zh zhVar = zh.ALARM;
                        if (zhVar.k() && (nh.a || ui.f(module, monitorPoint, false, hashMap))) {
                            vj.c("AppMonitorDelegate", "commitFail module:", module, " monitorPoint:", monitorPoint, " errorCode:", errorCode, "errorMsg:", errorMsg);
                            fj.b();
                            yh.b().i(zhVar.a(), module, monitorPoint, arg, errorCode, errorMsg, exta);
                            return;
                        }
                    }
                    vj.a("log discard !", "");
                    return;
                }
                vj.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                di.d(th);
            }
        }
    }

    /* compiled from: AppMonitorDelegate.java */
    /* renamed from: nh$b */
    /* loaded from: classes.dex */
    public static class b {
        public static void e(int statisticsInterval) {
            zh zhVar = zh.COUNTER;
            zhVar.l(statisticsInterval);
            nh.l(zhVar, statisticsInterval);
        }

        public static void d(int sampling) {
            ui.a().c(zh.COUNTER, sampling);
        }

        @Deprecated
        public static boolean a(String module, String monitorPoint) {
            return ui.d(zh.COUNTER, module, monitorPoint);
        }

        public static void b(String module, String monitorPoint, double value, Map<String, String> exta) {
            c(module, monitorPoint, null, value, exta);
        }

        public static void c(String module, String monitorPoint, String arg, double value, Map<String, String> exta) {
            try {
                if (!TextUtils.isEmpty(module) && !TextUtils.isEmpty(monitorPoint)) {
                    fj.q();
                    if (nh.c && zi.j()) {
                        zh zhVar = zh.COUNTER;
                        if (zhVar.k() && (nh.a || ui.d(zhVar, module, monitorPoint))) {
                            vj.c("AppMonitorDelegate", "commitCount module: ", module, " monitorPoint: ", monitorPoint, " value: ", Double.valueOf(value));
                            fj.r();
                            yh.b().h(zhVar.a(), module, monitorPoint, arg, value, exta);
                        }
                    }
                    return;
                }
                vj.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                di.d(th);
            }
        }
    }

    /* compiled from: AppMonitorDelegate.java */
    /* renamed from: nh$c */
    /* loaded from: classes.dex */
    public static class c {
        public static void d(int statisticsInterval) {
            zh zhVar = zh.OFFLINE_COUNTER;
            zhVar.l(statisticsInterval);
            nh.l(zhVar, statisticsInterval);
        }

        public static void c(int sampling) {
            ui.a().c(zh.OFFLINE_COUNTER, sampling);
        }

        @Deprecated
        public static boolean a(String module, String monitorPoint) {
            return ui.d(zh.OFFLINE_COUNTER, module, monitorPoint);
        }

        public static void b(String module, String monitorPoint, double value) {
            try {
                if (!TextUtils.isEmpty(module) && !TextUtils.isEmpty(monitorPoint)) {
                    fj.o();
                    if (nh.c && zi.j()) {
                        zh zhVar = zh.OFFLINE_COUNTER;
                        if (zhVar.k() && (nh.a || ui.d(zhVar, module, monitorPoint))) {
                            vj.c("AppMonitorDelegate", "commitOffLineCount module: ", module, " monitorPoint: ", monitorPoint, " value: ", Double.valueOf(value));
                            fj.p();
                            yh.b().h(zhVar.a(), module, monitorPoint, null, value, null);
                        }
                    }
                    return;
                }
                vj.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                di.d(th);
            }
        }
    }

    /* compiled from: AppMonitorDelegate.java */
    /* renamed from: nh$d */
    /* loaded from: classes.dex */
    public static class d {
        public static void h(int statisticsInterval) {
            zh zhVar = zh.STAT;
            zhVar.l(statisticsInterval);
            nh.l(zhVar, statisticsInterval);
        }

        public static void g(int sampling) {
            ui.a().c(zh.STAT, sampling);
        }

        @Deprecated
        public static boolean b(String module, String monitorPoint) {
            return ui.d(zh.STAT, module, monitorPoint);
        }

        public static void a(String module, String monitorPoint, String measureName) {
            try {
                if (nh.c && zi.j()) {
                    zh zhVar = zh.STAT;
                    if (zhVar.k()) {
                        if (nh.a || ui.d(zhVar, module, monitorPoint)) {
                            vj.c("AppMonitorDelegate", "statEvent begin. module: ", module, " monitorPoint: ", monitorPoint, " measureName: ", measureName);
                            yh.b().l(Integer.valueOf(zhVar.a()), module, monitorPoint, measureName);
                        }
                    }
                }
            } catch (Throwable th) {
                di.d(th);
            }
        }

        public static void f(String module, String monitorPoint, String measureName) {
            try {
                if (nh.c && zi.j()) {
                    zh zhVar = zh.STAT;
                    if (zhVar.k()) {
                        if (nh.a || ui.d(zhVar, module, monitorPoint)) {
                            vj.c("AppMonitorDelegate", "statEvent end. module: ", module, " monitorPoint: ", monitorPoint, " measureName: ", measureName);
                            yh.b().o(module, monitorPoint, measureName);
                        }
                    }
                }
            } catch (Throwable th) {
                di.d(th);
            }
        }

        public static void c(String module, String monitorPoint, double value, Map<String, String> exta) {
            d(module, monitorPoint, null, value, exta);
        }

        public static void d(String module, String monitorPoint, DimensionValueSet dimensionValues, double value, Map<String, String> exta) {
            try {
                if (!TextUtils.isEmpty(module) && !TextUtils.isEmpty(monitorPoint)) {
                    fj.m();
                    if (nh.c && zi.j()) {
                        zh zhVar = zh.STAT;
                        if (zhVar.k() && (nh.a || ui.d(zhVar, module, monitorPoint))) {
                            vj.c("AppMonitorDelegate", "statEvent commit. module: ", module, " monitorPoint: ", monitorPoint);
                            Metric metric = MetricRepo.getRepo().getMetric(module, monitorPoint);
                            fj.n();
                            if (metric != null) {
                                List<Measure> measures = metric.getMeasureSet().getMeasures();
                                if (measures.size() == 1) {
                                    e(module, monitorPoint, dimensionValues, ((MeasureValueSet) fi.a().b(MeasureValueSet.class, new Object[0])).setValue(measures.get(0).getName(), value), exta);
                                }
                            }
                        }
                    }
                    return;
                }
                vj.a("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                di.d(th);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
            if (defpackage.ui.e(r0, r9, r10, r11 != null ? r11.getMap() : null) != false) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void e(java.lang.String r9, java.lang.String r10, com.alibaba.mtl.appmonitor.model.DimensionValueSet r11, com.alibaba.mtl.appmonitor.model.MeasureValueSet r12, java.util.Map<java.lang.String, java.lang.String> r13) {
            /*
                boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L7a
                if (r0 != 0) goto L72
                boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L7a
                if (r0 == 0) goto Ld
                goto L72
            Ld:
                defpackage.fj.m()     // Catch: java.lang.Throwable -> L7a
                boolean r0 = defpackage.nh.c     // Catch: java.lang.Throwable -> L7a
                r1 = 3
                java.lang.String r2 = " monitorPoint: "
                r3 = 2
                r4 = 1
                r5 = 0
                r6 = 4
                if (r0 == 0) goto L60
                boolean r0 = defpackage.zi.j()     // Catch: java.lang.Throwable -> L7a
                if (r0 == 0) goto L60
                zh r0 = defpackage.zh.STAT     // Catch: java.lang.Throwable -> L7a
                boolean r7 = r0.k()     // Catch: java.lang.Throwable -> L7a
                if (r7 == 0) goto L60
                boolean r7 = defpackage.nh.a     // Catch: java.lang.Throwable -> L7a
                if (r7 != 0) goto L3b
                if (r11 == 0) goto L34
                java.util.Map r7 = r11.getMap()     // Catch: java.lang.Throwable -> L7a
                goto L35
            L34:
                r7 = 0
            L35:
                boolean r7 = defpackage.ui.e(r0, r9, r10, r7)     // Catch: java.lang.Throwable -> L7a
                if (r7 == 0) goto L60
            L3b:
                java.lang.String r7 = "statEvent commit success"
                java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L7a
                java.lang.String r8 = "statEvent commit. module: "
                r6[r5] = r8     // Catch: java.lang.Throwable -> L7a
                r6[r4] = r9     // Catch: java.lang.Throwable -> L7a
                r6[r3] = r2     // Catch: java.lang.Throwable -> L7a
                r6[r1] = r10     // Catch: java.lang.Throwable -> L7a
                defpackage.vj.c(r7, r6)     // Catch: java.lang.Throwable -> L7a
                defpackage.fj.n()     // Catch: java.lang.Throwable -> L7a
                yh r1 = defpackage.yh.b()     // Catch: java.lang.Throwable -> L7a
                int r2 = r0.a()     // Catch: java.lang.Throwable -> L7a
                r3 = r9
                r4 = r10
                r5 = r12
                r6 = r11
                r7 = r13
                r1.g(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7a
                goto L71
            L60:
                java.lang.String r0 = "statEvent commit failed,log discard"
                java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L7a
                java.lang.String r7 = " ,. module: "
                r6[r5] = r7     // Catch: java.lang.Throwable -> L7a
                r6[r4] = r9     // Catch: java.lang.Throwable -> L7a
                r6[r3] = r2     // Catch: java.lang.Throwable -> L7a
                r6[r1] = r10     // Catch: java.lang.Throwable -> L7a
                defpackage.vj.c(r0, r6)     // Catch: java.lang.Throwable -> L7a
            L71:
                goto L7e
            L72:
                java.lang.String r0 = "AppMonitorDelegate"
                java.lang.String r1 = "module & monitorPoint must not null"
                defpackage.vj.a(r0, r1)     // Catch: java.lang.Throwable -> L7a
                return
            L7a:
                r0 = move-exception
                defpackage.di.d(r0)
            L7e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.nh.d.e(java.lang.String, java.lang.String, com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.model.MeasureValueSet, java.util.Map):void");
        }
    }

    public static void l(zh eventType, int statisticsInterval) {
        try {
            if (c && eventType != null) {
                ki.b(eventType.a(), statisticsInterval);
                if (statisticsInterval > 0) {
                    eventType.f(true);
                } else {
                    eventType.f(false);
                }
            }
        } catch (Throwable th) {
            di.d(th);
        }
    }

    public static void i(boolean isSecurity, String appkey, String secret, String authcode) {
        jk ikVar;
        if (isSecurity) {
            ikVar = new kk(appkey, authcode);
        } else {
            boolean z = false;
            if (DiskLruCache.VERSION_1.equalsIgnoreCase(authcode)) {
                z = true;
            }
            ikVar = new ik(appkey, secret, z);
        }
        ej.c(ikVar);
        zi.d(b);
    }

    public static void h(String channel) {
        ej.m(channel);
    }

    public static void o(Map<String, String> params) {
        zi.p(params);
    }

    public static void n() {
        vj.c("AppMonitorDelegate", "[turnOffRealTimeDebug]");
    }
}
