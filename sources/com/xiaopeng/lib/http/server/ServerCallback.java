package com.xiaopeng.lib.http.server;

import com.lzy.okgo.model.Response;
/* loaded from: classes.dex */
public abstract class ServerCallback extends xk<ServerBean> implements yk<ServerBean> {
    public static final int CODE_SUCCESS = 200;
    private ServerConvert convert = new ServerConvert();

    @Override // defpackage.yk
    public abstract /* synthetic */ void onSuccess(Response<T> response);

    @Override // defpackage.al
    public ServerBean convertResponse(okhttp3.Response response) throws Throwable {
        ServerBean bean = this.convert.convertResponse(response);
        response.close();
        return bean;
    }
}
