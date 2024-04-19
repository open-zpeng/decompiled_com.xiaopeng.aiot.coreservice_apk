package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
/* compiled from: ActionBarPolicy.java */
/* renamed from: q0  reason: default package */
/* loaded from: classes.dex */
public class q0 {
    public Context a;

    public static q0 b(Context context) {
        return new q0(context);
    }

    public q0(Context context) {
        this.a = context;
    }

    public int d() {
        Configuration configuration = this.a.getResources().getConfiguration();
        int widthDp = configuration.screenWidthDp;
        int heightDp = configuration.screenHeightDp;
        int smallest = configuration.smallestScreenWidthDp;
        if (smallest > 600 || widthDp > 600) {
            return 5;
        }
        if (widthDp <= 960 || heightDp <= 720) {
            if (widthDp > 720 && heightDp > 960) {
                return 5;
            }
            if (widthDp < 500) {
                if (widthDp <= 640 || heightDp <= 480) {
                    if (widthDp > 480 && heightDp > 640) {
                        return 4;
                    }
                    if (widthDp >= 360) {
                        return 3;
                    }
                    return 2;
                }
                return 4;
            }
            return 4;
        }
        return 5;
    }

    public boolean h() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.a).hasPermanentMenuKey();
    }

    public int c() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean g() {
        return this.a.getResources().getBoolean(o.a);
    }

    public int f() {
        TypedArray a = this.a.obtainStyledAttributes(null, w.a, n.c, 0);
        int height = a.getLayoutDimension(w.j, 0);
        Resources r = this.a.getResources();
        if (!g()) {
            height = Math.min(height, r.getDimensionPixelSize(q.a));
        }
        a.recycle();
        return height;
    }

    public boolean a() {
        return this.a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int e() {
        return this.a.getResources().getDimensionPixelSize(q.b);
    }
}
