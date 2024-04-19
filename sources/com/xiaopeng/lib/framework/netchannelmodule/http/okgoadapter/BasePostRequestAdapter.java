package com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter;

import com.lzy.okgo.model.HttpHeaders;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IServerCallback;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
import com.xiaopeng.lib.framework.netchannelmodule.common.TrafficStatsEntry;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
/* loaded from: classes.dex */
public class BasePostRequestAdapter<T> implements IRequest {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private ol<T> mInternalRequest;

    public BasePostRequestAdapter(String url) {
        this.mInternalRequest = new ol<>(url);
        if (GlobalConfig.getApplicationContext() != null) {
            headers(GlobalConfig.PACKAGE_IDENTIFIER, GlobalConfig.getApplicationName());
        }
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest uploadJson(String json) {
        this.mInternalRequest.K(json);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest uploadFile(String filePath) throws IOException {
        if (filePath == null) {
            throw new AssertionError();
        }
        File sourceFile = new File(filePath);
        if (!sourceFile.exists()) {
            throw new FileNotFoundException();
        }
        this.mInternalRequest.J(sourceFile);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IResponse execute() throws IOException {
        TrafficStatsEntry.setTraficInfo();
        Response response = this.mInternalRequest.d();
        return new ResponseAdapter(response);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public void execute(Callback callback) {
        throw new RuntimeException("Not supported!!!");
    }

    public void execute(yk callback) {
        this.mInternalRequest.e(callback);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public void execute(IServerCallback callback) {
        throw new RuntimeException("Not supported!!!");
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public String getUrl() {
        return this.mInternalRequest.s();
    }

    public HttpHeaders getHeaders() {
        return this.mInternalRequest.n();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest headers(String key, String value) {
        this.mInternalRequest.u(key, value);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest isMultipart(boolean isMultipart) {
        this.mInternalRequest.H(isMultipart);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest removeHeader(String key) {
        this.mInternalRequest.D(key);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest removeAllHeaders() {
        this.mInternalRequest.B();
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest tag(Object tag) {
        this.mInternalRequest.F(tag);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest params(Map<String, String> params, boolean... isReplace) {
        this.mInternalRequest.A(params, isReplace);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest params(String key, String value) {
        this.mInternalRequest.y(key, value, new boolean[0]);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest params(String key, int value) {
        this.mInternalRequest.x(key, value, new boolean[0]);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest params(String key, float value) {
        this.mInternalRequest.w(key, value, new boolean[0]);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest params(String key, boolean value) {
        this.mInternalRequest.z(key, value, new boolean[0]);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest params(String key, File file) {
        this.mInternalRequest.I(key, file);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest removeParam(String key) {
        this.mInternalRequest.E(key);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest removeAllParams() {
        this.mInternalRequest.C();
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public String header(String key) {
        return this.mInternalRequest.n().get(key);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public Map<String, List<String>> headers() {
        if (this.mInternalRequest.q() == null || this.mInternalRequest.q().headers() == null) {
            return null;
        }
        return this.mInternalRequest.q().headers().toMultimap();
    }
}
