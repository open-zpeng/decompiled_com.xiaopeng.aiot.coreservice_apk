package defpackage;

import com.lzy.okgo.model.Response;
/* compiled from: NoneCacheRequestPolicy.java */
/* renamed from: vk  reason: default package */
/* loaded from: classes.dex */
public class vk<T> extends qk<T> {
    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, ? extends com.lzy.okgo.request.base.Request> */
    /* JADX WARN: Generic types in debug info not equals: vk != com.lzy.okgo.cache.policy.NoneCacheRequestPolicy<T> */
    public vk(sl<T, ? extends sl> slVar) {
        super(slVar);
    }

    /* compiled from: NoneCacheRequestPolicy.java */
    /* renamed from: vk$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Response a;

        public a(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            vk.this.f.onSuccess(this.a);
            vk.this.f.onFinish();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: vk != com.lzy.okgo.cache.policy.NoneCacheRequestPolicy<T> */
    @Override // defpackage.rk
    public void onSuccess(Response<T> success) {
        g(new a(success));
    }

    /* compiled from: NoneCacheRequestPolicy.java */
    /* renamed from: vk$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ Response a;

        public b(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            vk.this.f.onError(this.a);
            vk.this.f.onFinish();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: vk != com.lzy.okgo.cache.policy.NoneCacheRequestPolicy<T> */
    @Override // defpackage.rk
    public void onError(Response<T> error) {
        g(new b(error));
    }

    /* compiled from: NoneCacheRequestPolicy.java */
    /* renamed from: vk$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ ok a;

        public c(ok okVar) {
            this.a = okVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            vk vkVar = vk.this;
            vkVar.f.onStart(vkVar.a);
            try {
                vk.this.e();
                ok okVar = this.a;
                if (okVar != null) {
                    Response<T> success = Response.success(true, okVar.c(), vk.this.e, null);
                    vk.this.f.onCacheSuccess(success);
                    vk.this.f.onFinish();
                    return;
                }
                vk.this.f();
            } catch (Throwable throwable) {
                Response<T> error = Response.error(false, vk.this.e, null, throwable);
                vk.this.f.onError(error);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    /* JADX WARN: Generic types in debug info not equals: vk != com.lzy.okgo.cache.policy.NoneCacheRequestPolicy<T> */
    /* JADX WARN: Generic types in debug info not equals: yk != com.lzy.okgo.callback.Callback<T> */
    @Override // defpackage.rk
    public void b(ok<T> okVar, yk<T> ykVar) {
        this.f = ykVar;
        g(new c(okVar));
    }
}
