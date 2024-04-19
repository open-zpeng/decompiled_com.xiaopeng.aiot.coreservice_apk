package defpackage;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* compiled from: ExceptionEventBuilder.java */
/* renamed from: di  reason: default package */
/* loaded from: classes.dex */
public class di {
    public static void c(Context context, Throwable th) {
        if (th != null) {
            try {
                bi biVar = (bi) fi.a().b(bi.class, new Object[0]);
                zh zhVar = zh.ALARM;
                biVar.b = zhVar.a();
                HashMap hashMap = new HashMap();
                hashMap.put("meta", qh.a());
                ii iiVar = (ii) fi.a().b(ii.class, new Object[0]);
                iiVar.put(b(context, th));
                hashMap.put("data", iiVar);
                biVar.h.put(zhVar.c(), new JSONObject(hashMap).toString());
                biVar.d = "APPMONITOR";
                biVar.f = "sdk-exception";
                yi.a(biVar);
                fi.a().d(iiVar);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void d(Throwable th) {
        c(null, th);
    }

    public static JSONObject b(Context context, Throwable th) throws IOException {
        JSONObject jSONObject = (JSONObject) fi.a().b(ji.class, new Object[0]);
        if (context != null) {
            try {
                jSONObject.put("pname", oj.a(context));
            } catch (Exception e) {
            }
        }
        jSONObject.put("page", "APPMONITOR");
        jSONObject.put("monitorPoint", "sdk-exception");
        jSONObject.put("arg", th.getClass().getSimpleName());
        jSONObject.put("successCount", 0);
        jSONObject.put("failCount", 1);
        ArrayList arrayList = new ArrayList();
        String a = a(th);
        if (a != null) {
            JSONObject jSONObject2 = (JSONObject) fi.a().b(ji.class, new Object[0]);
            jSONObject2.put("errorCode", a);
            jSONObject2.put("errorCount", 1);
            arrayList.add(jSONObject2);
        }
        jSONObject.put("errors", arrayList);
        return jSONObject;
    }

    public static String a(Throwable th) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
            }
        }
        String sb2 = sb.toString();
        if (xi.b(sb2)) {
            return th.toString();
        }
        return sb2;
    }
}
