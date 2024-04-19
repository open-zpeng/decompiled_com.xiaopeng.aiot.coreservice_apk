package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket;

import okio.ByteString;
/* loaded from: classes.dex */
public abstract class WebSocketSubscriber implements fs<IWebSocketInfo> {
    private ls disposable;
    private boolean hasOpened;

    @Override // defpackage.fs
    public final void onNext(IWebSocketInfo webSocketInfo) {
        if (webSocketInfo.isOnOpen()) {
            this.hasOpened = true;
            onOpen();
        } else if (webSocketInfo.isClosed()) {
            this.hasOpened = false;
            onClosed(webSocketInfo.closedReasonCode(), webSocketInfo.closedReason());
        } else if (webSocketInfo.stringMessage() != null) {
            onMessage(webSocketInfo.stringMessage());
        } else if (webSocketInfo.byteStringMessage() != null) {
            onMessage(webSocketInfo.byteStringMessage());
        } else if (webSocketInfo.isOnReconnect()) {
            onReconnect();
        }
    }

    public void onOpen() {
    }

    public void onClosed(int code, String reason) {
    }

    public void onMessage(String text) {
    }

    public void onMessage(ByteString byteString) {
    }

    public void onReconnect() {
    }

    public void onClose() {
    }

    @Override // defpackage.fs
    public final void onSubscribe(ls disposable) {
        this.disposable = disposable;
    }

    public final void dispose() {
        ls lsVar = this.disposable;
        if (lsVar != null) {
            lsVar.a();
        }
    }

    @Override // defpackage.fs
    public final void onComplete() {
        if (this.hasOpened) {
            onClose();
        }
    }

    @Override // defpackage.fs
    public void onError(Throwable e) {
        e.printStackTrace();
    }
}
