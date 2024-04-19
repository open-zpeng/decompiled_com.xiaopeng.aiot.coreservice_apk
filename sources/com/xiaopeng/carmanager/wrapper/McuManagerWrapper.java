package com.xiaopeng.carmanager.wrapper;

import android.car.Car;
import android.car.hardware.CarPropertyValue;
import android.car.hardware.mcu.CarMcuManager;
import android.util.Log;
import com.xiaopeng.carmanager.AbsCarManager;
import com.xiaopeng.carmanager.IListener;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class McuManagerWrapper extends AbsCarManager<CarMcuManager, OnCarEcuEventChangedListener> {
    public static final String TAG = "McuManagerWrapper";

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public /* bridge */ /* synthetic */ void handleCarEventsListeners(OnCarEcuEventChangedListener onCarEcuEventChangedListener, CarPropertyValue carPropertyValue) {
        handleCarEventsListeners2(onCarEcuEventChangedListener, (CarPropertyValue<?>) carPropertyValue);
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public List<Integer> getPropertyIds() {
        List<Integer> list = new ArrayList<>();
        list.add(557847561);
        return list;
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public String getServiceName() {
        return "xp_mcu";
    }

    /* renamed from: handleCarEventsListeners  reason: avoid collision after fix types in other method */
    public void handleCarEventsListeners2(OnCarEcuEventChangedListener listener, CarPropertyValue<?> value) {
        switch (value.getPropertyId()) {
            case 557847561:
                listener.onIgStatusChanged(((Integer) getValue(value)).intValue());
                return;
            case 560993375:
                listener.onBleDataChanged((byte[]) getValue(value));
                return;
            default:
                return;
        }
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public void initCarManager(Car car) {
        Log.d("McuManagerWrapper", "initCarManager: ");
        super.initCarManager(car);
        registerPropCallback(560993375, 1);
    }

    /* loaded from: classes.dex */
    public interface OnCarEcuEventChangedListener extends IListener {
        default void onIgStatusChanged(int state) {
        }

        default void onBleDataChanged(byte[] bytes) {
        }
    }
}
