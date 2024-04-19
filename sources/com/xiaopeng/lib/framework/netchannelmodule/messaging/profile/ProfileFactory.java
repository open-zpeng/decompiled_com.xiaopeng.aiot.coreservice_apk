package com.xiaopeng.lib.framework.netchannelmodule.messaging.profile;

import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.IMessaging;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.MessagingException;
import com.xiaopeng.lib.framework.netchannelmodule.messaging.exception.MessagingExceptionImpl;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ProfileFactory {
    private static Map<IMessaging.CHANNEL, AbstractChannelProfile> map = new HashMap();

    /* renamed from: com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.ProfileFactory$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$messaging$IMessaging$CHANNEL;

        static {
            int[] iArr = new int[IMessaging.CHANNEL.values().length];
            $SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$messaging$IMessaging$CHANNEL = iArr;
            try {
                iArr[IMessaging.CHANNEL.COMMUNICATION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$messaging$IMessaging$CHANNEL[IMessaging.CHANNEL.REPORTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$messaging$IMessaging$CHANNEL[IMessaging.CHANNEL.TESTING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static AbstractChannelProfile channelProfile(IMessaging.CHANNEL channel) throws MessagingException {
        switch (AnonymousClass1.$SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$messaging$IMessaging$CHANNEL[channel.ordinal()]) {
            case 1:
                AbstractChannelProfile profile = map.get(channel);
                if (profile == null) {
                    AbstractChannelProfile profile2 = new CommunicationChannelProfile();
                    map.put(channel, profile2);
                    return profile2;
                }
                return profile;
            case 2:
                AbstractChannelProfile profile3 = map.get(channel);
                if (profile3 == null) {
                    AbstractChannelProfile profile4 = new ReportingChannelProfile();
                    map.put(channel, profile4);
                    return profile4;
                }
                return profile3;
            case 3:
                AbstractChannelProfile profile5 = map.get(channel);
                if (profile5 == null) {
                    AbstractChannelProfile profile6 = new TestingChannelProfile();
                    map.put(channel, profile6);
                    return profile6;
                }
                return profile5;
            default:
                throw new MessagingExceptionImpl(16);
        }
    }
}
