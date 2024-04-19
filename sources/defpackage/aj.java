package defpackage;

import defpackage.rj;
import java.util.HashMap;
/* compiled from: GcConfigChannelMgr.java */
/* renamed from: aj  reason: default package */
/* loaded from: classes.dex */
public class aj {
    public static aj a = new aj();
    public static String b = "adashxgc.ut.taobao.com";

    public static /* synthetic */ String c() {
        return b();
    }

    public static String b() {
        return "https://" + b + "/rest/gc2";
    }

    public static aj a() {
        return a;
    }

    public void d() {
        ek.a().g(new a());
    }

    /* compiled from: GcConfigChannelMgr.java */
    /* renamed from: aj$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!yj.h()) {
                return;
            }
            for (int i = 0; i < 8; i++) {
                HashMap hashMap = new HashMap();
                String g = zi.g("b01n15");
                String g2 = zi.g("b01na");
                hashMap.put("_b01n15", g);
                hashMap.put("_b01na", g2);
                try {
                    String c = gk.c(aj.c(), hashMap, null);
                    vj.c("ConfigMgr", "config:" + c);
                    rj.a a = rj.a(1, c, null, false);
                    if (a.b != null) {
                        byte[] bArr = a.b;
                        zi.n(new String(bArr, 0, bArr.length));
                        zi.o();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(10000L);
                } catch (Exception e2) {
                }
            }
        }
    }
}
