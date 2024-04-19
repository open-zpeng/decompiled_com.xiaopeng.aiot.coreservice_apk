package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* compiled from: XuiUtils.java */
/* renamed from: tq  reason: default package */
/* loaded from: classes.dex */
public class tq {
    public static int a(float dipValue) {
        float density = cp.a().getResources().getDisplayMetrics().density;
        return (int) ((dipValue * density) + 0.5f);
    }

    public static int b(Context context, int id) {
        float scale = context.getResources().getDisplayMetrics().density;
        float value = context.getResources().getDimension(id);
        return (int) ((value * scale) + 0.5f);
    }

    public static List<View> c(ViewGroup viewGroup, Class cls) {
        List<View> results = new ArrayList<>();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (cls.isInstance(child)) {
                results.add(child);
            } else if (child instanceof ViewGroup) {
                results.addAll(c((ViewGroup) child, cls));
            }
        }
        return results;
    }

    public static String d(int visibility) {
        switch (visibility) {
            case 0:
                return "visible";
            case 4:
                return "invisible";
            case 8:
                return "gone";
            default:
                return null;
        }
    }
}
