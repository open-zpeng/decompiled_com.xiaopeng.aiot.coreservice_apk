package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: XLoadingDrawable.java */
/* renamed from: wp  reason: default package */
/* loaded from: classes.dex */
public class wp extends Drawable {
    public static final double a = Math.toRadians(25.0d);
    public final MaskFilter b;
    public final Paint c;
    public int e;
    public float f;
    public int g;
    public float h;
    public float[] i;
    public float j;
    public float k;
    public float[] l;
    public float[] m;
    public float n;
    public int[] o;
    public ValueAnimator[] p;
    public boolean q;
    public float s;
    public float t;
    public int d = uo.x_theme_text_01;
    public final Interpolator r = new AccelerateDecelerateInterpolator();
    public long u = 1000;
    public boolean v = false;

    public wp() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        this.b = new BlurMaskFilter(2.0f, BlurMaskFilter.Blur.SOLID);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws IOException, XmlPullParserException {
        super.inflate(r, parser, attrs, theme);
        TypedArray ta = r.obtainAttributes(attrs, bp.V1);
        int resourceId = ta.getResourceId(bp.W1, uo.x_theme_text_01);
        this.d = resourceId;
        this.e = r.getColor(resourceId, theme);
        k(ta.getInt(bp.X1, 3));
        ta.recycle();
        h(r);
    }

    public void k(int type) {
        a();
        switch (type) {
            case 0:
                this.g = 3;
                this.h = 4.0f;
                this.n = 5.0f;
                this.j = 16.0f;
                this.k = 4.0f;
                break;
            case 1:
                this.g = 5;
                this.h = 4.0f;
                this.n = 5.0f;
                this.j = 22.0f;
                this.k = 8.0f;
                break;
            case 2:
                this.g = 5;
                this.h = 6.0f;
                this.n = 8.0f;
                this.j = 34.0f;
                this.k = 12.0f;
                break;
            default:
                this.g = 7;
                this.h = 6.0f;
                this.n = 19.0f;
                this.j = 50.0f;
                this.k = 10.0f;
                break;
        }
        this.f = 0.5f / (this.g - 1);
        invalidateSelf();
    }

    public void i(boolean isDebug) {
        this.v = isDebug;
    }

    public void j(long duration) {
        a();
        this.u = duration;
        invalidateSelf();
    }

    public float b() {
        return this.f;
    }

    public final void l() {
        f();
        for (int i = 0; i < this.g; i++) {
            this.p[i].setCurrentFraction(1.0f - (this.f * (i + 1)));
            this.p[i].start();
        }
        this.q = true;
    }

    public final void f() {
        final int count = this.g;
        this.p = new ValueAnimator[count];
        this.i = new float[count];
        this.m = new float[count];
        this.o = new int[count];
        for (int i = 0; i < count; i++) {
            final int index = i;
            this.p[index] = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f);
            this.p[index].setRepeatCount(-1);
            this.p[index].setRepeatMode(2);
            this.p[index].setDuration(this.u);
            this.p[index].setInterpolator(this.r);
            this.p[index].addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: up
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    wp.this.e(index, count, valueAnimator);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(int index, int count, ValueAnimator animation) {
        float value = ((Float) animation.getAnimatedValue()).floatValue();
        this.o[index] = ((int) (163.0f * value)) + 92;
        float[] fArr = this.i;
        float f = this.k;
        fArr[index] = f + ((this.j - f) * value);
        this.m[index] = (this.t - (fArr[index] * 0.5f)) + ((((count - 1) * 0.5f) - index) * ((float) Math.tan(a)) * (this.n + this.h));
        if (index == count - 1) {
            invalidateSelf();
        }
    }

    public void a() {
        ValueAnimator[] valueAnimatorArr = this.p;
        if (valueAnimatorArr != null) {
            for (ValueAnimator anim : valueAnimatorArr) {
                anim.removeAllUpdateListeners();
                anim.cancel();
            }
        }
        this.q = false;
        this.p = null;
        this.s = 0.0f;
    }

    public void g(Context context, Configuration newConfig) {
        this.e = context.getResources().getColor(this.d, context.getTheme());
        h(context.getResources());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        if (!visible) {
            a();
        }
        return super.setVisible(visible, restart);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        c();
        if (!this.q && isVisible()) {
            l();
            return;
        }
        if (this.v) {
            this.c.setColor(-65536);
            canvas.drawLine(0.0f, this.t, getIntrinsicWidth(), this.t, this.c);
            float f = this.s;
            canvas.drawLine(f, 0.0f, f, getIntrinsicHeight(), this.c);
        }
        canvas.rotate(25.0f, this.s, this.t);
        for (int i = 0; i < this.g; i++) {
            this.c.setColor(this.e);
            this.c.setAlpha(this.o[i]);
            float[] fArr = this.l;
            float f2 = fArr[i];
            float[] fArr2 = this.m;
            canvas.drawRoundRect(f2, fArr2[i], this.h + fArr[i], fArr2[i] + this.i[i], 1.0f, 1.0f, this.c);
        }
    }

    public final void h(Resources resources) {
        if (this.c == null || this.b == null) {
            return;
        }
        if (mq.b(resources.getConfiguration())) {
            this.c.setMaskFilter(this.b);
        } else {
            this.c.setMaskFilter(null);
        }
    }

    public final void c() {
        if (this.g == 0) {
            rq.d("xpui-XLoadingDrawable", "You must setType or config loading_type first");
        }
        if (this.s == 0.0f) {
            this.s = getIntrinsicWidth() * 0.5f;
            this.t = getIntrinsicHeight() * 0.5f;
            int i = this.g;
            this.l = new float[i];
            float firstLineX = this.s - (((i * this.h) * 0.5f) + ((i >> 1) * this.n));
            for (int i2 = 0; i2 < this.g; i2++) {
                this.l[i2] = (i2 * (this.n + this.h)) + firstLineX;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.c.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return getBounds().right - getBounds().left;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return getBounds().bottom - getBounds().top;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }
}
