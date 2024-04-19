package defpackage;

import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: HeadRequest.java */
/* renamed from: nl  reason: default package */
/* loaded from: classes.dex */
public class nl<T> extends ql<T, nl<T>> {
    /* JADX WARN: Generic types in debug info not equals: nl != com.lzy.okgo.request.HeadRequest<T> */
    public nl(String url) {
        super(url);
    }

    /* JADX WARN: Generic types in debug info not equals: nl != com.lzy.okgo.request.HeadRequest<T> */
    @Override // defpackage.sl
    public Request f(RequestBody requestBody) {
        Request.Builder requestBuilder = G(requestBody);
        return requestBuilder.head().url(this.a).tag(this.f).build();
    }
}
