package defpackage;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
/* compiled from: AppOpsManagerCompat.java */
/* renamed from: b7  reason: default package */
/* loaded from: classes.dex */
public final class b7 {
    public static String b(String permission) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(permission);
        }
        return null;
    }

    public static int a(Context context, String op, String proxiedPackageName) {
        if (Build.VERSION.SDK_INT >= 23) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
            return appOpsManager.noteProxyOpNoThrow(op, proxiedPackageName);
        }
        return 1;
    }
}
