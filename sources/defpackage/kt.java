package defpackage;
/* compiled from: ObjectHelper.java */
/* renamed from: kt  reason: default package */
/* loaded from: classes.dex */
public final class kt {
    public static final ws<Object, Object> a = new a();

    /* compiled from: ObjectHelper.java */
    /* renamed from: kt$a */
    /* loaded from: classes.dex */
    public static final class a implements ws<Object, Object> {
    }

    public static <T> T d(T object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
        return object;
    }

    public static boolean c(Object o1, Object o2) {
        return o1 == o2 || (o1 != null && o1.equals(o2));
    }

    public static int a(int v1, int v2) {
        if (v1 < v2) {
            return -1;
        }
        return v1 > v2 ? 1 : 0;
    }

    public static int b(long v1, long v2) {
        if (v1 < v2) {
            return -1;
        }
        return v1 > v2 ? 1 : 0;
    }

    public static int e(int value, String paramName) {
        if (value <= 0) {
            throw new IllegalArgumentException(paramName + " > 0 required but it was " + value);
        }
        return value;
    }
}
