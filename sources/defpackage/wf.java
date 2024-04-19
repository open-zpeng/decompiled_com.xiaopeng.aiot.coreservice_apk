package defpackage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: MapTypeAdapterFactory.java */
/* renamed from: wf  reason: default package */
/* loaded from: classes.dex */
public final class wf implements kh {
    public final gg a;
    public final boolean b;

    /* compiled from: MapTypeAdapterFactory.java */
    /* renamed from: wf$a */
    /* loaded from: classes.dex */
    public final class a<K, V> extends jh<Map<K, V>> {
        public final jh<K> a;
        public final jh<V> b;
        public final kg<? extends Map<K, V>> c;

        public a(xg xgVar, Type type, jh<K> jhVar, Type type2, jh<V> jhVar2, kg<? extends Map<K, V>> kgVar) {
            this.a = new bg(xgVar, jhVar, type);
            this.b = new bg(xgVar, jhVar2, type2);
            this.c = kgVar;
        }

        @Override // defpackage.jh
        /* renamed from: d */
        public Map<K, V> c(qg qgVar) throws IOException {
            rg t = qgVar.t();
            if (t == rg.NULL) {
                qgVar.w();
                return null;
            }
            Map<K, V> O000000o = this.c.O000000o();
            if (t == rg.BEGIN_ARRAY) {
                qgVar.c();
                while (qgVar.s()) {
                    qgVar.c();
                    K c = this.a.c(qgVar);
                    if (O000000o.put(c, this.b.c(qgVar)) != null) {
                        throw new hh("duplicate key: " + c);
                    }
                    qgVar.l();
                }
                qgVar.l();
            } else {
                qgVar.q();
                while (qgVar.s()) {
                    hg.a.a(qgVar);
                    K c2 = this.a.c(qgVar);
                    if (O000000o.put(c2, this.b.c(qgVar)) != null) {
                        throw new hh("duplicate key: " + c2);
                    }
                }
                qgVar.o();
            }
            return O000000o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Map<K, V> map) throws IOException {
            if (map == null) {
                sgVar.u();
            } else if (!wf.this.b) {
                sgVar.m();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    sgVar.f(String.valueOf(entry.getKey()));
                    this.b.a(sgVar, entry.getValue());
                }
                sgVar.s();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    lh b = this.a.b(entry2.getKey());
                    arrayList.add(b);
                    arrayList2.add(entry2.getValue());
                    z |= b.b() || b.a();
                }
                if (!z) {
                    sgVar.m();
                    while (i < arrayList.size()) {
                        sgVar.f(f((lh) arrayList.get(i)));
                        this.b.a(sgVar, arrayList2.get(i));
                        i++;
                    }
                    sgVar.s();
                    return;
                }
                sgVar.i();
                while (i < arrayList.size()) {
                    sgVar.i();
                    mg.b((lh) arrayList.get(i), sgVar);
                    this.b.a(sgVar, arrayList2.get(i));
                    sgVar.p();
                    i++;
                }
                sgVar.p();
            }
        }

        public final String f(lh lhVar) {
            if (!lhVar.d()) {
                if (lhVar.c()) {
                    return "null";
                }
                throw new AssertionError();
            }
            fh g = lhVar.g();
            if (g.s()) {
                return String.valueOf(g.m());
            }
            if (g.j()) {
                return Boolean.toString(g.q());
            }
            if (g.t()) {
                return g.l();
            }
            throw new AssertionError();
        }
    }

    public wf(gg ggVar, boolean z) {
        this.a = ggVar;
        this.b = z;
    }

    @Override // defpackage.kh
    public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
        Type d = ugVar.d();
        if (Map.class.isAssignableFrom(ugVar.a())) {
            Type[] o = eg.o(d, eg.r(d));
            return new a(xgVar, o[0], b(xgVar, o[0]), o[1], xgVar.b(ug.c(o[1])), this.a.a(ugVar));
        }
        return null;
    }

    public final jh<?> b(xg xgVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? cg.f : xgVar.b(ug.c(type));
    }
}
