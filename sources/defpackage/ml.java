package defpackage;

import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: GetRequest.java */
/* renamed from: ml  reason: default package */
/* loaded from: classes.dex */
public class ml<T> extends ql<T, ml<T>> {
    /* JADX WARN: Generic types in debug info not equals: ml != com.lzy.okgo.request.GetRequest<T> */
    public ml(String url) {
        super(url);
    }

    /* JADX WARN: Generic types in debug info not equals: ml != com.lzy.okgo.request.GetRequest<T> */
    @Override // defpackage.sl
    public Request f(RequestBody requestBody) {
        Request.Builder requestBuilder = G(requestBody);
        return requestBuilder.get().url(this.a).tag(this.f).build();
    }
}
