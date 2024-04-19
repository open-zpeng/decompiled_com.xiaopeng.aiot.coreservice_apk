package com.xiaopeng.xui.widget.datepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.icu.util.Calendar;
import android.util.AttributeSet;
import android.view.autofill.AutofillManager;
import com.xiaopeng.xui.widget.XFrameLayout;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XDatePicker extends XFrameLayout {
    public static final String b = XDatePicker.class.getSimpleName();
    public final d d;

    /* loaded from: classes.dex */
    public interface c {
        void a(XDatePicker xDatePicker, int i, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface d {
        Calendar a();

        void b(c cVar);

        int c();

        Calendar d();

        int e();

        int f();

        void g(c cVar);

        void h(long j);

        void i(long j);

        boolean isEnabled();

        void onConfigurationChanged(Configuration configuration);

        void setEnabled(boolean z);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiAction() {
        return super.getVuiAction();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiBizId() {
        return super.getVuiBizId();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ boolean getVuiDisableHitEffect() {
        return super.getVuiDisableHitEffect();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ ko getVuiElementChangedListener() {
        return super.getVuiElementChangedListener();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiElementId() {
        return super.getVuiElementId();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ oo getVuiElementType() {
        return super.getVuiElementType();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherElementId() {
        return super.getVuiFatherElementId();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiFatherLabel() {
        return super.getVuiFatherLabel();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ po getVuiFeedbackType() {
        return super.getVuiFeedbackType();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ String getVuiLabel() {
        return super.getVuiLabel();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ qo getVuiMode() {
        return super.getVuiMode();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ int getVuiPosition() {
        return super.getVuiPosition();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ ro getVuiPriority() {
        return super.getVuiPriority();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ JSONObject getVuiProps() {
        return super.getVuiProps();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ Object getVuiValue() {
        return super.getVuiValue();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setPerformVuiAction(boolean z) {
        super.setPerformVuiAction(z);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiAction(String str) {
        super.setVuiAction(str);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiBizId(String str) {
        super.setVuiBizId(str);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiDisableHitEffect(boolean z) {
        super.setVuiDisableHitEffect(z);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementChangedListener(ko koVar) {
        super.setVuiElementChangedListener(koVar);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementId(String str) {
        super.setVuiElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiElementType(oo ooVar) {
        super.setVuiElementType(ooVar);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherElementId(String str) {
        super.setVuiFatherElementId(str);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFatherLabel(String str) {
        super.setVuiFatherLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiFeedbackType(po poVar) {
        super.setVuiFeedbackType(poVar);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLabel(String str) {
        super.setVuiLabel(str);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiLayoutLoadable(boolean z) {
        super.setVuiLayoutLoadable(z);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiMode(qo qoVar) {
        super.setVuiMode(qoVar);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPosition(int i) {
        super.setVuiPosition(i);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiPriority(ro roVar) {
        super.setVuiPriority(roVar);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiProps(JSONObject jSONObject) {
        super.setVuiProps(jSONObject);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, defpackage.dr
    public /* bridge */ /* synthetic */ void setVuiValue(Object obj) {
        super.setVuiValue(obj);
    }

    public XDatePicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XDatePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, ap.XDatePicker);
    }

    public XDatePicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (getImportantForAutofill() == 0) {
            setImportantForAutofill(1);
        }
        d d2 = d(context, attrs, defStyleAttr, defStyleRes);
        this.d = d2;
        d2.g(new a());
    }

    /* loaded from: classes.dex */
    public class a implements c {
        public a() {
        }

        @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.c
        public void a(XDatePicker view, int year, int monthOfYear, int dayOfMonth) {
            AutofillManager afm = (AutofillManager) XDatePicker.this.getContext().getSystemService(AutofillManager.class);
            if (afm != null) {
                afm.notifyValueChanged(XDatePicker.this);
            }
        }
    }

    public final d d(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        return new or(this, context, attrs, defStyleAttr, defStyleRes);
    }

    public void setOnDateChangedListener(c onDateChangedListener) {
        this.d.b(onDateChangedListener);
    }

    public int getYear() {
        return this.d.e();
    }

    public int getMonth() {
        return this.d.f();
    }

    public int getDayOfMonth() {
        return this.d.c();
    }

    public long getMinDate() {
        return this.d.d().getTimeInMillis();
    }

    public void setMinDate(long minDate) {
        this.d.i(minDate);
    }

    public long getMaxDate() {
        return this.d.a().getTimeInMillis();
    }

    public void setMaxDate(long maxDate) {
        this.d.h(maxDate);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, android.view.View
    public void setEnabled(boolean enabled) {
        if (this.d.isEnabled() == enabled) {
            return;
        }
        super.setEnabled(enabled);
        this.d.setEnabled(enabled);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.d.isEnabled();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return XDatePicker.class.getName();
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.d.onConfigurationChanged(newConfig);
    }

    /* loaded from: classes.dex */
    public static abstract class b implements d {
        public XDatePicker a;
        public Context b;
        public Calendar c;
        public Locale d;
        public c e;
        public c f;
        public long g;

        public b(XDatePicker delegator, Context context) {
            this.a = delegator;
            this.b = context;
            l(Locale.getDefault());
        }

        public void l(Locale locale) {
            if (!locale.equals(this.d)) {
                this.d = locale;
                j(locale);
            }
        }

        @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.d
        public void b(c callback) {
            this.e = callback;
        }

        @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.d
        public void g(c callback) {
            this.f = callback;
        }

        public void k() {
            this.g = 0L;
        }

        public void j(Locale locale) {
        }
    }
}
