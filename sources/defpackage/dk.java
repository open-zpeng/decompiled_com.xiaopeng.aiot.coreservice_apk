package defpackage;
/* compiled from: SystemProperties.java */
/* renamed from: dk  reason: default package */
/* loaded from: classes.dex */
public class dk {
    public static final String a = dk.class.getSimpleName();

    public static String a(String key) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls.newInstance(), key);
        } catch (Exception e) {
            return "";
        }
    }

    public static String b(String key, String defaultValue) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), key, defaultValue);
        } catch (Exception e) {
            return "";
        }
    }
}
