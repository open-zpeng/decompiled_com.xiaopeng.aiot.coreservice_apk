package defpackage;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;
/* compiled from: AccessibilityRecordCompat.java */
/* renamed from: ta  reason: default package */
/* loaded from: classes.dex */
public class ta {
    public static void a(AccessibilityRecord record, int maxScrollX) {
        if (Build.VERSION.SDK_INT >= 15) {
            record.setMaxScrollX(maxScrollX);
        }
    }

    public static void b(AccessibilityRecord record, int maxScrollY) {
        if (Build.VERSION.SDK_INT >= 15) {
            record.setMaxScrollY(maxScrollY);
        }
    }
}
