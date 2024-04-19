package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.ScrollingTabContainerView;
import defpackage.l1;
/* compiled from: DecorToolbar.java */
/* renamed from: j2  reason: default package */
/* loaded from: classes.dex */
public interface j2 {
    void a(Menu menu, l1.a aVar);

    boolean b();

    void c();

    void collapseActionView();

    boolean d();

    boolean e();

    boolean f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    void h();

    void i(int i);

    void j(ScrollingTabContainerView scrollingTabContainerView);

    ViewGroup k();

    void l(boolean z);

    boolean m();

    void n(int i);

    int o();

    void p(int i);

    int q();

    ka r(int i, long j);

    void s();

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t();

    void u(boolean z);
}
