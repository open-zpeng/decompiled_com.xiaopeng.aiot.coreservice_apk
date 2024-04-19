package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
/* compiled from: WrappedDrawableApi21.java */
/* renamed from: m8  reason: default package */
/* loaded from: classes.dex */
public class m8 extends l8 {
    public static Method j;

    public m8(Drawable drawable) {
        super(drawable);
        g();
    }

    public m8(n8 state, Resources resources) {
        super(state, resources);
        g();
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float x, float y) {
        this.i.setHotspot(x, y);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int left, int top, int right, int bottom) {
        this.i.setHotspotBounds(left, top, right, bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.i.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.i.getDirtyBounds();
    }

    @Override // defpackage.l8, android.graphics.drawable.Drawable, defpackage.j8
    public void setTintList(ColorStateList tint) {
        if (c()) {
            super.setTintList(tint);
        } else {
            this.i.setTintList(tint);
        }
    }

    @Override // defpackage.l8, android.graphics.drawable.Drawable, defpackage.j8
    public void setTint(int tintColor) {
        if (c()) {
            super.setTint(tintColor);
        } else {
            this.i.setTint(tintColor);
        }
    }

    @Override // defpackage.l8, android.graphics.drawable.Drawable, defpackage.j8
    public void setTintMode(PorterDuff.Mode tintMode) {
        if (c()) {
            super.setTintMode(tintMode);
        } else {
            this.i.setTintMode(tintMode);
        }
    }

    @Override // defpackage.l8, android.graphics.drawable.Drawable
    public boolean setState(int[] stateSet) {
        if (super.setState(stateSet)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // defpackage.l8
    public boolean c() {
        if (Build.VERSION.SDK_INT == 21) {
            Drawable drawable = this.i;
            return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.i;
        if (drawable != null && (method = j) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception ex) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", ex);
            }
        }
        return false;
    }

    public final void g() {
        if (j == null) {
            try {
                j = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception ex) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", ex);
            }
        }
    }
}
