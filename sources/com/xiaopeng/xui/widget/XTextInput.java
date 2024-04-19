package com.xiaopeng.xui.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class XTextInput extends XRelativeLayout implements TextWatcher, View.OnFocusChangeListener {
    public ImageButton b;
    public EditText d;
    public TextView f;
    public View g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public lo p;
    public String q;

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiAction() {
        return super.getVuiAction();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiBizId() {
        return super.getVuiBizId();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
        return super.getVuiDisableHitEffect();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
        return super.getVuiElementChangedListener();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiElementId() {
        return super.getVuiElementId();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ oo getVuiElementType() {
        return super.getVuiElementType();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
        return super.getVuiFatherElementId();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
        return super.getVuiFatherLabel();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
        return super.getVuiFeedbackType();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiLabel() {
        return super.getVuiLabel();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ qo getVuiMode() {
        return super.getVuiMode();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ int getVuiPosition() {
        return super.getVuiPosition();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ ro getVuiPriority() {
        return super.getVuiPriority();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
        return super.getVuiProps();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ Object getVuiValue() {
        return super.getVuiValue();
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
        super.setPerformVuiAction(z);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiAction(String str) {
        super.setVuiAction(str);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
        super.setVuiBizId(str);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
        super.setVuiDisableHitEffect(z);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
        super.setVuiElementChangedListener(koVar);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
        super.setVuiElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
        super.setVuiElementType(ooVar);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
        super.setVuiFatherElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
        super.setVuiFatherLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
        super.setVuiFeedbackType(poVar);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
        super.setVuiLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
        super.setVuiLayoutLoadable(z);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
        super.setVuiMode(qoVar);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
        super.setVuiPosition(i);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
        super.setVuiPriority(roVar);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
        super.setVuiProps(jSONObject);
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
        super.setVuiValue(obj);
    }

    public void setMaxLength(int maxLength) {
        this.d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
    }

    public void setInputType(int inputType) {
        this.d.setInputType(inputType);
    }

    public String getText() {
        return this.d.getText().toString();
    }

    public void setEditHint(CharSequence hint) {
        this.d.setHint(hint);
    }

    public void setEditHint(int resid) {
        this.d.setHint(resid);
    }

    public void setEditContent(CharSequence text) {
        this.d.setText(text);
    }

    public void setEditContent(int resid) {
        this.d.setText(resid);
    }

    public EditText getEditText() {
        return this.d;
    }

    public void setResetEnable(boolean enable) {
        if (this.h != enable) {
            this.h = enable;
            this.b.setVisibility((!enable || this.d.getText().toString().length() <= 0) ? 8 : 0);
        }
    }

    public boolean h() {
        return this.i;
    }

    public void setErrorEnable(boolean enable) {
        if (this.i != enable) {
            this.i = enable;
            this.f.setVisibility(enable ? 0 : 8);
            p();
        }
    }

    public void setErrorMsg(CharSequence errorText) {
        if (!h()) {
            if (TextUtils.isEmpty(errorText)) {
                return;
            }
            setErrorEnable(true);
        }
        if (!TextUtils.isEmpty(errorText)) {
            o(errorText);
        } else {
            d();
        }
        p();
    }

    public final void o(CharSequence errorText) {
        this.f.setText(errorText);
    }

    public final void d() {
        this.f.setText((CharSequence) null);
    }

    public final void f() {
        this.m = getResources().getColor(this.j, getContext().getTheme());
        this.n = getResources().getColor(this.k, getContext().getTheme());
        this.o = getResources().getColor(this.l, getContext().getTheme());
    }

    public void p() {
        Drawable drawable = this.g.getBackground();
        if (drawable == null) {
            return;
        }
        if (i()) {
            drawable.mutate().setTint(this.o);
        } else if (this.d.isFocused()) {
            drawable.mutate().setTint(this.n);
        } else {
            drawable.mutate().setTint(this.m);
        }
    }

    public final boolean i() {
        return h() && !TextUtils.isEmpty(this.f.getText().toString());
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.View
    public void setEnabled(boolean enabled) {
        n(enabled, true);
        if (nq.a()) {
            if (enabled) {
                setAlpha(1.0f);
            } else {
                setAlpha(0.4f);
            }
        }
    }

    public void n(boolean enabled, boolean containChild) {
        super.setEnabled(enabled);
        if (containChild) {
            j(this, enabled);
        }
    }

    public final void j(ViewGroup viewGroup, boolean enabled) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof ViewGroup) {
                j((ViewGroup) view, enabled);
            }
            view.setEnabled(enabled);
            view.setAlpha(1.0f);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!this.h) {
            return;
        }
        if (s.length() > 0) {
            if (this.b.getVisibility() == 0) {
                return;
            }
            this.b.setVisibility(0);
            if (this.p != null && !TextUtils.isEmpty(this.q)) {
                this.p.a(this.q, this.b);
            }
        } else if (this.b.getVisibility() == 8) {
        } else {
            this.b.setVisibility(8);
            if (this.p != null && !TextUtils.isEmpty(this.q)) {
                this.p.a(this.q, this.b);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v, boolean hasFocus) {
        if (v == this.d) {
            p();
        }
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mq.d(newConfig)) {
            f();
            p();
        }
    }
}
