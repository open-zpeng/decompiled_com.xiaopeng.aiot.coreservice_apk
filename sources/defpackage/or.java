package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.icu.util.Calendar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaopeng.libconfig.remotecontrol.RemoteControlFeedbackConstant;
import com.xiaopeng.xui.widget.XNumberPicker;
import com.xiaopeng.xui.widget.datepicker.XDatePicker;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
/* compiled from: XDatePickerSpinnerDelegate.java */
/* renamed from: or  reason: default package */
/* loaded from: classes.dex */
public class or extends XDatePicker.b {
    public final LinearLayout h;
    public XNumberPicker i;
    public XNumberPicker j;
    public XNumberPicker k;
    public String[] l;
    public final DateFormat m;
    public int n;
    public Calendar o;
    public Calendar p;
    public Calendar q;
    public boolean r;

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.b, com.xiaopeng.xui.widget.datepicker.XDatePicker.d
    public /* bridge */ /* synthetic */ void b(XDatePicker.c cVar) {
        super.b(cVar);
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.b, com.xiaopeng.xui.widget.datepicker.XDatePicker.d
    public /* bridge */ /* synthetic */ void g(XDatePicker.c cVar) {
        super.g(cVar);
    }

    public or(XDatePicker delegator, Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(delegator, context);
        this.m = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        this.r = true;
        this.a = delegator;
        this.b = context;
        l(Locale.getDefault());
        TypedArray attributesArray = context.obtainStyledAttributes(attrs, bp.w1, defStyleAttr, defStyleRes);
        boolean spinnersShown = attributesArray.getBoolean(bp.A1, true);
        int startYear = attributesArray.getInt(bp.B1, 1900);
        int endYear = attributesArray.getInt(bp.x1, 2100);
        String minDate = attributesArray.getString(bp.z1);
        String maxDate = attributesArray.getString(bp.y1);
        int layoutResourceId = attributesArray.getResourceId(bp.C1, yo.x_date_picker_layout);
        attributesArray.recycle();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        View view = inflater.inflate(layoutResourceId, (ViewGroup) this.a, true);
        view.setSaveFromParentEnabled(false);
        XNumberPicker.e onChangeListener = new XNumberPicker.e() { // from class: nr
            @Override // com.xiaopeng.xui.widget.XNumberPicker.e
            public final void a(XNumberPicker xNumberPicker, int i, int i2) {
                or.this.q(xNumberPicker, i, i2);
            }
        };
        this.h = (LinearLayout) this.a.findViewById(xo.pickers);
        XNumberPicker spinner1 = (XNumberPicker) this.a.findViewById(xo.picker1);
        XNumberPicker spinner2 = (XNumberPicker) this.a.findViewById(xo.picker2);
        XNumberPicker spinner3 = (XNumberPicker) this.a.findViewById(xo.picker3);
        XNumberPicker[] pickers = {spinner1, spinner2, spinner3};
        t(pickers);
        this.i.setFormatter(XNumberPicker.getTwoDigitFormatter());
        this.i.setOnLongPressUpdateInterval(100L);
        this.i.setOnValueChangedListener(onChangeListener);
        this.j.setMinValue(0);
        this.j.setMaxValue(this.n - 1);
        this.j.setDisplayedValues(this.l);
        this.j.setOnLongPressUpdateInterval(200L);
        this.j.setOnValueChangedListener(onChangeListener);
        this.k.setOnLongPressUpdateInterval(100L);
        this.k.setOnValueChangedListener(onChangeListener);
        v(spinnersShown);
        this.o.clear();
        if (!TextUtils.isEmpty(minDate)) {
            if (!s(minDate, this.o)) {
                this.o.set(startYear, 0, 1);
            }
        } else {
            this.o.set(startYear, 0, 1);
        }
        i(this.o.getTimeInMillis());
        this.o.clear();
        if (!TextUtils.isEmpty(maxDate)) {
            if (!s(maxDate, this.o)) {
                this.o.set(endYear, 11, 31);
            }
        } else {
            this.o.set(endYear, 11, 31);
        }
        h(this.o.getTimeInMillis());
        this.c.setTimeInMillis(System.currentTimeMillis());
        o(this.c.get(1), this.c.get(2), this.c.get(5), null);
        if (this.a.getImportantForAccessibility() == 0) {
            this.a.setImportantForAccessibility(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void q(XNumberPicker picker, int oldVal, int newVal) {
        this.o.setTimeInMillis(this.c.getTimeInMillis());
        if (picker == this.i) {
            int maxDayOfMonth = this.o.getActualMaximum(5);
            if (oldVal == maxDayOfMonth && newVal == 1) {
                this.o.add(5, 1);
            } else if (oldVal == 1 && newVal == maxDayOfMonth) {
                this.o.add(5, -1);
            } else {
                this.o.add(5, newVal - oldVal);
            }
        } else if (picker == this.j) {
            if (oldVal == 11 && newVal == 0) {
                this.o.add(2, 1);
            } else if (oldVal == 0 && newVal == 11) {
                this.o.add(2, -1);
            } else {
                this.o.add(2, newVal - oldVal);
            }
        } else if (picker == this.k) {
            this.o.set(1, newVal);
        } else {
            throw new IllegalArgumentException();
        }
        u(this.o.get(1), this.o.get(2), this.o.get(5));
        w();
        r();
    }

    public final void r() {
        this.a.sendAccessibilityEvent(4);
        XDatePicker.c cVar = this.e;
        if (cVar != null) {
            cVar.a(this.a, e(), f(), c());
        }
        XDatePicker.c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.a(this.a, e(), f(), c());
        }
    }

    public final void t(XNumberPicker[] pickers) {
        String pattern = android.text.format.DateFormat.getBestDateTimePattern(Locale.getDefault(), "yyyyMMMdd");
        char[] order = n(pattern);
        for (int i = 0; i < order.length; i++) {
            char c = order[i];
            switch (c) {
                case 'M':
                    this.j = pickers[i];
                    break;
                case 'd':
                    this.i = pickers[i];
                    break;
                case 'y':
                    this.k = pickers[i];
                    break;
                default:
                    throw new IllegalArgumentException(Arrays.toString(order));
            }
        }
    }

    public static char[] n(String pattern) {
        char[] result = new char[3];
        int resultIndex = 0;
        boolean sawDay = false;
        boolean sawMonth = false;
        boolean sawYear = false;
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (ch == 'd' || ch == 'L' || ch == 'M' || ch == 'y') {
                if (ch == 'd' && !sawDay) {
                    result[resultIndex] = 'd';
                    sawDay = true;
                    resultIndex++;
                } else if ((ch == 'L' || ch == 'M') && !sawMonth) {
                    result[resultIndex] = 'M';
                    sawMonth = true;
                    resultIndex++;
                } else if (ch == 'y' && !sawYear) {
                    result[resultIndex] = 'y';
                    sawYear = true;
                    resultIndex++;
                }
            }
        }
        return result;
    }

    public final void u(int year, int month, int dayOfMonth) {
        this.c.set(year, month, dayOfMonth);
        k();
        if (this.c.before(this.p)) {
            this.c.setTimeInMillis(this.p.getTimeInMillis());
        } else if (this.c.after(this.q)) {
            this.c.setTimeInMillis(this.q.getTimeInMillis());
        }
    }

    public final boolean s(String date, Calendar outDate) {
        try {
            outDate.setTime(this.m.parse(date));
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void w() {
        if (this.c.equals(this.p)) {
            this.i.setMinValue(this.c.get(5));
            this.i.setMaxValue(this.c.getActualMaximum(5));
            this.i.setWrapSelectorWheel(false);
            this.j.setDisplayedValues(null);
            this.j.setMinValue(this.c.get(2));
            this.j.setMaxValue(this.c.getActualMaximum(2));
            this.j.setWrapSelectorWheel(false);
        } else if (this.c.equals(this.q)) {
            this.i.setMinValue(this.c.getActualMinimum(5));
            this.i.setMaxValue(this.c.get(5));
            this.i.setWrapSelectorWheel(false);
            this.j.setDisplayedValues(null);
            this.j.setMinValue(this.c.getActualMinimum(2));
            this.j.setMaxValue(this.c.get(2));
            this.j.setWrapSelectorWheel(false);
        } else {
            this.i.setMinValue(1);
            this.i.setMaxValue(this.c.getActualMaximum(5));
            this.i.setWrapSelectorWheel(true);
            this.j.setDisplayedValues(null);
            this.j.setMinValue(0);
            this.j.setMaxValue(11);
            this.j.setWrapSelectorWheel(true);
        }
        String[] dayDisplayedValues = new String[this.c.getActualMaximum(5)];
        for (int i = 0; i < this.c.getActualMaximum(5); i++) {
            dayDisplayedValues[i] = this.b.getResources().getString(zo.x_date_picker_day, Integer.valueOf(i + 1));
        }
        this.i.setDisplayedValues(dayDisplayedValues);
        String[] displayedValues = (String[]) Arrays.copyOfRange(this.l, this.j.getMinValue(), this.j.getMaxValue() + 1);
        this.j.setDisplayedValues(displayedValues);
        this.k.setMinValue(this.p.get(1));
        this.k.setMaxValue(this.q.get(1));
        String[] yearDisplayValues = new String[RemoteControlFeedbackConstant.SUCCESS_WAKE_UP];
        for (int i2 = 0; i2 < yearDisplayValues.length; i2++) {
            yearDisplayValues[i2] = this.b.getResources().getString(zo.x_date_picker_year, Integer.valueOf(this.k.getMinValue() + i2));
        }
        this.k.setDisplayedValues(yearDisplayValues);
        this.k.setWrapSelectorWheel(false);
        this.k.setValue(this.c.get(1));
        this.j.setValue(this.c.get(2));
        this.i.setValue(this.c.get(5));
    }

    public void o(int year, int monthOfYear, int dayOfMonth, XDatePicker.c onDateChangedListener) {
        u(year, monthOfYear, dayOfMonth);
        w();
        this.e = onDateChangedListener;
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.d
    public int e() {
        return this.c.get(1);
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.d
    public int f() {
        return this.c.get(2);
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.d
    public int c() {
        return this.c.get(5);
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.d
    public void i(long minDate) {
        this.o.setTimeInMillis(minDate);
        if (this.o.get(1) == this.p.get(1) && this.o.get(6) == this.p.get(6)) {
            return;
        }
        this.p.setTimeInMillis(minDate);
        if (this.c.before(this.p)) {
            this.c.setTimeInMillis(this.p.getTimeInMillis());
        }
        w();
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.d
    public Calendar d() {
        Calendar calendar = this.p;
        if (calendar != null) {
            return calendar;
        }
        Calendar minDate = Calendar.getInstance();
        minDate.set(1900, 1, 1);
        return minDate;
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.d
    public void h(long maxDate) {
        this.o.setTimeInMillis(maxDate);
        if (this.o.get(1) == this.q.get(1) && this.o.get(6) == this.q.get(6)) {
            return;
        }
        this.q.setTimeInMillis(maxDate);
        if (this.c.after(this.q)) {
            this.c.setTimeInMillis(this.q.getTimeInMillis());
        }
        w();
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.d
    public Calendar a() {
        if (this.q != null) {
            return this.p;
        }
        Calendar maxDate = Calendar.getInstance();
        maxDate.set(2100, 11, 30);
        return maxDate;
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.d
    public void setEnabled(boolean enabled) {
        this.i.setEnabled(enabled);
        this.j.setEnabled(enabled);
        this.k.setEnabled(enabled);
        this.r = enabled;
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.d
    public boolean isEnabled() {
        return this.r;
    }

    public void v(boolean shown) {
        this.h.setVisibility(shown ? 0 : 8);
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.b
    public void l(Locale locale) {
        super.l(locale);
        this.o = m(this.o, locale);
        this.p = m(this.p, locale);
        this.q = m(this.q, locale);
        this.c = m(this.c, locale);
        this.n = this.o.getActualMaximum(2) + 1;
        this.l = new DateFormatSymbols().getShortMonths();
    }

    public final Calendar m(Calendar oldCalendar, Locale locale) {
        if (oldCalendar == null) {
            return Calendar.getInstance(locale);
        }
        long currentTimeMillis = oldCalendar.getTimeInMillis();
        Calendar newCalendar = Calendar.getInstance(locale);
        newCalendar.setTimeInMillis(currentTimeMillis);
        return newCalendar;
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.d
    public void onConfigurationChanged(Configuration newConfig) {
        l(newConfig.getLocales().get(0));
    }
}
