package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: DependencyNode.java */
/* renamed from: l5  reason: default package */
/* loaded from: classes.dex */
public class l5 implements j5 {
    public v5 d;
    public int f;
    public int g;
    public j5 a = null;
    public boolean b = false;
    public boolean c = false;
    public a e = a.UNKNOWN;
    public int h = 1;
    public m5 i = null;
    public boolean j = false;
    public List<j5> k = new ArrayList();
    public List<l5> l = new ArrayList();

    /* compiled from: DependencyNode.java */
    /* renamed from: l5$a */
    /* loaded from: classes.dex */
    public enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public l5(v5 run) {
        this.d = run;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.t());
        sb.append(":");
        sb.append(this.e);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }

    public void d(int value) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = value;
        for (j5 node : this.k) {
            node.a(node);
        }
    }

    @Override // defpackage.j5
    public void a(j5 node) {
        for (l5 target : this.l) {
            if (!target.j) {
                return;
            }
        }
        this.c = true;
        j5 j5Var = this.a;
        if (j5Var != null) {
            j5Var.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        l5 target2 = null;
        int numTargets = 0;
        for (l5 t : this.l) {
            if (!(t instanceof m5)) {
                target2 = t;
                numTargets++;
            }
        }
        if (target2 != null && numTargets == 1 && target2.j) {
            m5 m5Var = this.i;
            if (m5Var != null) {
                if (m5Var.j) {
                    this.f = this.h * m5Var.g;
                } else {
                    return;
                }
            }
            d(target2.g + this.f);
        }
        j5 j5Var2 = this.a;
        if (j5Var2 != null) {
            j5Var2.a(this);
        }
    }

    public void b(j5 dependency) {
        this.k.add(dependency);
        if (this.j) {
            dependency.a(dependency);
        }
    }

    public void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }
}
