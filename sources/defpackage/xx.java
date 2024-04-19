package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
/* compiled from: MqttInputStream.java */
/* renamed from: xx  reason: default package */
/* loaded from: classes.dex */
public class xx extends InputStream {
    public static final String a;
    public static final qy b;
    public rw d;
    public DataInputStream f;
    public ByteArrayOutputStream g = new ByteArrayOutputStream();
    public long h = -1;
    public long i;
    public byte[] j;

    static {
        String name = xx.class.getName();
        a = name;
        b = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public xx(rw clientState, InputStream in) {
        this.d = null;
        this.d = clientState;
        this.f = new DataInputStream(in);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f.read();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f.close();
    }

    public my b() throws IOException, iw {
        try {
            if (this.h < 0) {
                this.g.reset();
                byte first = this.f.readByte();
                this.d.w(1);
                byte type = (byte) ((first >>> 4) & 15);
                if (type < 1 || type > 14) {
                    throw yw.a(32108);
                }
                this.h = my.v(this.f).a();
                this.g.write(first);
                this.g.write(my.k(this.h));
                this.j = new byte[(int) (this.g.size() + this.h)];
                this.i = 0L;
            }
            if (this.h < 0) {
                return null;
            }
            a();
            this.h = -1L;
            byte[] header = this.g.toByteArray();
            System.arraycopy(header, 0, this.j, 0, header.length);
            my message = my.i(this.j);
            b.fine(a, "readMqttWireMessage", "501", new Object[]{message});
            return message;
        } catch (SocketTimeoutException e) {
            return null;
        }
    }

    public final void a() throws IOException {
        int size = this.g.size();
        long j = this.i;
        int off = size + ((int) j);
        int len = (int) (this.h - j);
        if (len < 0) {
            throw new IndexOutOfBoundsException();
        }
        int n = 0;
        while (n < len) {
            try {
                int count = this.f.read(this.j, off + n, len - n);
                this.d.w(count);
                if (count < 0) {
                    throw new EOFException();
                }
                n += count;
            } catch (SocketTimeoutException e) {
                this.i += n;
                throw e;
            }
        }
    }
}
