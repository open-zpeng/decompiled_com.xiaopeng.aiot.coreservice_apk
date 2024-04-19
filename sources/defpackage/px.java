package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import javax.net.SocketFactory;
/* compiled from: WebSocketNetworkModule.java */
/* renamed from: px  reason: default package */
/* loaded from: classes.dex */
public class px extends gx {
    public static final String h;
    public static final qy i;
    public String j;
    public String k;
    public int l;
    public PipedInputStream m;
    public qx n;
    public ByteArrayOutputStream o;

    static {
        String name = px.class.getName();
        h = name;
        i = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public px(SocketFactory factory, String uri, String host, int port, String resourceContext) {
        super(factory, host, port, resourceContext);
        this.o = new lx(this);
        this.j = uri;
        this.k = host;
        this.l = port;
        this.m = new PipedInputStream();
        i.setResourceName(resourceContext);
    }

    @Override // defpackage.gx, defpackage.dx
    public void start() throws IOException, iw {
        super.start();
        ox handshake = new ox(e(), f(), this.j, this.k, this.l);
        handshake.a();
        qx qxVar = new qx(e(), this.m);
        this.n = qxVar;
        qxVar.b("webSocketReceiver");
    }

    public OutputStream f() throws IOException {
        return super.b();
    }

    public InputStream e() throws IOException {
        return super.c();
    }

    @Override // defpackage.gx, defpackage.dx
    public InputStream c() throws IOException {
        return this.m;
    }

    @Override // defpackage.gx, defpackage.dx
    public OutputStream b() throws IOException {
        return this.o;
    }

    @Override // defpackage.gx, defpackage.dx
    public void stop() throws IOException {
        nx frame = new nx((byte) 8, true, "1000".getBytes());
        byte[] rawFrame = frame.d();
        f().write(rawFrame);
        f().flush();
        qx qxVar = this.n;
        if (qxVar != null) {
            qxVar.c();
        }
        super.stop();
    }

    @Override // defpackage.gx, defpackage.dx
    public String a() {
        return "ws://" + this.k + ":" + this.l;
    }
}
