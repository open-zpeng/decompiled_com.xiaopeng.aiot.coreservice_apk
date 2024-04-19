package defpackage;

import defpackage.w4;
import defpackage.x4;
/* compiled from: Barrier.java */
/* renamed from: t4  reason: default package */
/* loaded from: classes.dex */
public class t4 extends c5 {
    public int L0 = 0;
    public boolean M0 = true;
    public int N0 = 0;
    public boolean O0 = false;

    @Override // defpackage.x4
    public boolean h() {
        return true;
    }

    public int p1() {
        return this.L0;
    }

    public void u1(int barrierType) {
        this.L0 = barrierType;
    }

    public void t1(boolean allowsGoneWidget) {
        this.M0 = allowsGoneWidget;
    }

    public boolean o1() {
        return this.M0;
    }

    @Override // defpackage.x4
    public boolean k0() {
        return this.O0;
    }

    @Override // defpackage.x4
    public boolean l0() {
        return this.O0;
    }

    @Override // defpackage.x4
    public String toString() {
        String debug = "[Barrier] " + t() + " {";
        for (int i = 0; i < this.K0; i++) {
            x4 widget = this.J0[i];
            if (i > 0) {
                debug = debug + ", ";
            }
            debug = debug + widget.t();
        }
        return debug + "}";
    }

    public void s1() {
        for (int i = 0; i < this.K0; i++) {
            x4 widget = this.J0[i];
            if (this.M0 || widget.h()) {
                int i2 = this.L0;
                if (i2 == 0 || i2 == 1) {
                    widget.M0(0, true);
                } else if (i2 == 2 || i2 == 3) {
                    widget.M0(1, true);
                }
            }
        }
    }

    @Override // defpackage.x4
    public void g(e4 system, boolean optimize) {
        Object[] objArr;
        int i;
        w4[] w4VarArr = this.W;
        w4VarArr[0] = this.O;
        w4VarArr[2] = this.P;
        w4VarArr[1] = this.Q;
        w4VarArr[3] = this.R;
        int i2 = 0;
        while (true) {
            objArr = this.W;
            if (i2 >= objArr.length) {
                break;
            }
            objArr[i2].i = system.q(objArr[i2]);
            i2++;
        }
        int i3 = this.L0;
        if (i3 >= 0 && i3 < 4) {
            w4 position = objArr[i3];
            if (!this.O0) {
                n1();
            }
            if (this.O0) {
                this.O0 = false;
                int i4 = this.L0;
                if (i4 == 0 || i4 == 1) {
                    system.f(this.O.i, this.f0);
                    system.f(this.Q.i, this.f0);
                    return;
                } else if (i4 == 2 || i4 == 3) {
                    system.f(this.P.i, this.g0);
                    system.f(this.R.i, this.g0);
                    return;
                } else {
                    return;
                }
            }
            boolean hasMatchConstraintWidgets = false;
            int i5 = 0;
            while (true) {
                if (i5 >= this.K0) {
                    break;
                }
                x4 widget = this.J0[i5];
                if (this.M0 || widget.h()) {
                    int i6 = this.L0;
                    if ((i6 == 0 || i6 == 1) && widget.A() == x4.b.MATCH_CONSTRAINT && widget.O.f != null && widget.Q.f != null) {
                        hasMatchConstraintWidgets = true;
                        break;
                    }
                    int i7 = this.L0;
                    if ((i7 == 2 || i7 == 3) && widget.Q() == x4.b.MATCH_CONSTRAINT && widget.P.f != null && widget.R.f != null) {
                        hasMatchConstraintWidgets = true;
                        break;
                    }
                }
                i5++;
            }
            boolean mHasHorizontalCenteredDependents = this.O.l() || this.Q.l();
            boolean mHasVerticalCenteredDependents = this.P.l() || this.R.l();
            boolean applyEqualityOnReferences = !hasMatchConstraintWidgets && (((i = this.L0) == 0 && mHasHorizontalCenteredDependents) || ((i == 2 && mHasVerticalCenteredDependents) || ((i == 1 && mHasHorizontalCenteredDependents) || (i == 3 && mHasVerticalCenteredDependents))));
            int equalityOnReferencesStrength = 5;
            if (!applyEqualityOnReferences) {
                equalityOnReferencesStrength = 4;
            }
            for (int i8 = 0; i8 < this.K0; i8++) {
                x4 widget2 = this.J0[i8];
                if (this.M0 || widget2.h()) {
                    j4 target = system.q(widget2.W[this.L0]);
                    w4[] w4VarArr2 = widget2.W;
                    int i9 = this.L0;
                    w4VarArr2[i9].i = target;
                    int margin = 0;
                    if (w4VarArr2[i9].f != null && w4VarArr2[i9].f.d == this) {
                        margin = 0 + w4VarArr2[i9].g;
                    }
                    if (i9 == 0 || i9 == 2) {
                        system.i(position.i, target, this.N0 - margin, hasMatchConstraintWidgets);
                    } else {
                        system.g(position.i, target, this.N0 + margin, hasMatchConstraintWidgets);
                    }
                    system.e(position.i, target, this.N0 + margin, equalityOnReferencesStrength);
                }
            }
            int i10 = this.L0;
            if (i10 == 0) {
                system.e(this.Q.i, this.O.i, 0, 8);
                system.e(this.O.i, this.a0.Q.i, 0, 4);
                system.e(this.O.i, this.a0.O.i, 0, 0);
            } else if (i10 == 1) {
                system.e(this.O.i, this.Q.i, 0, 8);
                system.e(this.O.i, this.a0.O.i, 0, 4);
                system.e(this.O.i, this.a0.Q.i, 0, 0);
            } else if (i10 == 2) {
                system.e(this.R.i, this.P.i, 0, 8);
                system.e(this.P.i, this.a0.R.i, 0, 4);
                system.e(this.P.i, this.a0.P.i, 0, 0);
            } else if (i10 == 3) {
                system.e(this.P.i, this.R.i, 0, 8);
                system.e(this.P.i, this.a0.P.i, 0, 4);
                system.e(this.P.i, this.a0.R.i, 0, 0);
            }
        }
    }

    public void v1(int margin) {
        this.N0 = margin;
    }

    public int q1() {
        return this.N0;
    }

    public int r1() {
        switch (this.L0) {
            case 0:
            case 1:
                return 0;
            case 2:
            case 3:
                return 1;
            default:
                return -1;
        }
    }

    public boolean n1() {
        int i;
        boolean hasAllWidgetsResolved = true;
        int i2 = 0;
        while (true) {
            i = this.K0;
            if (i2 >= i) {
                break;
            }
            x4 widget = this.J0[i2];
            if (this.M0 || widget.h()) {
                int i3 = this.L0;
                if ((i3 == 0 || i3 == 1) && !widget.k0()) {
                    hasAllWidgetsResolved = false;
                } else {
                    int i4 = this.L0;
                    if ((i4 == 2 || i4 == 3) && !widget.l0()) {
                        hasAllWidgetsResolved = false;
                    }
                }
            }
            i2++;
        }
        if (hasAllWidgetsResolved && i > 0) {
            int barrierPosition = 0;
            boolean initialized = false;
            for (int i5 = 0; i5 < this.K0; i5++) {
                x4 widget2 = this.J0[i5];
                if (this.M0 || widget2.h()) {
                    if (!initialized) {
                        int i6 = this.L0;
                        if (i6 == 0) {
                            barrierPosition = widget2.o(w4.b.LEFT).e();
                        } else if (i6 == 1) {
                            barrierPosition = widget2.o(w4.b.RIGHT).e();
                        } else if (i6 == 2) {
                            barrierPosition = widget2.o(w4.b.TOP).e();
                        } else if (i6 == 3) {
                            barrierPosition = widget2.o(w4.b.BOTTOM).e();
                        }
                        initialized = true;
                    }
                    int i7 = this.L0;
                    if (i7 == 0) {
                        barrierPosition = Math.min(barrierPosition, widget2.o(w4.b.LEFT).e());
                    } else if (i7 == 1) {
                        barrierPosition = Math.max(barrierPosition, widget2.o(w4.b.RIGHT).e());
                    } else if (i7 == 2) {
                        barrierPosition = Math.min(barrierPosition, widget2.o(w4.b.TOP).e());
                    } else if (i7 == 3) {
                        barrierPosition = Math.max(barrierPosition, widget2.o(w4.b.BOTTOM).e());
                    }
                }
            }
            int barrierPosition2 = barrierPosition + this.N0;
            int i8 = this.L0;
            if (i8 == 0 || i8 == 1) {
                z0(barrierPosition2, barrierPosition2);
            } else {
                C0(barrierPosition2, barrierPosition2);
            }
            this.O0 = true;
            return true;
        }
        return false;
    }
}
