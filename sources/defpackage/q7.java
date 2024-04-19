package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ColorStateListInflaterCompat.java */
/* renamed from: q7  reason: default package */
/* loaded from: classes.dex */
public final class q7 {
    public static ColorStateList c(Resources resources, int resId, Resources.Theme theme) {
        try {
            XmlPullParser parser = resources.getXml(resId);
            return a(resources, parser, theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }

    public static ColorStateList a(Resources r, XmlPullParser parser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int type;
        AttributeSet attrs = Xml.asAttributeSet(parser);
        do {
            type = parser.next();
            if (type == 2) {
                break;
            }
        } while (type != 1);
        if (type != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return b(r, parser, attrs, theme);
    }

    public static ColorStateList b(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = parser.getName();
        if (!name.equals("selector")) {
            throw new XmlPullParserException(parser.getPositionDescription() + ": invalid color state list tag " + name);
        }
        return d(r, parser, attrs, theme);
    }

    public static ColorStateList d(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int i = 1;
        int innerDepth = parser.getDepth() + 1;
        int[][] stateSpecList = new int[20];
        int[] colorList = new int[stateSpecList.length];
        int listSize = 0;
        while (true) {
            int type = parser.next();
            if (type != i && ((depth = parser.getDepth()) >= innerDepth || type != 3)) {
                if (type == 2 && depth <= innerDepth && parser.getName().equals("item")) {
                    TypedArray a = f(r, theme, attrs, y6.a);
                    int baseColor = a.getColor(y6.b, -65281);
                    float alphaMod = 1.0f;
                    int i2 = y6.c;
                    if (a.hasValue(i2)) {
                        alphaMod = a.getFloat(i2, 1.0f);
                    } else {
                        int i3 = y6.d;
                        if (a.hasValue(i3)) {
                            alphaMod = a.getFloat(i3, 1.0f);
                        }
                    }
                    a.recycle();
                    int j = 0;
                    int numAttrs = attrs.getAttributeCount();
                    int[] stateSpec = new int[numAttrs];
                    int i4 = 0;
                    while (i4 < numAttrs) {
                        int innerDepth2 = innerDepth;
                        int stateResId = attrs.getAttributeNameResource(i4);
                        TypedArray a2 = a;
                        if (stateResId != 16843173 && stateResId != 16843551 && stateResId != w6.a) {
                            int j2 = j + 1;
                            stateSpec[j] = attrs.getAttributeBooleanValue(i4, false) ? stateResId : -stateResId;
                            j = j2;
                        }
                        i4++;
                        innerDepth = innerDepth2;
                        a = a2;
                    }
                    int innerDepth3 = innerDepth;
                    int[] stateSpec2 = StateSet.trimStateSet(stateSpec, j);
                    int color = e(baseColor, alphaMod);
                    colorList = u7.a(colorList, listSize, color);
                    stateSpecList = (int[][]) u7.b(stateSpecList, listSize, stateSpec2);
                    listSize++;
                    innerDepth = innerDepth3;
                    i = 1;
                } else {
                    innerDepth = innerDepth;
                    i = 1;
                }
            }
        }
        int[] colors = new int[listSize];
        int[][] stateSpecs = new int[listSize];
        System.arraycopy(colorList, 0, colors, 0, listSize);
        System.arraycopy(stateSpecList, 0, stateSpecs, 0, listSize);
        return new ColorStateList(stateSpecs, colors);
    }

    public static TypedArray f(Resources res, Resources.Theme theme, AttributeSet set, int[] attrs) {
        return theme == null ? res.obtainAttributes(set, attrs) : theme.obtainStyledAttributes(set, attrs, 0, 0);
    }

    public static int e(int color, float alphaMod) {
        int alpha = Math.round(Color.alpha(color) * alphaMod);
        return (16777215 & color) | (alpha << 24);
    }
}
