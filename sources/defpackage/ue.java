package defpackage;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;
import defpackage.cd;
/* compiled from: SavedStateRegistryController.java */
/* renamed from: ue  reason: default package */
/* loaded from: classes.dex */
public final class ue {
    public final ve a;
    public final SavedStateRegistry b = new SavedStateRegistry();

    public ue(ve owner) {
        this.a = owner;
    }

    public SavedStateRegistry b() {
        return this.b;
    }

    public void c(Bundle savedState) {
        cd lifecycle = this.a.a();
        if (lifecycle.b() != cd.c.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(this.a));
        this.b.b(lifecycle, savedState);
    }

    public void d(Bundle outBundle) {
        this.b.c(outBundle);
    }

    public static ue a(ve owner) {
        return new ue(owner);
    }
}
