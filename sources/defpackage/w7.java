package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: TypedArrayUtils.java */
/* renamed from: w7  reason: default package */
/* loaded from: classes.dex */
public class w7 {
    public static boolean j(XmlPullParser parser, String attrName) {
        return parser.getAttributeValue("http://schemas.android.com/apk/res/android", attrName) != null;
    }

    public static float f(TypedArray a, XmlPullParser parser, String attrName, int resId, float defaultValue) {
        boolean hasAttr = j(parser, attrName);
        if (!hasAttr) {
            return defaultValue;
        }
        return a.getFloat(resId, defaultValue);
    }

    public static boolean a(TypedArray a, XmlPullParser parser, String attrName, int resId, boolean defaultValue) {
        boolean hasAttr = j(parser, attrName);
        if (!hasAttr) {
            return defaultValue;
        }
        return a.getBoolean(resId, defaultValue);
    }

    public static int g(TypedArray a, XmlPullParser parser, String attrName, int resId, int defaultValue) {
        boolean hasAttr = j(parser, attrName);
        if (!hasAttr) {
            return defaultValue;
        }
        return a.getInt(resId, defaultValue);
    }

    public static int b(TypedArray a, XmlPullParser parser, String attrName, int resId, int defaultValue) {
        boolean hasAttr = j(parser, attrName);
        if (!hasAttr) {
            return defaultValue;
        }
        return a.getColor(resId, defaultValue);
    }

    public static r7 e(TypedArray a, XmlPullParser parser, Resources.Theme theme, String attrName, int resId, int defaultValue) {
        if (j(parser, attrName)) {
            TypedValue value = new TypedValue();
            a.getValue(resId, value);
            int i = value.type;
            if (i >= 28 && i <= 31) {
                return r7.b(value.data);
            }
            r7 complexColor = r7.g(a.getResources(), a.getResourceId(resId, 0), theme);
            if (complexColor != null) {
                return complexColor;
            }
        }
        return r7.b(defaultValue);
    }

    public static ColorStateList c(TypedArray a, XmlPullParser parser, Resources.Theme theme, String attrName, int resId) {
        if (j(parser, attrName)) {
            TypedValue value = new TypedValue();
            a.getValue(resId, value);
            int i = value.type;
            if (i == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index " + resId + ": " + value);
            } else if (i >= 28 && i <= 31) {
                return d(value);
            } else {
                return q7.c(a.getResources(), a.getResourceId(resId, 0), theme);
            }
        }
        return null;
    }

    public static ColorStateList d(TypedValue value) {
        return ColorStateList.valueOf(value.data);
    }

    public static int h(TypedArray a, XmlPullParser parser, String attrName, int resId, int defaultValue) {
        boolean hasAttr = j(parser, attrName);
        if (!hasAttr) {
            return defaultValue;
        }
        return a.getResourceId(resId, defaultValue);
    }

    public static String i(TypedArray a, XmlPullParser parser, String attrName, int resId) {
        boolean hasAttr = j(parser, attrName);
        if (!hasAttr) {
            return null;
        }
        return a.getString(resId);
    }

    public static TypedValue l(TypedArray a, XmlPullParser parser, String attrName, int resId) {
        boolean hasAttr = j(parser, attrName);
        if (!hasAttr) {
            return null;
        }
        return a.peekValue(resId);
    }

    public static TypedArray k(Resources res, Resources.Theme theme, AttributeSet set, int[] attrs) {
        if (theme == null) {
            return res.obtainAttributes(set, attrs);
        }
        return theme.obtainStyledAttributes(set, attrs, 0, 0);
    }
}
