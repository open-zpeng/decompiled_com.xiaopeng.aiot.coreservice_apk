package defpackage;
/* compiled from: Exceptions.java */
/* renamed from: qs  reason: default package */
/* loaded from: classes.dex */
public final class qs {
    public static RuntimeException a(Throwable t) {
        throw cv.d(t);
    }

    public static void b(Throwable t) {
        if (t instanceof VirtualMachineError) {
            throw ((VirtualMachineError) t);
        }
        if (t instanceof ThreadDeath) {
            throw ((ThreadDeath) t);
        }
        if (t instanceof LinkageError) {
            throw ((LinkageError) t);
        }
    }
}
