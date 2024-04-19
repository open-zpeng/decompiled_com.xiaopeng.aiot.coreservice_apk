package defpackage;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
/* compiled from: ResourceBundleCatalog.java */
/* renamed from: ex  reason: default package */
/* loaded from: classes.dex */
public class ex extends bx {
    public ResourceBundle b = ResourceBundle.getBundle("org.eclipse.paho.client.mqttv3.internal.nls.messages");

    @Override // defpackage.bx
    public String a(int id) {
        try {
            return this.b.getString(Integer.toString(id));
        } catch (MissingResourceException e) {
            return "MqttException";
        }
    }
}
