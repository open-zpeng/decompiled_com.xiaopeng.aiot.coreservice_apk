package com.xiaopeng.datalog;

import android.car.Car;
import android.content.Context;
import android.util.Log;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
/* loaded from: classes.dex */
public class DataLogUtil {
    private static final boolean DEBUG = true;
    private static final String MODULE = "DashcamApp";
    private static final String TAG = "DataLogUtil";

    public static void registerInit(Context context) {
        Module.register(DataLogModuleEntry.class, new DataLogModuleEntry(context));
        getIDataLog();
    }

    private static IMoleEventBuilder builder(String pageID, String buttonID) {
        return getIDataLog().buildMoleEvent().setModule(MODULE).setPageId(pageID).setButtonId(buttonID);
    }

    public static IDataLog getIDataLog() {
        try {
            return (IDataLog) Module.get(DataLogModuleEntry.class).get(IDataLog.class);
        } catch (Exception e) {
            Log.w(TAG, "getIDataLog fatal:" + e.getMessage());
            return null;
        }
    }

    private static void report(IMoleEvent event) {
        boolean isExport = isExportVersion();
        Log.d(TAG, "isExport:" + isExport + "; report:" + event.toJson());
        if (isExport) {
            Log.d(TAG, "oversea version will not report data");
        } else {
            getIDataLog().sendStatData(event);
        }
    }

    public static boolean isExportVersion() {
        try {
            return Car.isExportVersion();
        } catch (Exception e) {
            return false;
        }
    }

    public static void sendStatData(String pageId, String buttonId) {
        Log.d(TAG, "sendStatData() called with: pageId = [" + pageId + "], buttonId = [" + buttonId + "]");
        IMoleEventBuilder builder = builder(pageId, buttonId);
        report(builder.build());
    }

    public static void sendStatData(String pageId, String buttonId, String prop, int value) {
        Log.d(TAG, "sendStatData() called with: pageId = [" + pageId + "], buttonId = [" + buttonId + "], prop = [" + prop + "], value = [" + value + "]");
        IMoleEventBuilder builder = builder(pageId, buttonId);
        builder.setProperty(prop, Integer.valueOf(value));
        report(builder.build());
    }

    public static void sendStatData(String pageId, String buttonId, String prop, String value) {
        Log.d(TAG, "sendStatData() called with: pageId = [" + pageId + "], buttonId = [" + buttonId + "], prop = [" + prop + "], value = [" + value + "]");
        IMoleEventBuilder builder = builder(pageId, buttonId);
        builder.setProperty(prop, value);
        report(builder.build());
    }
}
