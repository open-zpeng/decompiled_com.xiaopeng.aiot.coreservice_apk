package defpackage;

import java.util.ArrayList;
/* compiled from: DisconnectedMessageBuffer.java */
/* renamed from: xw  reason: default package */
/* loaded from: classes.dex */
public class xw implements Runnable {
    public static final qy a = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", "DisconnectedMessageBuffer");
    public wv b;
    public ax g;
    public Object f = new Object();
    public ArrayList d = new ArrayList();

    public xw(wv options) {
        this.b = options;
    }

    public void e(my message, ow token) throws iw {
        vv bufferedMessage = new vv(message, token);
        synchronized (this.f) {
            if (this.d.size() < this.b.a()) {
                this.d.add(bufferedMessage);
            } else if (this.b.c()) {
                this.d.remove(0);
                this.d.add(bufferedMessage);
            } else {
                throw new iw(32203);
            }
        }
    }

    public vv b(int messageIndex) {
        vv vvVar;
        synchronized (this.f) {
            vvVar = (vv) this.d.get(messageIndex);
        }
        return vvVar;
    }

    public void a(int messageIndex) {
        synchronized (this.f) {
            this.d.remove(messageIndex);
        }
    }

    public int c() {
        int size;
        synchronized (this.f) {
            size = this.d.size();
        }
        return size;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.fine("DisconnectedMessageBuffer", "run", "516");
        while (c() > 0) {
            try {
                vv bufferedMessage = b(0);
                this.g.a(bufferedMessage);
                a(0);
            } catch (iw e) {
                a.warning("DisconnectedMessageBuffer", "run", "517");
                return;
            }
        }
    }

    public void f(ax callback) {
        this.g = callback;
    }

    public boolean d() {
        return this.b.d();
    }
}
