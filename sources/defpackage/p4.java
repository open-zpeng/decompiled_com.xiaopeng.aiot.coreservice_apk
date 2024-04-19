package defpackage;

import java.text.DecimalFormat;
/* compiled from: SplineSet.java */
/* renamed from: p4  reason: default package */
/* loaded from: classes.dex */
public abstract class p4 {
    public l4 a;
    public int[] b = new int[10];
    public float[] c = new float[10];
    public int d;
    public String e;

    public String toString() {
        String str = this.e;
        DecimalFormat df = new DecimalFormat("##.##");
        for (int i = 0; i < this.d; i++) {
            str = str + "[" + this.b[i] + " , " + df.format(this.c[i]) + "] ";
        }
        return str;
    }

    public float a(float t) {
        return (float) this.a.a(t, 0);
    }

    public float b(float t) {
        return (float) this.a.d(t, 0);
    }
}
