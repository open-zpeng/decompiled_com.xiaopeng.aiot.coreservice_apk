package defpackage;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
/* compiled from: VectorDrawableCommon.java */
/* renamed from: hf  reason: default package */
/* loaded from: classes.dex */
public abstract class hf extends Drawable implements j8 {
    public Drawable a;

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int color, PorterDuff.Mode mode) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(color, mode);
        } else {
            super.setColorFilter(color, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int level) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setLevel(level);
        }
        return super.onLevelChange(level);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float x, float y) {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.j(drawable, x, y);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int left, int top, int right, int bottom) {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.k(drawable, left, top, right, bottom);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean filter) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setFilterBitmap(filter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.h(drawable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme t) {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.a(drawable, t);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getCurrent();
        }
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getPadding(padding);
        }
        return super.getPadding(padding);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getState();
        }
        return super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int configs) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setChangingConfigurations(configs);
        } else {
            super.setChangingConfigurations(configs);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] stateSet) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setState(stateSet);
        }
        return super.setState(stateSet);
    }
}
