package defpackage;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: PagerAdapter.java */
/* renamed from: mf  reason: default package */
/* loaded from: classes.dex */
public abstract class mf {
    public final DataSetObservable a = new DataSetObservable();
    public DataSetObserver b;

    public abstract int e();

    public abstract boolean k(View view, Object obj);

    public void s(ViewGroup container) {
        r(container);
    }

    public Object j(ViewGroup container, int position) {
        return i(container, position);
    }

    public void b(ViewGroup container, int position, Object object) {
        a(container, position, object);
    }

    public void p(ViewGroup container, int position, Object object) {
        o(container, position, object);
    }

    public void d(ViewGroup container) {
        c(container);
    }

    @Deprecated
    public void r(View container) {
    }

    @Deprecated
    public Object i(View container, int position) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void a(View container, int position, Object object) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    @Deprecated
    public void o(View container, int position, Object object) {
    }

    @Deprecated
    public void c(View container) {
    }

    public Parcelable n() {
        return null;
    }

    public void m(Parcelable state, ClassLoader loader) {
    }

    public int f(Object object) {
        return -1;
    }

    public void l(DataSetObserver observer) {
        this.a.registerObserver(observer);
    }

    public void t(DataSetObserver observer) {
        this.a.unregisterObserver(observer);
    }

    public void q(DataSetObserver observer) {
        synchronized (this) {
            this.b = observer;
        }
    }

    public CharSequence g(int position) {
        return null;
    }

    public float h(int position) {
        return 1.0f;
    }
}
