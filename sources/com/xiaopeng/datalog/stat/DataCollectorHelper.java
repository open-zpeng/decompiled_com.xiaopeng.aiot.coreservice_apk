package com.xiaopeng.datalog.stat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.UserHandle;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.datalog.DataLogModuleEntry;
import com.xiaopeng.datalog.StatEvent;
import com.xiaopeng.datalog.bean.LogEvent;
import com.xiaopeng.datalog.helper.DataBackupHelper;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import defpackage.mn;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class DataCollectorHelper {
    public static final String BUCKET_AND_ENDPOINT;
    public static final String BUCKET_NAME;
    private static final int CHECK_CONNECTION_DELAY = 10000;
    private static final boolean DEBUG = false;
    private static final int DUMP_CACHE_DELAY = 60000;
    private static final String LOG_PATH = "/data/Log/log0/";
    private static final int MAX_NUM_PER_ZIP_DATA_LOCAL = 20;
    private static final int MESSAGE_CHECK_CONNECTION = 3;
    private static final int MESSAGE_DUMP_CAN = 1;
    private static final int MESSAGE_DUMP_CDU = 2;
    private static final String SEPARATOR = "#";
    private static final String TAG = "DataCollectorHelper";
    private static volatile DataCollectorHelper mInstance;
    private Context mContext;
    private mn remoteService;
    private final List<String> mCanDataCache = new CopyOnWriteArrayList();
    private final List<Map<String, Object>> mCduDataCache = new CopyOnWriteArrayList();
    private Gson mGson = new Gson();
    private Handler mHandler = new Handler(wn.g(0), new Handler.Callback() { // from class: com.xiaopeng.datalog.stat.DataCollectorHelper.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    pn.r(DataCollectorHelper.TAG, "handleMessage MESSAGE_DUMP_CAN");
                    DataCollectorHelper.this.dumpCan2File();
                    return true;
                case 2:
                    pn.a(DataCollectorHelper.TAG, "handleMessage MESSAGE_DUMP_CDU");
                    DataCollectorHelper.this.dumpCdu2File();
                    return true;
                case 3:
                    pn.a(DataCollectorHelper.TAG, "handleMessage MESSAGE_CHECK_CONNECTION");
                    if (DataCollectorHelper.this.remoteService == null) {
                        DataCollectorHelper.this.bindService();
                        return true;
                    }
                    return true;
                default:
                    return true;
            }
        }
    });
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.xiaopeng.datalog.stat.DataCollectorHelper.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            pn.a(DataCollectorHelper.TAG, "onServiceConnected");
            DataCollectorHelper.this.remoteService = mn.a.W(iBinder);
            IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: com.xiaopeng.datalog.stat.DataCollectorHelper.2.1
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    if (DataCollectorHelper.this.remoteService != null) {
                        DataCollectorHelper.this.remoteService.asBinder().unlinkToDeath(this, 0);
                        DataCollectorHelper.this.remoteService = null;
                        DataCollectorHelper.this.bindService();
                    }
                }
            };
            try {
                if (DataCollectorHelper.this.remoteService != null) {
                    DataCollectorHelper.this.remoteService.asBinder().linkToDeath(deathRecipient, 0);
                }
            } catch (RemoteException mE) {
                pn.t(DataCollectorHelper.TAG, "RemoteException occurs when reLink to Service, exception:", mE);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            pn.a(DataCollectorHelper.TAG, "onServiceDisconnected");
            DataCollectorHelper.this.remoteService = null;
            DataCollectorHelper.this.bindService();
        }
    };

    static {
        String str = co.h() ? "xp-log-local" : "xp-log";
        BUCKET_NAME = str;
        BUCKET_AND_ENDPOINT = "http://" + str + ".oss-cn-hangzhou.aliyuncs.com/";
    }

    private DataCollectorHelper() {
    }

    public static DataCollectorHelper getInstance() {
        if (mInstance == null) {
            synchronized (DataCollectorHelper.class) {
                if (mInstance == null) {
                    mInstance = new DataCollectorHelper();
                }
            }
        }
        return mInstance;
    }

    public void init(Context context) {
        this.mContext = context;
        bindService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindService() {
        Intent intent = new Intent("com.xiaopeng.service.DATA_SERVICE");
        intent.setPackage("com.xiaopeng.data.uploader");
        this.mContext.startServiceAsUser(intent, UserHandle.CURRENT);
        this.mContext.bindServiceAsUser(intent, this.mConnection, 1, UserHandle.CURRENT);
        if (!this.mHandler.hasMessages(3)) {
            this.mHandler.sendEmptyMessageDelayed(3, 10000L);
        }
    }

    public boolean isConnected() {
        return this.remoteService != null;
    }

    public void uploadCdu(String data) {
        boolean success = false;
        mn mnVar = this.remoteService;
        if (mnVar != null) {
            try {
                mnVar.s(data);
                if (this.mCduDataCache.size() > 0) {
                    dumpCdu2File();
                }
                success = true;
            } catch (RemoteException e) {
                pn.t(TAG, "uploadCdu error!", e);
            }
        }
        if (!success) {
            Map<String, Object> dataMap = (Map) this.mGson.fromJson(data, new TypeToken<Map<String, Object>>() { // from class: com.xiaopeng.datalog.stat.DataCollectorHelper.3
            }.getType());
            uploadCduLogInternal(dataMap);
        }
    }

    public void uploadLogOrigin(String eventName, String data) {
        boolean success = false;
        mn mnVar = this.remoteService;
        if (mnVar != null) {
            try {
                mnVar.f(eventName, data);
                if (this.mCduDataCache.size() > 0) {
                    dumpCdu2File();
                }
                success = true;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        if (!success) {
            IDataLog dataLog = (IDataLog) Module.get(DataLogModuleEntry.class).get(IDataLog.class);
            String jsonData = dataLog.buildStat().setEventName(eventName).setProperty("data", data).build().toJson();
            Map<String, Object> dataMap = (Map) this.mGson.fromJson(jsonData, new TypeToken<Map<String, Object>>() { // from class: com.xiaopeng.datalog.stat.DataCollectorHelper.4
            }.getType());
            uploadCduLogInternal(dataMap);
        }
    }

    public void uploadCan(String data) {
        boolean success = false;
        mn mnVar = this.remoteService;
        if (mnVar != null) {
            try {
                mnVar.h(data);
                if (this.mCanDataCache.size() > 0) {
                    dumpCan2File();
                }
                success = true;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        if (!success) {
            this.mCanDataCache.add(data);
            if (this.mCanDataCache.size() >= 20) {
                dumpCan2File();
            } else if (!this.mHandler.hasMessages(1)) {
                this.mHandler.sendEmptyMessageDelayed(1, 60000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dumpCan2File() {
        if (this.mCanDataCache.isEmpty()) {
            pn.a(TAG, "mCanDataCache.isEmpty(), return!");
            return;
        }
        String canDataZipJson = buildCanDataZipJson();
        String message = xn.b(canDataZipJson);
        DataBackupHelper.getInstance().updateFile(DataBackupHelper.CAN_TAG, message, this.mContext);
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dumpCdu2File() {
        if (this.mCduDataCache.isEmpty()) {
            pn.a(TAG, "mCduDataCache.isEmpty(), return!");
        }
        String cduDataZipJson = buildCduDataZipJson();
        String message = xn.b(cduDataZipJson);
        DataBackupHelper.getInstance().updateFile(DataBackupHelper.CDU_TAG, message, this.mContext);
        this.mHandler.removeMessages(2);
    }

    public void uploadLogImmediately(String eventName, String data) {
        boolean success = false;
        mn mnVar = this.remoteService;
        if (mnVar != null) {
            try {
                mnVar.k(eventName, data);
                success = true;
            } catch (RemoteException e) {
                pn.t(TAG, "uploadLogImmediately error!", e);
            }
        }
        if (!success) {
            pn.s(TAG, "uploadLogImmediately fail and ignore!");
        }
    }

    public void uploadCduWithFiles(final StatEvent statEvent, final List<String> filePaths) {
        final String[] uploadInfos = generateUploadInfos();
        wn.i(new Runnable() { // from class: com.xiaopeng.datalog.stat.DataCollectorHelper.5
            @Override // java.lang.Runnable
            public void run() {
                DataCollectorHelper.this.zipAndEncrypt(uploadInfos[1], filePaths);
                statEvent.put("address", uploadInfos[0]);
                String dataJson = statEvent.toJson();
                List<String> filePathList = new ArrayList<>();
                filePathList.add(uploadInfos[1].replace(".zip", "_en.zip"));
                DataCollectorHelper.this.uploadCdu(dataJson);
                DataCollectorHelper.this.uploadFiles(filePathList);
            }
        });
    }

    private String[] generateUploadInfos() {
        long timeStamp = System.currentTimeMillis();
        String objectKeyDir = BUCKET_NAME + "/log/" + co.e() + "/" + nn.c(timeStamp) + "/" + un.g();
        String address = generateRemoteUrl(timeStamp, objectKeyDir);
        String dstFilePath = generateFilePath(timeStamp, objectKeyDir);
        return new String[]{address, dstFilePath};
    }

    private String generateRemoteUrl(long timeStamp, String objectKeyDir) {
        String objectKey = objectKeyDir.substring(objectKeyDir.indexOf("/") + 1) + "/" + timeStamp + "_en.zip";
        return BUCKET_AND_ENDPOINT + objectKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zipAndEncrypt(String dstFilePath, List<String> filePaths) {
        File dstZipFile = null;
        try {
            dstZipFile = xn.d(dstFilePath, filePaths);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File encryptFile = new File(dstFilePath.replace(".zip", "_en.zip"));
        boolean encryptResult = ao.c(dstZipFile, encryptFile, "@!chxpzi#0109$+/");
        deleteLocalFile(dstZipFile, encryptResult);
    }

    private String generateFilePath(long timeStamp, String objectKeyDir) {
        String dstFileDirPath = "/sdcard/Log/upload-zip/" + objectKeyDir;
        File dstFileDir = new File(dstFileDirPath);
        if (!dstFileDir.exists()) {
            dstFileDir.mkdirs();
        }
        return dstFileDirPath + "/" + timeStamp + ".zip";
    }

    private void deleteLocalFile(File dstZipFile, boolean encryptResult) {
        if (encryptResult) {
            try {
                dstZipFile.delete();
                System.gc();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String generateAllFilePathString(List<String> filePaths) {
        StringBuilder allFilePathStr = new StringBuilder();
        int len = filePaths.size();
        for (int i = 0; i < len; i++) {
            if (i < len - 1) {
                allFilePathStr.append(filePaths.get(i));
                allFilePathStr.append(SEPARATOR);
            } else {
                allFilePathStr.append(filePaths.get(i));
            }
        }
        return allFilePathStr.toString();
    }

    public void uploadFiles(List<String> fileList) {
        mn mnVar = this.remoteService;
        if (mnVar != null) {
            try {
                mnVar.P(fileList);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private String buildCanDataZipJson() {
        LogEvent event = LogEvent.create(LogEvent.RefType.CAN);
        try {
            event.setV(Integer.valueOf(un.b()).intValue());
        } catch (Exception e) {
            pn.t(TAG, "parse dbcVersion error!", e);
            event.setV(0);
        }
        JsonObject canData = new JsonObject();
        canData.addProperty("data", this.mGson.toJson(this.mCanDataCache));
        this.mCanDataCache.clear();
        ArrayList<Object> msg = new ArrayList<>();
        msg.add(canData);
        event.setMsg(msg);
        String canDataZipJson = this.mGson.toJson(event);
        msg.clear();
        return canDataZipJson;
    }

    private void uploadCduLogInternal(Map<String, Object> data) {
        this.mCduDataCache.add(data);
        if (this.mCduDataCache.size() >= 20) {
            dumpCdu2File();
        } else if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 60000L);
        }
    }

    private String buildCduDataZipJson() {
        LogEvent event = LogEvent.create(LogEvent.RefType.CDU);
        try {
            event.setV(Integer.valueOf(un.b()).intValue());
        } catch (Exception e) {
            pn.t(TAG, "parse dbcVersion error!", e);
            event.setV(0);
        }
        List msg = new ArrayList(this.mCduDataCache);
        this.mCduDataCache.clear();
        event.setMsg(msg);
        String cduDataZipJson = this.mGson.toJson(event);
        return cduDataZipJson;
    }

    public String uploadRecentSystemLog() {
        String[] uploadInfos = generateUploadInfos();
        final String remoteUrl = uploadInfos[0];
        wn.i(new Runnable() { // from class: com.xiaopeng.datalog.stat.DataCollectorHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (DataCollectorHelper.this.isConnected()) {
                    DataCollectorHelper.this.internalUploadRecentSystemLog(remoteUrl);
                } else {
                    wn.j(new Runnable() { // from class: com.xiaopeng.datalog.stat.DataCollectorHelper.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            DataCollectorHelper.this.internalUploadRecentSystemLog(remoteUrl);
                        }
                    }, 1000L);
                }
            }
        });
        return remoteUrl;
    }

    public void internalUploadRecentSystemLog(String ossUrl) {
        mn mnVar = this.remoteService;
        if (mnVar != null) {
            try {
                mnVar.R(ossUrl);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
