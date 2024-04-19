package com.xiaopeng.lib.framework.netchannelmodule.messaging.events;

import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
/* loaded from: classes.dex */
public class TracingEvent implements IEvent {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private IMessaging.CHANNEL mChannel;
    private byte[] mMessage;
    private IEvent.TYPE mType = IEvent.TYPE.TRACE;

    public TracingEvent message(String message) {
        if (message == null) {
            throw new AssertionError();
        }
        this.mMessage = message.getBytes();
        return this;
    }

    public TracingEvent message(byte[] message) {
        if (message == null) {
            throw new AssertionError();
        }
        this.mMessage = message;
        return this;
    }

    public TracingEvent channel(IMessaging.CHANNEL channel) {
        this.mChannel = channel;
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent
    public IMessaging.CHANNEL channel() {
        return this.mChannel;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent
    public IEvent.TYPE type() {
        return this.mType;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent
    public int reasonCode() {
        return 0;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent
    public long messageId() {
        return 0L;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent
    public String messageTopic() {
        return null;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent
    public byte[] messageContent() {
        return this.mMessage;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IEvent
    public int protocolReasonCode() {
        return 0;
    }
}
