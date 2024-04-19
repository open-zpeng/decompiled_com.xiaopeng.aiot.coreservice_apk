package defpackage;

import com.lzy.okgo.model.HttpParams;
import defpackage.pl;
import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: BodyRequest.java */
/* renamed from: pl  reason: default package */
/* loaded from: classes.dex */
public abstract class pl<T, R extends pl> extends sl<T, R> {
    public transient MediaType s;
    public String t;
    public byte[] u;
    public transient File v;
    public boolean w;
    public boolean x;
    public RequestBody y;

    /* JADX WARN: Generic types in debug info not equals: pl != com.lzy.okgo.request.base.BodyRequest<T, R extends pl> */
    public pl(String url) {
        super(url);
        this.w = false;
        this.x = false;
    }

    /* JADX WARN: Generic types in debug info not equals: pl != com.lzy.okgo.request.base.BodyRequest<T, R extends pl> */
    public R H(boolean isMultipart) {
        this.w = isMultipart;
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: pl != com.lzy.okgo.request.base.BodyRequest<T, R extends pl> */
    public R I(String key, File file) {
        this.k.put(key, file);
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: pl != com.lzy.okgo.request.base.BodyRequest<T, R extends pl> */
    public R K(String json) {
        this.t = json;
        this.s = HttpParams.MEDIA_TYPE_JSON;
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: pl != com.lzy.okgo.request.base.BodyRequest<T, R extends pl> */
    public R J(File file) {
        this.v = file;
        this.s = ul.e(file.getName());
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: pl != com.lzy.okgo.request.base.BodyRequest<T, R extends pl> */
    @Override // defpackage.sl
    public RequestBody g() {
        MediaType mediaType;
        MediaType mediaType2;
        MediaType mediaType3;
        if (this.x) {
            this.a = ul.c(this.b, this.k.urlParamsMap);
        }
        RequestBody requestBody = this.y;
        if (requestBody != null) {
            return requestBody;
        }
        String str = this.t;
        if (str == null || (mediaType3 = this.s) == null) {
            byte[] bArr = this.u;
            if (bArr == null || (mediaType2 = this.s) == null) {
                File file = this.v;
                return (file == null || (mediaType = this.s) == null) ? ul.d(this.k, this.w) : RequestBody.create(mediaType, file);
            }
            return RequestBody.create(mediaType2, bArr);
        }
        return RequestBody.create(mediaType3, str);
    }

    /* JADX WARN: Generic types in debug info not equals: pl != com.lzy.okgo.request.base.BodyRequest<T, R extends pl> */
    public Request.Builder G(RequestBody requestBody) {
        try {
            u("Content-Length", String.valueOf(requestBody.contentLength()));
        } catch (IOException e) {
            wl.a(e);
        }
        Request.Builder requestBuilder = new Request.Builder();
        return ul.a(requestBuilder, this.l);
    }
}
