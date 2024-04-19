package defpackage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* compiled from: ArrayTypeAdapter.java */
/* renamed from: rf  reason: default package */
/* loaded from: classes.dex */
public final class rf<E> extends jh<Object> {
    public static final kh a = new a();
    public final Class<E> b;
    public final jh<E> c;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: rf$a */
    /* loaded from: classes.dex */
    public static class a implements kh {
        @Override // defpackage.kh
        public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
            Type d = ugVar.d();
            if ((d instanceof GenericArrayType) || ((d instanceof Class) && ((Class) d).isArray())) {
                Type t = eg.t(d);
                return new rf(xgVar, xgVar.b(ug.c(t)), eg.r(t));
            }
            return null;
        }
    }

    public rf(xg xgVar, jh<E> jhVar, Class<E> cls) {
        this.c = new bg(xgVar, jhVar, cls);
        this.b = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.jh
    public void a(sg sgVar, Object obj) throws IOException {
        if (obj == null) {
            sgVar.u();
            return;
        }
        sgVar.i();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.a(sgVar, Array.get(obj, i));
        }
        sgVar.p();
    }

    @Override // defpackage.jh
    public Object c(qg qgVar) throws IOException {
        if (qgVar.t() == rg.NULL) {
            qgVar.w();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        qgVar.c();
        while (qgVar.s()) {
            arrayList.add(this.c.c(qgVar));
        }
        qgVar.l();
        Object newInstance = Array.newInstance((Class<?>) this.b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
