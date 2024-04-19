package defpackage;

import defpackage.w4;
import defpackage.x4;
/* compiled from: Guideline.java */
/* renamed from: a5  reason: default package */
/* loaded from: classes.dex */
public class a5 extends x4 {
    public float J0 = -1.0f;
    public int K0 = -1;
    public int L0 = -1;
    public w4 M0 = this.P;
    public int N0 = 0;
    public int O0 = 0;
    public boolean P0;

    public a5() {
        this.X.clear();
        this.X.add(this.M0);
        int count = this.W.length;
        for (int i = 0; i < count; i++) {
            this.W[i] = this.M0;
        }
    }

    @Override // defpackage.x4
    public boolean h() {
        return true;
    }

    public void u1(int orientation) {
        if (this.N0 == orientation) {
            return;
        }
        this.N0 = orientation;
        this.X.clear();
        if (this.N0 == 1) {
            this.M0 = this.O;
        } else {
            this.M0 = this.P;
        }
        this.X.add(this.M0);
        int count = this.W.length;
        for (int i = 0; i < count; i++) {
            this.W[i] = this.M0;
        }
    }

    public w4 l1() {
        return this.M0;
    }

    public int m1() {
        return this.N0;
    }

    /* compiled from: Guideline.java */
    /* renamed from: a5$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[w4.b.values().length];
            a = iArr;
            try {
                iArr[w4.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[w4.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[w4.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[w4.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[w4.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[w4.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[w4.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[w4.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[w4.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    @Override // defpackage.x4
    public w4 o(w4.b anchorType) {
        switch (a.a[anchorType.ordinal()]) {
            case 1:
            case 2:
                if (this.N0 == 1) {
                    return this.M0;
                }
                break;
            case 3:
            case 4:
                if (this.N0 == 0) {
                    return this.M0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        return null;
    }

    public void t1(float value) {
        if (value > -1.0f) {
            this.J0 = value;
            this.K0 = -1;
            this.L0 = -1;
        }
    }

    public void r1(int value) {
        if (value > -1) {
            this.J0 = -1.0f;
            this.K0 = value;
            this.L0 = -1;
        }
    }

    public void s1(int value) {
        if (value > -1) {
            this.J0 = -1.0f;
            this.K0 = -1;
            this.L0 = value;
        }
    }

    public float p1() {
        return this.J0;
    }

    public int n1() {
        return this.K0;
    }

    public int o1() {
        return this.L0;
    }

    public void q1(int position) {
        this.M0.t(position);
        this.P0 = true;
    }

    @Override // defpackage.x4
    public boolean k0() {
        return this.P0;
    }

    @Override // defpackage.x4
    public boolean l0() {
        return this.P0;
    }

    @Override // defpackage.x4
    public void g(e4 system, boolean optimize) {
        y4 parent = (y4) K();
        if (parent == null) {
            return;
        }
        w4 begin = parent.o(w4.b.LEFT);
        w4 end = parent.o(w4.b.RIGHT);
        x4 x4Var = this.a0;
        boolean z = true;
        boolean parentWrapContent = x4Var != null && x4Var.Z[0] == x4.b.WRAP_CONTENT;
        if (this.N0 == 0) {
            begin = parent.o(w4.b.TOP);
            end = parent.o(w4.b.BOTTOM);
            x4 x4Var2 = this.a0;
            if (x4Var2 == null || x4Var2.Z[1] != x4.b.WRAP_CONTENT) {
                z = false;
            }
            parentWrapContent = z;
        }
        if (this.P0 && this.M0.n()) {
            j4 guide = system.q(this.M0);
            system.f(guide, this.M0.e());
            if (this.K0 != -1) {
                if (parentWrapContent) {
                    system.h(system.q(end), guide, 0, 5);
                }
            } else if (this.L0 != -1 && parentWrapContent) {
                j4 parentRight = system.q(end);
                system.h(guide, system.q(begin), 0, 5);
                system.h(parentRight, guide, 0, 5);
            }
            this.P0 = false;
        } else if (this.K0 != -1) {
            j4 guide2 = system.q(this.M0);
            j4 parentLeft = system.q(begin);
            system.e(guide2, parentLeft, this.K0, 8);
            if (parentWrapContent) {
                system.h(system.q(end), guide2, 0, 5);
            }
        } else if (this.L0 != -1) {
            j4 guide3 = system.q(this.M0);
            j4 parentRight2 = system.q(end);
            system.e(guide3, parentRight2, -this.L0, 8);
            if (parentWrapContent) {
                system.h(guide3, system.q(begin), 0, 5);
                system.h(parentRight2, guide3, 0, 5);
            }
        } else if (this.J0 != -1.0f) {
            system.d(e4.s(system, system.q(this.M0), system.q(end), this.J0));
        }
    }

    @Override // defpackage.x4
    public void k1(e4 system, boolean optimize) {
        if (K() == null) {
            return;
        }
        int value = system.x(this.M0);
        if (this.N0 == 1) {
            g1(value);
            h1(0);
            F0(K().x());
            e1(0);
            return;
        }
        g1(0);
        h1(value);
        e1(K().T());
        F0(0);
    }
}
