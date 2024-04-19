package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import defpackage.v7;
/* compiled from: TintTypedArray.java */
/* renamed from: z2  reason: default package */
/* loaded from: classes.dex */
public class z2 {
    public final Context a;
    public final TypedArray b;
    public TypedValue c;

    public static z2 t(Context context, AttributeSet set, int[] attrs) {
        return new z2(context, context.obtainStyledAttributes(set, attrs));
    }

    public static z2 u(Context context, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes) {
        return new z2(context, context.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes));
    }

    public static z2 s(Context context, int resid, int[] attrs) {
        return new z2(context, context.obtainStyledAttributes(resid, attrs));
    }

    public z2(Context context, TypedArray array) {
        this.a = context;
        this.b = array;
    }

    public TypedArray q() {
        return this.b;
    }

    public Drawable f(int index) {
        int resourceId;
        if (this.b.hasValue(index) && (resourceId = this.b.getResourceId(index, 0)) != 0) {
            return j0.d(this.a, resourceId);
        }
        return this.b.getDrawable(index);
    }

    public Drawable g(int index) {
        int resourceId;
        if (this.b.hasValue(index) && (resourceId = this.b.getResourceId(index, 0)) != 0) {
            return y1.b().d(this.a, resourceId, true);
        }
        return null;
    }

    public Typeface i(int index, int style, v7.a fontCallback) {
        int resourceId = this.b.getResourceId(index, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return v7.b(this.a, resourceId, this.c, style, fontCallback);
    }

    public CharSequence o(int index) {
        return this.b.getText(index);
    }

    public String n(int index) {
        return this.b.getString(index);
    }

    public boolean a(int index, boolean defValue) {
        return this.b.getBoolean(index, defValue);
    }

    public int j(int index, int defValue) {
        return this.b.getInt(index, defValue);
    }

    public float h(int index, float defValue) {
        return this.b.getFloat(index, defValue);
    }

    public int b(int index, int defValue) {
        return this.b.getColor(index, defValue);
    }

    public ColorStateList c(int index) {
        int resourceId;
        ColorStateList value;
        if (this.b.hasValue(index) && (resourceId = this.b.getResourceId(index, 0)) != 0 && (value = j0.c(this.a, resourceId)) != null) {
            return value;
        }
        return this.b.getColorStateList(index);
    }

    public int k(int index, int defValue) {
        return this.b.getInteger(index, defValue);
    }

    public int d(int index, int defValue) {
        return this.b.getDimensionPixelOffset(index, defValue);
    }

    public int e(int index, int defValue) {
        return this.b.getDimensionPixelSize(index, defValue);
    }

    public int l(int index, int defValue) {
        return this.b.getLayoutDimension(index, defValue);
    }

    public int m(int index, int defValue) {
        return this.b.getResourceId(index, defValue);
    }

    public CharSequence[] p(int index) {
        return this.b.getTextArray(index);
    }

    public boolean r(int index) {
        return this.b.hasValue(index);
    }

    public void v() {
        this.b.recycle();
    }
}
