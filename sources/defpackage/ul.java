package defpackage;

import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: HttpUtils.java */
/* renamed from: ul  reason: default package */
/* loaded from: classes.dex */
public class ul {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[Catch: UnsupportedEncodingException -> 0x0079, TryCatch #0 {UnsupportedEncodingException -> 0x0079, blocks: (B:2:0x0000, B:6:0x0014, B:9:0x001b, B:11:0x0024, B:12:0x002c, B:14:0x0032, B:15:0x0042, B:17:0x0048, B:19:0x006b, B:10:0x0021), top: B:24:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(java.lang.String r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.UnsupportedEncodingException -> L79
            r0.<init>()     // Catch: java.io.UnsupportedEncodingException -> L79
            r0.append(r9)     // Catch: java.io.UnsupportedEncodingException -> L79
            r1 = 38
            int r1 = r9.indexOf(r1)     // Catch: java.io.UnsupportedEncodingException -> L79
            java.lang.String r2 = "&"
            if (r1 > 0) goto L21
            r1 = 63
            int r1 = r9.indexOf(r1)     // Catch: java.io.UnsupportedEncodingException -> L79
            if (r1 <= 0) goto L1b
            goto L21
        L1b:
            java.lang.String r1 = "?"
            r0.append(r1)     // Catch: java.io.UnsupportedEncodingException -> L79
            goto L24
        L21:
            r0.append(r2)     // Catch: java.io.UnsupportedEncodingException -> L79
        L24:
            java.util.Set r1 = r10.entrySet()     // Catch: java.io.UnsupportedEncodingException -> L79
            java.util.Iterator r1 = r1.iterator()     // Catch: java.io.UnsupportedEncodingException -> L79
        L2c:
            boolean r3 = r1.hasNext()     // Catch: java.io.UnsupportedEncodingException -> L79
            if (r3 == 0) goto L6b
            java.lang.Object r3 = r1.next()     // Catch: java.io.UnsupportedEncodingException -> L79
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.io.UnsupportedEncodingException -> L79
            java.lang.Object r4 = r3.getValue()     // Catch: java.io.UnsupportedEncodingException -> L79
            java.util.List r4 = (java.util.List) r4     // Catch: java.io.UnsupportedEncodingException -> L79
            java.util.Iterator r5 = r4.iterator()     // Catch: java.io.UnsupportedEncodingException -> L79
        L42:
            boolean r6 = r5.hasNext()     // Catch: java.io.UnsupportedEncodingException -> L79
            if (r6 == 0) goto L6a
            java.lang.Object r6 = r5.next()     // Catch: java.io.UnsupportedEncodingException -> L79
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.io.UnsupportedEncodingException -> L79
            java.lang.String r7 = "UTF-8"
            java.lang.String r7 = java.net.URLEncoder.encode(r6, r7)     // Catch: java.io.UnsupportedEncodingException -> L79
            java.lang.Object r8 = r3.getKey()     // Catch: java.io.UnsupportedEncodingException -> L79
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.io.UnsupportedEncodingException -> L79
            r0.append(r8)     // Catch: java.io.UnsupportedEncodingException -> L79
            java.lang.String r8 = "="
            r0.append(r8)     // Catch: java.io.UnsupportedEncodingException -> L79
            r0.append(r7)     // Catch: java.io.UnsupportedEncodingException -> L79
            r0.append(r2)     // Catch: java.io.UnsupportedEncodingException -> L79
            goto L42
        L6a:
            goto L2c
        L6b:
            int r1 = r0.length()     // Catch: java.io.UnsupportedEncodingException -> L79
            int r1 = r1 + (-1)
            r0.deleteCharAt(r1)     // Catch: java.io.UnsupportedEncodingException -> L79
            java.lang.String r1 = r0.toString()     // Catch: java.io.UnsupportedEncodingException -> L79
            return r1
        L79:
            r0 = move-exception
            defpackage.wl.a(r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ul.c(java.lang.String, java.util.Map):java.lang.String");
    }

    public static Request.Builder a(Request.Builder builder, HttpHeaders headers) {
        if (headers.headersMap.isEmpty()) {
            return builder;
        }
        Headers.Builder headerBuilder = new Headers.Builder();
        try {
            for (Map.Entry<String, String> entry : headers.headersMap.entrySet()) {
                headerBuilder.add(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            wl.a(e);
        }
        builder.headers(headerBuilder.build());
        return builder;
    }

    public static RequestBody d(HttpParams params, boolean isMultipart) {
        if (params.fileParamsMap.isEmpty() && !isMultipart) {
            FormBody.Builder bodyBuilder = new FormBody.Builder();
            for (String key : params.urlParamsMap.keySet()) {
                List<String> urlValues = params.urlParamsMap.get(key);
                for (String value : urlValues) {
                    bodyBuilder.add(key, value);
                }
            }
            return bodyBuilder.build();
        }
        MultipartBody.Builder multipartBodybuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (!params.urlParamsMap.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : params.urlParamsMap.entrySet()) {
                List<String> urlValues2 = entry.getValue();
                for (String value2 : urlValues2) {
                    multipartBodybuilder.addFormDataPart(entry.getKey(), value2);
                }
            }
        }
        for (Map.Entry<String, List<HttpParams.FileWrapper>> entry2 : params.fileParamsMap.entrySet()) {
            List<HttpParams.FileWrapper> fileValues = entry2.getValue();
            for (HttpParams.FileWrapper fileWrapper : fileValues) {
                RequestBody fileBody = RequestBody.create(fileWrapper.contentType, fileWrapper.file);
                multipartBodybuilder.addFormDataPart(entry2.getKey(), fileWrapper.fileName, fileBody);
            }
        }
        return multipartBodybuilder.build();
    }

    public static MediaType e(String fileName) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentType = fileNameMap.getContentTypeFor(fileName.replace("#", ""));
        if (contentType == null) {
            return HttpParams.MEDIA_TYPE_STREAM;
        }
        return MediaType.parse(contentType);
    }

    public static <T> T b(T object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
        return object;
    }

    public static void f(Runnable runnable) {
        lk.h().g().post(runnable);
    }
}
