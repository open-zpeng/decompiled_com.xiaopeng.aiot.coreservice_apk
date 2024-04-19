package defpackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: LogStoreMgr.java */
/* renamed from: jj  reason: default package */
/* loaded from: classes.dex */
public class jj {
    public static jj a;
    public List<com.alibaba.mtl.log.model.a> c = new CopyOnWriteArrayList();
    public Runnable d = new a();
    public hj b = new ij(ej.i());

    /* compiled from: LogStoreMgr.java */
    /* renamed from: jj$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jj.this.a();
        }
    }

    public jj() {
        lj.c().f();
        ek.a().g(new b());
    }

    public static synchronized jj f() {
        jj jjVar;
        synchronized (jj.class) {
            if (a == null) {
                a = new jj();
            }
            jjVar = a;
        }
        return jjVar;
    }

    public void i(com.alibaba.mtl.log.model.a aVar) {
        vj.c("LogStoreMgr", "[add] :", aVar.X);
        fj.j(aVar.T);
        this.c.add(aVar);
        if (this.c.size() >= 100) {
            ek.a().i(1);
            ek.a().e(1, this.d, 0L);
        } else if (!ek.a().h(1)) {
            ek.a().e(1, this.d, 5000L);
        }
    }

    public int d(List<com.alibaba.mtl.log.model.a> list) {
        vj.c("LogStoreMgr", list);
        return this.b.a(list);
    }

    public List<com.alibaba.mtl.log.model.a> g(String str, int i) {
        List<com.alibaba.mtl.log.model.a> a2 = this.b.a(str, i);
        vj.c("LogStoreMgr", "[get]", a2);
        return a2;
    }

    public synchronized void a() {
        vj.c("LogStoreMgr", "[store]");
        ArrayList arrayList = null;
        try {
            synchronized (this.c) {
                if (this.c.size() > 0) {
                    arrayList = new ArrayList(this.c);
                    this.c.clear();
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                this.b.mo50a((List<com.alibaba.mtl.log.model.a>) arrayList);
            }
        } catch (Throwable th) {
        }
    }

    public void k() {
        vj.c("LogStoreMgr", "[clear]");
        this.b.clear();
        this.c.clear();
    }

    public final void b() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -3);
        this.b.b("time", String.valueOf(calendar.getTimeInMillis()));
    }

    public final void c() {
        this.b.d(1000);
    }

    /* compiled from: LogStoreMgr.java */
    /* renamed from: jj$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jj.this.b();
            if (jj.this.b.c() > 9000) {
                jj.this.c();
            }
        }
    }
}
