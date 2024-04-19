package com.xiaopeng.xui.widget.quicksidebar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.xiaopeng.xui.view.XView;
import defpackage.uq;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XQuickSideBarView extends XView implements uq.a {
    public rr b;
    public List<String> d;
    public int f;
    public Paint g;
    public float h;
    public float i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;
    public float o;
    public boolean p;
    public boolean q;

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiAction() {
        return super.getVuiAction();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiBizId() {
        return super.getVuiBizId();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
        return super.getVuiDisableHitEffect();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
        return super.getVuiElementChangedListener();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiElementId() {
        return super.getVuiElementId();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ oo getVuiElementType() {
        return super.getVuiElementType();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
        return super.getVuiFatherElementId();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
        return super.getVuiFatherLabel();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
        return super.getVuiFeedbackType();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiLabel() {
        return super.getVuiLabel();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ qo getVuiMode() {
        return super.getVuiMode();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ int getVuiPosition() {
        return super.getVuiPosition();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ ro getVuiPriority() {
        return super.getVuiPriority();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
        return super.getVuiProps();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ Object getVuiValue() {
        return super.getVuiValue();
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
        super.setPerformVuiAction(z);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiAction(String str) {
        super.setVuiAction(str);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
        super.setVuiBizId(str);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
        super.setVuiDisableHitEffect(z);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
        super.setVuiElementChangedListener(koVar);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
        super.setVuiElementId(str);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
        super.setVuiElementType(ooVar);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
        super.setVuiFatherElementId(str);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
        super.setVuiFatherLabel(str);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
        super.setVuiFeedbackType(poVar);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
        super.setVuiLabel(str);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
        super.setVuiLayoutLoadable(z);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
        super.setVuiMode(qoVar);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
        super.setVuiPosition(i);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
        super.setVuiPriority(roVar);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
        super.setVuiProps(jSONObject);
    }

    @Override // com.xiaopeng.xui.view.XView, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
        super.setVuiValue(obj);
    }

    @Override // defpackage.uq.a
    public void d() {
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.m = getMeasuredHeight();
        this.l = getMeasuredWidth();
        float defaultItemHeight = this.m / this.d.size();
        float f = this.o;
        if (f > defaultItemHeight) {
            f = defaultItemHeight;
        }
        this.o = f;
        this.n = f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.d.size(); i++) {
            Paint bgRect = new Paint();
            if (i == this.f) {
                this.g.setTextSize(this.i);
                this.g.setColor(this.k);
                bgRect.setColor(f(uo.x_side_bar_item_choose_bg_color));
            } else {
                this.g.setTextSize(this.h);
                this.g.setColor(this.j);
                bgRect.setColor(f(uo.x_side_bar_item_bg_color));
            }
            bgRect.setStyle(Paint.Style.FILL);
            bgRect.setAntiAlias(true);
            float f = this.n;
            float left = (this.l - f) / 2.0f;
            float f2 = this.o;
            RectF rectF = new RectF(left, (i * f2) + 14.0f, f + left, ((i + 1) * f2) + 14.0f);
            canvas.drawRoundRect(rectF, 4.0f, 4.0f, bgRect);
            this.g.setAntiAlias(true);
            this.g.setStyle(Paint.Style.FILL);
            this.g.setTextAlign(Paint.Align.CENTER);
            this.g.setFakeBoldText(true);
            this.g.setTypeface(Typeface.create(getResources().getString(zo.x_font_typeface_medium), 0));
            Paint.FontMetrics fontMetrics = this.g.getFontMetrics();
            float f3 = fontMetrics.bottom;
            float distance = ((f3 - fontMetrics.top) / 2.0f) - f3;
            float baseline = rectF.centerY() + distance;
            canvas.drawText(this.d.get(i), rectF.centerX(), baseline, this.g);
            this.g.reset();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float y = event.getY();
        int oldChoose = this.f;
        int newChoose = (int) ((y - 14.0f) / this.o);
        switch (action) {
            case 0:
            case 2:
                this.q = true;
                if (oldChoose != newChoose && newChoose >= 0 && newChoose < this.d.size()) {
                    this.f = newChoose;
                    invalidate();
                    lq.a().g(2);
                    rr rrVar = this.b;
                    if (rrVar != null) {
                        rrVar.a(true);
                        this.b.b(this.d.get(newChoose), this.f);
                        break;
                    }
                }
                break;
            case 1:
                this.q = false;
                this.f = -1;
                rr rrVar2 = this.b;
                if (rrVar2 != null) {
                    rrVar2.a(false);
                }
                if (!this.p) {
                    invalidate();
                    break;
                }
                break;
            case 3:
                this.q = false;
                lq.a().i(2);
                rr rrVar3 = this.b;
                if (rrVar3 != null) {
                    rrVar3.a(false);
                }
                this.f = -1;
                invalidate();
                break;
        }
        return true;
    }

    public rr getListener() {
        return this.b;
    }

    public void setOnQuickSideBarTouchListener(rr listener) {
        this.b = listener;
    }

    public List<String> getLetters() {
        return this.d;
    }

    public void setLetters(List<String> letters) {
        this.d = letters;
        invalidate();
    }

    public final int f(int resourceId) {
        return getResources().getColor(resourceId, getContext().getTheme());
    }

    public void setSideBarHighLight(String letter) {
        h(letter, false);
    }

    public void h(String letter, boolean isCaseSensitive) {
        int index;
        if (!this.p || this.q) {
            return;
        }
        a("setSideBarHighLight");
        if (!TextUtils.isEmpty(letter)) {
            if (!isCaseSensitive) {
                index = this.d.indexOf(letter.toUpperCase());
            } else {
                index = this.d.indexOf(letter);
            }
            if (index >= 0 && this.f != index) {
                this.f = index;
                invalidate();
            }
        }
    }

    private void setSideBarHighLight(int position) {
        if (!this.p || this.q) {
            return;
        }
        int sideSize = this.d.size();
        if (position >= 0 && position < sideSize && this.f != position) {
            this.f = position;
            invalidate();
        }
    }
}
