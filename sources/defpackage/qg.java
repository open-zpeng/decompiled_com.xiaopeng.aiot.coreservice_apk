package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
/* compiled from: JsonReader.java */
/* renamed from: qg  reason: default package */
/* loaded from: classes.dex */
public class qg implements Closeable {
    public static final char[] a = ")]}'\n".toCharArray();
    public final Reader b;
    public boolean d = false;
    public final char[] f = new char[1024];
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = 0;
    public long l;
    public int m;
    public String n;
    public int[] o;
    public int p;

    /* compiled from: JsonReader.java */
    /* renamed from: qg$a */
    /* loaded from: classes.dex */
    public static class a extends hg {
        @Override // defpackage.hg
        public void a(qg qgVar) throws IOException {
            int i;
            if (qgVar instanceof tf) {
                ((tf) qgVar).Q();
                return;
            }
            int i2 = qgVar.k;
            if (i2 == 0) {
                i2 = qgVar.D();
            }
            if (i2 == 13) {
                i = 9;
            } else if (i2 == 12) {
                i = 8;
            } else if (i2 != 14) {
                throw new IllegalStateException("Expected a name but was " + qgVar.t() + "  at line " + qgVar.I() + " column " + qgVar.K());
            } else {
                i = 10;
            }
            qgVar.k = i;
        }
    }

    static {
        hg.a = new a();
    }

    public qg(Reader reader) {
        int[] iArr = new int[32];
        this.o = iArr;
        this.p = 0;
        this.p = 0 + 1;
        iArr[0] = 6;
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.b = reader;
    }

    public final int A() throws IOException {
        int i;
        String str;
        String str2;
        char c = this.f[this.g];
        if (c == 't' || c == 'T') {
            i = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c == 'f' || c == 'F') {
            i = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            i = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.g + i2 >= this.h && !m(i2 + 1)) {
                return 0;
            }
            char c2 = this.f[this.g + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.g + length < this.h || m(length + 1)) && f(this.f[this.g + length])) {
            return 0;
        }
        this.g += length;
        this.k = i;
        return i;
    }

    public void B() throws IOException {
        char c;
        int i = 0;
        do {
            int i2 = this.k;
            if (i2 == 0) {
                i2 = D();
            }
            if (i2 == 3) {
                d(1);
            } else if (i2 == 1) {
                d(3);
            } else {
                if (i2 == 4 || i2 == 2) {
                    this.p--;
                    i--;
                } else if (i2 == 14 || i2 == 10) {
                    H();
                } else {
                    if (i2 == 8 || i2 == 12) {
                        c = '\'';
                    } else if (i2 == 9 || i2 == 13) {
                        c = '\"';
                    } else if (i2 == 16) {
                        this.g += this.m;
                    }
                    r(c);
                }
                this.k = 0;
            }
            i++;
            this.k = 0;
        } while (i != 0);
    }

    public int C() throws IOException {
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        if (i == 15) {
            long j = this.l;
            int i2 = (int) j;
            if (j == i2) {
                this.k = 0;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.l + " at line " + I() + " column " + K());
        }
        if (i == 16) {
            this.n = new String(this.f, this.g, this.m);
            this.g += this.m;
        } else if (i != 8 && i != 9) {
            throw new IllegalStateException("Expected an int but was " + t() + " at line " + I() + " column " + K());
        } else {
            String k = k(i == 8 ? '\'' : '\"');
            this.n = k;
            try {
                int parseInt = Integer.parseInt(k);
                this.k = 0;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        }
        this.k = 11;
        double parseDouble = Double.parseDouble(this.n);
        int i3 = (int) parseDouble;
        if (i3 == parseDouble) {
            this.n = null;
            this.k = 0;
            return i3;
        }
        throw new NumberFormatException("Expected an int but was " + this.n + " at line " + I() + " column " + K());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int D() throws IOException {
        int i;
        int[] iArr = this.o;
        int i2 = this.p;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 != 2) {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5) {
                    switch (i(true)) {
                        case 44:
                            break;
                        case 59:
                            J();
                            break;
                        case w.M0 /* 125 */:
                            this.k = 2;
                            return 2;
                        default:
                            throw j("Unterminated object");
                    }
                }
                int i4 = i(true);
                switch (i4) {
                    case 34:
                        i = 13;
                        break;
                    case 39:
                        J();
                        i = 12;
                        break;
                    case w.M0 /* 125 */:
                        if (i3 != 5) {
                            this.k = 2;
                            return 2;
                        }
                        throw j("Expected name");
                    default:
                        J();
                        this.g--;
                        if (f((char) i4)) {
                            i = 14;
                            break;
                        } else {
                            throw j("Expected name");
                        }
                }
            } else if (i3 == 4) {
                iArr[i2 - 1] = 5;
                switch (i(true)) {
                    case 58:
                        break;
                    default:
                        throw j("Expected ':'");
                    case 61:
                        J();
                        if (this.g < this.h || m(1)) {
                            char[] cArr = this.f;
                            int i5 = this.g;
                            if (cArr[i5] == '>') {
                                this.g = i5 + 1;
                                break;
                            }
                        }
                        break;
                }
            } else if (i3 == 6) {
                if (this.d) {
                    N();
                }
                this.o[this.p - 1] = 7;
            } else if (i3 == 7) {
                if (i(false) == -1) {
                    i = 17;
                } else {
                    J();
                    this.g--;
                }
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            this.k = i;
            return i;
        } else {
            switch (i(true)) {
                case 44:
                    break;
                case 59:
                    J();
                    break;
                case 93:
                    this.k = 4;
                    return 4;
                default:
                    throw j("Unterminated array");
            }
        }
        switch (i(true)) {
            case 34:
                if (this.p == 1) {
                    J();
                }
                i = 9;
                this.k = i;
                return i;
            case 39:
                J();
                this.k = 8;
                return 8;
            case 44:
            case 59:
                if (i3 != 1 || i3 == 2) {
                    J();
                    this.g--;
                    this.k = 7;
                    return 7;
                }
                throw j("Unexpected value");
            case 91:
                this.k = 3;
                return 3;
            case 93:
                if (i3 == 1) {
                    this.k = 4;
                    return 4;
                }
                if (i3 != 1) {
                }
                J();
                this.g--;
                this.k = 7;
                return 7;
            case w.K0 /* 123 */:
                this.k = 1;
                return 1;
            default:
                this.g--;
                if (this.p == 1) {
                    J();
                }
                int A = A();
                if (A != 0) {
                    return A;
                }
                int G = G();
                if (G != 0) {
                    return G;
                }
                if (f(this.f[this.g])) {
                    J();
                    i = 10;
                    this.k = i;
                    return i;
                }
                throw j("Expected value");
        }
    }

    public final boolean E() {
        return this.d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
        r0 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String F() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r0
        L3:
            int r3 = r6.g
            int r4 = r3 + r2
            int r5 = r6.h
            if (r4 >= r5) goto L1a
            char[] r4 = r6.f
            int r3 = r3 + r2
            char r3 = r4[r3]
            switch(r3) {
                case 9: goto L28;
                case 10: goto L28;
                case 12: goto L28;
                case 13: goto L28;
                case 32: goto L28;
                case 35: goto L16;
                case 44: goto L28;
                case 47: goto L16;
                case 58: goto L28;
                case 59: goto L16;
                case 61: goto L16;
                case 91: goto L28;
                case 92: goto L16;
                case 93: goto L28;
                case 123: goto L28;
                case 125: goto L28;
                default: goto L13;
            }
        L13:
            int r2 = r2 + 1
            goto L3
        L16:
            r6.J()
            goto L28
        L1a:
            char[] r3 = r6.f
            int r3 = r3.length
            if (r2 >= r3) goto L2a
            int r3 = r2 + 1
            boolean r3 = r6.m(r3)
            if (r3 == 0) goto L28
            goto L3
        L28:
            r0 = r2
            goto L44
        L2a:
            if (r1 != 0) goto L31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L31:
            char[] r3 = r6.f
            int r4 = r6.g
            r1.append(r3, r4, r2)
            int r3 = r6.g
            int r3 = r3 + r2
            r6.g = r3
            r2 = 1
            boolean r2 = r6.m(r2)
            if (r2 != 0) goto L2
        L44:
            if (r1 != 0) goto L50
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f
            int r3 = r6.g
            r1.<init>(r2, r3, r0)
            goto L5b
        L50:
            char[] r2 = r6.f
            int r3 = r6.g
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L5b:
            int r2 = r6.g
            int r2 = r2 + r0
            r6.g = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qg.F():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x009f, code lost:
        if (f(r5) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a1, code lost:
        if (r9 != 2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00a3, code lost:
        if (r10 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00a9, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ab, code lost:
        if (r13 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ad, code lost:
        if (r13 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b0, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b1, code lost:
        r18.l = r11;
        r18.g += r8;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ba, code lost:
        r18.k = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00bc, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00bd, code lost:
        if (r9 == 2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c0, code lost:
        if (r9 == 4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c3, code lost:
        if (r9 != 7) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00c6, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00c7, code lost:
        r18.m = r8;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00cc, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int G() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qg.G():int");
    }

    public final void H() throws IOException {
        do {
            int i = 0;
            while (true) {
                int i2 = this.g;
                if (i2 + i < this.h) {
                    switch (this.f[i2 + i]) {
                        case '\t':
                        case '\n':
                        case '\f':
                        case '\r':
                        case ' ':
                        case ',':
                        case ':':
                        case '[':
                        case ']':
                        case w.K0 /* 123 */:
                        case w.M0 /* 125 */:
                            break;
                        case '#':
                        case '/':
                        case ';':
                        case '=':
                        case '\\':
                            J();
                            break;
                        default:
                            i++;
                    }
                } else {
                    this.g = i2 + i;
                }
            }
            this.g += i;
            return;
        } while (m(1));
    }

    public final int I() {
        return this.i + 1;
    }

    public final void J() throws IOException {
        if (!this.d) {
            throw j("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public final int K() {
        return (this.g - this.j) + 1;
    }

    public final void L() throws IOException {
        char c;
        do {
            if (this.g >= this.h && !m(1)) {
                return;
            }
            char[] cArr = this.f;
            int i = this.g;
            int i2 = i + 1;
            this.g = i2;
            c = cArr[i];
            if (c == '\n') {
                this.i++;
                this.j = i2;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final char M() throws IOException {
        int i;
        int i2;
        if (this.g != this.h || m(1)) {
            char[] cArr = this.f;
            int i3 = this.g;
            int i4 = i3 + 1;
            this.g = i4;
            char c = cArr[i3];
            switch (c) {
                case '\n':
                    this.i++;
                    this.j = i4;
                    break;
                case 'b':
                    return '\b';
                case 'f':
                    return '\f';
                case 'n':
                    return '\n';
                case 'r':
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (i4 + 4 <= this.h || m(4)) {
                        char c2 = 0;
                        int i5 = this.g;
                        int i6 = i5 + 4;
                        while (i5 < i6) {
                            char c3 = this.f[i5];
                            char c4 = (char) (c2 << 4);
                            if (c3 < '0' || c3 > '9') {
                                if (c3 >= 'a' && c3 <= 'f') {
                                    i = c3 - 'a';
                                } else if (c3 < 'A' || c3 > 'F') {
                                    throw new NumberFormatException("\\u" + new String(this.f, this.g, 4));
                                } else {
                                    i = c3 - 'A';
                                }
                                i2 = i + 10;
                            } else {
                                i2 = c3 - '0';
                            }
                            c2 = (char) (c4 + i2);
                            i5++;
                        }
                        this.g += 4;
                        return c2;
                    }
                    throw j("Unterminated escape sequence");
            }
            return c;
        }
        throw j("Unterminated escape sequence");
    }

    public final void N() throws IOException {
        i(true);
        int i = this.g - 1;
        this.g = i;
        char[] cArr = a;
        if (i + cArr.length > this.h && !m(cArr.length)) {
            return;
        }
        int i2 = 0;
        while (true) {
            char[] cArr2 = a;
            if (i2 >= cArr2.length) {
                this.g += cArr2.length;
                return;
            } else if (this.f[this.g + i2] != cArr2[i2]) {
                return;
            } else {
                i2++;
            }
        }
    }

    public void c() throws IOException {
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        if (i == 3) {
            d(1);
            this.k = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + t() + " at line " + I() + " column " + K());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.k = 0;
        this.o[0] = 8;
        this.p = 1;
        this.b.close();
    }

    public final void d(int i) {
        int i2 = this.p;
        int[] iArr = this.o;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.o = iArr2;
        }
        int[] iArr3 = this.o;
        int i3 = this.p;
        this.p = i3 + 1;
        iArr3[i3] = i;
    }

    public final void e(boolean z) {
        this.d = z;
    }

    public final boolean f(char c) throws IOException {
        switch (c) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case w.K0 /* 123 */:
            case w.M0 /* 125 */:
                return false;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                J();
                return false;
            default:
                return true;
        }
    }

    public final boolean g(String str) throws IOException {
        while (true) {
            if (this.g + str.length() > this.h && !m(str.length())) {
                return false;
            }
            char[] cArr = this.f;
            int i = this.g;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    if (this.f[this.g + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.i++;
            this.j = i + 1;
            this.g++;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final int i(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            char[] r0 = r6.f
        L2:
            int r1 = r6.g
        L4:
            int r2 = r6.h
        L6:
            r3 = 1
            if (r1 != r2) goto L40
            r6.g = r1
            boolean r1 = r6.m(r3)
            if (r1 != 0) goto L3c
            if (r7 != 0) goto L15
            r7 = -1
            return r7
        L15:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input at line "
            r0.append(r1)
            int r1 = r6.I()
            r0.append(r1)
            java.lang.String r1 = " column "
            r0.append(r1)
            int r1 = r6.K()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L3c:
            int r1 = r6.g
            int r2 = r6.h
        L40:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L50
            int r1 = r6.i
            int r1 = r1 + r3
            r6.i = r1
            r6.j = r4
            goto Lad
        L50:
            r5 = 32
            if (r1 == r5) goto Lad
            r5 = 13
            if (r1 == r5) goto Lad
            r5 = 9
            if (r1 != r5) goto L5d
            goto Lad
        L5d:
            r5 = 47
            if (r1 != r5) goto La2
            r6.g = r4
            r5 = 2
            if (r4 != r2) goto L76
            int r4 = r4 + (-1)
            r6.g = r4
            boolean r2 = r6.m(r5)
            int r4 = r6.g
            int r4 = r4 + r3
            r6.g = r4
            if (r2 != 0) goto L76
            return r1
        L76:
            r6.J()
            int r2 = r6.g
            char r3 = r0[r2]
            switch(r3) {
                case 42: goto L8a;
                case 47: goto L81;
                default: goto L80;
            }
        L80:
            return r1
        L81:
            int r2 = r2 + 1
            r6.g = r2
        L85:
            r6.L()
            goto L2
        L8a:
            int r2 = r2 + 1
            r6.g = r2
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r6.g(r1)
            if (r1 == 0) goto L9b
            int r1 = r6.g
            int r1 = r1 + r5
            goto L4
        L9b:
            java.lang.String r7 = "Unterminated comment"
            java.io.IOException r7 = r6.j(r7)
            throw r7
        La2:
            r2 = 35
            r6.g = r4
            if (r1 != r2) goto Lac
            r6.J()
            goto L85
        Lac:
            return r1
        Lad:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qg.i(boolean):int");
    }

    public final IOException j(String str) throws IOException {
        throw new tg(str + " at line " + I() + " column " + K());
    }

    public final String k(char c) throws IOException {
        char[] cArr = this.f;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = this.g;
            int i2 = this.h;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.g = i3;
                        sb.append(cArr, i, (i3 - i) - 1);
                        return sb.toString();
                    } else if (c2 == '\\') {
                        this.g = i3;
                        sb.append(cArr, i, (i3 - i) - 1);
                        sb.append(M());
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.i++;
                            this.j = i3;
                        }
                        i = i3;
                    }
                } else {
                    sb.append(cArr, i, i - i);
                    this.g = i;
                    if (!m(1)) {
                        throw j("Unterminated string");
                    }
                }
            }
        }
    }

    public void l() throws IOException {
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        if (i == 4) {
            this.p--;
            this.k = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + t() + " at line " + I() + " column " + K());
    }

    public final boolean m(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.f;
        int i4 = this.j;
        int i5 = this.g;
        this.j = i4 - i5;
        int i6 = this.h;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.h = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.h = 0;
        }
        this.g = 0;
        do {
            Reader reader = this.b;
            int i8 = this.h;
            int read = reader.read(cArr, i8, cArr.length - i8);
            if (read == -1) {
                return false;
            }
            i2 = this.h + read;
            this.h = i2;
            if (this.i == 0 && (i3 = this.j) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.g++;
                this.j = i3 + 1;
                i++;
                continue;
            }
        } while (i2 < i);
        return true;
    }

    public void o() throws IOException {
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        if (i == 2) {
            this.p--;
            this.k = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + t() + " at line " + I() + " column " + K());
    }

    public void q() throws IOException {
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        if (i == 1) {
            d(3);
            this.k = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + t() + " at line " + I() + " column " + K());
    }

    public final void r(char c) throws IOException {
        char[] cArr = this.f;
        while (true) {
            int i = this.g;
            int i2 = this.h;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.g = i3;
                        return;
                    } else if (c2 == '\\') {
                        this.g = i3;
                        M();
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.i++;
                            this.j = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.g = i;
                    if (!m(1)) {
                        throw j("Unterminated string");
                    }
                }
            }
        }
    }

    public boolean s() throws IOException {
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public rg t() throws IOException {
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        switch (i) {
            case 1:
                return rg.BEGIN_OBJECT;
            case 2:
                return rg.END_OBJECT;
            case 3:
                return rg.BEGIN_ARRAY;
            case 4:
                return rg.END_ARRAY;
            case 5:
            case 6:
                return rg.BOOLEAN;
            case 7:
                return rg.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return rg.STRING;
            case 12:
            case 13:
            case 14:
                return rg.NAME;
            case 15:
            case 16:
                return rg.NUMBER;
            case 17:
                return rg.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + I() + " column " + K();
    }

    public String u() throws IOException {
        char c;
        String k;
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        if (i == 14) {
            k = F();
        } else {
            if (i == 12) {
                c = '\'';
            } else if (i != 13) {
                throw new IllegalStateException("Expected a name but was " + t() + " at line " + I() + " column " + K());
            } else {
                c = '\"';
            }
            k = k(c);
        }
        this.k = 0;
        return k;
    }

    public String v() throws IOException {
        String str;
        char c;
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        if (i == 10) {
            str = F();
        } else {
            if (i == 8) {
                c = '\'';
            } else if (i == 9) {
                c = '\"';
            } else if (i == 11) {
                str = this.n;
                this.n = null;
            } else if (i == 15) {
                str = Long.toString(this.l);
            } else if (i != 16) {
                throw new IllegalStateException("Expected a string but was " + t() + " at line " + I() + " column " + K());
            } else {
                str = new String(this.f, this.g, this.m);
                this.g += this.m;
            }
            str = k(c);
        }
        this.k = 0;
        return str;
    }

    public void w() throws IOException {
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        if (i == 7) {
            this.k = 0;
            return;
        }
        throw new IllegalStateException("Expected null but was " + t() + " at line " + I() + " column " + K());
    }

    public boolean x() throws IOException {
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        if (i == 5) {
            this.k = 0;
            return true;
        } else if (i == 6) {
            this.k = 0;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + t() + " at line " + I() + " column " + K());
        }
    }

    public double y() throws IOException {
        String k;
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        if (i == 15) {
            this.k = 0;
            return this.l;
        }
        if (i == 16) {
            this.n = new String(this.f, this.g, this.m);
            this.g += this.m;
        } else {
            if (i == 8 || i == 9) {
                k = k(i == 8 ? '\'' : '\"');
            } else if (i == 10) {
                k = F();
            } else if (i != 11) {
                throw new IllegalStateException("Expected a double but was " + t() + " at line " + I() + " column " + K());
            }
            this.n = k;
        }
        this.k = 11;
        double parseDouble = Double.parseDouble(this.n);
        if (this.d || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.n = null;
            this.k = 0;
            return parseDouble;
        }
        throw new tg("JSON forbids NaN and infinities: " + parseDouble + " at line " + I() + " column " + K());
    }

    public long z() throws IOException {
        int i = this.k;
        if (i == 0) {
            i = D();
        }
        if (i == 15) {
            this.k = 0;
            return this.l;
        }
        if (i == 16) {
            this.n = new String(this.f, this.g, this.m);
            this.g += this.m;
        } else if (i != 8 && i != 9) {
            throw new IllegalStateException("Expected a long but was " + t() + " at line " + I() + " column " + K());
        } else {
            String k = k(i == 8 ? '\'' : '\"');
            this.n = k;
            try {
                long parseLong = Long.parseLong(k);
                this.k = 0;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        }
        this.k = 11;
        double parseDouble = Double.parseDouble(this.n);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.n = null;
            this.k = 0;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.n + " at line " + I() + " column " + K());
    }
}
