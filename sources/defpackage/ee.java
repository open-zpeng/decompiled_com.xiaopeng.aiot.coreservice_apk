package defpackage;

import android.media.session.MediaSessionManager;
import android.os.Build;
/* compiled from: MediaSessionManager.java */
/* renamed from: ee  reason: default package */
/* loaded from: classes.dex */
public final class ee {
    public fe a;

    public ee(String packageName, int pid, int uid) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a = new ge(packageName, pid, uid);
        } else {
            this.a = new he(packageName, pid, uid);
        }
    }

    public ee(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.a = new ge(remoteUserInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ee)) {
            return false;
        }
        return this.a.equals(((ee) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
