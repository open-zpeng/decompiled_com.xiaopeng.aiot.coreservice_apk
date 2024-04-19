package defpackage;

import com.xiaopeng.libconfig.ipc.AccountConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: TCPNetworkModule.java */
/* renamed from: gx  reason: default package */
/* loaded from: classes.dex */
public class gx implements dx {
    public static final String a;
    public static final qy b;
    public Socket c;
    public SocketFactory d;
    public String e;
    public int f;
    public int g;

    static {
        String name = gx.class.getName();
        a = name;
        b = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public gx(SocketFactory factory, String host, int port, String resourceContext) {
        b.setResourceName(resourceContext);
        this.d = factory;
        this.e = host;
        this.f = port;
    }

    @Override // defpackage.dx
    public void start() throws IOException, iw {
        try {
            b.fine(a, AccountConfig.FaceIDRegisterAction.STATUS_START, "252", new Object[]{this.e, new Integer(this.f), new Long(this.g * 1000)});
            SocketAddress sockaddr = new InetSocketAddress(this.e, this.f);
            SocketFactory socketFactory = this.d;
            if (socketFactory instanceof SSLSocketFactory) {
                Socket tempsocket = new Socket();
                tempsocket.connect(sockaddr, this.g * 1000);
                this.c = ((SSLSocketFactory) this.d).createSocket(tempsocket, this.e, this.f, true);
                return;
            }
            Socket createSocket = socketFactory.createSocket();
            this.c = createSocket;
            createSocket.connect(sockaddr, this.g * 1000);
        } catch (ConnectException ex) {
            b.fine(a, AccountConfig.FaceIDRegisterAction.STATUS_START, "250", null, ex);
            throw new iw(32103, ex);
        }
    }

    @Override // defpackage.dx
    public InputStream c() throws IOException {
        return this.c.getInputStream();
    }

    @Override // defpackage.dx
    public OutputStream b() throws IOException {
        return this.c.getOutputStream();
    }

    @Override // defpackage.dx
    public void stop() throws IOException {
        Socket socket = this.c;
        if (socket != null) {
            socket.shutdownInput();
            this.c.close();
        }
    }

    public void d(int timeout) {
        this.g = timeout;
    }

    @Override // defpackage.dx
    public String a() {
        return "tcp://" + this.e + ":" + this.f;
    }
}
