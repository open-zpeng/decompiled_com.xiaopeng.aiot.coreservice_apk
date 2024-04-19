package defpackage;
/* compiled from: Pair.java */
/* renamed from: g9  reason: default package */
/* loaded from: classes.dex */
public class g9<F, S> {
    public final F a;
    public final S b;

    /* JADX WARN: Generic types in debug info not equals: g9 != androidx.core.util.Pair<F, S> */
    public g9(F first, S second) {
        this.a = first;
        this.b = second;
    }

    /* JADX WARN: Generic types in debug info not equals: g9 != androidx.core.util.Pair<?, ?> */
    /* JADX WARN: Generic types in debug info not equals: g9 != androidx.core.util.Pair<F, S> */
    public boolean equals(Object o) {
        if (o instanceof g9) {
            g9 g9Var = (g9) o;
            return f9.a(g9Var.a, this.a) && f9.a(g9Var.b, this.b);
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: g9 != androidx.core.util.Pair<F, S> */
    public int hashCode() {
        F f = this.a;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.b;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    /* JADX WARN: Generic types in debug info not equals: g9 != androidx.core.util.Pair<F, S> */
    public String toString() {
        return "Pair{" + this.a + " " + this.b + "}";
    }
}
