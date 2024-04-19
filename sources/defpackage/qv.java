package defpackage;

import android.os.Binder;
import org.eclipse.paho.android.service.MqttService;
/* compiled from: MqttServiceBinder.java */
/* renamed from: qv  reason: default package */
/* loaded from: classes.dex */
public class qv extends Binder {
    public MqttService a;
    public String b;

    public qv(MqttService mqttService) {
        this.a = mqttService;
    }

    public MqttService a() {
        return this.a;
    }

    public void b(String activityToken) {
        this.b = activityToken;
    }
}
