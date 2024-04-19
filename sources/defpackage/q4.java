package defpackage;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
/* compiled from: TimeCycleSplineSet.java */
/* renamed from: q4  reason: default package */
/* loaded from: classes.dex */
public abstract class q4 {
    public static float a = 6.2831855f;
    public l4 b;
    public int f;
    public String g;
    public long j;
    public int c = 0;
    public int[] d = new int[10];
    public float[][] e = (float[][]) Array.newInstance(float.class, 10, 3);
    public float[] h = new float[3];
    public boolean i = false;
    public float k = Float.NaN;

    public String toString() {
        String str = this.g;
        DecimalFormat df = new DecimalFormat("##.##");
        for (int i = 0; i < this.f; i++) {
            str = str + "[" + this.d[i] + " , " + df.format(this.e[i]) + "] ";
        }
        return str;
    }

    public float a(float period) {
        switch (this.c) {
            case 1:
                return Math.signum(a * period);
            case 2:
                return 1.0f - Math.abs(period);
            case 3:
                return (((period * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                return 1.0f - (((period * 2.0f) + 1.0f) % 2.0f);
            case 5:
                return (float) Math.cos(a * period);
            case 6:
                float x = 1.0f - Math.abs(((period * 4.0f) % 4.0f) - 2.0f);
                return 1.0f - (x * x);
            default:
                return (float) Math.sin(a * period);
        }
    }
}
