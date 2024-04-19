package defpackage;

import java.util.Random;
/* compiled from: UploadEngine.java */
/* renamed from: lj  reason: default package */
/* loaded from: classes.dex */
public class lj {
    public static lj a = new lj();
    public long b = zi.a();
    public boolean c = false;
    public int d;

    public static lj c() {
        return a;
    }

    public synchronized void f() {
        this.c = true;
        if (ek.a().h(2)) {
            ek.a().i(2);
        }
        e();
        Random random = new Random();
        if (!mj.k()) {
            ek.a().e(2, new a(), random.nextInt((int) this.b));
        }
    }

    /* compiled from: UploadEngine.java */
    /* renamed from: lj$a */
    /* loaded from: classes.dex */
    public class a extends mj {
        public a() {
        }

        @Override // defpackage.mj
        public void a() {
            if (lj.this.c) {
                fj.d();
                lj.this.e();
                vj.c("UploadTask", "mPeriod:", Long.valueOf(lj.this.b));
                if (ek.a().h(2)) {
                    ek.a().i(2);
                }
                if (!mj.k()) {
                    ek.a().e(2, this, lj.this.b);
                }
            }
        }

        @Override // defpackage.mj
        public void b() {
            lj.this.a();
        }
    }

    public void a() {
        if (this.d == 0) {
            this.d = 7000;
        } else {
            this.d = 0;
        }
    }

    public synchronized void g() {
        this.c = false;
        ek.a().i(2);
    }

    public final long e() {
        long a2;
        vj.c("UploadEngine", "UTDC.bBackground:", Boolean.valueOf(ej.c), "AppInfoUtil.isForeground(UTDC.getContext()) ", Boolean.valueOf(oj.b(ej.i())));
        boolean z = !oj.b(ej.i());
        ej.c = z;
        zi.a();
        if (z) {
            a2 = zi.f() + this.d;
        } else {
            a2 = zi.a() + this.d;
        }
        this.b = a2;
        if (zi.h()) {
            this.b = 3000L;
        }
        return this.b;
    }
}
