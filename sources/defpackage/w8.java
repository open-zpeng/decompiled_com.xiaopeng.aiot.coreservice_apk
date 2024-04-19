package defpackage;

import android.os.Handler;
import android.os.Looper;
/* compiled from: CalleeHandler.java */
/* renamed from: w8  reason: default package */
/* loaded from: classes.dex */
public class w8 {
    public static Handler a() {
        if (Looper.myLooper() == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            return handler;
        }
        Handler handler2 = new Handler();
        return handler2;
    }
}
