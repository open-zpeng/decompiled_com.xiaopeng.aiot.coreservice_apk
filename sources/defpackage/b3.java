package defpackage;

import android.os.Build;
import android.view.View;
/* compiled from: TooltipCompat.java */
/* renamed from: b3  reason: default package */
/* loaded from: classes.dex */
public class b3 {
    public static void a(View view, CharSequence tooltipText) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(tooltipText);
        } else {
            c3.f(view, tooltipText);
        }
    }
}
