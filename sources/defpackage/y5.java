package defpackage;

import android.view.View;
/* compiled from: ViewOscillator.java */
/* renamed from: y5  reason: default package */
/* loaded from: classes.dex */
public abstract class y5 extends o4 {
    public abstract void c(View view, float f);

    /* compiled from: ViewOscillator.java */
    /* renamed from: y5$a */
    /* loaded from: classes.dex */
    public static class a extends y5 {
        @Override // defpackage.y5
        public void c(View view, float t) {
        }

        public void d(View view, float t, double dx, double dy) {
            view.setRotation(a(t) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
        }
    }
}
