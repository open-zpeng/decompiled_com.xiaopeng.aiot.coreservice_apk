package defpackage;
/* compiled from: GuidelineReference.java */
/* renamed from: p5  reason: default package */
/* loaded from: classes.dex */
public class p5 extends v5 {
    public p5(x4 widget) {
        super(widget);
        widget.f.f();
        widget.g.f();
        this.f = ((a5) widget).m1();
    }

    @Override // defpackage.v5
    public void f() {
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

    @Override // defpackage.v5, defpackage.j5
    public void a(j5 dependency) {
        l5 l5Var = this.h;
        if (!l5Var.c || l5Var.j) {
            return;
        }
        l5 startTarget = l5Var.l.get(0);
        a5 guideline = (a5) this.b;
        int startPos = (int) ((startTarget.g * guideline.p1()) + 0.5f);
        this.h.d(startPos);
    }

    @Override // defpackage.v5
    public void d() {
        a5 guideline = (a5) this.b;
        int relativeBegin = guideline.n1();
        int relativeEnd = guideline.o1();
        guideline.p1();
        if (guideline.m1() == 1) {
            if (relativeBegin != -1) {
                this.h.l.add(this.b.a0.f.h);
                this.b.a0.f.h.k.add(this.h);
                this.h.f = relativeBegin;
            } else if (relativeEnd != -1) {
                this.h.l.add(this.b.a0.f.i);
                this.b.a0.f.i.k.add(this.h);
                this.h.f = -relativeEnd;
            } else {
                l5 l5Var = this.h;
                l5Var.b = true;
                l5Var.l.add(this.b.a0.f.i);
                this.b.a0.f.i.k.add(this.h);
            }
            q(this.b.f.h);
            q(this.b.f.i);
            return;
        }
        if (relativeBegin != -1) {
            this.h.l.add(this.b.a0.g.h);
            this.b.a0.g.h.k.add(this.h);
            this.h.f = relativeBegin;
        } else if (relativeEnd != -1) {
            this.h.l.add(this.b.a0.g.i);
            this.b.a0.g.i.k.add(this.h);
            this.h.f = -relativeEnd;
        } else {
            l5 l5Var2 = this.h;
            l5Var2.b = true;
            l5Var2.l.add(this.b.a0.g.i);
            this.b.a0.g.i.k.add(this.h);
        }
        q(this.b.g.h);
        q(this.b.g.i);
    }

    @Override // defpackage.v5
    public void e() {
        a5 guideline = (a5) this.b;
        if (guideline.m1() == 1) {
            this.b.g1(this.h.g);
        } else {
            this.b.h1(this.h.g);
        }
    }
}
