package defpackage;

import java.util.Enumeration;
import java.util.Properties;
/* compiled from: Debug.java */
/* renamed from: wy  reason: default package */
/* loaded from: classes.dex */
public class wy {
    public static final String a;
    public static final qy b;
    public static final String c;

    static {
        String name = qw.class.getName();
        a = name;
        b = ry.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
        c = System.getProperty("line.separator", "\n");
    }

    public static String a(Properties props, String name) {
        StringBuffer propStr = new StringBuffer();
        Enumeration propsE = props.propertyNames();
        String str = c;
        propStr.append(String.valueOf(str) + "============== " + name + " ==============" + str);
        while (propsE.hasMoreElements()) {
            String key = (String) propsE.nextElement();
            propStr.append(String.valueOf(b(key, 28, ' ')) + ":  " + props.get(key) + c);
        }
        propStr.append("==========================================" + c);
        return propStr.toString();
    }

    public static String b(String s, int width, char fillChar) {
        if (s.length() >= width) {
            return s;
        }
        StringBuffer sb = new StringBuffer(width);
        sb.append(s);
        int i = width - s.length();
        while (true) {
            i--;
            if (i >= 0) {
                sb.append(fillChar);
            } else {
                return sb.toString();
            }
        }
    }
}
