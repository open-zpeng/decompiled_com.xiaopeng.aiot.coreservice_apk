package defpackage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: ReflectiveTypeAdapterFactory.java */
/* renamed from: xf  reason: default package */
/* loaded from: classes.dex */
public final class xf implements kh {
    public final gg a;
    public final wg b;
    public final fg d;

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: xf$a */
    /* loaded from: classes.dex */
    public class a extends c {
        public final jh<?> d;
        public final /* synthetic */ xg e;
        public final /* synthetic */ ug f;
        public final /* synthetic */ Field g;
        public final /* synthetic */ boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, boolean z, boolean z2, xg xgVar, ug ugVar, Field field, boolean z3) {
            super(str, z, z2);
            this.e = xgVar;
            this.f = ugVar;
            this.g = field;
            this.h = z3;
            this.d = xgVar.b(ugVar);
        }

        @Override // defpackage.xf.c
        public void a(qg qgVar, Object obj) throws IOException, IllegalAccessException {
            Object c = this.d.c(qgVar);
            if (c == null && this.h) {
                return;
            }
            this.g.set(obj, c);
        }

        @Override // defpackage.xf.c
        public void b(sg sgVar, Object obj) throws IOException, IllegalAccessException {
            new bg(this.e, this.d, this.f.d()).a(sgVar, this.g.get(obj));
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: xf$b */
    /* loaded from: classes.dex */
    public static final class b<T> extends jh<T> {
        public final kg<T> a;
        public final Map<String, c> b;

        public b(kg<T> kgVar, Map<String, c> map) {
            this.a = kgVar;
            this.b = map;
        }

        public /* synthetic */ b(kg kgVar, Map map, a aVar) {
            this(kgVar, map);
        }

        @Override // defpackage.jh
        public void a(sg sgVar, T t) throws IOException {
            if (t == null) {
                sgVar.u();
                return;
            }
            sgVar.m();
            try {
                for (c cVar : this.b.values()) {
                    if (cVar.b) {
                        sgVar.f(cVar.a);
                        cVar.b(sgVar, t);
                    }
                }
                sgVar.s();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }

        @Override // defpackage.jh
        public T c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            T O000000o = this.a.O000000o();
            try {
                qgVar.q();
                while (qgVar.s()) {
                    c cVar = this.b.get(qgVar.u());
                    if (cVar != null && cVar.c) {
                        cVar.a(qgVar, O000000o);
                    }
                    qgVar.B();
                }
                qgVar.o();
                return O000000o;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new hh(e2);
            }
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: xf$c */
    /* loaded from: classes.dex */
    public static abstract class c {
        public final String a;
        public final boolean b;
        public final boolean c;

        public c(String str, boolean z, boolean z2) {
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        public abstract void a(qg qgVar, Object obj) throws IOException, IllegalAccessException;

        public abstract void b(sg sgVar, Object obj) throws IOException, IllegalAccessException;
    }

    public xf(gg ggVar, wg wgVar, fg fgVar) {
        this.a = ggVar;
        this.b = wgVar;
        this.d = fgVar;
    }

    @Override // defpackage.kh
    public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
        Class<? super T> a2 = ugVar.a();
        if (Object.class.isAssignableFrom(a2)) {
            return new b(this.a.a(ugVar), d(xgVar, ugVar, a2), null);
        }
        return null;
    }

    public final c b(xg xgVar, Field field, String str, ug<?> ugVar, boolean z, boolean z2) {
        return new a(str, z, z2, xgVar, ugVar, field, ng.c(ugVar.a()));
    }

    public final String c(Field field) {
        of ofVar = (of) field.getAnnotation(of.class);
        return ofVar == null ? this.b.a(field) : ofVar.O000000o();
    }

    public final Map<String, c> d(xg xgVar, ug<?> ugVar, Class<?> cls) {
        Field[] declaredFields;
        c cVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type d = ugVar.d();
        ug<?> ugVar2 = ugVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            for (Field field : cls2.getDeclaredFields()) {
                boolean e = e(field, true);
                boolean e2 = e(field, false);
                if (e || e2) {
                    field.setAccessible(true);
                    c b2 = b(xgVar, field, c(field), ug.c(eg.h(ugVar2.d(), cls2, field.getGenericType())), e, e2);
                    if (((c) linkedHashMap.put(b2.a, b2)) != null) {
                        throw new IllegalArgumentException(d + " declares multiple JSON fields named " + cVar.a);
                    }
                }
            }
            ugVar2 = ug.c(eg.h(ugVar2.d(), cls2, cls2.getGenericSuperclass()));
            cls2 = ugVar2.a();
        }
        return linkedHashMap;
    }

    public boolean e(Field field, boolean z) {
        return (this.d.g(field.getType(), z) || this.d.h(field, z)) ? false : true;
    }
}
