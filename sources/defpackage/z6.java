package defpackage;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
/* compiled from: ActivityCompat.java */
/* renamed from: z6  reason: default package */
/* loaded from: classes.dex */
public class z6 extends m7 {
    public static void h(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void i(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            activity.recreate();
        } else if (i <= 23) {
            Handler handler = new Handler(activity.getMainLooper());
            handler.post(new a(activity));
        } else if (!a7.i(activity)) {
            activity.recreate();
        }
    }

    /* compiled from: ActivityCompat.java */
    /* renamed from: z6$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Activity a;

        public a(Activity activity) {
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isFinishing() && !a7.i(this.a)) {
                this.a.recreate();
            }
        }
    }
}
