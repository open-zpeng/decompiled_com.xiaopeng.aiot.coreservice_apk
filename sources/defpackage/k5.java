package defpackage;

import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import defpackage.h5;
import defpackage.x4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: DependencyGraph.java */
/* renamed from: k5  reason: default package */
/* loaded from: classes.dex */
public class k5 {
    public y4 a;
    public y4 d;
    public boolean b = true;
    public boolean c = true;
    public ArrayList<v5> e = new ArrayList<>();
    public ArrayList<s5> f = new ArrayList<>();
    public h5.b g = null;
    public h5.a h = new h5.a();
    public ArrayList<s5> i = new ArrayList<>();

    public k5(y4 container) {
        this.a = container;
        this.d = container;
    }

    public void n(h5.b measurer) {
        this.g = measurer;
    }

    public final int e(y4 container, int orientation) {
        int count = this.i.size();
        long wrapSize = 0;
        for (int i = 0; i < count; i++) {
            s5 run = this.i.get(i);
            long size = run.b(container, orientation);
            wrapSize = Math.max(wrapSize, size);
        }
        int i2 = (int) wrapSize;
        return i2;
    }

    public boolean f(boolean optimizeWrap) {
        boolean optimizeWrap2 = optimizeWrap & true;
        if (this.b || this.c) {
            Iterator<x4> it = this.a.J0.iterator();
            while (it.hasNext()) {
                x4 widget = it.next();
                widget.n();
                widget.b = false;
                widget.f.r();
                widget.g.q();
            }
            this.a.n();
            y4 y4Var = this.a;
            y4Var.b = false;
            y4Var.f.r();
            this.a.g.q();
            this.c = false;
        }
        boolean avoid = b(this.d);
        if (avoid) {
            return false;
        }
        this.a.g1(0);
        this.a.h1(0);
        x4.b originalHorizontalDimension = this.a.u(0);
        x4.b originalVerticalDimension = this.a.u(1);
        if (this.b) {
            c();
        }
        int x1 = this.a.U();
        int y1 = this.a.V();
        this.a.f.h.d(x1);
        this.a.g.h.d(y1);
        m();
        x4.b bVar = x4.b.WRAP_CONTENT;
        if (originalHorizontalDimension == bVar || originalVerticalDimension == bVar) {
            if (optimizeWrap2) {
                Iterator<v5> it2 = this.e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (!it2.next().m()) {
                        optimizeWrap2 = false;
                        break;
                    }
                }
            }
            if (optimizeWrap2 && originalHorizontalDimension == x4.b.WRAP_CONTENT) {
                this.a.J0(x4.b.FIXED);
                y4 y4Var2 = this.a;
                y4Var2.e1(e(y4Var2, 0));
                y4 y4Var3 = this.a;
                y4Var3.f.e.d(y4Var3.T());
            }
            if (optimizeWrap2 && originalVerticalDimension == x4.b.WRAP_CONTENT) {
                this.a.a1(x4.b.FIXED);
                y4 y4Var4 = this.a;
                y4Var4.F0(e(y4Var4, 1));
                y4 y4Var5 = this.a;
                y4Var5.g.e.d(y4Var5.x());
            }
        }
        boolean checkRoot = false;
        y4 y4Var6 = this.a;
        x4.b[] bVarArr = y4Var6.Z;
        x4.b bVar2 = bVarArr[0];
        x4.b bVar3 = x4.b.FIXED;
        if (bVar2 == bVar3 || bVarArr[0] == x4.b.MATCH_PARENT) {
            int x2 = y4Var6.T() + x1;
            this.a.f.i.d(x2);
            this.a.f.e.d(x2 - x1);
            m();
            y4 y4Var7 = this.a;
            x4.b[] bVarArr2 = y4Var7.Z;
            if (bVarArr2[1] == bVar3 || bVarArr2[1] == x4.b.MATCH_PARENT) {
                int y2 = y4Var7.x() + y1;
                this.a.g.i.d(y2);
                this.a.g.e.d(y2 - y1);
            }
            m();
            checkRoot = true;
        }
        Iterator<v5> it3 = this.e.iterator();
        while (it3.hasNext()) {
            v5 run = it3.next();
            if (run.b != this.a || run.g) {
                run.e();
            }
        }
        boolean allResolved = true;
        Iterator<v5> it4 = this.e.iterator();
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            v5 run2 = it4.next();
            if (checkRoot || run2.b != this.a) {
                if (!run2.h.j) {
                    allResolved = false;
                    break;
                } else if (!run2.i.j && !(run2 instanceof p5)) {
                    allResolved = false;
                    break;
                } else if (!run2.e.j && !(run2 instanceof i5) && !(run2 instanceof p5)) {
                    allResolved = false;
                    break;
                }
            }
        }
        this.a.J0(originalHorizontalDimension);
        this.a.a1(originalVerticalDimension);
        return allResolved;
    }

    public boolean g(boolean optimizeWrap) {
        if (this.b) {
            Iterator<x4> it = this.a.J0.iterator();
            while (it.hasNext()) {
                x4 widget = it.next();
                widget.n();
                widget.b = false;
                r5 r5Var = widget.f;
                r5Var.e.j = false;
                r5Var.g = false;
                r5Var.r();
                t5 t5Var = widget.g;
                t5Var.e.j = false;
                t5Var.g = false;
                t5Var.q();
            }
            this.a.n();
            y4 y4Var = this.a;
            y4Var.b = false;
            r5 r5Var2 = y4Var.f;
            r5Var2.e.j = false;
            r5Var2.g = false;
            r5Var2.r();
            t5 t5Var2 = this.a.g;
            t5Var2.e.j = false;
            t5Var2.g = false;
            t5Var2.q();
            c();
        }
        boolean avoid = b(this.d);
        if (avoid) {
            return false;
        }
        this.a.g1(0);
        this.a.h1(0);
        this.a.f.h.d(0);
        this.a.g.h.d(0);
        return true;
    }

    public boolean h(boolean optimizeWrap, int orientation) {
        x4.b bVar;
        boolean optimizeWrap2 = optimizeWrap & true;
        x4.b originalHorizontalDimension = this.a.u(0);
        x4.b originalVerticalDimension = this.a.u(1);
        int x1 = this.a.U();
        int y1 = this.a.V();
        if (optimizeWrap2 && (originalHorizontalDimension == (bVar = x4.b.WRAP_CONTENT) || originalVerticalDimension == bVar)) {
            Iterator<v5> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                v5 run = it.next();
                if (run.f == orientation && !run.m()) {
                    optimizeWrap2 = false;
                    break;
                }
            }
            if (orientation == 0) {
                if (optimizeWrap2 && originalHorizontalDimension == x4.b.WRAP_CONTENT) {
                    this.a.J0(x4.b.FIXED);
                    y4 y4Var = this.a;
                    y4Var.e1(e(y4Var, 0));
                    y4 y4Var2 = this.a;
                    y4Var2.f.e.d(y4Var2.T());
                }
            } else if (optimizeWrap2 && originalVerticalDimension == x4.b.WRAP_CONTENT) {
                this.a.a1(x4.b.FIXED);
                y4 y4Var3 = this.a;
                y4Var3.F0(e(y4Var3, 1));
                y4 y4Var4 = this.a;
                y4Var4.g.e.d(y4Var4.x());
            }
        }
        boolean checkRoot = false;
        if (orientation == 0) {
            y4 y4Var5 = this.a;
            x4.b[] bVarArr = y4Var5.Z;
            if (bVarArr[0] == x4.b.FIXED || bVarArr[0] == x4.b.MATCH_PARENT) {
                int x2 = y4Var5.T() + x1;
                this.a.f.i.d(x2);
                this.a.f.e.d(x2 - x1);
                checkRoot = true;
            }
        } else {
            y4 y4Var6 = this.a;
            x4.b[] bVarArr2 = y4Var6.Z;
            if (bVarArr2[1] == x4.b.FIXED || bVarArr2[1] == x4.b.MATCH_PARENT) {
                int y2 = y4Var6.x() + y1;
                this.a.g.i.d(y2);
                this.a.g.e.d(y2 - y1);
                checkRoot = true;
            }
        }
        m();
        Iterator<v5> it2 = this.e.iterator();
        while (it2.hasNext()) {
            v5 run2 = it2.next();
            if (run2.f == orientation && (run2.b != this.a || run2.g)) {
                run2.e();
            }
        }
        boolean allResolved = true;
        Iterator<v5> it3 = this.e.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            v5 run3 = it3.next();
            if (run3.f == orientation && (checkRoot || run3.b != this.a)) {
                if (!run3.h.j) {
                    allResolved = false;
                    break;
                } else if (!run3.i.j) {
                    allResolved = false;
                    break;
                } else if (!(run3 instanceof i5) && !run3.e.j) {
                    allResolved = false;
                    break;
                }
            }
        }
        this.a.J0(originalHorizontalDimension);
        this.a.a1(originalVerticalDimension);
        return allResolved;
    }

    public final void l(x4 widget, x4.b horizontalBehavior, int horizontalDimension, x4.b verticalBehavior, int verticalDimension) {
        h5.a aVar = this.h;
        aVar.d = horizontalBehavior;
        aVar.e = verticalBehavior;
        aVar.f = horizontalDimension;
        aVar.g = verticalDimension;
        this.g.b(widget, aVar);
        widget.e1(this.h.h);
        widget.F0(this.h.i);
        widget.E0(this.h.k);
        widget.u0(this.h.j);
    }

    public final boolean b(y4 constraintWidgetContainer) {
        x4.b horizontal;
        x4.b vertical;
        x4.b bVar;
        x4.b bVar2;
        Iterator<x4> it = constraintWidgetContainer.J0.iterator();
        while (it.hasNext()) {
            x4 widget = it.next();
            x4.b[] bVarArr = widget.Z;
            x4.b horizontal2 = bVarArr[0];
            x4.b vertical2 = bVarArr[1];
            if (widget.S() == 8) {
                widget.b = true;
            } else {
                if (widget.B < 1.0f && horizontal2 == x4.b.MATCH_CONSTRAINT) {
                    widget.w = 2;
                }
                if (widget.E < 1.0f && vertical2 == x4.b.MATCH_CONSTRAINT) {
                    widget.x = 2;
                }
                if (widget.v() > 0.0f) {
                    x4.b bVar3 = x4.b.MATCH_CONSTRAINT;
                    if (horizontal2 == bVar3 && (vertical2 == x4.b.WRAP_CONTENT || vertical2 == x4.b.FIXED)) {
                        widget.w = 3;
                    } else if (vertical2 == bVar3 && (horizontal2 == x4.b.WRAP_CONTENT || horizontal2 == x4.b.FIXED)) {
                        widget.x = 3;
                    } else if (horizontal2 == bVar3 && vertical2 == bVar3) {
                        if (widget.w == 0) {
                            widget.w = 3;
                        }
                        if (widget.x == 0) {
                            widget.x = 3;
                        }
                    }
                }
                x4.b bVar4 = x4.b.MATCH_CONSTRAINT;
                if (horizontal2 == bVar4 && widget.w == 1 && (widget.O.f == null || widget.Q.f == null)) {
                    horizontal = x4.b.WRAP_CONTENT;
                } else {
                    horizontal = horizontal2;
                }
                if (vertical2 == bVar4 && widget.x == 1 && (widget.P.f == null || widget.R.f == null)) {
                    vertical = x4.b.WRAP_CONTENT;
                } else {
                    vertical = vertical2;
                }
                r5 r5Var = widget.f;
                r5Var.d = horizontal;
                int i = widget.w;
                r5Var.a = i;
                t5 t5Var = widget.g;
                t5Var.d = vertical;
                int i2 = widget.x;
                t5Var.a = i2;
                x4.b bVar5 = x4.b.MATCH_PARENT;
                if ((horizontal == bVar5 || horizontal == x4.b.FIXED || horizontal == x4.b.WRAP_CONTENT) && (vertical == bVar5 || vertical == x4.b.FIXED || vertical == x4.b.WRAP_CONTENT)) {
                    int width = widget.T();
                    if (horizontal == bVar5) {
                        width = (constraintWidgetContainer.T() - widget.O.g) - widget.Q.g;
                        horizontal = x4.b.FIXED;
                    }
                    int height = widget.x();
                    if (vertical == bVar5) {
                        height = (constraintWidgetContainer.x() - widget.P.g) - widget.R.g;
                        vertical = x4.b.FIXED;
                    }
                    l(widget, horizontal, width, vertical, height);
                    widget.f.e.d(widget.T());
                    widget.g.e.d(widget.x());
                    widget.b = true;
                } else {
                    if (horizontal == bVar4 && (vertical == (bVar2 = x4.b.WRAP_CONTENT) || vertical == x4.b.FIXED)) {
                        if (i == 3) {
                            if (vertical == bVar2) {
                                l(widget, bVar2, 0, bVar2, 0);
                            }
                            int height2 = widget.x();
                            int width2 = (int) ((height2 * widget.d0) + 0.5f);
                            x4.b bVar6 = x4.b.FIXED;
                            l(widget, bVar6, width2, bVar6, height2);
                            widget.f.e.d(widget.T());
                            widget.g.e.d(widget.x());
                            widget.b = true;
                        } else if (i == 1) {
                            l(widget, bVar2, 0, vertical, 0);
                            widget.f.e.m = widget.T();
                        } else if (i == 2) {
                            x4.b[] bVarArr2 = constraintWidgetContainer.Z;
                            x4.b bVar7 = bVarArr2[0];
                            x4.b bVar8 = x4.b.FIXED;
                            if (bVar7 == bVar8 || bVarArr2[0] == bVar5) {
                                float percent = widget.B;
                                int width3 = (int) ((constraintWidgetContainer.T() * percent) + 0.5f);
                                int height3 = widget.x();
                                l(widget, bVar8, width3, vertical, height3);
                                widget.f.e.d(widget.T());
                                widget.g.e.d(widget.x());
                                widget.b = true;
                            }
                        } else {
                            w4[] w4VarArr = widget.W;
                            if (w4VarArr[0].f == null || w4VarArr[1].f == null) {
                                l(widget, bVar2, 0, vertical, 0);
                                widget.f.e.d(widget.T());
                                widget.g.e.d(widget.x());
                                widget.b = true;
                            }
                        }
                    }
                    if (vertical == bVar4 && (horizontal == (bVar = x4.b.WRAP_CONTENT) || horizontal == x4.b.FIXED)) {
                        if (i2 == 3) {
                            if (horizontal == bVar) {
                                l(widget, bVar, 0, bVar, 0);
                            }
                            int width4 = widget.T();
                            float ratio = widget.d0;
                            if (widget.w() == -1) {
                                ratio = 1.0f / ratio;
                            }
                            int height4 = (int) ((width4 * ratio) + 0.5f);
                            x4.b bVar9 = x4.b.FIXED;
                            l(widget, bVar9, width4, bVar9, height4);
                            widget.f.e.d(widget.T());
                            widget.g.e.d(widget.x());
                            widget.b = true;
                        } else if (i2 == 1) {
                            l(widget, horizontal, 0, bVar, 0);
                            widget.g.e.m = widget.x();
                        } else if (i2 == 2) {
                            x4.b[] bVarArr3 = constraintWidgetContainer.Z;
                            x4.b bVar10 = bVarArr3[1];
                            x4.b bVar11 = x4.b.FIXED;
                            if (bVar10 == bVar11 || bVarArr3[1] == bVar5) {
                                float percent2 = widget.E;
                                int width5 = widget.T();
                                int height5 = (int) ((constraintWidgetContainer.x() * percent2) + 0.5f);
                                l(widget, horizontal, width5, bVar11, height5);
                                widget.f.e.d(widget.T());
                                widget.g.e.d(widget.x());
                                widget.b = true;
                            }
                        } else {
                            w4[] w4VarArr2 = widget.W;
                            if (w4VarArr2[2].f == null || w4VarArr2[3].f == null) {
                                l(widget, bVar, 0, vertical, 0);
                                widget.f.e.d(widget.T());
                                widget.g.e.d(widget.x());
                                widget.b = true;
                            }
                        }
                    }
                    if (horizontal == bVar4 && vertical == bVar4) {
                        if (i == 1 || i2 == 1) {
                            x4.b bVar12 = x4.b.WRAP_CONTENT;
                            l(widget, bVar12, 0, bVar12, 0);
                            widget.f.e.m = widget.T();
                            widget.g.e.m = widget.x();
                        } else if (i2 == 2 && i == 2) {
                            x4.b[] bVarArr4 = constraintWidgetContainer.Z;
                            x4.b bVar13 = bVarArr4[0];
                            x4.b bVar14 = x4.b.FIXED;
                            if (bVar13 == bVar14 && bVarArr4[1] == bVar14) {
                                float horizPercent = widget.B;
                                float vertPercent = widget.E;
                                int width6 = (int) ((constraintWidgetContainer.T() * horizPercent) + 0.5f);
                                int height6 = (int) ((constraintWidgetContainer.x() * vertPercent) + 0.5f);
                                l(widget, bVar14, width6, bVar14, height6);
                                widget.f.e.d(widget.T());
                                widget.g.e.d(widget.x());
                                widget.b = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void m() {
        m5 m5Var;
        Iterator<x4> it = this.a.J0.iterator();
        while (it.hasNext()) {
            x4 widget = it.next();
            if (!widget.b) {
                x4.b[] bVarArr = widget.Z;
                boolean z = false;
                x4.b horiz = bVarArr[0];
                x4.b vert = bVarArr[1];
                int horizMatchConstraintsType = widget.w;
                int vertMatchConstraintsType = widget.x;
                x4.b bVar = x4.b.WRAP_CONTENT;
                boolean horizWrap = horiz == bVar || (horiz == x4.b.MATCH_CONSTRAINT && horizMatchConstraintsType == 1);
                if (vert == bVar || (vert == x4.b.MATCH_CONSTRAINT && vertMatchConstraintsType == 1)) {
                    z = true;
                }
                boolean vertWrap = z;
                m5 m5Var2 = widget.f.e;
                boolean horizResolved = m5Var2.j;
                m5 m5Var3 = widget.g.e;
                boolean vertResolved = m5Var3.j;
                if (horizResolved && vertResolved) {
                    x4.b bVar2 = x4.b.FIXED;
                    l(widget, bVar2, m5Var2.g, bVar2, m5Var3.g);
                    widget.b = true;
                } else if (horizResolved && vertWrap) {
                    l(widget, x4.b.FIXED, m5Var2.g, bVar, m5Var3.g);
                    if (vert == x4.b.MATCH_CONSTRAINT) {
                        widget.g.e.m = widget.x();
                    } else {
                        widget.g.e.d(widget.x());
                        widget.b = true;
                    }
                } else if (vertResolved && horizWrap) {
                    l(widget, bVar, m5Var2.g, x4.b.FIXED, m5Var3.g);
                    if (horiz == x4.b.MATCH_CONSTRAINT) {
                        widget.f.e.m = widget.T();
                    } else {
                        widget.f.e.d(widget.T());
                        widget.b = true;
                    }
                }
                if (widget.b && (m5Var = widget.g.l) != null) {
                    m5Var.d(widget.p());
                }
            }
        }
    }

    public void j() {
        this.b = true;
    }

    public void k() {
        this.c = true;
    }

    public void c() {
        d(this.e);
        this.i.clear();
        s5.a = 0;
        i(this.a.f, 0, this.i);
        i(this.a.g, 1, this.i);
        this.b = false;
    }

    public void d(ArrayList<v5> arrayList) {
        arrayList.clear();
        this.d.f.f();
        this.d.g.f();
        arrayList.add(this.d.f);
        arrayList.add(this.d.g);
        HashSet<ChainRun> chainRuns = null;
        Iterator<x4> it = this.d.J0.iterator();
        while (it.hasNext()) {
            x4 widget = it.next();
            if (widget instanceof a5) {
                arrayList.add(new p5(widget));
            } else {
                if (widget.f0()) {
                    if (widget.d == null) {
                        widget.d = new i5(widget, 0);
                    }
                    if (chainRuns == null) {
                        chainRuns = new HashSet<>();
                    }
                    chainRuns.add(widget.d);
                } else {
                    arrayList.add(widget.f);
                }
                if (widget.h0()) {
                    if (widget.e == null) {
                        widget.e = new i5(widget, 1);
                    }
                    if (chainRuns == null) {
                        chainRuns = new HashSet<>();
                    }
                    chainRuns.add(widget.e);
                } else {
                    arrayList.add(widget.g);
                }
                if (widget instanceof c5) {
                    arrayList.add(new q5(widget));
                }
            }
        }
        if (chainRuns != null) {
            arrayList.addAll(chainRuns);
        }
        Iterator<v5> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<v5> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            v5 run = it3.next();
            if (run.b != this.d) {
                run.d();
            }
        }
    }

    public final void a(l5 node, int orientation, int direction, l5 end, ArrayList<s5> arrayList, s5 group) {
        s5 group2;
        v5 run = node.d;
        if (run.c == null) {
            y4 y4Var = this.a;
            if (run != y4Var.f) {
                if (run == y4Var.g) {
                    return;
                }
                if (group == null) {
                    s5 group3 = new s5(run, direction);
                    arrayList.add(group3);
                    group2 = group3;
                } else {
                    group2 = group;
                }
                run.c = group2;
                group2.a(run);
                for (j5 dependent : run.h.k) {
                    if (dependent instanceof l5) {
                        a((l5) dependent, orientation, 0, end, arrayList, group2);
                    }
                }
                for (j5 dependent2 : run.i.k) {
                    if (dependent2 instanceof l5) {
                        a((l5) dependent2, orientation, 1, end, arrayList, group2);
                    }
                }
                if (orientation == 1 && (run instanceof t5)) {
                    for (j5 dependent3 : ((t5) run).k.k) {
                        if (dependent3 instanceof l5) {
                            a((l5) dependent3, orientation, 2, end, arrayList, group2);
                        }
                    }
                }
                for (l5 target : run.h.l) {
                    if (target == end) {
                        group2.c = true;
                    }
                    a(target, orientation, 0, end, arrayList, group2);
                }
                for (l5 target2 : run.i.l) {
                    if (target2 == end) {
                        group2.c = true;
                    }
                    a(target2, orientation, 1, end, arrayList, group2);
                }
                if (orientation == 1 && (run instanceof t5)) {
                    for (l5 target3 : ((t5) run).k.l) {
                        a(target3, orientation, 2, end, arrayList, group2);
                    }
                }
            }
        }
    }

    public final void i(v5 run, int orientation, ArrayList<s5> arrayList) {
        for (j5 dependent : run.h.k) {
            if (dependent instanceof l5) {
                l5 node = (l5) dependent;
                a(node, orientation, 0, run.i, arrayList, null);
            } else if (dependent instanceof v5) {
                v5 dependentRun = (v5) dependent;
                a(dependentRun.h, orientation, 0, run.i, arrayList, null);
            }
        }
        for (j5 dependent2 : run.i.k) {
            if (dependent2 instanceof l5) {
                l5 node2 = (l5) dependent2;
                a(node2, orientation, 1, run.h, arrayList, null);
            } else if (dependent2 instanceof v5) {
                v5 dependentRun2 = (v5) dependent2;
                a(dependentRun2.i, orientation, 1, run.h, arrayList, null);
            }
        }
        if (orientation == 1) {
            for (j5 dependent3 : ((t5) run).k.k) {
                if (dependent3 instanceof l5) {
                    l5 node3 = (l5) dependent3;
                    a(node3, orientation, 2, null, arrayList, null);
                }
            }
        }
    }
}
