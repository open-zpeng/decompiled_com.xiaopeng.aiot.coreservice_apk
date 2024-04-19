package defpackage;

import java.io.IOException;
import java.io.InputStream;
/* compiled from: CountingInputStream.java */
/* renamed from: sx  reason: default package */
/* loaded from: classes.dex */
public class sx extends InputStream {
    public InputStream a;
    public int b = 0;

    public sx(InputStream in) {
        this.a = in;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.a.read();
        if (i != -1) {
            this.b++;
        }
        return i;
    }

    public int a() {
        return this.b;
    }
}
