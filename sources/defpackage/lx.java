package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* compiled from: ExtendedByteArrayOutputStream.java */
/* renamed from: lx  reason: default package */
/* loaded from: classes.dex */
public class lx extends ByteArrayOutputStream {
    public final px a;
    public final rx b;

    public lx(px module) {
        this.a = module;
        this.b = null;
    }

    public lx(rx module) {
        this.a = null;
        this.b = module;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ByteBuffer byteBuffer;
        synchronized (this) {
            byteBuffer = ByteBuffer.wrap(toByteArray());
            reset();
        }
        nx frame = new nx((byte) 2, true, byteBuffer.array());
        byte[] rawFrame = frame.d();
        a().write(rawFrame);
        a().flush();
    }

    public OutputStream a() throws IOException {
        px pxVar = this.a;
        if (pxVar != null) {
            return pxVar.f();
        }
        rx rxVar = this.b;
        if (rxVar != null) {
            return rxVar.i();
        }
        return null;
    }
}
