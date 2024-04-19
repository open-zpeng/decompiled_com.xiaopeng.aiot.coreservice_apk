package defpackage;

import com.lzy.okgo.model.Response;
/* compiled from: FirstCacheRequestPolicy.java */
/* renamed from: tk  reason: default package */
/* loaded from: classes.dex */
public class tk<T> extends qk<T> {
    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, ? extends com.lzy.okgo.request.base.Request> */
    /* JADX WARN: Generic types in debug info not equals: tk != com.lzy.okgo.cache.policy.FirstCacheRequestPolicy<T> */
    public tk(sl<T, ? extends sl> slVar) {
        super(slVar);
    }

    /* compiled from: FirstCacheRequestPolicy.java */
    /* renamed from: tk$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Response a;

        public a(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            tk.this.f.onSuccess(this.a);
            tk.this.f.onFinish();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: tk != com.lzy.okgo.cache.policy.FirstCacheRequestPolicy<T> */
    @Override // defpackage.rk
    public void onSuccess(Response<T> success) {
        g(new a(success));
    }

    /* compiled from: FirstCacheRequestPolicy.java */
    /* renamed from: tk$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ Response a;

        public b(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            tk.this.f.onError(this.a);
            tk.this.f.onFinish();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: tk != com.lzy.okgo.cache.policy.FirstCacheRequestPolicy<T> */
    @Override // defpackage.rk
    public void onError(Response<T> error) {
        g(new b(error));
    }

    /* compiled from: FirstCacheRequestPolicy.java */
    /* renamed from: tk$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ ok a;

        public c(ok okVar) {
            this.a = okVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            tk tkVar = tk.this;
            tkVar.f.onStart(tkVar.a);
            try {
                tk.this.e();
                ok okVar = this.a;
                if (okVar != null) {
                    Response<T> success = Response.success(true, okVar.c(), tk.this.e, null);
                    tk.this.f.onCacheSuccess(success);
                }
                tk.this.f();
            } catch (Throwable throwable) {
                Response<T> error = Response.error(false, tk.this.e, null, throwable);
                tk.this.f.onError(error);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    /* JADX WARN: Generic types in debug info not equals: tk != com.lzy.okgo.cache.policy.FirstCacheRequestPolicy<T> */
    /* JADX WARN: Generic types in debug info not equals: yk != com.lzy.okgo.callback.Callback<T> */
    @Override // defpackage.rk
    public void b(ok<T> okVar, yk<T> ykVar) {
        this.f = ykVar;
        g(new c(okVar));
    }
}
