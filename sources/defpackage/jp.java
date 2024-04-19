package defpackage;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
/* compiled from: XActivityDelegate.java */
/* renamed from: jp  reason: default package */
/* loaded from: classes.dex */
public abstract class jp {
    public abstract boolean e(MotionEvent motionEvent);

    public abstract void f();

    public abstract void g();

    public abstract void h(Configuration configuration);

    public abstract void i(Bundle bundle);

    public abstract void j();

    public abstract void k();

    public abstract void l(Bundle bundle);

    public abstract void m();

    public abstract void n();

    public abstract void o(Bundle bundle);

    public abstract void p();

    public abstract void q();

    public abstract boolean r(MotionEvent motionEvent);

    public static jp d(AppCompatActivity activity) {
        return new kp(activity);
    }
}
