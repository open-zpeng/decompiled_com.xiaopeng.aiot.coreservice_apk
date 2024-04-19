package defpackage;

import com.xiaopeng.libconfig.ipc.AccountConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: HostConfigMgr.java */
/* renamed from: cj  reason: default package */
/* loaded from: classes.dex */
public class cj {
    public static cj a = new cj();
    public Map<String, bj> b = Collections.synchronizedMap(new HashMap());
    public String c;

    public static cj a() {
        return a;
    }

    public void c(String str) {
        JSONObject jSONObject;
        vj.c("HostConfigMgr", "host config:" + str);
        if (str != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("content");
                if (jSONObject3 != null && (jSONObject = jSONObject3.getJSONObject("hosts")) != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null) {
                            bj bjVar = new bj();
                            JSONObject jSONObject4 = jSONObject.getJSONObject(next);
                            if (jSONObject4 != null) {
                                bjVar.c = next.substring(1);
                                bjVar.a = jSONObject4.getString("host");
                                JSONArray jSONArray = jSONObject4.getJSONArray("eids");
                                if (jSONArray != null) {
                                    bjVar.b = new ArrayList<>();
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        bjVar.b.add(jSONArray.getString(i));
                                    }
                                }
                            }
                            this.b.put(bjVar.c + "", bjVar);
                        }
                    }
                }
                this.c = jSONObject2.getString(AccountConfig.KEY_TIMESTAMP);
            } catch (Throwable th) {
            }
        }
    }

    public Map<String, bj> b() {
        return this.b;
    }
}
