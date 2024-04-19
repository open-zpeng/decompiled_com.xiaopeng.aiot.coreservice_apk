package com.xiaopeng.aiot.coreservice;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.xiaopeng.base.BaseApplication;
import com.xiaopeng.base.log.LogUtils;
import com.xiaopeng.carmanager.CarClient;
import com.xiaopeng.lib.apirouter.server.ApiPublisherProvider;
import com.xiaopeng.lib.framework.configuration.ConfigurationModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.configurationmodule.IConfiguration;
/* loaded from: classes.dex */
public class App extends BaseApplication {
    public Handler d;

    @Override // com.xiaopeng.base.BaseApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        ApiPublisherProvider.CONTEXT = getApplicationContext();
        String currentProcessName = zm.b(this);
        pm.b(this, currentProcessName != null ? currentProcessName.replace(getPackageName(), "") : "");
        pm.d(dm.a);
        LogUtils.d("App", "*******************************");
        LogUtils.d("App", "**                           **");
        LogUtils.d("App", "**       Aiot App Start      **");
        LogUtils.d("App", "**                           **");
        LogUtils.d("App", "*******************************");
        dn.c().d(this);
        f();
        CarClient.connectToCar(this, this.d);
        e();
        h(this);
        this.d.post(new Runnable() { // from class: cm
            @Override // java.lang.Runnable
            public final void run() {
                LogUtils.i("App", "****init mWorkHandler********   ");
            }
        });
        try {
            PackageManager packageManager = getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            LogUtils.i("App", "versionName = " + packageInfo.versionName + " , versionCode = " + packageInfo.versionCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (az.d() == null) {
                az.b().h(false).f(false).g(false).e();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void f() {
        HandlerThread workThread = new HandlerThread("aiot-service-thread");
        workThread.start();
        this.d = new Handler(workThread.getLooper());
    }

    public void h(Context context) {
        LogUtils.d("App", "start AiotService");
        lm.a(context, "App Start");
    }

    public final void e() {
        Module.register(ConfigurationModuleEntry.class, new ConfigurationModuleEntry());
        d().init(this, getPackageName());
    }

    public static IConfiguration d() {
        return (IConfiguration) Module.get(ConfigurationModuleEntry.class).get(IConfiguration.class);
    }
}
