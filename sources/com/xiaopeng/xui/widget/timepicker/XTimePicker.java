package com.xiaopeng.xui.widget.timepicker;

import android.content.Context;
import android.icu.util.Calendar;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import com.xiaopeng.xui.widget.XFrameLayout;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XTimePicker extends XFrameLayout {
    public static final String b = XTimePicker.class.getSimpleName();
    public final d d;

    /* loaded from: classes.dex */
    public interface c {
        void a(XTimePicker xTimePicker, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(c cVar);

        void b(Parcelable parcelable);

        void c(int i);

        void d(int i);

        Parcelable e(Parcelable parcelable);

        void f(c cVar);

        int g();

        int h();

        AutofillValue i();

        boolean isEnabled();

        int j();

        void k(int i, int i2);

        void l(AutofillValue autofillValue);

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

    public XTimePicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XTimePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, ap.XTimePicker);
    }

    public XTimePicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (getImportantForAutofill() == 0) {
            setImportantForAutofill(1);
        }
        yr yrVar = new yr(this, context, attrs, defStyleAttr, defStyleRes);
        this.d = yrVar;
        yrVar.f(new a());
    }

    /* loaded from: classes.dex */
    public class a implements c {
        public a() {
        }

        @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.c
        public void a(XTimePicker view, int hourOfDay, int minute) {
            AutofillManager afm = (AutofillManager) XTimePicker.this.getContext().getSystemService(AutofillManager.class);
            if (afm != null) {
                afm.notifyValueChanged(XTimePicker.this);
            }
        }
    }

    public void setHour(int hour) {
        this.d.c(r8.a(hour, 0, 23));
    }

    public int getHour() {
        return this.d.g();
    }

    public void setMinute(int minute) {
        this.d.d(r8.a(minute, 0, 59));
    }

    public int getMinute() {
        return this.d.h();
    }

    public void setCurrentHour(Integer currentHour) {
        setHour(currentHour.intValue());
    }

    public Integer getCurrentHour() {
        return Integer.valueOf(getHour());
    }

    public void setCurrentMinute(Integer currentMinute) {
        setMinute(currentMinute.intValue());
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(getMinute());
    }

    public void setOnTimeChangedListener(c onTimeChangedListener) {
        this.d.a(onTimeChangedListener);
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.d.setEnabled(enabled);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.d.isEnabled();
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.d.j();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        return this.d.e(superState);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        View.BaseSavedState ss = (View.BaseSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        this.d.b(ss);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return XTimePicker.class.getName();
    }

    /* loaded from: classes.dex */
    public static abstract class b implements d {
        public final XTimePicker a;
        public final Context b;
        public final Locale c;
        public c d;
        public c e;
        public long f;

        public b(XTimePicker delegator, Context context) {
            this.a = delegator;
            this.b = context;
            this.c = context.getResources().getConfiguration().getLocales().get(0);
        }

        @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
        public void a(c callback) {
            this.d = callback;
        }

        @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
        public void f(c callback) {
            this.e = callback;
        }

        @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
        public final void l(AutofillValue value) {
            if (value == null || !value.isDate()) {
                String str = XTimePicker.b;
                rq.k(str, value + " could not be autofilled into " + this);
                return;
            }
            long time = value.getDateValue();
            Calendar cal = Calendar.getInstance(this.c);
            cal.setTimeInMillis(time);
            k(cal.get(11), cal.get(12));
            this.f = time;
        }

        @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
        public final AutofillValue i() {
            long j = this.f;
            if (j != 0) {
                return AutofillValue.forDate(j);
            }
            Calendar cal = Calendar.getInstance(this.c);
            cal.set(11, g());
            cal.set(12, h());
            return AutofillValue.forDate(cal.getTimeInMillis());
        }

        public void m() {
            this.f = 0L;
        }

        /* loaded from: classes.dex */
        public static class a extends View.BaseSavedState {
            public final int a;
            public final int b;
            public final int d;

            public a(Parcelable superState, int hour, int minute) {
                this(superState, hour, minute, 0);
            }

            public a(Parcelable superState, int hour, int minute, int currentItemShowing) {
                super(superState);
                this.a = hour;
                this.b = minute;
                this.d = currentItemShowing;
            }

            public int a() {
                return this.a;
            }

            public int b() {
                return this.b;
            }

            @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel dest, int flags) {
                super.writeToParcel(dest, flags);
                dest.writeInt(this.a);
                dest.writeInt(this.b);
                dest.writeInt(this.d);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure structure, int flags) {
        structure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(structure, flags);
    }

    @Override // android.view.View
    public void autofill(AutofillValue value) {
        if (isEnabled()) {
            this.d.l(value);
        }
    }

    @Override // android.view.View
    public AutofillValue getAutofillValue() {
        if (isEnabled()) {
            return this.d.i();
        }
        return null;
    }
}
