package com.xiaopeng.aiot.coreservice.bean;
/* loaded from: classes.dex */
public class AiotDcAwakeBean {
    private int category;
    private MsgContent msgContent;
    private String msgType;

    public void setCategory(int category) {
        this.category = category;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public MsgContent getMsgContent() {
        return this.msgContent;
    }

    public void setMsgContent(MsgContent msgContent) {
        this.msgContent = msgContent;
    }

    public int getCategory() {
        return this.category;
    }
}
