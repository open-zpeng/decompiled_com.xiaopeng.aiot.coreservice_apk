package defpackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* compiled from: ListCompositeDisposable.java */
/* renamed from: gt  reason: default package */
/* loaded from: classes.dex */
public final class gt implements ls, dt {
    public List<ls> a;
    public volatile boolean b;

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
            List<ls> list = this.a;
            this.a = null;
            e(list);
        }
    }

    @Override // defpackage.dt
    public boolean d(ls d) {
        kt.d(d, "d is null");
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    List<ls> list = this.a;
                    if (list == null) {
                        list = new LinkedList();
                        this.a = list;
                    }
                    list.add(d);
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
            List<ls> list = this.a;
            if (list != null && list.remove(d)) {
                return true;
            }
            return false;
        }
    }

    public void e(List<ls> list) {
        if (list == null) {
            return;
        }
        List<Throwable> errors = null;
        for (ls o : list) {
            try {
                o.a();
            } catch (Throwable ex) {
                qs.b(ex);
                if (errors == null) {
                    errors = new ArrayList<>();
                }
                errors.add(ex);
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
