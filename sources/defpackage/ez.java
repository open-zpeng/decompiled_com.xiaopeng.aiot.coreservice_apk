package defpackage;

import android.os.Looper;
import java.io.PrintStream;
import java.util.logging.Level;
/* compiled from: Logger.java */
/* renamed from: ez  reason: default package */
/* loaded from: classes.dex */
public interface ez {
    void a(Level level, String str);

    void b(Level level, String str, Throwable th);

    /* compiled from: Logger.java */
    /* renamed from: ez$b */
    /* loaded from: classes.dex */
    public static class b implements ez {
        @Override // defpackage.ez
        public void a(Level level, String msg) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + msg);
        }

        @Override // defpackage.ez
        public void b(Level level, String msg, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + msg);
            th.printStackTrace(System.out);
        }
    }

    /* compiled from: Logger.java */
    /* renamed from: ez$a */
    /* loaded from: classes.dex */
    public static class a {
        public static ez a() {
            if (pz.c() && b() != null) {
                return new pz("EventBus");
            }
            return new b();
        }

        public static Object b() {
            try {
                return Looper.getMainLooper();
            } catch (RuntimeException e) {
                return null;
            }
        }
    }
}
