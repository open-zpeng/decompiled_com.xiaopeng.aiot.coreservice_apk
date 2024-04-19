package com.xiaopeng.carmanager;

import android.app.Application;
import android.car.Car;
import android.car.hardware.CarEcuManager;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.xiaopeng.carmanager.CarWrapper;
import com.xiaopeng.xvs.account.carmanager.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class CarWrapper {
    private static final String TAG = "xyz-CarWrapper";
    private static volatile CarWrapper sInstance;
    private IOnCarConnectedListener iOnCarConnectedListener;
    private Car mCar;
    private Handler mWorkHandler;
    private int mReconnectTimes = 0;
    private final Map<String, Class<?>> mControllers = new HashMap();
    private final Map<Class<?>, AbsCarManager<? extends CarEcuManager, ? extends IListener>> mComponents = new HashMap();
    private final ServiceConnection mCarConnectionCb = new AnonymousClass1();

    /* renamed from: com.xiaopeng.carmanager.CarWrapper$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(CarWrapper.TAG, "onServiceConnected: ");
            CarWrapper.this.mWorkHandler.post(new Runnable() { // from class: fn
                @Override // java.lang.Runnable
                public final void run() {
                    CarWrapper.AnonymousClass1.this.a();
                }
            });
            if (CarWrapper.this.iOnCarConnectedListener != null) {
                CarWrapper.this.iOnCarConnectedListener.onCarConnected();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onServiceConnected$0 */
        public /* synthetic */ void a() {
            CarWrapper.this.initCarManagers();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Log.i(CarWrapper.TAG, "onServiceDisconnected: ");
            if (CarWrapper.this.iOnCarConnectedListener != null) {
                CarWrapper.this.iOnCarConnectedListener.onCarDisconnect();
            }
        }
    }

    public static CarWrapper getInstance() {
        if (sInstance == null) {
            synchronized (CarWrapper.class) {
                if (sInstance == null) {
                    sInstance = new CarWrapper();
                }
            }
        }
        return sInstance;
    }

    private CarWrapper() {
    }

    private void initWorkHandler(Handler workHandler) {
        if (workHandler == null) {
            HandlerThread thread = new HandlerThread("xvs-car-thread");
            thread.start();
            this.mWorkHandler = new Handler(thread.getLooper());
            return;
        }
        this.mWorkHandler = workHandler;
    }

    public void connectToCar(Application application, Handler workHandler) {
        Log.i(TAG, "connectToCar: ");
        this.mWorkHandler = workHandler;
        this.mCar = Car.createCar(application, this.mCarConnectionCb, workHandler);
        String[] components = application.getResources().getStringArray(R.array.config_car_api_components);
        initComponents(components);
        this.mCar.connect();
    }

    private void reconnectToCar() {
        Log.i(TAG, "reconnectToCar: mReconnectTimes=" + this.mReconnectTimes);
        releaseCarManagers();
        int i = this.mReconnectTimes;
        if (i > 5) {
            return;
        }
        this.mReconnectTimes = i + 1;
        if (this.mCar.isConnected() || this.mCar.isConnecting()) {
            Log.i(TAG, "connectToCar: mCar is null or isConnected or isConnecting");
        } else {
            this.mWorkHandler.postDelayed(new Runnable() { // from class: gn
                @Override // java.lang.Runnable
                public final void run() {
                    CarWrapper.this.a();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reconnectToCar$0 */
    public /* synthetic */ void a() {
        this.mCar.connect();
    }

    public <T> T getComponent(Class<T> component) {
        return (T) this.mComponents.get(component);
    }

    @Deprecated
    private void initComponents() {
        for (String service : this.mControllers.keySet()) {
            Class<?> cls = this.mControllers.get(service);
            if (cls != null) {
                try {
                    AbsCarManager controller = (AbsCarManager) cls.newInstance();
                    this.mComponents.put(cls, controller);
                } catch (IllegalAccessException | InstantiationException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    private void initComponents(String[] components) {
        Log.i(TAG, "initComponents() called with: components = [" + Arrays.toString(components) + "]");
        for (String clsName : components) {
            try {
                Class cls = Class.forName(clsName);
                AbsCarManager controller = (AbsCarManager) cls.newInstance();
                this.mComponents.put(cls, controller);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCarManagers() {
        for (Class service : this.mComponents.keySet()) {
            AbsCarManager controller = this.mComponents.get(service);
            if (controller != null) {
                controller.initCarManager(this.mCar);
            }
        }
    }

    private void releaseCarManagers() {
        for (Class service : this.mComponents.keySet()) {
            AbsCarManager controller = this.mComponents.get(service);
            if (controller != null) {
                controller.releaseCarManager();
            }
        }
    }

    @Deprecated
    private void addComponent(String server, Class classZ) {
        this.mControllers.put(server, classZ);
    }

    public void setOnCarConnectListener(IOnCarConnectedListener listener) {
        this.iOnCarConnectedListener = listener;
    }

    public boolean isCarConnected() {
        Car car = this.mCar;
        return car != null && car.isConnected();
    }
}
