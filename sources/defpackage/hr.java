package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XCheckBox;
import com.xiaopeng.xui.widget.XEditText;
import com.xiaopeng.xui.widget.XGroupHeader;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XProgressBar;
import com.xiaopeng.xui.widget.XRadioButton;
import com.xiaopeng.xui.widget.XRadioGroup;
import com.xiaopeng.xui.widget.XRecyclerView;
import com.xiaopeng.xui.widget.XScrollView;
import com.xiaopeng.xui.widget.XSeekBar;
import com.xiaopeng.xui.widget.XSegmented;
import com.xiaopeng.xui.widget.XSwitch;
import com.xiaopeng.xui.widget.XTabLayout;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.XViewPager;
import com.xiaopeng.xui.widget.slider.XSlider;
import com.xiaopeng.xui.widget.timepicker.XTimePicker;
/* compiled from: VuiViewUtils.java */
/* renamed from: hr  reason: default package */
/* loaded from: classes.dex */
public class hr {
    public static HandlerThread a = new HandlerThread("VuiUpdate");
    public static Handler b;

    public static oo a(Object view) {
        if (view instanceof XImageView) {
            return oo.IMAGEVIEW;
        }
        if (view instanceof XImageButton) {
            return oo.IMAGEBUTTON;
        }
        if (view instanceof XButton) {
            return oo.BUTTON;
        }
        if (view instanceof XTextView) {
            return oo.TEXTVIEW;
        }
        if (view instanceof XRadioButton) {
            return oo.RADIOBUTTON;
        }
        if (view instanceof XCheckBox) {
            return oo.CHECKBOX;
        }
        if (view instanceof XSwitch) {
            return oo.SWITCH;
        }
        if (view instanceof XRecyclerView) {
            return oo.RECYCLEVIEW;
        }
        if (view instanceof XProgressBar) {
            return oo.PROGRESSBAR;
        }
        if (view instanceof XScrollView) {
            return oo.SCROLLVIEW;
        }
        if (view instanceof XSlider) {
            return oo.XSLIDER;
        }
        if (view instanceof XTabLayout) {
            return oo.XTABLAYOUT;
        }
        if (view instanceof XSegmented) {
            return oo.XTABLAYOUT;
        }
        if (view instanceof XRadioGroup) {
            return oo.RADIOGROUP;
        }
        if (view instanceof XEditText) {
            return oo.EDITTEXT;
        }
        if (view instanceof XGroupHeader) {
            return oo.XGROUPHEADER;
        }
        if (view instanceof XSeekBar) {
            return oo.SEEKBAR;
        }
        if (view instanceof XTimePicker) {
            return oo.TIMEPICKER;
        }
        if (view instanceof XViewPager) {
            return oo.VIEWPAGER;
        }
        if (view instanceof ViewGroup) {
            return oo.GROUP;
        }
        return oo.UNKNOWN;
    }

    public static void b(ko listener, View view, so type) {
        try {
            if (b == null) {
                a.start();
                b = new Handler(a.getLooper());
            }
            Handler handler = b;
            if (handler != null) {
                handler.post(new a(listener, view, type));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* compiled from: VuiViewUtils.java */
    /* renamed from: hr$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public final /* synthetic */ ko a;
        public final /* synthetic */ View b;
        public final /* synthetic */ so d;

        public a(ko koVar, View view, so soVar) {
            this.a = koVar;
            this.b = view;
            this.d = soVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            ko koVar = this.a;
            if (koVar != null && (view = this.b) != null) {
                koVar.a(view, this.d);
            }
        }
    }
}
