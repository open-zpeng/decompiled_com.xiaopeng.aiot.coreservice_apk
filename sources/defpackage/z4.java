package defpackage;

import defpackage.x4;
import java.util.ArrayList;
import java.util.Arrays;
/* compiled from: Flow.java */
/* renamed from: z4  reason: default package */
/* loaded from: classes.dex */
public class z4 extends e5 {
    public x4[] v1;
    public int Y0 = -1;
    public int Z0 = -1;
    public int a1 = -1;
    public int b1 = -1;
    public int c1 = -1;
    public int d1 = -1;
    public float e1 = 0.5f;
    public float f1 = 0.5f;
    public float g1 = 0.5f;
    public float h1 = 0.5f;
    public float i1 = 0.5f;
    public float j1 = 0.5f;
    public int k1 = 0;
    public int l1 = 0;
    public int m1 = 2;
    public int n1 = 2;
    public int o1 = 0;
    public int p1 = -1;
    public int q1 = 0;
    public ArrayList<a> r1 = new ArrayList<>();
    public x4[] s1 = null;
    public x4[] t1 = null;
    public int[] u1 = null;
    public int w1 = 0;

    public void w2(int value) {
        this.q1 = value;
    }

    public void k2(int value) {
        this.a1 = value;
    }

    public void m2(int value) {
        this.b1 = value;
    }

    public void s2(int value) {
        this.c1 = value;
    }

    public void u2(int value) {
        this.d1 = value;
    }

    public void q2(int value) {
        this.Y0 = value;
    }

    public void A2(int value) {
        this.Z0 = value;
    }

    public void o2(float value) {
        this.e1 = value;
    }

    public void y2(float value) {
        this.f1 = value;
    }

    public void j2(float value) {
        this.g1 = value;
    }

    public void l2(float value) {
        this.h1 = value;
    }

    public void r2(float value) {
        this.i1 = value;
    }

    public void t2(float value) {
        this.j1 = value;
    }

    public void n2(int value) {
        this.m1 = value;
    }

    public void x2(int value) {
        this.n1 = value;
    }

    public void B2(int value) {
        this.o1 = value;
    }

    public void p2(int value) {
        this.k1 = value;
    }

    public void z2(int value) {
        this.l1 = value;
    }

    public void v2(int value) {
        this.p1 = value;
    }

    public final int f2(x4 widget, int max) {
        if (widget == null) {
            return 0;
        }
        if (widget.A() == x4.b.MATCH_CONSTRAINT) {
            int i = widget.w;
            if (i == 0) {
                return 0;
            }
            if (i == 2) {
                int value = (int) (widget.B * max);
                if (value != widget.T()) {
                    widget.S0(true);
                    x1(widget, x4.b.FIXED, value, widget.Q(), widget.x());
                }
                return value;
            } else if (i == 1) {
                return widget.T();
            } else {
                if (i == 3) {
                    return (int) ((widget.x() * widget.d0) + 0.5f);
                }
            }
        }
        return widget.T();
    }

    public final int e2(x4 widget, int max) {
        if (widget == null) {
            return 0;
        }
        if (widget.Q() == x4.b.MATCH_CONSTRAINT) {
            int i = widget.x;
            if (i == 0) {
                return 0;
            }
            if (i == 2) {
                int value = (int) (widget.E * max);
                if (value != widget.x()) {
                    widget.S0(true);
                    x1(widget, widget.A(), widget.T(), x4.b.FIXED, value);
                }
                return value;
            } else if (i == 1) {
                return widget.x();
            } else {
                if (i == 3) {
                    return (int) ((widget.T() * widget.d0) + 0.5f);
                }
            }
        }
        return widget.x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    @Override // defpackage.e5
    public void w1(int widthMode, int widthSize, int heightMode, int heightSize) {
        int max;
        int gone;
        x4[] widgets;
        int count;
        int[] measured;
        ?? r20;
        if (this.K0 > 0 && !y1()) {
            B1(0, 0);
            A1(false);
            return;
        }
        int paddingLeft = t1();
        int paddingRight = u1();
        int paddingTop = v1();
        int paddingBottom = s1();
        int[] measured2 = new int[2];
        int max2 = (widthSize - paddingLeft) - paddingRight;
        int i = this.q1;
        if (i != 1) {
            max = max2;
        } else {
            int max3 = (heightSize - paddingTop) - paddingBottom;
            max = max3;
        }
        if (i == 0) {
            if (this.Y0 == -1) {
                this.Y0 = 0;
            }
            if (this.Z0 == -1) {
                this.Z0 = 0;
            }
        } else {
            if (this.Y0 == -1) {
                this.Y0 = 0;
            }
            if (this.Z0 == -1) {
                this.Z0 = 0;
            }
        }
        x4[] widgets2 = this.J0;
        int i2 = 0;
        int gone2 = 0;
        while (true) {
            gone = this.K0;
            if (i2 >= gone) {
                break;
            }
            if (this.J0[i2].S() == 8) {
                gone2++;
            }
            i2++;
        }
        int count2 = this.K0;
        if (gone2 <= 0) {
            widgets = widgets2;
            count = count2;
        } else {
            x4[] widgets3 = new x4[gone - gone2];
            int j = 0;
            int i3 = 0;
            while (i3 < this.K0) {
                x4 widget = this.J0[i3];
                int count3 = count2;
                if (widget.S() != 8) {
                    widgets3[j] = widget;
                    j++;
                }
                i3++;
                count2 = count3;
            }
            widgets = widgets3;
            count = j;
        }
        this.v1 = widgets;
        this.w1 = count;
        switch (this.o1) {
            case 0:
                measured = measured2;
                r20 = 1;
                i2(widgets, count, this.q1, max, measured2);
                break;
            case 1:
                measured = measured2;
                r20 = 1;
                h2(widgets, count, this.q1, max, measured2);
                break;
            case 2:
                r20 = 1;
                measured = measured2;
                g2(widgets, count, this.q1, max, measured2);
                break;
            default:
                measured = measured2;
                r20 = 1;
                break;
        }
        int width = measured[0] + paddingLeft + paddingRight;
        int height = measured[r20] + paddingTop + paddingBottom;
        int measuredWidth = 0;
        int measuredHeight = 0;
        if (widthMode == 1073741824) {
            measuredWidth = widthSize;
        } else if (widthMode == Integer.MIN_VALUE) {
            measuredWidth = Math.min(width, widthSize);
        } else if (widthMode == 0) {
            measuredWidth = width;
        }
        if (heightMode == 1073741824) {
            measuredHeight = heightSize;
        } else if (heightMode == Integer.MIN_VALUE) {
            measuredHeight = Math.min(height, heightSize);
        } else if (heightMode == 0) {
            measuredHeight = height;
        }
        B1(measuredWidth, measuredHeight);
        e1(measuredWidth);
        F0(measuredHeight);
        A1(this.K0 > 0 ? r20 : false);
    }

    /* compiled from: Flow.java */
    /* renamed from: z4$a */
    /* loaded from: classes.dex */
    public class a {
        public int a;
        public w4 d;
        public w4 e;
        public w4 f;
        public w4 g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int q;
        public x4 b = null;
        public int c = 0;
        public int l = 0;
        public int m = 0;
        public int n = 0;
        public int o = 0;
        public int p = 0;

        public a(int orientation, w4 left, w4 top, w4 right, w4 bottom, int max) {
            this.a = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.q = 0;
            this.a = orientation;
            this.d = left;
            this.e = top;
            this.f = right;
            this.g = bottom;
            this.h = z4.this.t1();
            this.i = z4.this.v1();
            this.j = z4.this.u1();
            this.k = z4.this.s1();
            this.q = max;
        }

        public void j(int orientation, w4 left, w4 top, w4 right, w4 bottom, int paddingLeft, int paddingTop, int paddingRight, int paddingBottom, int max) {
            this.a = orientation;
            this.d = left;
            this.e = top;
            this.f = right;
            this.g = bottom;
            this.h = paddingLeft;
            this.i = paddingTop;
            this.j = paddingRight;
            this.k = paddingBottom;
            this.q = max;
        }

        public void c() {
            this.c = 0;
            this.b = null;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
        }

        public void i(int value) {
            this.n = value;
        }

        public int f() {
            if (this.a == 0) {
                return this.l - z4.this.k1;
            }
            return this.l;
        }

        public int e() {
            if (this.a == 1) {
                return this.m - z4.this.l1;
            }
            return this.m;
        }

        public void b(x4 widget) {
            if (this.a == 0) {
                int width = z4.this.f2(widget, this.q);
                if (widget.A() == x4.b.MATCH_CONSTRAINT) {
                    this.p++;
                    width = 0;
                }
                int gap = z4.this.k1;
                if (widget.S() == 8) {
                    gap = 0;
                }
                this.l += width + gap;
                int height = z4.this.e2(widget, this.q);
                if (this.b == null || this.c < height) {
                    this.b = widget;
                    this.c = height;
                    this.m = height;
                }
            } else {
                int width2 = z4.this.f2(widget, this.q);
                int height2 = z4.this.e2(widget, this.q);
                if (widget.Q() == x4.b.MATCH_CONSTRAINT) {
                    this.p++;
                    height2 = 0;
                }
                int gap2 = z4.this.l1;
                if (widget.S() == 8) {
                    gap2 = 0;
                }
                this.m += height2 + gap2;
                if (this.b == null || this.c < width2) {
                    this.b = widget;
                    this.c = width2;
                    this.l = width2;
                }
            }
            this.o++;
        }

        public void d(boolean isInRtl, int chainIndex, boolean isLastChain) {
            int count = this.o;
            for (int i = 0; i < count && this.n + i < z4.this.w1; i++) {
                x4 widget = z4.this.v1[this.n + i];
                if (widget != null) {
                    widget.r0();
                }
            }
            if (count == 0 || this.b == null) {
                return;
            }
            boolean singleChain = isLastChain && chainIndex == 0;
            int firstVisible = -1;
            int lastVisible = -1;
            for (int i2 = 0; i2 < count; i2++) {
                int index = i2;
                if (isInRtl) {
                    index = (count - 1) - i2;
                }
                if (this.n + index >= z4.this.w1) {
                    break;
                }
                if (z4.this.v1[this.n + index].S() == 0) {
                    if (firstVisible == -1) {
                        firstVisible = i2;
                    }
                    lastVisible = i2;
                }
            }
            x4 previous = null;
            if (this.a == 0) {
                x4 verticalWidget = this.b;
                verticalWidget.Y0(z4.this.Z0);
                int padding = this.i;
                if (chainIndex > 0) {
                    padding += z4.this.l1;
                }
                verticalWidget.P.a(this.e, padding);
                if (isLastChain) {
                    verticalWidget.R.a(this.g, this.k);
                }
                if (chainIndex > 0) {
                    w4 bottom = this.e.d.R;
                    bottom.a(verticalWidget.P, 0);
                }
                x4 baselineVerticalWidget = verticalWidget;
                if (z4.this.n1 == 3 && !verticalWidget.W()) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= count) {
                            break;
                        }
                        int index2 = i3;
                        if (isInRtl) {
                            index2 = (count - 1) - i3;
                        }
                        if (this.n + index2 >= z4.this.w1) {
                            break;
                        }
                        x4 widget2 = z4.this.v1[this.n + index2];
                        if (!widget2.W()) {
                            i3++;
                        } else {
                            baselineVerticalWidget = widget2;
                            break;
                        }
                    }
                }
                for (int i4 = 0; i4 < count; i4++) {
                    int index3 = i4;
                    if (isInRtl) {
                        index3 = (count - 1) - i4;
                    }
                    if (this.n + index3 < z4.this.w1) {
                        x4 widget3 = z4.this.v1[this.n + index3];
                        if (i4 == 0) {
                            widget3.k(widget3.O, this.d, this.h);
                        }
                        if (index3 == 0) {
                            int style = z4.this.Y0;
                            float bias = z4.this.e1;
                            if (isInRtl) {
                                bias = 1.0f - bias;
                            }
                            if (this.n == 0 && z4.this.a1 != -1) {
                                style = z4.this.a1;
                                float f = z4.this.g1;
                                if (isInRtl) {
                                    f = 1.0f - f;
                                }
                                bias = f;
                            } else if (isLastChain && z4.this.c1 != -1) {
                                style = z4.this.c1;
                                float f2 = z4.this.i1;
                                if (isInRtl) {
                                    f2 = 1.0f - f2;
                                }
                                bias = f2;
                            }
                            widget3.H0(style);
                            widget3.G0(bias);
                        }
                        if (i4 == count - 1) {
                            widget3.k(widget3.Q, this.f, this.j);
                        }
                        if (previous != null) {
                            widget3.O.a(previous.Q, z4.this.k1);
                            if (i4 == firstVisible) {
                                widget3.O.u(this.h);
                            }
                            previous.Q.a(widget3.O, 0);
                            if (i4 == lastVisible + 1) {
                                previous.Q.u(this.j);
                            }
                        }
                        if (widget3 != verticalWidget) {
                            if (z4.this.n1 == 3 && baselineVerticalWidget.W() && widget3 != baselineVerticalWidget && widget3.W()) {
                                widget3.S.a(baselineVerticalWidget.S, 0);
                            } else {
                                switch (z4.this.n1) {
                                    case 0:
                                        widget3.P.a(verticalWidget.P, 0);
                                        continue;
                                    case 1:
                                        widget3.R.a(verticalWidget.R, 0);
                                        continue;
                                    default:
                                        if (singleChain) {
                                            widget3.P.a(this.e, this.i);
                                            widget3.R.a(this.g, this.k);
                                            break;
                                        } else {
                                            widget3.P.a(verticalWidget.P, 0);
                                            widget3.R.a(verticalWidget.R, 0);
                                            continue;
                                        }
                                }
                            }
                        }
                        previous = widget3;
                    } else {
                        return;
                    }
                }
                return;
            }
            x4 horizontalWidget = this.b;
            horizontalWidget.H0(z4.this.Y0);
            int padding2 = this.h;
            if (chainIndex > 0) {
                padding2 += z4.this.k1;
            }
            if (isInRtl) {
                horizontalWidget.Q.a(this.f, padding2);
                if (isLastChain) {
                    horizontalWidget.O.a(this.d, this.j);
                }
                if (chainIndex > 0) {
                    w4 left = this.f.d.O;
                    left.a(horizontalWidget.Q, 0);
                }
            } else {
                horizontalWidget.O.a(this.d, padding2);
                if (isLastChain) {
                    horizontalWidget.Q.a(this.f, this.j);
                }
                if (chainIndex > 0) {
                    w4 right = this.d.d.Q;
                    right.a(horizontalWidget.O, 0);
                }
            }
            for (int i5 = 0; i5 < count && this.n + i5 < z4.this.w1; i5++) {
                x4 widget4 = z4.this.v1[this.n + i5];
                if (i5 == 0) {
                    widget4.k(widget4.P, this.e, this.i);
                    int style2 = z4.this.Z0;
                    float bias2 = z4.this.f1;
                    if (this.n == 0 && z4.this.b1 != -1) {
                        style2 = z4.this.b1;
                        bias2 = z4.this.h1;
                    } else if (isLastChain && z4.this.d1 != -1) {
                        style2 = z4.this.d1;
                        bias2 = z4.this.j1;
                    }
                    widget4.Y0(style2);
                    widget4.X0(bias2);
                }
                if (i5 == count - 1) {
                    widget4.k(widget4.R, this.g, this.k);
                }
                if (previous != null) {
                    widget4.P.a(previous.R, z4.this.l1);
                    if (i5 == firstVisible) {
                        widget4.P.u(this.i);
                    }
                    previous.R.a(widget4.P, 0);
                    if (i5 == lastVisible + 1) {
                        previous.R.u(this.k);
                    }
                }
                if (widget4 != horizontalWidget) {
                    if (isInRtl) {
                        switch (z4.this.m1) {
                            case 0:
                                widget4.Q.a(horizontalWidget.Q, 0);
                                break;
                            case 1:
                                widget4.O.a(horizontalWidget.O, 0);
                                break;
                            case 2:
                                widget4.O.a(horizontalWidget.O, 0);
                                widget4.Q.a(horizontalWidget.Q, 0);
                                break;
                        }
                    } else {
                        switch (z4.this.m1) {
                            case 0:
                                widget4.O.a(horizontalWidget.O, 0);
                                continue;
                            case 1:
                                widget4.Q.a(horizontalWidget.Q, 0);
                                continue;
                            case 2:
                                if (singleChain) {
                                    widget4.O.a(this.d, this.h);
                                    widget4.Q.a(this.f, this.j);
                                    continue;
                                } else {
                                    widget4.O.a(horizontalWidget.O, 0);
                                    widget4.Q.a(horizontalWidget.Q, 0);
                                    break;
                                }
                            default:
                                continue;
                        }
                    }
                }
                previous = widget4;
            }
        }

        public void g(int availableSpace) {
            int i = this.p;
            if (i == 0) {
                return;
            }
            int count = this.o;
            int widgetSize = availableSpace / i;
            for (int i2 = 0; i2 < count && this.n + i2 < z4.this.w1; i2++) {
                x4 widget = z4.this.v1[this.n + i2];
                if (this.a == 0) {
                    if (widget != null && widget.A() == x4.b.MATCH_CONSTRAINT && widget.w == 0) {
                        z4.this.x1(widget, x4.b.FIXED, widgetSize, widget.Q(), widget.x());
                    }
                } else if (widget != null && widget.Q() == x4.b.MATCH_CONSTRAINT && widget.x == 0) {
                    z4.this.x1(widget, widget.A(), widget.T(), x4.b.FIXED, widgetSize);
                }
            }
            h();
        }

        public final void h() {
            this.l = 0;
            this.m = 0;
            this.b = null;
            this.c = 0;
            int count = this.o;
            for (int i = 0; i < count && this.n + i < z4.this.w1; i++) {
                x4 widget = z4.this.v1[this.n + i];
                if (this.a != 0) {
                    int width = z4.this.f2(widget, this.q);
                    int height = z4.this.e2(widget, this.q);
                    int gap = z4.this.l1;
                    if (widget.S() == 8) {
                        gap = 0;
                    }
                    this.m += height + gap;
                    if (this.b == null || this.c < width) {
                        this.b = widget;
                        this.c = width;
                        this.l = width;
                    }
                } else {
                    int width2 = widget.T();
                    int gap2 = z4.this.k1;
                    if (widget.S() == 8) {
                        gap2 = 0;
                    }
                    this.l += width2 + gap2;
                    int height2 = z4.this.e2(widget, this.q);
                    if (this.b == null || this.c < height2) {
                        this.b = widget;
                        this.c = height2;
                        this.m = height2;
                    }
                }
            }
        }
    }

    public final void h2(x4[] widgets, int count, int orientation, int max, int[] measured) {
        a list;
        int nbMatchConstraintsWidgets;
        boolean doWrap;
        int i;
        int nbMatchConstraintsWidgets2;
        int nbMatchConstraintsWidgets3;
        boolean doWrap2;
        int i2;
        if (count == 0) {
            return;
        }
        this.r1.clear();
        a list2 = new a(orientation, this.O, this.P, this.Q, this.R, max);
        this.r1.add(list2);
        int nbMatchConstraintsWidgets4 = 0;
        if (orientation == 0) {
            int width = 0;
            a list3 = list2;
            int i3 = 0;
            while (i3 < count) {
                x4 widget = widgets[i3];
                int w = f2(widget, max);
                if (widget.A() != x4.b.MATCH_CONSTRAINT) {
                    nbMatchConstraintsWidgets3 = nbMatchConstraintsWidgets4;
                } else {
                    nbMatchConstraintsWidgets3 = nbMatchConstraintsWidgets4 + 1;
                }
                boolean doWrap3 = (width == max || (this.k1 + width) + w > max) && list3.b != null;
                if (!doWrap3 && i3 > 0 && (i2 = this.p1) > 0 && i3 % i2 == 0) {
                    doWrap2 = true;
                } else {
                    doWrap2 = doWrap3;
                }
                if (doWrap2) {
                    a list4 = new a(orientation, this.O, this.P, this.Q, this.R, max);
                    list4.i(i3);
                    this.r1.add(list4);
                    list3 = list4;
                    width = w;
                } else if (i3 > 0) {
                    width += this.k1 + w;
                } else {
                    width = w;
                }
                list3.b(widget);
                i3++;
                nbMatchConstraintsWidgets4 = nbMatchConstraintsWidgets3;
            }
            list = list3;
        } else {
            int height = 0;
            a list5 = list2;
            int i4 = 0;
            while (i4 < count) {
                x4 widget2 = widgets[i4];
                int h = e2(widget2, max);
                if (widget2.Q() != x4.b.MATCH_CONSTRAINT) {
                    nbMatchConstraintsWidgets = nbMatchConstraintsWidgets4;
                } else {
                    nbMatchConstraintsWidgets = nbMatchConstraintsWidgets4 + 1;
                }
                boolean doWrap4 = (height == max || (this.l1 + height) + h > max) && list5.b != null;
                if (!doWrap4 && i4 > 0 && (i = this.p1) > 0 && i4 % i == 0) {
                    doWrap = true;
                } else {
                    doWrap = doWrap4;
                }
                if (doWrap) {
                    a list6 = new a(orientation, this.O, this.P, this.Q, this.R, max);
                    list6.i(i4);
                    this.r1.add(list6);
                    list5 = list6;
                    height = h;
                } else if (i4 > 0) {
                    height += this.l1 + h;
                } else {
                    height = h;
                }
                list5.b(widget2);
                i4++;
                nbMatchConstraintsWidgets4 = nbMatchConstraintsWidgets;
            }
            list = list5;
        }
        int listCount = this.r1.size();
        w4 left = this.O;
        w4 top = this.P;
        w4 right = this.Q;
        w4 bottom = this.R;
        int paddingLeft = t1();
        int paddingTop = v1();
        int paddingRight = u1();
        int paddingBottom = s1();
        x4.b A = A();
        x4.b bVar = x4.b.WRAP_CONTENT;
        boolean needInternalMeasure = A == bVar || Q() == bVar;
        if (nbMatchConstraintsWidgets4 > 0 && needInternalMeasure) {
            int i5 = 0;
            while (i5 < listCount) {
                boolean needInternalMeasure2 = needInternalMeasure;
                a current = this.r1.get(i5);
                if (orientation == 0) {
                    nbMatchConstraintsWidgets2 = nbMatchConstraintsWidgets4;
                    current.g(max - current.f());
                } else {
                    nbMatchConstraintsWidgets2 = nbMatchConstraintsWidgets4;
                    current.g(max - current.e());
                }
                i5++;
                needInternalMeasure = needInternalMeasure2;
                nbMatchConstraintsWidgets4 = nbMatchConstraintsWidgets2;
            }
        }
        int paddingTop2 = paddingTop;
        int paddingRight2 = paddingRight;
        int paddingBottom2 = paddingBottom;
        w4 left2 = left;
        int maxWidth = 0;
        int maxHeight = 0;
        for (int i6 = 0; i6 < listCount; i6++) {
            a current2 = this.r1.get(i6);
            if (orientation == 0) {
                if (i6 < listCount - 1) {
                    a next = this.r1.get(i6 + 1);
                    bottom = next.b.P;
                    paddingBottom2 = 0;
                } else {
                    bottom = this.R;
                    paddingBottom2 = s1();
                }
                w4 currentBottom = current2.b.R;
                w4 currentBottom2 = left2;
                current2.j(orientation, currentBottom2, top, right, bottom, paddingLeft, paddingTop2, paddingRight2, paddingBottom2, max);
                paddingTop2 = 0;
                int maxWidth2 = Math.max(maxWidth, current2.f());
                maxHeight += current2.e();
                if (i6 > 0) {
                    maxHeight += this.l1;
                }
                maxWidth = maxWidth2;
                top = currentBottom;
            } else {
                w4 top2 = top;
                int maxHeight2 = maxHeight;
                int maxWidth3 = maxWidth;
                if (i6 < listCount - 1) {
                    a next2 = this.r1.get(i6 + 1);
                    right = next2.b.O;
                    paddingRight2 = 0;
                } else {
                    right = this.Q;
                    paddingRight2 = u1();
                }
                w4 currentRight = current2.b.Q;
                w4 currentRight2 = bottom;
                current2.j(orientation, left2, top2, right, currentRight2, paddingLeft, paddingTop2, paddingRight2, paddingBottom2, max);
                left2 = currentRight;
                paddingLeft = 0;
                maxWidth = maxWidth3 + current2.f();
                int maxWidth4 = current2.e();
                int maxHeight3 = Math.max(maxHeight2, maxWidth4);
                if (i6 <= 0) {
                    maxHeight = maxHeight3;
                    top = top2;
                } else {
                    maxWidth += this.k1;
                    maxHeight = maxHeight3;
                    top = top2;
                }
            }
        }
        measured[0] = maxWidth;
        measured[1] = maxHeight;
    }

    public final void i2(x4[] widgets, int count, int orientation, int max, int[] measured) {
        a list;
        if (count == 0) {
            return;
        }
        if (this.r1.size() == 0) {
            list = new a(orientation, this.O, this.P, this.Q, this.R, max);
            this.r1.add(list);
        } else {
            list = this.r1.get(0);
            list.c();
            list.j(orientation, this.O, this.P, this.Q, this.R, t1(), v1(), u1(), s1(), max);
        }
        for (int i = 0; i < count; i++) {
            x4 widget = widgets[i];
            list.b(widget);
        }
        int i2 = list.f();
        measured[0] = i2;
        measured[1] = list.e();
    }

    public final void g2(x4[] widgets, int count, int orientation, int max, int[] measured) {
        x4 widget;
        boolean done = false;
        int rows = 0;
        int cols = 0;
        if (orientation == 0) {
            cols = this.p1;
            if (cols <= 0) {
                int w = 0;
                cols = 0;
                for (int i = 0; i < count; i++) {
                    if (i > 0) {
                        w += this.k1;
                    }
                    x4 widget2 = widgets[i];
                    if (widget2 != null) {
                        w += f2(widget2, max);
                        if (w > max) {
                            break;
                        }
                        cols++;
                    }
                }
            }
        } else {
            rows = this.p1;
            if (rows <= 0) {
                int h = 0;
                rows = 0;
                for (int i2 = 0; i2 < count; i2++) {
                    if (i2 > 0) {
                        h += this.l1;
                    }
                    x4 widget3 = widgets[i2];
                    if (widget3 != null) {
                        h += e2(widget3, max);
                        if (h > max) {
                            break;
                        }
                        rows++;
                    }
                }
            }
        }
        if (this.u1 == null) {
            this.u1 = new int[2];
        }
        int w2 = 1;
        if ((rows == 0 && orientation == 1) || (cols == 0 && orientation == 0)) {
            done = true;
        }
        while (!done) {
            if (orientation == 0) {
                rows = (int) Math.ceil(count / cols);
            } else {
                cols = (int) Math.ceil(count / rows);
            }
            x4[] x4VarArr = this.t1;
            if (x4VarArr == null || x4VarArr.length < cols) {
                this.t1 = new x4[cols];
            } else {
                Arrays.fill(x4VarArr, (Object) null);
            }
            x4[] x4VarArr2 = this.s1;
            if (x4VarArr2 == null || x4VarArr2.length < rows) {
                this.s1 = new x4[rows];
            } else {
                Arrays.fill(x4VarArr2, (Object) null);
            }
            int i3 = 0;
            while (i3 < cols) {
                int j = 0;
                while (j < rows) {
                    int index = (j * cols) + i3;
                    if (orientation == w2) {
                        index = (i3 * rows) + j;
                    }
                    if (index < widgets.length && (widget = widgets[index]) != null) {
                        int w3 = f2(widget, max);
                        x4[] x4VarArr3 = this.t1;
                        if (x4VarArr3[i3] == null || x4VarArr3[i3].T() < w3) {
                            this.t1[i3] = widget;
                        }
                        int h2 = e2(widget, max);
                        x4[] x4VarArr4 = this.s1;
                        if (x4VarArr4[j] == null || x4VarArr4[j].x() < h2) {
                            this.s1[j] = widget;
                        }
                    }
                    j++;
                    w2 = 1;
                }
                i3++;
                w2 = 1;
            }
            int w4 = 0;
            for (int i4 = 0; i4 < cols; i4++) {
                x4 widget4 = this.t1[i4];
                if (widget4 != null) {
                    if (i4 > 0) {
                        w4 += this.k1;
                    }
                    w4 += f2(widget4, max);
                }
            }
            int h3 = 0;
            for (int j2 = 0; j2 < rows; j2++) {
                x4 widget5 = this.s1[j2];
                if (widget5 != null) {
                    if (j2 > 0) {
                        h3 += this.l1;
                    }
                    h3 += e2(widget5, max);
                }
            }
            measured[0] = w4;
            measured[1] = h3;
            if (orientation == 0) {
                if (w4 > max) {
                    if (cols > 1) {
                        cols--;
                    } else {
                        done = true;
                    }
                } else {
                    done = true;
                }
            } else if (h3 > max) {
                if (rows > 1) {
                    rows--;
                } else {
                    done = true;
                }
            } else {
                done = true;
            }
            w2 = 1;
        }
        int[] iArr = this.u1;
        iArr[0] = cols;
        iArr[1] = rows;
    }

    public final void d2(boolean isInRtl) {
        x4 widget;
        if (this.u1 == null || this.t1 == null || this.s1 == null) {
            return;
        }
        for (int i = 0; i < this.w1; i++) {
            this.v1[i].r0();
        }
        int[] iArr = this.u1;
        int cols = iArr[0];
        int rows = iArr[1];
        x4 previous = null;
        float horizontalBias = this.e1;
        for (int i2 = 0; i2 < cols; i2++) {
            int index = i2;
            if (isInRtl) {
                index = (cols - i2) - 1;
                horizontalBias = 1.0f - this.e1;
            }
            x4 widget2 = this.t1[index];
            if (widget2 != null && widget2.S() != 8) {
                if (i2 == 0) {
                    widget2.k(widget2.O, this.O, t1());
                    widget2.H0(this.Y0);
                    widget2.G0(horizontalBias);
                }
                if (i2 == cols - 1) {
                    widget2.k(widget2.Q, this.Q, u1());
                }
                if (i2 > 0 && previous != null) {
                    widget2.k(widget2.O, previous.Q, this.k1);
                    previous.k(previous.Q, widget2.O, 0);
                }
                previous = widget2;
            }
        }
        for (int j = 0; j < rows; j++) {
            x4 widget3 = this.s1[j];
            if (widget3 != null && widget3.S() != 8) {
                if (j == 0) {
                    widget3.k(widget3.P, this.P, v1());
                    widget3.Y0(this.Z0);
                    widget3.X0(this.f1);
                }
                if (j == rows - 1) {
                    widget3.k(widget3.R, this.R, s1());
                }
                if (j > 0 && previous != null) {
                    widget3.k(widget3.P, previous.R, this.l1);
                    previous.k(previous.R, widget3.P, 0);
                }
                previous = widget3;
            }
        }
        for (int i3 = 0; i3 < cols; i3++) {
            for (int j2 = 0; j2 < rows; j2++) {
                int index2 = (j2 * cols) + i3;
                if (this.q1 == 1) {
                    index2 = (i3 * rows) + j2;
                }
                x4[] x4VarArr = this.v1;
                if (index2 < x4VarArr.length && (widget = x4VarArr[index2]) != null && widget.S() != 8) {
                    x4 biggestInCol = this.t1[i3];
                    x4 biggestInRow = this.s1[j2];
                    if (widget != biggestInCol) {
                        widget.k(widget.O, biggestInCol.O, 0);
                        widget.k(widget.Q, biggestInCol.Q, 0);
                    }
                    if (widget != biggestInRow) {
                        widget.k(widget.P, biggestInRow.P, 0);
                        widget.k(widget.R, biggestInRow.R, 0);
                    }
                }
            }
        }
    }

    @Override // defpackage.x4
    public void g(e4 system, boolean optimize) {
        super.g(system, optimize);
        boolean isInRtl = K() != null && ((y4) K()).J1();
        switch (this.o1) {
            case 0:
                if (this.r1.size() > 0) {
                    a list = this.r1.get(0);
                    list.d(isInRtl, 0, true);
                    break;
                }
                break;
            case 1:
                int count = this.r1.size();
                int i = 0;
                while (i < count) {
                    a list2 = this.r1.get(i);
                    list2.d(isInRtl, i, i == count + (-1));
                    i++;
                }
                break;
            case 2:
                d2(isInRtl);
                break;
        }
        A1(false);
    }
}
