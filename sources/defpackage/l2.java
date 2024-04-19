package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;
/* compiled from: DropDownListView.java */
/* renamed from: l2  reason: default package */
/* loaded from: classes.dex */
public class l2 extends ListView {
    public final Rect a;
    public int b;
    public int d;
    public int f;
    public int g;
    public int h;
    public Field i;
    public a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public ka n;
    public db o;
    public b p;

    public l2(Context context, boolean hijackFocus) {
        super(context, null, n.z);
        this.a = new Rect();
        this.b = 0;
        this.d = 0;
        this.f = 0;
        this.g = 0;
        this.l = hijackFocus;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.i = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.l && this.k) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.l || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.l || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.l || super.hasFocus();
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable sel) {
        a aVar = sel != null ? new a(sel) : null;
        this.j = aVar;
        super.setSelector(aVar);
        Rect padding = new Rect();
        if (sel != null) {
            sel.getPadding(padding);
        }
        this.b = padding.left;
        this.d = padding.top;
        this.f = padding.right;
        this.g = padding.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.p != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        k();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
                this.h = pointToPosition((int) ev.getX(), (int) ev.getY());
                break;
        }
        b bVar = this.p;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(ev);
    }

    public int d(int widthMeasureSpec, int startPosition, int endPosition, int maxHeight, int disallowPartialChildPosition) {
        int paddingTop;
        ViewGroup.LayoutParams childLp;
        int paddingTop2 = getListPaddingTop();
        int paddingBottom = getListPaddingBottom();
        int reportedDividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return paddingTop2 + paddingBottom;
        }
        int returnedHeight = paddingTop2 + paddingBottom;
        int dividerHeight = (reportedDividerHeight <= 0 || divider == null) ? 0 : reportedDividerHeight;
        int prevHeightWithoutPartialChild = 0;
        View child = null;
        int viewType = 0;
        int count = adapter.getCount();
        int i = 0;
        while (i < count) {
            int newType = adapter.getItemViewType(i);
            if (newType != viewType) {
                child = null;
                viewType = newType;
            }
            child = adapter.getView(i, child, this);
            ViewGroup.LayoutParams childLp2 = child.getLayoutParams();
            if (childLp2 != null) {
                paddingTop = paddingTop2;
                childLp = childLp2;
            } else {
                paddingTop = paddingTop2;
                childLp = generateDefaultLayoutParams();
                child.setLayoutParams(childLp);
            }
            int paddingBottom2 = paddingBottom;
            int paddingBottom3 = childLp.height;
            int heightMeasureSpec = paddingBottom3 > 0 ? View.MeasureSpec.makeMeasureSpec(paddingBottom3, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0);
            child.measure(widthMeasureSpec, heightMeasureSpec);
            child.forceLayout();
            if (i > 0) {
                returnedHeight += dividerHeight;
            }
            returnedHeight += child.getMeasuredHeight();
            if (returnedHeight >= maxHeight) {
                if (disallowPartialChildPosition >= 0 && i > disallowPartialChildPosition && prevHeightWithoutPartialChild > 0 && returnedHeight != maxHeight) {
                    return prevHeightWithoutPartialChild;
                }
                return maxHeight;
            }
            if (disallowPartialChildPosition >= 0 && i >= disallowPartialChildPosition) {
                prevHeightWithoutPartialChild = returnedHeight;
            }
            i++;
            paddingBottom = paddingBottom2;
            paddingTop2 = paddingTop;
        }
        return returnedHeight;
    }

    private void setSelectorEnabled(boolean enabled) {
        a aVar = this.j;
        if (aVar != null) {
            aVar.c(enabled);
        }
    }

    /* compiled from: DropDownListView.java */
    /* renamed from: l2$a */
    /* loaded from: classes.dex */
    public static class a extends m0 {
        public boolean b;

        public a(Drawable drawable) {
            super(drawable);
            this.b = true;
        }

        public void c(boolean enabled) {
            this.b = enabled;
        }

        @Override // defpackage.m0, android.graphics.drawable.Drawable
        public boolean setState(int[] stateSet) {
            if (this.b) {
                return super.setState(stateSet);
            }
            return false;
        }

        @Override // defpackage.m0, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.b) {
                super.draw(canvas);
            }
        }

        @Override // defpackage.m0, android.graphics.drawable.Drawable
        public void setHotspot(float x, float y) {
            if (this.b) {
                super.setHotspot(x, y);
            }
        }

        @Override // defpackage.m0, android.graphics.drawable.Drawable
        public void setHotspotBounds(int left, int top, int right, int bottom) {
            if (this.b) {
                super.setHotspotBounds(left, top, right, bottom);
            }
        }

        @Override // defpackage.m0, android.graphics.drawable.Drawable
        public boolean setVisible(boolean visible, boolean restart) {
            if (this.b) {
                return super.setVisible(visible, restart);
            }
            return false;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent ev) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(ev);
        }
        int action = ev.getActionMasked();
        if (action == 10 && this.p == null) {
            b bVar = new b();
            this.p = bVar;
            bVar.b();
        }
        boolean handled = super.onHoverEvent(ev);
        if (action == 9 || action == 7) {
            int position = pointToPosition((int) ev.getX(), (int) ev.getY());
            if (position != -1 && position != getSelectedItemPosition()) {
                View hoveredItem = getChildAt(position - getFirstVisiblePosition());
                if (hoveredItem.isEnabled()) {
                    setSelectionFromTop(position, hoveredItem.getTop() - getTop());
                }
                k();
            }
        } else {
            setSelection(-1);
        }
        return handled;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.p = null;
        super.onDetachedFromWindow();
    }

    public boolean e(MotionEvent event, int activePointerId) {
        boolean handledEvent = true;
        boolean clearPressedItem = false;
        int actionMasked = event.getActionMasked();
        switch (actionMasked) {
            case 1:
                handledEvent = false;
            case 2:
                int activeIndex = event.findPointerIndex(activePointerId);
                if (activeIndex < 0) {
                    handledEvent = false;
                    break;
                } else {
                    int x = (int) event.getX(activeIndex);
                    int y = (int) event.getY(activeIndex);
                    int position = pointToPosition(x, y);
                    if (position == -1) {
                        clearPressedItem = true;
                        break;
                    } else {
                        View child = getChildAt(position - getFirstVisiblePosition());
                        i(child, position, x, y);
                        handledEvent = true;
                        if (actionMasked == 1) {
                            b(child, position);
                            break;
                        }
                    }
                }
                break;
            case 3:
                handledEvent = false;
                break;
        }
        if (!handledEvent || clearPressedItem) {
            a();
        }
        if (handledEvent) {
            if (this.o == null) {
                this.o = new db(this);
            }
            this.o.m(true);
            this.o.onTouch(this, event);
        } else {
            db dbVar = this.o;
            if (dbVar != null) {
                dbVar.m(false);
            }
        }
        return handledEvent;
    }

    public final void b(View child, int position) {
        long id = getItemIdAtPosition(position);
        performItemClick(child, position, id);
    }

    public void setListSelectionHidden(boolean hideListSelection) {
        this.k = hideListSelection;
    }

    public final void k() {
        Drawable selector = getSelector();
        if (selector != null && j() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (!this.a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.a);
            selector.draw(canvas);
        }
    }

    public final void h(int position, View sel, float x, float y) {
        g(position, sel);
        Drawable selector = getSelector();
        if (selector != null && position != -1) {
            i8.j(selector, x, y);
        }
    }

    public final void g(int position, View sel) {
        Drawable selector = getSelector();
        boolean manageState = (selector == null || position == -1) ? false : true;
        if (manageState) {
            selector.setVisible(false, false);
        }
        f(position, sel);
        if (manageState) {
            Rect bounds = this.a;
            float x = bounds.exactCenterX();
            float y = bounds.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            i8.j(selector, x, y);
        }
    }

    public final void f(int position, View sel) {
        Rect selectorRect = this.a;
        selectorRect.set(sel.getLeft(), sel.getTop(), sel.getRight(), sel.getBottom());
        selectorRect.left -= this.b;
        selectorRect.top -= this.d;
        selectorRect.right += this.f;
        selectorRect.bottom += this.g;
        try {
            boolean isChildViewEnabled = this.i.getBoolean(this);
            if (sel.isEnabled() != isChildViewEnabled) {
                this.i.set(this, Boolean.valueOf(!isChildViewEnabled));
                if (position != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public final void a() {
        this.m = false;
        setPressed(false);
        drawableStateChanged();
        View motionView = getChildAt(this.h - getFirstVisiblePosition());
        if (motionView != null) {
            motionView.setPressed(false);
        }
        ka kaVar = this.n;
        if (kaVar != null) {
            kaVar.b();
            this.n = null;
        }
    }

    public final void i(View child, int position, float x, float y) {
        View motionView;
        this.m = true;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            drawableHotspotChanged(x, y);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i2 = this.h;
        if (i2 != -1 && (motionView = getChildAt(i2 - getFirstVisiblePosition())) != null && motionView != child && motionView.isPressed()) {
            motionView.setPressed(false);
        }
        this.h = position;
        float childX = x - child.getLeft();
        float childY = y - child.getTop();
        if (i >= 21) {
            child.drawableHotspotChanged(childX, childY);
        }
        if (!child.isPressed()) {
            child.setPressed(true);
        }
        h(position, child, x, y);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    public final boolean j() {
        return this.m;
    }

    /* compiled from: DropDownListView.java */
    /* renamed from: l2$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l2 l2Var = l2.this;
            l2Var.p = null;
            l2Var.drawableStateChanged();
        }

        public void a() {
            l2 l2Var = l2.this;
            l2Var.p = null;
            l2Var.removeCallbacks(this);
        }

        public void b() {
            l2.this.post(this);
        }
    }
}
