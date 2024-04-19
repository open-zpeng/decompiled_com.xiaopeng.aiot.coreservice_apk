package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import defpackage.c9;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* compiled from: TextViewCompat.java */
/* renamed from: gb  reason: default package */
/* loaded from: classes.dex */
public final class gb {
    public static ActionMode.Callback m(TextView textView, ActionMode.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        if (i < 26 || i > 27 || (callback instanceof a)) {
            return callback;
        }
        return new a(callback, textView);
    }

    /* compiled from: TextViewCompat.java */
    /* renamed from: gb$a */
    /* loaded from: classes.dex */
    public static class a implements ActionMode.Callback {
        public final ActionMode.Callback a;
        public final TextView b;
        public Class<?> c;
        public Method d;
        public boolean e;
        public boolean f = false;

        public a(ActionMode.Callback callback, TextView textView) {
            this.a = callback;
            this.b = textView;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return this.a.onCreateActionMode(mode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            f(menu);
            return this.a.onPrepareActionMode(mode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return this.a.onActionItemClicked(mode, item);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode mode) {
            this.a.onDestroyActionMode(mode);
        }

        public final void f(Menu menu) {
            Method removeItemAtMethod;
            Context context = this.b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f) {
                this.f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.c = cls;
                    this.d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.e = true;
                } catch (ClassNotFoundException | NoSuchMethodException e) {
                    this.c = null;
                    this.d = null;
                    this.e = false;
                }
            }
            try {
                if (this.e && this.c.isInstance(menu)) {
                    removeItemAtMethod = this.d;
                } else {
                    removeItemAtMethod = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                }
                for (int i = menu.size() - 1; i >= 0; i--) {
                    MenuItem item = menu.getItem(i);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        removeItemAtMethod.invoke(menu, Integer.valueOf(i));
                    }
                }
                List<ResolveInfo> supportedActivities = c(context, packageManager);
                for (int i2 = 0; i2 < supportedActivities.size(); i2++) {
                    ResolveInfo info = supportedActivities.get(i2);
                    menu.add(0, 0, i2 + 100, info.loadLabel(packageManager)).setIntent(b(info, this.b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            }
        }

        public final List<ResolveInfo> c(Context context, PackageManager packageManager) {
            List<ResolveInfo> supportedActivities = new ArrayList<>();
            boolean canStartActivityForResult = context instanceof Activity;
            if (!canStartActivityForResult) {
                return supportedActivities;
            }
            List<ResolveInfo> unfiltered = packageManager.queryIntentActivities(a(), 0);
            for (ResolveInfo info : unfiltered) {
                if (e(info, context)) {
                    supportedActivities.add(info);
                }
            }
            return supportedActivities;
        }

        public final boolean e(ResolveInfo info, Context context) {
            if (context.getPackageName().equals(info.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = info.activityInfo;
            if (activityInfo.exported) {
                String str = activityInfo.permission;
                return str == null || context.checkSelfPermission(str) == 0;
            }
            return false;
        }

        public final Intent b(ResolveInfo info, TextView textView11) {
            Intent putExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !d(textView11));
            ActivityInfo activityInfo = info.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        public final boolean d(TextView textView11) {
            return (textView11 instanceof Editable) && textView11.onCheckIsTextEditor() && textView11.isEnabled();
        }

        public final Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
    }

    public static void h(TextView textView, int firstBaselineToTopHeight) {
        int fontMetricsTop;
        k9.b(firstBaselineToTopHeight);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            textView.setFirstBaselineToTopHeight(firstBaselineToTopHeight);
            return;
        }
        Paint.FontMetricsInt fontMetrics = textView.getPaint().getFontMetricsInt();
        if (i < 16 || textView.getIncludeFontPadding()) {
            fontMetricsTop = fontMetrics.top;
        } else {
            fontMetricsTop = fontMetrics.ascent;
        }
        if (firstBaselineToTopHeight > Math.abs(fontMetricsTop)) {
            int paddingTop = firstBaselineToTopHeight + fontMetricsTop;
            textView.setPadding(textView.getPaddingLeft(), paddingTop, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void i(TextView textView, int lastBaselineToBottomHeight) {
        int fontMetricsBottom;
        k9.b(lastBaselineToBottomHeight);
        Paint.FontMetricsInt fontMetrics = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            fontMetricsBottom = fontMetrics.bottom;
        } else {
            fontMetricsBottom = fontMetrics.descent;
        }
        if (lastBaselineToBottomHeight > Math.abs(fontMetricsBottom)) {
            int paddingBottom = lastBaselineToBottomHeight - fontMetricsBottom;
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), paddingBottom);
        }
    }

    public static int a(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int b(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static void j(TextView textView, int lineHeight) {
        k9.b(lineHeight);
        int fontHeight = textView.getPaint().getFontMetricsInt(null);
        if (lineHeight != fontHeight) {
            textView.setLineSpacing(lineHeight - fontHeight, 1.0f);
        }
    }

    public static c9.a e(TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return new c9.a(textView.getTextMetricsParams());
        }
        c9.a.C0003a builder = new c9.a.C0003a(new TextPaint(textView.getPaint()));
        if (i >= 23) {
            builder.b(textView.getBreakStrategy());
            builder.c(textView.getHyphenationFrequency());
        }
        if (i >= 18) {
            builder.d(d(textView));
        }
        return builder.a();
    }

    public static void l(TextView textView, c9.a params) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            textView.setTextDirection(c(params.d()));
        }
        if (i < 23) {
            float paintTextScaleX = params.e().getTextScaleX();
            textView.getPaint().set(params.e());
            if (paintTextScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((paintTextScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(paintTextScaleX);
            return;
        }
        textView.getPaint().set(params.e());
        textView.setBreakStrategy(params.b());
        textView.setHyphenationFrequency(params.c());
    }

    public static void k(TextView textView, c9 precomputed) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(precomputed.b());
            return;
        }
        c9.a param = e(textView);
        if (!param.a(precomputed.a())) {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
        textView.setText(precomputed);
    }

    public static TextDirectionHeuristic d(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(textView.getTextLocale());
            String zero = symbols.getDigitStrings()[0];
            int firstCodepoint = zero.codePointAt(0);
            byte digitDirection = Character.getDirectionality(firstCodepoint);
            if (digitDirection == 1 || digitDirection == 2) {
                return TextDirectionHeuristics.RTL;
            }
            return TextDirectionHeuristics.LTR;
        }
        boolean defaultIsRtl = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                return defaultIsRtl ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    public static int c(TextDirectionHeuristic heuristic) {
        if (heuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || heuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (heuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (heuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (heuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (heuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (heuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return heuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    public static void f(TextView textView, ColorStateList tint) {
        k9.d(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(tint);
        } else if (textView instanceof jb) {
            ((jb) textView).setSupportCompoundDrawablesTintList(tint);
        }
    }

    public static void g(TextView textView, PorterDuff.Mode tintMode) {
        k9.d(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(tintMode);
        } else if (textView instanceof jb) {
            ((jb) textView).setSupportCompoundDrawablesTintMode(tintMode);
        }
    }
}
