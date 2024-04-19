package defpackage;

import java.io.EOFException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import okhttp3.internal.http2.Settings;
/* compiled from: ClientState.java */
/* renamed from: rw  reason: default package */
/* loaded from: classes.dex */
public class rw {
    public static final String a;
    public static final qy b;
    public Hashtable A;
    public Hashtable B;
    public Hashtable C;
    public mw D;
    public Hashtable d;
    public volatile Vector e;
    public volatile Vector f;
    public vw g;
    public qw h;
    public sw i;
    public long j;
    public boolean k;
    public fw l;
    public int n;
    public int o;
    public my v;
    public Hashtable z;
    public int c = 0;
    public int m = 0;
    public Object p = new Object();
    public Object q = new Object();
    public boolean r = false;
    public long s = 0;
    public long t = 0;
    public long u = 0;
    public Object w = new Object();
    public int x = 0;
    public boolean y = false;

    static {
        String name = rw.class.getName();
        a = name;
        b = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public rw(fw persistence, vw tokenStore, sw callback, qw clientComms, mw pingSender) throws iw {
        this.h = null;
        this.i = null;
        this.n = 0;
        this.o = 0;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        qy qyVar = b;
        qyVar.setResourceName(clientComms.t().b());
        qyVar.finer(a, "<Init>", "");
        this.d = new Hashtable();
        this.f = new Vector();
        this.z = new Hashtable();
        this.A = new Hashtable();
        this.B = new Hashtable();
        this.C = new Hashtable();
        this.v = new ay();
        this.o = 0;
        this.n = 0;
        this.l = persistence;
        this.i = callback;
        this.g = tokenStore;
        this.h = clientComms;
        this.D = pingSender;
        I();
    }

    public void M(int maxInflight) {
        this.m = maxInflight;
        this.e = new Vector(this.m);
    }

    public void L(long keepAliveSecs) {
        this.j = 1000 * keepAliveSecs;
    }

    public long l() {
        return this.j;
    }

    public void K(boolean cleanSession) {
        this.k = cleanSession;
    }

    public boolean k() {
        return this.k;
    }

    public final String r(my message) {
        return "s-" + message.p();
    }

    public final String q(my message) {
        return "sc-" + message.p();
    }

    public final String o(my message) {
        return "r-" + message.p();
    }

    public final String p(my message) {
        return "sb-" + message.p();
    }

    public void c() throws iw {
        b.fine(a, "clearState", ">");
        this.l.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.z.clear();
        this.A.clear();
        this.B.clear();
        this.C.clear();
        this.g.a();
    }

    public final my H(String key, kw persistable) throws iw {
        my message = null;
        try {
            message = my.h(persistable);
        } catch (iw ex) {
            b.fine(a, "restoreMessage", "602", new Object[]{key}, ex);
            if (ex.getCause() instanceof EOFException) {
                if (key != null) {
                    this.l.remove(key);
                }
            } else {
                throw ex;
            }
        }
        b.fine(a, "restoreMessage", "601", new Object[]{key, message});
        return message;
    }

    public final void s(Vector list, my newMsg) {
        int newMsgId = newMsg.p();
        for (int i = 0; i < list.size(); i++) {
            my otherMsg = (my) list.elementAt(i);
            int otherMsgId = otherMsg.p();
            if (otherMsgId > newMsgId) {
                list.insertElementAt(newMsg, i);
                return;
            }
        }
        list.addElement(newMsg);
    }

    public final Vector D(Vector list) {
        int largestGapMsgIdPosInList;
        Vector newList = new Vector();
        if (list.size() == 0) {
            return newList;
        }
        int previousMsgId = 0;
        int largestGap = 0;
        int largestGapMsgIdPosInList2 = 0;
        for (int i = 0; i < list.size(); i++) {
            int currentMsgId = ((my) list.elementAt(i)).p();
            if (currentMsgId - previousMsgId > largestGap) {
                largestGap = currentMsgId - previousMsgId;
                largestGapMsgIdPosInList2 = i;
            }
            previousMsgId = currentMsgId;
        }
        int lowestMsgId = ((my) list.elementAt(0)).p();
        int highestMsgId = previousMsgId;
        if ((Settings.DEFAULT_INITIAL_WINDOW_SIZE - highestMsgId) + lowestMsgId <= largestGap) {
            largestGapMsgIdPosInList = largestGapMsgIdPosInList2;
        } else {
            largestGapMsgIdPosInList = 0;
        }
        for (int i2 = largestGapMsgIdPosInList; i2 < list.size(); i2++) {
            newList.addElement(list.elementAt(i2));
        }
        for (int i3 = 0; i3 < largestGapMsgIdPosInList; i3++) {
            newList.addElement(list.elementAt(i3));
        }
        return newList;
    }

    public void I() throws iw {
        Enumeration messageKeys = this.l.keys();
        int highestMsgId = this.c;
        Vector orphanedPubRels = new Vector();
        b.fine(a, "restoreState", "600");
        while (messageKeys.hasMoreElements()) {
            String key = (String) messageKeys.nextElement();
            kw persistable = this.l.get(key);
            my message = H(key, persistable);
            if (message != null) {
                if (key.startsWith("r-")) {
                    b.fine(a, "restoreState", "604", new Object[]{key, message});
                    this.C.put(new Integer(message.p()), message);
                } else if (key.startsWith("s-")) {
                    gy sendMessage = (gy) message;
                    highestMsgId = Math.max(sendMessage.p(), highestMsgId);
                    if (this.l.containsKey(q(sendMessage))) {
                        kw persistedConfirm = this.l.get(q(sendMessage));
                        fy confirmMessage = (fy) H(key, persistedConfirm);
                        if (confirmMessage != null) {
                            b.fine(a, "restoreState", "605", new Object[]{key, message});
                            this.z.put(new Integer(confirmMessage.p()), confirmMessage);
                        } else {
                            b.fine(a, "restoreState", "606", new Object[]{key, message});
                        }
                    } else {
                        sendMessage.w(true);
                        if (sendMessage.z().c() == 2) {
                            b.fine(a, "restoreState", "607", new Object[]{key, message});
                            this.z.put(new Integer(sendMessage.p()), sendMessage);
                        } else {
                            b.fine(a, "restoreState", "608", new Object[]{key, message});
                            this.A.put(new Integer(sendMessage.p()), sendMessage);
                        }
                    }
                    hw tok = this.g.k(sendMessage);
                    tok.a.s(this.h.t());
                    this.d.put(new Integer(sendMessage.p()), new Integer(sendMessage.p()));
                } else if (key.startsWith("sb-")) {
                    gy sendMessage2 = (gy) message;
                    highestMsgId = Math.max(sendMessage2.p(), highestMsgId);
                    if (sendMessage2.z().c() == 2) {
                        b.fine(a, "restoreState", "607", new Object[]{key, message});
                        this.z.put(new Integer(sendMessage2.p()), sendMessage2);
                    } else if (sendMessage2.z().c() == 1) {
                        b.fine(a, "restoreState", "608", new Object[]{key, message});
                        this.A.put(new Integer(sendMessage2.p()), sendMessage2);
                    } else {
                        b.fine(a, "restoreState", "511", new Object[]{key, message});
                        this.B.put(new Integer(sendMessage2.p()), sendMessage2);
                        this.l.remove(key);
                    }
                    hw tok2 = this.g.k(sendMessage2);
                    tok2.a.s(this.h.t());
                    this.d.put(new Integer(sendMessage2.p()), new Integer(sendMessage2.p()));
                } else if (key.startsWith("sc-")) {
                    fy pubRelMessage = (fy) message;
                    if (!this.l.containsKey(r(pubRelMessage))) {
                        orphanedPubRels.addElement(key);
                    }
                }
            }
        }
        Enumeration messageKeys2 = orphanedPubRels.elements();
        while (messageKeys2.hasMoreElements()) {
            String key2 = (String) messageKeys2.nextElement();
            b.fine(a, "restoreState", "609", new Object[]{key2});
            this.l.remove(key2);
        }
        this.c = highestMsgId;
    }

    public final void G() {
        this.e = new Vector(this.m);
        this.f = new Vector();
        Enumeration keys = this.z.keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            my msg = (my) this.z.get(key);
            if (msg instanceof gy) {
                b.fine(a, "restoreInflightMessages", "610", new Object[]{key});
                msg.w(true);
                s(this.e, (gy) msg);
            } else if (msg instanceof fy) {
                b.fine(a, "restoreInflightMessages", "611", new Object[]{key});
                s(this.f, (fy) msg);
            }
        }
        Enumeration keys2 = this.A.keys();
        while (keys2.hasMoreElements()) {
            Object key2 = keys2.nextElement();
            gy msg2 = (gy) this.A.get(key2);
            msg2.w(true);
            b.fine(a, "restoreInflightMessages", "612", new Object[]{key2});
            s(this.e, msg2);
        }
        Enumeration keys3 = this.B.keys();
        while (keys3.hasMoreElements()) {
            Object key3 = keys3.nextElement();
            b.fine(a, "restoreInflightMessages", "512", new Object[]{key3});
            s(this.e, (gy) this.B.get(key3));
        }
        this.f = D(this.f);
        this.e = D(this.e);
    }

    public void J(my message, ow token) throws iw {
        if (message.u() && message.p() == 0) {
            if ((message instanceof gy) && ((gy) message).z().c() != 0) {
                message.x(n());
            } else if ((message instanceof cy) || (message instanceof ey) || (message instanceof fy) || (message instanceof dy) || (message instanceof jy) || (message instanceof iy) || (message instanceof ly) || (message instanceof ky)) {
                message.x(n());
            }
        }
        if (token != null) {
            try {
                token.a.w(message.p());
            } catch (Exception e) {
            }
        }
        if (message instanceof gy) {
            synchronized (this.p) {
                if (this.n >= this.m) {
                    b.fine(a, "send", "613", new Object[]{new Integer(this.n)});
                    throw new iw(32202);
                }
                jw innerMessage = ((gy) message).z();
                b.fine(a, "send", "628", new Object[]{new Integer(message.p()), new Integer(innerMessage.c()), message});
                switch (innerMessage.c()) {
                    case 1:
                        this.A.put(new Integer(message.p()), message);
                        this.l.put(r(message), (gy) message);
                        break;
                    case 2:
                        this.z.put(new Integer(message.p()), message);
                        this.l.put(r(message), (gy) message);
                        break;
                }
                this.g.m(token, message);
                this.e.addElement(message);
                this.p.notifyAll();
            }
            return;
        }
        b.fine(a, "send", "615", new Object[]{new Integer(message.p()), message});
        if (message instanceof vx) {
            synchronized (this.p) {
                this.g.m(token, message);
                this.f.insertElementAt(message, 0);
                this.p.notifyAll();
            }
            return;
        }
        if (message instanceof ay) {
            this.v = message;
        } else if (message instanceof fy) {
            this.z.put(new Integer(message.p()), message);
            this.l.put(q(message), (fy) message);
        } else if (message instanceof dy) {
            this.l.remove(o(message));
        }
        synchronized (this.p) {
            if (!(message instanceof tx)) {
                this.g.m(token, message);
            }
            this.f.addElement(message);
            this.p.notifyAll();
        }
    }

    public void B(my message) {
        String key = p(message);
        try {
            message.x(n());
            key = p(message);
            try {
                this.l.put(key, (gy) message);
            } catch (lw e) {
                b.fine(a, "persistBufferedMessage", "515");
                this.l.open(this.h.t().b(), this.h.t().a());
                this.l.put(key, (gy) message);
            }
            b.fine(a, "persistBufferedMessage", "513", new Object[]{key});
        } catch (iw e2) {
            b.warning(a, "persistBufferedMessage", "513", new Object[]{key});
        }
    }

    public void N(my message) {
        try {
            b.fine(a, "unPersistBufferedMessage", "517", new Object[]{message.o()});
            this.l.remove(p(message));
        } catch (lw e) {
            b.fine(a, "unPersistBufferedMessage", "518", new Object[]{message.o()});
        }
    }

    public void O(gy message) throws lw {
        synchronized (this.p) {
            b.fine(a, "undo", "618", new Object[]{new Integer(message.p()), new Integer(message.z().c())});
            if (message.z().c() == 1) {
                this.A.remove(new Integer(message.p()));
            } else {
                this.z.remove(new Integer(message.p()));
            }
            this.e.removeElement(message);
            this.l.remove(r(message));
            this.g.j(message);
            if (message.z().c() > 0) {
                E(message.p());
                message.x(0);
            }
            b();
        }
    }

    public ow a(xv pingCallback) throws iw {
        Object obj;
        long time;
        long nextPingTime;
        qy qyVar = b;
        String str = a;
        qyVar.fine(str, "checkForActivity", "616", new Object[0]);
        synchronized (this.q) {
            if (this.r) {
                return null;
            }
            ow token = null;
            l();
            if (this.y && this.j > 0) {
                long time2 = System.currentTimeMillis();
                Object obj2 = this.w;
                synchronized (obj2) {
                    try {
                        try {
                            int i = this.x;
                            if (i > 0) {
                                try {
                                    try {
                                        obj = obj2;
                                        if (time2 - this.t >= this.j + 100) {
                                            try {
                                                Object[] objArr = new Object[5];
                                                objArr[0] = new Long(this.j);
                                                objArr[1] = new Long(this.s);
                                                objArr[2] = new Long(this.t);
                                                time2 = time2;
                                                try {
                                                    objArr[3] = new Long(time2);
                                                    objArr[4] = new Long(this.u);
                                                    qyVar.severe(str, "checkForActivity", "619", objArr);
                                                    throw yw.a(32000);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                throw th;
                                            }
                                        }
                                        time2 = time2;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        obj = obj2;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj = obj2;
                                }
                            } else {
                                obj = obj2;
                            }
                            if (i == 0) {
                                try {
                                    long time3 = time2;
                                    try {
                                        if (time2 - this.s >= this.j * 2) {
                                            Object[] objArr2 = new Object[5];
                                            objArr2[0] = new Long(this.j);
                                            objArr2[1] = new Long(this.s);
                                            objArr2[2] = new Long(this.t);
                                            try {
                                                objArr2[3] = new Long(time3);
                                                objArr2[4] = new Long(this.u);
                                                qyVar.severe(str, "checkForActivity", "642", objArr2);
                                                throw yw.a(32002);
                                            } catch (Throwable th5) {
                                                th = th5;
                                                throw th;
                                            }
                                        }
                                        time = time3;
                                    } catch (Throwable th6) {
                                        th = th6;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                }
                            } else {
                                time = time2;
                            }
                            if ((i != 0 || time - this.t < this.j - 100) && time - this.s < this.j - 100) {
                                qyVar.fine(str, "checkForActivity", "634", null);
                                nextPingTime = Math.max(1L, l() - (time - this.s));
                            } else {
                                qyVar.fine(str, "checkForActivity", "620", new Object[]{new Long(this.j), new Long(this.s), new Long(this.t)});
                                token = new ow(this.h.t().b());
                                if (pingCallback != null) {
                                    token.i(pingCallback);
                                }
                                this.g.m(token, this.v);
                                this.f.insertElementAt(this.v, 0);
                                nextPingTime = l();
                                try {
                                    u();
                                } catch (Throwable th8) {
                                    th = th8;
                                    throw th;
                                }
                            }
                            qyVar.fine(str, "checkForActivity", "624", new Object[]{new Long(nextPingTime)});
                            this.D.a(nextPingTime);
                        } catch (Throwable th9) {
                            th = th9;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        obj = obj2;
                    }
                }
            }
            return token;
        }
    }

    public my i() throws iw {
        my result = null;
        synchronized (this.p) {
            while (result == null) {
                if ((this.e.isEmpty() && this.f.isEmpty()) || (this.f.isEmpty() && this.n >= this.m)) {
                    try {
                        qy qyVar = b;
                        String str = a;
                        qyVar.fine(str, "get", "644");
                        this.p.wait();
                        qyVar.fine(str, "get", "647");
                    } catch (InterruptedException e) {
                    }
                }
                if (!this.y && (this.f.isEmpty() || !(((my) this.f.elementAt(0)) instanceof vx))) {
                    b.fine(a, "get", "621");
                    return null;
                } else if (!this.f.isEmpty()) {
                    result = (my) this.f.remove(0);
                    if (result instanceof fy) {
                        this.o++;
                        b.fine(a, "get", "617", new Object[]{new Integer(this.o)});
                    }
                    b();
                } else if (!this.e.isEmpty()) {
                    if (this.n < this.m) {
                        result = (my) this.e.elementAt(0);
                        this.e.removeElementAt(0);
                        this.n++;
                        b.fine(a, "get", "623", new Object[]{new Integer(this.n)});
                    } else {
                        b.fine(a, "get", "622");
                    }
                }
            }
            return result;
        }
    }

    public void A(int sentBytesCount) {
        if (sentBytesCount > 0) {
            this.s = System.currentTimeMillis();
        }
        b.fine(a, "notifySentBytes", "643", new Object[]{new Integer(sentBytesCount)});
    }

    public void z(my message) {
        this.s = System.currentTimeMillis();
        qy qyVar = b;
        String str = a;
        qyVar.fine(str, "notifySent", "625", new Object[]{message.o()});
        ow token = this.g.f(message);
        token.a.q();
        if (message instanceof ay) {
            synchronized (this.w) {
                long time = System.currentTimeMillis();
                synchronized (this.w) {
                    this.u = time;
                    this.x++;
                }
                qyVar.fine(str, "notifySent", "635", new Object[]{new Integer(this.x)});
            }
        } else if ((message instanceof gy) && ((gy) message).z().c() == 0) {
            token.a.o(null, null);
            this.i.a(token);
            f();
            E(message.p());
            this.g.j(message);
            b();
        }
    }

    public final void f() {
        synchronized (this.p) {
            this.n--;
            b.fine(a, "decrementInFlight", "646", new Object[]{new Integer(this.n)});
            if (!b()) {
                this.p.notifyAll();
            }
        }
    }

    public boolean b() {
        int tokC = this.g.b();
        if (this.r && tokC == 0 && this.f.size() == 0 && this.i.h()) {
            b.fine(a, "checkQuiesceLock", "626", new Object[]{new Boolean(this.r), new Integer(this.n), new Integer(this.f.size()), new Integer(this.o), Boolean.valueOf(this.i.h()), new Integer(tokC)});
            synchronized (this.q) {
                this.q.notifyAll();
            }
            return true;
        }
        return false;
    }

    public void w(int receivedBytesCount) {
        if (receivedBytesCount > 0) {
            this.t = System.currentTimeMillis();
        }
        b.fine(a, "notifyReceivedBytes", "630", new Object[]{new Integer(receivedBytesCount)});
    }

    public void v(tx ack) throws iw {
        this.t = System.currentTimeMillis();
        qy qyVar = b;
        String str = a;
        qyVar.fine(str, "notifyReceivedAck", "627", new Object[]{new Integer(ack.p()), ack});
        ow token = this.g.f(ack);
        if (token == null) {
            qyVar.fine(str, "notifyReceivedAck", "662", new Object[]{new Integer(ack.p())});
        } else if (ack instanceof ey) {
            fy rel = new fy((ey) ack);
            J(rel, token);
        } else if ((ack instanceof cy) || (ack instanceof dy)) {
            y(ack, token, null);
        } else if (ack instanceof by) {
            synchronized (this.w) {
                this.x = Math.max(0, this.x - 1);
                y(ack, token, null);
                if (this.x == 0) {
                    this.g.j(ack);
                }
            }
            qyVar.fine(str, "notifyReceivedAck", "636", new Object[]{new Integer(this.x)});
        } else if (ack instanceof ux) {
            int rc = ((ux) ack).y();
            if (rc == 0) {
                synchronized (this.p) {
                    if (this.k) {
                        c();
                        this.g.m(token, ack);
                    }
                    this.o = 0;
                    this.n = 0;
                    G();
                    e();
                }
                this.h.p((ux) ack, null);
                y(ack, token, null);
                this.g.j(ack);
                synchronized (this.p) {
                    this.p.notifyAll();
                }
            } else {
                iw mex = yw.a(rc);
                throw mex;
            }
        } else {
            y(ack, token, null);
            E(ack.p());
            this.g.j(ack);
        }
        b();
    }

    public void x(my message) throws iw {
        this.t = System.currentTimeMillis();
        b.fine(a, "notifyReceivedMsg", "651", new Object[]{new Integer(message.p()), message});
        if (!this.r) {
            if (message instanceof gy) {
                gy send = (gy) message;
                switch (send.z().c()) {
                    case 0:
                    case 1:
                        sw swVar = this.i;
                        if (swVar != null) {
                            swVar.i(send);
                            return;
                        }
                        return;
                    case 2:
                        this.l.put(o(message), (gy) message);
                        this.C.put(new Integer(send.p()), send);
                        J(new ey(send), null);
                        return;
                    default:
                        return;
                }
            } else if (message instanceof fy) {
                gy sendMsg = (gy) this.C.get(new Integer(message.p()));
                if (sendMsg != null) {
                    sw swVar2 = this.i;
                    if (swVar2 != null) {
                        swVar2.i(sendMsg);
                        return;
                    }
                    return;
                }
                dy pubComp = new dy(message.p());
                J(pubComp, null);
            }
        }
    }

    public void t(ow token) throws iw {
        my message = token.a.k();
        if (message != null && (message instanceof tx)) {
            qy qyVar = b;
            String str = a;
            qyVar.fine(str, "notifyComplete", "629", new Object[]{new Integer(message.p()), token, message});
            tx ack = (tx) message;
            if (ack instanceof cy) {
                this.l.remove(r(message));
                this.l.remove(p(message));
                this.A.remove(new Integer(ack.p()));
                f();
                E(message.p());
                this.g.j(message);
                qyVar.fine(str, "notifyComplete", "650", new Object[]{new Integer(ack.p())});
            } else if (ack instanceof dy) {
                this.l.remove(r(message));
                this.l.remove(q(message));
                this.l.remove(p(message));
                this.z.remove(new Integer(ack.p()));
                this.o--;
                f();
                E(message.p());
                this.g.j(message);
                qyVar.fine(str, "notifyComplete", "645", new Object[]{new Integer(ack.p()), new Integer(this.o)});
            }
            b();
        }
    }

    public void y(my ack, ow token, iw ex) {
        token.a.o(ack, ex);
        token.a.p();
        if (ack != null && (ack instanceof tx) && !(ack instanceof ey)) {
            b.fine(a, "notifyResult", "648", new Object[]{token.a.e(), ack, ex});
            this.i.a(token);
        }
        if (ack == null) {
            b.fine(a, "notifyResult", "649", new Object[]{token.a.e(), ex});
            this.i.a(token);
        }
    }

    public void e() {
        b.fine(a, "connected", "631");
        this.y = true;
        this.D.start();
    }

    public Vector F(iw reason) {
        b.fine(a, "resolveOldTokens", "632", new Object[]{reason});
        iw shutReason = reason;
        if (reason == null) {
            shutReason = new iw(32102);
        }
        Vector outT = this.g.d();
        Enumeration outTE = outT.elements();
        while (outTE.hasMoreElements()) {
            ow tok = (ow) outTE.nextElement();
            synchronized (tok) {
                if (!tok.h() && !tok.a.m() && tok.g() == null) {
                    tok.a.t(shutReason);
                }
            }
            if (!(tok instanceof hw)) {
                this.g.i(tok.a.e());
            }
        }
        return outT;
    }

    public void h(iw reason) {
        b.fine(a, "disconnected", "633", new Object[]{reason});
        this.y = false;
        try {
            if (this.k) {
                c();
            }
            this.e.clear();
            this.f.clear();
            synchronized (this.w) {
                this.x = 0;
            }
        } catch (iw e) {
        }
    }

    public final synchronized void E(int msgId) {
        this.d.remove(new Integer(msgId));
    }

    public final synchronized int n() throws iw {
        int startingMessageId = this.c;
        int loopCount = 0;
        do {
            int i = this.c + 1;
            this.c = i;
            if (i > 65535) {
                this.c = 1;
            }
            if (this.c == startingMessageId && (loopCount = loopCount + 1) == 2) {
                throw yw.a(32001);
            }
        } while (this.d.containsKey(new Integer(this.c)));
        Integer id = new Integer(this.c);
        this.d.put(id, id);
        return this.c;
    }

    public void C(long timeout) {
        if (timeout > 0) {
            qy qyVar = b;
            String str = a;
            qyVar.fine(str, "quiesce", "637", new Object[]{new Long(timeout)});
            synchronized (this.p) {
                this.r = true;
            }
            this.i.j();
            u();
            synchronized (this.q) {
                try {
                    int tokc = this.g.b();
                    if (tokc > 0 || this.f.size() > 0 || !this.i.h()) {
                        qyVar.fine(str, "quiesce", "639", new Object[]{new Integer(this.n), new Integer(this.f.size()), new Integer(this.o), new Integer(tokc)});
                        this.q.wait(timeout);
                    }
                } catch (InterruptedException e) {
                }
            }
            synchronized (this.p) {
                this.e.clear();
                this.f.clear();
                this.r = false;
                this.n = 0;
            }
            b.fine(a, "quiesce", "640");
        }
    }

    public void u() {
        synchronized (this.p) {
            b.fine(a, "notifyQueueLock", "638");
            this.p.notifyAll();
        }
    }

    public void g(gy message) throws lw {
        b.fine(a, "deliveryComplete", "641", new Object[]{new Integer(message.p())});
        this.l.remove(o(message));
        this.C.remove(new Integer(message.p()));
    }

    public int j() {
        return this.n;
    }

    public int m() {
        return this.m;
    }

    public void d() {
        this.d.clear();
        if (this.e != null) {
            this.e.clear();
        }
        this.f.clear();
        this.z.clear();
        this.A.clear();
        this.B.clear();
        this.C.clear();
        this.g.a();
        this.d = null;
        this.e = null;
        this.f = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.g = null;
        this.i = null;
        this.h = null;
        this.l = null;
        this.v = null;
    }
}
