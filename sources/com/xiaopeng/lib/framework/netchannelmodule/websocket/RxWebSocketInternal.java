package com.xiaopeng.lib.framework.netchannelmodule.websocket;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
/* loaded from: classes.dex */
public class RxWebSocketInternal {
    private static final int CLOSE_BY_CANCELLATION = 3000;
    private static final int CLOSE_CLIENT_NORMAL = 1000;
    private static final int DEFAULT_RETRY_INTERVAL = 1000;
    private OkHttpClient mClient;
    private Map<String, String> mHeaders;
    private String mLogTag;
    private Map<String, bs<IWebSocketInfo>> mObservableMap;
    private long mPingInterval;
    private long mReconnectInterval;
    private boolean mShowLog;
    private Map<String, WebSocket> mWebSocketMap;

    private RxWebSocketInternal() {
        this.mLogTag = "RxWebSocket";
        this.mReconnectInterval = 1000L;
        this.mPingInterval = 1000L;
        try {
            Class.forName("okhttp3.OkHttpClient");
            try {
                Class.forName("bs");
                try {
                    Class.forName("is");
                    this.mObservableMap = new ConcurrentHashMap();
                    this.mWebSocketMap = new ConcurrentHashMap();
                    this.mHeaders = new ConcurrentHashMap();
                    this.mClient = new OkHttpClient();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("Must be dependency rxandroid 2.x");
                }
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Must be dependency rxjava 2.x");
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Must be dependency okhttp3 !");
        }
    }

    public static RxWebSocketInternal getInstance() {
        return Holder.INSTANCE;
    }

    /* loaded from: classes.dex */
    public static final class Holder {
        private static final RxWebSocketInternal INSTANCE = new RxWebSocketInternal();

        private Holder() {
        }
    }

    public void client(OkHttpClient mClient) {
        if (mClient == null) {
            throw new NullPointerException("mClient == null");
        }
        this.mClient = mClient.newBuilder().pingInterval(this.mPingInterval, TimeUnit.MILLISECONDS).build();
    }

    public void header(String key, String value) {
        if (key == null || value == null) {
            return;
        }
        this.mHeaders.put(key, value);
    }

    public void sslSocketFactory(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
        this.mClient = this.mClient.newBuilder().sslSocketFactory(sslSocketFactory, trustManager).build();
    }

    public void showLog(boolean mShowLog) {
        this.mShowLog = mShowLog;
    }

    public void showLog(boolean showLog, String logTag) {
        showLog(showLog);
        this.mLogTag = logTag;
    }

    public void reconnectInterval(long interval) {
        this.mReconnectInterval = interval;
    }

    public void pingInterval(long interval) {
        this.mPingInterval = interval;
        this.mClient = this.mClient.newBuilder().pingInterval(interval, TimeUnit.MILLISECONDS).build();
    }

    /* JADX WARN: Generic types in debug info not equals: bs != io.reactivex.Observable<com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo> */
    public bs<IWebSocketInfo> getWebSocketInfo(final String url, long timeout, TimeUnit timeUnit) {
        bs<IWebSocketInfo> bsVar = this.mObservableMap.get(url);
        if (bsVar == null) {
            bsVar = bs.d(new WebSocketOnSubscribe(url)).C(timeout, timeUnit).t(new bt<Throwable>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.3
                @Override // defpackage.bt
                public boolean test(Throwable throwable) throws Exception {
                    if (RxWebSocketInternal.this.mShowLog) {
                        String str = RxWebSocketInternal.this.mLogTag;
                        Log.d(str, "predicate retry for " + throwable);
                    }
                    return (throwable instanceof IOException) || (throwable instanceof TimeoutException);
                }
            }).f(new us() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.2
                @Override // defpackage.us
                public void run() throws Exception {
                    RxWebSocketInternal.this.mObservableMap.remove(url);
                    RxWebSocketInternal.this.mWebSocketMap.remove(url);
                    if (RxWebSocketInternal.this.mShowLog) {
                        Log.d(RxWebSocketInternal.this.mLogTag, "OnDispose");
                    }
                }
            }).i(new ys<IWebSocketInfo>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.1
                @Override // defpackage.ys
                public void accept(IWebSocketInfo webSocketInfo) throws Exception {
                    if (webSocketInfo.isOnOpen()) {
                        RxWebSocketInternal.this.mWebSocketMap.put(url, ((WebSocketInfo) webSocketInfo).getWebSocket());
                    }
                }
            }).u().A(jv.b()).o(is.a());
            this.mObservableMap.put(url, bsVar);
        } else {
            WebSocket webSocket = this.mWebSocketMap.get(url);
            if (webSocket != null) {
                bsVar = bsVar.v(new WebSocketInfo(webSocket, IWebSocketInfo.STATE.OPEN));
            }
        }
        return bsVar.o(is.a());
    }

    public bs<IWebSocketInfo> getWebSocketInfo(String url) {
        return getWebSocketInfo(url, 1L, TimeUnit.HOURS);
    }

    public bs<String> getWebSocketString(String url) {
        return getWebSocketInfo(url).k(new bt<IWebSocketInfo>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.5
            @Override // defpackage.bt
            public boolean test(IWebSocketInfo webSocketInfo) throws Exception {
                return webSocketInfo.stringMessage() != null;
            }
        }).n(new zs<IWebSocketInfo, String>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.4
            @Override // defpackage.zs
            public String apply(IWebSocketInfo webSocketInfo) throws Exception {
                return webSocketInfo.stringMessage();
            }
        });
    }

    public bs<ByteString> getWebSocketByteString(String url) {
        return getWebSocketInfo(url).k(new bt<IWebSocketInfo>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.7
            @Override // defpackage.bt
            public boolean test(IWebSocketInfo webSocketInfo) throws Exception {
                return webSocketInfo.byteStringMessage() != null;
            }
        }).n(new zs<IWebSocketInfo, ByteString>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.6
            @Override // defpackage.zs
            public ByteString apply(IWebSocketInfo webSocketInfo) throws Exception {
                return webSocketInfo.byteStringMessage();
            }
        });
    }

    public bs<WebSocket> getWebSocket(String url) {
        return getWebSocketInfo(url).k(new bt<IWebSocketInfo>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.9
            @Override // defpackage.bt
            public boolean test(IWebSocketInfo webSocketInfo) throws Exception {
                return ((WebSocketInfo) webSocketInfo).getWebSocket() != null;
            }
        }).n(new zs<IWebSocketInfo, WebSocket>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.8
            @Override // defpackage.zs
            public WebSocket apply(IWebSocketInfo webSocketInfo) throws Exception {
                return ((WebSocketInfo) webSocketInfo).getWebSocket();
            }
        });
    }

    public void send(String url, String msg) {
        WebSocket webSocket = this.mWebSocketMap.get(url);
        if (webSocket != null) {
            webSocket.send(msg);
            return;
        }
        throw new IllegalStateException("WebSocket channel not open");
    }

    public void send(String url, ByteString byteString) {
        WebSocket webSocket = this.mWebSocketMap.get(url);
        if (webSocket != null) {
            webSocket.send(byteString);
            return;
        }
        throw new IllegalStateException("WebSocket channel not open");
    }

    public void asyncSend(String url, final String msg) {
        getWebSocket(url).B(1L).w(new ys<WebSocket>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.10
            @Override // defpackage.ys
            public void accept(WebSocket webSocket) throws Exception {
                webSocket.send(msg);
            }
        });
    }

    public void asyncSend(String url, final ByteString byteString) {
        getWebSocket(url).B(1L).w(new ys<WebSocket>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.RxWebSocketInternal.11
            @Override // defpackage.ys
            public void accept(WebSocket webSocket) throws Exception {
                webSocket.send(byteString);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Request getRequest(String url) {
        Request.Builder builder = new Request.Builder().get().url(url);
        if (this.mHeaders.size() > 0) {
            for (String key : this.mHeaders.keySet()) {
                builder.addHeader(key, this.mHeaders.get(key));
            }
        }
        return builder.build();
    }

    /* loaded from: classes.dex */
    public final class WebSocketOnSubscribe implements ds<IWebSocketInfo> {
        private String url;
        private WebSocket webSocket;

        public WebSocketOnSubscribe(String url) {
            this.url = url;
        }

        /* JADX WARN: Generic types in debug info not equals: cs != io.reactivex.ObservableEmitter<com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo> */
        @Override // defpackage.ds
        public void subscribe(cs<IWebSocketInfo> csVar) throws Exception {
            if (this.webSocket != null && Looper.getMainLooper().getThread() != Thread.currentThread()) {
                long ms = RxWebSocketInternal.this.mReconnectInterval;
                if (ms == 0) {
                    ms = 1000;
                }
                SystemClock.sleep(ms);
                csVar.onNext(WebSocketInfo.createReconnect());
            }
            initWebSocket(csVar);
        }

        /* JADX WARN: Generic types in debug info not equals: cs != io.reactivex.ObservableEmitter<com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo> */
        private void initWebSocket(cs<IWebSocketInfo> csVar) {
            WebSocket newWebSocket = RxWebSocketInternal.this.mClient.newWebSocket(RxWebSocketInternal.this.getRequest(this.url), new WebSocketListenerInternal(csVar, RxWebSocketInternal.this.mWebSocketMap, this.url, RxWebSocketInternal.this.mShowLog, RxWebSocketInternal.this.mLogTag));
            this.webSocket = newWebSocket;
            csVar.b(new CancelableInternal(newWebSocket, this.url, RxWebSocketInternal.this.mShowLog, RxWebSocketInternal.this.mLogTag));
        }
    }

    /* loaded from: classes.dex */
    public static class CancelableInternal implements xs {
        private boolean showLog;
        private String tag;
        private String url;
        private WebSocket webSocket;

        public CancelableInternal(WebSocket webSocket, String url, boolean showLog, String tag) {
            this.webSocket = webSocket;
            this.url = url;
            this.showLog = showLog;
            this.tag = tag;
        }

        @Override // defpackage.xs
        public void cancel() throws Exception {
            this.webSocket.close(RxWebSocketInternal.CLOSE_BY_CANCELLATION, "close WebSocket from rx cancel");
            if (this.showLog) {
                String str = this.tag;
                Log.d(str, this.url + " --> cancel for rx cancel");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class WebSocketListenerInternal extends WebSocketListener {
        private cs<IWebSocketInfo> emitter;
        private boolean showLog;
        private String tag;
        private String url;
        private Map<String, WebSocket> webSocketMap;

        /* JADX WARN: Generic types in debug info not equals: cs != io.reactivex.ObservableEmitter<com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.IWebSocketInfo> */
        public WebSocketListenerInternal(cs<IWebSocketInfo> csVar, Map<String, WebSocket> webSocketMap, String url, boolean showLog, String tag) {
            this.emitter = csVar;
            this.webSocketMap = webSocketMap;
            this.url = url;
            this.showLog = showLog;
            this.tag = tag;
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(WebSocket webSocket, Response response) {
            if (this.showLog) {
                String str = this.tag;
                Log.d(str, this.url + " --> onOpen");
            }
            this.webSocketMap.put(this.url, webSocket);
            if (!this.emitter.c()) {
                this.emitter.onNext(new WebSocketInfo(webSocket, IWebSocketInfo.STATE.OPEN));
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, String text) {
            if (!this.emitter.c()) {
                this.emitter.onNext(new WebSocketInfo(webSocket, text));
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            if (!this.emitter.c()) {
                this.emitter.onNext(new WebSocketInfo(webSocket, bytes));
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            if (this.showLog && !(t instanceof UnknownHostException)) {
                String str = this.tag;
                Log.e(str, t.toString() + webSocket.request().url().uri().getPath());
            }
            if (!this.emitter.c()) {
                this.emitter.onError(t);
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onClosing(WebSocket webSocket, int code, String reason) {
            webSocket.close(1000, null);
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(WebSocket webSocket, int code, String reason) {
            if (this.showLog) {
                String str = this.tag;
                Log.d(str, this.url + " --> onClosed:code= " + code + "reason:" + reason);
            }
            if (!this.emitter.c()) {
                WebSocketInfo info = new WebSocketInfo(webSocket, IWebSocketInfo.STATE.CLOSED);
                info.setClosedReason(code, reason);
                this.emitter.onNext(info);
            }
        }
    }

    public void close(String url) {
        WebSocket webSocket = this.mWebSocketMap.get(url);
        if (webSocket != null) {
            this.mObservableMap.remove(url);
            this.mWebSocketMap.remove(url);
            webSocket.close(1000, null);
        }
    }
}
