package defpackage;

import android.view.View;
/* compiled from: ViewSpline.java */
/* renamed from: z5  reason: default package */
/* loaded from: classes.dex */
public abstract class z5 extends p4 {
    public abstract void c(View view, float f);

    /* compiled from: ViewSpline.java */
    /* renamed from: z5$a */
    /* loaded from: classes.dex */
    public static class a extends z5 {
        @Override // defpackage.z5
        public void c(View view, float t) {
        }

        public void d(View view, float t, double dx, double dy) {
            view.setRotation(a(t) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
        }
    }
}
