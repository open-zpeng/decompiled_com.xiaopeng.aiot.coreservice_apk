package defpackage;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TaskExecutor.java */
/* renamed from: ek  reason: default package */
/* loaded from: classes.dex */
public class ek {
    public static ThreadPoolExecutor a;
    public static ek f;
    public HandlerThread h;
    public Handler i;
    public static int b = 1;
    public static int c = 2;
    public static int d = 10;
    public static int e = 60;
    public static final AtomicInteger g = new AtomicInteger();

    public static /* synthetic */ ThreadPoolExecutor f() {
        return b();
    }

    /* compiled from: TaskExecutor.java */
    /* renamed from: ek$b */
    /* loaded from: classes.dex */
    public static class b implements ThreadFactory {
        public int a;

        public b(int i) {
            this.a = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            int andIncrement = ek.g.getAndIncrement();
            Thread thread = new Thread(r, "AppMonitor:" + andIncrement);
            thread.setPriority(this.a);
            return thread;
        }
    }

    @TargetApi(9)
    public static ThreadPoolExecutor c(int i, int i2, int i3, int i4, int i5) {
        LinkedBlockingQueue linkedBlockingQueue;
        if (i5 > 0) {
            linkedBlockingQueue = new LinkedBlockingQueue(i5);
        } else {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        return new ThreadPoolExecutor(i2, i3, i4, TimeUnit.SECONDS, linkedBlockingQueue, new b(i), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public static synchronized ThreadPoolExecutor b() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (ek.class) {
            if (a == null) {
                a = c(b, c, d, e, IInputController.KEYCODE_KNOB_WIND_SPD_UP);
            }
            threadPoolExecutor = a;
        }
        return threadPoolExecutor;
    }

    public static synchronized ek a() {
        ek ekVar;
        synchronized (ek.class) {
            if (f == null) {
                f = new ek();
            }
            ekVar = f;
        }
        return ekVar;
    }

    public ek() {
        HandlerThread handlerThread = new HandlerThread("AppMonitor");
        this.h = handlerThread;
        handlerThread.start();
        this.i = new a(this.h.getLooper());
    }

    /* compiled from: TaskExecutor.java */
    /* renamed from: ek$a */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            try {
                Object obj = msg.obj;
                if (obj != null && (obj instanceof Runnable)) {
                    ek.f().submit((Runnable) msg.obj);
                }
            } catch (Throwable th) {
            }
        }
    }

    public final void e(int i, Runnable runnable, long j) {
        try {
            Message obtain = Message.obtain(this.i, i);
            obtain.obj = runnable;
            this.i.sendMessageDelayed(obtain, j);
        } catch (Exception e2) {
            di.d(e2);
        }
    }

    public final void i(int i) {
        this.i.removeMessages(i);
    }

    public final boolean h(int i) {
        return this.i.hasMessages(i);
    }

    public void g(Runnable runnable) {
        try {
            b().submit(runnable);
        } catch (Throwable th) {
        }
    }
}
