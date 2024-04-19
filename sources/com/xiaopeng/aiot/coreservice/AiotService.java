package com.xiaopeng.aiot.coreservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import com.xiaopeng.base.log.LogUtils;
import com.xiaopeng.libconfig.ipc.IpcConfig;
/* loaded from: classes.dex */
public class AiotService extends Service {
    public static final String a = AiotService.class.getSimpleName();
    public a b = new a();
    public BizAiotPresenter d;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LogUtils.i(a, "onCreate ");
        a();
        if (this.d == null) {
            this.d = new BizAiotPresenter();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            LogUtils.d(a, "onStartCommand ： intent is null");
            return 1;
        }
        String str = a;
        LogUtils.i(str, "onStartCommand flags =" + flags + ",startId = " + startId + ",action=" + intent.getAction());
        return 1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.b;
    }

    /* loaded from: classes.dex */
    public class a extends Binder {
        public a() {
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BizAiotPresenter bizAiotPresenter = this.d;
        if (bizAiotPresenter != null) {
            bizAiotPresenter.l();
            this.d = null;
        }
    }

    public final void a() {
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        Intent nfIntent = new Intent(this, SplashActivity.class);
        builder.setOngoing(true).setContentIntent(PendingIntent.getActivity(this, 0, nfIntent, 0)).setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).setSmallIcon(R.mipmap.ic_launcher).setContentText("is running......").setWhen(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("notification_id");
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            NotificationChannel channel = new NotificationChannel("notification_id", "notification_name", 2);
            notificationManager.createNotificationChannel(channel);
        }
        Notification notification = builder.build();
        notification.defaults = 1;
        startForeground(IpcConfig.SettingsConfig.SOUND_MODE, notification);
    }
}
