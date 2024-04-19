package defpackage;

import java.io.IOException;
import java.util.ArrayList;
/* compiled from: ObjectTypeAdapter.java */
/* renamed from: yf  reason: default package */
/* loaded from: classes.dex */
public final class yf extends jh<Object> {
    public static final kh a = new a();
    public final xg b;

    /* compiled from: ObjectTypeAdapter.java */
    /* renamed from: yf$a */
    /* loaded from: classes.dex */
    public static class a implements kh {
        @Override // defpackage.kh
        public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
            if (ugVar.a() == Object.class) {
                return new yf(xgVar, null);
            }
            return null;
        }
    }

    /* compiled from: ObjectTypeAdapter.java */
    /* renamed from: yf$b */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[rg.values().length];
            a = iArr;
            try {
                iArr[rg.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[rg.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[rg.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[rg.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[rg.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[rg.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public yf(xg xgVar) {
        this.b = xgVar;
    }

    public /* synthetic */ yf(xg xgVar, a aVar) {
        this(xgVar);
    }

    @Override // defpackage.jh
    public void a(sg sgVar, Object obj) throws IOException {
        if (obj == null) {
            sgVar.u();
            return;
        }
        jh e = this.b.e(obj.getClass());
        if (!(e instanceof yf)) {
            e.a(sgVar, obj);
            return;
        }
        sgVar.m();
        sgVar.s();
    }

    @Override // defpackage.jh
    public Object c(qg qgVar) throws IOException {
        switch (b.a[qgVar.t().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                qgVar.c();
                while (qgVar.s()) {
                    arrayList.add(c(qgVar));
                }
                qgVar.l();
                return arrayList;
            case 2:
                jg jgVar = new jg();
                qgVar.q();
                while (qgVar.s()) {
                    jgVar.put(qgVar.u(), c(qgVar));
                }
                qgVar.o();
                return jgVar;
            case 3:
                return qgVar.v();
            case 4:
                return Double.valueOf(qgVar.y());
            case 5:
                return Boolean.valueOf(qgVar.x());
            case 6:
                qgVar.w();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
