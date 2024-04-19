package defpackage;

import com.xiaopeng.lib.http.server.ServerBean;
/* compiled from: BizRawObservable.java */
/* renamed from: wm  reason: default package */
/* loaded from: classes.dex */
public final class wm extends bs<ServerBean> {
    public final bs<ServerBean> a;

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<com.xiaopeng.lib.http.server.ServerBean> */
    public wm(bs<ServerBean> bsVar) {
        this.a = bsVar;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super com.xiaopeng.lib.http.server.ServerBean> */
    @Override // defpackage.bs
    public void z(fs<? super ServerBean> fsVar) {
        this.a.a(new a(fsVar));
    }

    /* compiled from: BizRawObservable.java */
    /* renamed from: wm$a */
    /* loaded from: classes.dex */
    public static final class a implements fs<ServerBean> {
        public final fs<? super ServerBean> a;
        public boolean b;

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super com.xiaopeng.lib.http.server.ServerBean> */
        public a(fs<? super ServerBean> fsVar) {
            this.a = fsVar;
        }

        @Override // defpackage.fs
        public void onSubscribe(ls disposable) {
            this.a.onSubscribe(disposable);
        }

        @Override // defpackage.fs
        /* renamed from: b */
        public void onNext(ServerBean response) {
            if (response != null && a(response.getCode())) {
                this.a.onNext(response);
            } else if (response != null) {
                this.b = true;
                Throwable t = new tm(response);
                try {
                    this.a.onError(t);
                } catch (Throwable inner) {
                    qs.b(inner);
                    iv.m(new ps(t, inner));
                }
            } else {
                Throwable t2 = new NullPointerException("ServerBean or response body null");
                try {
                    this.a.onError(t2);
                } catch (Throwable inner2) {
                    qs.b(inner2);
                    iv.m(new ps(t2, inner2));
                }
            }
        }

        public final boolean a(int code) {
            return code == 200 || code == 0;
        }

        @Override // defpackage.fs
        public void onComplete() {
            if (!this.b) {
                this.a.onComplete();
            }
        }

        @Override // defpackage.fs
        public void onError(Throwable throwable) {
            if (!this.b) {
                this.a.onError(throwable);
                return;
            }
            Throwable broken = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            broken.initCause(throwable);
            iv.m(broken);
        }
    }
}
