package defpackage;

import android.view.View;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.Arrays;
import java.util.LinkedHashMap;
/* compiled from: MotionPaths.java */
/* renamed from: j6  reason: default package */
/* loaded from: classes.dex */
public class j6 implements Comparable<j6> {
    public static String[] a = {RequestParameters.POSITION, "x", "y", "width", "height", "pathRotate"};
    public m4 b;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int n;
    public int o;
    public float p;
    public h6 q;
    public LinkedHashMap<String, m6> r;
    public int s;
    public double[] t;
    public double[] u;
    public int d = 0;
    public float l = Float.NaN;
    public float m = Float.NaN;

    public j6() {
        int i = e6.a;
        this.n = i;
        this.o = i;
        this.p = Float.NaN;
        this.q = null;
        this.r = new LinkedHashMap<>();
        this.s = 0;
        this.t = new double[18];
        this.u = new double[18];
    }

    public void b(double p, int[] toUse, double[] data, float[] point, double[] vdata, float[] velocity) {
        float v_x = this.h;
        float v_y = this.i;
        float v_width = this.j;
        float v_height = this.k;
        float dv_x = 0.0f;
        float dv_y = 0.0f;
        float dv_width = 0.0f;
        float dv_height = 0.0f;
        for (int i = 0; i < toUse.length; i++) {
            float value = (float) data[i];
            float dvalue = (float) vdata[i];
            switch (toUse[i]) {
                case 1:
                    v_x = value;
                    dv_x = dvalue;
                    break;
                case 2:
                    v_y = value;
                    dv_y = dvalue;
                    break;
                case 3:
                    v_width = value;
                    dv_width = dvalue;
                    break;
                case 4:
                    v_height = value;
                    dv_height = dvalue;
                    break;
            }
        }
        float dangle = (dv_width / 2.0f) + dv_x;
        float dpos_y = (dv_height / 2.0f) + dv_y;
        h6 h6Var = this.q;
        if (h6Var != null) {
            float[] pos = new float[2];
            float[] vel = new float[2];
            h6Var.b(p, pos, vel);
            float rx = pos[0];
            float ry = pos[1];
            float radius = v_x;
            float angle = v_y;
            float dradius = dv_x;
            float dangle2 = dv_y;
            float drx = vel[0];
            float v_x2 = vel[1];
            float v_x3 = (float) ((rx + (radius * Math.sin(angle))) - (v_width / 2.0f));
            float v_y2 = (float) ((ry - (radius * Math.cos(angle))) - (v_height / 2.0f));
            float dpos_x = (float) (drx + (dradius * Math.sin(angle)) + (Math.cos(angle) * dangle2));
            dpos_y = (float) ((v_x2 - (dradius * Math.cos(angle))) + (Math.sin(angle) * dangle2));
            v_y = v_y2;
            dangle = dpos_x;
            v_x = v_x3;
        }
        point[0] = (v_width / 2.0f) + v_x + 0.0f;
        point[1] = (v_height / 2.0f) + v_y + 0.0f;
        velocity[0] = dangle;
        velocity[1] = dpos_y;
    }

    public void d(float position, View view, int[] toUse, double[] data, double[] slope, double[] cycle) {
        float v_x;
        float dangle;
        boolean z;
        boolean z2;
        float v_height;
        float v_y;
        float dv_height;
        float delta_path;
        View view2 = view;
        float v_x2 = this.h;
        float v_y2 = this.i;
        float v_width = this.j;
        float v_height2 = this.k;
        float dv_x = 0.0f;
        float dv_y = 0.0f;
        float dv_width = 0.0f;
        float dv_height2 = 0.0f;
        float delta_path2 = 0.0f;
        float path_rotate = Float.NaN;
        if (toUse.length != 0) {
            v_x = v_x2;
            if (this.t.length <= toUse[toUse.length - 1]) {
                int scratch_data_length = toUse[toUse.length - 1] + 1;
                this.t = new double[scratch_data_length];
                this.u = new double[scratch_data_length];
            }
        } else {
            v_x = v_x2;
        }
        Arrays.fill(this.t, Double.NaN);
        for (int i = 0; i < toUse.length; i++) {
            this.t[toUse[i]] = data[i];
            this.u[toUse[i]] = slope[i];
        }
        int i2 = 0;
        float v_y3 = v_y2;
        float v_width2 = v_width;
        while (true) {
            double[] dArr = this.t;
            if (i2 < dArr.length) {
                if (Double.isNaN(dArr[i2])) {
                    if (cycle == null) {
                        dv_height = dv_height2;
                        delta_path = delta_path2;
                    } else if (cycle[i2] == 0.0d) {
                        dv_height = dv_height2;
                        delta_path = delta_path2;
                    }
                    dv_height2 = dv_height;
                    delta_path2 = delta_path;
                    i2++;
                }
                double deltaCycle = cycle != null ? cycle[i2] : 0.0d;
                if (!Double.isNaN(this.t[i2])) {
                    deltaCycle = this.t[i2] + deltaCycle;
                }
                float value = (float) deltaCycle;
                dv_height = dv_height2;
                delta_path = delta_path2;
                dv_height2 = (float) this.u[i2];
                switch (i2) {
                    case 0:
                        delta_path2 = value;
                        dv_height2 = dv_height;
                        continue;
                        i2++;
                    case 1:
                        dv_x = dv_height2;
                        v_x = value;
                        dv_height2 = dv_height;
                        delta_path2 = delta_path;
                        continue;
                        i2++;
                    case 2:
                        v_y3 = value;
                        dv_y = dv_height2;
                        dv_height2 = dv_height;
                        delta_path2 = delta_path;
                        continue;
                        i2++;
                    case 3:
                        v_width2 = value;
                        dv_width = dv_height2;
                        dv_height2 = dv_height;
                        delta_path2 = delta_path;
                        continue;
                        i2++;
                    case 4:
                        v_height2 = value;
                        delta_path2 = delta_path;
                        continue;
                        i2++;
                    case 5:
                        path_rotate = value;
                        dv_height2 = dv_height;
                        delta_path2 = delta_path;
                        continue;
                        i2++;
                }
                dv_height2 = dv_height;
                delta_path2 = delta_path;
                i2++;
            } else {
                float dv_height3 = dv_height2;
                h6 h6Var = this.q;
                if (h6Var != null) {
                    float[] pos = new float[2];
                    float[] vel = new float[2];
                    h6Var.b(position, pos, vel);
                    float rx = pos[0];
                    float ry = pos[1];
                    float radius = v_x;
                    float angle = v_y3;
                    float dradius = dv_x;
                    float dangle2 = dv_y;
                    float v_y4 = vel[0];
                    float dry = vel[1];
                    float angle2 = path_rotate;
                    float pos_x = (float) ((rx + (radius * Math.sin(angle))) - (v_width2 / 2.0f));
                    float pos_y = (float) ((ry - (radius * Math.cos(angle))) - (v_height2 / 2.0f));
                    v_height = v_height2;
                    dangle = v_width2;
                    float dpos_x = (float) (v_y4 + (dradius * Math.sin(angle)) + (radius * Math.cos(angle) * dangle2));
                    float dpos_y = (float) ((dry - (dradius * Math.cos(angle))) + (radius * Math.sin(angle) * dangle2));
                    v_x = pos_x;
                    if (slope.length < 2) {
                        z2 = true;
                        z = false;
                    } else {
                        z = false;
                        slope[0] = dpos_x;
                        z2 = true;
                        slope[1] = dpos_y;
                    }
                    if (Float.isNaN(angle2)) {
                        view2 = view;
                    } else {
                        float rot = (float) (angle2 + Math.toDegrees(Math.atan2(dpos_y, dpos_x)));
                        view2 = view;
                        view2.setRotation(rot);
                    }
                    v_y = pos_y;
                } else {
                    float v_y5 = v_y3;
                    dangle = v_width2;
                    float dv_x2 = dv_x;
                    float dv_y2 = dv_y;
                    z = false;
                    z2 = true;
                    v_height = v_height2;
                    float v_height3 = dv_width;
                    if (!Float.isNaN(path_rotate)) {
                        float dx = dv_x2 + (v_height3 / 2.0f);
                        float dy = dv_y2 + (dv_height3 / 2.0f);
                        float rot2 = (float) (0.0f + path_rotate + Math.toDegrees(Math.atan2(dy, dx)));
                        view2.setRotation(rot2);
                    }
                    v_y = v_y5;
                }
                if (view2 instanceof d6) {
                    ((d6) view2).a(v_x, v_y, v_x + dangle, v_y + v_height);
                    return;
                }
                int l = (int) (v_x + 0.5f);
                int t = (int) (v_y + 0.5f);
                int r = (int) (v_x + 0.5f + dangle);
                int b = (int) (0.5f + v_y + v_height);
                int i_width = r - l;
                int i_height = b - t;
                if (i_width == view.getMeasuredWidth() && i_height == view.getMeasuredHeight()) {
                    z2 = z;
                }
                boolean remeasure = z2;
                if (remeasure) {
                    int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(i_width, 1073741824);
                    int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(i_height, 1073741824);
                    view2.measure(widthMeasureSpec, heightMeasureSpec);
                }
                view2.layout(l, t, r, b);
                return;
            }
        }
    }

    public void c(float locationX, float locationY, float[] mAnchorDpDt, int[] toUse, double[] deltaData, double[] data) {
        float d_x = 0.0f;
        float d_y = 0.0f;
        float d_width = 0.0f;
        float d_height = 0.0f;
        for (int i = 0; i < toUse.length; i++) {
            float deltaV = (float) deltaData[i];
            float f = (float) data[i];
            switch (toUse[i]) {
                case 1:
                    d_x = deltaV;
                    break;
                case 2:
                    d_y = deltaV;
                    break;
                case 3:
                    d_width = deltaV;
                    break;
                case 4:
                    d_height = deltaV;
                    break;
            }
        }
        float deltaX = d_x - ((0.0f * d_width) / 2.0f);
        float deltaY = d_y - ((0.0f * d_height) / 2.0f);
        float deltaWidth = (0.0f + 1.0f) * d_width;
        float deltaHeight = (0.0f + 1.0f) * d_height;
        float deltaRight = deltaX + deltaWidth;
        float deltaBottom = deltaY + deltaHeight;
        mAnchorDpDt[0] = ((1.0f - locationX) * deltaX) + (deltaRight * locationX) + 0.0f;
        mAnchorDpDt[1] = ((1.0f - locationY) * deltaY) + (deltaBottom * locationY) + 0.0f;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(j6 o) {
        return Float.compare(this.g, o.g);
    }
}
