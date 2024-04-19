package com.xiaopeng.xui.widget;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XExposedDropdownMenu extends XTextView implements AdapterView.OnItemClickListener {
    public static final String i = XExposedDropdownMenu.class.getSimpleName();
    public PopupWindow j;
    public ListView k;
    public ArrayAdapter<String> l;
    public a m;
    public int n;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str);
    }

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
    public /* bridge */ /* synthetic */ void setVuiPosition(int i2) {
        super.setVuiPosition(i2);
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

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        setSelection(position);
        String title = n(position);
        a aVar = this.m;
        if (aVar != null) {
            aVar.a(position, title);
        }
        if (this.j.isShowing()) {
            this.j.dismiss();
        }
    }

    public void setSelection(int position) {
        if (position < 0 || position >= this.l.getCount()) {
            return;
        }
        this.n = position;
        setText(n(position));
    }

    public int getSelection() {
        return this.n;
    }

    public String n(int index) {
        if (index >= 0 && index < this.l.getCount()) {
            return this.l.getItem(index);
        }
        return "";
    }

    public String getSelectionTitle() {
        return n(getSelection());
    }

    public void setEntries(String[] array) {
        this.l.clear();
        if (array != null && array.length > 0) {
            this.l.addAll(array);
            setSelection(0);
        }
        setDropdownHeight(this.l.getCount());
    }

    public void setEntries(CharSequence[] array) {
        this.l.clear();
        if (array != null && array.length > 0) {
            for (CharSequence c : array) {
                this.l.add(c.toString());
            }
            setSelection(0);
        }
        setDropdownHeight(this.l.getCount());
    }

    private void setDropdownHeight(int itemSize) {
        int windowHeight;
        if (itemSize > 5) {
            windowHeight = tq.a(408.0f);
        } else if (itemSize > 0) {
            windowHeight = tq.a((itemSize * 80) + ((itemSize - 1) * 2));
        } else {
            windowHeight = 0;
        }
        this.j.setHeight(windowHeight);
    }

    public void setOnItemClickListener(a mOnItemClickListener) {
        this.m = mOnItemClickListener;
    }

    @Override // com.xiaopeng.xui.widget.XTextView, android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mq.d(newConfig)) {
            o();
        }
    }

    @Override // com.xiaopeng.xui.widget.XTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
    }

    @Override // com.xiaopeng.xui.widget.XTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    public final void o() {
        ListView listView = this.k;
        if (listView != null) {
            listView.setBackground(getContext().getDrawable(wo.x_exposed_dropdown_menu_list_bg));
            this.k.setDivider(getContext().getDrawable(wo.x_exposed_dropdown_menu_divider));
        }
    }
}
