package com.xiaopeng.apirouter;

import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import com.xiaopeng.lib.apirouter.ApiRouter;
/* loaded from: classes.dex */
public class Route2IpcService {
    private static final String TAG = "Route2IpcService";

    public static void sendData(int id, String bundle, String pkgName) {
        Log.i(TAG, "sendData id = " + id + " ; pkgName = " + pkgName + " ; bundle = " + bundle);
        Uri.Builder builder = new Uri.Builder();
        StringBuilder sb = new StringBuilder();
        sb.append(pkgName);
        sb.append(IpcRouterService.IPCServiceName);
        Uri targetUrl = builder.authority(sb.toString()).path("onReceiverData").appendQueryParameter("id", String.valueOf(id)).appendQueryParameter("bundle", bundle).build();
        try {
            ApiRouter.route(targetUrl);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
