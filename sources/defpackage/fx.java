package defpackage;

import com.xiaopeng.base.log.LogUtils;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile;
import java.io.IOException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: SSLNetworkModule.java */
/* renamed from: fx  reason: default package */
/* loaded from: classes.dex */
public class fx extends gx {
    public static final String h;
    public static final qy i;
    public String[] j;
    public int k;
    public HostnameVerifier l;
    public String m;
    public int n;

    static {
        String name = fx.class.getName();
        h = name;
        i = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public fx(SSLSocketFactory factory, String host, int port, String resourceContext) {
        super(factory, host, port, resourceContext);
        this.m = host;
        this.n = port;
        i.setResourceName(resourceContext);
    }

    public void e(String[] enabledCiphers) {
        this.j = enabledCiphers;
        if (this.c != null && enabledCiphers != null) {
            if (i.isLoggable(5)) {
                String ciphers = "";
                for (int i2 = 0; i2 < enabledCiphers.length; i2++) {
                    if (i2 > 0) {
                        ciphers = String.valueOf(ciphers) + LogUtils.SEPARATOR;
                    }
                    ciphers = String.valueOf(ciphers) + enabledCiphers[i2];
                }
                i.fine(h, "setEnabledCiphers", "260", new Object[]{ciphers});
            }
            ((SSLSocket) this.c).setEnabledCipherSuites(enabledCiphers);
        }
    }

    public void g(int timeout) {
        super.d(timeout);
        this.k = timeout;
    }

    public void f(HostnameVerifier hostnameVerifier) {
        this.l = hostnameVerifier;
    }

    @Override // defpackage.gx, defpackage.dx
    public void start() throws IOException, iw {
        super.start();
        e(this.j);
        int soTimeout = this.c.getSoTimeout();
        this.c.setSoTimeout(this.k * 1000);
        ((SSLSocket) this.c).startHandshake();
        if (this.l != null) {
            SSLSession session = ((SSLSocket) this.c).getSession();
            this.l.verify(this.m, session);
        }
        this.c.setSoTimeout(soTimeout);
    }

    @Override // defpackage.gx, defpackage.dx
    public String a() {
        return AbstractChannelProfile.SSL_PREFIX + this.m + ":" + this.n;
    }
}
