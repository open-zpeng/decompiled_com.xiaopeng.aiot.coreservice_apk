package defpackage;

import java.util.Arrays;
import org.eclipse.paho.android.service.MqttAndroidClient;
/* compiled from: MqttTokenAndroid.java */
/* renamed from: rv  reason: default package */
/* loaded from: classes.dex */
public class rv implements bw {
    public xv a;
    public volatile boolean b;
    public volatile iw c;
    public Object d;
    public MqttAndroidClient e;
    public Object f;
    public String[] g;
    public bw h;
    public iw i;

    public rv(MqttAndroidClient client, Object userContext, xv listener) {
        this(client, userContext, listener, null);
    }

    public rv(MqttAndroidClient client, Object userContext, xv listener, String[] topics) {
        this.d = new Object();
        this.e = client;
        this.f = userContext;
        this.a = listener;
        this.g = topics;
    }

    @Override // defpackage.bw
    public void c(long timeout) throws iw, nw {
        synchronized (this.d) {
            try {
                this.d.wait(timeout);
            } catch (InterruptedException e) {
            }
            if (!this.b) {
                throw new iw(32000);
            }
            iw iwVar = this.i;
            if (iwVar != null) {
                throw iwVar;
            }
        }
    }

    public void g() {
        synchronized (this.d) {
            this.b = true;
            this.d.notifyAll();
            xv xvVar = this.a;
            if (xvVar != null) {
                xvVar.onSuccess(this);
            }
        }
    }

    public synchronized void h(Throwable exception) {
        synchronized (this.d) {
            this.b = true;
            if (exception instanceof iw) {
                this.i = (iw) exception;
            } else {
                this.i = new iw(exception);
            }
            this.d.notifyAll();
            if (exception instanceof iw) {
                this.c = (iw) exception;
            }
            xv xvVar = this.a;
            if (xvVar != null) {
                xvVar.onFailure(this, exception);
            }
        }
    }

    @Override // defpackage.bw
    public yv f() {
        return this.e;
    }

    @Override // defpackage.bw
    public xv e() {
        return this.a;
    }

    @Override // defpackage.bw
    public String[] b() {
        bw bwVar = this.h;
        if (bwVar != null && bwVar.b() != null) {
            return this.h.b();
        }
        return this.g;
    }

    public void i(bw delegate) {
        this.h = delegate;
    }

    @Override // defpackage.bw
    public int a() {
        bw bwVar = this.h;
        if (bwVar != null) {
            return bwVar.a();
        }
        return 0;
    }

    @Override // defpackage.bw
    public my d() {
        return this.h.d();
    }

    public String toString() {
        return "MqttTokenAndroid{topics=" + Arrays.toString(this.g) + '}';
    }
}
