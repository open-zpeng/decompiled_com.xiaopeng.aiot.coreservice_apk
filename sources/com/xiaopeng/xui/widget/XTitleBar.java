package com.xiaopeng.xui.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes.dex */
public class XTitleBar extends XLinearLayout implements View.OnClickListener {
    public XImageButton b;
    public XImageButton d;
    public TextView f;
    public ViewGroup g;
    public a h;
    public ViewGroup i;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c(View view, int i);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiAction() {
        return super.getVuiAction();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiBizId() {
        return super.getVuiBizId();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
        return super.getVuiDisableHitEffect();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
        return super.getVuiElementChangedListener();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiElementId() {
        return super.getVuiElementId();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ oo getVuiElementType() {
        return super.getVuiElementType();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
        return super.getVuiFatherElementId();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
        return super.getVuiFatherLabel();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
        return super.getVuiFeedbackType();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiLabel() {
        return super.getVuiLabel();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ qo getVuiMode() {
        return super.getVuiMode();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ int getVuiPosition() {
        return super.getVuiPosition();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ ro getVuiPriority() {
        return super.getVuiPriority();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
        return super.getVuiProps();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ Object getVuiValue() {
        return super.getVuiValue();
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
        super.setPerformVuiAction(z);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiAction(String str) {
        super.setVuiAction(str);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
        super.setVuiBizId(str);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
        super.setVuiDisableHitEffect(z);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
        super.setVuiElementChangedListener(koVar);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
        super.setVuiElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
        super.setVuiElementType(ooVar);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
        super.setVuiFatherElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
        super.setVuiFatherLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
        super.setVuiFeedbackType(poVar);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
        super.setVuiLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
        super.setVuiLayoutLoadable(z);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
        super.setVuiMode(qoVar);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
        super.setVuiPosition(i);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
        super.setVuiPriority(roVar);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
        super.setVuiProps(jSONObject);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
        super.setVuiValue(obj);
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        sq.a(this.b, this.i);
    }

    public final void f(int... action) {
        if (action != null) {
            for (int i = 0; i < action.length; i++) {
                ImageButton icon = (ImageButton) LayoutInflater.from(getContext()).inflate(yo.x_titlebar_action_icon, this.g, false);
                icon.setImageResource(action[i]);
                icon.setOnClickListener(this);
                icon.setId(i);
                this.g.addView(icon);
            }
        }
    }

    public final void d(CharSequence... action) {
        for (int i = 0; i < action.length; i++) {
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(yo.x_titlebar_action_ghostbtn, this.g, false);
            textView.setOnClickListener(this);
            textView.setId(i);
            textView.setText(action[i]);
            this.g.addView(textView);
        }
    }

    public void setTitle(CharSequence title) {
        this.f.setText(title);
    }

    public void setCloseVisibility(int visibility) {
        this.b.setVisibility(visibility);
    }

    public void setBackVisibility(int visibility) {
        this.d.setVisibility(visibility);
    }

    public void setActionWithIcon(int action1) {
        this.g.removeAllViews();
        f(action1);
        this.g.setVisibility(0);
    }

    public void setActionWithButton(CharSequence text) {
        this.g.removeAllViews();
        d(text);
        this.g.setVisibility(0);
    }

    public void setActionWithCustom(int layout) {
        View view = LayoutInflater.from(getContext()).inflate(layout, this.g, false);
        setActionWithCustom(view);
    }

    public void setActionWithCustom(View view) {
        this.g.removeAllViews();
        this.g.addView(view);
        this.g.setVisibility(0);
    }

    public void setOnTitleBarClickListener(a l) {
        this.h = l;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == xo.x_titlebar_btn_close) {
            a aVar = this.h;
            if (aVar != null) {
                aVar.b();
            }
        } else if (id == xo.x_titlebar_btn_back) {
            a aVar2 = this.h;
            if (aVar2 != null) {
                aVar2.a();
            }
        } else {
            a aVar3 = this.h;
            if (aVar3 != null) {
                aVar3.c(v, id);
            }
        }
    }
}
