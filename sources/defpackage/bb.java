package defpackage;

import android.os.Build;
import android.widget.EdgeEffect;
/* compiled from: EdgeEffectCompat.java */
/* renamed from: bb  reason: default package */
/* loaded from: classes.dex */
public final class bb {
    public static void a(EdgeEffect edgeEffect, float deltaDistance, float displacement) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(deltaDistance, displacement);
        } else {
            edgeEffect.onPull(deltaDistance);
        }
    }
}
