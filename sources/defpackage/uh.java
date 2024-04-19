package defpackage;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: AlarmEvent.java */
/* renamed from: uh  reason: default package */
/* loaded from: classes.dex */
public class uh extends xh {
    public int g = 0;
    public int h = 0;
    public Map<String, String> i;
    public Map<String, Integer> j;

    public synchronized void c() {
        this.g++;
    }

    public synchronized void d() {
        this.h++;
    }

    public synchronized void b(String str, String str2) {
        if (xi.b(str)) {
            return;
        }
        if (this.i == null) {
            this.i = new HashMap();
        }
        if (this.j == null) {
            this.j = new HashMap();
        }
        if (xi.a(str2)) {
            int i = 100;
            if (str2.length() <= 100) {
                i = str2.length();
            }
            this.i.put(str, str2.substring(0, i));
        }
        if (!this.j.containsKey(str)) {
            this.j.put(str, 1);
        } else {
            Map<String, Integer> map = this.j;
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        }
    }

    @Override // defpackage.xh
    public synchronized JSONObject a() {
        JSONObject a;
        a = super.a();
        try {
            a.put("successCount", this.g);
            a.put("failCount", this.h);
            if (this.j != null) {
                JSONArray jSONArray = (JSONArray) fi.a().b(ii.class, new Object[0]);
                for (Map.Entry<String, Integer> entry : this.j.entrySet()) {
                    JSONObject jSONObject = (JSONObject) fi.a().b(ji.class, new Object[0]);
                    String key = entry.getKey();
                    jSONObject.put("errorCode", key);
                    jSONObject.put("errorCount", entry.getValue());
                    if (this.i.containsKey(key)) {
                        jSONObject.put("errorMsg", this.i.get(key));
                    }
                    jSONArray.put(jSONObject);
                }
                a.put("errors", jSONArray);
            }
        } catch (Exception e) {
        }
        return a;
    }

    @Override // defpackage.xh, defpackage.gi
    public synchronized void clean() {
        super.clean();
        this.g = 0;
        this.h = 0;
        Map<String, String> map = this.i;
        if (map != null) {
            map.clear();
        }
        Map<String, Integer> map2 = this.j;
        if (map2 != null) {
            map2.clear();
        }
    }
}
