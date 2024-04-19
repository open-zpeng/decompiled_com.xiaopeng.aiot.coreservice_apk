package defpackage;

import java.util.Locale;
/* compiled from: XFpsMonitor.java */
/* renamed from: bq  reason: default package */
/* loaded from: classes.dex */
public class bq {
    public long c;
    public int e;
    public int f;
    public float g;
    public String i;
    public long b = -1;
    public final long a = 1000;
    public long d = -1;
    public String h = "";

    public bq(String tag) {
        this.i = tag;
    }

    public final void b() {
        if (this.d != -1) {
            throw new RuntimeException("Do you forget to call frameEnd? ");
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.d = currentTimeMillis;
        if (this.b == -1) {
            this.b = currentTimeMillis;
        }
    }

    public final String a() {
        if (this.d == -1) {
            throw new RuntimeException("Do you forget to call frameStart? ");
        }
        long end = System.currentTimeMillis();
        this.c += end - this.d;
        int i = this.e + 1;
        this.e = i;
        if (end - this.b > this.a) {
            this.f = i;
            StringBuilder sb = new StringBuilder();
            sb.append(this.e);
            StringBuilder stringBuilder = sb.append(" FPS\t\t");
            this.g = (((float) this.c) * 1.0f) / this.e;
            String s = String.format(Locale.getDefault(), "%.2f", Float.valueOf(this.g));
            stringBuilder.append(s);
            stringBuilder.append(" ms/f");
            String sb2 = stringBuilder.toString();
            this.h = sb2;
            rq.a(this.i, sb2);
            this.c = 0L;
            this.e = 0;
            this.b = end;
        }
        this.d = -1L;
        return this.h;
    }
}
