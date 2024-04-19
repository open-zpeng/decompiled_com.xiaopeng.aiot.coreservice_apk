package defpackage;

import java.util.Map;
import java.util.Set;
/* compiled from: JsonObject.java */
/* renamed from: dh  reason: default package */
/* loaded from: classes.dex */
public final class dh extends lh {
    public final jg<String, lh> a = new jg<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof dh) && ((dh) obj).a.equals(this.a));
    }

    public void h(String str, lh lhVar) {
        if (lhVar == null) {
            lhVar = ch.a;
        }
        this.a.put(str, lhVar);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Set<Map.Entry<String, lh>> i() {
        return this.a.entrySet();
    }
}
