package defpackage;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.mtl.appmonitor.AppMonitorService;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import defpackage.oh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: AppMonitor.java */
/* renamed from: mh  reason: default package */
/* loaded from: classes.dex */
public final class mh {
    public static volatile boolean d;
    public static oh e;
    public static String i;
    public static String j;
    public static boolean k;
    public static String l;
    public static Context n;
    public static ServiceConnection o;
    public static String p;
    public static Map<String, ?> q;
    public static Application a = null;
    public static j b = null;
    public static HandlerThread c = null;
    public static Object f = new Object();
    public static List<h> g = Collections.synchronizedList(new ArrayList());
    public static boolean h = false;
    public static i m = i.Local;

    /* compiled from: AppMonitor.java */
    /* renamed from: mh$h */
    /* loaded from: classes.dex */
    public static class h {
        public String a;
        public String b;
        public MeasureSet c;
        public DimensionSet d;
        public boolean e;
    }

    /* compiled from: AppMonitor.java */
    /* renamed from: mh$i */
    /* loaded from: classes.dex */
    public enum i {
        Local,
        Service
    }

    static {
        try {
            System.loadLibrary("ut_c_api");
            Log.i("AppMonitor", "load ut_c_api.so success");
        } catch (Throwable th) {
            Log.w("AppMonitor", "load ut_c_api.so failed");
        }
        o = new c();
        q = Collections.synchronizedMap(new HashMap());
    }

    public static synchronized void p(Application application) {
        synchronized (mh.class) {
            vj.c("AppMonitor", "[init]");
            try {
                if (!d) {
                    a = application;
                    if (application != null) {
                        n = application.getApplicationContext();
                    }
                    HandlerThread handlerThread = new HandlerThread("AppMonitor_Client");
                    c = handlerThread;
                    handlerThread.start();
                    b = new j(c.getLooper());
                    if (m == i.Local) {
                        g();
                    } else if (i()) {
                        b.b(true);
                    }
                    c().run();
                    d = true;
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void s(boolean isSecurity, String appkey, String secret, String authcode) {
        if (!o()) {
            return;
        }
        b.a(f(isSecurity, appkey, secret, authcode));
        k = isSecurity;
        j = appkey;
        l = secret;
        p = authcode;
    }

    public static void r(String channel) {
        if (!o()) {
            return;
        }
        b.a(d(channel));
        i = channel;
    }

    public static void u(Map<String, String> params) {
        if (!o()) {
            return;
        }
        b.a(new a(params));
    }

    /* compiled from: AppMonitor.java */
    /* renamed from: mh$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public final /* synthetic */ Map a;

        public a(Map map) {
            this.a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                mh.e.H(this.a);
            } catch (RemoteException e) {
                mh.h(e);
            }
        }
    }

    public static void t() {
        if (!o()) {
            return;
        }
        b.a(new b());
    }

    /* compiled from: AppMonitor.java */
    /* renamed from: mh$b */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                mh.e.T();
            } catch (RemoteException e) {
                mh.h(e);
            }
        }
    }

    public static boolean i() {
        Application application = a;
        if (application == null) {
            return false;
        }
        boolean bindService = application.getApplicationContext().bindService(new Intent(a.getApplicationContext(), AppMonitorService.class), o, 1);
        if (!bindService) {
            g();
        }
        vj.c("AppMonitor", "bindsuccess:", Boolean.valueOf(bindService));
        return bindService;
    }

    /* compiled from: AppMonitor.java */
    /* renamed from: mh$c */
    /* loaded from: classes.dex */
    public static class c implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            j jVar;
            if (i.Service == mh.m) {
                mh.e = oh.a.W(service);
                if (mh.h && (jVar = mh.b) != null) {
                    jVar.postAtFrontOfQueue(new a());
                }
            }
            synchronized (mh.f) {
                mh.f.notifyAll();
            }
        }

        /* compiled from: AppMonitor.java */
        /* renamed from: mh$c$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                mh.q();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            vj.c("AppMonitor", "[onServiceDisconnected]");
            synchronized (mh.f) {
                mh.f.notifyAll();
            }
            boolean unused = mh.h = true;
        }
    }

    /* compiled from: AppMonitor.java */
    /* renamed from: mh$j */
    /* loaded from: classes.dex */
    public static class j extends Handler {
        public boolean a;

        public j(Looper looper) {
            super(looper);
            this.a = false;
        }

        public void a(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            try {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = runnable;
                sendMessage(obtain);
            } catch (Throwable th) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            try {
                if (this.a) {
                    this.a = false;
                    synchronized (mh.f) {
                        try {
                            mh.f.wait(5000L);
                        } catch (InterruptedException e) {
                            mh.g();
                        }
                    }
                }
                Object obj = msg.obj;
                if (obj != null) {
                    if (obj instanceof Runnable) {
                        try {
                            ((Runnable) obj).run();
                        } catch (Throwable th) {
                        }
                    }
                }
            } catch (Throwable th2) {
            }
            super.handleMessage(msg);
        }

        public void b(boolean z) {
            this.a = true;
        }
    }

    public static void h(Exception exc) {
        vj.b("AppMonitor", "", exc);
        if (exc instanceof DeadObjectException) {
            q();
        }
    }

    public static synchronized void q() {
        synchronized (mh.class) {
            vj.c("AppMonitor", "[restart]");
            try {
                if (h) {
                    h = false;
                    g();
                    c().run();
                    f(k, j, l, p).run();
                    d(i).run();
                    synchronized (g) {
                        for (int i2 = 0; i2 < g.size(); i2++) {
                            h hVar = g.get(i2);
                            if (hVar != null) {
                                try {
                                    e(hVar.a, hVar.b, hVar.c, hVar.d, hVar.e).run();
                                } catch (Throwable th) {
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
            }
        }
    }

    public static void g() {
        e = new ph(a);
        m = i.Local;
        vj.a("AppMonitor", "Start AppMonitor Service failed,AppMonitor run in local Mode...");
    }

    public static boolean o() {
        if (!d) {
            vj.c("AppMonitor", "Please call UTAnalytics.getInstance().setAppApplicationInstance()||.setAppApplicationInstance4sdk() before call other method");
        }
        return d;
    }

    public static Runnable c() {
        return new d();
    }

    /* compiled from: AppMonitor.java */
    /* renamed from: mh$d */
    /* loaded from: classes.dex */
    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                mh.e.init();
            } catch (RemoteException e) {
                mh.g();
                try {
                    mh.e.init();
                } catch (Throwable th) {
                }
            }
        }
    }

    /* compiled from: AppMonitor.java */
    /* renamed from: mh$e */
    /* loaded from: classes.dex */
    public static class e implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String d;
        public final /* synthetic */ String f;

        public e(boolean z, String str, String str2, String str3) {
            this.a = z;
            this.b = str;
            this.d = str2;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                mh.e.w(this.a, this.b, this.d, this.f);
            } catch (Throwable th) {
            }
        }
    }

    public static Runnable f(boolean z, String str, String str2, String str3) {
        return new e(z, str, str2, str3);
    }

    /* compiled from: AppMonitor.java */
    /* renamed from: mh$f */
    /* loaded from: classes.dex */
    public static class f implements Runnable {
        public final /* synthetic */ String a;

        public f(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                mh.e.A(this.a);
            } catch (Throwable th) {
            }
        }
    }

    public static Runnable d(String str) {
        return new f(str);
    }

    /* compiled from: AppMonitor.java */
    /* renamed from: mh$g */
    /* loaded from: classes.dex */
    public static class g implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ MeasureSet d;
        public final /* synthetic */ DimensionSet f;
        public final /* synthetic */ boolean g;

        public g(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
            this.a = str;
            this.b = str2;
            this.d = measureSet;
            this.f = dimensionSet;
            this.g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                vj.c("AppMonitor", "register stat event. module: ", this.a, " monitorPoint: ", this.b);
                mh.e.l(this.a, this.b, this.d, this.f, this.g);
            } catch (RemoteException e) {
                mh.h(e);
            }
        }
    }

    public static Runnable e(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        return new g(str, str2, measureSet, dimensionSet, z);
    }
}
