package defpackage;

import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
/* compiled from: XBackgroundPaddingUtils.java */
/* renamed from: pq  reason: default package */
/* loaded from: classes.dex */
public class pq {
    public static Rect b(View view, AttributeSet attrs) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, bp.M0);
        boolean enable = a.getBoolean(bp.P0, false);
        if (enable) {
            int insetLeft = -1;
            int insetRight = -1;
            int insetTop = -1;
            int insetBottom = -1;
            int i = bp.N0;
            if (a.hasValue(i)) {
                int inset = a.getDimensionPixelSize(i, -1);
                insetBottom = inset;
                insetTop = inset;
                insetRight = inset;
                insetLeft = inset;
            }
            int inset2 = bp.Q0;
            if (a.hasValue(inset2)) {
                insetLeft = a.getDimensionPixelSize(inset2, -1);
            }
            int i2 = bp.R0;
            if (a.hasValue(i2)) {
                insetRight = a.getDimensionPixelSize(i2, -1);
            }
            int i3 = bp.S0;
            if (a.hasValue(i3)) {
                insetTop = a.getDimensionPixelSize(i3, -1);
            }
            int i4 = bp.O0;
            if (a.hasValue(i4)) {
                insetBottom = a.getDimensionPixelSize(i4, -1);
            }
            a.recycle();
            return a(view, insetLeft, insetTop, insetRight, insetBottom);
        }
        a.recycle();
        return null;
    }

    public static Rect a(View view, int insetLeft, int insetTop, int insetRight, int insetBottom) {
        int insetLeft2;
        int insetTop2;
        int insetRight2;
        int insetBottom2;
        Drawable child;
        int paddingLeftOffset;
        c(String.format("insetLeft %s, insetTop %s, insetRight %s, insetBottom %s, ", Integer.valueOf(insetLeft), Integer.valueOf(insetTop), Integer.valueOf(insetRight), Integer.valueOf(insetBottom)));
        Drawable drawable = view.getBackground();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        c(String.format("paddingLeft %s, paddingRight %s, paddingTop %s, paddingBottom %s, ", Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight), Integer.valueOf(paddingTop), Integer.valueOf(paddingBottom)));
        int paddingRightOffset = 0;
        int paddingTopOffset = 0;
        int paddingBottomOffset = 0;
        if (drawable != null) {
            if (drawable instanceof InsetDrawable) {
                InsetDrawable insetDrawable = (InsetDrawable) drawable;
                Drawable child2 = insetDrawable.getDrawable();
                Rect rect = new Rect();
                insetDrawable.getPadding(rect);
                int insetLeft3 = insetLeft;
                if (insetLeft3 == -1) {
                    insetLeft3 = rect.left;
                }
                insetTop2 = insetTop;
                if (insetTop2 == -1) {
                    insetTop2 = rect.top;
                }
                insetRight2 = insetRight;
                if (insetRight2 == -1) {
                    insetRight2 = rect.right;
                }
                insetBottom2 = insetBottom;
                if (insetBottom2 == -1) {
                    insetBottom2 = rect.bottom;
                }
                paddingLeftOffset = insetLeft3 - rect.left;
                paddingTopOffset = insetTop2 - rect.top;
                paddingRightOffset = insetRight2 - rect.right;
                paddingBottomOffset = insetBottom2 - rect.bottom;
                insetLeft2 = insetLeft3;
                child = child2;
            } else {
                insetLeft2 = insetLeft;
                insetTop2 = insetTop;
                insetRight2 = insetRight;
                insetBottom2 = insetBottom;
                child = drawable;
                paddingLeftOffset = 0;
            }
            c(String.format("paddingLeftOffset %s, paddingTopOffset %s, paddingRightOffset %s, paddingBottomOffset %s, ", Integer.valueOf(paddingLeftOffset), Integer.valueOf(paddingTopOffset), Integer.valueOf(paddingRightOffset), Integer.valueOf(paddingBottomOffset)));
            InsetDrawable newDrawable = new InsetDrawable(child, insetLeft2, insetTop2, insetRight2, insetBottom2);
            view.setBackground(newDrawable);
            newDrawable.setDrawable(child);
            int paddingLeftOffset2 = paddingBottom + paddingBottomOffset;
            view.setPadding(paddingLeft + paddingLeftOffset, paddingTop + paddingTopOffset, paddingRight + paddingRightOffset, paddingLeftOffset2);
            c(String.format("paddingLeft %s, paddingRight %s, paddingTop %s, paddingBottom %s, ", Integer.valueOf(view.getPaddingLeft()), Integer.valueOf(view.getPaddingRight()), Integer.valueOf(view.getPaddingTop()), Integer.valueOf(view.getPaddingBottom())));
            return new Rect(insetLeft2, insetTop2, insetRight2, insetBottom2);
        }
        return null;
    }

    public static void c(String msg) {
        rq.a("xpui-bgPadding", msg);
    }
}
