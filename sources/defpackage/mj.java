package defpackage;

import com.alibaba.mtl.log.model.a;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import defpackage.nj;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: UploadTask.java */
/* renamed from: mj  reason: default package */
/* loaded from: classes.dex */
public abstract class mj implements Runnable {
    public static volatile boolean a = false;
    public static boolean b = false;
    public static int d = 0;
    public int f = -1;
    public float g = 200.0f;
    public int h = 0;

    public abstract void a();

    public abstract void b();

    @Override // java.lang.Runnable
    public void run() {
        try {
            c();
            a();
        } catch (Throwable th) {
        }
    }

    public static boolean k() {
        return a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x016a, code lost:
        defpackage.xj.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01e9, code lost:
        defpackage.mj.a = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instructions count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mj.c():void");
    }

    public final int i(List<a> list) {
        if (list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2).T;
            if (str != null && "6005".equalsIgnoreCase(str.toString())) {
                i++;
            }
        }
        return i;
    }

    public final int j() {
        if (this.f == -1) {
            String i = yj.i();
            if ("wifi".equalsIgnoreCase(i)) {
                this.f = 20;
            } else if ("4G".equalsIgnoreCase(i)) {
                this.f = 16;
            } else if ("3G".equalsIgnoreCase(i)) {
                this.f = 12;
            } else {
                this.f = 8;
            }
        }
        return this.f;
    }

    public final nj.a e(String str, Map<String, Object> map) {
        if (str != null) {
            byte[] bArr = rj.a(2, str, map, false).b;
            vj.c("UploadTask", "url:", str);
            if (bArr != null) {
                String str2 = null;
                try {
                    str2 = new String(bArr, XmartV1Constants.UTF8_ENCODING);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (str2 != null) {
                    vj.c("UploadTask", "result:", str2);
                    return nj.a(str2);
                }
            }
        }
        return nj.a.a;
    }

    public final int d(Boolean bool, long j) {
        if (j < 0) {
            return this.f;
        }
        float f = this.h / ((float) j);
        if (bool.booleanValue()) {
            if (j > 45000) {
                return this.f;
            }
            this.f = (int) (((f * 45000.0f) / this.g) - d);
        } else {
            this.f /= 2;
            d++;
        }
        int i = this.f;
        if (i < 1) {
            this.f = 1;
            d = 0;
        } else if (i > 350) {
            this.f = 350;
        }
        vj.c("UploadTask", "winsize:", Integer.valueOf(this.f));
        return this.f;
    }

    public final Map<String, Object> g(List<a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            List<String> f = f(list.get(i));
            if (f != null) {
                for (int i2 = 0; i2 < f.size(); i2++) {
                    StringBuilder sb = (StringBuilder) hashMap.get(f.get(i2));
                    if (sb == null) {
                        sb = new StringBuilder();
                        hashMap.put(f.get(i2), sb);
                    } else {
                        sb.append("\n");
                    }
                    sb.append(list.get(i).k());
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        this.h = 0;
        for (String str : hashMap.keySet()) {
            byte[] h = h(((StringBuilder) hashMap.get(str)).toString());
            hashMap2.put(str, h);
            this.h += h.length;
        }
        float size = this.h / list.size();
        this.g = size;
        vj.c("UploadTask", "averagePackageSize:", Float.valueOf(size));
        return hashMap2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:2|(2:3|4))|(3:6|7|8)|9|10|11|12|13|(1:(0))) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] h(java.lang.String r4) {
        /*
            r3 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L25
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L25
            java.lang.String r1 = "UTF-8"
            byte[] r4 = r4.getBytes(r1)     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L20
            r2.write(r4)     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L20
            r2.flush()     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L20
            r2.close()     // Catch: java.lang.Exception -> L2f
            goto L2e
        L1d:
            r4 = move-exception
            r1 = r2
            goto L41
        L20:
            r4 = move-exception
            r1 = r2
            goto L26
        L23:
            r4 = move-exception
            goto L41
        L25:
            r4 = move-exception
        L26:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L23
            if (r1 == 0) goto L31
            r1.close()     // Catch: java.lang.Exception -> L2f
        L2e:
            goto L31
        L2f:
            r4 = move-exception
            goto L2e
        L31:
            byte[] r4 = r0.toByteArray()
            java.lang.String r1 = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK"
            byte[] r4 = defpackage.ak.c(r4, r1)
            r0.close()     // Catch: java.lang.Exception -> L3f
            goto L40
        L3f:
            r0 = move-exception
        L40:
            return r4
        L41:
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Exception -> L47
            goto L48
        L47:
            r0 = move-exception
        L48:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mj.h(java.lang.String):byte[]");
    }

    public final List<String> f(a aVar) {
        return zi.c(aVar.T);
    }
}
