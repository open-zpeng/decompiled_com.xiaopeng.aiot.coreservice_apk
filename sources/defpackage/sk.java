package defpackage;

import com.lzy.okgo.model.Response;
import okhttp3.Call;
/* compiled from: DefaultCachePolicy.java */
/* renamed from: sk  reason: default package */
/* loaded from: classes.dex */
public class sk<T> extends qk<T> {
    /* JADX WARN: Generic types in debug info not equals: sk != com.lzy.okgo.cache.policy.DefaultCachePolicy<T> */
    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, ? extends com.lzy.okgo.request.base.Request> */
    public sk(sl<T, ? extends sl> slVar) {
        super(slVar);
    }

    /* compiled from: DefaultCachePolicy.java */
    /* renamed from: sk$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Response a;

        public a(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            sk.this.f.onSuccess(this.a);
            sk.this.f.onFinish();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: sk != com.lzy.okgo.cache.policy.DefaultCachePolicy<T> */
    @Override // defpackage.rk
    public void onSuccess(Response<T> success) {
        g(new a(success));
    }

    /* compiled from: DefaultCachePolicy.java */
    /* renamed from: sk$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ Response a;

        public b(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            sk.this.f.onError(this.a);
            sk.this.f.onFinish();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: sk != com.lzy.okgo.cache.policy.DefaultCachePolicy<T> */
    @Override // defpackage.rk
    public void onError(Response<T> error) {
        g(new b(error));
    }

    /* JADX WARN: Generic types in debug info not equals: sk != com.lzy.okgo.cache.policy.DefaultCachePolicy<T> */
    @Override // defpackage.qk
    public boolean d(Call call, okhttp3.Response response) {
        if (response.code() != 304) {
            return false;
        }
        ok<T> okVar = this.g;
        if (okVar == null) {
            Response<T> error = Response.error(true, call, response, il.a(this.a.i()));
            g(new c(error));
        } else {
            Response<T> success = Response.success(true, okVar.c(), call, response);
            g(new d(success));
        }
        return true;
    }

    /* compiled from: DefaultCachePolicy.java */
    /* renamed from: sk$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ Response a;

        public c(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            sk.this.f.onError(this.a);
            sk.this.f.onFinish();
        }
    }

    /* compiled from: DefaultCachePolicy.java */
    /* renamed from: sk$d */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        public final /* synthetic */ Response a;

        public d(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            sk.this.f.onCacheSuccess(this.a);
            sk.this.f.onFinish();
        }
    }

    /* compiled from: DefaultCachePolicy.java */
    /* renamed from: sk$e */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            sk skVar = sk.this;
            skVar.f.onStart(skVar.a);
            try {
                sk.this.e();
                sk.this.f();
            } catch (Throwable throwable) {
                Response<T> error = Response.error(false, sk.this.e, null, throwable);
                sk.this.f.onError(error);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    /* JADX WARN: Generic types in debug info not equals: sk != com.lzy.okgo.cache.policy.DefaultCachePolicy<T> */
    /* JADX WARN: Generic types in debug info not equals: yk != com.lzy.okgo.callback.Callback<T> */
    @Override // defpackage.rk
    public void b(ok<T> okVar, yk<T> ykVar) {
        this.f = ykVar;
        g(new e());
    }
}
