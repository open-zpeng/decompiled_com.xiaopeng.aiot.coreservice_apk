package defpackage;

import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: LoaderManager.java */
/* renamed from: wd  reason: default package */
/* loaded from: classes.dex */
public abstract class wd {
    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();

    public static <T extends fd & sd> wd b(T owner) {
        return new xd(owner, owner.i());
    }
}
