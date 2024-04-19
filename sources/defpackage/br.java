package defpackage;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: XTouchDelegateGroup.java */
/* renamed from: br  reason: default package */
/* loaded from: classes.dex */
public class br extends TouchDelegate {
    public static final Rect a = new Rect();
    public List<ar> b;
    public TouchDelegate c;

    public br(View ancestor) {
        super(a, ancestor);
        this.b = new ArrayList();
    }

    public void a(ar touchDelegate) {
        if (touchDelegate == null) {
            return;
        }
        Iterator<ar> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ar exist = it.next();
            if (exist.a().equals(touchDelegate.a())) {
                this.b.remove(exist);
                break;
            }
        }
        this.b.add(touchDelegate);
    }

    public void b(TouchDelegate touchDelegate) {
        this.b.remove(touchDelegate);
        if (touchDelegate == this.c) {
            this.c = null;
        }
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        boolean handled = false;
        if (action == 0) {
            if (event.getPointerCount() > 1) {
                return false;
            }
            for (int i = this.b.size() - 1; i >= 0; i--) {
                ar touchDelegate = this.b.get(i);
                View view = touchDelegate.a();
                if (view == null || view.getVisibility() == 0) {
                    float savedX = event.getX();
                    float savedY = event.getY();
                    boolean handled2 = touchDelegate.onTouchEvent(event);
                    event.setLocation(savedX, savedY);
                    if (handled2) {
                        this.c = touchDelegate;
                        return true;
                    }
                }
            }
            return false;
        }
        TouchDelegate touchDelegate2 = this.c;
        if (touchDelegate2 != null && touchDelegate2.onTouchEvent(event)) {
            handled = true;
        }
        if (action == 1 || action == 32) {
            this.c = null;
        }
        return handled;
    }
}
