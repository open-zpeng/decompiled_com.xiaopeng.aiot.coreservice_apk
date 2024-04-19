package com.ut.mini.sdkevents;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTInterfaceCallDelegate;
import com.ut.mini.UTTracker;
import com.ut.mini.core.appstatus.UTMCAppStatusCallbacks;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.plugin.UTPlugin;
import java.util.List;
/* loaded from: classes.dex */
public class UTMI1010_2001Event extends UTPlugin implements UTMCAppStatusCallbacks {
    private long C = 0;
    private long D = 0;
    private long E = 0;

    @Override // com.ut.mini.plugin.UTPlugin
    public int[] returnRequiredMsgIds() {
        return new int[]{3};
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // com.ut.mini.plugin.UTPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPluginMsgArrivedFromSDK(int r8, java.lang.Object r9) {
        /*
            r7 = this;
            r0 = 3
            if (r8 != r0) goto L5a
            r0 = r9
            java.util.Map r0 = (java.util.Map) r0
            com.alibaba.mtl.log.model.LogField r1 = com.alibaba.mtl.log.model.LogField.EVENTID
            java.lang.String r2 = r1.toString()
            boolean r2 = r0.containsKey(r2)
            if (r2 == 0) goto L5a
            java.lang.String r1 = r1.toString()
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "2001"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L5a
        L25:
            com.alibaba.mtl.log.model.LogField r1 = com.alibaba.mtl.log.model.LogField.ARG3
            java.lang.String r2 = r1.toString()
            boolean r2 = r0.containsKey(r2)
            r3 = 0
            if (r2 == 0) goto L47
        L34:
            java.lang.String r1 = r1.toString()
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            long r0 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Exception -> L43
            goto L48
        L43:
            r0 = move-exception
            r0.printStackTrace()
        L47:
            r0 = r3
        L48:
            long r5 = r7.C
            long r5 = r5 + r0
            r7.C = r5
            boolean r0 = m()
            if (r0 == 0) goto L5a
            long r0 = r7.C
            r7.a(r0)
            r7.C = r3
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.sdkevents.UTMI1010_2001Event.onPluginMsgArrivedFromSDK(int, java.lang.Object):void");
    }

    private static boolean m() {
        String packageName;
        ActivityManager activityManager;
        ComponentName componentName;
        try {
            Context f = gj.b().f();
            if (f != null && (packageName = f.getPackageName()) != null && (activityManager = (ActivityManager) f.getSystemService("activity")) != null) {
                try {
                    List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                    if (runningTasks != null && runningTasks.size() > 0 && (componentName = runningTasks.get(0).topActivity) != null) {
                        if (packageName.contains(componentName.getPackageName())) {
                            return false;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private void a(long j) {
        if (!kj.a().d()) {
            long j2 = 0;
            if (j > 0) {
                if (0 != this.E) {
                    j2 = SystemClock.elapsedRealtime() - this.E;
                }
                UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder("UT", 1010, "" + j, "" + j2, null, null);
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                if (defaultTracker != null) {
                    defaultTracker.send(uTOriginalCustomHitBuilder.build());
                } else {
                    vj.a("Record app display event error", "Fatal Error,must call setRequestAuthentication method first.");
                }
            }
        }
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchBackground() {
        a(SystemClock.elapsedRealtime() - this.D);
        this.E = SystemClock.elapsedRealtime();
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchForeground() {
        this.D = SystemClock.elapsedRealtime();
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
        UTInterfaceCallDelegate.pageDisAppearByAuto(activity);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
        UTInterfaceCallDelegate.pageAppearByAuto(activity);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
