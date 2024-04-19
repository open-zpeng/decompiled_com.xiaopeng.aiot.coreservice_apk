package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: TaskStackBuilder.java */
/* renamed from: l7  reason: default package */
/* loaded from: classes.dex */
public final class l7 implements Iterable<Intent> {
    public final ArrayList<Intent> a = new ArrayList<>();
    public final Context b;

    /* compiled from: TaskStackBuilder.java */
    /* renamed from: l7$a */
    /* loaded from: classes.dex */
    public interface a {
        Intent h();
    }

    public l7(Context a2) {
        this.b = a2;
    }

    public static l7 d(Context context) {
        return new l7(context);
    }

    public l7 a(Intent nextIntent) {
        this.a.add(nextIntent);
        return this;
    }

    public l7 b(Activity sourceActivity) {
        Intent parent = null;
        if (sourceActivity instanceof a) {
            parent = ((a) sourceActivity).h();
        }
        if (parent == null) {
            parent = d7.a(sourceActivity);
        }
        if (parent != null) {
            ComponentName target = parent.getComponent();
            if (target == null) {
                target = parent.resolveActivity(this.b.getPackageManager());
            }
            c(target);
            a(parent);
        }
        return this;
    }

    public l7 c(ComponentName sourceActivityName) {
        int insertAt = this.a.size();
        try {
            Intent parent = d7.b(this.b, sourceActivityName);
            while (parent != null) {
                this.a.add(insertAt, parent);
                parent = d7.b(this.b, parent.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.a.iterator();
    }

    public void e() {
        f(null);
    }

    public void f(Bundle options) {
        if (this.a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.a;
        Intent[] intents = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intents[0] = new Intent(intents[0]).addFlags(268484608);
        if (!m7.g(this.b, intents, options)) {
            Intent topIntent = new Intent(intents[intents.length - 1]);
            topIntent.addFlags(268435456);
            this.b.startActivity(topIntent);
        }
    }
}
