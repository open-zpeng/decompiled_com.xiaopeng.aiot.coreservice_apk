package defpackage;

import defpackage.l5;
/* compiled from: DimensionDependency.java */
/* renamed from: m5  reason: default package */
/* loaded from: classes.dex */
public class m5 extends l5 {
    public int m;

    public m5(v5 run) {
        super(run);
        if (run instanceof r5) {
            this.e = l5.a.HORIZONTAL_DIMENSION;
        } else {
            this.e = l5.a.VERTICAL_DIMENSION;
        }
    }

    @Override // defpackage.l5
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
}
