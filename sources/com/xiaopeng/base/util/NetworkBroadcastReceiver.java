package com.xiaopeng.base.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaopeng.base.log.LogUtils;
/* loaded from: classes.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    public final String a = "NetworkBroadcastReceiver";
    public a b;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, cn cnVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            LogUtils.e("NetworkBroadcastReceiver", "onReceive#intent=" + intent);
            return;
        }
        String action = intent.getAction();
        LogUtils.d("NetworkBroadcastReceiver", "onReceive#action=" + action);
        if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            boolean isOnline = bn.c(context);
            cn networkStatus = bn.a(context);
            LogUtils.d("NetworkBroadcastReceiver", "onReceive#isOnline=" + isOnline + ", networdStatus=" + networkStatus);
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(isOnline, networkStatus);
            }
        }
    }
}
