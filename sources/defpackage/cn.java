package defpackage;
/* compiled from: NetworkStatus.java */
/* renamed from: cn  reason: default package */
/* loaded from: classes.dex */
public enum cn {
    NONE(-1, "无网络连接"),
    MOBILE(0, "移动网络连接"),
    WIFI(1, "WIFI连接");
    
    public int g;
    public String h;

    cn(int code, String msg) {
        this.g = code;
        this.h = msg;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NetwordStatus{status=" + this.g + ", desc='" + this.h + "'} " + super.toString();
    }
}
