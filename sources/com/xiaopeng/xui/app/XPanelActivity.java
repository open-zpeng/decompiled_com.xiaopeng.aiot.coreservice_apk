package com.xiaopeng.xui.app;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
/* loaded from: classes.dex */
public class XPanelActivity extends AppCompatActivity {
    public static final Uri t = Settings.System.getUriFor("key_panel_car_speed");
    public long A;
    public boolean B;
    public int C;
    public d D;
    public ContentObserver E;
    public float u = 0.0f;
    public final Runnable v = new a();
    public final Handler w;
    public boolean x;
    public boolean y;
    public float z;

    public XPanelActivity() {
        Handler handler = new Handler();
        this.w = handler;
        this.x = false;
        this.y = true;
        this.z = 0.6f;
        this.A = 0L;
        this.B = false;
        this.C = 0;
        this.E = new c(handler);
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            XPanelActivity.this.R();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(14);
        super.onCreate(savedInstanceState);
        this.D = new d(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        int orientation = getResources().getConfiguration().orientation;
        int x = O(this, vo.x_compat_app_panel_x);
        int y = O(this, vo.x_compat_app_panel_y);
        int width = O(this, vo.x_compat_app_panel_width);
        int height = O(this, vo.x_compat_app_panel_height);
        switch (orientation) {
            case 1:
                P().f(x).g(y).e(width).d(height).c(80).a();
                return;
            case 2:
                P().f(x).g(y).e(width).d(height).c(49).a();
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        W(false);
        T(true);
        X(getApplicationContext());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        T(false);
        a0(getApplicationContext());
        if (this.y) {
            S();
        }
        this.y = true;
    }

    @Override // android.app.Activity
    public void recreate() {
        super.recreate();
        this.y = false;
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent event) {
        if (Z(this, event)) {
            S();
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        W(false);
        return super.dispatchTouchEvent(ev);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean nonRoot) {
        return super.moveTaskToBack(nonRoot);
    }

    public d P() {
        return this.D;
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a) {
                case 0:
                    ep.a(XPanelActivity.this);
                    return;
                case 1:
                    ep.b(XPanelActivity.this, true);
                    return;
                default:
                    return;
            }
        }
    }

    public void S() {
        int type = this.C;
        Runnable r = new b(type);
        T(false);
        this.w.postDelayed(r, this.A);
    }

    public void T(boolean visible) {
        if (this.B) {
            Y(visible);
        }
    }

    public final void Y(boolean visible) {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams lp = window.getAttributes();
            if (lp != null) {
                lp.alpha = visible ? 1.0f : 0.0f;
                lp.dimAmount = visible ? this.z : 0.0f;
            }
            window.setAttributes(lp);
        }
    }

    public final void R() {
        float speed = Q();
        if (speed > 0.0f) {
            S();
        }
    }

    public final void W(boolean fromSpeed) {
        float speed = Q();
        boolean changed = true;
        if (fromSpeed) {
            changed = this.u * speed <= 0.0f;
        }
        if (speed <= 0.0f) {
            this.w.removeCallbacks(this.v);
        } else if (changed) {
            this.w.removeCallbacks(this.v);
            this.w.postDelayed(this.v, 30000L);
        }
        this.u = speed;
    }

    public final float Q() {
        try {
            return Settings.System.getFloat(getContentResolver(), "key_panel_car_speed", 0.0f);
        } catch (Exception e) {
            return 0.0f;
        }
    }

    public final boolean U(Context context, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int slop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        View decorView = getWindow().getDecorView();
        return x < (-slop) || y < (-slop) || x > decorView.getWidth() + slop || y > decorView.getHeight() + slop;
    }

    public final boolean Z(Context context, MotionEvent event) {
        boolean isOutside = (event.getAction() == 0 && U(context, event)) || event.getAction() == 4;
        View decorView = getWindow().getDecorView();
        return this.x && decorView != null && isOutside;
    }

    public final void V() {
        W(true);
    }

    public final void X(Context context) {
        try {
            context.getContentResolver().registerContentObserver(t, true, this.E);
        } catch (Exception e) {
        }
    }

    public final void a0(Context context) {
        try {
            context.getContentResolver().unregisterContentObserver(this.E);
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public class c extends ContentObserver {
        public c(Handler x0) {
            super(x0);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange, uri);
            XPanelActivity.this.V();
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public final Activity h;

        public d(Activity activity) {
            this.h = activity;
            b();
        }

        public final void b() {
            WindowManager.LayoutParams lp;
            Activity activity = this.h;
            if (activity != null && activity.getWindow() != null && (lp = this.h.getWindow().getAttributes()) != null) {
                this.a = lp.x;
                this.b = lp.y;
                this.c = lp.flags;
                this.d = lp.width;
                this.e = lp.height;
                this.f = lp.gravity;
                this.g = lp.systemUiVisibility;
            }
        }

        public void a() {
            WindowManager.LayoutParams lp;
            Activity activity = this.h;
            if (activity != null && activity.getWindow() != null && (lp = this.h.getWindow().getAttributes()) != null) {
                lp.x = this.a;
                lp.y = this.b;
                lp.flags |= this.c;
                lp.width = this.d;
                lp.height = this.e;
                lp.gravity = this.f;
                lp.systemUiVisibility |= this.g;
                this.h.getWindow().setAttributes(lp);
            }
        }

        public d f(int x) {
            this.a = x;
            return this;
        }

        public d g(int y) {
            this.b = y;
            return this;
        }

        public d e(int width) {
            this.d = width;
            return this;
        }

        public d d(int height) {
            this.e = height;
            return this;
        }

        public d c(int gravity) {
            this.f = gravity;
            return this;
        }
    }

    public static int O(Context context, int id) {
        float scale = context.getResources().getDisplayMetrics().density;
        float value = context.getResources().getDimension(id);
        return (int) ((value * scale) + 0.5f);
    }
}
