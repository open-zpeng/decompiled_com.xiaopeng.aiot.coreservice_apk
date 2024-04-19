package defpackage;

import java.util.Enumeration;
import java.util.Hashtable;
/* compiled from: MemoryPersistence.java */
/* renamed from: sy  reason: default package */
/* loaded from: classes.dex */
public class sy implements fw {
    public Hashtable a;

    @Override // defpackage.fw
    public void close() throws lw {
        this.a.clear();
    }

    @Override // defpackage.fw
    public Enumeration keys() throws lw {
        return this.a.keys();
    }

    @Override // defpackage.fw
    public kw get(String key) throws lw {
        return (kw) this.a.get(key);
    }

    @Override // defpackage.fw
    public void open(String clientId, String serverURI) throws lw {
        this.a = new Hashtable();
    }

    @Override // defpackage.fw
    public void put(String key, kw persistable) throws lw {
        this.a.put(key, persistable);
    }

    @Override // defpackage.fw
    public void remove(String key) throws lw {
        this.a.remove(key);
    }

    @Override // defpackage.fw
    public void clear() throws lw {
        this.a.clear();
    }

    @Override // defpackage.fw
    public boolean containsKey(String key) throws lw {
        return this.a.containsKey(key);
    }
}
