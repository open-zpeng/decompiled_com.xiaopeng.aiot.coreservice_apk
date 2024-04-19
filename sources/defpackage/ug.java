package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* compiled from: TypeToken.java */
/* renamed from: ug  reason: default package */
/* loaded from: classes.dex */
public class ug<T> {
    public final Class<? super T> a;
    public final Type b;
    public final int c;

    public ug() {
        Type b = b(ug.class);
        this.b = b;
        this.a = (Class<? super T>) eg.r(b);
        this.c = b.hashCode();
    }

    public ug(Type type) {
        Type p = eg.p((Type) dg.a(type));
        this.b = p;
        this.a = (Class<? super T>) eg.r(p);
        this.c = p.hashCode();
    }

    public static Type b(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return eg.p(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public static ug<?> c(Type type) {
        return new ug<>(type);
    }

    public static <T> ug<T> e(Class<T> cls) {
        return new ug<>(cls);
    }

    public final Class<? super T> a() {
        return this.a;
    }

    public final Type d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ug) && eg.k(this.b, ((ug) obj).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return eg.s(this.b);
    }
}
