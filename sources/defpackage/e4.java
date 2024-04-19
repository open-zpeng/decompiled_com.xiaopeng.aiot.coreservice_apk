package defpackage;

import defpackage.j4;
import defpackage.w4;
import java.util.Arrays;
import java.util.HashMap;
/* compiled from: LinearSystem.java */
/* renamed from: e4  reason: default package */
/* loaded from: classes.dex */
public class e4 {
    public static f4 h;
    public a A;
    public a n;
    public c4[] q;
    public final d4 x;
    public static boolean a = false;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = true;
    public static boolean f = false;
    public static int g = 1000;
    public static long i = 0;
    public static long j = 0;
    public boolean k = false;
    public int l = 0;
    public HashMap<String, j4> m = null;
    public int o = 32;
    public int p = 32;
    public boolean r = false;
    public boolean s = false;
    public boolean[] t = new boolean[32];
    public int u = 1;
    public int v = 0;
    public int w = 32;
    public j4[] y = new j4[g];
    public int z = 0;

    /* compiled from: LinearSystem.java */
    /* renamed from: e4$a */
    /* loaded from: classes.dex */
    public interface a {
        j4 a(e4 e4Var, boolean[] zArr);

        void b(j4 j4Var);

        void c(a aVar);

        void clear();

        j4 getKey();

        boolean isEmpty();
    }

    /* compiled from: LinearSystem.java */
    /* renamed from: e4$b */
    /* loaded from: classes.dex */
    public class b extends c4 {
        public b(d4 cache) {
            this.e = new k4(this, cache);
        }
    }

    public e4() {
        this.q = null;
        this.q = new c4[32];
        C();
        d4 d4Var = new d4();
        this.x = d4Var;
        this.n = new i4(d4Var);
        if (f) {
            this.A = new b(d4Var);
        } else {
            this.A = new c4(d4Var);
        }
    }

    public static f4 w() {
        return h;
    }

    public final void y() {
        int i2 = this.o * 2;
        this.o = i2;
        this.q = (c4[]) Arrays.copyOf(this.q, i2);
        d4 d4Var = this.x;
        d4Var.d = (j4[]) Arrays.copyOf(d4Var.d, this.o);
        int i3 = this.o;
        this.t = new boolean[i3];
        this.p = i3;
        this.w = i3;
        if (h != null) {
            throw null;
        }
    }

    public final void C() {
        if (f) {
            for (int i2 = 0; i2 < this.v; i2++) {
                c4 row = this.q[i2];
                if (row != null) {
                    this.x.a.a(row);
                }
                this.q[i2] = null;
            }
            return;
        }
        for (int i3 = 0; i3 < this.v; i3++) {
            c4 row2 = this.q[i3];
            if (row2 != null) {
                this.x.b.a(row2);
            }
            this.q[i3] = null;
        }
    }

    public void D() {
        d4 d4Var;
        int i2 = 0;
        while (true) {
            d4Var = this.x;
            j4[] j4VarArr = d4Var.d;
            if (i2 >= j4VarArr.length) {
                break;
            }
            j4 variable = j4VarArr[i2];
            if (variable != null) {
                variable.e();
            }
            i2++;
        }
        d4Var.c.c(this.y, this.z);
        this.z = 0;
        Arrays.fill(this.x.d, (Object) null);
        HashMap<String, j4> hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.l = 0;
        this.n.clear();
        this.u = 1;
        for (int i3 = 0; i3 < this.v; i3++) {
            c4[] c4VarArr = this.q;
            if (c4VarArr[i3] != null) {
                c4VarArr[i3].c = false;
            }
        }
        C();
        this.v = 0;
        if (f) {
            this.A = new b(this.x);
        } else {
            this.A = new c4(this.x);
        }
    }

    public j4 q(Object anchor) {
        if (anchor == null) {
            return null;
        }
        if (this.u + 1 >= this.p) {
            y();
        }
        j4 variable = null;
        if (anchor instanceof w4) {
            variable = ((w4) anchor).i();
            if (variable == null) {
                ((w4) anchor).s(this.x);
                variable = ((w4) anchor).i();
            }
            int i2 = variable.j;
            if (i2 == -1 || i2 > this.l || this.x.d[i2] == null) {
                if (i2 != -1) {
                    variable.e();
                }
                int i3 = this.l + 1;
                this.l = i3;
                this.u++;
                variable.j = i3;
                variable.q = j4.a.UNRESTRICTED;
                this.x.d[i3] = variable;
            }
        }
        return variable;
    }

    public c4 r() {
        c4 row;
        if (f) {
            row = this.x.a.b();
            if (row == null) {
                row = new b(this.x);
                j++;
            } else {
                row.y();
            }
        } else {
            row = this.x.b.b();
            if (row == null) {
                row = new c4(this.x);
                i++;
            } else {
                row.y();
            }
        }
        j4.c();
        return row;
    }

    public j4 t() {
        if (h != null) {
            throw null;
        }
        if (this.u + 1 >= this.p) {
            y();
        }
        j4 variable = a(j4.a.SLACK, null);
        int i2 = this.l + 1;
        this.l = i2;
        this.u++;
        variable.j = i2;
        this.x.d[i2] = variable;
        return variable;
    }

    public j4 p() {
        if (h != null) {
            throw null;
        }
        if (this.u + 1 >= this.p) {
            y();
        }
        j4 variable = a(j4.a.SLACK, null);
        int i2 = this.l + 1;
        this.l = i2;
        this.u++;
        variable.j = i2;
        this.x.d[i2] = variable;
        return variable;
    }

    public void m(c4 row, int sign, int strength) {
        j4 error = o(strength, null);
        row.e(error, sign);
    }

    public j4 o(int strength, String prefix) {
        if (h != null) {
            throw null;
        }
        if (this.u + 1 >= this.p) {
            y();
        }
        j4 variable = a(j4.a.ERROR, prefix);
        int i2 = this.l + 1;
        this.l = i2;
        this.u++;
        variable.j = i2;
        variable.l = strength;
        this.x.d[i2] = variable;
        this.n.b(variable);
        return variable;
    }

    public final j4 a(j4.a type, String prefix) {
        j4 variable = this.x.c.b();
        if (variable == null) {
            variable = new j4(type, prefix);
            variable.g(type, prefix);
        } else {
            variable.e();
            variable.g(type, prefix);
        }
        int i2 = this.z;
        int i3 = g;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            g = i4;
            this.y = (j4[]) Arrays.copyOf(this.y, i4);
        }
        j4[] j4VarArr = this.y;
        int i5 = this.z;
        this.z = i5 + 1;
        j4VarArr[i5] = variable;
        return variable;
    }

    public int x(Object object) {
        w4 anchor = (w4) object;
        j4 variable = anchor.i();
        if (variable != null) {
            return (int) (variable.m + 0.5f);
        }
        return 0;
    }

    public void z() throws Exception {
        if (h != null) {
            throw null;
        }
        if (this.n.isEmpty()) {
            n();
        } else if (this.r || this.s) {
            if (h != null) {
                throw null;
            }
            boolean fullySolved = true;
            int i2 = 0;
            while (true) {
                if (i2 >= this.v) {
                    break;
                }
                c4 r = this.q[i2];
                if (r.f) {
                    i2++;
                } else {
                    fullySolved = false;
                    break;
                }
            }
            if (!fullySolved) {
                A(this.n);
            } else if (h != null) {
                throw null;
            } else {
                n();
            }
        } else {
            A(this.n);
        }
    }

    public void A(a goal) throws Exception {
        if (h != null) {
            throw null;
        }
        u(goal);
        B(goal, false);
        n();
    }

    public void d(c4 row) {
        j4 pivotCandidate;
        if (row == null) {
            return;
        }
        if (h != null) {
            throw null;
        }
        if (this.v + 1 >= this.w || this.u + 1 >= this.p) {
            y();
        }
        boolean added = false;
        if (!row.f) {
            row.D(this);
            if (row.isEmpty()) {
                return;
            }
            row.r();
            if (row.f(this)) {
                j4 extra = p();
                row.a = extra;
                int numRows = this.v;
                l(row);
                if (this.v == numRows + 1) {
                    added = true;
                    this.A.c(row);
                    B(this.A, true);
                    if (extra.k == -1) {
                        if (row.a == extra && (pivotCandidate = row.v(extra)) != null) {
                            if (h != null) {
                                throw null;
                            }
                            row.x(pivotCandidate);
                        }
                        if (!row.f) {
                            row.a.h(this, row);
                        }
                        if (f) {
                            this.x.a.a(row);
                        } else {
                            this.x.b.a(row);
                        }
                        this.v--;
                    }
                }
            }
            if (!row.s()) {
                return;
            }
        }
        if (!added) {
            l(row);
        }
    }

    public final void l(c4 row) {
        int i2;
        if (c && row.f) {
            row.a.f(this, row.b);
        } else {
            c4[] c4VarArr = this.q;
            int i3 = this.v;
            c4VarArr[i3] = row;
            j4 j4Var = row.a;
            j4Var.k = i3;
            this.v = i3 + 1;
            j4Var.h(this, row);
        }
        if (c && this.k) {
            int i4 = 0;
            while (i4 < this.v) {
                if (this.q[i4] == null) {
                    System.out.println("WTF");
                }
                c4[] c4VarArr2 = this.q;
                if (c4VarArr2[i4] != null && c4VarArr2[i4].f) {
                    c4 removedRow = c4VarArr2[i4];
                    removedRow.a.f(this, removedRow.b);
                    if (f) {
                        this.x.a.a(removedRow);
                    } else {
                        this.x.b.a(removedRow);
                    }
                    this.q[i4] = null;
                    int lastRow = i4 + 1;
                    int j2 = i4 + 1;
                    while (true) {
                        i2 = this.v;
                        if (j2 >= i2) {
                            break;
                        }
                        c4[] c4VarArr3 = this.q;
                        c4VarArr3[j2 - 1] = c4VarArr3[j2];
                        if (c4VarArr3[j2 - 1].a.k == j2) {
                            c4VarArr3[j2 - 1].a.k = j2 - 1;
                        }
                        lastRow = j2;
                        j2++;
                    }
                    if (lastRow < i2) {
                        this.q[lastRow] = null;
                    }
                    this.v = i2 - 1;
                    i4--;
                }
                i4++;
            }
            this.k = false;
        }
    }

    public final int B(a goal, boolean b2) {
        if (h != null) {
            throw null;
        }
        boolean done = false;
        int tries = 0;
        for (int i2 = 0; i2 < this.u; i2++) {
            this.t[i2] = false;
        }
        while (!done) {
            if (h != null) {
                throw null;
            }
            tries++;
            if (tries >= this.u * 2) {
                return tries;
            }
            if (goal.getKey() != null) {
                this.t[goal.getKey().j] = true;
            }
            j4 pivotCandidate = goal.a(this, this.t);
            if (pivotCandidate != null) {
                boolean[] zArr = this.t;
                int i3 = pivotCandidate.j;
                if (zArr[i3]) {
                    return tries;
                }
                zArr[i3] = true;
            }
            if (pivotCandidate != null) {
                float min = Float.MAX_VALUE;
                int pivotRowIndex = -1;
                for (int i4 = 0; i4 < this.v; i4++) {
                    c4 current = this.q[i4];
                    j4 variable = current.a;
                    if (variable.q != j4.a.UNRESTRICTED && !current.f && current.t(pivotCandidate)) {
                        float a_j = current.e.d(pivotCandidate);
                        if (a_j < 0.0f) {
                            float value = (-current.b) / a_j;
                            if (value < min) {
                                min = value;
                                pivotRowIndex = i4;
                            }
                        }
                    }
                }
                if (pivotRowIndex > -1) {
                    c4 pivotEquation = this.q[pivotRowIndex];
                    pivotEquation.a.k = -1;
                    if (h != null) {
                        throw null;
                    }
                    pivotEquation.x(pivotCandidate);
                    j4 j4Var = pivotEquation.a;
                    j4Var.k = pivotRowIndex;
                    j4Var.h(this, pivotEquation);
                } else {
                    continue;
                }
            } else {
                done = true;
            }
        }
        return tries;
    }

    public final int u(a goal) throws Exception {
        float f2;
        boolean infeasibleSystem;
        boolean infeasibleSystem2;
        int tries = 0;
        boolean infeasibleSystem3 = false;
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= this.v) {
                break;
            }
            c4[] c4VarArr = this.q;
            j4 variable = c4VarArr[i2].a;
            if (variable.q == j4.a.UNRESTRICTED || c4VarArr[i2].b >= 0.0f) {
                i2++;
            } else {
                infeasibleSystem3 = true;
                break;
            }
        }
        if (infeasibleSystem3) {
            boolean done = false;
            tries = 0;
            while (!done) {
                if (h != null) {
                    throw null;
                }
                tries++;
                float min = Float.MAX_VALUE;
                int strength = 0;
                int pivotRowIndex = -1;
                int pivotColumnIndex = -1;
                int i3 = 0;
                while (i3 < this.v) {
                    c4 current = this.q[i3];
                    j4 variable2 = current.a;
                    if (variable2.q == j4.a.UNRESTRICTED) {
                        infeasibleSystem = infeasibleSystem3;
                    } else if (current.f) {
                        infeasibleSystem = infeasibleSystem3;
                    } else if (current.b >= f2) {
                        infeasibleSystem = infeasibleSystem3;
                    } else if (e) {
                        int size = current.e.c();
                        int j2 = 0;
                        while (j2 < size) {
                            j4 candidate = current.e.h(j2);
                            float a_j = current.e.d(candidate);
                            if (a_j <= f2) {
                                infeasibleSystem2 = infeasibleSystem3;
                            } else {
                                int k = 0;
                                while (true) {
                                    infeasibleSystem2 = infeasibleSystem3;
                                    if (k < 9) {
                                        float value = candidate.o[k] / a_j;
                                        if ((value < min && k == strength) || k > strength) {
                                            min = value;
                                            pivotRowIndex = i3;
                                            pivotColumnIndex = candidate.j;
                                            strength = k;
                                        }
                                        k++;
                                        infeasibleSystem3 = infeasibleSystem2;
                                    }
                                }
                            }
                            j2++;
                            infeasibleSystem3 = infeasibleSystem2;
                            f2 = 0.0f;
                        }
                        infeasibleSystem = infeasibleSystem3;
                    } else {
                        infeasibleSystem = infeasibleSystem3;
                        for (int j3 = 1; j3 < this.u; j3++) {
                            j4 candidate2 = this.x.d[j3];
                            float a_j2 = current.e.d(candidate2);
                            if (a_j2 > 0.0f) {
                                for (int k2 = 0; k2 < 9; k2++) {
                                    float value2 = candidate2.o[k2] / a_j2;
                                    if ((value2 < min && k2 == strength) || k2 > strength) {
                                        min = value2;
                                        pivotRowIndex = i3;
                                        pivotColumnIndex = j3;
                                        strength = k2;
                                    }
                                }
                            }
                        }
                    }
                    i3++;
                    infeasibleSystem3 = infeasibleSystem;
                    f2 = 0.0f;
                }
                boolean infeasibleSystem4 = infeasibleSystem3;
                if (pivotRowIndex != -1) {
                    c4 pivotEquation = this.q[pivotRowIndex];
                    pivotEquation.a.k = -1;
                    if (h != null) {
                        throw null;
                    }
                    pivotEquation.x(this.x.d[pivotColumnIndex]);
                    j4 j4Var = pivotEquation.a;
                    j4Var.k = pivotRowIndex;
                    j4Var.h(this, pivotEquation);
                } else {
                    done = true;
                }
                if (tries > this.u / 2) {
                    done = true;
                }
                infeasibleSystem3 = infeasibleSystem4;
                f2 = 0.0f;
            }
        }
        return tries;
    }

    public final void n() {
        for (int i2 = 0; i2 < this.v; i2++) {
            c4 row = this.q[i2];
            row.a.m = row.b;
        }
    }

    public d4 v() {
        return this.x;
    }

    public void h(j4 a2, j4 b2, int margin, int strength) {
        c4 row = r();
        j4 slack = t();
        slack.l = 0;
        row.o(a2, b2, slack, margin);
        if (strength != 8) {
            float slackValue = row.e.d(slack);
            m(row, (int) ((-1.0f) * slackValue), strength);
        }
        d(row);
    }

    public void g(j4 a2, j4 b2, int margin, boolean hasMatchConstraintWidgets) {
        c4 row = r();
        j4 slack = t();
        slack.l = 0;
        row.o(a2, b2, slack, margin);
        d(row);
    }

    public void j(j4 a2, j4 b2, int margin, int strength) {
        c4 row = r();
        j4 slack = t();
        slack.l = 0;
        row.p(a2, b2, slack, margin);
        if (strength != 8) {
            float slackValue = row.e.d(slack);
            m(row, (int) ((-1.0f) * slackValue), strength);
        }
        d(row);
    }

    public void i(j4 a2, j4 b2, int margin, boolean hasMatchConstraintWidgets) {
        c4 row = r();
        j4 slack = t();
        slack.l = 0;
        row.p(a2, b2, slack, margin);
        d(row);
    }

    public void c(j4 a2, j4 b2, int m1, float bias, j4 c2, j4 d2, int m2, int strength) {
        c4 row = r();
        row.h(a2, b2, m1, bias, c2, d2, m2);
        if (strength != 8) {
            row.d(this, strength);
        }
        d(row);
    }

    public void k(j4 a2, j4 b2, j4 c2, j4 d2, float ratio, int strength) {
        c4 row = r();
        row.k(a2, b2, c2, d2, ratio);
        if (strength != 8) {
            row.d(this, strength);
        }
        d(row);
    }

    public c4 e(j4 a2, j4 b2, int margin, int strength) {
        if (b && strength == 8 && b2.n && a2.k == -1) {
            a2.f(this, b2.m + margin);
            return null;
        }
        c4 row = r();
        row.n(a2, b2, margin);
        if (strength != 8) {
            row.d(this, strength);
        }
        d(row);
        return row;
    }

    public void f(j4 a2, int value) {
        if (b && a2.k == -1) {
            a2.f(this, value);
            for (int i2 = 0; i2 < this.l + 1; i2++) {
                j4 variable = this.x.d[i2];
                if (variable != null && variable.u && variable.v == a2.j) {
                    variable.f(this, value + variable.w);
                }
            }
            return;
        }
        int idx = a2.k;
        if (a2.k != -1) {
            c4 row = this.q[idx];
            if (row.f) {
                row.b = value;
                return;
            } else if (row.e.c() == 0) {
                row.f = true;
                row.b = value;
                return;
            } else {
                c4 newRow = r();
                newRow.m(a2, value);
                d(newRow);
                return;
            }
        }
        c4 row2 = r();
        row2.i(a2, value);
        d(row2);
    }

    public static c4 s(e4 linearSystem, j4 variableA, j4 variableC, float percent) {
        c4 row = linearSystem.r();
        return row.j(variableA, variableC, percent);
    }

    public void b(x4 widget, x4 target, float angle, int radius) {
        w4.b bVar = w4.b.LEFT;
        j4 Al = q(widget.o(bVar));
        w4.b bVar2 = w4.b.TOP;
        j4 At = q(widget.o(bVar2));
        w4.b bVar3 = w4.b.RIGHT;
        j4 Ar = q(widget.o(bVar3));
        w4.b bVar4 = w4.b.BOTTOM;
        j4 Ab = q(widget.o(bVar4));
        j4 Bl = q(target.o(bVar));
        j4 Bt = q(target.o(bVar2));
        j4 Br = q(target.o(bVar3));
        j4 Bb = q(target.o(bVar4));
        c4 row = r();
        float angleComponent = (float) (Math.sin(angle) * radius);
        row.q(At, Ab, Bt, Bb, angleComponent);
        d(row);
        c4 row2 = r();
        float angleComponent2 = (float) (Math.cos(angle) * radius);
        row2.q(Al, Ar, Bl, Br, angleComponent2);
        d(row2);
    }
}
