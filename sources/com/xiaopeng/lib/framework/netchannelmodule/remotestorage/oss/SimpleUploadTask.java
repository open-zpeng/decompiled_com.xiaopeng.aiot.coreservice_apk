package com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.xiaopeng.datalog.DataLogModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.StorageException;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.exception.StorageExceptionImpl;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.statistic.StorageCounter;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.Token;
import com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.TokenRetriever;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class SimpleUploadTask extends BaseOssTask {
    private static final int EACH_PARTITION_SIZE = 5242880;
    private static final String TAG = "NetChannel-BaseOssTask-SimpleUploadTask";

    public SimpleUploadTask(Bucket bucket) {
        super(bucket);
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.BaseOssTask
    public void performRealTask() {
        TokenRetriever.getInstance().getTokenWithCallback(new FutureTaskCallback());
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.BaseOssTask
    public SimpleUploadTask build() throws StorageException {
        super.build();
        File file = new File(this.mLocalFilePath);
        if (!file.exists()) {
            throw new StorageExceptionImpl(513);
        }
        this.mLocalFileSize = file.length();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeUploadTask(Token token) throws StorageException {
        final OSS oss = createOssClient(token.accessKeyId(), token.acessKeySecret(), token.securityToken());
        wn.i(new Runnable() { // from class: com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.SimpleUploadTask.1
            @Override // java.lang.Runnable
            public void run() {
                SimpleUploadTask simpleUploadTask = SimpleUploadTask.this;
                if (simpleUploadTask.mLocalFileSize > simpleUploadTask.bucketMaxObjectSize()) {
                    SimpleUploadTask.this.upload2OssByPartition(oss);
                } else {
                    SimpleUploadTask.this.upload2OSSByNormal(oss);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upload2OSSByNormal(OSS oss) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketRootName(), this.mRemoteObjectKey, this.mLocalFilePath);
        Map<String, String> map = this.mCallbackParams;
        if (map != null) {
            putObjectRequest.setCallbackParam(map);
        }
        oss.asyncPutObject(putObjectRequest, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.SimpleUploadTask.2
            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                if (!StorageCounter.isInternationVersion()) {
                    IDataLog dataLogService = (IDataLog) Module.get(DataLogModuleEntry.class).get(IDataLog.class);
                    dataLogService.sendStatData(dataLogService.buildMoleEvent().setEvent(GlobalConfig.EVENT_NAME_SUCCESS).setPageId(GlobalConfig.MOLE_PAGE_ID).setButtonId(GlobalConfig.MOLE_OSS_SUCCEED_BUTTON_ID).setProperty("pack", GlobalConfig.getApplicationSimpleName()).setProperty("method", "normal").setProperty("localPath", SimpleUploadTask.this.mLocalFilePath).setProperty("localSize", Long.valueOf(SimpleUploadTask.this.mLocalFileSize)).setProperty("uploadPath", SimpleUploadTask.this.mRemoteObjectKey).build());
                }
                SimpleUploadTask.this.doSuccess();
                StorageCounter.getInstance().increaseSucceedWithSize(SimpleUploadTask.this.mLocalFileSize);
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onFailure(PutObjectRequest request, ClientException clientException, ServiceException serviceException) {
                String failReason = "clientException:" + clientException + " serviceException:" + serviceException;
                if (!StorageCounter.isInternationVersion()) {
                    IDataLog dataLogService = (IDataLog) Module.get(DataLogModuleEntry.class).get(IDataLog.class);
                    dataLogService.sendStatData(dataLogService.buildMoleEvent().setEvent(GlobalConfig.EVENT_NAME_FAIL).setPageId(GlobalConfig.MOLE_PAGE_ID).setButtonId(GlobalConfig.MOLE_OSS_FAILED_BUTTON_ID).setProperty("pack", GlobalConfig.getApplicationSimpleName()).setProperty("method", "normal").setProperty("localPath", SimpleUploadTask.this.mLocalFilePath).setProperty("localSize", Long.valueOf(SimpleUploadTask.this.mLocalFileSize)).setProperty("uploadPath", SimpleUploadTask.this.mRemoteObjectKey).setProperty("failReason", failReason).build());
                }
                if (clientException != null) {
                    SimpleUploadTask.this.doFailure(new StorageExceptionImpl(StorageException.REASON_UPLOAD_ERROR, failReason));
                    StorageCounter.getInstance().increaseFailureWithCode(String.valueOf((int) StorageException.REASON_UPLOAD_ERROR), 0L);
                } else if (serviceException != null) {
                    int code = serviceException.getStatusCode();
                    SimpleUploadTask.this.doFailure(new StorageExceptionImpl(code, failReason));
                    StorageCounter.getInstance().increaseFailureWithCode(serviceException.getErrorCode(), 0L);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void upload2OssByPartition(com.alibaba.sdk.android.oss.OSS r33) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.SimpleUploadTask.upload2OssByPartition(com.alibaba.sdk.android.oss.OSS):void");
    }

    private void closeFileStream(InputStream input) {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                pn.f(TAG, "Failed to close file: " + e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class FutureTaskCallback implements TokenRetriever.IRetrievingCallback {
        private FutureTaskCallback() {
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.TokenRetriever.IRetrievingCallback
        public void onFailure(StorageException exception) {
            if (!StorageCounter.isInternationVersion()) {
                IDataLog dataLogService = (IDataLog) Module.get(DataLogModuleEntry.class).get(IDataLog.class);
                dataLogService.sendStatData(dataLogService.buildMoleEvent().setEvent(GlobalConfig.EVENT_NAME_FAIL).setPageId(GlobalConfig.MOLE_PAGE_ID).setButtonId(GlobalConfig.MOLE_OSS_FAILED_BUTTON_ID).setProperty("pack", GlobalConfig.getApplicationSimpleName()).setProperty("method", "token").setProperty("localPath", SimpleUploadTask.this.mLocalFilePath).setProperty("localSize", Long.valueOf(SimpleUploadTask.this.mLocalFileSize)).setProperty("uploadPath", SimpleUploadTask.this.mRemoteObjectKey).setProperty("failReason", exception.toString()).build());
            }
            SimpleUploadTask.this.doFailure(exception);
            StorageCounter.getInstance().increaseFailureWithCode(String.valueOf((int) StorageException.REASON_GET_TOKEN_ERROR), 0L);
        }

        @Override // com.xiaopeng.lib.framework.netchannelmodule.remotestorage.token.TokenRetriever.IRetrievingCallback
        public void onSuccess(Token token) {
            try {
                SimpleUploadTask.this.executeUploadTask(token);
            } catch (StorageException exception) {
                if (!StorageCounter.isInternationVersion()) {
                    IDataLog dataLogService = (IDataLog) Module.get(DataLogModuleEntry.class).get(IDataLog.class);
                    dataLogService.sendStatData(dataLogService.buildMoleEvent().setEvent(GlobalConfig.EVENT_NAME_FAIL).setPageId(GlobalConfig.MOLE_PAGE_ID).setButtonId(GlobalConfig.MOLE_OSS_FAILED_BUTTON_ID).setProperty("pack", GlobalConfig.getApplicationSimpleName()).setProperty("method", "token").setProperty("localPath", SimpleUploadTask.this.mLocalFilePath).setProperty("localSize", Long.valueOf(SimpleUploadTask.this.mLocalFileSize)).setProperty("uploadPath", SimpleUploadTask.this.mRemoteObjectKey).setProperty("failReason", exception.toString()).build());
                }
                SimpleUploadTask.this.doFailure(exception);
                StorageCounter.getInstance().increaseFailureWithCode(String.valueOf(exception.getReasonCode()), 0L);
            }
        }
    }
}
