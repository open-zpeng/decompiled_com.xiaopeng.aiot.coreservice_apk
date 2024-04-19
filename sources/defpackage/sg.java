package defpackage;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* compiled from: JsonWriter.java */
/* renamed from: sg  reason: default package */
/* loaded from: classes.dex */
public class sg implements Closeable, Flushable {
    public static final String[] a = new String[128];
    public static final String[] b;
    public final Writer d;
    public int[] f = new int[32];
    public int g = 0;
    public String h;
    public String i;
    public boolean j;
    public boolean k;
    public String l;
    public boolean m;

    static {
        for (int i = 0; i <= 31; i++) {
            a[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public sg(Writer writer) {
        h(6);
        this.i = ":";
        this.m = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.d = writer;
    }

    public final void A() throws IOException {
        int a2 = a();
        if (a2 == 5) {
            this.d.write(44);
        } else if (a2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        z();
        k(4);
    }

    public final int a() {
        int i = this.g;
        if (i != 0) {
            return this.f[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final sg b(int i, int i2, String str) throws IOException {
        int a2 = a();
        if (a2 == i2 || a2 == i) {
            if (this.l != null) {
                throw new IllegalStateException("Dangling name: " + this.l);
            }
            this.g--;
            if (a2 == i2) {
                z();
            }
            this.d.write(str);
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    public final sg c(int i, String str) throws IOException {
        t(true);
        h(i);
        this.d.write(str);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
        int i = this.g;
        if (i > 1 || (i == 1 && this.f[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.g = 0;
    }

    public sg d(long j) throws IOException {
        x();
        t(false);
        this.d.write(Long.toString(j));
        return this;
    }

    public sg e(Number number) throws IOException {
        if (number == null) {
            return u();
        }
        x();
        String obj = number.toString();
        if (this.j || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            t(false);
            this.d.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public sg f(String str) throws IOException {
        if (str != null) {
            if (this.l == null) {
                if (this.g != 0) {
                    this.l = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.g == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.d.flush();
    }

    public sg g(boolean z) throws IOException {
        x();
        t(false);
        this.d.write(z ? "true" : "false");
        return this;
    }

    public final void h(int i) {
        int i2 = this.g;
        int[] iArr = this.f;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f = iArr2;
        }
        int[] iArr3 = this.f;
        int i3 = this.g;
        this.g = i3 + 1;
        iArr3[i3] = i;
    }

    public sg i() throws IOException {
        x();
        return c(1, "[");
    }

    public sg j(String str) throws IOException {
        if (str == null) {
            return u();
        }
        x();
        t(false);
        n(str);
        return this;
    }

    public final void k(int i) {
        this.f[this.g - 1] = i;
    }

    public final void l(boolean z) {
        this.j = z;
    }

    public sg m() throws IOException {
        x();
        return c(3, "{");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.k
            if (r0 == 0) goto L7
            java.lang.String[] r0 = defpackage.sg.b
            goto L9
        L7:
            java.lang.String[] r0 = defpackage.sg.a
        L9:
            java.io.Writer r1 = r8.d
            java.lang.String r2 = "\""
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.d
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.d
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.d
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.d
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sg.n(java.lang.String):void");
    }

    public final void o(boolean z) {
        this.m = z;
    }

    public sg p() throws IOException {
        return b(1, 2, "]");
    }

    public final void q(String str) {
        String str2;
        if (str.length() == 0) {
            this.h = null;
            str2 = ":";
        } else {
            this.h = str;
            str2 = ": ";
        }
        this.i = str2;
    }

    public final void r(boolean z) {
        this.k = z;
    }

    public sg s() throws IOException {
        return b(3, 5, "}");
    }

    public final void t(boolean z) throws IOException {
        int i;
        switch (a()) {
            case 1:
                k(2);
                z();
                return;
            case 2:
                this.d.append(',');
                z();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.d.append((CharSequence) this.i);
                i = 5;
                k(i);
                return;
            case 6:
                if (this.j && !z) {
                    throw new IllegalStateException("JSON must start with an array or an object.");
                }
                i = 7;
                k(i);
                return;
            case 7:
                if (!this.j) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                if (this.j) {
                }
                i = 7;
                k(i);
                return;
        }
    }

    public sg u() throws IOException {
        if (this.l != null) {
            if (!this.m) {
                this.l = null;
                return this;
            }
            x();
        }
        t(false);
        this.d.write("null");
        return this;
    }

    public boolean v() {
        return this.j;
    }

    public final boolean w() {
        return this.k;
    }

    public final void x() throws IOException {
        if (this.l != null) {
            A();
            n(this.l);
            this.l = null;
        }
    }

    public final boolean y() {
        return this.m;
    }

    public final void z() throws IOException {
        if (this.h == null) {
            return;
        }
        this.d.write("\n");
        int i = this.g;
        for (int i2 = 1; i2 < i; i2++) {
            this.d.write(this.h);
        }
    }
}
