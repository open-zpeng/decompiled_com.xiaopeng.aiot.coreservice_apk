package defpackage;

import android.text.TextUtils;
/* compiled from: MediaSessionManagerImplBase.java */
/* renamed from: he  reason: default package */
/* loaded from: classes.dex */
public class he implements fe {
    public String a;
    public int b;
    public int c;

    public he(String packageName, int pid, int uid) {
        this.a = packageName;
        this.b = pid;
        this.c = uid;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof he) {
            he otherUserInfo = (he) obj;
            return TextUtils.equals(this.a, otherUserInfo.a) && this.b == otherUserInfo.b && this.c == otherUserInfo.c;
        }
        return false;
    }

    public int hashCode() {
        return f9.b(this.a, Integer.valueOf(this.b), Integer.valueOf(this.c));
    }
}
