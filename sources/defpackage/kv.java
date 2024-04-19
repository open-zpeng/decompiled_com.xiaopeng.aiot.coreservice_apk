package defpackage;

import java.util.Arrays;
/* compiled from: Intrinsics.java */
/* renamed from: kv  reason: default package */
/* loaded from: classes.dex */
public class kv {
    public static void a(Object value, String paramName) {
        if (value == null) {
            e(paramName);
        }
    }

    public static void e(String paramName) {
        throw ((NullPointerException) c(new NullPointerException(b(paramName))));
    }

    public static String b(String paramName) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StackTraceElement caller = stackTraceElements[4];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + paramName;
    }

    public static <T extends Throwable> T c(T throwable) {
        return (T) d(throwable, kv.class.getName());
    }

    public static <T extends Throwable> T d(T throwable, String classNameToDrop) {
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        int size = stackTrace.length;
        int lastIntrinsic = -1;
        for (int i = 0; i < size; i++) {
            if (classNameToDrop.equals(stackTrace[i].getClassName())) {
                lastIntrinsic = i;
            }
        }
        int i2 = lastIntrinsic + 1;
        StackTraceElement[] newStackTrace = (StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2, size);
        throwable.setStackTrace(newStackTrace);
        return throwable;
    }
}
