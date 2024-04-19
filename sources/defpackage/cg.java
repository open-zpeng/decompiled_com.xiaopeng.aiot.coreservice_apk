package defpackage;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
/* compiled from: TypeAdapters.java */
/* renamed from: cg  reason: default package */
/* loaded from: classes.dex */
public final class cg {
    public static final jh<StringBuffer> A;
    public static final kh B;
    public static final jh<URL> C;
    public static final kh D;
    public static final jh<URI> E;
    public static final kh F;
    public static final jh<InetAddress> G;
    public static final kh H;
    public static final jh<UUID> I;
    public static final kh J;
    public static final kh K;
    public static final jh<Calendar> L;
    public static final kh M;
    public static final jh<Locale> N;
    public static final kh O;
    public static final jh<lh> P;
    public static final kh Q;
    public static final kh R;
    public static final jh<Class> a;
    public static final kh b;
    public static final jh<BitSet> c;
    public static final kh d;
    public static final jh<Boolean> e;
    public static final jh<Boolean> f;
    public static final kh g;
    public static final jh<Number> h;
    public static final kh i;
    public static final jh<Number> j;
    public static final kh k;
    public static final jh<Number> l;
    public static final kh m;
    public static final jh<Number> n;
    public static final jh<Number> o;
    public static final jh<Number> p;
    public static final jh<Number> q;
    public static final kh r;
    public static final jh<Character> s;
    public static final kh t;
    public static final jh<String> u;
    public static final jh<BigDecimal> v;
    public static final jh<BigInteger> w;
    public static final kh x;
    public static final jh<StringBuilder> y;
    public static final kh z;

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$a */
    /* loaded from: classes.dex */
    public static class a extends jh<URL> {
        @Override // defpackage.jh
        /* renamed from: d */
        public URL c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            String v = qgVar.v();
            if ("null".equals(v)) {
                return null;
            }
            return new URL(v);
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, URL url) throws IOException {
            sgVar.j(url == null ? null : url.toExternalForm());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$a0 */
    /* loaded from: classes.dex */
    public static class a0 extends jh<String> {
        @Override // defpackage.jh
        /* renamed from: d */
        public String c(qg qgVar) throws IOException {
            rg t = qgVar.t();
            if (t != rg.NULL) {
                return t == rg.BOOLEAN ? Boolean.toString(qgVar.x()) : qgVar.v();
            }
            qgVar.w();
            return null;
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, String str) throws IOException {
            sgVar.j(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$b */
    /* loaded from: classes.dex */
    public static class b extends jh<URI> {
        @Override // defpackage.jh
        /* renamed from: d */
        public URI c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            try {
                String v = qgVar.v();
                if ("null".equals(v)) {
                    return null;
                }
                return new URI(v);
            } catch (URISyntaxException e) {
                throw new bh(e);
            }
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, URI uri) throws IOException {
            sgVar.j(uri == null ? null : uri.toASCIIString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$b0 */
    /* loaded from: classes.dex */
    public static class b0 extends jh<BigDecimal> {
        @Override // defpackage.jh
        /* renamed from: d */
        public BigDecimal c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            try {
                return new BigDecimal(qgVar.v());
            } catch (NumberFormatException e) {
                throw new hh(e);
            }
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, BigDecimal bigDecimal) throws IOException {
            sgVar.e(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$c */
    /* loaded from: classes.dex */
    public static class c extends jh<BitSet> {
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
            if (r7.C() != 0) goto L16;
         */
        @Override // defpackage.jh
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.BitSet c(defpackage.qg r7) throws java.io.IOException {
            /*
                r6 = this;
                rg r0 = r7.t()
                rg r1 = defpackage.rg.NULL
                if (r0 != r1) goto Ld
                r7.w()
                r7 = 0
                return r7
            Ld:
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r7.c()
                rg r1 = r7.t()
                r2 = 0
                r3 = r2
            L1b:
                rg r4 = defpackage.rg.END_ARRAY
                if (r1 == r4) goto L7e
                int[] r4 = defpackage.cg.q.a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                switch(r4) {
                    case 1: goto L6c;
                    case 2: goto L67;
                    case 3: goto L42;
                    default: goto L2b;
                }
            L2b:
                hh r7 = new hh
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r7.<init>(r0)
                throw r7
            L42:
                java.lang.String r1 = r7.v()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L4f
                if (r1 == 0) goto L4d
                goto L72
            L4d:
                r5 = r2
                goto L72
            L4f:
                r7 = move-exception
                hh r7 = new hh
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r7.<init>(r0)
                throw r7
            L67:
                boolean r5 = r7.x()
                goto L72
            L6c:
                int r1 = r7.C()
                if (r1 == 0) goto L4d
            L72:
                if (r5 == 0) goto L77
                r0.set(r3)
            L77:
                int r3 = r3 + 1
                rg r1 = r7.t()
                goto L1b
            L7e:
                r7.l()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.cg.c.c(qg):java.util.BitSet");
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                sgVar.u();
                return;
            }
            sgVar.i();
            for (int i = 0; i < bitSet.length(); i++) {
                sgVar.d(bitSet.get(i) ? 1L : 0L);
            }
            sgVar.p();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$c0 */
    /* loaded from: classes.dex */
    public static class c0 extends jh<BigInteger> {
        @Override // defpackage.jh
        /* renamed from: d */
        public BigInteger c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            try {
                return new BigInteger(qgVar.v());
            } catch (NumberFormatException e) {
                throw new hh(e);
            }
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, BigInteger bigInteger) throws IOException {
            sgVar.e(bigInteger);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$d */
    /* loaded from: classes.dex */
    public static class d extends jh<InetAddress> {
        @Override // defpackage.jh
        /* renamed from: d */
        public InetAddress c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            return InetAddress.getByName(qgVar.v());
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, InetAddress inetAddress) throws IOException {
            sgVar.j(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$d0 */
    /* loaded from: classes.dex */
    public static class d0 extends jh<StringBuilder> {
        @Override // defpackage.jh
        /* renamed from: d */
        public StringBuilder c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            return new StringBuilder(qgVar.v());
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, StringBuilder sb) throws IOException {
            sgVar.j(sb == null ? null : sb.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$e */
    /* loaded from: classes.dex */
    public static class e extends jh<UUID> {
        @Override // defpackage.jh
        /* renamed from: d */
        public UUID c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            return UUID.fromString(qgVar.v());
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, UUID uuid) throws IOException {
            sgVar.j(uuid == null ? null : uuid.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$e0 */
    /* loaded from: classes.dex */
    public static class e0 extends jh<StringBuffer> {
        @Override // defpackage.jh
        /* renamed from: d */
        public StringBuffer c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            return new StringBuffer(qgVar.v());
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, StringBuffer stringBuffer) throws IOException {
            sgVar.j(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$f */
    /* loaded from: classes.dex */
    public static class f implements kh {

        /* compiled from: TypeAdapters.java */
        /* renamed from: cg$f$a */
        /* loaded from: classes.dex */
        public class a extends jh<Timestamp> {
            public final /* synthetic */ jh a;

            public a(jh jhVar) {
                this.a = jhVar;
            }

            @Override // defpackage.jh
            /* renamed from: d */
            public Timestamp c(qg qgVar) throws IOException {
                Date date = (Date) this.a.c(qgVar);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // defpackage.jh
            /* renamed from: e */
            public void a(sg sgVar, Timestamp timestamp) throws IOException {
                this.a.a(sgVar, timestamp);
            }
        }

        @Override // defpackage.kh
        public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
            if (ugVar.a() != Timestamp.class) {
                return null;
            }
            return new a(xgVar.e(Date.class));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$f0 */
    /* loaded from: classes.dex */
    public static final class f0<T extends Enum<T>> extends jh<T> {
        public final Map<String, T> a = new HashMap();
        public final Map<T, String> b = new HashMap();

        public f0(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    of ofVar = (of) cls.getField(name).getAnnotation(of.class);
                    name = ofVar != null ? ofVar.O000000o() : name;
                    this.a.put(name, t);
                    this.b.put(t, name);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        @Override // defpackage.jh
        /* renamed from: d */
        public T c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            return this.a.get(qgVar.v());
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, T t) throws IOException {
            sgVar.j(t == null ? null : this.b.get(t));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$g */
    /* loaded from: classes.dex */
    public static class g extends jh<Calendar> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Calendar c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            qgVar.q();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (qgVar.t() != rg.END_OBJECT) {
                String u = qgVar.u();
                int C = qgVar.C();
                if ("year".equals(u)) {
                    i = C;
                } else if ("month".equals(u)) {
                    i2 = C;
                } else if ("dayOfMonth".equals(u)) {
                    i3 = C;
                } else if ("hourOfDay".equals(u)) {
                    i4 = C;
                } else if ("minute".equals(u)) {
                    i5 = C;
                } else if ("second".equals(u)) {
                    i6 = C;
                }
            }
            qgVar.o();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                sgVar.u();
                return;
            }
            sgVar.m();
            sgVar.f("year");
            sgVar.d(calendar.get(1));
            sgVar.f("month");
            sgVar.d(calendar.get(2));
            sgVar.f("dayOfMonth");
            sgVar.d(calendar.get(5));
            sgVar.f("hourOfDay");
            sgVar.d(calendar.get(11));
            sgVar.f("minute");
            sgVar.d(calendar.get(12));
            sgVar.f("second");
            sgVar.d(calendar.get(13));
            sgVar.s();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$h */
    /* loaded from: classes.dex */
    public static class h extends jh<Locale> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Locale c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(qgVar.v(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Locale locale) throws IOException {
            sgVar.j(locale == null ? null : locale.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$i */
    /* loaded from: classes.dex */
    public static class i extends jh<lh> {
        @Override // defpackage.jh
        /* renamed from: d */
        public lh c(qg qgVar) throws IOException {
            switch (q.a[qgVar.t().ordinal()]) {
                case 1:
                    return new fh(new ig(qgVar.v()));
                case 2:
                    return new fh(Boolean.valueOf(qgVar.x()));
                case 3:
                    return new fh(qgVar.v());
                case 4:
                    qgVar.w();
                    return ch.a;
                case 5:
                    zg zgVar = new zg();
                    qgVar.c();
                    while (qgVar.s()) {
                        zgVar.h(c(qgVar));
                    }
                    qgVar.l();
                    return zgVar;
                case 6:
                    dh dhVar = new dh();
                    qgVar.q();
                    while (qgVar.s()) {
                        dhVar.h(qgVar.u(), c(qgVar));
                    }
                    qgVar.o();
                    return dhVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, lh lhVar) throws IOException {
            if (lhVar == null || lhVar.c()) {
                sgVar.u();
            } else if (lhVar.d()) {
                fh g = lhVar.g();
                if (g.s()) {
                    sgVar.e(g.m());
                } else if (g.j()) {
                    sgVar.g(g.q());
                } else {
                    sgVar.j(g.l());
                }
            } else if (lhVar.b()) {
                sgVar.i();
                Iterator<lh> it = lhVar.f().iterator();
                while (it.hasNext()) {
                    a(sgVar, it.next());
                }
                sgVar.p();
            } else if (!lhVar.a()) {
                throw new IllegalArgumentException("Couldn't write " + lhVar.getClass());
            } else {
                sgVar.m();
                for (Map.Entry<String, lh> entry : lhVar.e().i()) {
                    sgVar.f(entry.getKey());
                    a(sgVar, entry.getValue());
                }
                sgVar.s();
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$j */
    /* loaded from: classes.dex */
    public static class j implements kh {
        @Override // defpackage.kh
        public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
            Class a = ugVar.a();
            if (!Enum.class.isAssignableFrom(a) || a == Enum.class) {
                return null;
            }
            if (!a.isEnum()) {
                a = (Class<? super Object>) a.getSuperclass();
            }
            return new f0(a);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$k */
    /* loaded from: classes.dex */
    public static class k extends jh<Class> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Class c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Class cls) throws IOException {
            if (cls == null) {
                sgVar.u();
                return;
            }
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$l */
    /* loaded from: classes.dex */
    public static class l implements kh {
        public final /* synthetic */ Class a;
        public final /* synthetic */ jh b;

        public l(Class cls, jh jhVar) {
            this.a = cls;
            this.b = jhVar;
        }

        @Override // defpackage.kh
        public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
            if (ugVar.a() == this.a) {
                return this.b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.a.getName() + ",adapter=" + this.b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$m */
    /* loaded from: classes.dex */
    public static class m implements kh {
        public final /* synthetic */ Class a;
        public final /* synthetic */ Class b;
        public final /* synthetic */ jh d;

        public m(Class cls, Class cls2, jh jhVar) {
            this.a = cls;
            this.b = cls2;
            this.d = jhVar;
        }

        @Override // defpackage.kh
        public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
            Class<? super T> a = ugVar.a();
            if (a == this.a || a == this.b) {
                return this.d;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.b.getName() + "+" + this.a.getName() + ",adapter=" + this.d + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$n */
    /* loaded from: classes.dex */
    public static class n extends jh<Boolean> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Boolean c(qg qgVar) throws IOException {
            if (qgVar.t() != rg.NULL) {
                return qgVar.t() == rg.STRING ? Boolean.valueOf(Boolean.parseBoolean(qgVar.v())) : Boolean.valueOf(qgVar.x());
            }
            qgVar.w();
            return null;
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Boolean bool) throws IOException {
            if (bool == null) {
                sgVar.u();
            } else {
                sgVar.g(bool.booleanValue());
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$o */
    /* loaded from: classes.dex */
    public static class o implements kh {
        public final /* synthetic */ Class a;
        public final /* synthetic */ Class b;
        public final /* synthetic */ jh d;

        public o(Class cls, Class cls2, jh jhVar) {
            this.a = cls;
            this.b = cls2;
            this.d = jhVar;
        }

        @Override // defpackage.kh
        public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
            Class<? super T> a = ugVar.a();
            if (a == this.a || a == this.b) {
                return this.d;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.a.getName() + "+" + this.b.getName() + ",adapter=" + this.d + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$p */
    /* loaded from: classes.dex */
    public static class p implements kh {
        public final /* synthetic */ Class a;
        public final /* synthetic */ jh b;

        public p(Class cls, jh jhVar) {
            this.a = cls;
            this.b = jhVar;
        }

        @Override // defpackage.kh
        public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
            if (this.a.isAssignableFrom(ugVar.a())) {
                return this.b;
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + this.b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$q */
    /* loaded from: classes.dex */
    public static /* synthetic */ class q {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[rg.values().length];
            a = iArr;
            try {
                iArr[rg.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[rg.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[rg.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[rg.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[rg.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[rg.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[rg.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[rg.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[rg.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[rg.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$r */
    /* loaded from: classes.dex */
    public static class r extends jh<Boolean> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Boolean c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            return Boolean.valueOf(qgVar.v());
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Boolean bool) throws IOException {
            sgVar.j(bool == null ? "null" : bool.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$s */
    /* loaded from: classes.dex */
    public static class s extends jh<Number> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Number c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            try {
                return Byte.valueOf((byte) qgVar.C());
            } catch (NumberFormatException e) {
                throw new hh(e);
            }
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Number number) throws IOException {
            sgVar.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$t */
    /* loaded from: classes.dex */
    public static class t extends jh<Number> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Number c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            try {
                return Short.valueOf((short) qgVar.C());
            } catch (NumberFormatException e) {
                throw new hh(e);
            }
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Number number) throws IOException {
            sgVar.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$u */
    /* loaded from: classes.dex */
    public static class u extends jh<Number> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Number c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            return Double.valueOf(qgVar.y());
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Number number) throws IOException {
            sgVar.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$v */
    /* loaded from: classes.dex */
    public static class v extends jh<Number> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Number c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            try {
                return Integer.valueOf(qgVar.C());
            } catch (NumberFormatException e) {
                throw new hh(e);
            }
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Number number) throws IOException {
            sgVar.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$w */
    /* loaded from: classes.dex */
    public static class w extends jh<Number> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Number c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            try {
                return Long.valueOf(qgVar.z());
            } catch (NumberFormatException e) {
                throw new hh(e);
            }
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Number number) throws IOException {
            sgVar.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$x */
    /* loaded from: classes.dex */
    public static class x extends jh<Number> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Number c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            return Float.valueOf((float) qgVar.y());
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Number number) throws IOException {
            sgVar.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$y */
    /* loaded from: classes.dex */
    public static class y extends jh<Number> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Number c(qg qgVar) throws IOException {
            rg t = qgVar.t();
            switch (q.a[t.ordinal()]) {
                case 1:
                    return new ig(qgVar.v());
                case 4:
                    qgVar.w();
                    return null;
                default:
                    throw new hh("Expecting number, got: " + t);
            }
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Number number) throws IOException {
            sgVar.e(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: cg$z */
    /* loaded from: classes.dex */
    public static class z extends jh<Character> {
        @Override // defpackage.jh
        /* renamed from: d */
        public Character c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            String v = qgVar.v();
            if (v.length() == 1) {
                return Character.valueOf(v.charAt(0));
            }
            throw new hh("Expecting character, got: " + v);
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Character ch) throws IOException {
            sgVar.j(ch == null ? null : String.valueOf(ch));
        }
    }

    static {
        k kVar = new k();
        a = kVar;
        b = b(Class.class, kVar);
        c cVar = new c();
        c = cVar;
        d = b(BitSet.class, cVar);
        n nVar = new n();
        e = nVar;
        f = new r();
        g = c(Boolean.TYPE, Boolean.class, nVar);
        s sVar = new s();
        h = sVar;
        i = c(Byte.TYPE, Byte.class, sVar);
        t tVar = new t();
        j = tVar;
        k = c(Short.TYPE, Short.class, tVar);
        v vVar = new v();
        l = vVar;
        m = c(Integer.TYPE, Integer.class, vVar);
        n = new w();
        o = new x();
        p = new u();
        y yVar = new y();
        q = yVar;
        r = b(Number.class, yVar);
        z zVar = new z();
        s = zVar;
        t = c(Character.TYPE, Character.class, zVar);
        a0 a0Var = new a0();
        u = a0Var;
        v = new b0();
        w = new c0();
        x = b(String.class, a0Var);
        d0 d0Var = new d0();
        y = d0Var;
        z = b(StringBuilder.class, d0Var);
        e0 e0Var = new e0();
        A = e0Var;
        B = b(StringBuffer.class, e0Var);
        a aVar = new a();
        C = aVar;
        D = b(URL.class, aVar);
        b bVar = new b();
        E = bVar;
        F = b(URI.class, bVar);
        d dVar = new d();
        G = dVar;
        H = d(InetAddress.class, dVar);
        e eVar = new e();
        I = eVar;
        J = b(UUID.class, eVar);
        K = new f();
        g gVar = new g();
        L = gVar;
        M = e(Calendar.class, GregorianCalendar.class, gVar);
        h hVar = new h();
        N = hVar;
        O = b(Locale.class, hVar);
        i iVar = new i();
        P = iVar;
        Q = d(lh.class, iVar);
        R = a();
    }

    public static kh a() {
        return new j();
    }

    public static <TT> kh b(Class<TT> cls, jh<TT> jhVar) {
        return new l(cls, jhVar);
    }

    public static <TT> kh c(Class<TT> cls, Class<TT> cls2, jh<? super TT> jhVar) {
        return new m(cls, cls2, jhVar);
    }

    public static <TT> kh d(Class<TT> cls, jh<TT> jhVar) {
        return new p(cls, jhVar);
    }

    public static <TT> kh e(Class<TT> cls, Class<? extends TT> cls2, jh<? super TT> jhVar) {
        return new o(cls, cls2, jhVar);
    }
}
