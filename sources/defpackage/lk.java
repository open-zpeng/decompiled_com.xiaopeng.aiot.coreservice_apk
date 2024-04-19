package defpackage;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import defpackage.kl;
import defpackage.ll;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okhttp3.Call;
import okhttp3.OkHttpClient;
/* compiled from: OkGo.java */
/* renamed from: lk  reason: default package */
/* loaded from: classes.dex */
public class lk {
    public static long a = 300;
    public Application b;
    public Handler c;
    public OkHttpClient d;
    public HttpParams e;
    public HttpHeaders f;
    public int g;
    public pk h;
    public long i;

    public lk() {
        this.c = new Handler(Looper.getMainLooper());
        this.g = 3;
        this.i = -1L;
        this.h = pk.NO_CACHE;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        ll loggingInterceptor = new ll("OkGo");
        loggingInterceptor.h(ll.a.BODY);
        loggingInterceptor.g(Level.INFO);
        builder.addInterceptor(loggingInterceptor);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.readTimeout(60000L, timeUnit);
        builder.writeTimeout(60000L, timeUnit);
        builder.connectTimeout(60000L, timeUnit);
        kl.c sslParams = kl.b();
        builder.sslSocketFactory(sslParams.a, sslParams.b);
        builder.hostnameVerifier(kl.b);
        this.d = builder.build();
    }

    public static lk h() {
        return b.a;
    }

    /* compiled from: OkGo.java */
    /* renamed from: lk$b */
    /* loaded from: classes.dex */
    public static class b {
        public static lk a = new lk();
    }

    public lk k(Application app) {
        this.b = app;
        return this;
    }

    public Context f() {
        ul.b(this.b, "please call OkGo.getInstance().init() first in application!");
        return this.b;
    }

    public Handler g() {
        return this.c;
    }

    public OkHttpClient i() {
        ul.b(this.d, "please call OkGo.getInstance().setOkHttpClient() first in application!");
        return this.d;
    }

    public lk l(OkHttpClient okHttpClient) {
        ul.b(okHttpClient, "okHttpClient == null");
        this.d = okHttpClient;
        return this;
    }

    public lk m(int retryCount) {
        if (retryCount < 0) {
            throw new IllegalArgumentException("retryCount must > 0");
        }
        this.g = retryCount;
        return this;
    }

    public int j() {
        return this.g;
    }

    public pk b() {
        return this.h;
    }

    public long c() {
        return this.i;
    }

    public HttpParams e() {
        return this.e;
    }

    public HttpHeaders d() {
        return this.f;
    }

    public void a(Object tag) {
        if (tag == null) {
            return;
        }
        for (Call call : i().dispatcher().queuedCalls()) {
            if (tag.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call2 : i().dispatcher().runningCalls()) {
            if (tag.equals(call2.request().tag())) {
                call2.cancel();
            }
        }
    }
}
