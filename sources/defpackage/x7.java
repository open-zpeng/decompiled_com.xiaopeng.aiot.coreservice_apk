package defpackage;

import android.graphics.Color;
/* compiled from: ColorUtils.java */
/* renamed from: x7  reason: default package */
/* loaded from: classes.dex */
public final class x7 {
    public static final ThreadLocal<double[]> a = new ThreadLocal<>();

    public static int b(int foreground, int background) {
        int bgAlpha = Color.alpha(background);
        int fgAlpha = Color.alpha(foreground);
        int a2 = a(fgAlpha, bgAlpha);
        int r = c(Color.red(foreground), fgAlpha, Color.red(background), bgAlpha, a2);
        int g = c(Color.green(foreground), fgAlpha, Color.green(background), bgAlpha, a2);
        int b = c(Color.blue(foreground), fgAlpha, Color.blue(background), bgAlpha, a2);
        return Color.argb(a2, r, g, b);
    }

    public static int a(int foregroundAlpha, int backgroundAlpha) {
        return 255 - (((255 - backgroundAlpha) * (255 - foregroundAlpha)) / 255);
    }

    public static int c(int fgC, int fgA, int bgC, int bgA, int a2) {
        if (a2 == 0) {
            return 0;
        }
        return (((fgC * 255) * fgA) + ((bgC * bgA) * (255 - fgA))) / (a2 * 255);
    }

    public static int d(int color, int alpha) {
        if (alpha < 0 || alpha > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (16777215 & color) | (alpha << 24);
    }
}
