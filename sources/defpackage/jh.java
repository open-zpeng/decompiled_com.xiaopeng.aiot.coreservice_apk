package defpackage;

import java.io.IOException;
/* compiled from: TypeAdapter.java */
/* renamed from: jh  reason: default package */
/* loaded from: classes.dex */
public abstract class jh<T> {
    public abstract void a(sg sgVar, T t) throws IOException;

    public final lh b(T t) {
        try {
            vf vfVar = new vf();
            a(vfVar, t);
            return vfVar.B();
        } catch (IOException e) {
            throw new bh(e);
        }
    }

    public abstract T c(qg qgVar) throws IOException;
}
