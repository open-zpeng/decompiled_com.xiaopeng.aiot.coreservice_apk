package defpackage;

import android.os.Build;
import android.view.ViewGroup;
/* compiled from: ViewGroupCompat.java */
/* renamed from: ia  reason: default package */
/* loaded from: classes.dex */
public final class ia {
    public static boolean a(ViewGroup group) {
        if (Build.VERSION.SDK_INT >= 21) {
            return group.isTransitionGroup();
        }
        Boolean explicit = (Boolean) group.getTag(x6.Q);
        return ((explicit == null || !explicit.booleanValue()) && group.getBackground() == null && ga.C(group) == null) ? false : true;
    }
}
