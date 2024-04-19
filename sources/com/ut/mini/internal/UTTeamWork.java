package com.ut.mini.internal;

import android.text.TextUtils;
import com.ut.device.UTDevice;
import com.ut.mini.base.UTMIVariables;
import java.util.Map;
/* loaded from: classes.dex */
public class UTTeamWork {
    private static UTTeamWork a = null;

    public static synchronized UTTeamWork getInstance() {
        UTTeamWork uTTeamWork;
        synchronized (UTTeamWork.class) {
            if (a == null) {
                a = new UTTeamWork();
            }
            uTTeamWork = a;
        }
        return uTTeamWork;
    }

    public void initialized() {
    }

    public void turnOnRealTimeDebug(Map<String, String> aMap) {
        mh.u(aMap);
    }

    public void turnOffRealTimeDebug() {
        mh.t();
    }

    public void dispatchLocalHits() {
    }

    public void saveCacheDataToLocal() {
        jj.f().a();
    }

    public void setToAliyunOsPlatform() {
        UTMIVariables.getInstance().setToAliyunOSPlatform();
    }

    public String getUtsid() {
        String str;
        try {
            if (ej.a() == null) {
                str = null;
            } else {
                str = ej.a().getAppkey();
            }
            String utdid = UTDevice.getUtdid(gj.b().f());
            long longValue = Long.valueOf(ej.i).longValue();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(utdid)) {
                return utdid + "_" + str + "_" + longValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeAuto1010Track() {
        kj.a().f();
    }

    public void disableNetworkStatusChecker() {
    }
}
