package com.xiaopeng.apirouter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaopeng.base.log.LogUtils;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IpcRouterService implements IServicePublisher {
    public static final String CONTENT = "content";
    public static final String IPCServiceName = ".IpcRouterService";
    private static final String TAG = "IpcRouterService";

    /* loaded from: classes.dex */
    public static class IpcMsgIdConfig {
        public static final int IPC_EVENT_FROM_DATA_REPORT = 10000;
        public static final int IPC_EVENT_FROM_DC = 10010;
        public static final int IPC_EVENT_FROM_OPEN_SDK = 10003;
        public static final int IPC_EVENT_FROM_REG_WAKEUP = 10001;
        public static final int IPC_EVENT_FROM_UNREG_WAKEUP = 10002;
        public static final int IPC_EVENT_SEND_OUT_MSG_ID = 123321;
    }

    public static void sendData(int id, String bundle, String targetPackageName, String ipcServiceName) {
        Uri.Builder builder = new Uri.Builder();
        Uri targetUrl = builder.authority(targetPackageName + ipcServiceName).path("onReceiverData").appendQueryParameter("id", String.valueOf(id)).appendQueryParameter("bundle", TextUtils.isEmpty(bundle) ? "" : bundle).build();
        LogUtils.i(TAG, "ApiRounter sendData :\tid:" + id + "\ttargetPackageName:\t" + targetPackageName);
        try {
            ApiRouter.route(targetUrl);
        } catch (RemoteException e) {
            e.printStackTrace();
            LogUtils.e(TAG, "ApiRounter sendData :e:" + e.getMessage());
        }
    }

    public static void sendData(int id, String bundle, String pkgName) {
        sendData(id, bundle, pkgName, IPCServiceName);
    }

    private static boolean isInstalled(Context context, String packagename) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packagename, 0);
        } catch (Exception e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            LogUtils.i(TAG, packagename + "\tuninstalled");
            return false;
        }
        LogUtils.i(TAG, packagename + "\tinstalled");
        return true;
    }

    @Publish
    public void onReceiverData(int id, String bundle) {
        if (TextUtils.isEmpty(bundle)) {
            LogUtils.e(TAG, "Service sub onReceiverData ID=" + id + ",bundle:" + bundle);
            return;
        }
        LogUtils.i(TAG, "Service sub onReceiverData ID=" + id + ",bundle:" + bundle);
        String senderPackageName = "com.xiaopeng.xxx";
        int bizType = 0;
        try {
            JSONObject jsonObject = new JSONObject(bundle);
            if (jsonObject.has("senderPackageName")) {
                senderPackageName = jsonObject.getString("senderPackageName");
            }
            if (jsonObject.has(IpcConfig.IPCKey.STRING_MSG)) {
                String msgstr = jsonObject.getString(IpcConfig.IPCKey.STRING_MSG);
                JSONObject jsonObject2 = new JSONObject(msgstr);
                if (jsonObject2.has("content")) {
                    bundle = jsonObject2.getString("content");
                }
                if (jsonObject.has("bizType")) {
                    bizType = jsonObject.getInt("bizType");
                }
            }
        } catch (JSONException e) {
            LogUtils.e(TAG, "Invalid json syntax: json = [" + bundle + "], error = [" + e.getMessage() + "]");
        }
        LogUtils.i(TAG, "Service onReceiverData CONTENT=" + bundle);
        IpcRouterEvent event = new IpcRouterEvent(id, bundle);
        event.bizType = bizType;
        event.senderPackageName = senderPackageName;
        if (az.d().h(IpcRouterEvent.class)) {
            az.d().n(event);
        } else {
            az.d().q(event);
        }
    }

    /* loaded from: classes.dex */
    public static class IpcRouterEvent {
        public int bizType;
        public final String bundle;
        public final int id;
        public String senderPackageName;

        public int getMsgID() {
            return this.id;
        }

        public JSONObject getPayloadData() {
            try {
                return new JSONObject(this.bundle);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public IpcRouterEvent(int id, String bundle) {
            this.id = id;
            this.bundle = bundle;
        }

        public void setBizType(int bizType) {
            this.bizType = bizType;
        }

        public int getBizType() {
            return this.bizType;
        }

        public void setSenderPackageName(String senderPackageName) {
            this.senderPackageName = senderPackageName;
        }

        public String getSenderPackageName() {
            return this.senderPackageName;
        }
    }
}
