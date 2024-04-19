package com.xiaopeng.lib.framework.configuration.internal;
/* loaded from: classes.dex */
public class ConfigServiceConnectEvent {
    public boolean mIsConnected;

    public ConfigServiceConnectEvent(boolean isConnected) {
        this.mIsConnected = isConnected;
    }

    public boolean isConnected() {
        return this.mIsConnected;
    }
}
