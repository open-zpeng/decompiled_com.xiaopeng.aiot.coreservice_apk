package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;
/* compiled from: VectorEnabledTintResources.java */
/* renamed from: e3  reason: default package */
/* loaded from: classes.dex */
public class e3 extends Resources {
    public static boolean a = false;
    public final WeakReference<Context> b;

    public static boolean b() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    public e3(Context context, Resources res) {
        super(res.getAssets(), res.getDisplayMetrics(), res.getConfiguration());
        this.b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int id) throws Resources.NotFoundException {
        Context context = this.b.get();
        if (context != null) {
            return q2.h().t(context, this, id);
        }
        return super.getDrawable(id);
    }

    public final Drawable c(int id) {
        return super.getDrawable(id);
    }

    public static boolean a() {
        return a;
    }
}
