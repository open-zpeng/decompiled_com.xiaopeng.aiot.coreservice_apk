package com.xiaopeng.carmanager;

import android.app.Application;
import android.car.Car;
import android.car.hardware.CarEcuManager;
import android.os.Handler;
/* loaded from: classes.dex */
public class CarClient {
    public static void connectToCar(Application application, Handler workHandler) {
        CarWrapper.getInstance().connectToCar(application, workHandler);
    }

    public static <T extends AbsCarManager<? extends CarEcuManager, ? extends IListener>> T getComponent(Class<T> cls) {
        T component = (T) CarWrapper.getInstance().getComponent(cls);
        if (component == null) {
            throw new ClassCastException("ClassNotFoundException");
        }
        return component;
    }

    @Deprecated
    public static <T> T getComponent(T cls) {
        if (cls == null) {
            throw new NullPointerException("ClassNotFoundException");
        }
        return cls;
    }

    public static String getVersionInCountryCode() {
        try {
            String code = Car.getVersionInCountryCode();
            return code;
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean isExportVersion() {
        try {
            return Car.isExportVersion();
        } catch (Exception e) {
            return false;
        }
    }

    public static String getSoftwareId() {
        try {
            return un.e();
        } catch (Exception e) {
            return "E28";
        }
    }

    public static String getHardwareCarType() {
        try {
            return Car.getHardwareCarStage();
        } catch (Exception e) {
            return "E28";
        }
    }

    public static String getHardwareCarTypeExt() {
        try {
            return Car.getXpCduType();
        } catch (Exception e) {
            return "E28";
        }
    }

    public static void setOnCarConnectListener(IOnCarConnectedListener listener) {
        CarWrapper.getInstance().setOnCarConnectListener(listener);
    }

    public static boolean isCarConnected() {
        return CarWrapper.getInstance().isCarConnected();
    }
}
