package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.xiaopeng.base.log.LogUtils;
import java.io.File;
/* compiled from: LogHelper.java */
/* renamed from: pm  reason: default package */
/* loaded from: classes.dex */
public class pm {
    public static String a;
    public static String b = "xyz-";
    public static String c = "LogHelper";

    public static void b(Context context, String processName) {
        String replace = processName.replace(":", "");
        a = replace;
        try {
            if (!TextUtils.isEmpty(replace)) {
                qm.f = "logs_" + a;
                if (!zm.f(context)) {
                    c(context);
                }
            }
            LogUtils.TAG = b;
            File dir = context.getExternalFilesDir(null);
            qm.k(dir != null ? dir.getAbsolutePath() : Environment.getExternalStorageState());
            qm.j(context.getFilesDir() + File.separator + "xlog/");
            qm.e();
            LogUtils.setLogEnable(true);
            String str = c;
            LogUtils.i(str, "process:" + a);
            String str2 = c;
            LogUtils.i(str2, "log:%s,cache:%s,file:%s", qm.c + qm.b, qm.d, qm.f);
        } catch (Exception e) {
        }
    }

    public static void c(Context context) {
        Log.d(c, "register receiver on ");
        context.registerReceiver(new a(), new IntentFilter("com.xiaopeng.base.log.FLUSH"));
    }

    /* compiled from: LogHelper.java */
    /* renamed from: pm$a */
    /* loaded from: classes.dex */
    public static class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.d(pm.c, "onReceive");
            qm.b();
        }
    }

    public static void d(boolean isDebug) {
        qm.e = isDebug;
    }
}
