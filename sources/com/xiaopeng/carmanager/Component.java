package com.xiaopeng.carmanager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaopeng.apirouter.IpcRouterService;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class Component {
    private static final String TAG = "xyz-Component";
    private IIpcService mIIpcService;

    public Component() {
        if (!az.d().l(this)) {
            az.d().s(this);
        }
    }

    /* loaded from: classes.dex */
    public static class LazyHolder {
        private static final Component INSTANCE = new Component();

        private LazyHolder() {
        }
    }

    public static Component getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void initComponent(Context context) {
        pn.l(TAG, "initComponent");
        Module.register(IpcModuleEntry.class, new IpcModuleEntry(context));
        initIpcService();
    }

    private void initIpcService() {
        IIpcService iIpcService = (IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class);
        this.mIIpcService = iIpcService;
        iIpcService.init();
    }

    private IIpcService getIpcService() {
        return this.mIIpcService;
    }

    @kz(threadMode = ThreadMode.MAIN)
    public void onEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        if (ipcMessageEvent == null) {
            pn.f(TAG, "ipcMessageEvent == null");
            return;
        }
        int id = ipcMessageEvent.getMsgID();
        String name = ipcMessageEvent.getSenderPackageName();
        Bundle payloadData = ipcMessageEvent.getPayloadData();
        if (payloadData == null) {
            pn.f(TAG, "payloadData == null");
            return;
        }
        String msgstr = payloadData.getString(IpcConfig.IPCKey.STRING_MSG);
        pn.l(TAG, "Service sub onReceiverData ID=" + id + ",msgstr:" + msgstr);
        String senderPackageName = "com.xiaopeng.xxx";
        int bizType = 0;
        try {
            JSONObject jsonObject = new JSONObject(msgstr);
            if (!TextUtils.isEmpty(name)) {
                senderPackageName = name;
            } else {
                pn.f(TAG, "name == empty");
            }
            if (jsonObject.has("content")) {
                msgstr = jsonObject.getString("content");
            }
            if (jsonObject.has("bizType")) {
                bizType = jsonObject.getInt("bizType");
            }
        } catch (JSONException e) {
            pn.f(TAG, "Invalid json syntax: json = [" + msgstr + "], error = [" + e.getMessage() + "]");
        }
        pn.l(TAG, "Service onReceiverData CONTENT=" + msgstr);
        IpcRouterService.IpcRouterEvent event = new IpcRouterService.IpcRouterEvent(id, msgstr);
        event.bizType = bizType;
        event.senderPackageName = senderPackageName;
        if (az.d().h(IpcRouterService.IpcRouterEvent.class)) {
            az.d().n(event);
        } else {
            az.d().q(event);
        }
    }

    public void destroy() {
        if (az.d().l(this)) {
            az.d().u(this);
        }
    }
}
