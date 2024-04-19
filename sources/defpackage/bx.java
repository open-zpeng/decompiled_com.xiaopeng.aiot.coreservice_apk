package defpackage;
/* compiled from: MessageCatalog.java */
/* renamed from: bx  reason: default package */
/* loaded from: classes.dex */
public abstract class bx {
    public static bx a = null;

    public abstract String a(int i);

    public static final String b(int id) {
        if (a == null) {
            if (yw.c("java.util.ResourceBundle")) {
                try {
                    a = (bx) Class.forName("ex").newInstance();
                } catch (Exception e) {
                    return "";
                }
            } else if (yw.c("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog")) {
                try {
                    a = (bx) Class.forName("org.eclipse.paho.client.mqttv3.internal.MIDPCatalog").newInstance();
                } catch (Exception e2) {
                    return "";
                }
            }
        }
        return a.a(id);
    }
}
