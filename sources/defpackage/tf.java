package defpackage;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: JsonTreeReader.java */
/* renamed from: tf  reason: default package */
/* loaded from: classes.dex */
public final class tf extends qg {
    public static final Reader q = new a();
    public static final Object r = new Object();
    public final List<Object> s;

    /* compiled from: JsonTreeReader.java */
    /* renamed from: tf$a */
    /* loaded from: classes.dex */
    public static class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    }

    @Override // defpackage.qg
    public void B() throws IOException {
        if (t() == rg.NAME) {
            u();
        } else {
            R();
        }
    }

    @Override // defpackage.qg
    public int C() throws IOException {
        rg t = t();
        rg rgVar = rg.NUMBER;
        if (t == rgVar || t == rg.STRING) {
            int o = ((fh) P()).o();
            R();
            return o;
        }
        throw new IllegalStateException("Expected " + rgVar + " but was " + t);
    }

    public final void O(rg rgVar) throws IOException {
        if (t() == rgVar) {
            return;
        }
        throw new IllegalStateException("Expected " + rgVar + " but was " + t());
    }

    public final Object P() {
        List<Object> list = this.s;
        return list.get(list.size() - 1);
    }

    public void Q() throws IOException {
        O(rg.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) P()).next();
        this.s.add(entry.getValue());
        this.s.add(new fh((String) entry.getKey()));
    }

    public final Object R() {
        List<Object> list = this.s;
        return list.remove(list.size() - 1);
    }

    @Override // defpackage.qg
    public void c() throws IOException {
        O(rg.BEGIN_ARRAY);
        this.s.add(((zg) P()).iterator());
    }

    @Override // defpackage.qg, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.s.clear();
        this.s.add(r);
    }

    @Override // defpackage.qg
    public void l() throws IOException {
        O(rg.END_ARRAY);
        R();
        R();
    }

    @Override // defpackage.qg
    public void o() throws IOException {
        O(rg.END_OBJECT);
        R();
        R();
    }

    @Override // defpackage.qg
    public void q() throws IOException {
        O(rg.BEGIN_OBJECT);
        this.s.add(((dh) P()).i().iterator());
    }

    @Override // defpackage.qg
    public boolean s() throws IOException {
        rg t = t();
        return (t == rg.END_OBJECT || t == rg.END_ARRAY) ? false : true;
    }

    @Override // defpackage.qg
    public rg t() throws IOException {
        if (this.s.isEmpty()) {
            return rg.END_DOCUMENT;
        }
        Object P = P();
        if (P instanceof Iterator) {
            List<Object> list = this.s;
            boolean z = list.get(list.size() - 2) instanceof dh;
            Iterator it = (Iterator) P;
            if (!it.hasNext()) {
                return z ? rg.END_OBJECT : rg.END_ARRAY;
            } else if (z) {
                return rg.NAME;
            } else {
                this.s.add(it.next());
                return t();
            }
        } else if (P instanceof dh) {
            return rg.BEGIN_OBJECT;
        } else {
            if (P instanceof zg) {
                return rg.BEGIN_ARRAY;
            }
            if (!(P instanceof fh)) {
                if (P instanceof ch) {
                    return rg.NULL;
                }
                if (P == r) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
            fh fhVar = (fh) P;
            if (fhVar.t()) {
                return rg.STRING;
            }
            if (fhVar.j()) {
                return rg.BOOLEAN;
            }
            if (fhVar.s()) {
                return rg.NUMBER;
            }
            throw new AssertionError();
        }
    }

    @Override // defpackage.qg
    public String toString() {
        return tf.class.getSimpleName();
    }

    @Override // defpackage.qg
    public String u() throws IOException {
        O(rg.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) P()).next();
        this.s.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // defpackage.qg
    public String v() throws IOException {
        rg t = t();
        rg rgVar = rg.STRING;
        if (t == rgVar || t == rg.NUMBER) {
            return ((fh) R()).l();
        }
        throw new IllegalStateException("Expected " + rgVar + " but was " + t);
    }

    @Override // defpackage.qg
    public void w() throws IOException {
        O(rg.NULL);
        R();
    }

    @Override // defpackage.qg
    public boolean x() throws IOException {
        O(rg.BOOLEAN);
        return ((fh) R()).q();
    }

    @Override // defpackage.qg
    public double y() throws IOException {
        rg t = t();
        rg rgVar = rg.NUMBER;
        if (t != rgVar && t != rg.STRING) {
            throw new IllegalStateException("Expected " + rgVar + " but was " + t);
        }
        double n = ((fh) P()).n();
        if (E() || !(Double.isNaN(n) || Double.isInfinite(n))) {
            R();
            return n;
        }
        throw new NumberFormatException("JSON forbids NaN and infinities: " + n);
    }

    @Override // defpackage.qg
    public long z() throws IOException {
        rg t = t();
        rg rgVar = rg.NUMBER;
        if (t == rgVar || t == rg.STRING) {
            long p = ((fh) P()).p();
            R();
            return p;
        }
        throw new IllegalStateException("Expected " + rgVar + " but was " + t);
    }
}
