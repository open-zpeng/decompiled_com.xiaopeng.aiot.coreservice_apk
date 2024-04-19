package defpackage;

import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
/* compiled from: HttpLoggingInterceptor.java */
/* renamed from: ll  reason: default package */
/* loaded from: classes.dex */
public class ll implements Interceptor {
    public static final Charset a = Charset.forName(XmartV1Constants.UTF8_ENCODING);
    public volatile a b = a.NONE;
    public Level c;
    public Logger d;

    /* compiled from: HttpLoggingInterceptor.java */
    /* renamed from: ll$a */
    /* loaded from: classes.dex */
    public enum a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public ll(String tag) {
        this.d = Logger.getLogger(tag);
    }

    public void h(a level) {
        if (this.b == null) {
            throw new NullPointerException("printLevel == null. Use Level.NONE instead.");
        }
        this.b = level;
    }

    public void g(Level level) {
        this.c = level;
    }

    public final void d(String message) {
        this.d.log(this.c, message);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (this.b == a.NONE) {
            return chain.proceed(request);
        }
        e(request, chain.connection());
        long startNs = System.nanoTime();
        try {
            Response response = chain.proceed(request);
            long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
            return f(response, tookMs);
        } catch (Exception e) {
            d("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    public final void e(Request request, Connection connection) throws IOException {
        StringBuilder sb;
        a aVar = this.b;
        a aVar2 = a.BODY;
        boolean logBody = aVar == aVar2;
        boolean logHeaders = this.b == aVar2 || this.b == a.HEADERS;
        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;
        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
        try {
            try {
                String requestStartMessage = "--> " + request.method() + ' ' + request.url() + ' ' + protocol;
                d(requestStartMessage);
                if (logHeaders) {
                    if (hasRequestBody) {
                        if (requestBody.contentType() != null) {
                            d("\tContent-Type: " + requestBody.contentType());
                        }
                        if (requestBody.contentLength() != -1) {
                            d("\tContent-Length: " + requestBody.contentLength());
                        }
                    }
                    Headers headers = request.headers();
                    int count = headers.size();
                    for (int i = 0; i < count; i++) {
                        String name = headers.name(i);
                        if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                            d("\t" + name + ": " + headers.value(i));
                        }
                    }
                    d(" ");
                    if (logBody && hasRequestBody) {
                        if (c(requestBody.contentType())) {
                            a(request);
                        } else {
                            d("\tbody: maybe [binary body], omitted!");
                        }
                    }
                }
                sb = new StringBuilder();
            } catch (Exception e) {
                wl.a(e);
                sb = new StringBuilder();
            }
            sb.append("--> END ");
            sb.append(request.method());
            d(sb.toString());
        } catch (Throwable th) {
            d("--> END " + request.method());
            throw th;
        }
    }

    public final Response f(Response response, long tookMs) {
        Response.Builder builder = response.newBuilder();
        Response clone = builder.build();
        ResponseBody responseBody = clone.body();
        a aVar = this.b;
        a aVar2 = a.BODY;
        boolean z = false;
        boolean logBody = aVar == aVar2;
        boolean logHeaders = (this.b == aVar2 || this.b == a.HEADERS) ? true : true;
        try {
            try {
                d("<-- " + clone.code() + ' ' + clone.message() + ' ' + clone.request().url() + " (" + tookMs + "ms）");
                if (logHeaders) {
                    Headers headers = clone.headers();
                    int count = headers.size();
                    for (int i = 0; i < count; i++) {
                        d("\t" + headers.name(i) + ": " + headers.value(i));
                    }
                    d(" ");
                    if (logBody && HttpHeaders.hasBody(clone)) {
                        if (responseBody == null) {
                            return response;
                        }
                        if (c(responseBody.contentType())) {
                            byte[] bytes = vl.b(responseBody.byteStream());
                            MediaType contentType = responseBody.contentType();
                            String body = new String(bytes, b(contentType));
                            d("\tbody:" + body);
                            return response.newBuilder().body(ResponseBody.create(responseBody.contentType(), bytes)).build();
                        }
                        d("\tbody: maybe [binary body], omitted!");
                    }
                }
            } catch (Exception e) {
                wl.a(e);
            }
            return response;
        } finally {
            d("<-- END HTTP");
        }
    }

    public static Charset b(MediaType contentType) {
        Charset charset = a;
        if (contentType != null) {
            charset = contentType.charset(charset);
        }
        return charset == null ? a : charset;
    }

    public static boolean c(MediaType mediaType) {
        if (mediaType == null) {
            return false;
        }
        if (mediaType.type() == null || !mediaType.type().equals("text")) {
            String subtype = mediaType.subtype();
            if (subtype != null) {
                String subtype2 = subtype.toLowerCase();
                if (subtype2.contains("x-www-form-urlencoded") || subtype2.contains("json") || subtype2.contains("xml") || subtype2.contains("html")) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final void a(Request request) {
        try {
            Request copy = request.newBuilder().build();
            RequestBody body = copy.body();
            if (body == null) {
                return;
            }
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            Charset charset = b(body.contentType());
            d("\tbody:" + buffer.readString(charset));
        } catch (Exception e) {
            wl.a(e);
        }
    }
}
