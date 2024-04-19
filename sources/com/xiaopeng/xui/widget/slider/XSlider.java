package com.xiaopeng.xui.widget.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.xiaopeng.xui.widget.slider.XSlider;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XSlider extends AbsSlider {
    public b Q;
    public a R;

    /* loaded from: classes.dex */
    public interface a {
        void a(XSlider xSlider, float f, String str, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(XSlider xSlider);

        void b(XSlider xSlider, float f, String str);

        void c(XSlider xSlider);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiAction() {
        return super.getVuiAction();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiBizId() {
        return super.getVuiBizId();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
        return super.getVuiDisableHitEffect();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
        return super.getVuiElementChangedListener();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiElementId() {
        return super.getVuiElementId();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ oo getVuiElementType() {
        return super.getVuiElementType();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
        return super.getVuiFatherElementId();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
        return super.getVuiFatherLabel();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
        return super.getVuiFeedbackType();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiLabel() {
        return super.getVuiLabel();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ qo getVuiMode() {
        return super.getVuiMode();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ int getVuiPosition() {
        return super.getVuiPosition();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ ro getVuiPriority() {
        return super.getVuiPriority();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
        return super.getVuiProps();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ Object getVuiValue() {
        return super.getVuiValue();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
        super.setPerformVuiAction(z);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiAction(String str) {
        super.setVuiAction(str);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
        super.setVuiBizId(str);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
        super.setVuiDisableHitEffect(z);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
        super.setVuiElementChangedListener(koVar);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
        super.setVuiElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
        super.setVuiElementType(ooVar);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
        super.setVuiFatherElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
        super.setVuiFatherLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
        super.setVuiFeedbackType(poVar);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
        super.setVuiLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
        super.setVuiLayoutLoadable(z);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
        super.setVuiMode(qoVar);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
        super.setVuiPosition(i);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
        super.setVuiPriority(roVar);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
        super.setVuiProps(jSONObject);
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider, com.xiaopeng.xui.widget.XViewGroup, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
        super.setVuiValue(obj);
    }

    public XSlider(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XSlider(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, ap.XSlider);
    }

    public XSlider(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean shouldStartDrag;
        if (isEnabled()) {
            switch (event.getAction()) {
                case 0:
                    ViewGroup scrollableParent = j();
                    boolean canScrollDown = scrollableParent != null && scrollableParent.canScrollVertically(1);
                    boolean canScrollUp = scrollableParent != null && scrollableParent.canScrollVertically(-1);
                    boolean canScrollVertical = canScrollDown || canScrollUp;
                    boolean canScrollRight = scrollableParent != null && scrollableParent.canScrollHorizontally(1);
                    boolean canScrollLeft = scrollableParent != null && scrollableParent.canScrollHorizontally(-1);
                    boolean canScrollHorizontal = canScrollLeft || canScrollRight;
                    boolean startDrag = getOrientation() != 0 ? !canScrollHorizontal : !canScrollVertical;
                    if (!startDrag) {
                        this.C = event.getX();
                        this.D = event.getY();
                        break;
                    } else {
                        this.E = true;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        b bVar = this.Q;
                        if (bVar != null) {
                            bVar.a(this);
                        }
                        this.o = s(event);
                        A(true, false);
                        i();
                        break;
                    }
                    break;
                case 1:
                    if (this.E) {
                        this.E = false;
                    } else {
                        b bVar2 = this.Q;
                        if (bVar2 != null) {
                            bVar2.a(this);
                        }
                    }
                    this.o = s(event);
                    p();
                    A(true, true);
                    getParent().requestDisallowInterceptTouchEvent(false);
                    b bVar3 = this.Q;
                    if (bVar3 != null) {
                        bVar3.c(this);
                    }
                    i();
                    break;
                case 2:
                    if (this.E) {
                        this.o = s(event);
                        A(true, false);
                        i();
                        break;
                    } else {
                        float x = event.getX();
                        float y = event.getY();
                        if (getOrientation() == 0) {
                            shouldStartDrag = Math.abs(x - this.C) > this.F;
                        } else {
                            shouldStartDrag = Math.abs(y - this.D) > this.F;
                        }
                        if (shouldStartDrag) {
                            this.E = true;
                            b bVar4 = this.Q;
                            if (bVar4 != null) {
                                bVar4.a(this);
                            }
                            this.o = s(event);
                            getParent().requestDisallowInterceptTouchEvent(true);
                            A(true, false);
                            i();
                            break;
                        }
                    }
                    break;
                case 3:
                    if (this.E) {
                        this.E = false;
                    }
                    i();
                    break;
            }
            return true;
        }
        return true;
    }

    public final float s(MotionEvent event) {
        return getOrientation() == 0 ? event.getX() : getHeight() - event.getY();
    }

    public final void A(boolean isNeedUpdate, boolean isForce) {
        float xLocation = f();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            xr child = (xr) getChildAt(i);
            if (child.getX() + (child.getWidth() / 2.0f) <= f()) {
                if (!child.o()) {
                    child.t(true);
                }
            } else {
                child.t(false);
            }
        }
        if (isNeedUpdate) {
            float f = ((xLocation - 16.0f) / this.v) * (this.j - this.h);
            this.q = f;
            float currentProgress = ((float) t(f, this.k)) + this.h;
            if (this.Q != null) {
                if ((isForce || currentProgress >= Math.min(this.r + this.s, this.j) || currentProgress <= Math.max(this.r - this.s, this.h)) && this.r != currentProgress) {
                    this.Q.b(this, currentProgress, this.g);
                    this.r = currentProgress;
                    m(this);
                }
            }
        }
    }

    public static double t(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = BigDecimal.valueOf(value);
        return bd.setScale(places, RoundingMode.DOWN).doubleValue();
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider
    public float getIndicatorValue() {
        return (((float) t(this.q, this.k)) + this.h) * this.A;
    }

    @Override // com.xiaopeng.xui.widget.slider.AbsSlider
    public void setAccuracy(float accuracy) {
        this.s = accuracy;
    }

    public void setSliderProgressListener(b sliderProgressListener) {
        this.Q = sliderProgressListener;
    }

    public void setProgressChangeListener(a progressChangeListener) {
        this.R = progressChangeListener;
    }

    public void setCurrentIndex(int currentIndex) {
        B(currentIndex, false);
    }

    public void B(final int currentIndex, final boolean fromUser) {
        post(new Runnable() { // from class: ur
            @Override // java.lang.Runnable
            public final void run() {
                XSlider.this.v(currentIndex, fromUser);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(int currentIndex, boolean fromUser) {
        a aVar;
        rq.e("XSlider", "setCurrentIndex:" + currentIndex + ", fromUser:" + fromUser);
        int i = this.h;
        this.o = ((((float) (currentIndex - i)) / ((float) (this.j - i))) * ((float) this.v)) + 16.0f;
        this.q = (float) (currentIndex - i);
        invalidate();
        A(false, false);
        this.r = currentIndex;
        wr wrVar = this.G;
        if (wrVar != null) {
            wrVar.e(f(), getPopString(), getSliderLength());
        }
        if (fromUser && (aVar = this.R) != null) {
            aVar.a(this, this.q + this.h, this.g, true);
        }
        if (getVuiValue() != null && ((Float) getVuiValue()).floatValue() == getIndicatorValue()) {
            return;
        }
        m(this);
    }

    @Override // com.xiaopeng.xui.widget.XViewGroup, android.view.View
    public void setEnabled(boolean enable) {
        if (!enable) {
            this.E = false;
        }
        super.setEnabled(enable);
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setEnabled(enable);
        }
        setAlphaByEnable(enable);
        invalidate();
    }

    public void setStartIndex(int startIndex) {
        if (startIndex == this.j) {
            throw new RuntimeException("startIndex = endIndex!!!");
        }
        this.h = startIndex;
        post(new Runnable() { // from class: vr
            @Override // java.lang.Runnable
            public final void run() {
                XSlider.this.z();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void z() {
        wr wrVar = this.G;
        if (wrVar != null) {
            wrVar.e(f(), getPopString(), getSliderLength());
        }
        invalidate();
    }

    public void setEndIndex(int endIndex) {
        if (this.h == endIndex) {
            throw new RuntimeException("startIndex = endIndex!!!");
        }
        this.j = endIndex;
        post(new Runnable() { // from class: tr
            @Override // java.lang.Runnable
            public final void run() {
                XSlider.this.x();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public /* synthetic */ void x() {
        invalidate();
    }

    public void setInitIndex(int initIndex) {
        int i = this.j;
        if (initIndex > i) {
            this.i = i;
            return;
        }
        int i2 = this.h;
        if (initIndex < i2) {
            this.i = i2;
            return;
        }
        this.i = initIndex;
        this.q = initIndex - i2;
        invalidate();
    }
}
