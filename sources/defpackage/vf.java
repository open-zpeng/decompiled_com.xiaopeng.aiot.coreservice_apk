package defpackage;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: JsonTreeWriter.java */
/* renamed from: vf  reason: default package */
/* loaded from: classes.dex */
public final class vf extends sg {
    public static final Writer n = new a();
    public static final fh o = new fh("closed");
    public final List<lh> p;
    public String q;
    public lh r;

    /* compiled from: JsonTreeWriter.java */
    /* renamed from: vf$a */
    /* loaded from: classes.dex */
    public static class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public vf() {
        super(n);
        this.p = new ArrayList();
        this.r = ch.a;
    }

    public lh B() {
        if (this.p.isEmpty()) {
            return this.r;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.p);
    }

    public final void C(lh lhVar) {
        if (this.q != null) {
            if (!lhVar.c() || y()) {
                ((dh) D()).h(this.q, lhVar);
            }
            this.q = null;
        } else if (this.p.isEmpty()) {
            this.r = lhVar;
        } else {
            lh D = D();
            if (!(D instanceof zg)) {
                throw new IllegalStateException();
            }
            ((zg) D).h(lhVar);
        }
    }

    public final lh D() {
        List<lh> list = this.p;
        return list.get(list.size() - 1);
    }

    @Override // defpackage.sg, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.p.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.p.add(o);
    }

    @Override // defpackage.sg
    public sg d(long j) throws IOException {
        C(new fh(Long.valueOf(j)));
        return this;
    }

    @Override // defpackage.sg
    public sg e(Number number) throws IOException {
        if (number == null) {
            return u();
        }
        if (!v()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        C(new fh(number));
        return this;
    }

    @Override // defpackage.sg
    public sg f(String str) throws IOException {
        if (this.p.isEmpty() || this.q != null) {
            throw new IllegalStateException();
        }
        if (D() instanceof dh) {
            this.q = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.sg, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // defpackage.sg
    public sg g(boolean z) throws IOException {
        C(new fh(Boolean.valueOf(z)));
        return this;
    }

    @Override // defpackage.sg
    public sg i() throws IOException {
        zg zgVar = new zg();
        C(zgVar);
        this.p.add(zgVar);
        return this;
    }

    @Override // defpackage.sg
    public sg j(String str) throws IOException {
        if (str == null) {
            return u();
        }
        C(new fh(str));
        return this;
    }

    @Override // defpackage.sg
    public sg m() throws IOException {
        dh dhVar = new dh();
        C(dhVar);
        this.p.add(dhVar);
        return this;
    }

    @Override // defpackage.sg
    public sg p() throws IOException {
        if (this.p.isEmpty() || this.q != null) {
            throw new IllegalStateException();
        }
        if (D() instanceof zg) {
            List<lh> list = this.p;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.sg
    public sg s() throws IOException {
        if (this.p.isEmpty() || this.q != null) {
            throw new IllegalStateException();
        }
        if (D() instanceof dh) {
            List<lh> list = this.p;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.sg
    public sg u() throws IOException {
        C(ch.a);
        return this;
    }
}
