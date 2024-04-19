package defpackage;

import android.os.Trace;
/* compiled from: TraceApi18Impl.java */
/* renamed from: af  reason: default package */
/* loaded from: classes.dex */
public final class af {
    public static void a(String label) {
        Trace.beginSection(label);
    }

    public static void b() {
        Trace.endSection();
    }
}
