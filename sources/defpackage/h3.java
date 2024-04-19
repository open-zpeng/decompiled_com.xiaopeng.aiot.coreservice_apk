package defpackage;

import java.util.concurrent.Executor;
/* compiled from: ArchTaskExecutor.java */
/* renamed from: h3  reason: default package */
/* loaded from: classes.dex */
public class h3 extends j3 {
    public static volatile h3 a;
    public static final Executor b = new a();
    public static final Executor c = new b();
    public j3 d;
    public j3 e;

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: h3$a */
    /* loaded from: classes.dex */
    public static class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            h3.d().c(command);
        }
    }

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: h3$b */
    /* loaded from: classes.dex */
    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            h3.d().a(command);
        }
    }

    public h3() {
        i3 i3Var = new i3();
        this.e = i3Var;
        this.d = i3Var;
    }

    public static h3 d() {
        if (a != null) {
            return a;
        }
        synchronized (h3.class) {
            if (a == null) {
                a = new h3();
            }
        }
        return a;
    }

    @Override // defpackage.j3
    public void a(Runnable runnable) {
        this.d.a(runnable);
    }

    @Override // defpackage.j3
    public void c(Runnable runnable) {
        this.d.c(runnable);
    }

    @Override // defpackage.j3
    public boolean b() {
        return this.d.b();
    }
}
