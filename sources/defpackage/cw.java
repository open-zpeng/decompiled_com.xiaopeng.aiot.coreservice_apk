package defpackage;

import com.lzy.okgo.model.HttpHeaders;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: MqttAsyncClient.java */
/* renamed from: cw  reason: default package */
/* loaded from: classes.dex */
public class cw implements yv {
    public static final String a;
    public static final qy b;
    public static int c;
    public static Object d;
    public String e;
    public String f;
    public qw g;
    public Hashtable h;
    public fw i;
    public dw j;
    public gw k;
    public Object l;
    public Timer m;
    public boolean n = false;
    public ScheduledExecutorService o;

    static {
        String name = cw.class.getName();
        a = name;
        b = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
        c = 1000;
        d = new Object();
    }

    public cw(String serverURI, String clientId, fw persistence, mw pingSender, ScheduledExecutorService executorService) throws iw {
        b.setResourceName(clientId);
        if (clientId == null) {
            throw new IllegalArgumentException("Null clientId");
        }
        int clientIdLength = 0;
        int i = 0;
        while (i < clientId.length() - 1) {
            if (c(clientId.charAt(i))) {
                i++;
            }
            clientIdLength++;
            i++;
        }
        if (clientIdLength > 65535) {
            throw new IllegalArgumentException("ClientId longer than 65535 characters");
        }
        gw.x(serverURI);
        this.f = serverURI;
        this.e = clientId;
        this.i = persistence;
        if (persistence == null) {
            this.i = new sy();
        }
        this.o = executorService;
        if (executorService == null) {
            this.o = Executors.newScheduledThreadPool(10);
        }
        b.fine(a, "MqttAsyncClient", "101", new Object[]{clientId, serverURI, persistence});
        this.i.open(clientId, serverURI);
        this.g = new qw(this, this.i, pingSender, this.o);
        this.i.close();
        this.h = new Hashtable();
    }

    public static boolean c(char ch) {
        return ch >= 55296 && ch <= 56319;
    }

    public dx[] t(String address, gw options) throws iw, nw {
        String[] array;
        b.fine(a, "createNetworkModules", "116", new Object[]{address});
        String[] serverURIs = options.i();
        if (serverURIs == null) {
            array = new String[]{address};
        } else {
            array = serverURIs.length == 0 ? new String[]{address} : serverURIs;
        }
        dx[] networkModules = new dx[array.length];
        for (int i = 0; i < array.length; i++) {
            networkModules[i] = s(array[i], options);
        }
        b.fine(a, "createNetworkModules", "108");
        return networkModules;
    }

    public final dx s(String address, gw options) throws iw, nw {
        String[] enabledCiphers;
        int port;
        SocketFactory factory;
        int port2;
        ix wSSFactoryFactory;
        SocketFactory factory2;
        String[] enabledCiphers2;
        qy qyVar = b;
        String str = a;
        qyVar.fine(str, "createNetworkModule", "115", new Object[]{address});
        SocketFactory factory3 = options.j();
        int serverURIType = gw.x(address);
        try {
            URI uri = new URI(address);
            if (uri.getHost() == null && address.contains("_")) {
                try {
                    Field hostField = URI.class.getDeclaredField("host");
                    hostField.setAccessible(true);
                    String shortAddress = address.substring(uri.getScheme().length() + 3);
                    hostField.set(uri, x(shortAddress));
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
                    throw yw.b(e.getCause());
                }
            }
            String host = uri.getHost();
            int port3 = uri.getPort();
            switch (serverURIType) {
                case 0:
                    if (port3 == -1) {
                        port3 = 1883;
                    }
                    if (factory3 == null) {
                        factory3 = SocketFactory.getDefault();
                    } else if (factory3 instanceof SSLSocketFactory) {
                        throw yw.a(32105);
                    }
                    gx gxVar = new gx(factory3, host, port3, this.e);
                    gxVar.d(options.a());
                    return gxVar;
                case 1:
                    if (port3 == -1) {
                        port3 = 8883;
                    }
                    ix factoryFactory = null;
                    if (factory3 == null) {
                        factoryFactory = new ix();
                        Properties sslClientProps = options.h();
                        if (sslClientProps != null) {
                            factoryFactory.t(sslClientProps, null);
                        }
                        factory3 = factoryFactory.c(null);
                    } else if (!(factory3 instanceof SSLSocketFactory)) {
                        throw yw.a(32105);
                    }
                    fx fxVar = new fx((SSLSocketFactory) factory3, host, port3, this.e);
                    fxVar.g(options.a());
                    fxVar.f(options.g());
                    if (factoryFactory != null && (enabledCiphers = factoryFactory.e(null)) != null) {
                        fxVar.e(enabledCiphers);
                        return fxVar;
                    }
                    return fxVar;
                case 2:
                default:
                    qyVar.fine(str, "createNetworkModule", "119", new Object[]{address});
                    return null;
                case 3:
                    if (port3 != -1) {
                        port = port3;
                    } else {
                        port = 80;
                    }
                    if (factory3 == null) {
                        factory = SocketFactory.getDefault();
                    } else if (factory3 instanceof SSLSocketFactory) {
                        throw yw.a(32105);
                    } else {
                        factory = factory3;
                    }
                    px pxVar = new px(factory, address, host, port, this.e);
                    pxVar.d(options.a());
                    return pxVar;
                case 4:
                    if (port3 != -1) {
                        port2 = port3;
                    } else {
                        port2 = 443;
                    }
                    if (factory3 == null) {
                        ix wSSFactoryFactory2 = new ix();
                        Properties sslClientProps2 = options.h();
                        if (sslClientProps2 != null) {
                            wSSFactoryFactory2.t(sslClientProps2, null);
                        }
                        wSSFactoryFactory = wSSFactoryFactory2;
                        factory2 = wSSFactoryFactory2.c(null);
                    } else if (factory3 instanceof SSLSocketFactory) {
                        wSSFactoryFactory = null;
                        factory2 = factory3;
                    } else {
                        throw yw.a(32105);
                    }
                    rx rxVar = new rx((SSLSocketFactory) factory2, address, host, port2, this.e);
                    rxVar.g(options.a());
                    if (wSSFactoryFactory != null && (enabledCiphers2 = wSSFactoryFactory.e(null)) != null) {
                        rxVar.e(enabledCiphers2);
                    }
                    return rxVar;
            }
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException("Malformed URI: " + address + ", " + e2.getMessage());
        }
    }

    public final String x(String uri) {
        int portIndex = uri.indexOf(58);
        if (portIndex == -1) {
            portIndex = uri.indexOf(47);
        }
        if (portIndex == -1) {
            portIndex = uri.length();
        }
        return uri.substring(0, portIndex);
    }

    public bw r(gw options, Object userContext, xv callback) throws iw, nw {
        gw options2;
        if (this.g.B()) {
            throw yw.a(32100);
        }
        if (this.g.C()) {
            throw new iw(32110);
        }
        if (this.g.E()) {
            throw new iw(32102);
        }
        if (this.g.A()) {
            throw new iw(32111);
        }
        if (options != null) {
            options2 = options;
        } else {
            options2 = new gw();
        }
        this.k = options2;
        this.l = userContext;
        boolean automaticReconnect = options2.n();
        qy qyVar = b;
        String str = a;
        Object[] objArr = new Object[8];
        objArr[0] = Boolean.valueOf(options2.o());
        objArr[1] = new Integer(options2.a());
        objArr[2] = new Integer(options2.c());
        objArr[3] = options2.k();
        objArr[4] = options2.f() == null ? "[null]" : "[notnull]";
        objArr[5] = options2.m() != null ? "[notnull]" : "[null]";
        objArr[6] = userContext;
        objArr[7] = callback;
        qyVar.fine(str, "connect", "103", objArr);
        this.g.L(t(this.f, options2));
        this.g.M(new b(automaticReconnect));
        ow userToken = new ow(b());
        ww connectActionListener = new ww(this, this.i, this.g, options2, userToken, userContext, callback, this.n);
        userToken.i(connectActionListener);
        userToken.j(this);
        dw dwVar = this.j;
        if (dwVar instanceof ew) {
            connectActionListener.b((ew) dwVar);
        }
        this.g.K(0);
        connectActionListener.a();
        return userToken;
    }

    public bw v(Object userContext, xv callback) throws iw {
        return u(30000L, userContext, callback);
    }

    public bw u(long quiesceTimeout, Object userContext, xv callback) throws iw {
        qy qyVar = b;
        String str = a;
        qyVar.fine(str, "disconnect", "104", new Object[]{new Long(quiesceTimeout), userContext, callback});
        ow token = new ow(b());
        token.i(callback);
        token.j(userContext);
        wx disconnect = new wx();
        try {
            this.g.r(disconnect, quiesceTimeout, token);
            qyVar.fine(str, "disconnect", "108");
            return token;
        } catch (iw ex) {
            b.fine(a, "disconnect", "105", null, ex);
            throw ex;
        }
    }

    public void w(long quiesceTimeout, long disconnectTimeout, boolean sendDisconnectPacket) throws iw {
        this.g.s(quiesceTimeout, disconnectTimeout, sendDisconnectPacket);
    }

    public boolean y() {
        return this.g.B();
    }

    @Override // defpackage.yv
    public String b() {
        return this.e;
    }

    @Override // defpackage.yv
    public String a() {
        return this.f;
    }

    public bw F(String topicFilter, int qos, Object userContext, xv callback) throws iw {
        return G(new String[]{topicFilter}, new int[]{qos}, userContext, callback);
    }

    public bw G(String[] topicFilters, int[] qos, Object userContext, xv callback) throws iw {
        if (topicFilters.length != qos.length) {
            throw new IllegalArgumentException();
        }
        for (String str : topicFilters) {
            this.g.G(str);
        }
        if (b.isLoggable(5)) {
            StringBuffer subs = new StringBuffer();
            for (int i = 0; i < topicFilters.length; i++) {
                if (i > 0) {
                    subs.append(", ");
                }
                subs.append("topic=");
                subs.append(topicFilters[i]);
                subs.append(" qos=");
                subs.append(qos[i]);
                pw.b(topicFilters[i], true);
            }
            b.fine(a, "subscribe", "106", new Object[]{subs.toString(), userContext, callback});
        }
        ow token = new ow(b());
        token.i(callback);
        token.j(userContext);
        token.a.y(topicFilters);
        jy register = new jy(topicFilters, qos);
        this.g.H(register, token);
        b.fine(a, "subscribe", "109");
        return token;
    }

    public void C(dw callback) {
        this.j = callback;
        this.g.I(callback);
    }

    public zv z(String topic, jw message, Object userContext, xv callback) throws iw, lw {
        qy qyVar = b;
        String str = a;
        qyVar.fine(str, "publish", "111", new Object[]{topic, userContext, callback});
        pw.b(topic, false);
        hw token = new hw(b());
        token.i(callback);
        token.j(userContext);
        token.k(message);
        token.a.y(new String[]{topic});
        gy pubMsg = new gy(topic, message);
        this.g.H(pubMsg, token);
        qyVar.fine(str, "publish", "112");
        return token;
    }

    public void A() throws iw {
        b.fine(a, "reconnect", "500", new Object[]{this.e});
        if (this.g.B()) {
            throw yw.a(32100);
        }
        if (this.g.C()) {
            throw new iw(32110);
        }
        if (this.g.E()) {
            throw new iw(32102);
        }
        if (this.g.A()) {
            throw new iw(32111);
        }
        E();
        p();
    }

    public final void p() {
        b.fine(a, "attemptReconnect", "500", new Object[]{this.e});
        try {
            r(this.k, this.l, new a("attemptReconnect"));
        } catch (nw ex) {
            b.fine(a, "attemptReconnect", "804", null, ex);
        } catch (iw ex2) {
            b.fine(a, "attemptReconnect", "804", null, ex2);
        }
    }

    public final void D() {
        b.fine(a, "startReconnectCycle", "503", new Object[]{this.e, new Long(c)});
        Timer timer = new Timer("MQTT Reconnect: " + this.e);
        this.m = timer;
        timer.schedule(new c(this, null), (long) c);
    }

    public final void E() {
        b.fine(a, "stopReconnectCycle", "504", new Object[]{this.e});
        synchronized (d) {
            if (this.k.n()) {
                Timer timer = this.m;
                if (timer != null) {
                    timer.cancel();
                    this.m = null;
                }
                c = 1000;
            }
        }
    }

    /* compiled from: MqttAsyncClient.java */
    /* renamed from: cw$c */
    /* loaded from: classes.dex */
    public class c extends TimerTask {
        public c() {
        }

        public /* synthetic */ c(cw cwVar, c cVar) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cw.b.fine(cw.a, "ReconnectTask.run", "506");
            cw.this.p();
        }
    }

    /* compiled from: MqttAsyncClient.java */
    /* renamed from: cw$b */
    /* loaded from: classes.dex */
    public class b implements ew {
        public final boolean a;

        public b(boolean isAutomaticReconnect) {
            this.a = isAutomaticReconnect;
        }

        @Override // defpackage.dw
        public void connectionLost(Throwable cause) {
            if (this.a) {
                cw.this.g.N(true);
                cw.this.n = true;
                cw.this.D();
            }
        }

        @Override // defpackage.dw
        public void messageArrived(String topic, jw message) throws Exception {
        }

        @Override // defpackage.dw
        public void deliveryComplete(zv token) {
        }

        @Override // defpackage.ew
        public void connectComplete(boolean reconnect, String serverURI) {
        }
    }

    /* compiled from: MqttAsyncClient.java */
    /* renamed from: cw$a */
    /* loaded from: classes.dex */
    public class a implements xv {
        public final String a;

        public a(String methodName) {
            this.a = methodName;
        }

        @Override // defpackage.xv
        public void onSuccess(bw asyncActionToken) {
            cw.b.fine(cw.a, this.a, "501", new Object[]{asyncActionToken.f().b()});
            cw.this.g.N(false);
            cw.this.E();
        }

        @Override // defpackage.xv
        public void onFailure(bw asyncActionToken, Throwable exception) {
            cw.b.fine(cw.a, this.a, "502", new Object[]{asyncActionToken.f().b()});
            if (cw.c < 128000) {
                cw.c *= 2;
            }
            a(cw.c);
        }

        public final void a(int delay) {
            String reschedulemethodName = String.valueOf(this.a) + ":rescheduleReconnectCycle";
            cw.b.fine(cw.a, reschedulemethodName, "505", new Object[]{cw.this.e, String.valueOf(cw.c)});
            synchronized (cw.d) {
                if (cw.this.k.n()) {
                    if (cw.this.m != null) {
                        cw.this.m.schedule(new c(cw.this, null), delay);
                    } else {
                        cw.c = delay;
                        cw.this.D();
                    }
                }
            }
        }
    }

    public void B(wv bufferOpts) {
        this.g.J(new xw(bufferOpts));
    }

    public void q(boolean force) throws iw {
        qy qyVar = b;
        String str = a;
        qyVar.fine(str, HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "113");
        this.g.n(force);
        qyVar.fine(str, HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "114");
    }
}
