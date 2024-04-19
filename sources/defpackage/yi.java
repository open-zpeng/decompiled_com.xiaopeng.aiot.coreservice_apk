package defpackage;

import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.log.model.LogField;
import com.xiaopeng.base.log.LogUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: UTUtil.java */
/* renamed from: yi  reason: default package */
/* loaded from: classes.dex */
public class yi {
    public static void d(Map<UTDimensionValueSet, List<xh>> map) {
        Integer eventId;
        for (Map.Entry<UTDimensionValueSet, List<xh>> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            UTDimensionValueSet key = entry.getKey();
            List<xh> value = entry.getValue();
            if (value.size() != 0 && (eventId = key.getEventId()) != null) {
                zh b = zh.b(eventId.intValue());
                int i = 0;
                bi biVar = (bi) fi.a().b(bi.class, new Object[0]);
                biVar.b = eventId.intValue();
                if (key.getMap() != null) {
                    biVar.h.putAll(key.getMap());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("meta", qh.a());
                ii iiVar = (ii) fi.a().b(ii.class, new Object[0]);
                for (xh xhVar : value) {
                    iiVar.put(xhVar.a());
                    if (i == 0) {
                        sb.append(xhVar.a);
                        sb2.append(xhVar.b);
                    } else {
                        sb.append(LogUtils.SEPARATOR);
                        sb.append(xhVar.a);
                        sb2.append(LogUtils.SEPARATOR);
                        sb2.append(xhVar.b);
                    }
                    i++;
                    fi.a().d(xhVar);
                }
                hashMap.put("data", iiVar);
                biVar.h.put(b.c(), new JSONObject(hashMap).toString());
                String sb3 = sb.toString();
                String sb4 = sb2.toString();
                biVar.h.put(LogField.ARG1.toString(), sb3);
                biVar.h.put(LogField.ARG2.toString(), sb4);
                biVar.d = sb3;
                biVar.f = sb4;
                c(biVar);
                fi.a().d(iiVar);
            }
            fi.a().d(key);
        }
    }

    public static void b(UTDimensionValueSet uTDimensionValueSet, xh xhVar) {
        Integer eventId = uTDimensionValueSet.getEventId();
        if (eventId != null) {
            zh b = zh.b(eventId.intValue());
            bi biVar = (bi) fi.a().b(bi.class, new Object[0]);
            biVar.b = 6699;
            if (uTDimensionValueSet.getMap() != null) {
                biVar.h.putAll(uTDimensionValueSet.getMap());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("meta", qh.a());
            hashMap.put("_event_id", eventId);
            ii iiVar = (ii) fi.a().b(ii.class, new Object[0]);
            iiVar.put(xhVar.a());
            fi.a().d(xhVar);
            hashMap.put("data", iiVar);
            biVar.h.put(b.c(), new JSONObject(hashMap).toString());
            biVar.h.put(LogField.EVENTID.toString(), String.valueOf(6699));
            c(biVar);
            fi.a().d(iiVar);
        }
    }

    public static void a(bi biVar) {
        if (biVar == null) {
            return;
        }
        ej.d(biVar.a, String.valueOf(biVar.b), biVar.d, biVar.f, biVar.g, biVar.h);
        fi.a().d(biVar);
    }

    public static void c(bi biVar) {
        vj.c("UTUtil", "upload without flowback. args:", biVar.h);
        vi.a().b(biVar.h);
        fi.a().d(biVar);
    }
}
