package com.xiaopeng.lib.framework.moduleinterface.aiassistantmodule.notification;
/* loaded from: classes.dex */
public interface INotification {
    void close(String str);

    void send(String str);

    void setOnNotificationCallback(INotificationCallback iNotificationCallback);
}
