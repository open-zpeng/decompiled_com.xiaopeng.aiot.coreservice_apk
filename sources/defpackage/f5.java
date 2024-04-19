package defpackage;

import java.util.ArrayList;
/* compiled from: WidgetContainer.java */
/* renamed from: f5  reason: default package */
/* loaded from: classes.dex */
public class f5 extends x4 {
    public ArrayList<x4> J0 = new ArrayList<>();

    @Override // defpackage.x4
    public void q0() {
        this.J0.clear();
        super.q0();
    }

    public void c(x4 widget) {
        this.J0.add(widget);
        if (widget.K() != null) {
            f5 container = (f5) widget.K();
            container.n1(widget);
        }
        widget.W0(this);
    }

    public void n1(x4 widget) {
        this.J0.remove(widget);
        widget.q0();
    }

    public ArrayList<x4> l1() {
        return this.J0;
    }

    public void m1() {
        ArrayList<x4> arrayList = this.J0;
        if (arrayList == null) {
            return;
        }
        int count = arrayList.size();
        for (int i = 0; i < count; i++) {
            x4 widget = this.J0.get(i);
            if (widget instanceof f5) {
                ((f5) widget).m1();
            }
        }
    }

    @Override // defpackage.x4
    public void t0(d4 cache) {
        super.t0(cache);
        int count = this.J0.size();
        for (int i = 0; i < count; i++) {
            x4 widget = this.J0.get(i);
            widget.t0(cache);
        }
    }

    public void o1() {
        this.J0.clear();
    }
}
