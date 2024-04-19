package defpackage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.savedstate.SavedStateRegistry;
import defpackage.cd;
/* compiled from: FragmentViewLifecycleOwner.java */
/* renamed from: qc  reason: default package */
/* loaded from: classes.dex */
public class qc implements ve, sd {
    public final Fragment a;
    public final rd b;
    public gd d = null;
    public ue f = null;

    public qc(Fragment fragment, rd viewModelStore) {
        this.a = fragment;
        this.b = viewModelStore;
    }

    @Override // defpackage.sd
    public rd i() {
        e();
        return this.b;
    }

    public void e() {
        if (this.d == null) {
            this.d = new gd(this);
            this.f = ue.a(this);
        }
    }

    public boolean f() {
        return this.d != null;
    }

    @Override // defpackage.fd
    public cd a() {
        e();
        return this.d;
    }

    public void j(cd.c state) {
        this.d.o(state);
    }

    public void d(cd.b event) {
        this.d.h(event);
    }

    @Override // defpackage.ve
    public SavedStateRegistry c() {
        e();
        return this.f.b();
    }

    public void g(Bundle savedState) {
        this.f.c(savedState);
    }

    public void h(Bundle outBundle) {
        this.f.d(outBundle);
    }
}
