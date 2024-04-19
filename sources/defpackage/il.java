package defpackage;
/* compiled from: CacheException.java */
/* renamed from: il  reason: default package */
/* loaded from: classes.dex */
public class il extends Exception {
    public static il a(String cacheKey) {
        return new il("the http response code is 304, but the cache with cacheKey = " + cacheKey + " is null or expired!");
    }

    public il(String detailMessage) {
        super(detailMessage);
    }
}
