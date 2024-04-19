package defpackage;

import java.util.Comparator;
import java.util.concurrent.Callable;
/* compiled from: Functions.java */
/* renamed from: jt  reason: default package */
/* loaded from: classes.dex */
public final class jt {
    public static final zs<Object, Object> a = new g();
    public static final Runnable b = new d();
    public static final us c = new a();
    public static final ys<Object> d = new b();
    public static final ys<Throwable> e = new e();
    public static final ys<Throwable> f = new k();
    public static final at g = new c();
    public static final bt<Object> h = new l();
    public static final bt<Object> i = new f();
    public static final Callable<Object> j = new j();
    public static final Comparator<Object> k = new i();
    public static final ys<sz> l = new h();

    /* compiled from: Functions.java */
    /* renamed from: jt$c */
    /* loaded from: classes.dex */
    public static final class c implements at {
    }

    public static <T> zs<T, T> c() {
        return (zs<T, T>) a;
    }

    public static <T> ys<T> b() {
        return (ys<T>) d;
    }

    public static <T> bt<T> a() {
        return (bt<T>) h;
    }

    /* compiled from: Functions.java */
    /* renamed from: jt$g */
    /* loaded from: classes.dex */
    public static final class g implements zs<Object, Object> {
        @Override // defpackage.zs
        public Object apply(Object v) {
            return v;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: jt$d */
    /* loaded from: classes.dex */
    public static final class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: jt$a */
    /* loaded from: classes.dex */
    public static final class a implements us {
        @Override // defpackage.us
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: jt$b */
    /* loaded from: classes.dex */
    public static final class b implements ys<Object> {
        @Override // defpackage.ys
        public void accept(Object v) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: jt$e */
    /* loaded from: classes.dex */
    public static final class e implements ys<Throwable> {
        @Override // defpackage.ys
        /* renamed from: a */
        public void accept(Throwable error) {
            iv.m(error);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: jt$k */
    /* loaded from: classes.dex */
    public static final class k implements ys<Throwable> {
        @Override // defpackage.ys
        /* renamed from: a */
        public void accept(Throwable error) {
            iv.m(new rs(error));
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: jt$l */
    /* loaded from: classes.dex */
    public static final class l implements bt<Object> {
        @Override // defpackage.bt
        public boolean test(Object o) {
            return true;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: jt$f */
    /* loaded from: classes.dex */
    public static final class f implements bt<Object> {
        @Override // defpackage.bt
        public boolean test(Object o) {
            return false;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: jt$j */
    /* loaded from: classes.dex */
    public static final class j implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: jt$i */
    /* loaded from: classes.dex */
    public static final class i implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object a, Object b) {
            return ((Comparable) a).compareTo(b);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: jt$h */
    /* loaded from: classes.dex */
    public static final class h implements ys<sz> {
        @Override // defpackage.ys
        /* renamed from: a */
        public void accept(sz t) throws Exception {
            t.request(Long.MAX_VALUE);
        }
    }
}
