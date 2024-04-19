package defpackage;

import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: SSLSocketFactoryFactory.java */
/* renamed from: ix  reason: default package */
/* loaded from: classes.dex */
public class ix {
    public static final String[] a = {"com.ibm.ssl.protocol", "com.ibm.ssl.contextProvider", "com.ibm.ssl.keyStore", "com.ibm.ssl.keyStorePassword", "com.ibm.ssl.keyStoreType", "com.ibm.ssl.keyStoreProvider", "com.ibm.ssl.keyManager", "com.ibm.ssl.trustStore", "com.ibm.ssl.trustStorePassword", "com.ibm.ssl.trustStoreType", "com.ibm.ssl.trustStoreProvider", "com.ibm.ssl.trustManager", "com.ibm.ssl.enabledCipherSuites", "com.ibm.ssl.clientAuthentication"};
    public static final byte[] b = {-99, -89, -39, Byte.MIN_VALUE, 5, -72, -119, -100};
    public Properties d;
    public qy e = null;
    public Hashtable c = new Hashtable();

    public final boolean u(String key) {
        String[] strArr;
        int i = 0;
        while (true) {
            strArr = a;
            if (i < strArr.length && !strArr[i].equals(key)) {
                i++;
            }
        }
        return i < strArr.length;
    }

    public final void a(Properties properties) throws IllegalArgumentException {
        Set<String> keys = properties.keySet();
        for (String k : keys) {
            if (!u(k)) {
                throw new IllegalArgumentException(String.valueOf(k) + " is not a valid IBM SSL property key.");
            }
        }
    }

    public static char[] x(byte[] b2) {
        if (b2 == null) {
            return null;
        }
        char[] c = new char[b2.length / 2];
        int i = 0;
        int j = 0;
        while (i < b2.length) {
            int i2 = i + 1;
            c[j] = (char) ((b2[i] & 255) + ((b2[i2] & 255) << 8));
            j++;
            i = i2 + 1;
        }
        return c;
    }

    public static byte[] w(char[] c) {
        if (c == null) {
            return null;
        }
        byte[] b2 = new byte[c.length * 2];
        int i = 0;
        for (int j = 0; j < c.length; j++) {
            int i2 = i + 1;
            b2[i] = (byte) (c[j] & 255);
            i = i2 + 1;
            b2[i2] = (byte) ((c[j] >> '\b') & 255);
        }
        return b2;
    }

    public static String v(char[] password) {
        if (password == null) {
            return null;
        }
        byte[] bytes = w(password);
        for (int i = 0; i < bytes.length; i++) {
            byte b2 = bytes[i];
            byte[] bArr = b;
            bytes[i] = (byte) ((b2 ^ bArr[i % bArr.length]) & 255);
        }
        String encryptedValue = "{xor}" + new String(jx.b(bytes));
        return encryptedValue;
    }

    public static char[] d(String ePassword) {
        if (ePassword == null) {
            return null;
        }
        try {
            byte[] bytes = jx.a(ePassword.substring("{xor}".length()));
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                byte[] bArr = b;
                bytes[i] = (byte) ((b2 ^ bArr[i % bArr.length]) & 255);
            }
            return x(bytes);
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] y(String ciphers) {
        if (ciphers == null) {
            return null;
        }
        Vector c = new Vector();
        int i = ciphers.indexOf(44);
        int j = 0;
        while (i > -1) {
            c.add(ciphers.substring(j, i));
            j = i + 1;
            i = ciphers.indexOf(44, j);
        }
        c.add(ciphers.substring(j));
        String[] s = new String[c.size()];
        c.toArray(s);
        return s;
    }

    public final void b(Properties p) {
        String pw = p.getProperty("com.ibm.ssl.keyStorePassword");
        if (pw != null && !pw.startsWith("{xor}")) {
            String epw = v(pw.toCharArray());
            p.put("com.ibm.ssl.keyStorePassword", epw);
        }
        String pw2 = p.getProperty("com.ibm.ssl.trustStorePassword");
        if (pw2 != null && !pw2.startsWith("{xor}")) {
            String epw2 = v(pw2.toCharArray());
            p.put("com.ibm.ssl.trustStorePassword", epw2);
        }
    }

    public void t(Properties props, String configID) throws IllegalArgumentException {
        a(props);
        Properties p = new Properties();
        p.putAll(props);
        b(p);
        if (configID != null) {
            this.c.put(configID, p);
        } else {
            this.d = p;
        }
    }

    public final String k(String configID, String ibmKey, String sysProperty) {
        String res = l(configID, ibmKey);
        if (res != null) {
            return res;
        }
        if (sysProperty != null) {
            return System.getProperty(sysProperty);
        }
        return res;
    }

    public final String l(String configID, String ibmKey) {
        String res = null;
        Properties p = null;
        if (configID != null) {
            p = (Properties) this.c.get(configID);
        }
        if (p != null && (res = p.getProperty(ibmKey)) != null) {
            return res;
        }
        Properties p2 = this.d;
        if (p2 != null && (res = p2.getProperty(ibmKey)) != null) {
            return res;
        }
        return res;
    }

    public String n(String configID) {
        return k(configID, "com.ibm.ssl.protocol", null);
    }

    public String f(String configID) {
        return k(configID, "com.ibm.ssl.contextProvider", null);
    }

    public char[] h(String configID) {
        String pw = k(configID, "com.ibm.ssl.keyStorePassword", "javax.net.ssl.keyStorePassword");
        if (pw == null) {
            return null;
        }
        if (pw.startsWith("{xor}")) {
            char[] r = d(pw);
            return r;
        }
        char[] r2 = pw.toCharArray();
        return r2;
    }

    public String j(String configID) {
        return k(configID, "com.ibm.ssl.keyStoreType", "javax.net.ssl.keyStoreType");
    }

    public String i(String configID) {
        return k(configID, "com.ibm.ssl.keyStoreProvider", null);
    }

    public String g(String configID) {
        return k(configID, "com.ibm.ssl.keyManager", "ssl.KeyManagerFactory.algorithm");
    }

    public String p(String configID) {
        return k(configID, "com.ibm.ssl.trustStore", "javax.net.ssl.trustStore");
    }

    public char[] q(String configID) {
        String pw = k(configID, "com.ibm.ssl.trustStorePassword", "javax.net.ssl.trustStorePassword");
        if (pw == null) {
            return null;
        }
        if (pw.startsWith("{xor}")) {
            char[] r = d(pw);
            return r;
        }
        char[] r2 = pw.toCharArray();
        return r2;
    }

    public String s(String configID) {
        return k(configID, "com.ibm.ssl.trustStoreType", null);
    }

    public String r(String configID) {
        return k(configID, "com.ibm.ssl.trustStoreProvider", null);
    }

    public String o(String configID) {
        return k(configID, "com.ibm.ssl.trustManager", "ssl.TrustManagerFactory.algorithm");
    }

    public String[] e(String configID) {
        String ciphers = k(configID, "com.ibm.ssl.enabledCipherSuites", null);
        String[] res = y(ciphers);
        return res;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:259:0x03e3
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final javax.net.ssl.SSLContext m(java.lang.String r32) throws defpackage.nw {
        /*
            Method dump skipped, instructions count: 1331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ix.m(java.lang.String):javax.net.ssl.SSLContext");
    }

    public SSLSocketFactory c(String configID) throws nw {
        SSLContext ctx = m(configID);
        qy qyVar = this.e;
        if (qyVar != null) {
            Object[] objArr = new Object[2];
            objArr[0] = configID != null ? configID : "null (broker defaults)";
            objArr[1] = e(configID) != null ? k(configID, "com.ibm.ssl.enabledCipherSuites", null) : "null (using platform-enabled cipher suites)";
            qyVar.fine("org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory", "createSocketFactory", "12020", objArr);
        }
        return ctx.getSocketFactory();
    }
}
