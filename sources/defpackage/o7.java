package defpackage;

import android.content.Context;
import android.os.Process;
/* compiled from: PermissionChecker.java */
/* renamed from: o7  reason: default package */
/* loaded from: classes.dex */
public final class o7 {
    public static int a(Context context, String permission, int pid, int uid, String packageName) {
        if (context.checkPermission(permission, pid, uid) == -1) {
            return -1;
        }
        String op = b7.b(permission);
        if (op == null) {
            return 0;
        }
        if (packageName == null) {
            String[] packageNames = context.getPackageManager().getPackagesForUid(uid);
            if (packageNames == null || packageNames.length <= 0) {
                return -1;
            }
            packageName = packageNames[0];
        }
        if (b7.a(context, op, packageName) == 0) {
            return 0;
        }
        return -2;
    }

    public static int b(Context context, String permission) {
        return a(context, permission, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
