package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: XCircularProgressPgDrawable.java */
/* renamed from: zp  reason: default package */
/* loaded from: classes.dex */
public class zp extends Drawable {
    public Paint a = new Paint();
    public Rect b = getBounds();
    public RectF c = new RectF(getBounds());
    public int d;
    public float e;
    public boolean f;
    public float g;
    public float h;

    public zp() {
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setAntiAlias(true);
        this.a.setDither(true);
        this.a.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws IOException, XmlPullParserException {
        super.inflate(r, parser, attrs);
        d(r, attrs, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws IOException, XmlPullParserException {
        super.inflate(r, parser, attrs, theme);
        d(r, attrs, theme);
    }

    public final void d(Resources resources, AttributeSet attrs, Resources.Theme theme) {
        TypedArray ta;
        if (theme != null) {
            ta = theme.obtainStyledAttributes(attrs, bp.n1, 0, 0);
        } else {
            ta = resources.obtainAttributes(attrs, bp.n1);
        }
        this.d = ta.getColor(bp.o1, resources.getColor(uo.x_circular_progress_primary_color, theme));
        this.e = ta.getDimension(bp.s1, 0.0f);
        this.f = ta.getBoolean(bp.p1, false);
        this.g = ta.getDimensionPixelSize(bp.q1, 0);
        this.h = ta.getDimensionPixelOffset(bp.r1, 0);
        ta.recycle();
    }

    public void c(float strokeWidth) {
        this.e = strokeWidth;
    }

    public void a(float inset) {
        this.g = inset;
    }

    public void b(float lightRadius) {
        this.h = lightRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.c.set(bounds);
        if (this.e == 0.0f) {
            this.e = (this.b.width() * 1.0f) / 10.0f;
        }
        float borderInset = this.e / 2.0f;
        RectF rectF = this.c;
        float f = this.g;
        rectF.inset(f + borderInset, f + borderInset);
        this.a.setColor(this.d);
        this.a.setStrokeWidth(this.e);
        if (this.f) {
            if (this.h == 0.0f) {
                this.h = this.e;
            }
            cq XLightPaint = new cq(this.a);
            XLightPaint.b(this.h);
            XLightPaint.a();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        float sweepAngle = ((getLevel() * 1.0f) / 10000.0f) * 360.0f;
        canvas.drawArc(this.c, -90.0f, sweepAngle, false, this.a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int level) {
        invalidateSelf();
        return super.onLevelChange(level);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.a.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }
}
