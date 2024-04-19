package defpackage;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: RequestExecutor.java */
/* renamed from: b9  reason: default package */
/* loaded from: classes.dex */
public class b9 {
    /* JADX WARN: Generic types in debug info not equals: d9 != androidx.core.util.Consumer<T> */
    public static <T> void b(Executor executor, Callable<T> callable, d9<T> d9Var) {
        Handler calleeHandler = w8.a();
        executor.execute(new b(calleeHandler, callable, d9Var));
    }

    public static <T> T c(ExecutorService executor, Callable<T> callable, int timeoutMillis) throws InterruptedException {
        Future<T> future = executor.submit(callable);
        try {
            return future.get(timeoutMillis, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (TimeoutException e3) {
            throw new InterruptedException("timeout");
        }
    }

    public static ThreadPoolExecutor a(String threadName, int threadPriority, int keepAliveTimeInMillis) {
        ThreadFactory threadFactory = new a(threadName, threadPriority);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 1, keepAliveTimeInMillis, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), threadFactory);
        executor.allowCoreThreadTimeOut(true);
        return executor;
    }

    /* compiled from: RequestExecutor.java */
    /* renamed from: b9$b */
    /* loaded from: classes.dex */
    public static class b<T> implements Runnable {
        public Callable<T> a;
        public d9<T> b;
        public Handler d;

        /* JADX WARN: Generic types in debug info not equals: b9$b != androidx.core.provider.RequestExecutor$ReplyRunnable<T> */
        /* JADX WARN: Generic types in debug info not equals: d9 != androidx.core.util.Consumer<T> */
        public b(Handler handler, Callable<T> callable, d9<T> d9Var) {
            this.a = callable;
            this.b = d9Var;
            this.d = handler;
        }

        /* JADX WARN: Generic types in debug info not equals: b9$b != androidx.core.provider.RequestExecutor$ReplyRunnable<T> */
        /* JADX WARN: Generic types in debug info not equals: d9 != androidx.core.util.Consumer<T> */
        @Override // java.lang.Runnable
        public void run() {
            T t;
            try {
                t = this.a.call();
            } catch (Exception e) {
                t = null;
            }
            T result = t;
            this.d.post(new a(this.b, result));
        }

        /* compiled from: RequestExecutor.java */
        /* renamed from: b9$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public final /* synthetic */ d9 a;
            public final /* synthetic */ Object b;

            public a(d9 d9Var, Object obj) {
                this.a = d9Var;
                this.b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.a.accept(this.b);
            }
        }
    }

    /* compiled from: RequestExecutor.java */
    /* renamed from: b9$a */
    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {
        public String a;
        public int b;

        public a(String threadName, int priority) {
            this.a = threadName;
            this.b = priority;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0002a(runnable, this.a, this.b);
        }

        /* compiled from: RequestExecutor.java */
        /* renamed from: b9$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0002a extends Thread {
            public final int a;

            public C0002a(Runnable target, String name, int priority) {
                super(target, name);
                this.a = priority;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.a);
                super.run();
            }
        }
    }
}
