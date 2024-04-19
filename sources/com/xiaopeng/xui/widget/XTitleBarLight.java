package com.xiaopeng.xui.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XTitleBarLight extends XRelativeLayout implements View.OnClickListener {
    public XImageButton b;
    public XImageButton d;
    public TextView f;
    public ViewGroup g;
    public a h;
    public ViewGroup i;
    public int j;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

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

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        sq.a(this.b, this.i);
        sq.a(this.d, this.i);
    }

    public void setTitle(int res) {
        this.f.setText(res);
    }

    public void setTitle(CharSequence title) {
        this.f.setText(title);
    }

    public void setTitleType(int type) {
        switch (type) {
            case 1:
                TextView textView = this.f;
                textView.setPadding(this.j, textView.getPaddingTop(), this.f.getPaddingRight(), this.f.getPaddingBottom());
                return;
            default:
                TextView textView2 = this.f;
                textView2.setPadding(0, textView2.getPaddingTop(), this.f.getPaddingRight(), this.f.getPaddingBottom());
                return;
        }
    }

    public void setMainAction(int action) {
        switch (action) {
            case -1:
                this.d.setVisibility(4);
                this.b.setVisibility(4);
                return;
            case 0:
            default:
                this.b.setVisibility(0);
                this.d.setVisibility(4);
                return;
            case 1:
                this.d.setVisibility(0);
                this.b.setVisibility(4);
                return;
        }
    }

    public void setRightAction(int layout) {
        View view = LayoutInflater.from(getContext()).inflate(layout, this.g, false);
        setRightAction(view);
    }

    public void setRightAction(View view) {
        this.g.removeAllViews();
        this.g.addView(view);
        this.g.setVisibility(0);
    }

    public void setOnTitleBarClickListener(a l) {
        this.h = l;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        a aVar;
        int id = v.getId();
        if (id == xo.x_titlebar_btn_close) {
            a aVar2 = this.h;
            if (aVar2 != null) {
                aVar2.b();
            }
        } else if (id == xo.x_titlebar_btn_back && (aVar = this.h) != null) {
            aVar.a();
        }
    }
}
