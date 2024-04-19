package defpackage;

import android.app.Application;
import android.content.Context;
/* compiled from: Xui.java */
/* renamed from: cp  reason: default package */
/* loaded from: classes.dex */
public class cp {
    public static Application a;
    public static boolean b;
    public static boolean c;
    public static boolean d;

    public static Context a() {
        Application application = a;
        if (application == null) {
            throw new RuntimeException("Xui must be call Xui#init()!");
        }
        return application;
    }

    public static boolean d() {
        return b;
    }

    public static boolean b() {
        return c;
    }

    public static boolean c() {
        return d;
    }
}
