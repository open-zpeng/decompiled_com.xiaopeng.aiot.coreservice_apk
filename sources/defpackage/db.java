package defpackage;

import android.view.View;
import android.widget.ListView;
/* compiled from: ListViewAutoScrollHelper.java */
/* renamed from: db  reason: default package */
/* loaded from: classes.dex */
public class db extends ya {
    public final ListView u;

    public db(ListView target) {
        super(target);
        this.u = target;
    }

    @Override // defpackage.ya
    public void j(int deltaX, int deltaY) {
        eb.b(this.u, deltaY);
    }

    @Override // defpackage.ya
    public boolean a(int direction) {
        return false;
    }

    @Override // defpackage.ya
    public boolean b(int direction) {
        ListView target = this.u;
        int itemCount = target.getCount();
        if (itemCount == 0) {
            return false;
        }
        int childCount = target.getChildCount();
        int firstPosition = target.getFirstVisiblePosition();
        int lastPosition = firstPosition + childCount;
        if (direction > 0) {
            if (lastPosition >= itemCount) {
                View lastView = target.getChildAt(childCount - 1);
                if (lastView.getBottom() <= target.getHeight()) {
                    return false;
                }
                return true;
            }
            return true;
        } else if (direction >= 0) {
            return false;
        } else {
            if (firstPosition <= 0) {
                View firstView = target.getChildAt(0);
                if (firstView.getTop() >= 0) {
                    return false;
                }
                return true;
            }
            return true;
        }
    }
}
