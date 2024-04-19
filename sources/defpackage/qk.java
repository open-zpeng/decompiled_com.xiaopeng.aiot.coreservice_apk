package defpackage;

import android.graphics.Bitmap;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
/* compiled from: BaseCachePolicy.java */
/* renamed from: qk  reason: default package */
/* loaded from: classes.dex */
public abstract class qk<T> implements rk<T> {
    public sl<T, ? extends sl> a;
    public volatile boolean b;
    public volatile int c = 0;
    public boolean d;
    public Call e;
    public yk<T> f;
    public ok<T> g;

    /* JADX WARN: Generic types in debug info not equals: qk != com.lzy.okgo.cache.policy.BaseCachePolicy<T> */
    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, ? extends com.lzy.okgo.request.base.Request> */
    public qk(sl<T, ? extends sl> slVar) {
        this.a = slVar;
    }

    /* JADX WARN: Generic types in debug info not equals: qk != com.lzy.okgo.cache.policy.BaseCachePolicy<T> */
    public boolean d(Call call, Response response) {
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: qk != com.lzy.okgo.cache.policy.BaseCachePolicy<T> */
    @Override // defpackage.rk
    public ok<T> a() {
        if (this.a.i() == null) {
            sl<T, ? extends sl> slVar = this.a;
            slVar.b(ul.c(slVar.h(), this.a.o().urlParamsMap));
        }
        if (this.a.j() == null) {
            this.a.c(pk.NO_CACHE);
        }
        pk cacheMode = this.a.j();
        if (cacheMode != pk.NO_CACHE) {
            ok<T> okVar = (ok<T>) dl.l().j(this.a.i());
            this.g = okVar;
            tl.a(this.a, okVar, cacheMode);
            ok<T> okVar2 = this.g;
            if (okVar2 != null && okVar2.a(cacheMode, this.a.l(), System.currentTimeMillis())) {
                this.g.j(true);
            }
        }
        ok<T> okVar3 = this.g;
        if (okVar3 == null || okVar3.g() || this.g.c() == null || this.g.f() == null) {
            this.g = null;
        }
        return this.g;
    }

    /* JADX WARN: Generic types in debug info not equals: qk != com.lzy.okgo.cache.policy.BaseCachePolicy<T> */
    public synchronized Call e() throws Throwable {
        if (this.d) {
            throw jl.a("Already executed!");
        }
        this.d = true;
        this.e = this.a.p();
        if (this.b) {
            this.e.cancel();
        }
        return this.e;
    }

    /* compiled from: BaseCachePolicy.java */
    /* renamed from: qk$a */
    /* loaded from: classes.dex */
    public class a implements Callback {
        public a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException e) {
            if ((e instanceof SocketTimeoutException) && qk.this.c < qk.this.a.r()) {
                qk.this.c++;
                qk qkVar = qk.this;
                qkVar.e = qkVar.a.p();
                if (qk.this.b) {
                    qk.this.e.cancel();
                } else {
                    qk.this.e.enqueue(this);
                }
            } else if (!call.isCanceled()) {
                com.lzy.okgo.model.Response<T> error = com.lzy.okgo.model.Response.error(false, call, null, e);
                qk.this.onError(error);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            int responseCode = response.code();
            if (responseCode == 404 || responseCode >= 500) {
                com.lzy.okgo.model.Response<T> error = com.lzy.okgo.model.Response.error(false, call, response, jl.b());
                qk.this.onError(error);
            } else if (qk.this.d(call, response)) {
            } else {
                try {
                    T body = qk.this.a.m().convertResponse(response);
                    qk.this.h(response.headers(), body);
                    com.lzy.okgo.model.Response<T> success = com.lzy.okgo.model.Response.success(false, body, call, response);
                    qk.this.onSuccess(success);
                } catch (Throwable throwable) {
                    com.lzy.okgo.model.Response<T> error2 = com.lzy.okgo.model.Response.error(false, call, response, throwable);
                    qk.this.onError(error2);
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: qk != com.lzy.okgo.cache.policy.BaseCachePolicy<T> */
    public void f() {
        this.e.enqueue(new a());
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    /* JADX WARN: Generic types in debug info not equals: qk != com.lzy.okgo.cache.policy.BaseCachePolicy<T> */
    public final void h(Headers headers, T data) {
        if (this.a.j() == pk.NO_CACHE || (data instanceof Bitmap)) {
            return;
        }
        ok<T> b = tl.b(headers, data, this.a.j(), this.a.i());
        if (b == null) {
            dl.l().n(this.a.i());
        } else {
            dl.l().o(this.a.i(), b);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: qk != com.lzy.okgo.cache.policy.BaseCachePolicy<T> */
    public void g(Runnable run) {
        lk.h().g().post(run);
    }
}
