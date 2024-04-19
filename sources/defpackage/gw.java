package defpackage;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
/* compiled from: MqttConnectOptions.java */
/* renamed from: gw  reason: default package */
/* loaded from: classes.dex */
public class gw {
    public String e;
    public char[] f;
    public SocketFactory g;
    public int a = 60;
    public int b = 10;
    public String c = null;
    public jw d = null;
    public Properties h = null;
    public HostnameVerifier i = null;
    public boolean j = true;
    public int k = 30;
    public String[] l = null;
    public int m = 0;
    public boolean n = false;

    public char[] f() {
        return this.f;
    }

    public void u(char[] password) {
        this.f = password;
    }

    public String k() {
        return this.e;
    }

    public void w(String userName) {
        if (userName != null && userName.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        this.e = userName;
    }

    public int c() {
        return this.a;
    }

    public int e() {
        return this.m;
    }

    public int d() {
        return this.b;
    }

    public void s(int maxInflight) {
        if (maxInflight < 0) {
            throw new IllegalArgumentException();
        }
        this.b = maxInflight;
    }

    public int a() {
        return this.k;
    }

    public void r(int connectionTimeout) {
        if (connectionTimeout < 0) {
            throw new IllegalArgumentException();
        }
        this.k = connectionTimeout;
    }

    public SocketFactory j() {
        return this.g;
    }

    public void v(SocketFactory socketFactory) {
        this.g = socketFactory;
    }

    public String l() {
        return this.c;
    }

    public jw m() {
        return this.d;
    }

    public Properties h() {
        return this.h;
    }

    public HostnameVerifier g() {
        return this.i;
    }

    public boolean o() {
        return this.j;
    }

    public void q(boolean cleanSession) {
        this.j = cleanSession;
    }

    public String[] i() {
        return this.l;
    }

    public static int x(String srvURI) {
        try {
            URI vURI = new URI(srvURI);
            if ("ws".equals(vURI.getScheme())) {
                return 3;
            }
            if ("wss".equals(vURI.getScheme())) {
                return 4;
            }
            if (vURI.getPath() != null && !vURI.getPath().isEmpty()) {
                throw new IllegalArgumentException(srvURI);
            }
            if ("tcp".equals(vURI.getScheme())) {
                return 0;
            }
            if ("ssl".equals(vURI.getScheme())) {
                return 1;
            }
            if ("local".equals(vURI.getScheme())) {
                return 2;
            }
            throw new IllegalArgumentException(srvURI);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(srvURI);
        }
    }

    public void t(int MqttVersion) throws IllegalArgumentException {
        if (MqttVersion != 0 && MqttVersion != 3 && MqttVersion != 4) {
            throw new IllegalArgumentException();
        }
        this.m = MqttVersion;
    }

    public boolean n() {
        return this.n;
    }

    public void p(boolean automaticReconnect) {
        this.n = automaticReconnect;
    }

    public Properties b() {
        Properties p = new Properties();
        p.put("MqttVersion", new Integer(e()));
        p.put("CleanSession", Boolean.valueOf(o()));
        p.put("ConTimeout", new Integer(a()));
        p.put("KeepAliveInterval", new Integer(c()));
        p.put("UserName", k() == null ? "null" : k());
        p.put("WillDestination", l() == null ? "null" : l());
        if (j() == null) {
            p.put("SocketFactory", "null");
        } else {
            p.put("SocketFactory", j());
        }
        if (h() == null) {
            p.put("SSLProperties", "null");
        } else {
            p.put("SSLProperties", h());
        }
        return p;
    }

    public String toString() {
        return wy.a(b(), "Connection options");
    }
}
