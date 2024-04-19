package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
/* compiled from: WrappedDrawableState.java */
/* renamed from: n8  reason: default package */
/* loaded from: classes.dex */
public final class n8 extends Drawable.ConstantState {
    public int a;
    public Drawable.ConstantState b;
    public ColorStateList c;
    public PorterDuff.Mode d;

    public n8(n8 orig) {
        this.c = null;
        this.d = l8.a;
        if (orig != null) {
            this.a = orig.a;
            this.b = orig.b;
            this.c = orig.c;
            this.d = orig.d;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources res) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new m8(this, res);
        }
        return new l8(this, res);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.a;
        Drawable.ConstantState constantState = this.b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public boolean a() {
        return this.b != null;
    }
}
