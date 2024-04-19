package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
/* compiled from: FragmentHostCallback.java */
/* renamed from: ac  reason: default package */
/* loaded from: classes.dex */
public abstract class ac<E> extends xb {
    public final Activity a;
    public final Context b;
    public final Handler d;
    public final int f;
    public final dc g;

    public abstract E m();

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<E> */
    public ac(FragmentActivity activity) {
        this(activity, activity, new Handler(), 0);
    }

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<E> */
    public ac(Activity activity, Context context, Handler handler, int windowAnimations) {
        this.g = new ec();
        this.a = activity;
        this.b = (Context) k9.e(context, "context == null");
        this.d = (Handler) k9.e(handler, "handler == null");
        this.f = windowAnimations;
    }

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<E> */
    public boolean o(Fragment fragment) {
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<E> */
    public LayoutInflater n() {
        return LayoutInflater.from(this.b);
    }

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<E> */
    public void p() {
    }

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<E> */
    @Override // defpackage.xb
    public View f(int id) {
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<E> */
    @Override // defpackage.xb
    public boolean h() {
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<E> */
    public Activity j() {
        return this.a;
    }

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<E> */
    public Context k() {
        return this.b;
    }

    /* JADX WARN: Generic types in debug info not equals: ac != androidx.fragment.app.FragmentHostCallback<E> */
    public Handler l() {
        return this.d;
    }
}
