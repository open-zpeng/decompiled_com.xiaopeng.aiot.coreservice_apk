package defpackage;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;
/* compiled from: ObjectsCompat.java */
/* renamed from: f9  reason: default package */
/* loaded from: classes.dex */
public class f9 {
    public static boolean a(Object a, Object b) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(a, b);
        }
        return a == b || (a != null && a.equals(b));
    }

    public static int b(Object... values) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.hash(values);
        }
        return Arrays.hashCode(values);
    }
}
