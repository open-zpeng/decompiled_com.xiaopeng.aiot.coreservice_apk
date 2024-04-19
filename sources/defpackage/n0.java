package defpackage;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import defpackage.l0;
/* compiled from: StateListDrawable.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: n0  reason: default package */
/* loaded from: classes.dex */
public class n0 extends l0 {
    public a o;
    public boolean p;

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] stateSet) {
        boolean changed = super.onStateChange(stateSet);
        int idx = this.o.B(stateSet);
        if (idx < 0) {
            idx = this.o.B(StateSet.WILD_CARD);
        }
        return f(idx) || changed;
    }

    public int[] j(AttributeSet attrs) {
        int j = 0;
        int numAttrs = attrs.getAttributeCount();
        int[] states = new int[numAttrs];
        for (int i = 0; i < numAttrs; i++) {
            int stateResId = attrs.getAttributeNameResource(i);
            switch (stateResId) {
                case 0:
                case 16842960:
                case 16843161:
                    break;
                default:
                    int j2 = j + 1;
                    states[j] = attrs.getAttributeBooleanValue(i, false) ? stateResId : -stateResId;
                    j = j2;
                    break;
            }
        }
        return StateSet.trimStateSet(states, j);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.p && super.mutate() == this) {
            this.o.s();
            this.p = true;
        }
        return this;
    }

    @Override // defpackage.l0
    /* renamed from: i */
    public a b() {
        return new a(this.o, this, null);
    }

    @Override // defpackage.l0
    public void clearMutated() {
        super.clearMutated();
        this.p = false;
    }

    /* compiled from: StateListDrawable.java */
    /* renamed from: n0$a */
    /* loaded from: classes.dex */
    public static class a extends l0.d {
        public int[][] J;

        public a(a orig, n0 owner, Resources res) {
            super(orig, owner, res);
            if (orig != null) {
                this.J = orig.J;
            } else {
                this.J = new int[g()];
            }
        }

        @Override // defpackage.l0.d
        public void s() {
            int[][] iArr = this.J;
            int[][] stateSets = new int[iArr.length];
            for (int i = iArr.length - 1; i >= 0; i--) {
                int[][] iArr2 = this.J;
                stateSets[i] = iArr2[i] != null ? (int[]) iArr2[i].clone() : null;
            }
            this.J = stateSets;
        }

        public int A(int[] stateSet, Drawable drawable) {
            int pos = a(drawable);
            this.J[pos] = stateSet;
            return pos;
        }

        public int B(int[] stateSet) {
            int[][] stateSets = this.J;
            int count = i();
            for (int i = 0; i < count; i++) {
                if (StateSet.stateSetMatches(stateSets[i], stateSet)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new n0(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            return new n0(this, res);
        }

        @Override // defpackage.l0.d
        public void p(int oldSize, int newSize) {
            super.p(oldSize, newSize);
            int[][] newStateSets = new int[newSize];
            System.arraycopy(this.J, 0, newStateSets, 0, oldSize);
            this.J = newStateSets;
        }
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // defpackage.l0
    public void g(l0.d state) {
        super.g(state);
        if (state instanceof a) {
            this.o = (a) state;
        }
    }

    public n0(a state, Resources res) {
        a newState = new a(state, this, res);
        g(newState);
        onStateChange(getState());
    }

    public n0(a state) {
        if (state != null) {
            g(state);
        }
    }
}
