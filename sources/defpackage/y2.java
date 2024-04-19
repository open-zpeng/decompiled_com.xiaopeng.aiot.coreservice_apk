package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
/* compiled from: TintResources.java */
/* renamed from: y2  reason: default package */
/* loaded from: classes.dex */
public class y2 extends r2 {
    public final WeakReference<Context> b;

    public y2(Context context, Resources res) {
        super(res);
        this.b = new WeakReference<>(context);
    }

    @Override // defpackage.r2, android.content.res.Resources
    public Drawable getDrawable(int id) throws Resources.NotFoundException {
        Drawable d = super.getDrawable(id);
        Context context = this.b.get();
        if (d != null && context != null) {
            q2.h().x(context, id, d);
        }
        return d;
    }
}
