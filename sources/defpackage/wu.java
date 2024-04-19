package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SchedulerPoolFactory.java */
/* renamed from: wu  reason: default package */
/* loaded from: classes.dex */
public final class wu {
    public static final boolean a;
    public static final int b;
    public static final AtomicReference<ScheduledExecutorService> c = new AtomicReference<>();
    public static final Map<ScheduledThreadPoolExecutor, Object> d = new ConcurrentHashMap();

    static {
        Properties properties = System.getProperties();
        a pp = new a();
        pp.a(properties);
        a = pp.a;
        b = pp.b;
        b();
    }

    public static void b() {
        d(a);
    }

    public static void d(boolean purgeEnabled) {
        if (!purgeEnabled) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = c;
            ScheduledExecutorService curr = atomicReference.get();
            if (curr != null) {
                return;
            }
            ScheduledExecutorService next = Executors.newScheduledThreadPool(1, new tu("RxSchedulerPurge"));
            if (atomicReference.compareAndSet(curr, next)) {
                b bVar = new b();
                int i = b;
                next.scheduleAtFixedRate(bVar, i, i, TimeUnit.SECONDS);
                return;
            }
            next.shutdownNow();
        }
    }

    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: wu$a */
    /* loaded from: classes.dex */
    public static final class a {
        public boolean a;
        public int b;

        public void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.a = true;
            }
            if (this.a && properties.containsKey("rx2.purge-period-seconds")) {
                try {
                    this.b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
                    return;
                } catch (NumberFormatException e) {
                    this.b = 1;
                    return;
                }
            }
            this.b = 1;
        }
    }

    public static ScheduledExecutorService a(ThreadFactory factory) {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1, factory);
        c(a, exec);
        return exec;
    }

    public static void c(boolean purgeEnabled, ScheduledExecutorService exec) {
        if (purgeEnabled && (exec instanceof ScheduledThreadPoolExecutor)) {
            ScheduledThreadPoolExecutor e = (ScheduledThreadPoolExecutor) exec;
            d.put(e, exec);
        }
    }

    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: wu$b */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(wu.d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor e = (ScheduledThreadPoolExecutor) it.next();
                if (e.isShutdown()) {
                    wu.d.remove(e);
                } else {
                    e.purge();
                }
            }
        }
    }
}
