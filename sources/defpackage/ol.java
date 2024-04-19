package defpackage;

import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: PostRequest.java */
/* renamed from: ol  reason: default package */
/* loaded from: classes.dex */
public class ol<T> extends pl<T, ol<T>> {
    /* JADX WARN: Generic types in debug info not equals: ol != com.lzy.okgo.request.PostRequest<T> */
    public ol(String url) {
        super(url);
    }

    /* JADX WARN: Generic types in debug info not equals: ol != com.lzy.okgo.request.PostRequest<T> */
    @Override // defpackage.sl
    public Request f(RequestBody requestBody) {
        Request.Builder requestBuilder = G(requestBody);
        return requestBuilder.post(requestBody).url(this.a).tag(this.f).build();
    }
}
