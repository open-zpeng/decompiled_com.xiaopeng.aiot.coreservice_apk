package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ConstraintLayoutStates.java */
/* renamed from: n6  reason: default package */
/* loaded from: classes.dex */
public class n6 {
    public final ConstraintLayout a;
    public o6 b;
    public int c = -1;
    public int d = -1;
    public SparseArray<a> e = new SparseArray<>();
    public SparseArray<o6> f = new SparseArray<>();
    public p6 g;

    public n6(Context context, ConstraintLayout layout, int resourceID) {
        this.a = layout;
        a(context, resourceID);
    }

    public void d(int id, float width, float height) {
        a state;
        int match;
        int i = this.c;
        if (i == id) {
            if (id == -1) {
                state = this.e.valueAt(0);
            } else {
                state = this.e.get(i);
            }
            int i2 = this.d;
            if ((i2 != -1 && state.b.get(i2).a(width, height)) || this.d == (match = state.b(width, height))) {
                return;
            }
            o6 constraintSet = match == -1 ? this.b : state.b.get(match).f;
            int cid = match == -1 ? state.c : state.b.get(match).e;
            if (constraintSet == null) {
                return;
            }
            this.d = match;
            p6 p6Var = this.g;
            if (p6Var != null) {
                p6Var.b(-1, cid);
                throw null;
            }
            constraintSet.c(this.a);
            p6 p6Var2 = this.g;
            if (p6Var2 != null) {
                p6Var2.a(-1, cid);
                throw null;
            }
            return;
        }
        this.c = id;
        a state2 = this.e.get(id);
        int match2 = state2.b(width, height);
        o6 constraintSet2 = match2 == -1 ? state2.d : state2.b.get(match2).f;
        int cid2 = match2 == -1 ? state2.c : state2.b.get(match2).e;
        if (constraintSet2 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + id + ", dim =" + width + ", " + height);
            return;
        }
        this.d = match2;
        p6 p6Var3 = this.g;
        if (p6Var3 != null) {
            p6Var3.b(id, cid2);
            throw null;
        }
        constraintSet2.c(this.a);
        p6 p6Var4 = this.g;
        if (p6Var4 != null) {
            p6Var4.a(id, cid2);
            throw null;
        }
    }

    public void c(p6 constraintsChangedListener) {
    }

    /* compiled from: ConstraintLayoutStates.java */
    /* renamed from: n6$a */
    /* loaded from: classes.dex */
    public static class a {
        public int a;
        public ArrayList<b> b = new ArrayList<>();
        public int c;
        public o6 d;

        public a(Context context, XmlPullParser parser) {
            this.c = -1;
            AttributeSet attrs = Xml.asAttributeSet(parser);
            TypedArray a = context.obtainStyledAttributes(attrs, r6.v7);
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == r6.w7) {
                    this.a = a.getResourceId(attr, this.a);
                } else if (attr == r6.x7) {
                    this.c = a.getResourceId(attr, this.c);
                    String type = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(type)) {
                        o6 o6Var = new o6();
                        this.d = o6Var;
                        o6Var.e(context, this.c);
                    }
                }
            }
            a.recycle();
        }

        public void a(b size) {
            this.b.add(size);
        }

        public int b(float width, float height) {
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).a(width, height)) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* compiled from: ConstraintLayoutStates.java */
    /* renamed from: n6$b */
    /* loaded from: classes.dex */
    public static class b {
        public float a;
        public float b;
        public float c;
        public float d;
        public int e;
        public o6 f;

        public b(Context context, XmlPullParser parser) {
            this.a = Float.NaN;
            this.b = Float.NaN;
            this.c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            AttributeSet attrs = Xml.asAttributeSet(parser);
            TypedArray a = context.obtainStyledAttributes(attrs, r6.T7);
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == r6.U7) {
                    this.e = a.getResourceId(attr, this.e);
                    String type = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(type)) {
                        o6 o6Var = new o6();
                        this.f = o6Var;
                        o6Var.e(context, this.e);
                    }
                } else if (attr == r6.V7) {
                    this.d = a.getDimension(attr, this.d);
                } else if (attr == r6.W7) {
                    this.b = a.getDimension(attr, this.b);
                } else if (attr == r6.X7) {
                    this.c = a.getDimension(attr, this.c);
                } else if (attr == r6.Y7) {
                    this.a = a.getDimension(attr, this.a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            a.recycle();
        }

        public boolean a(float widthDp, float heightDp) {
            if (Float.isNaN(this.a) || widthDp >= this.a) {
                if (Float.isNaN(this.b) || heightDp >= this.b) {
                    if (Float.isNaN(this.c) || widthDp <= this.c) {
                        return Float.isNaN(this.d) || heightDp <= this.d;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(Context context, int resourceId) {
        Resources res = context.getResources();
        XmlPullParser parser = res.getXml(resourceId);
        a state = null;
        try {
            int eventType = parser.getEventType();
            while (true) {
                char c = 1;
                if (eventType != 1) {
                    switch (eventType) {
                        case 0:
                            parser.getName();
                            break;
                        case 2:
                            String tagName = parser.getName();
                            switch (tagName.hashCode()) {
                                case -1349929691:
                                    if (tagName.equals("ConstraintSet")) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 80204913:
                                    if (tagName.equals("State")) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1382829617:
                                    if (tagName.equals("StateSet")) {
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1657696882:
                                    if (tagName.equals("layoutDescription")) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1901439077:
                                    if (tagName.equals("Variant")) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            switch (c) {
                                case 2:
                                    state = new a(context, parser);
                                    this.e.put(state.a, state);
                                    break;
                                case 3:
                                    b match = new b(context, parser);
                                    if (state != null) {
                                        state.a(match);
                                        break;
                                    }
                                    break;
                                case 4:
                                    b(context, parser);
                                    break;
                            }
                            break;
                    }
                    eventType = parser.next();
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public final void b(Context context, XmlPullParser parser) {
        o6 set = new o6();
        int count = parser.getAttributeCount();
        for (int i = 0; i < count; i++) {
            String name = parser.getAttributeName(i);
            String s = parser.getAttributeValue(i);
            if (name != null && s != null && "id".equals(name)) {
                int id = -1;
                if (s.contains("/")) {
                    String tmp = s.substring(s.indexOf(47) + 1);
                    id = context.getResources().getIdentifier(tmp, "id", context.getPackageName());
                }
                if (id == -1) {
                    if (s.length() > 1) {
                        id = Integer.parseInt(s.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                set.l(context, parser);
                this.f.put(id, set);
                return;
            }
        }
    }
}
