package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
/* compiled from: AlertDialog.java */
/* renamed from: y  reason: default package */
/* loaded from: classes.dex */
public class y extends c0 implements DialogInterface {
    public final AlertController d;

    public y(Context context, int themeResId) {
        super(context, h(context, themeResId));
        this.d = new AlertController(getContext(), this, getWindow());
    }

    public static int h(Context context, int resid) {
        if (((resid >>> 24) & 255) >= 1) {
            return resid;
        }
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(n.o, outValue, true);
        return outValue.resourceId;
    }

    public ListView g() {
        return this.d.d();
    }

    @Override // defpackage.c0, android.app.Dialog
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        this.d.q(title);
    }

    @Override // defpackage.c0, android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.d.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.d.g(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.d.h(keyCode, event)) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    /* compiled from: AlertDialog.java */
    /* renamed from: y$a */
    /* loaded from: classes.dex */
    public static class a {
        public final AlertController.f a;
        public final int b;

        public a(Context context) {
            this(context, y.h(context, 0));
        }

        public a(Context context, int themeResId) {
            this.a = new AlertController.f(new ContextThemeWrapper(context, y.h(context, themeResId)));
            this.b = themeResId;
        }

        public Context b() {
            return this.a.a;
        }

        public a h(CharSequence title) {
            this.a.f = title;
            return this;
        }

        public a d(View customTitleView) {
            this.a.g = customTitleView;
            return this;
        }

        public a e(Drawable icon) {
            this.a.d = icon;
            return this;
        }

        public a f(DialogInterface.OnKeyListener onKeyListener) {
            this.a.u = onKeyListener;
            return this;
        }

        public a c(ListAdapter adapter, DialogInterface.OnClickListener listener) {
            AlertController.f fVar = this.a;
            fVar.w = adapter;
            fVar.x = listener;
            return this;
        }

        public a g(ListAdapter adapter, int checkedItem, DialogInterface.OnClickListener listener) {
            AlertController.f fVar = this.a;
            fVar.w = adapter;
            fVar.x = listener;
            fVar.I = checkedItem;
            fVar.H = true;
            return this;
        }

        public y a() {
            y dialog = new y(this.a.a, this.b);
            this.a.a(dialog.d);
            dialog.setCancelable(this.a.r);
            if (this.a.r) {
                dialog.setCanceledOnTouchOutside(true);
            }
            dialog.setOnCancelListener(this.a.s);
            dialog.setOnDismissListener(this.a.t);
            DialogInterface.OnKeyListener onKeyListener = this.a.u;
            if (onKeyListener != null) {
                dialog.setOnKeyListener(onKeyListener);
            }
            return dialog;
        }
    }
}
