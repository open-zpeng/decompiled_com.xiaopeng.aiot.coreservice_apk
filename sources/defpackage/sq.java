package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
/* compiled from: XTouchAreaUtils.java */
/* renamed from: sq  reason: default package */
/* loaded from: classes.dex */
public class sq {
    public static final Class[] a = {TextView.class, ImageView.class};

    public static void b(ViewGroup parent) {
        d(a, parent);
    }

    public static void d(Class<?>[] classes, ViewGroup parent) {
        for (Class<?> cls : classes) {
            List<View> views = tq.c(parent, cls);
            if (views.size() > 0) {
                View[] views1 = new View[views.size()];
                views.toArray(views1);
                c(views1, parent);
            }
        }
    }

    public static void c(View[] views, ViewGroup parent) {
        for (View view : views) {
            a(view, parent);
        }
    }

    public static void a(View view, ViewGroup parent) {
        if (view == null || parent == null) {
            return;
        }
        cr.b(view, parent);
    }
}
