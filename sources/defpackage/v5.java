package defpackage;

import defpackage.w4;
import defpackage.x4;
/* compiled from: WidgetRun.java */
/* renamed from: v5  reason: default package */
/* loaded from: classes.dex */
public abstract class v5 implements j5 {
    public int a;
    public x4 b;
    public s5 c;
    public x4.b d;
    public m5 e = new m5(this);
    public int f = 0;
    public boolean g = false;
    public l5 h = new l5(this);
    public l5 i = new l5(this);
    public b j = b.NONE;

    /* compiled from: WidgetRun.java */
    /* renamed from: v5$b */
    /* loaded from: classes.dex */
    public enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract boolean m();

    public v5(x4 widget) {
        this.b = widget;
    }

    public final l5 h(w4 anchor) {
        w4 w4Var = anchor.f;
        if (w4Var == null) {
            return null;
        }
        x4 targetWidget = w4Var.d;
        w4.b targetType = w4Var.e;
        switch (a.a[targetType.ordinal()]) {
            case 1:
                r5 run = targetWidget.f;
                l5 target = run.h;
                return target;
            case 2:
                r5 run2 = targetWidget.f;
                l5 target2 = run2.i;
                return target2;
            case 3:
                t5 run3 = targetWidget.g;
                l5 target3 = run3.h;
                return target3;
            case 4:
                t5 run4 = targetWidget.g;
                l5 target4 = run4.k;
                return target4;
            case 5:
                t5 run5 = targetWidget.g;
                l5 target5 = run5.i;
                return target5;
            default:
                return null;
        }
    }

    /* compiled from: WidgetRun.java */
    /* renamed from: v5$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[w4.b.values().length];
            a = iArr;
            try {
                iArr[w4.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[w4.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[w4.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[w4.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[w4.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public void n(j5 dependency, w4 startAnchor, w4 endAnchor, int orientation) {
        l5 startTarget = h(startAnchor);
        l5 endTarget = h(endAnchor);
        if (!startTarget.j || !endTarget.j) {
            return;
        }
        int startPos = startTarget.g + startAnchor.f();
        int endPos = endTarget.g - endAnchor.f();
        int distance = endPos - startPos;
        if (!this.e.j && this.d == x4.b.MATCH_CONSTRAINT) {
            l(orientation, distance);
        }
        m5 m5Var = this.e;
        if (!m5Var.j) {
            return;
        }
        if (m5Var.g == distance) {
            this.h.d(startPos);
            this.i.d(endPos);
            return;
        }
        x4 x4Var = this.b;
        float bias = orientation == 0 ? x4Var.y() : x4Var.O();
        if (startTarget == endTarget) {
            startPos = startTarget.g;
            endPos = endTarget.g;
            bias = 0.5f;
        }
        int availableDistance = (endPos - startPos) - this.e.g;
        this.h.d((int) (startPos + 0.5f + (availableDistance * bias)));
        this.i.d(this.h.g + this.e.g);
    }

    public final void l(int orientation, int distance) {
        int value;
        switch (this.a) {
            case 0:
                this.e.d(g(distance, orientation));
                return;
            case 1:
                int wrapValue = g(this.e.m, orientation);
                this.e.d(Math.min(wrapValue, distance));
                return;
            case 2:
                x4 parent = this.b.K();
                if (parent != null) {
                    m5 m5Var = (orientation == 0 ? parent.f : parent.g).e;
                    if (m5Var.j) {
                        x4 x4Var = this.b;
                        float percent = orientation == 0 ? x4Var.B : x4Var.E;
                        int targetDimensionValue = m5Var.g;
                        int size = (int) ((targetDimensionValue * percent) + 0.5f);
                        this.e.d(g(size, orientation));
                        return;
                    }
                    return;
                }
                return;
            case 3:
                x4 x4Var2 = this.b;
                v5 run = x4Var2.f;
                x4.b bVar = run.d;
                x4.b bVar2 = x4.b.MATCH_CONSTRAINT;
                if (bVar == bVar2 && run.a == 3) {
                    t5 t5Var = x4Var2.g;
                    if (t5Var.d == bVar2 && t5Var.a == 3) {
                        return;
                    }
                }
                if (orientation == 0) {
                    run = x4Var2.g;
                }
                if (run.e.j) {
                    float ratio = x4Var2.v();
                    if (orientation == 1) {
                        value = (int) ((run.e.g / ratio) + 0.5f);
                    } else {
                        value = (int) ((run.e.g * ratio) + 0.5f);
                    }
                    this.e.d(value);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void p(j5 dependency) {
    }

    public void o(j5 dependency) {
    }

    @Override // defpackage.j5
    public void a(j5 dependency) {
    }

    public final int g(int dimension, int orientation) {
        if (orientation == 0) {
            x4 x4Var = this.b;
            int max = x4Var.A;
            int min = x4Var.z;
            int value = Math.max(min, dimension);
            if (max > 0) {
                value = Math.min(max, dimension);
            }
            if (value != dimension) {
                return value;
            }
            return dimension;
        }
        x4 x4Var2 = this.b;
        int max2 = x4Var2.D;
        int min2 = x4Var2.C;
        int value2 = Math.max(min2, dimension);
        if (max2 > 0) {
            value2 = Math.min(max2, dimension);
        }
        if (value2 != dimension) {
            return value2;
        }
        return dimension;
    }

    public final l5 i(w4 anchor, int orientation) {
        w4 w4Var = anchor.f;
        if (w4Var == null) {
            return null;
        }
        x4 targetWidget = w4Var.d;
        v5 run = orientation == 0 ? targetWidget.f : targetWidget.g;
        w4.b targetType = w4Var.e;
        switch (a.a[targetType.ordinal()]) {
            case 1:
            case 3:
                l5 target = run.h;
                return target;
            case 2:
            case 5:
                l5 target2 = run.i;
                return target2;
            case 4:
            default:
                return null;
        }
    }

    public final void b(l5 node, l5 target, int margin) {
        node.l.add(target);
        node.f = margin;
        target.k.add(node);
    }

    public final void c(l5 node, l5 target, int marginFactor, m5 dimensionDependency) {
        node.l.add(target);
        node.l.add(this.e);
        node.h = marginFactor;
        node.i = dimensionDependency;
        target.k.add(node);
        dimensionDependency.k.add(node);
    }

    public long j() {
        m5 m5Var = this.e;
        if (m5Var.j) {
            return m5Var.g;
        }
        return 0L;
    }

    public boolean k() {
        return this.g;
    }
}
