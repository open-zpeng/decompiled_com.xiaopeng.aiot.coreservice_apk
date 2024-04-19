package defpackage;

import java.util.HashMap;
import java.util.Map;
/* compiled from: BalancedPool.java */
/* renamed from: fi  reason: default package */
/* loaded from: classes.dex */
public class fi {
    public static fi a = new fi();
    public Map<Class<? extends gi>, hi<? extends gi>> b = new HashMap();

    public static fi a() {
        return a;
    }

    public <T extends gi> T b(Class<T> cls, Object... objArr) {
        T a2 = c(cls).a();
        if (a2 == null) {
            try {
                a2 = cls.newInstance();
            } catch (Exception e) {
                di.d(e);
            }
        }
        if (a2 != null) {
            a2.fill(objArr);
        }
        return a2;
    }

    public <T extends gi> void d(T t) {
        if (t == null || (t instanceof ji) || (t instanceof ii)) {
            return;
        }
        c(t.getClass()).b(t);
    }

    public final synchronized <T extends gi> hi<T> c(Class<T> cls) {
        hi<T> hiVar;
        hiVar = (hi<T>) this.b.get(cls);
        if (hiVar == null) {
            hiVar = new hi<>();
            this.b.put(cls, hiVar);
        }
        return hiVar;
    }
}
