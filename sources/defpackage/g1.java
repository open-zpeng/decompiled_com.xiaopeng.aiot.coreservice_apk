package defpackage;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import defpackage.l1;
import defpackage.y;
/* compiled from: MenuDialogHelper.java */
/* renamed from: g1  reason: default package */
/* loaded from: classes.dex */
public class g1 implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, l1.a {
    public f1 a;
    public y b;
    public d1 d;
    public l1.a f;

    public g1(f1 menu) {
        this.a = menu;
    }

    public void d(IBinder windowToken) {
        f1 menu = this.a;
        y.a builder = new y.a(menu.u());
        d1 d1Var = new d1(builder.b(), t.j);
        this.d = d1Var;
        d1Var.k(this);
        this.a.b(this.d);
        builder.c(this.d.b(), this);
        View headerView = menu.y();
        if (headerView != null) {
            builder.d(headerView);
        } else {
            builder.e(menu.w()).h(menu.x());
        }
        builder.f(this);
        y a = builder.a();
        this.b = a;
        a.setOnDismissListener(this);
        WindowManager.LayoutParams lp = this.b.getWindow().getAttributes();
        lp.type = 1003;
        if (windowToken != null) {
            lp.token = windowToken;
        }
        lp.flags |= OSSConstants.DEFAULT_STREAM_BUFFER_SIZE;
        this.b.show();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        Window win;
        View decor;
        KeyEvent.DispatcherState ds;
        View decor2;
        KeyEvent.DispatcherState ds2;
        if (keyCode == 82 || keyCode == 4) {
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                Window win2 = this.b.getWindow();
                if (win2 != null && (decor2 = win2.getDecorView()) != null && (ds2 = decor2.getKeyDispatcherState()) != null) {
                    ds2.startTracking(event, this);
                    return true;
                }
            } else if (event.getAction() == 1 && !event.isCanceled() && (win = this.b.getWindow()) != null && (decor = win.getDecorView()) != null && (ds = decor.getKeyDispatcherState()) != null && ds.isTracking(event)) {
                this.a.e(true);
                dialog.dismiss();
                return true;
            }
        }
        return this.a.performShortcut(keyCode, event, 0);
    }

    public void c() {
        y yVar = this.b;
        if (yVar != null) {
            yVar.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        this.d.a(this.a, true);
    }

    @Override // defpackage.l1.a
    public void a(f1 menu, boolean allMenusAreClosing) {
        if (allMenusAreClosing || menu == this.a) {
            c();
        }
        l1.a aVar = this.f;
        if (aVar != null) {
            aVar.a(menu, allMenusAreClosing);
        }
    }

    @Override // defpackage.l1.a
    public boolean b(f1 subMenu) {
        l1.a aVar = this.f;
        if (aVar != null) {
            return aVar.b(subMenu);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
        this.a.L((h1) this.d.b().getItem(which), 0);
    }
}
