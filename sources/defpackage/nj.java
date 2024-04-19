package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ApiResponseParse.java */
/* renamed from: nj  reason: default package */
/* loaded from: classes.dex */
public class nj {
    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("success")) {
                String string = jSONObject.getString("success");
                if (!TextUtils.isEmpty(string) && string.equals("success")) {
                    aVar.b = true;
                }
            }
            if (jSONObject.has("ret")) {
                aVar.c = jSONObject.getString("ret");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aVar;
    }

    /* compiled from: ApiResponseParse.java */
    /* renamed from: nj$a */
    /* loaded from: classes.dex */
    public static class a {
        public static a a = new a();
        public boolean b = false;
        public String c = null;

        public boolean a() {
            if ("E0102".equalsIgnoreCase(this.c)) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if ("E0111".equalsIgnoreCase(this.c) || "E0112".equalsIgnoreCase(this.c)) {
                return true;
            }
            return false;
        }
    }
}
