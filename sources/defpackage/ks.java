package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: CompositeDisposable.java */
/* renamed from: ks  reason: default package */
/* loaded from: classes.dex */
public final class ks implements ls, dt {
    public ev<ls> a;
    public volatile boolean b;

    /* JADX WARN: Generic types in debug info not equals: ev != io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> */
    @Override // defpackage.ls
    public void a() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            ev<ls> evVar = this.a;
            this.a = null;
            e(evVar);
        }
    }

    public boolean f() {
        return this.b;
    }

    /* JADX WARN: Generic types in debug info not equals: ev != io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> */
    @Override // defpackage.dt
    public boolean d(ls d) {
        kt.d(d, "d is null");
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    ev<ls> evVar = this.a;
                    if (evVar == null) {
                        evVar = new ev<>();
                        this.a = evVar;
                    }
                    evVar.a(d);
                    return true;
                }
            }
        }
        d.a();
        return false;
    }

    @Override // defpackage.dt
    public boolean c(ls d) {
        if (b(d)) {
            d.a();
            return true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: ev != io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> */
    @Override // defpackage.dt
    public boolean b(ls d) {
        kt.d(d, "Disposable item is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            if (this.b) {
                return false;
            }
            ev<ls> evVar = this.a;
            if (evVar != null && evVar.e(d)) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: ev != io.reactivex.internal.util.OpenHashSet<io.reactivex.disposables.Disposable> */
    public void e(ev<ls> evVar) {
        if (evVar == null) {
            return;
        }
        List<Throwable> errors = null;
        Object[] array = evVar.b();
        for (Object o : array) {
            if (o instanceof ls) {
                try {
                    ((ls) o).a();
                } catch (Throwable ex) {
                    qs.b(ex);
                    if (errors == null) {
                        errors = new ArrayList<>();
                    }
                    errors.add(ex);
                }
            }
        }
        if (errors != null) {
            if (errors.size() == 1) {
                throw cv.d(errors.get(0));
            }
            throw new ps(errors);
        }
    }
}
