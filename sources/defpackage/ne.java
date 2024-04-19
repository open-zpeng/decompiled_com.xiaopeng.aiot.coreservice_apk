package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: LayoutState.java */
/* renamed from: ne  reason: default package */
/* loaded from: classes.dex */
public class ne {
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean h;
    public boolean i;
    public boolean a = true;
    public int f = 0;
    public int g = 0;

    public boolean a(RecyclerView.t state) {
        int i = this.c;
        return i >= 0 && i < state.a();
    }

    public View b(RecyclerView.o recycler) {
        View view = recycler.h(this.c);
        this.c += this.d;
        return view;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
