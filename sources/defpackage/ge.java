package defpackage;

import android.media.session.MediaSessionManager;
/* compiled from: MediaSessionManagerImplApi28.java */
/* renamed from: ge  reason: default package */
/* loaded from: classes.dex */
public final class ge implements fe {
    public final MediaSessionManager.RemoteUserInfo a;

    public ge(String packageName, int pid, int uid) {
        this.a = new MediaSessionManager.RemoteUserInfo(packageName, pid, uid);
    }

    public ge(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.a = remoteUserInfo;
    }

    public int hashCode() {
        return f9.b(this.a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ge)) {
            return false;
        }
        ge other = (ge) obj;
        return this.a.equals(other.a);
    }
}
