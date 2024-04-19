package defpackage;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
/* compiled from: XLightPaint.java */
/* renamed from: cq  reason: default package */
/* loaded from: classes.dex */
public class cq {
    public static float a = 200.0f;
    public LightingColorFilter b;
    public BlurMaskFilter c;
    public Paint d;
    public int e = -1;
    public int f = 255;
    public int g = 0;
    public float h = 1.0f;
    public int i = 0;

    public cq(Paint paint) {
        this.d = paint;
    }

    public void b(float maxLightRadius) {
        a = maxLightRadius;
    }

    public void a() {
        float f = a;
        float f2 = this.h;
        float radius = f * f2;
        int i = this.g;
        if (i > 0) {
            int color = (int) (f2 * i);
            LightingColorFilter lightingColorFilter = new LightingColorFilter(-1, Color.argb(this.f, color, color, color));
            this.b = lightingColorFilter;
            this.d.setColorFilter(lightingColorFilter);
        }
        int color2 = this.i;
        if (color2 == 0) {
            if (radius > 0.0f) {
                BlurMaskFilter blurMaskFilter = new BlurMaskFilter(radius, BlurMaskFilter.Blur.SOLID);
                this.c = blurMaskFilter;
                this.d.setMaskFilter(blurMaskFilter);
                return;
            }
            this.d.setMaskFilter(null);
        } else if (color2 == 1) {
            int i2 = this.e;
            if (i2 == -1) {
                throw new IllegalArgumentException("Please set light color.");
            }
            this.d.setShadowLayer(radius, 0.0f, 0.0f, i2);
        }
    }
}
