package defpackage;

import com.lzy.okgo.model.Priority;
import defpackage.j4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: ConstraintAnchor.java */
/* renamed from: w4  reason: default package */
/* loaded from: classes.dex */
public class w4 {
    public int b;
    public boolean c;
    public final x4 d;
    public final b e;
    public w4 f;
    public j4 i;
    public HashSet<w4> a = null;
    public int g = 0;
    public int h = Priority.BG_LOW;

    /* compiled from: ConstraintAnchor.java */
    /* renamed from: w4$b */
    /* loaded from: classes.dex */
    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public void c(int orientation, ArrayList<u5> arrayList, u5 group) {
        HashSet<w4> hashSet = this.a;
        if (hashSet != null) {
            Iterator<w4> it = hashSet.iterator();
            while (it.hasNext()) {
                w4 anchor = it.next();
                o5.a(anchor.d, orientation, arrayList, group);
            }
        }
    }

    public HashSet<w4> d() {
        return this.a;
    }

    public boolean m() {
        HashSet<w4> hashSet = this.a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean l() {
        HashSet<w4> hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator<w4> it = hashSet.iterator();
        while (it.hasNext()) {
            w4 anchor = it.next();
            w4 opposite = anchor.g();
            if (opposite.o()) {
                return true;
            }
        }
        return false;
    }

    public void t(int finalValue) {
        this.b = finalValue;
        this.c = true;
    }

    public int e() {
        if (!this.c) {
            return 0;
        }
        return this.b;
    }

    public void r() {
        this.c = false;
        this.b = 0;
    }

    public boolean n() {
        return this.c;
    }

    public w4(x4 owner, b type) {
        this.d = owner;
        this.e = type;
    }

    public j4 i() {
        return this.i;
    }

    public void s(d4 cache) {
        j4 j4Var = this.i;
        if (j4Var == null) {
            this.i = new j4(j4.a.UNRESTRICTED, null);
        } else {
            j4Var.e();
        }
    }

    public x4 h() {
        return this.d;
    }

    public b k() {
        return this.e;
    }

    public int f() {
        w4 w4Var;
        if (this.d.S() == 8) {
            return 0;
        }
        if (this.h != Integer.MIN_VALUE && (w4Var = this.f) != null && w4Var.d.S() == 8) {
            return this.h;
        }
        return this.g;
    }

    public w4 j() {
        return this.f;
    }

    public void q() {
        HashSet<w4> hashSet;
        w4 w4Var = this.f;
        if (w4Var != null && (hashSet = w4Var.a) != null) {
            hashSet.remove(this);
            if (this.f.a.size() == 0) {
                this.f.a = null;
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = Priority.BG_LOW;
        this.c = false;
        this.b = 0;
    }

    public boolean b(w4 toAnchor, int margin, int goneMargin, boolean forceConnection) {
        if (toAnchor == null) {
            q();
            return true;
        } else if (!forceConnection && !p(toAnchor)) {
            return false;
        } else {
            this.f = toAnchor;
            if (toAnchor.a == null) {
                toAnchor.a = new HashSet<>();
            }
            HashSet<w4> hashSet = this.f.a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.g = margin;
            this.h = goneMargin;
            return true;
        }
    }

    public boolean a(w4 toAnchor, int margin) {
        return b(toAnchor, margin, Priority.BG_LOW, false);
    }

    public boolean o() {
        return this.f != null;
    }

    public boolean p(w4 anchor) {
        boolean isCompatible = false;
        if (anchor == null) {
            return false;
        }
        b target = anchor.k();
        b bVar = this.e;
        if (target == bVar) {
            return bVar != b.BASELINE || (anchor.h().W() && h().W());
        }
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return (target == b.BASELINE || target == b.CENTER_X || target == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean isCompatible2 = target == b.LEFT || target == b.RIGHT;
                if (anchor.h() instanceof a5) {
                    if (isCompatible2 || target == b.CENTER_X) {
                        isCompatible = true;
                    }
                    return isCompatible;
                }
                return isCompatible2;
            case 4:
            case 5:
                boolean isCompatible3 = target == b.TOP || target == b.BOTTOM;
                if (anchor.h() instanceof a5) {
                    if (isCompatible3 || target == b.CENTER_Y) {
                        isCompatible = true;
                    }
                    return isCompatible;
                }
                return isCompatible3;
            case 6:
                return (target == b.LEFT || target == b.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.e.name());
        }
    }

    /* compiled from: ConstraintAnchor.java */
    /* renamed from: w4$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public void u(int margin) {
        if (o()) {
            this.h = margin;
        }
    }

    public String toString() {
        return this.d.t() + ":" + this.e.toString();
    }

    public final w4 g() {
        switch (a.a[this.e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.d.Q;
            case 3:
                return this.d.O;
            case 4:
                return this.d.R;
            case 5:
                return this.d.P;
            default:
                throw new AssertionError(this.e.name());
        }
    }
}
