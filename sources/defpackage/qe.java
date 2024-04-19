package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: ScrollbarHelper.java */
/* renamed from: qe  reason: default package */
/* loaded from: classes.dex */
public class qe {
    public static int b(RecyclerView.t state, oe orientation, View startChild, View endChild, RecyclerView.h lm, boolean smoothScrollbarEnabled, boolean reverseLayout) {
        int itemsBefore;
        if (lm.B() == 0 || state.a() == 0 || startChild == null || endChild == null) {
            return 0;
        }
        int minPosition = Math.min(lm.U(startChild), lm.U(endChild));
        int maxPosition = Math.max(lm.U(startChild), lm.U(endChild));
        if (reverseLayout) {
            itemsBefore = Math.max(0, (state.a() - maxPosition) - 1);
        } else {
            itemsBefore = Math.max(0, minPosition);
        }
        if (!smoothScrollbarEnabled) {
            return itemsBefore;
        }
        int laidOutArea = Math.abs(orientation.d(endChild) - orientation.g(startChild));
        int itemRange = Math.abs(lm.U(startChild) - lm.U(endChild)) + 1;
        float avgSizePerRow = laidOutArea / itemRange;
        return Math.round((itemsBefore * avgSizePerRow) + (orientation.m() - orientation.g(startChild)));
    }

    public static int a(RecyclerView.t state, oe orientation, View startChild, View endChild, RecyclerView.h lm, boolean smoothScrollbarEnabled) {
        if (lm.B() == 0 || state.a() == 0 || startChild == null || endChild == null) {
            return 0;
        }
        if (!smoothScrollbarEnabled) {
            return Math.abs(lm.U(startChild) - lm.U(endChild)) + 1;
        }
        int extend = orientation.d(endChild) - orientation.g(startChild);
        return Math.min(orientation.n(), extend);
    }

    public static int c(RecyclerView.t state, oe orientation, View startChild, View endChild, RecyclerView.h lm, boolean smoothScrollbarEnabled) {
        if (lm.B() == 0 || state.a() == 0 || startChild == null || endChild == null) {
            return 0;
        }
        if (!smoothScrollbarEnabled) {
            return state.a();
        }
        int laidOutArea = orientation.d(endChild) - orientation.g(startChild);
        int laidOutRange = Math.abs(lm.U(startChild) - lm.U(endChild)) + 1;
        return (int) ((laidOutArea / laidOutRange) * state.a());
    }
}
