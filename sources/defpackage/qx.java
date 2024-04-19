package defpackage;

import com.xiaopeng.libconfig.ipc.AccountConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
/* compiled from: WebSocketReceiver.java */
/* renamed from: qx  reason: default package */
/* loaded from: classes.dex */
public class qx implements Runnable {
    public static final String a;
    public static final qy b;
    public InputStream h;
    public volatile boolean j;
    public PipedOutputStream k;
    public boolean d = false;
    public boolean f = false;
    public Object g = new Object();
    public Thread i = null;

    static {
        String name = qx.class.getName();
        a = name;
        b = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public qx(InputStream input, PipedInputStream pipedInputStream) throws IOException {
        this.h = input;
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        this.k = pipedOutputStream;
        pipedInputStream.connect(pipedOutputStream);
    }

    public void b(String threadName) {
        b.fine(a, AccountConfig.FaceIDRegisterAction.STATUS_START, "855");
        synchronized (this.g) {
            if (!this.d) {
                this.d = true;
                Thread thread = new Thread(this, threadName);
                this.i = thread;
                thread.start();
            }
        }
    }

    public void c() {
        this.f = true;
        boolean closed = false;
        synchronized (this.g) {
            b.fine(a, "stop", "850");
            if (this.d) {
                this.d = false;
                this.j = false;
                closed = true;
                a();
            }
        }
        if (closed && !Thread.currentThread().equals(this.i)) {
            try {
                this.i.join();
            } catch (InterruptedException e) {
            }
        }
        this.i = null;
        b.fine(a, "stop", "851");
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.d && this.h != null) {
            try {
                b.fine(a, "run", "852");
                this.j = this.h.available() > 0;
                nx incomingFrame = new nx(this.h);
                if (!incomingFrame.g()) {
                    for (int i = 0; i < incomingFrame.f().length; i++) {
                        this.k.write(incomingFrame.f()[i]);
                    }
                    this.k.flush();
                } else if (!this.f) {
                    throw new IOException("Server sent a WebSocket Frame with the Stop OpCode");
                    break;
                }
                this.j = false;
            } catch (IOException e) {
                c();
            }
        }
    }

    public final void a() {
        try {
            this.k.close();
        } catch (IOException e) {
        }
    }
}
