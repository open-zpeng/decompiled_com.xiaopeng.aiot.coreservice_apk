package com.xiaopeng.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.framework.netchannelmodule.common.TrafficeStaFlagInterceptor;
import com.xiaopeng.lib.http.HttpsUtils;
/* loaded from: classes.dex */
public class BaseApplication extends Application {
    public static Application a;
    public static BaseApplication b;

    public static Context a() {
        return a;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        a = this;
        b = this;
        if (getPackageName().endsWith(sn.a()) && getPackageName().startsWith("com.xiaopeng")) {
            try {
                HttpsUtils.init(this, true);
                iv.q(new ys() { // from class: mm
                    @Override // defpackage.ys
                    public final void accept(Object obj) {
                        Throwable th = (Throwable) obj;
                        pn.a("BaseApplication", "RxJava: Uncaught exception —— " + Log.getStackTraceString(th));
                    }
                });
                Module.register(NetworkChannelsEntry.class, new NetworkChannelsEntry());
                b().config().addInterceptor(new TrafficeStaFlagInterceptor()).retryCount(0).applicationContext(this).enableTrafficStats().apply();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public static IHttp b() {
        try {
            return (IHttp) Module.get(NetworkChannelsEntry.class).get(IHttp.class);
        } catch (Exception e) {
            pn.s("BaseApplication", "getHttp fatal:" + e.getMessage());
            return null;
        }
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        HttpsUtils.destroy();
    }
}
