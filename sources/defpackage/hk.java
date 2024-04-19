package defpackage;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* compiled from: UtSslSocketFactory.java */
@TargetApi(14)
/* renamed from: hk  reason: default package */
/* loaded from: classes.dex */
public class hk extends SSLSocketFactory {
    public Method a = null;
    public String b;

    public hk(String str) {
        this.b = str;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int port) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    @TargetApi(17)
    public Socket createSocket(Socket plainSocket, String host, int port, boolean autoClose) throws IOException {
        if (this.b == null) {
            this.b = host;
        }
        vj.c("", "host", this.b, "port", Integer.valueOf(port), "autoClose", Boolean.valueOf(autoClose));
        InetAddress inetAddress = plainSocket.getInetAddress();
        if (autoClose) {
            plainSocket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init((KeyStore) null);
            sSLCertificateSocketFactory.setTrustManagers(new TrustManager[]{new a(trustManagerFactory.getTrustManagers()[0])});
        } catch (Exception e) {
            vj.c("", e);
        }
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, port);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.b);
        } else {
            try {
                if (this.a == null) {
                    Method method = sSLSocket.getClass().getMethod("setHostname", String.class);
                    this.a = method;
                    method.setAccessible(true);
                }
                this.a.invoke(sSLSocket, this.b);
            } catch (Exception e2) {
                vj.c("", "SNI not useable", null, e2);
            }
        }
        vj.c("", "SSLSession PeerHost", sSLSocket.getSession().getPeerHost());
        return sSLSocket;
    }

    /* compiled from: UtSslSocketFactory.java */
    /* renamed from: hk$a */
    /* loaded from: classes.dex */
    public static class a implements X509TrustManager {
        public TrustManager a;

        public a(TrustManager trustManager) {
            this.a = trustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
        @Override // javax.net.ssl.X509TrustManager
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void checkServerTrusted(java.security.cert.X509Certificate[] r4, java.lang.String r5) throws java.security.cert.CertificateException {
            /*
                r3 = this;
                javax.net.ssl.TrustManager r0 = r3.a     // Catch: java.security.cert.CertificateException -> L9
                javax.net.ssl.X509TrustManager r0 = (javax.net.ssl.X509TrustManager) r0     // Catch: java.security.cert.CertificateException -> L9
                r0.checkServerTrusted(r4, r5)     // Catch: java.security.cert.CertificateException -> L9
                return
            L9:
                r0 = move-exception
                r1 = r0
            Lc:
                java.lang.Throwable r2 = r1.getCause()
                if (r2 == 0) goto L2d
                java.lang.Throwable r1 = r1.getCause()
                boolean r2 = r1 instanceof java.security.cert.CertificateExpiredException
                if (r2 != 0) goto L21
                boolean r2 = r1 instanceof java.security.cert.CertificateNotYetValidException
                if (r2 == 0) goto L1f
                goto L21
            L1f:
                goto Lc
            L21:
                r0 = 1
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r2 = 0
                r0[r2] = r1
                java.lang.String r1 = ""
                defpackage.vj.c(r1, r0)
                return
            L2d:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.hk.a.checkServerTrusted(java.security.cert.X509Certificate[], java.lang.String):void");
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}
