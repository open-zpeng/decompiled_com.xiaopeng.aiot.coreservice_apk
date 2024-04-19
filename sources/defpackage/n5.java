package defpackage;

import defpackage.h5;
import defpackage.w4;
import defpackage.x4;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: Direct.java */
/* renamed from: n5  reason: default package */
/* loaded from: classes.dex */
public class n5 {
    public static h5.a a = new h5.a();
    public static int b = 0;
    public static int c = 0;

    public static void h(y4 layout, h5.b measurer) {
        x4.b horizontal = layout.A();
        x4.b vertical = layout.Q();
        b = 0;
        c = 0;
        layout.s0();
        ArrayList<x4> l1 = layout.l1();
        int count = l1.size();
        for (int i = 0; i < count; i++) {
            l1.get(i).s0();
        }
        boolean isRtl = layout.J1();
        if (horizontal == x4.b.FIXED) {
            layout.z0(0, layout.T());
        } else {
            layout.A0(0);
        }
        boolean hasGuideline = false;
        boolean hasBarrier = false;
        for (int i2 = 0; i2 < count; i2++) {
            x4 child = l1.get(i2);
            if (child instanceof a5) {
                a5 guideline = (a5) child;
                if (guideline.m1() == 1) {
                    if (guideline.n1() != -1) {
                        guideline.q1(guideline.n1());
                    } else if (guideline.o1() != -1 && layout.k0()) {
                        guideline.q1(layout.T() - guideline.o1());
                    } else if (layout.k0()) {
                        int position = (int) ((guideline.p1() * layout.T()) + 0.5f);
                        guideline.q1(position);
                    }
                    hasGuideline = true;
                }
            } else if ((child instanceof t4) && ((t4) child).r1() == 0) {
                hasBarrier = true;
            }
        }
        if (hasGuideline) {
            for (int i3 = 0; i3 < count; i3++) {
                x4 child2 = l1.get(i3);
                if (child2 instanceof a5) {
                    a5 guideline2 = (a5) child2;
                    if (guideline2.m1() == 1) {
                        b(0, guideline2, measurer, isRtl);
                    }
                }
            }
        }
        b(0, layout, measurer, isRtl);
        if (hasBarrier) {
            for (int i4 = 0; i4 < count; i4++) {
                x4 child3 = l1.get(i4);
                if (child3 instanceof t4) {
                    t4 barrier = (t4) child3;
                    if (barrier.r1() == 0) {
                        c(0, barrier, measurer, 0, isRtl);
                    }
                }
            }
        }
        if (vertical == x4.b.FIXED) {
            layout.C0(0, layout.x());
        } else {
            layout.B0(0);
        }
        boolean hasGuideline2 = false;
        boolean hasBarrier2 = false;
        for (int i5 = 0; i5 < count; i5++) {
            x4 child4 = l1.get(i5);
            if (child4 instanceof a5) {
                a5 guideline3 = (a5) child4;
                if (guideline3.m1() == 0) {
                    if (guideline3.n1() != -1) {
                        guideline3.q1(guideline3.n1());
                    } else if (guideline3.o1() != -1 && layout.l0()) {
                        guideline3.q1(layout.x() - guideline3.o1());
                    } else if (layout.l0()) {
                        int position2 = (int) ((guideline3.p1() * layout.x()) + 0.5f);
                        guideline3.q1(position2);
                    }
                    hasGuideline2 = true;
                }
            } else if ((child4 instanceof t4) && ((t4) child4).r1() == 1) {
                hasBarrier2 = true;
            }
        }
        if (hasGuideline2) {
            for (int i6 = 0; i6 < count; i6++) {
                x4 child5 = l1.get(i6);
                if (child5 instanceof a5) {
                    a5 guideline4 = (a5) child5;
                    if (guideline4.m1() == 0) {
                        i(1, guideline4, measurer);
                    }
                }
            }
        }
        i(0, layout, measurer);
        if (hasBarrier2) {
            for (int i7 = 0; i7 < count; i7++) {
                x4 child6 = l1.get(i7);
                if (child6 instanceof t4) {
                    t4 barrier2 = (t4) child6;
                    if (barrier2.r1() == 1) {
                        c(0, barrier2, measurer, 1, isRtl);
                    }
                }
            }
        }
        for (int i8 = 0; i8 < count; i8++) {
            x4 child7 = l1.get(i8);
            if (child7.j0() && a(0, child7)) {
                y4.M1(0, child7, measurer, a, h5.a.a);
                if (child7 instanceof a5) {
                    if (((a5) child7).m1() == 0) {
                        i(0, child7, measurer);
                    } else {
                        b(0, child7, measurer, isRtl);
                    }
                } else {
                    b(0, child7, measurer, isRtl);
                    i(0, child7, measurer);
                }
            }
        }
    }

    public static void c(int level, t4 barrier, h5.b measurer, int orientation, boolean isRtl) {
        if (barrier.n1()) {
            if (orientation == 0) {
                b(level + 1, barrier, measurer, isRtl);
            } else {
                i(level + 1, barrier, measurer);
            }
        }
    }

    public static void b(int level, x4 layout, h5.b measurer, boolean isRtl) {
        w4 w4Var;
        w4 w4Var2;
        w4 w4Var3;
        w4 w4Var4;
        w4 w4Var5;
        if (layout.d0()) {
            return;
        }
        b++;
        if (!(layout instanceof y4) && layout.j0() && a(level + 1, layout)) {
            h5.a measure = new h5.a();
            y4.M1(level + 1, layout, measurer, measure, h5.a.a);
        }
        w4 left = layout.o(w4.b.LEFT);
        w4 right = layout.o(w4.b.RIGHT);
        int l = left.e();
        int r = right.e();
        if (left.d() != null && left.n()) {
            Iterator<w4> it = left.d().iterator();
            while (it.hasNext()) {
                w4 first = it.next();
                x4 widget = first.d;
                boolean canMeasure = a(level + 1, widget);
                if (widget.j0() && canMeasure) {
                    h5.a measure2 = new h5.a();
                    y4.M1(level + 1, widget, measurer, measure2, h5.a.a);
                }
                x4.b A = widget.A();
                x4.b bVar = x4.b.MATCH_CONSTRAINT;
                if (A != bVar || canMeasure) {
                    if (!widget.j0()) {
                        w4 w4Var6 = widget.O;
                        if (first == w4Var6 && widget.Q.f == null) {
                            int x1 = w4Var6.f() + l;
                            widget.z0(x1, widget.T() + x1);
                            b(level + 1, widget, measurer, isRtl);
                        } else {
                            w4 w4Var7 = widget.Q;
                            if (first == w4Var7 && w4Var6.f == null) {
                                int x2 = l - w4Var7.f();
                                widget.z0(x2 - widget.T(), x2);
                                b(level + 1, widget, measurer, isRtl);
                            } else if (first == w4Var6 && (w4Var3 = w4Var7.f) != null && w4Var3.n() && !widget.f0()) {
                                d(level + 1, measurer, widget, isRtl);
                            }
                        }
                    }
                } else if (widget.A() == bVar && widget.A >= 0 && widget.z >= 0 && ((widget.S() == 8 || (widget.w == 0 && widget.v() == 0.0f)) && !widget.f0() && !widget.i0())) {
                    if (((first == widget.O && (w4Var5 = widget.Q.f) != null && w4Var5.n()) || (first == widget.Q && (w4Var4 = widget.O.f) != null && w4Var4.n())) && !widget.f0()) {
                        e(level + 1, layout, measurer, widget, isRtl);
                    }
                }
            }
        }
        if (layout instanceof a5) {
            return;
        }
        if (right.d() != null && right.n()) {
            Iterator<w4> it2 = right.d().iterator();
            while (it2.hasNext()) {
                w4 first2 = it2.next();
                x4 widget2 = first2.d;
                boolean canMeasure2 = a(level + 1, widget2);
                if (widget2.j0() && canMeasure2) {
                    h5.a measure3 = new h5.a();
                    y4.M1(level + 1, widget2, measurer, measure3, h5.a.a);
                }
                boolean bothConnected = (first2 == widget2.O && (w4Var2 = widget2.Q.f) != null && w4Var2.n()) || (first2 == widget2.Q && (w4Var = widget2.O.f) != null && w4Var.n());
                x4.b A2 = widget2.A();
                x4.b bVar2 = x4.b.MATCH_CONSTRAINT;
                if (A2 == bVar2 && !canMeasure2) {
                    if (widget2.A() == bVar2 && widget2.A >= 0 && widget2.z >= 0) {
                        if (widget2.S() != 8) {
                            if (widget2.w == 0 && widget2.v() == 0.0f) {
                            }
                        }
                        if (!widget2.f0() && !widget2.i0() && bothConnected && !widget2.f0()) {
                            e(level + 1, layout, measurer, widget2, isRtl);
                        }
                    }
                }
                if (!widget2.j0()) {
                    w4 w4Var8 = widget2.O;
                    if (first2 == w4Var8 && widget2.Q.f == null) {
                        int x12 = w4Var8.f() + r;
                        widget2.z0(x12, widget2.T() + x12);
                        b(level + 1, widget2, measurer, isRtl);
                    } else {
                        w4 w4Var9 = widget2.Q;
                        if (first2 == w4Var9 && w4Var8.f == null) {
                            int x22 = r - w4Var9.f();
                            widget2.z0(x22 - widget2.T(), x22);
                            b(level + 1, widget2, measurer, isRtl);
                        } else if (bothConnected && !widget2.f0()) {
                            d(level + 1, measurer, widget2, isRtl);
                        }
                    }
                }
            }
        }
        layout.n0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x01d8, code lost:
        if (r8.v() != 0.0f) goto L120;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(int r18, defpackage.x4 r19, defpackage.h5.b r20) {
        /*
            Method dump skipped, instructions count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n5.i(int, x4, h5$b):void");
    }

    public static void d(int level, h5.b measurer, x4 widget, boolean isRtl) {
        int d1;
        float bias = widget.y();
        int start = widget.O.f.e();
        int end = widget.Q.f.e();
        int s1 = widget.O.f() + start;
        int s2 = end - widget.Q.f();
        if (start == end) {
            bias = 0.5f;
            s1 = start;
            s2 = end;
        }
        int width = widget.T();
        int distance = (s2 - s1) - width;
        if (s1 > s2) {
            distance = (s1 - s2) - width;
        }
        if (distance > 0) {
            d1 = (int) ((distance * bias) + 0.5f);
        } else {
            d1 = (int) (distance * bias);
        }
        int x1 = s1 + d1;
        int x2 = x1 + width;
        if (s1 > s2) {
            x1 = s1 + d1;
            x2 = x1 - width;
        }
        widget.z0(x1, x2);
        b(level + 1, widget, measurer, isRtl);
    }

    public static void f(int level, h5.b measurer, x4 widget) {
        int d1;
        float bias = widget.O();
        int start = widget.P.f.e();
        int end = widget.R.f.e();
        int s1 = widget.P.f() + start;
        int s2 = end - widget.R.f();
        if (start == end) {
            bias = 0.5f;
            s1 = start;
            s2 = end;
        }
        int height = widget.x();
        int distance = (s2 - s1) - height;
        if (s1 > s2) {
            distance = (s1 - s2) - height;
        }
        if (distance > 0) {
            d1 = (int) ((distance * bias) + 0.5f);
        } else {
            d1 = (int) (distance * bias);
        }
        int y1 = s1 + d1;
        int y2 = y1 + height;
        if (s1 > s2) {
            y1 = s1 - d1;
            y2 = y1 - height;
        }
        widget.C0(y1, y2);
        i(level + 1, widget, measurer);
    }

    public static void e(int level, x4 layout, h5.b measurer, x4 widget, boolean isRtl) {
        int parentWidth;
        float bias = widget.y();
        int s1 = widget.O.f.e() + widget.O.f();
        int s2 = widget.Q.f.e() - widget.Q.f();
        if (s2 >= s1) {
            int width = widget.T();
            if (widget.S() != 8) {
                int i = widget.w;
                if (i == 2) {
                    if (layout instanceof y4) {
                        parentWidth = layout.T();
                    } else {
                        parentWidth = layout.K().T();
                    }
                    width = (int) (widget.y() * 0.5f * parentWidth);
                } else if (i == 0) {
                    width = s2 - s1;
                }
                width = Math.max(widget.z, width);
                int i2 = widget.A;
                if (i2 > 0) {
                    width = Math.min(i2, width);
                }
            }
            int distance = (s2 - s1) - width;
            int d1 = (int) ((distance * bias) + 0.5f);
            int x1 = s1 + d1;
            int x2 = x1 + width;
            widget.z0(x1, x2);
            b(level + 1, widget, measurer, isRtl);
        }
    }

    public static void g(int level, x4 layout, h5.b measurer, x4 widget) {
        int parentHeight;
        float bias = widget.O();
        int s1 = widget.P.f.e() + widget.P.f();
        int s2 = widget.R.f.e() - widget.R.f();
        if (s2 >= s1) {
            int height = widget.x();
            if (widget.S() != 8) {
                int i = widget.x;
                if (i == 2) {
                    if (layout instanceof y4) {
                        parentHeight = layout.x();
                    } else {
                        parentHeight = layout.K().x();
                    }
                    height = (int) (bias * 0.5f * parentHeight);
                } else if (i == 0) {
                    height = s2 - s1;
                }
                height = Math.max(widget.C, height);
                int i2 = widget.D;
                if (i2 > 0) {
                    height = Math.min(i2, height);
                }
            }
            int distance = (s2 - s1) - height;
            int d1 = (int) ((distance * bias) + 0.5f);
            int y1 = s1 + d1;
            int y2 = y1 + height;
            widget.C0(y1, y2);
            i(level + 1, widget, measurer);
        }
    }

    public static boolean a(int level, x4 layout) {
        x4.b bVar;
        x4.b bVar2;
        x4.b horizontalBehaviour = layout.A();
        x4.b verticalBehaviour = layout.Q();
        y4 parent = layout.K() != null ? (y4) layout.K() : null;
        if (parent == null || parent.A() != x4.b.FIXED) {
        }
        if (parent == null || parent.Q() != x4.b.FIXED) {
        }
        x4.b bVar3 = x4.b.FIXED;
        boolean isHorizontalFixed = horizontalBehaviour == bVar3 || layout.k0() || horizontalBehaviour == x4.b.WRAP_CONTENT || (horizontalBehaviour == (bVar2 = x4.b.MATCH_CONSTRAINT) && layout.w == 0 && layout.d0 == 0.0f && layout.X(0)) || (horizontalBehaviour == bVar2 && layout.w == 1 && layout.a0(0, layout.T()));
        boolean isVerticalFixed = verticalBehaviour == bVar3 || layout.l0() || verticalBehaviour == x4.b.WRAP_CONTENT || (verticalBehaviour == (bVar = x4.b.MATCH_CONSTRAINT) && layout.x == 0 && layout.d0 == 0.0f && layout.X(1)) || (horizontalBehaviour == bVar && layout.x == 1 && layout.a0(1, layout.x()));
        if (layout.d0 <= 0.0f || !(isHorizontalFixed || isVerticalFixed)) {
            return isHorizontalFixed && isVerticalFixed;
        }
        return true;
    }
}
