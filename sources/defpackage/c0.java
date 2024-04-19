package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import defpackage.q9;
import defpackage.r0;
/* compiled from: AppCompatDialog.java */
/* renamed from: c0  reason: default package */
/* loaded from: classes.dex */
public class c0 extends Dialog implements z {
    public a0 a;
    public final q9.a b;

    /* compiled from: AppCompatDialog.java */
    /* renamed from: c0$a */
    /* loaded from: classes.dex */
    public class a implements q9.a {
        public a() {
        }

        @Override // defpackage.q9.a
        public boolean d(KeyEvent event) {
            return c0.this.c(event);
        }
    }

    public c0(Context context, int theme) {
        super(context, b(context, theme));
        this.b = new a();
        a0 delegate = a();
        delegate.E(b(context, theme));
        delegate.r(null);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        a().o();
        super.onCreate(savedInstanceState);
        a().r(savedInstanceState);
    }

    @Override // android.app.Dialog
    public void setContentView(int layoutResID) {
        a().B(layoutResID);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().C(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        a().D(view, params);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int id) {
        return (T) a().j(id);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        a().F(title);
    }

    @Override // android.app.Dialog
    public void setTitle(int titleId) {
        super.setTitle(titleId);
        a().F(getContext().getString(titleId));
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        a().d(view, params);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        a().x();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a().s();
    }

    public boolean d(int featureId) {
        return a().A(featureId);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().p();
    }

    public a0 a() {
        if (this.a == null) {
            this.a = a0.h(this, this);
        }
        return this.a;
    }

    public static int b(Context context, int themeId) {
        if (themeId == 0) {
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(n.y, outValue, true);
            return outValue.resourceId;
        }
        return themeId;
    }

    @Override // defpackage.z
    public void e(r0 mode) {
    }

    @Override // defpackage.z
    public void f(r0 mode) {
    }

    @Override // defpackage.z
    public r0 j(r0.a callback) {
        return null;
    }

    public boolean c(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        View decor = getWindow().getDecorView();
        return q9.e(this.b, decor, this, event);
    }
}
