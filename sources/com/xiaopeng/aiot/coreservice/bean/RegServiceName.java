package com.xiaopeng.aiot.coreservice.bean;

import com.xiaopeng.apirouter.IpcRouterService;
import java.io.Serializable;
/* loaded from: classes.dex */
public class RegServiceName implements Serializable {
    private String IPCServiceName = IpcRouterService.IPCServiceName;

    public void setIPCServiceName(String IPCServiceName) {
        this.IPCServiceName = IPCServiceName;
    }

    public String getIPCServiceName() {
        return this.IPCServiceName;
    }
}
