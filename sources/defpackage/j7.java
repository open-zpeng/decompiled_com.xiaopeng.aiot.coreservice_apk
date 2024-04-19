package defpackage;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;
/* compiled from: RemoteInput.java */
/* renamed from: j7  reason: default package */
/* loaded from: classes.dex */
public final class j7 {
    public boolean c() {
        throw null;
    }

    public Set<String> d() {
        throw null;
    }

    public CharSequence[] e() {
        throw null;
    }

    public int f() {
        throw null;
    }

    public Bundle g() {
        throw null;
    }

    public CharSequence h() {
        throw null;
    }

    public String i() {
        throw null;
    }

    public static RemoteInput[] b(j7[] srcArray) {
        if (srcArray == null) {
            return null;
        }
        RemoteInput[] result = new RemoteInput[srcArray.length];
        for (int i = 0; i < srcArray.length; i++) {
            result[i] = a(srcArray[i]);
        }
        return result;
    }

    public static RemoteInput a(j7 src) {
        RemoteInput.Builder builder = new RemoteInput.Builder(src.i()).setLabel(src.h()).setChoices(src.e()).setAllowFreeFormInput(src.c()).addExtras(src.g());
        if (Build.VERSION.SDK_INT >= 29) {
            builder.setEditChoicesBeforeSending(src.f());
        }
        return builder.build();
    }
}
