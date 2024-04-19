package defpackage;

import defpackage.l5;
import defpackage.v5;
import defpackage.w4;
import defpackage.x4;
/* compiled from: HorizontalWidgetRun.java */
/* renamed from: r5  reason: default package */
/* loaded from: classes.dex */
public class r5 extends v5 {
    public static int[] k = new int[2];

    public r5(x4 widget) {
        super(widget);
        this.h.e = l5.a.LEFT;
        this.i.e = l5.a.RIGHT;
        this.f = 0;
    }

    public String toString() {
        return "HorizontalRun " + this.b.t();
    }

    @Override // defpackage.v5
    public void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    public void r() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.e.j = false;
    }

    @Override // defpackage.v5
    public boolean m() {
        return this.d != x4.b.MATCH_CONSTRAINT || this.b.w == 0;
    }

    @Override // defpackage.v5
    public void d() {
        x4 parent;
        x4 parent2;
        x4 x4Var = this.b;
        if (x4Var.b) {
            this.e.d(x4Var.T());
        }
        if (!this.e.j) {
            x4.b A = this.b.A();
            this.d = A;
            if (A != x4.b.MATCH_CONSTRAINT) {
                x4.b bVar = x4.b.MATCH_PARENT;
                if (A == bVar && (parent2 = this.b.K()) != null && (parent2.A() == x4.b.FIXED || parent2.A() == bVar)) {
                    int resolvedDimension = (parent2.T() - this.b.O.f()) - this.b.Q.f();
                    b(this.h, parent2.f.h, this.b.O.f());
                    b(this.i, parent2.f.i, -this.b.Q.f());
                    this.e.d(resolvedDimension);
                    return;
                } else if (this.d == x4.b.FIXED) {
                    this.e.d(this.b.T());
                }
            }
        } else {
            x4.b bVar2 = this.d;
            x4.b bVar3 = x4.b.MATCH_PARENT;
            if (bVar2 == bVar3 && (parent = this.b.K()) != null && (parent.A() == x4.b.FIXED || parent.A() == bVar3)) {
                b(this.h, parent.f.h, this.b.O.f());
                b(this.i, parent.f.i, -this.b.Q.f());
                return;
            }
        }
        m5 m5Var = this.e;
        if (m5Var.j) {
            x4 x4Var2 = this.b;
            if (x4Var2.b) {
                w4[] w4VarArr = x4Var2.W;
                if (w4VarArr[0].f != null && w4VarArr[1].f != null) {
                    if (x4Var2.f0()) {
                        this.h.f = this.b.W[0].f();
                        this.i.f = -this.b.W[1].f();
                        return;
                    }
                    l5 startTarget = h(this.b.W[0]);
                    if (startTarget != null) {
                        b(this.h, startTarget, this.b.W[0].f());
                    }
                    l5 endTarget = h(this.b.W[1]);
                    if (endTarget != null) {
                        b(this.i, endTarget, -this.b.W[1].f());
                    }
                    this.h.b = true;
                    this.i.b = true;
                    return;
                } else if (w4VarArr[0].f != null) {
                    l5 target = h(w4VarArr[0]);
                    if (target != null) {
                        b(this.h, target, this.b.W[0].f());
                        b(this.i, this.h, this.e.g);
                        return;
                    }
                    return;
                } else if (w4VarArr[1].f != null) {
                    l5 target2 = h(w4VarArr[1]);
                    if (target2 != null) {
                        b(this.i, target2, -this.b.W[1].f());
                        b(this.h, this.i, -this.e.g);
                        return;
                    }
                    return;
                } else if (!(x4Var2 instanceof b5) && x4Var2.K() != null && this.b.o(w4.b.CENTER).f == null) {
                    l5 left = this.b.K().f.h;
                    b(this.h, left, this.b.U());
                    b(this.i, this.h, this.e.g);
                    return;
                } else {
                    return;
                }
            }
        }
        if (this.d == x4.b.MATCH_CONSTRAINT) {
            x4 x4Var3 = this.b;
            switch (x4Var3.w) {
                case 2:
                    x4 parent3 = x4Var3.K();
                    if (parent3 != null) {
                        l5 targetDimension = parent3.g.e;
                        this.e.l.add(targetDimension);
                        targetDimension.k.add(this.e);
                        m5 m5Var2 = this.e;
                        m5Var2.b = true;
                        m5Var2.k.add(this.h);
                        this.e.k.add(this.i);
                        break;
                    }
                    break;
                case 3:
                    if (x4Var3.x == 3) {
                        this.h.a = this;
                        this.i.a = this;
                        t5 t5Var = x4Var3.g;
                        t5Var.h.a = this;
                        t5Var.i.a = this;
                        m5Var.a = this;
                        if (x4Var3.h0()) {
                            this.e.l.add(this.b.g.e);
                            this.b.g.e.k.add(this.e);
                            t5 t5Var2 = this.b.g;
                            t5Var2.e.a = this;
                            this.e.l.add(t5Var2.h);
                            this.e.l.add(this.b.g.i);
                            this.b.g.h.k.add(this.e);
                            this.b.g.i.k.add(this.e);
                            break;
                        } else if (this.b.f0()) {
                            this.b.g.e.l.add(this.e);
                            this.e.k.add(this.b.g.e);
                            break;
                        } else {
                            this.b.g.e.l.add(this.e);
                            break;
                        }
                    } else {
                        l5 targetDimension2 = x4Var3.g.e;
                        m5Var.l.add(targetDimension2);
                        targetDimension2.k.add(this.e);
                        this.b.g.h.k.add(this.e);
                        this.b.g.i.k.add(this.e);
                        m5 m5Var3 = this.e;
                        m5Var3.b = true;
                        m5Var3.k.add(this.h);
                        this.e.k.add(this.i);
                        this.h.l.add(this.e);
                        this.i.l.add(this.e);
                        break;
                    }
            }
        }
        x4 x4Var4 = this.b;
        w4[] w4VarArr2 = x4Var4.W;
        if (w4VarArr2[0].f != null && w4VarArr2[1].f != null) {
            if (x4Var4.f0()) {
                this.h.f = this.b.W[0].f();
                this.i.f = -this.b.W[1].f();
                return;
            }
            l5 startTarget2 = h(this.b.W[0]);
            l5 endTarget2 = h(this.b.W[1]);
            if (startTarget2 != null) {
                startTarget2.b(this);
            }
            if (endTarget2 != null) {
                endTarget2.b(this);
            }
            this.j = v5.b.CENTER;
        } else if (w4VarArr2[0].f != null) {
            l5 target3 = h(w4VarArr2[0]);
            if (target3 != null) {
                b(this.h, target3, this.b.W[0].f());
                c(this.i, this.h, 1, this.e);
            }
        } else if (w4VarArr2[1].f != null) {
            l5 target4 = h(w4VarArr2[1]);
            if (target4 != null) {
                b(this.i, target4, -this.b.W[1].f());
                c(this.h, this.i, -1, this.e);
            }
        } else if (!(x4Var4 instanceof b5) && x4Var4.K() != null) {
            l5 left2 = this.b.K().f.h;
            b(this.h, left2, this.b.U());
            c(this.i, this.h, 1, this.e);
        }
    }

    public final void q(int[] dimensions, int x1, int x2, int y1, int y2, float ratio, int side) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        switch (side) {
            case -1:
                int candidateX1 = (int) ((dy * ratio) + 0.5f);
                int candidateY2 = (int) ((dx / ratio) + 0.5f);
                if (candidateX1 <= dx && dy <= dy) {
                    dimensions[0] = candidateX1;
                    dimensions[1] = dy;
                    return;
                } else if (dx <= dx && candidateY2 <= dy) {
                    dimensions[0] = dx;
                    dimensions[1] = candidateY2;
                    return;
                } else {
                    return;
                }
            case 0:
                int horizontalSide = (int) ((dy * ratio) + 0.5f);
                dimensions[0] = horizontalSide;
                dimensions[1] = dy;
                return;
            case 1:
                int verticalSide = (int) ((dx * ratio) + 0.5f);
                dimensions[0] = dx;
                dimensions[1] = verticalSide;
                return;
            default:
                return;
        }
    }

    /* compiled from: HorizontalWidgetRun.java */
    /* renamed from: r5$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[v5.b.values().length];
            a = iArr;
            try {
                iArr[v5.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[v5.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[v5.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Override // defpackage.v5, defpackage.j5
    public void a(j5 dependency) {
        switch (a.a[this.j.ordinal()]) {
            case 1:
                p(dependency);
                break;
            case 2:
                o(dependency);
                break;
            case 3:
                x4 x4Var = this.b;
                n(dependency, x4Var.O, x4Var.Q, 0);
                return;
        }
        if (!this.e.j && this.d == x4.b.MATCH_CONSTRAINT) {
            x4 x4Var2 = this.b;
            switch (x4Var2.w) {
                case 2:
                    x4 parent = x4Var2.K();
                    if (parent != null) {
                        m5 m5Var = parent.f.e;
                        if (m5Var.j) {
                            float percent = this.b.B;
                            int targetDimensionValue = m5Var.g;
                            int size = (int) ((targetDimensionValue * percent) + 0.5f);
                            this.e.d(size);
                            break;
                        }
                    }
                    break;
                case 3:
                    int i = x4Var2.x;
                    if (i == 0 || i == 3) {
                        t5 t5Var = x4Var2.g;
                        l5 secondStart = t5Var.h;
                        l5 secondEnd = t5Var.i;
                        boolean s1 = x4Var2.O.f != null;
                        boolean s2 = x4Var2.P.f != null;
                        boolean e1 = x4Var2.Q.f != null;
                        boolean e2 = x4Var2.R.f != null;
                        int definedSide = x4Var2.w();
                        if (s1 && s2 && e1 && e2) {
                            float ratio = this.b.v();
                            if (secondStart.j && secondEnd.j) {
                                l5 l5Var = this.h;
                                if (!l5Var.c || !this.i.c) {
                                    return;
                                }
                                q(k, l5Var.l.get(0).g + this.h.f, this.i.l.get(0).g - this.i.f, secondStart.g + secondStart.f, secondEnd.g - secondEnd.f, ratio, definedSide);
                                this.e.d(k[0]);
                                this.b.g.e.d(k[1]);
                                return;
                            }
                            l5 l5Var2 = this.h;
                            if (l5Var2.j) {
                                l5 l5Var3 = this.i;
                                if (l5Var3.j) {
                                    if (!secondStart.c || !secondEnd.c) {
                                        return;
                                    }
                                    q(k, l5Var2.g + l5Var2.f, l5Var3.g - l5Var3.f, secondStart.l.get(0).g + secondStart.f, secondEnd.l.get(0).g - secondEnd.f, ratio, definedSide);
                                    this.e.d(k[0]);
                                    this.b.g.e.d(k[1]);
                                }
                            }
                            l5 l5Var4 = this.h;
                            if (!l5Var4.c || !this.i.c || !secondStart.c || !secondEnd.c) {
                                return;
                            }
                            q(k, l5Var4.l.get(0).g + this.h.f, this.i.l.get(0).g - this.i.f, secondStart.l.get(0).g + secondStart.f, secondEnd.l.get(0).g - secondEnd.f, ratio, definedSide);
                            this.e.d(k[0]);
                            this.b.g.e.d(k[1]);
                            break;
                        } else if (s1 && e1) {
                            if (!this.h.c || !this.i.c) {
                                return;
                            }
                            float ratio2 = this.b.v();
                            int x1 = this.h.l.get(0).g + this.h.f;
                            int x2 = this.i.l.get(0).g - this.i.f;
                            switch (definedSide) {
                                case -1:
                                case 0:
                                    int ldx = g(x2 - x1, 0);
                                    int dy = (int) ((ldx * ratio2) + 0.5f);
                                    int ldy = g(dy, 1);
                                    if (dy != ldy) {
                                        ldx = (int) ((ldy / ratio2) + 0.5f);
                                    }
                                    this.e.d(ldx);
                                    this.b.g.e.d(ldy);
                                    break;
                                case 1:
                                    int ldx2 = g(x2 - x1, 0);
                                    int dy2 = (int) ((ldx2 / ratio2) + 0.5f);
                                    int ldy2 = g(dy2, 1);
                                    if (dy2 != ldy2) {
                                        ldx2 = (int) ((ldy2 * ratio2) + 0.5f);
                                    }
                                    this.e.d(ldx2);
                                    this.b.g.e.d(ldy2);
                                    break;
                            }
                        } else if (s2 && e2) {
                            if (!secondStart.c || !secondEnd.c) {
                                return;
                            }
                            float ratio3 = this.b.v();
                            int y1 = secondStart.l.get(0).g + secondStart.f;
                            int y2 = secondEnd.l.get(0).g - secondEnd.f;
                            switch (definedSide) {
                                case -1:
                                case 1:
                                    int dy3 = y2 - y1;
                                    int ldy3 = g(dy3, 1);
                                    int dx = (int) ((ldy3 / ratio3) + 0.5f);
                                    int ldx3 = g(dx, 0);
                                    if (dx != ldx3) {
                                        ldy3 = (int) ((ldx3 * ratio3) + 0.5f);
                                    }
                                    this.e.d(ldx3);
                                    this.b.g.e.d(ldy3);
                                    break;
                                case 0:
                                    int dy4 = y2 - y1;
                                    int ldy4 = g(dy4, 1);
                                    int dx2 = (int) ((ldy4 * ratio3) + 0.5f);
                                    int ldx4 = g(dx2, 0);
                                    if (dx2 != ldx4) {
                                        ldy4 = (int) ((ldx4 / ratio3) + 0.5f);
                                    }
                                    this.e.d(ldx4);
                                    this.b.g.e.d(ldy4);
                                    break;
                            }
                        }
                    } else {
                        int size2 = 0;
                        int ratioSide = x4Var2.w();
                        switch (ratioSide) {
                            case -1:
                                x4 x4Var3 = this.b;
                                size2 = (int) ((x4Var3.g.e.g * x4Var3.v()) + 0.5f);
                                break;
                            case 0:
                                x4 x4Var4 = this.b;
                                size2 = (int) ((x4Var4.g.e.g / x4Var4.v()) + 0.5f);
                                break;
                            case 1:
                                x4 x4Var5 = this.b;
                                size2 = (int) ((x4Var5.g.e.g * x4Var5.v()) + 0.5f);
                                break;
                        }
                        this.e.d(size2);
                        break;
                    }
                    break;
            }
        }
        l5 l5Var5 = this.h;
        if (l5Var5.c) {
            l5 l5Var6 = this.i;
            if (!l5Var6.c) {
                return;
            }
            if (l5Var5.j && l5Var6.j && this.e.j) {
                return;
            }
            if (!this.e.j && this.d == x4.b.MATCH_CONSTRAINT) {
                x4 x4Var6 = this.b;
                if (x4Var6.w == 0 && !x4Var6.f0()) {
                    l5 startTarget = this.h.l.get(0);
                    int i2 = startTarget.g;
                    l5 l5Var7 = this.h;
                    int startPos = i2 + l5Var7.f;
                    int endPos = this.i.l.get(0).g + this.i.f;
                    int distance = endPos - startPos;
                    l5Var7.d(startPos);
                    this.i.d(endPos);
                    this.e.d(distance);
                    return;
                }
            }
            l5 startTarget2 = this.e;
            if (!startTarget2.j && this.d == x4.b.MATCH_CONSTRAINT && this.a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                l5 startTarget3 = this.h.l.get(0);
                int startPos2 = startTarget3.g + this.h.f;
                int endPos2 = this.i.l.get(0).g + this.i.f;
                int availableSpace = endPos2 - startPos2;
                int value = Math.min(availableSpace, this.e.m);
                x4 x4Var7 = this.b;
                int max = x4Var7.A;
                int min = x4Var7.z;
                int value2 = Math.max(min, value);
                if (max > 0) {
                    value2 = Math.min(max, value2);
                }
                this.e.d(value2);
            }
            l5 startTarget4 = this.e;
            if (!startTarget4.j) {
                return;
            }
            l5 startTarget5 = this.h.l.get(0);
            l5 endTarget = this.i.l.get(0);
            int startPos3 = startTarget5.g + this.h.f;
            int endPos3 = endTarget.g + this.i.f;
            float bias = this.b.y();
            if (startTarget5 == endTarget) {
                startPos3 = startTarget5.g;
                endPos3 = endTarget.g;
                bias = 0.5f;
            }
            int distance2 = (endPos3 - startPos3) - this.e.g;
            this.h.d((int) (startPos3 + 0.5f + (distance2 * bias)));
            this.i.d(this.h.g + this.e.g);
        }
    }

    @Override // defpackage.v5
    public void e() {
        l5 l5Var = this.h;
        if (l5Var.j) {
            this.b.g1(l5Var.g);
        }
    }
}
