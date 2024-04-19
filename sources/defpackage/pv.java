package defpackage;

import java.util.Arrays;
import org.eclipse.paho.android.service.MqttAndroidClient;
/* compiled from: MqttDeliveryTokenAndroid.java */
/* renamed from: pv  reason: default package */
/* loaded from: classes.dex */
public class pv extends rv implements zv {
    public jw j;

    public pv(MqttAndroidClient client, Object userContext, xv listener, jw message) {
        super(client, userContext, listener);
        this.j = message;
    }

    @Override // defpackage.zv
    public jw getMessage() throws iw {
        return this.j;
    }

    @Override // defpackage.rv
    public String toString() {
        return "MqttDeliveryTokenAndroid{topics=" + Arrays.toString(b()) + '}';
    }
}
