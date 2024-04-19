package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.lzy.okgo.model.Priority;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: AppCompatTextViewAutoSizeHelper.java */
/* renamed from: h2  reason: default package */
/* loaded from: classes.dex */
public class h2 {
    public static final RectF a = new RectF();
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Method> b = new ConcurrentHashMap<>();
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Field> c = new ConcurrentHashMap<>();
    public int d = 0;
    public boolean e = false;
    public float f = -1.0f;
    public float g = -1.0f;
    public float h = -1.0f;
    public int[] i = new int[0];
    public boolean j = false;
    public TextPaint k;
    public final TextView l;
    public final Context m;
    public final c n;

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* renamed from: h2$c */
    /* loaded from: classes.dex */
    public static class c {
        public boolean b(TextView textView) {
            return ((Boolean) h2.r(textView, "getHorizontallyScrolling", false)).booleanValue();
        }

        public void a(StaticLayout.Builder layoutBuilder, TextView textView) {
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* renamed from: h2$a */
    /* loaded from: classes.dex */
    public static class a extends c {
        @Override // defpackage.h2.c
        public void a(StaticLayout.Builder layoutBuilder, TextView textView) {
            TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) h2.r(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
            layoutBuilder.setTextDirection(textDirectionHeuristic);
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* renamed from: h2$b */
    /* loaded from: classes.dex */
    public static class b extends a {
        @Override // defpackage.h2.c
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }

        @Override // defpackage.h2.a, defpackage.h2.c
        public void a(StaticLayout.Builder layoutBuilder, TextView textView) {
            layoutBuilder.setTextDirection(textView.getTextDirectionHeuristic());
        }
    }

    public h2(TextView textView) {
        this.l = textView;
        this.m = textView.getContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            this.n = new b();
        } else if (i >= 23) {
            this.n = new a();
        } else {
            this.n = new c();
        }
    }

    public void t(AttributeSet attrs, int defStyleAttr) {
        int autoSizeStepSizeArrayResId;
        float autoSizeMinTextSizeInPx = -1.0f;
        float autoSizeMaxTextSizeInPx = -1.0f;
        float autoSizeStepGranularityInPx = -1.0f;
        Context context = this.m;
        int[] iArr = w.i0;
        TypedArray a2 = context.obtainStyledAttributes(attrs, iArr, defStyleAttr, 0);
        TextView textView = this.l;
        ga.X(textView, textView.getContext(), iArr, attrs, a2, defStyleAttr, 0);
        int i = w.n0;
        if (a2.hasValue(i)) {
            this.d = a2.getInt(i, 0);
        }
        int i2 = w.m0;
        if (a2.hasValue(i2)) {
            autoSizeStepGranularityInPx = a2.getDimension(i2, -1.0f);
        }
        int i3 = w.k0;
        if (a2.hasValue(i3)) {
            autoSizeMinTextSizeInPx = a2.getDimension(i3, -1.0f);
        }
        int i4 = w.j0;
        if (a2.hasValue(i4)) {
            autoSizeMaxTextSizeInPx = a2.getDimension(i4, -1.0f);
        }
        int i5 = w.l0;
        if (a2.hasValue(i5) && (autoSizeStepSizeArrayResId = a2.getResourceId(i5, 0)) > 0) {
            TypedArray autoSizePreDefTextSizes = a2.getResources().obtainTypedArray(autoSizeStepSizeArrayResId);
            A(autoSizePreDefTextSizes);
            autoSizePreDefTextSizes.recycle();
        }
        a2.recycle();
        if (D()) {
            if (this.d == 1) {
                if (!this.j) {
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    if (autoSizeMinTextSizeInPx == -1.0f) {
                        autoSizeMinTextSizeInPx = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (autoSizeMaxTextSizeInPx == -1.0f) {
                        autoSizeMaxTextSizeInPx = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (autoSizeStepGranularityInPx == -1.0f) {
                        autoSizeStepGranularityInPx = 1.0f;
                    }
                    E(autoSizeMinTextSizeInPx, autoSizeMaxTextSizeInPx, autoSizeStepGranularityInPx);
                }
                z();
                return;
            }
            return;
        }
        this.d = 0;
    }

    public void w(int autoSizeTextType) {
        if (D()) {
            switch (autoSizeTextType) {
                case 0:
                    d();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    float autoSizeMinTextSizeInPx = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    float autoSizeMaxTextSizeInPx = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    E(autoSizeMinTextSizeInPx, autoSizeMaxTextSizeInPx, 1.0f);
                    if (z()) {
                        b();
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown auto-size text type: " + autoSizeTextType);
            }
        }
    }

    public void u(int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit) throws IllegalArgumentException {
        if (D()) {
            DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
            float autoSizeMinTextSizeInPx = TypedValue.applyDimension(unit, autoSizeMinTextSize, displayMetrics);
            float autoSizeMaxTextSizeInPx = TypedValue.applyDimension(unit, autoSizeMaxTextSize, displayMetrics);
            float autoSizeStepGranularityInPx = TypedValue.applyDimension(unit, autoSizeStepGranularity, displayMetrics);
            E(autoSizeMinTextSizeInPx, autoSizeMaxTextSizeInPx, autoSizeStepGranularityInPx);
            if (z()) {
                b();
            }
        }
    }

    public void v(int[] presetSizes, int unit) throws IllegalArgumentException {
        if (D()) {
            int presetSizesLength = presetSizes.length;
            if (presetSizesLength > 0) {
                int[] presetSizesInPx = new int[presetSizesLength];
                if (unit == 0) {
                    presetSizesInPx = Arrays.copyOf(presetSizes, presetSizesLength);
                } else {
                    DisplayMetrics displayMetrics = this.m.getResources().getDisplayMetrics();
                    for (int i = 0; i < presetSizesLength; i++) {
                        presetSizesInPx[i] = Math.round(TypedValue.applyDimension(unit, presetSizes[i], displayMetrics));
                    }
                }
                this.i = c(presetSizesInPx);
                if (!B()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(presetSizes));
                }
            } else {
                this.j = false;
            }
            if (z()) {
                b();
            }
        }
    }

    public int n() {
        return this.d;
    }

    public int l() {
        return Math.round(this.f);
    }

    public int k() {
        return Math.round(this.g);
    }

    public int j() {
        return Math.round(this.h);
    }

    public int[] m() {
        return this.i;
    }

    public final void A(TypedArray textSizes) {
        int textSizesLength = textSizes.length();
        int[] parsedSizes = new int[textSizesLength];
        if (textSizesLength > 0) {
            for (int i = 0; i < textSizesLength; i++) {
                parsedSizes[i] = textSizes.getDimensionPixelSize(i, -1);
            }
            this.i = c(parsedSizes);
            B();
        }
    }

    public final boolean B() {
        int[] iArr = this.i;
        int sizesLength = iArr.length;
        boolean z = sizesLength > 0;
        this.j = z;
        if (z) {
            this.d = 1;
            this.g = iArr[0];
            this.h = iArr[sizesLength - 1];
            this.f = -1.0f;
        }
        return z;
    }

    public final int[] c(int[] presetValues) {
        int presetValuesLength = presetValues.length;
        if (presetValuesLength == 0) {
            return presetValues;
        }
        Arrays.sort(presetValues);
        List<Integer> uniqueValidSizes = new ArrayList<>();
        for (int currentPresetValue : presetValues) {
            if (currentPresetValue > 0 && Collections.binarySearch(uniqueValidSizes, Integer.valueOf(currentPresetValue)) < 0) {
                uniqueValidSizes.add(Integer.valueOf(currentPresetValue));
            }
        }
        int i = uniqueValidSizes.size();
        if (presetValuesLength == i) {
            return presetValues;
        }
        int uniqueValidSizesLength = uniqueValidSizes.size();
        int[] cleanedUpSizes = new int[uniqueValidSizesLength];
        for (int i2 = 0; i2 < uniqueValidSizesLength; i2++) {
            cleanedUpSizes[i2] = uniqueValidSizes.get(i2).intValue();
        }
        return cleanedUpSizes;
    }

    public final void E(float autoSizeMinTextSizeInPx, float autoSizeMaxTextSizeInPx, float autoSizeStepGranularityInPx) throws IllegalArgumentException {
        if (autoSizeMinTextSizeInPx <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + autoSizeMinTextSizeInPx + "px) is less or equal to (0px)");
        } else if (autoSizeMaxTextSizeInPx <= autoSizeMinTextSizeInPx) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + autoSizeMaxTextSizeInPx + "px) is less or equal to minimum auto-size text size (" + autoSizeMinTextSizeInPx + "px)");
        } else if (autoSizeStepGranularityInPx <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + autoSizeStepGranularityInPx + "px) is less or equal to (0px)");
        } else {
            this.d = 1;
            this.g = autoSizeMinTextSizeInPx;
            this.h = autoSizeMaxTextSizeInPx;
            this.f = autoSizeStepGranularityInPx;
            this.j = false;
        }
    }

    public final boolean z() {
        if (D() && this.d == 1) {
            if (!this.j || this.i.length == 0) {
                int autoSizeValuesLength = ((int) Math.floor((this.h - this.g) / this.f)) + 1;
                int[] autoSizeTextSizesInPx = new int[autoSizeValuesLength];
                for (int i = 0; i < autoSizeValuesLength; i++) {
                    autoSizeTextSizesInPx[i] = Math.round(this.g + (i * this.f));
                }
                this.i = c(autoSizeTextSizesInPx);
            }
            this.e = true;
        } else {
            this.e = false;
        }
        return this.e;
    }

    public void b() {
        int availableWidth;
        if (!s()) {
            return;
        }
        if (this.e) {
            if (this.l.getMeasuredHeight() <= 0 || this.l.getMeasuredWidth() <= 0) {
                return;
            }
            boolean horizontallyScrolling = this.n.b(this.l);
            if (horizontallyScrolling) {
                availableWidth = 1048576;
            } else {
                availableWidth = (this.l.getMeasuredWidth() - this.l.getTotalPaddingLeft()) - this.l.getTotalPaddingRight();
            }
            int availableHeight = (this.l.getHeight() - this.l.getCompoundPaddingBottom()) - this.l.getCompoundPaddingTop();
            if (availableWidth <= 0 || availableHeight <= 0) {
                return;
            }
            RectF rectF = a;
            synchronized (rectF) {
                rectF.setEmpty();
                rectF.right = availableWidth;
                rectF.bottom = availableHeight;
                float optimalTextSize = i(rectF);
                if (optimalTextSize != this.l.getTextSize()) {
                    y(0, optimalTextSize);
                }
            }
        }
        this.e = true;
    }

    public final void d() {
        this.d = 0;
        this.g = -1.0f;
        this.h = -1.0f;
        this.f = -1.0f;
        this.i = new int[0];
        this.e = false;
    }

    public void y(int unit, float size) {
        Resources res;
        Context context = this.m;
        if (context == null) {
            res = Resources.getSystem();
        } else {
            res = context.getResources();
        }
        x(TypedValue.applyDimension(unit, size, res.getDisplayMetrics()));
    }

    public final void x(float size) {
        if (size != this.l.getPaint().getTextSize()) {
            this.l.getPaint().setTextSize(size);
            boolean isInLayout = false;
            if (Build.VERSION.SDK_INT >= 18) {
                isInLayout = this.l.isInLayout();
            }
            if (this.l.getLayout() != null) {
                this.e = false;
                try {
                    Method method = p("nullLayouts");
                    if (method != null) {
                        method.invoke(this.l, new Object[0]);
                    }
                } catch (Exception ex) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", ex);
                }
                if (!isInLayout) {
                    this.l.requestLayout();
                } else {
                    this.l.forceLayout();
                }
                this.l.invalidate();
            }
        }
    }

    public final int i(RectF availableSpace) {
        int sizesCount = this.i.length;
        if (sizesCount == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int bestSizeIndex = 0;
        int lowIndex = 0 + 1;
        int highIndex = sizesCount - 1;
        while (lowIndex <= highIndex) {
            int sizeToTryIndex = (lowIndex + highIndex) / 2;
            if (C(this.i[sizeToTryIndex], availableSpace)) {
                bestSizeIndex = lowIndex;
                lowIndex = sizeToTryIndex + 1;
            } else {
                highIndex = sizeToTryIndex - 1;
                bestSizeIndex = highIndex;
            }
        }
        return this.i[bestSizeIndex];
    }

    public void q(int suggestedSizeInPx) {
        TextPaint textPaint = this.k;
        if (textPaint == null) {
            this.k = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.k.set(this.l.getPaint());
        this.k.setTextSize(suggestedSizeInPx);
    }

    public StaticLayout e(CharSequence text, Layout.Alignment alignment, int availableWidth, int maxLines) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return f(text, alignment, availableWidth, maxLines);
        }
        if (i >= 16) {
            return h(text, alignment, availableWidth);
        }
        return g(text, alignment, availableWidth);
    }

    public final boolean C(int suggestedSizeInPx, RectF availableSpace) {
        CharSequence transformedText;
        CharSequence text = this.l.getText();
        TransformationMethod transformationMethod = this.l.getTransformationMethod();
        if (transformationMethod != null && (transformedText = transformationMethod.getTransformation(text, this.l)) != null) {
            text = transformedText;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.l.getMaxLines() : -1;
        q(suggestedSizeInPx);
        Layout.Alignment alignment = (Layout.Alignment) r(this.l, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
        StaticLayout layout = e(text, alignment, Math.round(availableSpace.right), maxLines);
        return (maxLines == -1 || (layout.getLineCount() <= maxLines && layout.getLineEnd(layout.getLineCount() - 1) == text.length())) && ((float) layout.getHeight()) <= availableSpace.bottom;
    }

    public final StaticLayout f(CharSequence text, Layout.Alignment alignment, int availableWidth, int maxLines) {
        StaticLayout.Builder layoutBuilder = StaticLayout.Builder.obtain(text, 0, text.length(), this.k, availableWidth);
        layoutBuilder.setAlignment(alignment).setLineSpacing(this.l.getLineSpacingExtra(), this.l.getLineSpacingMultiplier()).setIncludePad(this.l.getIncludeFontPadding()).setBreakStrategy(this.l.getBreakStrategy()).setHyphenationFrequency(this.l.getHyphenationFrequency()).setMaxLines(maxLines == -1 ? Priority.UI_TOP : maxLines);
        try {
            this.n.a(layoutBuilder, this.l);
        } catch (ClassCastException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return layoutBuilder.build();
    }

    public final StaticLayout h(CharSequence text, Layout.Alignment alignment, int availableWidth) {
        float lineSpacingMultiplier = this.l.getLineSpacingMultiplier();
        float lineSpacingAdd = this.l.getLineSpacingExtra();
        boolean includePad = this.l.getIncludeFontPadding();
        return new StaticLayout(text, this.k, availableWidth, alignment, lineSpacingMultiplier, lineSpacingAdd, includePad);
    }

    public final StaticLayout g(CharSequence text, Layout.Alignment alignment, int availableWidth) {
        float lineSpacingMultiplier = ((Float) a(this.l, "mSpacingMult", Float.valueOf(1.0f))).floatValue();
        float lineSpacingAdd = ((Float) a(this.l, "mSpacingAdd", Float.valueOf(0.0f))).floatValue();
        boolean includePad = ((Boolean) a(this.l, "mIncludePad", true)).booleanValue();
        return new StaticLayout(text, this.k, availableWidth, alignment, lineSpacingMultiplier, lineSpacingAdd, includePad);
    }

    public static <T> T r(Object object, String methodName, T defaultValue) {
        try {
            try {
                Method method = p(methodName);
                T result = (T) method.invoke(object, new Object[0]);
                if (result != null || 0 == 0) {
                    return result;
                }
            } catch (Exception ex) {
                Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + methodName + "() method", ex);
                if (0 != 0 || 1 == 0) {
                    return null;
                }
            }
            return defaultValue;
        } catch (Throwable th) {
            if (0 != 0 || 0 != 0) {
            }
            throw th;
        }
    }

    public static <T> T a(Object object, String fieldName, T defaultValue) {
        try {
            Field field = o(fieldName);
            if (field == null) {
                return defaultValue;
            }
            return (T) field.get(object);
        } catch (IllegalAccessException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + fieldName + " member", e);
            return defaultValue;
        }
    }

    public static Method p(String methodName) {
        try {
            Method method = b.get(methodName);
            if (method == null && (method = TextView.class.getDeclaredMethod(methodName, new Class[0])) != null) {
                method.setAccessible(true);
                b.put(methodName, method);
            }
            return method;
        } catch (Exception ex) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + methodName + "() method", ex);
            return null;
        }
    }

    public static Field o(String fieldName) {
        try {
            Field field = c.get(fieldName);
            if (field == null && (field = TextView.class.getDeclaredField(fieldName)) != null) {
                field.setAccessible(true);
                c.put(fieldName, field);
            }
            return field;
        } catch (NoSuchFieldException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + fieldName + " member", e);
            return null;
        }
    }

    public boolean s() {
        return D() && this.d != 0;
    }

    public final boolean D() {
        return !(this.l instanceof AppCompatEditText);
    }
}
