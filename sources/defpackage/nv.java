package defpackage;

import java.util.Iterator;
/* compiled from: MessageStore.java */
/* renamed from: nv  reason: default package */
/* loaded from: classes.dex */
public interface nv {

    /* compiled from: MessageStore.java */
    /* renamed from: nv$a */
    /* loaded from: classes.dex */
    public interface a {
        String a();

        String b();

        jw getMessage();
    }

    Iterator<a> a(String str);

    boolean b(String str, String str2);

    String c(String str, String str2, jw jwVar);

    void close();

    void d(String str);
}
