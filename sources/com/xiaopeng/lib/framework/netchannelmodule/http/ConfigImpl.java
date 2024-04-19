package com.xiaopeng.lib.framework.netchannelmodule.http;

import android.app.Application;
import com.xiaopeng.datalog.DataLogModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
import com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter.ResponseAdapter;
import com.xiaopeng.lib.framework.netchannelmodule.http.statistic.HttpCounter;
import com.xiaopeng.lib.framework.netchannelmodule.http.statistic.HttpEventCounter;
import com.xiaopeng.lib.framework.netchannelmodule.http.statistic.SocketCounter;
import com.xiaopeng.lib.framework.netchannelmodule.http.tracing.TracingInterceptor;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.TrafficStatInterceptor;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.plain.CountingPlainSocketInstrument;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.tls.CountingTLSSocketInstrument;
import com.xiaopeng.lib.framework.netchannelmodule.http.xmart.TimeoutDns;
import defpackage.ll;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
/* loaded from: classes.dex */
public class ConfigImpl implements IConfig {
    private static final String TAG = "NetChannel.Http.ConfigImpl";
    private static ll sLoggingInterceptor;
    private static boolean sSetupSocketTrafficStatistic = false;
    private static TracingInterceptor sTracingInterceptor;
    private OkHttpClient.Builder mBuilder;
    private OkHttpClient mCurrentClient;
    private int mRetryCount;

    public static OkHttpClient getCurrentHttpClient() {
        return lk.h().i();
    }

    public ConfigImpl() {
        OkHttpClient i = lk.h().i();
        this.mCurrentClient = i;
        this.mBuilder = i.newBuilder();
        this.mRetryCount = lk.h().j();
        enableHttpEventReport(this.mBuilder);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public int connectTimeout() {
        return this.mCurrentClient.connectTimeoutMillis();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public int dnsTimeout() {
        return TimeoutDns.timeout();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public int readTimeout() {
        return this.mCurrentClient.readTimeoutMillis();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public int writeTimeout() {
        return this.mCurrentClient.writeTimeoutMillis();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public int retryCount() {
        return lk.h().j();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig connectTimeout(int timeoutInMilliSeconds) {
        this.mBuilder.connectTimeout(timeoutInMilliSeconds, TimeUnit.MILLISECONDS);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig dnsTimeout(int timeoutInMilliSeconds) {
        TimeoutDns.timeout(timeoutInMilliSeconds);
        this.mBuilder.dns(TimeoutDns.getInstance());
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig readTimeout(int timeoutInMilliSeconds) {
        this.mBuilder.readTimeout(timeoutInMilliSeconds, TimeUnit.MILLISECONDS);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig writeTimeout(int timeoutInMilliSeconds) {
        this.mBuilder.writeTimeout(timeoutInMilliSeconds, TimeUnit.MILLISECONDS);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig enableLogging() {
        if (sLoggingInterceptor == null) {
            ll llVar = new ll(TAG);
            sLoggingInterceptor = llVar;
            llVar.h(co.g() ? ll.a.BODY : ll.a.BASIC);
            sLoggingInterceptor.g(Level.INFO);
            this.mBuilder.addInterceptor(sLoggingInterceptor);
        }
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig enableTrafficStats() {
        enableHttpTrafficStatistic();
        ResponseAdapter.enableStat(true);
        if (!sSetupSocketTrafficStatistic) {
            HttpCounter.getInstance().init();
            SocketCounter.getInstance().init();
            CountingTLSSocketInstrument.initialize();
            CountingPlainSocketInstrument.initialize();
            sSetupSocketTrafficStatistic = true;
        }
        return this;
    }

    public IConfig disableTrafficStats() {
        if (this.mBuilder.networkInterceptors() != null) {
            this.mBuilder.networkInterceptors().remove(TrafficStatInterceptor.getInstance());
        }
        if (sSetupSocketTrafficStatistic) {
            CountingTLSSocketInstrument.reset();
            CountingPlainSocketInstrument.reset();
            sSetupSocketTrafficStatistic = false;
        }
        ResponseAdapter.enableStat(false);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig enableTracing() {
        if (sTracingInterceptor == null) {
            TracingInterceptor tracingInterceptor = new TracingInterceptor();
            sTracingInterceptor = tracingInterceptor;
            this.mBuilder.addInterceptor(tracingInterceptor);
        }
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig addInterceptor(Interceptor interceptor) {
        this.mBuilder.addInterceptor(interceptor);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig applicationContext(Application application) {
        GlobalConfig.setApplicationContext(application);
        enableTrafficStats();
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public IConfig retryCount(int retryCount) {
        if (retryCount < 0) {
            throw new IllegalArgumentException("Invalid retry count!");
        }
        if (retryCount != this.mRetryCount) {
            this.mRetryCount = retryCount;
        }
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IConfig
    public void apply() {
        Module.register(DataLogModuleEntry.class, new DataLogModuleEntry(GlobalConfig.getApplicationContext()));
        this.mBuilder.dns(TimeoutDns.getInstance());
        lk.h().m(this.mRetryCount).l(this.mBuilder.build());
    }

    private void enableHttpTrafficStatistic() {
        if (GlobalConfig.getApplicationContext() == null) {
            return;
        }
        TrafficStatInterceptor trafficInterceptor = TrafficStatInterceptor.getInstance();
        if (this.mBuilder.networkInterceptors() != null && !this.mBuilder.networkInterceptors().contains(trafficInterceptor)) {
            this.mBuilder.addNetworkInterceptor(trafficInterceptor);
        }
    }

    private void enableHttpEventReport(OkHttpClient.Builder builder) {
        builder.eventListener(HttpEventCounter.INSTANCE.getEventListener());
    }
}
