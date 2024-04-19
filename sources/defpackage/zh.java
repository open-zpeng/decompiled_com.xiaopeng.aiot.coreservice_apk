package defpackage;
/* compiled from: EventType.java */
/* renamed from: zh  reason: default package */
/* loaded from: classes.dex */
public enum zh {
    ALARM(65501, 30, "alarmData", 5000),
    COUNTER(65502, 30, "counterData", 5000),
    OFFLINE_COUNTER(65133, 30, "counterData", 5000),
    STAT(65503, 30, "statData", 5000);
    
    public static String g = "EventType";
    public int i;
    public int k;
    public String l;
    public int o;
    public int m = 25;
    public int n = 180;
    public boolean j = true;

    zh(int i, int i2, String str, int i3) {
        this.i = i;
        this.k = i2;
        this.l = str;
        this.o = i3;
    }

    public int a() {
        return this.i;
    }

    public boolean k() {
        return this.j;
    }

    public void f(boolean z) {
        this.j = z;
    }

    public int d() {
        return this.k;
    }

    public void e(int i) {
        String str = g;
        vj.c(str, "[setTriggerCount]", this.l, i + "");
        this.k = i;
    }

    public static zh b(int i) {
        zh[] values;
        for (zh zhVar : values()) {
            if (zhVar != null && zhVar.a() == i) {
                return zhVar;
            }
        }
        return null;
    }

    public String c() {
        return this.l;
    }

    public int g() {
        return this.m;
    }

    public int i() {
        return this.n;
    }

    public void l(int statisticsInterval) {
        this.m = statisticsInterval;
        this.n = statisticsInterval;
    }

    public int j() {
        return this.o;
    }

    public void h(int i) {
        this.o = i;
    }
}
