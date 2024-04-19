package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
/* compiled from: TooltipPopup.java */
/* renamed from: d3  reason: default package */
/* loaded from: classes.dex */
public class d3 {
    public final Context a;
    public final View b;
    public final TextView c;
    public final WindowManager.LayoutParams d;
    public final Rect e;
    public final int[] f;
    public final int[] g;

    public d3(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.d = layoutParams;
        this.e = new Rect();
        this.f = new int[2];
        this.g = new int[2];
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(t.abc_tooltip, (ViewGroup) null);
        this.b = inflate;
        this.c = (TextView) inflate.findViewById(s.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = v.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public void e(View anchorView, int anchorX, int anchorY, boolean fromTouch, CharSequence tooltipText) {
        if (d()) {
            c();
        }
        this.c.setText(tooltipText);
        a(anchorView, anchorX, anchorY, fromTouch, this.d);
        WindowManager wm = (WindowManager) this.a.getSystemService("window");
        wm.addView(this.b, this.d);
    }

    public void c() {
        if (!d()) {
            return;
        }
        WindowManager wm = (WindowManager) this.a.getSystemService("window");
        wm.removeView(this.b);
    }

    public boolean d() {
        return this.b.getParent() != null;
    }

    public final void a(View anchorView, int anchorX, int anchorY, boolean fromTouch, WindowManager.LayoutParams outParams) {
        int offsetX;
        int offsetBelow;
        int offsetExtra;
        int statusBarHeight;
        outParams.token = anchorView.getApplicationWindowToken();
        int tooltipPreciseAnchorThreshold = this.a.getResources().getDimensionPixelOffset(q.tooltip_precise_anchor_threshold);
        if (anchorView.getWidth() >= tooltipPreciseAnchorThreshold) {
            offsetX = anchorX;
        } else {
            int offsetX2 = anchorView.getWidth();
            offsetX = offsetX2 / 2;
        }
        if (anchorView.getHeight() >= tooltipPreciseAnchorThreshold) {
            int offsetExtra2 = this.a.getResources().getDimensionPixelOffset(q.tooltip_precise_anchor_extra_offset);
            offsetBelow = anchorY + offsetExtra2;
            offsetExtra = anchorY - offsetExtra2;
        } else {
            offsetBelow = anchorView.getHeight();
            offsetExtra = 0;
        }
        outParams.gravity = 49;
        int tooltipOffset = this.a.getResources().getDimensionPixelOffset(fromTouch ? q.tooltip_y_offset_touch : q.tooltip_y_offset_non_touch);
        View appView = b(anchorView);
        if (appView == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        appView.getWindowVisibleDisplayFrame(this.e);
        Rect rect = this.e;
        if (rect.left < 0 && rect.top < 0) {
            Resources res = this.a.getResources();
            int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId != 0) {
                statusBarHeight = res.getDimensionPixelSize(resourceId);
            } else {
                statusBarHeight = 0;
            }
            DisplayMetrics metrics = res.getDisplayMetrics();
            this.e.set(0, statusBarHeight, metrics.widthPixels, metrics.heightPixels);
        }
        appView.getLocationOnScreen(this.g);
        anchorView.getLocationOnScreen(this.f);
        int[] iArr = this.f;
        int i = iArr[0];
        int[] iArr2 = this.g;
        iArr[0] = i - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        outParams.x = (iArr[0] + offsetX) - (appView.getWidth() / 2);
        int spec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.b.measure(spec, spec);
        int tooltipHeight = this.b.getMeasuredHeight();
        int[] iArr3 = this.f;
        int yAbove = ((iArr3[1] + offsetExtra) - tooltipOffset) - tooltipHeight;
        int yBelow = iArr3[1] + offsetBelow + tooltipOffset;
        if (!fromTouch) {
            if (yBelow + tooltipHeight <= this.e.height()) {
                outParams.y = yBelow;
            } else {
                outParams.y = yAbove;
            }
        } else if (yAbove >= 0) {
            outParams.y = yAbove;
        } else {
            outParams.y = yBelow;
        }
    }

    public static View b(View anchorView) {
        View rootView = anchorView.getRootView();
        ViewGroup.LayoutParams lp = rootView.getLayoutParams();
        if ((lp instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) lp).type == 2) {
            return rootView;
        }
        for (Context context = anchorView.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
