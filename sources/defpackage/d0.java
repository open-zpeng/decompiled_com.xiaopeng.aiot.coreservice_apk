package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: AppCompatViewInflater.java */
/* renamed from: d0  reason: default package */
/* loaded from: classes.dex */
public class d0 {
    public static final Class<?>[] a = {Context.class, AttributeSet.class};
    public static final int[] b = {16843375};
    public static final String[] c = {"android.widget.", "android.view.", "android.webkit."};
    public static final z3<String, Constructor<? extends View>> d = new z3<>();
    public final Object[] e = new Object[2];

    public final View q(View parent, String name, Context context, AttributeSet attrs, boolean inheritContext, boolean readAndroidTheme, boolean readAppTheme, boolean wrapContext) {
        View view;
        if (inheritContext && parent != null) {
            context = parent.getContext();
        }
        if (readAndroidTheme || readAppTheme) {
            context = t(context, attrs, readAndroidTheme, readAppTheme);
        }
        if (wrapContext) {
            context = w2.b(context);
        }
        char c2 = 65535;
        switch (name.hashCode()) {
            case -1946472170:
                if (name.equals("RatingBar")) {
                    c2 = 11;
                    break;
                }
                break;
            case -1455429095:
                if (name.equals("CheckedTextView")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -1346021293:
                if (name.equals("MultiAutoCompleteTextView")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -938935918:
                if (name.equals("TextView")) {
                    c2 = 0;
                    break;
                }
                break;
            case -937446323:
                if (name.equals("ImageButton")) {
                    c2 = 5;
                    break;
                }
                break;
            case -658531749:
                if (name.equals("SeekBar")) {
                    c2 = '\f';
                    break;
                }
                break;
            case -339785223:
                if (name.equals("Spinner")) {
                    c2 = 4;
                    break;
                }
                break;
            case 776382189:
                if (name.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                break;
            case 799298502:
                if (name.equals("ToggleButton")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 1125864064:
                if (name.equals("ImageView")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1413872058:
                if (name.equals("AutoCompleteTextView")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1601505219:
                if (name.equals("CheckBox")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1666676343:
                if (name.equals("EditText")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2001146706:
                if (name.equals("Button")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                view = n(context, attrs);
                u(view, name);
                break;
            case 1:
                view = h(context, attrs);
                u(view, name);
                break;
            case 2:
                view = c(context, attrs);
                u(view, name);
                break;
            case 3:
                view = f(context, attrs);
                u(view, name);
                break;
            case 4:
                view = m(context, attrs);
                u(view, name);
                break;
            case 5:
                view = g(context, attrs);
                u(view, name);
                break;
            case 6:
                view = d(context, attrs);
                u(view, name);
                break;
            case 7:
                view = j(context, attrs);
                u(view, name);
                break;
            case '\b':
                view = e(context, attrs);
                u(view, name);
                break;
            case '\t':
                view = b(context, attrs);
                u(view, name);
                break;
            case '\n':
                view = i(context, attrs);
                u(view, name);
                break;
            case 11:
                view = k(context, attrs);
                u(view, name);
                break;
            case '\f':
                view = l(context, attrs);
                u(view, name);
                break;
            case '\r':
                view = o(context, attrs);
                u(view, name);
                break;
            default:
                view = p(context, name, attrs);
                break;
        }
        if (view == null && context != context) {
            view = s(context, name, attrs);
        }
        if (view != null) {
            a(view, attrs);
        }
        return view;
    }

    public AppCompatTextView n(Context context, AttributeSet attrs) {
        return new AppCompatTextView(context, attrs);
    }

    public AppCompatImageView h(Context context, AttributeSet attrs) {
        return new AppCompatImageView(context, attrs);
    }

    public AppCompatButton c(Context context, AttributeSet attrs) {
        return new AppCompatButton(context, attrs);
    }

    public AppCompatEditText f(Context context, AttributeSet attrs) {
        return new AppCompatEditText(context, attrs);
    }

    public AppCompatSpinner m(Context context, AttributeSet attrs) {
        return new AppCompatSpinner(context, attrs);
    }

    public AppCompatImageButton g(Context context, AttributeSet attrs) {
        return new AppCompatImageButton(context, attrs);
    }

    public AppCompatCheckBox d(Context context, AttributeSet attrs) {
        return new AppCompatCheckBox(context, attrs);
    }

    public AppCompatRadioButton j(Context context, AttributeSet attrs) {
        return new AppCompatRadioButton(context, attrs);
    }

    public AppCompatCheckedTextView e(Context context, AttributeSet attrs) {
        return new AppCompatCheckedTextView(context, attrs);
    }

    public AppCompatAutoCompleteTextView b(Context context, AttributeSet attrs) {
        return new AppCompatAutoCompleteTextView(context, attrs);
    }

    public AppCompatMultiAutoCompleteTextView i(Context context, AttributeSet attrs) {
        return new AppCompatMultiAutoCompleteTextView(context, attrs);
    }

    public AppCompatRatingBar k(Context context, AttributeSet attrs) {
        return new AppCompatRatingBar(context, attrs);
    }

    public AppCompatSeekBar l(Context context, AttributeSet attrs) {
        return new AppCompatSeekBar(context, attrs);
    }

    public AppCompatToggleButton o(Context context, AttributeSet attrs) {
        return new AppCompatToggleButton(context, attrs);
    }

    public final void u(View view, String name) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + name + ">, but returned null");
        }
    }

    public View p(Context context, String name, AttributeSet attrs) {
        return null;
    }

    public final View s(Context context, String name, AttributeSet attrs) {
        if (name.equals("view")) {
            name = attrs.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.e;
            objArr[0] = context;
            objArr[1] = attrs;
            if (-1 != name.indexOf(46)) {
                return r(context, name, null);
            }
            int i = 0;
            while (true) {
                String[] strArr = c;
                if (i >= strArr.length) {
                    return null;
                }
                View view = r(context, name, strArr[i]);
                if (view != null) {
                    return view;
                }
                i++;
            }
        } catch (Exception e) {
            return null;
        } finally {
            Object[] objArr2 = this.e;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    public final void a(View view, AttributeSet attrs) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT >= 15 && !ga.F(view)) {
                return;
            }
            TypedArray a2 = context.obtainStyledAttributes(attrs, b);
            String handlerName = a2.getString(0);
            if (handlerName != null) {
                view.setOnClickListener(new a(view, handlerName));
            }
            a2.recycle();
        }
    }

    public final View r(Context context, String name, String prefix) throws ClassNotFoundException, InflateException {
        String str;
        z3<String, Constructor<? extends View>> z3Var = d;
        Constructor<? extends View> constructor = z3Var.get(name);
        if (constructor == null) {
            if (prefix != null) {
                try {
                    str = prefix + name;
                } catch (Exception e) {
                    return null;
                }
            } else {
                str = name;
            }
            constructor = Class.forName(str, false, context.getClassLoader()).asSubclass(View.class).getConstructor(a);
            z3Var.put(name, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.e);
    }

    public static Context t(Context context, AttributeSet attrs, boolean useAndroidTheme, boolean useAppTheme) {
        TypedArray a2 = context.obtainStyledAttributes(attrs, w.A3, 0, 0);
        int themeId = 0;
        if (useAndroidTheme) {
            themeId = a2.getResourceId(w.B3, 0);
        }
        if (useAppTheme && themeId == 0 && (themeId = a2.getResourceId(w.C3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        a2.recycle();
        if (themeId != 0) {
            if (!(context instanceof t0) || ((t0) context).getThemeResId() != themeId) {
                return new t0(context, themeId);
            }
            return context;
        }
        return context;
    }

    /* compiled from: AppCompatViewInflater.java */
    /* renamed from: d0$a */
    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {
        public final View a;
        public final String b;
        public Method d;
        public Context f;

        public a(View hostView, String methodName) {
            this.a = hostView;
            this.b = methodName;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (this.d == null) {
                a(this.a.getContext());
            }
            try {
                this.d.invoke(this.f, v);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        public final void a(Context context) {
            String idText;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.b, View.class)) != null) {
                        this.d = method;
                        this.f = context;
                        return;
                    }
                } catch (NoSuchMethodException e) {
                }
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    context = null;
                }
            }
            int id = this.a.getId();
            if (id == -1) {
                idText = "";
            } else {
                idText = " with id '" + this.a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.a.getClass() + idText);
        }
    }
}
