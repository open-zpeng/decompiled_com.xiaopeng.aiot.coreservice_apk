package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
/* compiled from: WrappedDrawableApi14.java */
/* renamed from: l8  reason: default package */
/* loaded from: classes.dex */
public class l8 extends Drawable implements Drawable.Callback, k8, j8 {
    public static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    public int b;
    public PorterDuff.Mode d;
    public boolean f;
    public n8 g;
    public boolean h;
    public Drawable i;

    public l8(n8 state, Resources res) {
        this.g = state;
        e(res);
    }

    public l8(Drawable dr) {
        this.g = d();
        a(dr);
    }

    public final void e(Resources res) {
        Drawable.ConstantState constantState;
        n8 n8Var = this.g;
        if (n8Var != null && (constantState = n8Var.b) != null) {
            a(constantState.newDrawable(res));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.i.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.i.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int configs) {
        this.i.setChangingConfigurations(configs);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        n8 n8Var = this.g;
        return changingConfigurations | (n8Var != null ? n8Var.getChangingConfigurations() : 0) | this.i.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean dither) {
        this.i.setDither(dither);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean filter) {
        this.i.setFilterBitmap(filter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.i.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        this.i.setColorFilter(cf);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList tintList;
        n8 n8Var;
        if (c() && (n8Var = this.g) != null) {
            tintList = n8Var.c;
        } else {
            tintList = null;
        }
        return (tintList != null && tintList.isStateful()) || this.i.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] stateSet) {
        boolean handled = this.i.setState(stateSet);
        boolean handled2 = f(stateSet) || handled;
        return handled2;
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.i.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.i.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        return super.setVisible(visible, restart) || this.i.setVisible(visible, restart);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.i.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.i.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.i.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.i.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.i.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.i.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        return this.i.getPadding(padding);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean mirrored) {
        i8.i(this.i, mirrored);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return i8.g(this.i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int layoutDirection) {
        return i8.l(this.i, layoutDirection);
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return i8.e(this.i);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        n8 n8Var = this.g;
        if (n8Var != null && n8Var.a()) {
            this.g.a = getChangingConfigurations();
            return this.g;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.h && super.mutate() == this) {
            this.g = d();
            Drawable drawable = this.i;
            if (drawable != null) {
                drawable.mutate();
            }
            n8 n8Var = this.g;
            if (n8Var != null) {
                Drawable drawable2 = this.i;
                n8Var.b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.h = true;
        }
        return this;
    }

    public final n8 d() {
        return new n8(this.g);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        scheduleSelf(what, when);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable who, Runnable what) {
        unscheduleSelf(what);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int level) {
        return this.i.setLevel(level);
    }

    @Override // android.graphics.drawable.Drawable, defpackage.j8
    public void setTint(int tint) {
        setTintList(ColorStateList.valueOf(tint));
    }

    @Override // android.graphics.drawable.Drawable, defpackage.j8
    public void setTintList(ColorStateList tint) {
        this.g.c = tint;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, defpackage.j8
    public void setTintMode(PorterDuff.Mode tintMode) {
        this.g.d = tintMode;
        f(getState());
    }

    public final boolean f(int[] state) {
        if (c()) {
            n8 n8Var = this.g;
            ColorStateList tintList = n8Var.c;
            PorterDuff.Mode tintMode = n8Var.d;
            if (tintList != null && tintMode != null) {
                int color = tintList.getColorForState(state, tintList.getDefaultColor());
                if (!this.f || color != this.b || tintMode != this.d) {
                    setColorFilter(color, tintMode);
                    this.b = color;
                    this.d = tintMode;
                    this.f = true;
                    return true;
                }
            } else {
                this.f = false;
                clearColorFilter();
            }
            return false;
        }
        return false;
    }

    @Override // defpackage.k8
    public final Drawable b() {
        return this.i;
    }

    @Override // defpackage.k8
    public final void a(Drawable dr) {
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.i = dr;
        if (dr != null) {
            dr.setCallback(this);
            setVisible(dr.isVisible(), true);
            setState(dr.getState());
            setLevel(dr.getLevel());
            setBounds(dr.getBounds());
            n8 n8Var = this.g;
            if (n8Var != null) {
                n8Var.b = dr.getConstantState();
            }
        }
        invalidateSelf();
    }

    public boolean c() {
        return true;
    }
}
