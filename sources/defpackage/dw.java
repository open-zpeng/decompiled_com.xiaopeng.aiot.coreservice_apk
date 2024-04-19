package defpackage;
/* compiled from: MqttCallback.java */
/* renamed from: dw  reason: default package */
/* loaded from: classes.dex */
public interface dw {
    void connectionLost(Throwable th);

    void deliveryComplete(zv zvVar);

    void messageArrived(String str, jw jwVar) throws Exception;
}
