package defpackage;

import android.text.TextUtils;
import com.lzy.okgo.model.HttpHeaders;
import com.xiaopeng.base.log.LogUtils;
import java.util.Locale;
import java.util.StringTokenizer;
import okhttp3.Headers;
/* compiled from: HeaderParser.java */
/* renamed from: tl  reason: default package */
/* loaded from: classes.dex */
public class tl {
    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public static <T> ok<T> b(Headers responseHeaders, T data, pk cacheMode, String cacheKey) {
        long localExpire = 0;
        if (cacheMode == pk.DEFAULT) {
            long date = HttpHeaders.getDate(responseHeaders.get("Date"));
            long expires = HttpHeaders.getExpiration(responseHeaders.get("Expires"));
            String cacheControl = HttpHeaders.getCacheControl(responseHeaders.get("Cache-Control"), responseHeaders.get(HttpHeaders.HEAD_KEY_PRAGMA));
            if (TextUtils.isEmpty(cacheControl) && expires <= 0) {
                return null;
            }
            long maxAge = 0;
            if (!TextUtils.isEmpty(cacheControl)) {
                StringTokenizer tokens = new StringTokenizer(cacheControl, LogUtils.SEPARATOR);
                while (tokens.hasMoreTokens()) {
                    String token = tokens.nextToken().trim().toLowerCase(Locale.getDefault());
                    if (token.equals("no-cache") || token.equals("no-store")) {
                        return null;
                    }
                    if (token.startsWith("max-age=")) {
                        try {
                            maxAge = Long.parseLong(token.substring(8));
                            if (maxAge <= 0) {
                                return null;
                            }
                        } catch (Exception e) {
                            wl.a(e);
                        }
                    }
                }
            }
            long now = System.currentTimeMillis();
            if (date > 0) {
                now = date;
            }
            if (maxAge > 0) {
                localExpire = now + (1000 * maxAge);
            } else if (expires >= 0) {
                localExpire = expires;
            }
        } else {
            localExpire = System.currentTimeMillis();
        }
        HttpHeaders headers = new HttpHeaders();
        for (String headerName : responseHeaders.names()) {
            headers.put(headerName, responseHeaders.get(headerName));
        }
        ok<T> okVar = new ok<>();
        okVar.k(cacheKey);
        okVar.i(data);
        okVar.l(localExpire);
        okVar.m(headers);
        return okVar;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public static <T> void a(sl request, ok<T> okVar, pk cacheMode) {
        HttpHeaders responseHeaders;
        if (okVar != null && cacheMode == pk.DEFAULT && (responseHeaders = okVar.f()) != null) {
            String eTag = responseHeaders.get("ETag");
            if (eTag != null) {
                request.u("If-None-Match", eTag);
            }
            long lastModified = HttpHeaders.getLastModified(responseHeaders.get("Last-Modified"));
            if (lastModified > 0) {
                request.u("If-Modified-Since", HttpHeaders.formatMillisToGMT(lastModified));
            }
        }
    }
}
