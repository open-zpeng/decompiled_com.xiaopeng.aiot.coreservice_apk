package defpackage;

import android.os.Handler;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* compiled from: XTimeLogs.java */
/* renamed from: tp  reason: default package */
/* loaded from: classes.dex */
public class tp implements Runnable {
    public Handler a = new Handler();
    public LinkedHashMap<String, Long> b = new LinkedHashMap<>();
    public long d;
    public long f;
    public long g;
    public String h;

    public static tp a() {
        return new tp();
    }

    public void d(String name) {
        this.h = name;
        long nanoTime = System.nanoTime();
        this.d = nanoTime;
        this.g = nanoTime;
    }

    public void c(String tag) {
        long t = System.nanoTime() - this.g;
        this.b.put(tag, Long.valueOf(t));
        this.g = System.nanoTime();
    }

    public void b() {
        this.f = System.nanoTime() - this.d;
        this.a.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Set<Map.Entry<String, Long>> sets = this.b.entrySet();
        StringBuilder sb = new StringBuilder();
        sb.append("total:");
        sb.append(this.f / 1000);
        sb.append("μs");
        for (Map.Entry<String, Long> item : sets) {
            sb.append(", ");
            sb.append(item.getKey());
            sb.append(":");
            sb.append(item.getValue().longValue() / 1000);
        }
        this.b.clear();
        rq.a(this.h, sb.toString());
    }
}
