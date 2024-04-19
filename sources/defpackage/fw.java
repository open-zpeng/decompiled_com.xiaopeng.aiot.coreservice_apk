package defpackage;

import java.util.Enumeration;
/* compiled from: MqttClientPersistence.java */
/* renamed from: fw  reason: default package */
/* loaded from: classes.dex */
public interface fw {
    void clear() throws lw;

    void close() throws lw;

    boolean containsKey(String str) throws lw;

    kw get(String str) throws lw;

    Enumeration keys() throws lw;

    void open(String str, String str2) throws lw;

    void put(String str, kw kwVar) throws lw;

    void remove(String str) throws lw;
}
