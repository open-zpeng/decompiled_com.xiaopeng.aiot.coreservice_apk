package defpackage;

import java.io.IOException;
import java.io.Writer;
/* compiled from: Streams.java */
/* renamed from: mg  reason: default package */
/* loaded from: classes.dex */
public final class mg {

    /* compiled from: Streams.java */
    /* renamed from: mg$b */
    /* loaded from: classes.dex */
    public static final class b extends Writer {
        public final Appendable a;
        public final a b;

        /* compiled from: Streams.java */
        /* renamed from: mg$b$a */
        /* loaded from: classes.dex */
        public static class a implements CharSequence {
            public char[] a;

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.a[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.a, i, i2 - i);
            }
        }

        public b(Appendable appendable) {
            this.b = new a();
            this.a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.a.append((char) i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            a aVar = this.b;
            aVar.a = cArr;
            this.a.append(aVar, i, i2 + i);
        }
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }

    public static void b(lh lhVar, sg sgVar) throws IOException {
        cg.P.a(sgVar, lhVar);
    }
}
