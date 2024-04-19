package defpackage;

import org.json.JSONObject;
/* compiled from: AbstractSampling.java */
/* renamed from: li  reason: default package */
/* loaded from: classes.dex */
public abstract class li<T extends JSONObject> {
    public int a;

    public li(int i) {
        this.a = i;
    }

    public void a(T t) {
        try {
            Integer valueOf = Integer.valueOf(t.getInt("sampling"));
            if (valueOf != null) {
                this.a = valueOf.intValue();
            }
        } catch (Exception e) {
        }
    }

    public boolean b(int i) {
        return i < this.a;
    }
}
