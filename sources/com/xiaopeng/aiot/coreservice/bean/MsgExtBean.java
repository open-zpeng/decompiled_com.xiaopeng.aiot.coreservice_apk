package com.xiaopeng.aiot.coreservice.bean;
/* loaded from: classes.dex */
public class MsgExtBean {
    private String forwardInfo;
    private String packageName;
    private String taskId;

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getForwardInfo() {
        return this.forwardInfo;
    }

    public void setForwardInfo(String forwardInfo) {
        this.forwardInfo = forwardInfo;
    }
}
