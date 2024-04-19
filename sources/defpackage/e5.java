package defpackage;

import defpackage.h5;
import defpackage.x4;
import java.util.HashSet;
/* compiled from: VirtualLayout.java */
/* renamed from: e5  reason: default package */
/* loaded from: classes.dex */
public class e5 extends c5 {
    public int L0 = 0;
    public int M0 = 0;
    public int N0 = 0;
    public int O0 = 0;
    public int P0 = 0;
    public int Q0 = 0;
    public int R0 = 0;
    public int S0 = 0;
    public boolean T0 = false;
    public int U0 = 0;
    public int V0 = 0;
    public h5.a W0 = new h5.a();
    public h5.b X0 = null;

    public void C1(int value) {
        this.N0 = value;
        this.L0 = value;
        this.O0 = value;
        this.M0 = value;
        this.P0 = value;
        this.Q0 = value;
    }

    public void H1(int value) {
        this.P0 = value;
        this.R0 = value;
        this.S0 = value;
    }

    public void E1(int value) {
        this.Q0 = value;
    }

    public void F1(int value) {
        this.N0 = value;
        this.R0 = value;
    }

    public void n1(boolean isRtl) {
        int i = this.P0;
        if (i > 0 || this.Q0 > 0) {
            if (isRtl) {
                this.R0 = this.Q0;
                this.S0 = i;
                return;
            }
            this.R0 = i;
            this.S0 = this.Q0;
        }
    }

    public void I1(int value) {
        this.L0 = value;
    }

    public void G1(int value) {
        this.O0 = value;
        this.S0 = value;
    }

    public void D1(int value) {
        this.M0 = value;
    }

    public int v1() {
        return this.L0;
    }

    public int s1() {
        return this.M0;
    }

    public int t1() {
        return this.R0;
    }

    public int u1() {
        return this.S0;
    }

    public void A1(boolean value) {
        this.T0 = value;
    }

    public boolean z1() {
        return this.T0;
    }

    public void w1(int widthMode, int widthSize, int heightMode, int heightSize) {
    }

    @Override // defpackage.c5, defpackage.b5
    public void a(y4 container) {
        o1();
    }

    public void o1() {
        for (int i = 0; i < this.K0; i++) {
            x4 widget = this.J0[i];
            if (widget != null) {
                widget.O0(true);
            }
        }
    }

    public int r1() {
        return this.U0;
    }

    public int q1() {
        return this.V0;
    }

    public void B1(int width, int height) {
        this.U0 = width;
        this.V0 = height;
    }

    public boolean y1() {
        h5.b measurer = null;
        x4 x4Var = this.a0;
        if (x4Var != null) {
            measurer = ((y4) x4Var).C1();
        }
        if (measurer == null) {
            return false;
        }
        int i = 0;
        while (true) {
            boolean skip = true;
            if (i >= this.K0) {
                return true;
            }
            x4 widget = this.J0[i];
            if (widget != null && !(widget instanceof a5)) {
                x4.b widthBehavior = widget.u(0);
                x4.b heightBehavior = widget.u(1);
                x4.b bVar = x4.b.MATCH_CONSTRAINT;
                if (widthBehavior != bVar || widget.w == 1 || heightBehavior != bVar || widget.x == 1) {
                    skip = false;
                }
                if (!skip) {
                    if (widthBehavior == bVar) {
                        widthBehavior = x4.b.WRAP_CONTENT;
                    }
                    if (heightBehavior == bVar) {
                        heightBehavior = x4.b.WRAP_CONTENT;
                    }
                    h5.a aVar = this.W0;
                    aVar.d = widthBehavior;
                    aVar.e = heightBehavior;
                    aVar.f = widget.T();
                    this.W0.g = widget.x();
                    measurer.b(widget, this.W0);
                    widget.e1(this.W0.h);
                    widget.F0(this.W0.i);
                    widget.u0(this.W0.j);
                }
            }
            i++;
        }
    }

    public void x1(x4 widget, x4.b horizontalBehavior, int horizontalDimension, x4.b verticalBehavior, int verticalDimension) {
        while (this.X0 == null && K() != null) {
            y4 parent = (y4) K();
            this.X0 = parent.C1();
        }
        h5.a aVar = this.W0;
        aVar.d = horizontalBehavior;
        aVar.e = verticalBehavior;
        aVar.f = horizontalDimension;
        aVar.g = verticalDimension;
        this.X0.b(widget, aVar);
        widget.e1(this.W0.h);
        widget.F0(this.W0.i);
        widget.E0(this.W0.k);
        widget.u0(this.W0.j);
    }

    public boolean p1(HashSet<x4> hashSet) {
        for (int i = 0; i < this.K0; i++) {
            x4 widget = this.J0[i];
            if (hashSet.contains(widget)) {
                return true;
            }
        }
        return false;
    }
}
