package defpackage;

import defpackage.l5;
import defpackage.v5;
import defpackage.w4;
import defpackage.x4;
/* compiled from: VerticalWidgetRun.java */
/* renamed from: t5  reason: default package */
/* loaded from: classes.dex */
public class t5 extends v5 {
    public l5 k;
    public m5 l;

    public t5(x4 widget) {
        super(widget);
        l5 l5Var = new l5(this);
        this.k = l5Var;
        this.l = null;
        this.h.e = l5.a.TOP;
        this.i.e = l5.a.BOTTOM;
        l5Var.e = l5.a.BASELINE;
        this.f = 1;
    }

    public String toString() {
        return "VerticalRun " + this.b.t();
    }

    @Override // defpackage.v5
    public void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    public void q() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.k.c();
        this.k.j = false;
        this.e.j = false;
    }

    @Override // defpackage.v5
    public boolean m() {
        return this.d != x4.b.MATCH_CONSTRAINT || this.b.x == 0;
    }

    /* compiled from: VerticalWidgetRun.java */
    /* renamed from: t5$a */
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
                n(dependency, x4Var.P, x4Var.R, 1);
                return;
        }
        m5 m5Var = this.e;
        if (m5Var.c && !m5Var.j && this.d == x4.b.MATCH_CONSTRAINT) {
            x4 x4Var2 = this.b;
            switch (x4Var2.x) {
                case 2:
                    x4 parent = x4Var2.K();
                    if (parent != null) {
                        m5 m5Var2 = parent.g.e;
                        if (m5Var2.j) {
                            float percent = this.b.E;
                            int targetDimensionValue = m5Var2.g;
                            int size = (int) ((targetDimensionValue * percent) + 0.5f);
                            this.e.d(size);
                            break;
                        }
                    }
                    break;
                case 3:
                    if (x4Var2.f.e.j) {
                        int size2 = 0;
                        int ratioSide = x4Var2.w();
                        switch (ratioSide) {
                            case -1:
                                x4 x4Var3 = this.b;
                                size2 = (int) ((x4Var3.f.e.g / x4Var3.v()) + 0.5f);
                                break;
                            case 0:
                                x4 x4Var4 = this.b;
                                size2 = (int) ((x4Var4.f.e.g * x4Var4.v()) + 0.5f);
                                break;
                            case 1:
                                x4 x4Var5 = this.b;
                                size2 = (int) ((x4Var5.f.e.g / x4Var5.v()) + 0.5f);
                                break;
                        }
                        this.e.d(size2);
                        break;
                    }
                    break;
            }
        }
        l5 l5Var = this.h;
        if (l5Var.c) {
            l5 l5Var2 = this.i;
            if (!l5Var2.c) {
                return;
            }
            if (l5Var.j && l5Var2.j && this.e.j) {
                return;
            }
            if (!this.e.j && this.d == x4.b.MATCH_CONSTRAINT) {
                x4 x4Var6 = this.b;
                if (x4Var6.w == 0 && !x4Var6.h0()) {
                    l5 startTarget = this.h.l.get(0);
                    int i = startTarget.g;
                    l5 l5Var3 = this.h;
                    int startPos = i + l5Var3.f;
                    int endPos = this.i.l.get(0).g + this.i.f;
                    int distance = endPos - startPos;
                    l5Var3.d(startPos);
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
                m5 m5Var3 = this.e;
                int i2 = m5Var3.m;
                if (availableSpace < i2) {
                    m5Var3.d(availableSpace);
                } else {
                    m5Var3.d(i2);
                }
            }
            l5 startTarget4 = this.e;
            if (startTarget4.j && this.h.l.size() > 0 && this.i.l.size() > 0) {
                l5 startTarget5 = this.h.l.get(0);
                l5 endTarget = this.i.l.get(0);
                int startPos3 = startTarget5.g + this.h.f;
                int endPos3 = endTarget.g + this.i.f;
                float bias = this.b.O();
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
    }

    @Override // defpackage.v5
    public void d() {
        x4 parent;
        x4 parent2;
        x4 x4Var = this.b;
        if (x4Var.b) {
            this.e.d(x4Var.x());
        }
        if (!this.e.j) {
            this.d = this.b.Q();
            if (this.b.W()) {
                this.l = new g5(this);
            }
            x4.b bVar = this.d;
            if (bVar != x4.b.MATCH_CONSTRAINT) {
                if (bVar == x4.b.MATCH_PARENT && (parent2 = this.b.K()) != null && parent2.Q() == x4.b.FIXED) {
                    int resolvedDimension = (parent2.x() - this.b.P.f()) - this.b.R.f();
                    b(this.h, parent2.g.h, this.b.P.f());
                    b(this.i, parent2.g.i, -this.b.R.f());
                    this.e.d(resolvedDimension);
                    return;
                } else if (this.d == x4.b.FIXED) {
                    this.e.d(this.b.x());
                }
            }
        } else if (this.d == x4.b.MATCH_PARENT && (parent = this.b.K()) != null && parent.Q() == x4.b.FIXED) {
            b(this.h, parent.g.h, this.b.P.f());
            b(this.i, parent.g.i, -this.b.R.f());
            return;
        }
        m5 m5Var = this.e;
        boolean z = m5Var.j;
        if (z) {
            x4 x4Var2 = this.b;
            if (x4Var2.b) {
                w4[] w4VarArr = x4Var2.W;
                if (w4VarArr[2].f != null && w4VarArr[3].f != null) {
                    if (x4Var2.h0()) {
                        this.h.f = this.b.W[2].f();
                        this.i.f = -this.b.W[3].f();
                    } else {
                        l5 startTarget = h(this.b.W[2]);
                        if (startTarget != null) {
                            b(this.h, startTarget, this.b.W[2].f());
                        }
                        l5 endTarget = h(this.b.W[3]);
                        if (endTarget != null) {
                            b(this.i, endTarget, -this.b.W[3].f());
                        }
                        this.h.b = true;
                        this.i.b = true;
                    }
                    if (this.b.W()) {
                        b(this.k, this.h, this.b.p());
                        return;
                    }
                    return;
                } else if (w4VarArr[2].f != null) {
                    l5 target = h(w4VarArr[2]);
                    if (target != null) {
                        b(this.h, target, this.b.W[2].f());
                        b(this.i, this.h, this.e.g);
                        if (this.b.W()) {
                            b(this.k, this.h, this.b.p());
                            return;
                        }
                        return;
                    }
                    return;
                } else if (w4VarArr[3].f != null) {
                    l5 target2 = h(w4VarArr[3]);
                    if (target2 != null) {
                        b(this.i, target2, -this.b.W[3].f());
                        b(this.h, this.i, -this.e.g);
                    }
                    if (this.b.W()) {
                        b(this.k, this.h, this.b.p());
                        return;
                    }
                    return;
                } else if (w4VarArr[4].f != null) {
                    l5 target3 = h(w4VarArr[4]);
                    if (target3 != null) {
                        b(this.k, target3, 0);
                        b(this.h, this.k, -this.b.p());
                        b(this.i, this.h, this.e.g);
                        return;
                    }
                    return;
                } else if (!(x4Var2 instanceof b5) && x4Var2.K() != null && this.b.o(w4.b.CENTER).f == null) {
                    l5 top = this.b.K().g.h;
                    b(this.h, top, this.b.V());
                    b(this.i, this.h, this.e.g);
                    if (this.b.W()) {
                        b(this.k, this.h, this.b.p());
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        if (!z && this.d == x4.b.MATCH_CONSTRAINT) {
            x4 x4Var3 = this.b;
            switch (x4Var3.x) {
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
                    if (!x4Var3.h0()) {
                        x4 x4Var4 = this.b;
                        if (x4Var4.w != 3) {
                            l5 targetDimension2 = x4Var4.f.e;
                            this.e.l.add(targetDimension2);
                            targetDimension2.k.add(this.e);
                            m5 m5Var3 = this.e;
                            m5Var3.b = true;
                            m5Var3.k.add(this.h);
                            this.e.k.add(this.i);
                            break;
                        }
                    }
                    break;
            }
        } else {
            m5Var.b(this);
        }
        x4 x4Var5 = this.b;
        w4[] w4VarArr2 = x4Var5.W;
        if (w4VarArr2[2].f != null && w4VarArr2[3].f != null) {
            if (x4Var5.h0()) {
                this.h.f = this.b.W[2].f();
                this.i.f = -this.b.W[3].f();
            } else {
                l5 startTarget2 = h(this.b.W[2]);
                l5 endTarget2 = h(this.b.W[3]);
                if (startTarget2 != null) {
                    startTarget2.b(this);
                }
                if (endTarget2 != null) {
                    endTarget2.b(this);
                }
                this.j = v5.b.CENTER;
            }
            if (this.b.W()) {
                c(this.k, this.h, 1, this.l);
            }
        } else if (w4VarArr2[2].f != null) {
            l5 target4 = h(w4VarArr2[2]);
            if (target4 != null) {
                b(this.h, target4, this.b.W[2].f());
                c(this.i, this.h, 1, this.e);
                if (this.b.W()) {
                    c(this.k, this.h, 1, this.l);
                }
                x4.b bVar2 = this.d;
                x4.b bVar3 = x4.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.b.v() > 0.0f) {
                    r5 r5Var = this.b.f;
                    if (r5Var.d == bVar3) {
                        r5Var.e.k.add(this.e);
                        this.e.l.add(this.b.f.e);
                        this.e.a = this;
                    }
                }
            }
        } else if (w4VarArr2[3].f != null) {
            l5 target5 = h(w4VarArr2[3]);
            if (target5 != null) {
                b(this.i, target5, -this.b.W[3].f());
                c(this.h, this.i, -1, this.e);
                if (this.b.W()) {
                    c(this.k, this.h, 1, this.l);
                }
            }
        } else if (w4VarArr2[4].f != null) {
            l5 target6 = h(w4VarArr2[4]);
            if (target6 != null) {
                b(this.k, target6, 0);
                c(this.h, this.k, -1, this.l);
                c(this.i, this.h, 1, this.e);
            }
        } else if (!(x4Var5 instanceof b5) && x4Var5.K() != null) {
            l5 top2 = this.b.K().g.h;
            b(this.h, top2, this.b.V());
            c(this.i, this.h, 1, this.e);
            if (this.b.W()) {
                c(this.k, this.h, 1, this.l);
            }
            x4.b bVar4 = this.d;
            x4.b bVar5 = x4.b.MATCH_CONSTRAINT;
            if (bVar4 == bVar5 && this.b.v() > 0.0f) {
                r5 r5Var2 = this.b.f;
                if (r5Var2.d == bVar5) {
                    r5Var2.e.k.add(this.e);
                    this.e.l.add(this.b.f.e);
                    this.e.a = this;
                }
            }
        }
        l5 top3 = this.e;
        if (top3.l.size() == 0) {
            this.e.c = true;
        }
    }

    @Override // defpackage.v5
    public void e() {
        l5 l5Var = this.h;
        if (l5Var.j) {
            this.b.h1(l5Var.g);
        }
    }
}
