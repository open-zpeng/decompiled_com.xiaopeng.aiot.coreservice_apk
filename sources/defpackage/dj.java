package defpackage;

import android.text.TextUtils;
import org.json.JSONObject;
/* compiled from: SystemConfig.java */
/* renamed from: dj  reason: default package */
/* loaded from: classes.dex */
public class dj {
    public static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SYSTEM")) {
                    vj.c("SystemConfig", "server system config ", str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("SYSTEM");
                    if (optJSONObject != null) {
                        try {
                            if (optJSONObject.has("bg_interval")) {
                                zi.i(optJSONObject.getInt("bg_interval") + "");
                            }
                        } catch (Throwable th) {
                        }
                        try {
                            if (optJSONObject.has("fg_interval")) {
                                zi.l(optJSONObject.getInt("fg_interval") + "");
                            }
                        } catch (Throwable th2) {
                        }
                        vj.c("SystemConfig", "UTDC.bSendToNewLogStore:", Boolean.valueOf(ej.k));
                        vj.c("SystemConfig", "Config.BACKGROUND_PERIOD:", Long.valueOf(zi.f()));
                        vj.c("SystemConfig", "Config.FOREGROUND_PERIOD:", Long.valueOf(zi.a()));
                        try {
                            if (optJSONObject.has("discard")) {
                                int i = optJSONObject.getInt("discard");
                                if (i == 1) {
                                    zi.g = true;
                                    lj.c().g();
                                } else if (i == 0) {
                                    zi.g = false;
                                    lj.c().f();
                                }
                            } else if (zi.g) {
                                zi.g = false;
                                lj.c().f();
                            }
                        } catch (Throwable th3) {
                        }
                        try {
                            if (optJSONObject.has("cdb") && optJSONObject.getInt("cdb") > a()) {
                                ek.a().g(new a());
                            }
                        } catch (Throwable th4) {
                        }
                    }
                }
            } catch (Throwable th5) {
                vj.b("SystemConfig", "updateconfig", th5);
            }
        }
    }

    /* compiled from: SystemConfig.java */
    /* renamed from: dj$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            jj.f().k();
        }
    }

    public static int a() {
        JSONObject jSONObject;
        String m = zi.m();
        if (TextUtils.isEmpty(m)) {
            return 0;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(m);
            if (jSONObject2.has("SYSTEM") && (jSONObject = jSONObject2.getJSONObject("SYSTEM")) != null && jSONObject.has("cdb")) {
                return jSONObject.getInt("cdb");
            }
            return 0;
        } catch (Throwable th) {
            return 0;
        }
    }
}
