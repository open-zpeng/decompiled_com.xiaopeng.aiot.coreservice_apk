package defpackage;

import com.alibaba.mtl.log.model.LogField;
import java.util.Map;
/* compiled from: UTAggregationPlugin.java */
/* renamed from: vi  reason: default package */
/* loaded from: classes.dex */
public class vi {
    public static final String a = null;
    public static vi b;

    public static synchronized vi a() {
        vi viVar;
        synchronized (vi.class) {
            if (b == null) {
                b = new vi();
            }
            viVar = b;
        }
        return viVar;
    }

    public void b(Map<String, String> map) {
        if (map == null) {
            return;
        }
        vj.c(a, "[sendToUT]:", " args:", map);
        if (ej.k) {
            ej.d(map.get(LogField.PAGE.toString()), map.get(LogField.EVENTID.toString()), map.get(LogField.ARG1.toString()), map.get(LogField.ARG2.toString()), map.get(LogField.ARG3.toString()), map);
            return;
        }
        map.put("_fuamf", "yes");
        fk.a(map);
    }
}
