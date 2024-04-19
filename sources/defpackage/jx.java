package defpackage;
/* compiled from: SimpleBase64Encoder.java */
/* renamed from: jx  reason: default package */
/* loaded from: classes.dex */
public class jx {
    public static final char[] a = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String b(byte[] bytes) {
        int len = bytes.length;
        StringBuffer encoded = new StringBuffer(((len + 2) / 3) * 4);
        int i = 0;
        int j = len;
        while (j >= 3) {
            encoded.append(d(((bytes[i] & 255) << 16) | ((bytes[i + 1] & 255) << 8) | (bytes[i + 2] & 255), 4));
            i += 3;
            j -= 3;
        }
        if (j == 2) {
            encoded.append(d(((bytes[i] & 255) << 8) | (bytes[i + 1] & 255), 3));
        }
        if (j == 1) {
            encoded.append(d(bytes[i] & 255, 2));
        }
        return encoded.toString();
    }

    public static byte[] a(String string) {
        byte[] encoded = string.getBytes();
        int len = encoded.length;
        byte[] decoded = new byte[(len * 3) / 4];
        int i = 0;
        int j = len;
        int k = 0;
        while (j >= 4) {
            long d = c(encoded, i, 4);
            j -= 4;
            i += 4;
            for (int l = 2; l >= 0; l--) {
                decoded[k + l] = (byte) (d & 255);
                d >>= 8;
            }
            k += 3;
        }
        if (j == 3) {
            long d2 = c(encoded, i, 3);
            for (int l2 = 1; l2 >= 0; l2--) {
                decoded[k + l2] = (byte) (d2 & 255);
                d2 >>= 8;
            }
        }
        if (j == 2) {
            long d3 = c(encoded, i, 2);
            decoded[k] = (byte) (d3 & 255);
        }
        return decoded;
    }

    public static final String d(long input, int size) {
        StringBuffer result = new StringBuffer(size);
        while (size > 0) {
            size--;
            result.append(a[(int) (63 & input)]);
            input >>= 6;
        }
        return result.toString();
    }

    public static final long c(byte[] encoded, int idx, int size) {
        long res = 0;
        int f = 0;
        while (size > 0) {
            size--;
            long r = 0;
            int idx2 = idx + 1;
            byte d = encoded[idx];
            if (d == 47) {
                r = 1;
            }
            if (d >= 48 && d <= 57) {
                r = (d + 2) - 48;
            }
            if (d >= 65 && d <= 90) {
                r = (d + 12) - 65;
            }
            if (d >= 97 && d <= 122) {
                r = (d + 38) - 97;
            }
            res += r << f;
            f += 6;
            idx = idx2;
        }
        return res;
    }
}
