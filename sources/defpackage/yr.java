package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.icu.util.Calendar;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.xui.widget.XNumberPicker;
import com.xiaopeng.xui.widget.timepicker.XTimePicker;
/* compiled from: XTimePickerSpinnerDelegate.java */
/* renamed from: yr  reason: default package */
/* loaded from: classes.dex */
public class yr extends XTimePicker.b {
    public final XNumberPicker g;
    public final XNumberPicker h;
    public final Calendar i;
    public boolean j;

    public yr(XTimePicker delegate, Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(delegate, context);
        this.j = true;
        TypedArray a2 = this.b.obtainStyledAttributes(attrs, bp.D3, defStyleAttr, defStyleRes);
        int layoutResourceId = a2.getResourceId(bp.E3, yo.x_time_picker_layout);
        a2.recycle();
        LayoutInflater inflater = LayoutInflater.from(this.b);
        View view = inflater.inflate(layoutResourceId, (ViewGroup) this.a, true);
        view.setSaveFromParentEnabled(false);
        XNumberPicker xNumberPicker = (XNumberPicker) delegate.findViewById(xo.hour);
        this.g = xNumberPicker;
        xNumberPicker.setMinValue(0);
        xNumberPicker.setMaxValue(23);
        xNumberPicker.setOnLongPressUpdateInterval(100L);
        String[] hourDisplayValues = new String[24];
        for (int i = 0; i < hourDisplayValues.length; i++) {
            hourDisplayValues[i] = context.getResources().getString(zo.x_time_picker_hour, Integer.valueOf(i));
        }
        this.g.setDisplayedValues(hourDisplayValues);
        this.g.setOnValueChangedListener(new a());
        XNumberPicker xNumberPicker2 = (XNumberPicker) this.a.findViewById(xo.minute);
        this.h = xNumberPicker2;
        xNumberPicker2.setMinValue(0);
        xNumberPicker2.setMaxValue(59);
        xNumberPicker2.setOnLongPressUpdateInterval(100L);
        xNumberPicker2.setFormatter(XNumberPicker.getTwoDigitFormatter());
        String[] minuteDisplayValues = new String[60];
        int i2 = 0;
        while (i2 < minuteDisplayValues.length) {
            minuteDisplayValues[i2] = context.getResources().getString(zo.x_time_picker_minute, Integer.valueOf(i2));
            i2++;
            a2 = a2;
        }
        this.h.setDisplayedValues(minuteDisplayValues);
        this.h.setOnValueChangedListener(new b());
        Calendar calendar = Calendar.getInstance(this.c);
        this.i = calendar;
        c(calendar.get(11));
        d(calendar.get(12));
        if (!isEnabled()) {
            setEnabled(false);
        }
        if (this.a.getImportantForAccessibility() == 0) {
            this.a.setImportantForAccessibility(1);
        }
    }

    /* compiled from: XTimePickerSpinnerDelegate.java */
    /* renamed from: yr$a */
    /* loaded from: classes.dex */
    public class a implements XNumberPicker.e {
        public a() {
        }

        @Override // com.xiaopeng.xui.widget.XNumberPicker.e
        public void a(XNumberPicker spinner, int oldVal, int newVal) {
            yr.this.q();
        }
    }

    /* compiled from: XTimePickerSpinnerDelegate.java */
    /* renamed from: yr$b */
    /* loaded from: classes.dex */
    public class b implements XNumberPicker.e {
        public b() {
        }

        @Override // com.xiaopeng.xui.widget.XNumberPicker.e
        public void a(XNumberPicker spinner, int oldVal, int newVal) {
            int minValue = yr.this.h.getMinValue();
            int maxValue = yr.this.h.getMaxValue();
            if (oldVal == maxValue && newVal == minValue) {
                int newHour = yr.this.g.getValue() + 1;
                yr.this.g.setValue(newHour);
            } else if (oldVal == minValue && newVal == maxValue) {
                int newHour2 = yr.this.g.getValue() - 1;
                yr.this.g.setValue(newHour2);
            }
            yr.this.q();
        }
    }

    public final void q() {
        this.a.sendAccessibilityEvent(4);
        XTimePicker.c cVar = this.d;
        if (cVar != null) {
            cVar.a(this.a, g(), h());
        }
        XTimePicker.c cVar2 = this.e;
        if (cVar2 != null) {
            cVar2.a(this.a, g(), h());
        }
    }

    @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
    public void c(int hour) {
        r(hour, true);
    }

    public final void r(int currentHour, boolean notifyTimeChanged) {
        if (currentHour == g()) {
            return;
        }
        m();
        this.g.setValue(currentHour);
        if (notifyTimeChanged) {
            q();
        }
    }

    @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
    public int g() {
        return this.g.getValue();
    }

    @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
    public void d(int minute) {
        s(minute, true);
    }

    public final void s(int minute, boolean notifyTimeChanged) {
        if (minute == h()) {
            return;
        }
        m();
        this.h.setValue(minute);
        if (notifyTimeChanged) {
            q();
        }
    }

    @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
    public int h() {
        return this.h.getValue();
    }

    @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
    public void k(int hour, int minute) {
        r(hour, false);
        s(minute, false);
        q();
    }

    @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
    public void setEnabled(boolean enabled) {
        this.h.setEnabled(enabled);
        this.g.setEnabled(enabled);
        this.j = enabled;
    }

    @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
    public boolean isEnabled() {
        return this.j;
    }

    @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
    public int j() {
        return this.g.getBaseline();
    }

    @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
    public Parcelable e(Parcelable superState) {
        return new XTimePicker.b.a(superState, g(), h());
    }

    @Override // com.xiaopeng.xui.widget.timepicker.XTimePicker.d
    public void b(Parcelable state) {
        if (state instanceof XTimePicker.b.a) {
            XTimePicker.b.a ss = (XTimePicker.b.a) state;
            c(ss.a());
            d(ss.b());
        }
    }
}
