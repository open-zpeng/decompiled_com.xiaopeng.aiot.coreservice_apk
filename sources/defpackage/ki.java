package defpackage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: UploadTask.java */
/* renamed from: ki  reason: default package */
/* loaded from: classes.dex */
public class ki implements Runnable {
    public static boolean a = false;
    public static Map<Integer, ki> b;
    public int d;
    public int f;
    public long g = System.currentTimeMillis();

    public static void e() {
        zh[] values;
        if (!a) {
            vj.c("CommitTask", "init StatisticsAlarmEvent");
            b = new ConcurrentHashMap();
            for (zh zhVar : zh.values()) {
                if (zhVar.k()) {
                    int a2 = zhVar.a();
                    ki kiVar = new ki(a2, zhVar.g() * 1000);
                    b.put(Integer.valueOf(a2), kiVar);
                    ek.a().e(a(a2), kiVar, kiVar.d);
                }
            }
            a = true;
        }
    }

    public static void d() {
        for (zh zhVar : zh.values()) {
            ek.a().i(a(zhVar.a()));
        }
        a = false;
        b = null;
    }

    public static void b(int i, int i2) {
        vj.c("CommitTask", "[setStatisticsInterval] eventId" + i + " statisticsInterval:" + i2);
        synchronized (b) {
            ki kiVar = b.get(Integer.valueOf(i));
            if (kiVar == null) {
                if (i2 > 0) {
                    ki kiVar2 = new ki(i, i2 * 1000);
                    b.put(Integer.valueOf(i), kiVar2);
                    vj.c("CommitTask", "post next eventId" + i + ": uploadTask.interval " + kiVar2.d);
                    ek.a().e(a(i), kiVar2, (long) kiVar2.d);
                }
            } else if (i2 > 0) {
                int i3 = i2 * 1000;
                if (kiVar.d != i3) {
                    ek.a().i(a(i));
                    kiVar.d = i3;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = kiVar.d - (currentTimeMillis - kiVar.g);
                    if (j < 0) {
                        j = 0;
                    }
                    vj.c("CommitTask", kiVar + "post next eventId" + i + " next:" + j + "  uploadTask.interval: " + kiVar.d);
                    ek.a().e(a(i), kiVar, j);
                    kiVar.g = currentTimeMillis;
                }
            } else {
                vj.c("CommitTask", "uploadTasks.size:" + b.size());
                b.remove(Integer.valueOf(i));
                vj.c("CommitTask", "uploadTasks.size:" + b.size());
            }
        }
    }

    public ki(int i, int i2) {
        this.d = 180000;
        this.f = i;
        this.d = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        vj.c("CommitTask", "check&commit event:", Integer.valueOf(this.f));
        yh.b().f(this.f);
        if (b.containsValue(this)) {
            this.g = System.currentTimeMillis();
            vj.c("CommitTask", "next:" + this.f);
            ek.a().e(a(this.f), this, (long) this.d);
        }
    }

    public static void c() {
        for (zh zhVar : zh.values()) {
            yh.b().f(zhVar.a());
        }
    }

    public static int a(int i) {
        switch (i) {
            case 65133:
                return 11;
            case 65501:
                return 6;
            case 65502:
                return 9;
            case 65503:
                return 10;
            default:
                return 0;
        }
    }
}
