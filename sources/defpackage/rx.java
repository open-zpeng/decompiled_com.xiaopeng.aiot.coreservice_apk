package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: WebSocketSecureNetworkModule.java */
/* renamed from: rx  reason: default package */
/* loaded from: classes.dex */
public class rx extends fx {
    public static final String o;
    public static final qy p;
    public PipedInputStream q;
    public qx r;
    public String s;
    public String t;
    public int u;
    public ByteArrayOutputStream v;

    static {
        String name = rx.class.getName();
        o = name;
        p = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public rx(SSLSocketFactory factory, String uri, String host, int port, String clientId) {
        super(factory, host, port, clientId);
        this.v = new lx(this);
        this.s = uri;
        this.t = host;
        this.u = port;
        this.q = new PipedInputStream();
        p.setResourceName(clientId);
    }

    @Override // defpackage.fx, defpackage.gx, defpackage.dx
    public void start() throws IOException, iw {
        super.start();
        ox handshake = new ox(super.c(), super.b(), this.s, this.t, this.u);
        handshake.a();
        qx qxVar = new qx(h(), this.q);
        this.r = qxVar;
        qxVar.b("WssSocketReceiver");
    }

    public OutputStream i() throws IOException {
        return super.b();
    }

    public InputStream h() throws IOException {
        return super.c();
    }

    @Override // defpackage.gx, defpackage.dx
    public InputStream c() throws IOException {
        return this.q;
    }

    @Override // defpackage.gx, defpackage.dx
    public OutputStream b() throws IOException {
        return this.v;
    }

    @Override // defpackage.gx, defpackage.dx
    public void stop() throws IOException {
        nx frame = new nx((byte) 8, true, "1000".getBytes());
        byte[] rawFrame = frame.d();
        i().write(rawFrame);
        i().flush();
        qx qxVar = this.r;
        if (qxVar != null) {
            qxVar.c();
        }
        super.stop();
    }

    @Override // defpackage.fx, defpackage.gx, defpackage.dx
    public String a() {
        return "wss://" + this.t + ":" + this.u;
    }
}
