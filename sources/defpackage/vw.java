package defpackage;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
/* compiled from: CommsTokenStore.java */
/* renamed from: vw  reason: default package */
/* loaded from: classes.dex */
public class vw {
    public static final String a;
    public static final qy b;
    public Hashtable c;
    public String d;
    public iw e = null;

    static {
        String name = vw.class.getName();
        a = name;
        b = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public vw(String logContext) {
        qy qyVar = b;
        qyVar.setResourceName(logContext);
        this.c = new Hashtable();
        this.d = logContext;
        qyVar.fine(a, "<Init>", "308");
    }

    public ow f(my message) {
        String key = message.o();
        return (ow) this.c.get(key);
    }

    public ow e(String key) {
        return (ow) this.c.get(key);
    }

    public ow j(my message) {
        if (message != null) {
            return i(message.o());
        }
        return null;
    }

    public ow i(String key) {
        b.fine(a, "removeToken", "306", new Object[]{key});
        if (key != null) {
            return (ow) this.c.remove(key);
        }
        return null;
    }

    public hw k(gy message) {
        hw token;
        synchronized (this.c) {
            String key = new Integer(message.p()).toString();
            if (this.c.containsKey(key)) {
                token = (hw) this.c.get(key);
                b.fine(a, "restoreToken", "302", new Object[]{key, message, token});
            } else {
                token = new hw(this.d);
                token.a.u(key);
                this.c.put(key, token);
                b.fine(a, "restoreToken", "303", new Object[]{key, message, token});
            }
        }
        return token;
    }

    public void m(ow token, my message) throws iw {
        synchronized (this.c) {
            iw iwVar = this.e;
            if (iwVar != null) {
                throw iwVar;
            }
            String key = message.o();
            b.fine(a, "saveToken", "300", new Object[]{key, message});
            l(token, key);
        }
    }

    public void l(ow token, String key) {
        synchronized (this.c) {
            b.fine(a, "saveToken", "307", new Object[]{key, token.toString()});
            token.a.u(key);
            this.c.put(key, token);
        }
    }

    public void h(iw quiesceResponse) {
        synchronized (this.c) {
            b.fine(a, "quiesce", "309", new Object[]{quiesceResponse});
            this.e = quiesceResponse;
        }
    }

    public void g() {
        synchronized (this.c) {
            b.fine(a, "open", "310");
            this.e = null;
        }
    }

    public hw[] c() {
        hw[] hwVarArr;
        synchronized (this.c) {
            b.fine(a, "getOutstandingDelTokens", "311");
            Vector list = new Vector();
            Enumeration enumeration = this.c.elements();
            while (enumeration.hasMoreElements()) {
                ow token = (ow) enumeration.nextElement();
                if (token != null && (token instanceof hw) && !token.a.n()) {
                    list.addElement(token);
                }
            }
            hw[] result = new hw[list.size()];
            hwVarArr = (hw[]) list.toArray(result);
        }
        return hwVarArr;
    }

    public Vector d() {
        Vector list;
        synchronized (this.c) {
            b.fine(a, "getOutstandingTokens", "312");
            list = new Vector();
            Enumeration enumeration = this.c.elements();
            while (enumeration.hasMoreElements()) {
                ow token = (ow) enumeration.nextElement();
                if (token != null) {
                    list.addElement(token);
                }
            }
        }
        return list;
    }

    public void a() {
        b.fine(a, "clear", "305", new Object[]{new Integer(this.c.size())});
        synchronized (this.c) {
            this.c.clear();
        }
    }

    public int b() {
        int size;
        synchronized (this.c) {
            size = this.c.size();
        }
        return size;
    }

    public String toString() {
        String stringBuffer;
        String lineSep = System.getProperty("line.separator", "\n");
        StringBuffer toks = new StringBuffer();
        synchronized (this.c) {
            Enumeration enumeration = this.c.elements();
            while (enumeration.hasMoreElements()) {
                ow token = (ow) enumeration.nextElement();
                toks.append("{" + token.a + "}" + lineSep);
            }
            stringBuffer = toks.toString();
        }
        return stringBuffer;
    }
}
