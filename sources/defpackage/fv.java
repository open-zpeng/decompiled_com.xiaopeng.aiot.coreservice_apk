package defpackage;
/* compiled from: Pow2.java */
/* renamed from: fv  reason: default package */
/* loaded from: classes.dex */
public final class fv {
    public static int a(int value) {
        return 1 << (32 - Integer.numberOfLeadingZeros(value - 1));
    }
}
