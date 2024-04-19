package com.xiaopeng.lib.framework.netchannelmodule.messaging.protocol;

import android.util.Pair;
import java.util.Enumeration;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class MemoryPersistenceProxy implements fw {
    private static final int MAX_MESSAGE_NUMBER = 200;
    private static final String TAG = "MemoryPersistenceProxy";
    public String mClientId;
    public Hashtable<String, Pair<kw, Long>> mHashTable = new Hashtable<>();
    public String mServerURI;
    public boolean mTraceEnabled;

    private void log(String message) {
        if (!co.g() || !this.mTraceEnabled) {
            return;
        }
        pn.a(TAG, message);
    }

    public MemoryPersistenceProxy() {
        log("new MemoryPersistenceProxy");
    }

    private void checkOpen() throws lw {
        if (this.mHashTable == null) {
            throw new lw();
        }
    }

    @Override // defpackage.fw
    public void close() throws lw {
        log("close()");
    }

    @Override // defpackage.fw
    public Enumeration keys() throws lw {
        checkOpen();
        Enumeration result = this.mHashTable.keys();
        log("keys():" + result + " hasMoreElements:" + result.hasMoreElements());
        return result;
    }

    @Override // defpackage.fw
    public kw get(String key) throws lw {
        checkOpen();
        kw result = (kw) this.mHashTable.get(key).first;
        log("get key:" + key + " result:" + result);
        return result;
    }

    @Override // defpackage.fw
    public void open(String clientId, String serverURI) throws lw {
        log("open clientId:" + clientId + " serverURI:" + serverURI);
        if (clientId == null || serverURI == null) {
            throw new IllegalArgumentException("clientId or serverURI can't be null");
        }
        if (clientId.equals(this.mClientId) && serverURI.equals(this.mServerURI)) {
            log("same config, return!");
            return;
        }
        Hashtable<String, Pair<kw, Long>> hashtable = this.mHashTable;
        if (hashtable != null) {
            hashtable.clear();
        }
        this.mClientId = clientId;
        this.mServerURI = serverURI;
        this.mHashTable = new Hashtable<>();
    }

    @Override // defpackage.fw
    public void put(String key, kw persistable) throws lw {
        checkOpen();
        log("put key:" + key + " persistable:" + persistable + " size:" + this.mHashTable.size());
        if (this.mHashTable.size() >= 200) {
            this.mHashTable.clear();
            log("exceed max persist count");
        }
        this.mHashTable.put(key, new Pair<>(persistable, Long.valueOf(System.currentTimeMillis())));
    }

    @Override // defpackage.fw
    public void remove(String key) throws lw {
        checkOpen();
        log("remove key:" + key);
        this.mHashTable.remove(key);
    }

    @Override // defpackage.fw
    public void clear() throws lw {
        checkOpen();
        log("clear");
        this.mHashTable.clear();
    }

    @Override // defpackage.fw
    public boolean containsKey(String key) throws lw {
        checkOpen();
        boolean result = this.mHashTable.containsKey(key);
        log("containsKey key:" + key + " result:" + result);
        return result;
    }

    public void setTraceEnabled(boolean enabled) {
        this.mTraceEnabled = enabled;
    }
}
