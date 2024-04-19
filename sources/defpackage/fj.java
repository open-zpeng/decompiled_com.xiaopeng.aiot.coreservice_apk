package defpackage;

import android.text.TextUtils;
import com.alibaba.mtl.log.model.a;
import com.xiaopeng.base.log.LogUtils;
import java.util.List;
/* compiled from: CoreStatics.java */
/* renamed from: fj  reason: default package */
/* loaded from: classes.dex */
public class fj {
    public static volatile long a;
    public static long b;
    public static long c;
    public static int d;
    public static long e;
    public static long f;
    public static long g = 0;
    public static long h = 0;
    public static long i = 0;
    public static long j = 0;
    public static int k = 0;
    public static int l = 0;
    public static long m = 0;
    public static long n = 0;
    public static long o = 0;
    public static long p = 0;
    public static long q = 0;
    public static long r = 0;
    public static long s = 0;
    public static long t = 0;
    public static long u = 0;
    public static long v = 0;
    public static long w = 0;
    public static long x = 0;
    public static StringBuilder y = new StringBuilder();

    public static synchronized void i(String str) {
        synchronized (fj.class) {
            if (h(str)) {
                return;
            }
            if ("65501".equalsIgnoreCase(str)) {
                x++;
            } else if ("65133".equalsIgnoreCase(str)) {
                v++;
            } else if ("65502".equalsIgnoreCase(str)) {
                w++;
            } else if ("65503".equalsIgnoreCase(str)) {
                u++;
            }
            a++;
        }
    }

    public static synchronized void j(String str) {
        synchronized (fj.class) {
            if (h(str)) {
                return;
            }
            b++;
            c();
        }
    }

    public static synchronized void e(List<a> list, int i2) {
        synchronized (fj.class) {
            if (list == null) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                a aVar = list.get(i4);
                if (aVar != null) {
                    if (!"6005".equalsIgnoreCase(aVar.T)) {
                        i3++;
                    }
                    y.append(aVar.X);
                    if (i4 != list.size() - 1) {
                        y.append(LogUtils.SEPARATOR);
                    }
                }
            }
            vj.c("CoreStatics", "[uploadInc]:", Long.valueOf(c), "count:", Integer.valueOf(i2));
            long j2 = c + i2;
            c = j2;
            vj.c("CoreStatics", "[uploadInc]:", Long.valueOf(j2));
            if (i3 != i2) {
                vj.a("CoreStatics", "Mutil Process Upload Error");
            }
        }
    }

    public static synchronized void g(int i2) {
        synchronized (fj.class) {
            d += i2;
        }
    }

    public static synchronized void k() {
        synchronized (fj.class) {
            e++;
        }
    }

    public static synchronized void l() {
        synchronized (fj.class) {
            f++;
        }
    }

    public static synchronized void m() {
        synchronized (fj.class) {
            m++;
        }
    }

    public static synchronized void n() {
        synchronized (fj.class) {
            n++;
        }
    }

    public static synchronized void o() {
        synchronized (fj.class) {
            o++;
        }
    }

    public static synchronized void p() {
        synchronized (fj.class) {
            p++;
        }
    }

    public static synchronized void q() {
        synchronized (fj.class) {
            q++;
        }
    }

    public static synchronized void r() {
        synchronized (fj.class) {
            r++;
        }
    }

    public static synchronized void a() {
        synchronized (fj.class) {
            s++;
        }
    }

    public static synchronized void b() {
        synchronized (fj.class) {
            t++;
        }
    }

    public static synchronized void f(boolean z) {
        synchronized (fj.class) {
        }
    }

    public static void c() {
        String i2 = yj.i();
        if ("wifi".equalsIgnoreCase(i2)) {
            j++;
        } else if ("3G".equalsIgnoreCase(i2)) {
            h++;
        } else if ("4G".equalsIgnoreCase(i2)) {
            i++;
        } else if ("2G".equalsIgnoreCase(i2)) {
            g++;
        } else {
            k++;
        }
    }

    public static synchronized void d() {
        synchronized (fj.class) {
            l++;
            if (a == 0 && c == 0) {
                return;
            }
            if (ej.c || l >= 6) {
                f(true);
            }
        }
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "6005".equalsIgnoreCase(str.trim());
    }
}
