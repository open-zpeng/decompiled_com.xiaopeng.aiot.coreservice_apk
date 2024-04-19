package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import com.xiaopeng.base.log.LogUtils;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: PathInterpolatorCompat.java */
/* renamed from: gf  reason: default package */
/* loaded from: classes.dex */
public class gf implements Interpolator {
    public float[] a;
    public float[] b;

    public gf(Context context, AttributeSet attrs, XmlPullParser parser) {
        this(context.getResources(), context.getTheme(), attrs, parser);
    }

    public gf(Resources res, Resources.Theme theme, AttributeSet attrs, XmlPullParser parser) {
        TypedArray a = w7.k(res, theme, attrs, bf.l);
        d(a, parser);
        a.recycle();
    }

    public final void d(TypedArray a, XmlPullParser parser) {
        if (w7.j(parser, "pathData")) {
            String pathData = w7.i(a, parser, "pathData", 4);
            Path path = z7.e(pathData);
            if (path == null) {
                throw new InflateException("The path is null, which is created from " + pathData);
            }
            b(path);
        } else if (!w7.j(parser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else {
            if (w7.j(parser, "controlY1")) {
                float x1 = w7.f(a, parser, "controlX1", 0, 0.0f);
                float y1 = w7.f(a, parser, "controlY1", 1, 0.0f);
                boolean hasX2 = w7.j(parser, "controlX2");
                boolean hasY2 = w7.j(parser, "controlY2");
                if (hasX2 != hasY2) {
                    throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
                }
                if (hasX2) {
                    float x2 = w7.f(a, parser, "controlX2", 2, 0.0f);
                    float y2 = w7.f(a, parser, "controlY2", 3, 0.0f);
                    a(x1, y1, x2, y2);
                    return;
                }
                c(x1, y1);
                return;
            }
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
    }

    public final void c(float controlX, float controlY) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(controlX, controlY, 1.0f, 1.0f);
        b(path);
    }

    public final void a(float x1, float y1, float x2, float y2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(x1, y1, x2, y2, 1.0f, 1.0f);
        b(path);
    }

    public final void b(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float pathLength = pathMeasure.getLength();
        int numPoints = Math.min(3000, ((int) (pathLength / 0.002f)) + 1);
        if (numPoints <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + pathLength);
        }
        this.a = new float[numPoints];
        this.b = new float[numPoints];
        float[] position = new float[2];
        for (int i = 0; i < numPoints; i++) {
            float distance = (i * pathLength) / (numPoints - 1);
            pathMeasure.getPosTan(distance, position, null);
            this.a[i] = position[0];
            this.b[i] = position[1];
        }
        if (Math.abs(this.a[0]) > 1.0E-5d || Math.abs(this.b[0]) > 1.0E-5d || Math.abs(this.a[numPoints - 1] - 1.0f) > 1.0E-5d || Math.abs(this.b[numPoints - 1] - 1.0f) > 1.0E-5d) {
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.a[0] + LogUtils.SEPARATOR + this.b[0] + " end:" + this.a[numPoints - 1] + LogUtils.SEPARATOR + this.b[numPoints - 1]);
        }
        float prevX = 0.0f;
        int componentIndex = 0;
        int i2 = 0;
        while (i2 < numPoints) {
            float[] fArr = this.a;
            int componentIndex2 = componentIndex + 1;
            float x = fArr[componentIndex];
            if (x < prevX) {
                throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + x);
            }
            fArr[i2] = x;
            prevX = x;
            i2++;
            componentIndex = componentIndex2;
        }
        if (pathMeasure.nextContour()) {
            throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float t) {
        if (t <= 0.0f) {
            return 0.0f;
        }
        if (t >= 1.0f) {
            return 1.0f;
        }
        int startIndex = 0;
        int endIndex = this.a.length - 1;
        while (endIndex - startIndex > 1) {
            int midIndex = (startIndex + endIndex) / 2;
            if (t < this.a[midIndex]) {
                endIndex = midIndex;
            } else {
                startIndex = midIndex;
            }
        }
        float[] fArr = this.a;
        float xRange = fArr[endIndex] - fArr[startIndex];
        if (xRange == 0.0f) {
            return this.b[startIndex];
        }
        float tInRange = t - fArr[startIndex];
        float fraction = tInRange / xRange;
        float[] fArr2 = this.b;
        float startY = fArr2[startIndex];
        float endY = fArr2[endIndex];
        return ((endY - startY) * fraction) + startY;
    }
}
