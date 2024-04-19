package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
/* compiled from: BackgroundTrigger.java */
/* renamed from: th  reason: default package */
/* loaded from: classes.dex */
public class th implements Runnable {
    public static boolean a = false;
    public static boolean b = false;
    public Application d;
    public boolean f = true;

    @TargetApi(14)
    public static void b(Application application) {
        if (!a) {
            vj.c("BackgroundTrigger", "init BackgroundTrigger");
            b = a(application.getApplicationContext());
            th thVar = new th(application);
            if (b) {
                ek.a().e(4, thVar, 60000L);
            } else if (Build.VERSION.SDK_INT >= 14) {
                thVar.getClass();
                application.registerActivityLifecycleCallbacks(new a(thVar));
            }
            a = true;
        }
    }

    public th(Application application) {
        this.d = application;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        vj.c("BackgroundTrigger", "[bg check]");
        boolean b2 = oj.b(this.d.getApplicationContext());
        if (this.f != b2) {
            this.f = b2;
            if (b2) {
                ui.a().j();
                zh[] values = zh.values();
                int length = values.length;
                while (i < length) {
                    zh zhVar = values[i];
                    nh.l(zhVar, zhVar.g());
                    i++;
                }
                ej.k();
            } else {
                zh[] values2 = zh.values();
                int length2 = values2.length;
                while (i < length2) {
                    zh zhVar2 = values2[i];
                    nh.l(zhVar2, zhVar2.i());
                    i++;
                }
                nh.m();
                ej.j();
            }
        }
        if (b) {
            ek.a().e(4, this, 60000L);
        }
    }

    /* compiled from: BackgroundTrigger.java */
    @TargetApi(14)
    /* renamed from: th$a */
    /* loaded from: classes.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        public Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            ek.a().i(4);
            ek.a().e(4, this.a, 60000L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            ek.a().i(4);
            ek.a().e(4, this.a, 60000L);
        }
    }

    public static boolean a(Context context) {
        String a2 = oj.a(context);
        vj.c("BackgroundTrigger", "[checkRuningProcess]:", a2);
        return (TextUtils.isEmpty(a2) || a2.indexOf(":") == -1) ? false : true;
    }
}
