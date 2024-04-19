package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: PendingPost.java */
/* renamed from: hz  reason: default package */
/* loaded from: classes.dex */
public final class hz {
    public static final List<hz> a = new ArrayList();
    public Object b;
    public oz c;
    public hz d;

    public hz(Object event, oz subscription) {
        this.b = event;
        this.c = subscription;
    }

    public static hz a(oz subscription, Object event) {
        List<hz> list = a;
        synchronized (list) {
            int size = list.size();
            if (size > 0) {
                hz pendingPost = list.remove(size - 1);
                pendingPost.b = event;
                pendingPost.c = subscription;
                pendingPost.d = null;
                return pendingPost;
            }
            return new hz(event, subscription);
        }
    }

    public static void b(hz pendingPost) {
        pendingPost.b = null;
        pendingPost.c = null;
        pendingPost.d = null;
        List<hz> list = a;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(pendingPost);
            }
        }
    }
}
