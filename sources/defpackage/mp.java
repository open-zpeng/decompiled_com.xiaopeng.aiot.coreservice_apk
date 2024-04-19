package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import defpackage.mp;
/* compiled from: XActivityDismissCause.java */
/* renamed from: mp  reason: default package */
/* loaded from: classes.dex */
public class mp {

    /* compiled from: XActivityDismissCause.java */
    /* renamed from: mp$a */
    /* loaded from: classes.dex */
    public interface a extends pp {
        void h();
    }

    /* compiled from: XActivityDismissCause.java */
    /* renamed from: mp$d */
    /* loaded from: classes.dex */
    public interface d {
        void b(int i);
    }

    /* compiled from: XActivityDismissCause.java */
    /* renamed from: mp$e */
    /* loaded from: classes.dex */
    public interface e extends pp {
        void g();
    }

    /* compiled from: XActivityDismissCause.java */
    /* renamed from: mp$g */
    /* loaded from: classes.dex */
    public interface g extends pp {
        boolean e(MotionEvent motionEvent);
    }

    /* compiled from: XActivityDismissCause.java */
    /* renamed from: mp$i */
    /* loaded from: classes.dex */
    public interface i extends pp {
        void b();
    }

    public static a a(Activity activity, d callBack) {
        return new b(activity, callBack);
    }

    public static e b(Activity activity, d callBack) {
        return new f(activity, callBack);
    }

    public static i d(Activity activity, d callBack) {
        return new j(activity, callBack);
    }

    public static g c(Activity activity, d callBack) {
        return new h(activity, callBack);
    }

    /* compiled from: XActivityDismissCause.java */
    /* renamed from: mp$c */
    /* loaded from: classes.dex */
    public static class c {
        public Activity a;
        public d b;

        public c(Activity activity, d callBack) {
            this.a = activity;
            this.b = callBack;
        }

        public void f(int cause) {
            d dVar = this.b;
            if (dVar != null) {
                dVar.b(cause);
            }
        }
    }

    /* compiled from: XActivityDismissCause.java */
    /* renamed from: mp$b */
    /* loaded from: classes.dex */
    public static class b extends c implements a {
        public b(Activity activity, d callBack) {
            super(activity, callBack);
        }

        @Override // defpackage.mp.a
        public void h() {
            rq.e("XActivityDismissCause", "onBackPressed");
            f(1);
        }
    }

    /* compiled from: XActivityDismissCause.java */
    /* renamed from: mp$f */
    /* loaded from: classes.dex */
    public static class f extends c implements e {
        public boolean c;

        public f(Activity activity, d callBack) {
            super(activity, callBack);
            this.c = true;
        }

        @Override // defpackage.pp
        public void d() {
            rq.e("XActivityDismissCause", "onRecreate");
            this.c = false;
        }

        @Override // defpackage.pp
        public void onPause() {
            boolean temp = this.c;
            if (this.c) {
                f(2);
            }
            this.c = true;
            rq.e("XActivityDismissCause", "onPause : last " + temp);
        }

        @Override // defpackage.mp.e
        public void g() {
            rq.e("XActivityDismissCause", "ignoreDismissOneshot mDismissOnPause false");
            this.c = false;
        }
    }

    /* compiled from: XActivityDismissCause.java */
    /* renamed from: mp$h */
    /* loaded from: classes.dex */
    public static class h extends c implements g {
        public boolean c;

        public h(Activity activity, d callBack) {
            super(activity, callBack);
        }

        @Override // defpackage.pp
        public void j(Bundle savedInstanceState) {
            TypedArray array = this.a.getTheme().obtainStyledAttributes(new int[]{16843611});
            this.c = array.getBoolean(0, false);
            array.recycle();
        }

        @Override // defpackage.mp.g
        public boolean e(MotionEvent event) {
            if (l(event)) {
                f(3);
                return true;
            }
            return false;
        }

        public final boolean k(Context context, MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            int slop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
            View decorView = this.a.getWindow().getDecorView();
            return x < (-slop) || y < (-slop) || x > decorView.getWidth() + slop || y > decorView.getHeight() + slop;
        }

        public final boolean l(MotionEvent event) {
            boolean isOutside = (event.getAction() == 0 && k(this.a, event)) || event.getAction() == 4;
            return this.c && isOutside;
        }
    }

    /* compiled from: XActivityDismissCause.java */
    /* renamed from: mp$j */
    /* loaded from: classes.dex */
    public static class j extends c implements i {
        public static final Uri c = Settings.System.getUriFor("key_panel_car_speed");
        public float d;
        public final Handler e;
        public final Runnable f;
        public ContentObserver g;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n */
        public /* synthetic */ void o() {
            float speed = l();
            if (speed > 0.0f) {
                f(4);
            }
        }

        public j(Activity activity, d callBack) {
            super(activity, callBack);
            this.d = 0.0f;
            Handler handler = new Handler();
            this.e = handler;
            this.f = new Runnable() { // from class: gp
                @Override // java.lang.Runnable
                public final void run() {
                    mp.j.this.o();
                }
            };
            this.g = new a(handler);
        }

        @Override // defpackage.pp
        public void c() {
            q(false);
            r(this.a.getApplicationContext());
        }

        @Override // defpackage.pp
        public void onPause() {
            s(this.a.getApplicationContext());
            this.e.removeCallbacks(this.f);
        }

        @Override // defpackage.pp
        public void i() {
            this.e.removeCallbacks(this.f);
        }

        @Override // defpackage.mp.i
        public void b() {
            q(false);
        }

        public final void p() {
            q(true);
        }

        public final void q(boolean fromSpeed) {
            float speed = l();
            boolean changed = true;
            if (fromSpeed) {
                changed = this.d * speed <= 0.0f;
            }
            if (speed <= 0.0f) {
                this.e.removeCallbacks(this.f);
            } else if (changed) {
                this.e.removeCallbacks(this.f);
                this.e.postDelayed(this.f, 30000L);
            }
            this.d = speed;
        }

        public final float l() {
            return m(this.a);
        }

        public static float m(Context context) {
            try {
                return Settings.System.getFloat(context.getContentResolver(), "key_panel_car_speed", 0.0f);
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0f;
            }
        }

        public final void r(Context context) {
            try {
                context.getContentResolver().registerContentObserver(c, true, this.g);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void s(Context context) {
            try {
                context.getContentResolver().unregisterContentObserver(this.g);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* compiled from: XActivityDismissCause.java */
        /* renamed from: mp$j$a */
        /* loaded from: classes.dex */
        public class a extends ContentObserver {
            public a(Handler x0) {
                super(x0);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                super.onChange(selfChange, uri);
                j.this.p();
            }
        }
    }
}
