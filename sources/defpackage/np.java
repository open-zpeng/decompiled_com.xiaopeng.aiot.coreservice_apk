package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.util.ArraySet;
import android.view.MotionEvent;
import defpackage.mp;
import java.util.Iterator;
/* compiled from: XActivityDismissCauseGroup.java */
/* renamed from: np  reason: default package */
/* loaded from: classes.dex */
public abstract class np implements pp, mp.e, mp.i, mp.g, mp.a {
    public abstract void k();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract mp.e o();

    public static np f(Activity activity, mp.d callBack) {
        return new a(activity, callBack);
    }

    /* compiled from: XActivityDismissCauseGroup.java */
    /* renamed from: np$a */
    /* loaded from: classes.dex */
    public static class a extends np {
        public Activity a;
        public mp.e b;
        public mp.i c;
        public mp.g d;
        public mp.a e;
        public ArraySet<pp> f = new ArraySet<>();
        public mp.d g;

        public a(Activity activity, mp.d callBack) {
            this.a = activity;
            this.g = callBack;
        }

        @Override // defpackage.np
        public void l() {
            mp.e b = mp.b(this.a, this.g);
            this.b = b;
            this.f.add(b);
        }

        @Override // defpackage.np
        public void n() {
            mp.i d = mp.d(this.a, this.g);
            this.c = d;
            this.f.add(d);
        }

        @Override // defpackage.np
        public void m() {
            mp.g c = mp.c(this.a, this.g);
            this.d = c;
            this.f.add(c);
        }

        @Override // defpackage.np
        public void k() {
            mp.a a = mp.a(this.a, this.g);
            this.e = a;
            this.f.add(a);
        }

        @Override // defpackage.np
        public mp.e o() {
            return this.b;
        }

        @Override // defpackage.pp
        public void j(Bundle var1) {
            Iterator<pp> it = this.f.iterator();
            while (it.hasNext()) {
                pp lifecycle = it.next();
                lifecycle.j(var1);
            }
        }

        @Override // defpackage.pp
        public void a() {
            Iterator<pp> it = this.f.iterator();
            while (it.hasNext()) {
                pp lifecycle = it.next();
                lifecycle.a();
            }
        }

        @Override // defpackage.pp
        public void c() {
            Iterator<pp> it = this.f.iterator();
            while (it.hasNext()) {
                pp lifecycle = it.next();
                lifecycle.c();
            }
        }

        @Override // defpackage.pp
        public void d() {
            Iterator<pp> it = this.f.iterator();
            while (it.hasNext()) {
                pp lifecycle = it.next();
                lifecycle.d();
            }
        }

        @Override // defpackage.pp
        public void onPause() {
            Iterator<pp> it = this.f.iterator();
            while (it.hasNext()) {
                pp lifecycle = it.next();
                lifecycle.onPause();
            }
        }

        @Override // defpackage.pp
        public void onStop() {
            Iterator<pp> it = this.f.iterator();
            while (it.hasNext()) {
                pp lifecycle = it.next();
                lifecycle.onStop();
            }
        }

        @Override // defpackage.pp
        public void i() {
            Iterator<pp> it = this.f.iterator();
            while (it.hasNext()) {
                pp lifecycle = it.next();
                lifecycle.i();
            }
        }

        @Override // defpackage.mp.a
        public void h() {
            mp.a aVar = this.e;
            if (aVar != null) {
                aVar.h();
            }
        }

        @Override // defpackage.mp.e
        public void g() {
            mp.e eVar = this.b;
            if (eVar != null) {
                eVar.g();
            }
        }

        @Override // defpackage.mp.g
        public boolean e(MotionEvent event) {
            mp.g gVar = this.d;
            return gVar != null && gVar.e(event);
        }

        @Override // defpackage.mp.i
        public void b() {
            mp.i iVar = this.c;
            if (iVar != null) {
                iVar.b();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{ mBackSceneInspect=");
            sb.append(this.e != null ? "has" : "no");
            sb.append(", mOnPauseSceneInspect=");
            sb.append(this.b != null ? "has" : "no");
            sb.append(", mOutSideSceneInspect=");
            sb.append(this.d != null ? "has" : "no");
            sb.append(", mSpeedTimeOutSceneInspect=");
            sb.append(this.c == null ? "no" : "has");
            sb.append('}');
            return sb.toString();
        }
    }
}
