package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: GradientColorInflaterCompat.java */
/* renamed from: t7  reason: default package */
/* loaded from: classes.dex */
public final class t7 {
    public static Shader b(Resources resources, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = parser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(parser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray a2 = w7.k(resources, theme, attrs, y6.x);
        float startX = w7.f(a2, parser, "startX", y6.G, 0.0f);
        float startY = w7.f(a2, parser, "startY", y6.H, 0.0f);
        float endX = w7.f(a2, parser, "endX", y6.I, 0.0f);
        float endY = w7.f(a2, parser, "endY", y6.J, 0.0f);
        float centerX = w7.f(a2, parser, "centerX", y6.B, 0.0f);
        float centerY = w7.f(a2, parser, "centerY", y6.C, 0.0f);
        int type = w7.g(a2, parser, "type", y6.A, 0);
        int startColor = w7.b(a2, parser, "startColor", y6.y, 0);
        boolean hasCenterColor = w7.j(parser, "centerColor");
        int centerColor = w7.b(a2, parser, "centerColor", y6.F, 0);
        int endColor = w7.b(a2, parser, "endColor", y6.z, 0);
        int tileMode = w7.g(a2, parser, "tileMode", y6.E, 0);
        float gradientRadius = w7.f(a2, parser, "gradientRadius", y6.D, 0.0f);
        a2.recycle();
        a colorStops = a(c(resources, parser, attrs, theme), startColor, endColor, hasCenterColor, centerColor);
        switch (type) {
            case 1:
                if (gradientRadius <= 0.0f) {
                    throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                }
                return new RadialGradient(centerX, centerY, gradientRadius, colorStops.a, colorStops.b, d(tileMode));
            case 2:
                return new SweepGradient(centerX, centerY, colorStops.a, colorStops.b);
            default:
                return new LinearGradient(startX, startY, endX, endY, colorStops.a, colorStops.b, d(tileMode));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0083, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r13.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.t7.a c(android.content.res.Resources r12, org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.content.res.Resources.Theme r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r13.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
            r3 = r4
        L13:
            int r4 = r13.next()
            r5 = r4
            if (r4 == r1) goto L84
            int r4 = r13.getDepth()
            r6 = r4
            if (r4 >= r0) goto L24
            r4 = 3
            if (r5 == r4) goto L84
        L24:
            r4 = 2
            if (r5 == r4) goto L28
            goto L13
        L28:
            if (r6 > r0) goto L13
            java.lang.String r4 = r13.getName()
            java.lang.String r7 = "item"
            boolean r4 = r4.equals(r7)
            if (r4 != 0) goto L37
            goto L13
        L37:
            int[] r4 = defpackage.y6.K
            android.content.res.TypedArray r4 = defpackage.w7.k(r12, r15, r14, r4)
            int r7 = defpackage.y6.L
            boolean r8 = r4.hasValue(r7)
            int r9 = defpackage.y6.M
            boolean r10 = r4.hasValue(r9)
            if (r8 == 0) goto L69
            if (r10 == 0) goto L69
            r11 = 0
            int r7 = r4.getColor(r7, r11)
            r11 = 0
            float r9 = r4.getFloat(r9, r11)
            r4.recycle()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            r3.add(r11)
            java.lang.Float r11 = java.lang.Float.valueOf(r9)
            r2.add(r11)
            goto L13
        L69:
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = r13.getPositionDescription()
            r7.append(r9)
            java.lang.String r9 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r1.<init>(r7)
            throw r1
        L84:
            int r1 = r3.size()
            if (r1 <= 0) goto L90
            t7$a r1 = new t7$a
            r1.<init>(r3, r2)
            return r1
        L90:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t7.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):t7$a");
    }

    public static a a(a colorItems, int startColor, int endColor, boolean hasCenterColor, int centerColor) {
        if (colorItems != null) {
            return colorItems;
        }
        if (hasCenterColor) {
            return new a(startColor, centerColor, endColor);
        }
        return new a(startColor, endColor);
    }

    public static Shader.TileMode d(int tileMode) {
        switch (tileMode) {
            case 1:
                return Shader.TileMode.REPEAT;
            case 2:
                return Shader.TileMode.MIRROR;
            default:
                return Shader.TileMode.CLAMP;
        }
    }

    /* compiled from: GradientColorInflaterCompat.java */
    /* renamed from: t7$a */
    /* loaded from: classes.dex */
    public static final class a {
        public final int[] a;
        public final float[] b;

        public a(List<Integer> colorsList, List<Float> offsetsList) {
            int size = colorsList.size();
            this.a = new int[size];
            this.b = new float[size];
            for (int i = 0; i < size; i++) {
                this.a[i] = colorsList.get(i).intValue();
                this.b[i] = offsetsList.get(i).floatValue();
            }
        }

        public a(int startColor, int endColor) {
            this.a = new int[]{startColor, endColor};
            this.b = new float[]{0.0f, 1.0f};
        }

        public a(int startColor, int centerColor, int endColor) {
            this.a = new int[]{startColor, centerColor, endColor};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
