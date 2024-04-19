package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import com.lzy.okgo.model.Response;
/* loaded from: classes.dex */
public abstract class ServerCallbackImpl extends xk<ServerBean> implements yk<ServerBean> {
    private ServerConverter convert = new ServerConverter();

    @Override // defpackage.yk
    public abstract /* synthetic */ void onSuccess(Response<T> response);

    @Override // defpackage.al
    public ServerBean convertResponse(okhttp3.Response response) throws Throwable {
        ServerBean bean = this.convert.convertResponse(response);
        response.close();
        return bean;
    }
}
