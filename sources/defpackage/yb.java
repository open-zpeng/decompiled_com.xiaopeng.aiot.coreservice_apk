package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
/* compiled from: FragmentController.java */
/* renamed from: yb  reason: default package */
/* loaded from: classes.dex */
public class yb {
    public final ac<?> a;

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<?> */
    public static yb b(ac<?> acVar) {
        return new yb((ac) k9.e(acVar, "callbacks == null"));
    }

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<?> */
    public yb(ac<?> acVar) {
        this.a = acVar;
    }

    public dc t() {
        return this.a.g;
    }

    public void a(Fragment parent) {
        ac<?> acVar = this.a;
        acVar.g.j(acVar, acVar, parent);
    }

    public View v(View parent, String name, Context context, AttributeSet attrs) {
        return this.a.g.u0().onCreateView(parent, name, context, attrs);
    }

    public void u() {
        this.a.g.Q0();
    }

    public Parcelable x() {
        return this.a.g.d1();
    }

    public void w(Parcelable state) {
        ac<?> acVar = this.a;
        if (!(acVar instanceof sd)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        acVar.g.b1(state);
    }

    public void f() {
        this.a.g.C();
    }

    public void c() {
        this.a.g.y();
    }

    public void q() {
        this.a.g.R();
    }

    public void p() {
        this.a.g.Q();
    }

    public void m() {
        this.a.g.M();
    }

    public void r() {
        this.a.g.T();
    }

    public void h() {
        this.a.g.E();
    }

    public void j(boolean isInMultiWindowMode) {
        this.a.g.H(isInMultiWindowMode);
    }

    public void n(boolean isInPictureInPictureMode) {
        this.a.g.N(isInPictureInPictureMode);
    }

    public void d(Configuration newConfig) {
        this.a.g.A(newConfig);
    }

    public void i() {
        this.a.g.G();
    }

    public boolean g(Menu menu, MenuInflater inflater) {
        return this.a.g.D(menu, inflater);
    }

    public boolean o(Menu menu) {
        return this.a.g.O(menu);
    }

    public boolean k(MenuItem item) {
        return this.a.g.J(item);
    }

    public boolean e(MenuItem item) {
        return this.a.g.B(item);
    }

    public void l(Menu menu) {
        this.a.g.K(menu);
    }

    public boolean s() {
        return this.a.g.a0(true);
    }
}
