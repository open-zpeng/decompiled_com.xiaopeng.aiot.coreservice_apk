package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.lzy.okgo.model.Priority;
/* compiled from: OrientationHelper.java */
/* renamed from: oe  reason: default package */
/* loaded from: classes.dex */
public abstract class oe {
    public final RecyclerView.h a;
    public int b;
    public final Rect c;

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o(View view);

    public abstract int p(View view);

    public abstract void q(int i);

    public /* synthetic */ oe(RecyclerView.h x0, a x1) {
        this(x0);
    }

    public oe(RecyclerView.h layoutManager) {
        this.b = Priority.BG_LOW;
        this.c = new Rect();
        this.a = layoutManager;
    }

    public static oe b(RecyclerView.h layoutManager, int orientation) {
        switch (orientation) {
            case 0:
                return a(layoutManager);
            case 1:
                return c(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    /* compiled from: OrientationHelper.java */
    /* renamed from: oe$a */
    /* loaded from: classes.dex */
    public class a extends oe {
        public a(RecyclerView.h layoutManager) {
            super(layoutManager, null);
        }

        @Override // defpackage.oe
        public int i() {
            return this.a.Z() - this.a.S();
        }

        @Override // defpackage.oe
        public int h() {
            return this.a.Z();
        }

        @Override // defpackage.oe
        public void q(int amount) {
            this.a.j0(amount);
        }

        @Override // defpackage.oe
        public int m() {
            return this.a.R();
        }

        @Override // defpackage.oe
        public int e(View view) {
            RecyclerView.i params = (RecyclerView.i) view.getLayoutParams();
            return this.a.J(view) + ((ViewGroup.MarginLayoutParams) params).leftMargin + ((ViewGroup.MarginLayoutParams) params).rightMargin;
        }

        @Override // defpackage.oe
        public int f(View view) {
            RecyclerView.i params = (RecyclerView.i) view.getLayoutParams();
            return this.a.I(view) + ((ViewGroup.MarginLayoutParams) params).topMargin + ((ViewGroup.MarginLayoutParams) params).bottomMargin;
        }

        @Override // defpackage.oe
        public int d(View view) {
            RecyclerView.i params = (RecyclerView.i) view.getLayoutParams();
            return this.a.K(view) + ((ViewGroup.MarginLayoutParams) params).rightMargin;
        }

        @Override // defpackage.oe
        public int g(View view) {
            RecyclerView.i params = (RecyclerView.i) view.getLayoutParams();
            return this.a.H(view) - ((ViewGroup.MarginLayoutParams) params).leftMargin;
        }

        @Override // defpackage.oe
        public int o(View view) {
            this.a.Y(view, true, this.c);
            return this.c.right;
        }

        @Override // defpackage.oe
        public int p(View view) {
            this.a.Y(view, true, this.c);
            return this.c.left;
        }

        @Override // defpackage.oe
        public int n() {
            return (this.a.Z() - this.a.R()) - this.a.S();
        }

        @Override // defpackage.oe
        public int j() {
            return this.a.S();
        }

        @Override // defpackage.oe
        public int k() {
            return this.a.a0();
        }

        @Override // defpackage.oe
        public int l() {
            return this.a.N();
        }
    }

    public static oe a(RecyclerView.h layoutManager) {
        return new a(layoutManager);
    }

    /* compiled from: OrientationHelper.java */
    /* renamed from: oe$b */
    /* loaded from: classes.dex */
    public class b extends oe {
        public b(RecyclerView.h layoutManager) {
            super(layoutManager, null);
        }

        @Override // defpackage.oe
        public int i() {
            return this.a.M() - this.a.Q();
        }

        @Override // defpackage.oe
        public int h() {
            return this.a.M();
        }

        @Override // defpackage.oe
        public void q(int amount) {
            this.a.k0(amount);
        }

        @Override // defpackage.oe
        public int m() {
            return this.a.T();
        }

        @Override // defpackage.oe
        public int e(View view) {
            RecyclerView.i params = (RecyclerView.i) view.getLayoutParams();
            return this.a.I(view) + ((ViewGroup.MarginLayoutParams) params).topMargin + ((ViewGroup.MarginLayoutParams) params).bottomMargin;
        }

        @Override // defpackage.oe
        public int f(View view) {
            RecyclerView.i params = (RecyclerView.i) view.getLayoutParams();
            return this.a.J(view) + ((ViewGroup.MarginLayoutParams) params).leftMargin + ((ViewGroup.MarginLayoutParams) params).rightMargin;
        }

        @Override // defpackage.oe
        public int d(View view) {
            RecyclerView.i params = (RecyclerView.i) view.getLayoutParams();
            return this.a.F(view) + ((ViewGroup.MarginLayoutParams) params).bottomMargin;
        }

        @Override // defpackage.oe
        public int g(View view) {
            RecyclerView.i params = (RecyclerView.i) view.getLayoutParams();
            return this.a.L(view) - ((ViewGroup.MarginLayoutParams) params).topMargin;
        }

        @Override // defpackage.oe
        public int o(View view) {
            this.a.Y(view, true, this.c);
            return this.c.bottom;
        }

        @Override // defpackage.oe
        public int p(View view) {
            this.a.Y(view, true, this.c);
            return this.c.top;
        }

        @Override // defpackage.oe
        public int n() {
            return (this.a.M() - this.a.T()) - this.a.Q();
        }

        @Override // defpackage.oe
        public int j() {
            return this.a.Q();
        }

        @Override // defpackage.oe
        public int k() {
            return this.a.N();
        }

        @Override // defpackage.oe
        public int l() {
            return this.a.a0();
        }
    }

    public static oe c(RecyclerView.h layoutManager) {
        return new b(layoutManager);
    }
}
