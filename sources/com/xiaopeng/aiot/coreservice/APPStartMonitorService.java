package com.xiaopeng.aiot.coreservice;

import android.app.IActivityController;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class APPStartMonitorService extends Service {
    public static c a;
    public a b = new a();

    /* loaded from: classes.dex */
    public interface c {
        void a(String str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.b;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b();
    }

    public void b() {
        Log.d("APPStartMonitorService", "setActivityController,");
        try {
            Class<?> cActivityManagerNative = Class.forName("android.app.ActivityManagerNative");
            Method getServiceMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class);
            Object ServiceManager = getServiceMethod.invoke(null, "activity");
            Method iBinder = cActivityManagerNative.getMethod("asInterface", IBinder.class);
            Object iAMS = iBinder.invoke(null, ServiceManager);
            Method setMethod = iAMS.getClass().getMethod("setActivityController", Class.forName("android.app.IActivityController"), Boolean.TYPE);
            setMethod.invoke(iAMS, new b(), true);
        } catch (ClassNotFoundException e) {
            e = e;
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e = e3;
            e.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    /* loaded from: classes.dex */
    public class b extends IActivityController.Stub {
        public b() {
        }

        public boolean activityStarting(Intent intent, String pkg) {
            Log.d("APPStartMonitorService", "activityStarting: " + pkg + ", intent= " + intent);
            if (APPStartMonitorService.a != null) {
                APPStartMonitorService.a.a(pkg);
                return true;
            }
            return true;
        }

        public boolean activityResuming(String pkg) {
            Log.d("APPStartMonitorService", "activityResuming: " + pkg);
            return true;
        }

        public int appEarlyNotResponding(String processName, int pid, String annotation) {
            return 0;
        }

        public boolean appCrashed(String processName, int pid, String shortMsg, String longMsg, long timeMillis, String stackTrace) {
            return false;
        }

        public int appNotResponding(String processName, int pid, String processStats) {
            return 0;
        }

        public int systemNotResponding(String msg) {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public class a extends Binder {
        public a() {
        }
    }
}
