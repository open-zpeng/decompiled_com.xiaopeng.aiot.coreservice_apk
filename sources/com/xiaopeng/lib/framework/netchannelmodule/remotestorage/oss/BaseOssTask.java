package com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.StorageException;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.aws.BaseAwsTask;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.exception.StorageExceptionImpl;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.statistic.StorageCounter;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.TokenRetriever;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class BaseOssTask implements Runnable {
    private static final int CONNECTION_TIMEOUT = 60000;
    private static final int ERROR_FORBIDDEN = 403;
    private static final int MAX_CONCURRENT_REQUEST = 2;
    private static final int MAX_ERROR_RETRY = 3;
    private static final int SOCKET_TIMEOUT = 60000;
    private static final String TAG = "NetChannel-BaseOssTask";
    private static OSS sOssClient;
    private Application mApplication;
    private Bucket mBucket;
    private Callback mCallback;
    public Map<String, String> mCallbackParams;
    public String mLocalFilePath;
    public long mLocalFileSize;
    private String mModuleName;
    private String mRemoteFolder;
    public String mRemoteObjectKey;
    public String mRemoteUrl;

    public abstract void performRealTask();

    public BaseOssTask(Bucket bucket) {
        this.mBucket = bucket;
    }

    public BaseOssTask application(Application application) {
        this.mApplication = application;
        return this;
    }

    public BaseOssTask module(String name) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(this.mRemoteFolder)) {
            throw new IllegalArgumentException("Remote folder has been assigned.");
        }
        this.mModuleName = name;
        return this;
    }

    public BaseOssTask remoteFolder(String name) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(this.mModuleName)) {
            throw new IllegalArgumentException("Module name has been assigned.");
        }
        this.mRemoteFolder = name;
        return this;
    }

    public BaseOssTask filePath(String filePath) {
        this.mLocalFilePath = filePath;
        return this;
    }

    public BaseOssTask callback(Callback callback) {
        this.mCallback = callback;
        return this;
    }

    public BaseOssTask remoteCallbackParams(Map<String, String> remoteCallbackParams) {
        this.mCallbackParams = remoteCallbackParams;
        return this;
    }

    public BaseOssTask build() throws StorageException {
        if (TextUtils.isEmpty(this.mRemoteFolder) && TextUtils.isEmpty(this.mModuleName)) {
            throw new StorageExceptionImpl(3);
        }
        String str = this.mRemoteFolder;
        if (str == null) {
            this.mRemoteObjectKey = this.mBucket.generateObjectKey(this.mModuleName);
        } else {
            this.mRemoteObjectKey = str;
        }
        this.mRemoteUrl = this.mBucket.getUrl() + this.mRemoteObjectKey;
        return this;
    }

    public void doSuccess() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onSuccess(this.mRemoteUrl, this.mLocalFilePath);
        }
    }

    public void doFailure(StorageException exception) {
        pn.a(TAG, "Failed! Reason is-->" + exception.getMessage());
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onFailure(this.mRemoteUrl, this.mLocalFilePath, exception);
        }
        if (exception.getReasonCode() == 403) {
            TokenRetriever.getInstance().clearToken();
        }
    }

    public String bucketRootName() {
        return this.mBucket.getRootName();
    }

    public long bucketMaxObjectSize() {
        return this.mBucket.getMaxObjectSize();
    }

    public synchronized OSS createOssClient(String accessKeyId, String accessKeySecret, String securityToken) {
        OSSCredentialProvider ossCredentialProvider = new OSSStsTokenCredentialProvider(accessKeyId, accessKeySecret, securityToken);
        OSS oss = sOssClient;
        if (oss == null) {
            ClientConfiguration configuration = new ClientConfiguration();
            configuration.setConnectionTimeout(BaseAwsTask.CONNECTION_TIMEOUT);
            configuration.setSocketTimeout(BaseAwsTask.CONNECTION_TIMEOUT);
            configuration.setMaxConcurrentRequest(2);
            configuration.setMaxErrorRetry(3);
            sOssClient = new OSSClient(this.mApplication, Bucket.END_POINT, ossCredentialProvider, configuration);
        } else {
            oss.updateCredentialProvider(ossCredentialProvider);
        }
        return sOssClient;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mCallback.onStart(this.mRemoteUrl, this.mLocalFilePath);
        performRealTask();
        StorageCounter.getInstance().increaseRequestCount();
    }
}
