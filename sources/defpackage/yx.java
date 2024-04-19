package defpackage;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: MqttOutputStream.java */
/* renamed from: yx  reason: default package */
/* loaded from: classes.dex */
public class yx extends OutputStream {
    public static final String a;
    public static final qy b;
    public rw d;
    public BufferedOutputStream f;

    static {
        String name = yx.class.getName();
        a = name;
        b = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public yx(rw clientState, OutputStream out) {
        this.d = null;
        this.d = clientState;
        this.f = new BufferedOutputStream(out);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] b2) throws IOException {
        this.f.write(b2);
        this.d.A(b2.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b2, int off, int len) throws IOException {
        this.f.write(b2, off, len);
        this.d.A(len);
    }

    @Override // java.io.OutputStream
    public void write(int b2) throws IOException {
        this.f.write(b2);
    }

    public void a(my message) throws IOException, iw {
        byte[] bytes = message.n();
        byte[] pl = message.r();
        this.f.write(bytes, 0, bytes.length);
        this.d.A(bytes.length);
        int offset = 0;
        while (offset < pl.length) {
            int length = Math.min(1024, pl.length - offset);
            this.f.write(pl, offset, length);
            offset += 1024;
            this.d.A(length);
        }
        b.fine(a, "write", "529", new Object[]{message});
    }
}
