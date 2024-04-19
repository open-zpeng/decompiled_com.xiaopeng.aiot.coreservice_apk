package defpackage;

import android.view.MotionEvent;
/* compiled from: MotionEventCompat.java */
/* renamed from: u9  reason: default package */
/* loaded from: classes.dex */
public final class u9 {
    public static boolean a(MotionEvent event, int source) {
        return (event.getSource() & source) == source;
    }
}
