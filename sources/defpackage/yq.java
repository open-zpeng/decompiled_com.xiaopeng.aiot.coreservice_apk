package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import defpackage.uq;
/* compiled from: XFontChangeMonitor.java */
/* renamed from: yq  reason: default package */
/* loaded from: classes.dex */
public class yq {
    public Context a;
    public float b;
    public uq.a c;

    public yq(Context context) {
        this.a = context;
        this.b = context.getResources().getConfiguration().fontScale;
    }

    public void d(uq.a onFontChangeCallback) {
        this.c = onFontChangeCallback;
    }

    public void c(Configuration config) {
        a(config);
    }

    public final void a(Configuration config) {
        float f = this.b;
        float f2 = config.fontScale;
        if (f != f2) {
            this.b = f2;
            uq.a aVar = this.c;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    public void b() {
        a(this.a.getResources().getConfiguration());
    }
}
