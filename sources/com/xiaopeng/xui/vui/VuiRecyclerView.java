package com.xiaopeng.xui.vui;

import android.os.Handler;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VuiRecyclerView extends RecyclerView implements dr {
    public boolean B0;
    public er C0;
    public fr D0;
    public lo E0;
    public Handler F0;
    public int G0;
    public Runnable H0;
    public String I0;
    public boolean J0;
    public boolean K0;
    public final RecyclerView.c L0;
    public boolean M0;
    public boolean N0;
    public boolean O0;

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiAction() {
        return super.getVuiAction();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiBizId() {
        return super.getVuiBizId();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
        return super.getVuiDisableHitEffect();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
        return super.getVuiElementChangedListener();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiElementId() {
        return super.getVuiElementId();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ oo getVuiElementType() {
        return super.getVuiElementType();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
        return super.getVuiFatherElementId();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
        return super.getVuiFatherLabel();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
        return super.getVuiFeedbackType();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiLabel() {
        return super.getVuiLabel();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ qo getVuiMode() {
        return super.getVuiMode();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ int getVuiPosition() {
        return super.getVuiPosition();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ ro getVuiPriority() {
        return super.getVuiPriority();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
        return super.getVuiProps();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ Object getVuiValue() {
        return super.getVuiValue();
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
        super.setPerformVuiAction(z);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiAction(String str) {
        super.setVuiAction(str);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
        super.setVuiBizId(str);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
        super.setVuiDisableHitEffect(z);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
        super.setVuiElementChangedListener(koVar);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
        super.setVuiElementId(str);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
        super.setVuiElementType(ooVar);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
        super.setVuiFatherElementId(str);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
        super.setVuiFatherLabel(str);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
        super.setVuiFeedbackType(poVar);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
        super.setVuiLabel(str);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
        super.setVuiLayoutLoadable(z);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
        super.setVuiMode(qoVar);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
        super.setVuiPosition(i);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
        super.setVuiPriority(roVar);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
        super.setVuiProps(jSONObject);
    }

    @Override // defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
        super.setVuiValue(obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        fr frVar;
        super.onAttachedToWindow();
        a("onAttachedToWindow:" + this.I0);
        if (this.K0 && this.C0 != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.C0);
        }
        if (this.J0 && (frVar = this.D0) != null) {
            d(frVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        fr frVar;
        super.onDetachedFromWindow();
        a("onDetachedFromWindow:" + this.I0);
        if (this.K0 && this.C0 != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.C0);
        }
        if (this.J0 && (frVar = this.D0) != null) {
            f0(frVar);
        }
        this.F0.removeCallbacks(this.H0);
    }

    public void finalize() throws Throwable {
        super.finalize();
        k();
    }

    public void x0() {
        if (!TextUtils.isEmpty(this.I0) && this.E0 != null) {
            this.F0.removeCallbacks(this.H0);
            this.F0.postDelayed(this.H0, this.G0);
            return;
        }
        a("updateVuiScene sceneid is empty");
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.b adapter) {
        er erVar;
        RecyclerView.b oldAdapter = getAdapter();
        if (oldAdapter != null) {
            oldAdapter.c(this.L0);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.b(this.L0);
        }
        if (this.K0 && (erVar = this.C0) != null) {
            erVar.a();
            throw null;
        }
    }

    public void setCanVuiScrollDown(boolean canScrollDown) {
        this.M0 = canScrollDown;
    }

    public void setCanVuiScrollRight(boolean canScrollRight) {
        this.N0 = canScrollRight;
    }

    public void setVuiCanControlScroll(boolean vuiCanControlScroll) {
        this.B0 = vuiCanControlScroll;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (!this.K0) {
            x0();
        }
    }

    public void setOrderState(boolean isReverse) {
        this.O0 = isReverse;
    }
}
