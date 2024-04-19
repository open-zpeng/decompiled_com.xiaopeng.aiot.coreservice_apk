package defpackage;

import java.util.Map;
/* compiled from: UTAdapter.java */
/* renamed from: fk  reason: default package */
/* loaded from: classes.dex */
public class fk {
    public static void a(Map<String, String> args) {
        Object b;
        try {
            Object d = bk.d("com.ut.mini.UTAnalytics", "getInstance");
            if (d != null && (b = bk.b(d, "getDefaultTracker")) != null) {
                bk.c(b, "send", new Object[]{args}, Map.class);
            }
        } catch (Exception e) {
        }
    }
}
