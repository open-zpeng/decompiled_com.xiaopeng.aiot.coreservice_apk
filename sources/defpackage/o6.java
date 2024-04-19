package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.Guideline;
import com.lzy.okgo.model.Priority;
import com.xiaopeng.base.log.LogUtils;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ConstraintSet.java */
/* renamed from: o6  reason: default package */
/* loaded from: classes.dex */
public class o6 {
    public static final int[] a = {0, 4, 8};
    public static SparseIntArray b = new SparseIntArray();
    public static SparseIntArray c = new SparseIntArray();
    public String d = "";
    public int e = 0;
    public HashMap<String, m6> f = new HashMap<>();
    public boolean g = true;
    public HashMap<Integer, a> h = new HashMap<>();

    static {
        b.append(r6.z0, 25);
        b.append(r6.A0, 26);
        b.append(r6.C0, 29);
        b.append(r6.D0, 30);
        b.append(r6.J0, 36);
        b.append(r6.I0, 35);
        b.append(r6.g0, 4);
        b.append(r6.f0, 3);
        b.append(r6.b0, 1);
        b.append(r6.d0, 91);
        b.append(r6.c0, 92);
        b.append(r6.S0, 6);
        b.append(r6.T0, 7);
        b.append(r6.n0, 17);
        b.append(r6.o0, 18);
        b.append(r6.p0, 19);
        b.append(r6.u, 27);
        b.append(r6.E0, 32);
        b.append(r6.F0, 33);
        b.append(r6.m0, 10);
        b.append(r6.l0, 9);
        b.append(r6.W0, 13);
        b.append(r6.Z0, 16);
        b.append(r6.X0, 14);
        b.append(r6.U0, 11);
        b.append(r6.Y0, 15);
        b.append(r6.V0, 12);
        b.append(r6.M0, 40);
        b.append(r6.x0, 39);
        b.append(r6.w0, 41);
        b.append(r6.L0, 42);
        b.append(r6.v0, 20);
        b.append(r6.K0, 37);
        b.append(r6.k0, 5);
        b.append(r6.y0, 87);
        b.append(r6.H0, 87);
        b.append(r6.B0, 87);
        b.append(r6.e0, 87);
        b.append(r6.a0, 87);
        b.append(r6.z, 24);
        b.append(r6.B, 28);
        b.append(r6.N, 31);
        b.append(r6.O, 8);
        b.append(r6.A, 34);
        b.append(r6.C, 2);
        b.append(r6.x, 23);
        b.append(r6.y, 21);
        b.append(r6.N0, 95);
        b.append(r6.q0, 96);
        b.append(r6.w, 22);
        b.append(r6.D, 43);
        b.append(r6.Q, 44);
        b.append(r6.L, 45);
        b.append(r6.M, 46);
        b.append(r6.K, 60);
        b.append(r6.I, 47);
        b.append(r6.J, 48);
        b.append(r6.E, 49);
        b.append(r6.F, 50);
        b.append(r6.G, 51);
        b.append(r6.H, 52);
        b.append(r6.P, 53);
        b.append(r6.O0, 54);
        b.append(r6.r0, 55);
        b.append(r6.P0, 56);
        b.append(r6.s0, 57);
        b.append(r6.Q0, 58);
        b.append(r6.t0, 59);
        b.append(r6.h0, 61);
        b.append(r6.j0, 62);
        b.append(r6.i0, 63);
        b.append(r6.R, 64);
        b.append(r6.j1, 65);
        b.append(r6.X, 66);
        b.append(r6.k1, 67);
        b.append(r6.c1, 79);
        b.append(r6.v, 38);
        b.append(r6.b1, 68);
        b.append(r6.R0, 69);
        b.append(r6.u0, 70);
        b.append(r6.a1, 97);
        b.append(r6.V, 71);
        b.append(r6.T, 72);
        b.append(r6.U, 73);
        b.append(r6.W, 74);
        b.append(r6.S, 75);
        b.append(r6.d1, 76);
        b.append(r6.G0, 77);
        b.append(r6.l1, 78);
        b.append(r6.Z, 80);
        b.append(r6.Y, 81);
        b.append(r6.e1, 82);
        b.append(r6.i1, 83);
        b.append(r6.h1, 84);
        b.append(r6.g1, 85);
        b.append(r6.f1, 86);
        SparseIntArray sparseIntArray = c;
        int i = r6.t4;
        sparseIntArray.append(i, 6);
        c.append(i, 7);
        c.append(r6.o3, 27);
        c.append(r6.w4, 13);
        c.append(r6.z4, 16);
        c.append(r6.x4, 14);
        c.append(r6.u4, 11);
        c.append(r6.y4, 15);
        c.append(r6.v4, 12);
        c.append(r6.n4, 40);
        c.append(r6.g4, 39);
        c.append(r6.f4, 41);
        c.append(r6.m4, 42);
        c.append(r6.e4, 20);
        c.append(r6.l4, 37);
        c.append(r6.Y3, 5);
        c.append(r6.h4, 87);
        c.append(r6.k4, 87);
        c.append(r6.i4, 87);
        c.append(r6.V3, 87);
        c.append(r6.U3, 87);
        c.append(r6.t3, 24);
        c.append(r6.v3, 28);
        c.append(r6.H3, 31);
        c.append(r6.I3, 8);
        c.append(r6.u3, 34);
        c.append(r6.w3, 2);
        c.append(r6.r3, 23);
        c.append(r6.s3, 21);
        c.append(r6.o4, 95);
        c.append(r6.Z3, 96);
        c.append(r6.q3, 22);
        c.append(r6.x3, 43);
        c.append(r6.K3, 44);
        c.append(r6.F3, 45);
        c.append(r6.G3, 46);
        c.append(r6.E3, 60);
        c.append(r6.C3, 47);
        c.append(r6.D3, 48);
        c.append(r6.y3, 49);
        c.append(r6.z3, 50);
        c.append(r6.A3, 51);
        c.append(r6.B3, 52);
        c.append(r6.J3, 53);
        c.append(r6.p4, 54);
        c.append(r6.a4, 55);
        c.append(r6.q4, 56);
        c.append(r6.b4, 57);
        c.append(r6.r4, 58);
        c.append(r6.c4, 59);
        c.append(r6.X3, 62);
        c.append(r6.W3, 63);
        c.append(r6.L3, 64);
        c.append(r6.K4, 65);
        c.append(r6.R3, 66);
        c.append(r6.L4, 67);
        c.append(r6.C4, 79);
        c.append(r6.p3, 38);
        c.append(r6.D4, 98);
        c.append(r6.B4, 68);
        c.append(r6.s4, 69);
        c.append(r6.d4, 70);
        c.append(r6.P3, 71);
        c.append(r6.N3, 72);
        c.append(r6.O3, 73);
        c.append(r6.Q3, 74);
        c.append(r6.M3, 75);
        c.append(r6.E4, 76);
        c.append(r6.j4, 77);
        c.append(r6.M4, 78);
        c.append(r6.T3, 80);
        c.append(r6.S3, 81);
        c.append(r6.F4, 82);
        c.append(r6.J4, 83);
        c.append(r6.I4, 84);
        c.append(r6.H4, 85);
        c.append(r6.G4, 86);
        c.append(r6.A4, 97);
    }

    public static void n(Object data, TypedArray a2, int attr, int orientation) {
        if (data == null) {
            return;
        }
        TypedValue v = a2.peekValue(attr);
        int type = v.type;
        int finalValue = 0;
        boolean finalConstrained = false;
        switch (type) {
            case 3:
                o(data, a2.getString(attr), orientation);
                return;
            case 4:
            default:
                int value = a2.getInt(attr, 0);
                switch (value) {
                    case -4:
                        finalValue = -2;
                        finalConstrained = true;
                        break;
                    case -3:
                        finalValue = 0;
                        break;
                    case -2:
                    case -1:
                        finalValue = value;
                        break;
                }
            case 5:
                finalValue = a2.getDimensionPixelSize(attr, 0);
                break;
        }
        if (data instanceof ConstraintLayout.b) {
            ConstraintLayout.b params = (ConstraintLayout.b) data;
            if (orientation == 0) {
                ((ViewGroup.MarginLayoutParams) params).width = finalValue;
                params.Z = finalConstrained;
                return;
            }
            ((ViewGroup.MarginLayoutParams) params).height = finalValue;
            params.a0 = finalConstrained;
        } else if (data instanceof b) {
            b params2 = (b) data;
            if (orientation == 0) {
                params2.e = finalValue;
                params2.n0 = finalConstrained;
                return;
            }
            params2.f = finalValue;
            params2.o0 = finalConstrained;
        } else if (data instanceof a.C0019a) {
            a.C0019a params3 = (a.C0019a) data;
            if (orientation == 0) {
                params3.b(23, finalValue);
                params3.d(80, finalConstrained);
                return;
            }
            params3.b(21, finalValue);
            params3.d(81, finalConstrained);
        }
    }

    public static void p(ConstraintLayout.b params, String value) {
        int commaIndex;
        float dimensionRatioValue = Float.NaN;
        int dimensionRatioSide = -1;
        if (value != null) {
            int len = value.length();
            int commaIndex2 = value.indexOf(44);
            if (commaIndex2 > 0 && commaIndex2 < len - 1) {
                String dimension = value.substring(0, commaIndex2);
                if (dimension.equalsIgnoreCase("W")) {
                    dimensionRatioSide = 0;
                } else if (dimension.equalsIgnoreCase("H")) {
                    dimensionRatioSide = 1;
                }
                commaIndex = commaIndex2 + 1;
            } else {
                commaIndex = 0;
            }
            int colonIndex = value.indexOf(58);
            if (colonIndex >= 0 && colonIndex < len - 1) {
                String nominator = value.substring(commaIndex, colonIndex);
                String denominator = value.substring(colonIndex + 1);
                if (nominator.length() > 0 && denominator.length() > 0) {
                    try {
                        float nominatorValue = Float.parseFloat(nominator);
                        float denominatorValue = Float.parseFloat(denominator);
                        if (nominatorValue > 0.0f && denominatorValue > 0.0f) {
                            dimensionRatioValue = dimensionRatioSide == 1 ? Math.abs(denominatorValue / nominatorValue) : Math.abs(nominatorValue / denominatorValue);
                        }
                    } catch (NumberFormatException e2) {
                    }
                }
            } else {
                String r = value.substring(commaIndex);
                if (r.length() > 0) {
                    try {
                        dimensionRatioValue = Float.parseFloat(r);
                    } catch (NumberFormatException e3) {
                    }
                }
            }
        }
        params.H = value;
        params.I = dimensionRatioValue;
        params.J = dimensionRatioSide;
    }

    public static void o(Object data, String value, int orientation) {
        if (value == null) {
            return;
        }
        int equalIndex = value.indexOf(61);
        int len = value.length();
        if (equalIndex > 0 && equalIndex < len - 1) {
            String key = value.substring(0, equalIndex);
            String val = value.substring(equalIndex + 1);
            if (val.length() > 0) {
                String key2 = key.trim();
                String val2 = val.trim();
                if ("ratio".equalsIgnoreCase(key2)) {
                    if (data instanceof ConstraintLayout.b) {
                        ConstraintLayout.b params = (ConstraintLayout.b) data;
                        if (orientation == 0) {
                            ((ViewGroup.MarginLayoutParams) params).width = 0;
                        } else {
                            ((ViewGroup.MarginLayoutParams) params).height = 0;
                        }
                        p(params, val2);
                    } else if (data instanceof b) {
                        ((b) data).A = val2;
                    } else if (data instanceof a.C0019a) {
                        ((a.C0019a) data).c(5, val2);
                    }
                } else if ("weight".equalsIgnoreCase(key2)) {
                    try {
                        float weight = Float.parseFloat(val2);
                        if (data instanceof ConstraintLayout.b) {
                            ConstraintLayout.b params2 = (ConstraintLayout.b) data;
                            if (orientation == 0) {
                                ((ViewGroup.MarginLayoutParams) params2).width = 0;
                                params2.K = weight;
                            } else {
                                ((ViewGroup.MarginLayoutParams) params2).height = 0;
                                params2.L = weight;
                            }
                        } else if (data instanceof b) {
                            b params3 = (b) data;
                            if (orientation == 0) {
                                params3.e = 0;
                                params3.W = weight;
                                return;
                            }
                            params3.f = 0;
                            params3.V = weight;
                        } else if (data instanceof a.C0019a) {
                            a.C0019a params4 = (a.C0019a) data;
                            if (orientation == 0) {
                                params4.b(23, 0);
                                params4.a(39, weight);
                                return;
                            }
                            params4.b(21, 0);
                            params4.a(40, weight);
                        }
                    } catch (NumberFormatException e2) {
                    }
                } else if ("parent".equalsIgnoreCase(key2)) {
                    try {
                        float percent = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(val2)));
                        if (data instanceof ConstraintLayout.b) {
                            ConstraintLayout.b params5 = (ConstraintLayout.b) data;
                            if (orientation == 0) {
                                ((ViewGroup.MarginLayoutParams) params5).width = 0;
                                params5.U = percent;
                                params5.O = 2;
                            } else {
                                ((ViewGroup.MarginLayoutParams) params5).height = 0;
                                params5.V = percent;
                                params5.P = 2;
                            }
                        } else if (data instanceof b) {
                            b params6 = (b) data;
                            if (orientation == 0) {
                                params6.e = 0;
                                params6.f0 = percent;
                                params6.Z = 2;
                                return;
                            }
                            params6.f = 0;
                            params6.g0 = percent;
                            params6.a0 = 2;
                        } else if (data instanceof a.C0019a) {
                            a.C0019a params7 = (a.C0019a) data;
                            if (orientation == 0) {
                                params7.b(23, 0);
                                params7.b(54, 2);
                                return;
                            }
                            params7.b(21, 0);
                            params7.b(55, 2);
                        }
                    } catch (NumberFormatException e3) {
                    }
                }
            }
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: o6$b */
    /* loaded from: classes.dex */
    public static class b {
        public static SparseIntArray a;
        public int e;
        public int f;
        public int[] k0;
        public String l0;
        public String m0;
        public boolean b = false;
        public boolean c = false;
        public boolean d = false;
        public int g = -1;
        public int h = -1;
        public float i = -1.0f;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public int x = -1;
        public float y = 0.5f;
        public float z = 0.5f;
        public String A = null;
        public int B = -1;
        public int C = 0;
        public float D = 0.0f;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Priority.BG_LOW;
        public int P = Priority.BG_LOW;
        public int Q = Priority.BG_LOW;
        public int R = Priority.BG_LOW;
        public int S = Priority.BG_LOW;
        public int T = Priority.BG_LOW;
        public int U = Priority.BG_LOW;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;
        public int a0 = 0;
        public int b0 = -1;
        public int c0 = -1;
        public int d0 = -1;
        public int e0 = -1;
        public float f0 = 1.0f;
        public float g0 = 1.0f;
        public int h0 = -1;
        public int i0 = 0;
        public int j0 = -1;
        public boolean n0 = false;
        public boolean o0 = false;
        public boolean p0 = true;
        public int q0 = 0;

        public void a(b src) {
            this.b = src.b;
            this.e = src.e;
            this.c = src.c;
            this.f = src.f;
            this.g = src.g;
            this.h = src.h;
            this.i = src.i;
            this.j = src.j;
            this.k = src.k;
            this.l = src.l;
            this.m = src.m;
            this.n = src.n;
            this.o = src.o;
            this.p = src.p;
            this.q = src.q;
            this.r = src.r;
            this.s = src.s;
            this.t = src.t;
            this.u = src.u;
            this.v = src.v;
            this.w = src.w;
            this.x = src.x;
            this.y = src.y;
            this.z = src.z;
            this.A = src.A;
            this.B = src.B;
            this.C = src.C;
            this.D = src.D;
            this.E = src.E;
            this.F = src.F;
            this.G = src.G;
            this.H = src.H;
            this.I = src.I;
            this.J = src.J;
            this.K = src.K;
            this.L = src.L;
            this.M = src.M;
            this.N = src.N;
            this.O = src.O;
            this.P = src.P;
            this.Q = src.Q;
            this.R = src.R;
            this.S = src.S;
            this.T = src.T;
            this.U = src.U;
            this.V = src.V;
            this.W = src.W;
            this.X = src.X;
            this.Y = src.Y;
            this.Z = src.Z;
            this.a0 = src.a0;
            this.b0 = src.b0;
            this.c0 = src.c0;
            this.d0 = src.d0;
            this.e0 = src.e0;
            this.f0 = src.f0;
            this.g0 = src.g0;
            this.h0 = src.h0;
            this.i0 = src.i0;
            this.j0 = src.j0;
            this.m0 = src.m0;
            int[] iArr = src.k0;
            if (iArr != null) {
                this.k0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.k0 = null;
            }
            this.l0 = src.l0;
            this.n0 = src.n0;
            this.o0 = src.o0;
            this.p0 = src.p0;
            this.q0 = src.q0;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(r6.l6, 24);
            a.append(r6.m6, 25);
            a.append(r6.o6, 28);
            a.append(r6.p6, 29);
            a.append(r6.u6, 35);
            a.append(r6.t6, 34);
            a.append(r6.V5, 4);
            a.append(r6.U5, 3);
            a.append(r6.S5, 1);
            a.append(r6.A6, 6);
            a.append(r6.B6, 7);
            a.append(r6.c6, 17);
            a.append(r6.d6, 18);
            a.append(r6.e6, 19);
            a.append(r6.B5, 26);
            a.append(r6.q6, 31);
            a.append(r6.r6, 32);
            a.append(r6.b6, 10);
            a.append(r6.a6, 9);
            a.append(r6.E6, 13);
            a.append(r6.H6, 16);
            a.append(r6.F6, 14);
            a.append(r6.C6, 11);
            a.append(r6.G6, 15);
            a.append(r6.D6, 12);
            a.append(r6.x6, 38);
            a.append(r6.j6, 37);
            a.append(r6.i6, 39);
            a.append(r6.w6, 40);
            a.append(r6.h6, 20);
            a.append(r6.v6, 36);
            a.append(r6.Z5, 5);
            a.append(r6.k6, 76);
            a.append(r6.s6, 76);
            a.append(r6.n6, 76);
            a.append(r6.T5, 76);
            a.append(r6.R5, 76);
            a.append(r6.E5, 23);
            a.append(r6.G5, 27);
            a.append(r6.I5, 30);
            a.append(r6.J5, 8);
            a.append(r6.F5, 33);
            a.append(r6.H5, 2);
            a.append(r6.C5, 22);
            a.append(r6.D5, 21);
            a.append(r6.y6, 41);
            a.append(r6.f6, 42);
            a.append(r6.Q5, 41);
            a.append(r6.P5, 42);
            a.append(r6.I6, 97);
            a.append(r6.W5, 61);
            a.append(r6.Y5, 62);
            a.append(r6.X5, 63);
            a.append(r6.z6, 69);
            a.append(r6.g6, 70);
            a.append(r6.N5, 71);
            a.append(r6.L5, 72);
            a.append(r6.M5, 73);
            a.append(r6.O5, 74);
            a.append(r6.K5, 75);
        }

        public void b(Context context, AttributeSet attrs) {
            TypedArray a2 = context.obtainStyledAttributes(attrs, r6.A5);
            this.c = true;
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                switch (a.get(attr)) {
                    case 1:
                        this.r = o6.m(a2, attr, this.r);
                        break;
                    case 2:
                        this.K = a2.getDimensionPixelSize(attr, this.K);
                        break;
                    case 3:
                        this.q = o6.m(a2, attr, this.q);
                        break;
                    case 4:
                        this.p = o6.m(a2, attr, this.p);
                        break;
                    case 5:
                        this.A = a2.getString(attr);
                        break;
                    case 6:
                        this.E = a2.getDimensionPixelOffset(attr, this.E);
                        break;
                    case 7:
                        this.F = a2.getDimensionPixelOffset(attr, this.F);
                        break;
                    case 8:
                        if (Build.VERSION.SDK_INT >= 17) {
                            this.L = a2.getDimensionPixelSize(attr, this.L);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        this.x = o6.m(a2, attr, this.x);
                        break;
                    case 10:
                        this.w = o6.m(a2, attr, this.w);
                        break;
                    case 11:
                        this.R = a2.getDimensionPixelSize(attr, this.R);
                        break;
                    case 12:
                        this.S = a2.getDimensionPixelSize(attr, this.S);
                        break;
                    case 13:
                        this.O = a2.getDimensionPixelSize(attr, this.O);
                        break;
                    case 14:
                        this.Q = a2.getDimensionPixelSize(attr, this.Q);
                        break;
                    case 15:
                        this.T = a2.getDimensionPixelSize(attr, this.T);
                        break;
                    case 16:
                        this.P = a2.getDimensionPixelSize(attr, this.P);
                        break;
                    case 17:
                        this.g = a2.getDimensionPixelOffset(attr, this.g);
                        break;
                    case 18:
                        this.h = a2.getDimensionPixelOffset(attr, this.h);
                        break;
                    case 19:
                        this.i = a2.getFloat(attr, this.i);
                        break;
                    case 20:
                        this.y = a2.getFloat(attr, this.y);
                        break;
                    case 21:
                        this.f = a2.getLayoutDimension(attr, this.f);
                        break;
                    case 22:
                        this.e = a2.getLayoutDimension(attr, this.e);
                        break;
                    case 23:
                        this.H = a2.getDimensionPixelSize(attr, this.H);
                        break;
                    case 24:
                        this.j = o6.m(a2, attr, this.j);
                        break;
                    case 25:
                        this.k = o6.m(a2, attr, this.k);
                        break;
                    case 26:
                        this.G = a2.getInt(attr, this.G);
                        break;
                    case 27:
                        this.I = a2.getDimensionPixelSize(attr, this.I);
                        break;
                    case 28:
                        this.l = o6.m(a2, attr, this.l);
                        break;
                    case 29:
                        this.m = o6.m(a2, attr, this.m);
                        break;
                    case 30:
                        if (Build.VERSION.SDK_INT >= 17) {
                            this.M = a2.getDimensionPixelSize(attr, this.M);
                            break;
                        } else {
                            break;
                        }
                    case 31:
                        this.u = o6.m(a2, attr, this.u);
                        break;
                    case 32:
                        this.v = o6.m(a2, attr, this.v);
                        break;
                    case 33:
                        this.J = a2.getDimensionPixelSize(attr, this.J);
                        break;
                    case 34:
                        this.o = o6.m(a2, attr, this.o);
                        break;
                    case 35:
                        this.n = o6.m(a2, attr, this.n);
                        break;
                    case 36:
                        this.z = a2.getFloat(attr, this.z);
                        break;
                    case 37:
                        this.W = a2.getFloat(attr, this.W);
                        break;
                    case 38:
                        this.V = a2.getFloat(attr, this.V);
                        break;
                    case 39:
                        this.X = a2.getInt(attr, this.X);
                        break;
                    case 40:
                        this.Y = a2.getInt(attr, this.Y);
                        break;
                    case 41:
                        o6.n(this, a2, attr, 0);
                        break;
                    case 42:
                        o6.n(this, a2, attr, 1);
                        break;
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 60:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 78:
                    case 79:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 95:
                    case 96:
                    default:
                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(attr) + "   " + a.get(attr));
                        break;
                    case 54:
                        this.Z = a2.getInt(attr, this.Z);
                        break;
                    case 55:
                        this.a0 = a2.getInt(attr, this.a0);
                        break;
                    case 56:
                        this.b0 = a2.getDimensionPixelSize(attr, this.b0);
                        break;
                    case 57:
                        this.c0 = a2.getDimensionPixelSize(attr, this.c0);
                        break;
                    case 58:
                        this.d0 = a2.getDimensionPixelSize(attr, this.d0);
                        break;
                    case 59:
                        this.e0 = a2.getDimensionPixelSize(attr, this.e0);
                        break;
                    case 61:
                        this.B = o6.m(a2, attr, this.B);
                        break;
                    case 62:
                        this.C = a2.getDimensionPixelSize(attr, this.C);
                        break;
                    case 63:
                        this.D = a2.getFloat(attr, this.D);
                        break;
                    case 69:
                        this.f0 = a2.getFloat(attr, 1.0f);
                        break;
                    case 70:
                        this.g0 = a2.getFloat(attr, 1.0f);
                        break;
                    case 71:
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        this.h0 = a2.getInt(attr, this.h0);
                        break;
                    case 73:
                        this.i0 = a2.getDimensionPixelSize(attr, this.i0);
                        break;
                    case 74:
                        this.l0 = a2.getString(attr);
                        break;
                    case 75:
                        this.p0 = a2.getBoolean(attr, this.p0);
                        break;
                    case 76:
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(attr) + "   " + a.get(attr));
                        break;
                    case 77:
                        this.m0 = a2.getString(attr);
                        break;
                    case 80:
                        this.n0 = a2.getBoolean(attr, this.n0);
                        break;
                    case 81:
                        this.o0 = a2.getBoolean(attr, this.o0);
                        break;
                    case 91:
                        this.s = o6.m(a2, attr, this.s);
                        break;
                    case 92:
                        this.t = o6.m(a2, attr, this.t);
                        break;
                    case 93:
                        this.N = a2.getDimensionPixelSize(attr, this.N);
                        break;
                    case 94:
                        this.U = a2.getDimensionPixelSize(attr, this.U);
                        break;
                    case 97:
                        this.q0 = a2.getInt(attr, this.q0);
                        break;
                }
            }
            a2.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: o6$e */
    /* loaded from: classes.dex */
    public static class e {
        public static SparseIntArray a;
        public boolean b = false;
        public float c = 0.0f;
        public float d = 0.0f;
        public float e = 0.0f;
        public float f = 1.0f;
        public float g = 1.0f;
        public float h = Float.NaN;
        public float i = Float.NaN;
        public int j = -1;
        public float k = 0.0f;
        public float l = 0.0f;
        public float m = 0.0f;
        public boolean n = false;
        public float o = 0.0f;

        public void a(e src) {
            this.b = src.b;
            this.c = src.c;
            this.d = src.d;
            this.e = src.e;
            this.f = src.f;
            this.g = src.g;
            this.h = src.h;
            this.i = src.i;
            this.j = src.j;
            this.k = src.k;
            this.l = src.l;
            this.m = src.m;
            this.n = src.n;
            this.o = src.o;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(r6.M7, 1);
            a.append(r6.N7, 2);
            a.append(r6.O7, 3);
            a.append(r6.K7, 4);
            a.append(r6.L7, 5);
            a.append(r6.G7, 6);
            a.append(r6.H7, 7);
            a.append(r6.I7, 8);
            a.append(r6.J7, 9);
            a.append(r6.P7, 10);
            a.append(r6.Q7, 11);
            a.append(r6.R7, 12);
        }

        public void b(Context context, AttributeSet attrs) {
            TypedArray a2 = context.obtainStyledAttributes(attrs, r6.F7);
            this.b = true;
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                switch (a.get(attr)) {
                    case 1:
                        this.c = a2.getFloat(attr, this.c);
                        break;
                    case 2:
                        this.d = a2.getFloat(attr, this.d);
                        break;
                    case 3:
                        this.e = a2.getFloat(attr, this.e);
                        break;
                    case 4:
                        this.f = a2.getFloat(attr, this.f);
                        break;
                    case 5:
                        this.g = a2.getFloat(attr, this.g);
                        break;
                    case 6:
                        this.h = a2.getDimension(attr, this.h);
                        break;
                    case 7:
                        this.i = a2.getDimension(attr, this.i);
                        break;
                    case 8:
                        this.k = a2.getDimension(attr, this.k);
                        break;
                    case 9:
                        this.l = a2.getDimension(attr, this.l);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.m = a2.getDimension(attr, this.m);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.n = true;
                            this.o = a2.getDimension(attr, this.o);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        this.j = o6.m(a2, attr, this.j);
                        break;
                }
            }
            a2.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: o6$d */
    /* loaded from: classes.dex */
    public static class d {
        public boolean a = false;
        public int b = 0;
        public int c = 0;
        public float d = 1.0f;
        public float e = Float.NaN;

        public void a(d src) {
            this.a = src.a;
            this.b = src.b;
            this.d = src.d;
            this.e = src.e;
            this.c = src.c;
        }

        public void b(Context context, AttributeSet attrs) {
            TypedArray a = context.obtainStyledAttributes(attrs, r6.n7);
            this.a = true;
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == r6.p7) {
                    this.d = a.getFloat(attr, this.d);
                } else if (attr == r6.o7) {
                    this.b = a.getInt(attr, this.b);
                    this.b = o6.a[this.b];
                } else if (attr == r6.r7) {
                    this.c = a.getInt(attr, this.c);
                } else if (attr == r6.q7) {
                    this.e = a.getFloat(attr, this.e);
                }
            }
            a.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: o6$c */
    /* loaded from: classes.dex */
    public static class c {
        public static SparseIntArray a;
        public boolean b = false;
        public int c = -1;
        public int d = 0;
        public String e = null;
        public int f = -1;
        public int g = 0;
        public float h = Float.NaN;
        public int i = -1;
        public float j = Float.NaN;
        public float k = Float.NaN;
        public int l = -1;
        public String m = null;
        public int n = -3;
        public int o = -1;

        public void a(c src) {
            this.b = src.b;
            this.c = src.c;
            this.e = src.e;
            this.f = src.f;
            this.g = src.g;
            this.j = src.j;
            this.h = src.h;
            this.i = src.i;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(r6.U6, 1);
            a.append(r6.W6, 2);
            a.append(r6.a7, 3);
            a.append(r6.T6, 4);
            a.append(r6.S6, 5);
            a.append(r6.R6, 6);
            a.append(r6.V6, 7);
            a.append(r6.Z6, 8);
            a.append(r6.Y6, 9);
            a.append(r6.X6, 10);
        }

        public void b(Context context, AttributeSet attrs) {
            TypedArray a2 = context.obtainStyledAttributes(attrs, r6.Q6);
            this.b = true;
            int N = a2.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a2.getIndex(i);
                switch (a.get(attr)) {
                    case 1:
                        this.j = a2.getFloat(attr, this.j);
                        break;
                    case 2:
                        this.f = a2.getInt(attr, this.f);
                        break;
                    case 3:
                        TypedValue type = a2.peekValue(attr);
                        if (type.type == 3) {
                            this.e = a2.getString(attr);
                            break;
                        } else {
                            this.e = m4.b[a2.getInteger(attr, 0)];
                            break;
                        }
                    case 4:
                        this.g = a2.getInt(attr, 0);
                        break;
                    case 5:
                        this.c = o6.m(a2, attr, this.c);
                        break;
                    case 6:
                        this.d = a2.getInteger(attr, this.d);
                        break;
                    case 7:
                        this.h = a2.getFloat(attr, this.h);
                        break;
                    case 8:
                        this.l = a2.getInteger(attr, this.l);
                        break;
                    case 9:
                        this.k = a2.getFloat(attr, this.k);
                        break;
                    case 10:
                        TypedValue type2 = a2.peekValue(attr);
                        int i2 = type2.type;
                        if (i2 == 1) {
                            int resourceId = a2.getResourceId(attr, -1);
                            this.o = resourceId;
                            if (resourceId != -1) {
                                this.n = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i2 == 3) {
                            String string = a2.getString(attr);
                            this.m = string;
                            if (string.indexOf("/") > 0) {
                                this.o = a2.getResourceId(attr, -1);
                                this.n = -2;
                                break;
                            } else {
                                this.n = -1;
                                break;
                            }
                        } else {
                            this.n = a2.getInteger(attr, this.o);
                            break;
                        }
                }
            }
            a2.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: o6$a */
    /* loaded from: classes.dex */
    public static class a {
        public int a;
        public String b;
        public final d c = new d();
        public final c d = new c();
        public final b e = new b();
        public final e f = new e();
        public HashMap<String, m6> g = new HashMap<>();
        public C0019a h;

        /* compiled from: ConstraintSet.java */
        /* renamed from: o6$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0019a {
            public int[] a = new int[10];
            public int[] b = new int[10];
            public int c = 0;
            public int[] d = new int[10];
            public float[] e = new float[10];
            public int f = 0;
            public int[] g = new int[5];
            public String[] h = new String[5];
            public int i = 0;
            public int[] j = new int[4];
            public boolean[] k = new boolean[4];
            public int l = 0;

            public void b(int type, int value) {
                int i = this.c;
                int[] iArr = this.a;
                if (i >= iArr.length) {
                    this.a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.b;
                    this.b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.a;
                int i2 = this.c;
                iArr3[i2] = type;
                int[] iArr4 = this.b;
                this.c = i2 + 1;
                iArr4[i2] = value;
            }

            public void a(int type, float value) {
                int i = this.f;
                int[] iArr = this.d;
                if (i >= iArr.length) {
                    this.d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.e;
                    this.e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.d;
                int i2 = this.f;
                iArr2[i2] = type;
                float[] fArr2 = this.e;
                this.f = i2 + 1;
                fArr2[i2] = value;
            }

            public void c(int type, String value) {
                int i = this.i;
                int[] iArr = this.g;
                if (i >= iArr.length) {
                    this.g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.h;
                    this.h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.g;
                int i2 = this.i;
                iArr2[i2] = type;
                String[] strArr2 = this.h;
                this.i = i2 + 1;
                strArr2[i2] = value;
            }

            public void d(int type, boolean value) {
                int i = this.l;
                int[] iArr = this.j;
                if (i >= iArr.length) {
                    this.j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.k;
                    this.k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.j;
                int i2 = this.l;
                iArr2[i2] = type;
                boolean[] zArr2 = this.k;
                this.l = i2 + 1;
                zArr2[i2] = value;
            }
        }

        /* renamed from: e */
        public a clone() {
            a clone = new a();
            clone.e.a(this.e);
            clone.d.a(this.d);
            clone.c.a(this.c);
            clone.f.a(this.f);
            clone.a = this.a;
            clone.h = this.h;
            return clone;
        }

        public final void h(ConstraintHelper helper, int viewId, Constraints.a param) {
            g(viewId, param);
            if (helper instanceof Barrier) {
                b bVar = this.e;
                bVar.j0 = 1;
                Barrier barrier = (Barrier) helper;
                bVar.h0 = barrier.getType();
                this.e.k0 = barrier.getReferencedIds();
                this.e.i0 = barrier.getMargin();
            }
        }

        public final void g(int viewId, Constraints.a param) {
            f(viewId, param);
            this.c.d = param.w0;
            e eVar = this.f;
            eVar.c = param.z0;
            eVar.d = param.A0;
            eVar.e = param.B0;
            eVar.f = param.C0;
            eVar.g = param.D0;
            eVar.h = param.E0;
            eVar.i = param.F0;
            eVar.k = param.G0;
            eVar.l = param.H0;
            eVar.m = param.I0;
            eVar.o = param.y0;
            eVar.n = param.x0;
        }

        public final void f(int viewId, ConstraintLayout.b param) {
            this.a = viewId;
            b bVar = this.e;
            bVar.j = param.d;
            bVar.k = param.e;
            bVar.l = param.f;
            bVar.m = param.g;
            bVar.n = param.h;
            bVar.o = param.i;
            bVar.p = param.j;
            bVar.q = param.k;
            bVar.r = param.l;
            bVar.s = param.m;
            bVar.t = param.n;
            bVar.u = param.r;
            bVar.v = param.s;
            bVar.w = param.t;
            bVar.x = param.u;
            bVar.y = param.F;
            bVar.z = param.G;
            bVar.A = param.H;
            bVar.B = param.o;
            bVar.C = param.p;
            bVar.D = param.q;
            bVar.E = param.W;
            bVar.F = param.X;
            bVar.G = param.Y;
            bVar.i = param.c;
            b bVar2 = this.e;
            bVar2.g = param.a;
            bVar2.h = param.b;
            bVar2.e = ((ViewGroup.MarginLayoutParams) param).width;
            bVar2.f = ((ViewGroup.MarginLayoutParams) param).height;
            bVar2.H = ((ViewGroup.MarginLayoutParams) param).leftMargin;
            bVar2.I = ((ViewGroup.MarginLayoutParams) param).rightMargin;
            bVar2.J = ((ViewGroup.MarginLayoutParams) param).topMargin;
            bVar2.K = ((ViewGroup.MarginLayoutParams) param).bottomMargin;
            bVar2.N = param.C;
            bVar2.V = param.L;
            bVar2.W = param.K;
            bVar2.Y = param.N;
            bVar2.X = param.M;
            bVar2.n0 = param.Z;
            bVar2.o0 = param.a0;
            bVar2.Z = param.O;
            bVar2.a0 = param.P;
            bVar2.b0 = param.S;
            bVar2.c0 = param.T;
            bVar2.d0 = param.Q;
            bVar2.e0 = param.R;
            bVar2.f0 = param.U;
            bVar2.g0 = param.V;
            bVar2.m0 = param.b0;
            bVar2.P = param.w;
            b bVar3 = this.e;
            bVar3.R = param.y;
            bVar3.O = param.v;
            bVar3.Q = param.x;
            bVar3.T = param.z;
            bVar3.S = param.A;
            bVar3.U = param.B;
            bVar3.q0 = param.c0;
            int currentApiVersion = Build.VERSION.SDK_INT;
            if (currentApiVersion >= 17) {
                bVar3.L = param.getMarginEnd();
                this.e.M = param.getMarginStart();
            }
        }

        public void d(ConstraintLayout.b param) {
            b bVar = this.e;
            param.d = bVar.j;
            param.e = bVar.k;
            param.f = bVar.l;
            param.g = bVar.m;
            param.h = bVar.n;
            param.i = bVar.o;
            param.j = bVar.p;
            param.k = bVar.q;
            param.l = bVar.r;
            param.m = bVar.s;
            param.n = bVar.t;
            param.r = bVar.u;
            param.s = bVar.v;
            param.t = bVar.w;
            param.u = bVar.x;
            ((ViewGroup.MarginLayoutParams) param).leftMargin = bVar.H;
            ((ViewGroup.MarginLayoutParams) param).rightMargin = bVar.I;
            ((ViewGroup.MarginLayoutParams) param).topMargin = bVar.J;
            ((ViewGroup.MarginLayoutParams) param).bottomMargin = bVar.K;
            param.z = bVar.T;
            param.A = bVar.S;
            param.w = bVar.P;
            param.y = bVar.R;
            param.F = bVar.y;
            param.G = bVar.z;
            b bVar2 = this.e;
            param.o = bVar2.B;
            param.p = bVar2.C;
            param.q = bVar2.D;
            param.H = bVar2.A;
            param.W = bVar2.E;
            param.X = bVar2.F;
            param.L = bVar2.V;
            param.K = bVar2.W;
            param.N = bVar2.Y;
            param.M = bVar2.X;
            param.Z = bVar2.n0;
            param.a0 = bVar2.o0;
            param.O = bVar2.Z;
            param.P = bVar2.a0;
            param.S = bVar2.b0;
            param.T = bVar2.c0;
            param.Q = bVar2.d0;
            param.R = bVar2.e0;
            param.U = bVar2.f0;
            param.V = bVar2.g0;
            param.Y = bVar2.G;
            param.c = bVar2.i;
            param.a = bVar2.g;
            param.b = bVar2.h;
            ((ViewGroup.MarginLayoutParams) param).width = bVar2.e;
            b bVar3 = this.e;
            ((ViewGroup.MarginLayoutParams) param).height = bVar3.f;
            String str = bVar3.m0;
            if (str != null) {
                param.b0 = str;
            }
            param.c0 = bVar3.q0;
            if (Build.VERSION.SDK_INT >= 17) {
                param.setMarginStart(bVar3.M);
                param.setMarginEnd(this.e.L);
            }
            param.b();
        }
    }

    public void e(Context context, int constraintLayoutId) {
        f((ConstraintLayout) LayoutInflater.from(context).inflate(constraintLayoutId, (ViewGroup) null));
    }

    public void f(ConstraintLayout constraintLayout) {
        int count = constraintLayout.getChildCount();
        this.h.clear();
        for (int i = 0; i < count; i++) {
            View view = constraintLayout.getChildAt(i);
            ConstraintLayout.b param = (ConstraintLayout.b) view.getLayoutParams();
            int id = view.getId();
            if (this.g && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.h.containsKey(Integer.valueOf(id))) {
                this.h.put(Integer.valueOf(id), new a());
            }
            a constraint = this.h.get(Integer.valueOf(id));
            if (constraint != null) {
                constraint.g = m6.b(this.f, view);
                constraint.f(id, param);
                constraint.c.b = view.getVisibility();
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 17) {
                    constraint.c.d = view.getAlpha();
                    constraint.f.c = view.getRotation();
                    constraint.f.d = view.getRotationX();
                    constraint.f.e = view.getRotationY();
                    constraint.f.f = view.getScaleX();
                    constraint.f.g = view.getScaleY();
                    float pivotX = view.getPivotX();
                    float pivotY = view.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        e eVar = constraint.f;
                        eVar.h = pivotX;
                        eVar.i = pivotY;
                    }
                    constraint.f.k = view.getTranslationX();
                    constraint.f.l = view.getTranslationY();
                    if (i2 >= 21) {
                        constraint.f.m = view.getTranslationZ();
                        e eVar2 = constraint.f;
                        if (eVar2.n) {
                            eVar2.o = view.getElevation();
                        }
                    }
                }
                if (view instanceof Barrier) {
                    Barrier barrier = (Barrier) view;
                    constraint.e.p0 = barrier.getAllowsGoneWidget();
                    constraint.e.k0 = barrier.getReferencedIds();
                    constraint.e.h0 = barrier.getType();
                    constraint.e.i0 = barrier.getMargin();
                }
            }
        }
    }

    public void g(Constraints constraints) {
        int count = constraints.getChildCount();
        this.h.clear();
        for (int i = 0; i < count; i++) {
            View view = constraints.getChildAt(i);
            Constraints.a param = (Constraints.a) view.getLayoutParams();
            int id = view.getId();
            if (this.g && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.h.containsKey(Integer.valueOf(id))) {
                this.h.put(Integer.valueOf(id), new a());
            }
            a constraint = this.h.get(Integer.valueOf(id));
            if (constraint != null) {
                if (view instanceof ConstraintHelper) {
                    ConstraintHelper helper = (ConstraintHelper) view;
                    constraint.h(helper, id, param);
                }
                constraint.g(id, param);
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void d(ConstraintLayout constraintLayout, boolean applyPostLayout) {
        int count = constraintLayout.getChildCount();
        HashSet<Integer> used = new HashSet<>(this.h.keySet());
        for (int i = 0; i < count; i++) {
            View view = constraintLayout.getChildAt(i);
            int id = view.getId();
            if (!this.h.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + b6.c(view));
            } else if (this.g && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1) {
                    if (this.h.containsKey(Integer.valueOf(id))) {
                        used.remove(Integer.valueOf(id));
                        a constraint = this.h.get(Integer.valueOf(id));
                        if (constraint != null) {
                            if (view instanceof Barrier) {
                                constraint.e.j0 = 1;
                                Barrier barrier = (Barrier) view;
                                barrier.setId(id);
                                barrier.setType(constraint.e.h0);
                                barrier.setMargin(constraint.e.i0);
                                barrier.setAllowsGoneWidget(constraint.e.p0);
                                b bVar = constraint.e;
                                int[] iArr = bVar.k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.l0;
                                    if (str != null) {
                                        bVar.k0 = h(barrier, str);
                                        barrier.setReferencedIds(constraint.e.k0);
                                    }
                                }
                            }
                            ConstraintLayout.b param = (ConstraintLayout.b) view.getLayoutParams();
                            param.b();
                            constraint.d(param);
                            if (applyPostLayout) {
                                m6.d(view, constraint.g);
                            }
                            view.setLayoutParams(param);
                            d dVar = constraint.c;
                            if (dVar.c == 0) {
                                view.setVisibility(dVar.b);
                            }
                            int i2 = Build.VERSION.SDK_INT;
                            if (i2 >= 17) {
                                view.setAlpha(constraint.c.d);
                                view.setRotation(constraint.f.c);
                                view.setRotationX(constraint.f.d);
                                view.setRotationY(constraint.f.e);
                                view.setScaleX(constraint.f.f);
                                view.setScaleY(constraint.f.g);
                                e eVar = constraint.f;
                                if (eVar.j != -1) {
                                    View layout = (View) view.getParent();
                                    View center = layout.findViewById(constraint.f.j);
                                    if (center != null) {
                                        float cy = (center.getTop() + center.getBottom()) / 2.0f;
                                        float cx = (center.getLeft() + center.getRight()) / 2.0f;
                                        if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                                            float px = cx - view.getLeft();
                                            float py = cy - view.getTop();
                                            view.setPivotX(px);
                                            view.setPivotY(py);
                                        }
                                    }
                                } else {
                                    if (!Float.isNaN(eVar.h)) {
                                        view.setPivotX(constraint.f.h);
                                    }
                                    if (!Float.isNaN(constraint.f.i)) {
                                        view.setPivotY(constraint.f.i);
                                    }
                                }
                                view.setTranslationX(constraint.f.k);
                                view.setTranslationY(constraint.f.l);
                                if (i2 >= 21) {
                                    view.setTranslationZ(constraint.f.m);
                                    e eVar2 = constraint.f;
                                    if (eVar2.n) {
                                        view.setElevation(eVar2.o);
                                    }
                                }
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator<Integer> it = used.iterator();
        while (it.hasNext()) {
            Integer id2 = it.next();
            a constraint2 = this.h.get(id2);
            if (constraint2 != null) {
                if (constraint2.e.j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(id2.intValue());
                    b bVar2 = constraint2.e;
                    int[] iArr2 = bVar2.k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar2.l0;
                        if (str2 != null) {
                            bVar2.k0 = h(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.e.k0);
                        }
                    }
                    barrier2.setType(constraint2.e.h0);
                    barrier2.setMargin(constraint2.e.i0);
                    ConstraintLayout.b param2 = constraintLayout.generateDefaultLayoutParams();
                    barrier2.s();
                    constraint2.d(param2);
                    constraintLayout.addView(barrier2, param2);
                }
                if (constraint2.e.b) {
                    Guideline g = new Guideline(constraintLayout.getContext());
                    g.setId(id2.intValue());
                    ConstraintLayout.b param3 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.d(param3);
                    constraintLayout.addView(g, param3);
                }
            }
        }
        for (int i3 = 0; i3 < count; i3++) {
            View view2 = constraintLayout.getChildAt(i3);
            if (view2 instanceof ConstraintHelper) {
                ConstraintHelper constraintHelper = (ConstraintHelper) view2;
                constraintHelper.i(constraintLayout);
            }
        }
    }

    public void k(Context context, int resourceId) {
        Resources res = context.getResources();
        XmlPullParser parser = res.getXml(resourceId);
        try {
            for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
                switch (eventType) {
                    case 0:
                        parser.getName();
                        break;
                    case 2:
                        String tagName = parser.getName();
                        a constraint = i(context, Xml.asAttributeSet(parser), false);
                        if (tagName.equalsIgnoreCase("Guideline")) {
                            constraint.e.b = true;
                        }
                        this.h.put(Integer.valueOf(constraint.a), constraint);
                        break;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void l(Context context, XmlPullParser parser) {
        a constraint = null;
        try {
            int eventType = parser.getEventType();
            while (true) {
                boolean z = true;
                if (eventType != 1) {
                    char c2 = 3;
                    switch (eventType) {
                        case 0:
                            parser.getName();
                            break;
                        case 2:
                            String tagName = parser.getName();
                            switch (tagName.hashCode()) {
                                case -2025855158:
                                    if (tagName.equals("Layout")) {
                                        c2 = 6;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1984451626:
                                    if (tagName.equals("Motion")) {
                                        c2 = 7;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1962203927:
                                    if (tagName.equals("ConstraintOverride")) {
                                        c2 = 1;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1269513683:
                                    if (tagName.equals("PropertySet")) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1238332596:
                                    if (tagName.equals("Transform")) {
                                        c2 = 5;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -71750448:
                                    if (tagName.equals("Guideline")) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 366511058:
                                    if (tagName.equals("CustomMethod")) {
                                        c2 = '\t';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1331510167:
                                    if (tagName.equals("Barrier")) {
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1791837707:
                                    if (tagName.equals("CustomAttribute")) {
                                        c2 = '\b';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1803088381:
                                    if (tagName.equals("Constraint")) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    constraint = i(context, Xml.asAttributeSet(parser), false);
                                    break;
                                case 1:
                                    constraint = i(context, Xml.asAttributeSet(parser), true);
                                    break;
                                case 2:
                                    constraint = i(context, Xml.asAttributeSet(parser), false);
                                    b bVar = constraint.e;
                                    bVar.b = true;
                                    bVar.c = true;
                                    break;
                                case 3:
                                    constraint = i(context, Xml.asAttributeSet(parser), false);
                                    constraint.e.j0 = 1;
                                    break;
                                case 4:
                                    if (constraint == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + parser.getLineNumber());
                                    }
                                    constraint.c.b(context, Xml.asAttributeSet(parser));
                                    break;
                                case 5:
                                    if (constraint == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + parser.getLineNumber());
                                    }
                                    constraint.f.b(context, Xml.asAttributeSet(parser));
                                    break;
                                case 6:
                                    if (constraint == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + parser.getLineNumber());
                                    }
                                    constraint.e.b(context, Xml.asAttributeSet(parser));
                                    break;
                                case 7:
                                    if (constraint == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + parser.getLineNumber());
                                    }
                                    constraint.d.b(context, Xml.asAttributeSet(parser));
                                    break;
                                case '\b':
                                case '\t':
                                    if (constraint == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + parser.getLineNumber());
                                    }
                                    m6.c(context, parser, constraint.g);
                                    break;
                            }
                            break;
                        case 3:
                            String lowerCase = parser.getName().toLowerCase(Locale.ROOT);
                            switch (lowerCase.hashCode()) {
                                case -2075718416:
                                    if (lowerCase.equals("guideline")) {
                                        z = true;
                                        break;
                                    }
                                    z = true;
                                    break;
                                case -190376483:
                                    if (lowerCase.equals("constraint")) {
                                        break;
                                    }
                                    z = true;
                                    break;
                                case 426575017:
                                    if (lowerCase.equals("constraintoverride")) {
                                        z = true;
                                        break;
                                    }
                                    z = true;
                                    break;
                                case 2146106725:
                                    if (lowerCase.equals("constraintset")) {
                                        z = false;
                                        break;
                                    }
                                    z = true;
                                    break;
                                default:
                                    z = true;
                                    break;
                            }
                            switch (z) {
                                case false:
                                    return;
                                case true:
                                case true:
                                case true:
                                    this.h.put(Integer.valueOf(constraint.a), constraint);
                                    constraint = null;
                                    break;
                            }
                            break;
                    }
                    eventType = parser.next();
                } else {
                    return;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    public static int m(TypedArray a2, int index, int def) {
        int ret = a2.getResourceId(index, def);
        if (ret == -1) {
            return a2.getInt(index, -1);
        }
        return ret;
    }

    public final a i(Context context, AttributeSet attrs, boolean override) {
        a c2 = new a();
        TypedArray a2 = context.obtainStyledAttributes(attrs, override ? r6.n3 : r6.t);
        q(context, c2, a2, override);
        a2.recycle();
        return c2;
    }

    public static void r(Context ctx, a c2, TypedArray a2) {
        int N = a2.getIndexCount();
        a.C0019a delta = new a.C0019a();
        c2.h = delta;
        c2.d.b = false;
        c2.e.c = false;
        c2.c.a = false;
        c2.f.b = false;
        for (int i = 0; i < N; i++) {
            int attr = a2.getIndex(i);
            int attrType = c.get(attr);
            switch (attrType) {
                case 2:
                    delta.b(2, a2.getDimensionPixelSize(attr, c2.e.K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(attr) + "   " + b.get(attr));
                    break;
                case 5:
                    delta.c(5, a2.getString(attr));
                    break;
                case 6:
                    delta.b(6, a2.getDimensionPixelOffset(attr, c2.e.E));
                    break;
                case 7:
                    delta.b(7, a2.getDimensionPixelOffset(attr, c2.e.F));
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        delta.b(8, a2.getDimensionPixelSize(attr, c2.e.L));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    delta.b(11, a2.getDimensionPixelSize(attr, c2.e.R));
                    break;
                case 12:
                    delta.b(12, a2.getDimensionPixelSize(attr, c2.e.S));
                    break;
                case 13:
                    delta.b(13, a2.getDimensionPixelSize(attr, c2.e.O));
                    break;
                case 14:
                    delta.b(14, a2.getDimensionPixelSize(attr, c2.e.Q));
                    break;
                case 15:
                    delta.b(15, a2.getDimensionPixelSize(attr, c2.e.T));
                    break;
                case 16:
                    delta.b(16, a2.getDimensionPixelSize(attr, c2.e.P));
                    break;
                case 17:
                    delta.b(17, a2.getDimensionPixelOffset(attr, c2.e.g));
                    break;
                case 18:
                    delta.b(18, a2.getDimensionPixelOffset(attr, c2.e.h));
                    break;
                case 19:
                    delta.a(19, a2.getFloat(attr, c2.e.i));
                    break;
                case 20:
                    delta.a(20, a2.getFloat(attr, c2.e.y));
                    break;
                case 21:
                    delta.b(21, a2.getLayoutDimension(attr, c2.e.f));
                    break;
                case 22:
                    delta.b(22, a[a2.getInt(attr, c2.c.b)]);
                    break;
                case 23:
                    delta.b(23, a2.getLayoutDimension(attr, c2.e.e));
                    break;
                case 24:
                    delta.b(24, a2.getDimensionPixelSize(attr, c2.e.H));
                    break;
                case 27:
                    delta.b(27, a2.getInt(attr, c2.e.G));
                    break;
                case 28:
                    delta.b(28, a2.getDimensionPixelSize(attr, c2.e.I));
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        delta.b(31, a2.getDimensionPixelSize(attr, c2.e.M));
                        break;
                    } else {
                        break;
                    }
                case 34:
                    delta.b(34, a2.getDimensionPixelSize(attr, c2.e.J));
                    break;
                case 37:
                    delta.a(37, a2.getFloat(attr, c2.e.z));
                    break;
                case 38:
                    int resourceId = a2.getResourceId(attr, c2.a);
                    c2.a = resourceId;
                    delta.b(38, resourceId);
                    break;
                case 39:
                    delta.a(39, a2.getFloat(attr, c2.e.W));
                    break;
                case 40:
                    delta.a(40, a2.getFloat(attr, c2.e.V));
                    break;
                case 41:
                    delta.b(41, a2.getInt(attr, c2.e.X));
                    break;
                case 42:
                    delta.b(42, a2.getInt(attr, c2.e.Y));
                    break;
                case 43:
                    delta.a(43, a2.getFloat(attr, c2.c.d));
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        delta.d(44, true);
                        delta.a(44, a2.getDimension(attr, c2.f.o));
                        break;
                    } else {
                        break;
                    }
                case 45:
                    delta.a(45, a2.getFloat(attr, c2.f.d));
                    break;
                case 46:
                    delta.a(46, a2.getFloat(attr, c2.f.e));
                    break;
                case 47:
                    delta.a(47, a2.getFloat(attr, c2.f.f));
                    break;
                case 48:
                    delta.a(48, a2.getFloat(attr, c2.f.g));
                    break;
                case 49:
                    delta.a(49, a2.getDimension(attr, c2.f.h));
                    break;
                case 50:
                    delta.a(50, a2.getDimension(attr, c2.f.i));
                    break;
                case 51:
                    delta.a(51, a2.getDimension(attr, c2.f.k));
                    break;
                case 52:
                    delta.a(52, a2.getDimension(attr, c2.f.l));
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        delta.a(53, a2.getDimension(attr, c2.f.m));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    delta.b(54, a2.getInt(attr, c2.e.Z));
                    break;
                case 55:
                    delta.b(55, a2.getInt(attr, c2.e.a0));
                    break;
                case 56:
                    delta.b(56, a2.getDimensionPixelSize(attr, c2.e.b0));
                    break;
                case 57:
                    delta.b(57, a2.getDimensionPixelSize(attr, c2.e.c0));
                    break;
                case 58:
                    delta.b(58, a2.getDimensionPixelSize(attr, c2.e.d0));
                    break;
                case 59:
                    delta.b(59, a2.getDimensionPixelSize(attr, c2.e.e0));
                    break;
                case 60:
                    delta.a(60, a2.getFloat(attr, c2.f.c));
                    break;
                case 62:
                    delta.b(62, a2.getDimensionPixelSize(attr, c2.e.C));
                    break;
                case 63:
                    delta.a(63, a2.getFloat(attr, c2.e.D));
                    break;
                case 64:
                    delta.b(64, m(a2, attr, c2.d.c));
                    break;
                case 65:
                    TypedValue type = a2.peekValue(attr);
                    if (type.type == 3) {
                        delta.c(65, a2.getString(attr));
                        break;
                    } else {
                        delta.c(65, m4.b[a2.getInteger(attr, 0)]);
                        break;
                    }
                case 66:
                    delta.b(66, a2.getInt(attr, 0));
                    break;
                case 67:
                    delta.a(67, a2.getFloat(attr, c2.d.j));
                    break;
                case 68:
                    delta.a(68, a2.getFloat(attr, c2.c.e));
                    break;
                case 69:
                    delta.a(69, a2.getFloat(attr, 1.0f));
                    break;
                case 70:
                    delta.a(70, a2.getFloat(attr, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    delta.b(72, a2.getInt(attr, c2.e.h0));
                    break;
                case 73:
                    delta.b(73, a2.getDimensionPixelSize(attr, c2.e.i0));
                    break;
                case 74:
                    delta.c(74, a2.getString(attr));
                    break;
                case 75:
                    delta.d(75, a2.getBoolean(attr, c2.e.p0));
                    break;
                case 76:
                    delta.b(76, a2.getInt(attr, c2.d.f));
                    break;
                case 77:
                    delta.c(77, a2.getString(attr));
                    break;
                case 78:
                    delta.b(78, a2.getInt(attr, c2.c.c));
                    break;
                case 79:
                    delta.a(79, a2.getFloat(attr, c2.d.h));
                    break;
                case 80:
                    delta.d(80, a2.getBoolean(attr, c2.e.n0));
                    break;
                case 81:
                    delta.d(81, a2.getBoolean(attr, c2.e.o0));
                    break;
                case 82:
                    delta.b(82, a2.getInteger(attr, c2.d.d));
                    break;
                case 83:
                    delta.b(83, m(a2, attr, c2.f.j));
                    break;
                case 84:
                    delta.b(84, a2.getInteger(attr, c2.d.l));
                    break;
                case 85:
                    delta.a(85, a2.getFloat(attr, c2.d.k));
                    break;
                case 86:
                    TypedValue type2 = a2.peekValue(attr);
                    int i2 = type2.type;
                    if (i2 == 1) {
                        c2.d.o = a2.getResourceId(attr, -1);
                        delta.b(89, c2.d.o);
                        c cVar = c2.d;
                        if (cVar.o != -1) {
                            cVar.n = -2;
                            delta.b(88, -2);
                            break;
                        } else {
                            break;
                        }
                    } else if (i2 == 3) {
                        c2.d.m = a2.getString(attr);
                        delta.c(90, c2.d.m);
                        if (c2.d.m.indexOf("/") > 0) {
                            c2.d.o = a2.getResourceId(attr, -1);
                            delta.b(89, c2.d.o);
                            c2.d.n = -2;
                            delta.b(88, -2);
                            break;
                        } else {
                            c2.d.n = -1;
                            delta.b(88, -1);
                            break;
                        }
                    } else {
                        c cVar2 = c2.d;
                        cVar2.n = a2.getInteger(attr, cVar2.o);
                        delta.b(88, c2.d.n);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(attr) + "   " + b.get(attr));
                    break;
                case 93:
                    delta.b(93, a2.getDimensionPixelSize(attr, c2.e.N));
                    break;
                case 94:
                    delta.b(94, a2.getDimensionPixelSize(attr, c2.e.U));
                    break;
                case 95:
                    n(delta, a2, attr, 0);
                    break;
                case 96:
                    n(delta, a2, attr, 1);
                    break;
                case 97:
                    delta.b(97, a2.getInt(attr, c2.e.q0));
                    break;
                case 98:
                    if (MotionLayout.A) {
                        int resourceId2 = a2.getResourceId(attr, c2.a);
                        c2.a = resourceId2;
                        if (resourceId2 == -1) {
                            c2.b = a2.getString(attr);
                            break;
                        } else {
                            break;
                        }
                    } else if (a2.peekValue(attr).type == 3) {
                        c2.b = a2.getString(attr);
                        break;
                    } else {
                        c2.a = a2.getResourceId(attr, c2.a);
                        break;
                    }
            }
        }
    }

    public final void q(Context ctx, a c2, TypedArray a2, boolean override) {
        if (override) {
            r(ctx, c2, a2);
            return;
        }
        int N = a2.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a2.getIndex(i);
            if (attr != r6.v && r6.N != attr && r6.O != attr) {
                c2.d.b = true;
                c2.e.c = true;
                c2.c.a = true;
                c2.f.b = true;
            }
            switch (b.get(attr)) {
                case 1:
                    b bVar = c2.e;
                    bVar.r = m(a2, attr, bVar.r);
                    break;
                case 2:
                    b bVar2 = c2.e;
                    bVar2.K = a2.getDimensionPixelSize(attr, bVar2.K);
                    break;
                case 3:
                    b bVar3 = c2.e;
                    bVar3.q = m(a2, attr, bVar3.q);
                    break;
                case 4:
                    b bVar4 = c2.e;
                    bVar4.p = m(a2, attr, bVar4.p);
                    break;
                case 5:
                    c2.e.A = a2.getString(attr);
                    break;
                case 6:
                    b bVar5 = c2.e;
                    bVar5.E = a2.getDimensionPixelOffset(attr, bVar5.E);
                    break;
                case 7:
                    b bVar6 = c2.e;
                    bVar6.F = a2.getDimensionPixelOffset(attr, bVar6.F);
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar7 = c2.e;
                        bVar7.L = a2.getDimensionPixelSize(attr, bVar7.L);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    b bVar8 = c2.e;
                    bVar8.x = m(a2, attr, bVar8.x);
                    break;
                case 10:
                    b bVar9 = c2.e;
                    bVar9.w = m(a2, attr, bVar9.w);
                    break;
                case 11:
                    b bVar10 = c2.e;
                    bVar10.R = a2.getDimensionPixelSize(attr, bVar10.R);
                    break;
                case 12:
                    b bVar11 = c2.e;
                    bVar11.S = a2.getDimensionPixelSize(attr, bVar11.S);
                    break;
                case 13:
                    b bVar12 = c2.e;
                    bVar12.O = a2.getDimensionPixelSize(attr, bVar12.O);
                    break;
                case 14:
                    b bVar13 = c2.e;
                    bVar13.Q = a2.getDimensionPixelSize(attr, bVar13.Q);
                    break;
                case 15:
                    b bVar14 = c2.e;
                    bVar14.T = a2.getDimensionPixelSize(attr, bVar14.T);
                    break;
                case 16:
                    b bVar15 = c2.e;
                    bVar15.P = a2.getDimensionPixelSize(attr, bVar15.P);
                    break;
                case 17:
                    b bVar16 = c2.e;
                    bVar16.g = a2.getDimensionPixelOffset(attr, bVar16.g);
                    break;
                case 18:
                    b bVar17 = c2.e;
                    bVar17.h = a2.getDimensionPixelOffset(attr, bVar17.h);
                    break;
                case 19:
                    b bVar18 = c2.e;
                    bVar18.i = a2.getFloat(attr, bVar18.i);
                    break;
                case 20:
                    b bVar19 = c2.e;
                    bVar19.y = a2.getFloat(attr, bVar19.y);
                    break;
                case 21:
                    b bVar20 = c2.e;
                    bVar20.f = a2.getLayoutDimension(attr, bVar20.f);
                    break;
                case 22:
                    d dVar = c2.c;
                    dVar.b = a2.getInt(attr, dVar.b);
                    d dVar2 = c2.c;
                    dVar2.b = a[dVar2.b];
                    break;
                case 23:
                    b bVar21 = c2.e;
                    bVar21.e = a2.getLayoutDimension(attr, bVar21.e);
                    break;
                case 24:
                    b bVar22 = c2.e;
                    bVar22.H = a2.getDimensionPixelSize(attr, bVar22.H);
                    break;
                case 25:
                    b bVar23 = c2.e;
                    bVar23.j = m(a2, attr, bVar23.j);
                    break;
                case 26:
                    b bVar24 = c2.e;
                    bVar24.k = m(a2, attr, bVar24.k);
                    break;
                case 27:
                    b bVar25 = c2.e;
                    bVar25.G = a2.getInt(attr, bVar25.G);
                    break;
                case 28:
                    b bVar26 = c2.e;
                    bVar26.I = a2.getDimensionPixelSize(attr, bVar26.I);
                    break;
                case 29:
                    b bVar27 = c2.e;
                    bVar27.l = m(a2, attr, bVar27.l);
                    break;
                case 30:
                    b bVar28 = c2.e;
                    bVar28.m = m(a2, attr, bVar28.m);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar29 = c2.e;
                        bVar29.M = a2.getDimensionPixelSize(attr, bVar29.M);
                        break;
                    } else {
                        break;
                    }
                case 32:
                    b bVar30 = c2.e;
                    bVar30.u = m(a2, attr, bVar30.u);
                    break;
                case 33:
                    b bVar31 = c2.e;
                    bVar31.v = m(a2, attr, bVar31.v);
                    break;
                case 34:
                    b bVar32 = c2.e;
                    bVar32.J = a2.getDimensionPixelSize(attr, bVar32.J);
                    break;
                case 35:
                    b bVar33 = c2.e;
                    bVar33.o = m(a2, attr, bVar33.o);
                    break;
                case 36:
                    b bVar34 = c2.e;
                    bVar34.n = m(a2, attr, bVar34.n);
                    break;
                case 37:
                    b bVar35 = c2.e;
                    bVar35.z = a2.getFloat(attr, bVar35.z);
                    break;
                case 38:
                    c2.a = a2.getResourceId(attr, c2.a);
                    break;
                case 39:
                    b bVar36 = c2.e;
                    bVar36.W = a2.getFloat(attr, bVar36.W);
                    break;
                case 40:
                    b bVar37 = c2.e;
                    bVar37.V = a2.getFloat(attr, bVar37.V);
                    break;
                case 41:
                    b bVar38 = c2.e;
                    bVar38.X = a2.getInt(attr, bVar38.X);
                    break;
                case 42:
                    b bVar39 = c2.e;
                    bVar39.Y = a2.getInt(attr, bVar39.Y);
                    break;
                case 43:
                    d dVar3 = c2.c;
                    dVar3.d = a2.getFloat(attr, dVar3.d);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar = c2.f;
                        eVar.n = true;
                        eVar.o = a2.getDimension(attr, eVar.o);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    e eVar2 = c2.f;
                    eVar2.d = a2.getFloat(attr, eVar2.d);
                    break;
                case 46:
                    e eVar3 = c2.f;
                    eVar3.e = a2.getFloat(attr, eVar3.e);
                    break;
                case 47:
                    e eVar4 = c2.f;
                    eVar4.f = a2.getFloat(attr, eVar4.f);
                    break;
                case 48:
                    e eVar5 = c2.f;
                    eVar5.g = a2.getFloat(attr, eVar5.g);
                    break;
                case 49:
                    e eVar6 = c2.f;
                    eVar6.h = a2.getDimension(attr, eVar6.h);
                    break;
                case 50:
                    e eVar7 = c2.f;
                    eVar7.i = a2.getDimension(attr, eVar7.i);
                    break;
                case 51:
                    e eVar8 = c2.f;
                    eVar8.k = a2.getDimension(attr, eVar8.k);
                    break;
                case 52:
                    e eVar9 = c2.f;
                    eVar9.l = a2.getDimension(attr, eVar9.l);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar10 = c2.f;
                        eVar10.m = a2.getDimension(attr, eVar10.m);
                        break;
                    } else {
                        break;
                    }
                case 54:
                    b bVar40 = c2.e;
                    bVar40.Z = a2.getInt(attr, bVar40.Z);
                    break;
                case 55:
                    b bVar41 = c2.e;
                    bVar41.a0 = a2.getInt(attr, bVar41.a0);
                    break;
                case 56:
                    b bVar42 = c2.e;
                    bVar42.b0 = a2.getDimensionPixelSize(attr, bVar42.b0);
                    break;
                case 57:
                    b bVar43 = c2.e;
                    bVar43.c0 = a2.getDimensionPixelSize(attr, bVar43.c0);
                    break;
                case 58:
                    b bVar44 = c2.e;
                    bVar44.d0 = a2.getDimensionPixelSize(attr, bVar44.d0);
                    break;
                case 59:
                    b bVar45 = c2.e;
                    bVar45.e0 = a2.getDimensionPixelSize(attr, bVar45.e0);
                    break;
                case 60:
                    e eVar11 = c2.f;
                    eVar11.c = a2.getFloat(attr, eVar11.c);
                    break;
                case 61:
                    b bVar46 = c2.e;
                    bVar46.B = m(a2, attr, bVar46.B);
                    break;
                case 62:
                    b bVar47 = c2.e;
                    bVar47.C = a2.getDimensionPixelSize(attr, bVar47.C);
                    break;
                case 63:
                    b bVar48 = c2.e;
                    bVar48.D = a2.getFloat(attr, bVar48.D);
                    break;
                case 64:
                    c cVar = c2.d;
                    cVar.c = m(a2, attr, cVar.c);
                    break;
                case 65:
                    TypedValue type = a2.peekValue(attr);
                    if (type.type == 3) {
                        c2.d.e = a2.getString(attr);
                        break;
                    } else {
                        c2.d.e = m4.b[a2.getInteger(attr, 0)];
                        break;
                    }
                case 66:
                    c2.d.g = a2.getInt(attr, 0);
                    break;
                case 67:
                    c cVar2 = c2.d;
                    cVar2.j = a2.getFloat(attr, cVar2.j);
                    break;
                case 68:
                    d dVar4 = c2.c;
                    dVar4.e = a2.getFloat(attr, dVar4.e);
                    break;
                case 69:
                    c2.e.f0 = a2.getFloat(attr, 1.0f);
                    break;
                case 70:
                    c2.e.g0 = a2.getFloat(attr, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = c2.e;
                    bVar49.h0 = a2.getInt(attr, bVar49.h0);
                    break;
                case 73:
                    b bVar50 = c2.e;
                    bVar50.i0 = a2.getDimensionPixelSize(attr, bVar50.i0);
                    break;
                case 74:
                    c2.e.l0 = a2.getString(attr);
                    break;
                case 75:
                    b bVar51 = c2.e;
                    bVar51.p0 = a2.getBoolean(attr, bVar51.p0);
                    break;
                case 76:
                    c cVar3 = c2.d;
                    cVar3.f = a2.getInt(attr, cVar3.f);
                    break;
                case 77:
                    c2.e.m0 = a2.getString(attr);
                    break;
                case 78:
                    d dVar5 = c2.c;
                    dVar5.c = a2.getInt(attr, dVar5.c);
                    break;
                case 79:
                    c cVar4 = c2.d;
                    cVar4.h = a2.getFloat(attr, cVar4.h);
                    break;
                case 80:
                    b bVar52 = c2.e;
                    bVar52.n0 = a2.getBoolean(attr, bVar52.n0);
                    break;
                case 81:
                    b bVar53 = c2.e;
                    bVar53.o0 = a2.getBoolean(attr, bVar53.o0);
                    break;
                case 82:
                    c cVar5 = c2.d;
                    cVar5.d = a2.getInteger(attr, cVar5.d);
                    break;
                case 83:
                    e eVar12 = c2.f;
                    eVar12.j = m(a2, attr, eVar12.j);
                    break;
                case 84:
                    c cVar6 = c2.d;
                    cVar6.l = a2.getInteger(attr, cVar6.l);
                    break;
                case 85:
                    c cVar7 = c2.d;
                    cVar7.k = a2.getFloat(attr, cVar7.k);
                    break;
                case 86:
                    TypedValue type2 = a2.peekValue(attr);
                    int i2 = type2.type;
                    if (i2 == 1) {
                        c2.d.o = a2.getResourceId(attr, -1);
                        c cVar8 = c2.d;
                        if (cVar8.o != -1) {
                            cVar8.n = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i2 == 3) {
                        c2.d.m = a2.getString(attr);
                        if (c2.d.m.indexOf("/") > 0) {
                            c2.d.o = a2.getResourceId(attr, -1);
                            c2.d.n = -2;
                            break;
                        } else {
                            c2.d.n = -1;
                            break;
                        }
                    } else {
                        c cVar9 = c2.d;
                        cVar9.n = a2.getInteger(attr, cVar9.o);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(attr) + "   " + b.get(attr));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(attr) + "   " + b.get(attr));
                    break;
                case 91:
                    b bVar54 = c2.e;
                    bVar54.s = m(a2, attr, bVar54.s);
                    break;
                case 92:
                    b bVar55 = c2.e;
                    bVar55.t = m(a2, attr, bVar55.t);
                    break;
                case 93:
                    b bVar56 = c2.e;
                    bVar56.N = a2.getDimensionPixelSize(attr, bVar56.N);
                    break;
                case 94:
                    b bVar57 = c2.e;
                    bVar57.U = a2.getDimensionPixelSize(attr, bVar57.U);
                    break;
                case 95:
                    n(c2.e, a2, attr, 0);
                    break;
                case 96:
                    n(c2.e, a2, attr, 1);
                    break;
                case 97:
                    b bVar58 = c2.e;
                    bVar58.q0 = a2.getInt(attr, bVar58.q0);
                    break;
            }
        }
    }

    public final int[] h(View view, String referenceIdString) {
        String[] split = referenceIdString.split(LogUtils.SEPARATOR);
        Context context = view.getContext();
        int[] tags = new int[split.length];
        int count = 0;
        int i = 0;
        while (i < split.length) {
            String idString = split[i].trim();
            int tag = 0;
            try {
                Field field = q6.class.getField(idString);
                tag = field.getInt(null);
            } catch (Exception e2) {
            }
            if (tag == 0) {
                tag = context.getResources().getIdentifier(idString, "id", context.getPackageName());
            }
            if (tag == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view.getParent();
                Object value = constraintLayout.u(0, idString);
                if (value != null && (value instanceof Integer)) {
                    tag = ((Integer) value).intValue();
                }
            }
            tags[count] = tag;
            i++;
            count++;
        }
        int i2 = split.length;
        if (count != i2) {
            return Arrays.copyOf(tags, count);
        }
        return tags;
    }

    public a j(int id) {
        if (this.h.containsKey(Integer.valueOf(id))) {
            return this.h.get(Integer.valueOf(id));
        }
        return null;
    }
}
