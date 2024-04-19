package com.ut.mini.plugin;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.ut.mini.core.appstatus.UTMCAppStatusCallbacks;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class UTPluginMgr implements UTMCAppStatusCallbacks {
    public static final String PARTNERPLUGIN_UTPREF = "com.ut.mini.perf.UTPerfPlugin";
    private static UTPluginMgr a = new UTPluginMgr();
    private HandlerThread b = null;
    private Handler mHandler = null;
    private List<UTPlugin> n = new LinkedList();
    private List<String> o = new ArrayList();
    private List<String> p = new ArrayList<String>() { // from class: com.ut.mini.plugin.UTPluginMgr.1
        {
            add(UTPluginMgr.PARTNERPLUGIN_UTPREF);
        }
    };
    private List<UTPlugin> q = new LinkedList();

    private UTPluginMgr() {
        if (Build.VERSION.SDK_INT >= 14) {
            UTMCAppStatusRegHelper.registerAppStatusCallbacks(this);
        }
    }

    public static UTPluginMgr getInstance() {
        return a;
    }

    private void N() {
        HandlerThread handlerThread = new HandlerThread("UT-PLUGIN-ASYNC");
        this.b = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.b.getLooper()) { // from class: com.ut.mini.plugin.UTPluginMgr.2
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    Object obj = msg.obj;
                    if (obj instanceof a) {
                        a aVar = (a) obj;
                        UTPlugin a2 = aVar.a();
                        int i = aVar.i();
                        Object msgObj = aVar.getMsgObj();
                        if (a2 != null) {
                            try {
                                if (msgObj instanceof UTPluginMsgDispatchDelegate) {
                                    UTPluginMsgDispatchDelegate uTPluginMsgDispatchDelegate = (UTPluginMsgDispatchDelegate) msgObj;
                                    if (uTPluginMsgDispatchDelegate.isMatchPlugin(a2)) {
                                        a2.onPluginMsgArrivedFromSDK(i, uTPluginMsgDispatchDelegate.getDispatchObject(a2));
                                    }
                                    return;
                                }
                                a2.onPluginMsgArrivedFromSDK(i, msgObj);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
    }

    public boolean isPartnerPluginExist(String aPluginClassPath) {
        if (this.o.contains(aPluginClassPath)) {
            return true;
        }
        return false;
    }

    private synchronized void a(int i, UTPluginContextValueDispatchDelegate uTPluginContextValueDispatchDelegate) {
        if (uTPluginContextValueDispatchDelegate == null) {
            return;
        }
        for (UTPlugin uTPlugin : this.q) {
            uTPluginContextValueDispatchDelegate.onPluginContextValueChange(uTPlugin.getPluginContext());
            uTPlugin.onPluginContextValueUpdate(i);
        }
    }

    public void updatePluginContextValue(int aPluginContextKey) {
        switch (aPluginContextKey) {
            case 1:
                a(aPluginContextKey, new UTPluginContextValueDispatchDelegate() { // from class: com.ut.mini.plugin.UTPluginMgr.3
                    @Override // com.ut.mini.plugin.UTPluginContextValueDispatchDelegate
                    public void onPluginContextValueChange(UTPluginContext aOriginalPluginContext) {
                        aOriginalPluginContext.setDebugLogFlag(vj.g());
                    }
                });
                return;
            default:
                return;
        }
    }

    public void runPartnerPlugin() {
        List<String> list = this.p;
        if (list != null && list.size() > 0) {
            for (String str : this.p) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        Object newInstance = Class.forName(str).newInstance();
                        if (newInstance instanceof UTPlugin) {
                            registerPlugin((UTPlugin) newInstance, true);
                            vj.d("runPartnerPlugin[OK]:" + str, new String[0]);
                            this.o.add(str);
                        }
                    } catch (ClassNotFoundException e) {
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    } catch (InstantiationException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    private UTPluginContext a() {
        UTPluginContext uTPluginContext = new UTPluginContext();
        uTPluginContext.setContext(gj.b().f());
        if (vj.g()) {
            uTPluginContext.setDebugLogFlag(vj.g());
        }
        return uTPluginContext;
    }

    public synchronized void registerPlugin(UTPlugin aPlugin, boolean aAsyncMode) {
        if (aPlugin != null) {
            if (!this.q.contains(aPlugin)) {
                aPlugin.a(a());
                this.q.add(aPlugin);
                if (!aAsyncMode) {
                    this.n.add(aPlugin);
                }
                aPlugin.onRegistered();
            }
        }
    }

    public synchronized void unregisterPlugin(UTPlugin aPlugin) {
        if (aPlugin != null) {
            if (this.q.contains(aPlugin)) {
                this.q.remove(aPlugin);
                aPlugin.onUnRegistered();
                aPlugin.a(null);
            }
        }
        List<UTPlugin> list = this.n;
        if (list != null && list.contains(aPlugin)) {
            this.n.remove(aPlugin);
        }
    }

    private boolean a(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        boolean z = false;
        for (int i2 : iArr) {
            if (i2 == i) {
                z = true;
            }
        }
        return z;
    }

    public synchronized boolean dispatchPluginMsg(int aMsgId, Object aMsgObj) {
        boolean z;
        List<UTPlugin> list;
        if (this.mHandler == null) {
            N();
        }
        z = false;
        if (this.q.size() > 0) {
            for (UTPlugin uTPlugin : this.q) {
                int[] returnRequiredMsgIds = uTPlugin.returnRequiredMsgIds();
                if (returnRequiredMsgIds != null && a(aMsgId, returnRequiredMsgIds)) {
                    if (aMsgId != 1 && ((list = this.n) == null || !list.contains(uTPlugin))) {
                        a aVar = new a();
                        aVar.g(aMsgId);
                        aVar.c(aMsgObj);
                        aVar.a(uTPlugin);
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        obtain.obj = aVar;
                        this.mHandler.sendMessage(obtain);
                        z = true;
                    }
                    if (aMsgObj instanceof UTPluginMsgDispatchDelegate) {
                        UTPluginMsgDispatchDelegate uTPluginMsgDispatchDelegate = (UTPluginMsgDispatchDelegate) aMsgObj;
                        if (uTPluginMsgDispatchDelegate.isMatchPlugin(uTPlugin)) {
                            uTPlugin.onPluginMsgArrivedFromSDK(aMsgId, uTPluginMsgDispatchDelegate.getDispatchObject(uTPlugin));
                        }
                    } else {
                        uTPlugin.onPluginMsgArrivedFromSDK(aMsgId, aMsgObj);
                    }
                    z = true;
                }
            }
        }
        return z;
    }

    /* loaded from: classes.dex */
    public static class a {
        private int K;
        private UTPlugin a;
        private Object f;

        private a() {
            this.K = 0;
            this.f = null;
            this.a = null;
        }

        public int i() {
            return this.K;
        }

        public void g(int i) {
            this.K = i;
        }

        public Object getMsgObj() {
            return this.f;
        }

        public void c(Object obj) {
            this.f = obj;
        }

        public UTPlugin a() {
            return this.a;
        }

        public void a(UTPlugin uTPlugin) {
            this.a = uTPlugin;
        }
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchBackground() {
        dispatchPluginMsg(2, null);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchForeground() {
        dispatchPluginMsg(8, null);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
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
