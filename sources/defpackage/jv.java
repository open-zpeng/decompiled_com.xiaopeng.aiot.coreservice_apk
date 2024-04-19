package defpackage;

import java.util.concurrent.Callable;
/* compiled from: Schedulers.java */
/* renamed from: jv  reason: default package */
/* loaded from: classes.dex */
public final class jv {
    public static final gs a = iv.h(new h());
    public static final gs b = iv.e(new b());
    public static final gs c = iv.f(new c());
    public static final gs d = yu.d();
    public static final gs e = iv.g(new f());

    /* compiled from: Schedulers.java */
    /* renamed from: jv$a */
    /* loaded from: classes.dex */
    public static final class a {
        public static final gs a = new pu();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: jv$d */
    /* loaded from: classes.dex */
    public static final class d {
        public static final gs a = new qu();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: jv$e */
    /* loaded from: classes.dex */
    public static final class e {
        public static final gs a = new ru();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: jv$g */
    /* loaded from: classes.dex */
    public static final class g {
        public static final gs a = new xu();
    }

    public static gs a() {
        return iv.l(b);
    }

    public static gs b() {
        return iv.n(c);
    }

    public static gs c() {
        return d;
    }

    /* compiled from: Schedulers.java */
    /* renamed from: jv$c */
    /* loaded from: classes.dex */
    public static final class c implements Callable<gs> {
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public gs call() throws Exception {
            return d.a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: jv$f */
    /* loaded from: classes.dex */
    public static final class f implements Callable<gs> {
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public gs call() throws Exception {
            return e.a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: jv$h */
    /* loaded from: classes.dex */
    public static final class h implements Callable<gs> {
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public gs call() throws Exception {
            return g.a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: jv$b */
    /* loaded from: classes.dex */
    public static final class b implements Callable<gs> {
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public gs call() throws Exception {
            return a.a;
        }
    }
}
