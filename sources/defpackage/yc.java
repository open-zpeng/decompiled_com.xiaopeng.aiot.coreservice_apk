package defpackage;

import android.view.animation.Interpolator;
/* compiled from: LookupTableInterpolator.java */
/* renamed from: yc  reason: default package */
/* loaded from: classes.dex */
public abstract class yc implements Interpolator {
    public final float[] a;
    public final float b;

    public yc(float[] values) {
        this.a = values;
        this.b = 1.0f / (values.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        if (input >= 1.0f) {
            return 1.0f;
        }
        if (input <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.a;
        int position = Math.min((int) ((fArr.length - 1) * input), fArr.length - 2);
        float f = this.b;
        float quantized = position * f;
        float diff = input - quantized;
        float weight = diff / f;
        float[] fArr2 = this.a;
        return fArr2[position] + ((fArr2[position + 1] - fArr2[position]) * weight);
    }
}
