package defpackage;

import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import com.xiaopeng.base.BaseApplication;
import com.xiaopeng.base.log.LogUtils;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* compiled from: XlogProxy.java */
/* renamed from: qm  reason: default package */
/* loaded from: classes.dex */
public class qm {
    public static File a;
    public static Handler g;
    public static volatile String b = "/xiaopeng/logs";
    public static String c = "/";
    public static String d = "/";
    public static boolean e = true;
    public static String f = "logs";
    public static long h = 3000;
    public static volatile String i = null;

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("marsxlog");
        } catch (Exception e2) {
            Log.e("XLogProxy", "loadLibrary error,", e2);
        }
        HandlerThread thread = new HandlerThread("LogThread");
        thread.setPriority(1);
        thread.start();
        g = new Handler(thread.getLooper());
    }

    public static void k(String rootPath) {
        a = new File(rootPath);
        c = rootPath;
    }

    public static void j(String path) {
        d = path;
    }

    public static void e() {
        l(f);
    }

    public static void l(String file) {
        a();
        Xlog xlog = new Xlog();
        String logPath = d() + b;
        d = c() + b;
        int xLogLevel = 2;
        if (e) {
            xlog.setConsoleLogOpen(0L, true);
            xLogLevel = 1;
        } else {
            xlog.setConsoleLogOpen(0L, false);
        }
        com.tencent.mars.xlog.Log.setLogImp(xlog);
        Xlog.open(false, xLogLevel, 0, d, logPath, file, "");
        i = file;
    }

    public static void h(final int type, final String msg, final String TAG, final String fileName) {
        g.post(new Runnable() { // from class: nm
            @Override // java.lang.Runnable
            public final void run() {
                qm.g(fileName, TAG, type, msg);
            }
        });
    }

    public static /* synthetic */ void g(String fileName, String TAG, int type, String msg) {
        if (!fileName.equals(i)) {
            l(fileName);
            LogUtils.d(TAG, "mCurrentLog = " + i);
        }
        i(type, msg, TAG);
    }

    public static void i(int type, String msg, String TAG) {
        switch (type) {
            case 2:
                com.tencent.mars.xlog.Log.v(TAG, msg);
                return;
            case 3:
                com.tencent.mars.xlog.Log.d(TAG, msg);
                return;
            case 4:
                com.tencent.mars.xlog.Log.i(TAG, msg);
                return;
            case 5:
                com.tencent.mars.xlog.Log.w(TAG, msg);
                return;
            case 6:
                com.tencent.mars.xlog.Log.e(TAG, msg);
                return;
            default:
                return;
        }
    }

    public static void a() {
        if (i != null) {
            com.tencent.mars.xlog.Log.appenderClose();
            i = null;
        }
    }

    public static void b() {
        try {
            try {
                final CountDownLatch wait = new CountDownLatch(1);
                g.post(new Runnable() { // from class: om
                    @Override // java.lang.Runnable
                    public final void run() {
                        qm.f(wait);
                    }
                });
                wait.await(h, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Log.e("XLogProxy", "flushToDisk error ", e2);
            }
            com.tencent.mars.xlog.Log.appenderFlushSync(false);
            Log.i("XLogProxy", "flushToDisk finish");
        } catch (Throwable th) {
            com.tencent.mars.xlog.Log.appenderFlushSync(false);
            throw th;
        }
    }

    public static /* synthetic */ void f(CountDownLatch wait) {
        if (i != null) {
            com.tencent.mars.xlog.Log.appenderFlushSync(true);
        }
        wait.countDown();
    }

    public static File d() {
        File externalFilesDir = BaseApplication.a().getFilesDir() != null ? BaseApplication.a().getExternalFilesDir(null) : new File(Environment.getExternalStorageState());
        a = externalFilesDir;
        return externalFilesDir;
    }

    public static File c() {
        return BaseApplication.a().getCacheDir() != null ? BaseApplication.a().getExternalCacheDir() : new File(Environment.getExternalStorageState());
    }
}
