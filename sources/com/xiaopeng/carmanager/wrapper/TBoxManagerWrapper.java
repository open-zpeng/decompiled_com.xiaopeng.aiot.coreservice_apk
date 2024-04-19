package com.xiaopeng.carmanager.wrapper;

import android.car.hardware.CarPropertyValue;
import android.car.hardware.tbox.CarTboxManager;
import com.xiaopeng.carmanager.AbsCarManager;
import com.xiaopeng.carmanager.IListener;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class TBoxManagerWrapper extends AbsCarManager<CarTboxManager, OnCarEcuEventChangedListener> {
    public static final String TAG = "McuManagerWrapper";

    /* loaded from: classes.dex */
    public interface OnCarEcuEventChangedListener extends IListener {
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public /* bridge */ /* synthetic */ void handleCarEventsListeners(OnCarEcuEventChangedListener onCarEcuEventChangedListener, CarPropertyValue carPropertyValue) {
        handleCarEventsListeners2(onCarEcuEventChangedListener, (CarPropertyValue<?>) carPropertyValue);
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public List<Integer> getPropertyIds() {
        List<Integer> list = new ArrayList<>();
        return list;
    }

    @Override // com.xiaopeng.carmanager.AbsCarManager
    public String getServiceName() {
        return "xp_tbox";
    }

    /* renamed from: handleCarEventsListeners  reason: avoid collision after fix types in other method */
    public void handleCarEventsListeners2(OnCarEcuEventChangedListener listener, CarPropertyValue<?> value) {
        value.getPropertyId();
    }
}
