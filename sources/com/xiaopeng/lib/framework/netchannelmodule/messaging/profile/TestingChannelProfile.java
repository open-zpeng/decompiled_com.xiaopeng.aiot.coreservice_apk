package com.xiaopeng.lib.framework.netchannelmodule.messaging.profile;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
import java.util.Set;
/* loaded from: classes.dex */
public final class TestingChannelProfile extends AbstractChannelProfile {
    private static final String DEFAULT_CLIENT_ID = "ExampleAndroidClient";
    private static final String DEFAULT_SERVER_URI = "tcp://10.192.152.118:1883";
    private static final boolean FUNCTION_PUBLISH = true;
    private static final boolean FUNCTION_SUBSCRIBE = true;
    private static final int MAX_CACHABLE_BUFFER_SIZE = 5000;
    private static final int MAX_INFLIGHT = 120;
    private static final String SYSTEM_PROPERTY_MQTT_CLIENT_ID = "persist.sys.mqtt.test.clientid";
    private static final String SYSTEM_PROPERTY_MQTT_TESTING_URL = "persist.sys.mqtt.test.url";
    private tn mPreference;

    public TestingChannelProfile() {
        super(true, true);
        this.mPreference = tn.b(GlobalConfig.getApplicationContext());
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public IMessaging.CHANNEL channel() {
        return IMessaging.CHANNEL.TESTING;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public boolean sendOutAllLogs() {
        return true;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public boolean enableTrace() {
        return true;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public boolean enableExtremePing() {
        return true;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public boolean needToCollectData() {
        return false;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public String serverUrl() {
        String value = SystemProperties.get(SYSTEM_PROPERTY_MQTT_TESTING_URL);
        if (TextUtils.isEmpty(value)) {
            String value2 = this.mPreference.c(SYSTEM_PROPERTY_MQTT_TESTING_URL);
            if (!TextUtils.isEmpty(value2)) {
                return value2;
            }
            return DEFAULT_SERVER_URI;
        }
        return value;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public String clientId() {
        String value = SystemProperties.get(SYSTEM_PROPERTY_MQTT_CLIENT_ID);
        if (TextUtils.isEmpty(value)) {
            String value2 = this.mPreference.c(SYSTEM_PROPERTY_MQTT_CLIENT_ID);
            if (!TextUtils.isEmpty(value2)) {
                return value2 + System.currentTimeMillis();
            }
            return DEFAULT_CLIENT_ID + System.currentTimeMillis();
        }
        return value;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public gw buildConnectOptions() {
        gw options = super.buildConnectOptions();
        options.s(120);
        return options;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public wv buildBufferOptions() {
        wv bufferOptions = new wv();
        bufferOptions.e(true);
        bufferOptions.f(MAX_CACHABLE_BUFFER_SIZE);
        bufferOptions.g(true);
        bufferOptions.h(true);
        return bufferOptions;
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile
    public Set<String> getAcceptedLogList() {
        return null;
    }
}
