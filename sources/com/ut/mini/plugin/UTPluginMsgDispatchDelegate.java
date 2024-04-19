package com.ut.mini.plugin;
/* loaded from: classes.dex */
public abstract class UTPluginMsgDispatchDelegate {
    private Object f;

    public final Object getMsgObj() {
        return this.f;
    }

    public UTPluginMsgDispatchDelegate(Object aMsgObject) {
        this.f = null;
        this.f = aMsgObject;
    }

    public boolean isMatchPlugin(UTPlugin lPlugin) {
        return true;
    }

    public Object getDispatchObject(UTPlugin lPlugin) {
        return this.f;
    }
}
