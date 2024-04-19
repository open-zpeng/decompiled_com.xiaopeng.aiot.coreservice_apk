package defpackage;
/* compiled from: DisplayCutoutCompat.java */
/* renamed from: o9  reason: default package */
/* loaded from: classes.dex */
public final class o9 {
    public final Object a;

    public o9(Object displayCutout) {
        this.a = displayCutout;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        o9 other = (o9) o;
        return f9.a(this.a, other.a);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.a + "}";
    }

    public static o9 a(Object displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new o9(displayCutout);
    }
}
