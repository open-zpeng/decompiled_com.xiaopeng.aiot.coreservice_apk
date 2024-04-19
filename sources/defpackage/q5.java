package defpackage;

import defpackage.l5;
/* compiled from: HelperReferences.java */
/* renamed from: q5  reason: default package */
/* loaded from: classes.dex */
public class q5 extends v5 {
    public q5(x4 widget) {
        super(widget);
    }

    @Override // defpackage.v5
    public void f() {
        this.c = null;
        this.h.c();
    }

    @Override // defpackage.v5
    public boolean m() {
        return false;
    }

    public final void q(l5 node) {
        this.h.k.add(node);
        node.l.add(this.h);
    }

    @Override // defpackage.v5
    public void d() {
        x4 x4Var = this.b;
        if (x4Var instanceof t4) {
            this.h.b = true;
            t4 barrier = (t4) x4Var;
            int type = barrier.p1();
            boolean allowsGoneWidget = barrier.o1();
            switch (type) {
                case 0:
                    this.h.e = l5.a.LEFT;
                    for (int i = 0; i < barrier.K0; i++) {
                        x4 refWidget = barrier.J0[i];
                        if (allowsGoneWidget || refWidget.S() != 8) {
                            l5 target = refWidget.f.h;
                            target.k.add(this.h);
                            this.h.l.add(target);
                        }
                    }
                    q(this.b.f.h);
                    q(this.b.f.i);
                    return;
                case 1:
                    this.h.e = l5.a.RIGHT;
                    for (int i2 = 0; i2 < barrier.K0; i2++) {
                        x4 refWidget2 = barrier.J0[i2];
                        if (allowsGoneWidget || refWidget2.S() != 8) {
                            l5 target2 = refWidget2.f.i;
                            target2.k.add(this.h);
                            this.h.l.add(target2);
                        }
                    }
                    q(this.b.f.h);
                    q(this.b.f.i);
                    return;
                case 2:
                    this.h.e = l5.a.TOP;
                    for (int i3 = 0; i3 < barrier.K0; i3++) {
                        x4 refwidget = barrier.J0[i3];
                        if (allowsGoneWidget || refwidget.S() != 8) {
                            l5 target3 = refwidget.g.h;
                            target3.k.add(this.h);
                            this.h.l.add(target3);
                        }
                    }
                    q(this.b.g.h);
                    q(this.b.g.i);
                    return;
                case 3:
                    this.h.e = l5.a.BOTTOM;
                    for (int i4 = 0; i4 < barrier.K0; i4++) {
                        x4 refwidget2 = barrier.J0[i4];
                        if (allowsGoneWidget || refwidget2.S() != 8) {
                            l5 target4 = refwidget2.g.i;
                            target4.k.add(this.h);
                            this.h.l.add(target4);
                        }
                    }
                    q(this.b.g.h);
                    q(this.b.g.i);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // defpackage.v5, defpackage.j5
    public void a(j5 dependency) {
        t4 barrier = (t4) this.b;
        int type = barrier.p1();
        int min = -1;
        int max = 0;
        for (l5 node : this.h.l) {
            int value = node.g;
            if (min == -1 || value < min) {
                min = value;
            }
            if (max < value) {
                max = value;
            }
        }
        if (type == 0 || type == 2) {
            this.h.d(barrier.q1() + min);
        } else {
            this.h.d(barrier.q1() + max);
        }
    }

    @Override // defpackage.v5
    public void e() {
        x4 x4Var = this.b;
        if (x4Var instanceof t4) {
            t4 barrier = (t4) x4Var;
            int type = barrier.p1();
            if (type == 0 || type == 1) {
                this.b.g1(this.h.g);
            } else {
                this.b.h1(this.h.g);
            }
        }
    }
}
