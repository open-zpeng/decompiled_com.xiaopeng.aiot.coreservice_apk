package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: ThreadUtils.java */
/* renamed from: wn  reason: default package */
/* loaded from: classes.dex */
public class wn {
    public static final ExecutorService a = Executors.newFixedThreadPool(4, new d(null).f("order-%d").e(false).d());
    public static ConcurrentHashMap<Object, c> b = new ConcurrentHashMap<>();
    public static Handler c;
    public static volatile HandlerThread d;
    public static Handler e;
    public static volatile HandlerThread f;
    public static Handler g;

    public static Looper g(int threadType) {
        switch (threadType) {
            case 0:
                c();
                return d.getLooper();
            case 1:
                d();
                return c.getLooper();
            case 2:
                e();
                return g.getLooper();
            default:
                throw new IllegalArgumentException("invalid threadType:" + threadType);
        }
    }

    public static void h(int threadType, Runnable task) {
        f(threadType, null, task, null, false, 0L);
    }

    public static void i(Runnable task) {
        f(0, null, task, null, false, 0L);
    }

    public static void j(Runnable task, long delayMillis) {
        f(0, null, task, null, false, delayMillis);
    }

    public static void f(int threadType, Runnable preCallback, Runnable task, Runnable postCallback, boolean callbackToMainThread, long delayMillis) {
        Handler handler;
        Handler handler2;
        Looper myLooper;
        if (task == null) {
            return;
        }
        if (c == null) {
            d();
        }
        switch (threadType) {
            case 0:
                if (d == null) {
                    c();
                }
                handler = e;
                break;
            case 1:
                handler = c;
                break;
            case 2:
                if (f == null) {
                    e();
                }
                handler = g;
                break;
            default:
                handler = c;
                break;
        }
        if (handler != null) {
            handler2 = handler;
        } else {
            Handler handler3 = c;
            handler2 = handler3;
        }
        Handler finalHandler = handler2;
        if (callbackToMainThread) {
            myLooper = null;
        } else {
            Looper myLooper2 = Looper.myLooper();
            if (myLooper2 != null) {
                myLooper = myLooper2;
            } else {
                Looper myLooper3 = c.getLooper();
                myLooper = myLooper3;
            }
        }
        Looper looper = myLooper;
        Runnable postRunnable = new a(task, postCallback, callbackToMainThread, looper);
        Runnable realRunnable = new b(preCallback, callbackToMainThread, looper, finalHandler, postRunnable);
        if (preCallback == null) {
            b.put(task, new c(realRunnable, Integer.valueOf(threadType)));
        } else {
            b.put(task, new c(postRunnable, Integer.valueOf(threadType)));
        }
        pn.a("ThreadUtils", "put task: " + task);
        finalHandler.postDelayed(realRunnable, delayMillis);
    }

    /* compiled from: ThreadUtils.java */
    /* renamed from: wn$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ Runnable b;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Looper f;

        public a(Runnable runnable, Runnable runnable2, boolean z, Looper looper) {
            this.a = runnable;
            this.b = runnable2;
            this.d = z;
            this.f = looper;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Throwable t) {
                t.printStackTrace();
            }
            if (this.b != null) {
                if (this.d || this.f == wn.c.getLooper()) {
                    wn.c.post(this.b);
                } else {
                    new Handler(this.f).post(this.b);
                }
            }
            pn.a("ThreadUtils", "remove task: " + this.a);
            wn.b.remove(this.a);
        }
    }

    /* compiled from: ThreadUtils.java */
    /* renamed from: wn$b */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Looper d;
        public final /* synthetic */ Handler f;
        public final /* synthetic */ Runnable g;

        public b(Runnable runnable, boolean z, Looper looper, Handler handler, Runnable runnable2) {
            this.a = runnable;
            this.b = z;
            this.d = looper;
            this.f = handler;
            this.g = runnable2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a != null) {
                if (this.b || this.d == wn.c.getLooper()) {
                    wn.c.post(new a());
                    return;
                } else {
                    new Handler(this.d).post(new RunnableC0025b());
                    return;
                }
            }
            this.g.run();
        }

        /* compiled from: ThreadUtils.java */
        /* renamed from: wn$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.a.run();
                b bVar = b.this;
                bVar.f.post(bVar.g);
            }
        }

        /* compiled from: ThreadUtils.java */
        /* renamed from: wn$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0025b implements Runnable {
            public RunnableC0025b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.a.run();
                b bVar = b.this;
                bVar.f.post(bVar.g);
            }
        }
    }

    /* compiled from: ThreadUtils.java */
    /* renamed from: wn$c */
    /* loaded from: classes.dex */
    public static class c {
        public Runnable a;
        public Integer b;

        public c(Runnable runnable, Integer type) {
            this.a = runnable;
            this.b = type;
        }
    }

    public static synchronized void d() {
        synchronized (wn.class) {
            if (c == null) {
                c = new Handler(Looper.getMainLooper());
            }
        }
    }

    public static synchronized void c() {
        synchronized (wn.class) {
            if (d == null) {
                d = new HandlerThread("BackgroundHandler", 10);
                d.start();
                e = new Handler(d.getLooper());
            }
        }
    }

    public static synchronized void e() {
        synchronized (wn.class) {
            if (f == null) {
                f = new HandlerThread("NormalHandler", 0);
                f.start();
                g = new Handler(f.getLooper());
            }
        }
    }

    /* compiled from: ThreadUtils.java */
    /* renamed from: wn$d */
    /* loaded from: classes.dex */
    public static class d {
        public String a;
        public boolean b;
        public ThreadFactory c;
        public String d;

        public d() {
            this.a = "newFixedThreadPool";
            this.b = false;
        }

        public /* synthetic */ d(vn x0) {
            this();
        }

        public d f(String mNameFormat) {
            this.d = mNameFormat;
            return this;
        }

        public d e(boolean mDaemon) {
            this.b = mDaemon;
            return this;
        }

        /* compiled from: ThreadUtils.java */
        /* renamed from: wn$d$a */
        /* loaded from: classes.dex */
        public class a implements ThreadFactory {
            public a() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable r) {
                ThreadFactory threadFactory = d.this.c != null ? d.this.c : Executors.defaultThreadFactory();
                Thread thread = threadFactory.newThread(r);
                AtomicLong count = d.this.d != null ? new AtomicLong(0L) : null;
                if (d.this.d != null) {
                    thread.setName(String.format(Locale.ROOT, d.this.d, Long.valueOf(count.getAndIncrement())));
                }
                thread.setDaemon(d.this.b);
                return thread;
            }
        }

        public ThreadFactory d() {
            return new a();
        }
    }
}
