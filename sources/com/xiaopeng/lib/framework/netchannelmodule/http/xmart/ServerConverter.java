package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ServerConverter implements al<ServerBean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // defpackage.al
    public ServerBean convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) {
            throw new IllegalStateException("null");
        }
        ServerBean bean = new ServerBean();
        JSONObject jsonObject = new JSONObject(body.string());
        bean.code(jsonObject.getInt("code"));
        try {
            bean.data(jsonObject.getString("data"));
        } catch (Throwable th) {
        }
        try {
            bean.message(jsonObject.getString("msg"));
        } catch (Throwable th2) {
        }
        return bean;
    }
}
