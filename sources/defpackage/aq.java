package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: XSliderTickMarkDrawableBase.java */
/* renamed from: aq  reason: default package */
/* loaded from: classes.dex */
public abstract class aq extends Drawable {
    public final Paint a;
    public final Paint b;
    public float d;
    public float e;
    public ColorStateList f;
    public final int c = 4;
    public boolean g = false;
    public boolean h = false;
    public boolean i = true;

    public aq() {
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(4.0f);
        Paint paint2 = new Paint(1);
        this.b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeWidth(4.0f);
        setLevel(100);
    }

    public void a(ColorStateList color) {
        this.f = color;
        if (color != null) {
            this.a.setColor(color.getDefaultColor());
            this.b.setColor(this.f.getDefaultColor());
            return;
        }
        this.a.setColor(687800320);
        this.b.setColor(687800320);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws IOException, XmlPullParserException {
        super.inflate(r, parser, attrs, theme);
        b(r, attrs, theme, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws IOException, XmlPullParserException {
        super.inflate(r, parser, attrs);
        b(r, attrs, null, 0);
    }

    public void b(Resources resources, AttributeSet attrs, Resources.Theme theme, int defStyleRes) {
        TypedArray ta;
        if (theme != null) {
            ta = theme.obtainStyledAttributes(attrs, bp.t0, 0, defStyleRes);
        } else {
            ta = resources.obtainAttributes(attrs, bp.t0);
        }
        ColorStateList colorStateList = ta.getColorStateList(bp.u0);
        a(colorStateList);
        ta.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] state) {
        ColorStateList colorStateList;
        boolean activated = false;
        boolean selected = false;
        boolean enabled = false;
        boolean changed = false;
        for (int s : state) {
            if (s == 16843518) {
                activated = true;
            } else if (s == 16842913) {
                selected = true;
            } else if (s == 16842910) {
                enabled = true;
            }
        }
        boolean enabledChanged = enabled != this.i;
        if (enabledChanged) {
            this.i = enabled;
        }
        boolean activatedChanged = activated != this.g;
        if (activatedChanged) {
            this.g = activated;
            this.a.setStrokeWidth(activated ? 2.0f : 4.0f);
            this.b.setMaskFilter(this.g ? new BlurMaskFilter(4.0f, BlurMaskFilter.Blur.NORMAL) : null);
        }
        boolean selectedChanged = selected != this.h;
        if (selectedChanged) {
            this.h = selected;
            if (!selected) {
                setLevel(100);
            }
        }
        changed = (activatedChanged || selectedChanged || enabledChanged) ? true : true;
        if (changed && (colorStateList = this.f) != null) {
            int color = colorStateList.getColorForState(state, colorStateList.getDefaultColor());
            this.a.setColor(color);
            this.b.setColor(color);
        }
        return changed;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.d = bounds.width() / 2.0f;
        this.e = bounds.height() / 2.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }
}
