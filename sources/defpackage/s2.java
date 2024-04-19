package defpackage;

import com.lzy.okgo.model.Priority;
/* compiled from: RtlSpacingHelper.java */
/* renamed from: s2  reason: default package */
/* loaded from: classes.dex */
public class s2 {
    public int a = 0;
    public int b = 0;
    public int c = Priority.BG_LOW;
    public int d = Priority.BG_LOW;
    public int e = 0;
    public int f = 0;
    public boolean g = false;
    public boolean h = false;

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.g ? this.b : this.a;
    }

    public int a() {
        return this.g ? this.a : this.b;
    }

    public void g(int start, int end) {
        this.c = start;
        this.d = end;
        this.h = true;
        if (this.g) {
            if (end != Integer.MIN_VALUE) {
                this.a = end;
            }
            if (start != Integer.MIN_VALUE) {
                this.b = start;
                return;
            }
            return;
        }
        if (start != Integer.MIN_VALUE) {
            this.a = start;
        }
        if (end != Integer.MIN_VALUE) {
            this.b = end;
        }
    }

    public void e(int left, int right) {
        this.h = false;
        if (left != Integer.MIN_VALUE) {
            this.e = left;
            this.a = left;
        }
        if (right != Integer.MIN_VALUE) {
            this.f = right;
            this.b = right;
        }
    }

    public void f(boolean isRtl) {
        if (isRtl == this.g) {
            return;
        }
        this.g = isRtl;
        if (!this.h) {
            this.a = this.e;
            this.b = this.f;
        } else if (isRtl) {
            int i = this.d;
            if (i == Integer.MIN_VALUE) {
                i = this.e;
            }
            this.a = i;
            int i2 = this.c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f;
            }
            this.b = i2;
        } else {
            int i3 = this.c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.e;
            }
            this.a = i3;
            int i4 = this.d;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f;
            }
            this.b = i4;
        }
    }
}
