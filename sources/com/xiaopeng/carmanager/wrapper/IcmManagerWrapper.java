package com.xiaopeng.carmanager.wrapper;

import android.car.hardware.CarPropertyValue;
import android.car.hardware.icm.CarIcmManager;
import com.xiaopeng.carmanager.AbsCarManager;
import com.xiaopeng.carmanager.IListener;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class IcmManagerWrapper extends AbsCarManager<CarIcmManager, OnCarEcuEventChangedListener> {
    public static final String TAG = "IcmManagerWrapper";

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public /* bridge */ /* synthetic */ void handleCarEventsListeners(OnCarEcuEventChangedListener onCarEcuEventChangedListener, CarPropertyValue carPropertyValue) {
        handleCarEventsListeners2(onCarEcuEventChangedListener, (CarPropertyValue<?>) carPropertyValue);
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public List<Integer> getPropertyIds() {
        List<Integer> list = new ArrayList<>();
        list.add(557848078);
        list.add(554702353);
        return list;
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public String getServiceName() {
        return "xp_icm";
    }

    /* renamed from: handleCarEventsListeners  reason: avoid collision after fix types in other method */
    public void handleCarEventsListeners2(OnCarEcuEventChangedListener listener, CarPropertyValue<?> value) {
        switch (value.getPropertyId()) {
            case 554702353:
                listener.onIcmSyncSignal((String) getValue(value));
                return;
            case 557848078:
                listener.onIcmConnectChanged(((Integer) getValue(value)).intValue());
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public interface OnCarEcuEventChangedListener extends IListener {
        default void onIcmConnectChanged(int status) {
        }

        default void onIcmSyncSignal(String signal) {
        }
    }
}
