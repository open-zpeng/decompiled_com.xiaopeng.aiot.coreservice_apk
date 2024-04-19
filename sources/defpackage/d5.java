package defpackage;

import defpackage.x4;
/* compiled from: Optimizer.java */
/* renamed from: d5  reason: default package */
/* loaded from: classes.dex */
public class d5 {
    public static boolean[] a = new boolean[3];

    public static void a(y4 container, e4 system, x4 widget) {
        widget.t = -1;
        widget.u = -1;
        x4.b bVar = container.Z[0];
        x4.b bVar2 = x4.b.WRAP_CONTENT;
        if (bVar != bVar2 && widget.Z[0] == x4.b.MATCH_PARENT) {
            int left = widget.O.g;
            int right = container.T() - widget.Q.g;
            w4 w4Var = widget.O;
            w4Var.i = system.q(w4Var);
            w4 w4Var2 = widget.Q;
            w4Var2.i = system.q(w4Var2);
            system.f(widget.O.i, left);
            system.f(widget.Q.i, right);
            widget.t = 2;
            widget.I0(left, right);
        }
        if (container.Z[1] != bVar2 && widget.Z[1] == x4.b.MATCH_PARENT) {
            int top = widget.P.g;
            int bottom = container.x() - widget.R.g;
            w4 w4Var3 = widget.P;
            w4Var3.i = system.q(w4Var3);
            w4 w4Var4 = widget.R;
            w4Var4.i = system.q(w4Var4);
            system.f(widget.P.i, top);
            system.f(widget.R.i, bottom);
            if (widget.l0 > 0 || widget.S() == 8) {
                w4 w4Var5 = widget.S;
                w4Var5.i = system.q(w4Var5);
                system.f(widget.S.i, widget.l0 + top);
            }
            widget.u = 2;
            widget.Z0(top, bottom);
        }
    }

    public static final boolean b(int optimizationLevel, int optimization) {
        return (optimizationLevel & optimization) == optimization;
    }
}
