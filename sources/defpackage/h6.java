package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
/* compiled from: MotionController.java */
/* renamed from: h6  reason: default package */
/* loaded from: classes.dex */
public class h6 {
    public j6 a;
    public j6 b;
    public g6 c;
    public g6 d;
    public l4[] e;
    public l4 f;
    public float g;
    public float h;
    public int[] i;
    public double[] j;
    public double[] k;
    public String[] l;
    public float[] m;
    public ArrayList<j6> n;
    public float[] o;
    public HashMap<String, a6> p;
    public HashMap<String, z5> q;
    public HashMap<String, y5> r;
    public f6[] s;
    public int t;
    public View u;
    public int v;
    public float w;
    public Interpolator x;
    public boolean y;

    public void b(double p, float[] pos, float[] vel) {
        double[] position = new double[4];
        double[] velocity = new double[4];
        int[] iArr = new int[4];
        this.e[0].b(p, position);
        this.e[0].e(p, velocity);
        Arrays.fill(vel, 0.0f);
        this.a.b(p, this.i, position, pos, velocity, vel);
    }

    public String toString() {
        return " start: x: " + this.a.h + " y: " + this.a.i + " end: x: " + this.b.h + " y: " + this.b.i;
    }

    public final float a(float position, float[] velocity) {
        if (velocity != null) {
            velocity[0] = 1.0f;
        } else {
            float f = this.h;
            if (f != 1.0d) {
                float f2 = this.g;
                if (position < f2) {
                    position = 0.0f;
                }
                if (position > f2 && position < 1.0d) {
                    position = Math.min((position - f2) * f, 1.0f);
                }
            }
        }
        float adjusted = position;
        m4 easing = this.a.b;
        float start = 0.0f;
        float end = Float.NaN;
        Iterator<j6> it = this.n.iterator();
        while (it.hasNext()) {
            j6 frame = it.next();
            if (frame.b != null) {
                if (frame.f < position) {
                    easing = frame.b;
                    start = frame.f;
                } else if (Float.isNaN(end)) {
                    end = frame.f;
                }
            }
        }
        if (easing != null) {
            if (Float.isNaN(end)) {
                end = 1.0f;
            }
            float offset = (position - start) / (end - start);
            float new_offset = (float) easing.a(offset);
            adjusted = ((end - start) * new_offset) + start;
            if (velocity != null) {
                velocity[0] = (float) easing.b(offset);
            }
        }
        return adjusted;
    }

    /* JADX WARN: Incorrect condition in loop: B:27:0x007c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.view.View r22, float r23, long r24, defpackage.n4 r26) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h6.e(android.view.View, float, long, n4):boolean");
    }

    public void c(float position, float locationX, float locationY, float[] mAnchorDpDt) {
        double[] dArr;
        float position2 = a(position, this.o);
        l4[] l4VarArr = this.e;
        if (l4VarArr != null) {
            l4VarArr[0].e(position2, this.k);
            this.e[0].b(position2, this.j);
            float v = this.o[0];
            int i = 0;
            while (true) {
                dArr = this.k;
                if (i >= dArr.length) {
                    break;
                }
                dArr[i] = dArr[i] * v;
                i++;
            }
            l4 l4Var = this.f;
            if (l4Var == null) {
                this.a.c(locationX, locationY, mAnchorDpDt, this.i, dArr, this.j);
                return;
            }
            double[] dArr2 = this.j;
            if (dArr2.length > 0) {
                l4Var.b(position2, dArr2);
                this.f.e(position2, this.k);
                this.a.c(locationX, locationY, mAnchorDpDt, this.i, this.k, this.j);
                return;
            }
            return;
        }
        j6 j6Var = this.b;
        float f = j6Var.h;
        j6 j6Var2 = this.a;
        float dleft = f - j6Var2.h;
        float dTop = j6Var.i - j6Var2.i;
        float dWidth = j6Var.j - j6Var2.j;
        float dHeight = j6Var.k - j6Var2.k;
        float dRight = dleft + dWidth;
        float dBottom = dTop + dHeight;
        mAnchorDpDt[0] = ((1.0f - locationX) * dleft) + (dRight * locationX);
        mAnchorDpDt[1] = ((1.0f - locationY) * dTop) + (dBottom * locationY);
    }

    public void d(float position, int width, int height, float locationX, float locationY, float[] mAnchorDpDt) {
        r4 vmat;
        float position2 = a(position, this.o);
        HashMap<String, z5> hashMap = this.q;
        p4 trans_x = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, z5> hashMap2 = this.q;
        p4 trans_y = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, z5> hashMap3 = this.q;
        p4 rotation = hashMap3 == null ? null : hashMap3.get("rotation");
        HashMap<String, z5> hashMap4 = this.q;
        p4 scale_x = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, z5> hashMap5 = this.q;
        p4 scale_y = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, y5> hashMap6 = this.r;
        y5 osc_x = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, y5> hashMap7 = this.r;
        y5 osc_y = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, y5> hashMap8 = this.r;
        y5 osc_r = hashMap8 == null ? null : hashMap8.get("rotation");
        HashMap<String, y5> hashMap9 = this.r;
        y5 osc_sx = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, y5> hashMap10 = this.r;
        y5 osc_sy = hashMap10 != null ? hashMap10.get("scaleY") : null;
        r4 vmat2 = new r4();
        vmat2.b();
        vmat2.d(rotation, position2);
        vmat2.h(trans_x, trans_y, position2);
        vmat2.f(scale_x, scale_y, position2);
        vmat2.c(osc_r, position2);
        vmat2.g(osc_x, osc_y, position2);
        vmat2.e(osc_sx, osc_sy, position2);
        l4 l4Var = this.f;
        if (l4Var == null) {
            if (this.e != null) {
                float position3 = a(position2, this.o);
                this.e[0].e(position3, this.k);
                this.e[0].b(position3, this.j);
                float v = this.o[0];
                int i = 0;
                while (true) {
                    double[] dArr = this.k;
                    if (i >= dArr.length) {
                        this.a.c(locationX, locationY, mAnchorDpDt, this.i, dArr, this.j);
                        vmat2.a(locationX, locationY, width, height, mAnchorDpDt);
                        return;
                    }
                    dArr[i] = dArr[i] * v;
                    i++;
                }
            } else {
                j6 j6Var = this.b;
                float f = j6Var.h;
                j6 j6Var2 = this.a;
                float dleft = f - j6Var2.h;
                float dTop = j6Var.i - j6Var2.i;
                float dWidth = j6Var.j - j6Var2.j;
                float dHeight = j6Var.k - j6Var2.k;
                float dRight = dleft + dWidth;
                float dBottom = dTop + dHeight;
                mAnchorDpDt[0] = ((1.0f - locationX) * dleft) + (dRight * locationX);
                mAnchorDpDt[1] = ((1.0f - locationY) * dTop) + (dBottom * locationY);
                vmat2.b();
                vmat2.d(rotation, position2);
                vmat2.h(trans_x, trans_y, position2);
                vmat2.f(scale_x, scale_y, position2);
                vmat2.c(osc_r, position2);
                vmat2.g(osc_x, osc_y, position2);
                vmat2.e(osc_sx, osc_sy, position2);
                vmat2.a(locationX, locationY, width, height, mAnchorDpDt);
            }
        } else {
            double[] dArr2 = this.j;
            if (dArr2.length > 0) {
                l4Var.b(position2, dArr2);
                this.f.e(position2, this.k);
                vmat = vmat2;
                this.a.c(locationX, locationY, mAnchorDpDt, this.i, this.k, this.j);
            } else {
                vmat = vmat2;
            }
            vmat.a(locationX, locationY, width, height, mAnchorDpDt);
        }
    }
}
