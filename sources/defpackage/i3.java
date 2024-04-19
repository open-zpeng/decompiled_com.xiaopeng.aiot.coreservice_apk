package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: DefaultTaskExecutor.java */
/* renamed from: i3  reason: default package */
/* loaded from: classes.dex */
public class i3 extends j3 {
    public final Object a = new Object();
    public final ExecutorService b = Executors.newFixedThreadPool(4, new a());
    public volatile Handler c;

    /* compiled from: DefaultTaskExecutor.java */
    /* renamed from: i3$a */
    /* loaded from: classes.dex */
    public class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(0);

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.a.getAndIncrement())));
            return t;
        }
    }

    @Override // defpackage.j3
    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    @Override // defpackage.j3
    public void c(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.a) {
                if (this.c == null) {
                    this.c = d(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }

    @Override // defpackage.j3
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static Handler d(Looper looper) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return Handler.createAsync(looper);
        }
        if (i >= 16) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, true);
            } catch (IllegalAccessException e) {
            } catch (InstantiationException e2) {
            } catch (NoSuchMethodException e3) {
            } catch (InvocationTargetException e4) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }
}
