package defpackage;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;
/* compiled from: SampleRules.java */
/* renamed from: ui  reason: default package */
/* loaded from: classes.dex */
public class ui {
    public static final String a = null;
    public static ui b;
    public Map<zh, ri> c = new HashMap();
    public int d;
    public String e;

    public ui() {
        zh[] values;
        for (zh zhVar : zh.values()) {
            if (zhVar == zh.ALARM) {
                this.c.put(zhVar, new qi(zhVar, zhVar.j()));
            } else {
                this.c.put(zhVar, new ri(zhVar, zhVar.j()));
            }
        }
    }

    public static ui a() {
        if (b == null) {
            synchronized (ui.class) {
                if (b == null) {
                    b = new ui();
                }
            }
        }
        return b;
    }

    public void b(Context context) {
        j();
    }

    public static boolean d(zh zhVar, String str, String str2) {
        return a().h(zhVar, str, str2, null);
    }

    public static boolean e(zh zhVar, String str, String str2, Map<String, String> map) {
        return a().h(zhVar, str, str2, map);
    }

    public static boolean f(String str, String str2, Boolean bool, Map<String, String> map) {
        return a().i(str, str2, bool, map);
    }

    public boolean h(zh zhVar, String str, String str2, Map<String, String> map) {
        ri riVar = this.c.get(zhVar);
        if (riVar != null) {
            return riVar.c(this.d, str, str2, map);
        }
        return false;
    }

    public boolean i(String str, String str2, Boolean bool, Map<String, String> map) {
        ri riVar = this.c.get(zh.ALARM);
        if (riVar != null && (riVar instanceof qi)) {
            return ((qi) riVar).g(this.d, str, str2, bool, map);
        }
        return false;
    }

    public void j() {
        this.d = new Random(System.currentTimeMillis()).nextInt(10000);
    }

    public void g(String str) {
        String str2;
        zh[] values;
        vj.c("SampleRules", "config:", str);
        synchronized (this) {
            if (!xi.b(str) && ((str2 = this.e) == null || !str2.equals(str))) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    for (zh zhVar : zh.values()) {
                        JSONObject optJSONObject = jSONObject.optJSONObject(zhVar.toString());
                        ri riVar = this.c.get(zhVar);
                        if (optJSONObject != null && riVar != null) {
                            vj.c(a, zhVar, optJSONObject);
                            riVar.d(optJSONObject);
                        }
                    }
                    this.e = str;
                } catch (Throwable th) {
                }
            }
        }
    }

    public void c(zh zhVar, int i) {
        ri riVar = this.c.get(zhVar);
        if (riVar != null) {
            riVar.f(i);
        }
    }
}
