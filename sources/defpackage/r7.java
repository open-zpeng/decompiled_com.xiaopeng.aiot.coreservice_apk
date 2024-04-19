package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Shader;
import android.util.Log;
/* compiled from: ComplexColorCompat.java */
/* renamed from: r7  reason: default package */
/* loaded from: classes.dex */
public final class r7 {
    public final Shader a;
    public final ColorStateList b;
    public int c;

    public r7(Shader shader, ColorStateList colorStateList, int color) {
        this.a = shader;
        this.b = colorStateList;
        this.c = color;
    }

    public static r7 d(Shader shader) {
        return new r7(shader, null, 0);
    }

    public static r7 c(ColorStateList colorStateList) {
        return new r7(null, colorStateList, colorStateList.getDefaultColor());
    }

    public static r7 b(int color) {
        return new r7(null, null, color);
    }

    public Shader f() {
        return this.a;
    }

    public int e() {
        return this.c;
    }

    public void k(int color) {
        this.c = color;
    }

    public boolean h() {
        return this.a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.a == null && (colorStateList = this.b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] stateSet) {
        if (!i()) {
            return false;
        }
        ColorStateList colorStateList = this.b;
        int colorForState = colorStateList.getColorForState(stateSet, colorStateList.getDefaultColor());
        if (colorForState == this.c) {
            return false;
        }
        this.c = colorForState;
        return true;
    }

    public boolean l() {
        return h() || this.c != 0;
    }

    public static r7 g(Resources resources, int resId, Resources.Theme theme) {
        try {
            return a(resources, resId, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r2.equals("gradient") != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.r7 a(android.content.res.Resources r7, int r8, android.content.res.Resources.Theme r9) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            android.content.res.XmlResourceParser r0 = r7.getXml(r8)
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r0)
        L8:
            int r2 = r0.next()
            r3 = r2
            r4 = 1
            r5 = 2
            if (r2 == r5) goto L14
            if (r3 == r4) goto L14
            goto L8
        L14:
            if (r3 != r5) goto L6a
            java.lang.String r2 = r0.getName()
            r5 = -1
            int r6 = r2.hashCode()
            switch(r6) {
                case 89650992: goto L2d;
                case 1191572447: goto L23;
                default: goto L22;
            }
        L22:
            goto L36
        L23:
            java.lang.String r4 = "selector"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L22
            r4 = 0
            goto L37
        L2d:
            java.lang.String r6 = "gradient"
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L22
            goto L37
        L36:
            r4 = r5
        L37:
            switch(r4) {
                case 0: goto L61;
                case 1: goto L58;
                default: goto L3a;
            }
        L3a:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r0.getPositionDescription()
            r5.append(r6)
            java.lang.String r6 = ": unsupported complex color tag "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L58:
            android.graphics.Shader r4 = defpackage.t7.b(r7, r0, r1, r9)
            r7 r4 = d(r4)
            return r4
        L61:
            android.content.res.ColorStateList r4 = defpackage.q7.b(r7, r0, r1, r9)
            r7 r4 = c(r4)
            return r4
        L6a:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r4 = "No start tag found"
            r2.<init>(r4)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r7.a(android.content.res.Resources, int, android.content.res.Resources$Theme):r7");
    }
}
