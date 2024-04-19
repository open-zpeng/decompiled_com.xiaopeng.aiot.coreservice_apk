package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: XCircularProgressIndeterminateDrawable.java */
/* renamed from: yp  reason: default package */
/* loaded from: classes.dex */
public class yp extends Drawable {
    public Paint a = new Paint();
    public Rect b = getBounds();
    public RectF c = new RectF(getBounds());
    public int d;
    public int e;
    public float f;
    public boolean g;
    public float h;
    public float i;

    public yp() {
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
            ta = theme.obtainStyledAttributes(attrs, bp.g1, 0, 0);
        } else {
            ta = resources.obtainAttributes(attrs, bp.g1);
        }
        this.d = ta.getColor(bp.l1, resources.getColor(17170445, theme));
        this.e = ta.getColor(bp.i1, resources.getColor(uo.x_circular_progress_primary_color, theme));
        this.f = ta.getDimension(bp.m1, 0.0f);
        this.g = ta.getBoolean(bp.h1, false);
        this.h = ta.getDimensionPixelSize(bp.j1, 0);
        this.i = ta.getDimensionPixelOffset(bp.k1, 0);
        ta.recycle();
    }

    public void c(float strokeWidth) {
        this.f = strokeWidth;
    }

    public void a(float inset) {
        this.h = inset;
    }

    public void b(float lightRadius) {
        this.i = lightRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        int[] progressColor = {this.d, this.e};
        SweepGradient sweepGradient = new SweepGradient(this.b.centerX(), this.b.centerY(), progressColor, (float[]) null);
        this.a.setShader(sweepGradient);
        if (this.f == 0.0f) {
            int width = this.b.width();
            this.f = width / 10.0f;
        }
        this.a.setStrokeWidth(this.f);
        float borderInset = this.f / 2.0f;
        this.c.set(bounds);
        RectF rectF = this.c;
        float f = this.h;
        rectF.inset(f + borderInset, f + borderInset);
        if (this.g) {
            if (this.i == 0.0f) {
                this.i = this.f;
            }
            cq XLightPaint = new cq(this.a);
            XLightPaint.b(this.i);
            XLightPaint.a();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.drawArc(this.c, 8.0f, 340.0f, false, this.a);
        canvas.restore();
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
