package com.xiaopeng.carmanager;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.CarEcuManager;
import android.car.hardware.CarPropertyValue;
import android.util.Log;
import com.xiaopeng.carmanager.IListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public abstract class AbsCarManager<CarManager extends CarEcuManager, CarListener extends IListener> {
    public static final String TAG = "AbsCarManager-";
    public CarManager mCarManager;
    private final CopyOnWriteArrayList<CarListener> mListeners = new CopyOnWriteArrayList<>();
    public final ConcurrentHashMap<Integer, CarPropertyValue<?>> mCarCachePropertyMap = new ConcurrentHashMap<>();
    private final CarEcuManager.CarEcuEventCallback mCarEcuEventCallback = new CarEcuManager.CarEcuEventCallback() { // from class: com.xiaopeng.carmanager.AbsCarManager.1
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            AbsCarManager.this.handleCarEventsUpdate(carPropertyValue);
        }

        public void onErrorEvent(int i, int i1) {
        }
    };

    public abstract List<Integer> getPropertyIds();

    public abstract String getServiceName();

    public abstract void handleCarEventsListeners(CarListener carlistener, CarPropertyValue<?> carPropertyValue);

    public void initCarManager(Car car) {
        try {
            CarManager carmanager = (CarManager) car.getCarManager(getServiceName());
            this.mCarManager = carmanager;
            carmanager.registerPropCallback(getPropertyIds(), this.mCarEcuEventCallback);
        } catch (CarNotConnectedException e) {
        }
    }

    public void registerPropCallback(Collection<Integer> ids, int flag) {
        try {
            this.mCarManager.registerPropCallbackWithFlag(ids, this.mCarEcuEventCallback, flag);
        } catch (CarNotConnectedException e) {
        }
    }

    public void registerPropCallback(int id, int flag) {
        try {
            List<Integer> list = new ArrayList<>();
            list.add(Integer.valueOf(id));
            this.mCarManager.registerPropCallbackWithFlag(list, this.mCarEcuEventCallback, flag);
        } catch (CarNotConnectedException e) {
        }
    }

    public CarManager getCarManager() {
        return this.mCarManager;
    }

    public void releaseCarManager() {
        CarManager carmanager = this.mCarManager;
        if (carmanager != null) {
            try {
                carmanager.unregisterPropCallback(getPropertyIds(), this.mCarEcuEventCallback);
            } catch (CarNotConnectedException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCarEventsUpdate(CarPropertyValue<?> value) {
        Log.i(TAG + getServiceName(), "handleCarEventsUpdate value=" + value);
        this.mCarCachePropertyMap.put(Integer.valueOf(value.getPropertyId()), value);
        Iterator<CarListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            CarListener listener = it.next();
            handleCarEventsListeners(listener, value);
        }
    }

    public <E> E getCarCacheProperty(int propertyId) throws Exception {
        CarPropertyValue<?> property = this.mCarCachePropertyMap.get(Integer.valueOf(propertyId));
        if (property != null) {
            E value = (E) getValue(property);
            Log.i(TAG + getServiceName(), "getCarCacheProperty: propertyId=" + propertyId + "; value=" + value);
            return value;
        }
        throw new Exception("Car propertyId not found; propertyId=" + propertyId);
    }

    public final void registerListener(CarListener listener) {
        if (listener != null && !this.mListeners.contains(listener)) {
            this.mListeners.add(listener);
        }
    }

    public final void unregisterListener(CarListener listener) {
        if (listener != null) {
            this.mListeners.remove(listener);
        }
    }

    public final <E> E getValue(CarPropertyValue<?> value) {
        return (E) value.getValue();
    }
}
