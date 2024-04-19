package defpackage;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import org.eclipse.paho.android.service.MqttService;
/* compiled from: AlarmPingSender.java */
/* renamed from: lv  reason: default package */
/* loaded from: classes.dex */
public class lv implements mw {
    public qw a;
    public MqttService b;
    public BroadcastReceiver c;
    public lv d;
    public PendingIntent e;
    public volatile boolean f = false;

    public lv(MqttService service, ov connection) {
        if (service == null) {
            throw new IllegalArgumentException("Neither service nor client can be null.");
        }
        this.b = service;
        this.d = this;
    }

    @Override // defpackage.mw
    public void b(qw comms) {
        this.a = comms;
        this.c = new b();
    }

    @Override // defpackage.mw
    public synchronized void start() {
        if (this.f) {
            return;
        }
        String action = "MqttService.pingSender." + this.a.t().b();
        Log.d("AlarmPingSender", "Register AlarmReceiver to MqttService" + action);
        this.b.registerReceiver(this.c, new IntentFilter(action));
        this.e = PendingIntent.getBroadcast(this.b, 0, new Intent(action), 134217728);
        a(this.a.u());
        this.f = true;
    }

    @Override // defpackage.mw
    public synchronized void stop() {
        if (this.f) {
            Log.d("AlarmPingSender", "Unregister AlarmReceiver to MqttService:" + this.a.t().b());
            if (this.e != null) {
                AlarmManager alarmManager = (AlarmManager) this.b.getSystemService("alarm");
                alarmManager.cancel(this.e);
            }
            this.f = false;
            try {
                this.b.unregisterReceiver(this.c);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    @Override // defpackage.mw
    public synchronized void a(long delayInMilliseconds) {
        long nextAlarmInMilliseconds = System.currentTimeMillis() + delayInMilliseconds;
        AlarmManager alarmManager = (AlarmManager) this.b.getSystemService("alarm");
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, nextAlarmInMilliseconds, this.e);
        } else {
            alarmManager.set(0, nextAlarmInMilliseconds, this.e);
        }
    }

    /* compiled from: AlarmPingSender.java */
    /* renamed from: lv$c */
    /* loaded from: classes.dex */
    public class c extends AsyncTask<qw, Void, Boolean> {
        public boolean a;

        public c() {
            this.a = false;
        }

        /* compiled from: AlarmPingSender.java */
        /* renamed from: lv$c$a */
        /* loaded from: classes.dex */
        public class a implements xv {
            public a() {
            }

            @Override // defpackage.xv
            public void onSuccess(bw asyncActionToken) {
                c.this.a = true;
            }

            @Override // defpackage.xv
            public void onFailure(bw asyncActionToken, Throwable exception) {
                Log.d("AlarmPingSender", "Ping async task : Failed.");
                c.this.a = false;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(qw... comms) {
            bw token = comms[0].m(new a());
            try {
                if (token == null) {
                    Log.d("AlarmPingSender", "Ping async background : Ping command was not sent by the client.");
                } else {
                    token.c(6000L);
                }
            } catch (iw e) {
                Log.d("AlarmPingSender", "Ping async background : Ignore MQTT exception : " + e.getMessage());
            } catch (Exception ex) {
                Log.d("AlarmPingSender", "Ping async background : Ignore unknown exception : " + ex.getMessage());
            }
            if (!this.a) {
                Log.d("AlarmPingSender", "Ping async background task completed at " + System.currentTimeMillis() + " Success is " + this.a);
            }
            return new Boolean(this.a);
        }

        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean success) {
            if (!success.booleanValue()) {
                Log.d("AlarmPingSender", "Ping async task onPostExecute() Success is " + this.a);
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onCancelled(Boolean success) {
            Log.d("AlarmPingSender", "Ping async task onCancelled() Success is " + this.a);
        }
    }

    /* compiled from: AlarmPingSender.java */
    /* renamed from: lv$b */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        public c a = null;
        public PowerManager.WakeLock b;
        public final String c;

        public b() {
            this.c = "MqttService.client." + lv.this.d.a.t().b();
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"Wakelock"})
        public void onReceive(Context context, Intent intent) {
            PowerManager pm = (PowerManager) lv.this.b.getSystemService("power");
            PowerManager.WakeLock newWakeLock = pm.newWakeLock(1, this.c);
            this.b = newWakeLock;
            newWakeLock.acquire();
            c cVar = this.a;
            if (cVar != null && cVar.cancel(true)) {
                Log.d("AlarmPingSender", "Previous ping async task was cancelled at:" + System.currentTimeMillis());
            }
            c cVar2 = new c();
            this.a = cVar2;
            cVar2.execute(lv.this.a);
            if (this.b.isHeld()) {
                this.b.release();
            }
        }
    }
}
