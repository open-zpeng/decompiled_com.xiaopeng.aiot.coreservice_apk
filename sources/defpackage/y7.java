package defpackage;

import android.graphics.Insets;
import android.graphics.Rect;
/* compiled from: Insets.java */
/* renamed from: y7  reason: default package */
/* loaded from: classes.dex */
public final class y7 {
    public static final y7 a = new y7(0, 0, 0, 0);
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public y7(int left, int top, int right, int bottom) {
        this.b = left;
        this.c = top;
        this.d = right;
        this.e = bottom;
    }

    public static y7 b(int left, int top, int right, int bottom) {
        if (left == 0 && top == 0 && right == 0 && bottom == 0) {
            return a;
        }
        return new y7(left, top, right, bottom);
    }

    public static y7 c(Rect r) {
        return b(r.left, r.top, r.right, r.bottom);
    }

    public static y7 a(y7 a2, y7 b) {
        return b(Math.max(a2.b, b.b), Math.max(a2.c, b.c), Math.max(a2.d, b.d), Math.max(a2.e, b.e));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        y7 insets = (y7) o;
        if (this.e == insets.e && this.b == insets.b && this.d == insets.d && this.c == insets.c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = this.b;
        return (((((result * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        return "Insets{left=" + this.b + ", top=" + this.c + ", right=" + this.d + ", bottom=" + this.e + '}';
    }

    public Insets d() {
        return Insets.of(this.b, this.c, this.d, this.e);
    }
}
