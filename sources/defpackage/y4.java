package defpackage;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import defpackage.h5;
import defpackage.x4;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: ConstraintWidgetContainer.java */
/* renamed from: y4  reason: default package */
/* loaded from: classes.dex */
public class y4 extends f5 {
    public static int K0 = 0;
    public int N0;
    public f4 Q0;
    public int S0;
    public int T0;
    public int U0;
    public int V0;
    public h5 L0 = new h5(this);
    public k5 M0 = new k5(this);
    public h5.b O0 = null;
    public boolean P0 = false;
    public e4 R0 = new e4();
    public int W0 = 0;
    public int X0 = 0;
    public v4[] Y0 = new v4[4];
    public v4[] Z0 = new v4[4];
    public boolean a1 = false;
    public boolean b1 = false;
    public boolean c1 = false;
    public int d1 = 0;
    public int e1 = 0;
    public int f1 = 257;
    public boolean g1 = false;
    public boolean h1 = false;
    public boolean i1 = false;
    public int j1 = 0;
    public WeakReference<w4> k1 = null;
    public WeakReference<w4> l1 = null;
    public WeakReference<w4> m1 = null;
    public WeakReference<w4> n1 = null;
    public HashSet<x4> o1 = new HashSet<>();
    public h5.a p1 = new h5.a();

    public void G1() {
        this.M0.j();
    }

    public void H1() {
        this.M0.k();
    }

    public boolean z1(boolean optimizeWrap) {
        return this.M0.f(optimizeWrap);
    }

    public boolean A1(boolean optimizeWrap) {
        return this.M0.g(optimizeWrap);
    }

    public boolean B1(boolean optimizeWrap, int orientation) {
        return this.M0.h(optimizeWrap, orientation);
    }

    public long L1(int optimizationLevel, int widthMode, int widthSize, int heightMode, int heightSize, int lastMeasureWidth, int lastMeasureHeight, int paddingX, int paddingY) {
        this.S0 = paddingX;
        this.T0 = paddingY;
        return this.L0.d(this, optimizationLevel, paddingX, paddingY, widthMode, widthSize, heightMode, heightSize, lastMeasureWidth, lastMeasureHeight);
    }

    public void U1() {
        this.L0.e(this);
    }

    public void P1(h5.b measurer) {
        this.O0 = measurer;
        this.M0.n(measurer);
    }

    public h5.b C1() {
        return this.O0;
    }

    public void Q1(int value) {
        this.f1 = value;
        e4.a = N1(IInputController.KEYCODE_BACK_BUTTON);
    }

    public int D1() {
        return this.f1;
    }

    public boolean N1(int feature) {
        return (this.f1 & feature) == feature;
    }

    @Override // defpackage.f5, defpackage.x4
    public void q0() {
        this.R0.D();
        this.S0 = 0;
        this.U0 = 0;
        this.T0 = 0;
        this.V0 = 0;
        this.g1 = false;
        super.q0();
    }

    public boolean K1() {
        return this.h1;
    }

    public boolean I1() {
        return this.i1;
    }

    public void y1(w4 top) {
        WeakReference<w4> weakReference = this.k1;
        if (weakReference == null || weakReference.get() == null || top.e() > this.k1.get().e()) {
            this.k1 = new WeakReference<>(top);
        }
    }

    public void t1(w4 left) {
        WeakReference<w4> weakReference = this.l1;
        if (weakReference == null || weakReference.get() == null || left.e() > this.l1.get().e()) {
            this.l1 = new WeakReference<>(left);
        }
    }

    public void x1(w4 bottom) {
        WeakReference<w4> weakReference = this.m1;
        if (weakReference == null || weakReference.get() == null || bottom.e() > this.m1.get().e()) {
            this.m1 = new WeakReference<>(bottom);
        }
    }

    public void s1(w4 right) {
        WeakReference<w4> weakReference = this.n1;
        if (weakReference == null || weakReference.get() == null || right.e() > this.n1.get().e()) {
            this.n1 = new WeakReference<>(right);
        }
    }

    public final void v1(w4 constraintAnchor, j4 parentMin) {
        j4 variable = this.R0.q(constraintAnchor);
        this.R0.h(variable, parentMin, 0, 5);
    }

    public final void u1(w4 constraintAnchor, j4 parentMax) {
        j4 variable = this.R0.q(constraintAnchor);
        this.R0.h(parentMax, variable, 0, 5);
    }

    public boolean q1(e4 system) {
        int orientation;
        boolean optimize = N1(64);
        g(system, optimize);
        int count = this.J0.size();
        boolean hasBarriers = false;
        for (int i = 0; i < count; i++) {
            x4 widget = this.J0.get(i);
            widget.M0(0, false);
            widget.M0(1, false);
            if (widget instanceof t4) {
                hasBarriers = true;
            }
        }
        if (hasBarriers) {
            for (int i2 = 0; i2 < count; i2++) {
                x4 widget2 = this.J0.get(i2);
                if (widget2 instanceof t4) {
                    ((t4) widget2).s1();
                }
            }
        }
        this.o1.clear();
        for (int i3 = 0; i3 < count; i3++) {
            x4 widget3 = this.J0.get(i3);
            if (widget3.f()) {
                if (widget3 instanceof e5) {
                    this.o1.add(widget3);
                } else {
                    widget3.g(system, optimize);
                }
            }
        }
        while (this.o1.size() > 0) {
            int numLayouts = this.o1.size();
            Iterator<x4> it = this.o1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e5 layout = (e5) it.next();
                if (layout.p1(this.o1)) {
                    layout.g(system, optimize);
                    this.o1.remove(layout);
                    break;
                }
            }
            if (numLayouts == this.o1.size()) {
                Iterator<x4> it2 = this.o1.iterator();
                while (it2.hasNext()) {
                    it2.next().g(system, optimize);
                }
                this.o1.clear();
            }
        }
        if (e4.a) {
            HashSet<x4> hashSet = new HashSet<>();
            for (int i4 = 0; i4 < count; i4++) {
                x4 widget4 = this.J0.get(i4);
                if (!widget4.f()) {
                    hashSet.add(widget4);
                }
            }
            if (A() != x4.b.WRAP_CONTENT) {
                orientation = 1;
            } else {
                orientation = 0;
            }
            e(this, system, hashSet, orientation, false);
            Iterator<x4> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                x4 widget5 = it3.next();
                d5.a(this, system, widget5);
                widget5.g(system, optimize);
            }
        } else {
            for (int i5 = 0; i5 < count; i5++) {
                x4 widget6 = this.J0.get(i5);
                if (widget6 instanceof y4) {
                    x4.b[] bVarArr = widget6.Z;
                    x4.b horizontalBehaviour = bVarArr[0];
                    x4.b verticalBehaviour = bVarArr[1];
                    x4.b bVar = x4.b.WRAP_CONTENT;
                    if (horizontalBehaviour == bVar) {
                        widget6.J0(x4.b.FIXED);
                    }
                    if (verticalBehaviour == bVar) {
                        widget6.a1(x4.b.FIXED);
                    }
                    widget6.g(system, optimize);
                    if (horizontalBehaviour == bVar) {
                        widget6.J0(horizontalBehaviour);
                    }
                    if (verticalBehaviour == bVar) {
                        widget6.a1(verticalBehaviour);
                    }
                } else {
                    d5.a(this, system, widget6);
                    if (!widget6.f()) {
                        widget6.g(system, optimize);
                    }
                }
            }
        }
        int i6 = this.W0;
        if (i6 > 0) {
            u4.b(this, system, null, 0);
        }
        if (this.X0 > 0) {
            u4.b(this, system, null, 1);
        }
        return true;
    }

    public boolean T1(e4 system, boolean[] flags) {
        flags[2] = false;
        boolean optimize = N1(64);
        k1(system, optimize);
        int count = this.J0.size();
        boolean hasOverride = false;
        for (int i = 0; i < count; i++) {
            x4 widget = this.J0.get(i);
            widget.k1(system, optimize);
            if (widget.Z()) {
                hasOverride = true;
            }
        }
        return hasOverride;
    }

    @Override // defpackage.x4
    public void j1(boolean updateHorizontal, boolean updateVertical) {
        super.j1(updateHorizontal, updateVertical);
        int count = this.J0.size();
        for (int i = 0; i < count; i++) {
            x4 widget = this.J0.get(i);
            widget.j1(updateHorizontal, updateVertical);
        }
    }

    public void S1(boolean isRtl) {
        this.P0 = isRtl;
    }

    public boolean J1() {
        return this.P0;
    }

    public static boolean M1(int level, x4 widget, h5.b measurer, h5.a measure, int measureStrategy) {
        int measuredWidth;
        int measuredHeight;
        if (measurer == null) {
            return false;
        }
        if (widget.S() == 8 || (widget instanceof a5) || (widget instanceof t4)) {
            measure.h = 0;
            measure.i = 0;
            return false;
        }
        measure.d = widget.A();
        measure.e = widget.Q();
        measure.f = widget.T();
        measure.g = widget.x();
        measure.l = false;
        measure.m = measureStrategy;
        x4.b bVar = measure.d;
        x4.b bVar2 = x4.b.MATCH_CONSTRAINT;
        boolean horizontalMatchConstraints = bVar == bVar2;
        boolean verticalMatchConstraints = measure.e == bVar2;
        boolean horizontalUseRatio = horizontalMatchConstraints && widget.d0 > 0.0f;
        boolean verticalUseRatio = verticalMatchConstraints && widget.d0 > 0.0f;
        if (horizontalMatchConstraints && widget.X(0) && widget.w == 0 && !horizontalUseRatio) {
            horizontalMatchConstraints = false;
            measure.d = x4.b.WRAP_CONTENT;
            if (verticalMatchConstraints && widget.x == 0) {
                measure.d = x4.b.FIXED;
            }
        }
        if (verticalMatchConstraints && widget.X(1) && widget.x == 0 && !verticalUseRatio) {
            verticalMatchConstraints = false;
            measure.e = x4.b.WRAP_CONTENT;
            if (horizontalMatchConstraints && widget.w == 0) {
                measure.e = x4.b.FIXED;
            }
        }
        if (widget.k0()) {
            horizontalMatchConstraints = false;
            measure.d = x4.b.FIXED;
        }
        if (widget.l0()) {
            verticalMatchConstraints = false;
            measure.e = x4.b.FIXED;
        }
        if (horizontalUseRatio) {
            if (widget.y[0] == 4) {
                measure.d = x4.b.FIXED;
            } else if (!verticalMatchConstraints) {
                x4.b bVar3 = measure.e;
                x4.b bVar4 = x4.b.FIXED;
                if (bVar3 == bVar4) {
                    measuredHeight = measure.g;
                } else {
                    measure.d = x4.b.WRAP_CONTENT;
                    measurer.b(widget, measure);
                    measuredHeight = measure.i;
                }
                measure.d = bVar4;
                measure.f = (int) (widget.v() * measuredHeight);
            }
        }
        if (verticalUseRatio) {
            if (widget.y[1] == 4) {
                measure.e = x4.b.FIXED;
            } else if (!horizontalMatchConstraints) {
                x4.b bVar5 = measure.d;
                x4.b bVar6 = x4.b.FIXED;
                if (bVar5 == bVar6) {
                    measuredWidth = measure.f;
                } else {
                    measure.e = x4.b.WRAP_CONTENT;
                    measurer.b(widget, measure);
                    measuredWidth = measure.h;
                }
                measure.e = bVar6;
                if (widget.w() == -1) {
                    measure.g = (int) (measuredWidth / widget.v());
                } else {
                    measure.g = (int) (widget.v() * measuredWidth);
                }
            }
        }
        measurer.b(widget, measure);
        widget.e1(measure.h);
        widget.F0(measure.i);
        widget.E0(measure.k);
        widget.u0(measure.j);
        measure.m = h5.a.a;
        return measure.l;
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0338 A[SYNTHETIC] */
    @Override // defpackage.f5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m1() {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y4.m1():void");
    }

    public boolean F1() {
        return false;
    }

    public e4 E1() {
        return this.R0;
    }

    public final void O1() {
        this.W0 = 0;
        this.X0 = 0;
    }

    public void p1(x4 constraintWidget, int type) {
        if (type == 0) {
            r1(constraintWidget);
        } else if (type == 1) {
            w1(constraintWidget);
        }
    }

    public final void r1(x4 widget) {
        int i = this.W0 + 1;
        v4[] v4VarArr = this.Z0;
        if (i >= v4VarArr.length) {
            this.Z0 = (v4[]) Arrays.copyOf(v4VarArr, v4VarArr.length * 2);
        }
        this.Z0[this.W0] = new v4(widget, 0, J1());
        this.W0++;
    }

    public final void w1(x4 widget) {
        int i = this.X0 + 1;
        v4[] v4VarArr = this.Y0;
        if (i >= v4VarArr.length) {
            this.Y0 = (v4[]) Arrays.copyOf(v4VarArr, v4VarArr.length * 2);
        }
        this.Y0[this.X0] = new v4(widget, 1, J1());
        this.X0++;
    }

    public void R1(int pass) {
        this.N0 = pass;
    }
}
