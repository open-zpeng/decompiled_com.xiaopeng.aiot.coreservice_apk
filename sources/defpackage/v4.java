package defpackage;

import defpackage.x4;
import java.util.ArrayList;
/* compiled from: ChainHead.java */
/* renamed from: v4  reason: default package */
/* loaded from: classes.dex */
public class v4 {
    public x4 a;
    public x4 b;
    public x4 c;
    public x4 d;
    public x4 e;
    public x4 f;
    public x4 g;
    public ArrayList<x4> h;
    public int i;
    public int j;
    public float k = 0.0f;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;

    public v4(x4 first, int orientation, boolean isRtl) {
        this.q = false;
        this.a = first;
        this.p = orientation;
        this.q = isRtl;
    }

    public static boolean c(x4 widget, int orientation) {
        if (widget.S() != 8 && widget.Z[orientation] == x4.b.MATCH_CONSTRAINT) {
            int[] iArr = widget.y;
            if (iArr[orientation] == 0 || iArr[orientation] == 3) {
                return true;
            }
        }
        return false;
    }

    public final void b() {
        x4 next;
        int offset = this.p * 2;
        x4 lastVisited = this.a;
        boolean z = true;
        this.o = true;
        x4 widget = this.a;
        x4 x4Var = this.a;
        boolean done = false;
        while (!done) {
            this.i++;
            x4[] x4VarArr = widget.E0;
            int i = this.p;
            x4VarArr[i] = null;
            widget.D0[i] = null;
            if (widget.S() != 8) {
                this.l++;
                x4.b u = widget.u(this.p);
                x4.b bVar = x4.b.MATCH_CONSTRAINT;
                if (u != bVar) {
                    this.m += widget.E(this.p);
                }
                int f = this.m + widget.W[offset].f();
                this.m = f;
                this.m = f + widget.W[offset + 1].f();
                int f2 = this.n + widget.W[offset].f();
                this.n = f2;
                this.n = f2 + widget.W[offset + 1].f();
                if (this.b == null) {
                    this.b = widget;
                }
                this.d = widget;
                x4.b[] bVarArr = widget.Z;
                int i2 = this.p;
                if (bVarArr[i2] == bVar) {
                    int[] iArr = widget.y;
                    if (iArr[i2] == 0 || iArr[i2] == 3 || iArr[i2] == 2) {
                        this.j++;
                        float[] fArr = widget.C0;
                        float weight = fArr[i2];
                        if (weight > 0.0f) {
                            this.k += fArr[i2];
                        }
                        if (c(widget, i2)) {
                            if (weight < 0.0f) {
                                this.r = true;
                            } else {
                                this.s = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList<>();
                            }
                            this.h.add(widget);
                        }
                        if (this.f == null) {
                            this.f = widget;
                        }
                        x4 x4Var2 = this.g;
                        if (x4Var2 != null) {
                            x4Var2.D0[this.p] = widget;
                        }
                        this.g = widget;
                    }
                    if (this.p == 0) {
                        if (widget.w != 0) {
                            this.o = false;
                        } else if (widget.z != 0 || widget.A != 0) {
                            this.o = false;
                        }
                    } else if (widget.x != 0) {
                        this.o = false;
                    } else if (widget.C != 0 || widget.D != 0) {
                        this.o = false;
                    }
                    if (widget.d0 != 0.0f) {
                        this.o = false;
                        this.u = true;
                    }
                }
            }
            if (lastVisited != widget) {
                lastVisited.E0[this.p] = widget;
            }
            lastVisited = widget;
            w4 nextAnchor = widget.W[offset + 1].f;
            if (nextAnchor != null) {
                next = nextAnchor.d;
                w4[] w4VarArr = next.W;
                if (w4VarArr[offset].f == null || w4VarArr[offset].f.d != widget) {
                    next = null;
                }
            } else {
                next = null;
            }
            if (next != null) {
                widget = next;
            } else {
                done = true;
            }
        }
        x4 x4Var3 = this.b;
        if (x4Var3 != null) {
            this.m -= x4Var3.W[offset].f();
        }
        x4 x4Var4 = this.d;
        if (x4Var4 != null) {
            this.m -= x4Var4.W[offset + 1].f();
        }
        this.c = widget;
        if (this.p == 0 && this.q) {
            this.e = widget;
        } else {
            this.e = this.a;
        }
        if (!this.s || !this.r) {
            z = false;
        }
        this.t = z;
    }

    public void a() {
        if (!this.v) {
            b();
        }
        this.v = true;
    }
}
