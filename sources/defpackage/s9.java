package defpackage;

import android.os.Build;
import android.view.ViewGroup;
/* compiled from: MarginLayoutParamsCompat.java */
/* renamed from: s9  reason: default package */
/* loaded from: classes.dex */
public final class s9 {
    public static int b(ViewGroup.MarginLayoutParams lp) {
        if (Build.VERSION.SDK_INT >= 17) {
            return lp.getMarginStart();
        }
        return lp.leftMargin;
    }

    public static int a(ViewGroup.MarginLayoutParams lp) {
        if (Build.VERSION.SDK_INT >= 17) {
            return lp.getMarginEnd();
        }
        return lp.rightMargin;
    }
}
