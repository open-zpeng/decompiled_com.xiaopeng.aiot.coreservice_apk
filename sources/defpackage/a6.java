package defpackage;

import android.view.View;
/* compiled from: ViewTimeCycle.java */
/* renamed from: a6  reason: default package */
/* loaded from: classes.dex */
public abstract class a6 extends q4 {
    public abstract boolean c(View view, float f, long j, n4 n4Var);

    public float b(float pos, long time, View view, n4 cache) {
        this.b.c(pos, this.h);
        float[] fArr = this.h;
        boolean z = true;
        float period = fArr[1];
        if (period == 0.0f) {
            this.i = false;
            return fArr[2];
        }
        if (Float.isNaN(this.k)) {
            float a2 = cache.a(view, this.g, 0);
            this.k = a2;
            if (Float.isNaN(a2)) {
                this.k = 0.0f;
            }
        }
        long delta_time = time - this.j;
        float f = (float) ((this.k + ((delta_time * 1.0E-9d) * period)) % 1.0d);
        this.k = f;
        cache.b(view, this.g, 0, f);
        this.j = time;
        float v = this.h[0];
        float wave = a(this.k);
        float offset = this.h[2];
        float value = (v * wave) + offset;
        if (v == 0.0f && period == 0.0f) {
            z = false;
        }
        this.i = z;
        return value;
    }

    /* compiled from: ViewTimeCycle.java */
    /* renamed from: a6$a */
    /* loaded from: classes.dex */
    public static class a extends a6 {
        @Override // defpackage.a6
        public boolean c(View view, float t, long time, n4 cache) {
            return this.i;
        }

        public boolean d(View view, n4 cache, float t, long time, double dx, double dy) {
            view.setRotation(b(t, time, view, cache) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
            return this.i;
        }
    }
}
