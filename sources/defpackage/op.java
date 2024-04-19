package defpackage;

import android.app.Activity;
import android.os.Handler;
import defpackage.lp;
import defpackage.op;
/* compiled from: XActivityDismissExtend.java */
/* renamed from: op  reason: default package */
/* loaded from: classes.dex */
public abstract class op implements lp, pp {

    /* compiled from: XActivityDismissExtend.java */
    /* renamed from: op$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i);

        void c(int i);
    }

    public abstract void l(a aVar);

    public static op k(Activity activity) {
        return new b(activity);
    }

    /* compiled from: XActivityDismissExtend.java */
    /* renamed from: op$b */
    /* loaded from: classes.dex */
    public static class b extends op {
        public Activity a;
        public int b = 0;
        public long c = 0;
        public final Handler d = new Handler();
        public Runnable e;
        public lp.a f;
        public a g;

        public b(Activity activity) {
            this.a = activity;
        }

        @Override // defpackage.op
        public void l(a listenerEx) {
            this.g = listenerEx;
        }

        @Override // defpackage.lp
        public void f(final int cause) {
            lp.a aVar = this.f;
            if (aVar != null && aVar.a(cause, this.b)) {
                rq.e("XActivityDismiss", "dismiss: intercept for " + n(cause));
                return;
            }
            a aVar2 = this.g;
            if (aVar2 != null) {
                aVar2.c(cause);
            }
            if (this.c == 0) {
                m(cause);
                return;
            }
            rq.e("XActivityDismiss", "dismiss: type : " + o(this.b) + " , cause : " + n(cause) + " " + this.e);
            if (this.e == null) {
                Runnable runnable = new Runnable() { // from class: hp
                    @Override // java.lang.Runnable
                    public final void run() {
                        op.b.this.q(cause);
                    }
                };
                this.e = runnable;
                this.d.postDelayed(runnable, this.c);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ void q(int cause) {
            m(cause);
            this.e = null;
            a aVar = this.g;
            if (aVar != null) {
                aVar.a(cause);
            }
        }

        @Override // defpackage.pp
        public void i() {
            Runnable runnable = this.e;
            if (runnable != null) {
                this.d.removeCallbacks(runnable);
                this.e = null;
            }
        }

        public final void m(int cause) {
            rq.e("XActivityDismiss", "_dismiss: type : " + o(this.b) + " , cause : " + n(cause));
            int type = this.b;
            switch (type) {
                case 0:
                    oq.a(this.a);
                    return;
                case 1:
                    oq.b(this.a, true);
                    return;
                default:
                    return;
            }
        }

        public final String n(int cause) {
            switch (cause) {
                case 1:
                    return "back";
                case 2:
                    return "pause";
                case 3:
                    return "outside";
                case 4:
                    return "timeout";
                default:
                    return "user";
            }
        }

        public final String o(int type) {
            switch (type) {
                case 1:
                    return "moveToBack";
                default:
                    return "finish";
            }
        }

        public String toString() {
            return "{mDismissType=" + this.b + ", mDismissDelay=" + this.c + '}';
        }
    }
}
