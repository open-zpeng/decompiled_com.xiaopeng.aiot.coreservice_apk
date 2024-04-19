package com.xiaopeng.aiot.coreservice.bean;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MsgContent {
    private String action;
    private String ext;
    private String message;

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExt() {
        return this.ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public JSONObject getExtData() {
        try {
            return new JSONObject(this.ext);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
