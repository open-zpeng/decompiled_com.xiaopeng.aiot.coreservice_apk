package com.xiaopeng.carmanager.wrapper;

import android.car.hardware.CarPropertyValue;
import android.car.hardware.ciu.CarCiuManager;
import com.xiaopeng.carmanager.AbsCarManager;
import com.xiaopeng.carmanager.IListener;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class CiuManagerWrapper extends AbsCarManager<CarCiuManager, OnCarEcuEventChangedListener> {
    public static final String TAG = "CiuManagerWrapper";

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public /* bridge */ /* synthetic */ void handleCarEventsListeners(OnCarEcuEventChangedListener onCarEcuEventChangedListener, CarPropertyValue carPropertyValue) {
        handleCarEventsListeners2(onCarEcuEventChangedListener, (CarPropertyValue<?>) carPropertyValue);
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public List<Integer> getPropertyIds() {
        return Arrays.asList(557852683, 557852674, 557852699, 557852684, 557852676, 557852702, 557852687);
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public String getServiceName() {
        return "xp_ciu";
    }

    /* renamed from: handleCarEventsListeners  reason: avoid collision after fix types in other method */
    public void handleCarEventsListeners2(OnCarEcuEventChangedListener listener, CarPropertyValue<?> value) {
        switch (value.getPropertyId()) {
            case 557852674:
                listener.onDeleteResult(((Integer) getValue(value)).intValue());
                return;
            case 557852676:
                int shield = ((Integer) getValue(value)).intValue();
                listener.onShield(shield == 1);
                return;
            case 557852683:
                listener.onRecognizeResult(((Integer) getValue(value)).intValue());
                return;
            case 557852684:
                listener.onRegisterState(((Integer) getValue(value)).intValue());
                return;
            case 557852687:
                listener.onDmsStatusChanged(((Integer) getValue(value)).intValue());
                return;
            case 557852699:
                listener.onFaceSwitchState(((Integer) getValue(value)).intValue());
                return;
            case 557852702:
                listener.onCiuValid(((Integer) getValue(value)).intValue());
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public interface OnCarEcuEventChangedListener extends IListener {
        default void onRecognizeResult(int result) {
        }

        default void onDeleteResult(int result) {
        }

        default void onFaceSwitchState(int state) {
        }

        default void onRegisterState(int state) {
        }

        default void onShield(boolean shield) {
        }

        default void onCiuValid(int valid) {
        }

        default void onDmsStatusChanged(int status) {
        }
    }
}
