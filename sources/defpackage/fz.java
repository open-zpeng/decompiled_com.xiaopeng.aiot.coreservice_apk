package defpackage;

import android.os.Looper;
/* compiled from: MainThreadSupport.java */
/* renamed from: fz  reason: default package */
/* loaded from: classes.dex */
public interface fz {
    jz a(az azVar);

    boolean b();

    /* compiled from: MainThreadSupport.java */
    /* renamed from: fz$a */
    /* loaded from: classes.dex */
    public static class a implements fz {
        public final Looper a;

        public a(Looper looper) {
            this.a = looper;
        }

        @Override // defpackage.fz
        public boolean b() {
            return this.a == Looper.myLooper();
        }

        @Override // defpackage.fz
        public jz a(az eventBus) {
            return new dz(eventBus, this.a, 10);
        }
    }
}
