package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
/* compiled from: XFontScaleHelper.java */
/* renamed from: zq  reason: default package */
/* loaded from: classes.dex */
public class zq {
    public float a;

    public static zq c(Resources resources, int value) {
        if (cp.b()) {
            float complexToFloat = a(resources, value);
            if (complexToFloat != -1.0f) {
                return new zq(complexToFloat);
            }
            return null;
        }
        return null;
    }

    public static zq d(TypedArray typedArray, int index) {
        return e(typedArray, index, 0);
    }

    public static zq e(TypedArray typedArray, int index, int defaultValue) {
        if (cp.b()) {
            float complexToFloat = b(typedArray, index, defaultValue);
            if (complexToFloat != -1.0f) {
                return new zq(complexToFloat);
            }
            return null;
        }
        return null;
    }

    public zq(float complexToFloat) {
        this.a = complexToFloat;
    }

    public float f(DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, this.a, displayMetrics);
    }

    public void g(TextView textView) {
        textView.setTextSize(this.a);
    }

    public static float b(TypedArray typedArray, int index, int defaultValue) {
        if (typedArray.hasValue(index)) {
            TypedValue out = new TypedValue();
            typedArray.getValue(index, out);
            if (out.getComplexUnit() == 2) {
                return TypedValue.complexToFloat(out.data);
            }
            return -1.0f;
        }
        return a(typedArray.getResources(), defaultValue);
    }

    public static float a(Resources resources, int defaultValue) {
        if (defaultValue != 0) {
            TypedValue out = new TypedValue();
            resources.getValue(defaultValue, out, true);
            if (out.getComplexUnit() == 2) {
                return TypedValue.complexToFloat(out.data);
            }
            return -1.0f;
        }
        return -1.0f;
    }
}
