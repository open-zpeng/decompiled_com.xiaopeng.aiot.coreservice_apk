package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ChainRun.java */
/* renamed from: i5  reason: default package */
/* loaded from: classes.dex */
public class i5 extends v5 {
    public ArrayList<v5> k;
    public int l;

    public i5(x4 widget, int orientation) {
        super(widget);
        this.k = new ArrayList<>();
        this.f = orientation;
        q();
    }

    public String toString() {
        StringBuilder log = new StringBuilder("ChainRun ");
        log.append(this.f == 0 ? "horizontal : " : "vertical : ");
        Iterator<v5> it = this.k.iterator();
        while (it.hasNext()) {
            v5 run = it.next();
            log.append("<");
            log.append(run);
            log.append("> ");
        }
        return log.toString();
    }

    @Override // defpackage.v5
    public boolean m() {
        int count = this.k.size();
        for (int i = 0; i < count; i++) {
            v5 run = this.k.get(i);
            if (!run.m()) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.v5
    public long j() {
        int count = this.k.size();
        long wrapDimension = 0;
        for (int i = 0; i < count; i++) {
            v5 run = this.k.get(i);
            wrapDimension = wrapDimension + run.h.f + run.j() + run.i.f;
        }
        return wrapDimension;
    }

    public final void q() {
        x4 current = this.b;
        x4 previous = current.L(this.f);
        while (previous != null) {
            current = previous;
            previous = current.L(this.f);
        }
        this.b = current;
        this.k.add(current.N(this.f));
        x4 next = current.J(this.f);
        while (next != null) {
            x4 current2 = next;
            this.k.add(current2.N(this.f));
            next = current2.J(this.f);
        }
        Iterator<v5> it = this.k.iterator();
        while (it.hasNext()) {
            v5 run = it.next();
            int i = this.f;
            if (i == 0) {
                run.b.d = this;
            } else if (i == 1) {
                run.b.e = this;
            }
        }
        boolean isInRtl = this.f == 0 && ((y4) this.b.K()).J1();
        if (isInRtl && this.k.size() > 1) {
            ArrayList<v5> arrayList = this.k;
            this.b = arrayList.get(arrayList.size() - 1).b;
        }
        this.l = this.f == 0 ? this.b.z() : this.b.P();
    }

    @Override // defpackage.v5
    public void f() {
        this.c = null;
        Iterator<v5> it = this.k.iterator();
        while (it.hasNext()) {
            v5 run = it.next();
            run.f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:276:0x045c, code lost:
        r6 = r6 - r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f0  */
    @Override // defpackage.v5, defpackage.j5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(defpackage.j5 r28) {
        /*
            Method dump skipped, instructions count: 1169
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i5.a(j5):void");
    }

    @Override // defpackage.v5
    public void e() {
        for (int i = 0; i < this.k.size(); i++) {
            v5 run = this.k.get(i);
            run.e();
        }
    }

    public final x4 r() {
        for (int i = 0; i < this.k.size(); i++) {
            v5 run = this.k.get(i);
            if (run.b.S() != 8) {
                return run.b;
            }
        }
        return null;
    }

    public final x4 s() {
        for (int i = this.k.size() - 1; i >= 0; i--) {
            v5 run = this.k.get(i);
            if (run.b.S() != 8) {
                return run.b;
            }
        }
        return null;
    }

    @Override // defpackage.v5
    public void d() {
        Iterator<v5> it = this.k.iterator();
        while (it.hasNext()) {
            v5 run = it.next();
            run.d();
        }
        int count = this.k.size();
        if (count < 1) {
            return;
        }
        x4 firstWidget = this.k.get(0).b;
        x4 lastWidget = this.k.get(count - 1).b;
        if (this.f == 0) {
            w4 startAnchor = firstWidget.O;
            w4 endAnchor = lastWidget.Q;
            l5 startTarget = i(startAnchor, 0);
            int startMargin = startAnchor.f();
            x4 firstVisibleWidget = r();
            if (firstVisibleWidget != null) {
                startMargin = firstVisibleWidget.O.f();
            }
            if (startTarget != null) {
                b(this.h, startTarget, startMargin);
            }
            l5 endTarget = i(endAnchor, 0);
            int endMargin = endAnchor.f();
            x4 lastVisibleWidget = s();
            if (lastVisibleWidget != null) {
                endMargin = lastVisibleWidget.Q.f();
            }
            if (endTarget != null) {
                b(this.i, endTarget, -endMargin);
            }
        } else {
            w4 startAnchor2 = firstWidget.P;
            w4 endAnchor2 = lastWidget.R;
            l5 startTarget2 = i(startAnchor2, 1);
            int startMargin2 = startAnchor2.f();
            x4 firstVisibleWidget2 = r();
            if (firstVisibleWidget2 != null) {
                startMargin2 = firstVisibleWidget2.P.f();
            }
            if (startTarget2 != null) {
                b(this.h, startTarget2, startMargin2);
            }
            l5 endTarget2 = i(endAnchor2, 1);
            int endMargin2 = endAnchor2.f();
            x4 lastVisibleWidget2 = s();
            if (lastVisibleWidget2 != null) {
                endMargin2 = lastVisibleWidget2.R.f();
            }
            if (endTarget2 != null) {
                b(this.i, endTarget2, -endMargin2);
            }
        }
        this.h.a = this;
        this.i.a = this;
    }
}
