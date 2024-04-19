package defpackage;
/* compiled from: MathUtils.java */
/* renamed from: r8  reason: default package */
/* loaded from: classes.dex */
public class r8 {
    public static int a(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }
}
