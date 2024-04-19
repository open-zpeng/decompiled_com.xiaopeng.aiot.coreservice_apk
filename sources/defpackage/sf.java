package defpackage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* compiled from: CollectionTypeAdapterFactory.java */
/* renamed from: sf  reason: default package */
/* loaded from: classes.dex */
public final class sf implements kh {
    public final gg a;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* renamed from: sf$a */
    /* loaded from: classes.dex */
    public static final class a<E> extends jh<Collection<E>> {
        public final jh<E> a;
        public final kg<? extends Collection<E>> b;

        public a(xg xgVar, Type type, jh<E> jhVar, kg<? extends Collection<E>> kgVar) {
            this.a = new bg(xgVar, jhVar, type);
            this.b = kgVar;
        }

        @Override // defpackage.jh
        /* renamed from: d */
        public Collection<E> c(qg qgVar) throws IOException {
            if (qgVar.t() == rg.NULL) {
                qgVar.w();
                return null;
            }
            Collection<E> O000000o = this.b.O000000o();
            qgVar.c();
            while (qgVar.s()) {
                O000000o.add(this.a.c(qgVar));
            }
            qgVar.l();
            return O000000o;
        }

        @Override // defpackage.jh
        /* renamed from: e */
        public void a(sg sgVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                sgVar.u();
                return;
            }
            sgVar.i();
            for (E e : collection) {
                this.a.a(sgVar, e);
            }
            sgVar.p();
        }
    }

    public sf(gg ggVar) {
        this.a = ggVar;
    }

    @Override // defpackage.kh
    public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
        Type d = ugVar.d();
        Class<? super T> a2 = ugVar.a();
        if (Collection.class.isAssignableFrom(a2)) {
            Type f = eg.f(d, a2);
            return new a(xgVar, f, xgVar.b(ug.c(f)), this.a.a(ugVar));
        }
        return null;
    }
}
