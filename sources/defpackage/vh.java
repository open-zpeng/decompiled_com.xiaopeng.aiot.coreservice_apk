package defpackage;

import org.json.JSONObject;
/* compiled from: CountEvent.java */
/* renamed from: vh  reason: default package */
/* loaded from: classes.dex */
public class vh extends xh {
    public int g;
    public double h;

    public synchronized void b(double d) {
        this.h += d;
        this.g++;
    }

    @Override // defpackage.xh
    public synchronized JSONObject a() {
        JSONObject a;
        a = super.a();
        try {
            a.put("count", this.g);
            a.put("value", this.h);
        } catch (Exception e) {
        }
        return a;
    }

    @Override // defpackage.xh, defpackage.gi
    public synchronized void fill(Object... params) {
        super.fill(params);
        this.h = 0.0d;
        this.g = 0;
    }
}
