package defpackage;

import com.lzy.okgo.model.Priority;
import defpackage.w4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: ConstraintWidget.java */
/* renamed from: x4  reason: default package */
/* loaded from: classes.dex */
public class x4 {
    public static float a = 0.5f;
    public boolean A0;
    public boolean B0;
    public float[] C0;
    public x4[] D0;
    public x4[] E0;
    public x4 F0;
    public x4 G0;
    public int H0;
    public int I0;
    public boolean K;
    public w4 V;
    public w4[] W;
    public ArrayList<w4> X;
    public boolean[] Y;
    public b[] Z;
    public x4 a0;
    public int b0;
    public int c0;
    public i5 d;
    public float d0;
    public i5 e;
    public int e0;
    public int f0;
    public int g0;
    public int h0;
    public int i0;
    public int j0;
    public int k0;
    public int l0;
    public int m0;
    public int n0;
    public float o0;
    public float p0;
    public Object q0;
    public int r0;
    public int s0;
    public String t0;
    public String u0;
    public boolean v0;
    public boolean w0;
    public boolean x0;
    public int y0;
    public int z0;
    public boolean b = false;
    public v5[] c = new v5[2];
    public r5 f = null;
    public t5 g = null;
    public boolean[] h = {true, true};
    public boolean i = false;
    public boolean j = true;
    public boolean k = false;
    public boolean l = true;
    public int m = -1;
    public int n = -1;
    public s4 o = new s4(this);
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public int t = -1;
    public int u = -1;
    public int v = 0;
    public int w = 0;
    public int x = 0;
    public int[] y = new int[2];
    public int z = 0;
    public int A = 0;
    public float B = 1.0f;
    public int C = 0;
    public int D = 0;
    public float E = 1.0f;
    public int F = -1;
    public float G = 1.0f;
    public int[] H = {Priority.UI_TOP, Priority.UI_TOP};
    public float I = 0.0f;
    public boolean J = false;
    public boolean L = false;
    public int M = 0;
    public int N = 0;
    public w4 O = new w4(this, w4.b.LEFT);
    public w4 P = new w4(this, w4.b.TOP);
    public w4 Q = new w4(this, w4.b.RIGHT);
    public w4 R = new w4(this, w4.b.BOTTOM);
    public w4 S = new w4(this, w4.b.BASELINE);
    public w4 T = new w4(this, w4.b.CENTER_X);
    public w4 U = new w4(this, w4.b.CENTER_Y);

    /* compiled from: ConstraintWidget.java */
    /* renamed from: x4$b */
    /* loaded from: classes.dex */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public v5 N(int orientation) {
        if (orientation == 0) {
            return this.f;
        }
        if (orientation == 1) {
            return this.g;
        }
        return null;
    }

    public void A0(int x1) {
        this.O.t(x1);
        this.f0 = x1;
    }

    public void B0(int y1) {
        this.P.t(y1);
        this.g0 = y1;
    }

    public boolean d0() {
        return this.r;
    }

    public boolean m0() {
        return this.s;
    }

    public void n0() {
        this.r = true;
    }

    public void o0() {
        this.s = true;
    }

    public void z0(int x1, int x2) {
        if (this.p) {
            return;
        }
        this.O.t(x1);
        this.Q.t(x2);
        this.f0 = x1;
        this.b0 = x2 - x1;
        this.p = true;
    }

    public void C0(int y1, int y2) {
        if (this.q) {
            return;
        }
        this.P.t(y1);
        this.R.t(y2);
        this.g0 = y1;
        this.c0 = y2 - y1;
        if (this.J) {
            this.S.t(this.l0 + y1);
        }
        this.q = true;
    }

    public void y0(int baselineValue) {
        if (!this.J) {
            return;
        }
        int y1 = baselineValue - this.l0;
        int y2 = this.c0 + y1;
        this.g0 = y1;
        this.P.t(y1);
        this.R.t(y2);
        this.S.t(baselineValue);
        this.q = true;
    }

    public boolean k0() {
        return this.p || (this.O.n() && this.Q.n());
    }

    public boolean l0() {
        return this.q || (this.P.n() && this.R.n());
    }

    public void s0() {
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        int mAnchorsSize = this.X.size();
        for (int i = 0; i < mAnchorsSize; i++) {
            w4 anchor = this.X.get(i);
            anchor.r();
        }
    }

    public boolean Y() {
        int mAnchorsSize = this.X.size();
        for (int i = 0; i < mAnchorsSize; i++) {
            w4 anchor = this.X.get(i);
            if (anchor.m()) {
                return true;
            }
        }
        return false;
    }

    public boolean X(int orientation) {
        if (orientation == 0) {
            int horizontalTargets = (this.O.f != null ? 1 : 0) + (this.Q.f != null ? 1 : 0);
            return horizontalTargets < 2;
        }
        int verticalTargets = (this.P.f != null ? 1 : 0) + (this.R.f != null ? 1 : 0) + (this.S.f != null ? 1 : 0);
        return verticalTargets < 2;
    }

    public boolean a0(int orientation, int size) {
        w4 w4Var;
        w4 w4Var2;
        if (orientation == 0) {
            w4 w4Var3 = this.O.f;
            return w4Var3 != null && w4Var3.n() && (w4Var2 = this.Q.f) != null && w4Var2.n() && (this.Q.f.e() - this.Q.f()) - (this.O.f.e() + this.O.f()) >= size;
        }
        w4 w4Var4 = this.P.f;
        return w4Var4 != null && w4Var4.n() && (w4Var = this.R.f) != null && w4Var.n() && (this.R.f.e() - this.R.f()) - (this.P.f.e() + this.P.f()) >= size;
        return false;
    }

    public boolean i0() {
        return this.L;
    }

    public void O0(boolean inVirtualLayout) {
        this.L = inVirtualLayout;
    }

    public int F() {
        return this.H[1];
    }

    public int G() {
        return this.H[0];
    }

    public void R0(int maxWidth) {
        this.H[0] = maxWidth;
    }

    public void Q0(int maxHeight) {
        this.H[1] = maxHeight;
    }

    public void E0(boolean hasBaseline) {
        this.J = hasBaseline;
    }

    public boolean g0() {
        return this.K;
    }

    public void N0(boolean inPlaceholder) {
        this.K = inPlaceholder;
    }

    public void M0(int orientation, boolean value) {
        this.Y[orientation] = value;
    }

    public boolean e0(int orientation) {
        return this.Y[orientation];
    }

    public void S0(boolean measureRequested) {
        this.j = measureRequested;
    }

    public boolean j0() {
        return this.j && this.s0 != 8;
    }

    public void f1(int behavior) {
        if (behavior >= 0 && behavior <= 3) {
            this.v = behavior;
        }
    }

    public int C() {
        return this.M;
    }

    public int D() {
        return this.N;
    }

    public void P0(int horizontal, int vertical) {
        this.M = horizontal;
        this.N = vertical;
        S0(false);
    }

    public void q0() {
        this.O.q();
        this.P.q();
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.a0 = null;
        this.I = 0.0f;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0.0f;
        this.e0 = -1;
        this.f0 = 0;
        this.g0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        float f = a;
        this.o0 = f;
        this.p0 = f;
        b[] bVarArr = this.Z;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.q0 = null;
        this.r0 = 0;
        this.s0 = 0;
        this.u0 = null;
        this.v0 = false;
        this.w0 = false;
        this.y0 = 0;
        this.z0 = 0;
        this.A0 = false;
        this.B0 = false;
        float[] fArr = this.C0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.t = -1;
        this.u = -1;
        int[] iArr = this.H;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.w = 0;
        this.x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Priority.UI_TOP;
        this.D = Priority.UI_TOP;
        this.z = 0;
        this.C = 0;
        this.i = false;
        this.F = -1;
        this.G = 1.0f;
        this.x0 = false;
        boolean[] zArr = this.h;
        zArr[0] = true;
        zArr[1] = true;
        this.L = false;
        boolean[] zArr2 = this.Y;
        zArr2[0] = false;
        zArr2[1] = false;
        this.j = true;
        int[] iArr2 = this.y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.m = -1;
        this.n = -1;
    }

    public boolean p0() {
        b[] bVarArr = this.Z;
        b bVar = bVarArr[0];
        b bVar2 = b.MATCH_CONSTRAINT;
        return bVar == bVar2 && bVarArr[1] == bVar2;
    }

    public boolean Z() {
        return (this.m == -1 && this.n == -1) ? false : true;
    }

    public x4() {
        w4 w4Var = new w4(this, w4.b.CENTER);
        this.V = w4Var;
        this.W = new w4[]{this.O, this.Q, this.P, this.R, this.S, w4Var};
        this.X = new ArrayList<>();
        this.Y = new boolean[2];
        b bVar = b.FIXED;
        this.Z = new b[]{bVar, bVar};
        this.a0 = null;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0.0f;
        this.e0 = -1;
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        float f = a;
        this.o0 = f;
        this.p0 = f;
        this.r0 = 0;
        this.s0 = 0;
        this.t0 = null;
        this.u0 = null;
        this.x0 = false;
        this.y0 = 0;
        this.z0 = 0;
        this.C0 = new float[]{-1.0f, -1.0f};
        this.D0 = new x4[]{null, null};
        this.E0 = new x4[]{null, null};
        this.F0 = null;
        this.G0 = null;
        this.H0 = -1;
        this.I0 = -1;
        d();
    }

    public void n() {
        if (this.f == null) {
            this.f = new r5(this);
        }
        if (this.g == null) {
            this.g = new t5(this);
        }
    }

    public void t0(d4 cache) {
        this.O.s(cache);
        this.P.s(cache);
        this.Q.s(cache);
        this.R.s(cache);
        this.S.s(cache);
        this.V.s(cache);
        this.T.s(cache);
        this.U.s(cache);
    }

    public final void d() {
        this.X.add(this.O);
        this.X.add(this.P);
        this.X.add(this.Q);
        this.X.add(this.R);
        this.X.add(this.T);
        this.X.add(this.U);
        this.X.add(this.V);
        this.X.add(this.S);
    }

    public x4 K() {
        return this.a0;
    }

    public void W0(x4 widget) {
        this.a0 = widget;
    }

    public void l(x4 target, float angle, int radius) {
        w4.b bVar = w4.b.CENTER;
        b0(bVar, target, bVar, radius, 0);
        this.I = angle;
    }

    public void d1(int visibility) {
        this.s0 = visibility;
    }

    public int S() {
        return this.s0;
    }

    public String t() {
        return this.t0;
    }

    public void w0(String name) {
        this.t0 = name;
    }

    public void m(e4 system) {
        system.q(this.O);
        system.q(this.P);
        system.q(this.Q);
        system.q(this.R);
        if (this.l0 > 0) {
            system.q(this.S);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.u0 != null) {
            str = "type: " + this.u0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.t0 != null) {
            str2 = "id: " + this.t0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f0);
        sb.append(", ");
        sb.append(this.g0);
        sb.append(") - (");
        sb.append(this.b0);
        sb.append(" x ");
        sb.append(this.c0);
        sb.append(")");
        return sb.toString();
    }

    public int U() {
        x4 x4Var = this.a0;
        if (x4Var != null && (x4Var instanceof y4)) {
            return ((y4) x4Var).S0 + this.f0;
        }
        return this.f0;
    }

    public int V() {
        x4 x4Var = this.a0;
        if (x4Var != null && (x4Var instanceof y4)) {
            return ((y4) x4Var).T0 + this.g0;
        }
        return this.g0;
    }

    public int T() {
        if (this.s0 == 8) {
            return 0;
        }
        return this.b0;
    }

    public int x() {
        if (this.s0 == 8) {
            return 0;
        }
        return this.c0;
    }

    public int E(int orientation) {
        if (orientation == 0) {
            return T();
        }
        if (orientation == 1) {
            return x();
        }
        return 0;
    }

    public int I() {
        return this.m0;
    }

    public int H() {
        return this.n0;
    }

    public int M() {
        return U() + this.b0;
    }

    public int r() {
        return V() + this.c0;
    }

    public int B() {
        w4 w4Var = this.O;
        int margin = w4Var != null ? 0 + w4Var.g : 0;
        w4 w4Var2 = this.Q;
        if (w4Var2 != null) {
            return margin + w4Var2.g;
        }
        return margin;
    }

    public int R() {
        int margin = this.O != null ? 0 + this.P.g : 0;
        if (this.Q != null) {
            return margin + this.R.g;
        }
        return margin;
    }

    public float y() {
        return this.o0;
    }

    public float O() {
        return this.p0;
    }

    public float q(int orientation) {
        if (orientation == 0) {
            return this.o0;
        }
        if (orientation == 1) {
            return this.p0;
        }
        return -1.0f;
    }

    public boolean W() {
        return this.J;
    }

    public int p() {
        return this.l0;
    }

    public Object s() {
        return this.q0;
    }

    public void g1(int x) {
        this.f0 = x;
    }

    public void h1(int y) {
        this.g0 = y;
    }

    public void V0(int x, int y) {
        this.f0 = x;
        this.g0 = y;
    }

    public void e1(int w) {
        this.b0 = w;
        int i = this.m0;
        if (w < i) {
            this.b0 = i;
        }
    }

    public void F0(int h) {
        this.c0 = h;
        int i = this.n0;
        if (h < i) {
            this.c0 = i;
        }
    }

    public void K0(int horizontalMatchStyle, int min, int max, float percent) {
        this.w = horizontalMatchStyle;
        this.z = min;
        this.A = max == Integer.MAX_VALUE ? 0 : max;
        this.B = percent;
        if (percent > 0.0f && percent < 1.0f && horizontalMatchStyle == 0) {
            this.w = 2;
        }
    }

    public void b1(int verticalMatchStyle, int min, int max, float percent) {
        this.x = verticalMatchStyle;
        this.C = min;
        this.D = max == Integer.MAX_VALUE ? 0 : max;
        this.E = percent;
        if (percent > 0.0f && percent < 1.0f && verticalMatchStyle == 0) {
            this.x = 2;
        }
    }

    public void x0(String ratio) {
        int commaIndex;
        if (ratio == null || ratio.length() == 0) {
            this.d0 = 0.0f;
            return;
        }
        int dimensionRatioSide = -1;
        float dimensionRatio = 0.0f;
        int len = ratio.length();
        int commaIndex2 = ratio.indexOf(44);
        if (commaIndex2 > 0 && commaIndex2 < len - 1) {
            String dimension = ratio.substring(0, commaIndex2);
            if (dimension.equalsIgnoreCase("W")) {
                dimensionRatioSide = 0;
            } else if (dimension.equalsIgnoreCase("H")) {
                dimensionRatioSide = 1;
            }
            commaIndex = commaIndex2 + 1;
        } else {
            commaIndex = 0;
        }
        int colonIndex = ratio.indexOf(58);
        if (colonIndex >= 0 && colonIndex < len - 1) {
            String nominator = ratio.substring(commaIndex, colonIndex);
            String denominator = ratio.substring(colonIndex + 1);
            if (nominator.length() > 0 && denominator.length() > 0) {
                try {
                    float nominatorValue = Float.parseFloat(nominator);
                    float denominatorValue = Float.parseFloat(denominator);
                    if (nominatorValue > 0.0f && denominatorValue > 0.0f) {
                        dimensionRatio = dimensionRatioSide == 1 ? Math.abs(denominatorValue / nominatorValue) : Math.abs(nominatorValue / denominatorValue);
                    }
                } catch (NumberFormatException e) {
                }
            }
        } else {
            String r = ratio.substring(commaIndex);
            if (r.length() > 0) {
                try {
                    dimensionRatio = Float.parseFloat(r);
                } catch (NumberFormatException e2) {
                }
            }
        }
        if (dimensionRatio > 0.0f) {
            this.d0 = dimensionRatio;
            this.e0 = dimensionRatioSide;
        }
    }

    public float v() {
        return this.d0;
    }

    public int w() {
        return this.e0;
    }

    public void G0(float horizontalBiasPercent) {
        this.o0 = horizontalBiasPercent;
    }

    public void X0(float verticalBiasPercent) {
        this.p0 = verticalBiasPercent;
    }

    public void U0(int w) {
        if (w < 0) {
            this.m0 = 0;
        } else {
            this.m0 = w;
        }
    }

    public void T0(int h) {
        if (h < 0) {
            this.n0 = 0;
        } else {
            this.n0 = h;
        }
    }

    public void D0(int left, int top, int right, int bottom) {
        int w = right - left;
        int h = bottom - top;
        this.f0 = left;
        this.g0 = top;
        if (this.s0 == 8) {
            this.b0 = 0;
            this.c0 = 0;
            return;
        }
        b[] bVarArr = this.Z;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && w < this.b0) {
            w = this.b0;
        }
        if (bVarArr[1] == bVar2 && h < this.c0) {
            h = this.c0;
        }
        this.b0 = w;
        this.c0 = h;
        int i = this.n0;
        if (h < i) {
            this.c0 = i;
        }
        int i2 = this.m0;
        if (w < i2) {
            this.b0 = i2;
        }
        int i3 = this.A;
        if (i3 > 0 && bVarArr[0] == b.MATCH_CONSTRAINT) {
            this.b0 = Math.min(this.b0, i3);
        }
        int i4 = this.D;
        if (i4 > 0 && this.Z[1] == b.MATCH_CONSTRAINT) {
            this.c0 = Math.min(this.c0, i4);
        }
        int i5 = this.b0;
        if (w != i5) {
            this.m = i5;
        }
        int i6 = this.c0;
        if (h != i6) {
            this.n = i6;
        }
    }

    public void I0(int left, int right) {
        this.f0 = left;
        int i = right - left;
        this.b0 = i;
        int i2 = this.m0;
        if (i < i2) {
            this.b0 = i2;
        }
    }

    public void Z0(int top, int bottom) {
        this.g0 = top;
        int i = bottom - top;
        this.c0 = i;
        int i2 = this.n0;
        if (i < i2) {
            this.c0 = i2;
        }
    }

    public void u0(int baseline) {
        this.l0 = baseline;
        this.J = baseline > 0;
    }

    public void v0(Object companion) {
        this.q0 = companion;
    }

    public void L0(float horizontalWeight) {
        this.C0[0] = horizontalWeight;
    }

    public void c1(float verticalWeight) {
        this.C0[1] = verticalWeight;
    }

    public void H0(int horizontalChainStyle) {
        this.y0 = horizontalChainStyle;
    }

    public int z() {
        return this.y0;
    }

    public void Y0(int verticalChainStyle) {
        this.z0 = verticalChainStyle;
    }

    public int P() {
        return this.z0;
    }

    public boolean h() {
        return this.s0 != 8;
    }

    public void b0(w4.b startType, x4 target, w4.b endType, int margin, int goneMargin) {
        w4 startAnchor = o(startType);
        w4 endAnchor = target.o(endType);
        startAnchor.b(endAnchor, margin, goneMargin, true);
    }

    public void k(w4 from, w4 to, int margin) {
        if (from.h() == this) {
            j(from.k(), to.h(), to.k(), margin);
        }
    }

    public void j(w4.b constraintFrom, x4 target, w4.b constraintTo, int margin) {
        w4.b bVar;
        w4.b bVar2;
        w4.b bVar3 = w4.b.CENTER;
        if (constraintFrom == bVar3) {
            if (constraintTo == bVar3) {
                w4.b bVar4 = w4.b.LEFT;
                w4 left = o(bVar4);
                w4.b bVar5 = w4.b.RIGHT;
                w4 right = o(bVar5);
                w4.b bVar6 = w4.b.TOP;
                w4 top = o(bVar6);
                w4.b bVar7 = w4.b.BOTTOM;
                w4 bottom = o(bVar7);
                boolean centerX = false;
                boolean centerY = false;
                if ((left == null || !left.o()) && (right == null || !right.o())) {
                    j(bVar4, target, bVar4, 0);
                    j(bVar5, target, bVar5, 0);
                    centerX = true;
                }
                if ((top == null || !top.o()) && (bottom == null || !bottom.o())) {
                    j(bVar6, target, bVar6, 0);
                    j(bVar7, target, bVar7, 0);
                    centerY = true;
                }
                if (centerX && centerY) {
                    o(bVar3).a(target.o(bVar3), 0);
                } else if (centerX) {
                    w4.b bVar8 = w4.b.CENTER_X;
                    o(bVar8).a(target.o(bVar8), 0);
                } else if (centerY) {
                    w4.b bVar9 = w4.b.CENTER_Y;
                    o(bVar9).a(target.o(bVar9), 0);
                }
                return;
            }
            w4.b bVar10 = w4.b.LEFT;
            if (constraintTo == bVar10 || constraintTo == w4.b.RIGHT) {
                j(bVar10, target, constraintTo, 0);
                j(w4.b.RIGHT, target, constraintTo, 0);
                o(bVar3).a(target.o(constraintTo), 0);
            } else {
                w4.b bVar11 = w4.b.TOP;
                if (constraintTo == bVar11 || constraintTo == w4.b.BOTTOM) {
                    j(bVar11, target, constraintTo, 0);
                    j(w4.b.BOTTOM, target, constraintTo, 0);
                    o(bVar3).a(target.o(constraintTo), 0);
                    return;
                }
            }
            return;
        }
        w4.b bVar12 = w4.b.CENTER_X;
        if (constraintFrom == bVar12 && (constraintTo == (bVar2 = w4.b.LEFT) || constraintTo == w4.b.RIGHT)) {
            w4 left2 = o(bVar2);
            w4 targetAnchor = target.o(constraintTo);
            w4 right2 = o(w4.b.RIGHT);
            left2.a(targetAnchor, 0);
            right2.a(targetAnchor, 0);
            o(bVar12).a(targetAnchor, 0);
            return;
        }
        w4.b bVar13 = w4.b.CENTER_Y;
        if (constraintFrom == bVar13 && (constraintTo == (bVar = w4.b.TOP) || constraintTo == w4.b.BOTTOM)) {
            w4 targetAnchor2 = target.o(constraintTo);
            o(bVar).a(targetAnchor2, 0);
            o(w4.b.BOTTOM).a(targetAnchor2, 0);
            o(bVar13).a(targetAnchor2, 0);
        } else if (constraintFrom == bVar12 && constraintTo == bVar12) {
            w4.b bVar14 = w4.b.LEFT;
            w4 left3 = o(bVar14);
            w4 leftTarget = target.o(bVar14);
            left3.a(leftTarget, 0);
            w4.b bVar15 = w4.b.RIGHT;
            w4 right3 = o(bVar15);
            w4 rightTarget = target.o(bVar15);
            right3.a(rightTarget, 0);
            o(bVar12).a(target.o(constraintTo), 0);
        } else if (constraintFrom == bVar13 && constraintTo == bVar13) {
            w4.b bVar16 = w4.b.TOP;
            w4 top2 = o(bVar16);
            w4 topTarget = target.o(bVar16);
            top2.a(topTarget, 0);
            w4.b bVar17 = w4.b.BOTTOM;
            w4 bottom2 = o(bVar17);
            w4 bottomTarget = target.o(bVar17);
            bottom2.a(bottomTarget, 0);
            o(bVar13).a(target.o(constraintTo), 0);
        } else {
            w4 fromAnchor = o(constraintFrom);
            w4 toAnchor = target.o(constraintTo);
            if (fromAnchor.p(toAnchor)) {
                w4.b bVar18 = w4.b.BASELINE;
                if (constraintFrom == bVar18) {
                    w4 top3 = o(w4.b.TOP);
                    w4 bottom3 = o(w4.b.BOTTOM);
                    if (top3 != null) {
                        top3.q();
                    }
                    if (bottom3 != null) {
                        bottom3.q();
                    }
                } else if (constraintFrom == w4.b.TOP || constraintFrom == w4.b.BOTTOM) {
                    w4 baseline = o(bVar18);
                    if (baseline != null) {
                        baseline.q();
                    }
                    w4 center = o(bVar3);
                    if (center.j() != toAnchor) {
                        center.q();
                    }
                    w4 opposite = o(constraintFrom).g();
                    w4 centerY2 = o(bVar13);
                    if (centerY2.o()) {
                        opposite.q();
                        centerY2.q();
                    }
                } else if (constraintFrom == w4.b.LEFT || constraintFrom == w4.b.RIGHT) {
                    w4 center2 = o(bVar3);
                    if (center2.j() != toAnchor) {
                        center2.q();
                    }
                    w4 opposite2 = o(constraintFrom).g();
                    w4 centerX2 = o(bVar12);
                    if (centerX2.o()) {
                        opposite2.q();
                        centerX2.q();
                    }
                }
                fromAnchor.a(toAnchor, margin);
            }
        }
    }

    public void r0() {
        x4 parent = K();
        if (parent != null && (parent instanceof y4)) {
            y4 parentContainer = (y4) K();
            if (parentContainer.F1()) {
                return;
            }
        }
        int mAnchorsSize = this.X.size();
        for (int i = 0; i < mAnchorsSize; i++) {
            w4 anchor = this.X.get(i);
            anchor.q();
        }
    }

    public w4 o(w4.b anchorType) {
        switch (a.a[anchorType.ordinal()]) {
            case 1:
                return this.O;
            case 2:
                return this.P;
            case 3:
                return this.Q;
            case 4:
                return this.R;
            case 5:
                return this.S;
            case 6:
                return this.V;
            case 7:
                return this.T;
            case 8:
                return this.U;
            case 9:
                return null;
            default:
                throw new AssertionError(anchorType.name());
        }
    }

    public b A() {
        return this.Z[0];
    }

    public b Q() {
        return this.Z[1];
    }

    public b u(int orientation) {
        if (orientation == 0) {
            return A();
        }
        if (orientation == 1) {
            return Q();
        }
        return null;
    }

    public void J0(b behaviour) {
        this.Z[0] = behaviour;
    }

    public void a1(b behaviour) {
        this.Z[1] = behaviour;
    }

    public boolean f0() {
        w4 w4Var = this.O;
        w4 w4Var2 = w4Var.f;
        if (w4Var2 == null || w4Var2.f != w4Var) {
            w4 w4Var3 = this.Q;
            w4 w4Var4 = w4Var3.f;
            if (w4Var4 != null && w4Var4.f == w4Var3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public x4 L(int orientation) {
        w4 w4Var;
        w4 w4Var2;
        if (orientation == 0) {
            w4 w4Var3 = this.O;
            w4 w4Var4 = w4Var3.f;
            if (w4Var4 != null && w4Var4.f == w4Var3) {
                return w4Var4.d;
            }
            return null;
        } else if (orientation == 1 && (w4Var2 = (w4Var = this.P).f) != null && w4Var2.f == w4Var) {
            return w4Var2.d;
        } else {
            return null;
        }
    }

    public x4 J(int orientation) {
        w4 w4Var;
        w4 w4Var2;
        if (orientation == 0) {
            w4 w4Var3 = this.Q;
            w4 w4Var4 = w4Var3.f;
            if (w4Var4 != null && w4Var4.f == w4Var3) {
                return w4Var4.d;
            }
            return null;
        } else if (orientation == 1 && (w4Var2 = (w4Var = this.R).f) != null && w4Var2.f == w4Var) {
            return w4Var2.d;
        } else {
            return null;
        }
    }

    public boolean h0() {
        w4 w4Var = this.P;
        w4 w4Var2 = w4Var.f;
        if (w4Var2 == null || w4Var2.f != w4Var) {
            w4 w4Var3 = this.R;
            w4 w4Var4 = w4Var3.f;
            if (w4Var4 != null && w4Var4.f == w4Var3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean c0(int orientation) {
        int offset = orientation * 2;
        w4[] w4VarArr = this.W;
        return (w4VarArr[offset].f == null || w4VarArr[offset].f.f == w4VarArr[offset] || w4VarArr[offset + 1].f == null || w4VarArr[offset + 1].f.f != w4VarArr[offset + 1]) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:206:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x063c  */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(defpackage.e4 r76, boolean r77) {
        /*
            Method dump skipped, instructions count: 1646
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x4.g(e4, boolean):void");
    }

    public boolean f() {
        return (this instanceof e5) || (this instanceof a5);
    }

    public void i1(boolean hParentWrapContent, boolean vParentWrapContent, boolean horizontalDimensionFixed, boolean verticalDimensionFixed) {
        if (this.F == -1) {
            if (horizontalDimensionFixed && !verticalDimensionFixed) {
                this.F = 0;
            } else if (!horizontalDimensionFixed && verticalDimensionFixed) {
                this.F = 1;
                if (this.e0 == -1) {
                    this.G = 1.0f / this.G;
                }
            }
        }
        if (this.F == 0 && (!this.P.o() || !this.R.o())) {
            this.F = 1;
        } else if (this.F == 1 && (!this.O.o() || !this.Q.o())) {
            this.F = 0;
        }
        if (this.F == -1 && (!this.P.o() || !this.R.o() || !this.O.o() || !this.Q.o())) {
            if (this.P.o() && this.R.o()) {
                this.F = 0;
            } else if (this.O.o() && this.Q.o()) {
                this.G = 1.0f / this.G;
                this.F = 1;
            }
        }
        if (this.F == -1) {
            int i = this.z;
            if (i > 0 && this.C == 0) {
                this.F = 0;
            } else if (i == 0 && this.C > 0) {
                this.G = 1.0f / this.G;
                this.F = 1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:275:0x05e5, code lost:
        if ((r4 instanceof defpackage.t4) != false) goto L247;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x066b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(defpackage.e4 r39, boolean r40, boolean r41, boolean r42, boolean r43, defpackage.j4 r44, defpackage.j4 r45, defpackage.x4.b r46, boolean r47, defpackage.w4 r48, defpackage.w4 r49, int r50, int r51, int r52, int r53, float r54, boolean r55, boolean r56, boolean r57, boolean r58, boolean r59, int r60, int r61, int r62, int r63, float r64, boolean r65) {
        /*
            Method dump skipped, instructions count: 1872
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x4.i(e4, boolean, boolean, boolean, boolean, j4, j4, x4$b, boolean, w4, w4, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* compiled from: ConstraintWidget.java */
    /* renamed from: x4$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[b.values().length];
            b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[w4.b.values().length];
            a = iArr2;
            try {
                iArr2[w4.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[w4.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[w4.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[w4.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[w4.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[w4.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[w4.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[w4.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
            try {
                a[w4.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    public void k1(e4 system, boolean optimize) {
        t5 t5Var;
        r5 r5Var;
        int left = system.x(this.O);
        int top = system.x(this.P);
        int right = system.x(this.Q);
        int bottom = system.x(this.R);
        if (optimize && (r5Var = this.f) != null) {
            l5 l5Var = r5Var.h;
            if (l5Var.j) {
                l5 l5Var2 = r5Var.i;
                if (l5Var2.j) {
                    left = l5Var.g;
                    right = l5Var2.g;
                }
            }
        }
        if (optimize && (t5Var = this.g) != null) {
            l5 l5Var3 = t5Var.h;
            if (l5Var3.j) {
                l5 l5Var4 = t5Var.i;
                if (l5Var4.j) {
                    top = l5Var3.g;
                    bottom = l5Var4.g;
                }
            }
        }
        int w = right - left;
        int h = bottom - top;
        if (w < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
        }
        D0(left, top, right, bottom);
    }

    public void j1(boolean updateHorizontal, boolean updateVertical) {
        boolean updateHorizontal2 = updateHorizontal & this.f.k();
        boolean updateVertical2 = updateVertical & this.g.k();
        r5 r5Var = this.f;
        int left = r5Var.h.g;
        t5 t5Var = this.g;
        int top = t5Var.h.g;
        int right = r5Var.i.g;
        int bottom = t5Var.i.g;
        int h = bottom - top;
        if (right - left < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
        }
        int w = right - left;
        int h2 = bottom - top;
        if (updateHorizontal2) {
            this.f0 = left;
        }
        if (updateVertical2) {
            this.g0 = top;
        }
        if (this.s0 == 8) {
            this.b0 = 0;
            this.c0 = 0;
            return;
        }
        if (updateHorizontal2) {
            if (this.Z[0] == b.FIXED && w < this.b0) {
                w = this.b0;
            }
            this.b0 = w;
            int i = this.m0;
            if (w < i) {
                this.b0 = i;
            }
        }
        if (updateVertical2) {
            if (this.Z[1] == b.FIXED && h2 < this.c0) {
                h2 = this.c0;
            }
            this.c0 = h2;
            int i2 = this.n0;
            if (h2 < i2) {
                this.c0 = i2;
            }
        }
    }

    public void e(y4 container, e4 system, HashSet<x4> hashSet, int orientation, boolean addSelf) {
        if (addSelf) {
            if (!hashSet.contains(this)) {
                return;
            }
            d5.a(container, system, this);
            hashSet.remove(this);
            g(system, container.N1(64));
        }
        if (orientation == 0) {
            HashSet<w4> d = this.O.d();
            if (d != null) {
                Iterator<w4> it = d.iterator();
                while (it.hasNext()) {
                    w4 anchor = it.next();
                    anchor.d.e(container, system, hashSet, orientation, true);
                }
            }
            HashSet<w4> d2 = this.Q.d();
            if (d2 != null) {
                Iterator<w4> it2 = d2.iterator();
                while (it2.hasNext()) {
                    w4 anchor2 = it2.next();
                    anchor2.d.e(container, system, hashSet, orientation, true);
                }
                return;
            }
            return;
        }
        HashSet<w4> d3 = this.P.d();
        if (d3 != null) {
            Iterator<w4> it3 = d3.iterator();
            while (it3.hasNext()) {
                w4 anchor3 = it3.next();
                anchor3.d.e(container, system, hashSet, orientation, true);
            }
        }
        HashSet<w4> d4 = this.R.d();
        if (d4 != null) {
            Iterator<w4> it4 = d4.iterator();
            while (it4.hasNext()) {
                w4 anchor4 = it4.next();
                anchor4.d.e(container, system, hashSet, orientation, true);
            }
        }
        HashSet<w4> d5 = this.S.d();
        if (d5 != null) {
            Iterator<w4> it5 = d5.iterator();
            while (it5.hasNext()) {
                w4 anchor5 = it5.next();
                anchor5.d.e(container, system, hashSet, orientation, true);
            }
        }
    }
}
