package defpackage;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: KeyEventDispatcher.java */
/* renamed from: q9  reason: default package */
/* loaded from: classes.dex */
public class q9 {
    public static boolean a = false;
    public static Method b = null;
    public static boolean c = false;
    public static Field d = null;

    /* compiled from: KeyEventDispatcher.java */
    /* renamed from: q9$a */
    /* loaded from: classes.dex */
    public interface a {
        boolean d(KeyEvent keyEvent);
    }

    public static boolean d(View root, KeyEvent event) {
        return ga.h(root, event);
    }

    public static boolean e(a component, View root, Window.Callback callback, KeyEvent event) {
        if (component == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return component.d(event);
        }
        if (callback instanceof Activity) {
            return b((Activity) callback, event);
        }
        if (callback instanceof Dialog) {
            return c((Dialog) callback, event);
        }
        return (root != null && ga.g(root, event)) || component.d(event);
    }

    public static boolean a(ActionBar actionBar, KeyEvent event) {
        if (!a) {
            try {
                b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException e) {
            }
            a = true;
        }
        Method method = b;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(actionBar, event)).booleanValue();
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
        }
        return false;
    }

    public static boolean b(Activity activity, KeyEvent event) {
        activity.onUserInteraction();
        Window win = activity.getWindow();
        if (win.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            int keyCode = event.getKeyCode();
            if (keyCode == 82 && actionBar != null && a(actionBar, event)) {
                return true;
            }
        }
        if (win.superDispatchKeyEvent(event)) {
            return true;
        }
        View decor = win.getDecorView();
        if (ga.g(decor, event)) {
            return true;
        }
        return event.dispatch(activity, decor != null ? decor.getKeyDispatcherState() : null, activity);
    }

    public static DialogInterface.OnKeyListener f(Dialog dialog) {
        if (!c) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            c = true;
        }
        Field field = d;
        if (field != null) {
            try {
                return (DialogInterface.OnKeyListener) field.get(dialog);
            } catch (IllegalAccessException e2) {
                return null;
            }
        }
        return null;
    }

    public static boolean c(Dialog dialog, KeyEvent event) {
        DialogInterface.OnKeyListener onKeyListener = f(dialog);
        if (onKeyListener != null && onKeyListener.onKey(dialog, event.getKeyCode(), event)) {
            return true;
        }
        Window win = dialog.getWindow();
        if (win.superDispatchKeyEvent(event)) {
            return true;
        }
        View decor = win.getDecorView();
        if (ga.g(decor, event)) {
            return true;
        }
        return event.dispatch(dialog, decor != null ? decor.getKeyDispatcherState() : null, dialog);
    }
}
