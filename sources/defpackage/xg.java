package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: Gson.java */
/* renamed from: xg  reason: default package */
/* loaded from: classes.dex */
public final class xg {
    public final ThreadLocal<Map<ug<?>, f<?>>> a;
    public final Map<ug<?>, jh<?>> b;
    public final List<kh> c;
    public final gg d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final ah i;
    public final gh j;

    /* compiled from: Gson.java */
    /* renamed from: xg$a */
    /* loaded from: classes.dex */
    public class a implements ah {
        public a() {
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: xg$b */
    /* loaded from: classes.dex */
    public class b implements gh {
        public b() {
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: xg$c */
    /* loaded from: classes.dex */
    public class c extends jh<Number> {
        public c() {
        }

        @Override // defpackage.jh
        /* renamed from: d */
        public Double c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            return Double.valueOf(qgVar.y());
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Number number) throws IOException {
            if (number == null) {
                sgVar.u();
                return;
            }
            xg.this.l(number.doubleValue());
            sgVar.e(number);
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: xg$d */
    /* loaded from: classes.dex */
    public class d extends jh<Number> {
        public d() {
        }

        @Override // defpackage.jh
        /* renamed from: d */
        public Float c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            return Float.valueOf((float) qgVar.y());
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Number number) throws IOException {
            if (number == null) {
                sgVar.u();
                return;
            }
            xg.this.l(number.floatValue());
            sgVar.e(number);
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: xg$e */
    /* loaded from: classes.dex */
    public class e extends jh<Number> {
        public e() {
        }

        @Override // defpackage.jh
        /* renamed from: d */
        public Number c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            return Long.valueOf(qgVar.z());
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Number number) throws IOException {
            if (number == null) {
                sgVar.u();
            } else {
                sgVar.j(number.toString());
            }
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: xg$f */
    /* loaded from: classes.dex */
    public static class f<T> extends jh<T> {
        public jh<T> a;

        @Override // defpackage.jh
        public void a(sg sgVar, T t) throws IOException {
            jh<T> jhVar = this.a;
            if (jhVar == null) {
                throw new IllegalStateException();
            }
            jhVar.a(sgVar, t);
        }

        @Override // defpackage.jh
        public T c(qg qgVar) throws IOException {
            jh<T> jhVar = this.a;
            if (jhVar != null) {
                return jhVar.c(qgVar);
            }
            throw new IllegalStateException();
        }

        public void d(jh<T> jhVar) {
            if (this.a != null) {
                throw new AssertionError();
            }
            this.a = jhVar;
        }
    }

    public xg() {
        this(fg.a, pg.a, Collections.emptyMap(), false, false, false, true, false, false, ih.a, Collections.emptyList());
    }

    public xg(fg fgVar, wg wgVar, Map<Type, yg<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, ih ihVar, List<kh> list) {
        this.a = new ThreadLocal<>();
        this.b = Collections.synchronizedMap(new HashMap());
        this.i = new a();
        this.j = new b();
        gg ggVar = new gg(map);
        this.d = ggVar;
        this.e = z;
        this.g = z3;
        this.f = z4;
        this.h = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(cg.Q);
        arrayList.add(yf.a);
        arrayList.add(fgVar);
        arrayList.addAll(list);
        arrayList.add(cg.x);
        arrayList.add(cg.m);
        arrayList.add(cg.g);
        arrayList.add(cg.i);
        arrayList.add(cg.k);
        arrayList.add(cg.c(Long.TYPE, Long.class, c(ihVar)));
        arrayList.add(cg.c(Double.TYPE, Double.class, f(z6)));
        arrayList.add(cg.c(Float.TYPE, Float.class, s(z6)));
        arrayList.add(cg.r);
        arrayList.add(cg.t);
        arrayList.add(cg.z);
        arrayList.add(cg.B);
        arrayList.add(cg.b(BigDecimal.class, cg.v));
        arrayList.add(cg.b(BigInteger.class, cg.w));
        arrayList.add(cg.D);
        arrayList.add(cg.F);
        arrayList.add(cg.J);
        arrayList.add(cg.O);
        arrayList.add(cg.H);
        arrayList.add(cg.d);
        arrayList.add(uf.a);
        arrayList.add(cg.M);
        arrayList.add(zf.a);
        arrayList.add(ag.a);
        arrayList.add(cg.K);
        arrayList.add(rf.a);
        arrayList.add(cg.R);
        arrayList.add(cg.b);
        arrayList.add(new sf(ggVar));
        arrayList.add(new wf(ggVar, z2));
        arrayList.add(new xf(ggVar, wgVar, fgVar));
        this.c = Collections.unmodifiableList(arrayList);
    }

    public static void p(Object obj, qg qgVar) {
        if (obj != null) {
            try {
                if (qgVar.t() == rg.END_DOCUMENT) {
                    return;
                }
                throw new bh("JSON document was not fully consumed.");
            } catch (tg e2) {
                throw new hh(e2);
            } catch (IOException e3) {
                throw new bh(e3);
            }
        }
    }

    public final sg a(Writer writer) throws IOException {
        if (this.g) {
            writer.write(")]}'\n");
        }
        sg sgVar = new sg(writer);
        if (this.h) {
            sgVar.q("  ");
        }
        sgVar.o(this.e);
        return sgVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> jh<T> b(ug<T> ugVar) {
        jh<T> jhVar = (jh<T>) this.b.get(ugVar);
        if (jhVar != null) {
            return jhVar;
        }
        Map<ug<?>, f<?>> map = this.a.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.a.set(map);
            z = true;
        }
        f<?> fVar = map.get(ugVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            f<?> fVar2 = new f<>();
            map.put(ugVar, fVar2);
            for (kh khVar : this.c) {
                jh jhVar2 = (jh<T>) khVar.a(this, ugVar);
                if (jhVar2 != null) {
                    fVar2.d(jhVar2);
                    this.b.put(ugVar, jhVar2);
                    return jhVar2;
                }
            }
            throw new IllegalArgumentException("GSON cannot handle " + ugVar);
        } finally {
            map.remove(ugVar);
            if (z) {
                this.a.remove();
            }
        }
    }

    public final jh<Number> c(ih ihVar) {
        return ihVar == ih.a ? cg.n : new e();
    }

    public <T> jh<T> d(kh khVar, ug<T> ugVar) {
        boolean z = false;
        for (kh khVar2 : this.c) {
            if (z) {
                jh<T> a2 = khVar2.a(this, ugVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (khVar2 == khVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + ugVar);
    }

    public <T> jh<T> e(Class<T> cls) {
        return b(ug.e(cls));
    }

    public final jh<Number> f(boolean z) {
        return z ? cg.p : new c();
    }

    public <T> T g(qg qgVar, Type type) throws bh, hh {
        boolean E = qgVar.E();
        boolean z = true;
        qgVar.e(true);
        try {
            try {
                try {
                    qgVar.t();
                    z = false;
                    T c2 = b(ug.c(type)).c(qgVar);
                    qgVar.e(E);
                    return c2;
                } catch (IOException e2) {
                    throw new hh(e2);
                }
            } catch (EOFException e3) {
                if (z) {
                    qgVar.e(E);
                    return null;
                }
                throw new hh(e3);
            } catch (IllegalStateException e4) {
                throw new hh(e4);
            }
        } catch (Throwable th) {
            qgVar.e(E);
            throw th;
        }
    }

    public <T> T h(Reader reader, Type type) throws bh, hh {
        qg qgVar = new qg(reader);
        T t = (T) g(qgVar, type);
        p(t, qgVar);
        return t;
    }

    public <T> T i(String str, Class<T> cls) throws hh {
        return (T) ng.a(cls).cast(j(str, cls));
    }

    public <T> T j(String str, Type type) throws hh {
        if (str == null) {
            return null;
        }
        return (T) h(new StringReader(str), type);
    }

    public String k(lh lhVar) {
        StringWriter stringWriter = new StringWriter();
        o(lhVar, stringWriter);
        return stringWriter.toString();
    }

    public final void l(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public void n(lh lhVar, sg sgVar) throws bh {
        boolean v = sgVar.v();
        sgVar.l(true);
        boolean w = sgVar.w();
        sgVar.r(this.f);
        boolean y = sgVar.y();
        sgVar.o(this.e);
        try {
            try {
                mg.b(lhVar, sgVar);
            } catch (IOException e2) {
                throw new bh(e2);
            }
        } finally {
            sgVar.l(v);
            sgVar.r(w);
            sgVar.o(y);
        }
    }

    public void o(lh lhVar, Appendable appendable) throws bh {
        try {
            n(lhVar, a(mg.a(appendable)));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void q(Object obj, Type type, sg sgVar) throws bh {
        jh b2 = b(ug.c(type));
        boolean v = sgVar.v();
        sgVar.l(true);
        boolean w = sgVar.w();
        sgVar.r(this.f);
        boolean y = sgVar.y();
        sgVar.o(this.e);
        try {
            try {
                b2.a(sgVar, obj);
            } catch (IOException e2) {
                throw new bh(e2);
            }
        } finally {
            sgVar.l(v);
            sgVar.r(w);
            sgVar.o(y);
        }
    }

    public void r(Object obj, Type type, Appendable appendable) throws bh {
        try {
            q(obj, type, a(mg.a(appendable)));
        } catch (IOException e2) {
            throw new bh(e2);
        }
    }

    public final jh<Number> s(boolean z) {
        return z ? cg.o : new d();
    }

    public String t(Object obj) {
        return obj == null ? k(ch.a) : u(obj, obj.getClass());
    }

    public String toString() {
        return "{serializeNulls:" + this.e + "factories:" + this.c + ",instanceCreators:" + this.d + "}";
    }

    public String u(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        r(obj, type, stringWriter);
        return stringWriter.toString();
    }
}
