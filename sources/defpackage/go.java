package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.android.internal.util.ArrayUtils;
import defpackage.eo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* compiled from: ThemeWrapper.java */
/* renamed from: go  reason: default package */
/* loaded from: classes.dex */
public class go {
    public static final boolean a = eo.b;

    public static HashMap<String, Integer> e(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, HashMap<String, List<String>> extras) {
        boolean hasStyle;
        boolean hasTheme;
        List<String> append;
        Set<String> set;
        String value;
        int i = defStyleAttr;
        HashMap<String, Integer> maps = eo.a.a;
        HashMap<String, Integer> list = new HashMap<>();
        List<String> append2 = (extras == null || !extras.containsKey("extra_append")) ? null : extras.get("extra_append");
        List<String> global = (extras == null || !extras.containsKey("extra_global")) ? null : extras.get("extra_global");
        if (attrs == null) {
            hasStyle = false;
            hasTheme = false;
        } else {
            int N = attrs.getAttributeCount();
            hasStyle = false;
            hasTheme = false;
            for (int i2 = 0; i2 < N; i2++) {
                try {
                    String name = attrs.getAttributeName(i2);
                    String value2 = attrs.getAttributeValue(i2);
                    if (a) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("resolveAttribute common attr name=");
                        sb.append(name);
                        sb.append(" value=");
                        value = value2;
                        sb.append(value);
                        eo.b.a(sb.toString());
                    } else {
                        value = value2;
                    }
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(value)) {
                        boolean isDefineAttribute = eo.a.a(name);
                        boolean isAppendAttribute = append2 != null && append2.contains(name);
                        boolean isValidAttribute = (isDefineAttribute || isAppendAttribute) && value.startsWith("@");
                        boolean isThemeAttribute = eo.a.c(name);
                        boolean isStyleAttribute = eo.a.b(name);
                        if (isValidAttribute) {
                            if (isThemeAttribute) {
                                hasTheme = true;
                            }
                            if (isStyleAttribute) {
                                hasStyle = true;
                            }
                            if (!isThemeAttribute && !isStyleAttribute) {
                                int resId = Integer.parseInt(value.substring(1));
                                list.put(name, Integer.valueOf(resId));
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        if (hasTheme || hasStyle) {
            for (String key : maps.keySet()) {
                int attr = maps.get(key).intValue();
                if (attr != 0 && !list.containsKey(key)) {
                    int resId2 = 0;
                    if (hasTheme) {
                        append = append2;
                        resId2 = b(attr, context, null, 0, 0);
                    } else {
                        append = append2;
                    }
                    if (hasStyle) {
                        resId2 = b(attr, context, attrs, i, defStyleRes);
                    }
                    if (a) {
                        eo.b.a("resolveAttribute theme&style attr key=" + key + " resId=0x" + Integer.toHexString(resId2) + " hasTheme=" + hasTheme + " hasStyle=" + hasStyle);
                    }
                    if (resId2 != 0) {
                        list.put(key, Integer.valueOf(resId2));
                    }
                    append2 = append;
                }
            }
        }
        if (i > 0 || defStyleRes > 0) {
            try {
                Set<String> set2 = maps.keySet();
                int size = set2.size();
                String[] keys = (String[]) set2.toArray(new String[size]);
                int[] values = ArrayUtils.convertToIntArray(new ArrayList(maps.values()));
                int i3 = 0;
                while (i3 < size) {
                    String key2 = keys[i3];
                    int attr2 = values[i3];
                    if (list.containsKey(key2)) {
                        set = set2;
                    } else {
                        set = set2;
                        int resId3 = b(attr2, context, null, i, defStyleRes);
                        if (a) {
                            eo.b.a("resolveAttribute def attr key=" + key2 + " resId=0x" + Integer.toHexString(resId3));
                        }
                        if (resId3 != 0) {
                            list.put(key2, Integer.valueOf(resId3));
                        }
                    }
                    i3++;
                    i = defStyleAttr;
                    set2 = set;
                }
            } catch (Exception e2) {
                eo.b.b("ThemeWrapper", "resolveAttribute style e=" + e2);
            }
        }
        if (global != null && !global.isEmpty()) {
            for (String key3 : global) {
                if (!TextUtils.isEmpty(key3) && !list.containsKey(key3)) {
                    if (maps.containsKey(key3)) {
                        int resId4 = b(maps.get(key3).intValue(), context, null, 0, 0);
                        if (a) {
                            eo.b.a("resolveAttribute global attr key=" + key3 + " resId=0x" + Integer.toHexString(resId4));
                        }
                        if (resId4 != 0) {
                            list.put(key3, Integer.valueOf(resId4));
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void i(View view, HashMap<String, Integer> map) {
        if (view != null && map != null) {
            for (String attr : map.keySet()) {
                if (eo.a.a(attr)) {
                    h(view.getContext(), view, attr, map.get(attr).intValue());
                } else {
                    d(view.getContext(), view, attr, map.get(attr) != null ? map.get(attr).intValue() : 0);
                }
            }
        }
    }

    public static void h(Context context, View view, String attr, int resId) {
        Context ctx = context != null ? context.getApplicationContext() : null;
        if (ctx != null && view != null && !TextUtils.isEmpty(attr)) {
            Resources res = ctx.getResources();
            ctx.getTheme();
            try {
                if ("alpha".equals(attr)) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        view.setAlpha(res.getFloat(resId));
                    }
                } else if ("background".equals(attr)) {
                    view.setBackground(a(p7.b(ctx, resId), view.getBackground()));
                } else if ("foreground".equals(attr)) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        view.setForeground(a(p7.b(ctx, resId), view.getForeground()));
                    }
                } else if ("scrollbarThumbVertical".equals(attr)) {
                    g(view, p7.b(ctx, resId));
                } else if ("src".equals(attr)) {
                    if (view instanceof ImageView) {
                        ImageView imageView = (ImageView) view;
                        imageView.setImageDrawable(a(p7.b(ctx, resId), imageView.getDrawable()));
                    }
                } else if ("textColor".equals(attr)) {
                    if (view instanceof TextView) {
                        ((TextView) view).setTextColor(p7.a(ctx, resId));
                    }
                } else if ("textColorHint".equals(attr)) {
                    if (view instanceof TextView) {
                        ((TextView) view).setHintTextColor(p7.a(ctx, resId));
                    }
                } else if ("drawableLeft".equals(attr)) {
                    if (view instanceof TextView) {
                        f(0, (TextView) view, p7.b(ctx, resId));
                    }
                } else if ("drawableTop".equals(attr)) {
                    if (view instanceof TextView) {
                        f(1, (TextView) view, p7.b(ctx, resId));
                    }
                } else if ("drawableRight".equals(attr)) {
                    if (view instanceof TextView) {
                        f(2, (TextView) view, p7.b(ctx, resId));
                    }
                } else if ("drawableBottom".equals(attr)) {
                    if (view instanceof TextView) {
                        f(3, (TextView) view, p7.b(ctx, resId));
                    }
                } else if ("drawableStart".equals(attr)) {
                    if (view instanceof TextView) {
                        f(4, (TextView) view, p7.b(ctx, resId));
                    }
                } else if ("drawableEnd".equals(attr)) {
                    if (view instanceof TextView) {
                        f(5, (TextView) view, p7.b(ctx, resId));
                    }
                } else if ("progressDrawable".equals(attr)) {
                    if (view instanceof ProgressBar) {
                        ((ProgressBar) view).setProgressDrawable(p7.b(ctx, resId));
                    }
                } else if ("thumb".equals(attr)) {
                    if (view instanceof SeekBar) {
                        ((SeekBar) view).setThumb(p7.b(ctx, resId));
                    }
                } else if ("button".equals(attr)) {
                    if (view instanceof CompoundButton) {
                        ((CompoundButton) view).setButtonDrawable(p7.b(ctx, resId));
                    }
                } else if ("divider".equals(attr) && (view instanceof ListView)) {
                    ((ListView) view).setDivider(p7.b(ctx, resId));
                }
                view.refreshDrawableState();
                if (a) {
                    eo.b.a("setViewResource view info:" + c(view, resId, attr));
                }
            } catch (Exception e) {
                if (a) {
                    eo.b.a("setViewResource error attr=" + attr + " view=" + view + " e=" + e);
                }
            }
        }
    }

    public static void d(Context context, View view, String attr, int resId) {
        try {
            if (!TextUtils.isEmpty(attr) && attr.length() > 0) {
                view.getClass().getPackage().getName();
                String className = view.getClass().getName();
                String attrMethod = "set" + attr.substring(0, 1).toUpperCase() + attr.substring(1);
                if (a) {
                    eo.b.a("invokeViewResource view info:" + c(view, resId, attr));
                }
                Class clazz = Class.forName(className);
                Method method = clazz.getMethod(attrMethod, Integer.TYPE);
                method.invoke(view, Integer.valueOf(resId));
            }
        } catch (Exception e) {
            eo.b.b("ThemeWrapper", "invokeViewResource view=" + view + " e=" + e);
        }
    }

    public static Drawable a(Drawable newDrawable, Drawable oldDrawable) {
        if (newDrawable != null && oldDrawable != null && newDrawable.getLevel() != oldDrawable.getLevel()) {
            newDrawable.setLevel(oldDrawable.getLevel());
        }
        return newDrawable;
    }

    public static int b(int attr, Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray ta = context != null ? context.getTheme().obtainStyledAttributes(attrs, new int[]{attr}, defStyleAttr, defStyleRes) : null;
        if (ta != null) {
            try {
                int resId = ta.getResourceId(0, 0);
                if (resId != 0) {
                    ta.recycle();
                    return resId;
                }
            } catch (Exception e) {
            } catch (Throwable th) {
                ta.recycle();
                throw th;
            }
            ta.recycle();
        }
        return 0;
    }

    public static void f(int type, TextView view, Drawable drawable) {
        if (drawable != null && view != null) {
            switch (type) {
                case 0:
                case 1:
                case 2:
                case 3:
                    Drawable[] drawables = view.getCompoundDrawables();
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    if (drawables != null) {
                        drawables[type] = a(drawable, drawables[type]);
                        view.setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
                        return;
                    }
                    return;
                case 4:
                case 5:
                    Drawable[] drawables2 = view.getCompoundDrawablesRelative();
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    if (drawables2 != null) {
                        int index = type == 4 ? (char) 0 : 2;
                        drawables2[index] = a(drawable, drawables2[index]);
                        view.setCompoundDrawablesRelative(drawables2[0], drawables2[1], drawables2[2], drawables2[3]);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static void g(View view, Drawable drawable) {
        Class<?> scrollCacheClazz;
        Field scrollBarField;
        Object scrollBarObj;
        Class<?> scrollBarClazz;
        Field verticalThumbField;
        try {
            Method method = View.class.getDeclaredMethod("getScrollCache", new Class[0]);
            if (method == null) {
                return;
            }
            method.setAccessible(true);
            Object scrollCacheObj = method.invoke(view, new Object[0]);
            if (scrollCacheObj == null || (scrollCacheClazz = scrollCacheObj.getClass()) == null || (scrollBarField = scrollCacheClazz.getField("scrollBar")) == null || (scrollBarObj = scrollBarField.get(scrollCacheObj)) == null || (scrollBarClazz = scrollBarObj.getClass()) == null || (verticalThumbField = scrollBarClazz.getDeclaredField("mVerticalThumb")) == null) {
                return;
            }
            verticalThumbField.setAccessible(true);
            verticalThumbField.set(scrollBarObj, drawable);
        } catch (Exception e) {
        }
    }

    public static String c(View view, int resId, String attr) {
        StringBuffer buffer = new StringBuffer("getViewInfo");
        if (view != null) {
            try {
                Context context = view.getContext().getApplicationContext();
                if (context != null) {
                    Resources res = context.getResources();
                    TypedValue value = new TypedValue();
                    res.getValue(resId, value, true);
                    buffer.append(" view.id=0x" + Integer.toHexString(view.getId()));
                    buffer.append(" view.resId=0x" + Integer.toHexString(resId));
                    buffer.append(" view.attr=" + attr);
                    buffer.append(" view.toString=" + view.toString());
                    buffer.append(" view.value.string=" + ((Object) value.string));
                    buffer.append(" view.value=" + value.toString());
                } else {
                    buffer.append(" context null");
                }
            } catch (Exception e) {
                buffer.append(" error=" + e);
            }
        }
        return buffer.toString();
    }
}
