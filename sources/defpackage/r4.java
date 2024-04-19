package defpackage;
/* compiled from: VelocityMatrix.java */
/* renamed from: r4  reason: default package */
/* loaded from: classes.dex */
public class r4 {
    public static String a = "VelocityMatrix";
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;

    public void b() {
        this.f = 0.0f;
        this.e = 0.0f;
        this.d = 0.0f;
        this.c = 0.0f;
        this.b = 0.0f;
    }

    public void d(p4 rot, float position) {
        if (rot != null) {
            this.f = rot.b(position);
            this.g = rot.a(position);
        }
    }

    public void h(p4 trans_x, p4 trans_y, float position) {
        if (trans_x != null) {
            this.d = trans_x.b(position);
        }
        if (trans_y != null) {
            this.e = trans_y.b(position);
        }
    }

    public void f(p4 scale_x, p4 scale_y, float position) {
        if (scale_x != null) {
            this.b = scale_x.b(position);
        }
        if (scale_y != null) {
            this.c = scale_y.b(position);
        }
    }

    public void c(o4 osc_r, float position) {
        if (osc_r != null) {
            this.f = osc_r.b(position);
        }
    }

    public void g(o4 osc_x, o4 osc_y, float position) {
        if (osc_x != null) {
            this.d = osc_x.b(position);
        }
        if (osc_y != null) {
            this.e = osc_y.b(position);
        }
    }

    public void e(o4 osc_sx, o4 osc_sy, float position) {
        if (osc_sx != null) {
            this.b = osc_sx.b(position);
        }
        if (osc_sy != null) {
            this.c = osc_sy.b(position);
        }
    }

    public void a(float locationX, float locationY, int width, int height, float[] mAnchorDpDt) {
        float dx = mAnchorDpDt[0];
        float dy = mAnchorDpDt[1];
        float offx = (locationX - 0.5f) * 2.0f;
        float offy = (locationY - 0.5f) * 2.0f;
        float dx2 = dx + this.d;
        float dy2 = dy + this.e;
        float dx3 = dx2 + (this.b * offx);
        float dy3 = dy2 + (this.c * offy);
        float r = (float) Math.toRadians(this.g);
        float dr = (float) Math.toRadians(this.f);
        mAnchorDpDt[0] = dx3 + (((float) ((((-width) * offx) * Math.sin(r)) - ((height * offy) * Math.cos(r)))) * dr);
        mAnchorDpDt[1] = dy3 + (((float) (((width * offx) * Math.cos(r)) - ((height * offy) * Math.sin(r)))) * dr);
    }
}
