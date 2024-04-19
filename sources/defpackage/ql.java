package defpackage;

import defpackage.ql;
import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: NoBodyRequest.java */
/* renamed from: ql  reason: default package */
/* loaded from: classes.dex */
public abstract class ql<T, R extends ql> extends sl<T, R> {
    /* JADX WARN: Generic types in debug info not equals: ql != com.lzy.okgo.request.base.NoBodyRequest<T, R extends ql> */
    public ql(String url) {
        super(url);
    }

    /* JADX WARN: Generic types in debug info not equals: ql != com.lzy.okgo.request.base.NoBodyRequest<T, R extends ql> */
    @Override // defpackage.sl
    public RequestBody g() {
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: ql != com.lzy.okgo.request.base.NoBodyRequest<T, R extends ql> */
    public Request.Builder G(RequestBody requestBody) {
        this.a = ul.c(this.b, this.k.urlParamsMap);
        Request.Builder requestBuilder = new Request.Builder();
        return ul.a(requestBuilder, this.l);
    }
}
