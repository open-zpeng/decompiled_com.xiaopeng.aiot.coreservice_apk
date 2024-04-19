package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.content.res.FontResourcesParserCompat;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: FontResourcesParserCompat.java */
/* renamed from: s7  reason: default package */
/* loaded from: classes.dex */
public class s7 {

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: s7$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: s7$d */
    /* loaded from: classes.dex */
    public static final class d implements a {
        public final y8 a;
        public final int b;
        public final int c;
        public final String d;

        public d(y8 request, int strategy, int timeoutMs, String systemFontFamilyName) {
            this.a = request;
            this.c = strategy;
            this.b = timeoutMs;
            this.d = systemFontFamilyName;
        }

        public y8 b() {
            return this.a;
        }

        public int a() {
            return this.c;
        }

        public int d() {
            return this.b;
        }

        public String c() {
            return this.d;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: s7$c */
    /* loaded from: classes.dex */
    public static final class c {
        public final String a;
        public int b;
        public boolean c;
        public String d;
        public int e;
        public int f;

        public c(String fileName, int weight, boolean italic, String variationSettings, int ttcIndex, int resourceId) {
            this.a = fileName;
            this.b = weight;
            this.c = italic;
            this.d = variationSettings;
            this.e = ttcIndex;
            this.f = resourceId;
        }

        public String a() {
            return this.a;
        }

        public int e() {
            return this.b;
        }

        public boolean f() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public int c() {
            return this.e;
        }

        public int b() {
            return this.f;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: s7$b */
    /* loaded from: classes.dex */
    public static final class b implements a {
        public final c[] a;

        public b(c[] entries) {
            this.a = entries;
        }

        public c[] a() {
            return this.a;
        }
    }

    public static a b(XmlPullParser parser, Resources resources) throws XmlPullParserException, IOException {
        int type;
        do {
            type = parser.next();
            if (type == 2) {
                break;
            }
        } while (type != 1);
        if (type != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return d(parser, resources);
    }

    public static a d(XmlPullParser parser, Resources resources) throws XmlPullParserException, IOException {
        parser.require(2, null, "font-family");
        String tag = parser.getName();
        if (tag.equals("font-family")) {
            return e(parser, resources);
        }
        g(parser);
        return null;
    }

    public static a e(XmlPullParser parser, Resources resources) throws XmlPullParserException, IOException {
        AttributeSet attrs = Xml.asAttributeSet(parser);
        TypedArray array = resources.obtainAttributes(attrs, y6.e);
        String authority = array.getString(y6.f);
        String providerPackage = array.getString(y6.j);
        String query = array.getString(y6.k);
        int certsId = array.getResourceId(y6.g, 0);
        int strategy = array.getInteger(y6.h, 1);
        int timeoutMs = array.getInteger(y6.i, IInputController.KEYCODE_KNOB_WIND_SPD_UP);
        String systemFontFamilyName = array.getString(y6.l);
        array.recycle();
        if (authority != null && providerPackage != null && query != null) {
            while (parser.next() != 3) {
                g(parser);
            }
            List<List<byte[]>> certs = c(resources, certsId);
            return new d(new y8(authority, providerPackage, query, certs), strategy, timeoutMs, systemFontFamilyName);
        }
        List<FontResourcesParserCompat.FontFileResourceEntry> fonts = new ArrayList<>();
        while (parser.next() != 3) {
            if (parser.getEventType() == 2) {
                String tag = parser.getName();
                if (tag.equals("font")) {
                    fonts.add(f(parser, resources));
                } else {
                    g(parser);
                }
            }
        }
        if (fonts.isEmpty()) {
            return null;
        }
        return new b((c[]) fonts.toArray(new c[fonts.size()]));
    }

    public static int a(TypedArray typedArray, int index) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(index);
        }
        TypedValue tv = new TypedValue();
        typedArray.getValue(index, tv);
        return tv.type;
    }

    public static List<List<byte[]>> c(Resources resources, int certsId) {
        if (certsId == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArray = resources.obtainTypedArray(certsId);
        try {
            if (typedArray.length() == 0) {
                return Collections.emptyList();
            }
            List<List<byte[]>> result = new ArrayList<>();
            if (a(typedArray, 0) == 1) {
                for (int i = 0; i < typedArray.length(); i++) {
                    int certId = typedArray.getResourceId(i, 0);
                    if (certId != 0) {
                        result.add(h(resources.getStringArray(certId)));
                    }
                }
            } else {
                result.add(h(resources.getStringArray(certsId)));
            }
            return result;
        } finally {
            typedArray.recycle();
        }
    }

    public static List<byte[]> h(String[] stringArray) {
        List<byte[]> result = new ArrayList<>();
        for (String item : stringArray) {
            result.add(Base64.decode(item, 0));
        }
        return result;
    }

    public static c f(XmlPullParser parser, Resources resources) throws XmlPullParserException, IOException {
        AttributeSet attrs = Xml.asAttributeSet(parser);
        TypedArray array = resources.obtainAttributes(attrs, y6.m);
        int weightAttr = y6.v;
        if (!array.hasValue(weightAttr)) {
            weightAttr = y6.o;
        }
        int weight = array.getInt(weightAttr, 400);
        int i = y6.t;
        if (!array.hasValue(i)) {
            i = y6.p;
        }
        int styleAttr = i;
        boolean isItalic = 1 == array.getInt(styleAttr, 0);
        int i2 = y6.w;
        if (!array.hasValue(i2)) {
            i2 = y6.q;
        }
        int ttcIndexAttr = i2;
        int i3 = y6.u;
        if (!array.hasValue(i3)) {
            i3 = y6.r;
        }
        int variationSettingsAttr = i3;
        String variationSettings = array.getString(variationSettingsAttr);
        int ttcIndex = array.getInt(ttcIndexAttr, 0);
        int i4 = y6.s;
        if (!array.hasValue(i4)) {
            i4 = y6.n;
        }
        int resourceAttr = i4;
        int resourceId = array.getResourceId(resourceAttr, 0);
        String filename = array.getString(resourceAttr);
        array.recycle();
        while (parser.next() != 3) {
            g(parser);
        }
        return new c(filename, weight, isItalic, variationSettings, ttcIndex, resourceId);
    }

    public static void g(XmlPullParser parser) throws XmlPullParserException, IOException {
        int depth = 1;
        while (depth > 0) {
            switch (parser.next()) {
                case 2:
                    depth++;
                    break;
                case 3:
                    depth--;
                    break;
            }
        }
    }
}
