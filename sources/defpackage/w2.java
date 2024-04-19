package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* compiled from: TintContextWrapper.java */
/* renamed from: w2  reason: default package */
/* loaded from: classes.dex */
public class w2 extends ContextWrapper {
    public static final Object a = new Object();
    public static ArrayList<WeakReference<w2>> b;
    public final Resources c;
    public final Resources.Theme d;

    public static Context b(Context context) {
        if (a(context)) {
            synchronized (a) {
                ArrayList<WeakReference<w2>> arrayList = b;
                if (arrayList == null) {
                    b = new ArrayList<>();
                } else {
                    for (int i = arrayList.size() - 1; i >= 0; i--) {
                        WeakReference<w2> weakReference = b.get(i);
                        if (weakReference == null || weakReference.get() == null) {
                            b.remove(i);
                        }
                    }
                    for (int i2 = b.size() - 1; i2 >= 0; i2--) {
                        WeakReference<w2> weakReference2 = b.get(i2);
                        w2 wrapper = weakReference2 != null ? weakReference2.get() : null;
                        if (wrapper != null && wrapper.getBaseContext() == context) {
                            return wrapper;
                        }
                    }
                }
                w2 wrapper2 = new w2(context);
                b.add(new WeakReference<>(wrapper2));
                return wrapper2;
            }
        }
        return context;
    }

    public static boolean a(Context context) {
        if ((context instanceof w2) || (context.getResources() instanceof y2) || (context.getResources() instanceof e3)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || e3.b();
    }

    public w2(Context base) {
        super(base);
        if (e3.b()) {
            e3 e3Var = new e3(this, base.getResources());
            this.c = e3Var;
            Resources.Theme newTheme = e3Var.newTheme();
            this.d = newTheme;
            newTheme.setTo(base.getTheme());
            return;
        }
        this.c = new y2(this, base.getResources());
        this.d = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.d;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int resid) {
        Resources.Theme theme = this.d;
        if (theme == null) {
            super.setTheme(resid);
        } else {
            theme.applyStyle(resid, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.c.getAssets();
    }
}
