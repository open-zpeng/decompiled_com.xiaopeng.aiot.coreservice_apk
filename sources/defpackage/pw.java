package defpackage;

import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import okhttp3.internal.http2.Settings;
/* compiled from: MqttTopic.java */
/* renamed from: pw  reason: default package */
/* loaded from: classes.dex */
public class pw {
    public static void b(String topicString, boolean wildcardAllowed) throws IllegalArgumentException {
        try {
            int topicLen = topicString.getBytes(XmartV1Constants.UTF8_ENCODING).length;
            if (topicLen < 1 || topicLen > 65535) {
                throw new IllegalArgumentException(String.format("Invalid topic length, should be in range[%d, %d]!", new Integer(1), new Integer((int) Settings.DEFAULT_INITIAL_WINDOW_SIZE)));
            }
            if (wildcardAllowed) {
                if (xy.d(topicString, new String[]{"#", "+"})) {
                    return;
                }
                if (xy.c(topicString, "#") > 1 || (topicString.contains("#") && !topicString.endsWith("/#"))) {
                    throw new IllegalArgumentException("Invalid usage of multi-level wildcard in topic string: " + topicString);
                }
                c(topicString);
            } else if (xy.a(topicString, "#+")) {
                throw new IllegalArgumentException("The topic name MUST NOT contain any wildcard characters (#+)");
            }
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public static void c(String topicString) {
        char singleLevelWildcardChar = "+".charAt(0);
        char topicLevelSeparatorChar = "/".charAt(0);
        char[] chars = topicString.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char prev = i + (-1) >= 0 ? chars[i - 1] : (char) 0;
            char next = i + 1 < length ? chars[i + 1] : (char) 0;
            if (chars[i] == singleLevelWildcardChar && ((prev != topicLevelSeparatorChar && prev != 0) || (next != topicLevelSeparatorChar && next != 0))) {
                throw new IllegalArgumentException(String.format("Invalid usage of single-level wildcard in topic string '%s'!", topicString));
            }
        }
    }

    public static boolean a(String topicFilter, String topicName) throws IllegalArgumentException {
        int curn = 0;
        int curf = 0;
        int curn_end = topicName.length();
        int curf_end = topicFilter.length();
        b(topicFilter, true);
        b(topicName, false);
        if (topicFilter.equals(topicName)) {
            return true;
        }
        while (curf < curf_end && curn < curn_end && ((topicName.charAt(curn) != '/' || topicFilter.charAt(curf) == '/') && (topicFilter.charAt(curf) == '+' || topicFilter.charAt(curf) == '#' || topicFilter.charAt(curf) == topicName.charAt(curn)))) {
            if (topicFilter.charAt(curf) == '+') {
                int nextpos = curn + 1;
                while (nextpos < curn_end && topicName.charAt(nextpos) != '/') {
                    curn++;
                    nextpos = curn + 1;
                }
            } else {
                int nextpos2 = topicFilter.charAt(curf);
                if (nextpos2 == 35) {
                    curn = curn_end - 1;
                }
            }
            curf++;
            curn++;
        }
        if (curn == curn_end && curf == curf_end) {
            return true;
        }
        return false;
    }
}
