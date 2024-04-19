package defpackage;

import android.util.Log;
import java.io.Writer;
/* compiled from: LogWriter.java */
/* renamed from: rc  reason: default package */
/* loaded from: classes.dex */
public final class rc extends Writer {
    public final String a;
    public StringBuilder b = new StringBuilder(128);

    public rc(String tag) {
        this.a = tag;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] buf, int offset, int count) {
        for (int i = 0; i < count; i++) {
            char c = buf[offset + i];
            if (c == '\n') {
                a();
            } else {
                this.b.append(c);
            }
        }
    }

    public final void a() {
        if (this.b.length() > 0) {
            Log.d(this.a, this.b.toString());
            StringBuilder sb = this.b;
            sb.delete(0, sb.length());
        }
    }
}
