package defpackage;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
/* compiled from: AccessibilityEventCompat.java */
/* renamed from: qa  reason: default package */
/* loaded from: classes.dex */
public final class qa {
    public static void b(AccessibilityEvent event, int changeTypes) {
        if (Build.VERSION.SDK_INT >= 19) {
            event.setContentChangeTypes(changeTypes);
        }
    }

    public static int a(AccessibilityEvent event) {
        if (Build.VERSION.SDK_INT >= 19) {
            return event.getContentChangeTypes();
        }
        return 0;
    }
}
