package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.xiaopeng.aiot.coreservice.AiotService;
/* compiled from: AppUtils.java */
/* renamed from: lm  reason: default package */
/* loaded from: classes.dex */
public class lm {
    public static void a(Context context, String action) {
        Intent serviceIntent = new Intent(context, AiotService.class);
        serviceIntent.setPackage(context.getPackageName());
        if (!TextUtils.isEmpty(action)) {
            serviceIntent.setAction(action);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(serviceIntent);
        } else {
            context.startService(serviceIntent);
        }
    }
}
