package com.xiaopeng.apirouter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xiaopeng.libconfig.ipc.IpcConfig;
/* loaded from: classes.dex */
public class IpcRouterEvent {
    public int mMsgID;
    public JsonObject mPayloadData;
    public String mSenderPackageName;
    public String mStringData;

    public IpcRouterEvent() {
        this.mSenderPackageName = "com.xiaopeng.xxx";
        this.mStringData = "";
    }

    public IpcRouterEvent(int id, String bundle) {
        this.mSenderPackageName = "com.xiaopeng.xxx";
        this.mStringData = "";
        this.mMsgID = id;
        JsonParser jsonParser = new JsonParser();
        JsonObject asJsonObject = jsonParser.parse(bundle).getAsJsonObject();
        this.mPayloadData = asJsonObject;
        if (asJsonObject.has("senderPackageName")) {
            this.mSenderPackageName = this.mPayloadData.get("senderPackageName").getAsString();
        }
        if (this.mPayloadData.has(IpcConfig.IPCKey.STRING_MSG)) {
            this.mStringData = this.mPayloadData.get(IpcConfig.IPCKey.STRING_MSG).getAsString();
        }
    }

    public String getSenderPackageName() {
        return this.mSenderPackageName;
    }

    public void setSenderPackageName(String senderPackageName) {
        this.mSenderPackageName = senderPackageName;
    }

    public int getMsgID() {
        return this.mMsgID;
    }

    public void setMsgID(int msgID) {
        this.mMsgID = msgID;
    }

    public JsonObject getPayloadData() {
        return this.mPayloadData;
    }

    public void setPayloadData(JsonObject payloadData) {
        this.mPayloadData = payloadData;
    }

    public void setStringData(String stringData) {
        this.mStringData = stringData;
    }

    public String getStringData() {
        return this.mStringData;
    }

    public String toString() {
        return "IpcMessageEvent{mSenderPackageName='" + this.mSenderPackageName + "', mMsgID=" + this.mMsgID + ", mPayloadData=" + this.mPayloadData + '}';
    }
}
