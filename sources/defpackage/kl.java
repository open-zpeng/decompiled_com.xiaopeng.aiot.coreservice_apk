package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* compiled from: HttpsUtils.java */
/* renamed from: kl  reason: default package */
/* loaded from: classes.dex */
public class kl {
    public static X509TrustManager a = new a();
    public static HostnameVerifier b = new b();

    /* compiled from: HttpsUtils.java */
    /* renamed from: kl$c */
    /* loaded from: classes.dex */
    public static class c {
        public SSLSocketFactory a;
        public X509TrustManager b;
    }

    public static c b() {
        return c(null, null, null, new InputStream[0]);
    }

    public static c c(X509TrustManager trustManager, InputStream bksFile, String password, InputStream... certificates) {
        X509TrustManager manager;
        c sslParams = new c();
        try {
            KeyManager[] keyManagers = d(bksFile, password);
            TrustManager[] trustManagers = e(certificates);
            if (trustManager != null) {
                manager = trustManager;
            } else if (trustManagers != null) {
                manager = a(trustManagers);
            } else {
                manager = a;
            }
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagers, new TrustManager[]{manager}, null);
            sslParams.a = sslContext.getSocketFactory();
            sslParams.b = manager;
            return sslParams;
        } catch (KeyManagementException e) {
            throw new AssertionError(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static KeyManager[] d(InputStream bksFile, String password) {
        if (bksFile == null || password == null) {
            return null;
        }
        try {
            KeyStore clientKeyStore = KeyStore.getInstance("BKS");
            clientKeyStore.load(bksFile, password.toCharArray());
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(clientKeyStore, password.toCharArray());
            return kmf.getKeyManagers();
        } catch (Exception e) {
            wl.a(e);
            return null;
        }
    }

    public static TrustManager[] e(InputStream... certificates) {
        if (certificates == null || certificates.length <= 0) {
            return null;
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            int length = certificates.length;
            int i = 0;
            while (i < length) {
                InputStream certStream = certificates[i];
                int index2 = index + 1;
                String certificateAlias = Integer.toString(index);
                Certificate cert = certificateFactory.generateCertificate(certStream);
                keyStore.setCertificateEntry(certificateAlias, cert);
                if (certStream != null) {
                    try {
                        certStream.close();
                    } catch (IOException e) {
                        wl.a(e);
                    }
                }
                i++;
                index = index2;
            }
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);
            return tmf.getTrustManagers();
        } catch (Exception e2) {
            wl.a(e2);
            return null;
        }
    }

    public static X509TrustManager a(TrustManager[] trustManagers) {
        for (TrustManager trustManager : trustManagers) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    /* compiled from: HttpsUtils.java */
    /* renamed from: kl$a */
    /* loaded from: classes.dex */
    public static class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* compiled from: HttpsUtils.java */
    /* renamed from: kl$b */
    /* loaded from: classes.dex */
    public static class b implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}
