package defpackage;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: Event.java */
/* renamed from: xh  reason: default package */
/* loaded from: classes.dex */
public abstract class xh implements gi {
    public String a;
    public String b;
    public String d;
    public int f;

    public JSONObject a() {
        JSONObject jSONObject = (JSONObject) fi.a().b(ji.class, new Object[0]);
        try {
            jSONObject.put("page", this.a);
            jSONObject.put("monitorPoint", this.b);
            String str = this.d;
            if (str != null) {
                jSONObject.put("arg", str);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    @Override // defpackage.gi
    public void clean() {
        this.f = 0;
        this.a = null;
        this.b = null;
        this.d = null;
    }

    @Override // defpackage.gi
    public void fill(Object... params) {
        this.f = ((Integer) params[0]).intValue();
        this.a = (String) params[1];
        this.b = (String) params[2];
        if (params.length > 3 && params[3] != null) {
            this.d = (String) params[3];
        }
    }
}
