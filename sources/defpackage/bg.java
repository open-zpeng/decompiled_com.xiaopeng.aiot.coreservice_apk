package defpackage;

import defpackage.xf;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* renamed from: bg  reason: default package */
/* loaded from: classes.dex */
public final class bg<T> extends jh<T> {
    public final xg a;
    public final jh<T> b;
    public final Type c;

    public bg(xg xgVar, jh<T> jhVar, Type type) {
        this.a = xgVar;
        this.b = jhVar;
        this.c = type;
    }

    @Override // defpackage.jh
    public void a(sg sgVar, T t) throws IOException {
        jh<T> jhVar = this.b;
        Type d = d(this.c, t);
        if (d != this.c) {
            jhVar = this.a.b(ug.c(d));
            if (jhVar instanceof xf.b) {
                jh<T> jhVar2 = this.b;
                if (!(jhVar2 instanceof xf.b)) {
                    jhVar = jhVar2;
                }
            }
        }
        jhVar.a(sgVar, t);
    }

    @Override // defpackage.jh
    public T c(qg qgVar) throws IOException {
        return this.b.c(qgVar);
    }

    public final Type d(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }
}
