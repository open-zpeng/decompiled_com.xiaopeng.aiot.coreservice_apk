package com.xiaopeng.lib.framework.netchannelmodule.messaging.profile;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
/* loaded from: classes.dex */
public final class CommunicationChannelProfile extends AbstractChannelProfile {
    private static final boolean FUNCTION_PUBLISH = true;
    private static final boolean FUNCTION_SUBSCRIBE = true;

    public CommunicationChannelProfile() {
        super(true, true);
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public String logTag() {
        return "PahoBizLogger";
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public String serverUrl() {
        String url = decode(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_URL));
        if (TextUtils.isEmpty(url)) {
            return "";
        }
        return AbstractChannelProfile.resolveWithDns(AbstractChannelProfile.SSL_PREFIX + url);
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public String clientId() {
        String decodedClientId;
        String clientId = SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_ID);
        if (TextUtils.isEmpty(clientId)) {
            decodedClientId = super.clientId();
        } else {
            decodedClientId = decode(clientId);
        }
        return decodedClientId + ":" + co.e();
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public IMessaging.CHANNEL channel() {
        return IMessaging.CHANNEL.COMMUNICATION;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public gw buildConnectOptions() {
        gw options = super.buildConnectOptions();
        options.v(GlobalConfig.getSocketFactory());
        options.w(getMQTTUserName());
        options.u(getMQTTPassword().toCharArray());
        return options;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public boolean enableExtremePing() {
        return true;
    }

    private String getMQTTUserName() {
        String userName = SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_USER);
        if (TextUtils.isEmpty(userName)) {
            return decode(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_USER));
        }
        return decode(userName);
    }

    private String getMQTTPassword() {
        String password = SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_COMM_PASS);
        if (TextUtils.isEmpty(password)) {
            return decode(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_PASS));
        }
        return decode(password);
    }
}
