package defpackage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* compiled from: Excluder.java */
/* renamed from: fg  reason: default package */
/* loaded from: classes.dex */
public final class fg implements kh, Cloneable {
    public static final fg a = new fg();
    public boolean g;
    public double b = -1.0d;
    public int d = 136;
    public boolean f = true;
    public List<og> h = Collections.emptyList();
    public List<og> i = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Excluder.java */
    /* renamed from: fg$a */
    /* loaded from: classes.dex */
    public class a<T> extends jh<T> {
        public jh<T> a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ xg d;
        public final /* synthetic */ ug e;

        public a(boolean z, boolean z2, xg xgVar, ug ugVar) {
            this.b = z;
            this.c = z2;
            this.d = xgVar;
            this.e = ugVar;
        }

        @Override // defpackage.jh
        public void a(sg sgVar, T t) throws IOException {
            if (this.c) {
                sgVar.u();
            } else {
                d().a(sgVar, t);
            }
        }

        @Override // defpackage.jh
        public T c(qg qgVar) throws IOException {
            if (this.b) {
                qgVar.B();
                return null;
            }
            return d().c(qgVar);
        }

        public final jh<T> d() {
            jh<T> jhVar = this.a;
            if (jhVar != null) {
                return jhVar;
            }
            jh<T> d = this.d.d(fg.this, this.e);
            this.a = d;
            return d;
        }
    }

    @Override // defpackage.kh
    public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
        Class<? super T> a2 = ugVar.a();
        boolean g = g(a2, true);
        boolean g2 = g(a2, false);
        if (g || g2) {
            return new a(g2, g, xgVar, ugVar);
        }
        return null;
    }

    /* renamed from: b */
    public fg clone() {
        try {
            return (fg) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public final boolean c(pf pfVar) {
        return pfVar == null || pfVar.O000000o() <= this.b;
    }

    public final boolean d(pf pfVar, qf qfVar) {
        return c(pfVar) && e(qfVar);
    }

    public final boolean e(qf qfVar) {
        return qfVar == null || qfVar.O000000o() > this.b;
    }

    public final boolean f(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public boolean g(Class<?> cls, boolean z) {
        if (this.b == -1.0d || d((pf) cls.getAnnotation(pf.class), (qf) cls.getAnnotation(qf.class))) {
            if ((this.f || !i(cls)) && !f(cls)) {
                for (og ogVar : z ? this.h : this.i) {
                    if (ogVar.b(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean h(Field field, boolean z) {
        nf nfVar;
        if ((this.d & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.b == -1.0d || d((pf) field.getAnnotation(pf.class), (qf) field.getAnnotation(qf.class))) && !field.isSynthetic()) {
            if (!this.g || ((nfVar = (nf) field.getAnnotation(nf.class)) != null && (!z ? !nfVar.O00000Oo() : !nfVar.O000000o()))) {
                if ((this.f || !i(field.getType())) && !f(field.getType())) {
                    List<og> list = z ? this.h : this.i;
                    if (list.isEmpty()) {
                        return false;
                    }
                    vg vgVar = new vg(field);
                    for (og ogVar : list) {
                        if (ogVar.a(vgVar)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public final boolean i(Class<?> cls) {
        return cls.isMemberClass() && !j(cls);
    }

    public final boolean j(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }
}
