package defpackage;

import java.io.UnsupportedEncodingException;
/* compiled from: Base64.java */
/* renamed from: pj  reason: default package */
/* loaded from: classes.dex */
public class pj {
    public static final /* synthetic */ boolean a = true;

    /* compiled from: Base64.java */
    /* renamed from: pj$a */
    /* loaded from: classes.dex */
    public static abstract class a {
        public byte[] a;
        public int b;
    }

    public static byte[] a(byte[] input, int flags) {
        return b(input, 0, input.length, flags);
    }

    public static byte[] b(byte[] input, int offset, int len, int flags) {
        b bVar = new b(flags, new byte[(len * 3) / 4]);
        if (!bVar.a(input, offset, len, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i = bVar.b;
        byte[] bArr = bVar.a;
        if (i == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    /* compiled from: Base64.java */
    /* renamed from: pj$b */
    /* loaded from: classes.dex */
    public static class b extends a {
        public static final int[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public int e;
        public int f;
        public final int[] g;

        public b(int i, byte[] bArr) {
            this.a = bArr;
            this.g = (i & 8) == 0 ? c : d;
            this.e = 0;
            this.f = 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00f0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(byte[] r15, int r16, int r17, boolean r18) {
            /*
                Method dump skipped, instructions count: 310
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.pj.b.a(byte[], int, int, boolean):boolean");
        }
    }

    public static String e(byte[] input, int flags) {
        try {
            return new String(c(input, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] c(byte[] input, int flags) {
        return d(input, 0, input.length, flags);
    }

    public static byte[] d(byte[] input, int offset, int len, int flags) {
        c cVar = new c(flags, null);
        int i = (len / 3) * 4;
        if (cVar.i) {
            if (len % 3 > 0) {
                i += 4;
            }
        } else {
            switch (len % 3) {
                case 1:
                    i += 2;
                    break;
                case 2:
                    i += 3;
                    break;
            }
        }
        if (cVar.j && len > 0) {
            i += (((len - 1) / 57) + 1) * (cVar.k ? 2 : 1);
        }
        cVar.a = new byte[i];
        cVar.a(input, offset, len, true);
        if (a || cVar.b == i) {
            return cVar.a;
        }
        throw new AssertionError();
    }

    /* compiled from: Base64.java */
    /* renamed from: pj$c */
    /* loaded from: classes.dex */
    public static class c extends a {
        public final byte[] f;
        public int g;
        public int h;
        public final boolean i;
        public final boolean j;
        public final boolean k;
        public final byte[] l;
        public static final /* synthetic */ boolean e = true;
        public static final byte[] c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        public static final byte[] d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        public c(int i, byte[] bArr) {
            this.a = bArr;
            this.i = (i & 1) == 0;
            boolean z = (i & 2) == 0;
            this.j = z;
            this.k = (i & 4) != 0;
            this.l = (i & 8) == 0 ? c : d;
            this.f = new byte[2];
            this.g = 0;
            this.h = z ? 19 : -1;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public boolean a(byte[] input, int offset, int len, boolean finish) {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            byte b;
            int i6;
            int i7;
            byte b2;
            int i8;
            int i9;
            byte b3;
            int i10;
            byte[] bArr = this.l;
            byte[] bArr2 = this.a;
            int i11 = this.h;
            int len2 = len + offset;
            switch (this.g) {
                case 0:
                default:
                    i = offset;
                    i2 = -1;
                    break;
                case 1:
                    if (offset + 2 <= len2) {
                        int i12 = offset + 1;
                        i2 = ((this.f[0] & 255) << 16) | ((input[offset] & 255) << 8) | (input[i12] & 255);
                        this.g = 0;
                        i = i12 + 1;
                        break;
                    }
                    i = offset;
                    i2 = -1;
                    break;
                case 2:
                    if (offset + 1 <= len2) {
                        byte[] bArr3 = this.f;
                        i = offset + 1;
                        i2 = ((bArr3[1] & 255) << 8) | ((bArr3[0] & 255) << 16) | (input[offset] & 255);
                        this.g = 0;
                        break;
                    }
                    i = offset;
                    i2 = -1;
                    break;
            }
            if (i2 == -1) {
                i3 = 0;
            } else {
                bArr2[0] = bArr[(i2 >> 18) & 63];
                bArr2[1] = bArr[(i2 >> 12) & 63];
                bArr2[2] = bArr[(i2 >> 6) & 63];
                bArr2[3] = bArr[i2 & 63];
                i11--;
                if (i11 != 0) {
                    i3 = 4;
                } else {
                    if (this.k) {
                        i10 = 5;
                        bArr2[4] = 13;
                    } else {
                        i10 = 4;
                    }
                    i3 = i10 + 1;
                    bArr2[i10] = 10;
                    i11 = 19;
                }
            }
            while (true) {
                int i13 = i + 3;
                if (i13 <= len2) {
                    int i14 = (input[i + 2] & 255) | ((input[i + 1] & 255) << 8) | ((input[i] & 255) << 16);
                    bArr2[i3] = bArr[(i14 >> 18) & 63];
                    bArr2[i3 + 1] = bArr[(i14 >> 12) & 63];
                    bArr2[i3 + 2] = bArr[(i14 >> 6) & 63];
                    bArr2[i3 + 3] = bArr[i14 & 63];
                    i3 += 4;
                    i11--;
                    if (i11 != 0) {
                        i = i13;
                    } else {
                        if (this.k) {
                            bArr2[i3] = 13;
                            i3++;
                        }
                        bArr2[i3] = 10;
                        i3++;
                        i = i13;
                        i11 = 19;
                    }
                } else {
                    if (finish) {
                        int i15 = this.g;
                        if (i - i15 == len2 - 1) {
                            if (i15 > 0) {
                                b3 = this.f[0];
                                i8 = i;
                                i9 = 1;
                            } else {
                                i8 = i + 1;
                                byte b4 = input[i];
                                i9 = 0;
                                b3 = b4;
                            }
                            int i16 = (b3 & 255) << 4;
                            this.g = i15 - i9;
                            int i17 = i3 + 1;
                            bArr2[i3] = bArr[(i16 >> 6) & 63];
                            i3 = i17 + 1;
                            bArr2[i17] = bArr[i16 & 63];
                            if (this.i) {
                                int i18 = i3 + 1;
                                bArr2[i3] = 61;
                                i3 = i18 + 1;
                                bArr2[i18] = 61;
                            }
                            if (this.j) {
                                if (this.k) {
                                    bArr2[i3] = 13;
                                    i3++;
                                }
                                bArr2[i3] = 10;
                                i3++;
                            }
                            i = i8;
                        } else if (i - i15 != len2 - 2) {
                            if (this.j && i3 > 0 && i11 != 19) {
                                if (this.k) {
                                    bArr2[i3] = 13;
                                    i3++;
                                }
                                bArr2[i3] = 10;
                                i3++;
                            }
                        } else {
                            if (i15 > 1) {
                                b = this.f[0];
                                i4 = i;
                                i5 = 1;
                            } else {
                                i4 = i + 1;
                                byte b5 = input[i];
                                i5 = 0;
                                b = b5;
                            }
                            int i19 = (b & 255) << 10;
                            if (i15 > 0) {
                                i7 = i5 + 1;
                                b2 = this.f[i5];
                                i6 = i4;
                            } else {
                                i6 = i4 + 1;
                                i7 = i5;
                                b2 = input[i4];
                            }
                            int i20 = i19 | ((b2 & 255) << 2);
                            this.g = i15 - i7;
                            int i21 = i3 + 1;
                            bArr2[i3] = bArr[(i20 >> 12) & 63];
                            int i22 = i21 + 1;
                            bArr2[i21] = bArr[(i20 >> 6) & 63];
                            int i23 = i22 + 1;
                            bArr2[i22] = bArr[i20 & 63];
                            if (this.i) {
                                bArr2[i23] = 61;
                                i23++;
                            }
                            if (this.j) {
                                if (this.k) {
                                    bArr2[i23] = 13;
                                    i23++;
                                }
                                bArr2[i23] = 10;
                                i23++;
                            }
                            i3 = i23;
                            i = i6;
                        }
                        boolean z = e;
                        if (!z && this.g != 0) {
                            throw new AssertionError();
                        }
                        if (!z && i != len2) {
                            throw new AssertionError();
                        }
                    } else if (i == len2 - 1) {
                        byte[] bArr4 = this.f;
                        int i24 = this.g;
                        this.g = i24 + 1;
                        bArr4[i24] = input[i];
                    } else if (i == len2 - 2) {
                        byte[] bArr5 = this.f;
                        int i25 = this.g;
                        int i26 = i25 + 1;
                        this.g = i26;
                        bArr5[i25] = input[i];
                        this.g = i26 + 1;
                        bArr5[i26] = input[i + 1];
                    }
                    this.b = i3;
                    this.h = i11;
                    return true;
                }
            }
        }
    }
}
