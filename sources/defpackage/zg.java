package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: JsonArray.java */
/* renamed from: zg  reason: default package */
/* loaded from: classes.dex */
public final class zg extends lh implements Iterable<lh> {
    public final List<lh> a = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zg) && ((zg) obj).a.equals(this.a));
    }

    public void h(lh lhVar) {
        if (lhVar == null) {
            lhVar = ch.a;
        }
        this.a.add(lhVar);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<lh> iterator() {
        return this.a.iterator();
    }
}
