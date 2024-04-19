package defpackage;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
/* compiled from: AppCompatPopupWindow.java */
/* renamed from: b2  reason: default package */
/* loaded from: classes.dex */
public class b2 extends PopupWindow {
    public static final boolean a;
    public boolean b;

    static {
        a = Build.VERSION.SDK_INT < 21;
    }

    public b2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        a(context, attrs, defStyleAttr, defStyleRes);
    }

    public final void a(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        z2 a2 = z2.u(context, attrs, w.b2, defStyleAttr, defStyleRes);
        int i = w.d2;
        if (a2.r(i)) {
            b(a2.a(i, false));
        }
        setBackgroundDrawable(a2.f(w.c2));
        a2.v();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        if (a && this.b) {
            yoff -= anchor.getHeight();
        }
        super.showAsDropDown(anchor, xoff, yoff);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        if (a && this.b) {
            yoff -= anchor.getHeight();
        }
        super.showAsDropDown(anchor, xoff, yoff, gravity);
    }

    @Override // android.widget.PopupWindow
    public void update(View anchor, int xoff, int yoff, int width, int height) {
        if (a && this.b) {
            yoff -= anchor.getHeight();
        }
        super.update(anchor, xoff, yoff, width, height);
    }

    public final void b(boolean overlapAnchor) {
        if (a) {
            this.b = overlapAnchor;
        } else {
            fb.a(this, overlapAnchor);
        }
    }
}
