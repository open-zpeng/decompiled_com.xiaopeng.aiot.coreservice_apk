package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import com.lzy.okgo.model.Priority;
/* compiled from: AbsActionBarView.java */
/* renamed from: s1  reason: default package */
/* loaded from: classes.dex */
public abstract class s1 extends ViewGroup {
    public final a a;
    public final Context b;
    public ActionMenuView d;
    public u1 f;
    public int g;
    public ka h;
    public boolean i;
    public boolean j;

    public abstract void setContentHeight(int i);

    public s1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public s1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        int i;
        this.a = new a();
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(n.a, tv, true) && (i = tv.resourceId) != 0) {
            this.b = new ContextThemeWrapper(context, i);
        } else {
            this.b = context;
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        TypedArray a2 = getContext().obtainStyledAttributes(null, w.a, n.c, 0);
        setContentHeight(a2.getLayoutDimension(w.j, 0));
        a2.recycle();
        u1 u1Var = this.f;
        if (u1Var != null) {
            u1Var.F(newConfig);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (action == 0) {
            this.i = false;
        }
        if (!this.i) {
            boolean handled = super.onTouchEvent(ev);
            if (action == 0 && !handled) {
                this.i = true;
            }
        }
        if (action == 1 || action == 3) {
            this.i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (action == 9) {
            this.j = false;
        }
        if (!this.j) {
            boolean handled = super.onHoverEvent(ev);
            if (action == 9 && !handled) {
                this.j = true;
            }
        }
        if (action == 10 || action == 3) {
            this.j = false;
        }
        return true;
    }

    public int getContentHeight() {
        return this.g;
    }

    public int getAnimatedVisibility() {
        if (this.h != null) {
            return this.a.b;
        }
        return getVisibility();
    }

    public ka f(int visibility, long duration) {
        ka kaVar = this.h;
        if (kaVar != null) {
            kaVar.b();
        }
        if (visibility != 0) {
            ka anim = ga.b(this).a(0.0f);
            anim.d(duration);
            anim.f(this.a.d(anim, visibility));
            return anim;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        ka anim2 = ga.b(this).a(1.0f);
        anim2.d(duration);
        anim2.f(this.a.d(anim2, visibility));
        return anim2;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        if (visibility != getVisibility()) {
            ka kaVar = this.h;
            if (kaVar != null) {
                kaVar.b();
            }
            super.setVisibility(visibility);
        }
    }

    public int c(View child, int availableWidth, int childSpecHeight, int spacing) {
        child.measure(View.MeasureSpec.makeMeasureSpec(availableWidth, Priority.BG_LOW), childSpecHeight);
        return Math.max(0, (availableWidth - child.getMeasuredWidth()) - spacing);
    }

    public static int d(int x, int val, boolean isRtl) {
        return isRtl ? x - val : x + val;
    }

    public int e(View child, int x, int y, int contentHeight, boolean reverse) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = ((contentHeight - childHeight) / 2) + y;
        if (reverse) {
            child.layout(x - childWidth, childTop, x, childTop + childHeight);
        } else {
            child.layout(x, childTop, x + childWidth, childTop + childHeight);
        }
        return reverse ? -childWidth : childWidth;
    }

    /* compiled from: AbsActionBarView.java */
    /* renamed from: s1$a */
    /* loaded from: classes.dex */
    public class a implements la {
        public boolean a = false;
        public int b;

        public a() {
        }

        public a d(ka animation, int visibility) {
            s1.this.h = animation;
            this.b = visibility;
            return this;
        }

        @Override // defpackage.la
        public void c(View view) {
            s1.super.setVisibility(0);
            this.a = false;
        }

        @Override // defpackage.la
        public void b(View view) {
            if (this.a) {
                return;
            }
            s1 s1Var = s1.this;
            s1Var.h = null;
            s1.super.setVisibility(this.b);
        }

        @Override // defpackage.la
        public void a(View view) {
            this.a = true;
        }
    }
}
