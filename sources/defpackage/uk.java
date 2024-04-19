package defpackage;

import com.lzy.okgo.model.Response;
/* compiled from: NoCachePolicy.java */
/* renamed from: uk  reason: default package */
/* loaded from: classes.dex */
public class uk<T> extends qk<T> {
    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, ? extends com.lzy.okgo.request.base.Request> */
    /* JADX WARN: Generic types in debug info not equals: uk != com.lzy.okgo.cache.policy.NoCachePolicy<T> */
    public uk(sl<T, ? extends sl> slVar) {
        super(slVar);
    }

    /* compiled from: NoCachePolicy.java */
    /* renamed from: uk$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Response a;

        public a(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            uk.this.f.onSuccess(this.a);
            uk.this.f.onFinish();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: uk != com.lzy.okgo.cache.policy.NoCachePolicy<T> */
    @Override // defpackage.rk
    public void onSuccess(Response<T> success) {
        g(new a(success));
    }

    /* compiled from: NoCachePolicy.java */
    /* renamed from: uk$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ Response a;

        public b(Response response) {
            this.a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            uk.this.f.onError(this.a);
            uk.this.f.onFinish();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: uk != com.lzy.okgo.cache.policy.NoCachePolicy<T> */
    @Override // defpackage.rk
    public void onError(Response<T> error) {
        g(new b(error));
    }

    /* compiled from: NoCachePolicy.java */
    /* renamed from: uk$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            uk ukVar = uk.this;
            ukVar.f.onStart(ukVar.a);
            try {
                uk.this.e();
                uk.this.f();
            } catch (Throwable throwable) {
                Response<T> error = Response.error(false, uk.this.e, null, throwable);
                uk.this.f.onError(error);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    /* JADX WARN: Generic types in debug info not equals: uk != com.lzy.okgo.cache.policy.NoCachePolicy<T> */
    /* JADX WARN: Generic types in debug info not equals: yk != com.lzy.okgo.callback.Callback<T> */
    @Override // defpackage.rk
    public void b(ok<T> okVar, yk<T> ykVar) {
        this.f = ykVar;
        g(new c());
    }
}
