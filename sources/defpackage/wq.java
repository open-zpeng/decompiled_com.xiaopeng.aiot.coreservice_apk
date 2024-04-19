package defpackage;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
/* compiled from: XViewDelegateFontScale.java */
/* renamed from: wq  reason: default package */
/* loaded from: classes.dex */
public class wq extends xq {
    public TextView a;
    public float b;
    public float c;

    public static wq f(TextView view, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        if (attrs == null) {
            return null;
        }
        Resources.Theme theme = view.getContext().getTheme();
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, bp.G1, defStyleAttr, defStyleRes);
        boolean isDynamicFontSizeChangeEnable = a.getBoolean(bp.H1, true);
        a.recycle();
        if (!isDynamicFontSizeChangeEnable) {
            return null;
        }
        boolean isTextSize = false;
        int textSizeUnit = 0;
        float complexToFloat = 0.0f;
        TypedArray a2 = theme.obtainStyledAttributes(attrs, new int[]{16842901}, defStyleAttr, defStyleRes);
        if (a2.hasValue(0)) {
            TypedValue value = new TypedValue();
            a2.getValue(0, value);
            textSizeUnit = value.getComplexUnit();
            complexToFloat = TypedValue.complexToFloat(value.data);
            isTextSize = true;
        }
        a2.recycle();
        if (!isTextSize) {
            TypedArray a3 = theme.obtainStyledAttributes(attrs, new int[]{16842804}, defStyleAttr, defStyleRes);
            int ap = a3.getResourceId(0, -1);
            a3.recycle();
            TypedArray appearance = ap != -1 ? theme.obtainStyledAttributes(ap, new int[]{16842901}) : null;
            if (appearance != null) {
                if (appearance.hasValue(0)) {
                    TypedValue value2 = new TypedValue();
                    appearance.getValue(0, value2);
                    textSizeUnit = value2.getComplexUnit();
                    complexToFloat = TypedValue.complexToFloat(value2.data);
                }
                appearance.recycle();
            }
        }
        if (textSizeUnit != 2) {
            return null;
        }
        return new wq(view, complexToFloat);
    }

    public wq(TextView textView, float complexToFloat) {
        this.a = textView;
        this.b = complexToFloat;
        this.c = textView.getContext().getResources().getConfiguration().fontScale;
    }

    @Override // defpackage.xq
    public void c(Configuration config) {
        e(config, "onConfigurationChanged");
    }

    public final void e(Configuration config, String from) {
        float f = this.c;
        float f2 = config.fontScale;
        if (f != f2) {
            this.c = f2;
            this.a.setTextSize(this.b);
        }
    }

    @Override // defpackage.xq
    public void b() {
        e(this.a.getResources().getConfiguration(), "onAttachedToWindow");
    }

    @Override // defpackage.xq
    public void d() {
    }
}
