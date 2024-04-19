package defpackage;

import java.util.Arrays;
import java.util.HashSet;
/* compiled from: SolverVariable.java */
/* renamed from: j4  reason: default package */
/* loaded from: classes.dex */
public class j4 implements Comparable<j4> {
    public static int a = 1;
    public static int b = 1;
    public static int d = 1;
    public static int f = 1;
    public static int g = 1;
    public boolean h;
    public String i;
    public float m;
    public a q;
    public int j = -1;
    public int k = -1;
    public int l = 0;
    public boolean n = false;
    public float[] o = new float[9];
    public float[] p = new float[9];
    public c4[] r = new c4[16];
    public int s = 0;
    public int t = 0;
    public boolean u = false;
    public int v = -1;
    public float w = 0.0f;
    public HashSet<c4> x = null;

    /* compiled from: SolverVariable.java */
    /* renamed from: j4$a */
    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public static void c() {
        b++;
    }

    public j4(a type, String prefix) {
        this.q = type;
    }

    public final void a(c4 row) {
        int i = 0;
        while (true) {
            int i2 = this.s;
            if (i < i2) {
                if (this.r[i] != row) {
                    i++;
                } else {
                    return;
                }
            } else {
                c4[] c4VarArr = this.r;
                if (i2 >= c4VarArr.length) {
                    this.r = (c4[]) Arrays.copyOf(c4VarArr, c4VarArr.length * 2);
                }
                c4[] c4VarArr2 = this.r;
                int i3 = this.s;
                c4VarArr2[i3] = row;
                this.s = i3 + 1;
                return;
            }
        }
    }

    public final void d(c4 row) {
        int count = this.s;
        for (int i = 0; i < count; i++) {
            if (this.r[i] == row) {
                for (int j = i; j < count - 1; j++) {
                    c4[] c4VarArr = this.r;
                    c4VarArr[j] = c4VarArr[j + 1];
                }
                int j2 = this.s;
                this.s = j2 - 1;
                return;
            }
        }
    }

    public final void h(e4 system, c4 definition) {
        int count = this.s;
        for (int i = 0; i < count; i++) {
            this.r[i].B(system, definition, false);
        }
        this.s = 0;
    }

    public void f(e4 system, float value) {
        this.m = value;
        this.n = true;
        this.u = false;
        this.v = -1;
        this.w = 0.0f;
        int count = this.s;
        this.k = -1;
        for (int i = 0; i < count; i++) {
            this.r[i].A(system, this, false);
        }
        this.s = 0;
    }

    public void e() {
        this.i = null;
        this.q = a.UNKNOWN;
        this.l = 0;
        this.j = -1;
        this.k = -1;
        this.m = 0.0f;
        this.n = false;
        this.u = false;
        this.v = -1;
        this.w = 0.0f;
        int count = this.s;
        for (int i = 0; i < count; i++) {
            this.r[i] = null;
        }
        this.s = 0;
        this.t = 0;
        this.h = false;
        Arrays.fill(this.p, 0.0f);
    }

    public void g(a type, String prefix) {
        this.q = type;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(j4 v) {
        return this.j - v.j;
    }

    public String toString() {
        if (this.i != null) {
            String result = "" + this.i;
            return result;
        }
        String result2 = "" + this.j;
        return result2;
    }
}
