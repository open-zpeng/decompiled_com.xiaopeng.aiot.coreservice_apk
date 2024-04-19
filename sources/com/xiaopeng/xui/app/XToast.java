package com.xiaopeng.xui.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.xiaopeng.xui.app.XToast;
import com.xiaopeng.xui.widget.XTextView;
import defpackage.fo;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XToast {
    public static Context b() {
        return cp.a();
    }

    public static void e(CharSequence msg) {
        int size = a(msg);
        if (size > 8) {
            i(msg);
        } else {
            j(msg);
        }
    }

    public static void j(CharSequence msg) {
        f(msg, 0);
    }

    public static void i(CharSequence msg) {
        f(msg, 1);
    }

    public static void f(CharSequence msg, int duration) {
        g(msg, duration, -1);
    }

    public static void g(CharSequence msg, int duration, int sharedId) {
        h(msg, duration, sharedId, 0);
    }

    public static void h(CharSequence msg, int duration, int sharedId, int iconId) {
        Toast toast = d(yo.x_toast);
        View view = toast.getView();
        XToastTextView textView = (XToastTextView) view.findViewById(xo.textView);
        textView.setIcon(iconId);
        toast.setDuration(duration);
        if (cp.c()) {
            textView.setElevation(0.0f);
        } else {
            textView.setElevation(12.0f);
        }
        textView.setText(msg);
        if (sharedId != -1) {
            c(toast, sharedId);
        }
        toast.show();
    }

    public static void c(Toast toast, int sharedId) {
        try {
            Method method = Toast.class.getMethod("setSharedId", Integer.TYPE);
            method.invoke(toast, Integer.valueOf(sharedId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Toast d(int layoutId) {
        Context context = b();
        View view = LayoutInflater.from(context).inflate(layoutId, (ViewGroup) null);
        Toast toast = new Toast(context);
        toast.setGravity(8388661, 0, 0);
        toast.setView(view);
        return toast;
    }

    public static int a(CharSequence msg) {
        if (msg == null) {
            return 0;
        }
        String[] parts = msg.toString().trim().split(" ");
        int count = 0;
        for (String part : parts) {
            if (part.trim().length() != 0) {
                boolean hasFull = false;
                int lastCharacterType = -1;
                for (int i = 0; i < part.length(); i++) {
                    char c = part.charAt(i);
                    if (qq.a(c)) {
                        if (lastCharacterType == 0) {
                            count++;
                        }
                        lastCharacterType = 1;
                        count++;
                        hasFull = true;
                    } else {
                        lastCharacterType = 0;
                    }
                }
                if (hasFull) {
                    if (lastCharacterType == 0) {
                        count++;
                    }
                } else {
                    count++;
                }
            }
        }
        return count;
    }

    /* loaded from: classes.dex */
    public static class XToastTextView extends XTextView {
        public int i;

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ String getVuiAction() {
            return super.getVuiAction();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ String getVuiBizId() {
            return super.getVuiBizId();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
            return super.getVuiDisableHitEffect();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
            return super.getVuiElementChangedListener();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ String getVuiElementId() {
            return super.getVuiElementId();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ oo getVuiElementType() {
            return super.getVuiElementType();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
            return super.getVuiFatherElementId();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
            return super.getVuiFatherLabel();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
            return super.getVuiFeedbackType();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ String getVuiLabel() {
            return super.getVuiLabel();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ qo getVuiMode() {
            return super.getVuiMode();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ int getVuiPosition() {
            return super.getVuiPosition();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ ro getVuiPriority() {
            return super.getVuiPriority();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
            return super.getVuiProps();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ Object getVuiValue() {
            return super.getVuiValue();
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
            super.setPerformVuiAction(z);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiAction(String str) {
            super.setVuiAction(str);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
            super.setVuiBizId(str);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
            super.setVuiDisableHitEffect(z);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
            super.setVuiElementChangedListener(koVar);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
            super.setVuiElementId(str);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
            super.setVuiElementType(ooVar);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
            super.setVuiFatherElementId(str);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
            super.setVuiFatherLabel(str);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
            super.setVuiFeedbackType(poVar);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
            super.setVuiLabel(str);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
            super.setVuiLayoutLoadable(z);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
            super.setVuiMode(qoVar);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
            super.setVuiPosition(i);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
            super.setVuiPriority(roVar);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
            super.setVuiProps(jSONObject);
        }

        @Override // com.xiaopeng.xui.widget.XTextView, defpackage.dr
        public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
            super.setVuiValue(obj);
        }

        public XToastTextView(Context context, AttributeSet attrs) {
            super(context, attrs);
            uq uqVar = this.h;
            if (uqVar != null && uqVar.e() != null) {
                this.h.e().a(new fo.a() { // from class: dp
                    @Override // defpackage.fo.a
                    public final void a() {
                        XToast.XToastTextView.this.o();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n */
        public /* synthetic */ void o() {
            if (this.i != 0) {
                a("XToast onThemeChanged !!! ");
                setCompoundDrawablesWithIntrinsicBounds(this.i, 0, 0, 0);
            }
        }

        public void setIcon(int icon) {
            this.i = icon;
            setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
        }
    }
}
