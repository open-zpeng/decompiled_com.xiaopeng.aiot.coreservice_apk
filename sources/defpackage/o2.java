package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.lzy.okgo.model.Priority;
import java.lang.reflect.Method;
/* compiled from: ListPopupWindow.java */
/* renamed from: o2  reason: default package */
/* loaded from: classes.dex */
public class o2 implements o1 {
    public static Method a;
    public static Method b;
    public static Method d;
    public AdapterView.OnItemSelectedListener A;
    public final g B;
    public final f C;
    public final e D;
    public final c E;
    public Runnable F;
    public final Handler G;
    public final Rect H;
    public Rect I;
    public boolean J;
    public PopupWindow K;
    public Context f;
    public ListAdapter g;
    public l2 h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public View u;
    public int v;
    public DataSetObserver w;
    public View x;
    public Drawable y;
    public AdapterView.OnItemClickListener z;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e2) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                d = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException e3) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException e4) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public o2(Context context) {
        this(context, null, n.D);
    }

    public o2(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public o2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.i = -2;
        this.j = -2;
        this.m = 1002;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = Priority.UI_TOP;
        this.v = 0;
        this.B = new g();
        this.C = new f();
        this.D = new e();
        this.E = new c();
        this.H = new Rect();
        this.f = context;
        this.G = new Handler(context.getMainLooper());
        TypedArray a2 = context.obtainStyledAttributes(attrs, w.o1, defStyleAttr, defStyleRes);
        this.k = a2.getDimensionPixelOffset(w.p1, 0);
        int dimensionPixelOffset = a2.getDimensionPixelOffset(w.q1, 0);
        this.l = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.n = true;
        }
        a2.recycle();
        b2 b2Var = new b2(context, attrs, defStyleAttr, defStyleRes);
        this.K = b2Var;
        b2Var.setInputMethodMode(1);
    }

    public void p(ListAdapter adapter) {
        DataSetObserver dataSetObserver = this.w;
        if (dataSetObserver == null) {
            this.w = new d();
        } else {
            ListAdapter listAdapter = this.g;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.g = adapter;
        if (adapter != null) {
            adapter.registerDataSetObserver(this.w);
        }
        l2 l2Var = this.h;
        if (l2Var != null) {
            l2Var.setAdapter(this.g);
        }
    }

    public void K(int position) {
        this.v = position;
    }

    public void F(boolean modal) {
        this.J = modal;
        this.K.setFocusable(modal);
    }

    public boolean x() {
        return this.J;
    }

    public Drawable f() {
        return this.K.getBackground();
    }

    public void i(Drawable d2) {
        this.K.setBackgroundDrawable(d2);
    }

    public void A(int animationStyle) {
        this.K.setAnimationStyle(animationStyle);
    }

    public View t() {
        return this.x;
    }

    public void z(View anchor) {
        this.x = anchor;
    }

    public int a() {
        return this.k;
    }

    public void l(int offset) {
        this.k = offset;
    }

    public int n() {
        if (!this.n) {
            return 0;
        }
        return this.l;
    }

    public void j(int offset) {
        this.l = offset;
        this.n = true;
    }

    public void D(Rect bounds) {
        this.I = bounds != null ? new Rect(bounds) : null;
    }

    public void C(int gravity) {
        this.q = gravity;
    }

    public int v() {
        return this.j;
    }

    public void M(int width) {
        this.j = width;
    }

    public void B(int width) {
        Drawable popupBackground = this.K.getBackground();
        if (popupBackground != null) {
            popupBackground.getPadding(this.H);
            Rect rect = this.H;
            this.j = rect.left + rect.right + width;
            return;
        }
        M(width);
    }

    public void H(AdapterView.OnItemClickListener clickListener) {
        this.z = clickListener;
    }

    @Override // defpackage.o1
    public void d() {
        int widthSpec;
        int heightSpec;
        int widthSpec2;
        int heightSpec2;
        int height = q();
        boolean noInputMethod = w();
        fb.b(this.K, this.m);
        boolean z = true;
        if (this.K.isShowing()) {
            if (!ga.I(t())) {
                return;
            }
            int widthSpec3 = this.j;
            if (widthSpec3 == -1) {
                widthSpec2 = -1;
            } else if (widthSpec3 == -2) {
                widthSpec2 = t().getWidth();
            } else {
                widthSpec2 = this.j;
            }
            int i = this.i;
            if (i == -1) {
                heightSpec2 = noInputMethod ? height : -1;
                if (noInputMethod) {
                    this.K.setWidth(this.j == -1 ? -1 : 0);
                    this.K.setHeight(0);
                } else {
                    this.K.setWidth(this.j == -1 ? -1 : 0);
                    this.K.setHeight(-1);
                }
            } else {
                heightSpec2 = i == -2 ? height : this.i;
            }
            PopupWindow popupWindow = this.K;
            if (this.s || this.r) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.K.update(t(), this.k, this.l, widthSpec2 < 0 ? -1 : widthSpec2, heightSpec2 < 0 ? -1 : heightSpec2);
            return;
        }
        int widthSpec4 = this.j;
        if (widthSpec4 == -1) {
            widthSpec = -1;
        } else if (widthSpec4 == -2) {
            widthSpec = t().getWidth();
        } else {
            widthSpec = this.j;
        }
        int i2 = this.i;
        if (i2 == -1) {
            heightSpec = -1;
        } else if (i2 == -2) {
            heightSpec = height;
        } else {
            heightSpec = this.i;
        }
        this.K.setWidth(widthSpec);
        this.K.setHeight(heightSpec);
        J(true);
        this.K.setOutsideTouchable((this.s || this.r) ? false : true);
        this.K.setTouchInterceptor(this.C);
        if (this.p) {
            fb.a(this.K, this.o);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = d;
            if (method != null) {
                try {
                    method.invoke(this.K, this.I);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.K.setEpicenterBounds(this.I);
        }
        fb.c(this.K, t(), this.k, this.l, this.q);
        this.h.setSelection(-1);
        if (!this.J || this.h.isInTouchMode()) {
            r();
        }
        if (!this.J) {
            this.G.post(this.E);
        }
    }

    @Override // defpackage.o1
    public void dismiss() {
        this.K.dismiss();
        y();
        this.K.setContentView(null);
        this.h = null;
        this.G.removeCallbacks(this.B);
    }

    public void G(PopupWindow.OnDismissListener listener) {
        this.K.setOnDismissListener(listener);
    }

    public final void y() {
        View view = this.u;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) parent;
                group.removeView(this.u);
            }
        }
    }

    public void E(int mode) {
        this.K.setInputMethodMode(mode);
    }

    public void L(int position) {
        l2 list = this.h;
        if (b() && list != null) {
            list.setListSelectionHidden(false);
            list.setSelection(position);
            if (list.getChoiceMode() != 0) {
                list.setItemChecked(position, true);
            }
        }
    }

    public void r() {
        l2 list = this.h;
        if (list != null) {
            list.setListSelectionHidden(true);
            list.requestLayout();
        }
    }

    @Override // defpackage.o1
    public boolean b() {
        return this.K.isShowing();
    }

    public boolean w() {
        return this.K.getInputMethodMode() == 2;
    }

    @Override // defpackage.o1
    public ListView g() {
        return this.h;
    }

    public l2 s(Context context, boolean hijackFocus) {
        return new l2(context, hijackFocus);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int q() {
        int padding;
        int childWidthSpec;
        int widthMode;
        int widthSize;
        int otherHeights = 0;
        if (this.h == null) {
            Context context = this.f;
            this.F = new a();
            l2 s = s(context, !this.J);
            this.h = s;
            Drawable drawable = this.y;
            if (drawable != null) {
                s.setSelector(drawable);
            }
            this.h.setAdapter(this.g);
            this.h.setOnItemClickListener(this.z);
            this.h.setFocusable(true);
            this.h.setFocusableInTouchMode(true);
            this.h.setOnItemSelectedListener(new b());
            this.h.setOnScrollListener(this.D);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.A;
            if (onItemSelectedListener != null) {
                this.h.setOnItemSelectedListener(onItemSelectedListener);
            }
            ViewGroup dropDownView = this.h;
            View hintView = this.u;
            if (hintView != null) {
                LinearLayout hintContainer = new LinearLayout(context);
                hintContainer.setOrientation(1);
                LinearLayout.LayoutParams hintParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.v) {
                    case 0:
                        hintContainer.addView(hintView);
                        hintContainer.addView(dropDownView, hintParams);
                        break;
                    case 1:
                        hintContainer.addView(dropDownView, hintParams);
                        hintContainer.addView(hintView);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.v);
                        break;
                }
                if (this.j >= 0) {
                    widthMode = Priority.BG_LOW;
                    widthSize = this.j;
                } else {
                    widthMode = 0;
                    widthSize = 0;
                }
                int widthSpec = View.MeasureSpec.makeMeasureSpec(widthSize, widthMode);
                hintView.measure(widthSpec, 0);
                LinearLayout.LayoutParams hintParams2 = (LinearLayout.LayoutParams) hintView.getLayoutParams();
                dropDownView = hintContainer;
                otherHeights = hintView.getMeasuredHeight() + hintParams2.topMargin + hintParams2.bottomMargin;
            }
            this.K.setContentView(dropDownView);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.K.getContentView();
            View view = this.u;
            if (view != null) {
                LinearLayout.LayoutParams hintParams3 = (LinearLayout.LayoutParams) view.getLayoutParams();
                otherHeights = view.getMeasuredHeight() + hintParams3.topMargin + hintParams3.bottomMargin;
            }
        }
        Drawable background = this.K.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            Rect rect = this.H;
            int i = rect.top;
            padding = rect.bottom + i;
            if (!this.n) {
                this.l = -i;
            }
        } else {
            this.H.setEmpty();
            padding = 0;
        }
        boolean ignoreBottomDecorations = this.K.getInputMethodMode() == 2;
        int maxHeight = u(t(), this.l, ignoreBottomDecorations);
        if (this.r || this.i == -1) {
            int childWidthSpec2 = maxHeight + padding;
            return childWidthSpec2;
        }
        int i2 = this.j;
        switch (i2) {
            case -2:
                int i3 = this.f.getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = this.H;
                childWidthSpec = View.MeasureSpec.makeMeasureSpec(i3 - (rect2.left + rect2.right), Priority.BG_LOW);
                break;
            case -1:
                int i4 = this.f.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.H;
                childWidthSpec = View.MeasureSpec.makeMeasureSpec(i4 - (rect3.left + rect3.right), 1073741824);
                break;
            default:
                childWidthSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
                break;
        }
        int listContent = this.h.d(childWidthSpec, 0, -1, maxHeight - otherHeights, -1);
        if (listContent > 0) {
            int listPadding = this.h.getPaddingTop() + this.h.getPaddingBottom();
            otherHeights += padding + listPadding;
        }
        int listPadding2 = listContent + otherHeights;
        return listPadding2;
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: o2$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = o2.this.t();
            if (view != null && view.getWindowToken() != null) {
                o2.this.d();
            }
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: o2$b */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            l2 dropDownList;
            if (position != -1 && (dropDownList = o2.this.h) != null) {
                dropDownList.setListSelectionHidden(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    public void I(boolean overlapAnchor) {
        this.p = true;
        this.o = overlapAnchor;
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: o2$d */
    /* loaded from: classes.dex */
    public class d extends DataSetObserver {
        public d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (o2.this.b()) {
                o2.this.d();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            o2.this.dismiss();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: o2$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o2.this.r();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: o2$g */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l2 l2Var = o2.this.h;
            if (l2Var != null && ga.I(l2Var) && o2.this.h.getCount() > o2.this.h.getChildCount()) {
                int childCount = o2.this.h.getChildCount();
                o2 o2Var = o2.this;
                if (childCount <= o2Var.t) {
                    o2Var.K.setInputMethodMode(2);
                    o2.this.d();
                }
            }
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: o2$f */
    /* loaded from: classes.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            PopupWindow popupWindow;
            int action = event.getAction();
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (action == 0 && (popupWindow = o2.this.K) != null && popupWindow.isShowing() && x >= 0 && x < o2.this.K.getWidth() && y >= 0 && y < o2.this.K.getHeight()) {
                o2 o2Var = o2.this;
                o2Var.G.postDelayed(o2Var.B, 250L);
                return false;
            } else if (action == 1) {
                o2 o2Var2 = o2.this;
                o2Var2.G.removeCallbacks(o2Var2.B);
                return false;
            } else {
                return false;
            }
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* renamed from: o2$e */
    /* loaded from: classes.dex */
    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == 1 && !o2.this.w() && o2.this.K.getContentView() != null) {
                o2 o2Var = o2.this;
                o2Var.G.removeCallbacks(o2Var.B);
                o2.this.B.run();
            }
        }
    }

    public final void J(boolean clip) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = a;
            if (method != null) {
                try {
                    method.invoke(this.K, Boolean.valueOf(clip));
                    return;
                } catch (Exception e2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.K.setIsClippedToScreen(clip);
    }

    public final int u(View anchor, int yOffset, boolean ignoreBottomDecorations) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = b;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.K, anchor, Integer.valueOf(yOffset), Boolean.valueOf(ignoreBottomDecorations))).intValue();
                } catch (Exception e2) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.K.getMaxAvailableHeight(anchor, yOffset);
        }
        return this.K.getMaxAvailableHeight(anchor, yOffset, ignoreBottomDecorations);
    }
}
