package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: WidgetGroup.java */
/* renamed from: u5  reason: default package */
/* loaded from: classes.dex */
public class u5 {
    public static int a = 0;
    public int c;
    public int e;
    public ArrayList<x4> b = new ArrayList<>();
    public boolean d = false;
    public ArrayList<a> f = null;
    public int g = -1;

    public u5(int orientation) {
        this.c = -1;
        this.e = 0;
        int i = a;
        a = i + 1;
        this.c = i;
        this.e = orientation;
    }

    public int d() {
        return this.e;
    }

    public int c() {
        return this.c;
    }

    public boolean a(x4 widget) {
        if (this.b.contains(widget)) {
            return false;
        }
        this.b.add(widget);
        return true;
    }

    public void h(boolean isAuthoritative) {
        this.d = isAuthoritative;
    }

    public final String e() {
        int i = this.e;
        if (i == 0) {
            return "Horizontal";
        }
        if (i == 1) {
            return "Vertical";
        }
        if (i == 2) {
            return "Both";
        }
        return "Unknown";
    }

    public String toString() {
        String ret = e() + " [" + this.c + "] <";
        Iterator<x4> it = this.b.iterator();
        while (it.hasNext()) {
            x4 widget = it.next();
            ret = ret + " " + widget.t();
        }
        return ret + " >";
    }

    public void g(int orientation, u5 widgetGroup) {
        Iterator<x4> it = this.b.iterator();
        while (it.hasNext()) {
            x4 widget = it.next();
            widgetGroup.a(widget);
            if (orientation == 0) {
                widget.H0 = widgetGroup.c();
            } else {
                widget.I0 = widgetGroup.c();
            }
        }
        this.g = widgetGroup.c;
    }

    public int f(e4 system, int orientation) {
        int count = this.b.size();
        if (count == 0) {
            return 0;
        }
        return j(system, this.b, orientation);
    }

    public final int j(e4 system, ArrayList<x4> arrayList, int orientation) {
        y4 container = (y4) arrayList.get(0).K();
        system.D();
        container.g(system, false);
        for (int i = 0; i < arrayList.size(); i++) {
            x4 widget = arrayList.get(i);
            widget.g(system, false);
        }
        if (orientation == 0 && container.W0 > 0) {
            u4.b(container, system, arrayList, 0);
        }
        if (orientation == 1 && container.X0 > 0) {
            u4.b(container, system, arrayList, 1);
        }
        try {
            system.z();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            x4 widget2 = arrayList.get(i2);
            a result = new a(widget2, system, orientation);
            this.f.add(result);
        }
        if (orientation == 0) {
            int left = system.x(container.O);
            int right = system.x(container.Q);
            system.D();
            return right - left;
        }
        int top = system.x(container.P);
        int bottom = system.x(container.R);
        system.D();
        return bottom - top;
    }

    public void i(int orientation) {
        this.e = orientation;
    }

    public void b(ArrayList<u5> arrayList) {
        int count = this.b.size();
        if (this.g != -1 && count > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                u5 group = arrayList.get(i);
                if (this.g == group.c) {
                    g(this.e, group);
                }
            }
        }
        if (count == 0) {
            arrayList.remove(this);
        }
    }

    /* compiled from: WidgetGroup.java */
    /* renamed from: u5$a */
    /* loaded from: classes.dex */
    public class a {
        public WeakReference<x4> a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public a(x4 widget, e4 system, int orientation) {
            this.a = new WeakReference<>(widget);
            this.b = system.x(widget.O);
            this.c = system.x(widget.P);
            this.d = system.x(widget.Q);
            this.e = system.x(widget.R);
            this.f = system.x(widget.S);
            this.g = orientation;
        }
    }
}
