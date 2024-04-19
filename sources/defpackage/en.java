package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: ThreadUtil.java */
/* renamed from: en  reason: default package */
/* loaded from: classes.dex */
public class en {
    public static Handler a = new Handler(Looper.getMainLooper());
    public static int b = 0;
    public static ExecutorService c = new ThreadPoolExecutor(2, 4, 5000, TimeUnit.MICROSECONDS, new LinkedBlockingQueue(), new a());

    public static /* synthetic */ int a() {
        int i = b;
        b = i + 1;
        return i;
    }

    /* compiled from: ThreadUtil.java */
    /* renamed from: en$a */
    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            return new Thread(r, "Background Runner " + en.a());
        }
    }

    public static void e(Runnable runnable, long delayMs) {
        if (runnable == null) {
            return;
        }
        a.postDelayed(runnable, delayMs);
    }

    public static void c(Runnable runner) {
        ExecutorService executorService;
        if (runner != null && (executorService = c) != null) {
            executorService.submit(runner);
        }
    }

    public static void d(Runnable runner, long delayMs) {
        if (runner == null) {
            return;
        }
        a.postDelayed(new b(runner), delayMs);
    }

    /* compiled from: ThreadUtil.java */
    /* renamed from: en$b */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public final /* synthetic */ Runnable a;

        public b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (en.c != null) {
                en.c.submit(this.a);
            }
        }
    }
}
