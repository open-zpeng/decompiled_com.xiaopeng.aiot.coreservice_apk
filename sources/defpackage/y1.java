package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import defpackage.q2;
/* compiled from: AppCompatDrawableManager.java */
/* renamed from: y1  reason: default package */
/* loaded from: classes.dex */
public final class y1 {
    public static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    public static y1 b;
    public q2 c;

    public static synchronized void h() {
        synchronized (y1.class) {
            if (b == null) {
                y1 y1Var = new y1();
                b = y1Var;
                y1Var.c = q2.h();
                b.c.u(new a());
            }
        }
    }

    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: y1$a */
    /* loaded from: classes.dex */
    public class a implements q2.f {
        public final int[] a = {r.R, r.P, r.a};
        public final int[] b = {r.o, r.abc_seekbar_tick_mark_material, r.t, r.p, r.q, r.s, r.r};
        public final int[] c = {r.O, r.Q, r.k, r.K, r.abc_text_select_handle_left_mtrl, r.abc_text_select_handle_middle_mtrl, r.abc_text_select_handle_right_mtrl};
        public final int[] d = {r.w, r.i, r.v};
        public final int[] e = {r.J, r.S};
        public final int[] f = {r.c, r.g, r.abc_btn_check_material_anim, r.abc_btn_radio_material_anim};

        public final ColorStateList j(Context context) {
            return h(context, u2.c(context, n.t));
        }

        public final ColorStateList g(Context context) {
            return h(context, 0);
        }

        public final ColorStateList i(Context context) {
            return h(context, u2.c(context, n.s));
        }

        public final ColorStateList h(Context context, int baseColor) {
            int[][] states = new int[4];
            int[] colors = new int[4];
            int colorControlHighlight = u2.c(context, n.v);
            int disabledColor = u2.b(context, n.t);
            states[0] = u2.b;
            colors[0] = disabledColor;
            int i = 0 + 1;
            states[i] = u2.e;
            colors[i] = x7.b(colorControlHighlight, baseColor);
            int i2 = i + 1;
            states[i2] = u2.c;
            colors[i2] = x7.b(colorControlHighlight, baseColor);
            int i3 = i2 + 1;
            states[i3] = u2.i;
            colors[i3] = baseColor;
            int i4 = i3 + 1;
            return new ColorStateList(states, colors);
        }

        public final ColorStateList k(Context context) {
            int[][] states = new int[3];
            int[] colors = new int[3];
            int i = n.x;
            ColorStateList thumbColor = u2.e(context, i);
            if (thumbColor == null || !thumbColor.isStateful()) {
                states[0] = u2.b;
                colors[0] = u2.b(context, i);
                int i2 = 0 + 1;
                states[i2] = u2.f;
                colors[i2] = u2.c(context, n.u);
                int i3 = i2 + 1;
                states[i3] = u2.i;
                colors[i3] = u2.c(context, i);
                int i4 = i3 + 1;
            } else {
                states[0] = u2.b;
                colors[0] = thumbColor.getColorForState(states[0], 0);
                int i5 = 0 + 1;
                states[i5] = u2.f;
                colors[i5] = u2.c(context, n.u);
                int i6 = i5 + 1;
                states[i6] = u2.i;
                colors[i6] = thumbColor.getDefaultColor();
                int i7 = i6 + 1;
            }
            return new ColorStateList(states, colors);
        }

        @Override // defpackage.q2.f
        public Drawable c(q2 resourceManager, Context context, int resId) {
            if (resId == r.j) {
                return new LayerDrawable(new Drawable[]{resourceManager.j(context, r.i), resourceManager.j(context, r.k)});
            }
            if (resId == r.abc_ratingbar_material) {
                return l(resourceManager, context, q.abc_star_big);
            }
            if (resId == r.abc_ratingbar_indicator_material) {
                return l(resourceManager, context, q.abc_star_medium);
            }
            if (resId == r.abc_ratingbar_small_material) {
                return l(resourceManager, context, q.abc_star_small);
            }
            return null;
        }

        public final LayerDrawable l(q2 resourceManager, Context context, int dimenResId) {
            BitmapDrawable starBitmapDrawable;
            BitmapDrawable tiledStarBitmapDrawable;
            BitmapDrawable halfStarBitmapDrawable;
            int starSize = context.getResources().getDimensionPixelSize(dimenResId);
            Drawable star = resourceManager.j(context, r.abc_star_black_48dp);
            Drawable halfStar = resourceManager.j(context, r.abc_star_half_black_48dp);
            if ((star instanceof BitmapDrawable) && star.getIntrinsicWidth() == starSize && star.getIntrinsicHeight() == starSize) {
                starBitmapDrawable = (BitmapDrawable) star;
                tiledStarBitmapDrawable = new BitmapDrawable(starBitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapStar = Bitmap.createBitmap(starSize, starSize, Bitmap.Config.ARGB_8888);
                Canvas canvasStar = new Canvas(bitmapStar);
                star.setBounds(0, 0, starSize, starSize);
                star.draw(canvasStar);
                BitmapDrawable starBitmapDrawable2 = new BitmapDrawable(bitmapStar);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapStar);
                starBitmapDrawable = starBitmapDrawable2;
                tiledStarBitmapDrawable = bitmapDrawable;
            }
            tiledStarBitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            if ((halfStar instanceof BitmapDrawable) && halfStar.getIntrinsicWidth() == starSize && halfStar.getIntrinsicHeight() == starSize) {
                halfStarBitmapDrawable = (BitmapDrawable) halfStar;
            } else {
                Bitmap bitmapHalfStar = Bitmap.createBitmap(starSize, starSize, Bitmap.Config.ARGB_8888);
                Canvas canvasHalfStar = new Canvas(bitmapHalfStar);
                halfStar.setBounds(0, 0, starSize, starSize);
                halfStar.draw(canvasHalfStar);
                halfStarBitmapDrawable = new BitmapDrawable(bitmapHalfStar);
            }
            LayerDrawable result = new LayerDrawable(new Drawable[]{starBitmapDrawable, halfStarBitmapDrawable, tiledStarBitmapDrawable});
            result.setId(0, 16908288);
            result.setId(1, 16908303);
            result.setId(2, 16908301);
            return result;
        }

        public final void m(Drawable d, int color, PorterDuff.Mode mode) {
            PorterDuff.Mode mode2;
            if (k2.a(d)) {
                d = d.mutate();
            }
            if (mode == null) {
                mode2 = y1.a;
            } else {
                mode2 = mode;
            }
            d.setColorFilter(y1.e(color, mode2));
        }

        @Override // defpackage.q2.f
        public boolean e(Context context, int resId, Drawable drawable) {
            if (resId == r.C) {
                LayerDrawable ld = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = ld.findDrawableByLayerId(16908288);
                int i = n.w;
                m(findDrawableByLayerId, u2.c(context, i), y1.a);
                m(ld.findDrawableByLayerId(16908303), u2.c(context, i), y1.a);
                m(ld.findDrawableByLayerId(16908301), u2.c(context, n.u), y1.a);
                return true;
            } else if (resId == r.abc_ratingbar_material || resId == r.abc_ratingbar_indicator_material || resId == r.abc_ratingbar_small_material) {
                LayerDrawable ld2 = (LayerDrawable) drawable;
                m(ld2.findDrawableByLayerId(16908288), u2.b(context, n.w), y1.a);
                Drawable findDrawableByLayerId2 = ld2.findDrawableByLayerId(16908303);
                int i2 = n.u;
                m(findDrawableByLayerId2, u2.c(context, i2), y1.a);
                m(ld2.findDrawableByLayerId(16908301), u2.c(context, i2), y1.a);
                return true;
            } else {
                return false;
            }
        }

        public final boolean f(int[] array, int value) {
            for (int id : array) {
                if (id == value) {
                    return true;
                }
            }
            return false;
        }

        @Override // defpackage.q2.f
        public ColorStateList d(Context context, int resId) {
            if (resId == r.m) {
                return j0.c(context, p.abc_tint_edittext);
            }
            if (resId == r.I) {
                return j0.c(context, p.abc_tint_switch_track);
            }
            if (resId == r.H) {
                return k(context);
            }
            if (resId == r.f) {
                return j(context);
            }
            if (resId == r.b) {
                return g(context);
            }
            if (resId == r.e) {
                return i(context);
            }
            if (resId == r.D || resId == r.E) {
                return j0.c(context, p.abc_tint_spinner);
            }
            if (f(this.b, resId)) {
                return u2.e(context, n.w);
            }
            if (f(this.e, resId)) {
                return j0.c(context, p.abc_tint_default);
            }
            if (f(this.f, resId)) {
                return j0.c(context, p.abc_tint_btn_checkable);
            }
            if (resId == r.A) {
                return j0.c(context, p.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // defpackage.q2.f
        public boolean a(Context context, int resId, Drawable drawable) {
            PorterDuff.Mode tintMode = y1.a;
            boolean colorAttrSet = false;
            int colorAttr = 0;
            int alpha = -1;
            if (f(this.a, resId)) {
                colorAttr = n.w;
                colorAttrSet = true;
            } else if (f(this.c, resId)) {
                colorAttr = n.u;
                colorAttrSet = true;
            } else if (f(this.d, resId)) {
                colorAttr = 16842801;
                colorAttrSet = true;
                tintMode = PorterDuff.Mode.MULTIPLY;
            } else if (resId == r.u) {
                colorAttr = 16842800;
                colorAttrSet = true;
                alpha = Math.round(40.8f);
            } else if (resId == r.abc_dialog_material_background) {
                colorAttr = 16842801;
                colorAttrSet = true;
            }
            if (colorAttrSet) {
                if (k2.a(drawable)) {
                    drawable = drawable.mutate();
                }
                int color = u2.c(context, colorAttr);
                drawable.setColorFilter(y1.e(color, tintMode));
                if (alpha != -1) {
                    drawable.setAlpha(alpha);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // defpackage.q2.f
        public PorterDuff.Mode b(int resId) {
            if (resId != r.H) {
                return null;
            }
            PorterDuff.Mode mode = PorterDuff.Mode.MULTIPLY;
            return mode;
        }
    }

    public static synchronized y1 b() {
        y1 y1Var;
        synchronized (y1.class) {
            if (b == null) {
                h();
            }
            y1Var = b;
        }
        return y1Var;
    }

    public synchronized Drawable c(Context context, int resId) {
        return this.c.j(context, resId);
    }

    public synchronized Drawable d(Context context, int resId, boolean failIfNotKnown) {
        return this.c.k(context, resId, failIfNotKnown);
    }

    public synchronized void g(Context context) {
        this.c.s(context);
    }

    public synchronized ColorStateList f(Context context, int resId) {
        return this.c.m(context, resId);
    }

    public static void i(Drawable drawable, x2 tint, int[] state) {
        q2.w(drawable, tint, state);
    }

    public static synchronized PorterDuffColorFilter e(int color, PorterDuff.Mode mode) {
        PorterDuffColorFilter l;
        synchronized (y1.class) {
            l = q2.l(color, mode);
        }
        return l;
    }
}
