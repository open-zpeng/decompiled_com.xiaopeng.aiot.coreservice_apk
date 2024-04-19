package defpackage;

import com.lzy.okgo.model.Response;
/* compiled from: RequestFailedCachePolicy.java */
/* renamed from: wk  reason: default package */
/* loaded from: classes.dex */
public class wk<T> extends qk<T> {
    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, ? extends com.lzy.okgo.request.base.Request> */
    /* JADX WARN: Generic types in debug info not equals: wk != com.lzy.okgo.cache.policy.RequestFailedCachePolicy<T> */
    public wk(sl<T, ? extends sl> slVar) {
        super(slVar);
    }

    /* compiled from: RequestFailedCachePolicy.java */
    /* renamed from: wk$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Response a;

        public a(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            wk.this.f.onSuccess(this.a);
            wk.this.f.onFinish();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: wk != com.lzy.okgo.cache.policy.RequestFailedCachePolicy<T> */
    @Override // defpackage.rk
    public void onSuccess(Response<T> success) {
        g(new a(success));
    }

    /* JADX WARN: Generic types in debug info not equals: wk != com.lzy.okgo.cache.policy.RequestFailedCachePolicy<T> */
    @Override // defpackage.rk
    public void onError(Response<T> error) {
        ok<T> okVar = this.g;
        if (okVar != null) {
            Response<T> cacheSuccess = Response.success(true, okVar.c(), error.getRawCall(), error.getRawResponse());
            g(new b(cacheSuccess));
            return;
        }
        g(new c(error));
    }

    /* compiled from: RequestFailedCachePolicy.java */
    /* renamed from: wk$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ Response a;

        public b(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            wk.this.f.onCacheSuccess(this.a);
            wk.this.f.onFinish();
        }
    }

    /* compiled from: RequestFailedCachePolicy.java */
    /* renamed from: wk$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ Response a;

        public c(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            wk.this.f.onError(this.a);
            wk.this.f.onFinish();
        }
    }

    /* compiled from: RequestFailedCachePolicy.java */
    /* renamed from: wk$d */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            wk wkVar = wk.this;
            wkVar.f.onStart(wkVar.a);
            try {
                wk.this.e();
                wk.this.f();
            } catch (Throwable throwable) {
                Response<T> error = Response.error(false, wk.this.e, null, throwable);
                wk.this.f.onError(error);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    /* JADX WARN: Generic types in debug info not equals: wk != com.lzy.okgo.cache.policy.RequestFailedCachePolicy<T> */
    /* JADX WARN: Generic types in debug info not equals: yk != com.lzy.okgo.callback.Callback<T> */
    @Override // defpackage.rk
    public void b(ok<T> okVar, yk<T> ykVar) {
        this.f = ykVar;
        g(new d());
    }
}
