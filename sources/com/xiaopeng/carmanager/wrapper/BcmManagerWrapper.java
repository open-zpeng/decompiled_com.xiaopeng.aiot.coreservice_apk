package com.xiaopeng.carmanager.wrapper;

import android.car.Car;
import android.car.hardware.CarPropertyValue;
import android.car.hardware.bcm.CarBcmManager;
import android.util.Log;
import com.xiaopeng.carmanager.AbsCarManager;
import com.xiaopeng.carmanager.IListener;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class BcmManagerWrapper extends AbsCarManager<CarBcmManager, OnCarEcuEventChangedListener> {
    public static final String TAG = "McuManagerWrapper";

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public /* bridge */ /* synthetic */ void handleCarEventsListeners(OnCarEcuEventChangedListener onCarEcuEventChangedListener, CarPropertyValue carPropertyValue) {
        handleCarEventsListeners2(onCarEcuEventChangedListener, (CarPropertyValue<?>) carPropertyValue);
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public List<Integer> getPropertyIds() {
        List<Integer> list = new ArrayList<>();
        try {
            if ("Q5".equals(Car.getXpCduType())) {
                list.add(557915161);
            }
        } catch (Exception e) {
            Log.e("McuManagerWrapper", "getPropertyIds: e=" + e.getMessage());
        }
        list.add(560995492);
        return list;
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public String getServiceName() {
        return "xp_bcm";
    }

    /* renamed from: handleCarEventsListeners  reason: avoid collision after fix types in other method */
    public void handleCarEventsListeners2(OnCarEcuEventChangedListener listener, CarPropertyValue<?> value) {
        switch (value.getPropertyId()) {
            case 557849607:
                int onSeat = ((Integer) getValue(value)).intValue();
                listener.onDriverSeatOccupied(onSeat == 1);
                return;
            case 557849609:
                int state = ((Integer) getValue(value)).intValue();
                StringBuilder sb = new StringBuilder();
                sb.append("handleCarEventsListeners: ID_BCM_DOOR_CENTRAL_LOCK_MODE lock=");
                sb.append(state == 1);
                Log.i("McuManagerWrapper", sb.toString());
                return;
            case 557915161:
                listener.onDoorStateChanged((Integer[]) getValue(value));
                return;
            case 560995492:
                listener.onNfcCardIdInfoChanged((byte[]) getValue(value));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public interface OnCarEcuEventChangedListener extends IListener {
        default void onDoorStateChanged(Integer[] doorStates) {
        }

        default void onDriverSeatOccupied(boolean occupied) {
        }

        default void onNfcCardIdInfoChanged(byte[] carId) {
        }
    }
}
