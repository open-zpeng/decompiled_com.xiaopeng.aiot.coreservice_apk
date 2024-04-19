package defpackage;

import defpackage.w4;
import defpackage.x4;
import java.util.ArrayList;
/* compiled from: BasicMeasure.java */
/* renamed from: h5  reason: default package */
/* loaded from: classes.dex */
public class h5 {
    public final ArrayList<x4> a = new ArrayList<>();
    public a b = new a();
    public y4 c;

    /* compiled from: BasicMeasure.java */
    /* renamed from: h5$a */
    /* loaded from: classes.dex */
    public static class a {
        public static int a = 0;
        public static int b = 1;
        public static int c = 2;
        public x4.b d;
        public x4.b e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public boolean k;
        public boolean l;
        public int m;
    }

    /* compiled from: BasicMeasure.java */
    /* renamed from: h5$b */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b(x4 x4Var, a aVar);
    }

    public void e(y4 layout) {
        this.a.clear();
        int childCount = layout.J0.size();
        for (int i = 0; i < childCount; i++) {
            x4 widget = layout.J0.get(i);
            x4.b A = widget.A();
            x4.b bVar = x4.b.MATCH_CONSTRAINT;
            if (A == bVar || widget.Q() == bVar) {
                this.a.add(widget);
            }
        }
        layout.G1();
    }

    public h5(y4 constraintWidgetContainer) {
        this.c = constraintWidgetContainer;
    }

    public final void b(y4 layout) {
        r5 r5Var;
        t5 t5Var;
        int childCount = layout.J0.size();
        boolean optimize = layout.N1(64);
        b measurer = layout.C1();
        for (int i = 0; i < childCount; i++) {
            x4 child = layout.J0.get(i);
            if (!(child instanceof a5) && !(child instanceof t4) && !child.i0() && (!optimize || (r5Var = child.f) == null || (t5Var = child.g) == null || !r5Var.e.j || !t5Var.e.j)) {
                boolean skip = false;
                x4.b widthBehavior = child.u(0);
                x4.b heightBehavior = child.u(1);
                x4.b bVar = x4.b.MATCH_CONSTRAINT;
                if (widthBehavior == bVar && child.w != 1 && heightBehavior == bVar && child.x != 1) {
                    skip = true;
                }
                if (!skip && layout.N1(1) && !(child instanceof e5)) {
                    if (widthBehavior == bVar && child.w == 0 && heightBehavior != bVar && !child.f0()) {
                        skip = true;
                    }
                    if (heightBehavior == bVar && child.x == 0 && widthBehavior != bVar && !child.f0()) {
                        skip = true;
                    }
                    if ((widthBehavior == bVar || heightBehavior == bVar) && child.d0 > 0.0f) {
                        skip = true;
                    }
                }
                if (skip) {
                    continue;
                } else {
                    a(measurer, child, a.a);
                    if (layout.Q0 != null) {
                        throw null;
                    }
                }
            }
        }
        measurer.a();
    }

    public final void c(y4 layout, String reason, int pass, int w, int h) {
        int minWidth = layout.I();
        int minHeight = layout.H();
        layout.U0(0);
        layout.T0(0);
        layout.e1(w);
        layout.F0(h);
        layout.U0(minWidth);
        layout.T0(minHeight);
        this.c.R1(pass);
        this.c.m1();
    }

    public long d(y4 layout, int optimizationLevel, int paddingX, int paddingY, int widthMode, int widthSize, int heightMode, int heightSize, int lastMeasureWidth, int lastMeasureHeight) {
        boolean optimize;
        boolean matchHeight;
        boolean z;
        boolean allSolved;
        int computations;
        int sizeDependentWidgetsCount;
        int optimizations;
        boolean z2;
        boolean z3;
        long layoutTime;
        int sizeDependentWidgetsCount2;
        long layoutTime2;
        int maxIterations;
        int childCount;
        boolean preWidth;
        boolean allSolved2;
        int widthSize2;
        boolean z4;
        h5 h5Var = this;
        b measurer = layout.C1();
        long layoutTime3 = 0;
        int childCount2 = layout.J0.size();
        int startingWidth = layout.T();
        int startingHeight = layout.x();
        boolean optimizeWrap = d5.b(optimizationLevel, 128);
        boolean optimize2 = optimizeWrap || d5.b(optimizationLevel, 64);
        if (optimize2) {
            int i = 0;
            while (i < childCount2) {
                x4 child = layout.J0.get(i);
                x4.b A = child.A();
                x4.b bVar = x4.b.MATCH_CONSTRAINT;
                boolean matchWidth = A == bVar;
                boolean optimize3 = optimize2;
                boolean matchHeight2 = child.Q() == bVar;
                boolean ratio = matchWidth && matchHeight2 && child.v() > 0.0f;
                if (!child.f0() || !ratio) {
                    if (child.h0() && ratio) {
                        matchHeight = false;
                        break;
                    }
                    boolean matchHeight3 = child instanceof e5;
                    if (matchHeight3) {
                        matchHeight = false;
                        break;
                    }
                    if (child.f0() || child.h0()) {
                        matchHeight = false;
                        break;
                    }
                    i++;
                    optimize2 = optimize3;
                } else {
                    matchHeight = false;
                    break;
                }
            }
            optimize = optimize2;
        } else {
            optimize = optimize2;
        }
        matchHeight = optimize;
        if (!matchHeight || e4.h == null) {
            boolean optimize4 = matchHeight & ((widthMode == 1073741824 && heightMode == 1073741824) || optimizeWrap);
            int computations2 = 0;
            if (optimize4) {
                int widthSize3 = Math.min(layout.G(), widthSize);
                int heightSize2 = Math.min(layout.F(), heightSize);
                if (widthMode == 1073741824 && layout.T() != widthSize3) {
                    layout.e1(widthSize3);
                    layout.G1();
                }
                if (heightMode == 1073741824 && layout.x() != heightSize2) {
                    layout.F0(heightSize2);
                    layout.G1();
                }
                if (widthMode == 1073741824 && heightMode == 1073741824) {
                    allSolved2 = layout.z1(optimizeWrap);
                    computations2 = 2;
                    widthSize2 = widthSize3;
                    z4 = true;
                } else {
                    allSolved2 = layout.A1(optimizeWrap);
                    if (widthMode == 1073741824) {
                        widthSize2 = widthSize3;
                        allSolved2 &= layout.B1(optimizeWrap, 0);
                        computations2 = 0 + 1;
                    } else {
                        widthSize2 = widthSize3;
                    }
                    if (heightMode == 1073741824) {
                        z4 = true;
                        allSolved2 &= layout.B1(optimizeWrap, 1);
                        computations2++;
                    } else {
                        z4 = true;
                    }
                }
                if (allSolved2) {
                    if (widthMode != 1073741824) {
                        z4 = false;
                    }
                    layout.j1(z4, heightMode == 1073741824);
                }
                computations = computations2;
                allSolved = allSolved2;
                z = true;
            } else {
                z = true;
                allSolved = false;
                computations = 0;
            }
            if (allSolved && computations == 2) {
                return 0L;
            }
            int optimizations2 = layout.D1();
            if (childCount2 > 0) {
                b(layout);
            }
            e(layout);
            int sizeDependentWidgetsCount3 = h5Var.a.size();
            if (childCount2 > 0) {
                sizeDependentWidgetsCount = sizeDependentWidgetsCount3;
                optimizations = optimizations2;
                z2 = z;
                z3 = false;
                c(layout, "First pass", 0, startingWidth, startingHeight);
            } else {
                sizeDependentWidgetsCount = sizeDependentWidgetsCount3;
                optimizations = optimizations2;
                z2 = z;
                z3 = false;
            }
            int sizeDependentWidgetsCount4 = sizeDependentWidgetsCount;
            if (sizeDependentWidgetsCount4 > 0) {
                boolean needSolverPass = false;
                x4.b A2 = layout.A();
                x4.b bVar2 = x4.b.WRAP_CONTENT;
                boolean containerWrapWidth = A2 == bVar2 ? z2 : z3;
                boolean containerWrapHeight = layout.Q() == bVar2 ? z2 : z3;
                int minWidth = Math.max(layout.T(), h5Var.c.I());
                int minHeight = Math.max(layout.x(), h5Var.c.H());
                int i2 = 0;
                while (i2 < sizeDependentWidgetsCount4) {
                    x4 widget = h5Var.a.get(i2);
                    if (widget instanceof e5) {
                        int preWidth2 = widget.T();
                        int preHeight = widget.x();
                        childCount = childCount2;
                        boolean needSolverPass2 = needSolverPass | h5Var.a(measurer, widget, a.b);
                        if (layout.Q0 != null) {
                            throw null;
                        }
                        int measuredWidth = widget.T();
                        int measuredHeight = widget.x();
                        if (measuredWidth != preWidth2) {
                            widget.e1(measuredWidth);
                            if (containerWrapWidth) {
                                int preWidth3 = widget.M();
                                if (preWidth3 > minWidth) {
                                    int w = widget.M() + widget.o(w4.b.RIGHT).f();
                                    minWidth = Math.max(minWidth, w);
                                }
                            }
                            preWidth = true;
                        } else {
                            preWidth = needSolverPass2;
                        }
                        if (measuredHeight != preHeight) {
                            widget.F0(measuredHeight);
                            if (containerWrapHeight && widget.r() > minHeight) {
                                int h = widget.r() + widget.o(w4.b.BOTTOM).f();
                                minHeight = Math.max(minHeight, h);
                            }
                            preWidth = true;
                        }
                        e5 virtualLayout = (e5) widget;
                        boolean needSolverPass3 = preWidth | virtualLayout.z1();
                        needSolverPass = needSolverPass3;
                    } else {
                        childCount = childCount2;
                    }
                    i2++;
                    childCount2 = childCount;
                }
                int maxIterations2 = 2;
                int j = 0;
                while (true) {
                    if (j >= maxIterations2) {
                        layoutTime = layoutTime3;
                        break;
                    }
                    boolean needSolverPass4 = needSolverPass;
                    int minWidth2 = minWidth;
                    int i3 = 0;
                    int minHeight2 = minHeight;
                    while (i3 < sizeDependentWidgetsCount4) {
                        x4 widget2 = h5Var.a.get(i3);
                        if ((widget2 instanceof b5) && !(widget2 instanceof e5)) {
                            sizeDependentWidgetsCount2 = sizeDependentWidgetsCount4;
                        } else if (widget2 instanceof a5) {
                            sizeDependentWidgetsCount2 = sizeDependentWidgetsCount4;
                        } else {
                            sizeDependentWidgetsCount2 = sizeDependentWidgetsCount4;
                            if (widget2.S() != 8 && ((!optimize4 || !widget2.f.e.j || !widget2.g.e.j) && !(widget2 instanceof e5))) {
                                int preWidth4 = widget2.T();
                                int preHeight2 = widget2.x();
                                layoutTime2 = layoutTime3;
                                int preBaselineDistance = widget2.p();
                                int measureStrategy = a.b;
                                int measureStrategy2 = maxIterations2 - 1;
                                boolean hasMeasure = h5Var.a(measurer, widget2, j == measureStrategy2 ? a.c : measureStrategy);
                                needSolverPass4 |= hasMeasure;
                                if (layout.Q0 != null) {
                                    throw null;
                                }
                                int measuredWidth2 = widget2.T();
                                maxIterations = maxIterations2;
                                int measuredHeight2 = widget2.x();
                                if (measuredWidth2 != preWidth4) {
                                    widget2.e1(measuredWidth2);
                                    if (containerWrapWidth) {
                                        int preWidth5 = widget2.M();
                                        if (preWidth5 > minWidth2) {
                                            int w2 = widget2.M() + widget2.o(w4.b.RIGHT).f();
                                            minWidth2 = Math.max(minWidth2, w2);
                                        }
                                    }
                                    needSolverPass4 = true;
                                }
                                if (measuredHeight2 != preHeight2) {
                                    widget2.F0(measuredHeight2);
                                    if (containerWrapHeight && widget2.r() > minHeight2) {
                                        int h2 = widget2.r() + widget2.o(w4.b.BOTTOM).f();
                                        minHeight2 = Math.max(minHeight2, h2);
                                    }
                                    needSolverPass4 = true;
                                }
                                if (widget2.W() && preBaselineDistance != widget2.p()) {
                                    needSolverPass4 = true;
                                }
                                i3++;
                                h5Var = this;
                                sizeDependentWidgetsCount4 = sizeDependentWidgetsCount2;
                                maxIterations2 = maxIterations;
                                layoutTime3 = layoutTime2;
                            }
                        }
                        maxIterations = maxIterations2;
                        layoutTime2 = layoutTime3;
                        i3++;
                        h5Var = this;
                        sizeDependentWidgetsCount4 = sizeDependentWidgetsCount2;
                        maxIterations2 = maxIterations;
                        layoutTime3 = layoutTime2;
                    }
                    int sizeDependentWidgetsCount5 = sizeDependentWidgetsCount4;
                    int maxIterations3 = maxIterations2;
                    layoutTime = layoutTime3;
                    if (!needSolverPass4) {
                        break;
                    }
                    c(layout, "intermediate pass", j + 1, startingWidth, startingHeight);
                    needSolverPass = false;
                    j++;
                    minHeight = minHeight2;
                    minWidth = minWidth2;
                    sizeDependentWidgetsCount4 = sizeDependentWidgetsCount5;
                    layoutTime3 = layoutTime;
                    h5Var = this;
                    maxIterations2 = maxIterations3;
                }
            } else {
                layoutTime = 0;
            }
            layout.Q1(optimizations);
            return layoutTime;
        }
        throw null;
    }

    public final boolean a(b measurer, x4 widget, int measureStrategy) {
        this.b.d = widget.A();
        this.b.e = widget.Q();
        this.b.f = widget.T();
        this.b.g = widget.x();
        a aVar = this.b;
        aVar.l = false;
        aVar.m = measureStrategy;
        x4.b bVar = aVar.d;
        x4.b bVar2 = x4.b.MATCH_CONSTRAINT;
        boolean horizontalMatchConstraints = bVar == bVar2;
        boolean verticalMatchConstraints = aVar.e == bVar2;
        boolean horizontalUseRatio = horizontalMatchConstraints && widget.d0 > 0.0f;
        boolean verticalUseRatio = verticalMatchConstraints && widget.d0 > 0.0f;
        if (horizontalUseRatio && widget.y[0] == 4) {
            aVar.d = x4.b.FIXED;
        }
        if (verticalUseRatio && widget.y[1] == 4) {
            aVar.e = x4.b.FIXED;
        }
        measurer.b(widget, aVar);
        widget.e1(this.b.h);
        widget.F0(this.b.i);
        widget.E0(this.b.k);
        widget.u0(this.b.j);
        a aVar2 = this.b;
        aVar2.m = a.a;
        return aVar2.l;
    }
}
