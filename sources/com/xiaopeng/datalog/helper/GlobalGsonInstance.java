package com.xiaopeng.datalog.helper;

import com.google.gson.Gson;
/* loaded from: classes.dex */
public class GlobalGsonInstance {
    private Gson mGson;

    /* loaded from: classes.dex */
    public static class Holder {
        public static final GlobalGsonInstance INSTANCE = new GlobalGsonInstance();

        private Holder() {
        }
    }

    public static GlobalGsonInstance getInstance() {
        return Holder.INSTANCE;
    }

    private GlobalGsonInstance() {
        this.mGson = new Gson();
    }

    public Gson getGson() {
        return this.mGson;
    }
}
