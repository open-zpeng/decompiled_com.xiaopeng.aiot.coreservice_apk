package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
/* compiled from: ContextThemeWrapper.java */
/* renamed from: t0  reason: default package */
/* loaded from: classes.dex */
public class t0 extends ContextWrapper {
    public int a;
    public Resources.Theme b;
    public LayoutInflater c;
    public Configuration d;
    public Resources e;

    public t0() {
        super(null);
    }

    public t0(Context base, int themeResId) {
        super(base);
        this.a = themeResId;
    }

    public t0(Context base, Resources.Theme theme) {
        super(base);
        this.b = theme;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    public void a(Configuration overrideConfiguration) {
        if (this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.d = new Configuration(overrideConfiguration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    public final Resources b() {
        if (this.e == null) {
            Configuration configuration = this.d;
            if (configuration == null) {
                this.e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                Context resContext = createConfigurationContext(configuration);
                this.e = resContext.getResources();
            } else {
                Resources res = super.getResources();
                Configuration newConfig = new Configuration(res.getConfiguration());
                newConfig.updateFrom(this.d);
                this.e = new Resources(res.getAssets(), res.getDisplayMetrics(), newConfig);
            }
        }
        return this.e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int resid) {
        if (this.a != resid) {
            this.a = resid;
            c();
        }
    }

    public int getThemeResId() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = v.d;
        }
        c();
        return this.b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        if ("layout_inflater".equals(name)) {
            if (this.c == null) {
                this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.c;
        }
        return getBaseContext().getSystemService(name);
    }

    public void d(Resources.Theme theme, int resid, boolean first) {
        theme.applyStyle(resid, true);
    }

    public final void c() {
        boolean first = this.b == null;
        if (first) {
            this.b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        d(this.b, this.a, first);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
