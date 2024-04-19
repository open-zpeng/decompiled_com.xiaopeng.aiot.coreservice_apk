package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: ConstraintAttribute.java */
/* renamed from: m6  reason: default package */
/* loaded from: classes.dex */
public class m6 {
    public boolean a;
    public String b;
    public b c;
    public int d;
    public float e;
    public String f;
    public boolean g;
    public int h;

    /* compiled from: ConstraintAttribute.java */
    /* renamed from: m6$b */
    /* loaded from: classes.dex */
    public enum b {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    /* compiled from: ConstraintAttribute.java */
    /* renamed from: m6$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[b.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[b.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[b.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[b.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[b.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[b.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[b.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public m6(String name, b attributeType, Object value, boolean method) {
        this.a = false;
        this.b = name;
        this.c = attributeType;
        this.a = method;
        f(value);
    }

    public m6(m6 source, Object value) {
        this.a = false;
        this.b = source.b;
        this.c = source.c;
        f(value);
    }

    public void f(Object value) {
        switch (a.a[this.c.ordinal()]) {
            case 1:
            case 6:
                this.d = ((Integer) value).intValue();
                return;
            case 2:
                this.g = ((Boolean) value).booleanValue();
                return;
            case 3:
                this.f = (String) value;
                return;
            case 4:
            case 5:
                this.h = ((Integer) value).intValue();
                return;
            case 7:
                this.e = ((Float) value).floatValue();
                return;
            case 8:
                this.e = ((Float) value).floatValue();
                return;
            default:
                return;
        }
    }

    public static HashMap<String, m6> b(HashMap<String, m6> hashMap, View view) {
        HashMap<String, m6> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String name : hashMap.keySet()) {
            m6 constraintAttribute = hashMap.get(name);
            try {
                if (name.equals("BackgroundColor")) {
                    ColorDrawable viewColor = (ColorDrawable) view.getBackground();
                    Object val = Integer.valueOf(viewColor.getColor());
                    hashMap2.put(name, new m6(constraintAttribute, val));
                } else {
                    Method method = cls.getMethod("getMap" + name, new Class[0]);
                    Object val2 = method.invoke(view, new Object[0]);
                    hashMap2.put(name, new m6(constraintAttribute, val2));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void d(View view, HashMap<String, m6> hashMap) {
        Class<?> cls = view.getClass();
        for (String name : hashMap.keySet()) {
            m6 constraintAttribute = hashMap.get(name);
            String methodName = name;
            if (!constraintAttribute.a) {
                methodName = "set" + methodName;
            }
            try {
                switch (a.a[constraintAttribute.c.ordinal()]) {
                    case 1:
                        Method method = cls.getMethod(methodName, Integer.TYPE);
                        method.invoke(view, Integer.valueOf(constraintAttribute.d));
                        break;
                    case 2:
                        Method method2 = cls.getMethod(methodName, Boolean.TYPE);
                        method2.invoke(view, Boolean.valueOf(constraintAttribute.g));
                        break;
                    case 3:
                        Method method3 = cls.getMethod(methodName, CharSequence.class);
                        method3.invoke(view, constraintAttribute.f);
                        break;
                    case 4:
                        Method method4 = cls.getMethod(methodName, Integer.TYPE);
                        method4.invoke(view, Integer.valueOf(constraintAttribute.h));
                        break;
                    case 5:
                        Method method5 = cls.getMethod(methodName, Drawable.class);
                        ColorDrawable drawable = new ColorDrawable();
                        drawable.setColor(constraintAttribute.h);
                        method5.invoke(view, drawable);
                        break;
                    case 6:
                        Method method6 = cls.getMethod(methodName, Integer.TYPE);
                        method6.invoke(view, Integer.valueOf(constraintAttribute.d));
                        break;
                    case 7:
                        Method method7 = cls.getMethod(methodName, Float.TYPE);
                        method7.invoke(view, Float.valueOf(constraintAttribute.e));
                        break;
                    case 8:
                        Method method8 = cls.getMethod(methodName, Float.TYPE);
                        method8.invoke(view, Float.valueOf(constraintAttribute.e));
                        break;
                }
            } catch (IllegalAccessException e) {
                Log.e("TransitionLayout", " Custom Attribute \"" + name + "\" not found on " + cls.getName());
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                Log.e("TransitionLayout", e2.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + name + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(methodName);
                Log.e("TransitionLayout", sb.toString());
            } catch (InvocationTargetException e3) {
                Log.e("TransitionLayout", " Custom Attribute \"" + name + "\" not found on " + cls.getName());
                e3.printStackTrace();
            }
        }
    }

    public static int a(int c) {
        int c2 = (c & (~(c >> 31))) - 255;
        return (c2 & (c2 >> 31)) + 255;
    }

    public void e(View view, float[] value) {
        Class<?> cls = view.getClass();
        String methodName = "set" + this.b;
        try {
            switch (a.a[this.c.ordinal()]) {
                case 2:
                    Method method = cls.getMethod(methodName, Boolean.TYPE);
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(value[0] > 0.5f);
                    method.invoke(view, objArr);
                    return;
                case 3:
                    throw new RuntimeException("unable to interpolate strings " + this.b);
                case 4:
                    Method method2 = cls.getMethod(methodName, Integer.TYPE);
                    int r = a((int) (((float) Math.pow(value[0], 0.45454545454545453d)) * 255.0f));
                    int g = a((int) (((float) Math.pow(value[1], 0.45454545454545453d)) * 255.0f));
                    int b2 = a((int) (((float) Math.pow(value[2], 0.45454545454545453d)) * 255.0f));
                    int a2 = a((int) (value[3] * 255.0f));
                    int color = (a2 << 24) | (r << 16) | (g << 8) | b2;
                    method2.invoke(view, Integer.valueOf(color));
                    return;
                case 5:
                    Method method3 = cls.getMethod(methodName, Drawable.class);
                    int r2 = a((int) (((float) Math.pow(value[0], 0.45454545454545453d)) * 255.0f));
                    int g2 = a((int) (((float) Math.pow(value[1], 0.45454545454545453d)) * 255.0f));
                    int b3 = a((int) (((float) Math.pow(value[2], 0.45454545454545453d)) * 255.0f));
                    int a3 = a((int) (value[3] * 255.0f));
                    int color2 = (a3 << 24) | (r2 << 16) | (g2 << 8) | b3;
                    ColorDrawable drawable = new ColorDrawable();
                    drawable.setColor(color2);
                    method3.invoke(view, drawable);
                    return;
                case 6:
                    Method method4 = cls.getMethod(methodName, Integer.TYPE);
                    method4.invoke(view, Integer.valueOf((int) value[0]));
                    return;
                case 7:
                    Method method5 = cls.getMethod(methodName, Float.TYPE);
                    method5.invoke(view, Float.valueOf(value[0]));
                    return;
                case 8:
                    Method method6 = cls.getMethod(methodName, Float.TYPE);
                    method6.invoke(view, Float.valueOf(value[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            Log.e("TransitionLayout", "cannot access method " + methodName + " on View \"" + b6.c(view) + "\"");
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            Log.e("TransitionLayout", "no method " + methodName + " on View \"" + b6.c(view) + "\"");
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public static void c(Context context, XmlPullParser parser, HashMap<String, m6> hashMap) {
        AttributeSet attributeSet = Xml.asAttributeSet(parser);
        TypedArray a2 = context.obtainStyledAttributes(attributeSet, r6.a5);
        String name = null;
        boolean method = false;
        Object value = null;
        b type = null;
        int N = a2.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a2.getIndex(i);
            if (attr == r6.b5) {
                name = a2.getString(attr);
                if (name != null && name.length() > 0) {
                    name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
                }
            } else if (attr == r6.l5) {
                method = true;
                name = a2.getString(attr);
            } else if (attr == r6.c5) {
                value = Boolean.valueOf(a2.getBoolean(attr, false));
                type = b.BOOLEAN_TYPE;
            } else if (attr == r6.e5) {
                type = b.COLOR_TYPE;
                value = Integer.valueOf(a2.getColor(attr, 0));
            } else if (attr == r6.d5) {
                type = b.COLOR_DRAWABLE_TYPE;
                value = Integer.valueOf(a2.getColor(attr, 0));
            } else if (attr == r6.i5) {
                type = b.DIMENSION_TYPE;
                value = Float.valueOf(TypedValue.applyDimension(1, a2.getDimension(attr, 0.0f), context.getResources().getDisplayMetrics()));
            } else if (attr == r6.f5) {
                type = b.DIMENSION_TYPE;
                value = Float.valueOf(a2.getDimension(attr, 0.0f));
            } else if (attr == r6.g5) {
                type = b.FLOAT_TYPE;
                value = Float.valueOf(a2.getFloat(attr, Float.NaN));
            } else if (attr == r6.h5) {
                type = b.INT_TYPE;
                value = Integer.valueOf(a2.getInteger(attr, -1));
            } else if (attr == r6.k5) {
                type = b.STRING_TYPE;
                value = a2.getString(attr);
            } else if (attr == r6.j5) {
                type = b.REFERENCE_TYPE;
                int tmp = a2.getResourceId(attr, -1);
                if (tmp == -1) {
                    tmp = a2.getInt(attr, -1);
                }
                value = Integer.valueOf(tmp);
            }
        }
        if (name != null && value != null) {
            hashMap.put(name, new m6(name, type, value, method));
        }
        a2.recycle();
    }
}
