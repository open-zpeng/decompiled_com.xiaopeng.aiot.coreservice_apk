package com.xiaopeng.aiot.coreservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.model.Progress;
import com.xiaopeng.aiot.coreservice.bean.AiotDcAwakeBean;
import com.xiaopeng.aiot.coreservice.bean.ConfigMonitorList;
import com.xiaopeng.aiot.coreservice.bean.ConfigWhiteList;
import com.xiaopeng.aiot.coreservice.bean.DataReportBean;
import com.xiaopeng.aiot.coreservice.bean.MsgExtBean;
import com.xiaopeng.apirouter.IpcRouterService;
import com.xiaopeng.base.BaseApplication;
import com.xiaopeng.base.log.LogUtils;
import com.xiaopeng.carmanager.AbsCarManager;
import com.xiaopeng.carmanager.CarClient;
import com.xiaopeng.carmanager.Component;
import com.xiaopeng.carmanager.wrapper.McuManagerWrapper;
import com.xiaopeng.lib.framework.configuration.internal.ConfigServiceConnectEvent;
import com.xiaopeng.lib.framework.moduleinterface.configurationmodule.ConfigurationChangeEvent;
import com.xiaopeng.lib.framework.moduleinterface.configurationmodule.IConfigurationData;
import com.xiaopeng.lib.http.server.ServerBean;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class BizAiotPresenter extends AiotBroadcastReceiver {
    public static ConcurrentHashMap<String, String> a = new ConcurrentHashMap<>();
    public static final CopyOnWriteArrayList<String> b = new CopyOnWriteArrayList<>();
    public static final CopyOnWriteArrayList<String> c = new CopyOnWriteArrayList<>();
    public BroadcastReceiver d;
    public jm e;
    public Intent f;
    public McuManagerWrapper.OnCarEcuEventChangedListener g = new a();

    public BizAiotPresenter() {
        LogUtils.d("mBizAiotPresenter", "BizAiotPresenter new ");
        if (!az.d().l(this)) {
            az.d().s(this);
        }
        this.e = new jm();
        ((McuManagerWrapper) CarClient.getComponent((Class<AbsCarManager>) McuManagerWrapper.class)).registerListener(this.g);
        Component.getInstance().initComponent(BaseApplication.a());
        en.d(new b(), 300L);
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BizAiotPresenter.this.u();
            BizAiotPresenter.this.v();
        }
    }

    public final void v() {
        LogUtils.i("mBizAiotPresenter", "initListFromHardDisk");
        LogUtils.d("mBizAiotPresenter", "mNeedWakeUpAppMap isEmpty =" + a.isEmpty());
        if (a.isEmpty()) {
            String mapStr = dn.c().a("NEED_WAKE_UP_APP_MAP_KEY");
            LogUtils.d("mBizAiotPresenter", "mapStr=" + mapStr);
            if (!TextUtils.isEmpty(mapStr)) {
                Type type = new c().getType();
                a = (ConcurrentHashMap) an.b(mapStr, type);
                LogUtils.d("mBizAiotPresenter", "mNeedWakeUpAppMap =" + a);
            }
        }
        String whiteListStr = dn.c().a("AIOT_SERVICE_WHITE_LIST");
        n(whiteListStr, true);
        String monitorListStr = dn.c().a("AIOT_SERVICE_MONITOR_LIST");
        m(monitorListStr, true);
    }

    /* loaded from: classes.dex */
    public class c extends TypeToken<ConcurrentHashMap<String, String>> {
        public c() {
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String whiteListStr = App.d().getConfiguration("AIOT_SERVICE_WHITE_LIST", "defaultValue");
            if (!TextUtils.isEmpty(whiteListStr) && !whiteListStr.equals("defaultValue")) {
                BizAiotPresenter.this.n(whiteListStr, false);
            } else {
                LogUtils.e("mBizAiotPresenter", "error info, whiteListStr = " + whiteListStr);
            }
            String monitorListStr = App.d().getConfiguration("AIOT_SERVICE_MONITOR_LIST", "defaultValue");
            if (!TextUtils.isEmpty(monitorListStr) && !monitorListStr.equals("defaultValue")) {
                BizAiotPresenter.this.m(monitorListStr, false);
                return;
            }
            LogUtils.e("mBizAiotPresenter", "error info, monitorListStr = " + monitorListStr);
        }
    }

    @kz(sticky = true, threadMode = ThreadMode.MAIN)
    public void onConfigServiceConnectStatusChanged(ConfigServiceConnectEvent event) {
        LogUtils.i("mBizAiotPresenter", "onConfigServiceConnectStatusChanged, event.isConnected() = " + event.isConnected());
        en.e(new d(), 5000L);
    }

    public final void n(String whiteListStr, boolean isFromHardDisk) {
        ConfigWhiteList whiteList = (ConfigWhiteList) an.a(whiteListStr, ConfigWhiteList.class);
        if (whiteList != null && whiteList.getWhiteList() != null) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = b;
            copyOnWriteArrayList.clear();
            copyOnWriteArrayList.addAll(whiteList.getWhiteList());
            LogUtils.i("mBizAiotPresenter", "mAppWhiteList update success, isFromHardDisk = " + isFromHardDisk + ", mAppWhiteList = " + copyOnWriteArrayList);
            if (!isFromHardDisk) {
                dn.c().b("AIOT_SERVICE_WHITE_LIST", whiteListStr);
                return;
            }
            return;
        }
        LogUtils.e("mBizAiotPresenter", "executeWhiteListStr error, whiteListStr = " + whiteListStr + ", isFromHardDisk = " + isFromHardDisk);
    }

    public final void m(String monitorListStr, boolean isFromHardDisk) {
        ConfigMonitorList monitorList = (ConfigMonitorList) an.a(monitorListStr, ConfigMonitorList.class);
        if (monitorList != null && monitorList.getMonitorList() != null) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = c;
            copyOnWriteArrayList.clear();
            copyOnWriteArrayList.addAll(monitorList.getMonitorList());
            LogUtils.i("mBizAiotPresenter", "mAPPMonitoredList update success, isFromHardDisk = " + isFromHardDisk + ", mAPPMonitoredList = " + copyOnWriteArrayList);
            if (!isFromHardDisk) {
                dn.c().b("AIOT_SERVICE_MONITOR_LIST", monitorListStr);
                return;
            }
            return;
        }
        LogUtils.e("mBizAiotPresenter", "executeMonitorListStr error, monitorListStr = " + monitorListStr + ", isFromHardDisk = " + isFromHardDisk);
    }

    @kz(threadMode = ThreadMode.BACKGROUND)
    public void onConfigurationChanged(ConfigurationChangeEvent event) {
        LogUtils.i("mBizAiotPresenter", "onConfigurationChanged,event = " + event.toString());
        List<IConfigurationData> list = event.getChangeList();
        if (list != null) {
            for (IConfigurationData data : list) {
                String key = data.getKey();
                LogUtils.i("mBizAiotPresenter", "IConfigurationData key = " + key);
                if (!TextUtils.isEmpty(key) && key.equals("AIOT_SERVICE_WHITE_LIST")) {
                    n(data.getValue(), false);
                }
                if (!TextUtils.isEmpty(key) && key.equals("AIOT_SERVICE_MONITOR_LIST")) {
                    m(data.getValue(), false);
                }
            }
        }
    }

    public void l() {
        if (az.d().l(this)) {
            az.d().u(this);
        }
        ((McuManagerWrapper) CarClient.getComponent((Class<AbsCarManager>) McuManagerWrapper.class)).unregisterListener(this.g);
        Component.getInstance().destroy();
        if (this.f != null) {
            BaseApplication.a().stopService(this.f);
        }
        BaseApplication.a().unregisterReceiver(this.d);
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public final /* synthetic */ IpcRouterService.IpcRouterEvent a;

        public e(IpcRouterService.IpcRouterEvent ipcRouterEvent) {
            this.a = ipcRouterEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.a.getMsgID()) {
                case 10000:
                    BizAiotPresenter.this.p(this.a);
                    return;
                case 10001:
                    BizAiotPresenter.this.s(this.a);
                    return;
                case 10002:
                    BizAiotPresenter.this.t(this.a);
                    return;
                case 10010:
                    BizAiotPresenter.this.r(this.a.bundle);
                    return;
                default:
                    LogUtils.d("mBizAiotPresenter", "IpcMessageEvent event.bundle=" + this.a.bundle);
                    return;
            }
        }
    }

    @kz(sticky = true, threadMode = ThreadMode.ASYNC)
    public void onEvent(IpcRouterService.IpcRouterEvent event) {
        LogUtils.d("mBizAiotPresenter", "IpcMessageEvent MsgID=" + event.getMsgID());
        en.c(new e(event));
    }

    public final void t(IpcRouterService.IpcRouterEvent event) {
        String senderPackageName = event.getSenderPackageName();
        LogUtils.e("mBizAiotPresenter", "un reg package =" + senderPackageName);
        if (a.containsKey(senderPackageName)) {
            a.remove(senderPackageName);
            if (!a.isEmpty()) {
                dn.c().b("NEED_WAKE_UP_APP_MAP_KEY", an.c(a));
            }
        }
    }

    public final void s(IpcRouterService.IpcRouterEvent event) {
        String IPCServiceName = IpcRouterService.IPCServiceName;
        try {
            if (TextUtils.isEmpty(event.bundle)) {
                IPCServiceName = event.bundle;
            }
            LogUtils.e("mBizAiotPresenter", "reg serviceName =" + event.bundle);
        } catch (Exception e2) {
            LogUtils.e("mBizAiotPresenter", "Exception=" + e2.getMessage());
            e2.printStackTrace();
        }
        LogUtils.e("mBizAiotPresenter", " serviceName =" + IPCServiceName);
        String senderPackageName = event.getSenderPackageName();
        LogUtils.e("mBizAiotPresenter", "reg package =" + senderPackageName);
        if (!a.containsKey(senderPackageName)) {
            a.put(senderPackageName, IPCServiceName);
            LogUtils.e("mBizAiotPresenter", "reg succeed =" + senderPackageName + IPCServiceName);
            dn.c().b("NEED_WAKE_UP_APP_MAP_KEY", an.c(a));
            return;
        }
        LogUtils.e("mBizAiotPresenter", "reg ed serviceName =" + senderPackageName);
    }

    public final void p(IpcRouterService.IpcRouterEvent event) {
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = b;
            if (!copyOnWriteArrayList.isEmpty() && copyOnWriteArrayList.contains(event.getSenderPackageName())) {
                DataReportBean dataReport = (DataReportBean) an.a(event.bundle, DataReportBean.class);
                if (dataReport != null) {
                    w(dataReport);
                }
                return;
            }
            LogUtils.e("mBizAiotPresenter", "this package app not in white list or white list is empty pkg=" + event.getSenderPackageName());
        } catch (Exception e2) {
            LogUtils.e("mBizAiotPresenter", "Exception=" + e2.getMessage());
            e2.printStackTrace();
        }
    }

    public final void r(String msg) {
        try {
            LogUtils.e("mBizAiotPresenter", "msg=" + msg);
            AiotDcAwakeBean dcAwakeBean = (AiotDcAwakeBean) an.a(msg, AiotDcAwakeBean.class);
            if (dcAwakeBean != null && dcAwakeBean.getMsgContent() != null && "AWAKE_APP".equals(dcAwakeBean.getMsgContent().getAction())) {
                q(dcAwakeBean.getMsgContent().getExt());
            }
        } catch (Exception e2) {
            LogUtils.e("mBizAiotPresenter", "Exception=" + e2.getMessage());
            e2.printStackTrace();
        }
    }

    public final void q(String ext) {
        try {
            MsgExtBean msgExt = (MsgExtBean) an.a(ext, MsgExtBean.class);
            if (msgExt != null) {
                if (zm.a(BaseApplication.a(), msgExt.getPackageName())) {
                    IpcRouterService.sendData(IpcRouterService.IpcMsgIdConfig.IPC_EVENT_SEND_OUT_MSG_ID, msgExt.getForwardInfo(), msgExt.getPackageName());
                    en.e(new f(msgExt), 1000L);
                } else {
                    o("应用未安装", false, msgExt.getTaskId());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public final /* synthetic */ MsgExtBean a;

        public f(MsgExtBean msgExtBean) {
            this.a = msgExtBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zm.g(BaseApplication.a(), this.a.getPackageName())) {
                BizAiotPresenter.this.o("成功启动", true, this.a.getTaskId());
            } else {
                BizAiotPresenter.this.o("未知错误", false, this.a.getTaskId());
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements km<ServerBean> {
        public g() {
        }

        @Override // defpackage.km
        /* renamed from: b */
        public void a(ServerBean serverBean) {
            LogUtils.i("mBizAiotPresenter", "postAppAwakeResultReport success");
        }

        @Override // defpackage.km
        public void onFail(String msg) {
            LogUtils.e("mBizAiotPresenter", "postAppAwakeResultReport fail");
        }
    }

    public final void o(String err, boolean isOk, String taskId) {
        this.e.e(un.f(), taskId, Boolean.valueOf(isOk), err, Long.valueOf(System.currentTimeMillis()), new g());
    }

    /* loaded from: classes.dex */
    public class h implements km<ServerBean> {
        public h() {
        }

        @Override // defpackage.km
        /* renamed from: b */
        public void a(ServerBean serverBean) {
            LogUtils.i("mBizAiotPresenter", "postIotDeviceReport success");
        }

        @Override // defpackage.km
        public void onFail(String msg) {
            LogUtils.e("mBizAiotPresenter", "postIotDeviceReport fail");
        }
    }

    public final void w(DataReportBean data) {
        this.e.h(data.getVin(), data.getGroupId(), data.getGroupName(), data.getDataType(), data.getDataContent(), Long.valueOf(data.getReportTime()), new h());
    }

    public final void u() {
        LogUtils.d("mBizAiotPresenter", "listenUsb: register");
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        filter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        filter.addAction("android.hardware.usb.action.USB_ACCESSORY_ATTACHED");
        filter.addAction("android.hardware.usb.action.USB_ACCESSORY_DETACHED");
        filter.addAction("android.hardware.usb.action.USB_STATE");
        this.d = new i();
        BaseApplication.a().registerReceiver(this.d, filter);
        LogUtils.d("mBizAiotPresenter", "listenUsb: registered");
    }

    /* loaded from: classes.dex */
    public class i extends BroadcastReceiver {
        public i() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LogUtils.d("mBizAiotPresenter", "onReceive: " + intent.getAction());
            String action = intent.getAction();
            UsbDevice device = (UsbDevice) intent.getParcelableExtra("device");
            if (device != null) {
                String serialNumber = device.getSerialNumber();
                DataReportBean data = new DataReportBean();
                data.setGroupId("sn-" + serialNumber);
                data.setReportTime(System.currentTimeMillis());
                data.setVin(un.f());
                data.setDataType("DEVICE_STATE");
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("manufacturerName", device.getManufacturerName());
                jsonObject.addProperty("productName", device.getProductName());
                jsonObject.addProperty("serialNumber", serialNumber);
                jsonObject.addProperty("deviceVersion", device.getVersion());
                if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                    jsonObject.addProperty(Progress.STATUS, "ATTACHED");
                } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                    jsonObject.addProperty(Progress.STATUS, "DETACHED");
                }
                data.setDataContent(jsonObject.toString());
                data.setGroupName("");
                BizAiotPresenter.this.w(data);
                LogUtils.d("mBizAiotPresenter", "USB devices Info: " + data.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements McuManagerWrapper.OnCarEcuEventChangedListener {
        public a() {
        }

        @Override // com.xiaopeng.carmanager.wrapper.McuManagerWrapper.OnCarEcuEventChangedListener
        public void onIgStatusChanged(int state) {
            LogUtils.e("mBizAiotPresenter", "ig ON = 1,OFF = 0 State = " + state);
            if (state == 1) {
                en.d(new RunnableC0012a(), 65000L);
            }
        }

        /* renamed from: com.xiaopeng.aiot.coreservice.BizAiotPresenter$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0012a implements Runnable {
            public RunnableC0012a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BizAiotPresenter.this.x();
            }
        }
    }

    public final void x() {
        try {
            for (Map.Entry<String, String> item : a.entrySet()) {
                if (zm.a(BaseApplication.a(), item.getKey())) {
                    if (TextUtils.isEmpty(item.getValue())) {
                        IpcRouterService.sendData(IpcRouterService.IpcMsgIdConfig.IPC_EVENT_SEND_OUT_MSG_ID, "", item.getKey());
                    } else {
                        IpcRouterService.sendData(IpcRouterService.IpcMsgIdConfig.IPC_EVENT_SEND_OUT_MSG_ID, "", item.getKey(), item.getValue());
                    }
                    LogUtils.e("mBizAiotPresenter", " start = " + item.getKey());
                }
            }
        } catch (Exception e2) {
            LogUtils.e("mBizAiotPresenter", "Exception=" + e2.getMessage());
            e2.printStackTrace();
        }
    }
}
