package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import defpackage.v7;
import java.lang.ref.WeakReference;
/* compiled from: AppCompatTextHelper.java */
/* renamed from: g2  reason: default package */
/* loaded from: classes.dex */
public class g2 {
    public final TextView a;
    public x2 b;
    public x2 c;
    public x2 d;
    public x2 e;
    public x2 f;
    public x2 g;
    public x2 h;
    public final h2 i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    public g2(TextView view) {
        this.a = view;
        this.i = new h2(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01dd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e6  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(android.util.AttributeSet r37, int r38) {
        /*
            Method dump skipped, instructions count: 886
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g2.m(android.util.AttributeSet, int):void");
    }

    public final void C(Context context, z2 a2) {
        String fontFamilyName;
        this.j = a2.j(w.M2, this.j);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            int j = a2.j(w.R2, -1);
            this.k = j;
            if (j != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        int fontFamilyId = w.Q2;
        if (a2.r(fontFamilyId) || a2.r(w.S2)) {
            this.l = null;
            int i2 = w.S2;
            if (a2.r(i2)) {
                fontFamilyId = i2;
            }
            int fontWeight = this.k;
            int style = this.j;
            if (!context.isRestricted()) {
                WeakReference<TextView> textViewWeak = new WeakReference<>(this.a);
                v7.a replyCallback = new a(fontWeight, style, textViewWeak);
                try {
                    Typeface typeface = a2.i(fontFamilyId, this.j, replyCallback);
                    if (typeface != null) {
                        if (i >= 28 && this.k != -1) {
                            this.l = Typeface.create(Typeface.create(typeface, 0), this.k, (this.j & 2) != 0);
                        } else {
                            this.l = typeface;
                        }
                    }
                    this.m = this.l == null;
                } catch (Resources.NotFoundException e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
            if (this.l == null && (fontFamilyName = a2.n(fontFamilyId)) != null) {
                if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                    this.l = Typeface.create(Typeface.create(fontFamilyName, 0), this.k, (this.j & 2) != 0);
                    return;
                } else {
                    this.l = Typeface.create(fontFamilyName, this.j);
                    return;
                }
            }
            return;
        }
        int i3 = w.L2;
        if (a2.r(i3)) {
            this.m = false;
            int typefaceIndex = a2.j(i3, 1);
            switch (typefaceIndex) {
                case 1:
                    this.l = Typeface.SANS_SERIF;
                    return;
                case 2:
                    this.l = Typeface.SERIF;
                    return;
                case 3:
                    this.l = Typeface.MONOSPACE;
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    /* renamed from: g2$a */
    /* loaded from: classes.dex */
    public class a extends v7.a {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ WeakReference c;

        public a(int i, int i2, WeakReference weakReference) {
            this.a = i;
            this.b = i2;
            this.c = weakReference;
        }

        @Override // defpackage.v7.a
        public void e(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.a) != -1) {
                typeface = Typeface.create(typeface, i, (this.b & 2) != 0);
            }
            g2.this.n(this.c, typeface);
        }

        @Override // defpackage.v7.a
        public void d(int reason) {
        }
    }

    public void n(WeakReference<TextView> textViewWeak, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = textViewWeak.get();
            if (textView != null) {
                if (ga.I(textView)) {
                    int style = this.j;
                    textView.post(new b(textView, typeface, style));
                    return;
                }
                textView.setTypeface(typeface, this.j);
            }
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    /* renamed from: g2$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ Typeface b;
        public final /* synthetic */ int d;

        public b(TextView textView, Typeface typeface, int i) {
            this.a = textView;
            this.b = typeface;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setTypeface(this.b, this.d);
        }
    }

    public void q(Context context, int resId) {
        String fontVariation;
        ColorStateList textColorHint;
        ColorStateList textColorLink;
        ColorStateList textColor;
        z2 a2 = z2.s(context, resId, w.J2);
        int i = w.U2;
        if (a2.r(i)) {
            s(a2.a(i, false));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            int i3 = w.N2;
            if (a2.r(i3) && (textColor = a2.c(i3)) != null) {
                this.a.setTextColor(textColor);
            }
            int i4 = w.P2;
            if (a2.r(i4) && (textColorLink = a2.c(i4)) != null) {
                this.a.setLinkTextColor(textColorLink);
            }
            int i5 = w.O2;
            if (a2.r(i5) && (textColorHint = a2.c(i5)) != null) {
                this.a.setHintTextColor(textColorHint);
            }
        }
        int i6 = w.K2;
        if (a2.r(i6) && a2.e(i6, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        C(context, a2);
        if (i2 >= 26) {
            int i7 = w.T2;
            if (a2.r(i7) && (fontVariation = a2.n(i7)) != null) {
                this.a.setFontVariationSettings(fontVariation);
            }
        }
        a2.v();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.j);
        }
    }

    public void s(boolean allCaps) {
        this.a.setAllCaps(allCaps);
    }

    public void p() {
        b();
    }

    public void b() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f != null || this.g != null) {
                Drawable[] compoundDrawables2 = this.a.getCompoundDrawablesRelative();
                a(compoundDrawables2[0], this.f);
                a(compoundDrawables2[2], this.g);
            }
        }
    }

    public final void a(Drawable drawable, x2 info) {
        if (drawable != null && info != null) {
            y1.i(drawable, info, this.a.getDrawableState());
        }
    }

    public static x2 d(Context context, y1 drawableManager, int drawableId) {
        ColorStateList tintList = drawableManager.f(context, drawableId);
        if (tintList != null) {
            x2 tintInfo = new x2();
            tintInfo.d = true;
            tintInfo.a = tintList;
            return tintInfo;
        }
        return null;
    }

    public void o(boolean changed, int left, int top, int right, int bottom) {
        if (!za.c) {
            c();
        }
    }

    public void A(int unit, float size) {
        if (!za.c && !l()) {
            B(unit, size);
        }
    }

    public void c() {
        this.i.b();
    }

    public boolean l() {
        return this.i.s();
    }

    public final void B(int unit, float size) {
        this.i.y(unit, size);
    }

    public void v(int autoSizeTextType) {
        this.i.w(autoSizeTextType);
    }

    public void t(int autoSizeMinTextSize, int autoSizeMaxTextSize, int autoSizeStepGranularity, int unit) throws IllegalArgumentException {
        this.i.u(autoSizeMinTextSize, autoSizeMaxTextSize, autoSizeStepGranularity, unit);
    }

    public void u(int[] presetSizes, int unit) throws IllegalArgumentException {
        this.i.v(presetSizes, unit);
    }

    public int i() {
        return this.i.n();
    }

    public int g() {
        return this.i.l();
    }

    public int f() {
        return this.i.k();
    }

    public int e() {
        return this.i.j();
    }

    public int[] h() {
        return this.i.m();
    }

    public ColorStateList j() {
        x2 x2Var = this.h;
        if (x2Var != null) {
            return x2Var.a;
        }
        return null;
    }

    public void w(ColorStateList tintList) {
        if (this.h == null) {
            this.h = new x2();
        }
        x2 x2Var = this.h;
        x2Var.a = tintList;
        x2Var.d = tintList != null;
        z();
    }

    public PorterDuff.Mode k() {
        x2 x2Var = this.h;
        if (x2Var != null) {
            return x2Var.b;
        }
        return null;
    }

    public void x(PorterDuff.Mode tintMode) {
        if (this.h == null) {
            this.h = new x2();
        }
        x2 x2Var = this.h;
        x2Var.b = tintMode;
        x2Var.c = tintMode != null;
        z();
    }

    public final void z() {
        x2 x2Var = this.h;
        this.b = x2Var;
        this.c = x2Var;
        this.d = x2Var;
        this.e = x2Var;
        this.f = x2Var;
        this.g = x2Var;
    }

    public final void y(Drawable drawableLeft, Drawable drawableTop, Drawable drawableRight, Drawable drawableBottom, Drawable drawableStart, Drawable drawableEnd) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17 && (drawableStart != null || drawableEnd != null)) {
            Drawable[] existingRel = this.a.getCompoundDrawablesRelative();
            this.a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableStart != null ? drawableStart : existingRel[0], drawableTop != null ? drawableTop : existingRel[1], drawableEnd != null ? drawableEnd : existingRel[2], drawableBottom != null ? drawableBottom : existingRel[3]);
        } else if (drawableLeft != null || drawableTop != null || drawableRight != null || drawableBottom != null) {
            if (i >= 17) {
                Drawable[] existingRel2 = this.a.getCompoundDrawablesRelative();
                if (existingRel2[0] != null || existingRel2[2] != null) {
                    this.a.setCompoundDrawablesRelativeWithIntrinsicBounds(existingRel2[0], drawableTop != null ? drawableTop : existingRel2[1], existingRel2[2], drawableBottom != null ? drawableBottom : existingRel2[3]);
                    return;
                }
            }
            Drawable[] existingAbs = this.a.getCompoundDrawables();
            this.a.setCompoundDrawablesWithIntrinsicBounds(drawableLeft != null ? drawableLeft : existingAbs[0], drawableTop != null ? drawableTop : existingAbs[1], drawableRight != null ? drawableRight : existingAbs[2], drawableBottom != null ? drawableBottom : existingAbs[3]);
        }
    }

    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            va.f(editorInfo, textView.getText());
        }
    }
}
