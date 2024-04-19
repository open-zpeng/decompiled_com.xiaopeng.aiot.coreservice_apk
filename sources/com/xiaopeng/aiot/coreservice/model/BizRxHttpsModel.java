package com.xiaopeng.aiot.coreservice.model;

import com.irdeto.securesdk.core.SSUtils;
import com.xiaopeng.lib.http.server.ServerBean;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class BizRxHttpsModel {
    private static final String TAG = BizRxHttpsModel.class.getSimpleName();

    public static bs<ServerBean> postIotDeviceReport(String vin, String groupId, String groupName, String dataType, String dataContent, Long reportTime) {
        Map<String, Object> params = new HashMap<>(6);
        params.put(SSUtils.O0000Ooo, vin);
        params.put("groupId", groupId);
        params.put("groupName", groupName);
        params.put("dataType", dataType);
        params.put("dataContent", dataContent);
        params.put("reportTime", reportTime);
        return vm.d(em.b, params);
    }

    public static bs<ServerBean> postAppAwakeResultReport(String vin, String taskId, Boolean awakeResult, String failedReason, Long reportTime) {
        Map<String, Object> params = new HashMap<>(5);
        params.put(SSUtils.O0000Ooo, vin);
        params.put("taskId", taskId);
        params.put("awakeResult", awakeResult);
        params.put("failedReason", failedReason);
        params.put("reportTime", reportTime);
        return vm.d(em.c, params);
    }
}
