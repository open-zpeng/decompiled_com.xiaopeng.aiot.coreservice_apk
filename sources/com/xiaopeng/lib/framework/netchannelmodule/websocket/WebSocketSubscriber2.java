package com.xiaopeng.lib.framework.netchannelmodule.websocket;

import android.annotation.SuppressLint;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.WebSocketSubscriber;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public abstract class WebSocketSubscriber2<T> extends WebSocketSubscriber {
    private static final Gson GSON = new Gson();
    public Type type;

    public abstract void onMessage(T t);

    public WebSocketSubscriber2() {
        analysisType();
    }

    private void analysisType() {
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("No generics found!");
        }
        ParameterizedType type = (ParameterizedType) superclass;
        this.type = type.getActualTypeArguments()[0];
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.WebSocketSubscriber
    @SuppressLint({"CheckResult"})
    public void onMessage(String text) {
        bs.m(text).n(new zs<String, T>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.WebSocketSubscriber2.2
            @Override // defpackage.zs
            public T apply(String s) throws Exception {
                try {
                    return (T) WebSocketSubscriber2.GSON.fromJson(s, WebSocketSubscriber2.this.type);
                } catch (JsonSyntaxException e) {
                    return (T) WebSocketSubscriber2.GSON.fromJson((String) WebSocketSubscriber2.GSON.fromJson(s, (Class<Object>) String.class), WebSocketSubscriber2.this.type);
                }
            }
        }).A(jv.b()).o(is.a()).w((ys<T>) new ys<T>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.WebSocketSubscriber2.1
            @Override // defpackage.ys
            public void accept(T t) throws Exception {
                WebSocketSubscriber2.this.onMessage((WebSocketSubscriber2) t);
            }
        });
    }
}
