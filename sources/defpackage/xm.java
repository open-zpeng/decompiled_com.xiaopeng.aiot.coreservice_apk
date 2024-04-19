package defpackage;

import com.tencent.mars.xlog.Log;
import com.xiaopeng.base.net.https.bean.ResponseBean;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.http.server.ServerBean;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: BodyObservable.java */
/* renamed from: xm  reason: default package */
/* loaded from: classes.dex */
public final class xm extends bs<ServerBean> {
    public final bs<IResponse> a;

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse> */
    public xm(bs<IResponse> bsVar) {
        this.a = bsVar;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super com.xiaopeng.lib.http.server.ServerBean> */
    @Override // defpackage.bs
    public void z(fs<? super ServerBean> fsVar) {
        this.a.a(new a(fsVar));
    }

    /* compiled from: BodyObservable.java */
    /* renamed from: xm$a */
    /* loaded from: classes.dex */
    public static class a implements fs<IResponse> {
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
        public void onNext(IResponse response) {
            Response raw = response.getRawResponse();
            String body = response.body();
            Log.d("BodyObservable", "onNext() called with: raw = [" + raw + "] body = [" + body + "]");
            if (raw != null) {
                this.a.onNext(a(body));
                return;
            }
            this.b = true;
            Throwable t = new um(response);
            try {
                this.a.onError(t);
            } catch (Throwable inner) {
                qs.b(inner);
                iv.m(new ps(t, inner));
            }
        }

        public static ServerBean a(String body) {
            ServerBean bean = null;
            try {
                JSONObject jsonObject = new JSONObject(body);
                bean = new ResponseBean();
                bean.setCode(jsonObject.getInt("code"));
                if (jsonObject.has("data")) {
                    bean.setData(jsonObject.getString("data"));
                }
                if (jsonObject.has("msg")) {
                    bean.setMsg(jsonObject.getString("msg"));
                }
            } catch (JSONException e) {
                Log.w("BodyObservable", "Invalid json syntax: json = [" + body + "], error = [" + e.getMessage() + "]");
            }
            return bean;
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
