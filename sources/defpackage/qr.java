package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.xiaopeng.xui.view.XView;
import defpackage.uq;
/* compiled from: XQuickSideBarTipsItemView.java */
/* renamed from: qr  reason: default package */
/* loaded from: classes.dex */
public class qr extends XView {
    public RectF b;
    public Paint d;
    public String f;
    public Paint g;
    public int h;
    public int i;
    public float j;
    public int k;
    public int l;
    public boolean m;

    public qr(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public qr(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.b = new RectF();
        this.f = "";
        this.m = false;
        h(context, attrs);
    }

    public final void h(Context context, AttributeSet attrs) {
        uq uqVar;
        i();
        Resources resources = context.getResources();
        int i = vo.x_sidebar_tips_textsize;
        this.j = resources.getDimension(i);
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, bp.q2);
            this.k = a.getColor(bp.s2, this.k);
            this.l = a.getColor(bp.r2, this.l);
            a.recycle();
        }
        final zq xFontScaleHelper = zq.c(getResources(), i);
        if (xFontScaleHelper != null && (uqVar = this.a) != null) {
            uqVar.i(new uq.a() { // from class: pr
                @Override // defpackage.uq.a
                public final void d() {
                    qr.this.n(xFontScaleHelper);
                }
            });
        }
        this.d = new Paint(1);
        this.g = new Paint(1);
        this.d.setColor(this.l);
        this.g.setColor(this.k);
        this.g.setTextSize(this.j);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setTypeface(Typeface.create(getResources().getString(zo.x_font_typeface_number_bold), 0));
        this.g.setTextAlign(Paint.Align.CENTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void n(zq xFontScaleHelper) {
        float f = xFontScaleHelper.f(getResources().getDisplayMetrics());
        this.j = f;
        this.g.setTextSize(f);
        invalidate();
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        this.h = measuredWidth;
        this.i = measuredWidth;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        canvas.drawColor(getResources().getColor(17170445, null));
        this.b.set(0.0f, 0.0f, this.h, this.i);
        canvas.drawRoundRect(this.b, 16.0f, 16.0f, this.d);
        Paint.FontMetrics fontMetrics = this.g.getFontMetrics();
        float top = fontMetrics.top;
        float bottom = fontMetrics.bottom;
        int baseLineY = (int) ((this.b.centerY() - (top / 2.0f)) - (bottom / 8.0f));
        canvas.drawText(this.f, this.b.centerX(), baseLineY, this.g);
    }

    public void o(String text) {
        this.f = text;
        Rect rect = new Rect();
        Paint paint = this.g;
        String str = this.f;
        paint.getTextBounds(str, 0, str.length(), rect);
        invalidate();
    }

    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mq.d(newConfig)) {
            i();
            this.d.setColor(this.l);
            this.g.setColor(this.k);
            invalidate();
        }
    }

    public final void i() {
        this.k = f(uo.x_side_bar_tips_text_color);
        this.l = f(uo.x_side_bar_tips_bg_color);
    }

    public final int f(int resourceId) {
        return getResources().getColor(resourceId, getContext().getTheme());
    }
}
