package com.xiaopeng.aiot.coreservice;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.gson.JsonObject;
import com.xiaopeng.apirouter.Route2IpcService;
import com.xiaopeng.base.log.LogUtils;
import com.xiaopeng.libconfig.ipc.IpcConfig;
@SuppressLint({"CustomSplashScreen"})
/* loaded from: classes.dex */
public class SplashActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        findViewById(R.id.btn).setOnClickListener(new a());
    }

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("senderPackageName", IpcConfig.App.APP_AIOT_SERVICE);
            jsonObject.addProperty("msg", "msg00");
            Route2IpcService.sendData(14, jsonObject.toString(), IpcConfig.App.APP_AIOT_SERVICE);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        LogUtils.i("SplashActivity", "on onStart ");
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        LogUtils.i("SplashActivity", "on onResume ");
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        LogUtils.i("SplashActivity", "on onPause ");
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        LogUtils.i("SplashActivity", "on onStop ");
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.i("SplashActivity", "on onNewIntent ");
    }
}
