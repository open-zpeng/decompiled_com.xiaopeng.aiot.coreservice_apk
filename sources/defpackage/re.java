package defpackage;

import android.view.View;
/* compiled from: ViewBoundsCheck.java */
/* renamed from: re  reason: default package */
/* loaded from: classes.dex */
public class re {
    public final b a;
    public a b = new a();

    /* compiled from: ViewBoundsCheck.java */
    /* renamed from: re$b */
    /* loaded from: classes.dex */
    public interface b {
        int a();

        int b(View view);

        View c(int i);

        int d();

        int e(View view);
    }

    public re(b callback) {
        this.a = callback;
    }

    /* compiled from: ViewBoundsCheck.java */
    /* renamed from: re$a */
    /* loaded from: classes.dex */
    public static class a {
        public int a = 0;
        public int b;
        public int c;
        public int d;
        public int e;

        public void e(int rvStart, int rvEnd, int childStart, int childEnd) {
            this.b = rvStart;
            this.c = rvEnd;
            this.d = childStart;
            this.e = childEnd;
        }

        public void a(int flags) {
            this.a |= flags;
        }

        public void d() {
            this.a = 0;
        }

        public int c(int x, int y) {
            if (x > y) {
                return 1;
            }
            if (x == y) {
                return 2;
            }
            return 4;
        }

        public boolean b() {
            int i = this.a;
            if ((i & 7) == 0 || (i & (c(this.d, this.b) << 0)) != 0) {
                int i2 = this.a;
                if ((i2 & 112) == 0 || (i2 & (c(this.d, this.c) << 4)) != 0) {
                    int i3 = this.a;
                    if ((i3 & 1792) == 0 || (i3 & (c(this.e, this.b) << 8)) != 0) {
                        int i4 = this.a;
                        return (i4 & 28672) == 0 || (i4 & (c(this.e, this.c) << 12)) != 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    public View a(int fromIndex, int toIndex, int preferredBoundFlags, int acceptableBoundFlags) {
        int start = this.a.d();
        int end = this.a.a();
        int next = toIndex > fromIndex ? 1 : -1;
        View acceptableMatch = null;
        for (int i = fromIndex; i != toIndex; i += next) {
            View child = this.a.c(i);
            int childStart = this.a.b(child);
            int childEnd = this.a.e(child);
            this.b.e(start, end, childStart, childEnd);
            if (preferredBoundFlags != 0) {
                this.b.d();
                this.b.a(preferredBoundFlags);
                if (this.b.b()) {
                    return child;
                }
            }
            if (acceptableBoundFlags != 0) {
                this.b.d();
                this.b.a(acceptableBoundFlags);
                if (this.b.b()) {
                    acceptableMatch = child;
                }
            }
        }
        return acceptableMatch;
    }

    public boolean b(View child, int boundsFlags) {
        this.b.e(this.a.d(), this.a.a(), this.a.b(child), this.a.e(child));
        if (boundsFlags != 0) {
            this.b.d();
            this.b.a(boundsFlags);
            return this.b.b();
        }
        return false;
    }
}
