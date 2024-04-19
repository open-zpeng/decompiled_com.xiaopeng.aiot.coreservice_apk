package com.xiaopeng.xui.widget.pageindicator;

import android.content.res.Configuration;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XNumberPagerIndicator extends XViewPagerIndicatorAbs {
    public int i;
    public int j;
    public TextView k;
    public String l;
    public int m;

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiAction() {
        return super.getVuiAction();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiBizId() {
        return super.getVuiBizId();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
        return super.getVuiDisableHitEffect();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
        return super.getVuiElementChangedListener();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiElementId() {
        return super.getVuiElementId();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ oo getVuiElementType() {
        return super.getVuiElementType();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
        return super.getVuiFatherElementId();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
        return super.getVuiFatherLabel();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
        return super.getVuiFeedbackType();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiLabel() {
        return super.getVuiLabel();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ qo getVuiMode() {
        return super.getVuiMode();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ int getVuiPosition() {
        return super.getVuiPosition();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ ro getVuiPriority() {
        return super.getVuiPriority();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
        return super.getVuiProps();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ Object getVuiValue() {
        return super.getVuiValue();
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
        super.setPerformVuiAction(z);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiAction(String str) {
        super.setVuiAction(str);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
        super.setVuiBizId(str);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
        super.setVuiDisableHitEffect(z);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
        super.setVuiElementChangedListener(koVar);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
        super.setVuiElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
        super.setVuiElementType(ooVar);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
        super.setVuiFatherElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
        super.setVuiFatherLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
        super.setVuiFeedbackType(poVar);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
        super.setVuiLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
        super.setVuiLayoutLoadable(z);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
        super.setVuiMode(qoVar);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
        super.setVuiPosition(i);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
        super.setVuiPriority(roVar);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
        super.setVuiProps(jSONObject);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs, com.xiaopeng.xui.widget.XLinearLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
        super.setVuiValue(obj);
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs
    public void d(int count) {
        if (this.k == null) {
            TextView textView = new TextView(getContext());
            this.k = textView;
            textView.setTextAppearance(ap.XNumberIndicatorSelectedTextStyle);
            this.k.setGravity(17);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-2, this.m);
            lp.weight = 1.0f;
            addView(this.k, lp);
        }
        this.j = count;
    }

    @Override // com.xiaopeng.xui.widget.pageindicator.XViewPagerIndicatorAbs
    public void f(int position) {
        this.i = position + 1;
        h();
    }

    public final void h() {
        if (this.k != null) {
            if (this.i > this.j) {
                throw new IllegalArgumentException("Position cannot greater than count");
            }
            TextAppearanceSpan textSpan = new TextAppearanceSpan(getContext(), ap.XNumberIndicatorTextStyle);
            String desc = String.format(this.l, Integer.valueOf(this.i), Integer.valueOf(this.j));
            SpannableString ss = new SpannableString(desc);
            ss.setSpan(textSpan, desc.indexOf(47), desc.length(), 17);
            this.k.setText(ss);
        }
    }

    @Override // com.xiaopeng.xui.widget.XLinearLayout, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (eo.c(newConfig)) {
            TextView textView = this.k;
            if (textView != null) {
                textView.setTextAppearance(ap.XNumberIndicatorSelectedTextStyle);
            }
            h();
        }
    }
}
