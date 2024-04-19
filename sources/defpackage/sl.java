package defpackage;

import android.text.TextUtils;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import defpackage.rl;
import defpackage.sl;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* compiled from: Request.java */
/* renamed from: sl  reason: default package */
/* loaded from: classes.dex */
public abstract class sl<T, R extends sl> implements Serializable {
    public String a;
    public String b;
    public transient OkHttpClient d;
    public transient Object f;
    public int g;
    public pk h;
    public String i;
    public long j;
    public HttpParams k = new HttpParams();
    public HttpHeaders l = new HttpHeaders();
    public transient Request m;
    public transient nk<T> n;
    public transient yk<T> o;
    public transient al<T> p;
    public transient rk<T> q;
    public transient rl.c r;

    public abstract Request f(RequestBody requestBody);

    public abstract RequestBody g();

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public sl(String url) {
        this.a = url;
        this.b = url;
        lk go = lk.h();
        String acceptLanguage = HttpHeaders.getAcceptLanguage();
        if (!TextUtils.isEmpty(acceptLanguage)) {
            u(HttpHeaders.HEAD_KEY_ACCEPT_LANGUAGE, acceptLanguage);
        }
        String userAgent = HttpHeaders.getUserAgent();
        if (!TextUtils.isEmpty(userAgent)) {
            u("User-Agent", userAgent);
        }
        if (go.e() != null) {
            v(go.e());
        }
        if (go.d() != null) {
            t(go.d());
        }
        this.g = go.j();
        this.h = go.b();
        this.j = go.c();
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R F(Object tag) {
        this.f = tag;
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R c(pk cacheMode) {
        this.h = cacheMode;
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R b(String cacheKey) {
        ul.b(cacheKey, "cacheKey == null");
        this.i = cacheKey;
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R t(HttpHeaders headers) {
        this.l.put(headers);
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R u(String key, String value) {
        this.l.put(key, value);
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R D(String key) {
        this.l.remove(key);
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R B() {
        this.l.clear();
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R v(HttpParams params) {
        this.k.put(params);
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R A(Map<String, String> params, boolean... isReplace) {
        this.k.put(params, isReplace);
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R y(String key, String value, boolean... isReplace) {
        this.k.put(key, value, isReplace);
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R x(String key, int value, boolean... isReplace) {
        this.k.put(key, value, isReplace);
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R w(String key, float value, boolean... isReplace) {
        this.k.put(key, value, isReplace);
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R z(String key, boolean value, boolean... isReplace) {
        this.k.put(key, value, isReplace);
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R E(String key) {
        this.k.remove(key);
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public R C() {
        this.k.clear();
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public HttpParams o() {
        return this.k;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public HttpHeaders n() {
        return this.l;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public String s() {
        return this.a;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public String h() {
        return this.b;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public pk j() {
        return this.h;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public rk<T> k() {
        return this.q;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public String i() {
        return this.i;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public long l() {
        return this.j;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public int r() {
        return this.g;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public Request q() {
        return this.m;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public al<T> m() {
        if (this.p == null) {
            this.p = this.o;
        }
        ul.b(this.p, "converter == null, do you forget to call Request#converter(Converter<T>) ?");
        return this.p;
    }

    /* JADX WARN: Generic types in debug info not equals: rl != com.lzy.okgo.request.base.ProgressRequestBody<T> */
    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public Call p() {
        RequestBody requestBody = g();
        if (requestBody != null) {
            rl rlVar = new rl(requestBody, this.o);
            rlVar.e(this.r);
            this.m = f(rlVar);
        } else {
            this.m = f(null);
        }
        if (this.d == null) {
            this.d = lk.h().i();
        }
        return this.d.newCall(this.m);
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public nk<T> a() {
        nk<T> nkVar = this.n;
        if (nkVar == null) {
            return new mk(this);
        }
        return nkVar;
    }

    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    public Response d() throws IOException {
        return p().execute();
    }

    /* JADX WARN: Generic types in debug info not equals: nk != com.lzy.okgo.adapter.Call<T> */
    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, R extends sl> */
    /* JADX WARN: Generic types in debug info not equals: yk != com.lzy.okgo.callback.Callback<T> */
    public void e(yk<T> ykVar) {
        ul.b(ykVar, "callback == null");
        this.o = ykVar;
        a().a(ykVar);
    }
}
