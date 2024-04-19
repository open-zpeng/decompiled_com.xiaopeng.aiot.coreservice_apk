package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
/* compiled from: HelperWidget.java */
/* renamed from: c5  reason: default package */
/* loaded from: classes.dex */
public class c5 extends x4 implements b5 {
    public x4[] J0 = new x4[4];
    public int K0 = 0;

    @Override // defpackage.b5
    public void a(y4 container) {
    }

    @Override // defpackage.b5
    public void c(x4 widget) {
        if (widget == this || widget == null) {
            return;
        }
        int i = this.K0 + 1;
        x4[] x4VarArr = this.J0;
        if (i > x4VarArr.length) {
            this.J0 = (x4[]) Arrays.copyOf(x4VarArr, x4VarArr.length * 2);
        }
        x4[] x4VarArr2 = this.J0;
        int i2 = this.K0;
        x4VarArr2[i2] = widget;
        this.K0 = i2 + 1;
    }

    @Override // defpackage.b5
    public void b() {
        this.K0 = 0;
        Arrays.fill(this.J0, (Object) null);
    }

    public void l1(ArrayList<u5> arrayList, int orientation, u5 group) {
        for (int i = 0; i < this.K0; i++) {
            x4 widget = this.J0[i];
            group.a(widget);
        }
        for (int i2 = 0; i2 < this.K0; i2++) {
            x4 widget2 = this.J0[i2];
            o5.a(widget2, orientation, arrayList, group);
        }
    }

    public int m1(int orientation) {
        int i;
        int i2;
        for (int i3 = 0; i3 < this.K0; i3++) {
            x4 widget = this.J0[i3];
            if (orientation == 0 && (i2 = widget.H0) != -1) {
                return i2;
            }
            if (orientation == 1 && (i = widget.I0) != -1) {
                return i;
            }
        }
        return -1;
    }
}
