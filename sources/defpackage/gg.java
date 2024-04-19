package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
/* compiled from: ConstructorConstructor.java */
/* renamed from: gg  reason: default package */
/* loaded from: classes.dex */
public final class gg {
    public final Map<Type, yg<?>> a;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: gg$a */
    /* loaded from: classes.dex */
    public class a<T> implements kg<T> {
        public a() {
        }

        @Override // defpackage.kg
        public T O000000o() {
            return (T) new LinkedList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: gg$b */
    /* loaded from: classes.dex */
    public class b<T> implements kg<T> {
        public b() {
        }

        @Override // defpackage.kg
        public T O000000o() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: gg$c */
    /* loaded from: classes.dex */
    public class c<T> implements kg<T> {
        public c() {
        }

        @Override // defpackage.kg
        public T O000000o() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: gg$d */
    /* loaded from: classes.dex */
    public class d<T> implements kg<T> {
        public final /* synthetic */ yg a;
        public final /* synthetic */ Type b;

        public d(yg ygVar, Type type) {
            this.a = ygVar;
            this.b = type;
        }

        @Override // defpackage.kg
        public T O000000o() {
            return (T) this.a.a(this.b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: gg$e */
    /* loaded from: classes.dex */
    public class e<T> implements kg<T> {
        public e() {
        }

        @Override // defpackage.kg
        public T O000000o() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: gg$f */
    /* loaded from: classes.dex */
    public class f<T> implements kg<T> {
        public f() {
        }

        @Override // defpackage.kg
        public T O000000o() {
            return (T) new jg();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: gg$g */
    /* loaded from: classes.dex */
    public class g<T> implements kg<T> {
        public final lg a = lg.a();
        public final /* synthetic */ Class b;
        public final /* synthetic */ Type c;

        public g(Class cls, Type type) {
            this.b = cls;
            this.c = type;
        }

        @Override // defpackage.kg
        public T O000000o() {
            try {
                return (T) this.a.b(this.b);
            } catch (Exception e) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.c + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: gg$h */
    /* loaded from: classes.dex */
    public class h<T> implements kg<T> {
        public final /* synthetic */ yg a;
        public final /* synthetic */ Type b;

        public h(yg ygVar, Type type) {
            this.a = ygVar;
            this.b = type;
        }

        @Override // defpackage.kg
        public T O000000o() {
            return (T) this.a.a(this.b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: gg$i */
    /* loaded from: classes.dex */
    public class i<T> implements kg<T> {
        public final /* synthetic */ Constructor a;

        public i(Constructor constructor) {
            this.a = constructor;
        }

        @Override // defpackage.kg
        public T O000000o() {
            try {
                return (T) this.a.newInstance(null);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e3.getTargetException());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: gg$j */
    /* loaded from: classes.dex */
    public class j<T> implements kg<T> {
        public j() {
        }

        @Override // defpackage.kg
        public T O000000o() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: gg$k */
    /* loaded from: classes.dex */
    public class k<T> implements kg<T> {
        public final /* synthetic */ Type a;

        public k(Type type) {
            this.a = type;
        }

        @Override // defpackage.kg
        public T O000000o() {
            Type type = this.a;
            if (!(type instanceof ParameterizedType)) {
                throw new bh("Invalid EnumSet type: " + this.a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new bh("Invalid EnumSet type: " + this.a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: gg$l */
    /* loaded from: classes.dex */
    public class l<T> implements kg<T> {
        public l() {
        }

        @Override // defpackage.kg
        public T O000000o() {
            return (T) new LinkedHashSet();
        }
    }

    public gg(Map<Type, yg<?>> map) {
        this.a = map;
    }

    public <T> kg<T> a(ug<T> ugVar) {
        Type d2 = ugVar.d();
        Class<? super T> a2 = ugVar.a();
        yg<?> ygVar = this.a.get(d2);
        if (ygVar != null) {
            return new d(ygVar, d2);
        }
        yg<?> ygVar2 = this.a.get(a2);
        if (ygVar2 != null) {
            return new h(ygVar2, d2);
        }
        kg<T> b2 = b(a2);
        if (b2 != null) {
            return b2;
        }
        kg<T> c2 = c(d2, a2);
        return c2 != null ? c2 : d(d2, a2);
    }

    public final <T> kg<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new i(declaredConstructor);
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    public final <T> kg<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new j() : EnumSet.class.isAssignableFrom(cls) ? new k(type) : Set.class.isAssignableFrom(cls) ? new l() : Queue.class.isAssignableFrom(cls) ? new a() : new b();
        } else if (Map.class.isAssignableFrom(cls)) {
            return SortedMap.class.isAssignableFrom(cls) ? new c() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(ug.c(((ParameterizedType) type).getActualTypeArguments()[0]).a())) ? new f() : new e();
        } else {
            return null;
        }
    }

    public final <T> kg<T> d(Type type, Class<? super T> cls) {
        return new g(cls, type);
    }

    public String toString() {
        return this.a.toString();
    }
}
