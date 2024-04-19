package com.xiaopeng.carmanager.wrapper;

import android.car.hardware.CarPropertyValue;
import android.car.hardware.vcu.CarVcuManager;
import android.util.Log;
import com.xiaopeng.carmanager.AbsCarManager;
import com.xiaopeng.carmanager.IListener;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class VcuManagerWrapper extends AbsCarManager<CarVcuManager, OnCarEcuEventChangedListener> {
    public static final String TAG = "xyz-VcuManagerWrapper";

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public /* bridge */ /* synthetic */ void handleCarEventsListeners(OnCarEcuEventChangedListener onCarEcuEventChangedListener, CarPropertyValue carPropertyValue) {
        handleCarEventsListeners2(onCarEcuEventChangedListener, (CarPropertyValue<?>) carPropertyValue);
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public List<Integer> getPropertyIds() {
        List<Integer> list = new ArrayList<>();
        list.add(557847045);
        return list;
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public String getServiceName() {
        return "xp_vcu";
    }

    /* renamed from: handleCarEventsListeners  reason: avoid collision after fix types in other method */
    public void handleCarEventsListeners2(OnCarEcuEventChangedListener listener, CarPropertyValue<?> value) {
        switch (value.getPropertyId()) {
            case 557847045:
                listener.onGearChanged(((Integer) getValue(value)).intValue());
                return;
            default:
                return;
        }
    }

    public boolean isGearParkingLevel() {
        try {
            return 4 == this.mCarManager.getDisplayGearLevel();
        } catch (Exception e) {
            Log.i(TAG, "isGearParkingLevel getGearLevel fatal err=" + e.getMessage());
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface OnCarEcuEventChangedListener extends IListener {
        default void onGearChanged(int gear) {
        }
    }
}
