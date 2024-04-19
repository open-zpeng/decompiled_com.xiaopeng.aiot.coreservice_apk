package com.xiaopeng.lib.framework.netchannelmodule.messaging.profile;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
/* loaded from: classes.dex */
public final class ReportingChannelProfile extends AbstractChannelProfile {
    private static final boolean FUNCTION_PUBLISH = true;
    private static final boolean FUNCTION_SUBSCRIBE = false;
    private static final int MAX_CACHABLE_BUFFER_SIZE = 1000;

    public ReportingChannelProfile() {
        super(true, false);
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public String serverUrl() {
        String url = decode(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_REPORTING_URL));
        if (TextUtils.isEmpty(url)) {
            return "";
        }
        return AbstractChannelProfile.resolveWithDns(AbstractChannelProfile.SSL_PREFIX + url);
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public String clientId() {
        return super.clientId();
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public IMessaging.CHANNEL channel() {
        return IMessaging.CHANNEL.REPORTING;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public int defaultQoSLevel() {
        return IMessaging.QOS.LEVEL_1.value();
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
    public wv buildBufferOptions() {
        wv bufferOptions = new wv();
        bufferOptions.e(true);
        bufferOptions.f(1000);
        bufferOptions.g(true);
        bufferOptions.h(true);
        return bufferOptions;
    }

    private String getMQTTUserName() {
        return decode(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_USER));
    }

    private String getMQTTPassword() {
        return decode(SystemProperties.get(AbstractChannelProfile.SYSTEM_PROPERTY_MQTT_PASS));
    }
}
