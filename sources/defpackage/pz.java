package defpackage;

import android.util.Log;
import java.util.logging.Level;
/* compiled from: AndroidLogger.java */
/* renamed from: pz  reason: default package */
/* loaded from: classes.dex */
public class pz implements ez {
    public static final boolean a;
    public final String b;

    static {
        boolean android2 = false;
        try {
            Class.forName("android.util.Log");
            android2 = true;
        } catch (ClassNotFoundException e) {
        }
        a = android2;
    }

    public static boolean c() {
        return a;
    }

    public pz(String tag) {
        this.b = tag;
    }

    @Override // defpackage.ez
    public void a(Level level, String msg) {
        if (level != Level.OFF) {
            Log.println(d(level), this.b, msg);
        }
    }

    @Override // defpackage.ez
    public void b(Level level, String msg, Throwable th) {
        if (level != Level.OFF) {
            int d = d(level);
            String str = this.b;
            Log.println(d, str, msg + "\n" + Log.getStackTraceString(th));
        }
    }

    public final int d(Level level) {
        int value = level.intValue();
        if (value < 800) {
            if (value < 500) {
                return 2;
            }
            return 3;
        } else if (value < 900) {
            return 4;
        } else {
            if (value < 1000) {
                return 5;
            }
            return 6;
        }
    }
}
