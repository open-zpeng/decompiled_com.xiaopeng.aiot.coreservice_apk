package defpackage;
/* compiled from: CleanTask.java */
/* renamed from: ei  reason: default package */
/* loaded from: classes.dex */
public class ei implements Runnable {
    public static boolean a = false;
    public static long b = 300000;
    public static ei d;

    public static void b() {
        if (!a) {
            vj.c("CleanTask", "init TimeoutEventManager");
            d = new ei();
            ek.a().e(5, d, b);
            a = true;
        }
    }

    public static void a() {
        ek.a().i(5);
        a = false;
        d = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        vj.c("CleanTask", "clean TimeoutEvent");
        yh.b().r();
        ek.a().e(5, d, b);
    }
}
