package com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss;

import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.StorageException;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.exception.StorageExceptionImpl;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.statistic.StorageCounter;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.Token;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.TokenRetriever;
/* loaded from: classes.dex */
public class AppendableTask extends BaseOssTask {
    private static int STATUS_OK = 200;
    private static final String TAG = "NetChannel-AppendableTask";
    private byte[] mUploadContent;

    public AppendableTask(Bucket bucket) {
        super(bucket);
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.BaseOssTask
    public void performRealTask() {
        TokenRetriever.getInstance().getTokenWithCallback(new FutureTaskCallback());
    }

    public AppendableTask append(byte[] data) throws StorageException {
        if (data == null || data.length == 0) {
            throw new StorageExceptionImpl(4);
        }
        this.mUploadContent = data;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.BaseOssTask
    public BaseOssTask build() throws StorageException {
        byte[] bArr = this.mUploadContent;
        if (bArr == null || bArr.length == 0) {
            throw new StorageExceptionImpl(4);
        }
        return super.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAppendTask(Token token) {
        final OSS oss = createOssClient(token.accessKeyId(), token.acessKeySecret(), token.securityToken());
        wn.i(new Runnable() { // from class: com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.AppendableTask.1
            @Override // java.lang.Runnable
            public void run() {
                AppendableTask.this.appendToOssObject(oss);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void appendToOssObject(com.alibaba.sdk.android.oss.OSS r25) {
        /*
            Method dump skipped, instructions count: 449
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.AppendableTask.appendToOssObject(com.alibaba.sdk.android.oss.OSS):void");
    }

    private long tryToGetExistingObjectLength(OSS oss) {
        try {
            HeadObjectRequest head = new HeadObjectRequest(bucketRootName(), this.mRemoteObjectKey);
            HeadObjectResult result = oss.headObject(head);
            if (STATUS_OK != result.getStatusCode()) {
                return 0L;
            }
            long size = result.getMetadata().getContentLength();
            return size;
        } catch (Exception e) {
            return 0L;
        }
    }

    /* loaded from: classes.dex */
    public class FutureTaskCallback implements TokenRetriever.IRetrievingCallback {
        private FutureTaskCallback() {
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.TokenRetriever.IRetrievingCallback
        public void onFailure(StorageException exception) {
            AppendableTask.this.doFailure(exception);
            StorageCounter.getInstance().increaseFailureWithCode(String.valueOf((int) StorageException.REASON_GET_TOKEN_ERROR), 0L);
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.TokenRetriever.IRetrievingCallback
        public void onSuccess(Token token) {
            AppendableTask.this.executeAppendTask(token);
        }
    }
}
