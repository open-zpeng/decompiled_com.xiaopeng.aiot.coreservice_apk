package defpackage;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* compiled from: ContextAwareHelper.java */
/* renamed from: d  reason: default package */
/* loaded from: classes.dex */
public final class d {
    public final Set<e> a = new CopyOnWriteArraySet();
    public volatile Context b;

    public void a(e listener) {
        if (this.b != null) {
            listener.a(this.b);
        }
        this.a.add(listener);
    }

    public void c(Context context) {
        this.b = context;
        for (e listener : this.a) {
            listener.a(context);
        }
    }

    public void b() {
        this.b = null;
    }
}
