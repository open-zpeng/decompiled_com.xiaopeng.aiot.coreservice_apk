package com.xiaopeng.aiot.coreservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaopeng.base.log.LogUtils;
/* loaded from: classes.dex */
public class AiotBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            LogUtils.d("AIoTBroadcast", "receiver intent -- null");
            return;
        }
        String action = intent.getAction();
        LogUtils.d("AIoTBroadcast", "receiver action --》" + action);
        if (!TextUtils.isEmpty(action)) {
            if ("com.xiaopeng.xui.businessevent".equals(action) || "com.xiaopeng.broadcast.ACTION_TOKEN_GOTTEN".equals(action) || "com.xiaopeng.action.CLIENT_SSL_UPDATE".equals(action)) {
                boolean isRun = zm.h(context, AiotService.class);
                LogUtils.d("AIoTBroadcast", "AiotService is run = " + isRun);
                if (!isRun) {
                    lm.a(context, action);
                }
            }
        }
    }
}
